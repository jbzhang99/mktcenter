package com.bizvane.mktcenterservice.models.po;

import java.io.Serializable;
import java.util.Date;

public class FileReportTempPO implements Serializable {

	/**
	 * ֻ��. ��������. file_report_temp_id
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	@io.swagger.annotations.ApiModelProperty(value = "��������", name = "fileReportTempId", required = false, example = "")
	private Long fileReportTempId;
	/**
	 * ֻ��. ������ҵid. sys_company_id
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	@io.swagger.annotations.ApiModelProperty(value = "������ҵid", name = "sysCompanyId", required = false, example = "")
	private Long sysCompanyId;
	/**
	 * ֻ��. ����Ʒ��id. sys_brand_id
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	@io.swagger.annotations.ApiModelProperty(value = "����Ʒ��id", name = "sysBrandId", required = false, example = "")
	private Long sysBrandId;
	/**
	 * ֻ��. ģ������. template_name
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	@io.swagger.annotations.ApiModelProperty(value = "ģ������", name = "templateName", required = false, example = "")
	private String templateName;
	/**
	 * ֻ��. ģ������. template_type
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	@io.swagger.annotations.ApiModelProperty(value = "ģ������", name = "templateType", required = false, example = "")
	private String templateType;
	/**
	 * ֻ��. ά��. template_dimension
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	@io.swagger.annotations.ApiModelProperty(value = "ά��", name = "templateDimension", required = false, example = "")
	private String templateDimension;
	/**
	 * ֻ��. ��ͷ����. report_data_name
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	@io.swagger.annotations.ApiModelProperty(value = "��ͷ����", name = "reportDataName", required = false, example = "")
	private String reportDataName;
	/**
	 * ֻ��. ��ͷ�ֶ�. report_data
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	@io.swagger.annotations.ApiModelProperty(value = "��ͷ�ֶ�", name = "reportData", required = false, example = "")
	private String reportData;
	/**
	 * ֻ��. ��֯. template_organization
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	@io.swagger.annotations.ApiModelProperty(value = "��֯", name = "templateOrganization", required = false, example = "")
	private String templateOrganization;
	/**
	 * ֻ��. ��ע. remark
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	@io.swagger.annotations.ApiModelProperty(value = "��ע", name = "remark", required = false, example = "")
	private String remark;
	/**
	 * ֻ��. ������id. create_user_id
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	@io.swagger.annotations.ApiModelProperty(value = "������id", name = "createUserId", required = false, example = "")
	private Long createUserId;
	/**
	 * ֻ��. ������. create_user_name
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	@io.swagger.annotations.ApiModelProperty(value = "������", name = "createUserName", required = false, example = "")
	private String createUserName;
	/**
	 * ֻ��. ����ʱ��. create_date
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	@io.swagger.annotations.ApiModelProperty(value = "����ʱ��", name = "createDate", required = false, example = "")
	private Date createDate;
	/**
	 * ֻ��. �޸���id. modified_user_id
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	@io.swagger.annotations.ApiModelProperty(value = "�޸���id", name = "modifiedUserId", required = false, example = "")
	private Long modifiedUserId;
	/**
	 * ֻ��. �޸���. modified_user_name
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	@io.swagger.annotations.ApiModelProperty(value = "�޸���", name = "modifiedUserName", required = false, example = "")
	private String modifiedUserName;
	/**
	 * ֻ��. �޸�ʱ��. modified_date
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	@io.swagger.annotations.ApiModelProperty(value = "�޸�ʱ��", name = "modifiedDate", required = false, example = "")
	private Date modifiedDate;
	/**
	 * ֻ��. ������Ч�ԣ�1��Ч��0��Ч��. valid
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	@io.swagger.annotations.ApiModelProperty(value = "������Ч�ԣ�1��Ч��0��Ч��", name = "valid", required = false, example = "")
	private Boolean valid;
	/**
	 * ֻ��. 
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	public Long getFileReportTempId() {
		return fileReportTempId;
	}

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	public void setFileReportTempId(Long fileReportTempId) {
		this.fileReportTempId = fileReportTempId;
	}

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	public Long getSysCompanyId() {
		return sysCompanyId;
	}

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	public void setSysCompanyId(Long sysCompanyId) {
		this.sysCompanyId = sysCompanyId;
	}

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	public Long getSysBrandId() {
		return sysBrandId;
	}

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	public void setSysBrandId(Long sysBrandId) {
		this.sysBrandId = sysBrandId;
	}

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	public String getTemplateName() {
		return templateName;
	}

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	public void setTemplateName(String templateName) {
		this.templateName = templateName == null ? null : templateName.trim();
	}

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	public String getTemplateType() {
		return templateType;
	}

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	public void setTemplateType(String templateType) {
		this.templateType = templateType == null ? null : templateType.trim();
	}

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	public String getTemplateDimension() {
		return templateDimension;
	}

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	public void setTemplateDimension(String templateDimension) {
		this.templateDimension = templateDimension == null ? null : templateDimension.trim();
	}

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	public String getReportDataName() {
		return reportDataName;
	}

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	public void setReportDataName(String reportDataName) {
		this.reportDataName = reportDataName == null ? null : reportDataName.trim();
	}

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	public String getReportData() {
		return reportData;
	}

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	public void setReportData(String reportData) {
		this.reportData = reportData == null ? null : reportData.trim();
	}

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	public String getTemplateOrganization() {
		return templateOrganization;
	}

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	public void setTemplateOrganization(String templateOrganization) {
		this.templateOrganization = templateOrganization == null ? null : templateOrganization.trim();
	}

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	public Long getCreateUserId() {
		return createUserId;
	}

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	public String getCreateUserName() {
		return createUserName;
	}

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName == null ? null : createUserName.trim();
	}

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	public Long getModifiedUserId() {
		return modifiedUserId;
	}

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	public void setModifiedUserId(Long modifiedUserId) {
		this.modifiedUserId = modifiedUserId;
	}

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	public String getModifiedUserName() {
		return modifiedUserName;
	}

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	public void setModifiedUserName(String modifiedUserName) {
		this.modifiedUserName = modifiedUserName == null ? null : modifiedUserName.trim();
	}

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	public Date getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	public Boolean getValid() {
		return valid;
	}

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
}