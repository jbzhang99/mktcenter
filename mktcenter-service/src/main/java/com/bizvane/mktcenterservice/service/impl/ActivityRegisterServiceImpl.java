package com.bizvane.mktcenterservice.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.bizvane.centerstageservice.models.po.SysCheckPo;
import com.bizvane.centerstageservice.models.po.SysStorePo;
import com.bizvane.centerstageservice.models.vo.SysCheckConfigVo;
import com.bizvane.centerstageservice.rpc.StoreServiceRpc;
import com.bizvane.centerstageservice.rpc.SysCheckConfigServiceRpc;
import com.bizvane.centerstageservice.rpc.SysCheckServiceRpc;
import com.bizvane.couponfacade.enums.SendTypeEnum;
import com.bizvane.couponfacade.interfaces.CouponQueryServiceFeign;
import com.bizvane.couponfacade.models.vo.CouponDetailResponseVO;
import com.bizvane.couponfacade.models.vo.SendCouponSimpleRequestVO;
import com.bizvane.members.facade.enums.IntegralChangeTypeEnum;
import com.bizvane.members.facade.es.vo.MembersInfoSearchVo;
import com.bizvane.members.facade.es.vo.WxChannelInfoSearchVo;
import com.bizvane.members.facade.service.api.WxChannelInfoAdvancedSearchApiService;
import com.bizvane.members.facade.service.card.request.IntegralChangeRequestModel;
import com.bizvane.mktcenterfacade.interfaces.ActivityRegisterService;
import com.bizvane.mktcenterfacade.models.bo.ActivityBO;
import com.bizvane.mktcenterfacade.models.bo.AwardBO;
import com.bizvane.mktcenterfacade.models.po.MktActivityCountPO;
import com.bizvane.mktcenterfacade.models.po.MktActivityPOWithBLOBs;
import com.bizvane.mktcenterfacade.models.po.MktActivityRecordPO;
import com.bizvane.mktcenterfacade.models.po.MktActivityRegisterPO;
import com.bizvane.mktcenterfacade.models.po.MktCouponPO;
import com.bizvane.mktcenterfacade.models.po.MktCouponPOExample;
import com.bizvane.mktcenterfacade.models.po.MktMessagePO;
import com.bizvane.mktcenterfacade.models.po.MktMessagePOExample;
import com.bizvane.mktcenterfacade.models.vo.ActivityVO;
import com.bizvane.mktcenterfacade.models.vo.MemberInfoModelVOActivity;
import com.bizvane.mktcenterfacade.models.vo.PageForm;
import com.bizvane.mktcenterservice.common.award.Award;
import com.bizvane.mktcenterservice.common.award.MemberMessageSend;
import com.bizvane.mktcenterservice.common.enums.ActivityStatusEnum;
import com.bizvane.mktcenterservice.common.enums.ActivityTypeEnum;
import com.bizvane.mktcenterservice.common.enums.BusinessTypeEnum;
import com.bizvane.mktcenterservice.common.enums.CheckStatusEnum;
import com.bizvane.mktcenterservice.common.enums.MktSmartTypeEnum;
import com.bizvane.mktcenterservice.common.job.JobUtil;
import com.bizvane.mktcenterservice.common.utils.CodeUtil;
import com.bizvane.mktcenterservice.common.utils.ExecuteParamCheckUtil;
import com.bizvane.mktcenterservice.mappers.MktActivityCountPOMapper;
import com.bizvane.mktcenterservice.mappers.MktActivityPOMapper;
import com.bizvane.mktcenterservice.mappers.MktActivityRecordPOMapper;
import com.bizvane.mktcenterservice.mappers.MktActivityRegisterPOMapper;
import com.bizvane.mktcenterservice.mappers.MktCouponPOMapper;
import com.bizvane.mktcenterservice.mappers.MktMessagePOMapper;
import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.jobutils.JobClient;
import com.bizvane.utils.jobutils.XxlJobInfo;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import lombok.extern.slf4j.Slf4j;

/**
 * @author chen.li
 * @date on 2018/7/13 15:10
 * @description 开卡活动
 *
 */
