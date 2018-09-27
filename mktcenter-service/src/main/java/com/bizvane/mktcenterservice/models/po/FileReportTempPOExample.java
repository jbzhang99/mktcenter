package com.bizvane.mktcenterservice.models.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FileReportTempPOExample implements Serializable {
    /**
	 *
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	protected String orderByClause;
	/**
	 *
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	protected boolean distinct;
	/**
	 *
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	protected List<Criteria> oredCriteria;
	/**
	 *
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	private static final long serialVersionUID = 1L;

	/**
	 *
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	public FileReportTempPOExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 *
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 *
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 *
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 *
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 *
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 *
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 *
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 *
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 *
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 *
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 *t_file_report_temp
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	protected abstract static class GeneratedCriteria implements Serializable {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andFileReportTempIdIsNull() {
			addCriterion("file_report_temp_id is null");
			return (Criteria) this;
		}

		public Criteria andFileReportTempIdIsNotNull() {
			addCriterion("file_report_temp_id is not null");
			return (Criteria) this;
		}

		public Criteria andFileReportTempIdEqualTo(Long value) {
			addCriterion("file_report_temp_id =", value, "fileReportTempId");
			return (Criteria) this;
		}

		public Criteria andFileReportTempIdNotEqualTo(Long value) {
			addCriterion("file_report_temp_id <>", value, "fileReportTempId");
			return (Criteria) this;
		}

		public Criteria andFileReportTempIdGreaterThan(Long value) {
			addCriterion("file_report_temp_id >", value, "fileReportTempId");
			return (Criteria) this;
		}

		public Criteria andFileReportTempIdGreaterThanOrEqualTo(Long value) {
			addCriterion("file_report_temp_id >=", value, "fileReportTempId");
			return (Criteria) this;
		}

		public Criteria andFileReportTempIdLessThan(Long value) {
			addCriterion("file_report_temp_id <", value, "fileReportTempId");
			return (Criteria) this;
		}

		public Criteria andFileReportTempIdLessThanOrEqualTo(Long value) {
			addCriterion("file_report_temp_id <=", value, "fileReportTempId");
			return (Criteria) this;
		}

		public Criteria andFileReportTempIdIn(List<Long> values) {
			addCriterion("file_report_temp_id in", values, "fileReportTempId");
			return (Criteria) this;
		}

		public Criteria andFileReportTempIdNotIn(List<Long> values) {
			addCriterion("file_report_temp_id not in", values, "fileReportTempId");
			return (Criteria) this;
		}

		public Criteria andFileReportTempIdBetween(Long value1, Long value2) {
			addCriterion("file_report_temp_id between", value1, value2, "fileReportTempId");
			return (Criteria) this;
		}

		public Criteria andFileReportTempIdNotBetween(Long value1, Long value2) {
			addCriterion("file_report_temp_id not between", value1, value2, "fileReportTempId");
			return (Criteria) this;
		}

		public Criteria andSysCompanyIdIsNull() {
			addCriterion("sys_company_id is null");
			return (Criteria) this;
		}

		public Criteria andSysCompanyIdIsNotNull() {
			addCriterion("sys_company_id is not null");
			return (Criteria) this;
		}

		public Criteria andSysCompanyIdEqualTo(Long value) {
			addCriterion("sys_company_id =", value, "sysCompanyId");
			return (Criteria) this;
		}

		public Criteria andSysCompanyIdNotEqualTo(Long value) {
			addCriterion("sys_company_id <>", value, "sysCompanyId");
			return (Criteria) this;
		}

		public Criteria andSysCompanyIdGreaterThan(Long value) {
			addCriterion("sys_company_id >", value, "sysCompanyId");
			return (Criteria) this;
		}

		public Criteria andSysCompanyIdGreaterThanOrEqualTo(Long value) {
			addCriterion("sys_company_id >=", value, "sysCompanyId");
			return (Criteria) this;
		}

		public Criteria andSysCompanyIdLessThan(Long value) {
			addCriterion("sys_company_id <", value, "sysCompanyId");
			return (Criteria) this;
		}

		public Criteria andSysCompanyIdLessThanOrEqualTo(Long value) {
			addCriterion("sys_company_id <=", value, "sysCompanyId");
			return (Criteria) this;
		}

		public Criteria andSysCompanyIdIn(List<Long> values) {
			addCriterion("sys_company_id in", values, "sysCompanyId");
			return (Criteria) this;
		}

		public Criteria andSysCompanyIdNotIn(List<Long> values) {
			addCriterion("sys_company_id not in", values, "sysCompanyId");
			return (Criteria) this;
		}

		public Criteria andSysCompanyIdBetween(Long value1, Long value2) {
			addCriterion("sys_company_id between", value1, value2, "sysCompanyId");
			return (Criteria) this;
		}

		public Criteria andSysCompanyIdNotBetween(Long value1, Long value2) {
			addCriterion("sys_company_id not between", value1, value2, "sysCompanyId");
			return (Criteria) this;
		}

		public Criteria andSysBrandIdIsNull() {
			addCriterion("sys_brand_id is null");
			return (Criteria) this;
		}

		public Criteria andSysBrandIdIsNotNull() {
			addCriterion("sys_brand_id is not null");
			return (Criteria) this;
		}

		public Criteria andSysBrandIdEqualTo(Long value) {
			addCriterion("sys_brand_id =", value, "sysBrandId");
			return (Criteria) this;
		}

		public Criteria andSysBrandIdNotEqualTo(Long value) {
			addCriterion("sys_brand_id <>", value, "sysBrandId");
			return (Criteria) this;
		}

		public Criteria andSysBrandIdGreaterThan(Long value) {
			addCriterion("sys_brand_id >", value, "sysBrandId");
			return (Criteria) this;
		}

		public Criteria andSysBrandIdGreaterThanOrEqualTo(Long value) {
			addCriterion("sys_brand_id >=", value, "sysBrandId");
			return (Criteria) this;
		}

		public Criteria andSysBrandIdLessThan(Long value) {
			addCriterion("sys_brand_id <", value, "sysBrandId");
			return (Criteria) this;
		}

		public Criteria andSysBrandIdLessThanOrEqualTo(Long value) {
			addCriterion("sys_brand_id <=", value, "sysBrandId");
			return (Criteria) this;
		}

		public Criteria andSysBrandIdIn(List<Long> values) {
			addCriterion("sys_brand_id in", values, "sysBrandId");
			return (Criteria) this;
		}

		public Criteria andSysBrandIdNotIn(List<Long> values) {
			addCriterion("sys_brand_id not in", values, "sysBrandId");
			return (Criteria) this;
		}

		public Criteria andSysBrandIdBetween(Long value1, Long value2) {
			addCriterion("sys_brand_id between", value1, value2, "sysBrandId");
			return (Criteria) this;
		}

		public Criteria andSysBrandIdNotBetween(Long value1, Long value2) {
			addCriterion("sys_brand_id not between", value1, value2, "sysBrandId");
			return (Criteria) this;
		}

		public Criteria andTemplateNameIsNull() {
			addCriterion("template_name is null");
			return (Criteria) this;
		}

		public Criteria andTemplateNameIsNotNull() {
			addCriterion("template_name is not null");
			return (Criteria) this;
		}

		public Criteria andTemplateNameEqualTo(String value) {
			addCriterion("template_name =", value, "templateName");
			return (Criteria) this;
		}

		public Criteria andTemplateNameNotEqualTo(String value) {
			addCriterion("template_name <>", value, "templateName");
			return (Criteria) this;
		}

		public Criteria andTemplateNameGreaterThan(String value) {
			addCriterion("template_name >", value, "templateName");
			return (Criteria) this;
		}

		public Criteria andTemplateNameGreaterThanOrEqualTo(String value) {
			addCriterion("template_name >=", value, "templateName");
			return (Criteria) this;
		}

		public Criteria andTemplateNameLessThan(String value) {
			addCriterion("template_name <", value, "templateName");
			return (Criteria) this;
		}

		public Criteria andTemplateNameLessThanOrEqualTo(String value) {
			addCriterion("template_name <=", value, "templateName");
			return (Criteria) this;
		}

		public Criteria andTemplateNameLike(String value) {
			addCriterion("template_name like", value, "templateName");
			return (Criteria) this;
		}

		public Criteria andTemplateNameNotLike(String value) {
			addCriterion("template_name not like", value, "templateName");
			return (Criteria) this;
		}

		public Criteria andTemplateNameIn(List<String> values) {
			addCriterion("template_name in", values, "templateName");
			return (Criteria) this;
		}

		public Criteria andTemplateNameNotIn(List<String> values) {
			addCriterion("template_name not in", values, "templateName");
			return (Criteria) this;
		}

		public Criteria andTemplateNameBetween(String value1, String value2) {
			addCriterion("template_name between", value1, value2, "templateName");
			return (Criteria) this;
		}

		public Criteria andTemplateNameNotBetween(String value1, String value2) {
			addCriterion("template_name not between", value1, value2, "templateName");
			return (Criteria) this;
		}

		public Criteria andTemplateTypeIsNull() {
			addCriterion("template_type is null");
			return (Criteria) this;
		}

		public Criteria andTemplateTypeIsNotNull() {
			addCriterion("template_type is not null");
			return (Criteria) this;
		}

		public Criteria andTemplateTypeEqualTo(String value) {
			addCriterion("template_type =", value, "templateType");
			return (Criteria) this;
		}

		public Criteria andTemplateTypeNotEqualTo(String value) {
			addCriterion("template_type <>", value, "templateType");
			return (Criteria) this;
		}

		public Criteria andTemplateTypeGreaterThan(String value) {
			addCriterion("template_type >", value, "templateType");
			return (Criteria) this;
		}

		public Criteria andTemplateTypeGreaterThanOrEqualTo(String value) {
			addCriterion("template_type >=", value, "templateType");
			return (Criteria) this;
		}

		public Criteria andTemplateTypeLessThan(String value) {
			addCriterion("template_type <", value, "templateType");
			return (Criteria) this;
		}

		public Criteria andTemplateTypeLessThanOrEqualTo(String value) {
			addCriterion("template_type <=", value, "templateType");
			return (Criteria) this;
		}

		public Criteria andTemplateTypeLike(String value) {
			addCriterion("template_type like", value, "templateType");
			return (Criteria) this;
		}

		public Criteria andTemplateTypeNotLike(String value) {
			addCriterion("template_type not like", value, "templateType");
			return (Criteria) this;
		}

		public Criteria andTemplateTypeIn(List<String> values) {
			addCriterion("template_type in", values, "templateType");
			return (Criteria) this;
		}

		public Criteria andTemplateTypeNotIn(List<String> values) {
			addCriterion("template_type not in", values, "templateType");
			return (Criteria) this;
		}

		public Criteria andTemplateTypeBetween(String value1, String value2) {
			addCriterion("template_type between", value1, value2, "templateType");
			return (Criteria) this;
		}

		public Criteria andTemplateTypeNotBetween(String value1, String value2) {
			addCriterion("template_type not between", value1, value2, "templateType");
			return (Criteria) this;
		}

		public Criteria andTemplateDimensionIsNull() {
			addCriterion("template_dimension is null");
			return (Criteria) this;
		}

		public Criteria andTemplateDimensionIsNotNull() {
			addCriterion("template_dimension is not null");
			return (Criteria) this;
		}

		public Criteria andTemplateDimensionEqualTo(String value) {
			addCriterion("template_dimension =", value, "templateDimension");
			return (Criteria) this;
		}

		public Criteria andTemplateDimensionNotEqualTo(String value) {
			addCriterion("template_dimension <>", value, "templateDimension");
			return (Criteria) this;
		}

		public Criteria andTemplateDimensionGreaterThan(String value) {
			addCriterion("template_dimension >", value, "templateDimension");
			return (Criteria) this;
		}

		public Criteria andTemplateDimensionGreaterThanOrEqualTo(String value) {
			addCriterion("template_dimension >=", value, "templateDimension");
			return (Criteria) this;
		}

		public Criteria andTemplateDimensionLessThan(String value) {
			addCriterion("template_dimension <", value, "templateDimension");
			return (Criteria) this;
		}

		public Criteria andTemplateDimensionLessThanOrEqualTo(String value) {
			addCriterion("template_dimension <=", value, "templateDimension");
			return (Criteria) this;
		}

		public Criteria andTemplateDimensionLike(String value) {
			addCriterion("template_dimension like", value, "templateDimension");
			return (Criteria) this;
		}

		public Criteria andTemplateDimensionNotLike(String value) {
			addCriterion("template_dimension not like", value, "templateDimension");
			return (Criteria) this;
		}

		public Criteria andTemplateDimensionIn(List<String> values) {
			addCriterion("template_dimension in", values, "templateDimension");
			return (Criteria) this;
		}

		public Criteria andTemplateDimensionNotIn(List<String> values) {
			addCriterion("template_dimension not in", values, "templateDimension");
			return (Criteria) this;
		}

		public Criteria andTemplateDimensionBetween(String value1, String value2) {
			addCriterion("template_dimension between", value1, value2, "templateDimension");
			return (Criteria) this;
		}

		public Criteria andTemplateDimensionNotBetween(String value1, String value2) {
			addCriterion("template_dimension not between", value1, value2, "templateDimension");
			return (Criteria) this;
		}

		public Criteria andReportDataNameIsNull() {
			addCriterion("report_data_name is null");
			return (Criteria) this;
		}

		public Criteria andReportDataNameIsNotNull() {
			addCriterion("report_data_name is not null");
			return (Criteria) this;
		}

		public Criteria andReportDataNameEqualTo(String value) {
			addCriterion("report_data_name =", value, "reportDataName");
			return (Criteria) this;
		}

		public Criteria andReportDataNameNotEqualTo(String value) {
			addCriterion("report_data_name <>", value, "reportDataName");
			return (Criteria) this;
		}

		public Criteria andReportDataNameGreaterThan(String value) {
			addCriterion("report_data_name >", value, "reportDataName");
			return (Criteria) this;
		}

		public Criteria andReportDataNameGreaterThanOrEqualTo(String value) {
			addCriterion("report_data_name >=", value, "reportDataName");
			return (Criteria) this;
		}

		public Criteria andReportDataNameLessThan(String value) {
			addCriterion("report_data_name <", value, "reportDataName");
			return (Criteria) this;
		}

		public Criteria andReportDataNameLessThanOrEqualTo(String value) {
			addCriterion("report_data_name <=", value, "reportDataName");
			return (Criteria) this;
		}

		public Criteria andReportDataNameLike(String value) {
			addCriterion("report_data_name like", value, "reportDataName");
			return (Criteria) this;
		}

		public Criteria andReportDataNameNotLike(String value) {
			addCriterion("report_data_name not like", value, "reportDataName");
			return (Criteria) this;
		}

		public Criteria andReportDataNameIn(List<String> values) {
			addCriterion("report_data_name in", values, "reportDataName");
			return (Criteria) this;
		}

		public Criteria andReportDataNameNotIn(List<String> values) {
			addCriterion("report_data_name not in", values, "reportDataName");
			return (Criteria) this;
		}

		public Criteria andReportDataNameBetween(String value1, String value2) {
			addCriterion("report_data_name between", value1, value2, "reportDataName");
			return (Criteria) this;
		}

		public Criteria andReportDataNameNotBetween(String value1, String value2) {
			addCriterion("report_data_name not between", value1, value2, "reportDataName");
			return (Criteria) this;
		}

		public Criteria andReportDataIsNull() {
			addCriterion("report_data is null");
			return (Criteria) this;
		}

		public Criteria andReportDataIsNotNull() {
			addCriterion("report_data is not null");
			return (Criteria) this;
		}

		public Criteria andReportDataEqualTo(String value) {
			addCriterion("report_data =", value, "reportData");
			return (Criteria) this;
		}

		public Criteria andReportDataNotEqualTo(String value) {
			addCriterion("report_data <>", value, "reportData");
			return (Criteria) this;
		}

		public Criteria andReportDataGreaterThan(String value) {
			addCriterion("report_data >", value, "reportData");
			return (Criteria) this;
		}

		public Criteria andReportDataGreaterThanOrEqualTo(String value) {
			addCriterion("report_data >=", value, "reportData");
			return (Criteria) this;
		}

		public Criteria andReportDataLessThan(String value) {
			addCriterion("report_data <", value, "reportData");
			return (Criteria) this;
		}

		public Criteria andReportDataLessThanOrEqualTo(String value) {
			addCriterion("report_data <=", value, "reportData");
			return (Criteria) this;
		}

		public Criteria andReportDataLike(String value) {
			addCriterion("report_data like", value, "reportData");
			return (Criteria) this;
		}

		public Criteria andReportDataNotLike(String value) {
			addCriterion("report_data not like", value, "reportData");
			return (Criteria) this;
		}

		public Criteria andReportDataIn(List<String> values) {
			addCriterion("report_data in", values, "reportData");
			return (Criteria) this;
		}

		public Criteria andReportDataNotIn(List<String> values) {
			addCriterion("report_data not in", values, "reportData");
			return (Criteria) this;
		}

		public Criteria andReportDataBetween(String value1, String value2) {
			addCriterion("report_data between", value1, value2, "reportData");
			return (Criteria) this;
		}

		public Criteria andReportDataNotBetween(String value1, String value2) {
			addCriterion("report_data not between", value1, value2, "reportData");
			return (Criteria) this;
		}

		public Criteria andTemplateOrganizationIsNull() {
			addCriterion("template_organization is null");
			return (Criteria) this;
		}

		public Criteria andTemplateOrganizationIsNotNull() {
			addCriterion("template_organization is not null");
			return (Criteria) this;
		}

		public Criteria andTemplateOrganizationEqualTo(String value) {
			addCriterion("template_organization =", value, "templateOrganization");
			return (Criteria) this;
		}

		public Criteria andTemplateOrganizationNotEqualTo(String value) {
			addCriterion("template_organization <>", value, "templateOrganization");
			return (Criteria) this;
		}

		public Criteria andTemplateOrganizationGreaterThan(String value) {
			addCriterion("template_organization >", value, "templateOrganization");
			return (Criteria) this;
		}

		public Criteria andTemplateOrganizationGreaterThanOrEqualTo(String value) {
			addCriterion("template_organization >=", value, "templateOrganization");
			return (Criteria) this;
		}

		public Criteria andTemplateOrganizationLessThan(String value) {
			addCriterion("template_organization <", value, "templateOrganization");
			return (Criteria) this;
		}

		public Criteria andTemplateOrganizationLessThanOrEqualTo(String value) {
			addCriterion("template_organization <=", value, "templateOrganization");
			return (Criteria) this;
		}

		public Criteria andTemplateOrganizationLike(String value) {
			addCriterion("template_organization like", value, "templateOrganization");
			return (Criteria) this;
		}

		public Criteria andTemplateOrganizationNotLike(String value) {
			addCriterion("template_organization not like", value, "templateOrganization");
			return (Criteria) this;
		}

		public Criteria andTemplateOrganizationIn(List<String> values) {
			addCriterion("template_organization in", values, "templateOrganization");
			return (Criteria) this;
		}

		public Criteria andTemplateOrganizationNotIn(List<String> values) {
			addCriterion("template_organization not in", values, "templateOrganization");
			return (Criteria) this;
		}

		public Criteria andTemplateOrganizationBetween(String value1, String value2) {
			addCriterion("template_organization between", value1, value2, "templateOrganization");
			return (Criteria) this;
		}

		public Criteria andTemplateOrganizationNotBetween(String value1, String value2) {
			addCriterion("template_organization not between", value1, value2, "templateOrganization");
			return (Criteria) this;
		}

		public Criteria andRemarkIsNull() {
			addCriterion("remark is null");
			return (Criteria) this;
		}

		public Criteria andRemarkIsNotNull() {
			addCriterion("remark is not null");
			return (Criteria) this;
		}

		public Criteria andRemarkEqualTo(String value) {
			addCriterion("remark =", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotEqualTo(String value) {
			addCriterion("remark <>", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkGreaterThan(String value) {
			addCriterion("remark >", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkGreaterThanOrEqualTo(String value) {
			addCriterion("remark >=", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkLessThan(String value) {
			addCriterion("remark <", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkLessThanOrEqualTo(String value) {
			addCriterion("remark <=", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkLike(String value) {
			addCriterion("remark like", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotLike(String value) {
			addCriterion("remark not like", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkIn(List<String> values) {
			addCriterion("remark in", values, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotIn(List<String> values) {
			addCriterion("remark not in", values, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkBetween(String value1, String value2) {
			addCriterion("remark between", value1, value2, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotBetween(String value1, String value2) {
			addCriterion("remark not between", value1, value2, "remark");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdIsNull() {
			addCriterion("create_user_id is null");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdIsNotNull() {
			addCriterion("create_user_id is not null");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdEqualTo(Long value) {
			addCriterion("create_user_id =", value, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdNotEqualTo(Long value) {
			addCriterion("create_user_id <>", value, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdGreaterThan(Long value) {
			addCriterion("create_user_id >", value, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdGreaterThanOrEqualTo(Long value) {
			addCriterion("create_user_id >=", value, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdLessThan(Long value) {
			addCriterion("create_user_id <", value, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdLessThanOrEqualTo(Long value) {
			addCriterion("create_user_id <=", value, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdIn(List<Long> values) {
			addCriterion("create_user_id in", values, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdNotIn(List<Long> values) {
			addCriterion("create_user_id not in", values, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdBetween(Long value1, Long value2) {
			addCriterion("create_user_id between", value1, value2, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdNotBetween(Long value1, Long value2) {
			addCriterion("create_user_id not between", value1, value2, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserNameIsNull() {
			addCriterion("create_user_name is null");
			return (Criteria) this;
		}

		public Criteria andCreateUserNameIsNotNull() {
			addCriterion("create_user_name is not null");
			return (Criteria) this;
		}

		public Criteria andCreateUserNameEqualTo(String value) {
			addCriterion("create_user_name =", value, "createUserName");
			return (Criteria) this;
		}

		public Criteria andCreateUserNameNotEqualTo(String value) {
			addCriterion("create_user_name <>", value, "createUserName");
			return (Criteria) this;
		}

		public Criteria andCreateUserNameGreaterThan(String value) {
			addCriterion("create_user_name >", value, "createUserName");
			return (Criteria) this;
		}

		public Criteria andCreateUserNameGreaterThanOrEqualTo(String value) {
			addCriterion("create_user_name >=", value, "createUserName");
			return (Criteria) this;
		}

		public Criteria andCreateUserNameLessThan(String value) {
			addCriterion("create_user_name <", value, "createUserName");
			return (Criteria) this;
		}

		public Criteria andCreateUserNameLessThanOrEqualTo(String value) {
			addCriterion("create_user_name <=", value, "createUserName");
			return (Criteria) this;
		}

		public Criteria andCreateUserNameLike(String value) {
			addCriterion("create_user_name like", value, "createUserName");
			return (Criteria) this;
		}

		public Criteria andCreateUserNameNotLike(String value) {
			addCriterion("create_user_name not like", value, "createUserName");
			return (Criteria) this;
		}

		public Criteria andCreateUserNameIn(List<String> values) {
			addCriterion("create_user_name in", values, "createUserName");
			return (Criteria) this;
		}

		public Criteria andCreateUserNameNotIn(List<String> values) {
			addCriterion("create_user_name not in", values, "createUserName");
			return (Criteria) this;
		}

		public Criteria andCreateUserNameBetween(String value1, String value2) {
			addCriterion("create_user_name between", value1, value2, "createUserName");
			return (Criteria) this;
		}

		public Criteria andCreateUserNameNotBetween(String value1, String value2) {
			addCriterion("create_user_name not between", value1, value2, "createUserName");
			return (Criteria) this;
		}

		public Criteria andCreateDateIsNull() {
			addCriterion("create_date is null");
			return (Criteria) this;
		}

		public Criteria andCreateDateIsNotNull() {
			addCriterion("create_date is not null");
			return (Criteria) this;
		}

		public Criteria andCreateDateEqualTo(Date value) {
			addCriterion("create_date =", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateNotEqualTo(Date value) {
			addCriterion("create_date <>", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateGreaterThan(Date value) {
			addCriterion("create_date >", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
			addCriterion("create_date >=", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateLessThan(Date value) {
			addCriterion("create_date <", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateLessThanOrEqualTo(Date value) {
			addCriterion("create_date <=", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateIn(List<Date> values) {
			addCriterion("create_date in", values, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateNotIn(List<Date> values) {
			addCriterion("create_date not in", values, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateBetween(Date value1, Date value2) {
			addCriterion("create_date between", value1, value2, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateNotBetween(Date value1, Date value2) {
			addCriterion("create_date not between", value1, value2, "createDate");
			return (Criteria) this;
		}

		public Criteria andModifiedUserIdIsNull() {
			addCriterion("modified_user_id is null");
			return (Criteria) this;
		}

		public Criteria andModifiedUserIdIsNotNull() {
			addCriterion("modified_user_id is not null");
			return (Criteria) this;
		}

		public Criteria andModifiedUserIdEqualTo(Long value) {
			addCriterion("modified_user_id =", value, "modifiedUserId");
			return (Criteria) this;
		}

		public Criteria andModifiedUserIdNotEqualTo(Long value) {
			addCriterion("modified_user_id <>", value, "modifiedUserId");
			return (Criteria) this;
		}

		public Criteria andModifiedUserIdGreaterThan(Long value) {
			addCriterion("modified_user_id >", value, "modifiedUserId");
			return (Criteria) this;
		}

		public Criteria andModifiedUserIdGreaterThanOrEqualTo(Long value) {
			addCriterion("modified_user_id >=", value, "modifiedUserId");
			return (Criteria) this;
		}

		public Criteria andModifiedUserIdLessThan(Long value) {
			addCriterion("modified_user_id <", value, "modifiedUserId");
			return (Criteria) this;
		}

		public Criteria andModifiedUserIdLessThanOrEqualTo(Long value) {
			addCriterion("modified_user_id <=", value, "modifiedUserId");
			return (Criteria) this;
		}

		public Criteria andModifiedUserIdIn(List<Long> values) {
			addCriterion("modified_user_id in", values, "modifiedUserId");
			return (Criteria) this;
		}

		public Criteria andModifiedUserIdNotIn(List<Long> values) {
			addCriterion("modified_user_id not in", values, "modifiedUserId");
			return (Criteria) this;
		}

		public Criteria andModifiedUserIdBetween(Long value1, Long value2) {
			addCriterion("modified_user_id between", value1, value2, "modifiedUserId");
			return (Criteria) this;
		}

		public Criteria andModifiedUserIdNotBetween(Long value1, Long value2) {
			addCriterion("modified_user_id not between", value1, value2, "modifiedUserId");
			return (Criteria) this;
		}

		public Criteria andModifiedUserNameIsNull() {
			addCriterion("modified_user_name is null");
			return (Criteria) this;
		}

		public Criteria andModifiedUserNameIsNotNull() {
			addCriterion("modified_user_name is not null");
			return (Criteria) this;
		}

		public Criteria andModifiedUserNameEqualTo(String value) {
			addCriterion("modified_user_name =", value, "modifiedUserName");
			return (Criteria) this;
		}

		public Criteria andModifiedUserNameNotEqualTo(String value) {
			addCriterion("modified_user_name <>", value, "modifiedUserName");
			return (Criteria) this;
		}

		public Criteria andModifiedUserNameGreaterThan(String value) {
			addCriterion("modified_user_name >", value, "modifiedUserName");
			return (Criteria) this;
		}

		public Criteria andModifiedUserNameGreaterThanOrEqualTo(String value) {
			addCriterion("modified_user_name >=", value, "modifiedUserName");
			return (Criteria) this;
		}

		public Criteria andModifiedUserNameLessThan(String value) {
			addCriterion("modified_user_name <", value, "modifiedUserName");
			return (Criteria) this;
		}

		public Criteria andModifiedUserNameLessThanOrEqualTo(String value) {
			addCriterion("modified_user_name <=", value, "modifiedUserName");
			return (Criteria) this;
		}

		public Criteria andModifiedUserNameLike(String value) {
			addCriterion("modified_user_name like", value, "modifiedUserName");
			return (Criteria) this;
		}

		public Criteria andModifiedUserNameNotLike(String value) {
			addCriterion("modified_user_name not like", value, "modifiedUserName");
			return (Criteria) this;
		}

		public Criteria andModifiedUserNameIn(List<String> values) {
			addCriterion("modified_user_name in", values, "modifiedUserName");
			return (Criteria) this;
		}

		public Criteria andModifiedUserNameNotIn(List<String> values) {
			addCriterion("modified_user_name not in", values, "modifiedUserName");
			return (Criteria) this;
		}

		public Criteria andModifiedUserNameBetween(String value1, String value2) {
			addCriterion("modified_user_name between", value1, value2, "modifiedUserName");
			return (Criteria) this;
		}

		public Criteria andModifiedUserNameNotBetween(String value1, String value2) {
			addCriterion("modified_user_name not between", value1, value2, "modifiedUserName");
			return (Criteria) this;
		}

		public Criteria andModifiedDateIsNull() {
			addCriterion("modified_date is null");
			return (Criteria) this;
		}

		public Criteria andModifiedDateIsNotNull() {
			addCriterion("modified_date is not null");
			return (Criteria) this;
		}

		public Criteria andModifiedDateEqualTo(Date value) {
			addCriterion("modified_date =", value, "modifiedDate");
			return (Criteria) this;
		}

		public Criteria andModifiedDateNotEqualTo(Date value) {
			addCriterion("modified_date <>", value, "modifiedDate");
			return (Criteria) this;
		}

		public Criteria andModifiedDateGreaterThan(Date value) {
			addCriterion("modified_date >", value, "modifiedDate");
			return (Criteria) this;
		}

		public Criteria andModifiedDateGreaterThanOrEqualTo(Date value) {
			addCriterion("modified_date >=", value, "modifiedDate");
			return (Criteria) this;
		}

		public Criteria andModifiedDateLessThan(Date value) {
			addCriterion("modified_date <", value, "modifiedDate");
			return (Criteria) this;
		}

		public Criteria andModifiedDateLessThanOrEqualTo(Date value) {
			addCriterion("modified_date <=", value, "modifiedDate");
			return (Criteria) this;
		}

		public Criteria andModifiedDateIn(List<Date> values) {
			addCriterion("modified_date in", values, "modifiedDate");
			return (Criteria) this;
		}

		public Criteria andModifiedDateNotIn(List<Date> values) {
			addCriterion("modified_date not in", values, "modifiedDate");
			return (Criteria) this;
		}

		public Criteria andModifiedDateBetween(Date value1, Date value2) {
			addCriterion("modified_date between", value1, value2, "modifiedDate");
			return (Criteria) this;
		}

		public Criteria andModifiedDateNotBetween(Date value1, Date value2) {
			addCriterion("modified_date not between", value1, value2, "modifiedDate");
			return (Criteria) this;
		}

		public Criteria andValidIsNull() {
			addCriterion("valid is null");
			return (Criteria) this;
		}

		public Criteria andValidIsNotNull() {
			addCriterion("valid is not null");
			return (Criteria) this;
		}

		public Criteria andValidEqualTo(Boolean value) {
			addCriterion("valid =", value, "valid");
			return (Criteria) this;
		}

		public Criteria andValidNotEqualTo(Boolean value) {
			addCriterion("valid <>", value, "valid");
			return (Criteria) this;
		}

		public Criteria andValidGreaterThan(Boolean value) {
			addCriterion("valid >", value, "valid");
			return (Criteria) this;
		}

		public Criteria andValidGreaterThanOrEqualTo(Boolean value) {
			addCriterion("valid >=", value, "valid");
			return (Criteria) this;
		}

		public Criteria andValidLessThan(Boolean value) {
			addCriterion("valid <", value, "valid");
			return (Criteria) this;
		}

		public Criteria andValidLessThanOrEqualTo(Boolean value) {
			addCriterion("valid <=", value, "valid");
			return (Criteria) this;
		}

		public Criteria andValidIn(List<Boolean> values) {
			addCriterion("valid in", values, "valid");
			return (Criteria) this;
		}

		public Criteria andValidNotIn(List<Boolean> values) {
			addCriterion("valid not in", values, "valid");
			return (Criteria) this;
		}

		public Criteria andValidBetween(Boolean value1, Boolean value2) {
			addCriterion("valid between", value1, value2, "valid");
			return (Criteria) this;
		}

		public Criteria andValidNotBetween(Boolean value1, Boolean value2) {
			addCriterion("valid not between", value1, value2, "valid");
			return (Criteria) this;
		}
	}

	/**
	 *t_file_report_temp
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	public static class Criterion implements Serializable {
		private String condition;
		private Object value;
		private Object secondValue;
		private boolean noValue;
		private boolean singleValue;
		private boolean betweenValue;
		private boolean listValue;
		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}

	/**9
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_file_report_temp
     *
     * @mbg.generated do_not_delete_during_merge 2018-09-19 16:48:11
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }
}