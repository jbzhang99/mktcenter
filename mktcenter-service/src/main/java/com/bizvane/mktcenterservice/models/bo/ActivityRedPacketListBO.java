package com.bizvane.mktcenterservice.models.bo;

import com.bizvane.mktcenterservice.models.po.MktActivityRedPacketSumPO;

/**
 * @Author: lijunwei
 * @Time: 2019/1/15 17:32
 */
public class ActivityRedPacketListBO extends MktActivityRedPacketSumPO {
    //进行天数
    private Integer goingDates;
    //剩余天数
    private Integer  residueDates;

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
}
