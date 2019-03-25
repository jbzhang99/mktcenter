package com.bizvane.couponfacade.models.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CouponEntityPOExample implements Serializable {
    /**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	protected String orderByClause;
	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	protected boolean distinct;
	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	protected List<Criteria> oredCriteria;
	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public CouponEntityPOExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
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
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-17 16:08:03
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * 只读. t_coupon_entity
	 * @mbg.generated  2019-01-17 16:08:03
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

		public Criteria andCouponEntityIdIsNull() {
			addCriterion("coupon_entity_id is null");
			return (Criteria) this;
		}

		public Criteria andCouponEntityIdIsNotNull() {
			addCriterion("coupon_entity_id is not null");
			return (Criteria) this;
		}

		public Criteria andCouponEntityIdEqualTo(Long value) {
			addCriterion("coupon_entity_id =", value, "couponEntityId");
			return (Criteria) this;
		}

		public Criteria andCouponEntityIdNotEqualTo(Long value) {
			addCriterion("coupon_entity_id <>", value, "couponEntityId");
			return (Criteria) this;
		}

		public Criteria andCouponEntityIdGreaterThan(Long value) {
			addCriterion("coupon_entity_id >", value, "couponEntityId");
			return (Criteria) this;
		}

		public Criteria andCouponEntityIdGreaterThanOrEqualTo(Long value) {
			addCriterion("coupon_entity_id >=", value, "couponEntityId");
			return (Criteria) this;
		}

		public Criteria andCouponEntityIdLessThan(Long value) {
			addCriterion("coupon_entity_id <", value, "couponEntityId");
			return (Criteria) this;
		}

		public Criteria andCouponEntityIdLessThanOrEqualTo(Long value) {
			addCriterion("coupon_entity_id <=", value, "couponEntityId");
			return (Criteria) this;
		}

		public Criteria andCouponEntityIdIn(List<Long> values) {
			addCriterion("coupon_entity_id in", values, "couponEntityId");
			return (Criteria) this;
		}

		public Criteria andCouponEntityIdNotIn(List<Long> values) {
			addCriterion("coupon_entity_id not in", values, "couponEntityId");
			return (Criteria) this;
		}

		public Criteria andCouponEntityIdBetween(Long value1, Long value2) {
			addCriterion("coupon_entity_id between", value1, value2, "couponEntityId");
			return (Criteria) this;
		}

		public Criteria andCouponEntityIdNotBetween(Long value1, Long value2) {
			addCriterion("coupon_entity_id not between", value1, value2, "couponEntityId");
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

		public Criteria andBusinessNameIsNull() {
			addCriterion("business_name is null");
			return (Criteria) this;
		}

		public Criteria andBusinessNameIsNotNull() {
			addCriterion("business_name is not null");
			return (Criteria) this;
		}

		public Criteria andBusinessNameEqualTo(String value) {
			addCriterion("business_name =", value, "businessName");
			return (Criteria) this;
		}

		public Criteria andBusinessNameNotEqualTo(String value) {
			addCriterion("business_name <>", value, "businessName");
			return (Criteria) this;
		}

		public Criteria andBusinessNameGreaterThan(String value) {
			addCriterion("business_name >", value, "businessName");
			return (Criteria) this;
		}

		public Criteria andBusinessNameGreaterThanOrEqualTo(String value) {
			addCriterion("business_name >=", value, "businessName");
			return (Criteria) this;
		}

		public Criteria andBusinessNameLessThan(String value) {
			addCriterion("business_name <", value, "businessName");
			return (Criteria) this;
		}

		public Criteria andBusinessNameLessThanOrEqualTo(String value) {
			addCriterion("business_name <=", value, "businessName");
			return (Criteria) this;
		}

		public Criteria andBusinessNameLike(String value) {
			addCriterion("business_name like", value, "businessName");
			return (Criteria) this;
		}

		public Criteria andBusinessNameNotLike(String value) {
			addCriterion("business_name not like", value, "businessName");
			return (Criteria) this;
		}

		public Criteria andBusinessNameIn(List<String> values) {
			addCriterion("business_name in", values, "businessName");
			return (Criteria) this;
		}

		public Criteria andBusinessNameNotIn(List<String> values) {
			addCriterion("business_name not in", values, "businessName");
			return (Criteria) this;
		}

		public Criteria andBusinessNameBetween(String value1, String value2) {
			addCriterion("business_name between", value1, value2, "businessName");
			return (Criteria) this;
		}

		public Criteria andBusinessNameNotBetween(String value1, String value2) {
			addCriterion("business_name not between", value1, value2, "businessName");
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

		public Criteria andCouponBatchSendRecordIdIsNull() {
			addCriterion("coupon_batch_send_record_id is null");
			return (Criteria) this;
		}

		public Criteria andCouponBatchSendRecordIdIsNotNull() {
			addCriterion("coupon_batch_send_record_id is not null");
			return (Criteria) this;
		}

		public Criteria andCouponBatchSendRecordIdEqualTo(Long value) {
			addCriterion("coupon_batch_send_record_id =", value, "couponBatchSendRecordId");
			return (Criteria) this;
		}

		public Criteria andCouponBatchSendRecordIdNotEqualTo(Long value) {
			addCriterion("coupon_batch_send_record_id <>", value, "couponBatchSendRecordId");
			return (Criteria) this;
		}

		public Criteria andCouponBatchSendRecordIdGreaterThan(Long value) {
			addCriterion("coupon_batch_send_record_id >", value, "couponBatchSendRecordId");
			return (Criteria) this;
		}

		public Criteria andCouponBatchSendRecordIdGreaterThanOrEqualTo(Long value) {
			addCriterion("coupon_batch_send_record_id >=", value, "couponBatchSendRecordId");
			return (Criteria) this;
		}

		public Criteria andCouponBatchSendRecordIdLessThan(Long value) {
			addCriterion("coupon_batch_send_record_id <", value, "couponBatchSendRecordId");
			return (Criteria) this;
		}

		public Criteria andCouponBatchSendRecordIdLessThanOrEqualTo(Long value) {
			addCriterion("coupon_batch_send_record_id <=", value, "couponBatchSendRecordId");
			return (Criteria) this;
		}

		public Criteria andCouponBatchSendRecordIdIn(List<Long> values) {
			addCriterion("coupon_batch_send_record_id in", values, "couponBatchSendRecordId");
			return (Criteria) this;
		}

		public Criteria andCouponBatchSendRecordIdNotIn(List<Long> values) {
			addCriterion("coupon_batch_send_record_id not in", values, "couponBatchSendRecordId");
			return (Criteria) this;
		}

		public Criteria andCouponBatchSendRecordIdBetween(Long value1, Long value2) {
			addCriterion("coupon_batch_send_record_id between", value1, value2, "couponBatchSendRecordId");
			return (Criteria) this;
		}

		public Criteria andCouponBatchSendRecordIdNotBetween(Long value1, Long value2) {
			addCriterion("coupon_batch_send_record_id not between", value1, value2, "couponBatchSendRecordId");
			return (Criteria) this;
		}

		public Criteria andMemberCodeIsNull() {
			addCriterion("member_code is null");
			return (Criteria) this;
		}

		public Criteria andMemberCodeIsNotNull() {
			addCriterion("member_code is not null");
			return (Criteria) this;
		}

		public Criteria andMemberCodeEqualTo(String value) {
			addCriterion("member_code =", value, "memberCode");
			return (Criteria) this;
		}

		public Criteria andMemberCodeNotEqualTo(String value) {
			addCriterion("member_code <>", value, "memberCode");
			return (Criteria) this;
		}

		public Criteria andMemberCodeGreaterThan(String value) {
			addCriterion("member_code >", value, "memberCode");
			return (Criteria) this;
		}

		public Criteria andMemberCodeGreaterThanOrEqualTo(String value) {
			addCriterion("member_code >=", value, "memberCode");
			return (Criteria) this;
		}

		public Criteria andMemberCodeLessThan(String value) {
			addCriterion("member_code <", value, "memberCode");
			return (Criteria) this;
		}

		public Criteria andMemberCodeLessThanOrEqualTo(String value) {
			addCriterion("member_code <=", value, "memberCode");
			return (Criteria) this;
		}

		public Criteria andMemberCodeLike(String value) {
			addCriterion("member_code like", value, "memberCode");
			return (Criteria) this;
		}

		public Criteria andMemberCodeNotLike(String value) {
			addCriterion("member_code not like", value, "memberCode");
			return (Criteria) this;
		}

		public Criteria andMemberCodeIn(List<String> values) {
			addCriterion("member_code in", values, "memberCode");
			return (Criteria) this;
		}

		public Criteria andMemberCodeNotIn(List<String> values) {
			addCriterion("member_code not in", values, "memberCode");
			return (Criteria) this;
		}

		public Criteria andMemberCodeBetween(String value1, String value2) {
			addCriterion("member_code between", value1, value2, "memberCode");
			return (Criteria) this;
		}

		public Criteria andMemberCodeNotBetween(String value1, String value2) {
			addCriterion("member_code not between", value1, value2, "memberCode");
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

		public Criteria andMoneyIsNull() {
			addCriterion("money is null");
			return (Criteria) this;
		}

		public Criteria andMoneyIsNotNull() {
			addCriterion("money is not null");
			return (Criteria) this;
		}

		public Criteria andMoneyEqualTo(BigDecimal value) {
			addCriterion("money =", value, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyNotEqualTo(BigDecimal value) {
			addCriterion("money <>", value, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyGreaterThan(BigDecimal value) {
			addCriterion("money >", value, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("money >=", value, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyLessThan(BigDecimal value) {
			addCriterion("money <", value, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyLessThanOrEqualTo(BigDecimal value) {
			addCriterion("money <=", value, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyIn(List<BigDecimal> values) {
			addCriterion("money in", values, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyNotIn(List<BigDecimal> values) {
			addCriterion("money not in", values, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("money between", value1, value2, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("money not between", value1, value2, "money");
			return (Criteria) this;
		}

		public Criteria andDiscountIsNull() {
			addCriterion("discount is null");
			return (Criteria) this;
		}

		public Criteria andDiscountIsNotNull() {
			addCriterion("discount is not null");
			return (Criteria) this;
		}

		public Criteria andDiscountEqualTo(BigDecimal value) {
			addCriterion("discount =", value, "discount");
			return (Criteria) this;
		}

		public Criteria andDiscountNotEqualTo(BigDecimal value) {
			addCriterion("discount <>", value, "discount");
			return (Criteria) this;
		}

		public Criteria andDiscountGreaterThan(BigDecimal value) {
			addCriterion("discount >", value, "discount");
			return (Criteria) this;
		}

		public Criteria andDiscountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("discount >=", value, "discount");
			return (Criteria) this;
		}

		public Criteria andDiscountLessThan(BigDecimal value) {
			addCriterion("discount <", value, "discount");
			return (Criteria) this;
		}

		public Criteria andDiscountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("discount <=", value, "discount");
			return (Criteria) this;
		}

		public Criteria andDiscountIn(List<BigDecimal> values) {
			addCriterion("discount in", values, "discount");
			return (Criteria) this;
		}

		public Criteria andDiscountNotIn(List<BigDecimal> values) {
			addCriterion("discount not in", values, "discount");
			return (Criteria) this;
		}

		public Criteria andDiscountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("discount between", value1, value2, "discount");
			return (Criteria) this;
		}

		public Criteria andDiscountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("discount not between", value1, value2, "discount");
			return (Criteria) this;
		}

		public Criteria andImgIsNull() {
			addCriterion("img is null");
			return (Criteria) this;
		}

		public Criteria andImgIsNotNull() {
			addCriterion("img is not null");
			return (Criteria) this;
		}

		public Criteria andImgEqualTo(String value) {
			addCriterion("img =", value, "img");
			return (Criteria) this;
		}

		public Criteria andImgNotEqualTo(String value) {
			addCriterion("img <>", value, "img");
			return (Criteria) this;
		}

		public Criteria andImgGreaterThan(String value) {
			addCriterion("img >", value, "img");
			return (Criteria) this;
		}

		public Criteria andImgGreaterThanOrEqualTo(String value) {
			addCriterion("img >=", value, "img");
			return (Criteria) this;
		}

		public Criteria andImgLessThan(String value) {
			addCriterion("img <", value, "img");
			return (Criteria) this;
		}

		public Criteria andImgLessThanOrEqualTo(String value) {
			addCriterion("img <=", value, "img");
			return (Criteria) this;
		}

		public Criteria andImgLike(String value) {
			addCriterion("img like", value, "img");
			return (Criteria) this;
		}

		public Criteria andImgNotLike(String value) {
			addCriterion("img not like", value, "img");
			return (Criteria) this;
		}

		public Criteria andImgIn(List<String> values) {
			addCriterion("img in", values, "img");
			return (Criteria) this;
		}

		public Criteria andImgNotIn(List<String> values) {
			addCriterion("img not in", values, "img");
			return (Criteria) this;
		}

		public Criteria andImgBetween(String value1, String value2) {
			addCriterion("img between", value1, value2, "img");
			return (Criteria) this;
		}

		public Criteria andImgNotBetween(String value1, String value2) {
			addCriterion("img not between", value1, value2, "img");
			return (Criteria) this;
		}

		public Criteria andInfoIsNull() {
			addCriterion("info is null");
			return (Criteria) this;
		}

		public Criteria andInfoIsNotNull() {
			addCriterion("info is not null");
			return (Criteria) this;
		}

		public Criteria andInfoEqualTo(String value) {
			addCriterion("info =", value, "info");
			return (Criteria) this;
		}

		public Criteria andInfoNotEqualTo(String value) {
			addCriterion("info <>", value, "info");
			return (Criteria) this;
		}

		public Criteria andInfoGreaterThan(String value) {
			addCriterion("info >", value, "info");
			return (Criteria) this;
		}

		public Criteria andInfoGreaterThanOrEqualTo(String value) {
			addCriterion("info >=", value, "info");
			return (Criteria) this;
		}

		public Criteria andInfoLessThan(String value) {
			addCriterion("info <", value, "info");
			return (Criteria) this;
		}

		public Criteria andInfoLessThanOrEqualTo(String value) {
			addCriterion("info <=", value, "info");
			return (Criteria) this;
		}

		public Criteria andInfoLike(String value) {
			addCriterion("info like", value, "info");
			return (Criteria) this;
		}

		public Criteria andInfoNotLike(String value) {
			addCriterion("info not like", value, "info");
			return (Criteria) this;
		}

		public Criteria andInfoIn(List<String> values) {
			addCriterion("info in", values, "info");
			return (Criteria) this;
		}

		public Criteria andInfoNotIn(List<String> values) {
			addCriterion("info not in", values, "info");
			return (Criteria) this;
		}

		public Criteria andInfoBetween(String value1, String value2) {
			addCriterion("info between", value1, value2, "info");
			return (Criteria) this;
		}

		public Criteria andInfoNotBetween(String value1, String value2) {
			addCriterion("info not between", value1, value2, "info");
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

		public Criteria andBindStatusEqualTo(Boolean value) {
			addCriterion("bind_status =", value, "bindStatus");
			return (Criteria) this;
		}

		public Criteria andBindStatusNotEqualTo(Boolean value) {
			addCriterion("bind_status <>", value, "bindStatus");
			return (Criteria) this;
		}

		public Criteria andBindStatusGreaterThan(Boolean value) {
			addCriterion("bind_status >", value, "bindStatus");
			return (Criteria) this;
		}

		public Criteria andBindStatusGreaterThanOrEqualTo(Boolean value) {
			addCriterion("bind_status >=", value, "bindStatus");
			return (Criteria) this;
		}

		public Criteria andBindStatusLessThan(Boolean value) {
			addCriterion("bind_status <", value, "bindStatus");
			return (Criteria) this;
		}

		public Criteria andBindStatusLessThanOrEqualTo(Boolean value) {
			addCriterion("bind_status <=", value, "bindStatus");
			return (Criteria) this;
		}

		public Criteria andBindStatusIn(List<Boolean> values) {
			addCriterion("bind_status in", values, "bindStatus");
			return (Criteria) this;
		}

		public Criteria andBindStatusNotIn(List<Boolean> values) {
			addCriterion("bind_status not in", values, "bindStatus");
			return (Criteria) this;
		}

		public Criteria andBindStatusBetween(Boolean value1, Boolean value2) {
			addCriterion("bind_status between", value1, value2, "bindStatus");
			return (Criteria) this;
		}

		public Criteria andBindStatusNotBetween(Boolean value1, Boolean value2) {
			addCriterion("bind_status not between", value1, value2, "bindStatus");
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

		public Criteria andIsLockIsNull() {
			addCriterion("is_lock is null");
			return (Criteria) this;
		}

		public Criteria andIsLockIsNotNull() {
			addCriterion("is_lock is not null");
			return (Criteria) this;
		}

		public Criteria andIsLockEqualTo(Boolean value) {
			addCriterion("is_lock =", value, "isLock");
			return (Criteria) this;
		}

		public Criteria andIsLockNotEqualTo(Boolean value) {
			addCriterion("is_lock <>", value, "isLock");
			return (Criteria) this;
		}

		public Criteria andIsLockGreaterThan(Boolean value) {
			addCriterion("is_lock >", value, "isLock");
			return (Criteria) this;
		}

		public Criteria andIsLockGreaterThanOrEqualTo(Boolean value) {
			addCriterion("is_lock >=", value, "isLock");
			return (Criteria) this;
		}

		public Criteria andIsLockLessThan(Boolean value) {
			addCriterion("is_lock <", value, "isLock");
			return (Criteria) this;
		}

		public Criteria andIsLockLessThanOrEqualTo(Boolean value) {
			addCriterion("is_lock <=", value, "isLock");
			return (Criteria) this;
		}

		public Criteria andIsLockIn(List<Boolean> values) {
			addCriterion("is_lock in", values, "isLock");
			return (Criteria) this;
		}

		public Criteria andIsLockNotIn(List<Boolean> values) {
			addCriterion("is_lock not in", values, "isLock");
			return (Criteria) this;
		}

		public Criteria andIsLockBetween(Boolean value1, Boolean value2) {
			addCriterion("is_lock between", value1, value2, "isLock");
			return (Criteria) this;
		}

		public Criteria andIsLockNotBetween(Boolean value1, Boolean value2) {
			addCriterion("is_lock not between", value1, value2, "isLock");
			return (Criteria) this;
		}

		public Criteria andUsePasswordIsNull() {
			addCriterion("use_password is null");
			return (Criteria) this;
		}

		public Criteria andUsePasswordIsNotNull() {
			addCriterion("use_password is not null");
			return (Criteria) this;
		}

		public Criteria andUsePasswordEqualTo(String value) {
			addCriterion("use_password =", value, "usePassword");
			return (Criteria) this;
		}

		public Criteria andUsePasswordNotEqualTo(String value) {
			addCriterion("use_password <>", value, "usePassword");
			return (Criteria) this;
		}

		public Criteria andUsePasswordGreaterThan(String value) {
			addCriterion("use_password >", value, "usePassword");
			return (Criteria) this;
		}

		public Criteria andUsePasswordGreaterThanOrEqualTo(String value) {
			addCriterion("use_password >=", value, "usePassword");
			return (Criteria) this;
		}

		public Criteria andUsePasswordLessThan(String value) {
			addCriterion("use_password <", value, "usePassword");
			return (Criteria) this;
		}

		public Criteria andUsePasswordLessThanOrEqualTo(String value) {
			addCriterion("use_password <=", value, "usePassword");
			return (Criteria) this;
		}

		public Criteria andUsePasswordLike(String value) {
			addCriterion("use_password like", value, "usePassword");
			return (Criteria) this;
		}

		public Criteria andUsePasswordNotLike(String value) {
			addCriterion("use_password not like", value, "usePassword");
			return (Criteria) this;
		}

		public Criteria andUsePasswordIn(List<String> values) {
			addCriterion("use_password in", values, "usePassword");
			return (Criteria) this;
		}

		public Criteria andUsePasswordNotIn(List<String> values) {
			addCriterion("use_password not in", values, "usePassword");
			return (Criteria) this;
		}

		public Criteria andUsePasswordBetween(String value1, String value2) {
			addCriterion("use_password between", value1, value2, "usePassword");
			return (Criteria) this;
		}

		public Criteria andUsePasswordNotBetween(String value1, String value2) {
			addCriterion("use_password not between", value1, value2, "usePassword");
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

		public Criteria andSendTypeEqualTo(String value) {
			addCriterion("send_type =", value, "sendType");
			return (Criteria) this;
		}

		public Criteria andSendTypeNotEqualTo(String value) {
			addCriterion("send_type <>", value, "sendType");
			return (Criteria) this;
		}

		public Criteria andSendTypeGreaterThan(String value) {
			addCriterion("send_type >", value, "sendType");
			return (Criteria) this;
		}

		public Criteria andSendTypeGreaterThanOrEqualTo(String value) {
			addCriterion("send_type >=", value, "sendType");
			return (Criteria) this;
		}

		public Criteria andSendTypeLessThan(String value) {
			addCriterion("send_type <", value, "sendType");
			return (Criteria) this;
		}

		public Criteria andSendTypeLessThanOrEqualTo(String value) {
			addCriterion("send_type <=", value, "sendType");
			return (Criteria) this;
		}

		public Criteria andSendTypeLike(String value) {
			addCriterion("send_type like", value, "sendType");
			return (Criteria) this;
		}

		public Criteria andSendTypeNotLike(String value) {
			addCriterion("send_type not like", value, "sendType");
			return (Criteria) this;
		}

		public Criteria andSendTypeIn(List<String> values) {
			addCriterion("send_type in", values, "sendType");
			return (Criteria) this;
		}

		public Criteria andSendTypeNotIn(List<String> values) {
			addCriterion("send_type not in", values, "sendType");
			return (Criteria) this;
		}

		public Criteria andSendTypeBetween(String value1, String value2) {
			addCriterion("send_type between", value1, value2, "sendType");
			return (Criteria) this;
		}

		public Criteria andSendTypeNotBetween(String value1, String value2) {
			addCriterion("send_type not between", value1, value2, "sendType");
			return (Criteria) this;
		}

		public Criteria andSendBusinessIdIsNull() {
			addCriterion("send_business_id is null");
			return (Criteria) this;
		}

		public Criteria andSendBusinessIdIsNotNull() {
			addCriterion("send_business_id is not null");
			return (Criteria) this;
		}

		public Criteria andSendBusinessIdEqualTo(Long value) {
			addCriterion("send_business_id =", value, "sendBusinessId");
			return (Criteria) this;
		}

		public Criteria andSendBusinessIdNotEqualTo(Long value) {
			addCriterion("send_business_id <>", value, "sendBusinessId");
			return (Criteria) this;
		}

		public Criteria andSendBusinessIdGreaterThan(Long value) {
			addCriterion("send_business_id >", value, "sendBusinessId");
			return (Criteria) this;
		}

		public Criteria andSendBusinessIdGreaterThanOrEqualTo(Long value) {
			addCriterion("send_business_id >=", value, "sendBusinessId");
			return (Criteria) this;
		}

		public Criteria andSendBusinessIdLessThan(Long value) {
			addCriterion("send_business_id <", value, "sendBusinessId");
			return (Criteria) this;
		}

		public Criteria andSendBusinessIdLessThanOrEqualTo(Long value) {
			addCriterion("send_business_id <=", value, "sendBusinessId");
			return (Criteria) this;
		}

		public Criteria andSendBusinessIdIn(List<Long> values) {
			addCriterion("send_business_id in", values, "sendBusinessId");
			return (Criteria) this;
		}

		public Criteria andSendBusinessIdNotIn(List<Long> values) {
			addCriterion("send_business_id not in", values, "sendBusinessId");
			return (Criteria) this;
		}

		public Criteria andSendBusinessIdBetween(Long value1, Long value2) {
			addCriterion("send_business_id between", value1, value2, "sendBusinessId");
			return (Criteria) this;
		}

		public Criteria andSendBusinessIdNotBetween(Long value1, Long value2) {
			addCriterion("send_business_id not between", value1, value2, "sendBusinessId");
			return (Criteria) this;
		}

		public Criteria andUseTypeIsNull() {
			addCriterion("use_type is null");
			return (Criteria) this;
		}

		public Criteria andUseTypeIsNotNull() {
			addCriterion("use_type is not null");
			return (Criteria) this;
		}

		public Criteria andUseTypeEqualTo(Byte value) {
			addCriterion("use_type =", value, "useType");
			return (Criteria) this;
		}

		public Criteria andUseTypeNotEqualTo(Byte value) {
			addCriterion("use_type <>", value, "useType");
			return (Criteria) this;
		}

		public Criteria andUseTypeGreaterThan(Byte value) {
			addCriterion("use_type >", value, "useType");
			return (Criteria) this;
		}

		public Criteria andUseTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("use_type >=", value, "useType");
			return (Criteria) this;
		}

		public Criteria andUseTypeLessThan(Byte value) {
			addCriterion("use_type <", value, "useType");
			return (Criteria) this;
		}

		public Criteria andUseTypeLessThanOrEqualTo(Byte value) {
			addCriterion("use_type <=", value, "useType");
			return (Criteria) this;
		}

		public Criteria andUseTypeIn(List<Byte> values) {
			addCriterion("use_type in", values, "useType");
			return (Criteria) this;
		}

		public Criteria andUseTypeNotIn(List<Byte> values) {
			addCriterion("use_type not in", values, "useType");
			return (Criteria) this;
		}

		public Criteria andUseTypeBetween(Byte value1, Byte value2) {
			addCriterion("use_type between", value1, value2, "useType");
			return (Criteria) this;
		}

		public Criteria andUseTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("use_type not between", value1, value2, "useType");
			return (Criteria) this;
		}

		public Criteria andUseStoreIdIsNull() {
			addCriterion("use_store_id is null");
			return (Criteria) this;
		}

		public Criteria andUseStoreIdIsNotNull() {
			addCriterion("use_store_id is not null");
			return (Criteria) this;
		}

		public Criteria andUseStoreIdEqualTo(Long value) {
			addCriterion("use_store_id =", value, "useStoreId");
			return (Criteria) this;
		}

		public Criteria andUseStoreIdNotEqualTo(Long value) {
			addCriterion("use_store_id <>", value, "useStoreId");
			return (Criteria) this;
		}

		public Criteria andUseStoreIdGreaterThan(Long value) {
			addCriterion("use_store_id >", value, "useStoreId");
			return (Criteria) this;
		}

		public Criteria andUseStoreIdGreaterThanOrEqualTo(Long value) {
			addCriterion("use_store_id >=", value, "useStoreId");
			return (Criteria) this;
		}

		public Criteria andUseStoreIdLessThan(Long value) {
			addCriterion("use_store_id <", value, "useStoreId");
			return (Criteria) this;
		}

		public Criteria andUseStoreIdLessThanOrEqualTo(Long value) {
			addCriterion("use_store_id <=", value, "useStoreId");
			return (Criteria) this;
		}

		public Criteria andUseStoreIdIn(List<Long> values) {
			addCriterion("use_store_id in", values, "useStoreId");
			return (Criteria) this;
		}

		public Criteria andUseStoreIdNotIn(List<Long> values) {
			addCriterion("use_store_id not in", values, "useStoreId");
			return (Criteria) this;
		}

		public Criteria andUseStoreIdBetween(Long value1, Long value2) {
			addCriterion("use_store_id between", value1, value2, "useStoreId");
			return (Criteria) this;
		}

		public Criteria andUseStoreIdNotBetween(Long value1, Long value2) {
			addCriterion("use_store_id not between", value1, value2, "useStoreId");
			return (Criteria) this;
		}

		public Criteria andUseBusinessCodeIsNull() {
			addCriterion("use_business_code is null");
			return (Criteria) this;
		}

		public Criteria andUseBusinessCodeIsNotNull() {
			addCriterion("use_business_code is not null");
			return (Criteria) this;
		}

		public Criteria andUseBusinessCodeEqualTo(String value) {
			addCriterion("use_business_code =", value, "useBusinessCode");
			return (Criteria) this;
		}

		public Criteria andUseBusinessCodeNotEqualTo(String value) {
			addCriterion("use_business_code <>", value, "useBusinessCode");
			return (Criteria) this;
		}

		public Criteria andUseBusinessCodeGreaterThan(String value) {
			addCriterion("use_business_code >", value, "useBusinessCode");
			return (Criteria) this;
		}

		public Criteria andUseBusinessCodeGreaterThanOrEqualTo(String value) {
			addCriterion("use_business_code >=", value, "useBusinessCode");
			return (Criteria) this;
		}

		public Criteria andUseBusinessCodeLessThan(String value) {
			addCriterion("use_business_code <", value, "useBusinessCode");
			return (Criteria) this;
		}

		public Criteria andUseBusinessCodeLessThanOrEqualTo(String value) {
			addCriterion("use_business_code <=", value, "useBusinessCode");
			return (Criteria) this;
		}

		public Criteria andUseBusinessCodeLike(String value) {
			addCriterion("use_business_code like", value, "useBusinessCode");
			return (Criteria) this;
		}

		public Criteria andUseBusinessCodeNotLike(String value) {
			addCriterion("use_business_code not like", value, "useBusinessCode");
			return (Criteria) this;
		}

		public Criteria andUseBusinessCodeIn(List<String> values) {
			addCriterion("use_business_code in", values, "useBusinessCode");
			return (Criteria) this;
		}

		public Criteria andUseBusinessCodeNotIn(List<String> values) {
			addCriterion("use_business_code not in", values, "useBusinessCode");
			return (Criteria) this;
		}

		public Criteria andUseBusinessCodeBetween(String value1, String value2) {
			addCriterion("use_business_code between", value1, value2, "useBusinessCode");
			return (Criteria) this;
		}

		public Criteria andUseBusinessCodeNotBetween(String value1, String value2) {
			addCriterion("use_business_code not between", value1, value2, "useBusinessCode");
			return (Criteria) this;
		}

		public Criteria andUseBusinessAmountIsNull() {
			addCriterion("use_business_amount is null");
			return (Criteria) this;
		}

		public Criteria andUseBusinessAmountIsNotNull() {
			addCriterion("use_business_amount is not null");
			return (Criteria) this;
		}

		public Criteria andUseBusinessAmountEqualTo(BigDecimal value) {
			addCriterion("use_business_amount =", value, "useBusinessAmount");
			return (Criteria) this;
		}

		public Criteria andUseBusinessAmountNotEqualTo(BigDecimal value) {
			addCriterion("use_business_amount <>", value, "useBusinessAmount");
			return (Criteria) this;
		}

		public Criteria andUseBusinessAmountGreaterThan(BigDecimal value) {
			addCriterion("use_business_amount >", value, "useBusinessAmount");
			return (Criteria) this;
		}

		public Criteria andUseBusinessAmountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("use_business_amount >=", value, "useBusinessAmount");
			return (Criteria) this;
		}

		public Criteria andUseBusinessAmountLessThan(BigDecimal value) {
			addCriterion("use_business_amount <", value, "useBusinessAmount");
			return (Criteria) this;
		}

		public Criteria andUseBusinessAmountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("use_business_amount <=", value, "useBusinessAmount");
			return (Criteria) this;
		}

		public Criteria andUseBusinessAmountIn(List<BigDecimal> values) {
			addCriterion("use_business_amount in", values, "useBusinessAmount");
			return (Criteria) this;
		}

		public Criteria andUseBusinessAmountNotIn(List<BigDecimal> values) {
			addCriterion("use_business_amount not in", values, "useBusinessAmount");
			return (Criteria) this;
		}

		public Criteria andUseBusinessAmountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("use_business_amount between", value1, value2, "useBusinessAmount");
			return (Criteria) this;
		}

		public Criteria andUseBusinessAmountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("use_business_amount not between", value1, value2, "useBusinessAmount");
			return (Criteria) this;
		}

		public Criteria andUseTimeIsNull() {
			addCriterion("use_time is null");
			return (Criteria) this;
		}

		public Criteria andUseTimeIsNotNull() {
			addCriterion("use_time is not null");
			return (Criteria) this;
		}

		public Criteria andUseTimeEqualTo(Date value) {
			addCriterion("use_time =", value, "useTime");
			return (Criteria) this;
		}

		public Criteria andUseTimeNotEqualTo(Date value) {
			addCriterion("use_time <>", value, "useTime");
			return (Criteria) this;
		}

		public Criteria andUseTimeGreaterThan(Date value) {
			addCriterion("use_time >", value, "useTime");
			return (Criteria) this;
		}

		public Criteria andUseTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("use_time >=", value, "useTime");
			return (Criteria) this;
		}

		public Criteria andUseTimeLessThan(Date value) {
			addCriterion("use_time <", value, "useTime");
			return (Criteria) this;
		}

		public Criteria andUseTimeLessThanOrEqualTo(Date value) {
			addCriterion("use_time <=", value, "useTime");
			return (Criteria) this;
		}

		public Criteria andUseTimeIn(List<Date> values) {
			addCriterion("use_time in", values, "useTime");
			return (Criteria) this;
		}

		public Criteria andUseTimeNotIn(List<Date> values) {
			addCriterion("use_time not in", values, "useTime");
			return (Criteria) this;
		}

		public Criteria andUseTimeBetween(Date value1, Date value2) {
			addCriterion("use_time between", value1, value2, "useTime");
			return (Criteria) this;
		}

		public Criteria andUseTimeNotBetween(Date value1, Date value2) {
			addCriterion("use_time not between", value1, value2, "useTime");
			return (Criteria) this;
		}

		public Criteria andUseFromIsNull() {
			addCriterion("use_from is null");
			return (Criteria) this;
		}

		public Criteria andUseFromIsNotNull() {
			addCriterion("use_from is not null");
			return (Criteria) this;
		}

		public Criteria andUseFromEqualTo(Byte value) {
			addCriterion("use_from =", value, "useFrom");
			return (Criteria) this;
		}

		public Criteria andUseFromNotEqualTo(Byte value) {
			addCriterion("use_from <>", value, "useFrom");
			return (Criteria) this;
		}

		public Criteria andUseFromGreaterThan(Byte value) {
			addCriterion("use_from >", value, "useFrom");
			return (Criteria) this;
		}

		public Criteria andUseFromGreaterThanOrEqualTo(Byte value) {
			addCriterion("use_from >=", value, "useFrom");
			return (Criteria) this;
		}

		public Criteria andUseFromLessThan(Byte value) {
			addCriterion("use_from <", value, "useFrom");
			return (Criteria) this;
		}

		public Criteria andUseFromLessThanOrEqualTo(Byte value) {
			addCriterion("use_from <=", value, "useFrom");
			return (Criteria) this;
		}

		public Criteria andUseFromIn(List<Byte> values) {
			addCriterion("use_from in", values, "useFrom");
			return (Criteria) this;
		}

		public Criteria andUseFromNotIn(List<Byte> values) {
			addCriterion("use_from not in", values, "useFrom");
			return (Criteria) this;
		}

		public Criteria andUseFromBetween(Byte value1, Byte value2) {
			addCriterion("use_from between", value1, value2, "useFrom");
			return (Criteria) this;
		}

		public Criteria andUseFromNotBetween(Byte value1, Byte value2) {
			addCriterion("use_from not between", value1, value2, "useFrom");
			return (Criteria) this;
		}

		public Criteria andStaffCodeIsNull() {
			addCriterion("staff_code is null");
			return (Criteria) this;
		}

		public Criteria andStaffCodeIsNotNull() {
			addCriterion("staff_code is not null");
			return (Criteria) this;
		}

		public Criteria andStaffCodeEqualTo(String value) {
			addCriterion("staff_code =", value, "staffCode");
			return (Criteria) this;
		}

		public Criteria andStaffCodeNotEqualTo(String value) {
			addCriterion("staff_code <>", value, "staffCode");
			return (Criteria) this;
		}

		public Criteria andStaffCodeGreaterThan(String value) {
			addCriterion("staff_code >", value, "staffCode");
			return (Criteria) this;
		}

		public Criteria andStaffCodeGreaterThanOrEqualTo(String value) {
			addCriterion("staff_code >=", value, "staffCode");
			return (Criteria) this;
		}

		public Criteria andStaffCodeLessThan(String value) {
			addCriterion("staff_code <", value, "staffCode");
			return (Criteria) this;
		}

		public Criteria andStaffCodeLessThanOrEqualTo(String value) {
			addCriterion("staff_code <=", value, "staffCode");
			return (Criteria) this;
		}

		public Criteria andStaffCodeLike(String value) {
			addCriterion("staff_code like", value, "staffCode");
			return (Criteria) this;
		}

		public Criteria andStaffCodeNotLike(String value) {
			addCriterion("staff_code not like", value, "staffCode");
			return (Criteria) this;
		}

		public Criteria andStaffCodeIn(List<String> values) {
			addCriterion("staff_code in", values, "staffCode");
			return (Criteria) this;
		}

		public Criteria andStaffCodeNotIn(List<String> values) {
			addCriterion("staff_code not in", values, "staffCode");
			return (Criteria) this;
		}

		public Criteria andStaffCodeBetween(String value1, String value2) {
			addCriterion("staff_code between", value1, value2, "staffCode");
			return (Criteria) this;
		}

		public Criteria andStaffCodeNotBetween(String value1, String value2) {
			addCriterion("staff_code not between", value1, value2, "staffCode");
			return (Criteria) this;
		}

		public Criteria andIsUseIsNull() {
			addCriterion("is_use is null");
			return (Criteria) this;
		}

		public Criteria andIsUseIsNotNull() {
			addCriterion("is_use is not null");
			return (Criteria) this;
		}

		public Criteria andIsUseEqualTo(Boolean value) {
			addCriterion("is_use =", value, "isUse");
			return (Criteria) this;
		}

		public Criteria andIsUseNotEqualTo(Boolean value) {
			addCriterion("is_use <>", value, "isUse");
			return (Criteria) this;
		}

		public Criteria andIsUseGreaterThan(Boolean value) {
			addCriterion("is_use >", value, "isUse");
			return (Criteria) this;
		}

		public Criteria andIsUseGreaterThanOrEqualTo(Boolean value) {
			addCriterion("is_use >=", value, "isUse");
			return (Criteria) this;
		}

		public Criteria andIsUseLessThan(Boolean value) {
			addCriterion("is_use <", value, "isUse");
			return (Criteria) this;
		}

		public Criteria andIsUseLessThanOrEqualTo(Boolean value) {
			addCriterion("is_use <=", value, "isUse");
			return (Criteria) this;
		}

		public Criteria andIsUseIn(List<Boolean> values) {
			addCriterion("is_use in", values, "isUse");
			return (Criteria) this;
		}

		public Criteria andIsUseNotIn(List<Boolean> values) {
			addCriterion("is_use not in", values, "isUse");
			return (Criteria) this;
		}

		public Criteria andIsUseBetween(Boolean value1, Boolean value2) {
			addCriterion("is_use between", value1, value2, "isUse");
			return (Criteria) this;
		}

		public Criteria andIsUseNotBetween(Boolean value1, Boolean value2) {
			addCriterion("is_use not between", value1, value2, "isUse");
			return (Criteria) this;
		}

		public Criteria andCouponStatusIsNull() {
			addCriterion("coupon_status is null");
			return (Criteria) this;
		}

		public Criteria andCouponStatusIsNotNull() {
			addCriterion("coupon_status is not null");
			return (Criteria) this;
		}

		public Criteria andCouponStatusEqualTo(Byte value) {
			addCriterion("coupon_status =", value, "couponStatus");
			return (Criteria) this;
		}

		public Criteria andCouponStatusNotEqualTo(Byte value) {
			addCriterion("coupon_status <>", value, "couponStatus");
			return (Criteria) this;
		}

		public Criteria andCouponStatusGreaterThan(Byte value) {
			addCriterion("coupon_status >", value, "couponStatus");
			return (Criteria) this;
		}

		public Criteria andCouponStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("coupon_status >=", value, "couponStatus");
			return (Criteria) this;
		}

		public Criteria andCouponStatusLessThan(Byte value) {
			addCriterion("coupon_status <", value, "couponStatus");
			return (Criteria) this;
		}

		public Criteria andCouponStatusLessThanOrEqualTo(Byte value) {
			addCriterion("coupon_status <=", value, "couponStatus");
			return (Criteria) this;
		}

		public Criteria andCouponStatusIn(List<Byte> values) {
			addCriterion("coupon_status in", values, "couponStatus");
			return (Criteria) this;
		}

		public Criteria andCouponStatusNotIn(List<Byte> values) {
			addCriterion("coupon_status not in", values, "couponStatus");
			return (Criteria) this;
		}

		public Criteria andCouponStatusBetween(Byte value1, Byte value2) {
			addCriterion("coupon_status between", value1, value2, "couponStatus");
			return (Criteria) this;
		}

		public Criteria andCouponStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("coupon_status not between", value1, value2, "couponStatus");
			return (Criteria) this;
		}

		public Criteria andBarcodeUrlIsNull() {
			addCriterion("barcode_url is null");
			return (Criteria) this;
		}

		public Criteria andBarcodeUrlIsNotNull() {
			addCriterion("barcode_url is not null");
			return (Criteria) this;
		}

		public Criteria andBarcodeUrlEqualTo(String value) {
			addCriterion("barcode_url =", value, "barcodeUrl");
			return (Criteria) this;
		}

		public Criteria andBarcodeUrlNotEqualTo(String value) {
			addCriterion("barcode_url <>", value, "barcodeUrl");
			return (Criteria) this;
		}

		public Criteria andBarcodeUrlGreaterThan(String value) {
			addCriterion("barcode_url >", value, "barcodeUrl");
			return (Criteria) this;
		}

		public Criteria andBarcodeUrlGreaterThanOrEqualTo(String value) {
			addCriterion("barcode_url >=", value, "barcodeUrl");
			return (Criteria) this;
		}

		public Criteria andBarcodeUrlLessThan(String value) {
			addCriterion("barcode_url <", value, "barcodeUrl");
			return (Criteria) this;
		}

		public Criteria andBarcodeUrlLessThanOrEqualTo(String value) {
			addCriterion("barcode_url <=", value, "barcodeUrl");
			return (Criteria) this;
		}

		public Criteria andBarcodeUrlLike(String value) {
			addCriterion("barcode_url like", value, "barcodeUrl");
			return (Criteria) this;
		}

		public Criteria andBarcodeUrlNotLike(String value) {
			addCriterion("barcode_url not like", value, "barcodeUrl");
			return (Criteria) this;
		}

		public Criteria andBarcodeUrlIn(List<String> values) {
			addCriterion("barcode_url in", values, "barcodeUrl");
			return (Criteria) this;
		}

		public Criteria andBarcodeUrlNotIn(List<String> values) {
			addCriterion("barcode_url not in", values, "barcodeUrl");
			return (Criteria) this;
		}

		public Criteria andBarcodeUrlBetween(String value1, String value2) {
			addCriterion("barcode_url between", value1, value2, "barcodeUrl");
			return (Criteria) this;
		}

		public Criteria andBarcodeUrlNotBetween(String value1, String value2) {
			addCriterion("barcode_url not between", value1, value2, "barcodeUrl");
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

		public Criteria andGiveIsNull() {
			addCriterion("give is null");
			return (Criteria) this;
		}

		public Criteria andGiveIsNotNull() {
			addCriterion("give is not null");
			return (Criteria) this;
		}

		public Criteria andGiveEqualTo(Boolean value) {
			addCriterion("give =", value, "give");
			return (Criteria) this;
		}

		public Criteria andGiveNotEqualTo(Boolean value) {
			addCriterion("give <>", value, "give");
			return (Criteria) this;
		}

		public Criteria andGiveGreaterThan(Boolean value) {
			addCriterion("give >", value, "give");
			return (Criteria) this;
		}

		public Criteria andGiveGreaterThanOrEqualTo(Boolean value) {
			addCriterion("give >=", value, "give");
			return (Criteria) this;
		}

		public Criteria andGiveLessThan(Boolean value) {
			addCriterion("give <", value, "give");
			return (Criteria) this;
		}

		public Criteria andGiveLessThanOrEqualTo(Boolean value) {
			addCriterion("give <=", value, "give");
			return (Criteria) this;
		}

		public Criteria andGiveIn(List<Boolean> values) {
			addCriterion("give in", values, "give");
			return (Criteria) this;
		}

		public Criteria andGiveNotIn(List<Boolean> values) {
			addCriterion("give not in", values, "give");
			return (Criteria) this;
		}

		public Criteria andGiveBetween(Boolean value1, Boolean value2) {
			addCriterion("give between", value1, value2, "give");
			return (Criteria) this;
		}

		public Criteria andGiveNotBetween(Boolean value1, Boolean value2) {
			addCriterion("give not between", value1, value2, "give");
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

		public Criteria andAstaffCodeIsNull() {
			addCriterion("Astaff_code is null");
			return (Criteria) this;
		}

		public Criteria andAstaffCodeIsNotNull() {
			addCriterion("Astaff_code is not null");
			return (Criteria) this;
		}

		public Criteria andAstaffCodeEqualTo(String value) {
			addCriterion("Astaff_code =", value, "astaffCode");
			return (Criteria) this;
		}

		public Criteria andAstaffCodeNotEqualTo(String value) {
			addCriterion("Astaff_code <>", value, "astaffCode");
			return (Criteria) this;
		}

		public Criteria andAstaffCodeGreaterThan(String value) {
			addCriterion("Astaff_code >", value, "astaffCode");
			return (Criteria) this;
		}

		public Criteria andAstaffCodeGreaterThanOrEqualTo(String value) {
			addCriterion("Astaff_code >=", value, "astaffCode");
			return (Criteria) this;
		}

		public Criteria andAstaffCodeLessThan(String value) {
			addCriterion("Astaff_code <", value, "astaffCode");
			return (Criteria) this;
		}

		public Criteria andAstaffCodeLessThanOrEqualTo(String value) {
			addCriterion("Astaff_code <=", value, "astaffCode");
			return (Criteria) this;
		}

		public Criteria andAstaffCodeLike(String value) {
			addCriterion("Astaff_code like", value, "astaffCode");
			return (Criteria) this;
		}

		public Criteria andAstaffCodeNotLike(String value) {
			addCriterion("Astaff_code not like", value, "astaffCode");
			return (Criteria) this;
		}

		public Criteria andAstaffCodeIn(List<String> values) {
			addCriterion("Astaff_code in", values, "astaffCode");
			return (Criteria) this;
		}

		public Criteria andAstaffCodeNotIn(List<String> values) {
			addCriterion("Astaff_code not in", values, "astaffCode");
			return (Criteria) this;
		}

		public Criteria andAstaffCodeBetween(String value1, String value2) {
			addCriterion("Astaff_code between", value1, value2, "astaffCode");
			return (Criteria) this;
		}

		public Criteria andAstaffCodeNotBetween(String value1, String value2) {
			addCriterion("Astaff_code not between", value1, value2, "astaffCode");
			return (Criteria) this;
		}

		public Criteria andTransferSendIsNull() {
			addCriterion("transfer_send is null");
			return (Criteria) this;
		}

		public Criteria andTransferSendIsNotNull() {
			addCriterion("transfer_send is not null");
			return (Criteria) this;
		}

		public Criteria andTransferSendEqualTo(Boolean value) {
			addCriterion("transfer_send =", value, "transferSend");
			return (Criteria) this;
		}

		public Criteria andTransferSendNotEqualTo(Boolean value) {
			addCriterion("transfer_send <>", value, "transferSend");
			return (Criteria) this;
		}

		public Criteria andTransferSendGreaterThan(Boolean value) {
			addCriterion("transfer_send >", value, "transferSend");
			return (Criteria) this;
		}

		public Criteria andTransferSendGreaterThanOrEqualTo(Boolean value) {
			addCriterion("transfer_send >=", value, "transferSend");
			return (Criteria) this;
		}

		public Criteria andTransferSendLessThan(Boolean value) {
			addCriterion("transfer_send <", value, "transferSend");
			return (Criteria) this;
		}

		public Criteria andTransferSendLessThanOrEqualTo(Boolean value) {
			addCriterion("transfer_send <=", value, "transferSend");
			return (Criteria) this;
		}

		public Criteria andTransferSendIn(List<Boolean> values) {
			addCriterion("transfer_send in", values, "transferSend");
			return (Criteria) this;
		}

		public Criteria andTransferSendNotIn(List<Boolean> values) {
			addCriterion("transfer_send not in", values, "transferSend");
			return (Criteria) this;
		}

		public Criteria andTransferSendBetween(Boolean value1, Boolean value2) {
			addCriterion("transfer_send between", value1, value2, "transferSend");
			return (Criteria) this;
		}

		public Criteria andTransferSendNotBetween(Boolean value1, Boolean value2) {
			addCriterion("transfer_send not between", value1, value2, "transferSend");
			return (Criteria) this;
		}

		public Criteria andTransferCouponDefinitionIdIsNull() {
			addCriterion("transfer_coupon_definition_id is null");
			return (Criteria) this;
		}

		public Criteria andTransferCouponDefinitionIdIsNotNull() {
			addCriterion("transfer_coupon_definition_id is not null");
			return (Criteria) this;
		}

		public Criteria andTransferCouponDefinitionIdEqualTo(Long value) {
			addCriterion("transfer_coupon_definition_id =", value, "transferCouponDefinitionId");
			return (Criteria) this;
		}

		public Criteria andTransferCouponDefinitionIdNotEqualTo(Long value) {
			addCriterion("transfer_coupon_definition_id <>", value, "transferCouponDefinitionId");
			return (Criteria) this;
		}

		public Criteria andTransferCouponDefinitionIdGreaterThan(Long value) {
			addCriterion("transfer_coupon_definition_id >", value, "transferCouponDefinitionId");
			return (Criteria) this;
		}

		public Criteria andTransferCouponDefinitionIdGreaterThanOrEqualTo(Long value) {
			addCriterion("transfer_coupon_definition_id >=", value, "transferCouponDefinitionId");
			return (Criteria) this;
		}

		public Criteria andTransferCouponDefinitionIdLessThan(Long value) {
			addCriterion("transfer_coupon_definition_id <", value, "transferCouponDefinitionId");
			return (Criteria) this;
		}

		public Criteria andTransferCouponDefinitionIdLessThanOrEqualTo(Long value) {
			addCriterion("transfer_coupon_definition_id <=", value, "transferCouponDefinitionId");
			return (Criteria) this;
		}

		public Criteria andTransferCouponDefinitionIdIn(List<Long> values) {
			addCriterion("transfer_coupon_definition_id in", values, "transferCouponDefinitionId");
			return (Criteria) this;
		}

		public Criteria andTransferCouponDefinitionIdNotIn(List<Long> values) {
			addCriterion("transfer_coupon_definition_id not in", values, "transferCouponDefinitionId");
			return (Criteria) this;
		}

		public Criteria andTransferCouponDefinitionIdBetween(Long value1, Long value2) {
			addCriterion("transfer_coupon_definition_id between", value1, value2, "transferCouponDefinitionId");
			return (Criteria) this;
		}

		public Criteria andTransferCouponDefinitionIdNotBetween(Long value1, Long value2) {
			addCriterion("transfer_coupon_definition_id not between", value1, value2, "transferCouponDefinitionId");
			return (Criteria) this;
		}

		public Criteria andTransferMemberCodeIsNull() {
			addCriterion("transfer_member_code is null");
			return (Criteria) this;
		}

		public Criteria andTransferMemberCodeIsNotNull() {
			addCriterion("transfer_member_code is not null");
			return (Criteria) this;
		}

		public Criteria andTransferMemberCodeEqualTo(String value) {
			addCriterion("transfer_member_code =", value, "transferMemberCode");
			return (Criteria) this;
		}

		public Criteria andTransferMemberCodeNotEqualTo(String value) {
			addCriterion("transfer_member_code <>", value, "transferMemberCode");
			return (Criteria) this;
		}

		public Criteria andTransferMemberCodeGreaterThan(String value) {
			addCriterion("transfer_member_code >", value, "transferMemberCode");
			return (Criteria) this;
		}

		public Criteria andTransferMemberCodeGreaterThanOrEqualTo(String value) {
			addCriterion("transfer_member_code >=", value, "transferMemberCode");
			return (Criteria) this;
		}

		public Criteria andTransferMemberCodeLessThan(String value) {
			addCriterion("transfer_member_code <", value, "transferMemberCode");
			return (Criteria) this;
		}

		public Criteria andTransferMemberCodeLessThanOrEqualTo(String value) {
			addCriterion("transfer_member_code <=", value, "transferMemberCode");
			return (Criteria) this;
		}

		public Criteria andTransferMemberCodeLike(String value) {
			addCriterion("transfer_member_code like", value, "transferMemberCode");
			return (Criteria) this;
		}

		public Criteria andTransferMemberCodeNotLike(String value) {
			addCriterion("transfer_member_code not like", value, "transferMemberCode");
			return (Criteria) this;
		}

		public Criteria andTransferMemberCodeIn(List<String> values) {
			addCriterion("transfer_member_code in", values, "transferMemberCode");
			return (Criteria) this;
		}

		public Criteria andTransferMemberCodeNotIn(List<String> values) {
			addCriterion("transfer_member_code not in", values, "transferMemberCode");
			return (Criteria) this;
		}

		public Criteria andTransferMemberCodeBetween(String value1, String value2) {
			addCriterion("transfer_member_code between", value1, value2, "transferMemberCode");
			return (Criteria) this;
		}

		public Criteria andTransferMemberCodeNotBetween(String value1, String value2) {
			addCriterion("transfer_member_code not between", value1, value2, "transferMemberCode");
			return (Criteria) this;
		}

		public Criteria andTransferInfoIsNull() {
			addCriterion("transfer_info is null");
			return (Criteria) this;
		}

		public Criteria andTransferInfoIsNotNull() {
			addCriterion("transfer_info is not null");
			return (Criteria) this;
		}

		public Criteria andTransferInfoEqualTo(String value) {
			addCriterion("transfer_info =", value, "transferInfo");
			return (Criteria) this;
		}

		public Criteria andTransferInfoNotEqualTo(String value) {
			addCriterion("transfer_info <>", value, "transferInfo");
			return (Criteria) this;
		}

		public Criteria andTransferInfoGreaterThan(String value) {
			addCriterion("transfer_info >", value, "transferInfo");
			return (Criteria) this;
		}

		public Criteria andTransferInfoGreaterThanOrEqualTo(String value) {
			addCriterion("transfer_info >=", value, "transferInfo");
			return (Criteria) this;
		}

		public Criteria andTransferInfoLessThan(String value) {
			addCriterion("transfer_info <", value, "transferInfo");
			return (Criteria) this;
		}

		public Criteria andTransferInfoLessThanOrEqualTo(String value) {
			addCriterion("transfer_info <=", value, "transferInfo");
			return (Criteria) this;
		}

		public Criteria andTransferInfoLike(String value) {
			addCriterion("transfer_info like", value, "transferInfo");
			return (Criteria) this;
		}

		public Criteria andTransferInfoNotLike(String value) {
			addCriterion("transfer_info not like", value, "transferInfo");
			return (Criteria) this;
		}

		public Criteria andTransferInfoIn(List<String> values) {
			addCriterion("transfer_info in", values, "transferInfo");
			return (Criteria) this;
		}

		public Criteria andTransferInfoNotIn(List<String> values) {
			addCriterion("transfer_info not in", values, "transferInfo");
			return (Criteria) this;
		}

		public Criteria andTransferInfoBetween(String value1, String value2) {
			addCriterion("transfer_info between", value1, value2, "transferInfo");
			return (Criteria) this;
		}

		public Criteria andTransferInfoNotBetween(String value1, String value2) {
			addCriterion("transfer_info not between", value1, value2, "transferInfo");
			return (Criteria) this;
		}
	}

	/**
	 * 只读. t_coupon_entity
	 * @mbg.generated  2019-01-17 16:08:03
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
     * This class corresponds to the database table t_coupon_entity
     *
     * @mbg.generated do_not_delete_during_merge 2018-12-12 11:07:16
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }
}