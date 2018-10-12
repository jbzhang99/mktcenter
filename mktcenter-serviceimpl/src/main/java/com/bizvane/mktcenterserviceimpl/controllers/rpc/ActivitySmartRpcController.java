package com.bizvane.mktcenterserviceimpl.controllers.rpc;

import com.bizvane.mktcenterservice.interfaces.ActivityService;
import com.bizvane.mktcenterservice.interfaces.ActivitySmartService;
import com.bizvane.mktcenterservice.models.po.MktActivitySmartGroupPO;
import com.bizvane.mktcenterservice.models.po.MktActivitySmartPO;
import com.bizvane.mktcenterservice.models.vo.ActivitySmartVO;
import com.bizvane.mktcenterservice.models.vo.PageForm;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.bizvane.utils.tokens.TokenUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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

    @RequestMapping("getSmartActivityGroupById")
    @io.swagger.annotations.ApiModelProperty(value = "mktActivitySmartId",name = "通过id获取智能营销分组", required = false,example = "")
    public ResponseData<MktActivitySmartGroupPO> getSmartActivityGroupById(@RequestParam("mktActivitySmartGroupId") Long mktActivitySmartGroupId){
        return activitySmartService.getSmartActivityGroupById(mktActivitySmartGroupId,new SysAccountPO());
    }

    @RequestMapping("getSmartActivityGroupList")
    @io.swagger.annotations.ApiModelProperty(value = "ActivitySmartVO",name = "查询智能营销分组列表", required = false,example = "")
    public ResponseData<PageInfo<MktActivitySmartGroupPO>> getSmartActivityGroupList(@RequestBody ActivitySmartVO vo){
        PageForm pageForm = new PageForm();
        pageForm.setPageNumber(vo.getPageNumber());
        pageForm.setPageSize(vo.getPageSize());
        vo.setType(0);
        SysAccountPO stageUser = new SysAccountPO();
        return activitySmartService.getSmartActivityGroupList(vo,pageForm,stageUser);
    }

    @RequestMapping("addSmartActivityGroup")
    @io.swagger.annotations.ApiModelProperty(value = "ActivitySmartVO",name = "添加智能营销分组", required = false,example = "")
    public ResponseData<Integer> addSmartActivityGroup(@RequestBody ActivitySmartVO vo){
        return activitySmartService.addSmartActivityGroup(vo);
    }

    @RequestMapping("updateSmartActivityGroup")
    @io.swagger.annotations.ApiModelProperty(value = "ActivitySmartVO",name = "更新智能营销分组", required = false,example = "")
    public ResponseData<Integer> updateSmartActivityGroup(@RequestBody ActivitySmartVO vo){
        return activitySmartService.updateSmartActivityGroup(vo);
    }

    @RequestMapping("updateSmartActivityGroupStatus")
    @io.swagger.annotations.ApiModelProperty(value = "ActivitySmartVO",name = "启用/禁用智能营销分组", required = false,example = "")
    public ResponseData<Integer> updateSmartActivityGroupStatus(@RequestBody ActivitySmartVO vo){
        return activitySmartService.updateSmartActivityGroupStatus(vo);
    }

    @RequestMapping("deleteSmartActivityGroup")
    @io.swagger.annotations.ApiModelProperty(value = "mktActivitySmartId",name = "删除智能营销活动分组", required = false,example = "")
    public ResponseData<Integer> deleteSmartActivityGroup(@RequestBody ActivitySmartVO vo){
        return activitySmartService.deleteSmartActivityGroup(vo);
    }

    @RequestMapping("copySmartActivityGroup")
    @io.swagger.annotations.ApiModelProperty(value = "ActivitySmartVO",name = "复制智能营销活动分组", required = false,example = "")
    public ResponseData<Integer> copySmartActivityGroup(@RequestBody ActivitySmartVO vo){
        return activitySmartService.copySmartActivityGroup(vo);
    }

}
