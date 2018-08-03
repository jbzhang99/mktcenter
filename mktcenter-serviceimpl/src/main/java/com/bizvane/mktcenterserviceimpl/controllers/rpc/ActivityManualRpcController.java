package com.bizvane.mktcenterserviceimpl.controllers.rpc;

import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.mktcenterservice.interfaces.ActivityManualService;
import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.utils.responseinfo.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseData<ActivityVO> getActivityByQrcode(MemberInfoModel memberInfoModel, String activityCode, Integer activityType){
        ResponseData<ActivityVO> activityVo=activityManualService.getActivityByQrcode(memberInfoModel,activityCode,activityType);
        return activityVo;
    }

    @RequestMapping("/getActivityByMemberInfo")
    @io.swagger.annotations.ApiModelProperty(value = "memberInfoModel,activityType",name = "领券中心列表", required = false,example = "")
    public ResponseData<List<ActivityVO>> getActivityByMemberInfo(MemberInfoModel memberInfoModel, Integer activityType){
        return activityManualService.getActivityByMemberInfo(memberInfoModel,activityType);

    }

    @RequestMapping("/executeActivity")
    @io.swagger.annotations.ApiModelProperty(value = "model,couponCode,activityType",name = "执行领券活动", required = false,example = "")
    public  ResponseData<Integer> executeActivity(MemberInfoModel  model,String couponCode,Integer activityType){
        return activityManualService.executeActivity(model,couponCode,activityType);
    }
}
