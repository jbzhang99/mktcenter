package com.bizvane.mktcenterserviceimpl.controllers.rpc;

import com.bizvane.mktcenterservice.interfaces.ActivityGoldenStatisticsService;
import com.bizvane.mktcenterservice.models.bo.ActivityGoldenStatisticsBo;
import com.bizvane.utils.responseinfo.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liufq
 */
@RestController
@RequestMapping("/goldenStatisticsRpc")
public class ActivityGoldenStatisticsRpcController {

    @Autowired
    private ActivityGoldenStatisticsService activityGoldenStatisticsService;

    /**
     * 砸金蛋活动统计
     *
     * @param bo
     * @return
     * */
    @RequestMapping("/goldenStatisticsData")
    public ResponseData goldenStatisticsData(@RequestBody ActivityGoldenStatisticsBo bo) {
        return activityGoldenStatisticsService.goldenStatisticsData(bo);
    }
}
