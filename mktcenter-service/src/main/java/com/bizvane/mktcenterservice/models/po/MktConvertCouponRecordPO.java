package com.bizvane.mktcenterservice.models.po;

import java.io.Serializable;
import java.util.Date;

public class MktConvertCouponRecordPO implements Serializable {

	/**
	 * 只读. 券兑换记录id. convert_coupon_record_id
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	@io.swagger.annotations.ApiModelProperty(value = "券兑换记录id", name = "convertCouponRecordId", required = false, example = "")
	private Long convertCouponRecordId;
	/**
	 * 只读. 券兑换记录code. convert_coupon_record_code
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	@io.swagger.annotations.ApiModelProperty(value = "券兑换记录code", name = "convertCouponRecordCode", required = false, example = "")
	private String convertCouponRecordCode;
	/**
	 * 只读. 兑换规则id. exchange_id
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	@io.swagger.annotations.ApiModelProperty(value = "兑换规则id", name = "exchangeId", required = false, example = "")
	private Long exchangeId;
	/**
	 * 只读. 公司id. sys_company_id
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	@io.swagger.annotations.ApiModelProperty(value = "公司id", name = "sysCompanyId", required = false, example = "")
	private Long sysCompanyId;
	/**
	 * 只读. 品牌id. sys_brand_id
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	@io.swagger.annotations.ApiModelProperty(value = "品牌id", name = "sysBrandId", required = false, example = "")
	private Long sysBrandId;
	/**
	 * 只读. 会员姓名. member_name
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	@io.swagger.annotations.ApiModelProperty(value = "会员姓名", name = "memberName", required = false, example = "")
	private String memberName;
	/**
	 * 只读. 会员code. member_code
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	@io.swagger.annotations.ApiModelProperty(value = "会员code", name = "memberCode", required = false, example = "")
	private String memberCode;
	/**
	 * 只读. 券编号. card_no
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	@io.swagger.annotations.ApiModelProperty(value = "券编号", name = "cardNo", required = false, example = "")
	private String cardNo;
	/**
	 * 只读. 券名称. coupon_name
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	@io.swagger.annotations.ApiModelProperty(value = "券名称", name = "couponName", required = false, example = "")
	private String couponName;
	/**
	 * 只读. 券数量. coupon_num
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	@io.swagger.annotations.ApiModelProperty(value = "券数量", name = "couponNum", required = false, example = "")
	private Integer couponNum;
	/**
	 * 只读. 兑换券的积分数量. convert_price
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	@io.swagger.annotations.ApiModelProperty(value = "兑换券的积分数量", name = "convertPrice", required = false, example = "")
	private Integer convertPrice;
	/**
	 * 只读. 兑换的券数量. convert_num
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	@io.swagger.annotations.ApiModelProperty(value = "兑换的券数量", name = "convertNum", required = false, example = "")
	private Integer convertNum;
	/**
	 * 只读. 会员兑换券所用积分. convert_tatal_integral
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	@io.swagger.annotations.ApiModelProperty(value = "会员兑换券所用积分", name = "convertTatalIntegral", required = false, example = "")
	private Integer convertTatalIntegral;
	/**
	 * 只读. 兑换时间. convert_time
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	@io.swagger.annotations.ApiModelProperty(value = "兑换时间", name = "convertTime", required = false, example = "")
	private Date convertTime;
	/**
	 * 只读. 是否成功:1成功 0失败. success_type
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	@io.swagger.annotations.ApiModelProperty(value = "是否成功:1成功 0失败", name = "successType", required = false, example = "")
	private Boolean successType;
	/**
	 * 只读. . create_user_id
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	@io.swagger.annotations.ApiModelProperty(value = "", name = "createUserId", required = false, example = "")
	private Long createUserId;
	/**
	 * 只读. . create_user_name
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	@io.swagger.annotations.ApiModelProperty(value = "", name = "createUserName", required = false, example = "")
	private String createUserName;
	/**
	 * 只读. . create_date
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	@io.swagger.annotations.ApiModelProperty(value = "", name = "createDate", required = false, example = "")
	private Date createDate;
	/**
	 * 只读. . modified_user_id
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	@io.swagger.annotations.ApiModelProperty(value = "", name = "modifiedUserId", required = false, example = "")
	private Long modifiedUserId;
	/**
	 * 只读. . modified_user_name
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	@io.swagger.annotations.ApiModelProperty(value = "", name = "modifiedUserName", required = false, example = "")
	private String modifiedUserName;
	/**
	 * 只读. . modified_date
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	@io.swagger.annotations.ApiModelProperty(value = "", name = "modifiedDate", required = false, example = "")
	private Date modifiedDate;
	/**
	 * 只读. 数据有效性：1有效；0无效. valid
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	@io.swagger.annotations.ApiModelProperty(value = "数据有效性：1有效；0无效", name = "valid", required = false, example = "")
	private Boolean valid;
	/**
	 * 只读. 券code. coupon_codes
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	@io.swagger.annotations.ApiModelProperty(value = "券code", name = "couponCodes", required = false, example = "")
	private String couponCodes;
	/**
	 * 只读. 
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	public Long getConvertCouponRecordId() {
		return convertCouponRecordId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	public void setConvertCouponRecordId(Long convertCouponRecordId) {
		this.convertCouponRecordId = convertCouponRecordId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	public String getConvertCouponRecordCode() {
		return convertCouponRecordCode;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	public void setConvertCouponRecordCode(String convertCouponRecordCode) {
		this.convertCouponRecordCode = convertCouponRecordCode == null ? null : convertCouponRecordCode.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	public Long getExchangeId() {
		return exchangeId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	public void setExchangeId(Long exchangeId) {
		this.exchangeId = exchangeId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	public Long getSysCompanyId() {
		return sysCompanyId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	public void setSysCompanyId(Long sysCompanyId) {
		this.sysCompanyId = sysCompanyId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	public Long getSysBrandId() {
		return sysBrandId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	public void setSysBrandId(Long sysBrandId) {
		this.sysBrandId = sysBrandId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	public String getMemberName() {
		return memberName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName == null ? null : memberName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	public String getMemberCode() {
		return memberCode;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode == null ? null : memberCode.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	public String getCardNo() {
		return cardNo;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo == null ? null : cardNo.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	public String getCouponName() {
		return couponName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	public void setCouponName(String couponName) {
		this.couponName = couponName == null ? null : couponName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	public Integer getCouponNum() {
		return couponNum;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	public void setCouponNum(Integer couponNum) {
		this.couponNum = couponNum;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	public Integer getConvertPrice() {
		return convertPrice;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	public void setConvertPrice(Integer convertPrice) {
		this.convertPrice = convertPrice;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	public Integer getConvertNum() {
		return convertNum;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	public void setConvertNum(Integer convertNum) {
		this.convertNum = convertNum;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	public Integer getConvertTatalIntegral() {
		return convertTatalIntegral;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	public void setConvertTatalIntegral(Integer convertTatalIntegral) {
		this.convertTatalIntegral = convertTatalIntegral;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	public Date getConvertTime() {
		return convertTime;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	public void setConvertTime(Date convertTime) {
		this.convertTime = convertTime;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	public Boolean getSuccessType() {
		return successType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	public void setSuccessType(Boolean successType) {
		this.successType = successType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	public Long getCreateUserId() {
		return createUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	public String getCreateUserName() {
		return createUserName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName == null ? null : createUserName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	public Long getModifiedUserId() {
		return modifiedUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	public void setModifiedUserId(Long modifiedUserId) {
		this.modifiedUserId = modifiedUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	public String getModifiedUserName() {
		return modifiedUserName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	public void setModifiedUserName(String modifiedUserName) {
		this.modifiedUserName = modifiedUserName == null ? null : modifiedUserName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	public Date getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	public Boolean getValid() {
		return valid;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	public void setValid(Boolean valid) {
		this.valid = valid;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	public String getCouponCodes() {
		return couponCodes;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-22 22:48:30
	 */
	public void setCouponCodes(String couponCodes) {
		this.couponCodes = couponCodes == null ? null : couponCodes.trim();
	}
}