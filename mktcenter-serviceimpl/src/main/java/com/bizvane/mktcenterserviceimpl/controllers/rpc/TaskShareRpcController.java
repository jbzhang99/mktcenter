package com.bizvane.mktcenterserviceimpl.controllers.rpc;

import com.bizvane.mktcenterservice.interfaces.TaskShareService;
import com.bizvane.mktcenterservice.models.vo.ShareSuccessVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: lijunwei
 * @Time: 2018/9/1 17:58
 */
@RestController
@RequestMapping("taskShareRpc")
public class TaskShareRpcController {
    @Autowired
    private TaskShareService taskShareService;

    /**
     * 执行分享任务的奖励
     * @param vo
     */
    @RequestMapping("doAwardShare")
    public  void   doAwardShare(@RequestBody  ShareSuccessVO vo){
        taskShareService.doAwardShare(vo);
    }
}
