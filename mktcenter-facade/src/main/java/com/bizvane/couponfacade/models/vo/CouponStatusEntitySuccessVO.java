package com.bizvane.couponfacade.models.vo;

import java.io.Serializable;

/**
 * 查询发券成功的状态条件
 * Created by yunjie.tian on 2018/9/17.
 */
public class CouponStatusEntitySuccessVO implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /*@io.swagger.annotations.ApiModelProperty(value = "同步成功", name = "CouponStatusSyncSuccess", required = false,example = "")
    private Byte CouponStatusSyncSuccess;*/

    @io.swagger.annotations.ApiModelProperty(value = "未使用", name = "CouponStatusUnused", required = false,example = "")
    private Byte CouponStatusUnused;

    @io.swagger.annotations.ApiModelProperty(value = "已过期", name = "CouponStatusOverdue", required = false,example = "")
    private Byte CouponStatusOverdue;

    @io.swagger.annotations.ApiModelProperty(value = "已使用", name = "CouponStatusUsed", required = false,example = "")
    private Byte CouponStatusUsed;


  /*  public Byte getCouponStatusSyncSuccess() {
        return CouponStatusSyncSuccess;
    }

    public void setCouponStatusSyncSuccess(Byte couponStatusSyncSuccess) {
        CouponStatusSyncSuccess = couponStatusSyncSuccess;
    }*/

    public Byte getCouponStatusUnused() {
        return CouponStatusUnused;
    }

    public void setCouponStatusUnused(Byte couponStatusUnused) {
        CouponStatusUnused = couponStatusUnused;
    }

    public Byte getCouponStatusOverdue() {
        return CouponStatusOverdue;
    }

    public void setCouponStatusOverdue(Byte couponStatusOverdue) {
        CouponStatusOverdue = couponStatusOverdue;
    }

    public Byte getCouponStatusUsed() {
        return CouponStatusUsed;
    }

    public void setCouponStatusUsed(Byte couponStatusUsed) {
        CouponStatusUsed = couponStatusUsed;
    }
}
