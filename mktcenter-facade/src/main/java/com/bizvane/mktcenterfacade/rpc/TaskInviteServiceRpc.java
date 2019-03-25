package com.bizvane.mktcenterfacade.rpc;

import com.bizvane.mktcenterfacade.models.vo.InviteSuccessVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: lijunwei
 * @Time: 2018/8/27 16:06
 */
@FeignClient(value = "${feign.client.mktcenter.name}",path = "${feign.client.mktcenter.path}/taskInviteRpc")
public interface TaskInviteServiceRpc {

    @RequestMapping("/doTaskInvite")
    @io.swagger.annotations.ApiModelProperty(value = "vo",name = "邀请开卡任务的奖励执行", required = false,example = "")
    public  void   doAwardInvite(@RequestBody InviteSuccessVO vo);
}
