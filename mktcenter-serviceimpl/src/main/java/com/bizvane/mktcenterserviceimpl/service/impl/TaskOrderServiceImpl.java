package com.bizvane.mktcenterserviceimpl.service.impl;

import com.bizvane.mktcenterservice.interfaces.TaskOrderService;
import com.bizvane.mktcenterservice.models.bo.TaskBO;
import com.bizvane.mktcenterservice.models.vo.PageForm;
import com.bizvane.mktcenterservice.models.vo.TaskVO;
import com.bizvane.mktcenterserviceimpl.mappers.MktTaskOrderPOMapper;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private MktTaskOrderPOMapper mktTaskOrderPOMapper;


    /**
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
    @Override
    public ResponseData<Integer> addTask(TaskBO bo, SysAccountPO stageUser) {
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
