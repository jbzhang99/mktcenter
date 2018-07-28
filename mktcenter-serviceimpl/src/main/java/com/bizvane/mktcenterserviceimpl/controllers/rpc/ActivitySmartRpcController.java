package com.bizvane.mktcenterserviceimpl.controllers.rpc;

import com.bizvane.mktcenterservice.interfaces.ActivityService;
import com.bizvane.mktcenterservice.models.vo.ActivitySmartVO;
import com.bizvane.utils.responseinfo.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chen.li
 * @date on 2018/7/27 15:19
 * @description 智能营销对外提供
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@RestController
@RequestMapping("activitySmartRpc")
public class ActivitySmartRpcController {

    @Autowired
    private ActivityService activityService;

    @RequestMapping("getActivityById")
    public ResponseData<Integer> getActivityById(ActivitySmartVO vo){
        return null;
    }

    @RequestMapping("getActivityList")
    public ResponseData<Integer> getActivityList(ActivitySmartVO vo){
        return null;
    }

    @RequestMapping("addActivity")
    public ResponseData<Integer> addActivity(ActivitySmartVO vo){
        return null;
    }

    @RequestMapping("updateActivity")
    public ResponseData<Integer> updateActivity(ActivitySmartVO vo){
        return null;
    }

}
