package com.bizvane.mktcenterserviceimpl.controllers;

import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.utils.responseinfo.ResponseData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chen.li
 * @date on 2018/7/27 15:19
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@RestController
@RequestMapping("activitySmartRpc")
public class ActivitySmartRpcController {

    @RequestMapping("getActivity")
    public ResponseData<Integer> getActivity(ActivityVO vo){
        return null;
    }

    @RequestMapping("addActivity")
    public ResponseData<Integer> addActivity(ActivityVO vo){
        return null;
    }

    @RequestMapping("updateActivity")
    public ResponseData<Integer> updateActivity(ActivityVO vo){
        return null;
    }



}
