package com.bizvane.mktcenterserviceimpl.service.impl;

import com.alibaba.fastjson.JSON;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.mktcenterservice.interfaces.*;
import com.bizvane.mktcenterservice.models.bo.*;
import com.bizvane.mktcenterservice.models.po.*;
import com.bizvane.mktcenterservice.models.vo.*;
import com.bizvane.mktcenterserviceimpl.common.award.Award;
import com.bizvane.mktcenterserviceimpl.common.constants.SystemConstants;
import com.bizvane.mktcenterserviceimpl.common.constants.TaskConstants;
import com.bizvane.mktcenterserviceimpl.common.utils.CodeUtil;
import com.bizvane.mktcenterserviceimpl.common.job.JobUtil;
import com.bizvane.mktcenterserviceimpl.common.utils.TaskParamCheckUtil;
import com.bizvane.mktcenterserviceimpl.common.utils.TimeUtils;
import com.bizvane.mktcenterserviceimpl.mappers.MktTaskInvitePOMapper;
import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springfox.documentation.spring.web.json.Json;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * @author chen.li
 * @date on 2018/7/24 10:54
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@Slf4j
@Service
public class TaskInviteServiceImpl implements TaskInviteService {
    @Autowired
    protected TaskService taskService;

    @Autowired
    private TaskCouponService taskCouponService;

    @Autowired
    private TaskMessageService taskMessageService;

    @Autowired
    private MktTaskInvitePOMapper mktTaskInvitePOMapper;

    @Autowired
    private Award award;

    @Autowired
    private TaskRecordService taskRecordService;

    @Autowired
    private JobUtil  jobUtil;

    /**
     * 查询任务列表
     *
     * @return
     */
    @Override
    public List<TaskVO> selectTask(TaskVO vo) {
        return mktTaskInvitePOMapper.getTaskList(vo);
    }

    /**
     * 创建任务
     * @param stageUser
     * @return
     */
    @Transactional
    @Override
    public ResponseData<Integer> addTask(TaskBO bo, SysAccountPO stageUser) throws ParseException {
        //0.参数的检验
        ResponseData responseData = TaskParamCheckUtil.checkParam(bo);
        //参数校验不通过
        if(responseData.getCode()>0){
            return responseData;
        }
        TaskVO taskVO = bo.getTaskVO();
        //1.生成任务编号
        String taskCode = CodeUtil.getTaskCode();
        //2.任务主表新增
        taskVO.setTaskCode(taskCode);
        //状态的设置

        MktTaskPOWithBLOBs mktTaskPOWithBLOBs = new MktTaskPOWithBLOBs();
        BeanUtils.copyProperties(taskVO, mktTaskPOWithBLOBs);
        //1.判断是否需要审核  1=需要审核   0=不需要
        Integer stagecheckStatus = taskService.getCenterStageCheckStage(mktTaskPOWithBLOBs);

        mktTaskPOWithBLOBs = taskService.isOrNoCheckState(mktTaskPOWithBLOBs,stagecheckStatus);
        Long mktTaskId = taskService.addTask(mktTaskPOWithBLOBs, stageUser);
        //将需要审核的任务添加到审核中心
       if(TaskConstants.FIRST.equals(stagecheckStatus)){
           taskService.addCheckData(mktTaskPOWithBLOBs);
       }

        //3.任务消费表新增
        MktTaskInvitePO mktTaskInvitePO = new MktTaskInvitePO();
        BeanUtils.copyProperties(taskVO, mktTaskInvitePO);
        mktTaskInvitePO.setMktTaskId(mktTaskId);
        this.insertInviteTask(mktTaskInvitePO, stageUser);

        //4.新增奖励新增  biz_type 活动类型  1=活动
        List<MktCouponPO> mktCouponPOList = bo.getMktCouponPOList();
        if (CollectionUtils.isNotEmpty(mktCouponPOList)) {
            mktCouponPOList.stream().forEach(param -> {
                param.setBizId(mktTaskId);
                param.setBizType(TaskConstants.TASK_TYPE);
                taskCouponService.addTaskCoupon(param, stageUser);
            });
        }
        //5.新增消息新增
        List<MktMessagePO> mktmessagePOList = bo.getMessagePOList();
        if (CollectionUtils.isNotEmpty(mktmessagePOList)) {
            mktmessagePOList.stream().forEach(param -> {
                        param.setBizId(mktTaskId);
                        param.setBizType(TaskConstants.TASK_TYPE);
                        taskMessageService.addTaskMessage(param, stageUser);
                    }
            );
        }

        //6.处理任务
        taskService.doOrderTask(mktTaskPOWithBLOBs,mktmessagePOList,stageUser);

        responseData.setCode(SystemConstants.SUCCESS_CODE);
        responseData.setMessage(SystemConstants.SUCCESS_MESSAGE);
        return responseData;
    }

