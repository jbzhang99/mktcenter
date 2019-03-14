package com.bizvane.couponfacade.models.po;

import java.io.Serializable;
import java.util.Date;

public class CouponOfflineBindPO implements Serializable {

  /**
   * 只读. 主键id. coupon_offline_bind_id
   * @mbg.generated  2018-07-26 09:54:19
   */
  @io.swagger.annotations.ApiModelProperty(value = "主键id", name = "couponOfflineBindId", required = false, example = "")
  private Long couponOfflineBindId;
  /**
   * 只读. 所属企业id. sys_company_id
   * @mbg.generated  2018-07-26 09:54:19
   */
  @io.swagger.annotations.ApiModelProperty(value = "所属企业id", name = "sysCompanyId", required = false, example = "")
  private Long sysCompanyId;
  /**
   * 只读. 品牌编号. brand_code
   * @mbg.generated  2018-07-26 09:54:19
   */
  @io.swagger.annotations.ApiModelProperty(value = "品牌编号", name = "brandCode", required = false, example = "")
  private String brandCode;
  /**
   * 只读. 券类型编号. type_code
   * @mbg.generated  2018-07-26 09:54:19
   */
  @io.swagger.annotations.ApiModelProperty(value = "券类型编号", name = "typeCode", required = false, example = "")
  private String typeCode;
  /**
   * 只读. 批次号. batch_no
   * @mbg.generated  2018-07-26 09:54:19
   */
  @io.swagger.annotations.ApiModelProperty(value = "批次号", name = "batchNo", required = false, example = "")
  private String batchNo;
  /**
   * 只读. 错误次数. err_count
   * @mbg.generated  2018-07-26 09:54:19
   */
  @io.swagger.annotations.ApiModelProperty(value = "错误次数", name = "errCount", required = false, example = "")
  private Integer errCount;
  /**
   * 只读. 提交时间. submit_time
   * @mbg.generated  2018-07-26 09:54:19
   */
  @io.swagger.annotations.ApiModelProperty(value = "提交时间", name = "submitTime", required = false, example = "")
  private Date submitTime;
  /**
   * 只读. 备注. remark
   * @mbg.generated  2018-07-26 09:54:19
   */
  @io.swagger.annotations.ApiModelProperty(value = "备注", name = "remark", required = false, example = "")
  private String remark;
  /**
   * 只读. 创建人id. create_user_id
   * @mbg.generated  2018-07-26 09:54:19
   */
  @io.swagger.annotations.ApiModelProperty(value = "创建人id", name = "createUserId", required = false, example = "")
  private Long createUserId;
  /**
   * 只读. 创建人. create_user_name
   * @mbg.generated  2018-07-26 09:54:19
   */
  @io.swagger.annotations.ApiModelProperty(value = "创建人", name = "createUserName", required = false, example = "")
  private String createUserName;
  /**
   * 只读. 创建时间. create_date
   * @mbg.generated  2018-07-26 09:54:19
   */
  @io.swagger.annotations.ApiModelProperty(value = "创建时间", name = "createDate", required = false, example = "")
  private Date createDate;
  /**
   * 只读. 修改人id. modified_user_id
   * @mbg.generated  2018-07-26 09:54:19
   */
  @io.swagger.annotations.ApiModelProperty(value = "修改人id", name = "modifiedUserId", required = false, example = "")
  private Long modifiedUserId;
  /**
   * 只读. 修改人. modified_user_name
   * @mbg.generated  2018-07-26 09:54:19
   */
  @io.swagger.annotations.ApiModelProperty(value = "修改人", name = "modifiedUserName", required = false, example = "")
  private String modifiedUserName;
  /**
   * 只读. 修改时间. modified_date
   * @mbg.generated  2018-07-26 09:54:19
   */
  @io.swagger.annotations.ApiModelProperty(value = "修改时间", name = "modifiedDate", required = false, example = "")
  private Date modifiedDate;
  /**
   * 只读. 数据有效性（1有效，0无效）. valid
   * @mbg.generated  2018-07-26 09:54:19
   */
  @io.swagger.annotations.ApiModelProperty(value = "数据有效性（1有效，0无效）", name = "valid", required = false, example = "")
  private Boolean valid;
  /**
   * 只读. 会员. member_id_list
   * @mbg.generated  2018-07-26 09:54:19
   */
  @io.swagger.annotations.ApiModelProperty(value = "会员", name = "memberIdList", required = false, example = "")
  private String memberIdList;
  /**
   * 只读. 
   * @mbg.generated  2018-07-26 09:54:19
   */
  private static final long serialVersionUID = 1L;

