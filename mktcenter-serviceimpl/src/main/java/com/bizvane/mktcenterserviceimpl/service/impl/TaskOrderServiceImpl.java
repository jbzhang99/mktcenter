package com.bizvane.mktcenterserviceimpl.service.impl;

import com.bizvane.centerstageservice.models.po.SysCheckConfigPo;
import com.bizvane.centerstageservice.models.vo.SysCheckConfigVo;
import com.bizvane.centerstageservice.rpc.SysCheckConfigServiceRpc;
import com.bizvane.mktcenterservice.interfaces.TaskCouponService;
import com.bizvane.mktcenterservice.interfaces.TaskMessageService;
import com.bizvane.mktcenterservice.interfaces.TaskOrderService;
import com.bizvane.mktcenterservice.interfaces.TaskService;
import com.bizvane.mktcenterservice.models.po.*;
import com.bizvane.mktcenterservice.models.vo.TaskConsumeVO;
import com.bizvane.mktcenterservice.models.vo.TaskVO;
import com.bizvane.mktcenterserviceimpl.common.constants.SystemConstants;
import com.bizvane.mktcenterserviceimpl.common.constants.TaskConstants;
import com.bizvane.mktcenterserviceimpl.common.utils.CodeUtil;
import com.bizvane.mktcenterserviceimpl.common.utils.TaskParamCheckUtil;
import com.bizvane.mktcenterserviceimpl.common.utils.TimeUtils;
import com.bizvane.mktcenterserviceimpl.mappers.MktTaskOrderPOMapper;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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



    /**s
     * 查询任务
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
    public ResponseData<Integer> addTask(TaskConsumeVO vo, SysAccountPO stageUser) {
        SysCheckConfigPo sysCheckConfigPo = new SysCheckConfigPo();
        sysCheckConfigPo.setSysBrandId(vo.getMktTaskPOWithBLOBs().getSysBrandId());
        Integer checkStatus = taskService.getCheckStatus(sysCheckConfigPo);

        //0.参数的检验
        ResponseData responseData = TaskParamCheckUtil.checkParam(vo);
        if (responseData.getCode()<0){
            return responseData;
        }

        String taskCode = CodeUtil.getTaskCode();
        //1.任务主表新增
        MktTaskPOWithBLOBs mktTaskPOWithBLOBs = vo.getMktTaskPOWithBLOBs();
        mktTaskPOWithBLOBs.setTaskCode(taskCode);
        Long mktTaskId = taskService.addTask(mktTaskPOWithBLOBs, stageUser);

        //2.任务消费表新增
        MktTaskOrderPO mktTaskOrderPO = vo.getMktTaskOrderPO();
        mktTaskOrderPO.setMktTaskId(mktTaskId);
        this.insertOrderTask(mktTaskOrderPO,stageUser);

        //3.新增奖励新增  biz_type 活动类型  1=活动
        List<MktCouponPO> mktCouponPOList = vo.getMktCouponPOList();

        if (CollectionUtils.isNotEmpty(mktCouponPOList)){

            mktCouponPOList.stream().forEach(param->{
                param.setBizId(mktTaskId);
                param.setBizCode(taskCode);
                param.setBizType(TaskConstants.TASK_TYPE);
                taskCouponService.addTaskCoupon(param,stageUser);
            });

        }


        //4.新增消息新增
        List<MktMessagePO> mktmessagePOList = vo.getMktmessagePOList();
        if (CollectionUtils.isNotEmpty(mktmessagePOList)){
            mktmessagePOList.stream().forEach(param-> {
                param.setBizId(mktTaskId);
                taskMessageService.addTaskMessage(param,stageUser);
            }
            );
        }

        responseData.setCode(SystemConstants.SUCCESS_CODE);
        responseData.setMessage(SystemConstants.SUCCESS_MESSAGE);
        return responseData;
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
