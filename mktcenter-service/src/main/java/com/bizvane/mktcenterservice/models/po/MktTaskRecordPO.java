package com.bizvane.mktcenterservice.models.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class MktTaskRecordPO implements Serializable {

	/**
	 * 只读. pkid. mkt_task_record_id
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "pkid", name = "mktTaskRecordId", required = false, example = "")
	private Long mktTaskRecordId;
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
	 * 只读. 任务类型：1完善资料，2分享任务，3邀请注册，4累计消费次数，5累计消费金额. task_type
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "任务类型：1完善资料，2分享任务，3邀请注册，4累计消费次数，5累计消费金额", name = "taskType", required = false, example = "")
	private Integer taskType;
	/**
	 * 只读. 根据task_type对应不同任务的id. task_id
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "根据task_type对应不同任务的id", name = "taskId", required = false, example = "")
	private Long taskId;
	/**
	 * 只读. 参与任务的会员编号. member_code
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "参与任务的会员编号", name = "memberCode", required = false, example = "")
	private String memberCode;
	/**
	 * 只读. 参与任务完成的订单金额. consume_amount
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "参与任务完成的订单金额", name = "consumeAmount", required = false, example = "")
	private BigDecimal consumeAmount;
	/**
	 * 只读. 任务参与日期. participate_date
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "任务参与日期", name = "participateDate", required = false, example = "")
	private Date participateDate;
	/**
	 * 只读. 是否奖励过/奖励次数（当前只做到1次）. rewarded
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "是否奖励过/奖励次数（当前只做到1次）", name = "rewarded", required = false, example = "")
	private Integer rewarded;
	/**
	 * 只读. 发券数量. coupon_num
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "发券数量", name = "couponNum", required = false, example = "")
	private Integer couponNum;
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
	public Long getMktTaskRecordId() {
		return mktTaskRecordId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public void setMktTaskRecordId(Long mktTaskRecordId) {
		this.mktTaskRecordId = mktTaskRecordId;
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
	public Integer getTaskType() {
		return taskType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public void setTaskType(Integer taskType) {
		this.taskType = taskType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public Long getTaskId() {
		return taskId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public void setTaskId(Long taskId) {
		this.taskId = taskId;
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
	public BigDecimal getConsumeAmount() {
		return consumeAmount;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public void setConsumeAmount(BigDecimal consumeAmount) {
		this.consumeAmount = consumeAmount;
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
	public Integer getCouponNum() {
		return couponNum;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public void setCouponNum(Integer couponNum) {
		this.couponNum = couponNum;
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