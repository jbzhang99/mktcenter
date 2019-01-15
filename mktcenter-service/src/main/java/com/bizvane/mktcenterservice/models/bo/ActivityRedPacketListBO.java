package com.bizvane.mktcenterservice.models.bo;

import com.bizvane.mktcenterservice.models.po.MktActivityPO;

/**
 * @Author: lijunwei
 * @Time: 2019/1/15 17:32
 */
public class ActivityRedPacketListBO extends MktActivityPO {
    private Integer initiatorNum;
    private Integer helpNum;
    private Integer getCouponNum;
    private Integer activityTime;

    public Integer getInitiatorNum() {
        return initiatorNum;
    }

    public void setInitiatorNum(Integer initiatorNum) {
        this.initiatorNum = initiatorNum;
    }

    public Integer getHelpNum() {
        return helpNum;
    }

    public void setHelpNum(Integer helpNum) {
        this.helpNum = helpNum;
    }

    public Integer getGetCouponNum() {
        return getCouponNum;
    }

    public void setGetCouponNum(Integer getCouponNum) {
        this.getCouponNum = getCouponNum;
    }

    public Integer getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(Integer activityTime) {
        this.activityTime = activityTime;
    }
}
