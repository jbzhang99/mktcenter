package com.bizvane.couponfacade.models.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CouponDefinitionCodePOExample implements Serializable {
    /**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	protected String orderByClause;
	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	protected boolean distinct;
	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	protected List<Criteria> oredCriteria;
	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	public CouponDefinitionCodePOExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * 只读. t_coupon_definition_code
	 * @mbg.generated  2019-03-11 16:34:48
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

		public Criteria andCouponDefinitionCodeIdIsNull() {
			addCriterion("coupon_definition_code_id is null");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionCodeIdIsNotNull() {
			addCriterion("coupon_definition_code_id is not null");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionCodeIdEqualTo(Long value) {
			addCriterion("coupon_definition_code_id =", value, "couponDefinitionCodeId");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionCodeIdNotEqualTo(Long value) {
			addCriterion("coupon_definition_code_id <>", value, "couponDefinitionCodeId");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionCodeIdGreaterThan(Long value) {
			addCriterion("coupon_definition_code_id >", value, "couponDefinitionCodeId");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionCodeIdGreaterThanOrEqualTo(Long value) {
			addCriterion("coupon_definition_code_id >=", value, "couponDefinitionCodeId");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionCodeIdLessThan(Long value) {
			addCriterion("coupon_definition_code_id <", value, "couponDefinitionCodeId");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionCodeIdLessThanOrEqualTo(Long value) {
			addCriterion("coupon_definition_code_id <=", value, "couponDefinitionCodeId");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionCodeIdIn(List<Long> values) {
			addCriterion("coupon_definition_code_id in", values, "couponDefinitionCodeId");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionCodeIdNotIn(List<Long> values) {
			addCriterion("coupon_definition_code_id not in", values, "couponDefinitionCodeId");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionCodeIdBetween(Long value1, Long value2) {
			addCriterion("coupon_definition_code_id between", value1, value2, "couponDefinitionCodeId");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionCodeIdNotBetween(Long value1, Long value2) {
			addCriterion("coupon_definition_code_id not between", value1, value2, "couponDefinitionCodeId");
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

		public Criteria andBrandCodeIsNull() {
			addCriterion("brand_code is null");
			return (Criteria) this;
		}

		public Criteria andBrandCodeIsNotNull() {
			addCriterion("brand_code is not null");
			return (Criteria) this;
		}

		public Criteria andBrandCodeEqualTo(String value) {
			addCriterion("brand_code =", value, "brandCode");
			return (Criteria) this;
		}

		public Criteria andBrandCodeNotEqualTo(String value) {
			addCriterion("brand_code <>", value, "brandCode");
			return (Criteria) this;
		}

		public Criteria andBrandCodeGreaterThan(String value) {
			addCriterion("brand_code >", value, "brandCode");
			return (Criteria) this;
		}

		public Criteria andBrandCodeGreaterThanOrEqualTo(String value) {
			addCriterion("brand_code >=", value, "brandCode");
			return (Criteria) this;
		}

		public Criteria andBrandCodeLessThan(String value) {
			addCriterion("brand_code <", value, "brandCode");
			return (Criteria) this;
		}

		public Criteria andBrandCodeLessThanOrEqualTo(String value) {
			addCriterion("brand_code <=", value, "brandCode");
			return (Criteria) this;
		}

		public Criteria andBrandCodeLike(String value) {
			addCriterion("brand_code like", value, "brandCode");
			return (Criteria) this;
		}

		public Criteria andBrandCodeNotLike(String value) {
			addCriterion("brand_code not like", value, "brandCode");
			return (Criteria) this;
		}

		public Criteria andBrandCodeIn(List<String> values) {
			addCriterion("brand_code in", values, "brandCode");
			return (Criteria) this;
		}

		public Criteria andBrandCodeNotIn(List<String> values) {
			addCriterion("brand_code not in", values, "brandCode");
			return (Criteria) this;
		}

		public Criteria andBrandCodeBetween(String value1, String value2) {
			addCriterion("brand_code between", value1, value2, "brandCode");
			return (Criteria) this;
		}

		public Criteria andBrandCodeNotBetween(String value1, String value2) {
			addCriterion("brand_code not between", value1, value2, "brandCode");
			return (Criteria) this;
		}

		public Criteria andCouponCodeIsNull() {
			addCriterion("coupon_code is null");
			return (Criteria) this;
		}

		public Criteria andCouponCodeIsNotNull() {
			addCriterion("coupon_code is not null");
			return (Criteria) this;
		}

		public Criteria andCouponCodeEqualTo(String value) {
			addCriterion("coupon_code =", value, "couponCode");
			return (Criteria) this;
		}

		public Criteria andCouponCodeNotEqualTo(String value) {
			addCriterion("coupon_code <>", value, "couponCode");
			return (Criteria) this;
		}

		public Criteria andCouponCodeGreaterThan(String value) {
			addCriterion("coupon_code >", value, "couponCode");
			return (Criteria) this;
		}

		public Criteria andCouponCodeGreaterThanOrEqualTo(String value) {
			addCriterion("coupon_code >=", value, "couponCode");
			return (Criteria) this;
		}

		public Criteria andCouponCodeLessThan(String value) {
			addCriterion("coupon_code <", value, "couponCode");
			return (Criteria) this;
		}

		public Criteria andCouponCodeLessThanOrEqualTo(String value) {
			addCriterion("coupon_code <=", value, "couponCode");
			return (Criteria) this;
		}

		public Criteria andCouponCodeLike(String value) {
			addCriterion("coupon_code like", value, "couponCode");
			return (Criteria) this;
		}

		public Criteria andCouponCodeNotLike(String value) {
			addCriterion("coupon_code not like", value, "couponCode");
			return (Criteria) this;
		}

		public Criteria andCouponCodeIn(List<String> values) {
			addCriterion("coupon_code in", values, "couponCode");
			return (Criteria) this;
		}

		public Criteria andCouponCodeNotIn(List<String> values) {
			addCriterion("coupon_code not in", values, "couponCode");
			return (Criteria) this;
		}

		public Criteria andCouponCodeBetween(String value1, String value2) {
			addCriterion("coupon_code between", value1, value2, "couponCode");
			return (Criteria) this;
		}

		public Criteria andCouponCodeNotBetween(String value1, String value2) {
			addCriterion("coupon_code not between", value1, value2, "couponCode");
			return (Criteria) this;
		}

		public Criteria andCouponNameIsNull() {
			addCriterion("coupon_name is null");
			return (Criteria) this;
		}

		public Criteria andCouponNameIsNotNull() {
			addCriterion("coupon_name is not null");
			return (Criteria) this;
		}

		public Criteria andCouponNameEqualTo(String value) {
			addCriterion("coupon_name =", value, "couponName");
			return (Criteria) this;
		}

		public Criteria andCouponNameNotEqualTo(String value) {
			addCriterion("coupon_name <>", value, "couponName");
			return (Criteria) this;
		}

		public Criteria andCouponNameGreaterThan(String value) {
			addCriterion("coupon_name >", value, "couponName");
			return (Criteria) this;
		}

		public Criteria andCouponNameGreaterThanOrEqualTo(String value) {
			addCriterion("coupon_name >=", value, "couponName");
			return (Criteria) this;
		}

		public Criteria andCouponNameLessThan(String value) {
			addCriterion("coupon_name <", value, "couponName");
			return (Criteria) this;
		}

		public Criteria andCouponNameLessThanOrEqualTo(String value) {
			addCriterion("coupon_name <=", value, "couponName");
			return (Criteria) this;
		}

		public Criteria andCouponNameLike(String value) {
			addCriterion("coupon_name like", value, "couponName");
			return (Criteria) this;
		}

		public Criteria andCouponNameNotLike(String value) {
			addCriterion("coupon_name not like", value, "couponName");
			return (Criteria) this;
		}

		public Criteria andCouponNameIn(List<String> values) {
			addCriterion("coupon_name in", values, "couponName");
			return (Criteria) this;
		}

		public Criteria andCouponNameNotIn(List<String> values) {
			addCriterion("coupon_name not in", values, "couponName");
			return (Criteria) this;
		}

		public Criteria andCouponNameBetween(String value1, String value2) {
			addCriterion("coupon_name between", value1, value2, "couponName");
			return (Criteria) this;
		}

		public Criteria andCouponNameNotBetween(String value1, String value2) {
			addCriterion("coupon_name not between", value1, value2, "couponName");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionIdIsNull() {
			addCriterion("coupon_definition_id is null");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionIdIsNotNull() {
			addCriterion("coupon_definition_id is not null");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionIdEqualTo(Long value) {
			addCriterion("coupon_definition_id =", value, "couponDefinitionId");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionIdNotEqualTo(Long value) {
			addCriterion("coupon_definition_id <>", value, "couponDefinitionId");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionIdGreaterThan(Long value) {
			addCriterion("coupon_definition_id >", value, "couponDefinitionId");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionIdGreaterThanOrEqualTo(Long value) {
			addCriterion("coupon_definition_id >=", value, "couponDefinitionId");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionIdLessThan(Long value) {
			addCriterion("coupon_definition_id <", value, "couponDefinitionId");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionIdLessThanOrEqualTo(Long value) {
			addCriterion("coupon_definition_id <=", value, "couponDefinitionId");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionIdIn(List<Long> values) {
			addCriterion("coupon_definition_id in", values, "couponDefinitionId");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionIdNotIn(List<Long> values) {
			addCriterion("coupon_definition_id not in", values, "couponDefinitionId");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionIdBetween(Long value1, Long value2) {
			addCriterion("coupon_definition_id between", value1, value2, "couponDefinitionId");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionIdNotBetween(Long value1, Long value2) {
			addCriterion("coupon_definition_id not between", value1, value2, "couponDefinitionId");
			return (Criteria) this;
		}

		public Criteria andErpCouponDefinitionCodeIsNull() {
			addCriterion("erp_coupon_definition_code is null");
			return (Criteria) this;
		}

		public Criteria andErpCouponDefinitionCodeIsNotNull() {
			addCriterion("erp_coupon_definition_code is not null");
			return (Criteria) this;
		}

		public Criteria andErpCouponDefinitionCodeEqualTo(String value) {
			addCriterion("erp_coupon_definition_code =", value, "erpCouponDefinitionCode");
			return (Criteria) this;
		}

		public Criteria andErpCouponDefinitionCodeNotEqualTo(String value) {
			addCriterion("erp_coupon_definition_code <>", value, "erpCouponDefinitionCode");
			return (Criteria) this;
		}

		public Criteria andErpCouponDefinitionCodeGreaterThan(String value) {
			addCriterion("erp_coupon_definition_code >", value, "erpCouponDefinitionCode");
			return (Criteria) this;
		}

		public Criteria andErpCouponDefinitionCodeGreaterThanOrEqualTo(String value) {
			addCriterion("erp_coupon_definition_code >=", value, "erpCouponDefinitionCode");
			return (Criteria) this;
		}

		public Criteria andErpCouponDefinitionCodeLessThan(String value) {
			addCriterion("erp_coupon_definition_code <", value, "erpCouponDefinitionCode");
			return (Criteria) this;
		}

		public Criteria andErpCouponDefinitionCodeLessThanOrEqualTo(String value) {
			addCriterion("erp_coupon_definition_code <=", value, "erpCouponDefinitionCode");
			return (Criteria) this;
		}

		public Criteria andErpCouponDefinitionCodeLike(String value) {
			addCriterion("erp_coupon_definition_code like", value, "erpCouponDefinitionCode");
			return (Criteria) this;
		}

		public Criteria andErpCouponDefinitionCodeNotLike(String value) {
			addCriterion("erp_coupon_definition_code not like", value, "erpCouponDefinitionCode");
			return (Criteria) this;
		}

		public Criteria andErpCouponDefinitionCodeIn(List<String> values) {
			addCriterion("erp_coupon_definition_code in", values, "erpCouponDefinitionCode");
			return (Criteria) this;
		}

		public Criteria andErpCouponDefinitionCodeNotIn(List<String> values) {
			addCriterion("erp_coupon_definition_code not in", values, "erpCouponDefinitionCode");
			return (Criteria) this;
		}

		public Criteria andErpCouponDefinitionCodeBetween(String value1, String value2) {
			addCriterion("erp_coupon_definition_code between", value1, value2, "erpCouponDefinitionCode");
			return (Criteria) this;
		}

		public Criteria andErpCouponDefinitionCodeNotBetween(String value1, String value2) {
			addCriterion("erp_coupon_definition_code not between", value1, value2, "erpCouponDefinitionCode");
			return (Criteria) this;
		}

		public Criteria andCouponCountIsNull() {
			addCriterion("coupon_count is null");
			return (Criteria) this;
		}

		public Criteria andCouponCountIsNotNull() {
			addCriterion("coupon_count is not null");
			return (Criteria) this;
		}

		public Criteria andCouponCountEqualTo(Integer value) {
			addCriterion("coupon_count =", value, "couponCount");
			return (Criteria) this;
		}

		public Criteria andCouponCountNotEqualTo(Integer value) {
			addCriterion("coupon_count <>", value, "couponCount");
			return (Criteria) this;
		}

		public Criteria andCouponCountGreaterThan(Integer value) {
			addCriterion("coupon_count >", value, "couponCount");
			return (Criteria) this;
		}

		public Criteria andCouponCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("coupon_count >=", value, "couponCount");
			return (Criteria) this;
		}

		public Criteria andCouponCountLessThan(Integer value) {
			addCriterion("coupon_count <", value, "couponCount");
			return (Criteria) this;
		}

		public Criteria andCouponCountLessThanOrEqualTo(Integer value) {
			addCriterion("coupon_count <=", value, "couponCount");
			return (Criteria) this;
		}

		public Criteria andCouponCountIn(List<Integer> values) {
			addCriterion("coupon_count in", values, "couponCount");
			return (Criteria) this;
		}

		public Criteria andCouponCountNotIn(List<Integer> values) {
			addCriterion("coupon_count not in", values, "couponCount");
			return (Criteria) this;
		}

		public Criteria andCouponCountBetween(Integer value1, Integer value2) {
			addCriterion("coupon_count between", value1, value2, "couponCount");
			return (Criteria) this;
		}

		public Criteria andCouponCountNotBetween(Integer value1, Integer value2) {
			addCriterion("coupon_count not between", value1, value2, "couponCount");
			return (Criteria) this;
		}

		public Criteria andValidDateStartIsNull() {
			addCriterion("valid_date_start is null");
			return (Criteria) this;
		}

		public Criteria andValidDateStartIsNotNull() {
			addCriterion("valid_date_start is not null");
			return (Criteria) this;
		}

		public Criteria andValidDateStartEqualTo(Date value) {
			addCriterion("valid_date_start =", value, "validDateStart");
			return (Criteria) this;
		}

		public Criteria andValidDateStartNotEqualTo(Date value) {
			addCriterion("valid_date_start <>", value, "validDateStart");
			return (Criteria) this;
		}

		public Criteria andValidDateStartGreaterThan(Date value) {
			addCriterion("valid_date_start >", value, "validDateStart");
			return (Criteria) this;
		}

		public Criteria andValidDateStartGreaterThanOrEqualTo(Date value) {
			addCriterion("valid_date_start >=", value, "validDateStart");
			return (Criteria) this;
		}

		public Criteria andValidDateStartLessThan(Date value) {
			addCriterion("valid_date_start <", value, "validDateStart");
			return (Criteria) this;
		}

		public Criteria andValidDateStartLessThanOrEqualTo(Date value) {
			addCriterion("valid_date_start <=", value, "validDateStart");
			return (Criteria) this;
		}

		public Criteria andValidDateStartIn(List<Date> values) {
			addCriterion("valid_date_start in", values, "validDateStart");
			return (Criteria) this;
		}

		public Criteria andValidDateStartNotIn(List<Date> values) {
			addCriterion("valid_date_start not in", values, "validDateStart");
			return (Criteria) this;
		}

		public Criteria andValidDateStartBetween(Date value1, Date value2) {
			addCriterion("valid_date_start between", value1, value2, "validDateStart");
			return (Criteria) this;
		}

		public Criteria andValidDateStartNotBetween(Date value1, Date value2) {
			addCriterion("valid_date_start not between", value1, value2, "validDateStart");
			return (Criteria) this;
		}

		public Criteria andValidDateEndIsNull() {
			addCriterion("valid_date_end is null");
			return (Criteria) this;
		}

		public Criteria andValidDateEndIsNotNull() {
			addCriterion("valid_date_end is not null");
			return (Criteria) this;
		}

		public Criteria andValidDateEndEqualTo(Date value) {
			addCriterion("valid_date_end =", value, "validDateEnd");
			return (Criteria) this;
		}

		public Criteria andValidDateEndNotEqualTo(Date value) {
			addCriterion("valid_date_end <>", value, "validDateEnd");
			return (Criteria) this;
		}

		public Criteria andValidDateEndGreaterThan(Date value) {
			addCriterion("valid_date_end >", value, "validDateEnd");
			return (Criteria) this;
		}

		public Criteria andValidDateEndGreaterThanOrEqualTo(Date value) {
			addCriterion("valid_date_end >=", value, "validDateEnd");
			return (Criteria) this;
		}

		public Criteria andValidDateEndLessThan(Date value) {
			addCriterion("valid_date_end <", value, "validDateEnd");
			return (Criteria) this;
		}

		public Criteria andValidDateEndLessThanOrEqualTo(Date value) {
			addCriterion("valid_date_end <=", value, "validDateEnd");
			return (Criteria) this;
		}

		public Criteria andValidDateEndIn(List<Date> values) {
			addCriterion("valid_date_end in", values, "validDateEnd");
			return (Criteria) this;
		}

		public Criteria andValidDateEndNotIn(List<Date> values) {
			addCriterion("valid_date_end not in", values, "validDateEnd");
			return (Criteria) this;
		}

		public Criteria andValidDateEndBetween(Date value1, Date value2) {
			addCriterion("valid_date_end between", value1, value2, "validDateEnd");
			return (Criteria) this;
		}

		public Criteria andValidDateEndNotBetween(Date value1, Date value2) {
			addCriterion("valid_date_end not between", value1, value2, "validDateEnd");
			return (Criteria) this;
		}

		public Criteria andPreferentialTypeIsNull() {
			addCriterion("preferential_type is null");
			return (Criteria) this;
		}

		public Criteria andPreferentialTypeIsNotNull() {
			addCriterion("preferential_type is not null");
			return (Criteria) this;
		}

		public Criteria andPreferentialTypeEqualTo(Byte value) {
			addCriterion("preferential_type =", value, "preferentialType");
			return (Criteria) this;
		}

		public Criteria andPreferentialTypeNotEqualTo(Byte value) {
			addCriterion("preferential_type <>", value, "preferentialType");
			return (Criteria) this;
		}

		public Criteria andPreferentialTypeGreaterThan(Byte value) {
			addCriterion("preferential_type >", value, "preferentialType");
			return (Criteria) this;
		}

		public Criteria andPreferentialTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("preferential_type >=", value, "preferentialType");
			return (Criteria) this;
		}

		public Criteria andPreferentialTypeLessThan(Byte value) {
			addCriterion("preferential_type <", value, "preferentialType");
			return (Criteria) this;
		}

		public Criteria andPreferentialTypeLessThanOrEqualTo(Byte value) {
			addCriterion("preferential_type <=", value, "preferentialType");
			return (Criteria) this;
		}

		public Criteria andPreferentialTypeIn(List<Byte> values) {
			addCriterion("preferential_type in", values, "preferentialType");
			return (Criteria) this;
		}

		public Criteria andPreferentialTypeNotIn(List<Byte> values) {
			addCriterion("preferential_type not in", values, "preferentialType");
			return (Criteria) this;
		}

		public Criteria andPreferentialTypeBetween(Byte value1, Byte value2) {
			addCriterion("preferential_type between", value1, value2, "preferentialType");
			return (Criteria) this;
		}

		public Criteria andPreferentialTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("preferential_type not between", value1, value2, "preferentialType");
			return (Criteria) this;
		}

		public Criteria andStatusIsNull() {
			addCriterion("status is null");
			return (Criteria) this;
		}

		public Criteria andStatusIsNotNull() {
			addCriterion("status is not null");
			return (Criteria) this;
		}

		public Criteria andStatusEqualTo(Boolean value) {
			addCriterion("status =", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotEqualTo(Boolean value) {
			addCriterion("status <>", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThan(Boolean value) {
			addCriterion("status >", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThanOrEqualTo(Boolean value) {
			addCriterion("status >=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThan(Boolean value) {
			addCriterion("status <", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThanOrEqualTo(Boolean value) {
			addCriterion("status <=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusIn(List<Boolean> values) {
			addCriterion("status in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotIn(List<Boolean> values) {
			addCriterion("status not in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusBetween(Boolean value1, Boolean value2) {
			addCriterion("status between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotBetween(Boolean value1, Boolean value2) {
			addCriterion("status not between", value1, value2, "status");
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
	}

	/**
	 * 只读. t_coupon_definition_code
	 * @mbg.generated  2019-03-11 16:34:48
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
     * This class corresponds to the database table t_coupon_definition_code
     *
     * @mbg.generated do_not_delete_during_merge 2019-03-11 16:13:22
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }
}