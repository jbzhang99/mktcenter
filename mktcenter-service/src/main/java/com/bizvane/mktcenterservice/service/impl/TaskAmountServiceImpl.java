package com.bizvane.mktcenterservice.service.impl;

import com.bizvane.mktcenterfacade.interfaces.TaskAmountService;
import com.bizvane.mktcenterfacade.interfaces.TaskCouponService;
import com.bizvane.mktcenterfacade.interfaces.TaskMessageService;
import com.bizvane.mktcenterfacade.interfaces.TaskService;
import com.bizvane.mktcenterfacade.models.bo.TaskBO;
import com.bizvane.mktcenterfacade.models.bo.TaskDetailBO;
import com.bizvane.mktcenterfacade.models.po.*;

import com.bizvane.mktcenterfacade.models.vo.TaskVO;
import com.bizvane.mktcenterservice.common.constants.SystemConstants;
import com.bizvane.mktcenterservice.common.constants.TaskConstants;
import com.bizvane.mktcenterservice.common.utils.CodeUtil;
import com.bizvane.mktcenterservice.common.utils.TaskParamCheckUtil;
import com.bizvane.mktcenterservice.common.utils.TimeUtils;
import com.bizvane.mktcenterservice.mappers.MktTaskOrderPOMapper;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * @Author: lijunwei
 * @Time: 2018/8/2 18:04
 */
@Service
public class TaskAmountServiceImpl implements TaskAmountService {
    @Autowired
    protected TaskService taskService;

    @Autowired
    private TaskCouponService taskCouponService;

    @Autowired
    private TaskMessageService taskMessageService;

    @Autowired
    private MktTaskOrderPOMapper mktTaskOrderPOMapper;
    /**
     * 审核任务:任务id   任务状态
     * 审核状态：1未审核，2审核中，3已审核，4已驳回',
     */
    @Override
    public Integer checkAmountTask(TaskVO vo) {
        MktTaskOrderPO mktTaskOrderPO = new MktTaskOrderPO();
        BeanUtils.copyProperties(vo, mktTaskOrderPO);
        return mktTaskOrderPOMapper.updateByPrimaryKeySelective(mktTaskOrderPO);

    }

    /**
     * 根据任务Id查询任务详情
     */
    @Override
    public List<TaskDetailBO> getAmountTaskDetails(Long mktTaskId) {
        return mktTaskOrderPOMapper.getOrderTaskDetails(mktTaskId);
    }
    /**
     * 查询任务列表
     * @return
     */
    @Override
    public List<TaskVO> selectTask(TaskVO vo) {
        return mktTaskOrderPOMapper.getTaskList(vo);
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
        TaskVO vo = bo.getTaskVO();
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
        //1.判断是否需要审核  1=需要审核   0=不需要
        Integer StagecheckStatus = taskService.getCenterStageCheckStage(mktTaskPOWithBLOBs);
        mktTaskPOWithBLOBs = taskService.isOrNoCheckState(mktTaskPOWithBLOBs,StagecheckStatus);
        Long mktTaskId = taskService.addTask(mktTaskPOWithBLOBs, stageUser);
        if(TaskConstants.FIRST.equals(StagecheckStatus)){
            taskService.addCheckData(mktTaskPOWithBLOBs);
        }

        //3.任务消费表新增
        MktTaskOrderPO mktTaskOrderPO = new MktTaskOrderPO();
        BeanUtils.copyProperties(vo, mktTaskOrderPO);
        mktTaskOrderPO.setMktTaskId(mktTaskId);
        //mktTaskPOWithBLOBs = taskService.isOrNoCheckState(mktTaskPOWithBLOBs);
        this.insertAmoutTask(mktTaskOrderPO, stageUser);
        //taskService.addCheckData(mktTaskPOWithBLOBs);

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
    public ResponseData updateAmountTask(TaskBO bo, SysAccountPO stageUser) {
        //0.参数的检验
        ResponseData responseData = TaskParamCheckUtil.checkParam(bo);
        //参数校验不通过
        if(responseData.getCode()>0){
            return responseData;
        }
        TaskVO vo = bo.getTaskVO();
        vo.setValid(Boolean.TRUE);
        vo.setModifiedDate(TimeUtils.getNowTime());
        vo.setModifiedUserName(stageUser.getName());
        vo.setModifiedUserId(stageUser.getSysAccountId());

        Long mktTaskId = vo.getMktTaskId();
        // String taskCode = vo.getTaskCode();
        //1.任务主表修改
        MktTaskPOWithBLOBs mktTaskPOWithBLOBs = new MktTaskPOWithBLOBs();
        BeanUtils.copyProperties(vo, mktTaskPOWithBLOBs);
        taskService.updateTask(mktTaskPOWithBLOBs, stageUser);

        //3.任务消费表修改
        MktTaskOrderPO mktTaskOrderPO = new MktTaskOrderPO();
        BeanUtils.copyProperties(vo, mktTaskOrderPO);
        this.modifieAmoutTask(mktTaskOrderPO, stageUser);

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
    public Integer insertAmoutTask(MktTaskOrderPO po, SysAccountPO stageUser) {
        po.setSysCompanyId(stageUser.getSysCompanyId());
        po.setCreateUserName(stageUser.getName());
        po.setCreateUserId(stageUser.getSysAccountId());
        po.setCreateDate(new Date());
        return mktTaskOrderPOMapper.insertSelective(po);
    }

    /**
     * 修改
     *
     * @param stageUser
     * @return
     */
    @Override
    public Integer modifieAmoutTask(MktTaskOrderPO po, SysAccountPO stageUser) {
        MktTaskOrderPOExample example = new MktTaskOrderPOExample();
        example.createCriteria().andMktTaskIdEqualTo(po.getMktTaskId()).andValidEqualTo(Boolean.TRUE);
        return mktTaskOrderPOMapper.updateByExample(po, example);
    }
}
