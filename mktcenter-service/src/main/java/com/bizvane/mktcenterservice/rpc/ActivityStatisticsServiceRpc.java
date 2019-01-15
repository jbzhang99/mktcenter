package com.bizvane.mktcenterservice.rpc;

import com.bizvane.utils.responseinfo.ResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author yy
 * @create 2019-01-14 16:43
 */
@FeignClient(value = "${feign.client.mktcenter.name}",path = "${feign.client.mktcenter.path}/statisticsRpc")
public interface ActivityStatisticsServiceRpc {

    /**
     * 操作计数器
     * @param activityId
     * @param code
     * @return
     */
    @RequestMapping("statisticsData")
    ResponseData statisticsData(@RequestParam("activityId") Long activityId, @RequestParam("code") int code,@RequestParam("memberCode") String memberCode);
}


