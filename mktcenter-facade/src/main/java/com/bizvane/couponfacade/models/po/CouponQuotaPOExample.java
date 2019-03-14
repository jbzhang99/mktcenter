package com.bizvane.couponfacade.models.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CouponQuotaPOExample implements Serializable {
    /**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	protected String orderByClause;
	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	protected boolean distinct;
	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	protected List<Criteria> oredCriteria;
	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	public CouponQuotaPOExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
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
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * 只读. t_coupon_quota
	 * @mbg.generated  2018-11-23 17:48:21
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

		public Criteria andCouponQuotaIdIsNull() {
			addCriterion("coupon_quota_id is null");
			return (Criteria) this;
		}

		public Criteria andCouponQuotaIdIsNotNull() {
			addCriterion("coupon_quota_id is not null");
			return (Criteria) this;
		}

		public Criteria andCouponQuotaIdEqualTo(Long value) {
			addCriterion("coupon_quota_id =", value, "couponQuotaId");
			return (Criteria) this;
		}

		public Criteria andCouponQuotaIdNotEqualTo(Long value) {
			addCriterion("coupon_quota_id <>", value, "couponQuotaId");
			return (Criteria) this;
		}

		public Criteria andCouponQuotaIdGreaterThan(Long value) {
			addCriterion("coupon_quota_id >", value, "couponQuotaId");
			return (Criteria) this;
		}

		public Criteria andCouponQuotaIdGreaterThanOrEqualTo(Long value) {
			addCriterion("coupon_quota_id >=", value, "couponQuotaId");
			return (Criteria) this;
		}

		public Criteria andCouponQuotaIdLessThan(Long value) {
			addCriterion("coupon_quota_id <", value, "couponQuotaId");
			return (Criteria) this;
		}

		public Criteria andCouponQuotaIdLessThanOrEqualTo(Long value) {
			addCriterion("coupon_quota_id <=", value, "couponQuotaId");
			return (Criteria) this;
		}

		public Criteria andCouponQuotaIdIn(List<Long> values) {
			addCriterion("coupon_quota_id in", values, "couponQuotaId");
			return (Criteria) this;
		}

		public Criteria andCouponQuotaIdNotIn(List<Long> values) {
			addCriterion("coupon_quota_id not in", values, "couponQuotaId");
			return (Criteria) this;
		}

		public Criteria andCouponQuotaIdBetween(Long value1, Long value2) {
			addCriterion("coupon_quota_id between", value1, value2, "couponQuotaId");
			return (Criteria) this;
		}

		public Criteria andCouponQuotaIdNotBetween(Long value1, Long value2) {
			addCriterion("coupon_quota_id not between", value1, value2, "couponQuotaId");
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

		public Criteria andQuotaTopicIsNull() {
			addCriterion("quota_topic is null");
			return (Criteria) this;
		}

		public Criteria andQuotaTopicIsNotNull() {
			addCriterion("quota_topic is not null");
			return (Criteria) this;
		}

		public Criteria andQuotaTopicEqualTo(String value) {
			addCriterion("quota_topic =", value, "quotaTopic");
			return (Criteria) this;
		}

		public Criteria andQuotaTopicNotEqualTo(String value) {
			addCriterion("quota_topic <>", value, "quotaTopic");
			return (Criteria) this;
		}

		public Criteria andQuotaTopicGreaterThan(String value) {
			addCriterion("quota_topic >", value, "quotaTopic");
			return (Criteria) this;
		}

		public Criteria andQuotaTopicGreaterThanOrEqualTo(String value) {
			addCriterion("quota_topic >=", value, "quotaTopic");
			return (Criteria) this;
		}

		public Criteria andQuotaTopicLessThan(String value) {
			addCriterion("quota_topic <", value, "quotaTopic");
			return (Criteria) this;
		}

		public Criteria andQuotaTopicLessThanOrEqualTo(String value) {
			addCriterion("quota_topic <=", value, "quotaTopic");
			return (Criteria) this;
		}

		public Criteria andQuotaTopicLike(String value) {
			addCriterion("quota_topic like", value, "quotaTopic");
			return (Criteria) this;
		}

		public Criteria andQuotaTopicNotLike(String value) {
			addCriterion("quota_topic not like", value, "quotaTopic");
			return (Criteria) this;
		}

		public Criteria andQuotaTopicIn(List<String> values) {
			addCriterion("quota_topic in", values, "quotaTopic");
			return (Criteria) this;
		}

		public Criteria andQuotaTopicNotIn(List<String> values) {
			addCriterion("quota_topic not in", values, "quotaTopic");
			return (Criteria) this;
		}

		public Criteria andQuotaTopicBetween(String value1, String value2) {
			addCriterion("quota_topic between", value1, value2, "quotaTopic");
			return (Criteria) this;
		}

		public Criteria andQuotaTopicNotBetween(String value1, String value2) {
			addCriterion("quota_topic not between", value1, value2, "quotaTopic");
			return (Criteria) this;
		}

		public Criteria andTotalNumberIsNull() {
			addCriterion("total_number is null");
			return (Criteria) this;
		}

		public Criteria andTotalNumberIsNotNull() {
			addCriterion("total_number is not null");
			return (Criteria) this;
		}

		public Criteria andTotalNumberEqualTo(Integer value) {
			addCriterion("total_number =", value, "totalNumber");
			return (Criteria) this;
		}

		public Criteria andTotalNumberNotEqualTo(Integer value) {
			addCriterion("total_number <>", value, "totalNumber");
			return (Criteria) this;
		}

		public Criteria andTotalNumberGreaterThan(Integer value) {
			addCriterion("total_number >", value, "totalNumber");
			return (Criteria) this;
		}

		public Criteria andTotalNumberGreaterThanOrEqualTo(Integer value) {
			addCriterion("total_number >=", value, "totalNumber");
			return (Criteria) this;
		}

		public Criteria andTotalNumberLessThan(Integer value) {
			addCriterion("total_number <", value, "totalNumber");
			return (Criteria) this;
		}

		public Criteria andTotalNumberLessThanOrEqualTo(Integer value) {
			addCriterion("total_number <=", value, "totalNumber");
			return (Criteria) this;
		}

		public Criteria andTotalNumberIn(List<Integer> values) {
			addCriterion("total_number in", values, "totalNumber");
			return (Criteria) this;
		}

		public Criteria andTotalNumberNotIn(List<Integer> values) {
			addCriterion("total_number not in", values, "totalNumber");
			return (Criteria) this;
		}

		public Criteria andTotalNumberBetween(Integer value1, Integer value2) {
			addCriterion("total_number between", value1, value2, "totalNumber");
			return (Criteria) this;
		}

		public Criteria andTotalNumberNotBetween(Integer value1, Integer value2) {
			addCriterion("total_number not between", value1, value2, "totalNumber");
			return (Criteria) this;
		}

		public Criteria andSendCountIsNull() {
			addCriterion("send_count is null");
			return (Criteria) this;
		}

		public Criteria andSendCountIsNotNull() {
			addCriterion("send_count is not null");
			return (Criteria) this;
		}

		public Criteria andSendCountEqualTo(Integer value) {
			addCriterion("send_count =", value, "sendCount");
			return (Criteria) this;
		}

		public Criteria andSendCountNotEqualTo(Integer value) {
			addCriterion("send_count <>", value, "sendCount");
			return (Criteria) this;
		}

		public Criteria andSendCountGreaterThan(Integer value) {
			addCriterion("send_count >", value, "sendCount");
			return (Criteria) this;
		}

		public Criteria andSendCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("send_count >=", value, "sendCount");
			return (Criteria) this;
		}

		public Criteria andSendCountLessThan(Integer value) {
			addCriterion("send_count <", value, "sendCount");
			return (Criteria) this;
		}

		public Criteria andSendCountLessThanOrEqualTo(Integer value) {
			addCriterion("send_count <=", value, "sendCount");
			return (Criteria) this;
		}

		public Criteria andSendCountIn(List<Integer> values) {
			addCriterion("send_count in", values, "sendCount");
			return (Criteria) this;
		}

		public Criteria andSendCountNotIn(List<Integer> values) {
			addCriterion("send_count not in", values, "sendCount");
			return (Criteria) this;
		}

		public Criteria andSendCountBetween(Integer value1, Integer value2) {
			addCriterion("send_count between", value1, value2, "sendCount");
			return (Criteria) this;
		}

		public Criteria andSendCountNotBetween(Integer value1, Integer value2) {
			addCriterion("send_count not between", value1, value2, "sendCount");
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

		public Criteria andMemberAverageIsNull() {
			addCriterion("member_average is null");
			return (Criteria) this;
		}

		public Criteria andMemberAverageIsNotNull() {
			addCriterion("member_average is not null");
			return (Criteria) this;
		}

		public Criteria andMemberAverageEqualTo(Integer value) {
			addCriterion("member_average =", value, "memberAverage");
			return (Criteria) this;
		}

		public Criteria andMemberAverageNotEqualTo(Integer value) {
			addCriterion("member_average <>", value, "memberAverage");
			return (Criteria) this;
		}

		public Criteria andMemberAverageGreaterThan(Integer value) {
			addCriterion("member_average >", value, "memberAverage");
			return (Criteria) this;
		}

		public Criteria andMemberAverageGreaterThanOrEqualTo(Integer value) {
			addCriterion("member_average >=", value, "memberAverage");
			return (Criteria) this;
		}

		public Criteria andMemberAverageLessThan(Integer value) {
			addCriterion("member_average <", value, "memberAverage");
			return (Criteria) this;
		}

		public Criteria andMemberAverageLessThanOrEqualTo(Integer value) {
			addCriterion("member_average <=", value, "memberAverage");
			return (Criteria) this;
		}

		public Criteria andMemberAverageIn(List<Integer> values) {
			addCriterion("member_average in", values, "memberAverage");
			return (Criteria) this;
		}

		public Criteria andMemberAverageNotIn(List<Integer> values) {
			addCriterion("member_average not in", values, "memberAverage");
			return (Criteria) this;
		}

		public Criteria andMemberAverageBetween(Integer value1, Integer value2) {
			addCriterion("member_average between", value1, value2, "memberAverage");
			return (Criteria) this;
		}

		public Criteria andMemberAverageNotBetween(Integer value1, Integer value2) {
			addCriterion("member_average not between", value1, value2, "memberAverage");
			return (Criteria) this;
		}

		public Criteria andStartDateIsNull() {
			addCriterion("start_date is null");
			return (Criteria) this;
		}

		public Criteria andStartDateIsNotNull() {
			addCriterion("start_date is not null");
			return (Criteria) this;
		}

		public Criteria andStartDateEqualTo(Date value) {
			addCriterion("start_date =", value, "startDate");
			return (Criteria) this;
		}

		public Criteria andStartDateNotEqualTo(Date value) {
			addCriterion("start_date <>", value, "startDate");
			return (Criteria) this;
		}

		public Criteria andStartDateGreaterThan(Date value) {
			addCriterion("start_date >", value, "startDate");
			return (Criteria) this;
		}

		public Criteria andStartDateGreaterThanOrEqualTo(Date value) {
			addCriterion("start_date >=", value, "startDate");
			return (Criteria) this;
		}

		public Criteria andStartDateLessThan(Date value) {
			addCriterion("start_date <", value, "startDate");
			return (Criteria) this;
		}

		public Criteria andStartDateLessThanOrEqualTo(Date value) {
			addCriterion("start_date <=", value, "startDate");
			return (Criteria) this;
		}

		public Criteria andStartDateIn(List<Date> values) {
			addCriterion("start_date in", values, "startDate");
			return (Criteria) this;
		}

		public Criteria andStartDateNotIn(List<Date> values) {
			addCriterion("start_date not in", values, "startDate");
			return (Criteria) this;
		}

		public Criteria andStartDateBetween(Date value1, Date value2) {
			addCriterion("start_date between", value1, value2, "startDate");
			return (Criteria) this;
		}

		public Criteria andStartDateNotBetween(Date value1, Date value2) {
			addCriterion("start_date not between", value1, value2, "startDate");
			return (Criteria) this;
		}

		public Criteria andEndDateIsNull() {
			addCriterion("end_date is null");
			return (Criteria) this;
		}

		public Criteria andEndDateIsNotNull() {
			addCriterion("end_date is not null");
			return (Criteria) this;
		}

		public Criteria andEndDateEqualTo(Date value) {
			addCriterion("end_date =", value, "endDate");
			return (Criteria) this;
		}

		public Criteria andEndDateNotEqualTo(Date value) {
			addCriterion("end_date <>", value, "endDate");
			return (Criteria) this;
		}

		public Criteria andEndDateGreaterThan(Date value) {
			addCriterion("end_date >", value, "endDate");
			return (Criteria) this;
		}

		public Criteria andEndDateGreaterThanOrEqualTo(Date value) {
			addCriterion("end_date >=", value, "endDate");
			return (Criteria) this;
		}

		public Criteria andEndDateLessThan(Date value) {
			addCriterion("end_date <", value, "endDate");
			return (Criteria) this;
		}

		public Criteria andEndDateLessThanOrEqualTo(Date value) {
			addCriterion("end_date <=", value, "endDate");
			return (Criteria) this;
		}

		public Criteria andEndDateIn(List<Date> values) {
			addCriterion("end_date in", values, "endDate");
			return (Criteria) this;
		}

		public Criteria andEndDateNotIn(List<Date> values) {
			addCriterion("end_date not in", values, "endDate");
			return (Criteria) this;
		}

		public Criteria andEndDateBetween(Date value1, Date value2) {
			addCriterion("end_date between", value1, value2, "endDate");
			return (Criteria) this;
		}

		public Criteria andEndDateNotBetween(Date value1, Date value2) {
			addCriterion("end_date not between", value1, value2, "endDate");
			return (Criteria) this;
		}

		public Criteria andStateIsNull() {
			addCriterion("state is null");
			return (Criteria) this;
		}

		public Criteria andStateIsNotNull() {
			addCriterion("state is not null");
			return (Criteria) this;
		}

		public Criteria andStateEqualTo(Boolean value) {
			addCriterion("state =", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateNotEqualTo(Boolean value) {
			addCriterion("state <>", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateGreaterThan(Boolean value) {
			addCriterion("state >", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateGreaterThanOrEqualTo(Boolean value) {
			addCriterion("state >=", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateLessThan(Boolean value) {
			addCriterion("state <", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateLessThanOrEqualTo(Boolean value) {
			addCriterion("state <=", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateIn(List<Boolean> values) {
			addCriterion("state in", values, "state");
			return (Criteria) this;
		}

		public Criteria andStateNotIn(List<Boolean> values) {
			addCriterion("state not in", values, "state");
			return (Criteria) this;
		}

		public Criteria andStateBetween(Boolean value1, Boolean value2) {
			addCriterion("state between", value1, value2, "state");
			return (Criteria) this;
		}

		public Criteria andStateNotBetween(Boolean value1, Boolean value2) {
			addCriterion("state not between", value1, value2, "state");
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

		public Criteria andNoteIsNull() {
			addCriterion("note is null");
			return (Criteria) this;
		}

		public Criteria andNoteIsNotNull() {
			addCriterion("note is not null");
			return (Criteria) this;
		}

		public Criteria andNoteEqualTo(String value) {
			addCriterion("note =", value, "note");
			return (Criteria) this;
		}

		public Criteria andNoteNotEqualTo(String value) {
			addCriterion("note <>", value, "note");
			return (Criteria) this;
		}

		public Criteria andNoteGreaterThan(String value) {
			addCriterion("note >", value, "note");
			return (Criteria) this;
		}

		public Criteria andNoteGreaterThanOrEqualTo(String value) {
			addCriterion("note >=", value, "note");
			return (Criteria) this;
		}

		public Criteria andNoteLessThan(String value) {
			addCriterion("note <", value, "note");
			return (Criteria) this;
		}

		public Criteria andNoteLessThanOrEqualTo(String value) {
			addCriterion("note <=", value, "note");
			return (Criteria) this;
		}

		public Criteria andNoteLike(String value) {
			addCriterion("note like", value, "note");
			return (Criteria) this;
		}

		public Criteria andNoteNotLike(String value) {
			addCriterion("note not like", value, "note");
			return (Criteria) this;
		}

		public Criteria andNoteIn(List<String> values) {
			addCriterion("note in", values, "note");
			return (Criteria) this;
		}

		public Criteria andNoteNotIn(List<String> values) {
			addCriterion("note not in", values, "note");
			return (Criteria) this;
		}

		public Criteria andNoteBetween(String value1, String value2) {
			addCriterion("note between", value1, value2, "note");
			return (Criteria) this;
		}

		public Criteria andNoteNotBetween(String value1, String value2) {
			addCriterion("note not between", value1, value2, "note");
			return (Criteria) this;
		}

		public Criteria andStateCodeIsNull() {
			addCriterion("state_code is null");
			return (Criteria) this;
		}

		public Criteria andStateCodeIsNotNull() {
			addCriterion("state_code is not null");
			return (Criteria) this;
		}

		public Criteria andStateCodeEqualTo(String value) {
			addCriterion("state_code =", value, "stateCode");
			return (Criteria) this;
		}

		public Criteria andStateCodeNotEqualTo(String value) {
			addCriterion("state_code <>", value, "stateCode");
			return (Criteria) this;
		}

		public Criteria andStateCodeGreaterThan(String value) {
			addCriterion("state_code >", value, "stateCode");
			return (Criteria) this;
		}

		public Criteria andStateCodeGreaterThanOrEqualTo(String value) {
			addCriterion("state_code >=", value, "stateCode");
			return (Criteria) this;
		}

		public Criteria andStateCodeLessThan(String value) {
			addCriterion("state_code <", value, "stateCode");
			return (Criteria) this;
		}

		public Criteria andStateCodeLessThanOrEqualTo(String value) {
			addCriterion("state_code <=", value, "stateCode");
			return (Criteria) this;
		}

		public Criteria andStateCodeLike(String value) {
			addCriterion("state_code like", value, "stateCode");
			return (Criteria) this;
		}

		public Criteria andStateCodeNotLike(String value) {
			addCriterion("state_code not like", value, "stateCode");
			return (Criteria) this;
		}

		public Criteria andStateCodeIn(List<String> values) {
			addCriterion("state_code in", values, "stateCode");
			return (Criteria) this;
		}

		public Criteria andStateCodeNotIn(List<String> values) {
			addCriterion("state_code not in", values, "stateCode");
			return (Criteria) this;
		}

		public Criteria andStateCodeBetween(String value1, String value2) {
			addCriterion("state_code between", value1, value2, "stateCode");
			return (Criteria) this;
		}

		public Criteria andStateCodeNotBetween(String value1, String value2) {
			addCriterion("state_code not between", value1, value2, "stateCode");
			return (Criteria) this;
		}

		public Criteria andStateNameIsNull() {
			addCriterion("state_name is null");
			return (Criteria) this;
		}

		public Criteria andStateNameIsNotNull() {
			addCriterion("state_name is not null");
			return (Criteria) this;
		}

		public Criteria andStateNameEqualTo(String value) {
			addCriterion("state_name =", value, "stateName");
			return (Criteria) this;
		}

		public Criteria andStateNameNotEqualTo(String value) {
			addCriterion("state_name <>", value, "stateName");
			return (Criteria) this;
		}

		public Criteria andStateNameGreaterThan(String value) {
			addCriterion("state_name >", value, "stateName");
			return (Criteria) this;
		}

		public Criteria andStateNameGreaterThanOrEqualTo(String value) {
			addCriterion("state_name >=", value, "stateName");
			return (Criteria) this;
		}

		public Criteria andStateNameLessThan(String value) {
			addCriterion("state_name <", value, "stateName");
			return (Criteria) this;
		}

		public Criteria andStateNameLessThanOrEqualTo(String value) {
			addCriterion("state_name <=", value, "stateName");
			return (Criteria) this;
		}

		public Criteria andStateNameLike(String value) {
			addCriterion("state_name like", value, "stateName");
			return (Criteria) this;
		}

		public Criteria andStateNameNotLike(String value) {
			addCriterion("state_name not like", value, "stateName");
			return (Criteria) this;
		}

		public Criteria andStateNameIn(List<String> values) {
			addCriterion("state_name in", values, "stateName");
			return (Criteria) this;
		}

		public Criteria andStateNameNotIn(List<String> values) {
			addCriterion("state_name not in", values, "stateName");
			return (Criteria) this;
		}

		public Criteria andStateNameBetween(String value1, String value2) {
			addCriterion("state_name between", value1, value2, "stateName");
			return (Criteria) this;
		}

		public Criteria andStateNameNotBetween(String value1, String value2) {
			addCriterion("state_name not between", value1, value2, "stateName");
			return (Criteria) this;
		}

		public Criteria andExtendCodeIsNull() {
			addCriterion("extend_code is null");
			return (Criteria) this;
		}

		public Criteria andExtendCodeIsNotNull() {
			addCriterion("extend_code is not null");
			return (Criteria) this;
		}

		public Criteria andExtendCodeEqualTo(String value) {
			addCriterion("extend_code =", value, "extendCode");
			return (Criteria) this;
		}

		public Criteria andExtendCodeNotEqualTo(String value) {
			addCriterion("extend_code <>", value, "extendCode");
			return (Criteria) this;
		}

		public Criteria andExtendCodeGreaterThan(String value) {
			addCriterion("extend_code >", value, "extendCode");
			return (Criteria) this;
		}

		public Criteria andExtendCodeGreaterThanOrEqualTo(String value) {
			addCriterion("extend_code >=", value, "extendCode");
			return (Criteria) this;
		}

		public Criteria andExtendCodeLessThan(String value) {
			addCriterion("extend_code <", value, "extendCode");
			return (Criteria) this;
		}

		public Criteria andExtendCodeLessThanOrEqualTo(String value) {
			addCriterion("extend_code <=", value, "extendCode");
			return (Criteria) this;
		}

		public Criteria andExtendCodeLike(String value) {
			addCriterion("extend_code like", value, "extendCode");
			return (Criteria) this;
		}

		public Criteria andExtendCodeNotLike(String value) {
			addCriterion("extend_code not like", value, "extendCode");
			return (Criteria) this;
		}

		public Criteria andExtendCodeIn(List<String> values) {
			addCriterion("extend_code in", values, "extendCode");
			return (Criteria) this;
		}

		public Criteria andExtendCodeNotIn(List<String> values) {
			addCriterion("extend_code not in", values, "extendCode");
			return (Criteria) this;
		}

		public Criteria andExtendCodeBetween(String value1, String value2) {
			addCriterion("extend_code between", value1, value2, "extendCode");
			return (Criteria) this;
		}

		public Criteria andExtendCodeNotBetween(String value1, String value2) {
			addCriterion("extend_code not between", value1, value2, "extendCode");
			return (Criteria) this;
		}

		public Criteria andExtendNameIsNull() {
			addCriterion("extend_name is null");
			return (Criteria) this;
		}

		public Criteria andExtendNameIsNotNull() {
			addCriterion("extend_name is not null");
			return (Criteria) this;
		}

		public Criteria andExtendNameEqualTo(String value) {
			addCriterion("extend_name =", value, "extendName");
			return (Criteria) this;
		}

		public Criteria andExtendNameNotEqualTo(String value) {
			addCriterion("extend_name <>", value, "extendName");
			return (Criteria) this;
		}

		public Criteria andExtendNameGreaterThan(String value) {
			addCriterion("extend_name >", value, "extendName");
			return (Criteria) this;
		}

		public Criteria andExtendNameGreaterThanOrEqualTo(String value) {
			addCriterion("extend_name >=", value, "extendName");
			return (Criteria) this;
		}

		public Criteria andExtendNameLessThan(String value) {
			addCriterion("extend_name <", value, "extendName");
			return (Criteria) this;
		}

		public Criteria andExtendNameLessThanOrEqualTo(String value) {
			addCriterion("extend_name <=", value, "extendName");
			return (Criteria) this;
		}

		public Criteria andExtendNameLike(String value) {
			addCriterion("extend_name like", value, "extendName");
			return (Criteria) this;
		}

		public Criteria andExtendNameNotLike(String value) {
			addCriterion("extend_name not like", value, "extendName");
			return (Criteria) this;
		}

		public Criteria andExtendNameIn(List<String> values) {
			addCriterion("extend_name in", values, "extendName");
			return (Criteria) this;
		}

		public Criteria andExtendNameNotIn(List<String> values) {
			addCriterion("extend_name not in", values, "extendName");
			return (Criteria) this;
		}

		public Criteria andExtendNameBetween(String value1, String value2) {
			addCriterion("extend_name between", value1, value2, "extendName");
			return (Criteria) this;
		}

		public Criteria andExtendNameNotBetween(String value1, String value2) {
			addCriterion("extend_name not between", value1, value2, "extendName");
			return (Criteria) this;
		}

		public Criteria andExtendNoteIsNull() {
			addCriterion("extend_note is null");
			return (Criteria) this;
		}

		public Criteria andExtendNoteIsNotNull() {
			addCriterion("extend_note is not null");
			return (Criteria) this;
		}

		public Criteria andExtendNoteEqualTo(String value) {
			addCriterion("extend_note =", value, "extendNote");
			return (Criteria) this;
		}

		public Criteria andExtendNoteNotEqualTo(String value) {
			addCriterion("extend_note <>", value, "extendNote");
			return (Criteria) this;
		}

		public Criteria andExtendNoteGreaterThan(String value) {
			addCriterion("extend_note >", value, "extendNote");
			return (Criteria) this;
		}

		public Criteria andExtendNoteGreaterThanOrEqualTo(String value) {
			addCriterion("extend_note >=", value, "extendNote");
			return (Criteria) this;
		}

		public Criteria andExtendNoteLessThan(String value) {
			addCriterion("extend_note <", value, "extendNote");
			return (Criteria) this;
		}

		public Criteria andExtendNoteLessThanOrEqualTo(String value) {
			addCriterion("extend_note <=", value, "extendNote");
			return (Criteria) this;
		}

		public Criteria andExtendNoteLike(String value) {
			addCriterion("extend_note like", value, "extendNote");
			return (Criteria) this;
		}

		public Criteria andExtendNoteNotLike(String value) {
			addCriterion("extend_note not like", value, "extendNote");
			return (Criteria) this;
		}

		public Criteria andExtendNoteIn(List<String> values) {
			addCriterion("extend_note in", values, "extendNote");
			return (Criteria) this;
		}

		public Criteria andExtendNoteNotIn(List<String> values) {
			addCriterion("extend_note not in", values, "extendNote");
			return (Criteria) this;
		}

		public Criteria andExtendNoteBetween(String value1, String value2) {
			addCriterion("extend_note between", value1, value2, "extendNote");
			return (Criteria) this;
		}

		public Criteria andExtendNoteNotBetween(String value1, String value2) {
			addCriterion("extend_note not between", value1, value2, "extendNote");
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
	 * 只读. t_coupon_quota
	 * @mbg.generated  2018-11-23 17:48:21
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
     * This class corresponds to the database table t_coupon_quota
     *
     * @mbg.generated do_not_delete_during_merge 2018-11-23 14:39:38
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }
}