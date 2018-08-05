package com.bizvane.mktcenterserviceimpl.service.impl;

import com.bizvane.centerstageservice.models.po.SysCheckConfigPo;
import com.bizvane.mktcenterservice.interfaces.TaskAmountService;
import com.bizvane.mktcenterservice.interfaces.TaskCouponService;
import com.bizvane.mktcenterservice.interfaces.TaskMessageService;
import com.bizvane.mktcenterservice.interfaces.TaskService;
import com.bizvane.mktcenterservice.models.bo.TaskDetailBO;
import com.bizvane.mktcenterservice.models.po.*;
import com.bizvane.mktcenterservice.models.vo.TaskDetailVO;
import com.bizvane.mktcenterservice.models.vo.TaskVO;
import com.bizvane.mktcenterserviceimpl.common.constants.SystemConstants;
import com.bizvane.mktcenterserviceimpl.common.constants.TaskConstants;
import com.bizvane.mktcenterserviceimpl.common.enums.CheckStatusEnum;
import com.bizvane.mktcenterserviceimpl.common.enums.TaskStatusEnum;
import com.bizvane.mktcenterserviceimpl.common.utils.CodeUtil;
import com.bizvane.mktcenterserviceimpl.common.utils.TaskParamCheckUtil;
import com.bizvane.mktcenterserviceimpl.common.utils.TimeUtils;
import com.bizvane.mktcenterserviceimpl.mappers.MktTaskOrderPOMapper;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
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
     *
     * @return
     */
    @Override
    public List<TaskVO> selectTask(TaskVO vo) {
        return mktTaskOrderPOMapper.getTaskList(vo);
    }

    /**
     * 创建任务
     *
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
        Long mktTaskId = taskService.addTask(mktTaskPOWithBLOBs, stageUser);

        //3.任务消费表新增
        MktTaskOrderPO mktTaskOrderPO = new MktTaskOrderPO();
        BeanUtils.copyProperties(vo, mktTaskOrderPO);
        mktTaskOrderPO.setMktTaskId(mktTaskId);
        this.insertAmoutTask(mktTaskOrderPO, stageUser);

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
    public ResponseData updateAmountTask(TaskDetailVO vo, SysAccountPO stageUser) {
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
        taskService.updateTask(mktTaskPOWithBLOBs, stageUser);

        //3.任务消费表修改
        MktTaskOrderPO mktTaskOrderPO = new MktTaskOrderPO();
        BeanUtils.copyProperties(vo, mktTaskOrderPO);
        this.modifieAmoutTask(mktTaskOrderPO, stageUser);

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
    public Integer insertAmoutTask(MktTaskOrderPO po, SysAccountPO stageUser) {
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
