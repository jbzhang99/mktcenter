package com.bizvane.mktcenterservice.models.vo;

/**
 * @Author: lijunwei
 * @Time: 2018/9/3 14:58
 * 转换后用于会员和券的任务类型
 */
public class ChangeTaskTypeVO {
   private String memberTaskType;
   private String couponTaskType;

    public String getMemberTaskType() {
        return memberTaskType;
    }

    public void setMemberTaskType(String memberTaskType) {
        this.memberTaskType = memberTaskType;
    }

    public String getCouponTaskType() {
        return couponTaskType;
    }

    public void setCouponTaskType(String couponTaskType) {
        this.couponTaskType = couponTaskType;
    }
}
