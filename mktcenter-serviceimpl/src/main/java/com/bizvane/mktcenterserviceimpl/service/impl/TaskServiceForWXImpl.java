package com.bizvane.mktcenterserviceimpl.service.impl;

import com.bizvane.mktcenterservice.interfaces.TaskServiceForWX;
import com.bizvane.mktcenterservice.models.vo.TaskVO;
import com.bizvane.mktcenterserviceimpl.common.enums.TaskTypeEnum;
import com.bizvane.utils.responseinfo.ResponseData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Geng on 2018/8/9.
 */
@Service
public class TaskServiceForWXImpl implements TaskServiceForWX{


    @Override
    //获取该会员未完成的任务
    public ResponseData getUnCompleteTask(Long brandId, String memberCode){


        ResponseData responseData = new ResponseData();
        List<TaskVO> taskVOList = new ArrayList<>();
        TaskVO taskVO = new TaskVO();
        taskVO.setMktTaskId((long)1);
        taskVO.setTaskType(TaskTypeEnum.TASK_TYPE_PROFILE.getCode());
        taskVO.setStartTime(new Date());


        taskVOList.add(taskVO);
        responseData.setData(taskVOList);
        return responseData;
    }

    @Override
    //获取该会员已完成的任务
    public ResponseData getCompleteTask(Long brandId,String memberCode){

        ResponseData responseData = new ResponseData();
        List<TaskVO> taskVOList = new ArrayList<>();
        TaskVO taskVO = new TaskVO();
        taskVO.setMktTaskId((long)3);
        taskVO.setTaskType(TaskTypeEnum.TASK_TYPE_CONSUME_AMOUNT.getCode());
        taskVO.setStartTime(new Date());


        taskVOList.add(taskVO);
        responseData.setData(taskVOList);
        return responseData;
    }

}
