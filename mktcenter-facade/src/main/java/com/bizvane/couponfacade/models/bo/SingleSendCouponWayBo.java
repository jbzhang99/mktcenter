package com.bizvane.couponfacade.models.bo;

/**
 * Created by 26095 on 2019/1/29.
 */
public class SingleSendCouponWayBo {
    /**
    * 单券发券方式
    * */
    private String sendCouponWay;
    /**
     * 单券发券数量
     * */
    private String sendCouponNum;
    /**
     * 核销数量
     * */
    private String salesVolume;
    /**
     * 核销率
     * */
    private String saleRate;
    /**
     * 客单价
     * */
    private String clientPrice;
    /**
     * 连带率
     * */
    private String jointRate;
    /**
     * 券收益
     * */
    private String achievements;
    /**
     * ROI
     * */
    private String ROI;

    public String getSendCouponWay() {
        return sendCouponWay;
    }

    public void setSendCouponWay(String sendCouponWay) {
        this.sendCouponWay = sendCouponWay;
    }

    public String getSendCouponNum() {
        return sendCouponNum;
    }

    public void setSendCouponNum(String sendCouponNum) {
        this.sendCouponNum = sendCouponNum;
    }

    public String getSalesVolume() {
        return salesVolume;
    }

    public void setSalesVolume(String salesVolume) {
        this.salesVolume = salesVolume;
    }

    public String getSaleRate() {
        return saleRate;
    }

    public void setSaleRate(String saleRate) {
        this.saleRate = saleRate;
    }

    public String getJointRate() {
        return jointRate;
    }

    public void setJointRate(String jointRate) {
        this.jointRate = jointRate;
    }

    public String getAchievements() {
        return achievements;
    }

    public void setAchievements(String achievements) {
        this.achievements = achievements;
    }

    public String getROI() {
        return ROI;
    }

    public void setROI(String ROI) {
        this.ROI = ROI;
    }

    public String getClientPrice() {
        return clientPrice;
    }

    public void setClientPrice(String clientPrice) {
        this.clientPrice = clientPrice;
    }
}
