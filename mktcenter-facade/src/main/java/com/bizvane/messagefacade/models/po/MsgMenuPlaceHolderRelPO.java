package com.bizvane.messagefacade.models.po;

import java.io.Serializable;
import java.util.Date;

public class MsgMenuPlaceHolderRelPO implements Serializable {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_msg_menu_placeholder_rel.msg_menu_placeholder_rel_id
	 * @mbg.generated  Fri Aug 31 14:01:37 CST 2018
	 */
	@io.swagger.annotations.ApiModelProperty(value = "pkid", name = "msgMenuPlaceholderRelId", required = false, example = "")
	private Long msgMenuPlaceholderRelId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_msg_menu_placeholder_rel.sys_company_id
	 * @mbg.generated  Fri Aug 31 14:01:37 CST 2018
	 */
	private Long sysCompanyId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_msg_menu_placeholder_rel.menu_code
	 * @mbg.generated  Fri Aug 31 14:01:37 CST 2018
	 */
	@io.swagger.annotations.ApiModelProperty(value = "菜单编号", name = "menuCode", required = false, example = "")
	private String menuCode;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_msg_menu_placeholder_rel.menu_name
	 * @mbg.generated  Fri Aug 31 14:01:37 CST 2018
	 */
	@io.swagger.annotations.ApiModelProperty(value = "菜单名称", name = "menuName", required = false, example = "")
	private String menuName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_msg_menu_placeholder_rel.msg_placeholder_id
	 * @mbg.generated  Fri Aug 31 14:01:37 CST 2018
	 */
	@io.swagger.annotations.ApiModelProperty(value = "占位符id", name = "msgPlaceholderId", required = false, example = "")
	private Long msgPlaceholderId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_msg_menu_placeholder_rel.remark
	 * @mbg.generated  Fri Aug 31 14:01:37 CST 2018
	 */
	@io.swagger.annotations.ApiModelProperty(value = "备注", name = "remark", required = false, example = "")
	private String remark;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_msg_menu_placeholder_rel.create_user_id
	 * @mbg.generated  Fri Aug 31 14:01:37 CST 2018
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建人id", name = "createUserId", required = false, example = "")
	private Long createUserId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_msg_menu_placeholder_rel.create_user_name
	 * @mbg.generated  Fri Aug 31 14:01:37 CST 2018
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建人", name = "createUserName", required = false, example = "")
	private String createUserName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_msg_menu_placeholder_rel.create_date
	 * @mbg.generated  Fri Aug 31 14:01:37 CST 2018
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建日期", name = "createDate", required = false, example = "")
	private Date createDate;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_msg_menu_placeholder_rel.modified_user_id
	 * @mbg.generated  Fri Aug 31 14:01:37 CST 2018
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改人id", name = "modifiedUserId", required = false, example = "")
	private Long modifiedUserId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_msg_menu_placeholder_rel.modified_user_name
	 * @mbg.generated  Fri Aug 31 14:01:37 CST 2018
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改人", name = "modifiedUserName", required = false, example = "")
	private String modifiedUserName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_msg_menu_placeholder_rel.modified_date
	 * @mbg.generated  Fri Aug 31 14:01:37 CST 2018
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改时间", name = "modifiedDate", required = false, example = "")
	private Date modifiedDate;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_msg_menu_placeholder_rel.valid
	 * @mbg.generated  Fri Aug 31 14:01:37 CST 2018
	 */
	@io.swagger.annotations.ApiModelProperty(value = "数据有效性：1=有效；0=无效", name = "valid", required = false, example = "")
	private Boolean valid;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_msg_menu_placeholder_rel.msg_menu_placeholder_rel_id
	 * @return  the value of t_msg_menu_placeholder_rel.msg_menu_placeholder_rel_id
	 * @mbg.generated  Fri Aug 31 14:01:37 CST 2018
	 */
	public Long getMsgMenuPlaceholderRelId() {
		return msgMenuPlaceholderRelId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_msg_menu_placeholder_rel.msg_menu_placeholder_rel_id
	 * @param msgMenuPlaceholderRelId  the value for t_msg_menu_placeholder_rel.msg_menu_placeholder_rel_id
	 * @mbg.generated  Fri Aug 31 14:01:37 CST 2018
	 */
	public void setMsgMenuPlaceholderRelId(Long msgMenuPlaceholderRelId) {
		this.msgMenuPlaceholderRelId = msgMenuPlaceholderRelId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_msg_menu_placeholder_rel.sys_company_id
	 * @return  the value of t_msg_menu_placeholder_rel.sys_company_id
	 * @mbg.generated  Fri Aug 31 14:01:37 CST 2018
	 */
	public Long getSysCompanyId() {
		return sysCompanyId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_msg_menu_placeholder_rel.sys_company_id
	 * @param sysCompanyId  the value for t_msg_menu_placeholder_rel.sys_company_id
	 * @mbg.generated  Fri Aug 31 14:01:37 CST 2018
	 */
	public void setSysCompanyId(Long sysCompanyId) {
		this.sysCompanyId = sysCompanyId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_msg_menu_placeholder_rel.menu_code
	 * @return  the value of t_msg_menu_placeholder_rel.menu_code
	 * @mbg.generated  Fri Aug 31 14:01:37 CST 2018
	 */
	public String getMenuCode() {
		return menuCode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_msg_menu_placeholder_rel.menu_code
	 * @param menuCode  the value for t_msg_menu_placeholder_rel.menu_code
	 * @mbg.generated  Fri Aug 31 14:01:37 CST 2018
	 */
	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode == null ? null : menuCode.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_msg_menu_placeholder_rel.menu_name
	 * @return  the value of t_msg_menu_placeholder_rel.menu_name
	 * @mbg.generated  Fri Aug 31 14:01:37 CST 2018
	 */
	public String getMenuName() {
		return menuName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_msg_menu_placeholder_rel.menu_name
	 * @param menuName  the value for t_msg_menu_placeholder_rel.menu_name
	 * @mbg.generated  Fri Aug 31 14:01:37 CST 2018
	 */
	public void setMenuName(String menuName) {
		this.menuName = menuName == null ? null : menuName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_msg_menu_placeholder_rel.msg_placeholder_id
	 * @return  the value of t_msg_menu_placeholder_rel.msg_placeholder_id
	 * @mbg.generated  Fri Aug 31 14:01:37 CST 2018
	 */
	public Long getMsgPlaceholderId() {
		return msgPlaceholderId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_msg_menu_placeholder_rel.msg_placeholder_id
	 * @param msgPlaceholderId  the value for t_msg_menu_placeholder_rel.msg_placeholder_id
	 * @mbg.generated  Fri Aug 31 14:01:37 CST 2018
	 */
	public void setMsgPlaceholderId(Long msgPlaceholderId) {
		this.msgPlaceholderId = msgPlaceholderId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_msg_menu_placeholder_rel.remark
	 * @return  the value of t_msg_menu_placeholder_rel.remark
	 * @mbg.generated  Fri Aug 31 14:01:37 CST 2018
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_msg_menu_placeholder_rel.remark
	 * @param remark  the value for t_msg_menu_placeholder_rel.remark
	 * @mbg.generated  Fri Aug 31 14:01:37 CST 2018
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_msg_menu_placeholder_rel.create_user_id
	 * @return  the value of t_msg_menu_placeholder_rel.create_user_id
	 * @mbg.generated  Fri Aug 31 14:01:37 CST 2018
	 */
	public Long getCreateUserId() {
		return createUserId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_msg_menu_placeholder_rel.create_user_id
	 * @param createUserId  the value for t_msg_menu_placeholder_rel.create_user_id
	 * @mbg.generated  Fri Aug 31 14:01:37 CST 2018
	 */
	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_msg_menu_placeholder_rel.create_user_name
	 * @return  the value of t_msg_menu_placeholder_rel.create_user_name
	 * @mbg.generated  Fri Aug 31 14:01:37 CST 2018
	 */
	public String getCreateUserName() {
		return createUserName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_msg_menu_placeholder_rel.create_user_name
	 * @param createUserName  the value for t_msg_menu_placeholder_rel.create_user_name
	 * @mbg.generated  Fri Aug 31 14:01:37 CST 2018
	 */
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName == null ? null : createUserName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_msg_menu_placeholder_rel.create_date
	 * @return  the value of t_msg_menu_placeholder_rel.create_date
	 * @mbg.generated  Fri Aug 31 14:01:37 CST 2018
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_msg_menu_placeholder_rel.create_date
	 * @param createDate  the value for t_msg_menu_placeholder_rel.create_date
	 * @mbg.generated  Fri Aug 31 14:01:37 CST 2018
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_msg_menu_placeholder_rel.modified_user_id
	 * @return  the value of t_msg_menu_placeholder_rel.modified_user_id
	 * @mbg.generated  Fri Aug 31 14:01:37 CST 2018
	 */
	public Long getModifiedUserId() {
		return modifiedUserId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_msg_menu_placeholder_rel.modified_user_id
	 * @param modifiedUserId  the value for t_msg_menu_placeholder_rel.modified_user_id
	 * @mbg.generated  Fri Aug 31 14:01:37 CST 2018
	 */
	public void setModifiedUserId(Long modifiedUserId) {
		this.modifiedUserId = modifiedUserId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_msg_menu_placeholder_rel.modified_user_name
	 * @return  the value of t_msg_menu_placeholder_rel.modified_user_name
	 * @mbg.generated  Fri Aug 31 14:01:37 CST 2018
	 */
	public String getModifiedUserName() {
		return modifiedUserName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_msg_menu_placeholder_rel.modified_user_name
	 * @param modifiedUserName  the value for t_msg_menu_placeholder_rel.modified_user_name
	 * @mbg.generated  Fri Aug 31 14:01:37 CST 2018
	 */
	public void setModifiedUserName(String modifiedUserName) {
		this.modifiedUserName = modifiedUserName == null ? null : modifiedUserName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_msg_menu_placeholder_rel.modified_date
	 * @return  the value of t_msg_menu_placeholder_rel.modified_date
	 * @mbg.generated  Fri Aug 31 14:01:37 CST 2018
	 */
	public Date getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_msg_menu_placeholder_rel.modified_date
	 * @param modifiedDate  the value for t_msg_menu_placeholder_rel.modified_date
	 * @mbg.generated  Fri Aug 31 14:01:37 CST 2018
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_msg_menu_placeholder_rel.valid
	 * @return  the value of t_msg_menu_placeholder_rel.valid
	 * @mbg.generated  Fri Aug 31 14:01:37 CST 2018
	 */
	public Boolean getValid() {
		return valid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_msg_menu_placeholder_rel.valid
	 * @param valid  the value for t_msg_menu_placeholder_rel.valid
	 * @mbg.generated  Fri Aug 31 14:01:37 CST 2018
	 */
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
}