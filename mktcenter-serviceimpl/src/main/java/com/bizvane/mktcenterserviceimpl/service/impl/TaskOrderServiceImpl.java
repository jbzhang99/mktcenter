package com.bizvane.mktcenterserviceimpl.service.impl;

import com.bizvane.centerstageservice.models.po.SysCheckConfigPo;
import com.bizvane.centerstageservice.models.vo.SysCheckConfigVo;
import com.bizvane.centerstageservice.rpc.SysCheckConfigServiceRpc;
import com.bizvane.mktcenterservice.interfaces.TaskCouponService;
import com.bizvane.mktcenterservice.interfaces.TaskMessageService;
import com.bizvane.mktcenterservice.interfaces.TaskOrderService;
import com.bizvane.mktcenterservice.interfaces.TaskService;
import com.bizvane.mktcenterservice.models.bo.TaskDetailBO;
import com.bizvane.mktcenterservice.models.po.*;
import com.bizvane.mktcenterservice.models.vo.TaskConsumeVO;
import com.bizvane.mktcenterservice.models.vo.TaskVO;
import com.bizvane.mktcenterserviceimpl.common.constants.SystemConstants;
import com.bizvane.mktcenterserviceimpl.common.constants.TaskConstants;
import com.bizvane.mktcenterserviceimpl.common.enums.CheckStatusEnum;
import com.bizvane.mktcenterserviceimpl.common.enums.TaskStatusEnum;
import com.bizvane.mktcenterserviceimpl.common.utils.CodeUtil;
import com.bizvane.mktcenterserviceimpl.common.utils.TaskParamCheckUtil;
import com.bizvane.mktcenterserviceimpl.common.utils.TimeUtils;
import com.bizvane.mktcenterserviceimpl.mappers.MktTaskOrderPOMapper;
import com.bizvane.utils.enumutils.SysResponseEnum;
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
 * @date on 2018/7/16 14:13
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@Service
public class TaskOrderServiceImpl implements TaskOrderService {

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
    public  Integer  checkOrderTask(TaskVO vo){
        MktTaskOrderPO mktTaskOrderPO = new MktTaskOrderPO();
        BeanUtils.copyProperties(vo,mktTaskOrderPO);
        return  mktTaskOrderPOMapper.updateByPrimaryKeySelective(mktTaskOrderPO);

    }
    /**
     * 根据任务Id查询任务详情
     */
    @Override
    public List<TaskDetailBO> getOrderTaskDetails(Long mktTaskId) {
        return mktTaskOrderPOMapper.getOrderTaskDetails(mktTaskId);
    }

    /**
     *查询任务列表
     * @return
     */
    @Override
    public List<TaskVO> selectTask(TaskVO vo) {
        return mktTaskOrderPOMapper.getTaskList(vo);
    }
    /**
     * 创建任务
     * @param vo
     * @param stageUser
     * @return
     */
    @Transactional
    @Override
    public ResponseData<Integer> addTask(TaskConsumeVO vo, SysAccountPO stageUser) throws ParseException {
        //0.参数的检验
        ResponseData responseData = TaskParamCheckUtil.checkParam(vo);
        if (responseData.getCode()<0){
            return responseData;
        }
        //1.生成任务编号
        String taskCode = CodeUtil.getTaskCode();
        //2.任务主表新增
        MktTaskPOWithBLOBs mktTaskPOWithBLOBs = vo.getMktTaskPOWithBLOBs();
        mktTaskPOWithBLOBs = this.isOrNoCheckState(mktTaskPOWithBLOBs);
        mktTaskPOWithBLOBs.setTaskCode(taskCode);

        Long mktTaskId = taskService.addTask(mktTaskPOWithBLOBs, stageUser);

        //3.任务消费表新增
        MktTaskOrderPO mktTaskOrderPO = vo.getMktTaskOrderPO();
        mktTaskOrderPO.setMktTaskId(mktTaskId);
        this.insertOrderTask(mktTaskOrderPO,stageUser);

        //4.新增奖励新增  biz_type 活动类型  1=活动
        List<MktCouponPO> mktCouponPOList = vo.getMktCouponPOList();
        if (CollectionUtils.isNotEmpty(mktCouponPOList)){
            mktCouponPOList.stream().forEach(param->{
                param.setBizId(mktTaskId);
                param.setBizCode(taskCode);
                param.setBizType(TaskConstants.TASK_TYPE);
                taskCouponService.addTaskCoupon(param,stageUser);
            });
        }
        //5.新增消息新增
        List<MktMessagePO> mktmessagePOList = vo.getMktmessagePOList();
        if (CollectionUtils.isNotEmpty(mktmessagePOList)){
            mktmessagePOList.stream().forEach(param-> {
                        param.setBizId(mktTaskId);
                        taskMessageService.addTaskMessage(param,stageUser);
                    }
            );
        }

        //6.判断时间是否滞后   2=滞后执行    3=立即执行
        Integer ImmediatelyRunStatus = TimeUtils.IsImmediatelyRun(mktTaskPOWithBLOBs.getStartTime());
//        if(TaskConstants.ZERO.equals(checkStatus)){
//            //任务待审核=0,判断是否要滞后执行
//            if (TaskConstants.SECOND.equals(ImmediatelyRunStatus)){
//
//            }else if(TaskConstants.SECOND.equals(ImmediatelyRunStatus)){
//
//            }
//
//        }else{
//            //任务已审核=3,判断是否要滞后执行
//
//        }
        responseData.setCode(SystemConstants.SUCCESS_CODE);
        responseData.setMessage(SystemConstants.SUCCESS_MESSAGE);
        return responseData;
    }

