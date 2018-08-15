package com.bizvane.mktcenterserviceimpl.service.impl;

import com.bizvane.mktcenterservice.interfaces.TaskServiceForWX;
import com.bizvane.mktcenterservice.models.bo.TaskWXBO;
import com.bizvane.mktcenterservice.models.vo.TaskForWXVO;
import com.bizvane.mktcenterservice.models.vo.TaskVO;
import com.bizvane.mktcenterserviceimpl.common.enums.TaskTypeEnum;
import com.bizvane.mktcenterserviceimpl.mappers.MktTaskPOMapper;
import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.responseinfo.ResponseData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Geng on 2018/8/9.
 */
@Service
public class TaskServiceForWXImpl implements TaskServiceForWX{

    @Autowired
    private MktTaskPOMapper  taskPOMapper;

    @Override
    //获取该会员已完成和未完成任务的任务
    public ResponseData getCompleteTask(TaskForWXVO vo){
        ResponseData<PageInfo<TaskWXBO>> responseData = new ResponseData(SysResponseEnum.SUCCESS.getCode(),SysResponseEnum.SUCCESS.getMessage(),null);
        PageHelper.startPage(vo.getPageNumber(),vo.getPageSize());
        List<TaskWXBO> lists = taskPOMapper.getCompleteTask(vo);
        PageInfo<TaskWXBO> taskWXBOPageInfo = new PageInfo<>(lists);
        responseData.setData(taskWXBOPageInfo);
        return responseData;
    }

}
