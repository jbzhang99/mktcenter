package com.bizvane.couponfacade.models.po;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CouponDefinitionPO implements Serializable {

	/**
	 * 只读. pkid. coupon_definition_id
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "pkid", name = "couponDefinitionId", required = false, example = "")
	private Long couponDefinitionId;
	/**
	 * 只读. 所属企业id. sys_company_id
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "所属企业id", name = "sysCompanyId", required = false, example = "")
	private Long sysCompanyId;
	/**
	 * 只读. 所属品牌id. sys_brand_id
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "所属品牌id", name = "sysBrandId", required = false, example = "")
	private Long sysBrandId;
	/**
	 * 只读. 所属品牌编号. brand_code
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "所属品牌编号", name = "brandCode", required = false, example = "")
	private String brandCode;
	/**
	 * 只读. 券编号. coupon_definition_code
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "券编号", name = "couponDefinitionCode", required = false, example = "")
	private String couponDefinitionCode;
	/**
	 * 只读. 券定义类型：1-线上定义，2-erp生成. coupon_definition_type
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "券定义类型：1-线上定义，2-erp生成", name = "couponDefinitionType", required = false, example = "")
	private Byte couponDefinitionType;
	/**
	 * 只读. 线下券类型号. erp_coupon_definition_code
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "线下券类型号", name = "erpCouponDefinitionCode", required = false, example = "")
	private String erpCouponDefinitionCode;
	/**
	 * 只读. 券名称. coupon_name
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "券名称", name = "couponName", required = false, example = "")
	private String couponName;
	/**
	 * 只读. 渠道限制（1仅线下，2全渠道，3仅线上）. use_channel
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "渠道限制（1仅线下，2全渠道，3仅线上）", name = "useChannel", required = false, example = "")
	private Byte useChannel;
	/**
	 * 只读. 优惠类型（1现金，2折扣，3兑换）. preferential_type
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "优惠类型（1现金，2折扣，3兑换）", name = "preferentialType", required = false, example = "")
	private Byte preferentialType;
	/**
	 * 只读. 券的面额. money
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "券的面额", name = "money", required = false, example = "")
	private BigDecimal money;
	/**
	 * 只读. 券的折扣. discount
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "券的折扣", name = "discount", required = false, example = "")
	private BigDecimal discount;
	/**
	 * 只读. 有效期类型：1-日期区间，2-领取后X天有效，3-仅限会员生日当天使用，4-仅限会员生日当月使用. valid_type
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "有效期类型：1-日期区间，2-领取后X天有效，3-仅限会员生日当天使用，4-仅限会员生日当月使用", name = "validType", required = false, example = "")
	private Byte validType;
	/**
	 * 只读. 有效期开始时间. valid_date_start
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "有效期开始时间", name = "validDateStart", required = false, example = "")
	private Date validDateStart;
	/**
	 * 只读. 有效期结束时间. valid_date_end
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "有效期结束时间", name = "validDateEnd", required = false, example = "")
	private Date validDateEnd;
	/**
	 * 只读. 有效天数. valid_day
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "有效天数", name = "validDay", required = false, example = "")
	private Integer validDay;
	/**
	 * 只读. 二维码. qr_code
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "二维码", name = "qrCode", required = false, example = "")
	private String qrCode;
	/**
	 * 只读. 券模板图片. img
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "券模板图片", name = "img", required = false, example = "")
	private String img;
	/**
	 * 只读. 单人最大领取数量限制. per_max_num
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "单人最大领取数量限制", name = "perMaxNum", required = false, example = "")
	private Integer perMaxNum;
	/**
	 * 只读. 是否记名（1记名，0不记名）. is_real_name
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "是否记名（1记名，0不记名）", name = "isRealName", required = false, example = "")
	private Boolean isRealName;
	/**
	 * 只读. 是否允许转赠（1允许转赠，0不允许转赠）. is_transfer
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "是否允许转赠（1允许转赠，0不允许转赠）", name = "isTransfer", required = false, example = "")
	private Boolean isTransfer;
	/**
	 * 只读. 活动叠加条件：1-不允许叠加其他活动使用，2-允许叠加其他活动使用，3-允许部分活动使用. activity_superposition_type
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "活动叠加条件：1-不允许叠加其他活动使用，2-允许叠加其他活动使用，3-允许部分活动使用", name = "activitySuperpositionType", required = false, example = "")
	private Byte activitySuperpositionType;
	/**
	 * 只读. 活动叠加白名单. activity_superposition_white_list
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "活动叠加白名单", name = "activitySuperpositionWhiteList", required = false, example = "")
	private String activitySuperpositionWhiteList;
	/**
	 * 只读. 活动叠加黑名单. activity_superposition_black_list
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "活动叠加黑名单", name = "activitySuperpositionBlackList", required = false, example = "")
	private String activitySuperpositionBlackList;
	/**
	 * 只读. 是否允许叠加（1是，0否）. is_superposition
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "是否允许叠加（1是，0否）", name = "isSuperposition", required = false, example = "")
	private Boolean isSuperposition;
	/**
	 * 只读. 正价购买限制. is_tag_price_limit
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "正价购买限制", name = "isTagPriceLimit", required = false, example = "")
	private Boolean isTagPriceLimit;
	/**
	 * 只读. . tag_price_max_preferential_limit
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "", name = "tagPriceMaxPreferentialLimit", required = false, example = "")
	private BigDecimal tagPriceMaxPreferentialLimit;
	/**
	 * 只读. 最低消费金额(满减金额). min_consume
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "最低消费金额(满减金额)", name = "minConsume", required = false, example = "")
	private BigDecimal minConsume;
	/**
	 * 只读. 最高优惠金额. max_preferential
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "最高优惠金额", name = "maxPreferential", required = false, example = "")
	private BigDecimal maxPreferential;
	/**
	 * 只读. 商品数量最低限制. min_commodity_num
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "商品数量最低限制", name = "minCommodityNum", required = false, example = "")
	private Integer minCommodityNum;
	/**
	 * 只读. 商品数量最高限制. max_commodity_num
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "商品数量最高限制", name = "maxCommodityNum", required = false, example = "")
	private Integer maxCommodityNum;
	/**
	 * 只读. 整单最低折扣限制. min_discount
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "整单最低折扣限制", name = "minDiscount", required = false, example = "")
	private BigDecimal minDiscount;
	/**
	 * 只读. 适用商品类型：1-全部适用，2-部分适用. appliance_commodity_type
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "适用商品类型：1-全部适用，2-部分适用", name = "applianceCommodityType", required = false, example = "")
	private Byte applianceCommodityType;
	/**
	 * 只读. 适用门店类型：1-全部适用，2-部分适用. appliance_store_type
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "适用门店类型：1-全部适用，2-部分适用", name = "applianceStoreType", required = false, example = "")
	private Byte applianceStoreType;
	/**
	 * 只读. 描述. info
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "描述", name = "info", required = false, example = "")
	private String info;
	/**
	 * 只读. 备注. remark
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "备注", name = "remark", required = false, example = "")
	private String remark;
	/**
	 * 只读. 券状态（1已启用，0已停用）. status
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "券状态（1已启用，0已停用）", name = "status", required = false, example = "")
	private Boolean status;
	/**
	 * 只读. 创建人id. create_user_id
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建人id", name = "createUserId", required = false, example = "")
	private Long createUserId;
	/**
	 * 只读. 创建人. create_user_name
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建人", name = "createUserName", required = false, example = "")
	private String createUserName;
	/**
	 * 只读. 创建时间. create_date
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建时间", name = "createDate", required = false, example = "")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createDate;
	/**
	 * 只读. 修改人id. modified_user_id
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改人id", name = "modifiedUserId", required = false, example = "")
	private Long modifiedUserId;
	/**
	 * 只读. 修改人. modified_user_name
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改人", name = "modifiedUserName", required = false, example = "")
	private String modifiedUserName;
	/**
	 * 只读. 修改时间. modified_date
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改时间", name = "modifiedDate", required = false, example = "")
	private Date modifiedDate;
	/**
	 * 只读. 数据有效性（1有效，0无效）. valid
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "数据有效性（1有效，0无效）", name = "valid", required = false, example = "")
	private Boolean valid;
	/**
	 * 只读. 添加到券自定义模板(1是，0否). is_add_template
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "添加到券自定义模板(1是，0否)", name = "isAddTemplate", required = false, example = "")
	private Boolean isAddTemplate;
	/**
	 * 只读. 券叠加条件(1-不允许叠加其他券使用  2-允许叠加其他券使用). coupon_superposition_type
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "券叠加条件(1-不允许叠加其他券使用  2-允许叠加其他券使用)", name = "couponSuperpositionType", required = false, example = "")
	private Byte couponSuperpositionType;
	/**
	 * 只读. 能否叠加会员卡使用（0-不能，1-能）. superposition_member_card
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "能否叠加会员卡使用（0-不能，1-能）", name = "superpositionMemberCard", required = false, example = "")
	private Boolean superpositionMemberCard;
	/**
	 * 只读. 转增后1核销送券，0不送券. transfer_send
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "转增后1核销送券，0不送券", name = "transferSend", required = false, example = "")
	private Boolean transferSend;
	/**
	 * 只读. 转增后要发的券定义id. transfer_coupon_definition_id
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "转增后要发的券定义id", name = "transferCouponDefinitionId", required = false, example = "")
	private Long transferCouponDefinitionId;
	/**
	 * 只读. 转增说明. transfer_info
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "转增说明", name = "transferInfo", required = false, example = "")
	private String transferInfo;
	/**
	 * 只读. 可裂变1，不可以0. transfer_fission
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "可裂变1，不可以0", name = "transferFission", required = false, example = "")
	private Boolean transferFission;
	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	private static final long serialVersionUID = 1L;
	
	  @io.swagger.annotations.ApiModelProperty(value = "发券二级批次号（系统）",name = "发券二级批次号（系统）", required = true,example = "")
	  private Long batchSendCodeDetail;
	  
	  

	public Long getBatchSendCodeDetail() {
		return batchSendCodeDetail;
	}

	public void setBatchSendCodeDetail(Long batchSendCodeDetail) {
		this.batchSendCodeDetail = batchSendCodeDetail;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public Long getCouponDefinitionId() {
		return couponDefinitionId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public void setCouponDefinitionId(Long couponDefinitionId) {
		this.couponDefinitionId = couponDefinitionId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public Long getSysCompanyId() {
		return sysCompanyId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public void setSysCompanyId(Long sysCompanyId) {
		this.sysCompanyId = sysCompanyId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public Long getSysBrandId() {
		return sysBrandId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public void setSysBrandId(Long sysBrandId) {
		this.sysBrandId = sysBrandId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public String getBrandCode() {
		return brandCode;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode == null ? null : brandCode.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public String getCouponDefinitionCode() {
		return couponDefinitionCode;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public void setCouponDefinitionCode(String couponDefinitionCode) {
		this.couponDefinitionCode = couponDefinitionCode == null ? null : couponDefinitionCode.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public Byte getCouponDefinitionType() {
		return couponDefinitionType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public void setCouponDefinitionType(Byte couponDefinitionType) {
		this.couponDefinitionType = couponDefinitionType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public String getErpCouponDefinitionCode() {
		return erpCouponDefinitionCode;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public void setErpCouponDefinitionCode(String erpCouponDefinitionCode) {
		this.erpCouponDefinitionCode = erpCouponDefinitionCode == null ? null : erpCouponDefinitionCode.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public String getCouponName() {
		return couponName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public void setCouponName(String couponName) {
		this.couponName = couponName == null ? null : couponName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public Byte getUseChannel() {
		return useChannel;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public void setUseChannel(Byte useChannel) {
		this.useChannel = useChannel;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public Byte getPreferentialType() {
		return preferentialType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public void setPreferentialType(Byte preferentialType) {
		this.preferentialType = preferentialType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public BigDecimal getMoney() {
		return money;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public BigDecimal getDiscount() {
		return discount;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public Byte getValidType() {
		return validType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public void setValidType(Byte validType) {
		this.validType = validType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public Date getValidDateStart() {
		return validDateStart;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public void setValidDateStart(Date validDateStart) {
		this.validDateStart = validDateStart;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public Date getValidDateEnd() {
		return validDateEnd;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public void setValidDateEnd(Date validDateEnd) {
		this.validDateEnd = validDateEnd;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public Integer getValidDay() {
		return validDay;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public void setValidDay(Integer validDay) {
		this.validDay = validDay;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public String getQrCode() {
		return qrCode;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public void setQrCode(String qrCode) {
		this.qrCode = qrCode == null ? null : qrCode.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public String getImg() {
		return img;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public void setImg(String img) {
		this.img = img == null ? null : img.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public Integer getPerMaxNum() {
		return perMaxNum;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public void setPerMaxNum(Integer perMaxNum) {
		this.perMaxNum = perMaxNum;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public Boolean getIsRealName() {
		return isRealName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public void setIsRealName(Boolean isRealName) {
		this.isRealName = isRealName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public Boolean getIsTransfer() {
		return isTransfer;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public void setIsTransfer(Boolean isTransfer) {
		this.isTransfer = isTransfer;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public Byte getActivitySuperpositionType() {
		return activitySuperpositionType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public void setActivitySuperpositionType(Byte activitySuperpositionType) {
		this.activitySuperpositionType = activitySuperpositionType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public String getActivitySuperpositionWhiteList() {
		return activitySuperpositionWhiteList;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public void setActivitySuperpositionWhiteList(String activitySuperpositionWhiteList) {
		this.activitySuperpositionWhiteList = activitySuperpositionWhiteList == null ? null
				: activitySuperpositionWhiteList.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public String getActivitySuperpositionBlackList() {
		return activitySuperpositionBlackList;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public void setActivitySuperpositionBlackList(String activitySuperpositionBlackList) {
		this.activitySuperpositionBlackList = activitySuperpositionBlackList == null ? null
				: activitySuperpositionBlackList.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public Boolean getIsSuperposition() {
		return isSuperposition;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public void setIsSuperposition(Boolean isSuperposition) {
		this.isSuperposition = isSuperposition;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public Boolean getIsTagPriceLimit() {
		return isTagPriceLimit;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public void setIsTagPriceLimit(Boolean isTagPriceLimit) {
		this.isTagPriceLimit = isTagPriceLimit;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public BigDecimal getTagPriceMaxPreferentialLimit() {
		return tagPriceMaxPreferentialLimit;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public void setTagPriceMaxPreferentialLimit(BigDecimal tagPriceMaxPreferentialLimit) {
		this.tagPriceMaxPreferentialLimit = tagPriceMaxPreferentialLimit;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public BigDecimal getMinConsume() {
		return minConsume;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public void setMinConsume(BigDecimal minConsume) {
		this.minConsume = minConsume;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public BigDecimal getMaxPreferential() {
		return maxPreferential;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public void setMaxPreferential(BigDecimal maxPreferential) {
		this.maxPreferential = maxPreferential;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public Integer getMinCommodityNum() {
		return minCommodityNum;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public void setMinCommodityNum(Integer minCommodityNum) {
		this.minCommodityNum = minCommodityNum;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public Integer getMaxCommodityNum() {
		return maxCommodityNum;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public void setMaxCommodityNum(Integer maxCommodityNum) {
		this.maxCommodityNum = maxCommodityNum;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public BigDecimal getMinDiscount() {
		return minDiscount;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public void setMinDiscount(BigDecimal minDiscount) {
		this.minDiscount = minDiscount;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public Byte getApplianceCommodityType() {
		return applianceCommodityType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public void setApplianceCommodityType(Byte applianceCommodityType) {
		this.applianceCommodityType = applianceCommodityType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public Byte getApplianceStoreType() {
		return applianceStoreType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public void setApplianceStoreType(Byte applianceStoreType) {
		this.applianceStoreType = applianceStoreType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public String getInfo() {
		return info;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public void setInfo(String info) {
		this.info = info == null ? null : info.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public Boolean getStatus() {
		return status;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public void setStatus(Boolean status) {
		this.status = status;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public Long getCreateUserId() {
		return createUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public String getCreateUserName() {
		return createUserName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName == null ? null : createUserName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public Long getModifiedUserId() {
		return modifiedUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public void setModifiedUserId(Long modifiedUserId) {
		this.modifiedUserId = modifiedUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public String getModifiedUserName() {
		return modifiedUserName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public void setModifiedUserName(String modifiedUserName) {
		this.modifiedUserName = modifiedUserName == null ? null : modifiedUserName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public Date getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public Boolean getValid() {
		return valid;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public void setValid(Boolean valid) {
		this.valid = valid;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public Boolean getIsAddTemplate() {
		return isAddTemplate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public void setIsAddTemplate(Boolean isAddTemplate) {
		this.isAddTemplate = isAddTemplate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public Byte getCouponSuperpositionType() {
		return couponSuperpositionType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public void setCouponSuperpositionType(Byte couponSuperpositionType) {
		this.couponSuperpositionType = couponSuperpositionType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public Boolean getSuperpositionMemberCard() {
		return superpositionMemberCard;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public void setSuperpositionMemberCard(Boolean superpositionMemberCard) {
		this.superpositionMemberCard = superpositionMemberCard;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public Boolean getTransferSend() {
		return transferSend;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public void setTransferSend(Boolean transferSend) {
		this.transferSend = transferSend;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public Long getTransferCouponDefinitionId() {
		return transferCouponDefinitionId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public void setTransferCouponDefinitionId(Long transferCouponDefinitionId) {
		this.transferCouponDefinitionId = transferCouponDefinitionId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public String getTransferInfo() {
		return transferInfo;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public void setTransferInfo(String transferInfo) {
		this.transferInfo = transferInfo == null ? null : transferInfo.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public Boolean getTransferFission() {
		return transferFission;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	public void setTransferFission(Boolean transferFission) {
		this.transferFission = transferFission;
	}
}