package com.bizvane.mktcenterservice.rpc;

import com.bizvane.utils.responseinfo.ResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Geng on 2018/8/9.
 */

@FeignClient("${feign.client.mktcenter.name}")
@RequestMapping("${feign.client.mktcenter.path}/taskForWXRpc")
public interface TaskServiceForWXRpc {



    @RequestMapping("/getCompleteTask")
    @io.swagger.annotations.ApiModelProperty(value = "brandId,memberCode",name = "该会员已完成和未完成的任务列表", required = false,example = "")
    public ResponseData getCompleteTask(Long brandId,String memberCode);
}
