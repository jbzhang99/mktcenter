package com.bizvane.mktcenterserviceimpl.service.impl;

import com.alibaba.fastjson.JSON;
import com.bizvane.centerstageservice.models.po.SysBrandPo;
import com.bizvane.centerstageservice.models.po.SysCheckConfigPo;
import com.bizvane.centerstageservice.models.po.SysCheckPo;
import com.bizvane.centerstageservice.models.po.SysCompanyPo;
import com.bizvane.centerstageservice.models.vo.SysCheckConfigVo;
import com.bizvane.centerstageservice.rpc.BrandServiceRpc;
import com.bizvane.centerstageservice.rpc.CompanyServiceRpc;
import com.bizvane.centerstageservice.rpc.SysCheckConfigServiceRpc;
import com.bizvane.centerstageservice.rpc.SysCheckServiceRpc;
import com.bizvane.connectorservice.util.SpringUtil;
import com.bizvane.couponfacade.enums.SendTypeEnum;
import com.bizvane.couponfacade.interfaces.CouponDefinitionServiceFeign;
import com.bizvane.couponfacade.interfaces.CouponQueryServiceFeign;
import com.bizvane.couponfacade.models.po.CouponDefinitionPO;
import com.bizvane.couponfacade.models.po.CouponEntityPO;
import com.bizvane.couponfacade.models.vo.CouponDetailResponseVO;
import com.bizvane.couponfacade.models.vo.CouponEntityAndDefinitionVO;
import com.bizvane.couponfacade.models.vo.CouponFindCouponCountResponseVO;
import com.bizvane.couponfacade.models.vo.SendCouponSimpleRequestVO;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.mktcenterservice.interfaces.ActivityManualService;
import com.bizvane.mktcenterservice.models.bo.ActivityBO;
import com.bizvane.mktcenterservice.models.bo.ActivityManualBO;
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
import com.bizvane.mktcenterserviceimpl.common.enums.*;
import com.bizvane.mktcenterserviceimpl.common.utils.ActivityParamCheckUtil;
import com.bizvane.mktcenterserviceimpl.common.utils.CodeUtil;
import com.bizvane.mktcenterserviceimpl.common.utils.DateUtil;
import com.bizvane.mktcenterserviceimpl.common.job.JobUtil;
import com.bizvane.mktcenterserviceimpl.common.utils.SpringContextUtil;
import com.bizvane.mktcenterserviceimpl.common.utils.ExecuteParamCheckUtil;
import com.bizvane.mktcenterserviceimpl.mappers.*;
import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.bizvane.wechatfacade.interfaces.QRCodeServiceFeign;
import com.bizvane.wechatfacade.models.vo.CreateMiniprgmQRCodeRequestVO;
import com.bizvane.wechatfacade.models.vo.UrlQRCodeCreateRequestVO;
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
    private CouponDefinitionServiceFeign couponDefinitionServiceFeign;

    @Autowired
    private MktMessagePOMapper mktMessagePOMapper;

    @Autowired
    private Award award;

    @Autowired
    private BrandServiceRpc brandServiceRpc;
    @Autowired
    private CompanyServiceRpc companyServiceRpc;

    @Autowired
    private QRCodeServiceFeign qrCodeServiceFeign;
    @Autowired
    private SysCheckServiceRpc sysCheckServiceRpc;
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


        //查询审核配置，是否需要审核然后判断
       /* SysCheckConfigVo so = new SysCheckConfigVo();
        so.setSysBrandId(activityVO.getSysBrandId());*/
        ResponseData<List<SysCheckConfigVo>> sysCheckConfigVo = sysCheckConfigServiceRpc.getCheckConfigListAll(activityVO.getSysBrandId());
        List<SysCheckConfigVo> sysCheckConfigVoList = sysCheckConfigVo.getData();
        //判断是否有审核配置
        int i = 0;
        if (!CollectionUtils.isEmpty(sysCheckConfigVoList)) {
            for (SysCheckConfigVo sysCheckConfig : sysCheckConfigVoList) {
                //判断是否需要审核  暂时先写这三个审核类型 后期确定下来写成枚举类
                if (sysCheckConfig.getFunctionCode().equals("C0002")) {
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
        if (i>0){
            //如果是待审核数据则需要增加一条审核数据l
            SysCheckPo po = new SysCheckPo();
            po.setSysBrandId(mktActivityPOWithBLOBs.getSysBrandId());
            po.setBusinessCode(mktActivityPOWithBLOBs.getActivityCode());
            po.setBusinessName(mktActivityPOWithBLOBs.getActivityName());
            po.setBusinessType(activityVO.getActivityType());
            po.setFunctionCode("C0002");
            po.setCheckStatus(CheckStatusEnum.CHECK_STATUS_PENDING.getCode());
            po.setBizName(mktActivityPOWithBLOBs.getActivityName());
            po.setBusinessId(mktActivityId);
            po.setCreateDate(new Date());
            po.setCreateUserId(stageUser.getSysAccountId());
            po.setCreateUserName(stageUser.getName());
            log.info("增加一条数据到审核中心");
            sysCheckServiceRpc.addCheck(po);
        }
        //新增明细表
        MktActivityManualPO mktActivityManualPO = new MktActivityManualPO();
        BeanUtils.copyProperties(activityVO, mktActivityManualPO);
        mktActivityManualPO.setMktActivityId(mktActivityId);
        mktActivityManualPO.setIsStoreLimit(activityVO.getStoreLimit());
        // 扫码领券的二维码
      if(ActivityTypeEnum.ACTIVITY_TYPE_QRCODE.getCode()==activityVO.getActivityType()){
         QRCodeConfig qrCodeConfig = (QRCodeConfig)SpringContextUtil.getBean("QRCodeConfig");
         String url= qrCodeConfig.getQrcodeurl()+activityVO.getActivityCode();
          CreateMiniprgmQRCodeRequestVO createMiniprgmQRCodeRequestVO = new CreateMiniprgmQRCodeRequestVO();
          createMiniprgmQRCodeRequestVO.setSysBrandId(activityVO.getSysBrandId());
          createMiniprgmQRCodeRequestVO.setMiniProgramType("10");

          //根据brandId查询brandCode
         // ResponseData<SysBrandPo> brandPoResult = brandServiceRpc.getBrandByID(activityVO.getSysBrandId());
          //createMiniprgmQRCodeRequestVO.setBrandCode(brandPoResult.getData().getBrandCode());//TODO-

          //ResponseData<SysCompanyPo> companyResult = companyServiceRpc.getCompanyById(stageUser.getSysCompanyId());
          //urlQRCodeCreateRequestVO.setCompanyCode(companyResult.getData().getCompanyCode());
          //urlQRCodeCreateRequestVO.setUrl(url);
          createMiniprgmQRCodeRequestVO.setPath("pages/template01/coupon-scancode/main");
         log.info("领券活动-创建活动-扫码领券查询二维码入参:"+JSON.toJSONString(createMiniprgmQRCodeRequestVO));
          ResponseData<String> qrCodeResponseData= null;
          try {
              qrCodeResponseData = qrCodeServiceFeign.createMiniprgmQRCode(createMiniprgmQRCodeRequestVO);
              log.info("二维码返回结果ssssssssssssssssssss:"+JSON.toJSONString(qrCodeResponseData));
              if(null==qrCodeResponseData||null==qrCodeResponseData.getData()){
                  log.info("领券活动-创建活动-扫码领券生成二维码为空");
                  responseData.setCode(SysResponseEnum.FAILED.getCode());
                  responseData.setMessage(SystemConstants.ERROR_QR_CODE_EMPTY);
                  responseData.setData(SystemConstants.ERROR_CODE);
                  return responseData;
              }
              mktActivityManualPO.setQrcode(qrCodeResponseData.getData());
          } catch (Exception e) {
              log.info("二维码返回结果ssssssssssssssssssss:"+JSON.toJSONString(e));
              e.printStackTrace();
          }
       }
       log.info("领券活动-创建活动-新增领券规则表，入参:"+JSON.toJSONString(mktActivityManualPO));
        mktActivityManualPOMapper.insertSelective(mktActivityManualPO);
        //新增券表,和活动绑定
        MktCouponPO mktCouponPO = new MktCouponPO();
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
         return responseData;
     }catch (Exception e){
         log.error("领券活动-创建活动-出错"+e.getMessage());
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
            example.createCriteria().andBizIdEqualTo(activityManualList.get(0).getMktActivityId()).andValidEqualTo(true);
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

            ActivityBO bo = new ActivityBO();
            bo.setActivityVO(activityManualList.get(0));
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
    public ResponseData<List<ActivityVO>> getActivityByMemberInfo(MemberInfoModel memberInfoModel,Integer activityType) {
        ResponseData responseData = new ResponseData();
        if (null==memberInfoModel.getServiceStoreId()){
            responseData.setCode(SysResponseEnum.MODEL_FAILED_VALIDATION.getCode());
            responseData.setMessage("服务门店不存在!");
            log.info("服务门店为NULL!");
            return responseData;
        }
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
                //过滤门店
                if (!ExecuteParamCheckUtil.implementActivitCheck(memberInfoModel,activityVO1)){
                    continue;
                }
                //2.查询活动对应的所有券
                log.info("couponQueryServiceFeign.findCouponByCouponCode--->入参为:"+activityVO1.getCouponDefinitionId());
                //ResponseData<CouponDefinitionPO> couponDefinitionPOResponseData  = couponDefinitionServiceFeign.findByIdRpc(activityVO1.getCouponDefinitionId());
                ResponseData<CouponDetailResponseVO>  couponDefinitionPOResponseData = couponQueryServiceFeign.getCouponDefinition(activityVO1.getCouponDefinitionId());
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
                criteria.andValidEqualTo(Boolean.TRUE).andActivityTypeEqualTo(activityType).andAcitivityIdEqualTo(activityVO1.getMktActivityId()).andMemberCodeEqualTo(memberInfoModel.getMemberCode());
                //获取所有记录数
                long countAll = mktActivityRecordPOMapper.countByExample(mktActivityRecordPOExample);
                log.info("记录中查到的已领取数量:"+countAll);

                criteria.andParticipateDateGreaterThanOrEqualTo(DateUtil.getZeroTime()).andParticipateDateLessThanOrEqualTo(new Date());
                long countToday = mktActivityRecordPOMapper.countByExample(mktActivityRecordPOExample);

                //默认设置可领取
                activityVO1.setCanReceive(Boolean.TRUE);
                activityVO1.setCouponDetailResponseVO(couponDefinitionPOResponseData.getData());

                //今日领取已达上限
                if (countToday >= activityVO1.getPerPersonPerDayMax()) {
                    activityVO1.setCanReceive(Boolean.FALSE);
                }
                //总领取数量已达上限
                if (countAll >= activityVO1.getPerPersonMax()) {
                    activityVO1.setCanReceive(Boolean.FALSE);
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
            return responseData;
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
        //1.查询企业下的所有活动及活动规则及券名称和券code
        ActivityVO activityVO = new ActivityVO();
        activityVO.setSysBrandId(memberInfoModel.getBrandId());
        activityVO.setActivityCode(activityCode);
        activityVO.setActivityType(activityType);
        activityVO.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode());
        try {
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
            log.info("couponQueryServiceFeign.findCouponByCouponCode---入参:"+activityVO.getCouponDefinitionId());
            //ResponseData<CouponDefinitionPO> couponDefinitionPOResponseData = couponDefinitionServiceFeign.findByIdRpc(activityVO.getCouponDefinitionId());
            ResponseData<CouponDetailResponseVO>  couponDefinitionPOResponseData = couponQueryServiceFeign.getCouponDefinition(activityVO.getCouponDefinitionId());
            log.info("couponQueryServiceFeign.findCouponByCouponCode---出参:"+JSON.toJSONString(couponDefinitionPOResponseData));
            //3.校验是否满足规则
            MktActivityRecordPOExample mktActivityRecordPOExample = new MktActivityRecordPOExample();
            MktActivityRecordPOExample.Criteria criteria = mktActivityRecordPOExample.createCriteria();
            criteria.andValidEqualTo(Boolean.TRUE).andActivityTypeEqualTo(activityType).andAcitivityIdEqualTo(activityVO.getMktActivityId()).andMemberCodeEqualTo(memberInfoModel.getMemberCode());
            //获取所有记录数
            long countAll = mktActivityRecordPOMapper.countByExample(mktActivityRecordPOExample);
            log.info("记录中查到的已领取数量:"+countAll);

            criteria.andParticipateDateGreaterThanOrEqualTo(DateUtil.getZeroTime()).andParticipateDateLessThanOrEqualTo(new Date());
            long countToday = mktActivityRecordPOMapper.countByExample(mktActivityRecordPOExample);

            //默认设置可领取
            activityVO.setCanReceive(Boolean.TRUE);
            activityVO.setCouponDetailResponseVO(couponDefinitionPOResponseData.getData());

            //今日领取已达上限
            if (countToday >= activityVO.getPerPersonPerDayMax()) {
                activityVO.setCanReceive(Boolean.FALSE);
            }
            //总领取数量已达上限
            if (countAll >= activityVO.getPerPersonMax()) {
                activityVO.setCanReceive(Boolean.FALSE);
            }
            log.info("校验规则结束,activityVO:"+JSON.toJSONString(activityVO));
            responseData.setData(activityVO);
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

    /**
     * 审核
     * @param
     * @param sysAccountPO
     * @return
     */
    @Override
    public ResponseData<Integer> checkActivity(SysCheckPo po, SysAccountPO sysAccountPO) {
        ResponseData responseData = new ResponseData();
        MktActivityPOWithBLOBs bs = new MktActivityPOWithBLOBs();
        bs.setModifiedUserId(sysAccountPO.getSysAccountId());
        bs.setModifiedDate(new Date());
        bs.setModifiedUserName(sysAccountPO.getName());
        bs.setCheckStatus(po.getCheckStatus());
        bs.setActivityCode(po.getBusinessCode());
        bs.setMktActivityId(po.getBusinessId());
        //查询扫码领卷的的详细信息
        ActivityVO vo = new ActivityVO();
        vo.setActivityCode(bs.getActivityCode());
        List<ActivityVO> activityManualList = mktActivityManualPOMapper.getActivityManualList(vo);
        ActivityVO activityVO = activityManualList.get(0);
        if(bs.getCheckStatus()==CheckStatusEnum.CHECK_STATUS_APPROVED.getCode()){
           // 活动开始时间<当前时间<活动结束时间  变为执行中
            if(new Date().after(activityVO.getStartTime()) && new Date().before(activityVO.getEndTime())){
                bs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode());
            }
            //判断审核时间 >活动结束时间  将活动状态变为已结束
            if(new Date().after(activityVO.getEndTime())){
                bs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_FINISHED.getCode());
            }
        }else{
            bs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_FINISHED.getCode());

        }
        log.info("更新审核状态的参数是+======="+ JSON.toJSONString(bs));
        int i = mktActivityPOMapper.updateByPrimaryKeySelective(bs);
        log.info("更新审核状态完成");
        //更新审核中心状态
        log.info("更新审核中心check的参数是+======="+ JSON.toJSONString(po));
        sysCheckServiceRpc.updateCheck(po);
        responseData.setCode(SystemConstants.SUCCESS_CODE);
        responseData.setMessage(SystemConstants.SUCCESS_MESSAGE);
        return responseData;
    }
}
