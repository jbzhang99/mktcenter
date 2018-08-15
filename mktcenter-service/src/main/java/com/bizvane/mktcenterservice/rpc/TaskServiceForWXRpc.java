package com.bizvane.mktcenterservice.rpc;

import com.bizvane.mktcenterservice.models.bo.TaskWXDetailBO;
import com.bizvane.mktcenterservice.models.vo.TaskForWXVO;
import com.bizvane.utils.responseinfo.ResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Geng on 2018/8/9.
 */

@FeignClient("${feign.client.mktcenter.name}")
@RequestMapping("${feign.client.mktcenter.path}/taskForWXRpc")
public interface TaskServiceForWXRpc {



    @RequestMapping("/getCompleteTask")
    @io.swagger.annotations.ApiModelProperty(value = "brandId,memberCode",name = "该会员已完成和未完成的任务列表", required = false,example = "")
    public ResponseData getCompleteTask(@RequestBody TaskForWXVO vo);

    @RequestMapping("/getTaskWXDetail")
    @io.swagger.annotations.ApiModelProperty(value = "taskCode",name = "任务code", required = false,example = "")
    public  ResponseData<TaskWXDetailBO>  getTaskWXDetail(@RequestParam String taskCode);
}
