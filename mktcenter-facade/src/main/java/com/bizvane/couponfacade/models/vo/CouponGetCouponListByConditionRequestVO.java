package com.bizvane.couponfacade.models.vo;

import com.bizvane.couponfacade.utils.PageFormUtil;

import java.io.Serializable;

public class CouponGetCouponListByConditionRequestVO implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @io.swagger.annotations.ApiModelProperty(value = "会员号", name = "memberCode", required = false,example = "")
  private String memberCode;

  @io.swagger.annotations.ApiModelProperty(value = "券状态", name = "couponStatus", required = false,example = "")
  private String couponStatus;

  @io.swagger.annotations.ApiModelProperty(value = "分页", name = "pageForm", required = false,example = "")
  private PageFormUtil pageForm;

  public String getMemberCode() {
    return memberCode;
  }

  public void setMemberCode(String memberCode) {
    this.memberCode = memberCode;
  }

  public String getCouponStatus() {
    return couponStatus;
  }

  public void setCouponStatus(String couponStatus) {
    this.couponStatus = couponStatus;
  }


  public PageFormUtil getPageForm() {
    return pageForm;
  }

  public void setPageForm(PageFormUtil pageForm) {
    this.pageForm = pageForm;
  }
}
