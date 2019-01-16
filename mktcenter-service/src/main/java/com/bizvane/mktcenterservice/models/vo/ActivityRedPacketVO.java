package com.bizvane.mktcenterservice.models.vo;

import lombok.Data;

/**
 * @Author: lijunwei
 * @Time: 2019/1/11 15:44
 */
@Data
public class ActivityRedPacketVO {
    //分页
    private int pageNumber=1;
    private int pageSize=10;
   //活动
    private Long mktActivityId;
    private String activityCode;
    private Integer activityType=12;
    private String activityName;
    private String wxNickname;
    private Long sysCompanyId;
    private Long sysBrandId;
    private Integer activityStatus;
    //参与者
    private String memberCode;
    private String memberPhone;
    private String memberName;
    //1=发起,2=助力,3=赠券
    private Integer type;
    //发起者
    private String sponsorCode;
    //统计
    private Integer initiatorNum = 0;
    private Integer helpNum = 0;
    private Integer getCouponNum = 0;

}
