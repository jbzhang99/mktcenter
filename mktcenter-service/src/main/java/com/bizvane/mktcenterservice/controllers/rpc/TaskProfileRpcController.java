package com.bizvane.mktcenterservice.controllers.rpc;

import com.bizvane.mktcenterfacade.interfaces.TaskProfileService;
import com.bizvane.mktcenterfacade.models.bo.TaskDetailBO;
import com.bizvane.mktcenterfacade.models.vo.ProfileSuccessVO;
import com.bizvane.utils.responseinfo.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: lijunwei
 * @Time: 2018/9/1 15:36
 */
@RestController
@RequestMapping("taskProfileRpc")
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

    @RequestMapping("getTaskProfileListApp")
    public ResponseData<List<TaskDetailBO>> getTaskProfileListApp(@RequestBody ProfileSuccessVO vo){
      return  taskProfileService.getTaskProfileListApp(vo);
    }
}
