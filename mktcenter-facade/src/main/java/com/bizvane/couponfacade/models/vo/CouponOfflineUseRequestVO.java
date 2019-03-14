package com.bizvane.couponfacade.models.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

public class CouponOfflineUseRequestVO implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "券号", name = "couponCode", required = false,example = "")
  private String couponCode;

  @ApiModelProperty(value = "描述", name = "description", required = false,example = "")
  private String description;

  @ApiModelProperty(value = "业务单号", name = "businessCode", required = false,example = "")
  private String businessCode;

  @ApiModelProperty(value = "品牌id", name = "sysBrandId", required = false,example = "")
  private Long sysBrandId;

  @ApiModelProperty(value = "是否会员", name = "isMember", required = false,example = "")
  private Integer isMember;

  @ApiModelProperty(value = "店铺id", name = "useStoreId", required = false,example = "")
  private Long useStoreId;

  @ApiModelProperty(value = "核销金额", name = "profitMoney", required = false,example = "")
  private BigDecimal profitMoney;

  @ApiModelProperty(value = "优惠金额", name = "discountMoney", required = false,example = "")
  private BigDecimal discountMoney;

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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getBusinessCode() {
    return businessCode;
  }

  public void setBusinessCode(String businessCode) {
    this.businessCode = businessCode;
  }

  public Long getSysBrandId() {
    return sysBrandId;
  }

  public void setSysBrandId(Long sysBrandId) {
    this.sysBrandId = sysBrandId;
  }

  public Long getUseStoreId() {
    return useStoreId;
  }

  public void setUseStoreId(Long useStoreId) {
    this.useStoreId = useStoreId;
  }

  public Integer getIsMember() {
    return isMember;
  }

  public void setIsMember(Integer isMember) {
    this.isMember = isMember;
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
