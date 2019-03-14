package com.bizvane.couponfacade.models.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CouponManualPOExample implements Serializable {
    /**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	protected String orderByClause;
	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	protected boolean distinct;
	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	protected List<Criteria> oredCriteria;
	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public CouponManualPOExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
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
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * 只读. t_coupon_manual
	 * @mbg.generated  2019-01-24 17:16:34
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

		public Criteria andCouponManualIdIsNull() {
			addCriterion("coupon_manual_id is null");
			return (Criteria) this;
		}

		public Criteria andCouponManualIdIsNotNull() {
			addCriterion("coupon_manual_id is not null");
			return (Criteria) this;
		}

		public Criteria andCouponManualIdEqualTo(Long value) {
			addCriterion("coupon_manual_id =", value, "couponManualId");
			return (Criteria) this;
		}

		public Criteria andCouponManualIdNotEqualTo(Long value) {
			addCriterion("coupon_manual_id <>", value, "couponManualId");
			return (Criteria) this;
		}

		public Criteria andCouponManualIdGreaterThan(Long value) {
			addCriterion("coupon_manual_id >", value, "couponManualId");
			return (Criteria) this;
		}

		public Criteria andCouponManualIdGreaterThanOrEqualTo(Long value) {
			addCriterion("coupon_manual_id >=", value, "couponManualId");
			return (Criteria) this;
		}

		public Criteria andCouponManualIdLessThan(Long value) {
			addCriterion("coupon_manual_id <", value, "couponManualId");
			return (Criteria) this;
		}

		public Criteria andCouponManualIdLessThanOrEqualTo(Long value) {
			addCriterion("coupon_manual_id <=", value, "couponManualId");
			return (Criteria) this;
		}

		public Criteria andCouponManualIdIn(List<Long> values) {
			addCriterion("coupon_manual_id in", values, "couponManualId");
			return (Criteria) this;
		}

		public Criteria andCouponManualIdNotIn(List<Long> values) {
			addCriterion("coupon_manual_id not in", values, "couponManualId");
			return (Criteria) this;
		}

		public Criteria andCouponManualIdBetween(Long value1, Long value2) {
			addCriterion("coupon_manual_id between", value1, value2, "couponManualId");
			return (Criteria) this;
		}

		public Criteria andCouponManualIdNotBetween(Long value1, Long value2) {
			addCriterion("coupon_manual_id not between", value1, value2, "couponManualId");
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

		public Criteria andTaskNameIsNull() {
			addCriterion("task_name is null");
			return (Criteria) this;
		}

		public Criteria andTaskNameIsNotNull() {
			addCriterion("task_name is not null");
			return (Criteria) this;
		}

		public Criteria andTaskNameEqualTo(String value) {
			addCriterion("task_name =", value, "taskName");
			return (Criteria) this;
		}

		public Criteria andTaskNameNotEqualTo(String value) {
			addCriterion("task_name <>", value, "taskName");
			return (Criteria) this;
		}

		public Criteria andTaskNameGreaterThan(String value) {
			addCriterion("task_name >", value, "taskName");
			return (Criteria) this;
		}

		public Criteria andTaskNameGreaterThanOrEqualTo(String value) {
			addCriterion("task_name >=", value, "taskName");
			return (Criteria) this;
		}

		public Criteria andTaskNameLessThan(String value) {
			addCriterion("task_name <", value, "taskName");
			return (Criteria) this;
		}

		public Criteria andTaskNameLessThanOrEqualTo(String value) {
			addCriterion("task_name <=", value, "taskName");
			return (Criteria) this;
		}

		public Criteria andTaskNameLike(String value) {
			addCriterion("task_name like", value, "taskName");
			return (Criteria) this;
		}

		public Criteria andTaskNameNotLike(String value) {
			addCriterion("task_name not like", value, "taskName");
			return (Criteria) this;
		}

		public Criteria andTaskNameIn(List<String> values) {
			addCriterion("task_name in", values, "taskName");
			return (Criteria) this;
		}

		public Criteria andTaskNameNotIn(List<String> values) {
			addCriterion("task_name not in", values, "taskName");
			return (Criteria) this;
		}

		public Criteria andTaskNameBetween(String value1, String value2) {
			addCriterion("task_name between", value1, value2, "taskName");
			return (Criteria) this;
		}

		public Criteria andTaskNameNotBetween(String value1, String value2) {
			addCriterion("task_name not between", value1, value2, "taskName");
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

		public Criteria andCouponDefinitionIdEqualTo(String value) {
			addCriterion("coupon_definition_id =", value, "couponDefinitionId");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionIdNotEqualTo(String value) {
			addCriterion("coupon_definition_id <>", value, "couponDefinitionId");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionIdGreaterThan(String value) {
			addCriterion("coupon_definition_id >", value, "couponDefinitionId");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionIdGreaterThanOrEqualTo(String value) {
			addCriterion("coupon_definition_id >=", value, "couponDefinitionId");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionIdLessThan(String value) {
			addCriterion("coupon_definition_id <", value, "couponDefinitionId");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionIdLessThanOrEqualTo(String value) {
			addCriterion("coupon_definition_id <=", value, "couponDefinitionId");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionIdLike(String value) {
			addCriterion("coupon_definition_id like", value, "couponDefinitionId");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionIdNotLike(String value) {
			addCriterion("coupon_definition_id not like", value, "couponDefinitionId");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionIdIn(List<String> values) {
			addCriterion("coupon_definition_id in", values, "couponDefinitionId");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionIdNotIn(List<String> values) {
			addCriterion("coupon_definition_id not in", values, "couponDefinitionId");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionIdBetween(String value1, String value2) {
			addCriterion("coupon_definition_id between", value1, value2, "couponDefinitionId");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionIdNotBetween(String value1, String value2) {
			addCriterion("coupon_definition_id not between", value1, value2, "couponDefinitionId");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionNameIsNull() {
			addCriterion("coupon_definition_name is null");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionNameIsNotNull() {
			addCriterion("coupon_definition_name is not null");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionNameEqualTo(String value) {
			addCriterion("coupon_definition_name =", value, "couponDefinitionName");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionNameNotEqualTo(String value) {
			addCriterion("coupon_definition_name <>", value, "couponDefinitionName");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionNameGreaterThan(String value) {
			addCriterion("coupon_definition_name >", value, "couponDefinitionName");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionNameGreaterThanOrEqualTo(String value) {
			addCriterion("coupon_definition_name >=", value, "couponDefinitionName");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionNameLessThan(String value) {
			addCriterion("coupon_definition_name <", value, "couponDefinitionName");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionNameLessThanOrEqualTo(String value) {
			addCriterion("coupon_definition_name <=", value, "couponDefinitionName");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionNameLike(String value) {
			addCriterion("coupon_definition_name like", value, "couponDefinitionName");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionNameNotLike(String value) {
			addCriterion("coupon_definition_name not like", value, "couponDefinitionName");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionNameIn(List<String> values) {
			addCriterion("coupon_definition_name in", values, "couponDefinitionName");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionNameNotIn(List<String> values) {
			addCriterion("coupon_definition_name not in", values, "couponDefinitionName");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionNameBetween(String value1, String value2) {
			addCriterion("coupon_definition_name between", value1, value2, "couponDefinitionName");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionNameNotBetween(String value1, String value2) {
			addCriterion("coupon_definition_name not between", value1, value2, "couponDefinitionName");
			return (Criteria) this;
		}

		public Criteria andMemberNumIsNull() {
			addCriterion("member_num is null");
			return (Criteria) this;
		}

		public Criteria andMemberNumIsNotNull() {
			addCriterion("member_num is not null");
			return (Criteria) this;
		}

		public Criteria andMemberNumEqualTo(Integer value) {
			addCriterion("member_num =", value, "memberNum");
			return (Criteria) this;
		}

		public Criteria andMemberNumNotEqualTo(Integer value) {
			addCriterion("member_num <>", value, "memberNum");
			return (Criteria) this;
		}

		public Criteria andMemberNumGreaterThan(Integer value) {
			addCriterion("member_num >", value, "memberNum");
			return (Criteria) this;
		}

		public Criteria andMemberNumGreaterThanOrEqualTo(Integer value) {
			addCriterion("member_num >=", value, "memberNum");
			return (Criteria) this;
		}

		public Criteria andMemberNumLessThan(Integer value) {
			addCriterion("member_num <", value, "memberNum");
			return (Criteria) this;
		}

		public Criteria andMemberNumLessThanOrEqualTo(Integer value) {
			addCriterion("member_num <=", value, "memberNum");
			return (Criteria) this;
		}

		public Criteria andMemberNumIn(List<Integer> values) {
			addCriterion("member_num in", values, "memberNum");
			return (Criteria) this;
		}

		public Criteria andMemberNumNotIn(List<Integer> values) {
			addCriterion("member_num not in", values, "memberNum");
			return (Criteria) this;
		}

		public Criteria andMemberNumBetween(Integer value1, Integer value2) {
			addCriterion("member_num between", value1, value2, "memberNum");
			return (Criteria) this;
		}

		public Criteria andMemberNumNotBetween(Integer value1, Integer value2) {
			addCriterion("member_num not between", value1, value2, "memberNum");
			return (Criteria) this;
		}

		public Criteria andMemberCountIsNull() {
			addCriterion("member_count is null");
			return (Criteria) this;
		}

		public Criteria andMemberCountIsNotNull() {
			addCriterion("member_count is not null");
			return (Criteria) this;
		}

		public Criteria andMemberCountEqualTo(Integer value) {
			addCriterion("member_count =", value, "memberCount");
			return (Criteria) this;
		}

		public Criteria andMemberCountNotEqualTo(Integer value) {
			addCriterion("member_count <>", value, "memberCount");
			return (Criteria) this;
		}

		public Criteria andMemberCountGreaterThan(Integer value) {
			addCriterion("member_count >", value, "memberCount");
			return (Criteria) this;
		}

		public Criteria andMemberCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("member_count >=", value, "memberCount");
			return (Criteria) this;
		}

		public Criteria andMemberCountLessThan(Integer value) {
			addCriterion("member_count <", value, "memberCount");
			return (Criteria) this;
		}

		public Criteria andMemberCountLessThanOrEqualTo(Integer value) {
			addCriterion("member_count <=", value, "memberCount");
			return (Criteria) this;
		}

		public Criteria andMemberCountIn(List<Integer> values) {
			addCriterion("member_count in", values, "memberCount");
			return (Criteria) this;
		}

		public Criteria andMemberCountNotIn(List<Integer> values) {
			addCriterion("member_count not in", values, "memberCount");
			return (Criteria) this;
		}

		public Criteria andMemberCountBetween(Integer value1, Integer value2) {
			addCriterion("member_count between", value1, value2, "memberCount");
			return (Criteria) this;
		}

		public Criteria andMemberCountNotBetween(Integer value1, Integer value2) {
			addCriterion("member_count not between", value1, value2, "memberCount");
			return (Criteria) this;
		}

		public Criteria andSuccessCountIsNull() {
			addCriterion("success_count is null");
			return (Criteria) this;
		}

		public Criteria andSuccessCountIsNotNull() {
			addCriterion("success_count is not null");
			return (Criteria) this;
		}

		public Criteria andSuccessCountEqualTo(Integer value) {
			addCriterion("success_count =", value, "successCount");
			return (Criteria) this;
		}

		public Criteria andSuccessCountNotEqualTo(Integer value) {
			addCriterion("success_count <>", value, "successCount");
			return (Criteria) this;
		}

		public Criteria andSuccessCountGreaterThan(Integer value) {
			addCriterion("success_count >", value, "successCount");
			return (Criteria) this;
		}

		public Criteria andSuccessCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("success_count >=", value, "successCount");
			return (Criteria) this;
		}

		public Criteria andSuccessCountLessThan(Integer value) {
			addCriterion("success_count <", value, "successCount");
			return (Criteria) this;
		}

		public Criteria andSuccessCountLessThanOrEqualTo(Integer value) {
			addCriterion("success_count <=", value, "successCount");
			return (Criteria) this;
		}

		public Criteria andSuccessCountIn(List<Integer> values) {
			addCriterion("success_count in", values, "successCount");
			return (Criteria) this;
		}

		public Criteria andSuccessCountNotIn(List<Integer> values) {
			addCriterion("success_count not in", values, "successCount");
			return (Criteria) this;
		}

		public Criteria andSuccessCountBetween(Integer value1, Integer value2) {
			addCriterion("success_count between", value1, value2, "successCount");
			return (Criteria) this;
		}

		public Criteria andSuccessCountNotBetween(Integer value1, Integer value2) {
			addCriterion("success_count not between", value1, value2, "successCount");
			return (Criteria) this;
		}

		public Criteria andFailCountIsNull() {
			addCriterion("fail_count is null");
			return (Criteria) this;
		}

		public Criteria andFailCountIsNotNull() {
			addCriterion("fail_count is not null");
			return (Criteria) this;
		}

		public Criteria andFailCountEqualTo(Integer value) {
			addCriterion("fail_count =", value, "failCount");
			return (Criteria) this;
		}

		public Criteria andFailCountNotEqualTo(Integer value) {
			addCriterion("fail_count <>", value, "failCount");
			return (Criteria) this;
		}

		public Criteria andFailCountGreaterThan(Integer value) {
			addCriterion("fail_count >", value, "failCount");
			return (Criteria) this;
		}

		public Criteria andFailCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("fail_count >=", value, "failCount");
			return (Criteria) this;
		}

		public Criteria andFailCountLessThan(Integer value) {
			addCriterion("fail_count <", value, "failCount");
			return (Criteria) this;
		}

		public Criteria andFailCountLessThanOrEqualTo(Integer value) {
			addCriterion("fail_count <=", value, "failCount");
			return (Criteria) this;
		}

		public Criteria andFailCountIn(List<Integer> values) {
			addCriterion("fail_count in", values, "failCount");
			return (Criteria) this;
		}

		public Criteria andFailCountNotIn(List<Integer> values) {
			addCriterion("fail_count not in", values, "failCount");
			return (Criteria) this;
		}

		public Criteria andFailCountBetween(Integer value1, Integer value2) {
			addCriterion("fail_count between", value1, value2, "failCount");
			return (Criteria) this;
		}

		public Criteria andFailCountNotBetween(Integer value1, Integer value2) {
			addCriterion("fail_count not between", value1, value2, "failCount");
			return (Criteria) this;
		}

		public Criteria andCancelCountIsNull() {
			addCriterion("cancel_count is null");
			return (Criteria) this;
		}

		public Criteria andCancelCountIsNotNull() {
			addCriterion("cancel_count is not null");
			return (Criteria) this;
		}

		public Criteria andCancelCountEqualTo(Integer value) {
			addCriterion("cancel_count =", value, "cancelCount");
			return (Criteria) this;
		}

		public Criteria andCancelCountNotEqualTo(Integer value) {
			addCriterion("cancel_count <>", value, "cancelCount");
			return (Criteria) this;
		}

		public Criteria andCancelCountGreaterThan(Integer value) {
			addCriterion("cancel_count >", value, "cancelCount");
			return (Criteria) this;
		}

		public Criteria andCancelCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("cancel_count >=", value, "cancelCount");
			return (Criteria) this;
		}

		public Criteria andCancelCountLessThan(Integer value) {
			addCriterion("cancel_count <", value, "cancelCount");
			return (Criteria) this;
		}

		public Criteria andCancelCountLessThanOrEqualTo(Integer value) {
			addCriterion("cancel_count <=", value, "cancelCount");
			return (Criteria) this;
		}

		public Criteria andCancelCountIn(List<Integer> values) {
			addCriterion("cancel_count in", values, "cancelCount");
			return (Criteria) this;
		}

		public Criteria andCancelCountNotIn(List<Integer> values) {
			addCriterion("cancel_count not in", values, "cancelCount");
			return (Criteria) this;
		}

		public Criteria andCancelCountBetween(Integer value1, Integer value2) {
			addCriterion("cancel_count between", value1, value2, "cancelCount");
			return (Criteria) this;
		}

		public Criteria andCancelCountNotBetween(Integer value1, Integer value2) {
			addCriterion("cancel_count not between", value1, value2, "cancelCount");
			return (Criteria) this;
		}

		public Criteria andSendTypeIsNull() {
			addCriterion("send_type is null");
			return (Criteria) this;
		}

		public Criteria andSendTypeIsNotNull() {
			addCriterion("send_type is not null");
			return (Criteria) this;
		}

		public Criteria andSendTypeEqualTo(Byte value) {
			addCriterion("send_type =", value, "sendType");
			return (Criteria) this;
		}

		public Criteria andSendTypeNotEqualTo(Byte value) {
			addCriterion("send_type <>", value, "sendType");
			return (Criteria) this;
		}

		public Criteria andSendTypeGreaterThan(Byte value) {
			addCriterion("send_type >", value, "sendType");
			return (Criteria) this;
		}

		public Criteria andSendTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("send_type >=", value, "sendType");
			return (Criteria) this;
		}

		public Criteria andSendTypeLessThan(Byte value) {
			addCriterion("send_type <", value, "sendType");
			return (Criteria) this;
		}

		public Criteria andSendTypeLessThanOrEqualTo(Byte value) {
			addCriterion("send_type <=", value, "sendType");
			return (Criteria) this;
		}

		public Criteria andSendTypeIn(List<Byte> values) {
			addCriterion("send_type in", values, "sendType");
			return (Criteria) this;
		}

		public Criteria andSendTypeNotIn(List<Byte> values) {
			addCriterion("send_type not in", values, "sendType");
			return (Criteria) this;
		}

		public Criteria andSendTypeBetween(Byte value1, Byte value2) {
			addCriterion("send_type between", value1, value2, "sendType");
			return (Criteria) this;
		}

		public Criteria andSendTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("send_type not between", value1, value2, "sendType");
			return (Criteria) this;
		}

		public Criteria andSendTimeIsNull() {
			addCriterion("send_time is null");
			return (Criteria) this;
		}

		public Criteria andSendTimeIsNotNull() {
			addCriterion("send_time is not null");
			return (Criteria) this;
		}

		public Criteria andSendTimeEqualTo(Date value) {
			addCriterion("send_time =", value, "sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeNotEqualTo(Date value) {
			addCriterion("send_time <>", value, "sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeGreaterThan(Date value) {
			addCriterion("send_time >", value, "sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("send_time >=", value, "sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeLessThan(Date value) {
			addCriterion("send_time <", value, "sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeLessThanOrEqualTo(Date value) {
			addCriterion("send_time <=", value, "sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeIn(List<Date> values) {
			addCriterion("send_time in", values, "sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeNotIn(List<Date> values) {
			addCriterion("send_time not in", values, "sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeBetween(Date value1, Date value2) {
			addCriterion("send_time between", value1, value2, "sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeNotBetween(Date value1, Date value2) {
			addCriterion("send_time not between", value1, value2, "sendTime");
			return (Criteria) this;
		}

		public Criteria andTaskStatusIsNull() {
			addCriterion("task_status is null");
			return (Criteria) this;
		}

		public Criteria andTaskStatusIsNotNull() {
			addCriterion("task_status is not null");
			return (Criteria) this;
		}

		public Criteria andTaskStatusEqualTo(Byte value) {
			addCriterion("task_status =", value, "taskStatus");
			return (Criteria) this;
		}

		public Criteria andTaskStatusNotEqualTo(Byte value) {
			addCriterion("task_status <>", value, "taskStatus");
			return (Criteria) this;
		}

		public Criteria andTaskStatusGreaterThan(Byte value) {
			addCriterion("task_status >", value, "taskStatus");
			return (Criteria) this;
		}

		public Criteria andTaskStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("task_status >=", value, "taskStatus");
			return (Criteria) this;
		}

		public Criteria andTaskStatusLessThan(Byte value) {
			addCriterion("task_status <", value, "taskStatus");
			return (Criteria) this;
		}

		public Criteria andTaskStatusLessThanOrEqualTo(Byte value) {
			addCriterion("task_status <=", value, "taskStatus");
			return (Criteria) this;
		}

		public Criteria andTaskStatusIn(List<Byte> values) {
			addCriterion("task_status in", values, "taskStatus");
			return (Criteria) this;
		}

		public Criteria andTaskStatusNotIn(List<Byte> values) {
			addCriterion("task_status not in", values, "taskStatus");
			return (Criteria) this;
		}

		public Criteria andTaskStatusBetween(Byte value1, Byte value2) {
			addCriterion("task_status between", value1, value2, "taskStatus");
			return (Criteria) this;
		}

		public Criteria andTaskStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("task_status not between", value1, value2, "taskStatus");
			return (Criteria) this;
		}

		public Criteria andSyncFailCountIsNull() {
			addCriterion("sync_fail_count is null");
			return (Criteria) this;
		}

		public Criteria andSyncFailCountIsNotNull() {
			addCriterion("sync_fail_count is not null");
			return (Criteria) this;
		}

		public Criteria andSyncFailCountEqualTo(Integer value) {
			addCriterion("sync_fail_count =", value, "syncFailCount");
			return (Criteria) this;
		}

		public Criteria andSyncFailCountNotEqualTo(Integer value) {
			addCriterion("sync_fail_count <>", value, "syncFailCount");
			return (Criteria) this;
		}

		public Criteria andSyncFailCountGreaterThan(Integer value) {
			addCriterion("sync_fail_count >", value, "syncFailCount");
			return (Criteria) this;
		}

		public Criteria andSyncFailCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("sync_fail_count >=", value, "syncFailCount");
			return (Criteria) this;
		}

		public Criteria andSyncFailCountLessThan(Integer value) {
			addCriterion("sync_fail_count <", value, "syncFailCount");
			return (Criteria) this;
		}

		public Criteria andSyncFailCountLessThanOrEqualTo(Integer value) {
			addCriterion("sync_fail_count <=", value, "syncFailCount");
			return (Criteria) this;
		}

		public Criteria andSyncFailCountIn(List<Integer> values) {
			addCriterion("sync_fail_count in", values, "syncFailCount");
			return (Criteria) this;
		}

		public Criteria andSyncFailCountNotIn(List<Integer> values) {
			addCriterion("sync_fail_count not in", values, "syncFailCount");
			return (Criteria) this;
		}

		public Criteria andSyncFailCountBetween(Integer value1, Integer value2) {
			addCriterion("sync_fail_count between", value1, value2, "syncFailCount");
			return (Criteria) this;
		}

		public Criteria andSyncFailCountNotBetween(Integer value1, Integer value2) {
			addCriterion("sync_fail_count not between", value1, value2, "syncFailCount");
			return (Criteria) this;
		}

		public Criteria andProfitMoneyIsNull() {
			addCriterion("profit_money is null");
			return (Criteria) this;
		}

		public Criteria andProfitMoneyIsNotNull() {
			addCriterion("profit_money is not null");
			return (Criteria) this;
		}

		public Criteria andProfitMoneyEqualTo(BigDecimal value) {
			addCriterion("profit_money =", value, "profitMoney");
			return (Criteria) this;
		}

		public Criteria andProfitMoneyNotEqualTo(BigDecimal value) {
			addCriterion("profit_money <>", value, "profitMoney");
			return (Criteria) this;
		}

		public Criteria andProfitMoneyGreaterThan(BigDecimal value) {
			addCriterion("profit_money >", value, "profitMoney");
			return (Criteria) this;
		}

		public Criteria andProfitMoneyGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("profit_money >=", value, "profitMoney");
			return (Criteria) this;
		}

		public Criteria andProfitMoneyLessThan(BigDecimal value) {
			addCriterion("profit_money <", value, "profitMoney");
			return (Criteria) this;
		}

		public Criteria andProfitMoneyLessThanOrEqualTo(BigDecimal value) {
			addCriterion("profit_money <=", value, "profitMoney");
			return (Criteria) this;
		}

		public Criteria andProfitMoneyIn(List<BigDecimal> values) {
			addCriterion("profit_money in", values, "profitMoney");
			return (Criteria) this;
		}

		public Criteria andProfitMoneyNotIn(List<BigDecimal> values) {
			addCriterion("profit_money not in", values, "profitMoney");
			return (Criteria) this;
		}

		public Criteria andProfitMoneyBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("profit_money between", value1, value2, "profitMoney");
			return (Criteria) this;
		}

		public Criteria andProfitMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("profit_money not between", value1, value2, "profitMoney");
			return (Criteria) this;
		}

		public Criteria andDiscountMoneyIsNull() {
			addCriterion("discount_money is null");
			return (Criteria) this;
		}

		public Criteria andDiscountMoneyIsNotNull() {
			addCriterion("discount_money is not null");
			return (Criteria) this;
		}

		public Criteria andDiscountMoneyEqualTo(BigDecimal value) {
			addCriterion("discount_money =", value, "discountMoney");
			return (Criteria) this;
		}

		public Criteria andDiscountMoneyNotEqualTo(BigDecimal value) {
			addCriterion("discount_money <>", value, "discountMoney");
			return (Criteria) this;
		}

		public Criteria andDiscountMoneyGreaterThan(BigDecimal value) {
			addCriterion("discount_money >", value, "discountMoney");
			return (Criteria) this;
		}

		public Criteria andDiscountMoneyGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("discount_money >=", value, "discountMoney");
			return (Criteria) this;
		}

		public Criteria andDiscountMoneyLessThan(BigDecimal value) {
			addCriterion("discount_money <", value, "discountMoney");
			return (Criteria) this;
		}

		public Criteria andDiscountMoneyLessThanOrEqualTo(BigDecimal value) {
			addCriterion("discount_money <=", value, "discountMoney");
			return (Criteria) this;
		}

		public Criteria andDiscountMoneyIn(List<BigDecimal> values) {
			addCriterion("discount_money in", values, "discountMoney");
			return (Criteria) this;
		}

		public Criteria andDiscountMoneyNotIn(List<BigDecimal> values) {
			addCriterion("discount_money not in", values, "discountMoney");
			return (Criteria) this;
		}

		public Criteria andDiscountMoneyBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("discount_money between", value1, value2, "discountMoney");
			return (Criteria) this;
		}

		public Criteria andDiscountMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("discount_money not between", value1, value2, "discountMoney");
			return (Criteria) this;
		}

		public Criteria andReviewUserIdIsNull() {
			addCriterion("review_user_id is null");
			return (Criteria) this;
		}

		public Criteria andReviewUserIdIsNotNull() {
			addCriterion("review_user_id is not null");
			return (Criteria) this;
		}

		public Criteria andReviewUserIdEqualTo(Long value) {
			addCriterion("review_user_id =", value, "reviewUserId");
			return (Criteria) this;
		}

		public Criteria andReviewUserIdNotEqualTo(Long value) {
			addCriterion("review_user_id <>", value, "reviewUserId");
			return (Criteria) this;
		}

		public Criteria andReviewUserIdGreaterThan(Long value) {
			addCriterion("review_user_id >", value, "reviewUserId");
			return (Criteria) this;
		}

		public Criteria andReviewUserIdGreaterThanOrEqualTo(Long value) {
			addCriterion("review_user_id >=", value, "reviewUserId");
			return (Criteria) this;
		}

		public Criteria andReviewUserIdLessThan(Long value) {
			addCriterion("review_user_id <", value, "reviewUserId");
			return (Criteria) this;
		}

		public Criteria andReviewUserIdLessThanOrEqualTo(Long value) {
			addCriterion("review_user_id <=", value, "reviewUserId");
			return (Criteria) this;
		}

		public Criteria andReviewUserIdIn(List<Long> values) {
			addCriterion("review_user_id in", values, "reviewUserId");
			return (Criteria) this;
		}

		public Criteria andReviewUserIdNotIn(List<Long> values) {
			addCriterion("review_user_id not in", values, "reviewUserId");
			return (Criteria) this;
		}

		public Criteria andReviewUserIdBetween(Long value1, Long value2) {
			addCriterion("review_user_id between", value1, value2, "reviewUserId");
			return (Criteria) this;
		}

		public Criteria andReviewUserIdNotBetween(Long value1, Long value2) {
			addCriterion("review_user_id not between", value1, value2, "reviewUserId");
			return (Criteria) this;
		}

		public Criteria andReviewUserNameIsNull() {
			addCriterion("review_user_name is null");
			return (Criteria) this;
		}

		public Criteria andReviewUserNameIsNotNull() {
			addCriterion("review_user_name is not null");
			return (Criteria) this;
		}

		public Criteria andReviewUserNameEqualTo(String value) {
			addCriterion("review_user_name =", value, "reviewUserName");
			return (Criteria) this;
		}

		public Criteria andReviewUserNameNotEqualTo(String value) {
			addCriterion("review_user_name <>", value, "reviewUserName");
			return (Criteria) this;
		}

		public Criteria andReviewUserNameGreaterThan(String value) {
			addCriterion("review_user_name >", value, "reviewUserName");
			return (Criteria) this;
		}

		public Criteria andReviewUserNameGreaterThanOrEqualTo(String value) {
			addCriterion("review_user_name >=", value, "reviewUserName");
			return (Criteria) this;
		}

		public Criteria andReviewUserNameLessThan(String value) {
			addCriterion("review_user_name <", value, "reviewUserName");
			return (Criteria) this;
		}

		public Criteria andReviewUserNameLessThanOrEqualTo(String value) {
			addCriterion("review_user_name <=", value, "reviewUserName");
			return (Criteria) this;
		}

		public Criteria andReviewUserNameLike(String value) {
			addCriterion("review_user_name like", value, "reviewUserName");
			return (Criteria) this;
		}

		public Criteria andReviewUserNameNotLike(String value) {
			addCriterion("review_user_name not like", value, "reviewUserName");
			return (Criteria) this;
		}

		public Criteria andReviewUserNameIn(List<String> values) {
			addCriterion("review_user_name in", values, "reviewUserName");
			return (Criteria) this;
		}

		public Criteria andReviewUserNameNotIn(List<String> values) {
			addCriterion("review_user_name not in", values, "reviewUserName");
			return (Criteria) this;
		}

		public Criteria andReviewUserNameBetween(String value1, String value2) {
			addCriterion("review_user_name between", value1, value2, "reviewUserName");
			return (Criteria) this;
		}

		public Criteria andReviewUserNameNotBetween(String value1, String value2) {
			addCriterion("review_user_name not between", value1, value2, "reviewUserName");
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

		public Criteria andStoreidsIsNull() {
			addCriterion("storeIds is null");
			return (Criteria) this;
		}

		public Criteria andStoreidsIsNotNull() {
			addCriterion("storeIds is not null");
			return (Criteria) this;
		}

		public Criteria andStoreidsEqualTo(String value) {
			addCriterion("storeIds =", value, "storeids");
			return (Criteria) this;
		}

		public Criteria andStoreidsNotEqualTo(String value) {
			addCriterion("storeIds <>", value, "storeids");
			return (Criteria) this;
		}

		public Criteria andStoreidsGreaterThan(String value) {
			addCriterion("storeIds >", value, "storeids");
			return (Criteria) this;
		}

		public Criteria andStoreidsGreaterThanOrEqualTo(String value) {
			addCriterion("storeIds >=", value, "storeids");
			return (Criteria) this;
		}

		public Criteria andStoreidsLessThan(String value) {
			addCriterion("storeIds <", value, "storeids");
			return (Criteria) this;
		}

		public Criteria andStoreidsLessThanOrEqualTo(String value) {
			addCriterion("storeIds <=", value, "storeids");
			return (Criteria) this;
		}

		public Criteria andStoreidsLike(String value) {
			addCriterion("storeIds like", value, "storeids");
			return (Criteria) this;
		}

		public Criteria andStoreidsNotLike(String value) {
			addCriterion("storeIds not like", value, "storeids");
			return (Criteria) this;
		}

		public Criteria andStoreidsIn(List<String> values) {
			addCriterion("storeIds in", values, "storeids");
			return (Criteria) this;
		}

		public Criteria andStoreidsNotIn(List<String> values) {
			addCriterion("storeIds not in", values, "storeids");
			return (Criteria) this;
		}

		public Criteria andStoreidsBetween(String value1, String value2) {
			addCriterion("storeIds between", value1, value2, "storeids");
			return (Criteria) this;
		}

		public Criteria andStoreidsNotBetween(String value1, String value2) {
			addCriterion("storeIds not between", value1, value2, "storeids");
			return (Criteria) this;
		}
	}

	/**
	 * 只读. t_coupon_manual
	 * @mbg.generated  2019-01-24 17:16:34
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
     * This class corresponds to the database table t_coupon_manual
     *
     * @mbg.generated do_not_delete_during_merge 2018-10-09 16:00:51
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }
}