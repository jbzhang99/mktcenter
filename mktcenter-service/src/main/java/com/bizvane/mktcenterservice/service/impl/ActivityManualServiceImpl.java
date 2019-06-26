package com.bizvane.mktcenterservice.service.impl;

import com.alibaba.fastjson.JSON;
import com.bizvane.centerstageservice.models.po.SysStorePo;
import com.bizvane.centerstageservice.rpc.StoreServiceRpc;
import com.bizvane.couponfacade.enums.SendTypeEnum;
import com.bizvane.couponfacade.interfaces.CouponQueryServiceFeign;
import com.bizvane.couponfacade.models.po.CouponDefinitionPO;
import com.bizvane.couponfacade.models.vo.CouponDetailResponseVO;
import com.bizvane.couponfacade.models.vo.CouponFindCouponCountResponseVO;
import com.bizvane.couponfacade.models.vo.SendCouponSimpleRequestVO;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.mktcenterfacade.interfaces.ActivityManualService;
import com.bizvane.mktcenterfacade.models.bo.ActivityBO;
import com.bizvane.mktcenterfacade.models.bo.ActivityManualBO;
import com.bizvane.mktcenterfacade.models.bo.AwardBO;
import com.bizvane.mktcenterfacade.models.po.*;
import com.bizvane.mktcenterservice.common.enums.*;
import com.bizvane.mktcenterservice.common.utils.*;
import com.bizvane.mktcenterservice.mappers.*;
import com.bizvane.mktcenterfacade.models.vo.ActivityCouponVO;
import com.bizvane.mktcenterfacade.models.vo.ActivityManualVO;
import com.bizvane.mktcenterfacade.models.vo.ActivityVO;
import com.bizvane.mktcenterfacade.models.vo.PageForm;
import com.bizvane.mktcenterservice.common.award.Award;
import com.bizvane.mktcenterservice.common.config.QRCodeConfig;
import com.bizvane.mktcenterservice.common.constants.ActivityConstants;
import com.bizvane.mktcenterservice.common.constants.ResponseConstants;
import com.bizvane.mktcenterservice.common.constants.SystemConstants;
import com.bizvane.mktcenterservice.common.job.JobUtil;

