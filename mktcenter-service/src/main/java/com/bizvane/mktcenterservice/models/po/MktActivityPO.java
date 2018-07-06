package com.bizvane.mktcenterservice.models.po;

import java.io.Serializable;
import java.util.Date;

public class MktActivityPO implements Serializable {

	/**
	 * 只读. pkid. mkt_activity_id
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	@io.swagger.annotations.ApiModelProperty(value = "pkid", name = "mktActivityId", required = false, example = "")
	private Long mktActivityId;
	/**
	 * 只读. 品牌id. sys_brand_id
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	@io.swagger.annotations.ApiModelProperty(value = "品牌id", name = "sysBrandId", required = false, example = "")
	private Long sysBrandId;
	/**
	 * 只读. 活动编号. activity_code
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	@io.swagger.annotations.ApiModelProperty(value = "活动编号", name = "activityCode", required = false, example = "")
	private String activityCode;
	/**
	 * 只读. 活动类型：1开卡活动，2升级活动，3扫码领券，4手动领券，5消费活动，6签到活动，7生日活动，8智能营销. activity_type
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	@io.swagger.annotations.ApiModelProperty(value = "活动类型：1开卡活动，2升级活动，3扫码领券，4手动领券，5消费活动，6签到活动，7生日活动，8智能营销", name = "activityType", required = false, example = "")
	private Integer activityType;
	/**
	 * 只读. 活动名称. activity_name
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	@io.swagger.annotations.ApiModelProperty(value = "活动名称", name = "activityName", required = false, example = "")
	private String activityName;
	/**
	 * 只读. 品牌编号. brand_code
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	@io.swagger.annotations.ApiModelProperty(value = "品牌编号", name = "brandCode", required = false, example = "")
	private String brandCode;
	/**
	 * 只读. 品牌名称. brand_name
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	@io.swagger.annotations.ApiModelProperty(value = "品牌名称", name = "brandName", required = false, example = "")
	private String brandName;
	/**
	 * 只读. 活动开始时间. start_time
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	@io.swagger.annotations.ApiModelProperty(value = "活动开始时间", name = "startTime", required = false, example = "")
	private Date startTime;
	/**
	 * 只读. 活动结束时间. end_time
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	@io.swagger.annotations.ApiModelProperty(value = "活动结束时间", name = "endTime", required = false, example = "")
	private Date endTime;
	/**
	 * 只读. 目标人群等级/升级目标等级 编号. mbr_level_code
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	@io.swagger.annotations.ApiModelProperty(value = "目标人群等级/升级目标等级 编号", name = "mbrLevelCode", required = false, example = "")
	private String mbrLevelCode;
	/**
	 * 只读. 目标人群等级/升级目标等级 名称. mbr_level_name
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	@io.swagger.annotations.ApiModelProperty(value = "目标人群等级/升级目标等级 名称", name = "mbrLevelName", required = false, example = "")
	private String mbrLevelName;
	/**
	 * 只读. 升级低级会员等级编号. mbr_low_level_code
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	@io.swagger.annotations.ApiModelProperty(value = "升级低级会员等级编号", name = "mbrLowLevelCode", required = false, example = "")
	private String mbrLowLevelCode;
	/**
	 * 只读. 升级低级会员等级名称. mbr_low_level_name
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	@io.swagger.annotations.ApiModelProperty(value = "升级低级会员等级名称", name = "mbrLowLevelName", required = false, example = "")
	private String mbrLowLevelName;
	/**
	 * 只读. 是否长期：1是，0否. long_term
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	@io.swagger.annotations.ApiModelProperty(value = "是否长期：1是，0否", name = "longTerm", required = false, example = "")
	private Integer longTerm;
	/**
	 * 只读. 活动期间每人最多领券数. coupon_per_member
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	@io.swagger.annotations.ApiModelProperty(value = "活动期间每人最多领券数", name = "couponPerMember", required = false, example = "")
	private Integer couponPerMember;
	/**
	 * 只读. 赠送积分数值. point
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	@io.swagger.annotations.ApiModelProperty(value = "赠送积分数值", name = "point", required = false, example = "")
	private Integer point;
	/**
	 * 只读. 审核状态：1未审核，2审核中，3已审核，4已驳回. check_status
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	@io.swagger.annotations.ApiModelProperty(value = "审核状态：1未审核，2审核中，3已审核，4已驳回", name = "checkStatus", required = false, example = "")
	private Integer checkStatus;
	/**
	 * 只读. 活动状态：1待执行，2执行中，3已结束. activity_status
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	@io.swagger.annotations.ApiModelProperty(value = "活动状态：1待执行，2执行中，3已结束", name = "activityStatus", required = false, example = "")
	private Integer activityStatus;
	/**
	 * 只读. 备注. remark
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	@io.swagger.annotations.ApiModelProperty(value = "备注", name = "remark", required = false, example = "")
	private String remark;
	/**
	 * 只读. 创建人id. create_user_id
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建人id", name = "createUserId", required = false, example = "")
	private Long createUserId;
	/**
	 * 只读. 创建人. create_user_name
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建人", name = "createUserName", required = false, example = "")
	private String createUserName;
	/**
	 * 只读. 创建日期. create_date
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建日期", name = "createDate", required = false, example = "")
	private Date createDate;
	/**
	 * 只读. 修改人id. modified_user_id
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改人id", name = "modifiedUserId", required = false, example = "")
	private Long modifiedUserId;
	/**
	 * 只读. 修改人. modified_user_name
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改人", name = "modifiedUserName", required = false, example = "")
	private String modifiedUserName;
	/**
	 * 只读. 修改时间. modified_date
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改时间", name = "modifiedDate", required = false, example = "")
	private Date modifiedDate;
	/**
	 * 只读. 数据有效性：1=有效；0=无效. valid
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	@io.swagger.annotations.ApiModelProperty(value = "数据有效性：1=有效；0=无效", name = "valid", required = false, example = "")
	private Boolean valid;
	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public Long getMktActivityId() {
		return mktActivityId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public void setMktActivityId(Long mktActivityId) {
		this.mktActivityId = mktActivityId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public Long getSysBrandId() {
		return sysBrandId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public void setSysBrandId(Long sysBrandId) {
		this.sysBrandId = sysBrandId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public String getActivityCode() {
		return activityCode;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public void setActivityCode(String activityCode) {
		this.activityCode = activityCode == null ? null : activityCode.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public Integer getActivityType() {
		return activityType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public void setActivityType(Integer activityType) {
		this.activityType = activityType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public String getActivityName() {
		return activityName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public void setActivityName(String activityName) {
		this.activityName = activityName == null ? null : activityName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public String getBrandCode() {
		return brandCode;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode == null ? null : brandCode.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public String getBrandName() {
		return brandName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public void setBrandName(String brandName) {
		this.brandName = brandName == null ? null : brandName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public String getMbrLevelCode() {
		return mbrLevelCode;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public void setMbrLevelCode(String mbrLevelCode) {
		this.mbrLevelCode = mbrLevelCode == null ? null : mbrLevelCode.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public String getMbrLevelName() {
		return mbrLevelName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public void setMbrLevelName(String mbrLevelName) {
		this.mbrLevelName = mbrLevelName == null ? null : mbrLevelName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public String getMbrLowLevelCode() {
		return mbrLowLevelCode;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public void setMbrLowLevelCode(String mbrLowLevelCode) {
		this.mbrLowLevelCode = mbrLowLevelCode == null ? null : mbrLowLevelCode.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public String getMbrLowLevelName() {
		return mbrLowLevelName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public void setMbrLowLevelName(String mbrLowLevelName) {
		this.mbrLowLevelName = mbrLowLevelName == null ? null : mbrLowLevelName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public Integer getLongTerm() {
		return longTerm;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public void setLongTerm(Integer longTerm) {
		this.longTerm = longTerm;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public Integer getCouponPerMember() {
		return couponPerMember;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public void setCouponPerMember(Integer couponPerMember) {
		this.couponPerMember = couponPerMember;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public Integer getPoint() {
		return point;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public void setPoint(Integer point) {
		this.point = point;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public Integer getCheckStatus() {
		return checkStatus;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public void setCheckStatus(Integer checkStatus) {
		this.checkStatus = checkStatus;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public Integer getActivityStatus() {
		return activityStatus;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public void setActivityStatus(Integer activityStatus) {
		this.activityStatus = activityStatus;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public Long getCreateUserId() {
		return createUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public String getCreateUserName() {
		return createUserName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName == null ? null : createUserName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public Long getModifiedUserId() {
		return modifiedUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public void setModifiedUserId(Long modifiedUserId) {
		this.modifiedUserId = modifiedUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public String getModifiedUserName() {
		return modifiedUserName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public void setModifiedUserName(String modifiedUserName) {
		this.modifiedUserName = modifiedUserName == null ? null : modifiedUserName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public Date getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public Boolean getValid() {
		return valid;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
}