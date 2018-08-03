package com.bizvane.mktcenterservice.models.vo;

import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.mktcenterservice.models.po.MktActivityManualPO;

public class ActivityManualVO extends MktActivityManualPO {

    private MemberInfoModel memberInfoModel;

    private String activityCode;

    private Integer activityType;

    private String couponCode;

    private Long couponId;

    public MemberInfoModel getMemberInfoModel() {
        return memberInfoModel;
    }

    public void setMemberInfoModel(MemberInfoModel memberInfoModel) {
        this.memberInfoModel = memberInfoModel;
    }

    public String getActivityCode() {
        return activityCode;
    }

    public void setActivityCode(String activityCode) {
        this.activityCode = activityCode;
    }

    public Integer getActivityType() {
        return activityType;
    }

    public void setActivityType(Integer activityType) {
        this.activityType = activityType;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {

        this.couponCode = couponCode;
    }

    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }
}
