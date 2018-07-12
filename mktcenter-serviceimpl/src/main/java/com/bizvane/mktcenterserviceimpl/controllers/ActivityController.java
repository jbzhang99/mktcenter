package com.bizvane.mktcenterserviceimpl.controllers;

import com.bizvane.mktcenterservice.interfaces.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
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

    /**
     * 获取所有活动列表
     * @return
     */
    @RequestMapping("getAcvitityList")
    public Result<MktActivityPO> getAcvitityList(){
        System.out.println("hello world ");
        return null;
    }
}
