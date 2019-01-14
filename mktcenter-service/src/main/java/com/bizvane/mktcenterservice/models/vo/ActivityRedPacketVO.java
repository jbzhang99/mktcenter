package com.bizvane.mktcenterservice.models.vo;

import lombok.Data;

/**
 * @Author: lijunwei
 * @Time: 2019/1/11 15:44
 */
@Data
public class ActivityRedPacketVO {
    private Long mktActivityId;
    private String activityCode;

    private Long sysCompanyId;
    private Long sysBrandId;
    //参与者
    private String memberCode;
    private String memberPhone;
    private String memberName;
    //1=发起,2=助力,3=赠券
    private Integer type;
    //发起者
    private String sponsorCode;

    private Integer initiatorNum=0;
    private Integer helpNum=0;
    private Integer getCouponNum=0;

}
