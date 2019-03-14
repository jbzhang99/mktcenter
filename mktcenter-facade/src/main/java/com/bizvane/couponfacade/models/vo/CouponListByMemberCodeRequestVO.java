package com.bizvane.couponfacade.models.vo;

import java.io.Serializable;

public class CouponListByMemberCodeRequestVO implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;


  @io.swagger.annotations.ApiModelProperty(value = "会员号", name = "memberCode", required = false,example = "")
  private String memberCode;

  @io.swagger.annotations.ApiModelProperty(value = "券使用状态", name = "couponStatus", required = false,example = "")
  private Byte couponStatus;

  @io.swagger.annotations.ApiModelProperty(value = "品牌号", name = "sysBrandId", required = false,example = "")
  private Long sysBrandId;

  @io.swagger.annotations.ApiModelProperty(value = "显示条数", name = "pageSize")
  private Integer pageSize = 20;

  @io.swagger.annotations.ApiModelProperty(value = "当前页数", name = "page")
  private Integer pageNumber = 1;

  public Long getSysBrandId() {
    return sysBrandId;
  }

  public void setSysBrandId(Long sysBrandId) {
    this.sysBrandId = sysBrandId;
  }

  public String getMemberCode() {
    return memberCode;
  }

  public void setMemberCode(String memberCode) {
    this.memberCode = memberCode;
  }

  public Byte getCouponStatus() {
    return couponStatus;
  }

  public void setCouponStatus(Byte couponStatus) {
    this.couponStatus = couponStatus;
  }

  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public Integer getPageNumber() {
    return pageNumber;
  }

  public void setPageNumber(Integer pageNumber) {
    this.pageNumber = pageNumber;
  }
}