@Service
@Slf4j
public class ActivityRegisterServiceImpl implements ActivityRegisterService {

    @Autowired
    private MktActivityRegisterPOMapper mktActivityRegisterPOMapper;

    @Autowired
    private MktActivityPOMapper mktActivityPOMapper;

    @Autowired
    private MktCouponPOMapper mktCouponPOMapper;

    @Autowired
    private MktMessagePOMapper mktMessagePOMapper;

    @Autowired
    private JobUtil jobUtil;

    @Autowired
    private JobClient jobClient;

    @Autowired
    private CouponQueryServiceFeign couponQueryServiceFeign;
    @Autowired
    private Award award;
    @Autowired
    private MktActivityRecordPOMapper mktActivityRecordPOMapper;
    @Autowired
    private MemberMessageSend memberMessage;
    @Autowired
    private WxChannelInfoAdvancedSearchApiService wxChannelInfoAdvancedSearchApiServic;
    @Autowired
    private StoreServiceRpc storeServiceRpc;
    
    @Autowired
    private MktActivityCountPOMapper mktActivityCountPOMapper;
    
    /**
     * 查询活动列表
     * @param vo
     * @param pageForm
     * @return
     */
    @Override
    public ResponseData<ActivityVO> getActivityList(ActivityVO vo,PageForm pageForm,SysAccountPO stageUser) {
        ResponseData responseData = new ResponseData();
        PageHelper.startPage(pageForm.getPageNumber(),pageForm.getPageSize());
        List<ActivityVO> activityRegisterList = new ArrayList<>();
        vo.setSysBrandId(stageUser.getBrandId());
        vo.setActivityType(ActivityTypeEnum.ACTIVITY_TYPE_REGISGER.getCode());
        try{
            log.info("开卡活动列表开始，参数="+vo);
            activityRegisterList = mktActivityRegisterPOMapper.getActivityList(vo);
        }catch (Exception e){
            log.error("开卡活动查询活动列表出错." + e.getMessage());
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(e.getMessage());
        }
        PageInfo<ActivityVO> pageInfo = new PageInfo<>(activityRegisterList);
        responseData.setData(pageInfo);
        return responseData;
    }

    /**
     * 创建活动
     * @param bo
     * @return
     */
    @Override
    @Transactional
    public ResponseData<Integer> addActivity(ActivityBO bo,SysAccountPO stageUser) {
        log.info("开卡活动-创建活动-入参:"+bo);
        //返回对象
        ResponseData responseData = new ResponseData();
        //得到大实体类
        ActivityVO activityVO = bo.getActivityVO();
        //判断是否是全部等级
        if (activityVO.getMbrLevelCode().equals("0")){
            activityVO.setMbrLevelName("全部等级");
        }
        //判断活动开始时间是否大于当前时间
        if(1 != bo.getActivityVO().getLongTerm() && new Date().after(activityVO.getStartTime())){
            responseData.setCode(SysResponseEnum.MODEL_FAILED_VALIDATION.getCode());
            responseData.setMessage("活动开始时间不能比当前时间小!");
            return responseData;
        }
        //工具类生成活动编码
        String activityCode = CodeUtil.getActivityCode();
        activityVO.setActivityCode(activityCode);
        //增加活动类型是开卡活动
        activityVO.setActivityType(ActivityTypeEnum.ACTIVITY_TYPE_REGISGER.getCode());
        //增加品牌id
        log.info("获取的品牌id是="+stageUser.getBrandId());
        if(null==stageUser.getBrandId()){
            log.error("token没有获取到品牌id");
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage("Token没有获取到品牌id!");
            return responseData;
        }
        activityVO.setSysCompanyId(stageUser.getSysCompanyId());
        activityVO.setSysBrandId(stageUser.getBrandId());
        MktActivityPOWithBLOBs mktActivityPOWithBLOBs = new MktActivityPOWithBLOBs();
        BeanUtils.copyProperties(activityVO,mktActivityPOWithBLOBs);
        //活动状态设置为待执行
        mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_PENDING.getCode());
        /*try{*/
        //查询判断长期活动同一会员等级是否有重复
        if(1 == bo.getActivityVO().getLongTerm()){
            ActivityVO vo = new ActivityVO();
            vo.setMbrLevelCode(bo.getActivityVO().getMbrLevelCode());
            vo.setLongTerm(bo.getActivityVO().getLongTerm());
            vo.setSysBrandId(activityVO.getSysBrandId());
            vo.setActivityType(ActivityTypeEnum.ACTIVITY_TYPE_REGISGER.getCode());
            //判断过滤禁用状态
            vo.setStop("true");
            List<ActivityVO> registerList = mktActivityRegisterPOMapper.getActivityList(vo);
            if(!CollectionUtils.isEmpty(registerList)){
                for (ActivityVO activity:registerList) {
                    //判断适用商品
                    if (false==activity.getIsStoreLimit() ||!ExecuteParamCheckUtil.addActivitCheck(bo,activity)){
                         responseData.setCode(SysResponseEnum.FAILED.getCode());
                         responseData.setMessage("已存在同一类型的长期活动!");
                         return responseData;
                    }
                }

            }

        }

