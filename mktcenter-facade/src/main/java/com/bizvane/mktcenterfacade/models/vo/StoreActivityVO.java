package com.bizvane.mktcenterfacade.models.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author chen.li
 * @date on 2019/4/11 15:50
 * @description
 */
@ApiModel(value="门店活动搜索对象")
@Data
public class StoreActivityVO {

    @ApiModelProperty(value = "分页页码", name = "pageNum", example = "1")
    private Integer pageNum;

    @ApiModelProperty(value = "分页大小", name = "pageSize", example = "10")
    private Integer pageSize;

    @ApiModelProperty(value = "我的活动状态", name = "activityStatus", example = "1进行中，2已完成")
    private Integer myActivityStatus;

    @ApiModelProperty(value = "会员code", name = "memberCode", example = "会员code")
    private String memberCode;
}
