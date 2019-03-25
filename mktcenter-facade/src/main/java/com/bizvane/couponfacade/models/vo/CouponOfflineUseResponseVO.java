package com.bizvane.couponfacade.models.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by yunjie.tian on 2018/8/17.
 */
public class CouponOfflineUseResponseVO implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @io.swagger.annotations.ApiModelProperty(value = "所属品牌code", name = "brandCode", required = false,example = "")
    private String brandCode;

    @io.swagger.annotations.ApiModelProperty(value = "所属企业code", name = "companyCode", required = false,example = "")
    private String companyCode;

    @io.swagger.annotations.ApiModelProperty(value = "券号", name = "couponCode", required = false,example = "")
    private String couponCode;

    @io.swagger.annotations.ApiModelProperty(value = "核销门店code", name = "useStoreCode", required = false,example = "")
    private String useStoreCode;

    @io.swagger.annotations.ApiModelProperty(value = "核销业务单号(订单号)", name = "useBusinessCode", required = false,example = "")
    private String useBusinessCode;

    @io.swagger.annotations.ApiModelProperty(value = "核销业务金额(订单金额)", name = "useBusinessAmount", required = false,example = "")
    private BigDecimal useBusinessAmount;

    @io.swagger.annotations.ApiModelProperty(value = "优惠金额", name = "discountMoney", required = false,example = "")
    private BigDecimal discountMoney;

    @io.swagger.annotations.ApiModelProperty(value = "核销时间", name = "useTime", required = false,example = "")
    private String useTime;


    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }


    public String getUseStoreCode() {
        return useStoreCode;
    }

    public void setUseStoreCode(String useStoreCode) {
        this.useStoreCode = useStoreCode;
    }

    public String getUseBusinessCode() {
        return useBusinessCode;
    }

    public void setUseBusinessCode(String useBusinessCode) {
        this.useBusinessCode = useBusinessCode;
    }

    public BigDecimal getUseBusinessAmount() {
        return useBusinessAmount;
    }

    public void setUseBusinessAmount(BigDecimal useBusinessAmount) {
        this.useBusinessAmount = useBusinessAmount;
    }

    public String getUseTime() {
        return useTime;
    }

    public void setUseTime(String useTime) {
        this.useTime = useTime;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public BigDecimal getDiscountMoney() {
        return discountMoney;
    }

    public void setDiscountMoney(BigDecimal discountMoney) {
        this.discountMoney = discountMoney;
    }
}
