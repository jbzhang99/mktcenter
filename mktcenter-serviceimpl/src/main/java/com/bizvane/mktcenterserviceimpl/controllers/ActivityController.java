package com.bizvane.mktcenterserviceimpl.controllers;

import com.bizvane.mktcenterservice.interfaces.ActivityService;
import com.bizvane.utils.jobutils.JobClient;
import com.bizvane.utils.jobutils.XxlJobInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chen.li
 * @date on 2018/7/6 15:12
 * @description 营销活动
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@RestController
@RequestMapping("activity")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @Autowired
    private JobClient jobClient;

    @RequestMapping("addActivity")
    public String addActivity(){
        XxlJobInfo xxlJobInfo = new XxlJobInfo();
        xxlJobInfo.setJobGroup(4);
        xxlJobInfo.setExecutorRouteStrategy("FIRST");
        xxlJobInfo.setJobCron("0/5 * * * * ?");
        xxlJobInfo.setGlueType("BEAN");
        xxlJobInfo.setExecutorHandler("activity");
        xxlJobInfo.setJobDesc("活动任务创建");
        xxlJobInfo.setExecutorBlockStrategy("SERIAL_EXECUTION");
        xxlJobInfo.setExecutorFailStrategy("NULL");
        xxlJobInfo.setAuthor("lichen");
        ResponseEntity<String> stringResponseEntity = jobClient.addJob(xxlJobInfo);
        System.out.println(stringResponseEntity);
        return null;
    }

}
