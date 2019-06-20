package com.bizvane.mktcenterfacade.rpc;

import com.bizvane.mktcenterfacade.models.vo.InviteSuccessVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * @Author: lijunwei
 * @Time: 2018/8/27 16:06
 */
@FeignClient(value = "${feign.client.mktcenter.name}",path = "${feign.client.mktcenter.path}/activityInviteRpc")
public interface ActivityInviteServiceRpc {

    @PostMapping("/award")
    @io.swagger.annotations.ApiModelProperty(value = "vo",name = "邀请开卡任务的奖励执行", required = false,example = "")
    public void award(@RequestBody @Valid InviteSuccessVO vo);
}
