package com.bizvane.couponfacade.models.vo;

import java.io.Serializable;

public class CouponDefinitionListQueryVO implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @io.swagger.annotations.ApiModelProperty(value = "券定义id", name = "couponDefinitionId", required = false, example = "")
  private Long couponDefinitionId;
  
  @io.swagger.annotations.ApiModelProperty(value = "券名称", name = "couponName", required = false, example = "")
  private String couponName;
  
  @io.swagger.annotations.ApiModelProperty(value = "优惠类型（1现金，2折扣，3礼品） 12购物券就是现金券加折扣券", name = "preferentialType", required = false,
      example = "")
  private Byte preferentialType;
  
  @io.swagger.annotations.ApiModelProperty(value = "券状态（1已启用，0已停用）", name = "status", required = false, example = "")
  private Boolean status;
  
  @io.swagger.annotations.ApiModelProperty(value = "可裂变", name = "transferFission", required = false, example = "")
  private Boolean transferFission;
  
  @io.swagger.annotations.ApiModelProperty(value = "创建时间开始", name = "createDateStart", required = false, example = "")
  private String createDateStart;
  
  @io.swagger.annotations.ApiModelProperty(value = "创建时间结束", name = "createDateEnd", required = false, example = "")
  private String createDateEnd;

  @io.swagger.annotations.ApiModelProperty(value = "渠道限制（1仅线上，2仅线下，3全渠道）", name = "useChannel", required = false,
          example = "")
  private Byte useChannel;

  @io.swagger.annotations.ApiModelProperty(value = "创建人", name = "createUserName", required = false, example = "")
  private String createUserName;
  
  @io.swagger.annotations.ApiModelProperty(value = "页码", name = "pageNum", required = false, example = "")
  private Integer pageNumber = 1;
  
  @io.swagger.annotations.ApiModelProperty(value = "每页显示条数", name = "pageSize", required = false, example = "")
  private Integer pageSize = 10;

  @io.swagger.annotations.ApiModelProperty(value = "品牌id", name = "sysBrandId", required = false, example = "")
  private Long sysBrandId;

  @io.swagger.annotations.ApiModelProperty(value = "企业id", name = "sysCompanyId", required = false, example = "")
  private Long sysCompanyId;

  
  

  public Boolean getTransferFission() {
	return transferFission;
 }

public void setTransferFission(Boolean transferFission) {
	this.transferFission = transferFission;
}

public String getCouponName() {
    return couponName;
  }

  public Long getSysCompanyId() {
    return sysCompanyId;
  }

  public void setSysCompanyId(Long sysCompanyId) {
    this.sysCompanyId = sysCompanyId;
  }

  public void setCouponName(String couponName) {
    this.couponName = couponName;
  }

  public Long getSysBrandId() {
    return sysBrandId;
  }

  public void setSysBrandId(Long sysBrandId) {
    this.sysBrandId = sysBrandId;
  }

  public Byte getPreferentialType() {
    return preferentialType;
  }

  public void setPreferentialType(Byte preferentialType) {
    this.preferentialType = preferentialType;
  }

  public Boolean getStatus() {
    return status;
  }

  public void setStatus(Boolean status) {
    this.status = status;
  }

  public String getCreateDateStart() {
    return createDateStart;
  }

  public void setCreateDateStart(String createDateStart) {
    this.createDateStart = createDateStart;
  }

  public String getCreateDateEnd() {
    return createDateEnd;
  }

  public void setCreateDateEnd(String createDateEnd) {
    this.createDateEnd = createDateEnd;
  }

  public Integer getPageNumber() {
    return pageNumber;
  }

  public void setPageNumber(Integer pageNumber) {
    this.pageNumber = pageNumber;
  }

  public Byte getUseChannel() {
    return useChannel;
  }

  public void setUseChannel(Byte useChannel) {
    this.useChannel = useChannel;
  }

  public String getCreateUserName() {
    return createUserName;
  }

  public void setCreateUserName(String createUserName) {
    this.createUserName = createUserName;
  }

  public Long getCouponDefinitionId() {
    return couponDefinitionId;
  }

  public void setCouponDefinitionId(Long couponDefinitionId) {
    this.couponDefinitionId = couponDefinitionId;
  }

  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }
  
  
}
