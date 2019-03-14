package com.bizvane.mktcenterfacade.models.po;

import java.io.Serializable;
import java.util.Date;

public class MktActivityRegisterPO implements Serializable {

	/**
	 * 只读. pkid. mkt_activity_resigter_id
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "pkid", name = "mktActivityResigterId", required = false, example = "")
	private Long mktActivityResigterId;
	/**
	 * 只读. . sys_company_id
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "", name = "sysCompanyId", required = false, example = "")
	private Long sysCompanyId;
	/**
	 * 只读. 关联活动id. mkt_activity_id
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "关联活动id", name = "mktActivityId", required = false, example = "")
	private Long mktActivityId;
	/**
	 * 只读. 线下开卡状态：0所有，1未开，2已开. offline_card_status
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "线下开卡状态：0所有，1未开，2已开", name = "offlineCardStatus", required = false, example = "")
	private Integer offlineCardStatus;
	/**
	 * 只读. 开卡时等级编号. mbr_level_code
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "开卡时等级编号", name = "mbrLevelCode", required = false, example = "")
	private String mbrLevelCode;
	/**
	 * 只读. 开卡时等级名称. mbr_level_name
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "开卡时等级名称", name = "mbrLevelName", required = false, example = "")
	private String mbrLevelName;
	/**
	 * 只读. 门店限制状态：0不限制，1限制. is_store_limit
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "门店限制状态：0不限制，1限制", name = "isStoreLimit", required = false, example = "")
	private Boolean isStoreLimit;
	/**
	 * 只读. 门店限制类型：1黑名单，2白名单. store_limit_type
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "门店限制类型：1黑名单，2白名单", name = "storeLimitType", required = false, example = "")
	private Integer storeLimitType;
	/**
	 * 只读. 备注. remark
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "备注", name = "remark", required = false, example = "")
	private String remark;
	/**
	 * 只读. 创建人id. create_user_id
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建人id", name = "createUserId", required = false, example = "")
	private Long createUserId;
	/**
	 * 只读. 创建人. create_user_name
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建人", name = "createUserName", required = false, example = "")
	private String createUserName;
	/**
	 * 只读. 创建日期. create_date
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建日期", name = "createDate", required = false, example = "")
	private Date createDate;
	/**
	 * 只读. 修改人id. modified_user_id
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改人id", name = "modifiedUserId", required = false, example = "")
	private Long modifiedUserId;
	/**
	 * 只读. 修改人. modified_user_name
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改人", name = "modifiedUserName", required = false, example = "")
	private String modifiedUserName;
	/**
	 * 只读. 修改时间. modified_date
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改时间", name = "modifiedDate", required = false, example = "")
	private Date modifiedDate;
	/**
	 * 只读. 数据有效性：1=有效；0=无效. valid
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "数据有效性：1=有效；0=无效", name = "valid", required = false, example = "")
	private Boolean valid;
	/**
	 * 只读. 门店限制名单. store_limit_list
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	@io.swagger.annotations.ApiModelProperty(value = "门店限制名单", name = "storeLimitList", required = false, example = "")
	private String storeLimitList;
	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public Long getMktActivityResigterId() {
		return mktActivityResigterId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public void setMktActivityResigterId(Long mktActivityResigterId) {
		this.mktActivityResigterId = mktActivityResigterId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public Long getSysCompanyId() {
		return sysCompanyId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public void setSysCompanyId(Long sysCompanyId) {
		this.sysCompanyId = sysCompanyId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public Long getMktActivityId() {
		return mktActivityId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public void setMktActivityId(Long mktActivityId) {
		this.mktActivityId = mktActivityId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public Integer getOfflineCardStatus() {
		return offlineCardStatus;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public void setOfflineCardStatus(Integer offlineCardStatus) {
		this.offlineCardStatus = offlineCardStatus;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public String getMbrLevelCode() {
		return mbrLevelCode;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public void setMbrLevelCode(String mbrLevelCode) {
		this.mbrLevelCode = mbrLevelCode == null ? null : mbrLevelCode.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public String getMbrLevelName() {
		return mbrLevelName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public void setMbrLevelName(String mbrLevelName) {
		this.mbrLevelName = mbrLevelName == null ? null : mbrLevelName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public Boolean getIsStoreLimit() {
		return isStoreLimit;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public void setIsStoreLimit(Boolean isStoreLimit) {
		this.isStoreLimit = isStoreLimit;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public Integer getStoreLimitType() {
		return storeLimitType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public void setStoreLimitType(Integer storeLimitType) {
		this.storeLimitType = storeLimitType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public Long getCreateUserId() {
		return createUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public String getCreateUserName() {
		return createUserName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName == null ? null : createUserName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public Long getModifiedUserId() {
		return modifiedUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public void setModifiedUserId(Long modifiedUserId) {
		this.modifiedUserId = modifiedUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public String getModifiedUserName() {
		return modifiedUserName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public void setModifiedUserName(String modifiedUserName) {
		this.modifiedUserName = modifiedUserName == null ? null : modifiedUserName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public Date getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public Boolean getValid() {
		return valid;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public void setValid(Boolean valid) {
		this.valid = valid;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public String getStoreLimitList() {
		return storeLimitList;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	public void setStoreLimitList(String storeLimitList) {
		this.storeLimitList = storeLimitList == null ? null : storeLimitList.trim();
	}
}