package com.bizvane.mktcenterservice.models.po;

import java.io.Serializable;
import java.util.Date;

public class MktActivityRedPacketRecordPO implements Serializable {

	/**
	 * 只读. . mkt_activity_red_packet_record_id
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	@io.swagger.annotations.ApiModelProperty(value = "", name = "mktActivityRedPacketRecordId", required = false, example = "")
	private Long mktActivityRedPacketRecordId;
	/**
	 * 只读. 关联活动id. mkt_activity_id
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	@io.swagger.annotations.ApiModelProperty(value = "关联活动id", name = "mktActivityId", required = false, example = "")
	private Long mktActivityId;
	/**
	 * 只读. 所属企业id. sys_company_id
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	@io.swagger.annotations.ApiModelProperty(value = "所属企业id", name = "sysCompanyId", required = false, example = "")
	private Long sysCompanyId;
	/**
	 * 只读. 所属品牌id. sys_brand_id
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	@io.swagger.annotations.ApiModelProperty(value = "所属品牌id", name = "sysBrandId", required = false, example = "")
	private Long sysBrandId;
	/**
	 * 只读. 参与活动的会员编号. member_code
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	@io.swagger.annotations.ApiModelProperty(value = "参与活动的会员编号", name = "memberCode", required = false, example = "")
	private String memberCode;
	/**
	 * 只读. 会员手机号. member_phone
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	@io.swagger.annotations.ApiModelProperty(value = "会员手机号", name = "memberPhone", required = false, example = "")
	private String memberPhone;
	/**
	 * 只读. 会员名称. member_name
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	@io.swagger.annotations.ApiModelProperty(value = "会员名称", name = "memberName", required = false, example = "")
	private String memberName;
	/**
	 * 只读. 发起者会员编号. sponsor_code
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	@io.swagger.annotations.ApiModelProperty(value = "发起者会员编号", name = "sponsorCode", required = false, example = "")
	private String sponsorCode;
	/**
	 * 只读. 券定义id. coupon_definition_id
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	@io.swagger.annotations.ApiModelProperty(value = "券定义id", name = "couponDefinitionId", required = false, example = "")
	private Long couponDefinitionId;
	/**
	 * 只读. 券code. coupon_code
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	@io.swagger.annotations.ApiModelProperty(value = "券code", name = "couponCode", required = false, example = "")
	private String couponCode;
	/**
	 * 只读. 券名称. coupon_name
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	@io.swagger.annotations.ApiModelProperty(value = "券名称", name = "couponName", required = false, example = "")
	private String couponName;
	/**
	 * 只读. 领券时间. get_coupon_date
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	@io.swagger.annotations.ApiModelProperty(value = "领券时间", name = "getCouponDate", required = false, example = "")
	private Date getCouponDate;
	/**
	 * 只读. 赠送积分. reward_ integral
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	@io.swagger.annotations.ApiModelProperty(value = "赠送积分", name = "rewardIntegral", required = false, example = "")
	private Integer rewardIntegral;
	/**
	 * 只读. 1=发起,2=助力,3=赠券. type
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	@io.swagger.annotations.ApiModelProperty(value = "1=发起,2=助力,3=赠券", name = "type", required = false, example = "")
	private Integer type;
	/**
	 * 只读. 备注. remark
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	@io.swagger.annotations.ApiModelProperty(value = "备注", name = "remark", required = false, example = "")
	private String remark;
	/**
	 * 只读. 创建人id. create_user_id
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建人id", name = "createUserId", required = false, example = "")
	private Long createUserId;
	/**
	 * 只读. 创建人. create_user_name
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建人", name = "createUserName", required = false, example = "")
	private String createUserName;
	/**
	 * 只读. 创建时间. create_date
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建时间", name = "createDate", required = false, example = "")
	private Date createDate;
	/**
	 * 只读. 修改人id. modified_user_id
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改人id", name = "modifiedUserId", required = false, example = "")
	private Integer modifiedUserId;
	/**
	 * 只读. 修改人. modified_user_name
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改人", name = "modifiedUserName", required = false, example = "")
	private String modifiedUserName;
	/**
	 * 只读. 修改时间. modified_date
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改时间", name = "modifiedDate", required = false, example = "")
	private Date modifiedDate;
	/**
	 * 只读. 数据有效性：1=有效；0=无效. valid
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	@io.swagger.annotations.ApiModelProperty(value = "数据有效性：1=有效；0=无效", name = "valid", required = false, example = "")
	private Boolean valid;
	/**
	 * 只读. 
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	public Long getMktActivityRedPacketRecordId() {
		return mktActivityRedPacketRecordId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	public void setMktActivityRedPacketRecordId(Long mktActivityRedPacketRecordId) {
		this.mktActivityRedPacketRecordId = mktActivityRedPacketRecordId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	public Long getMktActivityId() {
		return mktActivityId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	public void setMktActivityId(Long mktActivityId) {
		this.mktActivityId = mktActivityId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	public Long getSysCompanyId() {
		return sysCompanyId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	public void setSysCompanyId(Long sysCompanyId) {
		this.sysCompanyId = sysCompanyId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	public Long getSysBrandId() {
		return sysBrandId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	public void setSysBrandId(Long sysBrandId) {
		this.sysBrandId = sysBrandId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	public String getMemberCode() {
		return memberCode;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode == null ? null : memberCode.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	public String getMemberPhone() {
		return memberPhone;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone == null ? null : memberPhone.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	public String getMemberName() {
		return memberName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName == null ? null : memberName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	public String getSponsorCode() {
		return sponsorCode;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	public void setSponsorCode(String sponsorCode) {
		this.sponsorCode = sponsorCode == null ? null : sponsorCode.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	public Long getCouponDefinitionId() {
		return couponDefinitionId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	public void setCouponDefinitionId(Long couponDefinitionId) {
		this.couponDefinitionId = couponDefinitionId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	public String getCouponCode() {
		return couponCode;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode == null ? null : couponCode.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	public String getCouponName() {
		return couponName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	public void setCouponName(String couponName) {
		this.couponName = couponName == null ? null : couponName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	public Date getGetCouponDate() {
		return getCouponDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	public void setGetCouponDate(Date getCouponDate) {
		this.getCouponDate = getCouponDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	public Integer getRewardIntegral() {
		return rewardIntegral;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	public void setRewardIntegral(Integer rewardIntegral) {
		this.rewardIntegral = rewardIntegral;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	public Long getCreateUserId() {
		return createUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	public String getCreateUserName() {
		return createUserName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName == null ? null : createUserName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	public Integer getModifiedUserId() {
		return modifiedUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	public void setModifiedUserId(Integer modifiedUserId) {
		this.modifiedUserId = modifiedUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	public String getModifiedUserName() {
		return modifiedUserName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	public void setModifiedUserName(String modifiedUserName) {
		this.modifiedUserName = modifiedUserName == null ? null : modifiedUserName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	public Date getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	public Boolean getValid() {
		return valid;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-15 23:19:25
	 */
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
}