package com.bizvane.mktcenterserviceimpl.service.impl;

import com.bizvane.centerstageservice.models.po.SysCheckConfigPo;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.mktcenterservice.interfaces.TaskCouponService;
import com.bizvane.mktcenterservice.interfaces.TaskInviteService;
import com.bizvane.mktcenterservice.interfaces.TaskMessageService;
import com.bizvane.mktcenterservice.interfaces.TaskService;
import com.bizvane.mktcenterservice.models.bo.AwardBO;
import com.bizvane.mktcenterservice.models.bo.TaskBO;
import com.bizvane.mktcenterservice.models.bo.TaskDetailBO;
import com.bizvane.mktcenterservice.models.po.*;
import com.bizvane.mktcenterservice.models.vo.PageForm;
import com.bizvane.mktcenterservice.models.vo.TaskDetailVO;
import com.bizvane.mktcenterservice.models.vo.TaskVO;
import com.bizvane.mktcenterserviceimpl.common.award.Award;
import com.bizvane.mktcenterserviceimpl.common.constants.SystemConstants;
import com.bizvane.mktcenterserviceimpl.common.constants.TaskConstants;
import com.bizvane.mktcenterserviceimpl.common.enums.CheckStatusEnum;
import com.bizvane.mktcenterserviceimpl.common.enums.MktSmartTypeEnum;
import com.bizvane.mktcenterserviceimpl.common.enums.TaskStatusEnum;
import com.bizvane.mktcenterserviceimpl.common.utils.CodeUtil;
import com.bizvane.mktcenterserviceimpl.common.utils.JobUtil;
import com.bizvane.mktcenterserviceimpl.common.utils.TaskParamCheckUtil;
import com.bizvane.mktcenterserviceimpl.common.utils.TimeUtils;
import com.bizvane.mktcenterserviceimpl.mappers.MktTaskInvitePOMapper;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.List;

