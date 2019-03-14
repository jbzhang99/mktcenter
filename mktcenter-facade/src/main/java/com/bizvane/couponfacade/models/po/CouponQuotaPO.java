package com.bizvane.couponfacade.models.po;

import java.io.Serializable;
import java.util.Date;

public class CouponQuotaPO implements Serializable {

	/**
	 * 只读. 配额定义id. coupon_quota_id
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	@io.swagger.annotations.ApiModelProperty(value = "配额定义id", name = "couponQuotaId", required = false, example = "")
	private Long couponQuotaId;
	/**
	 * 只读. 企业id. sys_company_id
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	@io.swagger.annotations.ApiModelProperty(value = "企业id", name = "sysCompanyId", required = false, example = "")
	private Long sysCompanyId;
	/**
	 * 只读. 品牌id. sys_brand_id
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	@io.swagger.annotations.ApiModelProperty(value = "品牌id", name = "sysBrandId", required = false, example = "")
	private Long sysBrandId;
	/**
	 * 只读. 券定义id. coupon_definition_id
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	@io.swagger.annotations.ApiModelProperty(value = "券定义id", name = "couponDefinitionId", required = false, example = "")
	private Long couponDefinitionId;
	/**
	 * 只读. 分配主题. quota_topic
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	@io.swagger.annotations.ApiModelProperty(value = "分配主题", name = "quotaTopic", required = false, example = "")
	private String quotaTopic;
	/**
	 * 只读. 分配总张数. total_number
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	@io.swagger.annotations.ApiModelProperty(value = "分配总张数", name = "totalNumber", required = false, example = "")
	private Integer totalNumber;
	/**
	 * 只读. 已分配张数. send_count
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	@io.swagger.annotations.ApiModelProperty(value = "已分配张数", name = "sendCount", required = false, example = "")
	private Integer sendCount;
	/**
	 * 只读. 分配人数. member_count
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	@io.swagger.annotations.ApiModelProperty(value = "分配人数", name = "memberCount", required = false, example = "")
	private Integer memberCount;
	/**
	 * 只读. 人均分配张数. member_average
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	@io.swagger.annotations.ApiModelProperty(value = "人均分配张数", name = "memberAverage", required = false, example = "")
	private Integer memberAverage;
	/**
	 * 只读. 开始时间. start_date
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	@io.swagger.annotations.ApiModelProperty(value = "开始时间", name = "startDate", required = false, example = "")
	private Date startDate;
	/**
	 * 只读. 截止时间. end_date
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	@io.swagger.annotations.ApiModelProperty(value = "截止时间", name = "endDate", required = false, example = "")
	private Date endDate;
	/**
	 * 只读. 数据有效性（1启用，0禁用）. state
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	@io.swagger.annotations.ApiModelProperty(value = "数据有效性（1启用，0禁用）", name = "state", required = false, example = "")
	private Boolean state;
	/**
	 * 只读. 券名称. coupon_name
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	@io.swagger.annotations.ApiModelProperty(value = "券名称", name = "couponName", required = false, example = "")
	private String couponName;
	/**
	 * 只读. 创建人id. create_user_id
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建人id", name = "createUserId", required = false, example = "")
	private Long createUserId;
	/**
	 * 只读. 创建人. create_user_name
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建人", name = "createUserName", required = false, example = "")
	private String createUserName;
	/**
	 * 只读. 创建时间. create_date
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建时间", name = "createDate", required = false, example = "")
	private Date createDate;
	/**
	 * 只读. 修改人id. modified_user_id
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改人id", name = "modifiedUserId", required = false, example = "")
	private Long modifiedUserId;
	/**
	 * 只读. 修改人. modified_user_name
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改人", name = "modifiedUserName", required = false, example = "")
	private String modifiedUserName;
	/**
	 * 只读. 修改时间. modified_date
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改时间", name = "modifiedDate", required = false, example = "")
	private Date modifiedDate;
	/**
	 * 只读. 备注. note
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	@io.swagger.annotations.ApiModelProperty(value = "备注", name = "note", required = false, example = "")
	private String note;
	/**
	 * 只读. . state_code
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	@io.swagger.annotations.ApiModelProperty(value = "", name = "stateCode", required = false, example = "")
	private String stateCode;
	/**
	 * 只读. . state_name
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	@io.swagger.annotations.ApiModelProperty(value = "", name = "stateName", required = false, example = "")
	private String stateName;
	/**
	 * 只读. . extend_code
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	@io.swagger.annotations.ApiModelProperty(value = "", name = "extendCode", required = false, example = "")
	private String extendCode;
	/**
	 * 只读. . extend_name
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	@io.swagger.annotations.ApiModelProperty(value = "", name = "extendName", required = false, example = "")
	private String extendName;
	/**
	 * 只读. . extend_note
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	@io.swagger.annotations.ApiModelProperty(value = "", name = "extendNote", required = false, example = "")
	private String extendNote;
	/**
	 * 只读. 数据有效性（1有效，0无效）. valid
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	@io.swagger.annotations.ApiModelProperty(value = "数据有效性（1有效，0无效）", name = "valid", required = false, example = "")
	private Boolean valid;
	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	public Long getCouponQuotaId() {
		return couponQuotaId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	public void setCouponQuotaId(Long couponQuotaId) {
		this.couponQuotaId = couponQuotaId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	public Long getSysCompanyId() {
		return sysCompanyId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	public void setSysCompanyId(Long sysCompanyId) {
		this.sysCompanyId = sysCompanyId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	public Long getSysBrandId() {
		return sysBrandId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	public void setSysBrandId(Long sysBrandId) {
		this.sysBrandId = sysBrandId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	public Long getCouponDefinitionId() {
		return couponDefinitionId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	public void setCouponDefinitionId(Long couponDefinitionId) {
		this.couponDefinitionId = couponDefinitionId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	public String getQuotaTopic() {
		return quotaTopic;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	public void setQuotaTopic(String quotaTopic) {
		this.quotaTopic = quotaTopic == null ? null : quotaTopic.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	public Integer getTotalNumber() {
		return totalNumber;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	public void setTotalNumber(Integer totalNumber) {
		this.totalNumber = totalNumber;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	public Integer getSendCount() {
		return sendCount;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	public void setSendCount(Integer sendCount) {
		this.sendCount = sendCount;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	public Integer getMemberCount() {
		return memberCount;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	public void setMemberCount(Integer memberCount) {
		this.memberCount = memberCount;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	public Integer getMemberAverage() {
		return memberAverage;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	public void setMemberAverage(Integer memberAverage) {
		this.memberAverage = memberAverage;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	public Boolean getState() {
		return state;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	public void setState(Boolean state) {
		this.state = state;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	public String getCouponName() {
		return couponName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	public void setCouponName(String couponName) {
		this.couponName = couponName == null ? null : couponName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	public Long getCreateUserId() {
		return createUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	public String getCreateUserName() {
		return createUserName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName == null ? null : createUserName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	public Long getModifiedUserId() {
		return modifiedUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	public void setModifiedUserId(Long modifiedUserId) {
		this.modifiedUserId = modifiedUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	public String getModifiedUserName() {
		return modifiedUserName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	public void setModifiedUserName(String modifiedUserName) {
		this.modifiedUserName = modifiedUserName == null ? null : modifiedUserName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	public Date getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	public String getNote() {
		return note;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	public void setNote(String note) {
		this.note = note == null ? null : note.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	public String getStateCode() {
		return stateCode;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode == null ? null : stateCode.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	public String getStateName() {
		return stateName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	public void setStateName(String stateName) {
		this.stateName = stateName == null ? null : stateName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	public String getExtendCode() {
		return extendCode;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	public void setExtendCode(String extendCode) {
		this.extendCode = extendCode == null ? null : extendCode.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	public String getExtendName() {
		return extendName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	public void setExtendName(String extendName) {
		this.extendName = extendName == null ? null : extendName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	public String getExtendNote() {
		return extendNote;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	public void setExtendNote(String extendNote) {
		this.extendNote = extendNote == null ? null : extendNote.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	public Boolean getValid() {
		return valid;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
}