package com.bizvane.mktcenterserviceimpl.controllers;

import com.bizvane.mktcenterservice.interfaces.TaskService;
import com.bizvane.mktcenterservice.models.po.MktTaskPOWithBLOBs;
import com.bizvane.mktcenterservice.models.vo.PageForm;
import com.bizvane.mktcenterservice.models.vo.TaskVO;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author chen.li
 * @date on 2018/7/13 13:30
 * @description 任务
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@RestController
@RequestMapping("task")
public class TaskController {

    @Autowired
    private TaskService taskService;
    /**
     * 根据任务类型查询任务列表
     */
    @RequestMapping("getTaskByTaskType")
    public ResponseData<PageInfo<MktTaskPOWithBLOBs>> getTaskByTaskType(TaskVO vo, PageForm pageForm){
        return  taskService.getTaskByTaskType(vo,pageForm);
    }



    /**
     * 禁用任务
     * @param mktTaskId
     * @return
     */
    @RequestMapping("stopTaskById")
    public ResponseData<Integer> stopTaskById(Long mktTaskId, HttpServletRequest request){
        //获取操作人信息
        SysAccountPO stageUser =new SysAccountPO();
//        SysAccountPO stageUser = TokenUtils.getStageUser(request);
        //禁用任务
        ResponseData<Integer> integerResponseData = taskService.stopTaskById(mktTaskId, stageUser);
        return integerResponseData;
    }

    /**
     * 任务审核
     * @param mktTaskId
     * @param request
     * @return
     */
    @RequestMapping("checkTaskById")
    public ResponseData<Integer> checkTaskById(Long mktTaskId, HttpServletRequest request){
        //获取操作人信息
        SysAccountPO stageUser =new SysAccountPO();
//        SysAccountPO stageUser = TokenUtils.getStageUser(request);
        //审核任务
        ResponseData<Integer> integerResponseData = taskService.checkTaskById(mktTaskId, stageUser);
        return integerResponseData;
    }
}
