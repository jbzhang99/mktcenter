package com.bizvane.mktcenterservice.service.impl;

import com.alibaba.fastjson.JSON;
import com.bizvane.centerstageservice.models.po.SysCheckPo;
import com.bizvane.centerstageservice.models.po.SysStorePo;
import com.bizvane.centerstageservice.models.vo.SysCheckConfigVo;
import com.bizvane.centerstageservice.rpc.StoreServiceRpc;
import com.bizvane.centerstageservice.rpc.SysCheckConfigServiceRpc;
import com.bizvane.centerstageservice.rpc.SysCheckServiceRpc;
import com.bizvane.couponfacade.enums.SendTypeEnum;
import com.bizvane.couponfacade.interfaces.CouponQueryServiceFeign;
import com.bizvane.couponfacade.interfaces.SendCouponServiceFeign;
import com.bizvane.couponfacade.models.vo.CouponDetailResponseVO;
import com.bizvane.couponfacade.models.vo.SendCouponSimpleRequestVO;
import com.bizvane.members.facade.enums.*;
import com.bizvane.members.facade.es.vo.MembersInfoSearchVo;
import com.bizvane.members.facade.models.MbrLevelModel;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.members.facade.service.api.IntegralRecordApiService;
import com.bizvane.members.facade.service.api.MemberInfoApiService;
import com.bizvane.members.facade.service.api.MemberLevelApiService;
import com.bizvane.members.facade.service.card.request.IntegralChangeRequestModel;
import com.bizvane.mktcenterfacade.interfaces.ActivityUpgradeService;
import com.bizvane.mktcenterfacade.models.bo.ActivityBO;
import com.bizvane.mktcenterfacade.models.bo.AwardBO;
import com.bizvane.mktcenterfacade.models.po.*;
import com.bizvane.mktcenterservice.common.enums.*;
import com.bizvane.mktcenterservice.common.enums.BusinessTypeEnum;
import com.bizvane.mktcenterservice.mappers.*;

import com.bizvane.mktcenterfacade.models.vo.ActivityVO;
import com.bizvane.mktcenterfacade.models.vo.PageForm;
import com.bizvane.mktcenterservice.common.award.Award;
import com.bizvane.mktcenterservice.common.award.MemberMessageSend;

import com.bizvane.mktcenterservice.common.utils.CodeUtil;
import com.bizvane.mktcenterservice.common.job.JobUtil;
import com.bizvane.mktcenterservice.common.utils.ExecuteParamCheckUtil;

import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.jobutils.JobClient;
import com.bizvane.utils.jobutils.XxlJobInfo;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chen.li
 * @date on 2018/7/13 18:54
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@Service
@Slf4j
public class ActivityUpgradeServiceImpl implements ActivityUpgradeService {

    @Autowired
    private MktActivityUpgradePOMapper mktActivityUpgradePOMapper;
    @Autowired
    private MktActivityPOMapper mktActivityPOMapper;
    @Autowired
    private MktCouponPOMapper mktCouponPOMapper;
    @Autowired
    private MktMessagePOMapper mktMessagePOMapper;
    @Autowired
    private JobUtil jobUtil;
    @Autowired
    private SysCheckConfigServiceRpc sysCheckConfigServiceRpc;
    @Autowired
    private IntegralRecordApiService integralRecordApiService;
    @Autowired
    private SendCouponServiceFeign sendCouponServiceFeign;
    @Autowired
    private SysCheckServiceRpc sysCheckServiceRpc;
    @Autowired
    private CouponQueryServiceFeign couponQueryServiceFeign;
    @Autowired
    private Award award;
    @Autowired
    private JobClient jobClient;
    @Autowired
    private MktActivityRecordPOMapper mktActivityRecordPOMapper;
    @Autowired
    private MemberInfoApiService memberInfoApiService;
    @Autowired
    private MemberLevelApiService memberLevelApiService;
    @Autowired
    private MemberMessageSend memberMessage;
    @Autowired
    private StoreServiceRpc storeServiceRpc;
    
    @Autowired
    private MktActivityCountPOMapper mktActivityCountPOMapper;
    
