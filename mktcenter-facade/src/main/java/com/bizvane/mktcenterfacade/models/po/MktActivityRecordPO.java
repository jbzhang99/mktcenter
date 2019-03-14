package com.bizvane.mktcenterfacade.models.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class MktActivityRecordPO implements Serializable {

	/**
	 * 只读. pkid. mkt_activity_record_id
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "pkid", name = "mktActivityRecordId", required = false, example = "")
	private Long mktActivityRecordId;
	/**
	 * 只读. . sys_company_id
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "", name = "sysCompanyId", required = false, example = "")
	private Long sysCompanyId;
	/**
	 * 只读. 品牌id. sys_brand_id
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "品牌id", name = "sysBrandId", required = false, example = "")
	private Long sysBrandId;
	/**
	 * 只读. 活动类型：1开卡活动，2升级活动，3扫码领券，4手动领券，5消费活动，6签到活动，7生日活动，8智能营销. activity_type
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "活动类型：1开卡活动，2升级活动，3扫码领券，4手动领券，5消费活动，6签到活动，7生日活动，8智能营销", name = "activityType", required = false, example = "")
	private Integer activityType;
	/**
	 * 只读. 根据activity_type对应不同活动明细的id. acitivity_id
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "根据activity_type对应不同活动明细的id", name = "acitivityId", required = false, example = "")
	private Long acitivityId;
	/**
	 * 只读. 参与活动的会员编号. member_code
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "参与活动的会员编号", name = "memberCode", required = false, example = "")
	private String memberCode;
	/**
	 * 只读. 活动参与一次的订单金额. order_amount
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "活动参与一次的订单金额", name = "orderAmount", required = false, example = "")
	private BigDecimal orderAmount;
	/**
	 * 只读. 活动参与日期. participate_date
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "活动参与日期", name = "participateDate", required = false, example = "")
	private Date participateDate;
	/**
	 * 只读. 是否奖励过/奖励次数（当前只做到1次）. rewarded
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "是否奖励过/奖励次数（当前只做到1次）", name = "rewarded", required = false, example = "")
	private Integer rewarded;
	/**
	 * 只读. 奖励积分. points
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "奖励积分", name = "points", required = false, example = "")
	private Integer points;
	/**
	 * 只读. 备注. remark
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "备注", name = "remark", required = false, example = "")
	private String remark;
	/**
	 * 只读. 创建人id. create_user_id
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建人id", name = "createUserId", required = false, example = "")
	private Long createUserId;
	/**
	 * 只读. 创建人. create_user_name
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建人", name = "createUserName", required = false, example = "")
	private String createUserName;
	/**
	 * 只读. 创建日期. create_date
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建日期", name = "createDate", required = false, example = "")
	private Date createDate;
	/**
	 * 只读. 修改人id. modified_user_id
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改人id", name = "modifiedUserId", required = false, example = "")
	private Long modifiedUserId;
	/**
	 * 只读. 修改人. modified_user_name
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改人", name = "modifiedUserName", required = false, example = "")
	private String modifiedUserName;
	/**
	 * 只读. 修改时间. modified_date
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改时间", name = "modifiedDate", required = false, example = "")
	private Date modifiedDate;
	/**
	 * 只读. 数据有效性：1=有效；0=无效. valid
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "数据有效性：1=有效；0=无效", name = "valid", required = false, example = "")
	private Boolean valid;
	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public Long getMktActivityRecordId() {
		return mktActivityRecordId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public void setMktActivityRecordId(Long mktActivityRecordId) {
		this.mktActivityRecordId = mktActivityRecordId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public Long getSysCompanyId() {
		return sysCompanyId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public void setSysCompanyId(Long sysCompanyId) {
		this.sysCompanyId = sysCompanyId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public Long getSysBrandId() {
		return sysBrandId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public void setSysBrandId(Long sysBrandId) {
		this.sysBrandId = sysBrandId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public Integer getActivityType() {
		return activityType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public void setActivityType(Integer activityType) {
		this.activityType = activityType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public Long getAcitivityId() {
		return acitivityId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public void setAcitivityId(Long acitivityId) {
		this.acitivityId = acitivityId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public String getMemberCode() {
		return memberCode;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode == null ? null : memberCode.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public BigDecimal getOrderAmount() {
		return orderAmount;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public void setOrderAmount(BigDecimal orderAmount) {
		this.orderAmount = orderAmount;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public Date getParticipateDate() {
		return participateDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public void setParticipateDate(Date participateDate) {
		this.participateDate = participateDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public Integer getRewarded() {
		return rewarded;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public void setRewarded(Integer rewarded) {
		this.rewarded = rewarded;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public Integer getPoints() {
		return points;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public void setPoints(Integer points) {
		this.points = points;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public Long getCreateUserId() {
		return createUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public String getCreateUserName() {
		return createUserName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName == null ? null : createUserName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public Long getModifiedUserId() {
		return modifiedUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public void setModifiedUserId(Long modifiedUserId) {
		this.modifiedUserId = modifiedUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public String getModifiedUserName() {
		return modifiedUserName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public void setModifiedUserName(String modifiedUserName) {
		this.modifiedUserName = modifiedUserName == null ? null : modifiedUserName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public Date getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public Boolean getValid() {
		return valid;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
}