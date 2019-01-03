package com.bizvane.mktcenterservice.models.po;

import java.io.Serializable;
import java.util.Date;

public class MktActivityPrizeRecordPO implements Serializable {

	/**
	 * 只读. . mkt_activity_prize_record_id
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "", name = "mktActivityPrizeRecordId", required = false, example = "")
	private Long mktActivityPrizeRecordId;
	/**
	 * 只读. 关联活动id. mkt_activity_id
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "关联活动id", name = "mktActivityId", required = false, example = "")
	private Long mktActivityId;
	/**
	 * 只读. 所属企业id. sys_company_id
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "所属企业id", name = "sysCompanyId", required = false, example = "")
	private Long sysCompanyId;
	/**
	 * 只读. 所属品牌id. sys_brand_id
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "所属品牌id", name = "sysBrandId", required = false, example = "")
	private Long sysBrandId;
	/**
	 * 只读. 参与活动的会员编号. member_code
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "参与活动的会员编号", name = "memberCode", required = false, example = "")
	private String memberCode;
	/**
	 * 只读. 会员手机号. member_phone
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "会员手机号", name = "memberPhone", required = false, example = "")
	private String memberPhone;
	/**
	 * 只读. 会员名称. member_name
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "会员名称", name = "memberName", required = false, example = "")
	private String memberName;
	/**
	 * 只读. 奖项类型，10-特等奖，20-一等奖，30-二等奖，40-三等奖，50-谢谢参与. prize_type
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "奖项类型，10-特等奖，20-一等奖，30-二等奖，40-三等奖，50-谢谢参与", name = "prizeType", required = false, example = "")
	private Integer prizeType;
	/**
	 * 只读. 奖品类型：10-积分，20-优惠券（现金，折扣）,30-兑换券（礼品券）. awad_type
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "奖品类型：10-积分，20-优惠券（现金，折扣）,30-兑换券（礼品券）", name = "awadType", required = false, example = "")
	private Integer awadType;
	/**
	 * 只读. 奖品名称. prize_name
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "奖品名称", name = "prizeName", required = false, example = "")
	private String prizeName;
	/**
	 * 只读. 中奖时间. prize_time
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "中奖时间", name = "prizeTime", required = false, example = "")
	private Date prizeTime;
	/**
	 * 只读. 券定义id. coupon_definition_id
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "券定义id", name = "couponDefinitionId", required = false, example = "")
	private Long couponDefinitionId;
	/**
	 * 只读. 券code. coupon_definition_code
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "券code", name = "couponDefinitionCode", required = false, example = "")
	private String couponDefinitionCode;
	/**
	 * 只读. 是否中奖，1是，0否. is_win_prize
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "是否中奖，1是，0否", name = "isWinPrize", required = false, example = "")
	private Boolean isWinPrize;
	/**
	 * 只读. 备注. remark
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "备注", name = "remark", required = false, example = "")
	private String remark;
	/**
	 * 只读. 创建人id. create_user_id
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建人id", name = "createUserId", required = false, example = "")
	private Long createUserId;
	/**
	 * 只读. 创建人. create_user_name
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建人", name = "createUserName", required = false, example = "")
	private String createUserName;
	/**
	 * 只读. 创建时间. create_date
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建时间", name = "createDate", required = false, example = "")
	private Date createDate;
	/**
	 * 只读. 修改人id. modified_user_id
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改人id", name = "modifiedUserId", required = false, example = "")
	private Integer modifiedUserId;
	/**
	 * 只读. 修改人. modified_user_name
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改人", name = "modifiedUserName", required = false, example = "")
	private String modifiedUserName;
	/**
	 * 只读. 修改时间. modified_date
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改时间", name = "modifiedDate", required = false, example = "")
	private Date modifiedDate;
	/**
	 * 只读. 数据有效性：1=有效；0=无效. valid
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "数据有效性：1=有效；0=无效", name = "valid", required = false, example = "")
	private Boolean valid;
	/**
	 * 只读. 
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	public Long getMktActivityPrizeRecordId() {
		return mktActivityPrizeRecordId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	public void setMktActivityPrizeRecordId(Long mktActivityPrizeRecordId) {
		this.mktActivityPrizeRecordId = mktActivityPrizeRecordId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	public Long getMktActivityId() {
		return mktActivityId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	public void setMktActivityId(Long mktActivityId) {
		this.mktActivityId = mktActivityId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	public Long getSysCompanyId() {
		return sysCompanyId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	public void setSysCompanyId(Long sysCompanyId) {
		this.sysCompanyId = sysCompanyId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	public Long getSysBrandId() {
		return sysBrandId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	public void setSysBrandId(Long sysBrandId) {
		this.sysBrandId = sysBrandId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	public String getMemberCode() {
		return memberCode;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode == null ? null : memberCode.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	public String getMemberPhone() {
		return memberPhone;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone == null ? null : memberPhone.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	public String getMemberName() {
		return memberName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName == null ? null : memberName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	public Integer getPrizeType() {
		return prizeType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	public void setPrizeType(Integer prizeType) {
		this.prizeType = prizeType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	public Integer getAwadType() {
		return awadType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	public void setAwadType(Integer awadType) {
		this.awadType = awadType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	public String getPrizeName() {
		return prizeName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	public void setPrizeName(String prizeName) {
		this.prizeName = prizeName == null ? null : prizeName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	public Date getPrizeTime() {
		return prizeTime;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	public void setPrizeTime(Date prizeTime) {
		this.prizeTime = prizeTime;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	public Long getCouponDefinitionId() {
		return couponDefinitionId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	public void setCouponDefinitionId(Long couponDefinitionId) {
		this.couponDefinitionId = couponDefinitionId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	public String getCouponDefinitionCode() {
		return couponDefinitionCode;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	public void setCouponDefinitionCode(String couponDefinitionCode) {
		this.couponDefinitionCode = couponDefinitionCode == null ? null : couponDefinitionCode.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	public Boolean getIsWinPrize() {
		return isWinPrize;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	public void setIsWinPrize(Boolean isWinPrize) {
		this.isWinPrize = isWinPrize;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	public Long getCreateUserId() {
		return createUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	public String getCreateUserName() {
		return createUserName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName == null ? null : createUserName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	public Integer getModifiedUserId() {
		return modifiedUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	public void setModifiedUserId(Integer modifiedUserId) {
		this.modifiedUserId = modifiedUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	public String getModifiedUserName() {
		return modifiedUserName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	public void setModifiedUserName(String modifiedUserName) {
		this.modifiedUserName = modifiedUserName == null ? null : modifiedUserName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	public Date getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	public Boolean getValid() {
		return valid;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
}