package com.bizvane.mktcenterservice.models.vo;

import com.bizvane.couponfacade.models.po.CouponDefinitionPO;

/**
 * @Author: lijunwei
 * @Time: 2018/11/28 14:04
 */
public class CouponIntegralExchangeVO {
    private Long exchangeId;
    private Integer exchangePrice;
    private CouponDefinitionPO couponDefinitionPO;

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
}
