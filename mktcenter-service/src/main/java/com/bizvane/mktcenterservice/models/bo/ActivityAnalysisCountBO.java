package com.bizvane.mktcenterservice.models.bo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 活动效果分析BO
 * Created by agan on 2018/8/7.
 */
public class ActivityAnalysisCountBO {
    private Long mktActivityId;//活动id

    private String activityName;//活动名称

    private Integer longTerm;//是否是长期活动

    private Long participateNumber;//参与人数

    private Long couponSum;//发行优惠券数量

    private Long couponUsedSum;//已核销数量

    private BigDecimal money;//收益

    private String couponUsedSumPercentage;//已核销数量百分比

    private int pointsSum;//赠送积分

    private String startDate;//开始时间

    private String endDate;//结束时间

    private Date startTime;//活动开始时间

    private Date endTime;//活动结束时间

    private Long sysBrandId;//品牌id

    private Integer activityType;//活动类型

    private String  activityCode;//活动编号

    private Date createDate;//创建日期

    private Integer activityTypeExtend;//活动类型(适用领券活动)

    private Integer activityStatus;//活动状态

    private String days;//进行天数

    private BigDecimal  orderAmountSum;//会员参与活动金额

    public BigDecimal getOrderAmountSum() {
        return orderAmountSum;
    }

    public void setOrderAmountSum(BigDecimal orderAmountSum) {
        this.orderAmountSum = orderAmountSum;
    }

    public Integer getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(Integer activityStatus) {
        this.activityStatus = activityStatus;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public Integer getActivityTypeExtend() {
        return activityTypeExtend;
    }

    public void setActivityTypeExtend(Integer activityTypeExtend) {
        this.activityTypeExtend = activityTypeExtend;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getCouponSum() {
        return couponSum;
    }

    public void setCouponSum(Long couponSum) {
        this.couponSum = couponSum;
    }

    public Long getCouponUsedSum() {
        return couponUsedSum;
    }

    public void setCouponUsedSum(Long couponUsedSum) {
        this.couponUsedSum = couponUsedSum;
    }

    public Long getMktActivityId() {
        return mktActivityId;
    }

    public void setMktActivityId(Long mktActivityId) {
        this.mktActivityId = mktActivityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Integer getLongTerm() {
        return longTerm;
    }

    public void setLongTerm(Integer longTerm) {
        this.longTerm = longTerm;
    }

    public Long getParticipateNumber() {
        return participateNumber;
    }

    public void setParticipateNumber(Long participateNumber) {
        this.participateNumber = participateNumber;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getCouponUsedSumPercentage() {
        return couponUsedSumPercentage;
    }

    public void setCouponUsedSumPercentage(String couponUsedSumPercentage) {
        this.couponUsedSumPercentage = couponUsedSumPercentage;
    }

    public int getPointsSum() {
        return pointsSum;
    }

    public void setPointsSum(int pointsSum) {
        this.pointsSum = pointsSum;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getSysBrandId() {
        return sysBrandId;
    }

    public void setSysBrandId(Long sysBrandId) {
        this.sysBrandId = sysBrandId;
    }

    public Integer getActivityType() {
        return activityType;
    }

    public void setActivityType(Integer activityType) {
        this.activityType = activityType;
    }

    public String getActivityCode() {
        return activityCode;
    }

    public void setActivityCode(String activityCode) {
        this.activityCode = activityCode;
    }
}
