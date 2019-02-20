package com.bizvane.mktcenterserviceimpl.controllers;

import com.bizvane.mktcenterservice.interfaces.ActivityGoldenStatisticsService;
import com.bizvane.mktcenterservice.models.bo.ActivityGoldenStatisticsBo;
import com.bizvane.utils.responseinfo.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liufq
 */
@RestController
@RequestMapping("/goldenStatistics")
public class ActivityGoldenStatisticsController {
    @Autowired
    private ActivityGoldenStatisticsService activityGoldenStatisticsService;
    /**
     * 砸金蛋活动统计
     *
     * @param bo
     * @return
     * */
    @RequestMapping("/goldenStatisticsData")
    public ResponseData goldenStatisticsData(ActivityGoldenStatisticsBo bo) {
        return activityGoldenStatisticsService.goldenStatisticsData(bo);
    }

    /**
     * 砸金蛋活动概括
     *
     * @param activityId
     * @return
     * */
    @RequestMapping("/goldenActivityGeneralization")
    public ResponseData goldenActivityGeneralization(Long activityId) {
        return activityGoldenStatisticsService.goldenActivityGeneralization(activityId);
    }

    /**
     * 根据日期区间获取统计数据
     *
     * @param bo
     * @return
     * */
    @RequestMapping("/goldenActivityGeneralizationDate")
    public ResponseData goldenActivityGeneralizationDate(ActivityGoldenStatisticsBo bo) {
        return activityGoldenStatisticsService.goldenActivityGeneralizationDate(bo);
    }
}
