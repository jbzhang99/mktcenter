package com.bizvane.mktcenterfacade.models.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MktActivityRedPacketSumPOExample implements Serializable {
    /**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	protected String orderByClause;
	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	protected boolean distinct;
	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	protected List<Criteria> oredCriteria;
	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	public MktActivityRedPacketSumPOExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
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
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * 只读. t_mkt_activity_red_packet_sum
	 * @mbg.generated  2019-01-25 13:53:49
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

		public Criteria andMktActivityRedPacketSumIdIsNull() {
			addCriterion("mkt_activity_red_packet_sum_id is null");
			return (Criteria) this;
		}

		public Criteria andMktActivityRedPacketSumIdIsNotNull() {
			addCriterion("mkt_activity_red_packet_sum_id is not null");
			return (Criteria) this;
		}

		public Criteria andMktActivityRedPacketSumIdEqualTo(Long value) {
			addCriterion("mkt_activity_red_packet_sum_id =", value, "mktActivityRedPacketSumId");
			return (Criteria) this;
		}

		public Criteria andMktActivityRedPacketSumIdNotEqualTo(Long value) {
			addCriterion("mkt_activity_red_packet_sum_id <>", value, "mktActivityRedPacketSumId");
			return (Criteria) this;
		}

		public Criteria andMktActivityRedPacketSumIdGreaterThan(Long value) {
			addCriterion("mkt_activity_red_packet_sum_id >", value, "mktActivityRedPacketSumId");
			return (Criteria) this;
		}

		public Criteria andMktActivityRedPacketSumIdGreaterThanOrEqualTo(Long value) {
			addCriterion("mkt_activity_red_packet_sum_id >=", value, "mktActivityRedPacketSumId");
			return (Criteria) this;
		}

		public Criteria andMktActivityRedPacketSumIdLessThan(Long value) {
			addCriterion("mkt_activity_red_packet_sum_id <", value, "mktActivityRedPacketSumId");
			return (Criteria) this;
		}

		public Criteria andMktActivityRedPacketSumIdLessThanOrEqualTo(Long value) {
			addCriterion("mkt_activity_red_packet_sum_id <=", value, "mktActivityRedPacketSumId");
			return (Criteria) this;
		}

		public Criteria andMktActivityRedPacketSumIdIn(List<Long> values) {
			addCriterion("mkt_activity_red_packet_sum_id in", values, "mktActivityRedPacketSumId");
			return (Criteria) this;
		}

		public Criteria andMktActivityRedPacketSumIdNotIn(List<Long> values) {
			addCriterion("mkt_activity_red_packet_sum_id not in", values, "mktActivityRedPacketSumId");
			return (Criteria) this;
		}

		public Criteria andMktActivityRedPacketSumIdBetween(Long value1, Long value2) {
			addCriterion("mkt_activity_red_packet_sum_id between", value1, value2, "mktActivityRedPacketSumId");
			return (Criteria) this;
		}

		public Criteria andMktActivityRedPacketSumIdNotBetween(Long value1, Long value2) {
			addCriterion("mkt_activity_red_packet_sum_id not between", value1, value2, "mktActivityRedPacketSumId");
			return (Criteria) this;
		}

		public Criteria andMktActivityIdIsNull() {
			addCriterion("mkt_activity_id is null");
			return (Criteria) this;
		}

		public Criteria andMktActivityIdIsNotNull() {
			addCriterion("mkt_activity_id is not null");
			return (Criteria) this;
		}

		public Criteria andMktActivityIdEqualTo(Long value) {
			addCriterion("mkt_activity_id =", value, "mktActivityId");
			return (Criteria) this;
		}

		public Criteria andMktActivityIdNotEqualTo(Long value) {
			addCriterion("mkt_activity_id <>", value, "mktActivityId");
			return (Criteria) this;
		}

		public Criteria andMktActivityIdGreaterThan(Long value) {
			addCriterion("mkt_activity_id >", value, "mktActivityId");
			return (Criteria) this;
		}

		public Criteria andMktActivityIdGreaterThanOrEqualTo(Long value) {
			addCriterion("mkt_activity_id >=", value, "mktActivityId");
			return (Criteria) this;
		}

		public Criteria andMktActivityIdLessThan(Long value) {
			addCriterion("mkt_activity_id <", value, "mktActivityId");
			return (Criteria) this;
		}

		public Criteria andMktActivityIdLessThanOrEqualTo(Long value) {
			addCriterion("mkt_activity_id <=", value, "mktActivityId");
			return (Criteria) this;
		}

		public Criteria andMktActivityIdIn(List<Long> values) {
			addCriterion("mkt_activity_id in", values, "mktActivityId");
			return (Criteria) this;
		}

		public Criteria andMktActivityIdNotIn(List<Long> values) {
			addCriterion("mkt_activity_id not in", values, "mktActivityId");
			return (Criteria) this;
		}

		public Criteria andMktActivityIdBetween(Long value1, Long value2) {
			addCriterion("mkt_activity_id between", value1, value2, "mktActivityId");
			return (Criteria) this;
		}

		public Criteria andMktActivityIdNotBetween(Long value1, Long value2) {
			addCriterion("mkt_activity_id not between", value1, value2, "mktActivityId");
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

		public Criteria andActivityCodeIsNull() {
			addCriterion("activity_code is null");
			return (Criteria) this;
		}

		public Criteria andActivityCodeIsNotNull() {
			addCriterion("activity_code is not null");
			return (Criteria) this;
		}

		public Criteria andActivityCodeEqualTo(String value) {
			addCriterion("activity_code =", value, "activityCode");
			return (Criteria) this;
		}

		public Criteria andActivityCodeNotEqualTo(String value) {
			addCriterion("activity_code <>", value, "activityCode");
			return (Criteria) this;
		}

		public Criteria andActivityCodeGreaterThan(String value) {
			addCriterion("activity_code >", value, "activityCode");
			return (Criteria) this;
		}

		public Criteria andActivityCodeGreaterThanOrEqualTo(String value) {
			addCriterion("activity_code >=", value, "activityCode");
			return (Criteria) this;
		}

		public Criteria andActivityCodeLessThan(String value) {
			addCriterion("activity_code <", value, "activityCode");
			return (Criteria) this;
		}

		public Criteria andActivityCodeLessThanOrEqualTo(String value) {
			addCriterion("activity_code <=", value, "activityCode");
			return (Criteria) this;
		}

		public Criteria andActivityCodeLike(String value) {
			addCriterion("activity_code like", value, "activityCode");
			return (Criteria) this;
		}

		public Criteria andActivityCodeNotLike(String value) {
			addCriterion("activity_code not like", value, "activityCode");
			return (Criteria) this;
		}

		public Criteria andActivityCodeIn(List<String> values) {
			addCriterion("activity_code in", values, "activityCode");
			return (Criteria) this;
		}

		public Criteria andActivityCodeNotIn(List<String> values) {
			addCriterion("activity_code not in", values, "activityCode");
			return (Criteria) this;
		}

		public Criteria andActivityCodeBetween(String value1, String value2) {
			addCriterion("activity_code between", value1, value2, "activityCode");
			return (Criteria) this;
		}

		public Criteria andActivityCodeNotBetween(String value1, String value2) {
			addCriterion("activity_code not between", value1, value2, "activityCode");
			return (Criteria) this;
		}

		public Criteria andActivityNameIsNull() {
			addCriterion("activity_name is null");
			return (Criteria) this;
		}

		public Criteria andActivityNameIsNotNull() {
			addCriterion("activity_name is not null");
			return (Criteria) this;
		}

		public Criteria andActivityNameEqualTo(String value) {
			addCriterion("activity_name =", value, "activityName");
			return (Criteria) this;
		}

		public Criteria andActivityNameNotEqualTo(String value) {
			addCriterion("activity_name <>", value, "activityName");
			return (Criteria) this;
		}

		public Criteria andActivityNameGreaterThan(String value) {
			addCriterion("activity_name >", value, "activityName");
			return (Criteria) this;
		}

		public Criteria andActivityNameGreaterThanOrEqualTo(String value) {
			addCriterion("activity_name >=", value, "activityName");
			return (Criteria) this;
		}

		public Criteria andActivityNameLessThan(String value) {
			addCriterion("activity_name <", value, "activityName");
			return (Criteria) this;
		}

		public Criteria andActivityNameLessThanOrEqualTo(String value) {
			addCriterion("activity_name <=", value, "activityName");
			return (Criteria) this;
		}

		public Criteria andActivityNameLike(String value) {
			addCriterion("activity_name like", value, "activityName");
			return (Criteria) this;
		}

		public Criteria andActivityNameNotLike(String value) {
			addCriterion("activity_name not like", value, "activityName");
			return (Criteria) this;
		}

		public Criteria andActivityNameIn(List<String> values) {
			addCriterion("activity_name in", values, "activityName");
			return (Criteria) this;
		}

		public Criteria andActivityNameNotIn(List<String> values) {
			addCriterion("activity_name not in", values, "activityName");
			return (Criteria) this;
		}

		public Criteria andActivityNameBetween(String value1, String value2) {
			addCriterion("activity_name between", value1, value2, "activityName");
			return (Criteria) this;
		}

		public Criteria andActivityNameNotBetween(String value1, String value2) {
			addCriterion("activity_name not between", value1, value2, "activityName");
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

		public Criteria andInitiatorNumIsNull() {
			addCriterion("initiator_num is null");
			return (Criteria) this;
		}

		public Criteria andInitiatorNumIsNotNull() {
			addCriterion("initiator_num is not null");
			return (Criteria) this;
		}

		public Criteria andInitiatorNumEqualTo(Integer value) {
			addCriterion("initiator_num =", value, "initiatorNum");
			return (Criteria) this;
		}

		public Criteria andInitiatorNumNotEqualTo(Integer value) {
			addCriterion("initiator_num <>", value, "initiatorNum");
			return (Criteria) this;
		}

		public Criteria andInitiatorNumGreaterThan(Integer value) {
			addCriterion("initiator_num >", value, "initiatorNum");
			return (Criteria) this;
		}

		public Criteria andInitiatorNumGreaterThanOrEqualTo(Integer value) {
			addCriterion("initiator_num >=", value, "initiatorNum");
			return (Criteria) this;
		}

		public Criteria andInitiatorNumLessThan(Integer value) {
			addCriterion("initiator_num <", value, "initiatorNum");
			return (Criteria) this;
		}

		public Criteria andInitiatorNumLessThanOrEqualTo(Integer value) {
			addCriterion("initiator_num <=", value, "initiatorNum");
			return (Criteria) this;
		}

		public Criteria andInitiatorNumIn(List<Integer> values) {
			addCriterion("initiator_num in", values, "initiatorNum");
			return (Criteria) this;
		}

		public Criteria andInitiatorNumNotIn(List<Integer> values) {
			addCriterion("initiator_num not in", values, "initiatorNum");
			return (Criteria) this;
		}

		public Criteria andInitiatorNumBetween(Integer value1, Integer value2) {
			addCriterion("initiator_num between", value1, value2, "initiatorNum");
			return (Criteria) this;
		}

		public Criteria andInitiatorNumNotBetween(Integer value1, Integer value2) {
			addCriterion("initiator_num not between", value1, value2, "initiatorNum");
			return (Criteria) this;
		}

		public Criteria andHelpNumIsNull() {
			addCriterion("help_num is null");
			return (Criteria) this;
		}

		public Criteria andHelpNumIsNotNull() {
			addCriterion("help_num is not null");
			return (Criteria) this;
		}

		public Criteria andHelpNumEqualTo(Integer value) {
			addCriterion("help_num =", value, "helpNum");
			return (Criteria) this;
		}

		public Criteria andHelpNumNotEqualTo(Integer value) {
			addCriterion("help_num <>", value, "helpNum");
			return (Criteria) this;
		}

		public Criteria andHelpNumGreaterThan(Integer value) {
			addCriterion("help_num >", value, "helpNum");
			return (Criteria) this;
		}

		public Criteria andHelpNumGreaterThanOrEqualTo(Integer value) {
			addCriterion("help_num >=", value, "helpNum");
			return (Criteria) this;
		}

		public Criteria andHelpNumLessThan(Integer value) {
			addCriterion("help_num <", value, "helpNum");
			return (Criteria) this;
		}

		public Criteria andHelpNumLessThanOrEqualTo(Integer value) {
			addCriterion("help_num <=", value, "helpNum");
			return (Criteria) this;
		}

		public Criteria andHelpNumIn(List<Integer> values) {
			addCriterion("help_num in", values, "helpNum");
			return (Criteria) this;
		}

		public Criteria andHelpNumNotIn(List<Integer> values) {
			addCriterion("help_num not in", values, "helpNum");
			return (Criteria) this;
		}

		public Criteria andHelpNumBetween(Integer value1, Integer value2) {
			addCriterion("help_num between", value1, value2, "helpNum");
			return (Criteria) this;
		}

		public Criteria andHelpNumNotBetween(Integer value1, Integer value2) {
			addCriterion("help_num not between", value1, value2, "helpNum");
			return (Criteria) this;
		}

		public Criteria andGetCouponNumIsNull() {
			addCriterion("get_coupon_num is null");
			return (Criteria) this;
		}

		public Criteria andGetCouponNumIsNotNull() {
			addCriterion("get_coupon_num is not null");
			return (Criteria) this;
		}

		public Criteria andGetCouponNumEqualTo(Integer value) {
			addCriterion("get_coupon_num =", value, "getCouponNum");
			return (Criteria) this;
		}

		public Criteria andGetCouponNumNotEqualTo(Integer value) {
			addCriterion("get_coupon_num <>", value, "getCouponNum");
			return (Criteria) this;
		}

		public Criteria andGetCouponNumGreaterThan(Integer value) {
			addCriterion("get_coupon_num >", value, "getCouponNum");
			return (Criteria) this;
		}

		public Criteria andGetCouponNumGreaterThanOrEqualTo(Integer value) {
			addCriterion("get_coupon_num >=", value, "getCouponNum");
			return (Criteria) this;
		}

		public Criteria andGetCouponNumLessThan(Integer value) {
			addCriterion("get_coupon_num <", value, "getCouponNum");
			return (Criteria) this;
		}

		public Criteria andGetCouponNumLessThanOrEqualTo(Integer value) {
			addCriterion("get_coupon_num <=", value, "getCouponNum");
			return (Criteria) this;
		}

		public Criteria andGetCouponNumIn(List<Integer> values) {
			addCriterion("get_coupon_num in", values, "getCouponNum");
			return (Criteria) this;
		}

		public Criteria andGetCouponNumNotIn(List<Integer> values) {
			addCriterion("get_coupon_num not in", values, "getCouponNum");
			return (Criteria) this;
		}

		public Criteria andGetCouponNumBetween(Integer value1, Integer value2) {
			addCriterion("get_coupon_num between", value1, value2, "getCouponNum");
			return (Criteria) this;
		}

		public Criteria andGetCouponNumNotBetween(Integer value1, Integer value2) {
			addCriterion("get_coupon_num not between", value1, value2, "getCouponNum");
			return (Criteria) this;
		}

		public Criteria andStartTimeIsNull() {
			addCriterion("start_time is null");
			return (Criteria) this;
		}

		public Criteria andStartTimeIsNotNull() {
			addCriterion("start_time is not null");
			return (Criteria) this;
		}

		public Criteria andStartTimeEqualTo(Date value) {
			addCriterion("start_time =", value, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeNotEqualTo(Date value) {
			addCriterion("start_time <>", value, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeGreaterThan(Date value) {
			addCriterion("start_time >", value, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("start_time >=", value, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeLessThan(Date value) {
			addCriterion("start_time <", value, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeLessThanOrEqualTo(Date value) {
			addCriterion("start_time <=", value, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeIn(List<Date> values) {
			addCriterion("start_time in", values, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeNotIn(List<Date> values) {
			addCriterion("start_time not in", values, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeBetween(Date value1, Date value2) {
			addCriterion("start_time between", value1, value2, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeNotBetween(Date value1, Date value2) {
			addCriterion("start_time not between", value1, value2, "startTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeIsNull() {
			addCriterion("end_time is null");
			return (Criteria) this;
		}

		public Criteria andEndTimeIsNotNull() {
			addCriterion("end_time is not null");
			return (Criteria) this;
		}

		public Criteria andEndTimeEqualTo(Date value) {
			addCriterion("end_time =", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeNotEqualTo(Date value) {
			addCriterion("end_time <>", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeGreaterThan(Date value) {
			addCriterion("end_time >", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("end_time >=", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeLessThan(Date value) {
			addCriterion("end_time <", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeLessThanOrEqualTo(Date value) {
			addCriterion("end_time <=", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeIn(List<Date> values) {
			addCriterion("end_time in", values, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeNotIn(List<Date> values) {
			addCriterion("end_time not in", values, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeBetween(Date value1, Date value2) {
			addCriterion("end_time between", value1, value2, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeNotBetween(Date value1, Date value2) {
			addCriterion("end_time not between", value1, value2, "endTime");
			return (Criteria) this;
		}

		public Criteria andActivityTimeIsNull() {
			addCriterion("activity_time is null");
			return (Criteria) this;
		}

		public Criteria andActivityTimeIsNotNull() {
			addCriterion("activity_time is not null");
			return (Criteria) this;
		}

		public Criteria andActivityTimeEqualTo(Integer value) {
			addCriterion("activity_time =", value, "activityTime");
			return (Criteria) this;
		}

		public Criteria andActivityTimeNotEqualTo(Integer value) {
			addCriterion("activity_time <>", value, "activityTime");
			return (Criteria) this;
		}

		public Criteria andActivityTimeGreaterThan(Integer value) {
			addCriterion("activity_time >", value, "activityTime");
			return (Criteria) this;
		}

		public Criteria andActivityTimeGreaterThanOrEqualTo(Integer value) {
			addCriterion("activity_time >=", value, "activityTime");
			return (Criteria) this;
		}

		public Criteria andActivityTimeLessThan(Integer value) {
			addCriterion("activity_time <", value, "activityTime");
			return (Criteria) this;
		}

		public Criteria andActivityTimeLessThanOrEqualTo(Integer value) {
			addCriterion("activity_time <=", value, "activityTime");
			return (Criteria) this;
		}

		public Criteria andActivityTimeIn(List<Integer> values) {
			addCriterion("activity_time in", values, "activityTime");
			return (Criteria) this;
		}

		public Criteria andActivityTimeNotIn(List<Integer> values) {
			addCriterion("activity_time not in", values, "activityTime");
			return (Criteria) this;
		}

		public Criteria andActivityTimeBetween(Integer value1, Integer value2) {
			addCriterion("activity_time between", value1, value2, "activityTime");
			return (Criteria) this;
		}

		public Criteria andActivityTimeNotBetween(Integer value1, Integer value2) {
			addCriterion("activity_time not between", value1, value2, "activityTime");
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

		public Criteria andModifiedUserIdEqualTo(Integer value) {
			addCriterion("modified_user_id =", value, "modifiedUserId");
			return (Criteria) this;
		}

		public Criteria andModifiedUserIdNotEqualTo(Integer value) {
			addCriterion("modified_user_id <>", value, "modifiedUserId");
			return (Criteria) this;
		}

		public Criteria andModifiedUserIdGreaterThan(Integer value) {
			addCriterion("modified_user_id >", value, "modifiedUserId");
			return (Criteria) this;
		}

		public Criteria andModifiedUserIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("modified_user_id >=", value, "modifiedUserId");
			return (Criteria) this;
		}

		public Criteria andModifiedUserIdLessThan(Integer value) {
			addCriterion("modified_user_id <", value, "modifiedUserId");
			return (Criteria) this;
		}

		public Criteria andModifiedUserIdLessThanOrEqualTo(Integer value) {
			addCriterion("modified_user_id <=", value, "modifiedUserId");
			return (Criteria) this;
		}

		public Criteria andModifiedUserIdIn(List<Integer> values) {
			addCriterion("modified_user_id in", values, "modifiedUserId");
			return (Criteria) this;
		}

		public Criteria andModifiedUserIdNotIn(List<Integer> values) {
			addCriterion("modified_user_id not in", values, "modifiedUserId");
			return (Criteria) this;
		}

		public Criteria andModifiedUserIdBetween(Integer value1, Integer value2) {
			addCriterion("modified_user_id between", value1, value2, "modifiedUserId");
			return (Criteria) this;
		}

		public Criteria andModifiedUserIdNotBetween(Integer value1, Integer value2) {
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
	 * 只读. t_mkt_activity_red_packet_sum
	 * @mbg.generated  2019-01-25 13:53:49
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
     * This class corresponds to the database table t_mkt_activity_red_packet_sum
     *
     * @mbg.generated do_not_delete_during_merge 2019-01-11 11:03:19
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }
}