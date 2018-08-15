package com.bizvane.mktcenterservice.interfaces;

import com.bizvane.mktcenterservice.models.bo.TaskWXDetailBO;
import com.bizvane.mktcenterservice.models.vo.TaskForWXVO;
import com.bizvane.utils.responseinfo.ResponseData;

/**
 * Created by Geng on 2018/8/9.
 */
public interface TaskServiceForWX {


    //获取该会员已完成的任务和未完成任务
    public ResponseData getCompleteTask(TaskForWXVO vo);
   //获取任务详情
    public  ResponseData<TaskWXDetailBO>  getTaskWXDetail(String taskCode);


}
