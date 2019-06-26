package com.bizvane.mktcenterfacade.models.vo;

import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.mktcenterfacade.models.po.MktActivityManualPO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("会员活动对象")
public class ActivityManualVO extends MktActivityManualPO {

    @ApiModelProperty(value = "会员对象", name = "propertyList")
    private MemberInfoModel memberInfoModel;
    @ApiModelProperty(value = "活动编号", name = "propertyList", example = "AC2019041517351231")
    private String activityCode;
    @ApiModelProperty(value = "活动类型", name = "propertyList", example = "1")
    private Integer activityType;
    @ApiModelProperty(value = "券号", name = "propertyList", example = "Jz75mhz6tKGy")
    private String couponCode;
    @ApiModelProperty(value = "券定义id", name = "propertyList", example = "1")
    private Long couponDefinitionId;
    @ApiModelProperty(value = "今天领取的数量", name = "propertyList", example = "3")
    private Long countTodaySum;//今天领取的总数量
    @ApiModelProperty(value = "已领取的总数量", name = "propertyList", example = "7")
    private Long countAllSum;//领取的总数量

    private Long sysBrandId;

}
