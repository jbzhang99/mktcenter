package com.bizvane.mktcenterservice.models.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MktConvertCouponRecordPOExample implements Serializable {
    /**
	 * 只读. 
	 * @mbg.generated  2018-11-23 11:48:52
	 */
	protected String orderByClause;
	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 11:48:52
	 */
	protected boolean distinct;
	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 11:48:52
	 */
	protected List<Criteria> oredCriteria;
	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 11:48:52
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 11:48:52
	 */
	public MktConvertCouponRecordPOExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 11:48:52
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 11:48:52
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 11:48:52
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 11:48:52
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 11:48:52
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 11:48:52
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 11:48:52
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 11:48:52
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
	 * @mbg.generated  2018-11-23 11:48:52
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 11:48:52
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * 只读. t_mkt_convert_coupon_record
	 * @mbg.generated  2018-11-23 11:48:52
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

		public Criteria andConvertCouponRecordIdIsNull() {
			addCriterion("convert_coupon_record_id is null");
			return (Criteria) this;
		}

		public Criteria andConvertCouponRecordIdIsNotNull() {
			addCriterion("convert_coupon_record_id is not null");
			return (Criteria) this;
		}

		public Criteria andConvertCouponRecordIdEqualTo(Long value) {
			addCriterion("convert_coupon_record_id =", value, "convertCouponRecordId");
			return (Criteria) this;
		}

		public Criteria andConvertCouponRecordIdNotEqualTo(Long value) {
			addCriterion("convert_coupon_record_id <>", value, "convertCouponRecordId");
			return (Criteria) this;
		}

		public Criteria andConvertCouponRecordIdGreaterThan(Long value) {
			addCriterion("convert_coupon_record_id >", value, "convertCouponRecordId");
			return (Criteria) this;
		}

		public Criteria andConvertCouponRecordIdGreaterThanOrEqualTo(Long value) {
			addCriterion("convert_coupon_record_id >=", value, "convertCouponRecordId");
			return (Criteria) this;
		}

		public Criteria andConvertCouponRecordIdLessThan(Long value) {
			addCriterion("convert_coupon_record_id <", value, "convertCouponRecordId");
			return (Criteria) this;
		}

		public Criteria andConvertCouponRecordIdLessThanOrEqualTo(Long value) {
			addCriterion("convert_coupon_record_id <=", value, "convertCouponRecordId");
			return (Criteria) this;
		}

		public Criteria andConvertCouponRecordIdIn(List<Long> values) {
			addCriterion("convert_coupon_record_id in", values, "convertCouponRecordId");
			return (Criteria) this;
		}

		public Criteria andConvertCouponRecordIdNotIn(List<Long> values) {
			addCriterion("convert_coupon_record_id not in", values, "convertCouponRecordId");
			return (Criteria) this;
		}

		public Criteria andConvertCouponRecordIdBetween(Long value1, Long value2) {
			addCriterion("convert_coupon_record_id between", value1, value2, "convertCouponRecordId");
			return (Criteria) this;
		}

		public Criteria andConvertCouponRecordIdNotBetween(Long value1, Long value2) {
			addCriterion("convert_coupon_record_id not between", value1, value2, "convertCouponRecordId");
			return (Criteria) this;
		}

		public Criteria andConvertCouponRecordCodeIsNull() {
			addCriterion("convert_coupon_record_code is null");
			return (Criteria) this;
		}

		public Criteria andConvertCouponRecordCodeIsNotNull() {
			addCriterion("convert_coupon_record_code is not null");
			return (Criteria) this;
		}

		public Criteria andConvertCouponRecordCodeEqualTo(String value) {
			addCriterion("convert_coupon_record_code =", value, "convertCouponRecordCode");
			return (Criteria) this;
		}

		public Criteria andConvertCouponRecordCodeNotEqualTo(String value) {
			addCriterion("convert_coupon_record_code <>", value, "convertCouponRecordCode");
			return (Criteria) this;
		}

		public Criteria andConvertCouponRecordCodeGreaterThan(String value) {
			addCriterion("convert_coupon_record_code >", value, "convertCouponRecordCode");
			return (Criteria) this;
		}

		public Criteria andConvertCouponRecordCodeGreaterThanOrEqualTo(String value) {
			addCriterion("convert_coupon_record_code >=", value, "convertCouponRecordCode");
			return (Criteria) this;
		}

		public Criteria andConvertCouponRecordCodeLessThan(String value) {
			addCriterion("convert_coupon_record_code <", value, "convertCouponRecordCode");
			return (Criteria) this;
		}

		public Criteria andConvertCouponRecordCodeLessThanOrEqualTo(String value) {
			addCriterion("convert_coupon_record_code <=", value, "convertCouponRecordCode");
			return (Criteria) this;
		}

		public Criteria andConvertCouponRecordCodeLike(String value) {
			addCriterion("convert_coupon_record_code like", value, "convertCouponRecordCode");
			return (Criteria) this;
		}

		public Criteria andConvertCouponRecordCodeNotLike(String value) {
			addCriterion("convert_coupon_record_code not like", value, "convertCouponRecordCode");
			return (Criteria) this;
		}

		public Criteria andConvertCouponRecordCodeIn(List<String> values) {
			addCriterion("convert_coupon_record_code in", values, "convertCouponRecordCode");
			return (Criteria) this;
		}

		public Criteria andConvertCouponRecordCodeNotIn(List<String> values) {
			addCriterion("convert_coupon_record_code not in", values, "convertCouponRecordCode");
			return (Criteria) this;
		}

		public Criteria andConvertCouponRecordCodeBetween(String value1, String value2) {
			addCriterion("convert_coupon_record_code between", value1, value2, "convertCouponRecordCode");
			return (Criteria) this;
		}

		public Criteria andConvertCouponRecordCodeNotBetween(String value1, String value2) {
			addCriterion("convert_coupon_record_code not between", value1, value2, "convertCouponRecordCode");
			return (Criteria) this;
		}

		public Criteria andExchangeIdIsNull() {
			addCriterion("exchange_id is null");
			return (Criteria) this;
		}

		public Criteria andExchangeIdIsNotNull() {
			addCriterion("exchange_id is not null");
			return (Criteria) this;
		}

		public Criteria andExchangeIdEqualTo(Long value) {
			addCriterion("exchange_id =", value, "exchangeId");
			return (Criteria) this;
		}

		public Criteria andExchangeIdNotEqualTo(Long value) {
			addCriterion("exchange_id <>", value, "exchangeId");
			return (Criteria) this;
		}

		public Criteria andExchangeIdGreaterThan(Long value) {
			addCriterion("exchange_id >", value, "exchangeId");
			return (Criteria) this;
		}

		public Criteria andExchangeIdGreaterThanOrEqualTo(Long value) {
			addCriterion("exchange_id >=", value, "exchangeId");
			return (Criteria) this;
		}

		public Criteria andExchangeIdLessThan(Long value) {
			addCriterion("exchange_id <", value, "exchangeId");
			return (Criteria) this;
		}

		public Criteria andExchangeIdLessThanOrEqualTo(Long value) {
			addCriterion("exchange_id <=", value, "exchangeId");
			return (Criteria) this;
		}

		public Criteria andExchangeIdIn(List<Long> values) {
			addCriterion("exchange_id in", values, "exchangeId");
			return (Criteria) this;
		}

		public Criteria andExchangeIdNotIn(List<Long> values) {
			addCriterion("exchange_id not in", values, "exchangeId");
			return (Criteria) this;
		}

		public Criteria andExchangeIdBetween(Long value1, Long value2) {
			addCriterion("exchange_id between", value1, value2, "exchangeId");
			return (Criteria) this;
		}

		public Criteria andExchangeIdNotBetween(Long value1, Long value2) {
			addCriterion("exchange_id not between", value1, value2, "exchangeId");
			return (Criteria) this;
		}

		public Criteria andExchangeCodeIsNull() {
			addCriterion("exchange_code is null");
			return (Criteria) this;
		}

		public Criteria andExchangeCodeIsNotNull() {
			addCriterion("exchange_code is not null");
			return (Criteria) this;
		}

		public Criteria andExchangeCodeEqualTo(String value) {
			addCriterion("exchange_code =", value, "exchangeCode");
			return (Criteria) this;
		}

		public Criteria andExchangeCodeNotEqualTo(String value) {
			addCriterion("exchange_code <>", value, "exchangeCode");
			return (Criteria) this;
		}

		public Criteria andExchangeCodeGreaterThan(String value) {
			addCriterion("exchange_code >", value, "exchangeCode");
			return (Criteria) this;
		}

		public Criteria andExchangeCodeGreaterThanOrEqualTo(String value) {
			addCriterion("exchange_code >=", value, "exchangeCode");
			return (Criteria) this;
		}

		public Criteria andExchangeCodeLessThan(String value) {
			addCriterion("exchange_code <", value, "exchangeCode");
			return (Criteria) this;
		}

		public Criteria andExchangeCodeLessThanOrEqualTo(String value) {
			addCriterion("exchange_code <=", value, "exchangeCode");
			return (Criteria) this;
		}

		public Criteria andExchangeCodeLike(String value) {
			addCriterion("exchange_code like", value, "exchangeCode");
			return (Criteria) this;
		}

		public Criteria andExchangeCodeNotLike(String value) {
			addCriterion("exchange_code not like", value, "exchangeCode");
			return (Criteria) this;
		}

		public Criteria andExchangeCodeIn(List<String> values) {
			addCriterion("exchange_code in", values, "exchangeCode");
			return (Criteria) this;
		}

		public Criteria andExchangeCodeNotIn(List<String> values) {
			addCriterion("exchange_code not in", values, "exchangeCode");
			return (Criteria) this;
		}

		public Criteria andExchangeCodeBetween(String value1, String value2) {
			addCriterion("exchange_code between", value1, value2, "exchangeCode");
			return (Criteria) this;
		}

		public Criteria andExchangeCodeNotBetween(String value1, String value2) {
			addCriterion("exchange_code not between", value1, value2, "exchangeCode");
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

		public Criteria andMemberNameIsNull() {
			addCriterion("member_name is null");
			return (Criteria) this;
		}

		public Criteria andMemberNameIsNotNull() {
			addCriterion("member_name is not null");
			return (Criteria) this;
		}

		public Criteria andMemberNameEqualTo(String value) {
			addCriterion("member_name =", value, "memberName");
			return (Criteria) this;
		}

		public Criteria andMemberNameNotEqualTo(String value) {
			addCriterion("member_name <>", value, "memberName");
			return (Criteria) this;
		}

		public Criteria andMemberNameGreaterThan(String value) {
			addCriterion("member_name >", value, "memberName");
			return (Criteria) this;
		}

		public Criteria andMemberNameGreaterThanOrEqualTo(String value) {
			addCriterion("member_name >=", value, "memberName");
			return (Criteria) this;
		}

		public Criteria andMemberNameLessThan(String value) {
			addCriterion("member_name <", value, "memberName");
			return (Criteria) this;
		}

		public Criteria andMemberNameLessThanOrEqualTo(String value) {
			addCriterion("member_name <=", value, "memberName");
			return (Criteria) this;
		}

		public Criteria andMemberNameLike(String value) {
			addCriterion("member_name like", value, "memberName");
			return (Criteria) this;
		}

		public Criteria andMemberNameNotLike(String value) {
			addCriterion("member_name not like", value, "memberName");
			return (Criteria) this;
		}

		public Criteria andMemberNameIn(List<String> values) {
			addCriterion("member_name in", values, "memberName");
			return (Criteria) this;
		}

		public Criteria andMemberNameNotIn(List<String> values) {
			addCriterion("member_name not in", values, "memberName");
			return (Criteria) this;
		}

		public Criteria andMemberNameBetween(String value1, String value2) {
			addCriterion("member_name between", value1, value2, "memberName");
			return (Criteria) this;
		}

		public Criteria andMemberNameNotBetween(String value1, String value2) {
			addCriterion("member_name not between", value1, value2, "memberName");
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

		public Criteria andCardNoIsNull() {
			addCriterion("card_no is null");
			return (Criteria) this;
		}

		public Criteria andCardNoIsNotNull() {
			addCriterion("card_no is not null");
			return (Criteria) this;
		}

		public Criteria andCardNoEqualTo(String value) {
			addCriterion("card_no =", value, "cardNo");
			return (Criteria) this;
		}

		public Criteria andCardNoNotEqualTo(String value) {
			addCriterion("card_no <>", value, "cardNo");
			return (Criteria) this;
		}

		public Criteria andCardNoGreaterThan(String value) {
			addCriterion("card_no >", value, "cardNo");
			return (Criteria) this;
		}

		public Criteria andCardNoGreaterThanOrEqualTo(String value) {
			addCriterion("card_no >=", value, "cardNo");
			return (Criteria) this;
		}

		public Criteria andCardNoLessThan(String value) {
			addCriterion("card_no <", value, "cardNo");
			return (Criteria) this;
		}

		public Criteria andCardNoLessThanOrEqualTo(String value) {
			addCriterion("card_no <=", value, "cardNo");
			return (Criteria) this;
		}

		public Criteria andCardNoLike(String value) {
			addCriterion("card_no like", value, "cardNo");
			return (Criteria) this;
		}

		public Criteria andCardNoNotLike(String value) {
			addCriterion("card_no not like", value, "cardNo");
			return (Criteria) this;
		}

		public Criteria andCardNoIn(List<String> values) {
			addCriterion("card_no in", values, "cardNo");
			return (Criteria) this;
		}

		public Criteria andCardNoNotIn(List<String> values) {
			addCriterion("card_no not in", values, "cardNo");
			return (Criteria) this;
		}

		public Criteria andCardNoBetween(String value1, String value2) {
			addCriterion("card_no between", value1, value2, "cardNo");
			return (Criteria) this;
		}

		public Criteria andCardNoNotBetween(String value1, String value2) {
			addCriterion("card_no not between", value1, value2, "cardNo");
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

		public Criteria andCouponNumIsNull() {
			addCriterion("coupon_num is null");
			return (Criteria) this;
		}

		public Criteria andCouponNumIsNotNull() {
			addCriterion("coupon_num is not null");
			return (Criteria) this;
		}

		public Criteria andCouponNumEqualTo(Integer value) {
			addCriterion("coupon_num =", value, "couponNum");
			return (Criteria) this;
		}

		public Criteria andCouponNumNotEqualTo(Integer value) {
			addCriterion("coupon_num <>", value, "couponNum");
			return (Criteria) this;
		}

		public Criteria andCouponNumGreaterThan(Integer value) {
			addCriterion("coupon_num >", value, "couponNum");
			return (Criteria) this;
		}

		public Criteria andCouponNumGreaterThanOrEqualTo(Integer value) {
			addCriterion("coupon_num >=", value, "couponNum");
			return (Criteria) this;
		}

		public Criteria andCouponNumLessThan(Integer value) {
			addCriterion("coupon_num <", value, "couponNum");
			return (Criteria) this;
		}

		public Criteria andCouponNumLessThanOrEqualTo(Integer value) {
			addCriterion("coupon_num <=", value, "couponNum");
			return (Criteria) this;
		}

		public Criteria andCouponNumIn(List<Integer> values) {
			addCriterion("coupon_num in", values, "couponNum");
			return (Criteria) this;
		}

		public Criteria andCouponNumNotIn(List<Integer> values) {
			addCriterion("coupon_num not in", values, "couponNum");
			return (Criteria) this;
		}

		public Criteria andCouponNumBetween(Integer value1, Integer value2) {
			addCriterion("coupon_num between", value1, value2, "couponNum");
			return (Criteria) this;
		}

		public Criteria andCouponNumNotBetween(Integer value1, Integer value2) {
			addCriterion("coupon_num not between", value1, value2, "couponNum");
			return (Criteria) this;
		}

		public Criteria andConvertPriceIsNull() {
			addCriterion("convert_price is null");
			return (Criteria) this;
		}

		public Criteria andConvertPriceIsNotNull() {
			addCriterion("convert_price is not null");
			return (Criteria) this;
		}

		public Criteria andConvertPriceEqualTo(Integer value) {
			addCriterion("convert_price =", value, "convertPrice");
			return (Criteria) this;
		}

		public Criteria andConvertPriceNotEqualTo(Integer value) {
			addCriterion("convert_price <>", value, "convertPrice");
			return (Criteria) this;
		}

		public Criteria andConvertPriceGreaterThan(Integer value) {
			addCriterion("convert_price >", value, "convertPrice");
			return (Criteria) this;
		}

		public Criteria andConvertPriceGreaterThanOrEqualTo(Integer value) {
			addCriterion("convert_price >=", value, "convertPrice");
			return (Criteria) this;
		}

		public Criteria andConvertPriceLessThan(Integer value) {
			addCriterion("convert_price <", value, "convertPrice");
			return (Criteria) this;
		}

		public Criteria andConvertPriceLessThanOrEqualTo(Integer value) {
			addCriterion("convert_price <=", value, "convertPrice");
			return (Criteria) this;
		}

		public Criteria andConvertPriceIn(List<Integer> values) {
			addCriterion("convert_price in", values, "convertPrice");
			return (Criteria) this;
		}

		public Criteria andConvertPriceNotIn(List<Integer> values) {
			addCriterion("convert_price not in", values, "convertPrice");
			return (Criteria) this;
		}

		public Criteria andConvertPriceBetween(Integer value1, Integer value2) {
			addCriterion("convert_price between", value1, value2, "convertPrice");
			return (Criteria) this;
		}

		public Criteria andConvertPriceNotBetween(Integer value1, Integer value2) {
			addCriterion("convert_price not between", value1, value2, "convertPrice");
			return (Criteria) this;
		}

		public Criteria andConvertNumIsNull() {
			addCriterion("convert_num is null");
			return (Criteria) this;
		}

		public Criteria andConvertNumIsNotNull() {
			addCriterion("convert_num is not null");
			return (Criteria) this;
		}

		public Criteria andConvertNumEqualTo(Integer value) {
			addCriterion("convert_num =", value, "convertNum");
			return (Criteria) this;
		}

		public Criteria andConvertNumNotEqualTo(Integer value) {
			addCriterion("convert_num <>", value, "convertNum");
			return (Criteria) this;
		}

		public Criteria andConvertNumGreaterThan(Integer value) {
			addCriterion("convert_num >", value, "convertNum");
			return (Criteria) this;
		}

		public Criteria andConvertNumGreaterThanOrEqualTo(Integer value) {
			addCriterion("convert_num >=", value, "convertNum");
			return (Criteria) this;
		}

		public Criteria andConvertNumLessThan(Integer value) {
			addCriterion("convert_num <", value, "convertNum");
			return (Criteria) this;
		}

		public Criteria andConvertNumLessThanOrEqualTo(Integer value) {
			addCriterion("convert_num <=", value, "convertNum");
			return (Criteria) this;
		}

		public Criteria andConvertNumIn(List<Integer> values) {
			addCriterion("convert_num in", values, "convertNum");
			return (Criteria) this;
		}

		public Criteria andConvertNumNotIn(List<Integer> values) {
			addCriterion("convert_num not in", values, "convertNum");
			return (Criteria) this;
		}

		public Criteria andConvertNumBetween(Integer value1, Integer value2) {
			addCriterion("convert_num between", value1, value2, "convertNum");
			return (Criteria) this;
		}

		public Criteria andConvertNumNotBetween(Integer value1, Integer value2) {
			addCriterion("convert_num not between", value1, value2, "convertNum");
			return (Criteria) this;
		}

		public Criteria andConvertTatalIntegralIsNull() {
			addCriterion("convert_tatal_integral is null");
			return (Criteria) this;
		}

		public Criteria andConvertTatalIntegralIsNotNull() {
			addCriterion("convert_tatal_integral is not null");
			return (Criteria) this;
		}

		public Criteria andConvertTatalIntegralEqualTo(Integer value) {
			addCriterion("convert_tatal_integral =", value, "convertTatalIntegral");
			return (Criteria) this;
		}

		public Criteria andConvertTatalIntegralNotEqualTo(Integer value) {
			addCriterion("convert_tatal_integral <>", value, "convertTatalIntegral");
			return (Criteria) this;
		}

		public Criteria andConvertTatalIntegralGreaterThan(Integer value) {
			addCriterion("convert_tatal_integral >", value, "convertTatalIntegral");
			return (Criteria) this;
		}

		public Criteria andConvertTatalIntegralGreaterThanOrEqualTo(Integer value) {
			addCriterion("convert_tatal_integral >=", value, "convertTatalIntegral");
			return (Criteria) this;
		}

		public Criteria andConvertTatalIntegralLessThan(Integer value) {
			addCriterion("convert_tatal_integral <", value, "convertTatalIntegral");
			return (Criteria) this;
		}

		public Criteria andConvertTatalIntegralLessThanOrEqualTo(Integer value) {
			addCriterion("convert_tatal_integral <=", value, "convertTatalIntegral");
			return (Criteria) this;
		}

		public Criteria andConvertTatalIntegralIn(List<Integer> values) {
			addCriterion("convert_tatal_integral in", values, "convertTatalIntegral");
			return (Criteria) this;
		}

		public Criteria andConvertTatalIntegralNotIn(List<Integer> values) {
			addCriterion("convert_tatal_integral not in", values, "convertTatalIntegral");
			return (Criteria) this;
		}

		public Criteria andConvertTatalIntegralBetween(Integer value1, Integer value2) {
			addCriterion("convert_tatal_integral between", value1, value2, "convertTatalIntegral");
			return (Criteria) this;
		}

		public Criteria andConvertTatalIntegralNotBetween(Integer value1, Integer value2) {
			addCriterion("convert_tatal_integral not between", value1, value2, "convertTatalIntegral");
			return (Criteria) this;
		}

		public Criteria andConvertTimeIsNull() {
			addCriterion("convert_time is null");
			return (Criteria) this;
		}

		public Criteria andConvertTimeIsNotNull() {
			addCriterion("convert_time is not null");
			return (Criteria) this;
		}

		public Criteria andConvertTimeEqualTo(Date value) {
			addCriterion("convert_time =", value, "convertTime");
			return (Criteria) this;
		}

		public Criteria andConvertTimeNotEqualTo(Date value) {
			addCriterion("convert_time <>", value, "convertTime");
			return (Criteria) this;
		}

		public Criteria andConvertTimeGreaterThan(Date value) {
			addCriterion("convert_time >", value, "convertTime");
			return (Criteria) this;
		}

		public Criteria andConvertTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("convert_time >=", value, "convertTime");
			return (Criteria) this;
		}

		public Criteria andConvertTimeLessThan(Date value) {
			addCriterion("convert_time <", value, "convertTime");
			return (Criteria) this;
		}

		public Criteria andConvertTimeLessThanOrEqualTo(Date value) {
			addCriterion("convert_time <=", value, "convertTime");
			return (Criteria) this;
		}

		public Criteria andConvertTimeIn(List<Date> values) {
			addCriterion("convert_time in", values, "convertTime");
			return (Criteria) this;
		}

		public Criteria andConvertTimeNotIn(List<Date> values) {
			addCriterion("convert_time not in", values, "convertTime");
			return (Criteria) this;
		}

		public Criteria andConvertTimeBetween(Date value1, Date value2) {
			addCriterion("convert_time between", value1, value2, "convertTime");
			return (Criteria) this;
		}

		public Criteria andConvertTimeNotBetween(Date value1, Date value2) {
			addCriterion("convert_time not between", value1, value2, "convertTime");
			return (Criteria) this;
		}

		public Criteria andSuccessTypeIsNull() {
			addCriterion("success_type is null");
			return (Criteria) this;
		}

		public Criteria andSuccessTypeIsNotNull() {
			addCriterion("success_type is not null");
			return (Criteria) this;
		}

		public Criteria andSuccessTypeEqualTo(Boolean value) {
			addCriterion("success_type =", value, "successType");
			return (Criteria) this;
		}

		public Criteria andSuccessTypeNotEqualTo(Boolean value) {
			addCriterion("success_type <>", value, "successType");
			return (Criteria) this;
		}

		public Criteria andSuccessTypeGreaterThan(Boolean value) {
			addCriterion("success_type >", value, "successType");
			return (Criteria) this;
		}

		public Criteria andSuccessTypeGreaterThanOrEqualTo(Boolean value) {
			addCriterion("success_type >=", value, "successType");
			return (Criteria) this;
		}

		public Criteria andSuccessTypeLessThan(Boolean value) {
			addCriterion("success_type <", value, "successType");
			return (Criteria) this;
		}

		public Criteria andSuccessTypeLessThanOrEqualTo(Boolean value) {
			addCriterion("success_type <=", value, "successType");
			return (Criteria) this;
		}

		public Criteria andSuccessTypeIn(List<Boolean> values) {
			addCriterion("success_type in", values, "successType");
			return (Criteria) this;
		}

		public Criteria andSuccessTypeNotIn(List<Boolean> values) {
			addCriterion("success_type not in", values, "successType");
			return (Criteria) this;
		}

		public Criteria andSuccessTypeBetween(Boolean value1, Boolean value2) {
			addCriterion("success_type between", value1, value2, "successType");
			return (Criteria) this;
		}

		public Criteria andSuccessTypeNotBetween(Boolean value1, Boolean value2) {
			addCriterion("success_type not between", value1, value2, "successType");
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
	 * 只读. t_mkt_convert_coupon_record
	 * @mbg.generated  2018-11-23 11:48:52
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
     * This class corresponds to the database table t_mkt_convert_coupon_record
     *
     * @mbg.generated do_not_delete_during_merge 2018-11-22 16:07:57
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }
}