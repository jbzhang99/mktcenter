package com.bizvane.mktcenterservice.rpc;

import com.bizvane.mktcenterservice.models.vo.ShareSuccessVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: lijunwei
 * @Time: 2018/9/3 15:46
 */
@FeignClient("${feign.client.mktcenter.name}")
@RequestMapping("${feign.client.mktcenter.path}/taskShareRpc")
public interface TaskShareServiceRpc {
    /**
     * 执行分享任务的奖励
     * @param vo
     */
    @RequestMapping("doAwardShare")
    public  void   doAwardShare(@RequestBody ShareSuccessVO vo);
}