        //查询结果如果不需要审核审核状态为已审核
        mktActivityPOWithBLOBs.setCheckStatus(CheckStatusEnum.CHECK_STATUS_APPROVED.getCode());
        //getStartTime 开始时间>当前时间增加job
        if(1!= bo.getActivityVO().getLongTerm() && new Date().before(activityVO.getStartTime())){
            //活动状态设置为待执行
            mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_PENDING.getCode());
            //创建任务调度任务开始时间
            jobUtil.addJob(stageUser,activityVO,activityCode);
            //创建任务调度任务结束时间
            jobUtil.addJobEndTime(stageUser,activityVO,activityCode);
        }else{
            //活动状态设置为执行中
            mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode());

        }
        //新增活动主表
        mktActivityPOWithBLOBs.setCreateDate(new Date());
        mktActivityPOWithBLOBs.setCreateUserId(stageUser.getSysAccountId());
        mktActivityPOWithBLOBs.setCreateUserName(stageUser.getName());
        log.info("领券活动-创建活动-新增活动主表入参:"+ JSON.toJSONString(mktActivityPOWithBLOBs));
        mktActivityPOMapper.insertSelective(mktActivityPOWithBLOBs);
        log.info("开卡活动-创建主表活动-成功");
        //获取新增后数据id
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

        //新增开卡活动表
        MktActivityRegisterPO mktActivityRegisterPO = new MktActivityRegisterPO();
        BeanUtils.copyProperties(mktActivityPOWithBLOBs,mktActivityRegisterPO);
        mktActivityRegisterPO.setMktActivityId(mktActivityId);
        mktActivityRegisterPO.setMbrLevelCode(activityVO.getMbrLevelCode());
        mktActivityRegisterPO.setMbrLevelName(activityVO.getMbrLevelName());
        mktActivityRegisterPO.setIsStoreLimit(activityVO.getStoreLimit());
        mktActivityRegisterPO.setOfflineCardStatus(activityVO.getOfflineCardStatus());
        if (true==activityVO.getStoreLimit()){
                mktActivityRegisterPO.setStoreLimitList(activityVO.getStoreLimitList());
                mktActivityRegisterPO.setStoreLimitType(activityVO.getStoreLimitType());
            }
        log.info("领券活动-创建活动-新增开卡活动表入参:"+ JSON.toJSONString(mktActivityRegisterPO));
        mktActivityRegisterPOMapper.insertSelective(mktActivityRegisterPO);
        log.info("开卡活动-创建开卡活动表活动-成功");
        //新增券奖励
        List<MktCouponPO> couponCodeList = bo.getCouponCodeList();
        if(!CollectionUtils.isEmpty(couponCodeList)){
            for(MktCouponPO couponCode : couponCodeList){
                MktCouponPO mktCouponPO = new MktCouponPO();
                BeanUtils.copyProperties(mktActivityPOWithBLOBs,mktCouponPO);
                mktCouponPO.setBizType(BusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode());
                mktCouponPO.setBizId(mktActivityId);
                mktCouponPO.setCouponName(couponCode.getCouponName());
                mktCouponPO.setCouponDefinitionId(couponCode.getCouponDefinitionId());
                mktCouponPOMapper.insertSelective(mktCouponPO);
            }
        }

        //新增活动消息
        List<MktMessagePO> messageVOList = bo.getMessageVOList();
        if(!CollectionUtils.isEmpty(messageVOList)){
            for(MktMessagePO messageVO : messageVOList){
                MktMessagePO mktMessagePO = new MktMessagePO();
                BeanUtils.copyProperties(mktActivityPOWithBLOBs,mktMessagePO);
                BeanUtils.copyProperties(messageVO,mktMessagePO);
                mktMessagePO.setBizType(BusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode());
                mktMessagePO.setBizId(mktActivityId);
                mktMessagePO.setSendImmediately(activityVO.getSendImmediately());
                mktMessagePO.setSendTime(activityVO.getSendTime());
                mktMessagePOMapper.insertSelective(mktMessagePO);
            }
        }
        //判断信息类是否为空
       if(!CollectionUtils.isEmpty(messageVOList) ){
            //如果是立即发送 则发送短息
            if(true==activityVO.getSendImmediately()){
                //分页查询会员信息发送短信
                MembersInfoSearchVo membersInfoSearchVo = new MembersInfoSearchVo();
                membersInfoSearchVo.setPageNumber(1);
                membersInfoSearchVo.setPageSize(10000);
                membersInfoSearchVo.setCardStatus(2);
                membersInfoSearchVo.setBrandId(activityVO.getSysBrandId());
                membersInfoSearchVo.setSysCompanyId(activityVO.getSysCompanyId());
                log.info("开卡活动-查询发送短信高级搜索参数+=====："+JSON.toJSONString(membersInfoSearchVo));
                memberMessage.sendDXmessage(messageVOList, membersInfoSearchVo);
                //查询对应的会员  发送微信模板消息
                WxChannelInfoSearchVo wxChannelInfoSearchVo = new WxChannelInfoSearchVo();
                wxChannelInfoSearchVo.setPageNum(1);
                wxChannelInfoSearchVo.setPageSize(10000);
                wxChannelInfoSearchVo.setFocus(2);
                wxChannelInfoSearchVo.setCardStatus(1);
                wxChannelInfoSearchVo.setMiniProgram((byte) 1);
                wxChannelInfoSearchVo.setBrandId(activityVO.getSysBrandId());
                log.info("开卡活动-查询发送微信模板高级搜索参数+=====："+JSON.toJSONString(wxChannelInfoSearchVo));
                memberMessage.sendWXmessage(messageVOList, wxChannelInfoSearchVo,activityVO);
            }else{
                //自定义时间发送 加人job任务
                jobUtil.addSendMessageJob(stageUser,activityVO,activityCode);
            }


        }

        //结束
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        log.info("开卡活动-创建活动-成功");
        return responseData;
    }


    /**
     * 执行活动
     * @param vo
     * @return
     */
    @Async
    @Override
    @Transactional
    public void executeRegisterActivity(MemberInfoModelVOActivity vo) {
        log.info("开卡活动-开卡活动入参："+JSON.toJSONString(vo));
        //返回对象
        ResponseData responseData = new ResponseData();
        //查询品牌下所有执行中的活动
        ActivityVO activity = new ActivityVO();
        activity.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode());
        activity.setSysBrandId(vo.getBrandId());
        activity.setActivityType(ActivityTypeEnum.ACTIVITY_TYPE_REGISGER.getCode());
        log.info("开卡活动-查询品牌下说有执行中的活动参数："+JSON.toJSONString(activity));
        List<ActivityVO> registerList = mktActivityRegisterPOMapper.getActivityList(activity);
        for (ActivityVO activityVO:registerList) {
            //增加积分奖励新增接口
            if(null!=activityVO.getPoints()){
                AwardBO bo = new AwardBO();
                //用这个实体类
                IntegralChangeRequestModel integralChangeRequestModel =new IntegralChangeRequestModel();
                integralChangeRequestModel.setSysCompanyId(activityVO.getSysCompanyId());
                integralChangeRequestModel.setBrandId(activityVO.getSysBrandId());
                integralChangeRequestModel.setMemberCode(vo.getMemberCode());
                integralChangeRequestModel.setChangeBills(activityVO.getActivityCode());
                integralChangeRequestModel.setChangeIntegral(activityVO.getPoints());
                integralChangeRequestModel.setChangeType(IntegralChangeTypeEnum.INCOME.getCode());
                integralChangeRequestModel.setBusinessType(com.bizvane.members.facade.enums.BusinessTypeEnum.ACTIVITY_TYPE_REGISGER.getCode());
                integralChangeRequestModel.setChangeDate(new Date());
                bo.setIntegralRecordModel(integralChangeRequestModel);
                bo.setMktType(MktSmartTypeEnum.SMART_TYPE_INTEGRAL.getCode());
                log.info("开卡活动-开卡活动送积分");
                award.execute(bo);
            }
            // 增加券奖励接口
            MktCouponPOExample example = new  MktCouponPOExample();
            example.createCriteria().andBizIdEqualTo(activityVO.getMktActivityId()).andValidEqualTo(true).andBizTypeEqualTo(1);;
            List<MktCouponPO> mktCouponPOs= mktCouponPOMapper.selectByExample(example);
            for (MktCouponPO mktCouponPO:mktCouponPOs) {
                AwardBO awardBO = new AwardBO();
                SendCouponSimpleRequestVO sendCouponSimpleRequestVO = new SendCouponSimpleRequestVO();
                sendCouponSimpleRequestVO.setMemberCode(vo.getMemberCode());
                sendCouponSimpleRequestVO.setCouponDefinitionId(mktCouponPO.getCouponDefinitionId());
                sendCouponSimpleRequestVO.setSendBussienId(mktCouponPO.getBizId());
                sendCouponSimpleRequestVO.setSendType(SendTypeEnum.SEND_COUPON_OPNE_CARD.getCode());
                sendCouponSimpleRequestVO.setCompanyId(vo.getSysCompanyId());
                sendCouponSimpleRequestVO.setBrandId(vo.getBrandId());
                sendCouponSimpleRequestVO.setBusinessName(activityVO.getActivityName());
                awardBO.setSendCouponSimpleRequestVO(sendCouponSimpleRequestVO);
                awardBO.setMktType(MktSmartTypeEnum.SMART_TYPE_COUPON.getCode());
                log.info("开卡活动-开卡活动送券");
                award.execute(awardBO);
            }
            //新增积分到会员参与活动记录表中数据
            MktActivityRecordPO po = new MktActivityRecordPO();
            po.setActivityType(ActivityTypeEnum.ACTIVITY_TYPE_REGISGER.getCode());
            po.setMemberCode(vo.getMemberCode());
            po.setParticipateDate(new Date());
            int points = 0;
            if(null!=activityVO.getPoints()){
                points = activityVO.getPoints();
                po.setPoints(points);
            }
            po.setAcitivityId(activityVO.getMktActivityId());
            po.setSysCompanyId(activityVO.getSysCompanyId());
            po.setSysBrandId(activityVO.getSysBrandId());
            log.info("新增积分记录表");
            mktActivityRecordPOMapper.insertSelective(po);

            mktActivityCountPOMapper.updateSum(po.getAcitivityId(), 1, BigDecimal.ZERO, points);
        }
        log.info("执行活动成功！");
    }

    /**
     * 修改活动
     * @param bo
     * @param stageUser
     * @return
     */
    @Override
    @Transactional
    public ResponseData<Integer> updateActivityRegister(ActivityBO bo, SysAccountPO stageUser) {
        log.info("修改活动开始！");
        //返回对象
        ResponseData responseData = new ResponseData();
        //得到大实体类
        ActivityVO activityVO = bo.getActivityVO();
        if(activityVO.getCheckStatus()!=CheckStatusEnum.CHECK_STATUS_PENDING.getCode()||activityVO.getCheckStatus()!=CheckStatusEnum.CHECK_STATUS_REJECTED.getCode()){
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage("该任务不能修改!");
            return responseData;
        }
        MktActivityPOWithBLOBs mktActivityPOWithBLOBs = new MktActivityPOWithBLOBs();
        BeanUtils.copyProperties(activityVO,mktActivityPOWithBLOBs);
        //job类
        XxlJobInfo xxlJobInfo = new XxlJobInfo();
        xxlJobInfo.setExecutorParam(activityVO.getActivityCode());
        xxlJobInfo.setBizType(BusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode());

        //查询结果如果不需要审核审核状态为已审核
        mktActivityPOWithBLOBs.setCheckStatus(CheckStatusEnum.CHECK_STATUS_APPROVED.getCode());
        //getStartTime 开始时间>当前时间增加job
        if(1 != bo.getActivityVO().getLongTerm() && new Date().before(activityVO.getStartTime())){
            //活动状态设置为待执行
            mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_PENDING.getCode());
            //先删除原来创建的job任务
            jobClient.removeByBiz(xxlJobInfo);
            //创建任务调度任务开始时间
            jobUtil.addJob(stageUser,activityVO,mktActivityPOWithBLOBs.getActivityCode());
            //创建任务调度任务结束时间
            jobUtil.addJobEndTime(stageUser,activityVO,mktActivityPOWithBLOBs.getActivityCode());
        }else{
            //活动状态设置为执行中
            mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode());
        }
        //修改活动主表
        mktActivityPOWithBLOBs.setModifiedDate(new Date());
        mktActivityPOWithBLOBs.setModifiedUserId(stageUser.getSysAccountId());
        mktActivityPOWithBLOBs.setModifiedUserName(stageUser.getName());
        log.info("开卡活动修改-修改开卡活动主表的参数："+JSON.toJSONString(mktActivityPOWithBLOBs));
        mktActivityPOMapper.updateByPrimaryKeySelective(mktActivityPOWithBLOBs);
        log.info("修改开卡活动成功");
        //获取活动数据id
        Long mktActivityId = mktActivityPOWithBLOBs.getMktActivityId();

        //修改开卡活动表
        MktActivityRegisterPO mktActivityRegisterPO = new MktActivityRegisterPO();
        BeanUtils.copyProperties(mktActivityPOWithBLOBs,mktActivityRegisterPO);
        mktActivityRegisterPO.setMktActivityId(mktActivityId);
        log.info("开卡活动修改-修改开卡活动表的参数："+JSON.toJSONString(mktActivityRegisterPO));
        mktActivityRegisterPOMapper.updateByPrimaryKeySelective(mktActivityRegisterPO);
        log.info("修改开卡活动表成功");

        //先删除在新增
        MktCouponPO record = new MktCouponPO();
        record.setValid(false);
        MktCouponPOExample example = new MktCouponPOExample();
        example.createCriteria().andBizIdEqualTo(mktActivityId);
        mktCouponPOMapper.updateByExampleSelective(record,example);
        //修改券奖励
        List<MktCouponPO> couponCodeList = bo.getCouponCodeList();
        if(!CollectionUtils.isEmpty(couponCodeList)){
            for(MktCouponPO couponCode : couponCodeList){
                MktCouponPO mktCouponPO = new MktCouponPO();
                BeanUtils.copyProperties(mktActivityPOWithBLOBs,mktCouponPO);
                mktCouponPO.setBizType(BusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode());
                mktCouponPO.setBizId(mktActivityId);
                mktCouponPO.setCouponName(couponCode.getCouponName());
                mktCouponPO.setCouponDefinitionId(couponCode.getCouponDefinitionId());
                mktCouponPO.setBizId(couponCode.getBizId());
                mktCouponPOMapper.insertSelective(mktCouponPO);
            }
        }


        //先删除在新增
        MktMessagePO message = new MktMessagePO();
        message.setValid(false);
        MktMessagePOExample exam = new MktMessagePOExample();
        exam.createCriteria().andBizIdEqualTo(mktActivityId);
        mktMessagePOMapper.updateByExampleSelective(message,exam);
        //修改活动消息
        List<MktMessagePO> messageVOList = bo.getMessageVOList();
        if(!CollectionUtils.isEmpty(messageVOList)){
            for(MktMessagePO messageVO : messageVOList){
                MktMessagePO mktMessagePO = new MktMessagePO();
                BeanUtils.copyProperties(mktActivityPOWithBLOBs,mktMessagePO);
                BeanUtils.copyProperties(messageVO,mktMessagePO);
                mktMessagePO.setBizType(BusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode());
                mktMessagePO.setBizId(mktActivityId);
                mktMessagePOMapper.insertSelective(mktMessagePO);
            }
        }
        //如果执行状态为执行中 就要发送消息
        if(mktActivityPOWithBLOBs.getActivityStatus()==ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode()){
            //分页查询会员信息发送短信
            MembersInfoSearchVo membersInfoSearchVo = new MembersInfoSearchVo();
            membersInfoSearchVo.setPageNumber(1);
            membersInfoSearchVo.setPageSize(10000);
            membersInfoSearchVo.setCardStatus(1);
            membersInfoSearchVo.setBrandId(activityVO.getSysBrandId());
            memberMessage.getMemberList(messageVOList, membersInfoSearchVo,activityVO);
            //查询对应的会员   发送微信模板消息
        }
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        return responseData;
    }

    /**
     *  查询活动详情
     * @param businessCode
     * @return
     */
    @Override
    public ResponseData<ActivityBO> selectActivityRegisterById(String businessCode) {
        ActivityBO bo = new ActivityBO();
        log.info("查询开卡活动详情="+businessCode);
        ResponseData responseData = new ResponseData();
        ActivityVO vo= new ActivityVO();
        vo.setActivityCode(businessCode);
        vo.setActivityType(ActivityTypeEnum.ACTIVITY_TYPE_REGISGER.getCode());
        List<ActivityVO> registerList = mktActivityRegisterPOMapper.getActivityList(vo);
        if(CollectionUtils.isEmpty(registerList)){
            responseData.setCode(SysResponseEnum.OPERATE_FAILED_DATA_NOT_EXISTS.getCode());
            responseData.setMessage(SysResponseEnum.OPERATE_FAILED_DATA_NOT_EXISTS.getMessage());
            return responseData;
        }
        if(!CollectionUtils.isEmpty(registerList)){
            bo.setActivityVO(registerList.get(0));
            if (!StringUtils.isEmpty(registerList.get(0).getStoreLimitList())){
                String ids =registerList.get(0).getStoreLimitList();
                //查询适用门店
                List<Long> listIds = Arrays.asList(ids.split(",")).stream().map(s -> Long.parseLong(s.trim())).collect(Collectors.toList());
                ResponseData<List<SysStorePo>> sysStorePOs = storeServiceRpc.getIdStoreLists(listIds);

                if(!CollectionUtils.isEmpty(sysStorePOs.getData())){
                    bo.getActivityVO().setSysStorePos(sysStorePOs.getData());
                }
            }
        }


        //查询活动卷
        MktCouponPOExample example = new  MktCouponPOExample();
        example.createCriteria().andBizIdEqualTo(registerList.get(0).getMktActivityId()).andValidEqualTo(true).andBizTypeEqualTo(1);
        List<MktCouponPO> mktCouponPOs= mktCouponPOMapper.selectByExample(example);
        List<CouponDetailResponseVO> lists = new ArrayList<>();
            //查询券接口
            if(!CollectionUtils.isEmpty(mktCouponPOs)){
                for (MktCouponPO po:mktCouponPOs) {
                    ResponseData<CouponDetailResponseVO>  entityAndDefinition = couponQueryServiceFeign.getCouponDefinition(po.getCouponDefinitionId());
                    lists.add(entityAndDefinition.getData());
                }
            }


        //查询消息模板
        MktMessagePOExample exampl = new MktMessagePOExample();
        exampl.createCriteria().andBizIdEqualTo(registerList.get(0).getMktActivityId()).andValidEqualTo(true);
        List<MktMessagePO> listMktMessage = mktMessagePOMapper.selectByExampleWithBLOBs(exampl);

        if(!CollectionUtils.isEmpty(listMktMessage)){
            bo.setMessageVOList(listMktMessage);
        }
            bo.setCouponEntityAndDefinitionVOList(lists);
        responseData.setData(bo);
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        return responseData;
    }
}
