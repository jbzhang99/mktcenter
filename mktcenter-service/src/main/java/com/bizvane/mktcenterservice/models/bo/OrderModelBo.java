package com.bizvane.mktcenterservice.models.bo;

import java.math.BigDecimal;

/**
 * Created by agan on 2018/7/28.
 */
public class OrderModelBo {
    private Long memberCode;//会员编号
    private Integer brandId;//品牌id
    private Integer orderFrom;//订单来源
    private BigDecimal payMoney;//订单金额
    private String productNo;//商品编码
    private Long serviceStoreId;//服务门店id
    private Long levelId;//会员等级id
    private Integer memberType;//会员范围

    public Integer getMemberType() {
        return memberType;
    }

    public void setMemberType(Integer memberType) {
        this.memberType = memberType;
    }

    public BigDecimal getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(BigDecimal payMoney) {
        this.payMoney = payMoney;
    }

    public Long getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(Long memberCode) {
        this.memberCode = memberCode;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getOrderFrom() {
        return orderFrom;
    }

    public void setOrderFrom(Integer orderFrom) {
        this.orderFrom = orderFrom;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public Long getServiceStoreId() {
        return serviceStoreId;
    }

    public void setServiceStoreId(Long serviceStoreId) {
        this.serviceStoreId = serviceStoreId;
    }

    public Long getLevelId() {
        return levelId;
    }

    public void setLevelId(Long levelId) {
        this.levelId = levelId;
    }
}
