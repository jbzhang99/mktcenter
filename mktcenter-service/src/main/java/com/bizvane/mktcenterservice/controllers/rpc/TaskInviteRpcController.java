package com.bizvane.mktcenterservice.controllers.rpc;

import com.bizvane.mktcenterfacade.interfaces.TaskInviteService;
import com.bizvane.mktcenterfacade.models.vo.InviteSuccessVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: lijunwei
 * @Time: 2018/8/27 15:42
 * 邀请开卡任务
 */
@RestController
@RequestMapping("/taskInviteRpc")
public class TaskInviteRpcController {
    @Autowired
    private TaskInviteService taskInviteService;

    @RequestMapping("/doTaskInvite")
    @io.swagger.annotations.ApiModelProperty(value = "vo",name = "邀请开卡任务的奖励执行", required = false,example = "")
    public void getCompleteTask(@RequestBody InviteSuccessVO vo){
        taskInviteService.doAwardInvite(vo);
    }


}

