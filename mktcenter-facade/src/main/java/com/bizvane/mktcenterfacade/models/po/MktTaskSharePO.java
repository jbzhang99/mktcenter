package com.bizvane.mktcenterfacade.models.po;

import java.io.Serializable;
import java.util.Date;

public class MktTaskSharePO implements Serializable {

	/**
	 * 只读. pkid. mkt_task_share_id
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	@io.swagger.annotations.ApiModelProperty(value = "pkid", name = "mktTaskShareId", required = false, example = "")
	private Long mktTaskShareId;
	/**
	 * 只读. . sys_company_id
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	@io.swagger.annotations.ApiModelProperty(value = "", name = "sysCompanyId", required = false, example = "")
	private Long sysCompanyId;
	/**
	 * 只读. 关联的任务id. mkt_task_id
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	@io.swagger.annotations.ApiModelProperty(value = "关联的任务id", name = "mktTaskId", required = false, example = "")
	private Long mktTaskId;
	/**
	 * 只读. 任务条件/分享次数. share_times
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	@io.swagger.annotations.ApiModelProperty(value = "任务条件/分享次数", name = "shareTimes", required = false, example = "")
	private Integer shareTimes;
	/**
	 * 只读. 任务条件/分享的链接类型：1站内链接，2自定义链接. share_url_type
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	@io.swagger.annotations.ApiModelProperty(value = "任务条件/分享的链接类型：1站内链接，2自定义链接", name = "shareUrlType", required = false, example = "")
	private Integer shareUrlType;
	/**
	 * 只读. 门店限制状态：0不限制，1限制. is_store_limit
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	@io.swagger.annotations.ApiModelProperty(value = "门店限制状态：0不限制，1限制", name = "isStoreLimit", required = false, example = "")
	private Boolean isStoreLimit;
	/**
	 * 只读. 门店限制类型：1黑名单，2白名单. store_limit_type
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	@io.swagger.annotations.ApiModelProperty(value = "门店限制类型：1黑名单，2白名单", name = "storeLimitType", required = false, example = "")
	private Integer storeLimitType;
	/**
	 * 只读. 备注. remark
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	@io.swagger.annotations.ApiModelProperty(value = "备注", name = "remark", required = false, example = "")
	private String remark;
	/**
	 * 只读. 创建人id. create_user_id
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建人id", name = "createUserId", required = false, example = "")
	private Long createUserId;
	/**
	 * 只读. 创建人. create_user_name
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建人", name = "createUserName", required = false, example = "")
	private String createUserName;
	/**
	 * 只读. 创建日期. create_date
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建日期", name = "createDate", required = false, example = "")
	private Date createDate;
	/**
	 * 只读. 修改人id. modified_user_id
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改人id", name = "modifiedUserId", required = false, example = "")
	private Long modifiedUserId;
	/**
	 * 只读. 修改人. modified_user_name
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改人", name = "modifiedUserName", required = false, example = "")
	private String modifiedUserName;
	/**
	 * 只读. 修改时间. modified_date
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改时间", name = "modifiedDate", required = false, example = "")
	private Date modifiedDate;
	/**
	 * 只读. 数据有效性：1=有效；0=无效. valid
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	@io.swagger.annotations.ApiModelProperty(value = "数据有效性：1=有效；0=无效", name = "valid", required = false, example = "")
	private Boolean valid;
	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	public Long getMktTaskShareId() {
		return mktTaskShareId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	public void setMktTaskShareId(Long mktTaskShareId) {
		this.mktTaskShareId = mktTaskShareId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	public Long getSysCompanyId() {
		return sysCompanyId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	public void setSysCompanyId(Long sysCompanyId) {
		this.sysCompanyId = sysCompanyId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	public Long getMktTaskId() {
		return mktTaskId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	public void setMktTaskId(Long mktTaskId) {
		this.mktTaskId = mktTaskId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	public Integer getShareTimes() {
		return shareTimes;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	public void setShareTimes(Integer shareTimes) {
		this.shareTimes = shareTimes;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	public Integer getShareUrlType() {
		return shareUrlType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	public void setShareUrlType(Integer shareUrlType) {
		this.shareUrlType = shareUrlType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	public Boolean getIsStoreLimit() {
		return isStoreLimit;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	public void setIsStoreLimit(Boolean isStoreLimit) {
		this.isStoreLimit = isStoreLimit;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	public Integer getStoreLimitType() {
		return storeLimitType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	public void setStoreLimitType(Integer storeLimitType) {
		this.storeLimitType = storeLimitType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	public Long getCreateUserId() {
		return createUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	public String getCreateUserName() {
		return createUserName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName == null ? null : createUserName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	public Long getModifiedUserId() {
		return modifiedUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	public void setModifiedUserId(Long modifiedUserId) {
		this.modifiedUserId = modifiedUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	public String getModifiedUserName() {
		return modifiedUserName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	public void setModifiedUserName(String modifiedUserName) {
		this.modifiedUserName = modifiedUserName == null ? null : modifiedUserName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	public Date getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	public Boolean getValid() {
		return valid;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
}