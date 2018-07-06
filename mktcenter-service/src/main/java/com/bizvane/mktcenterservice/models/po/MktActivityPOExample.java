package com.bizvane.mktcenterservice.models.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MktActivityPOExample implements Serializable {
    /**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	protected String orderByClause;
	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	protected boolean distinct;
	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	protected List<Criteria> oredCriteria;
	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public MktActivityPOExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
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
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * 只读. t_mkt_activity
	 * @mbg.generated  2018-07-06 19:28:16
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

		public Criteria andActivityTypeIsNull() {
			addCriterion("activity_type is null");
			return (Criteria) this;
		}

		public Criteria andActivityTypeIsNotNull() {
			addCriterion("activity_type is not null");
			return (Criteria) this;
		}

		public Criteria andActivityTypeEqualTo(Integer value) {
			addCriterion("activity_type =", value, "activityType");
			return (Criteria) this;
		}

		public Criteria andActivityTypeNotEqualTo(Integer value) {
			addCriterion("activity_type <>", value, "activityType");
			return (Criteria) this;
		}

		public Criteria andActivityTypeGreaterThan(Integer value) {
			addCriterion("activity_type >", value, "activityType");
			return (Criteria) this;
		}

		public Criteria andActivityTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("activity_type >=", value, "activityType");
			return (Criteria) this;
		}

		public Criteria andActivityTypeLessThan(Integer value) {
			addCriterion("activity_type <", value, "activityType");
			return (Criteria) this;
		}

		public Criteria andActivityTypeLessThanOrEqualTo(Integer value) {
			addCriterion("activity_type <=", value, "activityType");
			return (Criteria) this;
		}

		public Criteria andActivityTypeIn(List<Integer> values) {
			addCriterion("activity_type in", values, "activityType");
			return (Criteria) this;
		}

		public Criteria andActivityTypeNotIn(List<Integer> values) {
			addCriterion("activity_type not in", values, "activityType");
			return (Criteria) this;
		}

		public Criteria andActivityTypeBetween(Integer value1, Integer value2) {
			addCriterion("activity_type between", value1, value2, "activityType");
			return (Criteria) this;
		}

		public Criteria andActivityTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("activity_type not between", value1, value2, "activityType");
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

		public Criteria andBrandNameIsNull() {
			addCriterion("brand_name is null");
			return (Criteria) this;
		}

		public Criteria andBrandNameIsNotNull() {
			addCriterion("brand_name is not null");
			return (Criteria) this;
		}

		public Criteria andBrandNameEqualTo(String value) {
			addCriterion("brand_name =", value, "brandName");
			return (Criteria) this;
		}

		public Criteria andBrandNameNotEqualTo(String value) {
			addCriterion("brand_name <>", value, "brandName");
			return (Criteria) this;
		}

		public Criteria andBrandNameGreaterThan(String value) {
			addCriterion("brand_name >", value, "brandName");
			return (Criteria) this;
		}

		public Criteria andBrandNameGreaterThanOrEqualTo(String value) {
			addCriterion("brand_name >=", value, "brandName");
			return (Criteria) this;
		}

		public Criteria andBrandNameLessThan(String value) {
			addCriterion("brand_name <", value, "brandName");
			return (Criteria) this;
		}

		public Criteria andBrandNameLessThanOrEqualTo(String value) {
			addCriterion("brand_name <=", value, "brandName");
			return (Criteria) this;
		}

		public Criteria andBrandNameLike(String value) {
			addCriterion("brand_name like", value, "brandName");
			return (Criteria) this;
		}

		public Criteria andBrandNameNotLike(String value) {
			addCriterion("brand_name not like", value, "brandName");
			return (Criteria) this;
		}

		public Criteria andBrandNameIn(List<String> values) {
			addCriterion("brand_name in", values, "brandName");
			return (Criteria) this;
		}

		public Criteria andBrandNameNotIn(List<String> values) {
			addCriterion("brand_name not in", values, "brandName");
			return (Criteria) this;
		}

		public Criteria andBrandNameBetween(String value1, String value2) {
			addCriterion("brand_name between", value1, value2, "brandName");
			return (Criteria) this;
		}

		public Criteria andBrandNameNotBetween(String value1, String value2) {
			addCriterion("brand_name not between", value1, value2, "brandName");
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

		public Criteria andMbrLevelCodeIsNull() {
			addCriterion("mbr_level_code is null");
			return (Criteria) this;
		}

		public Criteria andMbrLevelCodeIsNotNull() {
			addCriterion("mbr_level_code is not null");
			return (Criteria) this;
		}

		public Criteria andMbrLevelCodeEqualTo(String value) {
			addCriterion("mbr_level_code =", value, "mbrLevelCode");
			return (Criteria) this;
		}

		public Criteria andMbrLevelCodeNotEqualTo(String value) {
			addCriterion("mbr_level_code <>", value, "mbrLevelCode");
			return (Criteria) this;
		}

		public Criteria andMbrLevelCodeGreaterThan(String value) {
			addCriterion("mbr_level_code >", value, "mbrLevelCode");
			return (Criteria) this;
		}

		public Criteria andMbrLevelCodeGreaterThanOrEqualTo(String value) {
			addCriterion("mbr_level_code >=", value, "mbrLevelCode");
			return (Criteria) this;
		}

		public Criteria andMbrLevelCodeLessThan(String value) {
			addCriterion("mbr_level_code <", value, "mbrLevelCode");
			return (Criteria) this;
		}

		public Criteria andMbrLevelCodeLessThanOrEqualTo(String value) {
			addCriterion("mbr_level_code <=", value, "mbrLevelCode");
			return (Criteria) this;
		}

		public Criteria andMbrLevelCodeLike(String value) {
			addCriterion("mbr_level_code like", value, "mbrLevelCode");
			return (Criteria) this;
		}

		public Criteria andMbrLevelCodeNotLike(String value) {
			addCriterion("mbr_level_code not like", value, "mbrLevelCode");
			return (Criteria) this;
		}

		public Criteria andMbrLevelCodeIn(List<String> values) {
			addCriterion("mbr_level_code in", values, "mbrLevelCode");
			return (Criteria) this;
		}

		public Criteria andMbrLevelCodeNotIn(List<String> values) {
			addCriterion("mbr_level_code not in", values, "mbrLevelCode");
			return (Criteria) this;
		}

		public Criteria andMbrLevelCodeBetween(String value1, String value2) {
			addCriterion("mbr_level_code between", value1, value2, "mbrLevelCode");
			return (Criteria) this;
		}

		public Criteria andMbrLevelCodeNotBetween(String value1, String value2) {
			addCriterion("mbr_level_code not between", value1, value2, "mbrLevelCode");
			return (Criteria) this;
		}

		public Criteria andMbrLevelNameIsNull() {
			addCriterion("mbr_level_name is null");
			return (Criteria) this;
		}

		public Criteria andMbrLevelNameIsNotNull() {
			addCriterion("mbr_level_name is not null");
			return (Criteria) this;
		}

		public Criteria andMbrLevelNameEqualTo(String value) {
			addCriterion("mbr_level_name =", value, "mbrLevelName");
			return (Criteria) this;
		}

		public Criteria andMbrLevelNameNotEqualTo(String value) {
			addCriterion("mbr_level_name <>", value, "mbrLevelName");
			return (Criteria) this;
		}

		public Criteria andMbrLevelNameGreaterThan(String value) {
			addCriterion("mbr_level_name >", value, "mbrLevelName");
			return (Criteria) this;
		}

		public Criteria andMbrLevelNameGreaterThanOrEqualTo(String value) {
			addCriterion("mbr_level_name >=", value, "mbrLevelName");
			return (Criteria) this;
		}

		public Criteria andMbrLevelNameLessThan(String value) {
			addCriterion("mbr_level_name <", value, "mbrLevelName");
			return (Criteria) this;
		}

		public Criteria andMbrLevelNameLessThanOrEqualTo(String value) {
			addCriterion("mbr_level_name <=", value, "mbrLevelName");
			return (Criteria) this;
		}

		public Criteria andMbrLevelNameLike(String value) {
			addCriterion("mbr_level_name like", value, "mbrLevelName");
			return (Criteria) this;
		}

		public Criteria andMbrLevelNameNotLike(String value) {
			addCriterion("mbr_level_name not like", value, "mbrLevelName");
			return (Criteria) this;
		}

		public Criteria andMbrLevelNameIn(List<String> values) {
			addCriterion("mbr_level_name in", values, "mbrLevelName");
			return (Criteria) this;
		}

		public Criteria andMbrLevelNameNotIn(List<String> values) {
			addCriterion("mbr_level_name not in", values, "mbrLevelName");
			return (Criteria) this;
		}

		public Criteria andMbrLevelNameBetween(String value1, String value2) {
			addCriterion("mbr_level_name between", value1, value2, "mbrLevelName");
			return (Criteria) this;
		}

		public Criteria andMbrLevelNameNotBetween(String value1, String value2) {
			addCriterion("mbr_level_name not between", value1, value2, "mbrLevelName");
			return (Criteria) this;
		}

		public Criteria andMbrLowLevelCodeIsNull() {
			addCriterion("mbr_low_level_code is null");
			return (Criteria) this;
		}

		public Criteria andMbrLowLevelCodeIsNotNull() {
			addCriterion("mbr_low_level_code is not null");
			return (Criteria) this;
		}

		public Criteria andMbrLowLevelCodeEqualTo(String value) {
			addCriterion("mbr_low_level_code =", value, "mbrLowLevelCode");
			return (Criteria) this;
		}

		public Criteria andMbrLowLevelCodeNotEqualTo(String value) {
			addCriterion("mbr_low_level_code <>", value, "mbrLowLevelCode");
			return (Criteria) this;
		}

		public Criteria andMbrLowLevelCodeGreaterThan(String value) {
			addCriterion("mbr_low_level_code >", value, "mbrLowLevelCode");
			return (Criteria) this;
		}

		public Criteria andMbrLowLevelCodeGreaterThanOrEqualTo(String value) {
			addCriterion("mbr_low_level_code >=", value, "mbrLowLevelCode");
			return (Criteria) this;
		}

		public Criteria andMbrLowLevelCodeLessThan(String value) {
			addCriterion("mbr_low_level_code <", value, "mbrLowLevelCode");
			return (Criteria) this;
		}

		public Criteria andMbrLowLevelCodeLessThanOrEqualTo(String value) {
			addCriterion("mbr_low_level_code <=", value, "mbrLowLevelCode");
			return (Criteria) this;
		}

		public Criteria andMbrLowLevelCodeLike(String value) {
			addCriterion("mbr_low_level_code like", value, "mbrLowLevelCode");
			return (Criteria) this;
		}

		public Criteria andMbrLowLevelCodeNotLike(String value) {
			addCriterion("mbr_low_level_code not like", value, "mbrLowLevelCode");
			return (Criteria) this;
		}

		public Criteria andMbrLowLevelCodeIn(List<String> values) {
			addCriterion("mbr_low_level_code in", values, "mbrLowLevelCode");
			return (Criteria) this;
		}

		public Criteria andMbrLowLevelCodeNotIn(List<String> values) {
			addCriterion("mbr_low_level_code not in", values, "mbrLowLevelCode");
			return (Criteria) this;
		}

		public Criteria andMbrLowLevelCodeBetween(String value1, String value2) {
			addCriterion("mbr_low_level_code between", value1, value2, "mbrLowLevelCode");
			return (Criteria) this;
		}

		public Criteria andMbrLowLevelCodeNotBetween(String value1, String value2) {
			addCriterion("mbr_low_level_code not between", value1, value2, "mbrLowLevelCode");
			return (Criteria) this;
		}

		public Criteria andMbrLowLevelNameIsNull() {
			addCriterion("mbr_low_level_name is null");
			return (Criteria) this;
		}

		public Criteria andMbrLowLevelNameIsNotNull() {
			addCriterion("mbr_low_level_name is not null");
			return (Criteria) this;
		}

		public Criteria andMbrLowLevelNameEqualTo(String value) {
			addCriterion("mbr_low_level_name =", value, "mbrLowLevelName");
			return (Criteria) this;
		}

		public Criteria andMbrLowLevelNameNotEqualTo(String value) {
			addCriterion("mbr_low_level_name <>", value, "mbrLowLevelName");
			return (Criteria) this;
		}

		public Criteria andMbrLowLevelNameGreaterThan(String value) {
			addCriterion("mbr_low_level_name >", value, "mbrLowLevelName");
			return (Criteria) this;
		}

		public Criteria andMbrLowLevelNameGreaterThanOrEqualTo(String value) {
			addCriterion("mbr_low_level_name >=", value, "mbrLowLevelName");
			return (Criteria) this;
		}

		public Criteria andMbrLowLevelNameLessThan(String value) {
			addCriterion("mbr_low_level_name <", value, "mbrLowLevelName");
			return (Criteria) this;
		}

		public Criteria andMbrLowLevelNameLessThanOrEqualTo(String value) {
			addCriterion("mbr_low_level_name <=", value, "mbrLowLevelName");
			return (Criteria) this;
		}

		public Criteria andMbrLowLevelNameLike(String value) {
			addCriterion("mbr_low_level_name like", value, "mbrLowLevelName");
			return (Criteria) this;
		}

		public Criteria andMbrLowLevelNameNotLike(String value) {
			addCriterion("mbr_low_level_name not like", value, "mbrLowLevelName");
			return (Criteria) this;
		}

		public Criteria andMbrLowLevelNameIn(List<String> values) {
			addCriterion("mbr_low_level_name in", values, "mbrLowLevelName");
			return (Criteria) this;
		}

		public Criteria andMbrLowLevelNameNotIn(List<String> values) {
			addCriterion("mbr_low_level_name not in", values, "mbrLowLevelName");
			return (Criteria) this;
		}

		public Criteria andMbrLowLevelNameBetween(String value1, String value2) {
			addCriterion("mbr_low_level_name between", value1, value2, "mbrLowLevelName");
			return (Criteria) this;
		}

		public Criteria andMbrLowLevelNameNotBetween(String value1, String value2) {
			addCriterion("mbr_low_level_name not between", value1, value2, "mbrLowLevelName");
			return (Criteria) this;
		}

		public Criteria andLongTermIsNull() {
			addCriterion("long_term is null");
			return (Criteria) this;
		}

		public Criteria andLongTermIsNotNull() {
			addCriterion("long_term is not null");
			return (Criteria) this;
		}

		public Criteria andLongTermEqualTo(Integer value) {
			addCriterion("long_term =", value, "longTerm");
			return (Criteria) this;
		}

		public Criteria andLongTermNotEqualTo(Integer value) {
			addCriterion("long_term <>", value, "longTerm");
			return (Criteria) this;
		}

		public Criteria andLongTermGreaterThan(Integer value) {
			addCriterion("long_term >", value, "longTerm");
			return (Criteria) this;
		}

		public Criteria andLongTermGreaterThanOrEqualTo(Integer value) {
			addCriterion("long_term >=", value, "longTerm");
			return (Criteria) this;
		}

		public Criteria andLongTermLessThan(Integer value) {
			addCriterion("long_term <", value, "longTerm");
			return (Criteria) this;
		}

		public Criteria andLongTermLessThanOrEqualTo(Integer value) {
			addCriterion("long_term <=", value, "longTerm");
			return (Criteria) this;
		}

		public Criteria andLongTermIn(List<Integer> values) {
			addCriterion("long_term in", values, "longTerm");
			return (Criteria) this;
		}

		public Criteria andLongTermNotIn(List<Integer> values) {
			addCriterion("long_term not in", values, "longTerm");
			return (Criteria) this;
		}

		public Criteria andLongTermBetween(Integer value1, Integer value2) {
			addCriterion("long_term between", value1, value2, "longTerm");
			return (Criteria) this;
		}

		public Criteria andLongTermNotBetween(Integer value1, Integer value2) {
			addCriterion("long_term not between", value1, value2, "longTerm");
			return (Criteria) this;
		}

		public Criteria andCouponPerMemberIsNull() {
			addCriterion("coupon_per_member is null");
			return (Criteria) this;
		}

		public Criteria andCouponPerMemberIsNotNull() {
			addCriterion("coupon_per_member is not null");
			return (Criteria) this;
		}

		public Criteria andCouponPerMemberEqualTo(Integer value) {
			addCriterion("coupon_per_member =", value, "couponPerMember");
			return (Criteria) this;
		}

		public Criteria andCouponPerMemberNotEqualTo(Integer value) {
			addCriterion("coupon_per_member <>", value, "couponPerMember");
			return (Criteria) this;
		}

		public Criteria andCouponPerMemberGreaterThan(Integer value) {
			addCriterion("coupon_per_member >", value, "couponPerMember");
			return (Criteria) this;
		}

		public Criteria andCouponPerMemberGreaterThanOrEqualTo(Integer value) {
			addCriterion("coupon_per_member >=", value, "couponPerMember");
			return (Criteria) this;
		}

		public Criteria andCouponPerMemberLessThan(Integer value) {
			addCriterion("coupon_per_member <", value, "couponPerMember");
			return (Criteria) this;
		}

		public Criteria andCouponPerMemberLessThanOrEqualTo(Integer value) {
			addCriterion("coupon_per_member <=", value, "couponPerMember");
			return (Criteria) this;
		}

		public Criteria andCouponPerMemberIn(List<Integer> values) {
			addCriterion("coupon_per_member in", values, "couponPerMember");
			return (Criteria) this;
		}

		public Criteria andCouponPerMemberNotIn(List<Integer> values) {
			addCriterion("coupon_per_member not in", values, "couponPerMember");
			return (Criteria) this;
		}

		public Criteria andCouponPerMemberBetween(Integer value1, Integer value2) {
			addCriterion("coupon_per_member between", value1, value2, "couponPerMember");
			return (Criteria) this;
		}

		public Criteria andCouponPerMemberNotBetween(Integer value1, Integer value2) {
			addCriterion("coupon_per_member not between", value1, value2, "couponPerMember");
			return (Criteria) this;
		}

		public Criteria andPointIsNull() {
			addCriterion("point is null");
			return (Criteria) this;
		}

		public Criteria andPointIsNotNull() {
			addCriterion("point is not null");
			return (Criteria) this;
		}

		public Criteria andPointEqualTo(Integer value) {
			addCriterion("point =", value, "point");
			return (Criteria) this;
		}

		public Criteria andPointNotEqualTo(Integer value) {
			addCriterion("point <>", value, "point");
			return (Criteria) this;
		}

		public Criteria andPointGreaterThan(Integer value) {
			addCriterion("point >", value, "point");
			return (Criteria) this;
		}

		public Criteria andPointGreaterThanOrEqualTo(Integer value) {
			addCriterion("point >=", value, "point");
			return (Criteria) this;
		}

		public Criteria andPointLessThan(Integer value) {
			addCriterion("point <", value, "point");
			return (Criteria) this;
		}

		public Criteria andPointLessThanOrEqualTo(Integer value) {
			addCriterion("point <=", value, "point");
			return (Criteria) this;
		}

		public Criteria andPointIn(List<Integer> values) {
			addCriterion("point in", values, "point");
			return (Criteria) this;
		}

		public Criteria andPointNotIn(List<Integer> values) {
			addCriterion("point not in", values, "point");
			return (Criteria) this;
		}

		public Criteria andPointBetween(Integer value1, Integer value2) {
			addCriterion("point between", value1, value2, "point");
			return (Criteria) this;
		}

		public Criteria andPointNotBetween(Integer value1, Integer value2) {
			addCriterion("point not between", value1, value2, "point");
			return (Criteria) this;
		}

		public Criteria andCheckStatusIsNull() {
			addCriterion("check_status is null");
			return (Criteria) this;
		}

		public Criteria andCheckStatusIsNotNull() {
			addCriterion("check_status is not null");
			return (Criteria) this;
		}

		public Criteria andCheckStatusEqualTo(Integer value) {
			addCriterion("check_status =", value, "checkStatus");
			return (Criteria) this;
		}

		public Criteria andCheckStatusNotEqualTo(Integer value) {
			addCriterion("check_status <>", value, "checkStatus");
			return (Criteria) this;
		}

		public Criteria andCheckStatusGreaterThan(Integer value) {
			addCriterion("check_status >", value, "checkStatus");
			return (Criteria) this;
		}

		public Criteria andCheckStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("check_status >=", value, "checkStatus");
			return (Criteria) this;
		}

		public Criteria andCheckStatusLessThan(Integer value) {
			addCriterion("check_status <", value, "checkStatus");
			return (Criteria) this;
		}

		public Criteria andCheckStatusLessThanOrEqualTo(Integer value) {
			addCriterion("check_status <=", value, "checkStatus");
			return (Criteria) this;
		}

		public Criteria andCheckStatusIn(List<Integer> values) {
			addCriterion("check_status in", values, "checkStatus");
			return (Criteria) this;
		}

		public Criteria andCheckStatusNotIn(List<Integer> values) {
			addCriterion("check_status not in", values, "checkStatus");
			return (Criteria) this;
		}

		public Criteria andCheckStatusBetween(Integer value1, Integer value2) {
			addCriterion("check_status between", value1, value2, "checkStatus");
			return (Criteria) this;
		}

		public Criteria andCheckStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("check_status not between", value1, value2, "checkStatus");
			return (Criteria) this;
		}

		public Criteria andActivityStatusIsNull() {
			addCriterion("activity_status is null");
			return (Criteria) this;
		}

		public Criteria andActivityStatusIsNotNull() {
			addCriterion("activity_status is not null");
			return (Criteria) this;
		}

		public Criteria andActivityStatusEqualTo(Integer value) {
			addCriterion("activity_status =", value, "activityStatus");
			return (Criteria) this;
		}

		public Criteria andActivityStatusNotEqualTo(Integer value) {
			addCriterion("activity_status <>", value, "activityStatus");
			return (Criteria) this;
		}

		public Criteria andActivityStatusGreaterThan(Integer value) {
			addCriterion("activity_status >", value, "activityStatus");
			return (Criteria) this;
		}

		public Criteria andActivityStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("activity_status >=", value, "activityStatus");
			return (Criteria) this;
		}

		public Criteria andActivityStatusLessThan(Integer value) {
			addCriterion("activity_status <", value, "activityStatus");
			return (Criteria) this;
		}

		public Criteria andActivityStatusLessThanOrEqualTo(Integer value) {
			addCriterion("activity_status <=", value, "activityStatus");
			return (Criteria) this;
		}

		public Criteria andActivityStatusIn(List<Integer> values) {
			addCriterion("activity_status in", values, "activityStatus");
			return (Criteria) this;
		}

		public Criteria andActivityStatusNotIn(List<Integer> values) {
			addCriterion("activity_status not in", values, "activityStatus");
			return (Criteria) this;
		}

		public Criteria andActivityStatusBetween(Integer value1, Integer value2) {
			addCriterion("activity_status between", value1, value2, "activityStatus");
			return (Criteria) this;
		}

		public Criteria andActivityStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("activity_status not between", value1, value2, "activityStatus");
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
	 * 只读. t_mkt_activity
	 * @mbg.generated  2018-07-06 19:28:16
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
     * This class corresponds to the database table t_mkt_activity
     *
     * @mbg.generated do_not_delete_during_merge 2018-07-06 18:29:38
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }
}