    /**
     * 查询升级活动列表
     * @param vo
     * @param pageForm
     * @return
     */
    @Override
    public ResponseData<ActivityVO> getActivityUpgradeList(ActivityVO vo, PageForm pageForm,SysAccountPO stageUser) {
        log.info("查询升级活动列表");
        ResponseData responseData = new ResponseData();
        PageHelper.startPage(pageForm.getPageNumber(),pageForm.getPageSize());
        vo.setSysBrandId(stageUser.getBrandId());
        List<ActivityVO> activityUpgradeList = mktActivityUpgradePOMapper.getActivityUpgradeList(vo);
        PageInfo<ActivityVO> pageInfo = new PageInfo<>(activityUpgradeList);
        responseData.setData(pageInfo);
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        return responseData;
    }

    /**
     * 创建活动
     * @param bo
     * @param stageUser
     * @return
     */
    @Override
    @Transactional
    public ResponseData<Integer> addActivityUpgrade(ActivityBO bo, SysAccountPO stageUser) {
        log.info("创建升级活动开始");
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
        //增加活动类型是升级活动
        activityVO.setActivityType(ActivityTypeEnum.ACTIVITY_TYPE_UPGRADE.getCode());
        //增加品牌id
        log.info("获取的品牌id是="+stageUser.getBrandId());
        if(null==stageUser.getBrandId()){
            log.error("token没有获取到品牌id");
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage("Token没有获取到品牌id!");
            return responseData;
        }
        activityVO.setSysBrandId(stageUser.getBrandId());
        activityVO.setSysCompanyId(stageUser.getSysCompanyId());
        MktActivityPOWithBLOBs mktActivityPOWithBLOBs = new MktActivityPOWithBLOBs();
        BeanUtils.copyProperties(activityVO,mktActivityPOWithBLOBs);
        //查询判断长期活动同一会员等级是否有重复
       if(1 == bo.getActivityVO().getLongTerm()){
            ActivityVO vo = new ActivityVO();
            vo.setMbrLevelCode(bo.getActivityVO().getMbrLevelCode());
            vo.setLongTerm(bo.getActivityVO().getLongTerm());
            vo.setSysBrandId(activityVO.getSysBrandId());
            vo.setActivityType(ActivityTypeEnum.ACTIVITY_TYPE_UPGRADE.getCode());
           //判断过滤禁用状态
           vo.setStop("ture");
            List<ActivityVO> activityUpgradeList = mktActivityUpgradePOMapper.getActivityUpgradeList(vo);
           if(!CollectionUtils.isEmpty(activityUpgradeList)){
               for (ActivityVO activity:activityUpgradeList) {
                   //判断适用商品
                   if (false==activity.getIsStoreLimit() ||!ExecuteParamCheckUtil.addActivitCheck(bo,activity)){
                       responseData.setCode(SysResponseEnum.FAILED.getCode());
                       responseData.setMessage("已存在同一类型的长期活动!");
                       return responseData;
                   }
               }

           }
        }


        //查询审核配置，是否需要审核然后判断
        /*SysCheckConfigVo so = new SysCheckConfigVo();
        so.setSysBrandId(activityVO.getSysBrandId());*/
        ResponseData<List<SysCheckConfigVo>> sysCheckConfigVo =sysCheckConfigServiceRpc.getCheckConfigListAll(activityVO.getSysBrandId());
        List<SysCheckConfigVo> sysCheckConfigVoList = sysCheckConfigVo.getData();
        //判断是否有审核配置
        int i = 0;
        if(!CollectionUtils.isEmpty(sysCheckConfigVoList)){
            for (SysCheckConfigVo sysCheckConfig:sysCheckConfigVoList) {
                //判断是否需要审核  暂时先写这三个审核类型 后期确定下来写成枚举类
                if(sysCheckConfig.getFunctionCode().equals("C0001") || sysCheckConfig.getFunctionCode().equals("C0002") || sysCheckConfig.getFunctionCode().equals("C0003")){
                    i+=1;
                }
            }
        }

        if(i>0){
            //查询结果如果需要审核审核状态为待审核
            mktActivityPOWithBLOBs.setCheckStatus(CheckStatusEnum.CHECK_STATUS_PENDING.getCode());
            //活动状态设置为待执行
            mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_PENDING.getCode());

            //getStartTime 开始时间>当前时间增加job
            if(1 != bo.getActivityVO().getLongTerm() && new Date().before(activityVO.getStartTime())){
                log.info("新增job任务");
                //创建任务调度任务开始时间
                jobUtil.addJob(stageUser,activityVO,activityCode);
                //创建任务调度任务结束时间
                jobUtil.addJobEndTime(stageUser,activityVO,activityCode);
            }
        }else{
            //查询结果如果不需要审核审核状态为已审核
            mktActivityPOWithBLOBs.setCheckStatus(CheckStatusEnum.CHECK_STATUS_APPROVED.getCode());
            //getStartTime 开始时间>当前时间增加job
            if(1 != bo.getActivityVO().getLongTerm() && new Date().before(activityVO.getStartTime())){
                //活动状态设置为待执行
                mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_PENDING.getCode());
                log.info("新增job任务");
                //创建任务调度任务开始时间
                jobUtil.addJob(stageUser,activityVO,activityCode);
                //创建任务调度任务结束时间
                jobUtil.addJobEndTime(stageUser,activityVO,activityCode);
            }else{
                //活动状态设置为执行中
                mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode());

            }
        }

        //新增活动主表
        mktActivityPOWithBLOBs.setCreateDate(new Date());
        mktActivityPOWithBLOBs.setCreateUserId(stageUser.getSysAccountId());
        mktActivityPOWithBLOBs.setCreateUserName(stageUser.getName());
        log.info("新增主表数据="+ JSON.toJSONString(mktActivityPOWithBLOBs));
        mktActivityPOMapper.insertSelective(mktActivityPOWithBLOBs);
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

        if (i>0){
            //如果是待审核数据则需要增加一条审核数据
            SysCheckPo po = new SysCheckPo();
            po.setSysBrandId(mktActivityPOWithBLOBs.getSysBrandId());
            po.setSysCompanyId(mktActivityPOWithBLOBs.getSysCompanyId());
            po.setBusinessCode(mktActivityPOWithBLOBs.getActivityCode());
            po.setBusinessName(mktActivityPOWithBLOBs.getActivityName());
            po.setBusinessType(ActivityTypeEnum.ACTIVITY_TYPE_UPGRADE.getCode());
            po.setFunctionCode("C0002");
            po.setCheckStatus(CheckStatusEnum.CHECK_STATUS_PENDING.getCode());
            po.setBusinessId(mktActivityId);
            po.setBizName(mktActivityPOWithBLOBs.getActivityName());
            po.setCreateDate(new Date());
            po.setCreateUserId(stageUser.getSysAccountId());
            po.setCreateUserName(stageUser.getName());
            log.info("新增一条审核中心数据="+ JSON.toJSONString(po));
            sysCheckServiceRpc.addCheck(po);
        }
        //新增升级活动表
        MktActivityUpgradePO mktActivityUpgradePO = new MktActivityUpgradePO();
        BeanUtils.copyProperties(mktActivityPOWithBLOBs,mktActivityUpgradePO);
        mktActivityUpgradePO.setMktActivityId(mktActivityId);
        mktActivityUpgradePO.setMbrLevelCode(activityVO.getMbrLevelCode());
        mktActivityUpgradePO.setMbrLevelName(activityVO.getMbrLevelName());
        mktActivityUpgradePO.setIsStoreLimit(activityVO.getStoreLimit());
        mktActivityUpgradePO.setMemberType(activityVO.getMemberType());
        if (true==activityVO.getStoreLimit()){
            mktActivityUpgradePO.setStoreLimitList(activityVO.getStoreLimitList());
            mktActivityUpgradePO.setStoreLimitType(activityVO.getStoreLimitType());
        }
        log.info("新增升级表数据="+ JSON.toJSONString(mktActivityUpgradePO));
        mktActivityUpgradePOMapper.insertSelective(mktActivityUpgradePO);


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
               // mktCouponPO.setBizId(couponCode.getBizId());
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
        ////如果是立即发送 则发送短息
        if(!CollectionUtils.isEmpty(messageVOList) ){
            if(true==activityVO.getSendImmediately()){
                log.info("开始立即发送");
                //查询该会员下一个等级
                ResponseData<MbrLevelModel> MbrLevelModels = memberLevelApiService.queryOnLevel(Long.parseLong(activityVO.getMbrLevelCode()));
                if (null!=MbrLevelModels.getData()){
                    MbrLevelModel  mbrLevel = MbrLevelModels.getData();
                    //分页查询会员信息发送短信
                    MembersInfoSearchVo membersInfoSearchVo = new MembersInfoSearchVo();
                    membersInfoSearchVo.setPageNumber(1);
                    membersInfoSearchVo.setPageSize(10000);
                    membersInfoSearchVo.setBrandId(activityVO.getSysBrandId());
                    membersInfoSearchVo.setSysCompanyId(activityVO.getSysCompanyId());
                    if(!activityVO.getMbrLevelCode().equals("0")){
                        List<Long> level = new ArrayList<>();
                        level.add(mbrLevel.getMbrLevelId());
                        membersInfoSearchVo.setLevelID(level);
                    }

                    log.info("发送短息查询会员参数="+ JSON.toJSONString(membersInfoSearchVo));
                    memberMessage.getMemberList(messageVOList, membersInfoSearchVo,activityVO);
                }

            }else{
                //自定义时间发送 加人job任务
                jobUtil.addSendMessageJob(stageUser,activityVO,activityCode);
            }

        }
        //结束
        log.info("创建升级活动结束");
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        return responseData;
    }

    /**
     * 修改升级活动
     * @param bo
     * @param stageUser
     * @return
     */
    @Override
    @Transactional
    public ResponseData<Integer> updateActivityUpgrade(ActivityBO bo, SysAccountPO stageUser) {
        log.info("修改升级活动开始");
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
        //查询审核配置，是否需要审核然后判断
       /* SysCheckConfigVo so = new SysCheckConfigVo();
        so.setSysBrandId(activityVO.getSysBrandId());*/
        ResponseData<List<SysCheckConfigVo>> sysCheckConfigVo =sysCheckConfigServiceRpc.getCheckConfigListAll(activityVO.getSysBrandId());
        List<SysCheckConfigVo> sysCheckConfigVoList = sysCheckConfigVo.getData();
        //判断是否有审核配置
        int i = 0;
        if(!CollectionUtils.isEmpty(sysCheckConfigVoList)){
            for (SysCheckConfigVo sysCheckConfig:sysCheckConfigVoList) {
                //判断是否需要审核  暂时先写这三个审核类型 后期确定下来写成枚举类
                if(sysCheckConfig.getFunctionCode().equals("C0002")){
                    i+=1;
                }
            }
        }

        if(i>0){
            //查询结果如果需要审核审核状态为待审核
            mktActivityPOWithBLOBs.setCheckStatus(CheckStatusEnum.CHECK_STATUS_PENDING.getCode());
            //活动状态设置为待执行
            mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_PENDING.getCode());

            //如果是待审核数据则需要增加一条审核数据
            //已驳回的可以新建审核
            if(activityVO.getCheckStatus() == CheckStatusEnum.CHECK_STATUS_REJECTED.getCode()){
                SysCheckPo po = new SysCheckPo();
                po.setSysBrandId(mktActivityPOWithBLOBs.getSysBrandId());
                po.setFunctionCode(mktActivityPOWithBLOBs.getActivityCode());
                po.setBusinessName(mktActivityPOWithBLOBs.getActivityName());
                po.setBusinessType(ActivityTypeEnum.ACTIVITY_TYPE_UPGRADE.getCode());
                po.setFunctionCode("C0002");
                po.setCheckStatus(CheckStatusEnum.CHECK_STATUS_PENDING.getCode());
                po.setCreateDate(new Date());
                po.setCreateUserId(stageUser.getSysAccountId());
                po.setCreateUserName(stageUser.getName());
                log.info("新增一条数据到审核中心="+ JSON.toJSONString(po));
                sysCheckServiceRpc.addCheck(po);
            }

            //getStartTime 开始时间>当前时间增加job
            if(1 != bo.getActivityVO().getLongTerm() && new Date().before(activityVO.getStartTime())){
                //先删除原来创建的job任务
                jobClient.removeByBiz(xxlJobInfo);
                //创建任务调度任务开始时间
                jobUtil.addJob(stageUser,activityVO,activityVO.getActivityCode());
                //创建任务调度任务结束时间
                jobUtil.addJobEndTime(stageUser,activityVO,activityVO.getActivityCode());
            }
        }else{
            //查询结果如果不需要审核审核状态为已审核
            mktActivityPOWithBLOBs.setCheckStatus(CheckStatusEnum.CHECK_STATUS_APPROVED.getCode());
            //getStartTime 开始时间>当前时间增加job
            if(1 != bo.getActivityVO().getLongTerm() && new Date().before(activityVO.getStartTime())){
                //活动状态设置为待执行
                mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_PENDING.getCode());
                //先删除原来创建的job任务
                jobClient.removeByBiz(xxlJobInfo);
                //创建任务调度任务开始时间
                jobUtil.addJob(stageUser,activityVO,activityVO.getActivityCode());
                //创建任务调度任务结束时间
                jobUtil.addJobEndTime(stageUser,activityVO,activityVO.getActivityCode());
            }else{
                //活动状态设置为执行中
                mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode());

            }
        }
        //修改活动主表
        mktActivityPOWithBLOBs.setModifiedDate(new Date());
        mktActivityPOWithBLOBs.setModifiedUserId(stageUser.getSysAccountId());
        mktActivityPOWithBLOBs.setModifiedUserName(stageUser.getName());
        log.info("修改活动主表="+ JSON.toJSONString(mktActivityPOWithBLOBs));
        mktActivityPOMapper.updateByPrimaryKeySelective(mktActivityPOWithBLOBs);
        //获取新增后数据id
        Long mktActivityId = mktActivityPOWithBLOBs.getMktActivityId();

        //修改升级活动表
        MktActivityUpgradePO mktActivityUpgradePO = new MktActivityUpgradePO();
        BeanUtils.copyProperties(mktActivityPOWithBLOBs,mktActivityUpgradePO);
        mktActivityUpgradePO.setMktActivityId(mktActivityId);
        log.info("修改活动升级表="+ JSON.toJSONString(mktActivityUpgradePO));
        mktActivityUpgradePOMapper.updateByPrimaryKeySelective(mktActivityUpgradePO);
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
        if(!CollectionUtils.isEmpty(messageVOList) && mktActivityPOWithBLOBs.getActivityStatus()==ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode()){
            //查询该会员下一个等级
            ResponseData<MbrLevelModel> MbrLevelModels = memberLevelApiService.queryOnLevel(Long.parseLong(activityVO.getMbrLevelCode()));
            MbrLevelModel  mbrLevel = MbrLevelModels.getData();
            //分页查询会员信息发送短信
            MembersInfoSearchVo membersInfoSearchVo = new MembersInfoSearchVo();
            membersInfoSearchVo.setPageNumber(1);
            membersInfoSearchVo.setPageSize(10000);
            membersInfoSearchVo.setBrandId(activityVO.getSysBrandId());
            List<Long> level = new ArrayList<>();
            level.add(mbrLevel.getMbrLevelId());
            membersInfoSearchVo.setLevelID(level);
            membersInfoSearchVo.setSysCompanyId(activityVO.getSysCompanyId());
            memberMessage.getMemberList(messageVOList, membersInfoSearchVo,activityVO);
        }
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        return responseData;
    }

    /**
     * 查询升级活动详情
     * @param businessCode
     * @return
     */
    @Override
    public ResponseData<ActivityBO> selectActivityUpgradesById(String businessCode) {
        ActivityBO bo = new ActivityBO();
        log.info("查询升级活动表参数businessCode="+businessCode);
        ResponseData responseData = new ResponseData();
        ActivityVO vo= new ActivityVO();
        vo.setActivityCode(businessCode);
        List<ActivityVO> upgradeList = mktActivityUpgradePOMapper.getActivityUpgradeList(vo);
        if (CollectionUtils.isEmpty(upgradeList)){
            responseData.setCode(SysResponseEnum.OPERATE_FAILED_DATA_NOT_EXISTS.getCode());
            responseData.setMessage(SysResponseEnum.OPERATE_FAILED_DATA_NOT_EXISTS.getMessage());
            return responseData;
        }
        if(!CollectionUtils.isEmpty(upgradeList)){
            bo.setActivityVO(upgradeList.get(0));
            if (!StringUtils.isEmpty(upgradeList.get(0).getStoreLimitList())){
                String ids =upgradeList.get(0).getStoreLimitList();
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
        example.createCriteria().andBizIdEqualTo(upgradeList.get(0).getMktActivityId()).andValidEqualTo(true).andBizTypeEqualTo(1);
        List<MktCouponPO> mktCouponPOs= mktCouponPOMapper.selectByExample(example);
        //查询券接口
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
        exampl.createCriteria().andBizIdEqualTo(upgradeList.get(0).getMktActivityId()).andValidEqualTo(true);
        List<MktMessagePO> listMktMessage = mktMessagePOMapper.selectByExampleWithBLOBs(exampl);
            bo.setCouponEntityAndDefinitionVOList(lists);
        if(!CollectionUtils.isEmpty(listMktMessage)){
            bo.setMessageVOList(listMktMessage);
        }
        responseData.setData(bo);
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        return responseData;
    }

    /**
     * 执行活动
     * @param vo
     * @return
     */
    @Override
    @Transactional
    @Async("asyncServiceExecutor")
    public ResponseData<Integer> executeUpgrades(MemberInfoModel vo) {
        //返回对象
        ResponseData responseData = new ResponseData();
        log.info("执行升级活动开始开始了开始了开始了开始了开始了");
        log.info("执行升级活动参数="+ JSON.toJSONString(vo));
        log.info("服务门店为!======================="+vo.getServiceStoreId());
        //查询品牌下所有执行中的活动
        ActivityVO activity = new ActivityVO();
        activity.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode());
        activity.setSysBrandId(vo.getBrandId());
        activity.setActivityType(ActivityTypeEnum.ACTIVITY_TYPE_UPGRADE.getCode());
        //查询会员等级相应的活动
       /* activity.setMbrLevelCode(vo.getLevelId().toString());*/
        List<ActivityVO> upgradeList = mktActivityUpgradePOMapper.getActivityUpgradeList(activity);
        if (CollectionUtils.isEmpty(upgradeList)){
            responseData.setCode(SysResponseEnum.OPERATE_FAILED_DATA_NOT_EXISTS.getCode());
            responseData.setMessage("没有对应的活动");
            return responseData;
        }
        for (ActivityVO activityVO:upgradeList) {
            //判断会员等级相应的活动
            if(!"0".equals(activityVO.getMbrLevelCode())){
                if (!activityVO.getMbrLevelCode().equals(vo.getLevelId().toString())){
                    continue;
                }
            }
            if (!ExecuteParamCheckUtil.implementActivitCheck(vo,activityVO)){
                continue;
            }
            ////增加积分奖励新增接口
            if (null!=activityVO.getPoints()){
                AwardBO bo = new AwardBO();
                IntegralChangeRequestModel integralChangeRequestModel =new IntegralChangeRequestModel();
                integralChangeRequestModel.setSysCompanyId(activityVO.getSysCompanyId());
                integralChangeRequestModel.setBrandId(activityVO.getSysBrandId());
                integralChangeRequestModel.setMemberCode(vo.getMemberCode());
                integralChangeRequestModel.setChangeBills(activityVO.getActivityCode());
                integralChangeRequestModel.setChangeIntegral(activityVO.getPoints());
                integralChangeRequestModel.setChangeType(IntegralChangeTypeEnum.INCOME.getCode());
                integralChangeRequestModel.setBusinessType(com.bizvane.members.facade.enums.BusinessTypeEnum.ACTIVITY_TYPE_UPGRADE.getCode());
                integralChangeRequestModel.setChangeDate(new Date());
                bo.setIntegralRecordModel(integralChangeRequestModel);
                bo.setMktType(MktSmartTypeEnum.SMART_TYPE_INTEGRAL.getCode());
                log.info("新增积分奖励开始开始开始开始");
                award.execute(bo);
            }

            // 增加卷奖励接口
            MktCouponPOExample example = new  MktCouponPOExample();
            example.createCriteria().andBizIdEqualTo(activityVO.getMktActivityId()).andValidEqualTo(true).andBizTypeEqualTo(1);
            List<MktCouponPO> mktCouponPOs= mktCouponPOMapper.selectByExample(example);
            if(!CollectionUtils.isEmpty(mktCouponPOs)){
                for (MktCouponPO mktCouponPO:mktCouponPOs) {
                    AwardBO awardBO = new AwardBO();
                    SendCouponSimpleRequestVO sendCouponSimpleRequestVO = new SendCouponSimpleRequestVO();
                    sendCouponSimpleRequestVO.setBusinessName(activityVO.getActivityName());
                    sendCouponSimpleRequestVO.setMemberCode(vo.getMemberCode());
                    sendCouponSimpleRequestVO.setCouponDefinitionId(mktCouponPO.getCouponDefinitionId());
                    sendCouponSimpleRequestVO.setSendBussienId(mktCouponPO.getBizId());
                    sendCouponSimpleRequestVO.setSendType(SendTypeEnum.SEND_COUPON_UPGRADE_ACTIVITY.getCode());
                    sendCouponSimpleRequestVO.setCompanyId(vo.getSysCompanyId());
                    sendCouponSimpleRequestVO.setBrandId(vo.getBrandId());
                    awardBO.setSendCouponSimpleRequestVO(sendCouponSimpleRequestVO);
                    awardBO.setMktType(MktSmartTypeEnum.SMART_TYPE_COUPON.getCode());
                    log.info("新增券奖励开始开始开始开始");
                    award.execute(awardBO);
                }
            }

            //新增积分到会员参与活动记录表中数据
            MktActivityRecordPO po = new MktActivityRecordPO();
            po.setActivityType(ActivityTypeEnum.ACTIVITY_TYPE_UPGRADE.getCode());
            po.setMemberCode(vo.getMemberCode());
            po.setParticipateDate(new Date());
            po.setPoints(activityVO.getPoints());
            po.setAcitivityId(activityVO.getMktActivityId());
            po.setSysBrandId(activityVO.getSysBrandId());
            log.info("新增积分记录表");
            mktActivityRecordPOMapper.insertSelective(po);
            
            mktActivityCountPOMapper.updateSum(po.getAcitivityId(), 1, BigDecimal.ZERO, po.getPoints());
        }
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        return responseData;
    }

    /**
     * 会员活动审核
     * @param
     * @param sysAccountPO
     * @return
     */
    @Override
    @Transactional
    public ResponseData<Integer> checkActivityUpgrades(SysCheckPo po, SysAccountPO sysAccountPO) {
        log.info("会员升级活动审核");
        ResponseData responseData = new ResponseData();
        MktActivityPOWithBLOBs bs = new MktActivityPOWithBLOBs();
        bs.setModifiedUserId(sysAccountPO.getSysAccountId());
        bs.setModifiedDate(new Date());
        bs.setModifiedUserName(sysAccountPO.getName());
        bs.setCheckStatus(po.getCheckStatus());
        bs.setActivityCode(po.getBusinessCode());
        bs.setMktActivityId(po.getBusinessId());
        //根据code查询出审核活动的详细信息
        ActivityVO vo = new ActivityVO();
        vo.setActivityCode(po.getBusinessCode());
        List<ActivityVO> activityUpgradeList = mktActivityUpgradePOMapper.getActivityUpgradeList(vo);
        if (CollectionUtils.isEmpty(activityUpgradeList)){
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.OPERATE_FAILED_DATA_NOT_EXISTS.getMessage());
            return responseData;
        }
        ActivityVO activityPO = activityUpgradeList.get(0);
        //判断是审核通过还是审核驳回
        if(bs.getCheckStatus()==CheckStatusEnum.CHECK_STATUS_APPROVED.getCode()){
            //活动开始时间<当前时间<活动结束时间  或者长期活动 也就是StartTime=null
            if(1== activityPO.getLongTerm() ||(new Date().after(activityPO.getStartTime()) && new Date().before(activityPO.getEndTime()))){
                //将活动状态变更为执行中 并且发送消息
                bs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode());
            }
            //判断审核时间 >活动结束时间  将活动状态变为已结束
            if(null!=activityPO.getEndTime()&&new Date().after(activityPO.getEndTime())){
                bs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_FINISHED.getCode());
            }

        }else{
            bs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_FINISHED.getCode());

        }
        log.info("更新审核状态的参数是+======="+ JSON.toJSONString(bs));
        int i = mktActivityPOMapper.updateByPrimaryKeySelective(bs);
        //更新审核中心状态
        sysCheckServiceRpc.updateCheck(po);
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        return responseData;
    }
}