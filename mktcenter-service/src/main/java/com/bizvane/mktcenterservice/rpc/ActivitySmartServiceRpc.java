package com.bizvane.mktcenterservice.rpc;

import com.bizvane.mktcenterservice.models.vo.ActivitySmartVO;
import com.bizvane.utils.responseinfo.PageInfo;
import com.bizvane.utils.responseinfo.ResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author chen.li
 * @date on 2018/7/27 15:16
 * @description 智能营销对外接口
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@FeignClient("${feign.client.mktcenter.name}")
@RequestMapping("${feign.client.mktcenter.path}/activitySmartRpc")
public interface ActivitySmartServiceRpc {

    @RequestMapping("getSmartActivityById")
    @io.swagger.annotations.ApiModelProperty(value = "ActivitySmartVO",name = "通过id获取活动", required = false,example = "")
    public ResponseData<ActivitySmartVO> getSmartActivityById(@RequestParam("mktActivitySmartId") Long mktActivitySmartId);

    @RequestMapping("getSmartActivityList")
    @io.swagger.annotations.ApiModelProperty(value = "ActivitySmartVO",name = "查询智能营销活动列表", required = false,example = "")
    public ResponseData<PageInfo<ActivitySmartVO>> getSmartActivityList(@RequestBody ActivitySmartVO vo);

    @RequestMapping("addSmartActivity")
    @io.swagger.annotations.ApiModelProperty(value = "ActivitySmartVO",name = "添加智能营销活动", required = false,example = "")
    public ResponseData<Integer> addSmartActivity(@RequestBody ActivitySmartVO vo);

    @RequestMapping("updateSmartActivity")
    @io.swagger.annotations.ApiModelProperty(value = "ActivitySmartVO",name = "更新智能营销活动", required = false,example = "")
    public ResponseData<Integer> updateSmartActivity(@RequestBody ActivitySmartVO vo);

    @RequestMapping("updateSmartActivityStatus")
    @io.swagger.annotations.ApiModelProperty(value = "ActivitySmartVO",name = "启用/禁用智能营销活动", required = false,example = "")
    public ResponseData<Integer> updateSmartActivityStatus(@RequestBody ActivitySmartVO vo);

    @RequestMapping("deleteSmartActivity")
    @io.swagger.annotations.ApiModelProperty(value = "ActivitySmartVO",name = "删除智能营销活动分组", required = false,example = "")
    public ResponseData<Integer> deleteSmartActivity(@RequestBody ActivitySmartVO vo);

    @RequestMapping("copySmartActivity")
    @io.swagger.annotations.ApiModelProperty(value = "ActivitySmartVO",name = "复制智能营销活动分组", required = false,example = "")
    public ResponseData<Integer> copySmartActivity(@RequestBody ActivitySmartVO vo);

}
