package com.bizvane.mktcenterserviceimpl.service.impl;

import com.bizvane.mktcenterservice.interfaces.TaskOrderService;
import com.bizvane.mktcenterservice.models.bo.TaskBO;
import com.bizvane.mktcenterservice.models.po.*;
import com.bizvane.mktcenterservice.models.vo.PageForm;
import com.bizvane.mktcenterservice.models.vo.TaskVO;
import com.bizvane.mktcenterserviceimpl.common.constants.TaskConstants;
import com.bizvane.mktcenterserviceimpl.common.utils.CodeUtil;
import com.bizvane.mktcenterserviceimpl.common.utils.TimeUtils;
import com.bizvane.mktcenterserviceimpl.mappers.MktCouponPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktMessagePOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktTaskOrderPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktTaskPOMapper;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
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
    protected MktTaskPOMapper  mktTaskPOMapper;

    @Autowired
    private MktTaskOrderPOMapper mktTaskOrderPOMapper;

    @Autowired
    private MktCouponPOMapper  mktCouponPOMapper;

    @Autowired
    private MktMessagePOMapper mktMessagePOMapper;
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
     * @param bo
     * @param stageUser
     * @return
     */
    @Transactional
    @Override
    public ResponseData<Integer> addTask(TaskBO bo, SysAccountPO stageUser) {
        TaskVO taskVO = bo.getTaskVO();
        taskVO.setCreateDate(TimeUtils.getNowTime());
        //1.任务主表新增
        String taskCode = CodeUtil.getTaskCode();
        MktTaskPOWithBLOBs mktTaskPO = new MktTaskPOWithBLOBs();
        BeanUtils.copyProperties(bo,mktTaskPO);
        mktTaskPO.setTaskCode(taskCode);
        mktTaskPOMapper.insertSelective(mktTaskPO);
        Long mktTaskId = mktTaskPO.getMktTaskId();

        //2.任务消费表新增
        MktTaskOrderPO mktTaskOrderPO = new MktTaskOrderPO();
        mktTaskOrderPO.setMktTaskId(mktTaskId);
        BeanUtils.copyProperties(taskVO,mktTaskPO);
        mktTaskOrderPOMapper.insertSelective(mktTaskOrderPO);

        //3.新增奖励新增  biz_type 活动类型  1=活动
        MktCouponPO mktCouponPO = new MktCouponPO();
        mktCouponPO.setBizId(mktTaskId);
        mktCouponPO.setBizCode(taskCode);
        mktCouponPO.setBizType(TaskConstants.TASK_TYPE);
        BeanUtils.copyProperties(taskVO,mktCouponPO);
        mktCouponPOMapper.insertSelective(mktCouponPO);

        //4.新增消息新增
        MktMessagePO mktMessagePO = new MktMessagePO();
        mktMessagePO.setBizId(mktTaskId);

        mktMessagePOMapper.insertSelective(mktMessagePO);


        return null;
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
     * 更新任务
     * @param bo
     * @param stageUser
     * @return
     */
    @Override
    public ResponseData<Integer> updateTask(TaskBO bo, SysAccountPO stageUser) {
        return null;
    }


}
