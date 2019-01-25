package com.bizvane.mktcenterservice.models.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class MktActivityStatisticsPOExample implements Serializable {
    /**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	protected String orderByClause;
	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	protected boolean distinct;
	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	protected List<Criteria> oredCriteria;
	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	public MktActivityStatisticsPOExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
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
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * 只读. t_mkt_activity_statistics
	 * @mbg.generated  2019-01-25 10:27:46
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

		protected void addCriterionForJDBCDate(String condition, Date value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value.getTime()), property);
		}

		protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
			if (values == null || values.size() == 0) {
				throw new RuntimeException("Value list for " + property + " cannot be null or empty");
			}
			List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
			Iterator<Date> iter = values.iterator();
			while (iter.hasNext()) {
				dateList.add(new java.sql.Date(iter.next().getTime()));
			}
			addCriterion(condition, dateList, property);
		}

		protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
		}

		public Criteria andMktActivityStatisticsIdIsNull() {
			addCriterion("mkt_activity_statistics_id is null");
			return (Criteria) this;
		}

		public Criteria andMktActivityStatisticsIdIsNotNull() {
			addCriterion("mkt_activity_statistics_id is not null");
			return (Criteria) this;
		}

		public Criteria andMktActivityStatisticsIdEqualTo(Long value) {
			addCriterion("mkt_activity_statistics_id =", value, "mktActivityStatisticsId");
			return (Criteria) this;
		}

		public Criteria andMktActivityStatisticsIdNotEqualTo(Long value) {
			addCriterion("mkt_activity_statistics_id <>", value, "mktActivityStatisticsId");
			return (Criteria) this;
		}

		public Criteria andMktActivityStatisticsIdGreaterThan(Long value) {
			addCriterion("mkt_activity_statistics_id >", value, "mktActivityStatisticsId");
			return (Criteria) this;
		}

		public Criteria andMktActivityStatisticsIdGreaterThanOrEqualTo(Long value) {
			addCriterion("mkt_activity_statistics_id >=", value, "mktActivityStatisticsId");
			return (Criteria) this;
		}

		public Criteria andMktActivityStatisticsIdLessThan(Long value) {
			addCriterion("mkt_activity_statistics_id <", value, "mktActivityStatisticsId");
			return (Criteria) this;
		}

		public Criteria andMktActivityStatisticsIdLessThanOrEqualTo(Long value) {
			addCriterion("mkt_activity_statistics_id <=", value, "mktActivityStatisticsId");
			return (Criteria) this;
		}

		public Criteria andMktActivityStatisticsIdIn(List<Long> values) {
			addCriterion("mkt_activity_statistics_id in", values, "mktActivityStatisticsId");
			return (Criteria) this;
		}

		public Criteria andMktActivityStatisticsIdNotIn(List<Long> values) {
			addCriterion("mkt_activity_statistics_id not in", values, "mktActivityStatisticsId");
			return (Criteria) this;
		}

		public Criteria andMktActivityStatisticsIdBetween(Long value1, Long value2) {
			addCriterion("mkt_activity_statistics_id between", value1, value2, "mktActivityStatisticsId");
			return (Criteria) this;
		}

		public Criteria andMktActivityStatisticsIdNotBetween(Long value1, Long value2) {
			addCriterion("mkt_activity_statistics_id not between", value1, value2, "mktActivityStatisticsId");
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

		public Criteria andVisitorsCountIsNull() {
			addCriterion("visitors_count is null");
			return (Criteria) this;
		}

		public Criteria andVisitorsCountIsNotNull() {
			addCriterion("visitors_count is not null");
			return (Criteria) this;
		}

		public Criteria andVisitorsCountEqualTo(Integer value) {
			addCriterion("visitors_count =", value, "visitorsCount");
			return (Criteria) this;
		}

		public Criteria andVisitorsCountNotEqualTo(Integer value) {
			addCriterion("visitors_count <>", value, "visitorsCount");
			return (Criteria) this;
		}

		public Criteria andVisitorsCountGreaterThan(Integer value) {
			addCriterion("visitors_count >", value, "visitorsCount");
			return (Criteria) this;
		}

		public Criteria andVisitorsCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("visitors_count >=", value, "visitorsCount");
			return (Criteria) this;
		}

		public Criteria andVisitorsCountLessThan(Integer value) {
			addCriterion("visitors_count <", value, "visitorsCount");
			return (Criteria) this;
		}

		public Criteria andVisitorsCountLessThanOrEqualTo(Integer value) {
			addCriterion("visitors_count <=", value, "visitorsCount");
			return (Criteria) this;
		}

		public Criteria andVisitorsCountIn(List<Integer> values) {
			addCriterion("visitors_count in", values, "visitorsCount");
			return (Criteria) this;
		}

		public Criteria andVisitorsCountNotIn(List<Integer> values) {
			addCriterion("visitors_count not in", values, "visitorsCount");
			return (Criteria) this;
		}

		public Criteria andVisitorsCountBetween(Integer value1, Integer value2) {
			addCriterion("visitors_count between", value1, value2, "visitorsCount");
			return (Criteria) this;
		}

		public Criteria andVisitorsCountNotBetween(Integer value1, Integer value2) {
			addCriterion("visitors_count not between", value1, value2, "visitorsCount");
			return (Criteria) this;
		}

		public Criteria andLaunchMembersCountIsNull() {
			addCriterion("launch_members_count is null");
			return (Criteria) this;
		}

		public Criteria andLaunchMembersCountIsNotNull() {
			addCriterion("launch_members_count is not null");
			return (Criteria) this;
		}

		public Criteria andLaunchMembersCountEqualTo(Integer value) {
			addCriterion("launch_members_count =", value, "launchMembersCount");
			return (Criteria) this;
		}

		public Criteria andLaunchMembersCountNotEqualTo(Integer value) {
			addCriterion("launch_members_count <>", value, "launchMembersCount");
			return (Criteria) this;
		}

		public Criteria andLaunchMembersCountGreaterThan(Integer value) {
			addCriterion("launch_members_count >", value, "launchMembersCount");
			return (Criteria) this;
		}

		public Criteria andLaunchMembersCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("launch_members_count >=", value, "launchMembersCount");
			return (Criteria) this;
		}

		public Criteria andLaunchMembersCountLessThan(Integer value) {
			addCriterion("launch_members_count <", value, "launchMembersCount");
			return (Criteria) this;
		}

		public Criteria andLaunchMembersCountLessThanOrEqualTo(Integer value) {
			addCriterion("launch_members_count <=", value, "launchMembersCount");
			return (Criteria) this;
		}

		public Criteria andLaunchMembersCountIn(List<Integer> values) {
			addCriterion("launch_members_count in", values, "launchMembersCount");
			return (Criteria) this;
		}

		public Criteria andLaunchMembersCountNotIn(List<Integer> values) {
			addCriterion("launch_members_count not in", values, "launchMembersCount");
			return (Criteria) this;
		}

		public Criteria andLaunchMembersCountBetween(Integer value1, Integer value2) {
			addCriterion("launch_members_count between", value1, value2, "launchMembersCount");
			return (Criteria) this;
		}

		public Criteria andLaunchMembersCountNotBetween(Integer value1, Integer value2) {
			addCriterion("launch_members_count not between", value1, value2, "launchMembersCount");
			return (Criteria) this;
		}

		public Criteria andHelpMembersCountIsNull() {
			addCriterion("help_members_count is null");
			return (Criteria) this;
		}

		public Criteria andHelpMembersCountIsNotNull() {
			addCriterion("help_members_count is not null");
			return (Criteria) this;
		}

		public Criteria andHelpMembersCountEqualTo(Integer value) {
			addCriterion("help_members_count =", value, "helpMembersCount");
			return (Criteria) this;
		}

		public Criteria andHelpMembersCountNotEqualTo(Integer value) {
			addCriterion("help_members_count <>", value, "helpMembersCount");
			return (Criteria) this;
		}

		public Criteria andHelpMembersCountGreaterThan(Integer value) {
			addCriterion("help_members_count >", value, "helpMembersCount");
			return (Criteria) this;
		}

		public Criteria andHelpMembersCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("help_members_count >=", value, "helpMembersCount");
			return (Criteria) this;
		}

		public Criteria andHelpMembersCountLessThan(Integer value) {
			addCriterion("help_members_count <", value, "helpMembersCount");
			return (Criteria) this;
		}

		public Criteria andHelpMembersCountLessThanOrEqualTo(Integer value) {
			addCriterion("help_members_count <=", value, "helpMembersCount");
			return (Criteria) this;
		}

		public Criteria andHelpMembersCountIn(List<Integer> values) {
			addCriterion("help_members_count in", values, "helpMembersCount");
			return (Criteria) this;
		}

		public Criteria andHelpMembersCountNotIn(List<Integer> values) {
			addCriterion("help_members_count not in", values, "helpMembersCount");
			return (Criteria) this;
		}

		public Criteria andHelpMembersCountBetween(Integer value1, Integer value2) {
			addCriterion("help_members_count between", value1, value2, "helpMembersCount");
			return (Criteria) this;
		}

		public Criteria andHelpMembersCountNotBetween(Integer value1, Integer value2) {
			addCriterion("help_members_count not between", value1, value2, "helpMembersCount");
			return (Criteria) this;
		}

		public Criteria andRegisterMembersCountIsNull() {
			addCriterion("register_members_count is null");
			return (Criteria) this;
		}

		public Criteria andRegisterMembersCountIsNotNull() {
			addCriterion("register_members_count is not null");
			return (Criteria) this;
		}

		public Criteria andRegisterMembersCountEqualTo(Integer value) {
			addCriterion("register_members_count =", value, "registerMembersCount");
			return (Criteria) this;
		}

		public Criteria andRegisterMembersCountNotEqualTo(Integer value) {
			addCriterion("register_members_count <>", value, "registerMembersCount");
			return (Criteria) this;
		}

		public Criteria andRegisterMembersCountGreaterThan(Integer value) {
			addCriterion("register_members_count >", value, "registerMembersCount");
			return (Criteria) this;
		}

		public Criteria andRegisterMembersCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("register_members_count >=", value, "registerMembersCount");
			return (Criteria) this;
		}

		public Criteria andRegisterMembersCountLessThan(Integer value) {
			addCriterion("register_members_count <", value, "registerMembersCount");
			return (Criteria) this;
		}

		public Criteria andRegisterMembersCountLessThanOrEqualTo(Integer value) {
			addCriterion("register_members_count <=", value, "registerMembersCount");
			return (Criteria) this;
		}

		public Criteria andRegisterMembersCountIn(List<Integer> values) {
			addCriterion("register_members_count in", values, "registerMembersCount");
			return (Criteria) this;
		}

		public Criteria andRegisterMembersCountNotIn(List<Integer> values) {
			addCriterion("register_members_count not in", values, "registerMembersCount");
			return (Criteria) this;
		}

		public Criteria andRegisterMembersCountBetween(Integer value1, Integer value2) {
			addCriterion("register_members_count between", value1, value2, "registerMembersCount");
			return (Criteria) this;
		}

		public Criteria andRegisterMembersCountNotBetween(Integer value1, Integer value2) {
			addCriterion("register_members_count not between", value1, value2, "registerMembersCount");
			return (Criteria) this;
		}

		public Criteria andTakeCouponCountIsNull() {
			addCriterion("take_coupon_count is null");
			return (Criteria) this;
		}

		public Criteria andTakeCouponCountIsNotNull() {
			addCriterion("take_coupon_count is not null");
			return (Criteria) this;
		}

		public Criteria andTakeCouponCountEqualTo(Long value) {
			addCriterion("take_coupon_count =", value, "takeCouponCount");
			return (Criteria) this;
		}

		public Criteria andTakeCouponCountNotEqualTo(Long value) {
			addCriterion("take_coupon_count <>", value, "takeCouponCount");
			return (Criteria) this;
		}

		public Criteria andTakeCouponCountGreaterThan(Long value) {
			addCriterion("take_coupon_count >", value, "takeCouponCount");
			return (Criteria) this;
		}

		public Criteria andTakeCouponCountGreaterThanOrEqualTo(Long value) {
			addCriterion("take_coupon_count >=", value, "takeCouponCount");
			return (Criteria) this;
		}

		public Criteria andTakeCouponCountLessThan(Long value) {
			addCriterion("take_coupon_count <", value, "takeCouponCount");
			return (Criteria) this;
		}

		public Criteria andTakeCouponCountLessThanOrEqualTo(Long value) {
			addCriterion("take_coupon_count <=", value, "takeCouponCount");
			return (Criteria) this;
		}

		public Criteria andTakeCouponCountIn(List<Long> values) {
			addCriterion("take_coupon_count in", values, "takeCouponCount");
			return (Criteria) this;
		}

		public Criteria andTakeCouponCountNotIn(List<Long> values) {
			addCriterion("take_coupon_count not in", values, "takeCouponCount");
			return (Criteria) this;
		}

		public Criteria andTakeCouponCountBetween(Long value1, Long value2) {
			addCriterion("take_coupon_count between", value1, value2, "takeCouponCount");
			return (Criteria) this;
		}

		public Criteria andTakeCouponCountNotBetween(Long value1, Long value2) {
			addCriterion("take_coupon_count not between", value1, value2, "takeCouponCount");
			return (Criteria) this;
		}

		public Criteria andStatisticsTimeIsNull() {
			addCriterion("statistics_time is null");
			return (Criteria) this;
		}

		public Criteria andStatisticsTimeIsNotNull() {
			addCriterion("statistics_time is not null");
			return (Criteria) this;
		}

		public Criteria andStatisticsTimeEqualTo(Date value) {
			addCriterionForJDBCDate("statistics_time =", value, "statisticsTime");
			return (Criteria) this;
		}

		public Criteria andStatisticsTimeNotEqualTo(Date value) {
			addCriterionForJDBCDate("statistics_time <>", value, "statisticsTime");
			return (Criteria) this;
		}

		public Criteria andStatisticsTimeGreaterThan(Date value) {
			addCriterionForJDBCDate("statistics_time >", value, "statisticsTime");
			return (Criteria) this;
		}

		public Criteria andStatisticsTimeGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("statistics_time >=", value, "statisticsTime");
			return (Criteria) this;
		}

		public Criteria andStatisticsTimeLessThan(Date value) {
			addCriterionForJDBCDate("statistics_time <", value, "statisticsTime");
			return (Criteria) this;
		}

		public Criteria andStatisticsTimeLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("statistics_time <=", value, "statisticsTime");
			return (Criteria) this;
		}

		public Criteria andStatisticsTimeIn(List<Date> values) {
			addCriterionForJDBCDate("statistics_time in", values, "statisticsTime");
			return (Criteria) this;
		}

		public Criteria andStatisticsTimeNotIn(List<Date> values) {
			addCriterionForJDBCDate("statistics_time not in", values, "statisticsTime");
			return (Criteria) this;
		}

		public Criteria andStatisticsTimeBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("statistics_time between", value1, value2, "statisticsTime");
			return (Criteria) this;
		}

		public Criteria andStatisticsTimeNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("statistics_time not between", value1, value2, "statisticsTime");
			return (Criteria) this;
		}

		public Criteria andStatisticsTypeIsNull() {
			addCriterion("statistics_type is null");
			return (Criteria) this;
		}

		public Criteria andStatisticsTypeIsNotNull() {
			addCriterion("statistics_type is not null");
			return (Criteria) this;
		}

		public Criteria andStatisticsTypeEqualTo(String value) {
			addCriterion("statistics_type =", value, "statisticsType");
			return (Criteria) this;
		}

		public Criteria andStatisticsTypeNotEqualTo(String value) {
			addCriterion("statistics_type <>", value, "statisticsType");
			return (Criteria) this;
		}

		public Criteria andStatisticsTypeGreaterThan(String value) {
			addCriterion("statistics_type >", value, "statisticsType");
			return (Criteria) this;
		}

		public Criteria andStatisticsTypeGreaterThanOrEqualTo(String value) {
			addCriterion("statistics_type >=", value, "statisticsType");
			return (Criteria) this;
		}

		public Criteria andStatisticsTypeLessThan(String value) {
			addCriterion("statistics_type <", value, "statisticsType");
			return (Criteria) this;
		}

		public Criteria andStatisticsTypeLessThanOrEqualTo(String value) {
			addCriterion("statistics_type <=", value, "statisticsType");
			return (Criteria) this;
		}

		public Criteria andStatisticsTypeLike(String value) {
			addCriterion("statistics_type like", value, "statisticsType");
			return (Criteria) this;
		}

		public Criteria andStatisticsTypeNotLike(String value) {
			addCriterion("statistics_type not like", value, "statisticsType");
			return (Criteria) this;
		}

		public Criteria andStatisticsTypeIn(List<String> values) {
			addCriterion("statistics_type in", values, "statisticsType");
			return (Criteria) this;
		}

		public Criteria andStatisticsTypeNotIn(List<String> values) {
			addCriterion("statistics_type not in", values, "statisticsType");
			return (Criteria) this;
		}

		public Criteria andStatisticsTypeBetween(String value1, String value2) {
			addCriterion("statistics_type between", value1, value2, "statisticsType");
			return (Criteria) this;
		}

		public Criteria andStatisticsTypeNotBetween(String value1, String value2) {
			addCriterion("statistics_type not between", value1, value2, "statisticsType");
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
	 * 只读. t_mkt_activity_statistics
	 * @mbg.generated  2019-01-25 10:27:46
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
     * This class corresponds to the database table t_mkt_activity_statistics
     *
     * @mbg.generated do_not_delete_during_merge 2019-01-11 11:03:19
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }
}