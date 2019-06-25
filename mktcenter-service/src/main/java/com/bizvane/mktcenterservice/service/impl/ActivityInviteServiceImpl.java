package com.bizvane.mktcenterservice.service.impl;

import com.alibaba.fastjson.JSON;
import com.bizvane.centerstageservice.models.po.SysStorePo;
import com.bizvane.couponfacade.interfaces.CouponQueryServiceFeign;
import com.bizvane.couponfacade.models.vo.CouponDetailResponseVO;
import com.bizvane.members.facade.es.vo.MembersInfoSearchVo;
import com.bizvane.members.facade.es.vo.WxChannelInfoSearchVo;
import com.bizvane.mktcenterfacade.interfaces.*;
import com.bizvane.mktcenterfacade.models.bo.ActivityBO;
import com.bizvane.mktcenterfacade.models.po.*;

import com.bizvane.mktcenterfacade.models.vo.ActivityVO;
import com.bizvane.mktcenterfacade.models.vo.PageForm;
import com.bizvane.mktcenterservice.common.award.Award;
import com.bizvane.mktcenterservice.common.award.MemberMessageSend;
import com.bizvane.mktcenterservice.common.constants.SystemConstants;
import com.bizvane.mktcenterservice.common.constants.TaskConstants;
import com.bizvane.mktcenterservice.common.enums.ActivityStatusEnum;
import com.bizvane.mktcenterservice.common.enums.ActivityTypeEnum;
import com.bizvane.mktcenterservice.common.enums.BusinessTypeEnum;
import com.bizvane.mktcenterservice.common.enums.CheckStatusEnum;
import com.bizvane.mktcenterservice.common.job.JobUtil;
import com.bizvane.mktcenterservice.common.utils.ActivityParamCheckUtil;
import com.bizvane.mktcenterservice.common.utils.CodeUtil;
import com.bizvane.mktcenterservice.common.utils.ExecuteParamCheckUtil;
import com.bizvane.mktcenterservice.common.utils.TimeUtils;
import com.bizvane.mktcenterservice.mappers.*;
import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.jobutils.JobClient;
import com.bizvane.utils.jobutils.XxlJobInfo;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chen.li
 * @date on 2018/7/24 10:54
 * @description
 *
 */
@Slf4j
@Service
public class ActivityInviteServiceImpl implements ActivityInviteService {
    @Autowired
    private ActivityService activityService;

    @Autowired
    private MktActivityPOMapper mktActivityPOMapper;

    @Autowired
    private MktActivityCountPOMapper mktActivityCountPOMapper;

    @Autowired
    private MktActivityInvitePOMapper mktActivityInvitePOMapper;

    @Autowired
    private MktCouponPOMapper mktCouponPOMapper;

    @Autowired
    private MktMessagePOMapper mktMessagePOMapper;

    @Autowired
    private MemberMessageSend memberMessageSend;

    @Autowired
    private ActivityRecordService activityRecordService;

    @Autowired
    private CouponQueryServiceFeign couponQueryServiceFeign;

    @Autowired
    private JobUtil  jobUtil;

    @Autowired
    private JobClient jobClient;

    /**
     * 查询活动列表
     * @return
     */
    @Override
    public ResponseData<List<ActivityVO>> list(ActivityVO vo, PageForm pageForm, SysAccountPO stageUser) {
        ResponseData responseData = new ResponseData();
        PageHelper.startPage(pageForm.getPageNumber(),pageForm.getPageSize());
        vo.setSysBrandId(stageUser.getBrandId());
        vo.setActivityType(ActivityTypeEnum.ACTIVITY_TYPE_INVITE.getCode());
        List<ActivityVO> activityInviteList =mktActivityInvitePOMapper.getActivityList(vo);
        PageInfo<ActivityVO> pageInfo = new PageInfo<>(activityInviteList);
        responseData.setData(pageInfo);
        return responseData;
    }

