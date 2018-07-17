package com.bizvane.mktcenterserviceimpl.service.impl;

import com.bizvane.mktcenterservice.interfaces.TaskService;
import com.bizvane.mktcenterservice.models.po.MktTaskPO;
import com.bizvane.mktcenterservice.models.po.MktTaskPOWithBLOBs;
import com.bizvane.mktcenterserviceimpl.common.enums.CheckStatusEnum;
import com.bizvane.mktcenterserviceimpl.common.enums.TaskStatusEnum;
import com.bizvane.mktcenterserviceimpl.mappers.MktTaskPOMapper;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @author chen.li
 * @date on 2018/7/16 14:11
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
public class TaskServiceImpl implements TaskService {

    @Autowired
    private MktTaskPOMapper mktTaskPOMapper;

    /**
     * 禁用/停用任务
     * @param mktTaskId
     * @param sysAccountPO
     * @return
     */
    @Override
    public ResponseData<Integer> stopTaskById(Long mktTaskId, SysAccountPO sysAccountPO) {
        ResponseData responseData = new ResponseData();
        MktTaskPOWithBLOBs mktTaskPOWithBLOBs = new MktTaskPOWithBLOBs();
        mktTaskPOWithBLOBs.setMktTaskId(mktTaskId);
        mktTaskPOWithBLOBs.setTaskStatus(TaskStatusEnum.TASK_STATUS_DISABLED.getCode());
        mktTaskPOWithBLOBs.setModifiedDate(new Date());
        mktTaskPOWithBLOBs.setModifiedUserId(sysAccountPO.getSysAccountId());
        mktTaskPOWithBLOBs.setModifiedUserName(sysAccountPO.getName());
        mktTaskPOMapper.updateByPrimaryKeySelective(mktTaskPOWithBLOBs);
        return responseData;
    }

    /**
     * 任务审核:通过/驳回
     * @param mktTaskId
     * @param sysAccountPO
     * @return
     */
    @Override
    public ResponseData<Integer> checkTaskById(Long mktTaskId, SysAccountPO sysAccountPO) {
        ResponseData responseData = new ResponseData();
        MktTaskPOWithBLOBs mktTaskPOWithBLOBs = new MktTaskPOWithBLOBs();
        mktTaskPOWithBLOBs.setMktTaskId(mktTaskId);
        mktTaskPOWithBLOBs.setTaskStatus(CheckStatusEnum.CHECK_STATUS_APPROVED.getCode());
        mktTaskPOWithBLOBs.setModifiedDate(new Date());
        mktTaskPOWithBLOBs.setModifiedUserId(sysAccountPO.getSysAccountId());
        mktTaskPOWithBLOBs.setModifiedUserName(sysAccountPO.getName());
        mktTaskPOMapper.updateByPrimaryKeySelective(mktTaskPOWithBLOBs);
        return responseData;
    }
}
