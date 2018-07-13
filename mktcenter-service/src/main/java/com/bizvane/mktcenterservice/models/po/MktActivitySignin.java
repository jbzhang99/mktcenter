package com.bizvane.mktcenterservice.models.po;

import java.io.Serializable;
import java.util.Date;

public class MktActivitySignin implements Serializable {

	/**
	 * 只读. pkid. mkt_activity_sign_in_id
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	@io.swagger.annotations.ApiModelProperty(value = "pkid", name = "mktActivitySignInId", required = false, example = "")
	private Long mktActivitySignInId;
	/**
	 * 只读. 关联活动id. mkt_activity_id
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	@io.swagger.annotations.ApiModelProperty(value = "关联活动id", name = "mktActivityId", required = false, example = "")
	private Long mktActivityId;
	/**
	 * 只读. 签到方式：1连续签到，2累计签到，3单日签到. sign_type
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	@io.swagger.annotations.ApiModelProperty(value = "签到方式：1连续签到，2累计签到，3单日签到", name = "signType", required = false, example = "")
	private Integer signType;
	/**
	 * 只读. 积分方式. integral_type
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	@io.swagger.annotations.ApiModelProperty(value = "积分方式", name = "integralType", required = false, example = "")
	private String integralType;
	/**
	 * 只读. 赠送积分基数. integral_basis
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	@io.swagger.annotations.ApiModelProperty(value = "赠送积分基数", name = "integralBasis", required = false, example = "")
	private Long integralBasis;
	/**
	 * 只读. 每次增加的数值. integral_addend
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	@io.swagger.annotations.ApiModelProperty(value = "每次增加的数值", name = "integralAddend", required = false, example = "")
	private Long integralAddend;
	/**
	 * 只读. 增加后的最高积分上限. integral_max
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	@io.swagger.annotations.ApiModelProperty(value = "增加后的最高积分上限", name = "integralMax", required = false, example = "")
	private Long integralMax;
	/**
	 * 只读. 备注. remark
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	@io.swagger.annotations.ApiModelProperty(value = "备注", name = "remark", required = false, example = "")
	private String remark;
	/**
	 * 只读. 创建人id. create_user_id
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建人id", name = "createUserId", required = false, example = "")
	private Long createUserId;
	/**
	 * 只读. 创建人. create_user_name
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建人", name = "createUserName", required = false, example = "")
	private String createUserName;
	/**
	 * 只读. 创建日期. create_date
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建日期", name = "createDate", required = false, example = "")
	private Date createDate;
	/**
	 * 只读. 修改人id. modified_user_id
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改人id", name = "modifiedUserId", required = false, example = "")
	private Long modifiedUserId;
	/**
	 * 只读. 修改人. modified_user_name
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改人", name = "modifiedUserName", required = false, example = "")
	private String modifiedUserName;
	/**
	 * 只读. 修改时间. modified_date
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改时间", name = "modifiedDate", required = false, example = "")
	private Date modifiedDate;
	/**
	 * 只读. 数据有效性：1=有效；0=无效. valid
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	@io.swagger.annotations.ApiModelProperty(value = "数据有效性：1=有效；0=无效", name = "valid", required = false, example = "")
	private Boolean valid;
	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public Long getMktActivitySignInId() {
		return mktActivitySignInId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public void setMktActivitySignInId(Long mktActivitySignInId) {
		this.mktActivitySignInId = mktActivitySignInId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public Long getMktActivityId() {
		return mktActivityId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public void setMktActivityId(Long mktActivityId) {
		this.mktActivityId = mktActivityId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public Integer getSignType() {
		return signType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public void setSignType(Integer signType) {
		this.signType = signType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public String getIntegralType() {
		return integralType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public void setIntegralType(String integralType) {
		this.integralType = integralType == null ? null : integralType.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public Long getIntegralBasis() {
		return integralBasis;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public void setIntegralBasis(Long integralBasis) {
		this.integralBasis = integralBasis;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public Long getIntegralAddend() {
		return integralAddend;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public void setIntegralAddend(Long integralAddend) {
		this.integralAddend = integralAddend;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public Long getIntegralMax() {
		return integralMax;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public void setIntegralMax(Long integralMax) {
		this.integralMax = integralMax;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public Long getCreateUserId() {
		return createUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public String getCreateUserName() {
		return createUserName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName == null ? null : createUserName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public Long getModifiedUserId() {
		return modifiedUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public void setModifiedUserId(Long modifiedUserId) {
		this.modifiedUserId = modifiedUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public String getModifiedUserName() {
		return modifiedUserName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public void setModifiedUserName(String modifiedUserName) {
		this.modifiedUserName = modifiedUserName == null ? null : modifiedUserName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public Date getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public Boolean getValid() {
		return valid;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
}