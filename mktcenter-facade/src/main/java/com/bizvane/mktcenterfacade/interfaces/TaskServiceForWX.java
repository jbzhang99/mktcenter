package com.bizvane.mktcenterfacade.interfaces;

import com.bizvane.centercontrolservice.models.bo.AppletFunctionBO;
import com.bizvane.mktcenterfacade.models.bo.TaskWXBO;
import com.bizvane.mktcenterfacade.models.bo.TaskWXDetailBO;
import com.bizvane.mktcenterfacade.models.vo.TaskForWXVO;
import com.bizvane.utils.responseinfo.ResponseData;
import com.github.pagehelper.PageInfo;

/**
 * Created by Geng on 2018/8/9.
 */
public interface TaskServiceForWX {


    //获取该会员已完成的任务和未完成任务
    public ResponseData<PageInfo<TaskWXBO>> getCompleteTask(TaskForWXVO vo);
   //获取任务详情
    public  ResponseData<TaskWXDetailBO>  getTaskWXDetail(Long taskId);
    //获取链接详情
    public ResponseData<AppletFunctionBO>  getURLDetail(TaskForWXVO vo);


}
