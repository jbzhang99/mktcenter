package com.bizvane.mktcenterserviceimpl.service.impl;

import com.alibaba.fastjson.JSON;
import com.bizvane.centerstageservice.models.po.SysCheckConfigPo;
import com.bizvane.centerstageservice.models.vo.SysCheckConfigVo;
import com.bizvane.centerstageservice.rpc.SysCheckConfigServiceRpc;
import com.bizvane.couponfacade.interfaces.CouponDefinitionServiceFeign;
import com.bizvane.couponfacade.interfaces.CouponQueryServiceFeign;
import com.bizvane.couponfacade.models.po.CouponDefinitionPO;
import com.bizvane.couponfacade.models.po.CouponEntityPO;
import com.bizvane.couponfacade.models.vo.CouponDefinitionListQueryVO;
import com.bizvane.couponfacade.models.vo.CouponEntityAndDefinitionVO;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.mktcenterservice.interfaces.ActivityManualService;
import com.bizvane.mktcenterservice.models.bo.ActivityBO;
import com.bizvane.mktcenterservice.models.bo.AwardBO;
import com.bizvane.mktcenterservice.models.po.*;
import com.bizvane.mktcenterservice.models.vo.ActivityManualVO;
import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.mktcenterservice.models.vo.PageForm;
import com.bizvane.mktcenterserviceimpl.common.award.Award;
import com.bizvane.mktcenterserviceimpl.common.config.QRCodeConfig;
import com.bizvane.mktcenterserviceimpl.common.constants.ActivityConstants;
import com.bizvane.mktcenterserviceimpl.common.constants.ResponseConstants;
import com.bizvane.mktcenterserviceimpl.common.constants.SystemConstants;
import com.bizvane.mktcenterserviceimpl.common.enums.ActivityStatusEnum;
import com.bizvane.mktcenterserviceimpl.common.enums.BusinessTypeEnum;
import com.bizvane.mktcenterserviceimpl.common.enums.CheckStatusEnum;
import com.bizvane.mktcenterserviceimpl.common.utils.ActivityParamCheckUtil;
import com.bizvane.mktcenterserviceimpl.common.utils.CodeUtil;
import com.bizvane.mktcenterserviceimpl.common.utils.DateUtil;
import com.bizvane.mktcenterserviceimpl.common.utils.JobUtil;
import com.bizvane.mktcenterserviceimpl.mappers.*;
import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.bizvane.wechatfacade.interfaces.QRCodeServiceFeign;
import com.bizvane.wechatfacade.models.vo.QRCodeCreateRequestVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
@Slf4j
public class ActivityManualServiceImpl implements ActivityManualService {
    @Autowired
    private MktActivityManualPOMapper mktActivityManualPOMapper;
    @Autowired
    private SysCheckConfigServiceRpc sysCheckConfigServiceRpc;

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
    private MktMessagePOMapper mktMessagePOMapper;

    @Autowired
    private Award award;

    @Autowired
    private QRCodeServiceFeign qrCodeServiceFeign;

    @Autowired
    private CouponDefinitionServiceFeign couponDefinitionServiceFeign;

