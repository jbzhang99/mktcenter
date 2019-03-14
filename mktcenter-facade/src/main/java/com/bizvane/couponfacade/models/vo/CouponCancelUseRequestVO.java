package com.bizvane.couponfacade.models.vo;

import java.io.Serializable;
import java.util.List;

public class CouponCancelUseRequestVO implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @io.swagger.annotations.ApiModelProperty(value = "会员号", name = "memberCode", required = false,example = "")
  private String memberCode;
  @io.swagger.annotations.ApiModelProperty(value = "券号", name = "couponCode", required = false,example = "")
  private String couponCode;

  @io.swagger.annotations.ApiModelProperty(value = "会员号集合", name = "memberCodeList", required = false,example = "")
  private List<String> memberCodeList;

  public String getMemberCode() {
    return memberCode;
  }

  public void setMemberCode(String memberCode) {
    this.memberCode = memberCode;
  }

  public String getCouponCode() {
    return couponCode;
  }

  public void setCouponCode(String couponCode) {
    this.couponCode = couponCode;
  }

  public List<String> getMemberCodeList() {
    return memberCodeList;
  }

  public void setMemberCodeList(List<String> memberCodeList) {
    this.memberCodeList = memberCodeList;
  }


}
