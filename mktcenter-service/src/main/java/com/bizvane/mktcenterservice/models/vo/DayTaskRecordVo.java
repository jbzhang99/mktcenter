package com.bizvane.mktcenterservice.models.vo;

import java.util.Date;

/**
 * Created by Geng on 2018/8/2.
 */
public class DayTaskRecordVo {

    //某天的赠送总积分数
    private Long dayPoints;

    //某天的发行券总张数
    private Long dayCountCoupon;

    //某天参与活动的会员人数
    private Long dayCountMbr;

    //某天完成任务的会员人数
    private Long dayCompleteCountMbr;

    //任务名称
    private String taskName;

    //某天被核销的优惠券
    private Long dayInvalidCountCoupon;

    //某任务的分享总次数
    private Long oneTaskShareTimes;

    //参与时间
    private Date participateDay;

    //某任务获得的总积分
    private Long oneTaskPoints;

    //某任务发行的总券数
    private Long oneTaskCountCoupon;

    //某任务完成的会员总人数
    private Long oneTaskCompleteCountMbr;

    //某任务被核销的优惠券
    private Long oneTaskInvalidCountCoupon;

    //某任务参与的会员总人数
    private Long oneTaskCountMbr;

    public Long getDayPoints() {
        return dayPoints;
    }

    public void setDayPoints(Long dayPoints) {
        this.dayPoints = dayPoints;
    }

    public Long getDayCountCoupon() {
        return dayCountCoupon;
    }

    public void setDayCountCoupon(Long dayCountCoupon) {
        this.dayCountCoupon = dayCountCoupon;
    }

    public Long getDayCountMbr() {
        return dayCountMbr;
    }

    public void setDayCountMbr(Long dayCountMbr) {
        this.dayCountMbr = dayCountMbr;
    }

    public Long getDayCompleteCountMbr() {
        return dayCompleteCountMbr;
    }

    public void setDayCompleteCountMbr(Long dayCompleteCountMbr) {
        this.dayCompleteCountMbr = dayCompleteCountMbr;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Long getDayInvalidCountCoupon() {
        return dayInvalidCountCoupon;
    }

    public void setDayInvalidCountCoupon(Long dayInvalidCountCoupon) {
        this.dayInvalidCountCoupon = dayInvalidCountCoupon;
    }

    public Long getOneTaskShareTimes() {
        return oneTaskShareTimes;
    }

    public void setOneTaskShareTimes(Long oneTaskShareTimes) {
        this.oneTaskShareTimes = oneTaskShareTimes;
    }

    public Date getParticipateDay() {
        return participateDay;
    }

    public void setParticipateDay(Date participateDay) {
        this.participateDay = participateDay;
    }

    public Long getOneTaskPoints() {
        return oneTaskPoints;
    }

    public void setOneTaskPoints(Long oneTaskPoints) {
        this.oneTaskPoints = oneTaskPoints;
    }

    public Long getOneTaskCountCoupon() {
        return oneTaskCountCoupon;
    }

    public void setOneTaskCountCoupon(Long oneTaskCountCoupon) {
        this.oneTaskCountCoupon = oneTaskCountCoupon;
    }

    public Long getOneTaskCompleteCountMbr() {
        return oneTaskCompleteCountMbr;
    }

    public void setOneTaskCompleteCountMbr(Long oneTaskCompleteCountMbr) {
        this.oneTaskCompleteCountMbr = oneTaskCompleteCountMbr;
    }

    public Long getOneTaskInvalidCountCoupon() {
        return oneTaskInvalidCountCoupon;
    }

    public void setOneTaskInvalidCountCoupon(Long oneTaskInvalidCountCoupon) {
        this.oneTaskInvalidCountCoupon = oneTaskInvalidCountCoupon;
    }

    public Long getOneTaskCountMbr() {
        return oneTaskCountMbr;
    }

    public void setOneTaskCountMbr(Long oneTaskCountMbr) {
        this.oneTaskCountMbr = oneTaskCountMbr;
    }
}