    /**
     * 更新消费任务
     *
     * @param stageUser
     * @return
     */
    @Transactional
    @Override
    public ResponseData updateInviteTask(TaskBO bo, SysAccountPO stageUser) throws ParseException {
        //0.参数的检验
        ResponseData responseData = TaskParamCheckUtil.checkParam(bo);
        //参数校验不通过
        if(responseData.getCode()>0){
            return responseData;
        }
        TaskVO taskVO = bo.getTaskVO();
        Long mktTaskId = taskVO.getMktTaskId();
        //1.任务主表修改
        MktTaskPOWithBLOBs mktTaskPOWithBLOBs = new MktTaskPOWithBLOBs();
        BeanUtils.copyProperties(taskVO, mktTaskPOWithBLOBs);
        //1.判断是否需要审核  1=需要审核   0=不需要
        Integer StagecheckStatus = taskService.getCenterStageCheckStage(mktTaskPOWithBLOBs);
        //状态的设置
        mktTaskPOWithBLOBs = taskService.isOrNoCheckState(mktTaskPOWithBLOBs,StagecheckStatus);
        taskService.updateTask(mktTaskPOWithBLOBs, stageUser);

        //3.任务邀请表修改
        MktTaskInvitePO mktTaskInvitePO = new MktTaskInvitePO();
        BeanUtils.copyProperties(taskVO, mktTaskInvitePO);
        this.modifieInviteTask(mktTaskInvitePO, stageUser);

        //4.奖励修改 biz_type 活动类型  1=活动
        taskCouponService.deleteTaskCoupon(mktTaskId, stageUser);
        List<MktCouponPO> mktCouponPOList = bo.getMktCouponPOList();
        if (CollectionUtils.isNotEmpty(mktCouponPOList)) {
            mktCouponPOList.stream().forEach(param -> {
                param.setBizId(mktTaskId);
                param.setBizType(TaskConstants.TASK_TYPE);
                taskCouponService.addTaskCoupon(param, stageUser);
            });
        }
        //5.修改消息
        taskMessageService.deleteTaskMessage(mktTaskId,stageUser);
        List<MktMessagePO> mktmessagePOList = bo.getMessagePOList();
        if (CollectionUtils.isNotEmpty(mktmessagePOList)) {
            mktmessagePOList.stream().forEach(param -> {
                        param.setBizId(mktTaskId);
                        param.setBizType(TaskConstants.TASK_TYPE);
                        taskMessageService.addTaskMessage(param, stageUser);
                    }
            );
        }
        //6.处理任务
        taskService.doOrderTask(mktTaskPOWithBLOBs,mktmessagePOList,stageUser);
        responseData.setCode(SystemConstants.SUCCESS_CODE);
        responseData.setMessage(SystemConstants.SUCCESS_MESSAGE);
        return responseData;
    }
    /**
     * 新增消费任务
     */
    @Override
    public Integer insertInviteTask(MktTaskInvitePO po, SysAccountPO stageUser) {
        po.setSysCompanyId(stageUser.getSysCompanyId());
        po.setCreateUserName(stageUser.getName());
        po.setCreateUserId(stageUser.getSysAccountId());
        po.setCreateDate(new Date());
        return mktTaskInvitePOMapper.insertSelective(po);
    }

