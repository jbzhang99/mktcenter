package com.bizvane.mktcenterfacade.models.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MktTaskCountPOExample implements Serializable {
    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    protected String orderByClause;

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    protected boolean distinct;

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    protected List<Criteria> oredCriteria;

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    private static final long serialVersionUID = 1L;

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    public MktTaskCountPOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-06 15:41:41
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
     * @mbg.generated 2018-12-06 15:41:41
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * 只读. t_mkt_task_count
     *
     * @mbg.generated 2018-12-06 15:41:41
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

        public Criteria andMktTaskCountIdIsNull() {
            addCriterion("mkt_task_count_id is null");
            return (Criteria) this;
        }

        public Criteria andMktTaskCountIdIsNotNull() {
            addCriterion("mkt_task_count_id is not null");
            return (Criteria) this;
        }

        public Criteria andMktTaskCountIdEqualTo(Long value) {
            addCriterion("mkt_task_count_id =", value, "mktTaskCountId");
            return (Criteria) this;
        }

        public Criteria andMktTaskCountIdNotEqualTo(Long value) {
            addCriterion("mkt_task_count_id <>", value, "mktTaskCountId");
            return (Criteria) this;
        }

        public Criteria andMktTaskCountIdGreaterThan(Long value) {
            addCriterion("mkt_task_count_id >", value, "mktTaskCountId");
            return (Criteria) this;
        }

        public Criteria andMktTaskCountIdGreaterThanOrEqualTo(Long value) {
            addCriterion("mkt_task_count_id >=", value, "mktTaskCountId");
            return (Criteria) this;
        }

        public Criteria andMktTaskCountIdLessThan(Long value) {
            addCriterion("mkt_task_count_id <", value, "mktTaskCountId");
            return (Criteria) this;
        }

        public Criteria andMktTaskCountIdLessThanOrEqualTo(Long value) {
            addCriterion("mkt_task_count_id <=", value, "mktTaskCountId");
            return (Criteria) this;
        }

        public Criteria andMktTaskCountIdIn(List<Long> values) {
            addCriterion("mkt_task_count_id in", values, "mktTaskCountId");
            return (Criteria) this;
        }

        public Criteria andMktTaskCountIdNotIn(List<Long> values) {
            addCriterion("mkt_task_count_id not in", values, "mktTaskCountId");
            return (Criteria) this;
        }

        public Criteria andMktTaskCountIdBetween(Long value1, Long value2) {
            addCriterion("mkt_task_count_id between", value1, value2, "mktTaskCountId");
            return (Criteria) this;
        }

        public Criteria andMktTaskCountIdNotBetween(Long value1, Long value2) {
            addCriterion("mkt_task_count_id not between", value1, value2, "mktTaskCountId");
            return (Criteria) this;
        }

        public Criteria andMktTaskIdIsNull() {
            addCriterion("mkt_task_id is null");
            return (Criteria) this;
        }

        public Criteria andMktTaskIdIsNotNull() {
            addCriterion("mkt_task_id is not null");
            return (Criteria) this;
        }

        public Criteria andMktTaskIdEqualTo(Long value) {
            addCriterion("mkt_task_id =", value, "mktTaskId");
            return (Criteria) this;
        }

        public Criteria andMktTaskIdNotEqualTo(Long value) {
            addCriterion("mkt_task_id <>", value, "mktTaskId");
            return (Criteria) this;
        }

        public Criteria andMktTaskIdGreaterThan(Long value) {
            addCriterion("mkt_task_id >", value, "mktTaskId");
            return (Criteria) this;
        }

        public Criteria andMktTaskIdGreaterThanOrEqualTo(Long value) {
            addCriterion("mkt_task_id >=", value, "mktTaskId");
            return (Criteria) this;
        }

        public Criteria andMktTaskIdLessThan(Long value) {
            addCriterion("mkt_task_id <", value, "mktTaskId");
            return (Criteria) this;
        }

        public Criteria andMktTaskIdLessThanOrEqualTo(Long value) {
            addCriterion("mkt_task_id <=", value, "mktTaskId");
            return (Criteria) this;
        }

        public Criteria andMktTaskIdIn(List<Long> values) {
            addCriterion("mkt_task_id in", values, "mktTaskId");
            return (Criteria) this;
        }

        public Criteria andMktTaskIdNotIn(List<Long> values) {
            addCriterion("mkt_task_id not in", values, "mktTaskId");
            return (Criteria) this;
        }

        public Criteria andMktTaskIdBetween(Long value1, Long value2) {
            addCriterion("mkt_task_id between", value1, value2, "mktTaskId");
            return (Criteria) this;
        }

        public Criteria andMktTaskIdNotBetween(Long value1, Long value2) {
            addCriterion("mkt_task_id not between", value1, value2, "mktTaskId");
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

        public Criteria andConsumeAmountSumIsNull() {
            addCriterion("consume_amount_sum is null");
            return (Criteria) this;
        }

        public Criteria andConsumeAmountSumIsNotNull() {
            addCriterion("consume_amount_sum is not null");
            return (Criteria) this;
        }

        public Criteria andConsumeAmountSumEqualTo(BigDecimal value) {
            addCriterion("consume_amount_sum =", value, "consumeAmountSum");
            return (Criteria) this;
        }

        public Criteria andConsumeAmountSumNotEqualTo(BigDecimal value) {
            addCriterion("consume_amount_sum <>", value, "consumeAmountSum");
            return (Criteria) this;
        }

        public Criteria andConsumeAmountSumGreaterThan(BigDecimal value) {
            addCriterion("consume_amount_sum >", value, "consumeAmountSum");
            return (Criteria) this;
        }

        public Criteria andConsumeAmountSumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("consume_amount_sum >=", value, "consumeAmountSum");
            return (Criteria) this;
        }

        public Criteria andConsumeAmountSumLessThan(BigDecimal value) {
            addCriterion("consume_amount_sum <", value, "consumeAmountSum");
            return (Criteria) this;
        }

        public Criteria andConsumeAmountSumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("consume_amount_sum <=", value, "consumeAmountSum");
            return (Criteria) this;
        }

        public Criteria andConsumeAmountSumIn(List<BigDecimal> values) {
            addCriterion("consume_amount_sum in", values, "consumeAmountSum");
            return (Criteria) this;
        }

        public Criteria andConsumeAmountSumNotIn(List<BigDecimal> values) {
            addCriterion("consume_amount_sum not in", values, "consumeAmountSum");
            return (Criteria) this;
        }

        public Criteria andConsumeAmountSumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("consume_amount_sum between", value1, value2, "consumeAmountSum");
            return (Criteria) this;
        }

        public Criteria andConsumeAmountSumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("consume_amount_sum not between", value1, value2, "consumeAmountSum");
            return (Criteria) this;
        }

        public Criteria andCouponNumSumIsNull() {
            addCriterion("coupon_num_sum is null");
            return (Criteria) this;
        }

        public Criteria andCouponNumSumIsNotNull() {
            addCriterion("coupon_num_sum is not null");
            return (Criteria) this;
        }

        public Criteria andCouponNumSumEqualTo(Integer value) {
            addCriterion("coupon_num_sum =", value, "couponNumSum");
            return (Criteria) this;
        }

        public Criteria andCouponNumSumNotEqualTo(Integer value) {
            addCriterion("coupon_num_sum <>", value, "couponNumSum");
            return (Criteria) this;
        }

        public Criteria andCouponNumSumGreaterThan(Integer value) {
            addCriterion("coupon_num_sum >", value, "couponNumSum");
            return (Criteria) this;
        }

        public Criteria andCouponNumSumGreaterThanOrEqualTo(Integer value) {
            addCriterion("coupon_num_sum >=", value, "couponNumSum");
            return (Criteria) this;
        }

        public Criteria andCouponNumSumLessThan(Integer value) {
            addCriterion("coupon_num_sum <", value, "couponNumSum");
            return (Criteria) this;
        }

        public Criteria andCouponNumSumLessThanOrEqualTo(Integer value) {
            addCriterion("coupon_num_sum <=", value, "couponNumSum");
            return (Criteria) this;
        }

        public Criteria andCouponNumSumIn(List<Integer> values) {
            addCriterion("coupon_num_sum in", values, "couponNumSum");
            return (Criteria) this;
        }

        public Criteria andCouponNumSumNotIn(List<Integer> values) {
            addCriterion("coupon_num_sum not in", values, "couponNumSum");
            return (Criteria) this;
        }

        public Criteria andCouponNumSumBetween(Integer value1, Integer value2) {
            addCriterion("coupon_num_sum between", value1, value2, "couponNumSum");
            return (Criteria) this;
        }

        public Criteria andCouponNumSumNotBetween(Integer value1, Integer value2) {
            addCriterion("coupon_num_sum not between", value1, value2, "couponNumSum");
            return (Criteria) this;
        }

        public Criteria andPointsSumIsNull() {
            addCriterion("points_sum is null");
            return (Criteria) this;
        }

        public Criteria andPointsSumIsNotNull() {
            addCriterion("points_sum is not null");
            return (Criteria) this;
        }

        public Criteria andPointsSumEqualTo(Integer value) {
            addCriterion("points_sum =", value, "pointsSum");
            return (Criteria) this;
        }

        public Criteria andPointsSumNotEqualTo(Integer value) {
            addCriterion("points_sum <>", value, "pointsSum");
            return (Criteria) this;
        }

        public Criteria andPointsSumGreaterThan(Integer value) {
            addCriterion("points_sum >", value, "pointsSum");
            return (Criteria) this;
        }

        public Criteria andPointsSumGreaterThanOrEqualTo(Integer value) {
            addCriterion("points_sum >=", value, "pointsSum");
            return (Criteria) this;
        }

        public Criteria andPointsSumLessThan(Integer value) {
            addCriterion("points_sum <", value, "pointsSum");
            return (Criteria) this;
        }

        public Criteria andPointsSumLessThanOrEqualTo(Integer value) {
            addCriterion("points_sum <=", value, "pointsSum");
            return (Criteria) this;
        }

        public Criteria andPointsSumIn(List<Integer> values) {
            addCriterion("points_sum in", values, "pointsSum");
            return (Criteria) this;
        }

        public Criteria andPointsSumNotIn(List<Integer> values) {
            addCriterion("points_sum not in", values, "pointsSum");
            return (Criteria) this;
        }

        public Criteria andPointsSumBetween(Integer value1, Integer value2) {
            addCriterion("points_sum between", value1, value2, "pointsSum");
            return (Criteria) this;
        }

        public Criteria andPointsSumNotBetween(Integer value1, Integer value2) {
            addCriterion("points_sum not between", value1, value2, "pointsSum");
            return (Criteria) this;
        }

        public Criteria andShareNumSumIsNull() {
            addCriterion("share_num_sum is null");
            return (Criteria) this;
        }

        public Criteria andShareNumSumIsNotNull() {
            addCriterion("share_num_sum is not null");
            return (Criteria) this;
        }

        public Criteria andShareNumSumEqualTo(Integer value) {
            addCriterion("share_num_sum =", value, "shareNumSum");
            return (Criteria) this;
        }

        public Criteria andShareNumSumNotEqualTo(Integer value) {
            addCriterion("share_num_sum <>", value, "shareNumSum");
            return (Criteria) this;
        }

        public Criteria andShareNumSumGreaterThan(Integer value) {
            addCriterion("share_num_sum >", value, "shareNumSum");
            return (Criteria) this;
        }

        public Criteria andShareNumSumGreaterThanOrEqualTo(Integer value) {
            addCriterion("share_num_sum >=", value, "shareNumSum");
            return (Criteria) this;
        }

        public Criteria andShareNumSumLessThan(Integer value) {
            addCriterion("share_num_sum <", value, "shareNumSum");
            return (Criteria) this;
        }

        public Criteria andShareNumSumLessThanOrEqualTo(Integer value) {
            addCriterion("share_num_sum <=", value, "shareNumSum");
            return (Criteria) this;
        }

        public Criteria andShareNumSumIn(List<Integer> values) {
            addCriterion("share_num_sum in", values, "shareNumSum");
            return (Criteria) this;
        }

        public Criteria andShareNumSumNotIn(List<Integer> values) {
            addCriterion("share_num_sum not in", values, "shareNumSum");
            return (Criteria) this;
        }

        public Criteria andShareNumSumBetween(Integer value1, Integer value2) {
            addCriterion("share_num_sum between", value1, value2, "shareNumSum");
            return (Criteria) this;
        }

        public Criteria andShareNumSumNotBetween(Integer value1, Integer value2) {
            addCriterion("share_num_sum not between", value1, value2, "shareNumSum");
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
     * This class corresponds to the database table t_mkt_task_count
     *
     * @mbg.generated do_not_delete_during_merge 2018-12-06 15:41:41
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

    /**
     * 只读. t_mkt_task_count
     *
     * @mbg.generated 2018-12-06 15:41:41
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