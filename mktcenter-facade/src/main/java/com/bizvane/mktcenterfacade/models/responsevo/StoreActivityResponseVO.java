package com.bizvane.mktcenterfacade.models.responsevo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author chen.li
 * @date on 2019/5/10 20:19
 * @description
 */
@ApiModel(value="门店活动搜索结果对象")
@Data
public class StoreActivityResponseVO {

    @ApiModelProperty(value = "活动id", name = "mktActivityId", example = "活动id")
    private Long mktActivityId;

    @ApiModelProperty(value = "活动类型：5消费活动，9评价奖励",
        name = "activityType", required = false, example = "")
    private Integer activityType;
    
    @ApiModelProperty(value = "活动名称", name = "activityName", example = "开卡活动")
    private String activityName;
    
    @ApiModelProperty(value = "是否长期：1是，0否", name = "longTerm", required = false, example = "")
    private Integer longTerm;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @ApiModelProperty(value = "活动开始时间", name = "startTime", example = "2019-05-10")
    private Date startTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @ApiModelProperty(value = "活动结束时间", name = "endTime", example = "2019-05-11")
    private Date endTime;

    @ApiModelProperty(value = "活动描述", name = "activityInfo", example = "活动描述")
    private Integer activityInfo;

    @ApiModelProperty(value = "参与次数", name = "participateTimes", example = "1")
    private Integer participateTimes;

    @ApiModelProperty(value = "总次数", name = "allTimes", example = "2")
    private Integer allTimes;
}