import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.bizvane.wechatfacade.interfaces.QRCodeServiceFeign;
import com.bizvane.wechatfacade.models.vo.CreateMiniprgmCodeBO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class ActivityManualServiceImpl implements ActivityManualService {
    @Autowired
    private MktActivityManualPOMapper mktActivityManualPOMapper;

    @Autowired
    private JobUtil jobUtil;
    @Autowired
    private MktActivityPOMapper mktActivityPOMapper;

    @Autowired
    private MktCouponPOMapper mktCouponPOMapper;

    @Autowired
    private MktActivityRecordPOMapper mktActivityRecordPOMapper;

    @Autowired
    private CouponQueryServiceFeign couponQueryServiceFeign;

    @Autowired
    private Award award;

    @Autowired
    private QRCodeServiceFeign qrCodeServiceFeign;

    @Autowired
    private MktActivityCountPOMapper mktActivityCountPOMapper;

    @Autowired
    private StoreServiceRpc storeServiceRpc;
    
    @Override
    public ResponseData<ActivityVO> getActivityManualList(ActivityVO vo, PageForm pageForm,SysAccountPO stageUser) {
        ResponseData responseData = new ResponseData();
        log.info("领券活动查询活动列表入参:ActivityVO:"+JSON.toJSONString(vo));
        PageHelper.startPage(pageForm.getPageNumber(), pageForm.getPageSize());
        List<ActivityVO> activityManualList = new ArrayList<>();
        vo.setSysBrandId(stageUser.getBrandId());
        try {
            log.info("查询领券活动列表开始");
            activityManualList = mktActivityManualPOMapper.getActivityManualList(vo);
            log.info("领券活动查询活动列表出参:"+JSON.toJSONString(activityManualList));
        } catch (Exception e) {
            log.error("领券活动查询活动列表出错." + e.getMessage());
            responseData.setCode(SystemConstants.ERROR_CODE);
            responseData.setMessage(e.getMessage());
        }
        PageInfo<ActivityVO> pageInfo = new PageInfo<>(activityManualList);
        responseData.setData(pageInfo);
        return responseData;
    }

    /**
     * 创建活动
     *
     * @param
     * @param
     * @param stageUser
     * @return
     */
    @Override
    @Transactional
    public ResponseData<Integer> addActivityManual(ActivityBO bo, SysAccountPO stageUser) {
        ActivityVO activityVO = bo.getActivityVO();
        //1.入参校验
        ResponseData responseData = ActivityParamCheckUtil.checkManualActivityParams(bo.getCouponCodeList().get(0).getCouponDefinitionId(),activityVO);
        if(responseData.getCode()==ResponseConstants.ERROR){
            return responseData;
        }
        //判断活动开始时间是否大于当前时间
        if(new Date().after(activityVO.getStartTime())){
            responseData.setCode(SysResponseEnum.MODEL_FAILED_VALIDATION.getCode());
            responseData.setMessage("活动开始时间不能比当前时间小!");
            return responseData;
        }
        activityVO.setCreateUserName(stageUser.getName());
        activityVO.setCreateUserId(stageUser.getSysAccountId());
        activityVO.setCreateDate(new Date());
     try {
        //活动编号
        String activityCode = CodeUtil.getActivityCode();
        log.info("领券活动-创建活动-活动编号:"+activityCode);
        activityVO.setActivityCode(activityCode);
        //活动类型
        MktActivityPOWithBLOBs mktActivityPOWithBLOBs = new MktActivityPOWithBLOBs();
        BeanUtils.copyProperties(activityVO, mktActivityPOWithBLOBs);
         mktActivityPOWithBLOBs.setSysBrandId(stageUser.getBrandId());
         mktActivityPOWithBLOBs.setSysCompanyId(stageUser.getSysCompanyId());

         //审核状态为已审核
         mktActivityPOWithBLOBs.setCheckStatus(CheckStatusEnum.CHECK_STATUS_APPROVED.getCode());
         //getStartTime 开始时间>当前时间增加job，待执行
         if (new Date().before(activityVO.getStartTime())) {
             //活动状态设置为待执行
             mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_PENDING.getCode());
             //创建任务调度任务开始时间
             jobUtil.addJob(stageUser, activityVO, activityCode);
             //创建任务调度任务结束时间
             jobUtil.addJobEndTime(stageUser, activityVO, activityCode);
         } else {
             //活动状态设置为执行中
             mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode());
         }
        //新增活动主表
         log.info("领券活动-创建活动-新增活动主表入参:"+JSON.toJSONString(mktActivityPOWithBLOBs));
         mktActivityPOWithBLOBs.setIsStoreLimit(activityVO.getStoreLimit());
         mktActivityPOMapper.insertSelective(mktActivityPOWithBLOBs);
        //返回主表的id
        Long mktActivityId = mktActivityPOWithBLOBs.getMktActivityId();
        
        // 新增活动统计表
        MktActivityCountPO mktActivityCountPO = new MktActivityCountPO();
        mktActivityCountPO.setMktActivityId(mktActivityId);
        mktActivityCountPO.setSysCompanyId(mktActivityPOWithBLOBs.getSysCompanyId());
        mktActivityCountPO.setSysBrandId(mktActivityPOWithBLOBs.getSysBrandId());
        mktActivityCountPO.setCreateDate(new Date());
        mktActivityCountPO.setCreateUserId(stageUser.getSysAccountId());
        mktActivityCountPO.setCreateUserName(stageUser.getName());
        mktActivityCountPOMapper.insertSelective(mktActivityCountPO);
        
        log.info("领券活动-创建活动-新增活动-活动主表id"+mktActivityId);

        //新增明细表
        MktActivityManualPO mktActivityManualPO = new MktActivityManualPO();
        BeanUtils.copyProperties(activityVO, mktActivityManualPO);
        mktActivityManualPO.setMktActivityId(mktActivityId);
        mktActivityManualPO.setIsStoreLimit(activityVO.getStoreLimit());

       log.info("领券活动-创建活动-新增领券规则表，入参:"+JSON.toJSONString(mktActivityManualPO));
        mktActivityManualPOMapper.insertSelective(mktActivityManualPO);
        //新增券表,和活动绑定
        MktCouponPO mktCouponPO = new MktCouponPO();
         mktCouponPO.setSysCompanyId(stageUser.getSysCompanyId());
        mktCouponPO.setCouponDefinitionId(bo.getCouponCodeList().get(0).getCouponDefinitionId());
        mktCouponPO.setBizId(mktActivityId);//活动id
        mktCouponPO.setBizType(BusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode());
        mktCouponPO.setModifiedUserId(stageUser.getSysAccountId());
        mktCouponPO.setModifiedUserName(stageUser.getName());
        mktCouponPO.setModifiedDate(new Date());
        mktCouponPO.setCouponName(activityVO.getCouponName());
        log.info("领券活动-创建活动-新增券表-入参:"+JSON.toJSONString(mktCouponPO));
        mktCouponPOMapper.insertSelective(mktCouponPO);
            responseData.setCode(SystemConstants.SUCCESS_CODE);
            responseData.setMessage(SystemConstants.SUCCESS_MESSAGE);
        log.info("领券活动-创建活动-成功");
     }catch (Exception e){
         log.error("领券活动-创建活动-出错"+e.getMessage());
         responseData.setCode(SystemConstants.ERROR_CODE);
         responseData.setMessage(ActivityConstants.ERROR_SQL);
      }
        return responseData;
    }



    /**
     * 领券
     * @param vo
     * @return
     */
    @Override
    public ResponseData<ActivityManualVO> executeActivity(ActivityManualVO vo) {
        log.info("领券活动-执行活动，入参:memberInfoModel-"+ JSON.toJSONString(vo));
        ResponseData responseData = new ResponseData();
        if(vo==null || vo.getMktActivityId()==null){
            log.warn("参数为空");
            responseData.setCode(SystemConstants.ERROR_CODE);
            responseData.setMessage(SystemConstants.ERROR_MSG_PARAM_EMPTY);
            return  responseData;
        }
        MemberInfoModel memberInfoModel = vo.getMemberInfoModel();

        if(null==memberInfoModel||null==memberInfoModel.getBrandId()||StringUtils.isEmpty(memberInfoModel.getMemberCode())){
            log.warn("参数/品牌id/会员信息为空");
            responseData.setCode(SystemConstants.ERROR_CODE);
            responseData.setMessage(SystemConstants.ERROR_MSG_PARAM_EMPTY);
            return  responseData;
        }
        if(StringUtils.isEmpty(vo.getCouponDefinitionId())){
            log.warn("领券活动-执行活动-券号为空");
            responseData.setCode(SystemConstants.ERROR_CODE);
            responseData.setMessage(SystemConstants.ERROR_MSG_PARAM_EMPTY);
            return  responseData;
        }
        //判断活动是否被禁用
        ActivityVO activity = new ActivityVO();
        activity.setMktActivityId(vo.getMktActivityId());
        activity.setValid(Boolean.TRUE);
        List<ActivityVO> manualList = mktActivityManualPOMapper.getActivityManualList(activity);
        if (CollectionUtils.isEmpty(manualList) || manualList.get(0).getActivityStatus()!=ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode()){
            responseData.setCode(SystemConstants.ERROR_CODE);
            responseData.setMessage("该活动已结束");
            return responseData;
        }

        MktActivityRecordPO mktActivityRecordPO = new MktActivityRecordPO();
        mktActivityRecordPO.setMemberCode(memberInfoModel.getMemberCode());
        try {
            //查规则
            MktActivityManualPOExample mktActivityManualPOExample = new MktActivityManualPOExample();
            mktActivityManualPOExample.createCriteria().andValidEqualTo(Boolean.TRUE).andMktActivityIdEqualTo(vo.getMktActivityId());
            List<MktActivityManualPO> mktActivityManualPOS = mktActivityManualPOMapper.selectByExampleWithBLOBs(mktActivityManualPOExample);
            if(CollectionUtils.isEmpty(mktActivityManualPOS)){
                log.warn("领券活动-执行活动-查询领券规则信息为空");
                responseData.setCode(SystemConstants.ERROR_CODE);
                responseData.setMessage(ActivityConstants.RETURN_EMPTY);
                return responseData;
            }
            MktActivityManualPO mktActivityManualPO = mktActivityManualPOS.get(0);
            mktActivityRecordPO.setAcitivityId(mktActivityManualPO.getMktActivityManualId());
            mktActivityRecordPO.setMemberCode(memberInfoModel.getMemberCode());
            //查记录
            log.info("领券活动-执行活动-查询已领记录入参:"+JSON.toJSONString(mktActivityRecordPO));

            MktActivityRecordPOExample mktActivityRecordPOExample = new MktActivityRecordPOExample();
            MktActivityRecordPOExample.Criteria criteria = mktActivityRecordPOExample.createCriteria();
            criteria.andValidEqualTo(Boolean.TRUE).andAcitivityIdEqualTo(vo.getMktActivityId()).andMemberCodeEqualTo(memberInfoModel.getMemberCode());
            //获取所有记录数
            long countAll = mktActivityRecordPOMapper.countByExample(mktActivityRecordPOExample);
            log.info("记录中查到的已领取数量:"+countAll);
            //获取今天记录
            criteria.andParticipateDateGreaterThanOrEqualTo(DateUtil.getZeroTime()).andParticipateDateLessThanOrEqualTo(new Date());
            long countToday = mktActivityRecordPOMapper.countByExample(mktActivityRecordPOExample);

            log.info("couponQueryServiceFeign.findCouponByCouponCode：入参:"+vo.getCouponCode());
            //ResponseData<CouponDefinitionPO> couponDefinitionPOResponseData = couponDefinitionServiceFeign.findByIdRpc(vo.getCouponDefinitionId());
            ResponseData<CouponDetailResponseVO>  couponDefinitionPOResponseData = couponQueryServiceFeign.getCouponDefinition(vo.getCouponDefinitionId());
            log.info("couponQueryServiceFeign.findCouponByCouponCode：出参:"+JSON.toJSONString(couponDefinitionPOResponseData));

            if(!ResponseConstants.SUCCESS.equals(couponDefinitionPOResponseData.getCode())){
                log.warn("couponQueryServiceFeign.findCouponByCouponCode--->出错:"+couponDefinitionPOResponseData.getMessage());
                responseData.setCode(SystemConstants.ERROR_CODE);
                responseData.setMessage(couponDefinitionPOResponseData.getMessage());
                return responseData;
            }else  if (null==couponDefinitionPOResponseData.getData()){
                log.warn("couponQueryServiceFeign.findCouponByCouponCode--->查询为空:"+JSON.toJSONString(couponDefinitionPOResponseData.getData()));
                responseData.setCode(SystemConstants.ERROR_CODE);
                responseData.setMessage(couponDefinitionPOResponseData.getMessage());
                return responseData;
            }
            //总领取数量已达上限
            if (countAll >= mktActivityManualPO.getPerPersonMax()) {
                log.warn("领取超过最大限制,已领取:"+countAll+"，最大限制为:"+mktActivityManualPO.getPerPersonMax());
                responseData.setCode(SystemConstants.ERROR_CODE);
                responseData.setMessage(ActivityConstants.CAN_NOT_RECEIVE);
                return responseData;
            }
            //今日领取已达上限
            if (countToday >= mktActivityManualPO.getPerPersonPerDayMax()) {
                log.warn("领取超过当日最大限制,今日已领取数:"+countToday+",当日最大限制为:"+mktActivityManualPO.getPerPersonPerDayMax());
                responseData.setCode(SystemConstants.ERROR_CODE);
                responseData.setMessage(ActivityConstants.CAN_NOT_RECEIVE);
                return responseData;
            }

            //发券
            AwardBO awardBO = new AwardBO();
            SendCouponSimpleRequestVO sendCouponSimpleRequestVO = new SendCouponSimpleRequestVO();
            sendCouponSimpleRequestVO.setCouponDefinitionId(vo.getCouponDefinitionId());
            sendCouponSimpleRequestVO.setMemberCode(vo.getMemberInfoModel().getMemberCode());
            sendCouponSimpleRequestVO.setSendBussienId(vo.getMktActivityId());
            sendCouponSimpleRequestVO.setSendType(SendTypeEnum.SEND_COUPON_RECEIVE_ACTIVITY.getCode());
            sendCouponSimpleRequestVO.setBrandId(memberInfoModel.getBrandId());
            sendCouponSimpleRequestVO.setCompanyId(memberInfoModel.getSysCompanyId());
            sendCouponSimpleRequestVO.setBusinessName(manualList.get(0).getActivityName());
            awardBO.setSendCouponSimpleRequestVO(sendCouponSimpleRequestVO);
            awardBO.setMktType(MktSmartTypeEnum.SMART_TYPE_COUPON.getCode());
            log.info("领券活动执行活动-发券调接口入参:"+JSON.toJSONString(awardBO));
            award.execute(awardBO);

            //新增记录表
            mktActivityRecordPO.setMemberCode(memberInfoModel.getMemberCode());
            mktActivityRecordPO.setAcitivityId(vo.getMktActivityId());
            mktActivityRecordPO.setActivityType(vo.getActivityType());
            mktActivityRecordPO.setParticipateDate(new Date());
            mktActivityRecordPO.setCreateUserId(memberInfoModel.getCreateUserId());
            mktActivityManualPO.setCreateDate(new Date());
            mktActivityManualPO.setCreateUserName(memberInfoModel.getCreateUserName());
            mktActivityRecordPO.setModifiedUserId(memberInfoModel.getModifiedUserId());
            mktActivityRecordPO.setModifiedDate(new Date());
            mktActivityRecordPO.setModifiedUserName(memberInfoModel.getModifiedUserName());
            log.info("领券活动-执行活动-新增记录表，入参:"+JSON.toJSONString(mktActivityRecordPO));
            mktActivityRecordPOMapper.insertSelective(mktActivityRecordPO);
            
            mktActivityCountPOMapper.updateSum(vo.getMktActivityId(), 1, BigDecimal.ZERO, 0);

            //计算券还剩余领取几次
            Long countAllSum = mktActivityManualPO.getPerPersonMax()-countAll-1;
            Long countTodaySum = mktActivityManualPO.getPerPersonPerDayMax()-countToday-1;
            ActivityManualVO activityManualVO = new ActivityManualVO();
            activityManualVO.setCountAllSum(countAllSum);
            activityManualVO.setCountTodaySum(countTodaySum);
            responseData.setData(activityManualVO);
            responseData.setCode(SystemConstants.SUCCESS_CODE);
            responseData.setMessage(SystemConstants.SUCCESS_MESSAGE);
        }catch (Exception e){
            log.error("领券活动-执行活动-出错:"+e.getMessage());
            responseData.setCode(SystemConstants.ERROR_CODE);
            responseData.setMessage("领券活动-执行活动失败");
            return responseData;
        }
        return responseData;
    }


    @Override
    public ResponseData<List<ActivityBO>> getActivityManualEffect(ActivityVO vo) {
        log.info("领券活动-活动效果分析-入参:"+JSON.toJSONString(vo));
        ResponseData responseData = new ResponseData<>();
        try {
            List<ActivityVO> activityVOList = mktActivityManualPOMapper.getActivityManualList(vo);
            Long sumCouponReceive =0L;
            Long sumCouponUse=0L;
            BigDecimal sumCouponMoney=BigDecimal.ZERO;
            for(ActivityVO vo1:activityVOList){
                Long sendBusinessId = vo1.getMktActivityId();
                Date createDtStart =vo.getCreateDateStart();
                Date createDtEnd=vo.getCreateDateEnd();
                ResponseData<CouponFindCouponCountResponseVO> couponResponseData=couponQueryServiceFeign.findCouponCountBySendBusinessId(sendBusinessId, CouponSendTypeEnum.getCouponSendTypeEnumByMktModuleCode(vo.getActivityType()).getCouponModuleCode(),vo.getSysBrandId()) ;//一个活动只有一张券
                vo1.setCouponFindCouponCountResponseVO(couponResponseData.getData());
                sumCouponReceive=sumCouponReceive+couponResponseData.getData().getCouponSum();//券总数量
                sumCouponUse=sumCouponUse+couponResponseData.getData().getCouponUsedSum();//券已使用总数量
                if(couponResponseData.getData().getMoney()!=null){
                    sumCouponMoney=sumCouponMoney.add(couponResponseData.getData().getMoney());//券收益
                }
                //计算核销率
                if(couponResponseData.getData().getCouponSum()==0){
                    vo1.setUseCouponRate(SystemConstants.PRECISION_PERCENTAGE);
                }else{
                    DecimalFormat df = new DecimalFormat(SystemConstants.PRECISION_PERCENTAGE);
                    vo1.setUseCouponRate(df.format(couponResponseData.getData().getCouponUsedSum()/couponResponseData.getData().getCouponSum()));
                }
            }
            ActivityManualBO activityManualBO = new ActivityManualBO();
            activityManualBO.setActivityVOList(activityVOList);
            activityManualBO.setSumCouponMoney(sumCouponMoney);
            activityManualBO.setSumCouponReceive(sumCouponReceive);
            activityManualBO.setSumCouponUse(sumCouponUse);
            responseData.setData(activityManualBO);
        }catch (Exception e){
            log.info("领券活动-查询活动效果分析-出错"+e.getMessage());
            responseData.setMessage(ActivityConstants.ERROR_SQL);
            responseData.setCode(SystemConstants.ERROR_CODE);
            return  responseData;
        }
        responseData.setMessage(SystemConstants.SUCCESS_MESSAGE);
        responseData.setCode(SystemConstants.SUCCESS_CODE);
        return responseData;
    }


    @Override
    public ResponseData<ActivityBO> selectActivityManualByBusinessCode(String businessCode) {
        ResponseData responseData = new ResponseData();
        ActivityBO bo = new ActivityBO();
        if(StringUtils.isEmpty(businessCode)){
            log.error("领券活动-查询活动详情-入参为空");
            responseData.setCode(SystemConstants.ERROR_CODE);
            responseData.setMessage(ActivityConstants.ERROR_MSG_ACTIVITY_CODE_EMPTY);
            return  responseData;
        }
        try {
            ActivityVO vo = new ActivityVO();
            vo.setActivityCode(businessCode);
            log.info("领券活动-查询活动详情-getActivityList入参:"+ JSON.toJSONString(vo));
            List<ActivityVO> activityManualList = mktActivityManualPOMapper.getActivityList(vo);
            if(CollectionUtils.isEmpty(activityManualList)){
                log.error("领券活动-查询活动详情-未查到相关数据");
                responseData.setCode(SystemConstants.ERROR_CODE);
                responseData.setMessage(ResponseConstants.DATA_NOT_EXIST);
                return  responseData;
            }
            log.info("领券活动-查询活动详情-出参:"+ JSON.toJSONString(activityManualList));
            //查询活动券
            MktCouponPOExample example = new  MktCouponPOExample();
            example.createCriteria().andBizIdEqualTo(activityManualList.get(0).getMktActivityId()).andValidEqualTo(true).andBizTypeEqualTo(1);
            log.info("领券活动-查询券-入参:"+JSON.toJSONString(example));
            List<MktCouponPO> mktCouponPOs= mktCouponPOMapper.selectByExample(example);
            log.info("领券活动-查询券-出参:"+JSON.toJSONString(mktCouponPOs));
            //查询券接口
            List<CouponDetailResponseVO> lists = new ArrayList<>();
            if(!CollectionUtils.isEmpty(mktCouponPOs)){
                for (MktCouponPO po:mktCouponPOs) {
                    ResponseData<CouponDetailResponseVO>  entityAndDefinition = couponQueryServiceFeign.getCouponDefinition(po.getCouponDefinitionId());
                    log.info("领券活动-调券接口-出参:"+JSON.toJSONString(entityAndDefinition));
                    lists.add(entityAndDefinition.getData());
                }
            }
            bo.setActivityVO(activityManualList.get(0));
            if(!CollectionUtils.isEmpty(activityManualList)){
                if (!StringUtils.isEmpty(activityManualList.get(0).getStoreLimitList())){
                    String ids =activityManualList.get(0).getStoreLimitList();
                    //查询适用门店
                    List<Long> listIds = Arrays.asList(ids.split(",")).stream().map(s -> Long.parseLong(s.trim())).collect(Collectors.toList());
                    ResponseData<List<SysStorePo>> sysStorePOs = storeServiceRpc.getIdStoreLists(listIds);
                    List<SysStorePo> data = sysStorePOs.getData();
                    bo.getActivityVO().setSysStorePos(data);
                }
            }
            bo.setCouponEntityAndDefinitionVOList(lists);
            responseData.setData(bo);
        }catch (Exception e){
            log.error("领券活动-查询活动详情出错"+e.getMessage());
            responseData.setCode(SystemConstants.ERROR_CODE);
            responseData.setMessage(ActivityConstants.ERROR_SQL);
            return  responseData;
        }
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        return responseData;
    }


    @Override
    public ResponseData<List<ActivityCouponVO>> getActivityByMemberInfo(MemberInfoModel memberInfoModel,Integer activityType) {
        ResponseData<List<ActivityCouponVO>> responseData = new ResponseData<>();
        log.info("领券中心查询入参:"+JSON.toJSONString(memberInfoModel));

        List<ActivityCouponVO> activityVOList = new ArrayList<>();
        //1.查询企业下的所有活动及活动规则及券名称和券code
        ActivityVO activityVO = new ActivityVO();
        activityVO.setSysBrandId(memberInfoModel.getBrandId());
        activityVO.setActivityType(activityType);
        activityVO.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode());
        log.info("查询活动，入参:"+JSON.toJSONString(activityVO));
        List<ActivityCouponVO> activityList = mktActivityManualPOMapper.getActivityIdList(activityVO);
        log.info("查询活动，出参:"+ JSON.toJSONString(activityList));

        if(CollectionUtils.isEmpty(activityList)){
            return responseData;
        }
        
        for (ActivityCouponVO vo : activityList) {
          
            //2.查询活动对应的所有券
            log.info("couponQueryServiceFeign.findCouponByCouponCode--->入参为:"+vo.getCouponDefinitionId());
            //ResponseData<CouponDefinitionPO> couponDefinitionPOResponseData  = couponDefinitionServiceFeign.findByIdRpc(activityVO1.getCouponDefinitionId());
            ResponseData<CouponDetailResponseVO>  couponDefinitionPOResponseData = couponQueryServiceFeign.getCouponDefinition(vo.getCouponDefinitionId());
            log.info("couponQueryServiceFeign.findCouponByCouponCode--->出参为:"+JSON.toJSONString(couponDefinitionPOResponseData));
            
            if(!ResponseConstants.SUCCESS.equals(couponDefinitionPOResponseData.getCode())){
                log.warn("couponQueryServiceFeign.findCouponByCouponCode--->出错:"+couponDefinitionPOResponseData.getMessage());
                responseData.setCode(SystemConstants.ERROR_CODE);
                responseData.setMessage(couponDefinitionPOResponseData.getMessage());
                return responseData;
            }else  if (null==couponDefinitionPOResponseData.getData()){
                log.warn("couponQueryServiceFeign.findCouponByCouponCode--->查询为空:"+JSON.toJSONString(couponDefinitionPOResponseData.getData()));
                responseData.setCode(SystemConstants.ERROR_CODE);
                responseData.setMessage(couponDefinitionPOResponseData.getMessage());
                return responseData;
            }
            
            //3.校验是否满足规则
            MktActivityRecordPOExample mktActivityRecordPOExample = new MktActivityRecordPOExample();
            MktActivityRecordPOExample.Criteria criteria = mktActivityRecordPOExample.createCriteria();
            criteria.andValidEqualTo(Boolean.TRUE).andActivityTypeEqualTo(activityType).andAcitivityIdEqualTo(vo.getMktActivityId()).andMemberCodeEqualTo(memberInfoModel.getMemberCode());
            long countAll = mktActivityRecordPOMapper.countByExample(mktActivityRecordPOExample);
            log.info("记录中查到的已领取数量:"+countAll);

            CouponDefinitionPO couponDefinitionPO = couponDefinitionPOResponseData.getData().getCouponDefinitionPO();
            
            vo.setPreferentialType(couponDefinitionPO.getPreferentialType());
            vo.setMoney(couponDefinitionPO.getMoney());
            vo.setDiscount(couponDefinitionPO.getDiscount());
            vo.setExchangeProductId(couponDefinitionPO.getExchangeProductId());
            vo.setValidType(couponDefinitionPO.getValidType());
            vo.setValidDateStart(couponDefinitionPO.getValidDateStart());
            vo.setValidDateEnd(couponDefinitionPO.getValidDateEnd());
            vo.setValidDay(couponDefinitionPO.getValidDay());
            vo.setMinConsume(couponDefinitionPO.getMinConsume());
            vo.setActivityInfo(couponDefinitionPO.getInfo());
            
            criteria.andParticipateDateGreaterThanOrEqualTo(DateUtil.getZeroTime()).andParticipateDateLessThanOrEqualTo(new Date());
            long countToday = mktActivityRecordPOMapper.countByExample(mktActivityRecordPOExample);

            //默认设置可领取
            vo.setCanReceive(Boolean.TRUE);
            //今日领取已达上限
            if (countToday >= vo.getPerPersonPerDayMax()) {
                vo.setCanReceive(Boolean.FALSE);
            }
            //总领取数量已达上限
            if (countAll >= vo.getPerPersonMax()) {
              vo.setCanReceive(Boolean.FALSE);
            }
            log.info("校验规则结束,activityVO1:"+JSON.toJSONString(vo));
            activityVOList.add(vo);
        }

        responseData.setData(activityVOList);
        log.info("领券中心查询出参:"+JSON.toJSONString(activityVOList));
        return responseData;
    }

    @Override
    public ResponseData<ActivityCouponVO> getActivityByQrcode(MemberInfoModel memberInfoModel, String activityCode,Integer activityType) {
        ResponseData responseData = new ResponseData();
        log.info("领券活动-扫码领券-入参:"+JSON.toJSONString(memberInfoModel)+",activityCode:"+JSON.toJSONString(activityCode));
        if(null==memberInfoModel){
            log.warn("领券活动-扫码领券-入参会员信息为空");
            responseData.setCode(SystemConstants.ERROR_CODE);
            responseData.setMessage(SystemConstants.ERROR_MSG_PARAM_EMPTY);
            return responseData;
        }
        if(StringUtils.isEmpty(activityCode)){
            log.warn("领取活动-扫码领券-入参活动编号为空");
            responseData.setCode(SystemConstants.ERROR_CODE);
            responseData.setMessage(SystemConstants.ERROR_MSG_PARAM_EMPTY);
            return responseData;
        }
        //1.查询企业下的所有活动及活动规则及券名称和券code
        ActivityVO activityVO = new ActivityVO();
        activityVO.setSysBrandId(memberInfoModel.getBrandId());
        activityVO.setActivityCode(activityCode);
        activityVO.setActivityType(activityType);
        activityVO.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode());
        try {
            log.info("领券活动-扫码领券-入参activityVO:"+JSON.toJSONString(activityVO));
            List<ActivityVO> activityVOList1 = mktActivityManualPOMapper.getActivityIdListOld(activityVO);
            if (CollectionUtils.isEmpty(activityVOList1)) {
                log.warn("领券活动-查询扫码领券活动为空");
                responseData.setCode(SystemConstants.SUCCESS_CODE);
                responseData.setMessage(ActivityConstants.RETURN_EMPTY);
                return responseData;
            }
            ActivityVO activityCouponVO = activityVOList1.get(0);//只有一个对象
            //2.查询活动对应的所有券
            log.info("couponQueryServiceFeign.findCouponByCouponCode---入参:"+activityCouponVO.getCouponDefinitionId());
            //ResponseData<CouponDefinitionPO> couponDefinitionPOResponseData = couponDefinitionServiceFeign.findByIdRpc(activityCouponVO.getCouponDefinitionId());
            ResponseData<CouponDetailResponseVO>  couponDefinitionPOResponseData = couponQueryServiceFeign.getCouponDefinition(activityCouponVO.getCouponDefinitionId());
            log.info("couponQueryServiceFeign.findCouponByCouponCode---出参:"+JSON.toJSONString(couponDefinitionPOResponseData));
            //3.校验是否满足规则
            MktActivityRecordPOExample mktActivityRecordPOExample = new MktActivityRecordPOExample();
            MktActivityRecordPOExample.Criteria criteria = mktActivityRecordPOExample.createCriteria();
            criteria.andValidEqualTo(Boolean.TRUE).andActivityTypeEqualTo(activityType).andAcitivityIdEqualTo(activityCouponVO.getMktActivityId()).andMemberCodeEqualTo(memberInfoModel.getMemberCode());
            //获取所有记录数
            long countAll = mktActivityRecordPOMapper.countByExample(mktActivityRecordPOExample);
            log.info("记录中查到的已领取数量:"+countAll);

            criteria.andParticipateDateGreaterThanOrEqualTo(DateUtil.getZeroTime()).andParticipateDateLessThanOrEqualTo(new Date());
            long countToday = mktActivityRecordPOMapper.countByExample(mktActivityRecordPOExample);

            //默认设置可领取
            activityCouponVO.setCanReceive(Boolean.TRUE);
            activityCouponVO.setCouponDetailResponseVO(couponDefinitionPOResponseData.getData());

            //今日领取已达上限
            if (countToday >= activityCouponVO.getPerPersonPerDayMax()) {
                activityCouponVO.setCanReceive(Boolean.FALSE);
            }
            //总领取数量已达上限
            if (countAll >= activityCouponVO.getPerPersonMax()) {
                activityCouponVO.setCanReceive(Boolean.FALSE);
            }
            log.info("校验规则结束,activityCouponVO:"+JSON.toJSONString(activityCouponVO));
            responseData.setData(activityCouponVO);
        } catch (Exception e) {
            log.error("扫码领券出错"+e.getMessage());
            responseData.setCode(SystemConstants.ERROR_CODE);
            responseData.setMessage("查询领券中心出错");
            return responseData;
        }
        //4.返回所有券列表及是否可领取
        responseData.setCode(SystemConstants.SUCCESS_CODE);
        responseData.setMessage(SystemConstants.SUCCESS_MESSAGE);
        return responseData;
    }
}
