package com.bizvane.mktcenterfacade.models.bo;

import com.bizvane.mktcenterfacade.models.po.MktActivityRedPacketSumPO;

/**
 * @Author: lijunwei
 * @Time: 2019/1/15 17:32
 */
public class ActivityRedPacketListBO extends MktActivityRedPacketSumPO {
    //进行天数
    private Integer goingDates;
    //剩余天数
    private Integer  residueDates;

    private Integer  activityStatus;

    public Integer getGoingDates() {
        return goingDates;
    }

    public void setGoingDates(Integer goingDates) {
        this.goingDates = goingDates;
    }

    public Integer getResidueDates() {
        return residueDates;
    }

    public void setResidueDates(Integer residueDates) {
        this.residueDates = residueDates;
    }

    public Integer getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(Integer activityStatus) {
        this.activityStatus = activityStatus;
    }
}
