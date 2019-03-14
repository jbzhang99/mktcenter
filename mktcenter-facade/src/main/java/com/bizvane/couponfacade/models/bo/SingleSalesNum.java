package com.bizvane.couponfacade.models.bo;

/**
 * Created by 26095 on 2019/1/23.
 */
public class SingleSalesNum {
    /*
    * 用于传递 订单量 和 成交额 的实体类
    * */

    //同比去年同期订单量
    private String yesteryearData;
    //环比上个周期订单量
    private String lastData;
    //本期订单量 = 当前订单量 = 总订单量
    private String currentData;
    //用券订单量
    private String useVouData;
    //未使用订单量
    private String elseData;
    //同比上升
    private String yesterdayDataPercent;
    //环比上升
    private String lastDataPercent;

    public String getYesteryearData() {
        return yesteryearData;
    }

    public void setYesteryearData(String yesteryearData) {
        this.yesteryearData = yesteryearData;
    }

    public String getLastData() {
        return lastData;
    }

    public void setLastData(String lastData) {
        this.lastData = lastData;
    }

    public String getCurrentData() {
        return currentData;
    }

    public void setCurrentData(String currentData) {
        this.currentData = currentData;
    }

    public String getUseVouData() {
        return useVouData;
    }

    public void setUseVouData(String useVouData) {
        this.useVouData = useVouData;
    }

    public String getElseData() {
        return elseData;
    }

    public void setElseData(String elseData) {
        this.elseData = elseData;
    }

    public String getYesterdayDataPercent() {
        return yesterdayDataPercent;
    }

    public void setYesterdayDataPercent(String yesterdayDataPercent) {
        this.yesterdayDataPercent = yesterdayDataPercent;
    }

    public String getLastDataPercent() {
        return lastDataPercent;
    }

    public void setLastDataPercent(String lastDataPercent) {
        this.lastDataPercent = lastDataPercent;
    }
}
