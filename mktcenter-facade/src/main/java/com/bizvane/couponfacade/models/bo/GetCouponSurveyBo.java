package com.bizvane.couponfacade.models.bo;

import java.io.Serializable;

public class GetCouponSurveyBo implements Serializable{
    //累计发券总数量
    private double couponCountSum;
    //待核销数量
    private double couponUnusedSum;
    //已过期数量
    private double couponOverdueSum;
    //已核销数量
    private double couponUsedSum;
    //核销率
    private String writeOffRate;
    //券成交金额
    private String couponAmountSum;

    public double getCouponCountSum() {
        return couponCountSum;
    }

    public void setCouponCountSum(double couponCountSum) {
        this.couponCountSum = couponCountSum;
    }

    public double getCouponUnusedSum() {
        return couponUnusedSum;
    }

    public void setCouponUnusedSum(double couponUnusedSum) {
        this.couponUnusedSum = couponUnusedSum;
    }

    public double getCouponOverdueSum() {
        return couponOverdueSum;
    }

    public void setCouponOverdueSum(double couponOverdueSum) {
        this.couponOverdueSum = couponOverdueSum;
    }

    public double getCouponUsedSum() {
        return couponUsedSum;
    }

    public void setCouponUsedSum(double couponUsedSum) {
        this.couponUsedSum = couponUsedSum;
    }

    public String getWriteOffRate() {
        return writeOffRate;
    }

    public void setWriteOffRate(String writeOffRate) {
        this.writeOffRate = writeOffRate;
    }

    public String getCouponAmountSum() {
        return couponAmountSum;
    }

    public void setCouponAmountSum(String couponAmountSum) {
        this.couponAmountSum = couponAmountSum;
    }
}
