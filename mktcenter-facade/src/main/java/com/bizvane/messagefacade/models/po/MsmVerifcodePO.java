package com.bizvane.messagefacade.models.po;

import java.io.Serializable;
import java.util.Date;

public class MsmVerifcodePO implements Serializable {

	/**
	 * 只读. id. verifcode_id
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	private Long verifcodeId;
	/**
	 * 只读. 手机号. phone
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	private String phone;
	/**
	 * 只读. 验证码. verif_code
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	private String verifCode;
	/**
	 * 只读. 平台名称. platform
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	private String platform;
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
	public Long getVerifcodeId() {
		return verifcodeId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	public void setVerifcodeId(Long verifcodeId) {
		this.verifcodeId = verifcodeId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	public String getVerifCode() {
		return verifCode;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	public void setVerifCode(String verifCode) {
		this.verifCode = verifCode == null ? null : verifCode.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	public String getPlatform() {
		return platform;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	public void setPlatform(String platform) {
		this.platform = platform == null ? null : platform.trim();
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