package com.bizvane.mktcenterfacade.models.vo;

import com.bizvane.couponfacade.models.po.CouponDefinitionPO;

/**
 * @Author: lijunwei
 * @Time: 2018/11/28 14:04
 */
public class CouponIntegralExchangeVO {
    private Long exchangeId;
    private Integer exchangePrice;
    private CouponDefinitionPO couponDefinitionPO;
    private String exchangeInfo;
    //是否限兑 0：限制 1：不限制
    private Integer exchangeStatus;
    //限制兑换量
    private Long exchangeCount;


    public Long getExchangeId() {
        return exchangeId;
    }

    public void setExchangeId(Long exchangeId) {
        this.exchangeId = exchangeId;
    }

    public Integer getExchangePrice() {
        return exchangePrice;
    }

    public void setExchangePrice(Integer exchangePrice) {
        this.exchangePrice = exchangePrice;
    }

    public CouponDefinitionPO getCouponDefinitionPO() {
        return couponDefinitionPO;
    }

    public void setCouponDefinitionPO(CouponDefinitionPO couponDefinitionPO) {
        this.couponDefinitionPO = couponDefinitionPO;
    }

    public String getExchangeInfo() {
        return exchangeInfo;
    }

    public void setExchangeInfo(String exchangeInfo) {
        this.exchangeInfo = exchangeInfo;
    }

    public Integer getExchangeStatus() {
        return exchangeStatus;
    }

    public void setExchangeStatus(Integer exchangeStatus) {
        this.exchangeStatus = exchangeStatus;
    }

    public Long getExchangeCount() {
        return exchangeCount;
    }

    public void setExchangeCount(Long exchangeCount) {
        this.exchangeCount = exchangeCount;
    }
}
