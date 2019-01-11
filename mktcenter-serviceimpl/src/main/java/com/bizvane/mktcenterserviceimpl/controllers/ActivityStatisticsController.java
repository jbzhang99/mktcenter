package com.bizvane.mktcenterserviceimpl.controllers;

import com.bizvane.mktcenterservice.interfaces.ActivityStatisticsService;
import com.bizvane.utils.responseinfo.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yy
 * @create 2019-01-11 11:15
 */
@RestController
@RequestMapping("statistics")
@Slf4j
public class ActivityStatisticsController {

    @Autowired
    private ActivityStatisticsService activityStatisticsService;


    /**
     * 得到統計時間列表
     * @return
     */
    @RequestMapping("getAllDate")
    public ResponseData getAllDate(){
        log.info("enter ActivityStatisticsController method getAllDate");
        return activityStatisticsService.getAllDate();
    }
}
