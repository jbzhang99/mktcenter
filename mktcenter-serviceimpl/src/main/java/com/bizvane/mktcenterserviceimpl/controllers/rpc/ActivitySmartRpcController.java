package com.bizvane.mktcenterserviceimpl.controllers.rpc;

import com.bizvane.mktcenterservice.interfaces.ActivityService;
import com.bizvane.mktcenterservice.interfaces.ActivitySmartService;
import com.bizvane.mktcenterservice.models.po.MktActivitySmartGroupPO;
import com.bizvane.mktcenterservice.models.po.MktActivitySmartPO;
import com.bizvane.mktcenterservice.models.vo.ActivitySmartVO;
import com.bizvane.mktcenterservice.models.vo.PageForm;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping("getSmartActivityById")
    @io.swagger.annotations.ApiModelProperty(value = "mktActivitySmartId",name = "通过id获取活动分组", required = false,example = "")
    public ResponseData<MktActivitySmartGroupPO> getSmartActivityById(@RequestParam("mktActivitySmartId") Long mktActivitySmartId){
        return activitySmartService.getSmartActivityById(mktActivitySmartId);
    }

    @RequestMapping("getSmartActivityList")
    @io.swagger.annotations.ApiModelProperty(value = "ActivitySmartVO",name = "查询智能营销活动列表", required = false,example = "")
    public ResponseData<PageInfo<MktActivitySmartGroupPO>> getSmartActivityList(@RequestBody ActivitySmartVO vo){
        PageForm pageForm = new PageForm();
        pageForm.setPageNumber(vo.getPageNumber());
        pageForm.setPageSize(vo.getPageSize());
        return activitySmartService.getSmartActivityList(vo,pageForm);
    }

    @RequestMapping("addSmartActivity")
    @io.swagger.annotations.ApiModelProperty(value = "ActivitySmartVO",name = "添加智能营销活动", required = false,example = "")
    public ResponseData<Integer> addSmartActivity(@RequestBody ActivitySmartVO vo){
        return activitySmartService.addSmartActivity(vo);
    }

    @RequestMapping("updateSmartActivity")
    @io.swagger.annotations.ApiModelProperty(value = "ActivitySmartVO",name = "更新智能营销活动", required = false,example = "")
    public ResponseData<Integer> updateSmartActivity(@RequestBody ActivitySmartVO vo){
        return activitySmartService.updateSmartActivity(vo);
    }

    @RequestMapping("updateSmartActivityStatus")
    @io.swagger.annotations.ApiModelProperty(value = "ActivitySmartVO",name = "启用/禁用智能营销活动", required = false,example = "")
    public ResponseData<Integer> updateSmartActivityStatus(@RequestBody ActivitySmartVO vo){
        return activitySmartService.updateSmartActivityStatus(vo);
    }

    @RequestMapping("deleteSmartActivity")
    @io.swagger.annotations.ApiModelProperty(value = "mktActivitySmartId",name = "删除智能营销活动分组", required = false,example = "")
    public ResponseData<Integer> deleteSmartActivity(@RequestBody ActivitySmartVO vo){
        return activitySmartService.deleteSmartActivity(vo);
    }

    @RequestMapping("copySmartActivity")
    @io.swagger.annotations.ApiModelProperty(value = "ActivitySmartVO",name = "复制智能营销活动分组", required = false,example = "")
    public ResponseData<Integer> copySmartActivity(@RequestBody ActivitySmartVO vo){
        return activitySmartService.copySmartActivity(vo);
    }

}
