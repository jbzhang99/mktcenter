package com.bizvane.couponservice.common.datavo;

import java.io.Serializable;

public class ReportTempPO implements Serializable {
	
	@io.swagger.annotations.ApiModelProperty(value = "模板名称", name = "templateName", required = false, example = "")
	private String templateName;

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
	
	
	public String getTemplateName() {
		return templateName;
	}
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	public String getReportDataName() {
		return reportDataName;
	}
	public void setReportDataName(String reportDataName) {
		this.reportDataName = reportDataName;
	}
	public String getReportData() {
		return reportData;
	}
	public void setReportData(String reportData) {
		this.reportData = reportData;
	}
	
	
	
}