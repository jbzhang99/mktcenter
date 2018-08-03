package com.bizvane.mktcenterserviceimpl.service.impl;

import com.bizvane.centerstageservice.models.po.SysCheckConfigPo;
import com.bizvane.centerstageservice.models.vo.SysCheckConfigVo;
import com.bizvane.centerstageservice.rpc.SysCheckConfigServiceRpc;
import com.bizvane.couponfacade.interfaces.CouponQueryServiceFeign;
import com.bizvane.couponfacade.models.po.CouponEntityPO;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.mktcenterservice.interfaces.ActivityManualService;
import com.bizvane.mktcenterservice.models.bo.ActivityBO;
import com.bizvane.mktcenterservice.models.po.*;
import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.mktcenterservice.models.vo.PageForm;
import com.bizvane.mktcenterserviceimpl.common.config.QRCodeConfig;
import com.bizvane.mktcenterserviceimpl.common.constants.ActivityConstants;
import com.bizvane.mktcenterserviceimpl.common.constants.SystemConstants;
import com.bizvane.mktcenterserviceimpl.common.enums.ActivityStatusEnum;
import com.bizvane.mktcenterserviceimpl.common.enums.ActivityTypeEnum;
import com.bizvane.mktcenterserviceimpl.common.enums.CheckStatusEnum;
import com.bizvane.mktcenterserviceimpl.common.utils.ActivityParamCheckUtil;
import com.bizvane.mktcenterserviceimpl.common.utils.JobUtil;
import com.bizvane.mktcenterserviceimpl.mappers.*;
import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
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
import java.util.UUID;

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
    @Override
    public ResponseData<ActivityVO> getActivityManualList(ActivityVO vo, PageForm pageForm) {
        ResponseData responseData = new ResponseData();
        PageHelper.startPage(pageForm.getPageNum(), pageForm.getPageSize());
        List<ActivityVO> activityManualList = new ArrayList<>();
        try {
            log.info("查询领券活动列表开始");
            activityManualList = mktActivityManualPOMapper.getActivityManualList(vo);
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
        ResponseData responseData = new ResponseData();
        log.info("领券活动-创建活动-入参:couponId:"+couponId+",activityVO:"+activityVO.toString()+",stageUser:"+stageUser.toString());
        //1.入参校验
        ActivityParamCheckUtil.checkManualParam(activityVO,couponId) ;
        activityVO.setCreateUserName(stageUser.getName());
        activityVO.setCreateUserId(stageUser.getSysAccountId());
        activityVO.setCreateDate(new Date());
     try {
        //活动编号
        String activityCode = "AC" + UUID.randomUUID().toString().replaceAll("-", "");
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
         log.info("领券活动-创建活动-新增活动主表入参:"+mktActivityPOWithBLOBs);
        mktActivityPOMapper.insertSelective(mktActivityPOWithBLOBs);
        //返回主表的id
        Long mktActivityId = mktActivityPOWithBLOBs.getMktActivityId();
        log.info("领券活动-创建活动-新增活动-活动主表id"+mktActivityId);
        //新增明细表
        MktActivityManualPO mktActivityManualPO = new MktActivityManualPO();
        BeanUtils.copyProperties(activityVO, mktActivityManualPO);
        mktActivityManualPO.setMktActivityId(mktActivityId);
        // todo 券二维码

         StringBuffer stringBuffer  = new StringBuffer();
         QRCodeConfig qrCodeConfig = new QRCodeConfig();
         stringBuffer.append(qrCodeConfig.getQrcodeurl()).append(activityCode) ;
     //掉接口

        mktActivityManualPOMapper.insertSelective(mktActivityManualPO);
        //新增券表,和活动绑定
        MktCouponPO mktCouponPO = new MktCouponPO();
        mktCouponPO.setCouponId(couponId);
        mktCouponPO.setBizId(mktActivityId);//活动id
        mktCouponPO.setBizType(1);//业务类型 1.活动改为枚举，不要出现魔数
        mktCouponPO.setModifiedUserId(stageUser.getSysAccountId());
        mktCouponPO.setModifiedUserName(stageUser.getName());
        mktCouponPO.setModifiedDate(new Date());
        mktCouponPO.setCouponName(activityVO.getCouponName());
        mktCouponPO.setCouponCode(activityVO.getCouponCode());
        log.info("领券活动-创建活动-新增券表-入参:"+mktCouponPO);
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

    @Override
    public ResponseData<Integer> executeActivity(MemberInfoModel memberInfoModel, String couponCode) {
        log.info("领券活动-执行活动，入参:memberInfoModel-"+memberInfoModel+",couponCode:"+couponCode);
        ResponseData responseData = new ResponseData();
        ActivityVO activityVO = new ActivityVO();
        try {
        activityVO.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode());
        if(null==memberInfoModel||null==memberInfoModel.getBrandId()||StringUtils.isEmpty(memberInfoModel.getMemberCode())){
            log.warn("会员信息为空");
            responseData.setCode(SystemConstants.ERROR_CODE);
            responseData.setMessage(SystemConstants.ERROR_MSG_PARAM_EMPTY);
            return  responseData;
        }
        if(StringUtils.isEmpty(couponCode)){
            log.warn("领券活动-执行活动-券号为空");
            responseData.setCode(SystemConstants.ERROR_CODE);
            responseData.setMessage(SystemConstants.ERROR_MSG_PARAM_EMPTY);
            return  responseData;
        }
        activityVO.setSysBrandId(memberInfoModel.getBrandId());
        MktActivityRecordPO mktActivityRecordPO = new MktActivityRecordPO();
        mktActivityRecordPO.setMemberCode(memberInfoModel.getMemberCode());
        //查券表得到活动id
        MktCouponPO mktCouponPO = new MktCouponPO();
        mktCouponPO.setCouponCode(couponCode);
        mktCouponPO.setBizType(1);
        MktCouponPO mktCouponPO1 = mktCouponPOMapper.selectMktActivityManualId(mktCouponPO);//活动id
        if (mktCouponPO1 == null) {
            log.warn("领券活动-执行活动-查询券信息为空");
            responseData.setCode(SystemConstants.ERROR_CODE);
            responseData.setMessage(ActivityConstants.RETURN_EMPTY);
            return responseData;
        }
        //查规则
        MktActivityManualPO mktActivityManualPO = mktActivityManualPOMapper.selectByActivityId(mktCouponPO1.getBizId());
         if(null==mktActivityManualPO){
             log.warn("领券活动-执行活动-查询领券规则信息为空");
             responseData.setCode(SystemConstants.ERROR_CODE);
             responseData.setMessage(ActivityConstants.RETURN_EMPTY);
             return responseData;
         }
        mktActivityRecordPO.setAcitivityId(mktActivityManualPO.getMktActivityManualId());
        mktActivityRecordPO.setMemberCode(memberInfoModel.getMemberCode());
        //查记录
        int count = mktActivityRecordPOMapper.countByCondition(mktActivityRecordPO);
        List<MktActivityRecordPO> mktActivityRecordList = mktActivityRecordPOMapper.selectActivityRecordPOList(mktActivityRecordPO);

        ResponseData<CouponEntityPO> couponByCouponCode = couponQueryServiceFeign.findCouponByCouponCode(couponCode);
        //校验是否可领取
        activityVO.setCanReceive(true);
        if(count==0||mktActivityRecordList.isEmpty()||0==mktActivityRecordList.size()){
            log.info("领券活动-执行活动-该会员未领取该活动券");
            activityVO.setCouponEntityPO(couponByCouponCode.getData());
            responseData.setCode(SystemConstants.SUCCESS_CODE);
            responseData.setMessage(SystemConstants.SUCCESS_MESSAGE);
            responseData.setData(activityVO);
            return responseData;
        }
        if (count > mktActivityManualPO.getPerPersonMax()) {
            log.warn("领取超过最大限制");
            activityVO.setCanReceive(false);
            activityVO.setCouponEntityPO(couponByCouponCode.getData());
            responseData.setCode(SystemConstants.SUCCESS_CODE);
            responseData.setMessage(ActivityConstants.CAN_NOT_RECEIVE);
            return responseData;
        }
        int receiveCount = 0;
        for (MktActivityRecordPO recordPO : mktActivityRecordList) {
            if (recordPO.getParticipateDate().compareTo(new Date()) == 0) {
                receiveCount++;
            }
        }
        if (receiveCount > mktActivityManualPO.getPerPersonPerDayMax()) {
            log.warn("领取超过当日最大限制");
            activityVO.setCanReceive(false);
            activityVO.setCouponEntityPO(couponByCouponCode.getData());
            responseData.setCode(SystemConstants.SUCCESS_CODE);
            responseData.setMessage(ActivityConstants.CAN_NOT_RECEIVE);
            return responseData;
        }
        //todo 调券接口将会员和券绑定
        //新增记录表
        mktActivityRecordPO.setMemberCode(memberInfoModel.getMemberCode());
        mktActivityRecordPO.setAcitivityId(mktActivityManualPO.getMktActivityManualId());
        mktActivityRecordPO.setActivityType(activityVO.getActivityType());
        mktActivityRecordPO.setParticipateDate(new Date());
        mktActivityRecordPO.setCreateUserId(memberInfoModel.getCreateUserId());
        mktActivityManualPO.setCreateDate(new Date());
        mktActivityManualPO.setCreateUserName(memberInfoModel.getCreateUserName());
        mktActivityRecordPO.setModifiedUserId(memberInfoModel.getModifiedUserId());
        mktActivityRecordPO.setModifiedDate(new Date());
        mktActivityRecordPO.setModifiedUserName(memberInfoModel.getModifiedUserName());
        log.info("领券活动-执行活动-新增记录表，入参:"+mktActivityRecordPO);
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
    public ResponseData<List<ActivityBO>> getActivityManualEffect(ActivityVO vo) {
        ResponseData responseData = new ResponseData<>();
        List<MktCouponPO> mktCouponPOList = new ArrayList<>();
        try {
        //todo调券接口查询券信息
        /**
         * 入参：
         * 出参领取张数，核销张数，核销率，券收益
         */
        //查活动信息
        List<ActivityVO> activityManualEffectList = mktActivityManualPOMapper.getActivityManualEffect(vo);
        List<ActivityBO> list = new ArrayList<>();
        ActivityBO activityBO = new ActivityBO();
        for (ActivityVO activityVO : activityManualEffectList) {
            activityBO.setActivityVO(activityVO);
            list.add(activityBO);
        }
        activityBO.setCouponCodeList(mktCouponPOList);
        list.add(activityBO);
        responseData.setData(list);
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
        log.info("领券活动-查询活动详情-getActivityList入参:"+vo);
        List<ActivityVO> activityManualList = mktActivityManualPOMapper.getActivityList(vo);
        log.info("领券活动-查询活动详情-出参:"+activityManualList);
            //查询活动卷
            MktCouponPOExample example = new  MktCouponPOExample();
            example.createCriteria().andBizIdEqualTo(activityManualList.get(0).getMktActivityId());
            example.createCriteria().andValidEqualTo(true);
            List<MktCouponPO> mktCouponPOs= mktCouponPOMapper.selectByExample(example);
            //查询消息模板
            MktMessagePOExample exampl = new MktMessagePOExample();
            example.createCriteria().andBizIdEqualTo(activityManualList.get(0).getMktActivityId());
            List<MktMessagePO> listMktMessage = mktMessagePOMapper.selectByExample(exampl);
            ActivityBO bo = new ActivityBO();
            if(CollectionUtils.isEmpty(activityManualList)){
                bo.setActivityVO(activityManualList.get(0));
            }
            if(CollectionUtils.isEmpty(mktCouponPOs)){
                bo.setCouponCodeList(mktCouponPOs);
            }
            if(CollectionUtils.isEmpty(listMktMessage)){
                bo.setMessageVOList(listMktMessage);
            }
        responseData.setData(activityManualList);
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
        log.info("领券中心查询入参:"+memberInfoModel);
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
        try {
            log.info("查询活动，入参:"+activityVO);
          List<ActivityVO> activityList = mktActivityManualPOMapper.getActivityIdList(activityVO);
             log.info("查询活动，出参:"+activityList);
             if(activityList.isEmpty()&&0==activityList.size()){
                 log.warn("查询活动为空");
                 responseData.setCode(SystemConstants.SUCCESS_CODE);
                 responseData.setMessage("查询领券中心活动为空");
                 return responseData;
             }
        for (ActivityVO activityVO1 : activityList) {
            //2.查询活动对应的所有券
            MktCouponPO couponPO = new MktCouponPO();
            couponPO.setBizId(activityVO1.getMktActivityId());
            couponPO.setBizType(1);
            MktCouponPO mktCouponPO = mktCouponPOMapper.selectCouponCode(couponPO);
            if(null==mktCouponPO){
                log.warn("领券中心活动对应的券为空");
                responseData.setCode(SystemConstants.ERROR_CODE);
                responseData.setMessage("领券中心活动对应的券为空");
                return responseData;
            }
            log.info("couponQueryServiceFeign.findCouponByCouponCode--->入参为:"+mktCouponPO.getCouponCode());
            ResponseData<CouponEntityPO> couponByCouponCode = couponQueryServiceFeign.findCouponByCouponCode(mktCouponPO.getCouponCode());
           log.info("couponQueryServiceFeign.findCouponByCouponCode--->出参为:"+couponByCouponCode);
           if(couponByCouponCode.getCode()==-1){
            log.warn("couponQueryServiceFeign.findCouponByCouponCode--->出错:"+couponByCouponCode.getMessage());
               responseData.setCode(SystemConstants.ERROR_CODE);
               responseData.setMessage(couponByCouponCode.getMessage());
               return responseData;
           }else  if (null==couponByCouponCode.getData()){
               log.warn("couponQueryServiceFeign.findCouponByCouponCode--->查询为空:"+couponByCouponCode.getData());
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
           log.info("记录表中查到已领取的list:"+mktActivityRecordList);
           if(0==count||mktActivityRecordList.isEmpty()){
               log.info("该会员未领取该活动券");
               activityVO1.setCouponEntityPO(couponByCouponCode.getData());
               responseData.setCode(SystemConstants.SUCCESS_CODE);
               responseData.setMessage(SystemConstants.SUCCESS_MESSAGE);
               return responseData;
           }
            //校验今日已领取的
            int receiveCount = 0;
            for (MktActivityRecordPO recordPO : mktActivityRecordList) {
                if (recordPO.getParticipateDate().compareTo(new Date()) == 0) {
                    receiveCount++;
                }
            }
            if (receiveCount > activityVO1.getPerPersonPerDayMax()) {
                activityVO1.setCanReceive(false);
                activityVO1.setCouponEntityPO(couponByCouponCode.getData());
            }
            //校验每个人最多领取的
            if (count > activityVO1.getPerPersonMax()) {
                activityVO1.setCanReceive(false);
                activityVO1.setCouponEntityPO(couponByCouponCode.getData());
            }
            log.info("校验规则结束,activityVO1:"+activityVO1);
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
        log.info("领券中心查询出参:"+activityVOList);
        return responseData;
    }

    @Override
    public ResponseData<ActivityVO> getActivityByQrcode(MemberInfoModel memberInfoModel, String activityCode,Integer activityType) {
        ResponseData responseData = new ResponseData();
        log.info("领券活动-扫码领券-入参:"+memberInfoModel+",activityCode:"+activityCode);
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
            log.info("领券活动-扫码领券-入参activityVO:"+activityVO);
            List<ActivityVO> activityVOList1 = mktActivityManualPOMapper.getActivityIdList(activityVO);
            if (activityVOList1.isEmpty()) {
                log.warn("领券活动-查询扫码领券活动为空");
                responseData.setCode(SystemConstants.SUCCESS_CODE);
                responseData.setMessage(ActivityConstants.RETURN_EMPTY);
                return responseData;
            }
            activityVO = activityVOList1.get(0);//只有一个对象
            //2.查询活动对应的所有券
            MktCouponPO couponPO = new MktCouponPO();
            couponPO.setBizId(activityVO.getMktActivityId());
            couponPO.setBizType(1);
            log.info("领券活动-扫码领券-入参couponPO:"+couponPO);
            MktCouponPO mktCouponPO = mktCouponPOMapper.selectCouponCode(couponPO);
            log.info("couponQueryServiceFeign.findCouponByCouponCode---入参:"+mktCouponPO.getCouponCode());
            ResponseData<CouponEntityPO> couponByCouponCode = couponQueryServiceFeign.findCouponByCouponCode(mktCouponPO.getCouponCode());
           log.info("couponQueryServiceFeign.findCouponByCouponCode---出参:"+couponByCouponCode);
            //3.校验是否满足规则
            MktActivityRecordPO mktActivityRecordPO = new MktActivityRecordPO();
            mktActivityRecordPO.setMemberCode(memberInfoModel.getMemberCode());
            mktActivityRecordPO.setAcitivityId(activityVO.getMktActivityManualId());
            mktActivityRecordPO.setActivityType(activityType);
            int count = mktActivityRecordPOMapper.countByCondition(mktActivityRecordPO);
            log.info("记录中查到的已领取数量:"+count);
            List<MktActivityRecordPO> mktActivityRecordList = mktActivityRecordPOMapper.selectActivityRecordPOList(mktActivityRecordPO);
            log.info("记录表中查到已领取的list:"+mktActivityRecordList);
            activityVO.setCanReceive(true);
            if(0==count||mktActivityRecordList.isEmpty()){
                log.info("该会员未领取该活动券");
                activityVO.setCouponEntityPO(couponByCouponCode.getData());
                responseData.setCode(SystemConstants.SUCCESS_CODE);
                responseData.setMessage(SystemConstants.SUCCESS_MESSAGE);
                return responseData;
            }
            //校验今日已领取的
            int receiveCount = 0;
            for (MktActivityRecordPO recordPO : mktActivityRecordList) {
                if (recordPO.getParticipateDate().compareTo(new Date()) == 0) {
                    receiveCount++;
                }
            }
            if (receiveCount > activityVO.getPerPersonPerDayMax()) {
                activityVO.setCanReceive(false);
                activityVO.setCouponEntityPO(couponByCouponCode.getData());
            }
            //校验每个人最多领取的
            if (count > activityVO.getPerPersonMax()) {
                activityVO.setCanReceive(false);
                activityVO.setCouponEntityPO(couponByCouponCode.getData());
            }
            log.info("校验规则结束,activityVO1:"+activityVO);
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
}
