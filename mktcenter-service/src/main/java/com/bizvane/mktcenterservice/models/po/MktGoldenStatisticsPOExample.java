package com.bizvane.mktcenterservice.models.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MktGoldenStatisticsPOExample implements Serializable {
    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    protected String orderByClause;

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    protected boolean distinct;

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    protected List<Criteria> oredCriteria;

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    private static final long serialVersionUID = 1L;

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    public MktGoldenStatisticsPOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
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
     * @mbg.generated 2019-02-19 16:54:15
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * 只读. t_mkt_golden_statistics
     *
     * @mbg.generated 2019-02-19 16:54:15
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

        public Criteria andMktGoldenStatisticsIdIsNull() {
            addCriterion("mkt_golden_statistics_id is null");
            return (Criteria) this;
        }

        public Criteria andMktGoldenStatisticsIdIsNotNull() {
            addCriterion("mkt_golden_statistics_id is not null");
            return (Criteria) this;
        }

        public Criteria andMktGoldenStatisticsIdEqualTo(Long value) {
            addCriterion("mkt_golden_statistics_id =", value, "mktGoldenStatisticsId");
            return (Criteria) this;
        }

        public Criteria andMktGoldenStatisticsIdNotEqualTo(Long value) {
            addCriterion("mkt_golden_statistics_id <>", value, "mktGoldenStatisticsId");
            return (Criteria) this;
        }

        public Criteria andMktGoldenStatisticsIdGreaterThan(Long value) {
            addCriterion("mkt_golden_statistics_id >", value, "mktGoldenStatisticsId");
            return (Criteria) this;
        }

        public Criteria andMktGoldenStatisticsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("mkt_golden_statistics_id >=", value, "mktGoldenStatisticsId");
            return (Criteria) this;
        }

        public Criteria andMktGoldenStatisticsIdLessThan(Long value) {
            addCriterion("mkt_golden_statistics_id <", value, "mktGoldenStatisticsId");
            return (Criteria) this;
        }

        public Criteria andMktGoldenStatisticsIdLessThanOrEqualTo(Long value) {
            addCriterion("mkt_golden_statistics_id <=", value, "mktGoldenStatisticsId");
            return (Criteria) this;
        }

        public Criteria andMktGoldenStatisticsIdIn(List<Long> values) {
            addCriterion("mkt_golden_statistics_id in", values, "mktGoldenStatisticsId");
            return (Criteria) this;
        }

        public Criteria andMktGoldenStatisticsIdNotIn(List<Long> values) {
            addCriterion("mkt_golden_statistics_id not in", values, "mktGoldenStatisticsId");
            return (Criteria) this;
        }

        public Criteria andMktGoldenStatisticsIdBetween(Long value1, Long value2) {
            addCriterion("mkt_golden_statistics_id between", value1, value2, "mktGoldenStatisticsId");
            return (Criteria) this;
        }

        public Criteria andMktGoldenStatisticsIdNotBetween(Long value1, Long value2) {
            addCriterion("mkt_golden_statistics_id not between", value1, value2, "mktGoldenStatisticsId");
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

        public Criteria andParticipateMemberCountIsNull() {
            addCriterion("participate_member_count is null");
            return (Criteria) this;
        }

        public Criteria andParticipateMemberCountIsNotNull() {
            addCriterion("participate_member_count is not null");
            return (Criteria) this;
        }

        public Criteria andParticipateMemberCountEqualTo(Integer value) {
            addCriterion("participate_member_count =", value, "participateMemberCount");
            return (Criteria) this;
        }

        public Criteria andParticipateMemberCountNotEqualTo(Integer value) {
            addCriterion("participate_member_count <>", value, "participateMemberCount");
            return (Criteria) this;
        }

        public Criteria andParticipateMemberCountGreaterThan(Integer value) {
            addCriterion("participate_member_count >", value, "participateMemberCount");
            return (Criteria) this;
        }

        public Criteria andParticipateMemberCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("participate_member_count >=", value, "participateMemberCount");
            return (Criteria) this;
        }

        public Criteria andParticipateMemberCountLessThan(Integer value) {
            addCriterion("participate_member_count <", value, "participateMemberCount");
            return (Criteria) this;
        }

        public Criteria andParticipateMemberCountLessThanOrEqualTo(Integer value) {
            addCriterion("participate_member_count <=", value, "participateMemberCount");
            return (Criteria) this;
        }

        public Criteria andParticipateMemberCountIn(List<Integer> values) {
            addCriterion("participate_member_count in", values, "participateMemberCount");
            return (Criteria) this;
        }

        public Criteria andParticipateMemberCountNotIn(List<Integer> values) {
            addCriterion("participate_member_count not in", values, "participateMemberCount");
            return (Criteria) this;
        }

        public Criteria andParticipateMemberCountBetween(Integer value1, Integer value2) {
            addCriterion("participate_member_count between", value1, value2, "participateMemberCount");
            return (Criteria) this;
        }

        public Criteria andParticipateMemberCountNotBetween(Integer value1, Integer value2) {
            addCriterion("participate_member_count not between", value1, value2, "participateMemberCount");
            return (Criteria) this;
        }

        public Criteria andPageForwardCountIsNull() {
            addCriterion("page_forward_count is null");
            return (Criteria) this;
        }

        public Criteria andPageForwardCountIsNotNull() {
            addCriterion("page_forward_count is not null");
            return (Criteria) this;
        }

        public Criteria andPageForwardCountEqualTo(Integer value) {
            addCriterion("page_forward_count =", value, "pageForwardCount");
            return (Criteria) this;
        }

        public Criteria andPageForwardCountNotEqualTo(Integer value) {
            addCriterion("page_forward_count <>", value, "pageForwardCount");
            return (Criteria) this;
        }

        public Criteria andPageForwardCountGreaterThan(Integer value) {
            addCriterion("page_forward_count >", value, "pageForwardCount");
            return (Criteria) this;
        }

        public Criteria andPageForwardCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("page_forward_count >=", value, "pageForwardCount");
            return (Criteria) this;
        }

        public Criteria andPageForwardCountLessThan(Integer value) {
            addCriterion("page_forward_count <", value, "pageForwardCount");
            return (Criteria) this;
        }

        public Criteria andPageForwardCountLessThanOrEqualTo(Integer value) {
            addCriterion("page_forward_count <=", value, "pageForwardCount");
            return (Criteria) this;
        }

        public Criteria andPageForwardCountIn(List<Integer> values) {
            addCriterion("page_forward_count in", values, "pageForwardCount");
            return (Criteria) this;
        }

        public Criteria andPageForwardCountNotIn(List<Integer> values) {
            addCriterion("page_forward_count not in", values, "pageForwardCount");
            return (Criteria) this;
        }

        public Criteria andPageForwardCountBetween(Integer value1, Integer value2) {
            addCriterion("page_forward_count between", value1, value2, "pageForwardCount");
            return (Criteria) this;
        }

        public Criteria andPageForwardCountNotBetween(Integer value1, Integer value2) {
            addCriterion("page_forward_count not between", value1, value2, "pageForwardCount");
            return (Criteria) this;
        }

        public Criteria andEffectiveSharingCountIsNull() {
            addCriterion("effective_sharing_count is null");
            return (Criteria) this;
        }

        public Criteria andEffectiveSharingCountIsNotNull() {
            addCriterion("effective_sharing_count is not null");
            return (Criteria) this;
        }

        public Criteria andEffectiveSharingCountEqualTo(Integer value) {
            addCriterion("effective_sharing_count =", value, "effectiveSharingCount");
            return (Criteria) this;
        }

        public Criteria andEffectiveSharingCountNotEqualTo(Integer value) {
            addCriterion("effective_sharing_count <>", value, "effectiveSharingCount");
            return (Criteria) this;
        }

        public Criteria andEffectiveSharingCountGreaterThan(Integer value) {
            addCriterion("effective_sharing_count >", value, "effectiveSharingCount");
            return (Criteria) this;
        }

        public Criteria andEffectiveSharingCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("effective_sharing_count >=", value, "effectiveSharingCount");
            return (Criteria) this;
        }

        public Criteria andEffectiveSharingCountLessThan(Integer value) {
            addCriterion("effective_sharing_count <", value, "effectiveSharingCount");
            return (Criteria) this;
        }

        public Criteria andEffectiveSharingCountLessThanOrEqualTo(Integer value) {
            addCriterion("effective_sharing_count <=", value, "effectiveSharingCount");
            return (Criteria) this;
        }

        public Criteria andEffectiveSharingCountIn(List<Integer> values) {
            addCriterion("effective_sharing_count in", values, "effectiveSharingCount");
            return (Criteria) this;
        }

        public Criteria andEffectiveSharingCountNotIn(List<Integer> values) {
            addCriterion("effective_sharing_count not in", values, "effectiveSharingCount");
            return (Criteria) this;
        }

        public Criteria andEffectiveSharingCountBetween(Integer value1, Integer value2) {
            addCriterion("effective_sharing_count between", value1, value2, "effectiveSharingCount");
            return (Criteria) this;
        }

        public Criteria andEffectiveSharingCountNotBetween(Integer value1, Integer value2) {
            addCriterion("effective_sharing_count not between", value1, value2, "effectiveSharingCount");
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

        public Criteria andTotalVisitorsCountIsNull() {
            addCriterion("total_visitors_count is null");
            return (Criteria) this;
        }

        public Criteria andTotalVisitorsCountIsNotNull() {
            addCriterion("total_visitors_count is not null");
            return (Criteria) this;
        }

        public Criteria andTotalVisitorsCountEqualTo(Integer value) {
            addCriterion("total_visitors_count =", value, "totalVisitorsCount");
            return (Criteria) this;
        }

        public Criteria andTotalVisitorsCountNotEqualTo(Integer value) {
            addCriterion("total_visitors_count <>", value, "totalVisitorsCount");
            return (Criteria) this;
        }

        public Criteria andTotalVisitorsCountGreaterThan(Integer value) {
            addCriterion("total_visitors_count >", value, "totalVisitorsCount");
            return (Criteria) this;
        }

        public Criteria andTotalVisitorsCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_visitors_count >=", value, "totalVisitorsCount");
            return (Criteria) this;
        }

        public Criteria andTotalVisitorsCountLessThan(Integer value) {
            addCriterion("total_visitors_count <", value, "totalVisitorsCount");
            return (Criteria) this;
        }

        public Criteria andTotalVisitorsCountLessThanOrEqualTo(Integer value) {
            addCriterion("total_visitors_count <=", value, "totalVisitorsCount");
            return (Criteria) this;
        }

        public Criteria andTotalVisitorsCountIn(List<Integer> values) {
            addCriterion("total_visitors_count in", values, "totalVisitorsCount");
            return (Criteria) this;
        }

        public Criteria andTotalVisitorsCountNotIn(List<Integer> values) {
            addCriterion("total_visitors_count not in", values, "totalVisitorsCount");
            return (Criteria) this;
        }

        public Criteria andTotalVisitorsCountBetween(Integer value1, Integer value2) {
            addCriterion("total_visitors_count between", value1, value2, "totalVisitorsCount");
            return (Criteria) this;
        }

        public Criteria andTotalVisitorsCountNotBetween(Integer value1, Integer value2) {
            addCriterion("total_visitors_count not between", value1, value2, "totalVisitorsCount");
            return (Criteria) this;
        }

        public Criteria andTotalParticipateMemberCountIsNull() {
            addCriterion("total_participate_member_count is null");
            return (Criteria) this;
        }

        public Criteria andTotalParticipateMemberCountIsNotNull() {
            addCriterion("total_participate_member_count is not null");
            return (Criteria) this;
        }

        public Criteria andTotalParticipateMemberCountEqualTo(Integer value) {
            addCriterion("total_participate_member_count =", value, "totalParticipateMemberCount");
            return (Criteria) this;
        }

        public Criteria andTotalParticipateMemberCountNotEqualTo(Integer value) {
            addCriterion("total_participate_member_count <>", value, "totalParticipateMemberCount");
            return (Criteria) this;
        }

        public Criteria andTotalParticipateMemberCountGreaterThan(Integer value) {
            addCriterion("total_participate_member_count >", value, "totalParticipateMemberCount");
            return (Criteria) this;
        }

        public Criteria andTotalParticipateMemberCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_participate_member_count >=", value, "totalParticipateMemberCount");
            return (Criteria) this;
        }

        public Criteria andTotalParticipateMemberCountLessThan(Integer value) {
            addCriterion("total_participate_member_count <", value, "totalParticipateMemberCount");
            return (Criteria) this;
        }

        public Criteria andTotalParticipateMemberCountLessThanOrEqualTo(Integer value) {
            addCriterion("total_participate_member_count <=", value, "totalParticipateMemberCount");
            return (Criteria) this;
        }

        public Criteria andTotalParticipateMemberCountIn(List<Integer> values) {
            addCriterion("total_participate_member_count in", values, "totalParticipateMemberCount");
            return (Criteria) this;
        }

        public Criteria andTotalParticipateMemberCountNotIn(List<Integer> values) {
            addCriterion("total_participate_member_count not in", values, "totalParticipateMemberCount");
            return (Criteria) this;
        }

        public Criteria andTotalParticipateMemberCountBetween(Integer value1, Integer value2) {
            addCriterion("total_participate_member_count between", value1, value2, "totalParticipateMemberCount");
            return (Criteria) this;
        }

        public Criteria andTotalParticipateMemberCountNotBetween(Integer value1, Integer value2) {
            addCriterion("total_participate_member_count not between", value1, value2, "totalParticipateMemberCount");
            return (Criteria) this;
        }

        public Criteria andTotalPageForwardCountIsNull() {
            addCriterion("total_page_forward_count is null");
            return (Criteria) this;
        }

        public Criteria andTotalPageForwardCountIsNotNull() {
            addCriterion("total_page_forward_count is not null");
            return (Criteria) this;
        }

        public Criteria andTotalPageForwardCountEqualTo(Integer value) {
            addCriterion("total_page_forward_count =", value, "totalPageForwardCount");
            return (Criteria) this;
        }

        public Criteria andTotalPageForwardCountNotEqualTo(Integer value) {
            addCriterion("total_page_forward_count <>", value, "totalPageForwardCount");
            return (Criteria) this;
        }

        public Criteria andTotalPageForwardCountGreaterThan(Integer value) {
            addCriterion("total_page_forward_count >", value, "totalPageForwardCount");
            return (Criteria) this;
        }

        public Criteria andTotalPageForwardCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_page_forward_count >=", value, "totalPageForwardCount");
            return (Criteria) this;
        }

        public Criteria andTotalPageForwardCountLessThan(Integer value) {
            addCriterion("total_page_forward_count <", value, "totalPageForwardCount");
            return (Criteria) this;
        }

        public Criteria andTotalPageForwardCountLessThanOrEqualTo(Integer value) {
            addCriterion("total_page_forward_count <=", value, "totalPageForwardCount");
            return (Criteria) this;
        }

        public Criteria andTotalPageForwardCountIn(List<Integer> values) {
            addCriterion("total_page_forward_count in", values, "totalPageForwardCount");
            return (Criteria) this;
        }

        public Criteria andTotalPageForwardCountNotIn(List<Integer> values) {
            addCriterion("total_page_forward_count not in", values, "totalPageForwardCount");
            return (Criteria) this;
        }

        public Criteria andTotalPageForwardCountBetween(Integer value1, Integer value2) {
            addCriterion("total_page_forward_count between", value1, value2, "totalPageForwardCount");
            return (Criteria) this;
        }

        public Criteria andTotalPageForwardCountNotBetween(Integer value1, Integer value2) {
            addCriterion("total_page_forward_count not between", value1, value2, "totalPageForwardCount");
            return (Criteria) this;
        }

        public Criteria andTotalEffectiveSharingCountIsNull() {
            addCriterion("total_effective_sharing_count is null");
            return (Criteria) this;
        }

        public Criteria andTotalEffectiveSharingCountIsNotNull() {
            addCriterion("total_effective_sharing_count is not null");
            return (Criteria) this;
        }

        public Criteria andTotalEffectiveSharingCountEqualTo(Integer value) {
            addCriterion("total_effective_sharing_count =", value, "totalEffectiveSharingCount");
            return (Criteria) this;
        }

        public Criteria andTotalEffectiveSharingCountNotEqualTo(Integer value) {
            addCriterion("total_effective_sharing_count <>", value, "totalEffectiveSharingCount");
            return (Criteria) this;
        }

        public Criteria andTotalEffectiveSharingCountGreaterThan(Integer value) {
            addCriterion("total_effective_sharing_count >", value, "totalEffectiveSharingCount");
            return (Criteria) this;
        }

        public Criteria andTotalEffectiveSharingCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_effective_sharing_count >=", value, "totalEffectiveSharingCount");
            return (Criteria) this;
        }

        public Criteria andTotalEffectiveSharingCountLessThan(Integer value) {
            addCriterion("total_effective_sharing_count <", value, "totalEffectiveSharingCount");
            return (Criteria) this;
        }

        public Criteria andTotalEffectiveSharingCountLessThanOrEqualTo(Integer value) {
            addCriterion("total_effective_sharing_count <=", value, "totalEffectiveSharingCount");
            return (Criteria) this;
        }

        public Criteria andTotalEffectiveSharingCountIn(List<Integer> values) {
            addCriterion("total_effective_sharing_count in", values, "totalEffectiveSharingCount");
            return (Criteria) this;
        }

        public Criteria andTotalEffectiveSharingCountNotIn(List<Integer> values) {
            addCriterion("total_effective_sharing_count not in", values, "totalEffectiveSharingCount");
            return (Criteria) this;
        }

        public Criteria andTotalEffectiveSharingCountBetween(Integer value1, Integer value2) {
            addCriterion("total_effective_sharing_count between", value1, value2, "totalEffectiveSharingCount");
            return (Criteria) this;
        }

        public Criteria andTotalEffectiveSharingCountNotBetween(Integer value1, Integer value2) {
            addCriterion("total_effective_sharing_count not between", value1, value2, "totalEffectiveSharingCount");
            return (Criteria) this;
        }

        public Criteria andTotalRegisterMembersCountIsNull() {
            addCriterion("total_register_members_count is null");
            return (Criteria) this;
        }

        public Criteria andTotalRegisterMembersCountIsNotNull() {
            addCriterion("total_register_members_count is not null");
            return (Criteria) this;
        }

        public Criteria andTotalRegisterMembersCountEqualTo(Integer value) {
            addCriterion("total_register_members_count =", value, "totalRegisterMembersCount");
            return (Criteria) this;
        }

        public Criteria andTotalRegisterMembersCountNotEqualTo(Integer value) {
            addCriterion("total_register_members_count <>", value, "totalRegisterMembersCount");
            return (Criteria) this;
        }

        public Criteria andTotalRegisterMembersCountGreaterThan(Integer value) {
            addCriterion("total_register_members_count >", value, "totalRegisterMembersCount");
            return (Criteria) this;
        }

        public Criteria andTotalRegisterMembersCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_register_members_count >=", value, "totalRegisterMembersCount");
            return (Criteria) this;
        }

        public Criteria andTotalRegisterMembersCountLessThan(Integer value) {
            addCriterion("total_register_members_count <", value, "totalRegisterMembersCount");
            return (Criteria) this;
        }

        public Criteria andTotalRegisterMembersCountLessThanOrEqualTo(Integer value) {
            addCriterion("total_register_members_count <=", value, "totalRegisterMembersCount");
            return (Criteria) this;
        }

        public Criteria andTotalRegisterMembersCountIn(List<Integer> values) {
            addCriterion("total_register_members_count in", values, "totalRegisterMembersCount");
            return (Criteria) this;
        }

        public Criteria andTotalRegisterMembersCountNotIn(List<Integer> values) {
            addCriterion("total_register_members_count not in", values, "totalRegisterMembersCount");
            return (Criteria) this;
        }

        public Criteria andTotalRegisterMembersCountBetween(Integer value1, Integer value2) {
            addCriterion("total_register_members_count between", value1, value2, "totalRegisterMembersCount");
            return (Criteria) this;
        }

        public Criteria andTotalRegisterMembersCountNotBetween(Integer value1, Integer value2) {
            addCriterion("total_register_members_count not between", value1, value2, "totalRegisterMembersCount");
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
            addCriterion("statistics_time =", value, "statisticsTime");
            return (Criteria) this;
        }

        public Criteria andStatisticsTimeNotEqualTo(Date value) {
            addCriterion("statistics_time <>", value, "statisticsTime");
            return (Criteria) this;
        }

        public Criteria andStatisticsTimeGreaterThan(Date value) {
            addCriterion("statistics_time >", value, "statisticsTime");
            return (Criteria) this;
        }

        public Criteria andStatisticsTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("statistics_time >=", value, "statisticsTime");
            return (Criteria) this;
        }

        public Criteria andStatisticsTimeLessThan(Date value) {
            addCriterion("statistics_time <", value, "statisticsTime");
            return (Criteria) this;
        }

        public Criteria andStatisticsTimeLessThanOrEqualTo(Date value) {
            addCriterion("statistics_time <=", value, "statisticsTime");
            return (Criteria) this;
        }

        public Criteria andStatisticsTimeIn(List<Date> values) {
            addCriterion("statistics_time in", values, "statisticsTime");
            return (Criteria) this;
        }

        public Criteria andStatisticsTimeNotIn(List<Date> values) {
            addCriterion("statistics_time not in", values, "statisticsTime");
            return (Criteria) this;
        }

        public Criteria andStatisticsTimeBetween(Date value1, Date value2) {
            addCriterion("statistics_time between", value1, value2, "statisticsTime");
            return (Criteria) this;
        }

        public Criteria andStatisticsTimeNotBetween(Date value1, Date value2) {
            addCriterion("statistics_time not between", value1, value2, "statisticsTime");
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

    /**9
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_mkt_golden_statistics
     *
     * @mbg.generated do_not_delete_during_merge 2019-02-19 16:54:15
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

    /**
     * 只读. t_mkt_golden_statistics
     *
     * @mbg.generated 2019-02-19 16:54:15
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