    /**
     * 判断是否滞后执行
     */
    public  MktTaskPOWithBLOBs   isOrNoCheckState(MktTaskPOWithBLOBs po) throws ParseException {
        //1.判断是否需要审核  1:需要审核 0:不需要
        SysCheckConfigPo sysCheckConfigPo = new SysCheckConfigPo();
        sysCheckConfigPo.setSysBrandId(po.getSysBrandId());
        Integer checkStatus = taskService.getCheckStatus(sysCheckConfigPo);
        //判断时间是否滞后   2=滞后执行    3和1=立即执行
        Integer ImmediatelyRunStatus = TimeUtils.IsImmediatelyRun(po.getStartTime());
        if(TaskConstants.ZERO.equals(checkStatus)){
            //待审核=1
            po.setCheckStatus(CheckStatusEnum.CHECK_STATUS_PENDING.getCode());
            //待执行=1
            po.setCheckStatus(TaskStatusEnum.TASK_STATUS_PENDING.getCode());
        }else{
            //已审核=3
            po.setCheckStatus(TaskConstants.THREE);
            if(TaskConstants.THREE.equals(ImmediatelyRunStatus)){
                //待执行
                po.setCheckStatus(TaskStatusEnum.TASK_STATUS_PENDING.getCode());
            }else{
                //执行中
                po.setCheckStatus(TaskStatusEnum.TASK_STATUS_EXECUTING.getCode());
            }
        }
        return po;
    }

    /**
     * 判断时间是否滞后,已经是否立即执行,还是创建job执行
     */
    public  void   doOrderTask(TaskConsumeVO vo){
        MktTaskPOWithBLOBs mktTaskPO = vo.getMktTaskPOWithBLOBs();
        Integer checkStatus = mktTaskPO.getCheckStatus();//审核状态
        Integer taskStatus = mktTaskPO.getTaskStatus();//执行状态
        //已审核   执行中  执行时间小于当前时间 或等于当前时间
        if (TaskConstants.THREE.equals(checkStatus) && TaskConstants.SECOND.equals(taskStatus) ){

           if (CollectionUtils.isNotEmpty(vo.getMktCouponPOList())){

           }
         }
         //已审核   待执行,创建job
        if (TaskConstants.THREE.equals(checkStatus) && TaskConstants.FIRST.equals(taskStatus) ){

        }

    }

    /**
     * 更新任务
     */
    @Override
    public ResponseData<Integer> updateTask(MktTaskOrderPO po,SysAccountPO stageUser) {
        return null;
    }
    /**
     * 新增消费任务
     */
    public Integer  insertOrderTask(MktTaskOrderPO po,SysAccountPO stageUser){

        po.setCreateDate(TimeUtils.getNowTime());
        po.setCreateUserId(stageUser.getSysAccountId());
        po.setCreateUserName(stageUser.getName());

        return  mktTaskOrderPOMapper.insertSelective(po);
    }
    /**
     * 执行任务
     * @param vo
     * @return
     */
    @Override
    public ResponseData<Integer> executeTask(TaskVO vo) {
        return null;
    }

    /**
     * 更新消费任务
     * @param stageUser
     * @return
     */
    @Override
    public Integer updateOrderTask(MktTaskOrderPO po,SysAccountPO stageUser) {
        po.setModifiedDate(TimeUtils.getNowTime());
        po.setModifiedUserId(stageUser.getSysAccountId());
        po.setCreateUserName(stageUser.getName());

        return  mktTaskOrderPOMapper.updateByPrimaryKeySelective(po);

    }


}
