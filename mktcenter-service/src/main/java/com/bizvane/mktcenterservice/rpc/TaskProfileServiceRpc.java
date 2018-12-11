package com.bizvane.mktcenterservice.rpc;

import com.bizvane.mktcenterservice.models.vo.InviteSuccessVO;
import com.bizvane.mktcenterservice.models.vo.ProfileSuccessVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: lijunwei
 * @Time: 2018/9/1 15:39
 */
@FeignClient(value = "${feign.client.mktcenter.name}",path = "${feign.client.mktcenter.path}/taskProfileRpc")
public interface TaskProfileServiceRpc {

    @RequestMapping("/doAwardProfile")
    public  void   doAwardInvite(@RequestBody ProfileSuccessVO vo);
}