    @Override
    public ResponseData<ActivityVO> getActivityManualList(ActivityVO vo, PageForm pageForm) {
        ResponseData responseData = new ResponseData();
        log.info("领券活动查询活动列表入参:ActivityVO:"+JSON.toJSONString(vo));
        PageHelper.startPage(pageForm.getPageNum(), pageForm.getPageSize());
        List<ActivityVO> activityManualList = new ArrayList<>();
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
     * @param couponId
     * @param activityVO
     * @param stageUser
     * @return
     */
    @Override
    @Transactional
    public ResponseData<Integer> addActivityManual(Long couponId, ActivityVO activityVO, SysAccountPO stageUser) {
        log.info("领券活动-创建活动-入参:couponId:"+couponId+",activityVO:"+JSON.toJSONString(activityVO)+",stageUser:"+JSON.toJSONString(stageUser));
        //1.入参校验
        ResponseData responseData = new ResponseData();
        ActivityParamCheckUtil.checkAddActivityParams(couponId, activityVO);
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

        //查询审核配置，是否需要审核然后判断
        SysCheckConfigVo so = new SysCheckConfigVo();
        so.setSysBrandId(activityVO.getSysBrandId());
        ResponseData<List<SysCheckConfigVo>> sysCheckConfigVo = sysCheckConfigServiceRpc.getCheckConfigListAll(so);
        List<SysCheckConfigVo> sysCheckConfigVoList = sysCheckConfigVo.getData();
        //判断是否有审核配置
        int i = 0;
        if (!CollectionUtils.isEmpty(sysCheckConfigVoList)) {
            for (SysCheckConfigVo sysCheckConfig : sysCheckConfigVoList) {
                //判断是否需要审核  暂时先写这三个审核类型 后期确定下来写成枚举类
                if (sysCheckConfig.getFunctionCode().equals("C0001") || sysCheckConfig.getFunctionCode().equals("C0002") || sysCheckConfig.getFunctionCode().equals("C0003")) {
                    i += 1;
                }
            }
        }
        if (i > 0) {
            //1.待审核，增加审核单，活动开始时间>今天，待执行
            //查询结果如果需要审核审核状态为待审核
            mktActivityPOWithBLOBs.setCheckStatus(CheckStatusEnum.CHECK_STATUS_PENDING.getCode());
            //活动状态设置为待执行
            mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_PENDING.getCode());

            //如果是待审核数据则需要增加一条审核数据
            SysCheckConfigPo configPo = new SysCheckConfigPo();
            configPo.setSysBrandId(mktActivityPOWithBLOBs.getSysBrandId());
            configPo.setFunctionCode(mktActivityPOWithBLOBs.getActivityCode());
            configPo.setFunctionName(mktActivityPOWithBLOBs.getActivityName());
            configPo.setCreateDate(new Date());
            configPo.setCreateUserId(stageUser.getSysAccountId());
            configPo.setCreateUserName(stageUser.getName());
            sysCheckConfigServiceRpc.addCheckConfig(configPo);
            //getStartTime 开始时间>当前时间增加job
            if (new Date().before(activityVO.getStartTime())) {
                //创建任务调度任务开始时间
                jobUtil.addJob(stageUser, activityVO, activityCode);
                //创建任务调度任务结束时间
                jobUtil.addJobEndTime(stageUser, activityVO, activityCode);
            }
        } else {
            //查询结果如果不需要审核审核状态为已审核
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
        }
        //新增活动主表
         log.info("领券活动-创建活动-新增活动主表入参:"+JSON.toJSONString(mktActivityPOWithBLOBs));
        mktActivityPOMapper.insertSelective(mktActivityPOWithBLOBs);
        //返回主表的id
        Long mktActivityId = mktActivityPOWithBLOBs.getMktActivityId();
        log.info("领券活动-创建活动-新增活动-活动主表id"+mktActivityId);
        //新增明细表
        MktActivityManualPO mktActivityManualPO = new MktActivityManualPO();
        BeanUtils.copyProperties(activityVO, mktActivityManualPO);
        mktActivityManualPO.setMktActivityId(mktActivityId);
        // 扫码领券的二维码
      if(1==activityVO.getReceiveType()){
         QRCodeConfig qrCodeConfig = new QRCodeConfig();
         QRCodeCreateRequestVO qrCodeCreateRequestVO = new QRCodeCreateRequestVO();
         qrCodeCreateRequestVO.setSysBrandId(activityVO.getSysBrandId());
         qrCodeCreateRequestVO.setBusinessCode(activityCode);
         qrCodeCreateRequestVO.setBusinessType(String.valueOf(BusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode()));
         qrCodeCreateRequestVO.setLogoImageUrl(qrCodeConfig.getQrcodeurl());
        log.info("领券活动-创建活动-扫码领券查询二维码入参:"+JSON.toJSONString(qrCodeCreateRequestVO));
         ResponseData<String> qrCodeResponseData= qrCodeServiceFeign.createQRCode(qrCodeCreateRequestVO);
         if(null==qrCodeCreateRequestVO){
            log.info("领券活动-创建活动-扫码领券生成二维码为空");
            responseData.setMessage(SystemConstants.ERROR_QR_CODE_EMPTY);
            responseData.setData(SystemConstants.ERROR_CODE);
            return responseData;
         }
         String qrCodeUrl=qrCodeResponseData.getData();
         mktActivityManualPO.setQrcode(qrCodeUrl);
       }
       log.info("领券活动-创建活动-新增领券规则表，入参:"+JSON.toJSONString(mktActivityManualPO));
        mktActivityManualPOMapper.insertSelective(mktActivityManualPO);
        //新增券表,和活动绑定
        MktCouponPO mktCouponPO = new MktCouponPO();
        mktCouponPO.setCouponDefinitionId(couponId);
        mktCouponPO.setBizId(mktActivityId);//活动id
        mktCouponPO.setBizType(BusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode());//业务类型 1.活动改为枚举，不要出现魔数
        mktCouponPO.setModifiedUserId(stageUser.getSysAccountId());
        mktCouponPO.setModifiedUserName(stageUser.getName());
        mktCouponPO.setModifiedDate(new Date());
        mktCouponPO.setCouponName(activityVO.getCouponName());
        mktCouponPO.setCouponCode(activityVO.getCouponCode());
        log.info("领券活动-创建活动-新增券表-入参:"+JSON.toJSONString(mktCouponPO));
        mktCouponPOMapper.insertSelective(mktCouponPO);
            responseData.setCode(SystemConstants.SUCCESS_CODE);
            responseData.setMessage(SystemConstants.SUCCESS_MESSAGE);
        log.info("领券活动-创建活动-成功");
         return responseData;
     }catch (Exception e){
         log.error("领券活动-创建活动-出错");
         responseData.setCode(SystemConstants.ERROR_CODE);
         responseData.setMessage(ActivityConstants.ERROR_SQL);
         return responseData;
      }
    }



    /**
     * 领券
     * @param vo
     * @return
     */
    @Override
    public ResponseData<Integer> executeActivity(ActivityManualVO vo) {
        log.info("领券活动-执行活动，入参:memberInfoModel-"+ JSON.toJSONString(vo));
        ResponseData responseData = new ResponseData();
        ActivityVO activityVO = new ActivityVO();
        if(vo==null){
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
            if(StringUtils.isEmpty(vo.getCouponCode())){
                log.warn("领券活动-执行活动-券号为空");
                responseData.setCode(SystemConstants.ERROR_CODE);
                responseData.setMessage(SystemConstants.ERROR_MSG_PARAM_EMPTY);
                return  responseData;
            }
            activityVO.setSysBrandId(memberInfoModel.getBrandId());
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
            int count = mktActivityRecordPOMapper.countByCondition(mktActivityRecordPO);
            List<MktActivityRecordPO> mktActivityRecordList = mktActivityRecordPOMapper.selectActivityRecordPOList(mktActivityRecordPO);
            log.info("couponQueryServiceFeign.findCouponByCouponCode：入参:"+vo.getCouponCode());
            ResponseData<CouponEntityPO> couponByCouponCode = couponQueryServiceFeign.findCouponByCouponCode(vo.getCouponCode());
            log.info("couponQueryServiceFeign.findCouponByCouponCode：出参:"+JSON.toJSONString(couponByCouponCode));

            if(!ResponseConstants.SUCCESS.equals(couponByCouponCode.getCode())){
                log.warn("couponQueryServiceFeign.findCouponByCouponCode--->出错:"+couponByCouponCode.getMessage());
                responseData.setCode(SystemConstants.ERROR_CODE);
                responseData.setMessage(couponByCouponCode.getMessage());
                return responseData;
            }else  if (null==couponByCouponCode.getData()){
                log.warn("couponQueryServiceFeign.findCouponByCouponCode--->查询为空:"+JSON.toJSONString(couponByCouponCode.getData()));
                responseData.setCode(SystemConstants.ERROR_CODE);
                responseData.setMessage(couponByCouponCode.getMessage());
                return responseData;
            }
            //校验是否可领取
            activityVO.setCanReceive(Boolean.TRUE);
            if(count==0||CollectionUtils.isEmpty(mktActivityRecordList)){
                log.info("领券活动-执行活动-该会员未领取该活动券");
                activityVO.setCouponEntityPO(couponByCouponCode.getData());
                responseData.setCode(SystemConstants.SUCCESS_CODE);
                responseData.setMessage(SystemConstants.SUCCESS_MESSAGE);
                responseData.setData(activityVO);
                return responseData;
            }
            if (count > mktActivityManualPO.getPerPersonMax()) {
                log.warn("领取超过最大限制,已领取:"+count+"，最大限制为:"+mktActivityManualPO.getPerPersonMax());
                activityVO.setCanReceive(Boolean.FALSE);
                activityVO.setCouponEntityPO(couponByCouponCode.getData());
                responseData.setCode(SystemConstants.SUCCESS_CODE);
                responseData.setMessage(ActivityConstants.CAN_NOT_RECEIVE);
                return responseData;
            }
            int receiveCount = 0;
            for (MktActivityRecordPO recordPO : mktActivityRecordList) {
                if (new Date().after(recordPO.getParticipateDate()) && (DateUtil.getZeroTime()).before(recordPO.getParticipateDate())) {
                    receiveCount++;
                }
            }
            if (receiveCount > mktActivityManualPO.getPerPersonPerDayMax()) {
                log.warn("领取超过当日最大限制,已领取数:"+receiveCount+",当日最大限制为:"+mktActivityManualPO.getPerPersonPerDayMax());
                activityVO.setCanReceive(Boolean.FALSE);
                activityVO.setCouponEntityPO(couponByCouponCode.getData());
                responseData.setCode(SystemConstants.SUCCESS_CODE);
                responseData.setMessage(ActivityConstants.CAN_NOT_RECEIVE);
                return responseData;
            }

            //发券
            AwardBO awardBO = new AwardBO();
            awardBO.setCouponDefinitionId(vo.getCouponId());
            awardBO.setMemberCode(vo.getMemberInfoModel().getMemberCode());
            awardBO.setSendBussienId(vo.getMktActivityId());
            log.info("领券活动执行活动-发券调接口入参:"+JSON.toJSONString(awardBO));
            award.execute(awardBO);

            //新增记录表
            mktActivityRecordPO.setMemberCode(memberInfoModel.getMemberCode());
            mktActivityRecordPO.setAcitivityId(mktActivityManualPO.getMktActivityManualId());
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
        }catch (Exception e){
            log.error("领券活动-执行活动-出错:"+e.getMessage());
            responseData.setCode(SystemConstants.ERROR_CODE);
            responseData.setMessage("领券活动-执行活动失败");
            return responseData;
        }
        responseData.setCode(SystemConstants.SUCCESS_CODE);
        responseData.setMessage(SystemConstants.SUCCESS_MESSAGE);
        return responseData;
    }


    @Override
    public ResponseData<List<ActivityBO>> getActivityManualEffect(ActivityVO vo,SysAccountPO stageUser) {
        log.info("领券活动-活动效果分析-入参:"+JSON.toJSONString(vo));
        ResponseData responseData = new ResponseData<>();
        //查询该品牌下的所有领券活动
        //todo调券接口查询券信息
        /**
         * 入参：
         * 出参领取张数，核销张数，核销率，券收益
         */
        vo.setSysBrandId( stageUser.getBrandId());
        try {
        List<ActivityVO> activityVOList = mktActivityManualPOMapper.getActivityManualList(vo);
        for(ActivityVO vo1:activityVOList){
            vo1.getActivityCode();
            MktCouponPOExample mktCouponPOExample= new MktCouponPOExample();
            mktCouponPOExample.createCriteria().andBizIdEqualTo(vo1.getMktActivityId());
            List<MktCouponPO> couponPOList= mktCouponPOMapper.selectByExample(mktCouponPOExample);
            if(CollectionUtils.isEmpty(couponPOList)){
              continue;
            }
            CouponDefinitionListQueryVO couponDefinitionListQueryVO = new CouponDefinitionListQueryVO();
            //couponDefinitionListQueryVO.setCouponDefinitionId(couponPOList.get(0));
            ResponseData<com.bizvane.utils.responseinfo.PageInfo<CouponDefinitionPO>> couponResponseData=couponDefinitionServiceFeign.getListRpc(couponDefinitionListQueryVO) ;//一个活动只有一张券
        }

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
    public ResponseData<ActivityBO> selectActivityManualById(String businessCode) {
        ResponseData responseData = new ResponseData();
        if(StringUtils.isEmpty(businessCode)){
            log.error("领券活动-查询活动详情-入参为空");
            responseData.setCode(SystemConstants.ERROR_CODE);
            responseData.setMessage(SystemConstants.ERROR_MSG_PARAM_EMPTY);
            return  responseData;
        }
        try {
            ActivityVO vo = new ActivityVO();
            vo.setActivityCode(businessCode);
            log.info("领券活动-查询活动详情-getActivityList入参:"+ JSON.toJSONString(vo));
            List<ActivityVO> activityManualList = mktActivityManualPOMapper.getActivityList(vo);
            log.info("领券活动-查询活动详情-出参:"+ JSON.toJSONString(activityManualList));
            //查询活动卷
            MktCouponPOExample example = new  MktCouponPOExample();
            example.createCriteria().andBizIdEqualTo(activityManualList.get(0).getMktActivityId()).andValidEqualTo(true);
            log.info("领券活动-查询券-入参:"+JSON.toJSONString(example));
            List<MktCouponPO> mktCouponPOs= mktCouponPOMapper.selectByExample(example);
            log.info("领券活动-查询券-出参:"+JSON.toJSONString(mktCouponPOs));
            //查询券接口
            List<CouponEntityAndDefinitionVO> lists = new ArrayList<>();
            if(!CollectionUtils.isEmpty(mktCouponPOs)){
                for (MktCouponPO po:mktCouponPOs) {
                    CouponEntityPO couponEntity = new CouponEntityPO();
                    couponEntity.setCouponEntityId(po.getCouponDefinitionId());
                    ResponseData<CouponEntityAndDefinitionVO>  entityAndDefinition = couponQueryServiceFeign.getAllRpc(couponEntity);
                    log.info("领券活动-调券接口-出参:"+JSON.toJSONString(entityAndDefinition));
                    lists.add(entityAndDefinition.getData());
                }
            }

            ActivityBO bo = new ActivityBO();
            if(!CollectionUtils.isEmpty(activityManualList)){
                bo.setActivityVO(activityManualList.get(0));
            }
            if(!CollectionUtils.isEmpty(lists)){
                bo.setCouponEntityAndDefinitionVOList(lists);
            }
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
    public ResponseData<List<ActivityVO>> getActivityByMemberInfo(MemberInfoModel memberInfoModel,Integer activityType) {
        ResponseData responseData = new ResponseData();
        log.info("领券中心查询入参:"+JSON.toJSONString(memberInfoModel));
        //入参校验
        if(null==memberInfoModel){
            log.warn("领券中心-会员信息为空");
            responseData.setCode(SystemConstants.ERROR_CODE);
            responseData.setMessage("会员信息为空");
            return responseData;
        }
        if(null==memberInfoModel.getBrandId()||StringUtils.isEmpty(memberInfoModel.getMemberCode())){
            log.warn("领券中心-会员信息为空");
            responseData.setCode(SystemConstants.ERROR_CODE);
            responseData.setMessage("会员信息为空");
            return responseData;
        }
        if(null==activityType){
            log.warn("领券中心-活动类型为空");
            responseData.setCode(SystemConstants.ERROR_CODE);
            responseData.setMessage("活动类型为空");
            return responseData;
        }

        List<ActivityVO> activityVOList = new ArrayList<>();
        //1.查询企业下的所有活动及活动规则及券名称和券code
        ActivityVO activityVO = new ActivityVO();
        activityVO.setSysBrandId(memberInfoModel.getBrandId());
        activityVO.setActivityType(activityType);
        activityVO.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode());
        try {
            log.info("查询活动，入参:"+JSON.toJSONString(activityVO));
          List<ActivityVO> activityList = mktActivityManualPOMapper.getActivityIdList(activityVO);
             log.info("查询活动，出参:"+ JSON.toJSONString(activityList));
             if(CollectionUtils.isEmpty(activityList)){
                 log.warn("查询活动为空");
                 responseData.setCode(SystemConstants.SUCCESS_CODE);
                 responseData.setMessage("查询领券中心活动为空");
                 return responseData;
             }
        for (ActivityVO activityVO1 : activityList) {
            //2.查询活动对应的所有券
            MktCouponPO couponPO = new MktCouponPO();
            couponPO.setBizId(activityVO1.getMktActivityId());
            couponPO.setBizType(BusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode());
            MktCouponPO mktCouponPO = mktCouponPOMapper.selectMktActivityManualId(couponPO);
            if(null==mktCouponPO){
                log.warn("领券中心活动对应的券为空");
                responseData.setCode(SystemConstants.ERROR_CODE);
                responseData.setMessage("领券中心活动对应的券为空");
                return responseData;
            }
            log.info("couponQueryServiceFeign.findCouponByCouponCode--->入参为:"+mktCouponPO.getCouponCode());
            ResponseData<CouponEntityPO> couponByCouponCode = couponQueryServiceFeign.findCouponByCouponCode(mktCouponPO.getCouponCode());
           log.info("couponQueryServiceFeign.findCouponByCouponCode--->出参为:"+JSON.toJSONString(couponByCouponCode));
           if(!ResponseConstants.SUCCESS.equals(couponByCouponCode.getCode())){
            log.warn("couponQueryServiceFeign.findCouponByCouponCode--->出错:"+couponByCouponCode.getMessage());
               responseData.setCode(SystemConstants.ERROR_CODE);
               responseData.setMessage(couponByCouponCode.getMessage());
               return responseData;
           }else  if (null==couponByCouponCode.getData()){
               log.warn("couponQueryServiceFeign.findCouponByCouponCode--->查询为空:"+JSON.toJSONString(couponByCouponCode.getData()));
               responseData.setCode(SystemConstants.ERROR_CODE);
               responseData.setMessage(couponByCouponCode.getMessage());
               return responseData;
           }
            //3.校验是否满足规则
            MktActivityRecordPO mktActivityRecordPO = new MktActivityRecordPO();
            mktActivityRecordPO.setMemberCode(memberInfoModel.getMemberCode());
            mktActivityRecordPO.setAcitivityId(activityVO1.getMktActivityManualId());
            mktActivityRecordPO.setActivityType(activityType);
            int count = mktActivityRecordPOMapper.countByCondition(mktActivityRecordPO);
            log.info("记录中查到的已领取数量:"+count);
            List<MktActivityRecordPO> mktActivityRecordList = mktActivityRecordPOMapper.selectActivityRecordPOList(mktActivityRecordPO);
           log.info("记录表中查到已领取的list:"+JSON.toJSONString(mktActivityRecordList));
           if(0==count||CollectionUtils.isEmpty(mktActivityRecordList)){
               log.info("该会员未领取该活动券");
               activityVO1.setCouponEntityPO(couponByCouponCode.getData());
               responseData.setCode(SystemConstants.SUCCESS_CODE);
               responseData.setMessage(SystemConstants.SUCCESS_MESSAGE);
               return responseData;
           }
            //校验今日已领取的
            int receiveCount = 0;
           activityVO1.setCanReceive(Boolean.TRUE);
            for (MktActivityRecordPO recordPO : mktActivityRecordList) {
                if (new Date().after(recordPO.getParticipateDate()) && (DateUtil.getZeroTime()).before(recordPO.getParticipateDate())) {
                    receiveCount++;
                }
            }
            if (receiveCount > activityVO1.getPerPersonPerDayMax()) {
                activityVO1.setCanReceive(Boolean.FALSE);
                activityVO1.setCouponEntityPO(couponByCouponCode.getData());
            }
            //校验每个人最多领取的
            if (count > activityVO1.getPerPersonMax()) {
                activityVO1.setCanReceive(Boolean.FALSE);
                activityVO1.setCouponEntityPO(couponByCouponCode.getData());
            }
            log.info("校验规则结束,activityVO1:"+JSON.toJSONString(activityVO1));
            activityVOList.add(activityVO1);
        }

        //4.返回所有券列表及是否可领取
        responseData.setData(activityVOList);
        responseData.setCode(SystemConstants.SUCCESS_CODE);
        responseData.setMessage(SystemConstants.SUCCESS_MESSAGE);
        }catch (Exception e){
            log.error("查询领券中心出错"+e.getMessage());
            responseData.setCode(SystemConstants.ERROR_CODE);
            responseData.setMessage("查询领券中心出错");
        }
        log.info("领券中心查询出参:"+JSON.toJSONString(activityVOList));
        return responseData;
    }

    @Override
    public ResponseData<ActivityVO> getActivityByQrcode(MemberInfoModel memberInfoModel, String activityCode,Integer activityType) {
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
        try {
            //1.查询企业下的所有活动及活动规则及券名称和券code
            ActivityVO activityVO = new ActivityVO();
            activityVO.setSysBrandId(memberInfoModel.getBrandId());
            activityVO.setActivityCode(activityCode);
            activityVO.setActivityType(activityType);
            log.info("领券活动-扫码领券-入参activityVO:"+JSON.toJSONString(activityVO));
            List<ActivityVO> activityVOList1 = mktActivityManualPOMapper.getActivityIdList(activityVO);
            if (CollectionUtils.isEmpty(activityVOList1)) {
                log.warn("领券活动-查询扫码领券活动为空");
                responseData.setCode(SystemConstants.SUCCESS_CODE);
                responseData.setMessage(ActivityConstants.RETURN_EMPTY);
                return responseData;
            }
            activityVO = activityVOList1.get(0);//只有一个对象
            //2.查询活动对应的所有券
            MktCouponPO couponPO = new MktCouponPO();
            couponPO.setBizId(activityVO.getMktActivityId());
            couponPO.setBizType(BusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode());
            log.info("领券活动-扫码领券-入参couponPO:"+JSON.toJSONString(couponPO));
            MktCouponPO mktCouponPO = mktCouponPOMapper.selectMktActivityManualId(couponPO);
            log.info("couponQueryServiceFeign.findCouponByCouponCode---入参:"+mktCouponPO.getCouponCode());
            ResponseData<CouponEntityPO> couponByCouponCode = couponQueryServiceFeign.findCouponByCouponCode(mktCouponPO.getCouponCode());
            log.info("couponQueryServiceFeign.findCouponByCouponCode---出参:"+JSON.toJSONString(couponByCouponCode));
            //3.校验是否满足规则
            MktActivityRecordPO mktActivityRecordPO = new MktActivityRecordPO();
            mktActivityRecordPO.setMemberCode(memberInfoModel.getMemberCode());
            mktActivityRecordPO.setAcitivityId(activityVO.getMktActivityManualId());
            mktActivityRecordPO.setActivityType(activityType);
            int count = mktActivityRecordPOMapper.countByCondition(mktActivityRecordPO);
            log.info("记录中查到的已领取数量:"+count);
            List<MktActivityRecordPO> mktActivityRecordList = mktActivityRecordPOMapper.selectActivityRecordPOList(mktActivityRecordPO);
            log.info("记录表中查到已领取的list:"+JSON.toJSONString(mktActivityRecordList));
            activityVO.setCanReceive(Boolean.TRUE);
            if(0==count||CollectionUtils.isEmpty(mktActivityRecordList)){
                log.info("该会员未领取该活动券");
                activityVO.setCouponEntityPO(couponByCouponCode.getData());
                responseData.setCode(SystemConstants.SUCCESS_CODE);
                responseData.setMessage(SystemConstants.SUCCESS_MESSAGE);
                return responseData;
            }
            //校验今日已领取的
            int receiveCount = 0;
            for (MktActivityRecordPO recordPO : mktActivityRecordList) {
                if (new Date().after(recordPO.getParticipateDate()) && (DateUtil.getZeroTime()).before(recordPO.getParticipateDate())) {
                    receiveCount++;
                }
            }
            if (receiveCount > activityVO.getPerPersonPerDayMax()) {
                activityVO.setCanReceive(Boolean.FALSE);
                activityVO.setCouponEntityPO(couponByCouponCode.getData());
            }
            //校验每个人最多领取的
            if (count > activityVO.getPerPersonMax()) {
                activityVO.setCanReceive(Boolean.FALSE);
                activityVO.setCouponEntityPO(couponByCouponCode.getData());
            }
            log.info("校验规则结束,activityVO1:"+JSON.toJSONString(activityVO));
            responseData.setData(activityVO);
        } catch (Exception e) {
            log.error("扫码领券出错");
            responseData.setCode(SystemConstants.ERROR_CODE);
            responseData.setMessage("查询领券中心出错");
        }
        //4.返回所有券列表及是否可领取
        responseData.setCode(SystemConstants.SUCCESS_CODE);
        responseData.setMessage(SystemConstants.SUCCESS_MESSAGE);
        return responseData;
    }

    /**
     * 审核
     * @param bs
     * @param sysAccountPO
     * @return
     */
    @Override
    public ResponseData<Integer> checkActivity(MktActivityPOWithBLOBs bs, SysAccountPO sysAccountPO) {
        ResponseData responseData = new ResponseData();
        MktActivityPOExample mktActivityPOExample = new MktActivityPOExample();
        mktActivityPOExample.createCriteria().andValidEqualTo(Boolean.TRUE).andActivityCodeEqualTo(bs.getActivityCode());
        mktActivityPOMapper.updateByExampleSelective(bs,mktActivityPOExample);

        //todo 调用中台审核接口更改此单据状态

        responseData.setCode(SystemConstants.SUCCESS_CODE);
        responseData.setMessage(SystemConstants.SUCCESS_MESSAGE);
        return responseData;
    }
}
