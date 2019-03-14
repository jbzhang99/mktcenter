package com.bizvane.couponfacade.models.po;

import java.io.Serializable;
import java.util.Date;

public class CouponIssueBatchPO implements Serializable {

  /**
   * 只读. pkid. coupon_issue_batch_id
   * @mbg.generated  2018-07-06 10:56:28
   */
  @io.swagger.annotations.ApiModelProperty(value = "pkid", name = "couponIssueBatchId", required = false, example = "")
  private Long couponIssueBatchId;
  /**
   * 只读. 券定义id. coupon_definition_id
   * @mbg.generated  2018-07-06 10:56:28
   */
  @io.swagger.annotations.ApiModelProperty(value = "券定义id", name = "couponDefinitionId", required = false, example = "")
  private Long couponDefinitionId;
  /**
   * 只读. 发行批次号. issue_batch_code
   * @mbg.generated  2018-07-06 10:56:28
   */
  @io.swagger.annotations.ApiModelProperty(value = "发行批次号", name = "issueBatchCode", required = false, example = "")
  private String issueBatchCode;
  /**
   * 只读. 发行数量. issue_num
   * @mbg.generated  2018-07-06 10:56:28
   */
  @io.swagger.annotations.ApiModelProperty(value = "发行数量", name = "issueNum", required = false, example = "")
  private Integer issueNum;
  /**
   * 只读. 失败数量. issue_fail_num
   * @mbg.generated  2018-07-06 10:56:28
   */
  @io.swagger.annotations.ApiModelProperty(value = "失败数量", name = "issueFailNum", required = false, example = "")
  private Integer issueFailNum;
  /**
   * 只读. 发行人id. issue_user_id
   * @mbg.generated  2018-07-06 10:56:28
   */
  @io.swagger.annotations.ApiModelProperty(value = "发行人id", name = "issueUserId", required = false, example = "")
  private Long issueUserId;
  /**
   * 只读. 发行人. issue_user_name
   * @mbg.generated  2018-07-06 10:56:28
   */
  @io.swagger.annotations.ApiModelProperty(value = "发行人", name = "issueUserName", required = false, example = "")
  private String issueUserName;
  /**
   * 只读. 发行时间. issue_time
   * @mbg.generated  2018-07-06 10:56:28
   */
  @io.swagger.annotations.ApiModelProperty(value = "发行时间", name = "issueTime", required = false, example = "")
  private Date issueTime;
  /**
   * 只读. 审核人id. check_user_id
   * @mbg.generated  2018-07-06 10:56:28
   */
  @io.swagger.annotations.ApiModelProperty(value = "审核人id", name = "checkUserId", required = false, example = "")
  private Long checkUserId;
  /**
   * 只读. 审核人. check_user_name
   * @mbg.generated  2018-07-06 10:56:28
   */
  @io.swagger.annotations.ApiModelProperty(value = "审核人", name = "checkUserName", required = false, example = "")
  private String checkUserName;
  /**
   * 只读. 发行状态（1未审核，2已审核，3发行中，4已发行）. issue_status
   * @mbg.generated  2018-07-06 10:56:28
   */
  @io.swagger.annotations.ApiModelProperty(value = "发行状态（1未审核，2已审核，3发行中，4已发行）", name = "issueStatus", required = false,
      example = "")
  private Byte issueStatus;
  /**
   * 只读. 是否需要与线下同步（1是，0否）. offline_sync
   * @mbg.generated  2018-07-06 10:56:28
   */
  @io.swagger.annotations.ApiModelProperty(value = "是否需要与线下同步（1是，0否）", name = "offlineSync", required = false,
      example = "")
  private Boolean offlineSync;
  /**
   * 只读. 同步状态（1未同步，2已同步，3同步中）. sync_status
   * @mbg.generated  2018-07-06 10:56:28
   */
  @io.swagger.annotations.ApiModelProperty(value = "同步状态（1未同步，2已同步，3同步中）", name = "syncStatus", required = false,
      example = "")
  private Byte syncStatus;
  /**
   * 只读. 备注. remark
   * @mbg.generated  2018-07-06 10:56:28
   */
  @io.swagger.annotations.ApiModelProperty(value = "备注", name = "remark", required = false, example = "")
  private String remark;
  /**
   * 只读. 创建人id. create_user_id
   * @mbg.generated  2018-07-06 10:56:28
   */
  @io.swagger.annotations.ApiModelProperty(value = "创建人id", name = "createUserId", required = false, example = "")
  private Long createUserId;
  /**
   * 只读. 创建人. create_user_name
   * @mbg.generated  2018-07-06 10:56:28
   */
  @io.swagger.annotations.ApiModelProperty(value = "创建人", name = "createUserName", required = false, example = "")
  private String createUserName;
  /**
   * 只读. 创建时间. create_date
   * @mbg.generated  2018-07-06 10:56:28
   */
  @io.swagger.annotations.ApiModelProperty(value = "创建时间", name = "createDate", required = false, example = "")
  private Date createDate;
  /**
   * 只读. 修改人id. modified_user_id
   * @mbg.generated  2018-07-06 10:56:28
   */
  @io.swagger.annotations.ApiModelProperty(value = "修改人id", name = "modifiedUserId", required = false, example = "")
  private Long modifiedUserId;
  /**
   * 只读. 修改人. modified_user_name
   * @mbg.generated  2018-07-06 10:56:28
   */
  @io.swagger.annotations.ApiModelProperty(value = "修改人", name = "modifiedUserName", required = false, example = "")
  private String modifiedUserName;
  /**
   * 只读. 修改时间. modified_date
   * @mbg.generated  2018-07-06 10:56:28
   */
  @io.swagger.annotations.ApiModelProperty(value = "修改时间", name = "modifiedDate", required = false, example = "")
  private Date modifiedDate;
  /**
   * 只读. 数据有效性（1有效，0无效）. valid
   * @mbg.generated  2018-07-06 10:56:28
   */
  @io.swagger.annotations.ApiModelProperty(value = "数据有效性（1有效，0无效）", name = "valid", required = false, example = "")
  private Boolean valid;
  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  private static final long serialVersionUID = 1L;

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  public Long getCouponIssueBatchId() {
    return couponIssueBatchId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  public void setCouponIssueBatchId(Long couponIssueBatchId) {
    this.couponIssueBatchId = couponIssueBatchId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  public Long getCouponDefinitionId() {
    return couponDefinitionId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  public void setCouponDefinitionId(Long couponDefinitionId) {
    this.couponDefinitionId = couponDefinitionId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  public String getIssueBatchCode() {
    return issueBatchCode;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  public void setIssueBatchCode(String issueBatchCode) {
    this.issueBatchCode = issueBatchCode == null ? null : issueBatchCode.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  public Integer getIssueNum() {
    return issueNum;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  public void setIssueNum(Integer issueNum) {
    this.issueNum = issueNum;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  public Integer getIssueFailNum() {
    return issueFailNum;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  public void setIssueFailNum(Integer issueFailNum) {
    this.issueFailNum = issueFailNum;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  public Long getIssueUserId() {
    return issueUserId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  public void setIssueUserId(Long issueUserId) {
    this.issueUserId = issueUserId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  public String getIssueUserName() {
    return issueUserName;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  public void setIssueUserName(String issueUserName) {
    this.issueUserName = issueUserName == null ? null : issueUserName.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  public Date getIssueTime() {
    return issueTime;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  public void setIssueTime(Date issueTime) {
    this.issueTime = issueTime;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  public Long getCheckUserId() {
    return checkUserId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  public void setCheckUserId(Long checkUserId) {
    this.checkUserId = checkUserId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  public String getCheckUserName() {
    return checkUserName;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  public void setCheckUserName(String checkUserName) {
    this.checkUserName = checkUserName == null ? null : checkUserName.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  public Byte getIssueStatus() {
    return issueStatus;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  public void setIssueStatus(Byte issueStatus) {
    this.issueStatus = issueStatus;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  public Boolean getOfflineSync() {
    return offlineSync;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  public void setOfflineSync(Boolean offlineSync) {
    this.offlineSync = offlineSync;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  public Byte getSyncStatus() {
    return syncStatus;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  public void setSyncStatus(Byte syncStatus) {
    this.syncStatus = syncStatus;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  public String getRemark() {
    return remark;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  public void setRemark(String remark) {
    this.remark = remark == null ? null : remark.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  public Long getCreateUserId() {
    return createUserId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  public void setCreateUserId(Long createUserId) {
    this.createUserId = createUserId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  public String getCreateUserName() {
    return createUserName;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  public void setCreateUserName(String createUserName) {
    this.createUserName = createUserName == null ? null : createUserName.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  public Date getCreateDate() {
    return createDate;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  public Long getModifiedUserId() {
    return modifiedUserId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  public void setModifiedUserId(Long modifiedUserId) {
    this.modifiedUserId = modifiedUserId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  public String getModifiedUserName() {
    return modifiedUserName;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  public void setModifiedUserName(String modifiedUserName) {
    this.modifiedUserName = modifiedUserName == null ? null : modifiedUserName.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  public Date getModifiedDate() {
    return modifiedDate;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  public void setModifiedDate(Date modifiedDate) {
    this.modifiedDate = modifiedDate;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  public Boolean getValid() {
    return valid;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  public void setValid(Boolean valid) {
    this.valid = valid;
  }
}