package com.bizvane.mktcenterservice.rpc;

import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.mktcenterservice.models.vo.ActivityManualVO;
import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.utils.responseinfo.ResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author xiao.shu
 * @date on 2018/8/3 16:48
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@FeignClient("${feign.client.mktcenter.name}")
@RequestMapping("${feign.client.mktcenter.path}/activityManualRpc")
public interface ActivityManualServiceRpc {

    @RequestMapping("/getActivityByQrcode")
    @io.swagger.annotations.ApiModelProperty(value = "memberInfoModel,activityCode,activityType",name = "扫码领券列表", required = false,example = "")
    public ResponseData<ActivityVO> getActivityByQrcode(@RequestBody ActivityManualVO vo);

    @RequestMapping("/getActivityByMemberInfo")
    @io.swagger.annotations.ApiModelProperty(value = "memberInfoModel,activityType",name = "领券中心列表", required = false,example = "")
    public ResponseData<List<ActivityVO>> getActivityByMemberInfo(@RequestBody ActivityManualVO vo);

    @RequestMapping("/executeActivity")
    @io.swagger.annotations.ApiModelProperty(value = "model,couponCode,activityType",name = "执行领券活动", required = false,example = "")
    public  ResponseData<ActivityManualVO> executeActivity(@RequestBody ActivityManualVO vo);

}
