package com.bizvane.mktcenterservice.models.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class MktActivityStatisticsPOExample implements Serializable {
    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    protected String orderByClause;

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    protected boolean distinct;

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    protected List<Criteria> oredCriteria;

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    private static final long serialVersionUID = 1L;

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public MktActivityStatisticsPOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
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
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * 只读. t_mkt_activity_statistics
     *
     * @mbg.generated 2019-01-11 11:03:19
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

        public Criteria andOther1IsNull() {
            addCriterion("other1 is null");
            return (Criteria) this;
        }

        public Criteria andOther1IsNotNull() {
            addCriterion("other1 is not null");
            return (Criteria) this;
        }

        public Criteria andOther1EqualTo(String value) {
            addCriterion("other1 =", value, "other1");
            return (Criteria) this;
        }

        public Criteria andOther1NotEqualTo(String value) {
            addCriterion("other1 <>", value, "other1");
            return (Criteria) this;
        }

        public Criteria andOther1GreaterThan(String value) {
            addCriterion("other1 >", value, "other1");
            return (Criteria) this;
        }

        public Criteria andOther1GreaterThanOrEqualTo(String value) {
            addCriterion("other1 >=", value, "other1");
            return (Criteria) this;
        }

        public Criteria andOther1LessThan(String value) {
            addCriterion("other1 <", value, "other1");
            return (Criteria) this;
        }

        public Criteria andOther1LessThanOrEqualTo(String value) {
            addCriterion("other1 <=", value, "other1");
            return (Criteria) this;
        }

        public Criteria andOther1Like(String value) {
            addCriterion("other1 like", value, "other1");
            return (Criteria) this;
        }

        public Criteria andOther1NotLike(String value) {
            addCriterion("other1 not like", value, "other1");
            return (Criteria) this;
        }

        public Criteria andOther1In(List<String> values) {
            addCriterion("other1 in", values, "other1");
            return (Criteria) this;
        }

        public Criteria andOther1NotIn(List<String> values) {
            addCriterion("other1 not in", values, "other1");
            return (Criteria) this;
        }

        public Criteria andOther1Between(String value1, String value2) {
            addCriterion("other1 between", value1, value2, "other1");
            return (Criteria) this;
        }

        public Criteria andOther1NotBetween(String value1, String value2) {
            addCriterion("other1 not between", value1, value2, "other1");
            return (Criteria) this;
        }

        public Criteria andOther2IsNull() {
            addCriterion("other2 is null");
            return (Criteria) this;
        }

        public Criteria andOther2IsNotNull() {
            addCriterion("other2 is not null");
            return (Criteria) this;
        }

        public Criteria andOther2EqualTo(String value) {
            addCriterion("other2 =", value, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2NotEqualTo(String value) {
            addCriterion("other2 <>", value, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2GreaterThan(String value) {
            addCriterion("other2 >", value, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2GreaterThanOrEqualTo(String value) {
            addCriterion("other2 >=", value, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2LessThan(String value) {
            addCriterion("other2 <", value, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2LessThanOrEqualTo(String value) {
            addCriterion("other2 <=", value, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2Like(String value) {
            addCriterion("other2 like", value, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2NotLike(String value) {
            addCriterion("other2 not like", value, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2In(List<String> values) {
            addCriterion("other2 in", values, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2NotIn(List<String> values) {
            addCriterion("other2 not in", values, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2Between(String value1, String value2) {
            addCriterion("other2 between", value1, value2, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2NotBetween(String value1, String value2) {
            addCriterion("other2 not between", value1, value2, "other2");
            return (Criteria) this;
        }

        public Criteria andOther3IsNull() {
            addCriterion("other3 is null");
            return (Criteria) this;
        }

        public Criteria andOther3IsNotNull() {
            addCriterion("other3 is not null");
            return (Criteria) this;
        }

        public Criteria andOther3EqualTo(String value) {
            addCriterion("other3 =", value, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3NotEqualTo(String value) {
            addCriterion("other3 <>", value, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3GreaterThan(String value) {
            addCriterion("other3 >", value, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3GreaterThanOrEqualTo(String value) {
            addCriterion("other3 >=", value, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3LessThan(String value) {
            addCriterion("other3 <", value, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3LessThanOrEqualTo(String value) {
            addCriterion("other3 <=", value, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3Like(String value) {
            addCriterion("other3 like", value, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3NotLike(String value) {
            addCriterion("other3 not like", value, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3In(List<String> values) {
            addCriterion("other3 in", values, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3NotIn(List<String> values) {
            addCriterion("other3 not in", values, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3Between(String value1, String value2) {
            addCriterion("other3 between", value1, value2, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3NotBetween(String value1, String value2) {
            addCriterion("other3 not between", value1, value2, "other3");
            return (Criteria) this;
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

    /**
     * 只读. t_mkt_activity_statistics
     *
     * @mbg.generated 2019-01-11 11:03:19
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
}