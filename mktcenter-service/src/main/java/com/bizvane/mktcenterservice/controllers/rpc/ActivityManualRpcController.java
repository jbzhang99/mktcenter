package com.bizvane.mktcenterservice.controllers.rpc;

import com.bizvane.mktcenterfacade.interfaces.ActivityManualService;
import com.bizvane.mktcenterfacade.models.vo.ActivityManualVO;
import com.bizvane.mktcenterfacade.models.vo.ActivityVO;
import com.bizvane.utils.responseinfo.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * @author xiao.shu
 * @date on 2018/8/3 16:18
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@RestController
@RequestMapping("activityManualRpc")
public class ActivityManualRpcController {
    @Autowired
    private ActivityManualService activityManualService ;

    @RequestMapping("/getActivityByQrcode")
    @io.swagger.annotations.ApiModelProperty(value = "memberInfoModel,activityCode,activityType",name = "扫码领券列表", required = false,example = "")
    public ResponseData<ActivityVO> getActivityByQrcode(@RequestBody ActivityManualVO vo){
        ResponseData<ActivityVO> activityVo=activityManualService.getActivityByQrcode(vo.getMemberInfoModel(),vo.getActivityCode(),vo.getActivityType());
        return activityVo;
    }

    @RequestMapping("/getActivityByMemberInfo")
    @io.swagger.annotations.ApiModelProperty(value = "memberInfoModel,activityType",name = "领券中心列表", required = false,example = "")
    public ResponseData<List<ActivityVO>> getActivityByMemberInfo(@RequestBody ActivityManualVO vo){
        return activityManualService.getActivityByMemberInfo(vo.getMemberInfoModel(),vo.getActivityType());

    }

    @RequestMapping("/executeActivity")
    @io.swagger.annotations.ApiModelProperty(value = "model,couponCode,activityType",name = "执行领券活动", required = false,example = "")
    public  ResponseData<ActivityManualVO> executeActivity(@RequestBody ActivityManualVO vo){
        return activityManualService.executeActivity(vo);
    }
}
