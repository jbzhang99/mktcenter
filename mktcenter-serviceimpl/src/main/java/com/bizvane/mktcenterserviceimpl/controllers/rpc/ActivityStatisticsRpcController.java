package com.bizvane.mktcenterserviceimpl.controllers.rpc;

import com.bizvane.mktcenterservice.interfaces.ActivityStatisticsService;
import com.bizvane.utils.responseinfo.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yy
 * @create 2019-01-14 16:49
 */
@RestController
@RequestMapping("statisticsRpc")
public class ActivityStatisticsRpcController {

    @Autowired
    private ActivityStatisticsService activityStatisticsService;

    /**
     * 调用计数器
     * @param activityId
     * @param code
     * @return
     */
    @RequestMapping("statisticsData")
    public ResponseData statisticsData(@RequestParam("activityId") Long activityId, @RequestParam("code") int code,@RequestParam("memberCode") String memberCode){
        return activityStatisticsService.statisticsData(activityId,code,memberCode);
    }
}
