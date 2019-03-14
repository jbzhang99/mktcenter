package com.bizvane.mktcenterfacade.rpc;

import com.bizvane.mktcenterfacade.models.vo.ShareSuccessVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: lijunwei
 * @Time: 2018/9/3 15:46
 */
@FeignClient(value = "${feign.client.mktcenter.name}",path = "${feign.client.mktcenter.path}/taskShareRpc")
public interface TaskShareServiceRpc {
    /**
     * 执行分享任务的奖励
     * @param vo
     */
    @RequestMapping("doAwardShare")
    public  void   doAwardShare(@RequestBody ShareSuccessVO vo);
}
