package com.bizvane.couponfacade.models.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CouponBatchSendDetailPOExample implements Serializable {
    /**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	protected String orderByClause;
	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	protected boolean distinct;
	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	protected List<Criteria> oredCriteria;
	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public CouponBatchSendDetailPOExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
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
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * 只读. t_coupon_batch_send_detail
	 * @mbg.generated  2019-01-04 18:32:43
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

		public Criteria andTCouponBatchSendDetailIdIsNull() {
			addCriterion("t_coupon_batch_send_detail_id is null");
			return (Criteria) this;
		}

		public Criteria andTCouponBatchSendDetailIdIsNotNull() {
			addCriterion("t_coupon_batch_send_detail_id is not null");
			return (Criteria) this;
		}

		public Criteria andTCouponBatchSendDetailIdEqualTo(Long value) {
			addCriterion("t_coupon_batch_send_detail_id =", value, "tCouponBatchSendDetailId");
			return (Criteria) this;
		}

		public Criteria andTCouponBatchSendDetailIdNotEqualTo(Long value) {
			addCriterion("t_coupon_batch_send_detail_id <>", value, "tCouponBatchSendDetailId");
			return (Criteria) this;
		}

		public Criteria andTCouponBatchSendDetailIdGreaterThan(Long value) {
			addCriterion("t_coupon_batch_send_detail_id >", value, "tCouponBatchSendDetailId");
			return (Criteria) this;
		}

		public Criteria andTCouponBatchSendDetailIdGreaterThanOrEqualTo(Long value) {
			addCriterion("t_coupon_batch_send_detail_id >=", value, "tCouponBatchSendDetailId");
			return (Criteria) this;
		}

		public Criteria andTCouponBatchSendDetailIdLessThan(Long value) {
			addCriterion("t_coupon_batch_send_detail_id <", value, "tCouponBatchSendDetailId");
			return (Criteria) this;
		}

		public Criteria andTCouponBatchSendDetailIdLessThanOrEqualTo(Long value) {
			addCriterion("t_coupon_batch_send_detail_id <=", value, "tCouponBatchSendDetailId");
			return (Criteria) this;
		}

		public Criteria andTCouponBatchSendDetailIdIn(List<Long> values) {
			addCriterion("t_coupon_batch_send_detail_id in", values, "tCouponBatchSendDetailId");
			return (Criteria) this;
		}

		public Criteria andTCouponBatchSendDetailIdNotIn(List<Long> values) {
			addCriterion("t_coupon_batch_send_detail_id not in", values, "tCouponBatchSendDetailId");
			return (Criteria) this;
		}

		public Criteria andTCouponBatchSendDetailIdBetween(Long value1, Long value2) {
			addCriterion("t_coupon_batch_send_detail_id between", value1, value2, "tCouponBatchSendDetailId");
			return (Criteria) this;
		}

		public Criteria andTCouponBatchSendDetailIdNotBetween(Long value1, Long value2) {
			addCriterion("t_coupon_batch_send_detail_id not between", value1, value2, "tCouponBatchSendDetailId");
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

		public Criteria andCouponManualIdIsNull() {
			addCriterion("coupon_manual_id is null");
			return (Criteria) this;
		}

		public Criteria andCouponManualIdIsNotNull() {
			addCriterion("coupon_manual_id is not null");
			return (Criteria) this;
		}

		public Criteria andCouponManualIdEqualTo(String value) {
			addCriterion("coupon_manual_id =", value, "couponManualId");
			return (Criteria) this;
		}

		public Criteria andCouponManualIdNotEqualTo(String value) {
			addCriterion("coupon_manual_id <>", value, "couponManualId");
			return (Criteria) this;
		}

		public Criteria andCouponManualIdGreaterThan(String value) {
			addCriterion("coupon_manual_id >", value, "couponManualId");
			return (Criteria) this;
		}

		public Criteria andCouponManualIdGreaterThanOrEqualTo(String value) {
			addCriterion("coupon_manual_id >=", value, "couponManualId");
			return (Criteria) this;
		}

		public Criteria andCouponManualIdLessThan(String value) {
			addCriterion("coupon_manual_id <", value, "couponManualId");
			return (Criteria) this;
		}

		public Criteria andCouponManualIdLessThanOrEqualTo(String value) {
			addCriterion("coupon_manual_id <=", value, "couponManualId");
			return (Criteria) this;
		}

		public Criteria andCouponManualIdLike(String value) {
			addCriterion("coupon_manual_id like", value, "couponManualId");
			return (Criteria) this;
		}

		public Criteria andCouponManualIdNotLike(String value) {
			addCriterion("coupon_manual_id not like", value, "couponManualId");
			return (Criteria) this;
		}

		public Criteria andCouponManualIdIn(List<String> values) {
			addCriterion("coupon_manual_id in", values, "couponManualId");
			return (Criteria) this;
		}

		public Criteria andCouponManualIdNotIn(List<String> values) {
			addCriterion("coupon_manual_id not in", values, "couponManualId");
			return (Criteria) this;
		}

		public Criteria andCouponManualIdBetween(String value1, String value2) {
			addCriterion("coupon_manual_id between", value1, value2, "couponManualId");
			return (Criteria) this;
		}

		public Criteria andCouponManualIdNotBetween(String value1, String value2) {
			addCriterion("coupon_manual_id not between", value1, value2, "couponManualId");
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

		public Criteria andBatchSendCodeIsNull() {
			addCriterion("batch_send_code is null");
			return (Criteria) this;
		}

		public Criteria andBatchSendCodeIsNotNull() {
			addCriterion("batch_send_code is not null");
			return (Criteria) this;
		}

		public Criteria andBatchSendCodeEqualTo(String value) {
			addCriterion("batch_send_code =", value, "batchSendCode");
			return (Criteria) this;
		}

		public Criteria andBatchSendCodeNotEqualTo(String value) {
			addCriterion("batch_send_code <>", value, "batchSendCode");
			return (Criteria) this;
		}

		public Criteria andBatchSendCodeGreaterThan(String value) {
			addCriterion("batch_send_code >", value, "batchSendCode");
			return (Criteria) this;
		}

		public Criteria andBatchSendCodeGreaterThanOrEqualTo(String value) {
			addCriterion("batch_send_code >=", value, "batchSendCode");
			return (Criteria) this;
		}

		public Criteria andBatchSendCodeLessThan(String value) {
			addCriterion("batch_send_code <", value, "batchSendCode");
			return (Criteria) this;
		}

		public Criteria andBatchSendCodeLessThanOrEqualTo(String value) {
			addCriterion("batch_send_code <=", value, "batchSendCode");
			return (Criteria) this;
		}

		public Criteria andBatchSendCodeLike(String value) {
			addCriterion("batch_send_code like", value, "batchSendCode");
			return (Criteria) this;
		}

		public Criteria andBatchSendCodeNotLike(String value) {
			addCriterion("batch_send_code not like", value, "batchSendCode");
			return (Criteria) this;
		}

		public Criteria andBatchSendCodeIn(List<String> values) {
			addCriterion("batch_send_code in", values, "batchSendCode");
			return (Criteria) this;
		}

		public Criteria andBatchSendCodeNotIn(List<String> values) {
			addCriterion("batch_send_code not in", values, "batchSendCode");
			return (Criteria) this;
		}

		public Criteria andBatchSendCodeBetween(String value1, String value2) {
			addCriterion("batch_send_code between", value1, value2, "batchSendCode");
			return (Criteria) this;
		}

		public Criteria andBatchSendCodeNotBetween(String value1, String value2) {
			addCriterion("batch_send_code not between", value1, value2, "batchSendCode");
			return (Criteria) this;
		}

		public Criteria andBatchSendCodeDetailIsNull() {
			addCriterion("batch_send_code_detail is null");
			return (Criteria) this;
		}

		public Criteria andBatchSendCodeDetailIsNotNull() {
			addCriterion("batch_send_code_detail is not null");
			return (Criteria) this;
		}

		public Criteria andBatchSendCodeDetailEqualTo(String value) {
			addCriterion("batch_send_code_detail =", value, "batchSendCodeDetail");
			return (Criteria) this;
		}

		public Criteria andBatchSendCodeDetailNotEqualTo(String value) {
			addCriterion("batch_send_code_detail <>", value, "batchSendCodeDetail");
			return (Criteria) this;
		}

		public Criteria andBatchSendCodeDetailGreaterThan(String value) {
			addCriterion("batch_send_code_detail >", value, "batchSendCodeDetail");
			return (Criteria) this;
		}

		public Criteria andBatchSendCodeDetailGreaterThanOrEqualTo(String value) {
			addCriterion("batch_send_code_detail >=", value, "batchSendCodeDetail");
			return (Criteria) this;
		}

		public Criteria andBatchSendCodeDetailLessThan(String value) {
			addCriterion("batch_send_code_detail <", value, "batchSendCodeDetail");
			return (Criteria) this;
		}

		public Criteria andBatchSendCodeDetailLessThanOrEqualTo(String value) {
			addCriterion("batch_send_code_detail <=", value, "batchSendCodeDetail");
			return (Criteria) this;
		}

		public Criteria andBatchSendCodeDetailLike(String value) {
			addCriterion("batch_send_code_detail like", value, "batchSendCodeDetail");
			return (Criteria) this;
		}

		public Criteria andBatchSendCodeDetailNotLike(String value) {
			addCriterion("batch_send_code_detail not like", value, "batchSendCodeDetail");
			return (Criteria) this;
		}

		public Criteria andBatchSendCodeDetailIn(List<String> values) {
			addCriterion("batch_send_code_detail in", values, "batchSendCodeDetail");
			return (Criteria) this;
		}

		public Criteria andBatchSendCodeDetailNotIn(List<String> values) {
			addCriterion("batch_send_code_detail not in", values, "batchSendCodeDetail");
			return (Criteria) this;
		}

		public Criteria andBatchSendCodeDetailBetween(String value1, String value2) {
			addCriterion("batch_send_code_detail between", value1, value2, "batchSendCodeDetail");
			return (Criteria) this;
		}

		public Criteria andBatchSendCodeDetailNotBetween(String value1, String value2) {
			addCriterion("batch_send_code_detail not between", value1, value2, "batchSendCodeDetail");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionCodeIsNull() {
			addCriterion("coupon_definition_code is null");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionCodeIsNotNull() {
			addCriterion("coupon_definition_code is not null");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionCodeEqualTo(String value) {
			addCriterion("coupon_definition_code =", value, "couponDefinitionCode");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionCodeNotEqualTo(String value) {
			addCriterion("coupon_definition_code <>", value, "couponDefinitionCode");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionCodeGreaterThan(String value) {
			addCriterion("coupon_definition_code >", value, "couponDefinitionCode");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionCodeGreaterThanOrEqualTo(String value) {
			addCriterion("coupon_definition_code >=", value, "couponDefinitionCode");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionCodeLessThan(String value) {
			addCriterion("coupon_definition_code <", value, "couponDefinitionCode");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionCodeLessThanOrEqualTo(String value) {
			addCriterion("coupon_definition_code <=", value, "couponDefinitionCode");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionCodeLike(String value) {
			addCriterion("coupon_definition_code like", value, "couponDefinitionCode");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionCodeNotLike(String value) {
			addCriterion("coupon_definition_code not like", value, "couponDefinitionCode");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionCodeIn(List<String> values) {
			addCriterion("coupon_definition_code in", values, "couponDefinitionCode");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionCodeNotIn(List<String> values) {
			addCriterion("coupon_definition_code not in", values, "couponDefinitionCode");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionCodeBetween(String value1, String value2) {
			addCriterion("coupon_definition_code between", value1, value2, "couponDefinitionCode");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionCodeNotBetween(String value1, String value2) {
			addCriterion("coupon_definition_code not between", value1, value2, "couponDefinitionCode");
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

		public Criteria andBizTypeIsNull() {
			addCriterion("biz_type is null");
			return (Criteria) this;
		}

		public Criteria andBizTypeIsNotNull() {
			addCriterion("biz_type is not null");
			return (Criteria) this;
		}

		public Criteria andBizTypeEqualTo(String value) {
			addCriterion("biz_type =", value, "bizType");
			return (Criteria) this;
		}

		public Criteria andBizTypeNotEqualTo(String value) {
			addCriterion("biz_type <>", value, "bizType");
			return (Criteria) this;
		}

		public Criteria andBizTypeGreaterThan(String value) {
			addCriterion("biz_type >", value, "bizType");
			return (Criteria) this;
		}

		public Criteria andBizTypeGreaterThanOrEqualTo(String value) {
			addCriterion("biz_type >=", value, "bizType");
			return (Criteria) this;
		}

		public Criteria andBizTypeLessThan(String value) {
			addCriterion("biz_type <", value, "bizType");
			return (Criteria) this;
		}

		public Criteria andBizTypeLessThanOrEqualTo(String value) {
			addCriterion("biz_type <=", value, "bizType");
			return (Criteria) this;
		}

		public Criteria andBizTypeLike(String value) {
			addCriterion("biz_type like", value, "bizType");
			return (Criteria) this;
		}

		public Criteria andBizTypeNotLike(String value) {
			addCriterion("biz_type not like", value, "bizType");
			return (Criteria) this;
		}

		public Criteria andBizTypeIn(List<String> values) {
			addCriterion("biz_type in", values, "bizType");
			return (Criteria) this;
		}

		public Criteria andBizTypeNotIn(List<String> values) {
			addCriterion("biz_type not in", values, "bizType");
			return (Criteria) this;
		}

		public Criteria andBizTypeBetween(String value1, String value2) {
			addCriterion("biz_type between", value1, value2, "bizType");
			return (Criteria) this;
		}

		public Criteria andBizTypeNotBetween(String value1, String value2) {
			addCriterion("biz_type not between", value1, value2, "bizType");
			return (Criteria) this;
		}

		public Criteria andBizCodeIsNull() {
			addCriterion("biz_code is null");
			return (Criteria) this;
		}

		public Criteria andBizCodeIsNotNull() {
			addCriterion("biz_code is not null");
			return (Criteria) this;
		}

		public Criteria andBizCodeEqualTo(String value) {
			addCriterion("biz_code =", value, "bizCode");
			return (Criteria) this;
		}

		public Criteria andBizCodeNotEqualTo(String value) {
			addCriterion("biz_code <>", value, "bizCode");
			return (Criteria) this;
		}

		public Criteria andBizCodeGreaterThan(String value) {
			addCriterion("biz_code >", value, "bizCode");
			return (Criteria) this;
		}

		public Criteria andBizCodeGreaterThanOrEqualTo(String value) {
			addCriterion("biz_code >=", value, "bizCode");
			return (Criteria) this;
		}

		public Criteria andBizCodeLessThan(String value) {
			addCriterion("biz_code <", value, "bizCode");
			return (Criteria) this;
		}

		public Criteria andBizCodeLessThanOrEqualTo(String value) {
			addCriterion("biz_code <=", value, "bizCode");
			return (Criteria) this;
		}

		public Criteria andBizCodeLike(String value) {
			addCriterion("biz_code like", value, "bizCode");
			return (Criteria) this;
		}

		public Criteria andBizCodeNotLike(String value) {
			addCriterion("biz_code not like", value, "bizCode");
			return (Criteria) this;
		}

		public Criteria andBizCodeIn(List<String> values) {
			addCriterion("biz_code in", values, "bizCode");
			return (Criteria) this;
		}

		public Criteria andBizCodeNotIn(List<String> values) {
			addCriterion("biz_code not in", values, "bizCode");
			return (Criteria) this;
		}

		public Criteria andBizCodeBetween(String value1, String value2) {
			addCriterion("biz_code between", value1, value2, "bizCode");
			return (Criteria) this;
		}

		public Criteria andBizCodeNotBetween(String value1, String value2) {
			addCriterion("biz_code not between", value1, value2, "bizCode");
			return (Criteria) this;
		}

		public Criteria andSendNumIsNull() {
			addCriterion("send_num is null");
			return (Criteria) this;
		}

		public Criteria andSendNumIsNotNull() {
			addCriterion("send_num is not null");
			return (Criteria) this;
		}

		public Criteria andSendNumEqualTo(Integer value) {
			addCriterion("send_num =", value, "sendNum");
			return (Criteria) this;
		}

		public Criteria andSendNumNotEqualTo(Integer value) {
			addCriterion("send_num <>", value, "sendNum");
			return (Criteria) this;
		}

		public Criteria andSendNumGreaterThan(Integer value) {
			addCriterion("send_num >", value, "sendNum");
			return (Criteria) this;
		}

		public Criteria andSendNumGreaterThanOrEqualTo(Integer value) {
			addCriterion("send_num >=", value, "sendNum");
			return (Criteria) this;
		}

		public Criteria andSendNumLessThan(Integer value) {
			addCriterion("send_num <", value, "sendNum");
			return (Criteria) this;
		}

		public Criteria andSendNumLessThanOrEqualTo(Integer value) {
			addCriterion("send_num <=", value, "sendNum");
			return (Criteria) this;
		}

		public Criteria andSendNumIn(List<Integer> values) {
			addCriterion("send_num in", values, "sendNum");
			return (Criteria) this;
		}

		public Criteria andSendNumNotIn(List<Integer> values) {
			addCriterion("send_num not in", values, "sendNum");
			return (Criteria) this;
		}

		public Criteria andSendNumBetween(Integer value1, Integer value2) {
			addCriterion("send_num between", value1, value2, "sendNum");
			return (Criteria) this;
		}

		public Criteria andSendNumNotBetween(Integer value1, Integer value2) {
			addCriterion("send_num not between", value1, value2, "sendNum");
			return (Criteria) this;
		}

		public Criteria andFailNumIsNull() {
			addCriterion("fail_num is null");
			return (Criteria) this;
		}

		public Criteria andFailNumIsNotNull() {
			addCriterion("fail_num is not null");
			return (Criteria) this;
		}

		public Criteria andFailNumEqualTo(Integer value) {
			addCriterion("fail_num =", value, "failNum");
			return (Criteria) this;
		}

		public Criteria andFailNumNotEqualTo(Integer value) {
			addCriterion("fail_num <>", value, "failNum");
			return (Criteria) this;
		}

		public Criteria andFailNumGreaterThan(Integer value) {
			addCriterion("fail_num >", value, "failNum");
			return (Criteria) this;
		}

		public Criteria andFailNumGreaterThanOrEqualTo(Integer value) {
			addCriterion("fail_num >=", value, "failNum");
			return (Criteria) this;
		}

		public Criteria andFailNumLessThan(Integer value) {
			addCriterion("fail_num <", value, "failNum");
			return (Criteria) this;
		}

		public Criteria andFailNumLessThanOrEqualTo(Integer value) {
			addCriterion("fail_num <=", value, "failNum");
			return (Criteria) this;
		}

		public Criteria andFailNumIn(List<Integer> values) {
			addCriterion("fail_num in", values, "failNum");
			return (Criteria) this;
		}

		public Criteria andFailNumNotIn(List<Integer> values) {
			addCriterion("fail_num not in", values, "failNum");
			return (Criteria) this;
		}

		public Criteria andFailNumBetween(Integer value1, Integer value2) {
			addCriterion("fail_num between", value1, value2, "failNum");
			return (Criteria) this;
		}

		public Criteria andFailNumNotBetween(Integer value1, Integer value2) {
			addCriterion("fail_num not between", value1, value2, "failNum");
			return (Criteria) this;
		}

		public Criteria andIsOfflineSyncIsNull() {
			addCriterion("is_offline_sync is null");
			return (Criteria) this;
		}

		public Criteria andIsOfflineSyncIsNotNull() {
			addCriterion("is_offline_sync is not null");
			return (Criteria) this;
		}

		public Criteria andIsOfflineSyncEqualTo(Boolean value) {
			addCriterion("is_offline_sync =", value, "isOfflineSync");
			return (Criteria) this;
		}

		public Criteria andIsOfflineSyncNotEqualTo(Boolean value) {
			addCriterion("is_offline_sync <>", value, "isOfflineSync");
			return (Criteria) this;
		}

		public Criteria andIsOfflineSyncGreaterThan(Boolean value) {
			addCriterion("is_offline_sync >", value, "isOfflineSync");
			return (Criteria) this;
		}

		public Criteria andIsOfflineSyncGreaterThanOrEqualTo(Boolean value) {
			addCriterion("is_offline_sync >=", value, "isOfflineSync");
			return (Criteria) this;
		}

		public Criteria andIsOfflineSyncLessThan(Boolean value) {
			addCriterion("is_offline_sync <", value, "isOfflineSync");
			return (Criteria) this;
		}

		public Criteria andIsOfflineSyncLessThanOrEqualTo(Boolean value) {
			addCriterion("is_offline_sync <=", value, "isOfflineSync");
			return (Criteria) this;
		}

		public Criteria andIsOfflineSyncIn(List<Boolean> values) {
			addCriterion("is_offline_sync in", values, "isOfflineSync");
			return (Criteria) this;
		}

		public Criteria andIsOfflineSyncNotIn(List<Boolean> values) {
			addCriterion("is_offline_sync not in", values, "isOfflineSync");
			return (Criteria) this;
		}

		public Criteria andIsOfflineSyncBetween(Boolean value1, Boolean value2) {
			addCriterion("is_offline_sync between", value1, value2, "isOfflineSync");
			return (Criteria) this;
		}

		public Criteria andIsOfflineSyncNotBetween(Boolean value1, Boolean value2) {
			addCriterion("is_offline_sync not between", value1, value2, "isOfflineSync");
			return (Criteria) this;
		}

		public Criteria andSyncStatusIsNull() {
			addCriterion("sync_status is null");
			return (Criteria) this;
		}

		public Criteria andSyncStatusIsNotNull() {
			addCriterion("sync_status is not null");
			return (Criteria) this;
		}

		public Criteria andSyncStatusEqualTo(Byte value) {
			addCriterion("sync_status =", value, "syncStatus");
			return (Criteria) this;
		}

		public Criteria andSyncStatusNotEqualTo(Byte value) {
			addCriterion("sync_status <>", value, "syncStatus");
			return (Criteria) this;
		}

		public Criteria andSyncStatusGreaterThan(Byte value) {
			addCriterion("sync_status >", value, "syncStatus");
			return (Criteria) this;
		}

		public Criteria andSyncStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("sync_status >=", value, "syncStatus");
			return (Criteria) this;
		}

		public Criteria andSyncStatusLessThan(Byte value) {
			addCriterion("sync_status <", value, "syncStatus");
			return (Criteria) this;
		}

		public Criteria andSyncStatusLessThanOrEqualTo(Byte value) {
			addCriterion("sync_status <=", value, "syncStatus");
			return (Criteria) this;
		}

		public Criteria andSyncStatusIn(List<Byte> values) {
			addCriterion("sync_status in", values, "syncStatus");
			return (Criteria) this;
		}

		public Criteria andSyncStatusNotIn(List<Byte> values) {
			addCriterion("sync_status not in", values, "syncStatus");
			return (Criteria) this;
		}

		public Criteria andSyncStatusBetween(Byte value1, Byte value2) {
			addCriterion("sync_status between", value1, value2, "syncStatus");
			return (Criteria) this;
		}

		public Criteria andSyncStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("sync_status not between", value1, value2, "syncStatus");
			return (Criteria) this;
		}

		public Criteria andBindStatusIsNull() {
			addCriterion("bind_status is null");
			return (Criteria) this;
		}

		public Criteria andBindStatusIsNotNull() {
			addCriterion("bind_status is not null");
			return (Criteria) this;
		}

		public Criteria andBindStatusEqualTo(Byte value) {
			addCriterion("bind_status =", value, "bindStatus");
			return (Criteria) this;
		}

		public Criteria andBindStatusNotEqualTo(Byte value) {
			addCriterion("bind_status <>", value, "bindStatus");
			return (Criteria) this;
		}

		public Criteria andBindStatusGreaterThan(Byte value) {
			addCriterion("bind_status >", value, "bindStatus");
			return (Criteria) this;
		}

		public Criteria andBindStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("bind_status >=", value, "bindStatus");
			return (Criteria) this;
		}

		public Criteria andBindStatusLessThan(Byte value) {
			addCriterion("bind_status <", value, "bindStatus");
			return (Criteria) this;
		}

		public Criteria andBindStatusLessThanOrEqualTo(Byte value) {
			addCriterion("bind_status <=", value, "bindStatus");
			return (Criteria) this;
		}

		public Criteria andBindStatusIn(List<Byte> values) {
			addCriterion("bind_status in", values, "bindStatus");
			return (Criteria) this;
		}

		public Criteria andBindStatusNotIn(List<Byte> values) {
			addCriterion("bind_status not in", values, "bindStatus");
			return (Criteria) this;
		}

		public Criteria andBindStatusBetween(Byte value1, Byte value2) {
			addCriterion("bind_status between", value1, value2, "bindStatus");
			return (Criteria) this;
		}

		public Criteria andBindStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("bind_status not between", value1, value2, "bindStatus");
			return (Criteria) this;
		}

		public Criteria andMemberEsIsNull() {
			addCriterion("member_es is null");
			return (Criteria) this;
		}

		public Criteria andMemberEsIsNotNull() {
			addCriterion("member_es is not null");
			return (Criteria) this;
		}

		public Criteria andMemberEsEqualTo(String value) {
			addCriterion("member_es =", value, "memberEs");
			return (Criteria) this;
		}

		public Criteria andMemberEsNotEqualTo(String value) {
			addCriterion("member_es <>", value, "memberEs");
			return (Criteria) this;
		}

		public Criteria andMemberEsGreaterThan(String value) {
			addCriterion("member_es >", value, "memberEs");
			return (Criteria) this;
		}

		public Criteria andMemberEsGreaterThanOrEqualTo(String value) {
			addCriterion("member_es >=", value, "memberEs");
			return (Criteria) this;
		}

		public Criteria andMemberEsLessThan(String value) {
			addCriterion("member_es <", value, "memberEs");
			return (Criteria) this;
		}

		public Criteria andMemberEsLessThanOrEqualTo(String value) {
			addCriterion("member_es <=", value, "memberEs");
			return (Criteria) this;
		}

		public Criteria andMemberEsLike(String value) {
			addCriterion("member_es like", value, "memberEs");
			return (Criteria) this;
		}

		public Criteria andMemberEsNotLike(String value) {
			addCriterion("member_es not like", value, "memberEs");
			return (Criteria) this;
		}

		public Criteria andMemberEsIn(List<String> values) {
			addCriterion("member_es in", values, "memberEs");
			return (Criteria) this;
		}

		public Criteria andMemberEsNotIn(List<String> values) {
			addCriterion("member_es not in", values, "memberEs");
			return (Criteria) this;
		}

		public Criteria andMemberEsBetween(String value1, String value2) {
			addCriterion("member_es between", value1, value2, "memberEs");
			return (Criteria) this;
		}

		public Criteria andMemberEsNotBetween(String value1, String value2) {
			addCriterion("member_es not between", value1, value2, "memberEs");
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
	 * 只读. t_coupon_batch_send_detail
	 * @mbg.generated  2019-01-04 18:32:43
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
     * This class corresponds to the database table t_coupon_batch_send_detail
     *
     * @mbg.generated do_not_delete_during_merge 2019-01-04 16:26:32
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }
}