package com.bizvane.mktcenterfacade.models.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModel;

public class MktActivityRecordPO implements Serializable {

	/**
	 * @mbg.generated
	 */
	@ApiModelProperty(value = "pkid", name = "mktActivityRecordId", required = false, example = "")
	private Long mktActivityRecordId;
	/**
	 * @mbg.generated
	 */
	@ApiModelProperty(value = "", name = "sysCompanyId", required = false, example = "")
	private Long sysCompanyId;
	/**
	 * @mbg.generated
	 */
	@ApiModelProperty(value = "品牌id", name = "sysBrandId", required = false, example = "")
	private Long sysBrandId;
	/**
	 * @mbg.generated
	 */
	@ApiModelProperty(value = "活动类型：1开卡活动，2升级活动，3扫码领券，4手动领券，5消费活动，6签到活动，7生日活动，8智能营销,14邀请开卡", name = "activityType", required = false, example = "")
	private Integer activityType;
	/**
	 * @mbg.generated
	 */
	@ApiModelProperty(value = "根据activity_type对应不同活动明细的id", name = "acitivityId", required = false, example = "")
	private Long acitivityId;
	/**
	 * @mbg.generated
	 */
	@ApiModelProperty(value = "参与活动的会员编号(邀请活动中邀请人)", name = "memberCode", required = false, example = "")
	private String memberCode;
	/**
	 * @mbg.generated
	 */
	@ApiModelProperty(value = "邀请活动被邀请人", name = "invitedMemberCode", required = false, example = "")
	private String invitedMemberCode;
	/**
	 * @mbg.generated
	 */
	@ApiModelProperty(value = "活动参与一次的订单金额", name = "orderAmount", required = false, example = "")
	private BigDecimal orderAmount;
	/**
	 * @mbg.generated
	 */
	@ApiModelProperty(value = "活动参与日期", name = "participateDate", required = false, example = "")
	private Date participateDate;
	/**
	 * @mbg.generated
	 */
	@ApiModelProperty(value = "是否奖励过/奖励次数（当前只做到1次）", name = "rewarded", required = false, example = "")
	private Integer rewarded;
	/**
	 * @mbg.generated
	 */
	@ApiModelProperty(value = "奖励积分", name = "points", required = false, example = "")
	private Integer points;
	/**
	 * @mbg.generated
	 */
	@ApiModelProperty(value = "备注", name = "remark", required = false, example = "")
	private String remark;
	/**
	 * @mbg.generated
	 */
	@ApiModelProperty(value = "创建人id", name = "createUserId", required = false, example = "")
	private Long createUserId;
	/**
	 * @mbg.generated
	 */
	@ApiModelProperty(value = "创建人", name = "createUserName", required = false, example = "")
	private String createUserName;
	/**
	 * @mbg.generated
	 */
	@ApiModelProperty(value = "创建日期", name = "createDate", required = false, example = "")
	private Date createDate;
	/**
	 * @mbg.generated
	 */
	@ApiModelProperty(value = "修改人id", name = "modifiedUserId", required = false, example = "")
	private Long modifiedUserId;
	/**
	 * @mbg.generated
	 */
	@ApiModelProperty(value = "修改人", name = "modifiedUserName", required = false, example = "")
	private String modifiedUserName;
	/**
	 * @mbg.generated
	 */
	@ApiModelProperty(value = "修改时间", name = "modifiedDate", required = false, example = "")
	private Date modifiedDate;
	/**
	 * @mbg.generated
	 */
	@ApiModelProperty(value = "数据有效性：1=有效；0=无效", name = "valid", required = false, example = "")
	private Boolean valid;
	/**
	 * @mbg.generated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbg.generated
	 */
	public Long getMktActivityRecordId() {
		return mktActivityRecordId;
	}

	/**
	 * @mbg.generated
	 */
	public void setMktActivityRecordId(Long mktActivityRecordId) {
		this.mktActivityRecordId = mktActivityRecordId;
	}

