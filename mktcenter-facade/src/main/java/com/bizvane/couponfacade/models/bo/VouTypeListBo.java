package com.bizvane.couponfacade.models.bo;

/**
 * Created by 26095 on 2019/2/1.
 */
public class VouTypeListBo {
    //券类型号
    private String vouTypeId;
    //券名称
    private String vouName;
    //创建时间
    private String createDate;
    //面额或者折扣
    private String moneyOrDiscount;
    //有效期
    private String validDate;
    //发券数量
    private String totalTickets;
    //累计核销数量
    private String salesVolume;
    //核销率
    private String saleRate;
    //券成交金额
    private String achievements;

    public String getVouTypeId() {
        return vouTypeId;
    }

    public void setVouTypeId(String vouTypeId) {
        this.vouTypeId = vouTypeId;
    }

    public String getVouName() {
        return vouName;
    }

    public void setVouName(String vouName) {
        this.vouName = vouName;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getMoneyOrDiscount() {
        return moneyOrDiscount;
    }

    public void setMoneyOrDiscount(String moneyOrDiscount) {
        this.moneyOrDiscount = moneyOrDiscount;
    }

    public String getValidDate() {
        return validDate;
    }

    public void setValidDate(String validDate) {
        this.validDate = validDate;
    }

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

    public String getSaleRate() {
        return saleRate;
    }

    public void setSaleRate(String saleRate) {
        this.saleRate = saleRate;
    }

    public String getAchievements() {
        return achievements;
    }

    public void setAchievements(String achievements) {
        this.achievements = achievements;
    }
}