    /**
     * 查询活动详情
     * @param businessCode
     * @return
     */
    @Override
    public ResponseData<ActivityBO> selectActivityInviteById(String businessCode) {
        ActivityBO bo = new ActivityBO();
        log.info("查询开卡活动详情="+businessCode);
        ResponseData responseData = new ResponseData();
        ActivityVO vo= new ActivityVO();
        vo.setActivityCode(businessCode);
        vo.setActivityType(ActivityTypeEnum.ACTIVITY_TYPE_INVITE.getCode());
        List<ActivityVO> activityInviteList = mktActivityInvitePOMapper.getActivityList(vo);
        if(CollectionUtils.isEmpty(activityInviteList)){
            responseData.setCode(SysResponseEnum.OPERATE_FAILED_DATA_NOT_EXISTS.getCode());
            responseData.setMessage(SysResponseEnum.OPERATE_FAILED_DATA_NOT_EXISTS.getMessage());
            return responseData;
        }

        bo.setActivityVO(activityInviteList.get(0));

        //查询活动卷
        MktCouponPOExample example = new  MktCouponPOExample();
        example.createCriteria().andBizIdEqualTo(activityInviteList.get(0).getMktActivityId()).andValidEqualTo(true).andBizTypeEqualTo(1);
        List<MktCouponPO> mktCouponPOs= mktCouponPOMapper.selectByExample(example);
        List<CouponDetailResponseVO> lists = new ArrayList<>();
        //查询券接口
        if(!org.springframework.util.CollectionUtils.isEmpty(mktCouponPOs)){
            for (MktCouponPO po:mktCouponPOs) {
                ResponseData<CouponDetailResponseVO>  entityAndDefinition = couponQueryServiceFeign.getCouponDefinition(po.getCouponDefinitionId());
                lists.add(entityAndDefinition.getData());
            }
        }

        //查询消息模板
        MktMessagePOExample exampl = new MktMessagePOExample();
        exampl.createCriteria().andBizIdEqualTo(activityInviteList.get(0).getMktActivityId()).andValidEqualTo(true);
        List<MktMessagePO> listMktMessage = mktMessagePOMapper.selectByExampleWithBLOBs(exampl);

        if(!org.springframework.util.CollectionUtils.isEmpty(listMktMessage)){
            bo.setMessageVOList(listMktMessage);
        }
        bo.setCouponEntityAndDefinitionVOList(lists);
        responseData.setData(bo);
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        return responseData;
    }

