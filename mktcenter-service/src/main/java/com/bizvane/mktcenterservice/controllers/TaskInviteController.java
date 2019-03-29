package com.bizvane.mktcenterservice.controllers;

import com.bizvane.mktcenterfacade.interfaces.TaskInviteService;
import com.bizvane.mktcenterfacade.models.bo.TaskBO;
import com.bizvane.mktcenterfacade.models.vo.InviteSuccessVO;

import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.bizvane.utils.tokens.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

/**
 * @author chen.li
 * @date on 2018/7/13 13:38
 * @description
 *
 * 消费金额任务
 */
@RestController
@RequestMapping("/taskInvite")
public class TaskInviteController {
    @Autowired
    private TaskInviteService taskInviteService;
    /**
     * 创建任务
     * @return
     */
    @RequestMapping("/addTask")
    public ResponseData<Integer> addTask(TaskBO bo , HttpServletRequest request) throws ParseException {
        //参数校验通过，获取操作人信息
        SysAccountPO sysAccountPo = TokenUtils.getStageUser(request);
        bo.getTaskVO().setTaskType(3);
        return  taskInviteService.addTask(bo, sysAccountPo);
    }
    /**
     * 修改任务
     */
    @RequestMapping("/updateInviteTask")
    public ResponseData updateInviteTask(TaskBO bo, HttpServletRequest request) throws ParseException {
        SysAccountPO stageUser = TokenUtils.getStageUser(request);
        return  taskInviteService.updateInviteTask(bo, stageUser);
    }

    @RequestMapping("/doAwardInvite")
    public  void   doAwardInvite(InviteSuccessVO vo){
        taskInviteService.doAwardInvite( vo);
    }
}
