package com.bizvane.mktcenterfacade.rpc;

import com.bizvane.mktcenterfacade.models.vo.ActivityCouponVO;
import com.bizvane.mktcenterfacade.models.vo.ActivityManualVO;
import com.bizvane.mktcenterfacade.models.vo.ActivityVO;
import com.bizvane.utils.responseinfo.ResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author xiao.shu
 * @date on 2018/8/3 16:48
 * @description
 *
 */
@FeignClient(value = "${feign.client.mktcenter.name}",path = "${feign.client.mktcenter.path}/activityManualRpc")
public interface ActivityManualServiceRpc {

    @RequestMapping("/getActivityByQrcode")
    @io.swagger.annotations.ApiModelProperty(value = "memberInfoModel,activityCode,activityType",name = "扫码领券列表", required = false,example = "")
    public ResponseData<ActivityVO> getActivityByQrcode(@RequestBody ActivityManualVO vo);

    @RequestMapping("/getActivityByMemberInfo")
    @io.swagger.annotations.ApiModelProperty(value = "memberInfoModel,activityType",name = "领券中心列表", required = false,example = "")
    public ResponseData<List<ActivityCouponVO>> getActivityByMemberInfo(@RequestBody ActivityManualVO vo);

    @RequestMapping("/executeActivity")
    @io.swagger.annotations.ApiModelProperty(value = "model,couponCode,activityType",name = "执行领券活动", required = false,example = "")
    public  ResponseData<ActivityManualVO> executeActivity(@RequestBody ActivityManualVO vo);

}