	/**
	 * @mbg.generated
	 */
	public Long getSysCompanyId() {
		return sysCompanyId;
	}

	/**
	 * @mbg.generated
	 */
	public void setSysCompanyId(Long sysCompanyId) {
		this.sysCompanyId = sysCompanyId;
	}

	/**
	 * @mbg.generated
	 */
	public Long getSysBrandId() {
		return sysBrandId;
	}

	/**
	 * @mbg.generated
	 */
	public void setSysBrandId(Long sysBrandId) {
		this.sysBrandId = sysBrandId;
	}

	/**
	 * @mbg.generated
	 */
	public Integer getActivityType() {
		return activityType;
	}

	/**
	 * @mbg.generated
	 */
	public void setActivityType(Integer activityType) {
		this.activityType = activityType;
	}

	/**
	 * @mbg.generated
	 */
	public Long getAcitivityId() {
		return acitivityId;
	}

	/**
	 * @mbg.generated
	 */
	public void setAcitivityId(Long acitivityId) {
		this.acitivityId = acitivityId;
	}

	/**
	 * @mbg.generated
	 */
	public String getMemberCode() {
		return memberCode;
	}

	/**
	 * @mbg.generated
	 */
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode == null ? null : memberCode.trim();
	}

	/**
	 * @mbg.generated
	 */
	public String getInvitedMemberCode() {
		return invitedMemberCode;
	}

	/**
	 * @mbg.generated
	 */
	public void setInvitedMemberCode(String invitedMemberCode) {
		this.invitedMemberCode = invitedMemberCode == null ? null : invitedMemberCode.trim();
	}

	/**
	 * @mbg.generated
	 */
	public BigDecimal getOrderAmount() {
		return orderAmount;
	}

	/**
	 * @mbg.generated
	 */
	public void setOrderAmount(BigDecimal orderAmount) {
		this.orderAmount = orderAmount;
	}

	/**
	 * @mbg.generated
	 */
	public Date getParticipateDate() {
		return participateDate;
	}

	/**
	 * @mbg.generated
	 */
	public void setParticipateDate(Date participateDate) {
		this.participateDate = participateDate;
	}

	/**
	 * @mbg.generated
	 */
	public Integer getRewarded() {
		return rewarded;
	}

	/**
	 * @mbg.generated
	 */
	public void setRewarded(Integer rewarded) {
		this.rewarded = rewarded;
	}

	/**
	 * @mbg.generated
	 */
	public Integer getPoints() {
		return points;
	}

	/**
	 * @mbg.generated
	 */
	public void setPoints(Integer points) {
		this.points = points;
	}

	/**
	 * @mbg.generated
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @mbg.generated
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/**
	 * @mbg.generated
	 */
	public Long getCreateUserId() {
		return createUserId;
	}

	/**
	 * @mbg.generated
	 */
	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	/**
	 * @mbg.generated
	 */
	public String getCreateUserName() {
		return createUserName;
	}

	/**
	 * @mbg.generated
	 */
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName == null ? null : createUserName.trim();
	}

	/**
	 * @mbg.generated
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @mbg.generated
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * @mbg.generated
	 */
	public Long getModifiedUserId() {
		return modifiedUserId;
	}

	/**
	 * @mbg.generated
	 */
	public void setModifiedUserId(Long modifiedUserId) {
		this.modifiedUserId = modifiedUserId;
	}

	/**
	 * @mbg.generated
	 */
	public String getModifiedUserName() {
		return modifiedUserName;
	}

	/**
	 * @mbg.generated
	 */
	public void setModifiedUserName(String modifiedUserName) {
		this.modifiedUserName = modifiedUserName == null ? null : modifiedUserName.trim();
	}

	/**
	 * @mbg.generated
	 */
	public Date getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * @mbg.generated
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * @mbg.generated
	 */
	public Boolean getValid() {
		return valid;
	}

	/**
	 * @mbg.generated
	 */
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
}