    /**
     * 创建活动
     * @param stageUser
     * @return
     */
    @Transactional
    @Override
    public ResponseData<Integer> add(ActivityBO bo, SysAccountPO stageUser){
        log.info("邀请开卡活动-创建活动-入参bo:{},stageUser:{}",JSON.toJSONString(bo),JSON.toJSONString(stageUser));
        //返回对象
        ResponseData responseData = new ResponseData();
        //得到大实体类
        ActivityVO activityVO = bo.getActivityVO();
        //判断活动开始时间是否大于当前时间
        if(new Date().after(activityVO.getStartTime())){
            responseData.setCode(SysResponseEnum.MODEL_FAILED_VALIDATION.getCode());
            responseData.setMessage("活动开始时间不能比当前时间小!");
            return responseData;
        }
        //工具类生成活动编码
        String activityCode = CodeUtil.getActivityCode();
        activityVO.setActivityCode(activityCode);
        //增加活动类型是开卡活动
        activityVO.setActivityType(ActivityTypeEnum.ACTIVITY_TYPE_INVITE.getCode());
        //增加品牌id
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
        //查询结果如果不需要审核审核状态为已审核
        mktActivityPOWithBLOBs.setCheckStatus(CheckStatusEnum.CHECK_STATUS_APPROVED.getCode());
        //getStartTime 开始时间>当前时间增加job
        if( new Date().before(activityVO.getStartTime())){
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
        log.info("邀请开卡活动-创建活动-新增活动主表入参:"+ JSON.toJSONString(mktActivityPOWithBLOBs));
        mktActivityPOMapper.insertSelective(mktActivityPOWithBLOBs);
        log.info("邀请开卡活动-创建主表活动-成功");
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

        //新增邀请开卡活动表
        MktActivityInvitePO mktActivityInvitePO = new MktActivityInvitePO();
        BeanUtils.copyProperties(mktActivityPOWithBLOBs,mktActivityInvitePO);
        mktActivityInvitePO.setMktActivityId(mktActivityId);

        log.info("邀请开卡活动-新增入参:"+ JSON.toJSONString(mktActivityInvitePO));
        mktActivityInvitePOMapper.insertSelective(mktActivityInvitePO);
        log.info("邀请开卡活动-创建成功");
        //新增券奖励
        List<MktCouponPO> couponCodeList = bo.getCouponCodeList();
        if(!org.springframework.util.CollectionUtils.isEmpty(couponCodeList)){
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
        if(CollectionUtils.isNotEmpty(messageVOList)){
            //如果是立即发送 则发送短息
            if(activityVO.getSendImmediately()){
                //分页查询会员信息发送短信
                MembersInfoSearchVo membersInfoSearchVo = new MembersInfoSearchVo();
                membersInfoSearchVo.setPageNumber(1);
                membersInfoSearchVo.setPageSize(10000);
                membersInfoSearchVo.setCardStatus(2);
                membersInfoSearchVo.setBrandId(activityVO.getSysBrandId());
                membersInfoSearchVo.setSysCompanyId(activityVO.getSysCompanyId());
                log.info("开卡活动-查询发送短信高级搜索参数+=====："+JSON.toJSONString(membersInfoSearchVo));
                memberMessageSend.sendDXmessage(messageVOList, membersInfoSearchVo);
                //查询对应的会员  发送微信模板消息
                WxChannelInfoSearchVo wxChannelInfoSearchVo = new WxChannelInfoSearchVo();
                wxChannelInfoSearchVo.setPageNum(1);
                wxChannelInfoSearchVo.setPageSize(10000);
                wxChannelInfoSearchVo.setFocus(2);
                wxChannelInfoSearchVo.setCardStatus(1);
                wxChannelInfoSearchVo.setMiniProgram((byte) 1);
                wxChannelInfoSearchVo.setBrandId(activityVO.getSysBrandId());
                log.info("开卡活动-查询发送微信模板高级搜索参数+=====："+JSON.toJSONString(wxChannelInfoSearchVo));
                memberMessageSend.sendWXmessage(messageVOList, wxChannelInfoSearchVo,activityVO);
            }else{
                //自定义时间发送 加人job任务
                jobUtil.addSendMessageJob(stageUser,activityVO,activityCode);
            }

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
        //结束
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        log.info("邀请开卡活动-创建活动-成功");
        return responseData;
    }

    /**
     * 更新邀请开卡活动
     *
     * @param stageUser
     * @return
     */
    @Transactional
    @Override
    public ResponseData update(ActivityBO bo, SysAccountPO stageUser){
        log.info("邀请开卡活动修改开始,bo:{},stageUser:{}",JSON.toJSONString(bo),JSON.toJSONString(stageUser));
        //返回对象
        ResponseData responseData = new ResponseData();
        //得到大实体类
        ActivityVO activityVO = bo.getActivityVO();

        MktActivityPOWithBLOBs mktActivityPOWithBLOBs = new MktActivityPOWithBLOBs();
        BeanUtils.copyProperties(activityVO,mktActivityPOWithBLOBs);
        //job类
        XxlJobInfo xxlJobInfo = new XxlJobInfo();
        xxlJobInfo.setExecutorParam(activityVO.getActivityCode());
        xxlJobInfo.setBizType(BusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode());

        //查询结果如果不需要审核审核状态为已审核
        mktActivityPOWithBLOBs.setCheckStatus(CheckStatusEnum.CHECK_STATUS_APPROVED.getCode());
        //getStartTime 开始时间>当前时间增加job
        if( new Date().before(activityVO.getStartTime())){
            //活动状态设置为待执行
            mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_PENDING.getCode());
            //先删除原来创建的job任务
            jobClient.removeByBiz(xxlJobInfo);
            //创建任务调度任务开始时间
            jobUtil.addStratBirthdayJob(stageUser,activityVO,mktActivityPOWithBLOBs.getActivityCode());
            //创建任务调度任务结束时间
            jobUtil.addEndBirthdayJob(stageUser,activityVO,mktActivityPOWithBLOBs.getActivityCode());
        }else{
            //活动状态设置为执行中
            mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode());

        }

        //修改活动主表
        mktActivityPOWithBLOBs.setModifiedDate(new Date());
        mktActivityPOWithBLOBs.setModifiedUserId(stageUser.getSysAccountId());
        mktActivityPOWithBLOBs.setModifiedUserName(stageUser.getName());
        mktActivityPOMapper.updateByPrimaryKeySelective(mktActivityPOWithBLOBs);

        //获取新增后数据id
        Long mktActivityId = mktActivityPOWithBLOBs.getMktActivityId();

        //修改邀请开卡活动表
        MktActivityInvitePO mktActivityInvitePO = new MktActivityInvitePO();
        BeanUtils.copyProperties(mktActivityPOWithBLOBs,mktActivityInvitePO);
        mktActivityInvitePO.setMktActivityId(mktActivityId);
        mktActivityInvitePOMapper.updateByPrimaryKeySelective(mktActivityInvitePO);

        //先删除在新增
        MktCouponPO record = new MktCouponPO();
        record.setValid(Boolean.FALSE);
        MktCouponPOExample example = new MktCouponPOExample();
        example.createCriteria().andBizIdEqualTo(mktActivityId);
        mktCouponPOMapper.updateByExampleSelective(record,example);
        //修改券奖励
        List<MktCouponPO> couponCodeList = bo.getCouponCodeList();
        if(!org.springframework.util.CollectionUtils.isEmpty(couponCodeList)){
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
        if(!org.springframework.util.CollectionUtils.isEmpty(messageVOList)){
            for(MktMessagePO messageVO : messageVOList){
                MktMessagePO mktMessagePO = new MktMessagePO();
                BeanUtils.copyProperties(mktActivityPOWithBLOBs,mktMessagePO);
                BeanUtils.copyProperties(messageVO,mktMessagePO);
                mktMessagePO.setBizType(BusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode());
                mktMessagePO.setBizId(mktActivityId);
                mktMessagePOMapper.insertSelective(mktMessagePO);
            }
        }
        log.info("任务修改结束");
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        return responseData;
    }
}

