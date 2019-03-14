package com.bizvane.mktcenterfacade.models.bo;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by agan on 2018/8/11.
 */
public class CtivityAnalysisBO {
    private List<ActivityAnalysisCountBO> activityAnalysisCountBO;//

    private Long participateTotal;//合计人数

    private Long couponSumTotal;//发行优惠券合计数量

    private Long couponUsedSumTotal;//以及核销优惠券数量

    private BigDecimal moneyTotal;//收益合计

    private int pointsSumTotal;//赠送积分合计

    private Long total;//总数

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<ActivityAnalysisCountBO> getActivityAnalysisCountBO() {
        return activityAnalysisCountBO;
    }

    public void setActivityAnalysisCountBO(List<ActivityAnalysisCountBO> activityAnalysisCountBO) {
        this.activityAnalysisCountBO = activityAnalysisCountBO;
    }

    public Long getParticipateTotal() {
        return participateTotal;
    }

    public void setParticipateTotal(Long participateTotal) {
        this.participateTotal = participateTotal;
    }

    public Long getCouponSumTotal() {
        return couponSumTotal;
    }

    public void setCouponSumTotal(Long couponSumTotal) {
        this.couponSumTotal = couponSumTotal;
    }

    public Long getCouponUsedSumTotal() {
        return couponUsedSumTotal;
    }

    public void setCouponUsedSumTotal(Long couponUsedSumTotal) {
        this.couponUsedSumTotal = couponUsedSumTotal;
    }

    public BigDecimal getMoneyTotal() {
        return moneyTotal;
    }

    public void setMoneyTotal(BigDecimal moneyTotal) {
        this.moneyTotal = moneyTotal;
    }

    public int getPointsSumTotal() {
        return pointsSumTotal;
    }

    public void setPointsSumTotal(int pointsSumTotal) {
        this.pointsSumTotal = pointsSumTotal;
    }
}
