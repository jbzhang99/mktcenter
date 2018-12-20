package com.bizvane.mktcenterservice.models.vo;

import lombok.Data;

import java.util.Date;

/**
 * @Author: lijunwei
 * @Time: 2018/12/19 20:52
 */
@Data
public class AnalysisPriceResultVO {
    private Long mktActivityId;
    private String activityCode;
    private String activityName;
    private Integer activityStatus;
    private Integer totalDates;
    //进行天数
    private Integer goingDates;
    //剩余天数
    private Integer  residueDates;
    //参与人数
    private Integer  totalPeople;
    //中奖人数
    private Integer  prizePeople;
    private Date startTime;
    private Date endTime;
}
