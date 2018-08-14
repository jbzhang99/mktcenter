package com.bizvane.mktcenterserviceimpl.controllers.rpc;

import com.bizvane.mktcenterservice.interfaces.TaskServiceForWX;
import com.bizvane.utils.responseinfo.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Geng on 2018/8/9.
 */

@RestController
@RequestMapping("taskForWXRpc")
public class TaskForWXRpcController {

    @Autowired
    private TaskServiceForWX taskServiceForWX;

    @RequestMapping("/getCompleteTask")
    @io.swagger.annotations.ApiModelProperty(value = "brandId,memberCode",name = "该会员已完成的任务列表", required = false,example = "")
    public ResponseData getCompleteTask(Long brandId,String memberCode){

        return taskServiceForWX.getCompleteTask(brandId,memberCode);
    }


}
