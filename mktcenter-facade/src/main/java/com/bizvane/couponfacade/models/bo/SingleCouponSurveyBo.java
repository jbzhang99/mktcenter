package com.bizvane.couponfacade.models.bo;

/**
 * Created by 26095 on 2019/1/21.
 */
public class SingleCouponSurveyBo {
    //发券量
    private String totalTickets;
    //核销量
    private String salesVolume;
    //核销率
    private String saleRate;
    //劵成交订单
    private String orderNum;
    //劵成交金额
    private String achievements;
    //客单价
    private String clientPrice;
    //连带率
    private String jointRate;
    //ROI
    private String ROI;
    //用券订单笔数
    private String penNumber;

    public String getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(String totalTickets) {
        this.totalTickets = totalTickets;
    }

    public String getSalesVolume() {
        return salesVolume;
    }

    public void setSalesVolume(String salesVolume) {
        this.salesVolume = salesVolume;
    }

    public String getPenNumber() {
        return penNumber;
    }

    public void setPenNumber(String penNumber) {
        this.penNumber = penNumber;
    }

    public String getSaleRate() {
        return saleRate;
    }

    public void setSaleRate(String saleRate) {
        this.saleRate = saleRate;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getAchievements() {
        return achievements;
    }

    public void setAchievements(String achievements) {
        this.achievements = achievements;
    }

    public String getClientPrice() {
        return clientPrice;
    }

    public void setClientPrice(String clientPrice) {
        this.clientPrice = clientPrice;
    }

    public String getJointRate() {
        return jointRate;
    }

    public void setJointRate(String jointRate) {
        this.jointRate = jointRate;
    }

    public String getROI() {
        return ROI;
    }

    public void setROI(String ROI) {
        this.ROI = ROI;
    }
}
