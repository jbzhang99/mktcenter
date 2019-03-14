package com.bizvane.couponfacade.models.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CouponQuotaDetailPO implements Serializable {

	/**
	 * 只读. . coupon_quota_detail_id
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "", name = "couponQuotaDetailId", required = false, example = "")
	private Long couponQuotaDetailId;
	/**
	 * 只读. 企业id. sys_company_id
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "企业id", name = "sysCompanyId", required = false, example = "")
	private Long sysCompanyId;
	/**
	 * 只读. 品牌id. sys_brand_id
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "品牌id", name = "sysBrandId", required = false, example = "")
	private Long sysBrandId;
	/**
	 * 只读. 券配额表主键. coupon_quota_id
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "券配额表主键", name = "couponQuotaId", required = false, example = "")
	private Long couponQuotaId;
	/**
	 * 只读. 分配主题. quota_topic
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "分配主题", name = "quotaTopic", required = false, example = "")
	private String quotaTopic;
	/**
	 * 只读. . sys_staff_id
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "", name = "sysStaffId", required = false, example = "")
	private Long sysStaffId;
	/**
	 * 只读. 员工编号. staff_code
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "员工编号", name = "staffCode", required = false, example = "")
	private String staffCode;
	/**
	 * 只读. 员工名称. staff_name
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "员工名称", name = "staffName", required = false, example = "")
	private String staffName;
	/**
	 * 只读. 店铺名称. store_name
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "店铺名称", name = "storeName", required = false, example = "")
	private String storeName;
	/**
	 * 只读. 店铺线下code. store_offline_code
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "店铺线下code", name = "storeOfflineCode", required = false, example = "")
	private String storeOfflineCode;
	/**
	 * 只读. 配额总数. total_number
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "配额总数", name = "totalNumber", required = false, example = "")
	private Integer totalNumber;
	/**
	 * 只读. 已使用张数. use_number
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "已使用张数", name = "useNumber", required = false, example = "")
	private Integer useNumber;
	/**
	 * 只读. 剩余张数. unuse_number
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "剩余张数", name = "unuseNumber", required = false, example = "")
	private Integer unuseNumber;
	/**
	 * 只读. 券编号. coupon_definition_code
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "券编号", name = "couponDefinitionCode", required = false, example = "")
	private String couponDefinitionCode;
	/**
	 * 只读. 券定义id. coupon_definition_id
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "券定义id", name = "couponDefinitionId", required = false, example = "")
	private Long couponDefinitionId;
	/**
	 * 只读. 优惠类型（1现金，2折扣，3礼品）. preferential_type
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "优惠类型（1现金，2折扣，3礼品）", name = "preferentialType", required = false, example = "")
	private Byte preferentialType;
	/**
	 * 只读. 最低消费金额(满减金额). min_consume
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "最低消费金额(满减金额)", name = "minConsume", required = false, example = "")
	private BigDecimal minConsume;
	/**
	 * 只读. 券名称. coupon_name
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "券名称", name = "couponName", required = false, example = "")
	private String couponName;
	/**
	 * 只读. 面额. money
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "面额", name = "money", required = false, example = "")
	private BigDecimal money;
	/**
	 * 只读. 折扣. discount
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "折扣", name = "discount", required = false, example = "")
	private BigDecimal discount;
	/**
	 * 只读. . valid_day
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "", name = "validDay", required = false, example = "")
	private Integer validDay;
	/**
	 * 只读. . valid_type
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "", name = "validType", required = false, example = "")
	private Byte validType;
	/**
	 * 只读. 券说明. info
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "券说明", name = "info", required = false, example = "")
	private String info;
	/**
	 * 只读. 有效期开始时间. valid_date_start
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "有效期开始时间", name = "validDateStart", required = false, example = "")
	private Date validDateStart;
	/**
	 * 只读. 有效期结束时间. valid_date_end
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "有效期结束时间", name = "validDateEnd", required = false, example = "")
	private Date validDateEnd;
	/**
	 * 只读. 券可发送有效时间-开始. start_date_start
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "券可发送有效时间-开始", name = "startDateStart", required = false, example = "")
	private Date startDateStart;
	/**
	 * 只读. 券可发送有效时间-截止. start_date_end
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "券可发送有效时间-截止", name = "startDateEnd", required = false, example = "")
	private Date startDateEnd;
	/**
	 * 只读. 截止时间-开始. end_date_start
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "截止时间-开始", name = "endDateStart", required = false, example = "")
	private Date endDateStart;
	/**
	 * 只读. 截止时间-截止. end_date_end
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "截止时间-截止", name = "endDateEnd", required = false, example = "")
	private Date endDateEnd;
	/**
	 * 只读. 创建人id. create_user_id
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建人id", name = "createUserId", required = false, example = "")
	private Long createUserId;
	/**
	 * 只读. 创建人. create_user_name
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建人", name = "createUserName", required = false, example = "")
	private String createUserName;
	/**
	 * 只读. 创建时间. create_date
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建时间", name = "createDate", required = false, example = "")
	private Date createDate;
	/**
	 * 只读. 修改人id. modified_user_id
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改人id", name = "modifiedUserId", required = false, example = "")
	private Long modifiedUserId;
	/**
	 * 只读. 修改人. modified_user_name
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改人", name = "modifiedUserName", required = false, example = "")
	private String modifiedUserName;
	/**
	 * 只读. 修改时间. modified_date
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改时间", name = "modifiedDate", required = false, example = "")
	private Date modifiedDate;
	/**
	 * 只读. 备注. note
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "备注", name = "note", required = false, example = "")
	private String note;
	/**
	 * 只读. 有效期类型：1-日期区间，2-领取后X天有效，3-仅限会员生日当天使用，4-仅限会员生日当月使用. state_code
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "有效期类型：1-日期区间，2-领取后X天有效，3-仅限会员生日当天使用，4-仅限会员生日当月使用", name = "stateCode", required = false, example = "")
	private String stateCode;
	/**
	 * 只读. 有效天数. state_name
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "有效天数", name = "stateName", required = false, example = "")
	private String stateName;
	/**
	 * 只读. . extend_code
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "", name = "extendCode", required = false, example = "")
	private String extendCode;
	/**
	 * 只读. . extend_name
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "", name = "extendName", required = false, example = "")
	private String extendName;
	/**
	 * 只读. . extend_note
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "", name = "extendNote", required = false, example = "")
	private String extendNote;
	/**
	 * 只读. 数据有效性（1有效，0无效）. valid
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "数据有效性（1有效，0无效）", name = "valid", required = false, example = "")
	private Boolean valid;
	/**
	 * 只读. 所有发送的会员code. member_code_list
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "所有发送的会员code", name = "memberCodeList", required = false, example = "")
	private String memberCodeList;
	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public Long getCouponQuotaDetailId() {
		return couponQuotaDetailId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public void setCouponQuotaDetailId(Long couponQuotaDetailId) {
		this.couponQuotaDetailId = couponQuotaDetailId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public Long getSysCompanyId() {
		return sysCompanyId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public void setSysCompanyId(Long sysCompanyId) {
		this.sysCompanyId = sysCompanyId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public Long getSysBrandId() {
		return sysBrandId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public void setSysBrandId(Long sysBrandId) {
		this.sysBrandId = sysBrandId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public Long getCouponQuotaId() {
		return couponQuotaId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public void setCouponQuotaId(Long couponQuotaId) {
		this.couponQuotaId = couponQuotaId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public String getQuotaTopic() {
		return quotaTopic;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public void setQuotaTopic(String quotaTopic) {
		this.quotaTopic = quotaTopic == null ? null : quotaTopic.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public Long getSysStaffId() {
		return sysStaffId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public void setSysStaffId(Long sysStaffId) {
		this.sysStaffId = sysStaffId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public String getStaffCode() {
		return staffCode;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode == null ? null : staffCode.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public String getStaffName() {
		return staffName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public void setStaffName(String staffName) {
		this.staffName = staffName == null ? null : staffName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public String getStoreName() {
		return storeName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public void setStoreName(String storeName) {
		this.storeName = storeName == null ? null : storeName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public String getStoreOfflineCode() {
		return storeOfflineCode;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public void setStoreOfflineCode(String storeOfflineCode) {
		this.storeOfflineCode = storeOfflineCode == null ? null : storeOfflineCode.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public Integer getTotalNumber() {
		return totalNumber;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public void setTotalNumber(Integer totalNumber) {
		this.totalNumber = totalNumber;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public Integer getUseNumber() {
		return useNumber;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public void setUseNumber(Integer useNumber) {
		this.useNumber = useNumber;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public Integer getUnuseNumber() {
		return unuseNumber;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public void setUnuseNumber(Integer unuseNumber) {
		this.unuseNumber = unuseNumber;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public String getCouponDefinitionCode() {
		return couponDefinitionCode;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public void setCouponDefinitionCode(String couponDefinitionCode) {
		this.couponDefinitionCode = couponDefinitionCode == null ? null : couponDefinitionCode.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public Long getCouponDefinitionId() {
		return couponDefinitionId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public void setCouponDefinitionId(Long couponDefinitionId) {
		this.couponDefinitionId = couponDefinitionId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public Byte getPreferentialType() {
		return preferentialType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public void setPreferentialType(Byte preferentialType) {
		this.preferentialType = preferentialType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public BigDecimal getMinConsume() {
		return minConsume;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public void setMinConsume(BigDecimal minConsume) {
		this.minConsume = minConsume;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public String getCouponName() {
		return couponName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public void setCouponName(String couponName) {
		this.couponName = couponName == null ? null : couponName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public BigDecimal getMoney() {
		return money;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public BigDecimal getDiscount() {
		return discount;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public Integer getValidDay() {
		return validDay;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public void setValidDay(Integer validDay) {
		this.validDay = validDay;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public Byte getValidType() {
		return validType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public void setValidType(Byte validType) {
		this.validType = validType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public String getInfo() {
		return info;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public void setInfo(String info) {
		this.info = info == null ? null : info.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public Date getValidDateStart() {
		return validDateStart;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public void setValidDateStart(Date validDateStart) {
		this.validDateStart = validDateStart;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public Date getValidDateEnd() {
		return validDateEnd;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public void setValidDateEnd(Date validDateEnd) {
		this.validDateEnd = validDateEnd;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public Date getStartDateStart() {
		return startDateStart;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public void setStartDateStart(Date startDateStart) {
		this.startDateStart = startDateStart;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public Date getStartDateEnd() {
		return startDateEnd;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public void setStartDateEnd(Date startDateEnd) {
		this.startDateEnd = startDateEnd;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public Date getEndDateStart() {
		return endDateStart;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public void setEndDateStart(Date endDateStart) {
		this.endDateStart = endDateStart;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public Date getEndDateEnd() {
		return endDateEnd;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public void setEndDateEnd(Date endDateEnd) {
		this.endDateEnd = endDateEnd;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public Long getCreateUserId() {
		return createUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public String getCreateUserName() {
		return createUserName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName == null ? null : createUserName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public Long getModifiedUserId() {
		return modifiedUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public void setModifiedUserId(Long modifiedUserId) {
		this.modifiedUserId = modifiedUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public String getModifiedUserName() {
		return modifiedUserName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public void setModifiedUserName(String modifiedUserName) {
		this.modifiedUserName = modifiedUserName == null ? null : modifiedUserName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public Date getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public String getNote() {
		return note;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public void setNote(String note) {
		this.note = note == null ? null : note.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public String getStateCode() {
		return stateCode;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode == null ? null : stateCode.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public String getStateName() {
		return stateName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public void setStateName(String stateName) {
		this.stateName = stateName == null ? null : stateName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public String getExtendCode() {
		return extendCode;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public void setExtendCode(String extendCode) {
		this.extendCode = extendCode == null ? null : extendCode.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public String getExtendName() {
		return extendName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public void setExtendName(String extendName) {
		this.extendName = extendName == null ? null : extendName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public String getExtendNote() {
		return extendNote;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public void setExtendNote(String extendNote) {
		this.extendNote = extendNote == null ? null : extendNote.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public Boolean getValid() {
		return valid;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public void setValid(Boolean valid) {
		this.valid = valid;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public String getMemberCodeList() {
		return memberCodeList;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public void setMemberCodeList(String memberCodeList) {
		this.memberCodeList = memberCodeList == null ? null : memberCodeList.trim();
	}
}