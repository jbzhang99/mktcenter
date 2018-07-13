package com.bizvane.mktcenterserviceimpl.controllers;

import com.bizvane.mktcenterservice.interfaces.ActivityRegisterService;
import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.utils.commonutils.PageForm;
import com.bizvane.utils.responseinfo.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chen.li
 * @date on 2018/7/13 13:37
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@RestController
@RequestMapping("activitySignin")
public class ActivitySigninController {

    @Autowired
    private ActivityRegisterService activityRegisterService;

    /**
     * 查询活动列表
     * @return
     */
    @RequestMapping("getActivityList")
    public ResponseData<ActivityVO> getActivityList(ActivityVO vo, PageForm pageForm){
        ResponseData<ActivityVO> activityRegisterList = activityRegisterService.getActivityList(vo, pageForm);
        return activityRegisterList;
    }
}
