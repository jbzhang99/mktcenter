package com.bizvane.mktcenterserviceimpl.controllers;

import com.bizvane.mktcenterservice.interfaces.ActivityGoldenStatisticsService;
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
     * @param activityId 活动id
     * @param code 枚举值： 1、访问人数 2、参与会员数 3、页面转发次数 4、有效分享人数 5、注册会员数
     * @param memberCode 会员code
     * */
    @RequestMapping("/goldenStatisticsData")
    public ResponseData goldenStatisticsData(Long activityId, int code, String memberCode) {
        return activityGoldenStatisticsService.goldenStatisticsData(activityId, code, memberCode);
    }

    /**
     * 砸金蛋活动概括
     *
     * @param activityId
     *
     * @return
     * */
    @RequestMapping("/goldenActivityGeneralization")
    public ResponseData goldenActivityGeneralization(Long activityId) {
        return activityGoldenStatisticsService.goldenActivityGeneralization(activityId);
    }
}
