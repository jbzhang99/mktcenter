package com.bizvane.mktcenterfacade.rpc;

import com.bizvane.mktcenterfacade.models.bo.ActivityGoldenStatisticsBo;
import com.bizvane.utils.responseinfo.ResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author liufq
 */
@FeignClient(value = "${feign.client.mktcenter.name}",path = "${feign.client.mktcenter.path}/goldenStatisticsRpc")
public interface ActivityGoldenStatisticsServiceRpc {
    /**
     * 砸金蛋活动统计
     *
     * @param bo
     * @return
     * */
    @RequestMapping("/goldenStatisticsData")
    ResponseData goldenStatisticsData(@RequestBody ActivityGoldenStatisticsBo bo);
}
