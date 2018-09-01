package com.bizvane.mktcenterserviceimpl.controllers.rpc;

import com.bizvane.mktcenterservice.interfaces.TaskProfileService;
import com.bizvane.mktcenterservice.models.vo.ProfileSuccessVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: lijunwei
 * @Time: 2018/9/1 15:36
 */
@RestController
@RequestMapping("taskShareRpc")
public class TaskProfileRpcController {

   @Autowired
   private TaskProfileService taskProfileService;
    /**
     * 执行完善资料的任务奖励
     */
    @RequestMapping("doAwardProfile")
    public  void   doAwardProfile(@RequestBody ProfileSuccessVO vo){
        taskProfileService.doAwardProfile(vo);
    }
}