  /**
   * 只读. 
   * @mbg.generated  2018-07-26 09:54:19
   */
  public Long getCouponOfflineBindId() {
    return couponOfflineBindId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-26 09:54:19
   */
  public void setCouponOfflineBindId(Long couponOfflineBindId) {
    this.couponOfflineBindId = couponOfflineBindId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-26 09:54:19
   */
  public Long getSysCompanyId() {
    return sysCompanyId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-26 09:54:19
   */
  public void setSysCompanyId(Long sysCompanyId) {
    this.sysCompanyId = sysCompanyId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-26 09:54:19
   */
  public String getBrandCode() {
    return brandCode;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-26 09:54:19
   */
  public void setBrandCode(String brandCode) {
    this.brandCode = brandCode == null ? null : brandCode.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-26 09:54:19
   */
  public String getTypeCode() {
    return typeCode;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-26 09:54:19
   */
  public void setTypeCode(String typeCode) {
    this.typeCode = typeCode == null ? null : typeCode.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-26 09:54:19
   */
  public String getBatchNo() {
    return batchNo;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-26 09:54:19
   */
  public void setBatchNo(String batchNo) {
    this.batchNo = batchNo == null ? null : batchNo.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-26 09:54:19
   */
  public Integer getErrCount() {
    return errCount;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-26 09:54:19
   */
  public void setErrCount(Integer errCount) {
    this.errCount = errCount;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-26 09:54:19
   */
  public Date getSubmitTime() {
    return submitTime;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-26 09:54:19
   */
  public void setSubmitTime(Date submitTime) {
    this.submitTime = submitTime;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-26 09:54:19
   */
  public String getRemark() {
    return remark;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-26 09:54:19
   */
  public void setRemark(String remark) {
    this.remark = remark == null ? null : remark.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-26 09:54:19
   */
  public Long getCreateUserId() {
    return createUserId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-26 09:54:19
   */
  public void setCreateUserId(Long createUserId) {
    this.createUserId = createUserId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-26 09:54:19
   */
  public String getCreateUserName() {
    return createUserName;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-26 09:54:19
   */
  public void setCreateUserName(String createUserName) {
    this.createUserName = createUserName == null ? null : createUserName.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-26 09:54:19
   */
  public Date getCreateDate() {
    return createDate;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-26 09:54:19
   */
  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-26 09:54:19
   */
  public Long getModifiedUserId() {
    return modifiedUserId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-26 09:54:19
   */
  public void setModifiedUserId(Long modifiedUserId) {
    this.modifiedUserId = modifiedUserId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-26 09:54:19
   */
  public String getModifiedUserName() {
    return modifiedUserName;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-26 09:54:19
   */
  public void setModifiedUserName(String modifiedUserName) {
    this.modifiedUserName = modifiedUserName == null ? null : modifiedUserName.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-26 09:54:19
   */
  public Date getModifiedDate() {
    return modifiedDate;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-26 09:54:19
   */
  public void setModifiedDate(Date modifiedDate) {
    this.modifiedDate = modifiedDate;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-26 09:54:19
   */
  public Boolean getValid() {
    return valid;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-26 09:54:19
   */
  public void setValid(Boolean valid) {
    this.valid = valid;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-26 09:54:19
   */
  public String getMemberIdList() {
    return memberIdList;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-26 09:54:19
   */
  public void setMemberIdList(String memberIdList) {
    this.memberIdList = memberIdList == null ? null : memberIdList.trim();
  }
}