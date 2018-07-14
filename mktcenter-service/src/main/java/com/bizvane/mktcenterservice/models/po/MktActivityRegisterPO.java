package com.bizvane.mktcenterservice.models.po;

import java.io.Serializable;
import java.util.Date;

public class MktActivityRegisterPO implements Serializable {

	/**
	 * 只读. pkid. mkt_activity_resigter_id
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	@io.swagger.annotations.ApiModelProperty(value = "pkid", name = "mktActivityResigterId", required = false, example = "")
	private Long mktActivityResigterId;
	/**
	 * 只读. 关联活动id. mkt_activity_id
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	@io.swagger.annotations.ApiModelProperty(value = "关联活动id", name = "mktActivityId", required = false, example = "")
	private Long mktActivityId;
	/**
	 * 只读. 线下开卡状态：0所有，1未开，2已开. offline_card_status
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	@io.swagger.annotations.ApiModelProperty(value = "线下开卡状态：0所有，1未开，2已开", name = "offlineCardStatus", required = false, example = "")
	private Integer offlineCardStatus;
	/**
	 * 只读. 开卡时等级编号. mbr_level_code
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	@io.swagger.annotations.ApiModelProperty(value = "开卡时等级编号", name = "mbrLevelCode", required = false, example = "")
	private String mbrLevelCode;
	/**
	 * 只读. 开卡时等级名称. mbr_level_name
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	@io.swagger.annotations.ApiModelProperty(value = "开卡时等级名称", name = "mbrLevelName", required = false, example = "")
	private String mbrLevelName;
	/**
	 * 只读. 备注. remark
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	@io.swagger.annotations.ApiModelProperty(value = "备注", name = "remark", required = false, example = "")
	private String remark;
	/**
	 * 只读. 创建人id. create_user_id
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建人id", name = "createUserId", required = false, example = "")
	private Long createUserId;
	/**
	 * 只读. 创建人. create_user_name
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建人", name = "createUserName", required = false, example = "")
	private String createUserName;
	/**
	 * 只读. 创建日期. create_date
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建日期", name = "createDate", required = false, example = "")
	private Date createDate;
	/**
	 * 只读. 修改人id. modified_user_id
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改人id", name = "modifiedUserId", required = false, example = "")
	private Long modifiedUserId;
	/**
	 * 只读. 修改人. modified_user_name
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改人", name = "modifiedUserName", required = false, example = "")
	private String modifiedUserName;
	/**
	 * 只读. 修改时间. modified_date
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改时间", name = "modifiedDate", required = false, example = "")
	private Date modifiedDate;
	/**
	 * 只读. 数据有效性：1=有效；0=无效. valid
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	@io.swagger.annotations.ApiModelProperty(value = "数据有效性：1=有效；0=无效", name = "valid", required = false, example = "")
	private Boolean valid;
	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public Long getMktActivityResigterId() {
		return mktActivityResigterId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public void setMktActivityResigterId(Long mktActivityResigterId) {
		this.mktActivityResigterId = mktActivityResigterId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public Long getMktActivityId() {
		return mktActivityId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public void setMktActivityId(Long mktActivityId) {
		this.mktActivityId = mktActivityId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public Integer getOfflineCardStatus() {
		return offlineCardStatus;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public void setOfflineCardStatus(Integer offlineCardStatus) {
		this.offlineCardStatus = offlineCardStatus;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public String getMbrLevelCode() {
		return mbrLevelCode;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public void setMbrLevelCode(String mbrLevelCode) {
		this.mbrLevelCode = mbrLevelCode == null ? null : mbrLevelCode.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public String getMbrLevelName() {
		return mbrLevelName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public void setMbrLevelName(String mbrLevelName) {
		this.mbrLevelName = mbrLevelName == null ? null : mbrLevelName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public Long getCreateUserId() {
		return createUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public String getCreateUserName() {
		return createUserName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName == null ? null : createUserName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public Long getModifiedUserId() {
		return modifiedUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public void setModifiedUserId(Long modifiedUserId) {
		this.modifiedUserId = modifiedUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public String getModifiedUserName() {
		return modifiedUserName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public void setModifiedUserName(String modifiedUserName) {
		this.modifiedUserName = modifiedUserName == null ? null : modifiedUserName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public Date getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public Boolean getValid() {
		return valid;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
}