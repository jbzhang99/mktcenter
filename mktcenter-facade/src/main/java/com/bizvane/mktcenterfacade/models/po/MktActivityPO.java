package com.bizvane.mktcenterfacade.models.po;

import java.io.Serializable;
import java.util.Date;

public class MktActivityPO implements Serializable {

  /**
   * 只读. pkid. mkt_activity_id
   * @mbg.generated  2019-05-24 15:35:50
   */
  @io.swagger.annotations.ApiModelProperty(value = "pkid", name = "mktActivityId", required = false, example = "")
  private Long mktActivityId;
  /**
   * 只读. 所属企业id. sys_company_id
   * @mbg.generated  2019-05-24 15:35:50
   */
  @io.swagger.annotations.ApiModelProperty(value = "所属企业id", name = "sysCompanyId", required = false, example = "")
  private Long sysCompanyId;
  /**
   * 只读. 所属品牌id. sys_brand_id
   * @mbg.generated  2019-05-24 15:35:50
   */
  @io.swagger.annotations.ApiModelProperty(value = "所属品牌id", name = "sysBrandId", required = false, example = "")
  private Long sysBrandId;
  /**
   * 只读. 关联的会员分组id. mbr_group_def_id
   * @mbg.generated  2019-05-24 15:35:50
   */
  @io.swagger.annotations.ApiModelProperty(value = "关联的会员分组id", name = "mbrGroupDefId", required = false, example = "")
  private Long mbrGroupDefId;
  /**
   * 只读. 关联智能营销分组id. mkt_activity_smart_group_id
   * @mbg.generated  2019-05-24 15:35:50
   */
  @io.swagger.annotations.ApiModelProperty(value = "关联智能营销分组id", name = "mktActivitySmartGroupId", required = false,
      example = "")
  private Long mktActivitySmartGroupId;
  /**
   * 只读. 活动编号. activity_code
   * @mbg.generated  2019-05-24 15:35:50
   */
  @io.swagger.annotations.ApiModelProperty(value = "活动编号", name = "activityCode", required = false, example = "")
  private String activityCode;
  /**
   * 只读. 活动类型：1开卡活动，2升级活动，3扫码领券，4手动领券，5消费活动，6签到活动，7生日活动，8智能营销，9评价奖励，10入会纪念，11大转盘，12红包膨胀，13砸金蛋. activity_type
   * @mbg.generated  2019-05-24 15:35:50
   */
  @io.swagger.annotations.ApiModelProperty(
      value = "活动类型：1开卡活动，2升级活动，3扫码领券，4手动领券，5消费活动，6签到活动，7生日活动，8智能营销，9评价奖励，10入会纪念，11大转盘，12红包膨胀，13砸金蛋",
      name = "activityType", required = false, example = "")
  private Integer activityType;
  /**
   * 只读. 活动名称. activity_name
   * @mbg.generated  2019-05-24 15:35:50
   */
  @io.swagger.annotations.ApiModelProperty(value = "活动名称", name = "activityName", required = false, example = "")
  private String activityName;
  /**
   * 只读. 活动开始时间. start_time
   * @mbg.generated  2019-05-24 15:35:50
   */
  @io.swagger.annotations.ApiModelProperty(value = "活动开始时间", name = "startTime", required = false, example = "")
  private Date startTime;
  /**
   * 只读. 活动结束时间. end_time
   * @mbg.generated  2019-05-24 15:35:50
   */
  @io.swagger.annotations.ApiModelProperty(value = "活动结束时间", name = "endTime", required = false, example = "")
  private Date endTime;
  /**
   * 只读. 是否长期：1是，0否. long_term
   * @mbg.generated  2019-05-24 15:35:50
   */
  @io.swagger.annotations.ApiModelProperty(value = "是否长期：1是，0否", name = "longTerm", required = false, example = "")
  private Integer longTerm;
  /**
   * 只读. 积分立即赠送：1是，0否. send_immediately
   * @mbg.generated  2019-05-24 15:35:50
   */
  @io.swagger.annotations.ApiModelProperty(value = "积分立即赠送：1是，0否", name = "sendImmediately", required = false,
      example = "")
  private Boolean sendImmediately;
  /**
   * 只读. 积分开始赠送时间. send_time
   * @mbg.generated  2019-05-24 15:35:50
   */
  @io.swagger.annotations.ApiModelProperty(value = "积分开始赠送时间", name = "sendTime", required = false, example = "")
  private Date sendTime;
  /**
   * 只读. 赠送积分. points
   * @mbg.generated  2019-05-24 15:35:50
   */
  @io.swagger.annotations.ApiModelProperty(value = "赠送积分", name = "points", required = false, example = "")
  private Integer points;
  /**
   * 只读. 活动列表图片，多张逗号分隔. activity_list_img
   * @mbg.generated  2019-05-24 15:35:50
   */
  @io.swagger.annotations.ApiModelProperty(value = "活动列表图片，多张逗号分隔", name = "activityListImg", required = false,
      example = "")
  private String activityListImg;
  /**
   * 只读. 活动详情图片. activity_detail_img
   * @mbg.generated  2019-05-24 15:35:50
   */
  @io.swagger.annotations.ApiModelProperty(value = "活动详情图片", name = "activityDetailImg", required = false, example = "")
  private String activityDetailImg;
  /**
   * 只读. 二维码图片url. qr_code_url
   * @mbg.generated  2019-05-24 15:35:50
   */
  @io.swagger.annotations.ApiModelProperty(value = "二维码图片url", name = "qrCodeUrl", required = false, example = "")
  private String qrCodeUrl;
  /**
   * 只读. 审核状态：0全部，1待审核，2审核中，3已审核，4已驳回. check_status
   * @mbg.generated  2019-05-24 15:35:50
   */
  @io.swagger.annotations.ApiModelProperty(value = "审核状态：0全部，1待审核，2审核中，3已审核，4已驳回", name = "checkStatus",
      required = false, example = "")
  private Integer checkStatus;
  /**
   * 只读. 活动状态：0全部，1待执行，2执行中，3已结束，4已禁用. activity_status
   * @mbg.generated  2019-05-24 15:35:50
   */
  @io.swagger.annotations.ApiModelProperty(value = "活动状态：0全部，1待执行，2执行中，3已结束，4已禁用", name = "activityStatus",
      required = false, example = "")
  private Integer activityStatus;
  /**
   * 只读. 门店限制状态：0不限制，1限制. is_store_limit
   * @mbg.generated  2019-05-24 15:35:50
   */
  @io.swagger.annotations.ApiModelProperty(value = "门店限制状态：0不限制，1限制", name = "isStoreLimit", required = false,
      example = "")
  private Boolean isStoreLimit;
  /**
   * 只读. 门店限制类型：1黑名单，2白名单. store_limit_type
   * @mbg.generated  2019-05-24 15:35:50
   */
  @io.swagger.annotations.ApiModelProperty(value = "门店限制类型：1黑名单，2白名单", name = "storeLimitType", required = false,
      example = "")
  private Integer storeLimitType;
  /**
   * 只读. 消耗积分. prize_points
   * @mbg.generated  2019-05-24 15:35:50
   */
  @io.swagger.annotations.ApiModelProperty(value = "消耗积分", name = "prizePoints", required = false, example = "")
  private Integer prizePoints;
  /**
   * 只读. 没人每天限制次数. tries_limit
   * @mbg.generated  2019-05-24 15:35:50
   */
  @io.swagger.annotations.ApiModelProperty(value = "没人每天限制次数", name = "triesLimit", required = false, example = "")
  private Integer triesLimit;
  /**
   * 只读. 备注. remark
   * @mbg.generated  2019-05-24 15:35:50
   */
  @io.swagger.annotations.ApiModelProperty(value = "备注", name = "remark", required = false, example = "")
  private String remark;
  /**
   * 只读. 创建人id. create_user_id
   * @mbg.generated  2019-05-24 15:35:50
   */
  @io.swagger.annotations.ApiModelProperty(value = "创建人id", name = "createUserId", required = false, example = "")
  private Long createUserId;
  /**
   * 只读. 创建人. create_user_name
   * @mbg.generated  2019-05-24 15:35:50
   */
  @io.swagger.annotations.ApiModelProperty(value = "创建人", name = "createUserName", required = false, example = "")
  private String createUserName;
  /**
   * 只读. 创建日期. create_date
   * @mbg.generated  2019-05-24 15:35:50
   */
  @io.swagger.annotations.ApiModelProperty(value = "创建日期", name = "createDate", required = false, example = "")
  private Date createDate;
  /**
   * 只读. 修改人id. modified_user_id
   * @mbg.generated  2019-05-24 15:35:50
   */
  @io.swagger.annotations.ApiModelProperty(value = "修改人id", name = "modifiedUserId", required = false, example = "")
  private Long modifiedUserId;
  /**
   * 只读. 修改人. modified_user_name
   * @mbg.generated  2019-05-24 15:35:50
   */
  @io.swagger.annotations.ApiModelProperty(value = "修改人", name = "modifiedUserName", required = false, example = "")
  private String modifiedUserName;
  /**
   * 只读. 修改时间. modified_date
   * @mbg.generated  2019-05-24 15:35:50
   */
  @io.swagger.annotations.ApiModelProperty(value = "修改时间", name = "modifiedDate", required = false, example = "")
  private Date modifiedDate;
  /**
   * 只读. 数据有效性：1=有效；0=无效. valid
   * @mbg.generated  2019-05-24 15:35:50
   */
  @io.swagger.annotations.ApiModelProperty(value = "数据有效性：1=有效；0=无效", name = "valid", required = false, example = "")
  private Boolean valid;
  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  private static final long serialVersionUID = 1L;

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public Long getMktActivityId() {
    return mktActivityId;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public void setMktActivityId(Long mktActivityId) {
    this.mktActivityId = mktActivityId;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public Long getSysCompanyId() {
    return sysCompanyId;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public void setSysCompanyId(Long sysCompanyId) {
    this.sysCompanyId = sysCompanyId;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public Long getSysBrandId() {
    return sysBrandId;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public void setSysBrandId(Long sysBrandId) {
    this.sysBrandId = sysBrandId;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public Long getMbrGroupDefId() {
    return mbrGroupDefId;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public void setMbrGroupDefId(Long mbrGroupDefId) {
    this.mbrGroupDefId = mbrGroupDefId;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public Long getMktActivitySmartGroupId() {
    return mktActivitySmartGroupId;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public void setMktActivitySmartGroupId(Long mktActivitySmartGroupId) {
    this.mktActivitySmartGroupId = mktActivitySmartGroupId;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public String getActivityCode() {
    return activityCode;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public void setActivityCode(String activityCode) {
    this.activityCode = activityCode == null ? null : activityCode.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public Integer getActivityType() {
    return activityType;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public void setActivityType(Integer activityType) {
    this.activityType = activityType;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public String getActivityName() {
    return activityName;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public void setActivityName(String activityName) {
    this.activityName = activityName == null ? null : activityName.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public Date getStartTime() {
    return startTime;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public Date getEndTime() {
    return endTime;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public Integer getLongTerm() {
    return longTerm;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public void setLongTerm(Integer longTerm) {
    this.longTerm = longTerm;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public Boolean getSendImmediately() {
    return sendImmediately;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public void setSendImmediately(Boolean sendImmediately) {
    this.sendImmediately = sendImmediately;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public Date getSendTime() {
    return sendTime;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public void setSendTime(Date sendTime) {
    this.sendTime = sendTime;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public Integer getPoints() {
    return points;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public void setPoints(Integer points) {
    this.points = points;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public String getActivityListImg() {
    return activityListImg;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public void setActivityListImg(String activityListImg) {
    this.activityListImg = activityListImg == null ? null : activityListImg.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public String getActivityDetailImg() {
    return activityDetailImg;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public void setActivityDetailImg(String activityDetailImg) {
    this.activityDetailImg = activityDetailImg == null ? null : activityDetailImg.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public String getQrCodeUrl() {
    return qrCodeUrl;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public void setQrCodeUrl(String qrCodeUrl) {
    this.qrCodeUrl = qrCodeUrl == null ? null : qrCodeUrl.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public Integer getCheckStatus() {
    return checkStatus;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public void setCheckStatus(Integer checkStatus) {
    this.checkStatus = checkStatus;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public Integer getActivityStatus() {
    return activityStatus;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public void setActivityStatus(Integer activityStatus) {
    this.activityStatus = activityStatus;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public Boolean getIsStoreLimit() {
    return isStoreLimit;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public void setIsStoreLimit(Boolean isStoreLimit) {
    this.isStoreLimit = isStoreLimit;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public Integer getStoreLimitType() {
    return storeLimitType;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public void setStoreLimitType(Integer storeLimitType) {
    this.storeLimitType = storeLimitType;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public Integer getPrizePoints() {
    return prizePoints;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public void setPrizePoints(Integer prizePoints) {
    this.prizePoints = prizePoints;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public Integer getTriesLimit() {
    return triesLimit;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public void setTriesLimit(Integer triesLimit) {
    this.triesLimit = triesLimit;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public String getRemark() {
    return remark;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public void setRemark(String remark) {
    this.remark = remark == null ? null : remark.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public Long getCreateUserId() {
    return createUserId;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public void setCreateUserId(Long createUserId) {
    this.createUserId = createUserId;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public String getCreateUserName() {
    return createUserName;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public void setCreateUserName(String createUserName) {
    this.createUserName = createUserName == null ? null : createUserName.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public Date getCreateDate() {
    return createDate;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public Long getModifiedUserId() {
    return modifiedUserId;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public void setModifiedUserId(Long modifiedUserId) {
    this.modifiedUserId = modifiedUserId;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public String getModifiedUserName() {
    return modifiedUserName;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public void setModifiedUserName(String modifiedUserName) {
    this.modifiedUserName = modifiedUserName == null ? null : modifiedUserName.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public Date getModifiedDate() {
    return modifiedDate;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public void setModifiedDate(Date modifiedDate) {
    this.modifiedDate = modifiedDate;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public Boolean getValid() {
    return valid;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public void setValid(Boolean valid) {
    this.valid = valid;
  }
}