/**
 * @author chen.li
 * @date on 2018/7/24 10:54
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
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
    private JobUtil  jobUtil;
    /**
     * 审核任务:任务id   任务状态
     * 审核状态：1未审核，2审核中，3已审核，4已驳回',
     */
    @Override
    public Integer checkInviteTask(TaskVO vo) {
        MktTaskInvitePO po = new MktTaskInvitePO();
        BeanUtils.copyProperties(vo, po);
        return mktTaskInvitePOMapper.updateByPrimaryKeySelective(po);

    }

    /**
     * 根据任务Id查询任务详情
     */
    @Override
    public List<TaskDetailBO> getInviteTaskDetails(Long mktTaskId) {
        return mktTaskInvitePOMapper.getInviteTaskDetails(mktTaskId);
    }
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
     * @param vo
     * @param stageUser
     * @return
     */
    @Transactional
    @Override
    public ResponseData<Integer> addTask(TaskDetailVO vo, SysAccountPO stageUser) throws ParseException {
        //0.参数的检验
        ResponseData responseData = TaskParamCheckUtil.checkParam(vo);
        if (responseData.getCode() < 0) {
            return responseData;
        }
        vo.setValid(Boolean.TRUE);
        vo.setCreateDate(TimeUtils.getNowTime());
        vo.setCreateUserId(stageUser.getSysAccountId());
        vo.setCreateUserName(stageUser.getName());

        //1.生成任务编号
        String taskCode = CodeUtil.getTaskCode();
        //2.任务主表新增
        MktTaskPOWithBLOBs mktTaskPOWithBLOBs = new MktTaskPOWithBLOBs();
        BeanUtils.copyProperties(vo, mktTaskPOWithBLOBs);
        mktTaskPOWithBLOBs.setTaskCode(taskCode);
        //状态的设置
        mktTaskPOWithBLOBs = taskService.isOrNoCheckState(mktTaskPOWithBLOBs);
        Long mktTaskId = taskService.addTask(mktTaskPOWithBLOBs, stageUser);

        //3.任务消费表新增
        MktTaskInvitePO mktTaskInvitePO = new MktTaskInvitePO();
        BeanUtils.copyProperties(vo, mktTaskInvitePO);
        mktTaskInvitePO.setMktTaskId(mktTaskId);
        this.insertInviteTask(mktTaskInvitePO, stageUser);

        //4.新增奖励新增  biz_type 活动类型  1=活动
        List<MktCouponPO> mktCouponPOList = vo.getMktCouponPOList();
        if (CollectionUtils.isNotEmpty(mktCouponPOList)) {
            mktCouponPOList.stream().forEach(param -> {
                param.setBizId(mktTaskId);
                param.setBizType(TaskConstants.TASK_TYPE);
                taskCouponService.addTaskCoupon(param, stageUser);
            });
        }
        //5.新增消息新增
        List<MktMessagePO> mktmessagePOList = vo.getMktmessagePOList();
        if (CollectionUtils.isNotEmpty(mktmessagePOList)) {
            mktmessagePOList.stream().forEach(param -> {
                        param.setBizId(mktTaskId);
                        param.setBizType(TaskConstants.TASK_TYPE);
                        taskMessageService.addTaskMessage(param, stageUser);
                    }
            );
        }

        //6.处理任务
        taskService.doOrderTask(vo,mktTaskPOWithBLOBs,stageUser);

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
    public ResponseData updateInviteTask(TaskDetailVO vo, SysAccountPO stageUser) throws ParseException {
        //        mktTaskOrderPOMapper.updateByPrimaryKeySelective(po);
        //0.参数的检验
        ResponseData responseData = TaskParamCheckUtil.checkParam(vo);
        if (responseData.getCode() < 0) {
            return responseData;
        }
        vo.setValid(Boolean.TRUE);
        vo.setModifiedDate(TimeUtils.getNowTime());
        vo.setModifiedUserName(stageUser.getName());
        vo.setModifiedUserId(stageUser.getSysAccountId());

        Long mktTaskId = vo.getMktTaskId();
        // String taskCode = vo.getTaskCode();
        //1.任务主表修改
        MktTaskPOWithBLOBs mktTaskPOWithBLOBs = new MktTaskPOWithBLOBs();
        BeanUtils.copyProperties(vo, mktTaskPOWithBLOBs);
        //状态的设置
        mktTaskPOWithBLOBs = taskService.isOrNoCheckState(mktTaskPOWithBLOBs);
        taskService.updateTask(mktTaskPOWithBLOBs, stageUser);

        //3.任务消费表修改
        MktTaskInvitePO mktTaskInvitePO = new MktTaskInvitePO();
        BeanUtils.copyProperties(vo, mktTaskInvitePO);
        this.modifieInviteTask(mktTaskInvitePO, stageUser);

        //4.奖励修改 biz_type 活动类型  1=活动
        taskCouponService.deleteTaskCoupon(mktTaskId, stageUser);
        List<MktCouponPO> mktCouponPOList = vo.getMktCouponPOList();
        if (CollectionUtils.isNotEmpty(mktCouponPOList)) {
            mktCouponPOList.stream().forEach(param -> {
                param.setBizId(mktTaskId);
                param.setBizType(TaskConstants.TASK_TYPE);
                taskCouponService.addTaskCoupon(param, stageUser);
            });
        }
        //5.修改消息
        taskMessageService.deleteTaskMessage(mktTaskId,stageUser);
        List<MktMessagePO> mktmessagePOList = vo.getMktmessagePOList();
        if (CollectionUtils.isNotEmpty(mktmessagePOList)) {
            mktmessagePOList.stream().forEach(param -> {
                        param.setBizId(mktTaskId);
                        param.setBizType(TaskConstants.TASK_TYPE);
                        taskMessageService.addTaskMessage(param, stageUser);
                    }
            );
        }
        //6.处理任务
        taskService.doOrderTask(vo,mktTaskPOWithBLOBs,stageUser);

        responseData.setCode(SystemConstants.SUCCESS_CODE);
        responseData.setMessage(SystemConstants.SUCCESS_MESSAGE);
        return responseData;


    }

    /**
     * 新增消费任务
     */
    @Override
    public Integer insertInviteTask(MktTaskInvitePO po, SysAccountPO stageUser) {
        return mktTaskInvitePOMapper.insertSelective(po);
    }

    /**
     * 修改
     *
     * @param stageUser
     * @return
     */
    @Override
    public Integer modifieInviteTask(MktTaskInvitePO po, SysAccountPO stageUser) {
        MktTaskInvitePOExample example = new MktTaskInvitePOExample();
        example.createCriteria().andMktTaskIdEqualTo(po.getMktTaskId()).andValidEqualTo(Boolean.TRUE);
        return mktTaskInvitePOMapper.updateByExample(po, example);
    }
    /**
     * 邀请任务的
     */
}

