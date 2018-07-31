package com.bizvane.mktcenterserviceimpl.controllers.rpc;

import com.bizvane.mktcenterservice.interfaces.ActivityService;
import com.bizvane.mktcenterservice.interfaces.ActivitySmartService;
import com.bizvane.mktcenterservice.models.po.MktActivitySmartPO;
import com.bizvane.mktcenterservice.models.vo.ActivitySmartVO;
import com.bizvane.mktcenterservice.models.vo.PageForm;
import com.bizvane.utils.responseinfo.ResponseData;
import com.github.pagehelper.PageInfo;
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
    private ActivitySmartService activitySmartService;

    @RequestMapping("getActivityById")
    @io.swagger.annotations.ApiModelProperty(value = "ActivitySmartVO",name = "通过id获取活动", required = false,example = "")
    public ResponseData<MktActivitySmartPO> getActivityById(Long mktActivitySmartId){
        return activitySmartService.getActivityById(mktActivitySmartId);
    }

    @RequestMapping("getActivityList")
    @io.swagger.annotations.ApiModelProperty(value = "ActivitySmartVO",name = "查询智能营销活动列表", required = false,example = "")
    public ResponseData<PageInfo<MktActivitySmartPO>> getActivityList(ActivitySmartVO vo, PageForm pageForm){
        return activitySmartService.getActivityList(vo,pageForm);
    }

    @RequestMapping("addActivity")
    @io.swagger.annotations.ApiModelProperty(value = "ActivitySmartVO",name = "添加智能营销活动", required = false,example = "")
    public ResponseData<Integer> addSmartActivity(ActivitySmartVO vo){
        return new ResponseData<>();
    }

    @RequestMapping("updateActivity")
    @io.swagger.annotations.ApiModelProperty(value = "ActivitySmartVO",name = "更新智能营销活动", required = false,example = "")
    public ResponseData<Integer> updateSmartActivity(ActivitySmartVO vo){
        return new ResponseData<>();
    }

}
