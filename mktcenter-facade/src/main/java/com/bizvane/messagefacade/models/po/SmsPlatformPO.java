package com.bizvane.messagefacade.models.po;

import java.io.Serializable;
import java.util.Date;

public class SmsPlatformPO implements Serializable {

	/**
	 * 只读. id. platform_id
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	private Long platformId;
	/**
	 * 只读. 平台编号. platform_code
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	private String platformCode;
	/**
	 * 只读. 平台名称. platform_name
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	private String platformName;
	/**
	 * 只读. 备注. remark
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	private String remark;
	/**
	 * 只读. 创建人id. create_user_id
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	private Long createUserId;
	/**
	 * 只读. 创建人. create_user_name
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	private String createUserName;
	/**
	 * 只读. 创建时间. create_date
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	private Date createDate;
	/**
	 * 只读. 修改人id. modified_user_id
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	private Long modifiedUserId;
	/**
	 * 只读. 修改人姓名. modified_user_name
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	private String modifiedUserName;
	/**
	 * 只读. 修改时间. modified_date
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	private Date modifiedDate;
	/**
	 * 只读. 
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	public Long getPlatformId() {
		return platformId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	public void setPlatformId(Long platformId) {
		this.platformId = platformId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	public String getPlatformCode() {
		return platformCode;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	public void setPlatformCode(String platformCode) {
		this.platformCode = platformCode == null ? null : platformCode.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	public String getPlatformName() {
		return platformName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	public void setPlatformName(String platformName) {
		this.platformName = platformName == null ? null : platformName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	public Long getCreateUserId() {
		return createUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	public String getCreateUserName() {
		return createUserName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName == null ? null : createUserName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	public Long getModifiedUserId() {
		return modifiedUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	public void setModifiedUserId(Long modifiedUserId) {
		this.modifiedUserId = modifiedUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	public String getModifiedUserName() {
		return modifiedUserName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	public void setModifiedUserName(String modifiedUserName) {
		this.modifiedUserName = modifiedUserName == null ? null : modifiedUserName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	public Date getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
}