    /**
     * 修改
     * @param stageUser
     * @return
     */
    @Override
    public Integer modifieInviteTask(MktTaskInvitePO po, SysAccountPO stageUser) {
        po.setModifiedDate(TimeUtils.getNowTime());
        po.setModifiedUserId(stageUser.getSysAccountId());
        po.setModifiedUserName(stageUser.getName());

        MktTaskInvitePOExample example = new MktTaskInvitePOExample();
        example.createCriteria().andMktTaskIdEqualTo(po.getMktTaskId()).andValidEqualTo(Boolean.TRUE);
        return mktTaskInvitePOMapper.updateByExample(po, example);
    }
    /**
     * 执行邀请任务的奖励
     */
    @Async
    @Override
    public  void   doAwardInvite(InviteSuccessVO vo){
        log.info("执行邀请任务的奖励--参数--"+ JSON.toJSONString(vo));
        //被邀请人信息
        Date openCardTime = vo.getOpenCardTime();
        //邀请人的信息
        String inviteMemberCode = vo.getInviteMemberCode();
        MemberInfoModel memeberDetail = taskService.getCompanyMemeberDetail(inviteMemberCode);
        log.info("邀请注册任务中会员详情--"+ JSON.toJSONString(memeberDetail));
        Long companyId = memeberDetail.getSysCompanyId();
        Long brandId = memeberDetail.getBrandId();
        String memberCode = memeberDetail.getMemberCode();
        String cardNo = memeberDetail.getCardNo();
        Long serviceStoreId = memeberDetail.getServiceStoreId();
        //符合条件的任务列表
        List<TaskAwardBO> taskInviteAwardList = taskService.getTaskInviteAwardList(companyId, brandId,openCardTime);
        log.info("符合条件的邀请注册任务列表--"+ JSON.toJSONString(taskInviteAwardList));
        if (CollectionUtils.isNotEmpty(taskInviteAwardList)){
            taskInviteAwardList.stream().
                filter(obj->{
                    Boolean isStoreLimit = obj.getStoreLimit();
                    String  StoreLimitList=obj.getStoreLimitList();
                    return isStoreLimit||(serviceStoreId!=null)||(StringUtils.isNotBlank(StoreLimitList) && obj.getStoreLimitList().contains(String.valueOf(serviceStoreId)));}).
                forEach(obj->{
                    Integer taskType = obj.getTaskType();
                    Long mktTaskId = obj.getMktTaskId();
                    //邀请开卡人数
                    Integer inviteNum = obj.getInviteNum();
                    MktTaskRecordVO recordVO = new MktTaskRecordVO();
                    recordVO.setSysBrandId(brandId);
                    recordVO.setTaskType(taskType);
                    recordVO.setTaskId(mktTaskId);
                    recordVO.setMemberCode(inviteMemberCode);
                    // 获取会员是否已经成功参与过某一任务
                    Boolean isOrNoAward = taskRecordService.getIsOrNoAward(recordVO);
                    log.info("获取会员是否参加过某一任务--"+isOrNoAward+"--"+JSON.toJSONString(recordVO));
                    if (!isOrNoAward){
                        MktTaskRecordPO recordPO = new MktTaskRecordPO();
                        BeanUtils.copyProperties(recordVO,recordPO);
                        recordPO.setParticipateDate(openCardTime);
                        taskRecordService.addTaskRecord(recordPO);
                        //获取会员参与某一活动放总金额和总次数
                        TotalStatisticsBO totalBO = taskRecordService.getTotalStatistics(recordVO);
                        if (totalBO!=null && totalBO.getTotalTimes()!=null &&  totalBO.getTotalTimes().equals(inviteNum)){
                            recordPO.setRewarded(1);
                            taskRecordService.updateTaskRecord(recordPO);
                            taskService.sendCouponAndPoint(memberCode,obj);
                        }
                    }
            });
        }
    }
}

