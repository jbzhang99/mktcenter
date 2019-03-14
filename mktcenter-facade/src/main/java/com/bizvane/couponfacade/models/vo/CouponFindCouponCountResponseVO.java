package com.bizvane.couponfacade.models.vo;

import java.io.Serializable;
import java.math.BigDecimal;

@io.swagger.annotations.ApiModel(value = "券数量统计")
public class CouponFindCouponCountResponseVO implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  @io.swagger.annotations.ApiModelProperty(value = "券总数量", name = "couponSum", required = false, example = "")
  private Long couponSum;
  
  @io.swagger.annotations.ApiModelProperty(value = "券已使用数量", name = "couponUsedSum", required = false, example = "")
  private Long couponUsedSum;
  
  @io.swagger.annotations.ApiModelProperty(value = "券未使用数量", name = "couponUnusedSum", required = false, example = "")
  private Long couponUnusedSum;
  
  @io.swagger.annotations.ApiModelProperty(value = "券过期数量", name = "couponOverdueSum", required = false, example = "")
  private Long couponOverdueSum;

  @io.swagger.annotations.ApiModelProperty(value = "收益", name = "money", required = false, example = "")
  private BigDecimal money;
  
  @io.swagger.annotations.ApiModelProperty(value = "核销率", name = "couponRate", required = false, example = "")
  private String couponRate;
  
  public String getCouponRate() {
	return couponRate;
}

public void setCouponRate(String couponRate) {
	this.couponRate = couponRate;
}

public Long getCouponSum() {
    return couponSum;
  }

  public void setCouponSum(Long couponSum) {
    this.couponSum = couponSum;
  }

  public Long getCouponUsedSum() {
    return couponUsedSum;
  }

  public void setCouponUsedSum(Long couponUsedSum) {
    this.couponUsedSum = couponUsedSum;
  }

  public Long getCouponUnusedSum() {
    return couponUnusedSum;
  }

  public void setCouponUnusedSum(Long couponUnusedSum) {
    this.couponUnusedSum = couponUnusedSum;
  }

  public Long getCouponOverdueSum() {
    return couponOverdueSum;
  }

  public void setCouponOverdueSum(Long couponOverdueSum) {
    this.couponOverdueSum = couponOverdueSum;
  }

  public BigDecimal getMoney() {
    return money;
  }

  public void setMoney(BigDecimal money) {
    this.money = money;
  }
}
