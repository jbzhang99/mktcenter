package com.bizvane.mktcenterfacade.rpc;

import com.bizvane.mktcenterfacade.models.vo.ActivitySmartVO;
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
@FeignClient(value = "${feign.client.mktcenter.name}",path = "${feign.client.mktcenter.path}/activitySmartRpc")
public interface ActivitySmartServiceRpc {

    @RequestMapping("getSmartActivityGroupById")
    @io.swagger.annotations.ApiModelProperty(value = "ActivitySmartVO",name = "通过id获取活动", required = false,example = "")
    public ResponseData<ActivitySmartVO> getSmartActivityGroupById(@RequestParam("mktActivitySmartGroupId") Long mktActivitySmartGroupId);

    @RequestMapping("getSmartActivityGroupList")
    @io.swagger.annotations.ApiModelProperty(value = "ActivitySmartVO",name = "查询智能营销活动列表", required = false,example = "")
    public ResponseData<PageInfo<ActivitySmartVO>> getSmartActivityGroupList(@RequestBody ActivitySmartVO vo);

    @RequestMapping("addSmartActivityGroup")
    @io.swagger.annotations.ApiModelProperty(value = "ActivitySmartVO",name = "添加智能营销活动", required = false,example = "")
    public ResponseData<Integer> addSmartActivityGroup(@RequestBody ActivitySmartVO vo);

    @RequestMapping("updateSmartActivityGroup")
    @io.swagger.annotations.ApiModelProperty(value = "ActivitySmartVO",name = "更新智能营销活动", required = false,example = "")
    public ResponseData<Integer> updateSmartActivityGroup(@RequestBody ActivitySmartVO vo);

    @RequestMapping("updateSmartActivityGroupStatus")
    @io.swagger.annotations.ApiModelProperty(value = "ActivitySmartVO",name = "启用/禁用智能营销活动", required = false,example = "")
    public ResponseData<Integer> updateSmartActivityGroupStatus(@RequestBody ActivitySmartVO vo);

    @RequestMapping("deleteSmartActivityGroup")
    @io.swagger.annotations.ApiModelProperty(value = "ActivitySmartVO",name = "删除智能营销活动分组", required = false,example = "")
    public ResponseData<Integer> deleteSmartActivityGroup(@RequestBody ActivitySmartVO vo);

    @RequestMapping("copySmartActivityGroup")
    @io.swagger.annotations.ApiModelProperty(value = "ActivitySmartVO",name = "复制智能营销活动分组", required = false,example = "")
    public ResponseData<Integer> copySmartActivityGroup(@RequestBody ActivitySmartVO vo);

}
