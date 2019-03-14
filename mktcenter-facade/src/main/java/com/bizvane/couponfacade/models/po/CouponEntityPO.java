package com.bizvane.couponfacade.models.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CouponEntityPO implements Serializable {

	/**
	 * 只读. pkid. coupon_entity_id
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	@io.swagger.annotations.ApiModelProperty(value = "pkid", name = "couponEntityId", required = false, example = "")
	private Long couponEntityId;
	/**
	 * 只读. 所属企业id. sys_company_id
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	@io.swagger.annotations.ApiModelProperty(value = "所属企业id", name = "sysCompanyId", required = false, example = "")
	private Long sysCompanyId;
	/**
	 * 只读. 所属品牌id. sys_brand_id
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	@io.swagger.annotations.ApiModelProperty(value = "所属品牌id", name = "sysBrandId", required = false, example = "")
	private Long sysBrandId;
	/**
	 * 只读. 所属品牌编号. brand_code
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	@io.swagger.annotations.ApiModelProperty(value = "所属品牌编号", name = "brandCode", required = false, example = "")
	private String brandCode;
	/**
	 * 只读. 券号. coupon_code
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	@io.swagger.annotations.ApiModelProperty(value = "券号", name = "couponCode", required = false, example = "")
	private String couponCode;
	/**
	 * 只读. . business_name
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	@io.swagger.annotations.ApiModelProperty(value = "", name = "businessName", required = false, example = "")
	private String businessName;
	/**
	 * 只读. 券定义id. coupon_definition_id
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	@io.swagger.annotations.ApiModelProperty(value = "券定义id", name = "couponDefinitionId", required = false, example = "")
	private String couponDefinitionId;
	/**
	 * 只读. 券发送记录批次号. coupon_batch_send_record_id
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	@io.swagger.annotations.ApiModelProperty(value = "券发送记录批次号", name = "couponBatchSendRecordId", required = false, example = "")
	private Long couponBatchSendRecordId;
	/**
	 * 只读. 会员code. member_code
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	@io.swagger.annotations.ApiModelProperty(value = "会员code", name = "memberCode", required = false, example = "")
	private String memberCode;
	/**
	 * 只读. 券名称. coupon_name
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	@io.swagger.annotations.ApiModelProperty(value = "券名称", name = "couponName", required = false, example = "")
	private String couponName;
	/**
	 * 只读. 面额. money
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	@io.swagger.annotations.ApiModelProperty(value = "面额", name = "money", required = false, example = "")
	private BigDecimal money;
	/**
	 * 只读. 折扣. discount
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	@io.swagger.annotations.ApiModelProperty(value = "折扣", name = "discount", required = false, example = "")
	private BigDecimal discount;
	/**
	 * 只读. 券模板图片. img
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	@io.swagger.annotations.ApiModelProperty(value = "券模板图片", name = "img", required = false, example = "")
	private String img;
	/**
	 * 只读. 券说明. info
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	@io.swagger.annotations.ApiModelProperty(value = "券说明", name = "info", required = false, example = "")
	private String info;
	/**
	 * 只读. 绑定状态（0未绑定，1已绑定）. bind_status
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	@io.swagger.annotations.ApiModelProperty(value = "绑定状态（0未绑定，1已绑定）", name = "bindStatus", required = false, example = "")
	private Boolean bindStatus;
	/**
	 * 只读. 有效期开始时间. valid_date_start
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	@io.swagger.annotations.ApiModelProperty(value = "有效期开始时间", name = "validDateStart", required = false, example = "")
	private Date validDateStart;
	/**
	 * 只读. 有效期结束时间. valid_date_end
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	@io.swagger.annotations.ApiModelProperty(value = "有效期结束时间", name = "validDateEnd", required = false, example = "")
	private Date validDateEnd;
	/**
	 * 只读. 是否锁定(0-未锁定 1-锁定). is_lock
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	@io.swagger.annotations.ApiModelProperty(value = "是否锁定(0-未锁定 1-锁定)", name = "isLock", required = false, example = "")
	private Boolean isLock;
	/**
	 * 只读. 核销密码. use_password
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	@io.swagger.annotations.ApiModelProperty(value = "核销密码", name = "usePassword", required = false, example = "")
	private String usePassword;
	/**
	 * 只读. 发放类型（10-开卡发券，15-会员生日，20-受赠，25-积分兑换，30-线上开卡，35-会员升级，--40-会员生日，45-会员消费，50-会员签到，55-领券，60-完善资料，65-微信分享，70-消费次数，75-消费金额，80-邀请开卡,85-批量发券,90-入会纪念日,95-定向营销 ，100 - 评价奖励活动，101 - 积分商城）. send_type
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	@io.swagger.annotations.ApiModelProperty(value = "发放类型（10-开卡发券，15-会员生日，20-受赠，25-积分兑换，30-线上开卡，35-会员升级，--40-会员生日，45-会员消费，50-会员签到，55-领券，60-完善资料，65-微信分享，70-消费次数，75-消费金额，80-邀请开卡,85-批量发券,90-入会纪念日,95-定向营销 ，100 - 评价奖励活动，101 - 积分商城）", name = "sendType", required = false, example = "")
	private String sendType;
	/**
	 * 只读. 发券业务单号(手工发券id). send_business_id
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	@io.swagger.annotations.ApiModelProperty(value = "发券业务单号(手工发券id)", name = "sendBusinessId", required = false, example = "")
	private Long sendBusinessId;
	/**
	 * 只读. 使用类型：1-线上，2-线下. use_type
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	@io.swagger.annotations.ApiModelProperty(value = "使用类型：1-线上，2-线下", name = "useType", required = false, example = "")
	private Byte useType;
	/**
	 * 只读. 核销门店. use_store_id
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	@io.swagger.annotations.ApiModelProperty(value = "核销门店", name = "useStoreId", required = false, example = "")
	private Long useStoreId;
	/**
	 * 只读. 券使用业务单号. use_business_code
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	@io.swagger.annotations.ApiModelProperty(value = "券使用业务单号", name = "useBusinessCode", required = false, example = "")
	private String useBusinessCode;
	/**
	 * 只读. . use_business_amount
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	@io.swagger.annotations.ApiModelProperty(value = "", name = "useBusinessAmount", required = false, example = "")
	private BigDecimal useBusinessAmount;
	/**
	 * 只读. 使用时间. use_time
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	@io.swagger.annotations.ApiModelProperty(value = "使用时间", name = "useTime", required = false, example = "")
	private Date useTime;
	/**
	 * 只读. 核销来源（5-企业微信）. use_from
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	@io.swagger.annotations.ApiModelProperty(value = "核销来源（5-企业微信）", name = "useFrom", required = false, example = "")
	private Byte useFrom;
	/**
	 * 只读. 核销导购. staff_code
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	@io.swagger.annotations.ApiModelProperty(value = "核销导购", name = "staffCode", required = false, example = "")
	private String staffCode;
	/**
	 * 只读. 是否使用(1-已使用，0-未使用). is_use
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	@io.swagger.annotations.ApiModelProperty(value = "是否使用(1-已使用，0-未使用)", name = "isUse", required = false, example = "")
	private Boolean isUse;
	/**
	 * 只读. //5-线上绑定，10-同步中，11-同步失败，//12-同步成功，20-未使用，25-已过期，30-已核销. coupon_status
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	@io.swagger.annotations.ApiModelProperty(value = "//5-线上绑定，10-同步中，11-同步失败，//12-同步成功，20-未使用，25-已过期，30-已核销", name = "couponStatus", required = false, example = "")
	private Byte couponStatus;
	/**
	 * 只读. 条形码url. barcode_url
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	@io.swagger.annotations.ApiModelProperty(value = "条形码url", name = "barcodeUrl", required = false, example = "")
	private String barcodeUrl;
	/**
	 * 只读. 优惠类型（1现金，2折扣，3礼品）. preferential_type
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	@io.swagger.annotations.ApiModelProperty(value = "优惠类型（1现金，2折扣，3礼品）", name = "preferentialType", required = false, example = "")
	private Byte preferentialType;
	/**
	 * 只读. 备注. remark
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	@io.swagger.annotations.ApiModelProperty(value = "备注", name = "remark", required = false, example = "")
	private String remark;
	/**
	 * 只读. 转赠状态 (0-未转赠，1-转赠中). give
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	@io.swagger.annotations.ApiModelProperty(value = "转赠状态 (0-未转赠，1-转赠中)", name = "give", required = false, example = "")
	private Boolean give;
	/**
	 * 只读. 创建人id. create_user_id
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建人id", name = "createUserId", required = false, example = "")
	private Long createUserId;
	/**
	 * 只读. 创建人. create_user_name
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建人", name = "createUserName", required = false, example = "")
	private String createUserName;
	/**
	 * 只读. 创建时间. create_date
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建时间", name = "createDate", required = false, example = "")
	private Date createDate;
	/**
	 * 只读. 修改人id. modified_user_id
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改人id", name = "modifiedUserId", required = false, example = "")
	private Long modifiedUserId;
	/**
	 * 只读. 修改人. modified_user_name
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改人", name = "modifiedUserName", required = false, example = "")
	private String modifiedUserName;
	/**
	 * 只读. 修改时间. modified_date
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改时间", name = "modifiedDate", required = false, example = "")
	private Date modifiedDate;
	/**
	 * 只读. 数据有效性（1有效，0无效）. valid
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	@io.swagger.annotations.ApiModelProperty(value = "数据有效性（1有效，0无效）", name = "valid", required = false, example = "")
	private Boolean valid;
	/**
	 * 只读. 员工编号. Astaff_code
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	@io.swagger.annotations.ApiModelProperty(value = "员工编号", name = "astaffCode", required = false, example = "")
	private String astaffCode;
	/**
	 * 只读. 转增有奖1核销送券，0不送券. transfer_send
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	@io.swagger.annotations.ApiModelProperty(value = "转增有奖1核销送券，0不送券", name = "transferSend", required = false, example = "")
	private Boolean transferSend;
	/**
	 * 只读. 转增后要发的券. transfer_coupon_definition_id
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	@io.swagger.annotations.ApiModelProperty(value = "转增后要发的券", name = "transferCouponDefinitionId", required = false, example = "")
	private Long transferCouponDefinitionId;
	/**
	 * 只读. 原来转增的会员. transfer_member_code
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	@io.swagger.annotations.ApiModelProperty(value = "原来转增的会员", name = "transferMemberCode", required = false, example = "")
	private String transferMemberCode;
	/**
	 * 只读. 转增说明. transfer_info
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	@io.swagger.annotations.ApiModelProperty(value = "转增说明", name = "transferInfo", required = false, example = "")
	private String transferInfo;
	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public Long getCouponEntityId() {
		return couponEntityId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public void setCouponEntityId(Long couponEntityId) {
		this.couponEntityId = couponEntityId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public Long getSysCompanyId() {
		return sysCompanyId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public void setSysCompanyId(Long sysCompanyId) {
		this.sysCompanyId = sysCompanyId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public Long getSysBrandId() {
		return sysBrandId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public void setSysBrandId(Long sysBrandId) {
		this.sysBrandId = sysBrandId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public String getBrandCode() {
		return brandCode;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode == null ? null : brandCode.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public String getCouponCode() {
		return couponCode;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode == null ? null : couponCode.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public String getBusinessName() {
		return businessName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public void setBusinessName(String businessName) {
		this.businessName = businessName == null ? null : businessName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public String getCouponDefinitionId() {
		return couponDefinitionId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public void setCouponDefinitionId(String couponDefinitionId) {
		this.couponDefinitionId = couponDefinitionId == null ? null : couponDefinitionId.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public Long getCouponBatchSendRecordId() {
		return couponBatchSendRecordId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public void setCouponBatchSendRecordId(Long couponBatchSendRecordId) {
		this.couponBatchSendRecordId = couponBatchSendRecordId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public String getMemberCode() {
		return memberCode;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode == null ? null : memberCode.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public String getCouponName() {
		return couponName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public void setCouponName(String couponName) {
		this.couponName = couponName == null ? null : couponName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public BigDecimal getMoney() {
		return money;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public BigDecimal getDiscount() {
		return discount;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public String getImg() {
		return img;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public void setImg(String img) {
		this.img = img == null ? null : img.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public String getInfo() {
		return info;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public void setInfo(String info) {
		this.info = info == null ? null : info.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public Boolean getBindStatus() {
		return bindStatus;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public void setBindStatus(Boolean bindStatus) {
		this.bindStatus = bindStatus;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public Date getValidDateStart() {
		return validDateStart;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public void setValidDateStart(Date validDateStart) {
		this.validDateStart = validDateStart;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public Date getValidDateEnd() {
		return validDateEnd;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public void setValidDateEnd(Date validDateEnd) {
		this.validDateEnd = validDateEnd;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public Boolean getIsLock() {
		return isLock;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public void setIsLock(Boolean isLock) {
		this.isLock = isLock;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public String getUsePassword() {
		return usePassword;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public void setUsePassword(String usePassword) {
		this.usePassword = usePassword == null ? null : usePassword.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public String getSendType() {
		return sendType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public void setSendType(String sendType) {
		this.sendType = sendType == null ? null : sendType.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public Long getSendBusinessId() {
		return sendBusinessId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public void setSendBusinessId(Long sendBusinessId) {
		this.sendBusinessId = sendBusinessId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public Byte getUseType() {
		return useType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public void setUseType(Byte useType) {
		this.useType = useType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public Long getUseStoreId() {
		return useStoreId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public void setUseStoreId(Long useStoreId) {
		this.useStoreId = useStoreId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public String getUseBusinessCode() {
		return useBusinessCode;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public void setUseBusinessCode(String useBusinessCode) {
		this.useBusinessCode = useBusinessCode == null ? null : useBusinessCode.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public BigDecimal getUseBusinessAmount() {
		return useBusinessAmount;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public void setUseBusinessAmount(BigDecimal useBusinessAmount) {
		this.useBusinessAmount = useBusinessAmount;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public Date getUseTime() {
		return useTime;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public void setUseTime(Date useTime) {
		this.useTime = useTime;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public Byte getUseFrom() {
		return useFrom;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public void setUseFrom(Byte useFrom) {
		this.useFrom = useFrom;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public String getStaffCode() {
		return staffCode;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode == null ? null : staffCode.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public Boolean getIsUse() {
		return isUse;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public void setIsUse(Boolean isUse) {
		this.isUse = isUse;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public Byte getCouponStatus() {
		return couponStatus;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public void setCouponStatus(Byte couponStatus) {
		this.couponStatus = couponStatus;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public String getBarcodeUrl() {
		return barcodeUrl;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public void setBarcodeUrl(String barcodeUrl) {
		this.barcodeUrl = barcodeUrl == null ? null : barcodeUrl.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public Byte getPreferentialType() {
		return preferentialType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public void setPreferentialType(Byte preferentialType) {
		this.preferentialType = preferentialType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public Boolean getGive() {
		return give;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public void setGive(Boolean give) {
		this.give = give;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public Long getCreateUserId() {
		return createUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public String getCreateUserName() {
		return createUserName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName == null ? null : createUserName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public Long getModifiedUserId() {
		return modifiedUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public void setModifiedUserId(Long modifiedUserId) {
		this.modifiedUserId = modifiedUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public String getModifiedUserName() {
		return modifiedUserName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public void setModifiedUserName(String modifiedUserName) {
		this.modifiedUserName = modifiedUserName == null ? null : modifiedUserName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public Date getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public Boolean getValid() {
		return valid;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public void setValid(Boolean valid) {
		this.valid = valid;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public String getAstaffCode() {
		return astaffCode;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public void setAstaffCode(String astaffCode) {
		this.astaffCode = astaffCode == null ? null : astaffCode.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public Boolean getTransferSend() {
		return transferSend;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public void setTransferSend(Boolean transferSend) {
		this.transferSend = transferSend;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public Long getTransferCouponDefinitionId() {
		return transferCouponDefinitionId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public void setTransferCouponDefinitionId(Long transferCouponDefinitionId) {
		this.transferCouponDefinitionId = transferCouponDefinitionId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public String getTransferMemberCode() {
		return transferMemberCode;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public void setTransferMemberCode(String transferMemberCode) {
		this.transferMemberCode = transferMemberCode == null ? null : transferMemberCode.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public String getTransferInfo() {
		return transferInfo;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public void setTransferInfo(String transferInfo) {
		this.transferInfo = transferInfo == null ? null : transferInfo.trim();
	}
}