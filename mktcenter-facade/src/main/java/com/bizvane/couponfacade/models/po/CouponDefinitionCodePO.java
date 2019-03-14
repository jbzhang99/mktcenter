package com.bizvane.couponfacade.models.po;

import java.io.Serializable;
import java.util.Date;

public class CouponDefinitionCodePO implements Serializable {

	/**
	 * 只读. pkid. coupon_definition_code_id
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	@io.swagger.annotations.ApiModelProperty(value = "pkid", name = "couponDefinitionCodeId", required = false, example = "")
	private Long couponDefinitionCodeId;
	/**
	 * 只读. 所属企业id. sys_company_id
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	@io.swagger.annotations.ApiModelProperty(value = "所属企业id", name = "sysCompanyId", required = false, example = "")
	private Long sysCompanyId;
	/**
	 * 只读. 所属品牌id. sys_brand_id
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	@io.swagger.annotations.ApiModelProperty(value = "所属品牌id", name = "sysBrandId", required = false, example = "")
	private Long sysBrandId;
	/**
	 * 只读. 所属品牌编号. brand_code
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	@io.swagger.annotations.ApiModelProperty(value = "所属品牌编号", name = "brandCode", required = false, example = "")
	private String brandCode;
	/**
	 * 只读. 券号. coupon_code
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	@io.swagger.annotations.ApiModelProperty(value = "券号", name = "couponCode", required = false, example = "")
	private String couponCode;
	/**
	 * 只读. 券名称. coupon_name
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	@io.swagger.annotations.ApiModelProperty(value = "券名称", name = "couponName", required = false, example = "")
	private String couponName;
	/**
	 * 只读. 券定义id. coupon_definition_id
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	@io.swagger.annotations.ApiModelProperty(value = "券定义id", name = "couponDefinitionId", required = false, example = "")
	private Long couponDefinitionId;
	/**
	 * 只读. 线下券类型号. erp_coupon_definition_code
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	@io.swagger.annotations.ApiModelProperty(value = "线下券类型号", name = "erpCouponDefinitionCode", required = false, example = "")
	private String erpCouponDefinitionCode;
	/**
	 * 只读. 同步数量. coupon_count
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	@io.swagger.annotations.ApiModelProperty(value = "同步数量", name = "couponCount", required = false, example = "")
	private Integer couponCount;
	/**
	 * 只读. 有效期开始时间. valid_date_start
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	@io.swagger.annotations.ApiModelProperty(value = "有效期开始时间", name = "validDateStart", required = false, example = "")
	private Date validDateStart;
	/**
	 * 只读. 有效期结束时间. valid_date_end
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	@io.swagger.annotations.ApiModelProperty(value = "有效期结束时间", name = "validDateEnd", required = false, example = "")
	private Date validDateEnd;
	/**
	 * 只读. 优惠类型（1现金，2折扣，3兑换）. preferential_type
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	@io.swagger.annotations.ApiModelProperty(value = "优惠类型（1现金，2折扣，3兑换）", name = "preferentialType", required = false, example = "")
	private Byte preferentialType;
	/**
	 * 只读. 券状态（1可用，2占用，3已经使用，4过期）. status
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	@io.swagger.annotations.ApiModelProperty(value = "券状态（1可用，2占用，3已经使用，4过期）", name = "status", required = false, example = "")
	private Boolean status;
	/**
	 * 只读. 创建人id. create_user_id
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建人id", name = "createUserId", required = false, example = "")
	private Long createUserId;
	/**
	 * 只读. 创建人. create_user_name
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建人", name = "createUserName", required = false, example = "")
	private String createUserName;
	/**
	 * 只读. 创建时间. create_date
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建时间", name = "createDate", required = false, example = "")
	private Date createDate;
	/**
	 * 只读. 修改人id. modified_user_id
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改人id", name = "modifiedUserId", required = false, example = "")
	private Long modifiedUserId;
	/**
	 * 只读. 修改人. modified_user_name
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改人", name = "modifiedUserName", required = false, example = "")
	private String modifiedUserName;
	/**
	 * 只读. 修改时间. modified_date
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改时间", name = "modifiedDate", required = false, example = "")
	private Date modifiedDate;
	/**
	 * 只读. 同步说明. remark
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	@io.swagger.annotations.ApiModelProperty(value = "同步说明", name = "remark", required = false, example = "")
	private String remark;
	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	public Long getCouponDefinitionCodeId() {
		return couponDefinitionCodeId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	public void setCouponDefinitionCodeId(Long couponDefinitionCodeId) {
		this.couponDefinitionCodeId = couponDefinitionCodeId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	public Long getSysCompanyId() {
		return sysCompanyId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	public void setSysCompanyId(Long sysCompanyId) {
		this.sysCompanyId = sysCompanyId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	public Long getSysBrandId() {
		return sysBrandId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	public void setSysBrandId(Long sysBrandId) {
		this.sysBrandId = sysBrandId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	public String getBrandCode() {
		return brandCode;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode == null ? null : brandCode.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	public String getCouponCode() {
		return couponCode;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode == null ? null : couponCode.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	public String getCouponName() {
		return couponName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	public void setCouponName(String couponName) {
		this.couponName = couponName == null ? null : couponName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	public Long getCouponDefinitionId() {
		return couponDefinitionId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	public void setCouponDefinitionId(Long couponDefinitionId) {
		this.couponDefinitionId = couponDefinitionId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	public String getErpCouponDefinitionCode() {
		return erpCouponDefinitionCode;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	public void setErpCouponDefinitionCode(String erpCouponDefinitionCode) {
		this.erpCouponDefinitionCode = erpCouponDefinitionCode == null ? null : erpCouponDefinitionCode.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	public Integer getCouponCount() {
		return couponCount;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	public void setCouponCount(Integer couponCount) {
		this.couponCount = couponCount;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	public Date getValidDateStart() {
		return validDateStart;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	public void setValidDateStart(Date validDateStart) {
		this.validDateStart = validDateStart;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	public Date getValidDateEnd() {
		return validDateEnd;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	public void setValidDateEnd(Date validDateEnd) {
		this.validDateEnd = validDateEnd;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	public Byte getPreferentialType() {
		return preferentialType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	public void setPreferentialType(Byte preferentialType) {
		this.preferentialType = preferentialType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	public Boolean getStatus() {
		return status;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	public void setStatus(Boolean status) {
		this.status = status;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	public Long getCreateUserId() {
		return createUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	public String getCreateUserName() {
		return createUserName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName == null ? null : createUserName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	public Long getModifiedUserId() {
		return modifiedUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	public void setModifiedUserId(Long modifiedUserId) {
		this.modifiedUserId = modifiedUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	public String getModifiedUserName() {
		return modifiedUserName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	public void setModifiedUserName(String modifiedUserName) {
		this.modifiedUserName = modifiedUserName == null ? null : modifiedUserName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	public Date getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}
}