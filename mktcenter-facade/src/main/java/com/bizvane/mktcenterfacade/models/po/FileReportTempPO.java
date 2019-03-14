package com.bizvane.mktcenterfacade.models.po;

import java.io.Serializable;
import java.util.Date;

public class FileReportTempPO implements Serializable {

	/**
	 * 只读. 主键自增. file_report_temp_id
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	@io.swagger.annotations.ApiModelProperty(value = "主键自增", name = "fileReportTempId", required = false, example = "")
	private Long fileReportTempId;
	/**
	 * 只读. 所属企业id. sys_company_id
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	@io.swagger.annotations.ApiModelProperty(value = "所属企业id", name = "sysCompanyId", required = false, example = "")
	private Long sysCompanyId;
	/**
	 * 只读. 所属品牌id. sys_brand_id
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	@io.swagger.annotations.ApiModelProperty(value = "所属品牌id", name = "sysBrandId", required = false, example = "")
	private Long sysBrandId;
	/**
	 * 只读. 模板名称. template_name
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	@io.swagger.annotations.ApiModelProperty(value = "模板名称", name = "templateName", required = false, example = "")
	private String templateName;
	/**
	 * 只读. 模板类型. template_type
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	@io.swagger.annotations.ApiModelProperty(value = "模板类型", name = "templateType", required = false, example = "")
	private String templateType;
	/**
	 * 只读. 维度. template_dimension
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	@io.swagger.annotations.ApiModelProperty(value = "维度", name = "templateDimension", required = false, example = "")
	private String templateDimension;
	/**
	 * 只读. 表头名称. report_data_name
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	@io.swagger.annotations.ApiModelProperty(value = "表头名称", name = "reportDataName", required = false, example = "")
	private String reportDataName;
	/**
	 * 只读. 表头字段. report_data
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	@io.swagger.annotations.ApiModelProperty(value = "表头字段", name = "reportData", required = false, example = "")
	private String reportData;
	/**
	 * 只读. 组织. template_organization
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	@io.swagger.annotations.ApiModelProperty(value = "组织", name = "templateOrganization", required = false, example = "")
	private String templateOrganization;
	/**
	 * 只读. 备注. remark
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	@io.swagger.annotations.ApiModelProperty(value = "备注", name = "remark", required = false, example = "")
	private String remark;
	/**
	 * 只读. 创建人id. create_user_id
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建人id", name = "createUserId", required = false, example = "")
	private Long createUserId;
	/**
	 * 只读. 创建人. create_user_name
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建人", name = "createUserName", required = false, example = "")
	private String createUserName;
	/**
	 * 只读. 创建时间. create_date
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建时间", name = "createDate", required = false, example = "")
	private Date createDate;
	/**
	 * 只读. 修改人id. modified_user_id
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改人id", name = "modifiedUserId", required = false, example = "")
	private Long modifiedUserId;
	/**
	 * 只读. 修改人. modified_user_name
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改人", name = "modifiedUserName", required = false, example = "")
	private String modifiedUserName;
	/**
	 * 只读. 修改时间. modified_date
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改时间", name = "modifiedDate", required = false, example = "")
	private Date modifiedDate;
	/**
	 * 只读. 数据有效性（1有效，0无效）. valid
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	@io.swagger.annotations.ApiModelProperty(value = "数据有效性（1有效，0无效）", name = "valid", required = false, example = "")
	private Boolean valid;
	/**
	 * 只读. 
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	public Long getFileReportTempId() {
		return fileReportTempId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	public void setFileReportTempId(Long fileReportTempId) {
		this.fileReportTempId = fileReportTempId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	public Long getSysCompanyId() {
		return sysCompanyId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	public void setSysCompanyId(Long sysCompanyId) {
		this.sysCompanyId = sysCompanyId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	public Long getSysBrandId() {
		return sysBrandId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	public void setSysBrandId(Long sysBrandId) {
		this.sysBrandId = sysBrandId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	public String getTemplateName() {
		return templateName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	public void setTemplateName(String templateName) {
		this.templateName = templateName == null ? null : templateName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	public String getTemplateType() {
		return templateType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	public void setTemplateType(String templateType) {
		this.templateType = templateType == null ? null : templateType.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	public String getTemplateDimension() {
		return templateDimension;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	public void setTemplateDimension(String templateDimension) {
		this.templateDimension = templateDimension == null ? null : templateDimension.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	public String getReportDataName() {
		return reportDataName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	public void setReportDataName(String reportDataName) {
		this.reportDataName = reportDataName == null ? null : reportDataName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	public String getReportData() {
		return reportData;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	public void setReportData(String reportData) {
		this.reportData = reportData == null ? null : reportData.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	public String getTemplateOrganization() {
		return templateOrganization;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	public void setTemplateOrganization(String templateOrganization) {
		this.templateOrganization = templateOrganization == null ? null : templateOrganization.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	public Long getCreateUserId() {
		return createUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	public String getCreateUserName() {
		return createUserName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName == null ? null : createUserName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	public Long getModifiedUserId() {
		return modifiedUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	public void setModifiedUserId(Long modifiedUserId) {
		this.modifiedUserId = modifiedUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	public String getModifiedUserName() {
		return modifiedUserName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	public void setModifiedUserName(String modifiedUserName) {
		this.modifiedUserName = modifiedUserName == null ? null : modifiedUserName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	public Date getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	public Boolean getValid() {
		return valid;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
}