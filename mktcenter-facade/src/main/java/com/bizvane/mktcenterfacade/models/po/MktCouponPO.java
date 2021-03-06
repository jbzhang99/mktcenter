package com.bizvane.mktcenterfacade.models.po;

import java.io.Serializable;
import java.util.Date;

public class MktCouponPO implements Serializable {

	/**
	 * 只读. pkid. mkt_coupon_id
	 * @mbg.generated  2018-09-08 11:41:35
	 */
	@io.swagger.annotations.ApiModelProperty(value = "pkid", name = "mktCouponId", required = false, example = "")
	private Long mktCouponId;
	/**
	 * 只读. . sys_company_id
	 * @mbg.generated  2018-09-08 11:41:35
	 */
	@io.swagger.annotations.ApiModelProperty(value = "", name = "sysCompanyId", required = false, example = "")
	private Long sysCompanyId;
	/**
	 * 只读. 业务类型：1活动，2任务. biz_type
	 * @mbg.generated  2018-09-08 11:41:35
	 */
	@io.swagger.annotations.ApiModelProperty(value = "业务类型：1活动，2任务", name = "bizType", required = false, example = "")
	private Integer bizType;
	/**
	 * 只读. 业务单号id. biz_id
	 * @mbg.generated  2018-09-08 11:41:35
	 */
	@io.swagger.annotations.ApiModelProperty(value = "业务单号id", name = "bizId", required = false, example = "")
	private Long bizId;
	/**
	 * 只读. 活动奖励券id. coupon_definition_id
	 * @mbg.generated  2018-09-08 11:41:35
	 */
	@io.swagger.annotations.ApiModelProperty(value = "活动奖励券id", name = "couponDefinitionId", required = false, example = "")
	private Long couponDefinitionId;
	/**
	 * 只读. 活动奖励的券名称. coupon_name
	 * @mbg.generated  2018-09-08 11:41:35
	 */
	@io.swagger.annotations.ApiModelProperty(value = "活动奖励的券名称", name = "couponName", required = false, example = "")
	private String couponName;
	/**
	 * 只读. 立即发送：1是，0否. send_immediately
	 * @mbg.generated  2018-09-08 11:41:35
	 */
	@io.swagger.annotations.ApiModelProperty(value = "立即发送：1是，0否", name = "sendImmediately", required = false, example = "")
	private Boolean sendImmediately;
	/**
	 * 只读. 开始发送时间. send_time
	 * @mbg.generated  2018-09-08 11:41:35
	 */
	@io.swagger.annotations.ApiModelProperty(value = "开始发送时间", name = "sendTime", required = false, example = "")
	private Date sendTime;
	/**
	 * 只读. 备注. remark
	 * @mbg.generated  2018-09-08 11:41:35
	 */
	@io.swagger.annotations.ApiModelProperty(value = "备注", name = "remark", required = false, example = "")
	private String remark;
	/**
	 * 只读. 创建人id. create_user_id
	 * @mbg.generated  2018-09-08 11:41:35
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建人id", name = "createUserId", required = false, example = "")
	private Long createUserId;
	/**
	 * 只读. 创建人. create_user_name
	 * @mbg.generated  2018-09-08 11:41:35
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建人", name = "createUserName", required = false, example = "")
	private String createUserName;
	/**
	 * 只读. 创建日期. create_date
	 * @mbg.generated  2018-09-08 11:41:35
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建日期", name = "createDate", required = false, example = "")
	private Date createDate;
	/**
	 * 只读. 修改人id. modified_user_id
	 * @mbg.generated  2018-09-08 11:41:35
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改人id", name = "modifiedUserId", required = false, example = "")
	private Long modifiedUserId;
	/**
	 * 只读. 修改人. modified_user_name
	 * @mbg.generated  2018-09-08 11:41:35
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改人", name = "modifiedUserName", required = false, example = "")
	private String modifiedUserName;
	/**
	 * 只读. 修改时间. modified_date
	 * @mbg.generated  2018-09-08 11:41:35
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改时间", name = "modifiedDate", required = false, example = "")
	private Date modifiedDate;
	/**
	 * 只读. 数据有效性：1=有效；0=无效. valid
	 * @mbg.generated  2018-09-08 11:41:35
	 */
	@io.swagger.annotations.ApiModelProperty(value = "数据有效性：1=有效；0=无效", name = "valid", required = false, example = "")
	private Boolean valid;
	/**
	 * 只读. 
	 * @mbg.generated  2018-09-08 11:41:35
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-08 11:41:35
	 */
	public Long getMktCouponId() {
		return mktCouponId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-08 11:41:35
	 */
	public void setMktCouponId(Long mktCouponId) {
		this.mktCouponId = mktCouponId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-08 11:41:35
	 */
	public Long getSysCompanyId() {
		return sysCompanyId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-08 11:41:35
	 */
	public void setSysCompanyId(Long sysCompanyId) {
		this.sysCompanyId = sysCompanyId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-08 11:41:35
	 */
	public Integer getBizType() {
		return bizType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-08 11:41:35
	 */
	public void setBizType(Integer bizType) {
		this.bizType = bizType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-08 11:41:35
	 */
	public Long getBizId() {
		return bizId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-08 11:41:35
	 */
	public void setBizId(Long bizId) {
		this.bizId = bizId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-08 11:41:35
	 */
	public Long getCouponDefinitionId() {
		return couponDefinitionId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-08 11:41:35
	 */
	public void setCouponDefinitionId(Long couponDefinitionId) {
		this.couponDefinitionId = couponDefinitionId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-08 11:41:35
	 */
	public String getCouponName() {
		return couponName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-08 11:41:35
	 */
	public void setCouponName(String couponName) {
		this.couponName = couponName == null ? null : couponName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-08 11:41:35
	 */
	public Boolean getSendImmediately() {
		return sendImmediately;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-08 11:41:35
	 */
	public void setSendImmediately(Boolean sendImmediately) {
		this.sendImmediately = sendImmediately;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-08 11:41:35
	 */
	public Date getSendTime() {
		return sendTime;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-08 11:41:35
	 */
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-08 11:41:35
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-08 11:41:35
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-08 11:41:35
	 */
	public Long getCreateUserId() {
		return createUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-08 11:41:35
	 */
	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-08 11:41:35
	 */
	public String getCreateUserName() {
		return createUserName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-08 11:41:35
	 */
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName == null ? null : createUserName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-08 11:41:35
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-08 11:41:35
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-08 11:41:35
	 */
	public Long getModifiedUserId() {
		return modifiedUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-08 11:41:35
	 */
	public void setModifiedUserId(Long modifiedUserId) {
		this.modifiedUserId = modifiedUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-08 11:41:35
	 */
	public String getModifiedUserName() {
		return modifiedUserName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-08 11:41:35
	 */
	public void setModifiedUserName(String modifiedUserName) {
		this.modifiedUserName = modifiedUserName == null ? null : modifiedUserName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-08 11:41:35
	 */
	public Date getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-08 11:41:35
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-08 11:41:35
	 */
	public Boolean getValid() {
		return valid;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-08 11:41:35
	 */
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
}