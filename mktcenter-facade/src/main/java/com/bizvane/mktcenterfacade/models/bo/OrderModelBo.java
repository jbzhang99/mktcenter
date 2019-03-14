package com.bizvane.mktcenterfacade.models.bo;

import java.math.BigDecimal;

/**
 * Created by agan on 2018/7/28.
 */
public class OrderModelBo {
    private String memberCode;//会员编号
    private Integer brandId;//品牌id
    private Integer orderFrom;//订单来源
    private BigDecimal payMoney;//订单金额
    private String productNos;//商品编码
    private Long serviceStoreId;//服务门店id
    private Long levelId;//会员等级id
    private Integer memberType;//会员范围

    private Long companyId;//企业id
    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getProductNos() {
        return productNos;
    }

    public void setProductNos(String productNos) {
        this.productNos = productNos;
    }

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

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
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
