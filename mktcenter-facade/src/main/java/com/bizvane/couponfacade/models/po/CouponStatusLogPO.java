package com.bizvane.couponfacade.models.po;

import java.io.Serializable;
import java.util.Date;

public class CouponStatusLogPO implements Serializable {

  /**
   * 只读. pkid. coupon_status_log_id
   * @mbg.generated  2018-07-27 16:45:43
   */
  @io.swagger.annotations.ApiModelProperty(value = "pkid", name = "couponStatusLogId", required = false, example = "")
  private Long couponStatusLogId;
  /**
   * 只读. 所属公司id. sys_company_id
   * @mbg.generated  2018-07-27 16:45:43
   */
  @io.swagger.annotations.ApiModelProperty(value = "所属公司id", name = "sysCompanyId", required = false, example = "")
  private Long sysCompanyId;
  /**
   * 只读. 所属品牌id. sys_brand_id
   * @mbg.generated  2018-07-27 16:45:43
   */
  @io.swagger.annotations.ApiModelProperty(value = "所属品牌id", name = "sysBrandId", required = false, example = "")
  private Long sysBrandId;
  /**
   * 只读. 所属品牌id. brand_code
   * @mbg.generated  2018-07-27 16:45:43
   */
  @io.swagger.annotations.ApiModelProperty(value = "所属品牌id", name = "brandCode", required = false, example = "")
  private String brandCode;
  /**
   * 只读. 券实例id. coupon_entity_id
   * @mbg.generated  2018-07-27 16:45:43
   */
  @io.swagger.annotations.ApiModelProperty(value = "券实例id", name = "couponEntityId", required = false, example = "")
  private Long couponEntityId;
  /**
   * 只读. 券号. coupon_code
   * @mbg.generated  2018-07-27 16:45:43
   */
  @io.swagger.annotations.ApiModelProperty(value = "券号", name = "couponCode", required = false, example = "")
  private String couponCode;
  /**
   * 只读. 业务类型（1过期，2核销，3转赠）. business_type
   * @mbg.generated  2018-07-27 16:45:43
   */
  @io.swagger.annotations.ApiModelProperty(value = "业务类型（1过期，2核销，3转赠）", name = "businessType", required = false,
      example = "")
  private Byte businessType;
  /**
   * 只读. 业务code. business_code
   * @mbg.generated  2018-07-27 16:45:43
   */
  @io.swagger.annotations.ApiModelProperty(value = "业务code", name = "businessCode", required = false, example = "")
  private String businessCode;
  /**
   * 只读. 业务时间. business_time
   * @mbg.generated  2018-07-27 16:45:43
   */
  @io.swagger.annotations.ApiModelProperty(value = "业务时间", name = "businessTime", required = false, example = "")
  private Date businessTime;
  /**
   * 只读. 转赠人code. transfer_member_code
   * @mbg.generated  2018-07-27 16:45:43
   */
  @io.swagger.annotations.ApiModelProperty(value = "转赠人code", name = "transferMemberCode", required = false,
      example = "")
  private String transferMemberCode;
  /**
   * 只读. 转赠人姓名. transfer_member_name
   * @mbg.generated  2018-07-27 16:45:43
   */
  @io.swagger.annotations.ApiModelProperty(value = "转赠人姓名", name = "transferMemberName", required = false, example = "")
  private String transferMemberName;
  /**
   * 只读. 被转赠人code. received_member_code
   * @mbg.generated  2018-07-27 16:45:43
   */
  @io.swagger.annotations.ApiModelProperty(value = "被转赠人code", name = "receivedMemberCode", required = false,
      example = "")
  private String receivedMemberCode;
  /**
   * 只读. 被转赠人姓名. received_member_name
   * @mbg.generated  2018-07-27 16:45:43
   */
  @io.swagger.annotations.ApiModelProperty(value = "被转赠人姓名", name = "receivedMemberName", required = false,
      example = "")
  private String receivedMemberName;
  /**
   * 只读. 备注. remark
   * @mbg.generated  2018-07-27 16:45:43
   */
  @io.swagger.annotations.ApiModelProperty(value = "备注", name = "remark", required = false, example = "")
  private String remark;
  /**
   * 只读. 创建人id. create_user_id
   * @mbg.generated  2018-07-27 16:45:43
   */
  @io.swagger.annotations.ApiModelProperty(value = "创建人id", name = "createUserId", required = false, example = "")
  private Long createUserId;
  /**
   * 只读. 创建人. create_user_name
   * @mbg.generated  2018-07-27 16:45:43
   */
  @io.swagger.annotations.ApiModelProperty(value = "创建人", name = "createUserName", required = false, example = "")
  private String createUserName;
  /**
   * 只读. 创建时间. create_date
   * @mbg.generated  2018-07-27 16:45:43
   */
  @io.swagger.annotations.ApiModelProperty(value = "创建时间", name = "createDate", required = false, example = "")
  private Date createDate;
  /**
   * 只读. 修改人id. modified_user_id
   * @mbg.generated  2018-07-27 16:45:43
   */
  @io.swagger.annotations.ApiModelProperty(value = "修改人id", name = "modifiedUserId", required = false, example = "")
  private Long modifiedUserId;
  /**
   * 只读. 修改人. modified_user_name
   * @mbg.generated  2018-07-27 16:45:43
   */
  @io.swagger.annotations.ApiModelProperty(value = "修改人", name = "modifiedUserName", required = false, example = "")
  private String modifiedUserName;
  /**
   * 只读. 修改时间. modified_date
   * @mbg.generated  2018-07-27 16:45:43
   */
  @io.swagger.annotations.ApiModelProperty(value = "修改时间", name = "modifiedDate", required = false, example = "")
  private Date modifiedDate;
  /**
   * 只读. 数据有效性（1有效，0无效）. valid
   * @mbg.generated  2018-07-27 16:45:43
   */
  @io.swagger.annotations.ApiModelProperty(value = "数据有效性（1有效，0无效）", name = "valid", required = false, example = "")
  private Boolean valid;
  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  private static final long serialVersionUID = 1L;

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  public Long getCouponStatusLogId() {
    return couponStatusLogId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  public void setCouponStatusLogId(Long couponStatusLogId) {
    this.couponStatusLogId = couponStatusLogId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  public Long getSysCompanyId() {
    return sysCompanyId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  public void setSysCompanyId(Long sysCompanyId) {
    this.sysCompanyId = sysCompanyId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  public Long getSysBrandId() {
    return sysBrandId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  public void setSysBrandId(Long sysBrandId) {
    this.sysBrandId = sysBrandId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  public String getBrandCode() {
    return brandCode;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  public void setBrandCode(String brandCode) {
    this.brandCode = brandCode == null ? null : brandCode.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  public Long getCouponEntityId() {
    return couponEntityId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  public void setCouponEntityId(Long couponEntityId) {
    this.couponEntityId = couponEntityId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  public String getCouponCode() {
    return couponCode;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  public void setCouponCode(String couponCode) {
    this.couponCode = couponCode == null ? null : couponCode.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  public Byte getBusinessType() {
    return businessType;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  public void setBusinessType(Byte businessType) {
    this.businessType = businessType;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  public String getBusinessCode() {
    return businessCode;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  public void setBusinessCode(String businessCode) {
    this.businessCode = businessCode == null ? null : businessCode.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  public Date getBusinessTime() {
    return businessTime;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  public void setBusinessTime(Date businessTime) {
    this.businessTime = businessTime;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  public String getTransferMemberCode() {
    return transferMemberCode;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  public void setTransferMemberCode(String transferMemberCode) {
    this.transferMemberCode = transferMemberCode == null ? null : transferMemberCode.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  public String getTransferMemberName() {
    return transferMemberName;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  public void setTransferMemberName(String transferMemberName) {
    this.transferMemberName = transferMemberName == null ? null : transferMemberName.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  public String getReceivedMemberCode() {
    return receivedMemberCode;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  public void setReceivedMemberCode(String receivedMemberCode) {
    this.receivedMemberCode = receivedMemberCode == null ? null : receivedMemberCode.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  public String getReceivedMemberName() {
    return receivedMemberName;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  public void setReceivedMemberName(String receivedMemberName) {
    this.receivedMemberName = receivedMemberName == null ? null : receivedMemberName.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  public String getRemark() {
    return remark;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  public void setRemark(String remark) {
    this.remark = remark == null ? null : remark.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  public Long getCreateUserId() {
    return createUserId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  public void setCreateUserId(Long createUserId) {
    this.createUserId = createUserId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  public String getCreateUserName() {
    return createUserName;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  public void setCreateUserName(String createUserName) {
    this.createUserName = createUserName == null ? null : createUserName.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  public Date getCreateDate() {
    return createDate;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  public Long getModifiedUserId() {
    return modifiedUserId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  public void setModifiedUserId(Long modifiedUserId) {
    this.modifiedUserId = modifiedUserId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  public String getModifiedUserName() {
    return modifiedUserName;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  public void setModifiedUserName(String modifiedUserName) {
    this.modifiedUserName = modifiedUserName == null ? null : modifiedUserName.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  public Date getModifiedDate() {
    return modifiedDate;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  public void setModifiedDate(Date modifiedDate) {
    this.modifiedDate = modifiedDate;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  public Boolean getValid() {
    return valid;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  public void setValid(Boolean valid) {
    this.valid = valid;
  }
}