package com.bizvane.couponfacade.models.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by yunjie.tian on 2018/11/7.
 */
public class CouponAllUseRequestVO implements Serializable{

    @ApiModelProperty(value = "券号", name = "couponCode", required = false,example = "")
    private String couponCode;

    @ApiModelProperty(value = "品牌id", name = "brandId", required = false,example = "")
    private Long brandId;

    @ApiModelProperty(value = "订单号", name = "useBusinessCode", required = false,example = "")
    private String useBusinessCode;

    @ApiModelProperty(value = "核销金额", name = "profitMoney", required = false,example = "")
    private BigDecimal profitMoney;

    @ApiModelProperty(value = "优惠金额", name = "discountMoney", required = false,example = "")
    private BigDecimal discountMoney;

    @ApiModelProperty(value = "店铺id", name = "useStoreId", required = false,example = "")
    private Long useStoreId;

    @ApiModelProperty(value = "核销来源", name = "useFrom", required = false,example = "")
    private Byte useFrom;

    @ApiModelProperty(value = "员工编号", name = "staffCode", required = false,example = "")
    private String staffCode;

    public String getStaffCode() {
        return staffCode;
    }

    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode;
    }


    public Long getUseStoreId() {
        return useStoreId;
    }

    public void setUseStoreId(Long useStoreId) {
        this.useStoreId = useStoreId;
    }

    public Byte getUseFrom() {
        return useFrom;
    }

    public void setUseFrom(Byte useFrom) {
        this.useFrom = useFrom;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public String getUseBusinessCode() {
        return useBusinessCode;
    }

    public void setUseBusinessCode(String useBusinessCode) {
        this.useBusinessCode = useBusinessCode;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public BigDecimal getProfitMoney() {
        return profitMoney;
    }

    public void setProfitMoney(BigDecimal profitMoney) {
        this.profitMoney = profitMoney;
    }

    public BigDecimal getDiscountMoney() {
        return discountMoney;
    }

    public void setDiscountMoney(BigDecimal discountMoney) {
        this.discountMoney = discountMoney;
    }
}
