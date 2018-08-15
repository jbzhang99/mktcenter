package com.bizvane.mktcenterservice.models.bo;

/**
 * @Author: lijunwei
 * @Time: 2018/8/15 11:36
 */
public class TaskCouponWXBO {
    private Long mktCouponId;
    private String couponName;

    public Long getMktCouponId() {
        return mktCouponId;
    }

    public void setMktCouponId(Long mktCouponId) {
        this.mktCouponId = mktCouponId;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }
}
