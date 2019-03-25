package com.bizvane.mktcenterfacade.models.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MktActivityPrizePOExample implements Serializable {
    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    protected String orderByClause;

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    protected boolean distinct;

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    protected List<Criteria> oredCriteria;

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    private static final long serialVersionUID = 1L;

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    public MktActivityPrizePOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
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
     * @mbg.generated 2018-12-18 15:22:31
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * 只读. t_mkt_activity_prize
     *
     * @mbg.generated 2018-12-18 15:22:31
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

        public Criteria andMktActivityPrizeIdIsNull() {
            addCriterion("mkt_activity_prize_id is null");
            return (Criteria) this;
        }

        public Criteria andMktActivityPrizeIdIsNotNull() {
            addCriterion("mkt_activity_prize_id is not null");
            return (Criteria) this;
        }

        public Criteria andMktActivityPrizeIdEqualTo(Long value) {
            addCriterion("mkt_activity_prize_id =", value, "mktActivityPrizeId");
            return (Criteria) this;
        }

        public Criteria andMktActivityPrizeIdNotEqualTo(Long value) {
            addCriterion("mkt_activity_prize_id <>", value, "mktActivityPrizeId");
            return (Criteria) this;
        }

        public Criteria andMktActivityPrizeIdGreaterThan(Long value) {
            addCriterion("mkt_activity_prize_id >", value, "mktActivityPrizeId");
            return (Criteria) this;
        }

        public Criteria andMktActivityPrizeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("mkt_activity_prize_id >=", value, "mktActivityPrizeId");
            return (Criteria) this;
        }

        public Criteria andMktActivityPrizeIdLessThan(Long value) {
            addCriterion("mkt_activity_prize_id <", value, "mktActivityPrizeId");
            return (Criteria) this;
        }

        public Criteria andMktActivityPrizeIdLessThanOrEqualTo(Long value) {
            addCriterion("mkt_activity_prize_id <=", value, "mktActivityPrizeId");
            return (Criteria) this;
        }

        public Criteria andMktActivityPrizeIdIn(List<Long> values) {
            addCriterion("mkt_activity_prize_id in", values, "mktActivityPrizeId");
            return (Criteria) this;
        }

        public Criteria andMktActivityPrizeIdNotIn(List<Long> values) {
            addCriterion("mkt_activity_prize_id not in", values, "mktActivityPrizeId");
            return (Criteria) this;
        }

        public Criteria andMktActivityPrizeIdBetween(Long value1, Long value2) {
            addCriterion("mkt_activity_prize_id between", value1, value2, "mktActivityPrizeId");
            return (Criteria) this;
        }

        public Criteria andMktActivityPrizeIdNotBetween(Long value1, Long value2) {
            addCriterion("mkt_activity_prize_id not between", value1, value2, "mktActivityPrizeId");
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

        public Criteria andPrizeTypeIsNull() {
            addCriterion("prize_type is null");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeIsNotNull() {
            addCriterion("prize_type is not null");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeEqualTo(Integer value) {
            addCriterion("prize_type =", value, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeNotEqualTo(Integer value) {
            addCriterion("prize_type <>", value, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeGreaterThan(Integer value) {
            addCriterion("prize_type >", value, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("prize_type >=", value, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeLessThan(Integer value) {
            addCriterion("prize_type <", value, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeLessThanOrEqualTo(Integer value) {
            addCriterion("prize_type <=", value, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeIn(List<Integer> values) {
            addCriterion("prize_type in", values, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeNotIn(List<Integer> values) {
            addCriterion("prize_type not in", values, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeBetween(Integer value1, Integer value2) {
            addCriterion("prize_type between", value1, value2, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("prize_type not between", value1, value2, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeNameIsNull() {
            addCriterion("prize_name is null");
            return (Criteria) this;
        }

        public Criteria andPrizeNameIsNotNull() {
            addCriterion("prize_name is not null");
            return (Criteria) this;
        }

        public Criteria andPrizeNameEqualTo(String value) {
            addCriterion("prize_name =", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameNotEqualTo(String value) {
            addCriterion("prize_name <>", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameGreaterThan(String value) {
            addCriterion("prize_name >", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameGreaterThanOrEqualTo(String value) {
            addCriterion("prize_name >=", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameLessThan(String value) {
            addCriterion("prize_name <", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameLessThanOrEqualTo(String value) {
            addCriterion("prize_name <=", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameLike(String value) {
            addCriterion("prize_name like", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameNotLike(String value) {
            addCriterion("prize_name not like", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameIn(List<String> values) {
            addCriterion("prize_name in", values, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameNotIn(List<String> values) {
            addCriterion("prize_name not in", values, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameBetween(String value1, String value2) {
            addCriterion("prize_name between", value1, value2, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameNotBetween(String value1, String value2) {
            addCriterion("prize_name not between", value1, value2, "prizeName");
            return (Criteria) this;
        }

        public Criteria andAwadTypeIsNull() {
            addCriterion("awad_type is null");
            return (Criteria) this;
        }

        public Criteria andAwadTypeIsNotNull() {
            addCriterion("awad_type is not null");
            return (Criteria) this;
        }

        public Criteria andAwadTypeEqualTo(Integer value) {
            addCriterion("awad_type =", value, "awadType");
            return (Criteria) this;
        }

        public Criteria andAwadTypeNotEqualTo(Integer value) {
            addCriterion("awad_type <>", value, "awadType");
            return (Criteria) this;
        }

        public Criteria andAwadTypeGreaterThan(Integer value) {
            addCriterion("awad_type >", value, "awadType");
            return (Criteria) this;
        }

        public Criteria andAwadTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("awad_type >=", value, "awadType");
            return (Criteria) this;
        }

        public Criteria andAwadTypeLessThan(Integer value) {
            addCriterion("awad_type <", value, "awadType");
            return (Criteria) this;
        }

        public Criteria andAwadTypeLessThanOrEqualTo(Integer value) {
            addCriterion("awad_type <=", value, "awadType");
            return (Criteria) this;
        }

        public Criteria andAwadTypeIn(List<Integer> values) {
            addCriterion("awad_type in", values, "awadType");
            return (Criteria) this;
        }

        public Criteria andAwadTypeNotIn(List<Integer> values) {
            addCriterion("awad_type not in", values, "awadType");
            return (Criteria) this;
        }

        public Criteria andAwadTypeBetween(Integer value1, Integer value2) {
            addCriterion("awad_type between", value1, value2, "awadType");
            return (Criteria) this;
        }

        public Criteria andAwadTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("awad_type not between", value1, value2, "awadType");
            return (Criteria) this;
        }

        public Criteria andPrizePointsIsNull() {
            addCriterion("prize_points is null");
            return (Criteria) this;
        }

        public Criteria andPrizePointsIsNotNull() {
            addCriterion("prize_points is not null");
            return (Criteria) this;
        }

        public Criteria andPrizePointsEqualTo(Integer value) {
            addCriterion("prize_points =", value, "prizePoints");
            return (Criteria) this;
        }

        public Criteria andPrizePointsNotEqualTo(Integer value) {
            addCriterion("prize_points <>", value, "prizePoints");
            return (Criteria) this;
        }

        public Criteria andPrizePointsGreaterThan(Integer value) {
            addCriterion("prize_points >", value, "prizePoints");
            return (Criteria) this;
        }

        public Criteria andPrizePointsGreaterThanOrEqualTo(Integer value) {
            addCriterion("prize_points >=", value, "prizePoints");
            return (Criteria) this;
        }

        public Criteria andPrizePointsLessThan(Integer value) {
            addCriterion("prize_points <", value, "prizePoints");
            return (Criteria) this;
        }

        public Criteria andPrizePointsLessThanOrEqualTo(Integer value) {
            addCriterion("prize_points <=", value, "prizePoints");
            return (Criteria) this;
        }

        public Criteria andPrizePointsIn(List<Integer> values) {
            addCriterion("prize_points in", values, "prizePoints");
            return (Criteria) this;
        }

        public Criteria andPrizePointsNotIn(List<Integer> values) {
            addCriterion("prize_points not in", values, "prizePoints");
            return (Criteria) this;
        }

        public Criteria andPrizePointsBetween(Integer value1, Integer value2) {
            addCriterion("prize_points between", value1, value2, "prizePoints");
            return (Criteria) this;
        }

        public Criteria andPrizePointsNotBetween(Integer value1, Integer value2) {
            addCriterion("prize_points not between", value1, value2, "prizePoints");
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

        public Criteria andImageUrlIsNull() {
            addCriterion("image_url is null");
            return (Criteria) this;
        }

        public Criteria andImageUrlIsNotNull() {
            addCriterion("image_url is not null");
            return (Criteria) this;
        }

        public Criteria andImageUrlEqualTo(String value) {
            addCriterion("image_url =", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlNotEqualTo(String value) {
            addCriterion("image_url <>", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlGreaterThan(String value) {
            addCriterion("image_url >", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlGreaterThanOrEqualTo(String value) {
            addCriterion("image_url >=", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlLessThan(String value) {
            addCriterion("image_url <", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlLessThanOrEqualTo(String value) {
            addCriterion("image_url <=", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlLike(String value) {
            addCriterion("image_url like", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlNotLike(String value) {
            addCriterion("image_url not like", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlIn(List<String> values) {
            addCriterion("image_url in", values, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlNotIn(List<String> values) {
            addCriterion("image_url not in", values, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlBetween(String value1, String value2) {
            addCriterion("image_url between", value1, value2, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlNotBetween(String value1, String value2) {
            addCriterion("image_url not between", value1, value2, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andProbabilityIsNull() {
            addCriterion("probability is null");
            return (Criteria) this;
        }

        public Criteria andProbabilityIsNotNull() {
            addCriterion("probability is not null");
            return (Criteria) this;
        }

        public Criteria andProbabilityEqualTo(BigDecimal value) {
            addCriterion("probability =", value, "probability");
            return (Criteria) this;
        }

        public Criteria andProbabilityNotEqualTo(BigDecimal value) {
            addCriterion("probability <>", value, "probability");
            return (Criteria) this;
        }

        public Criteria andProbabilityGreaterThan(BigDecimal value) {
            addCriterion("probability >", value, "probability");
            return (Criteria) this;
        }

        public Criteria andProbabilityGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("probability >=", value, "probability");
            return (Criteria) this;
        }

        public Criteria andProbabilityLessThan(BigDecimal value) {
            addCriterion("probability <", value, "probability");
            return (Criteria) this;
        }

        public Criteria andProbabilityLessThanOrEqualTo(BigDecimal value) {
            addCriterion("probability <=", value, "probability");
            return (Criteria) this;
        }

        public Criteria andProbabilityIn(List<BigDecimal> values) {
            addCriterion("probability in", values, "probability");
            return (Criteria) this;
        }

        public Criteria andProbabilityNotIn(List<BigDecimal> values) {
            addCriterion("probability not in", values, "probability");
            return (Criteria) this;
        }

        public Criteria andProbabilityBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("probability between", value1, value2, "probability");
            return (Criteria) this;
        }

        public Criteria andProbabilityNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("probability not between", value1, value2, "probability");
            return (Criteria) this;
        }

        public Criteria andInvalidCountIsNull() {
            addCriterion("invalid_count is null");
            return (Criteria) this;
        }

        public Criteria andInvalidCountIsNotNull() {
            addCriterion("invalid_count is not null");
            return (Criteria) this;
        }

        public Criteria andInvalidCountEqualTo(Integer value) {
            addCriterion("invalid_count =", value, "invalidCount");
            return (Criteria) this;
        }

        public Criteria andInvalidCountNotEqualTo(Integer value) {
            addCriterion("invalid_count <>", value, "invalidCount");
            return (Criteria) this;
        }

        public Criteria andInvalidCountGreaterThan(Integer value) {
            addCriterion("invalid_count >", value, "invalidCount");
            return (Criteria) this;
        }

        public Criteria andInvalidCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("invalid_count >=", value, "invalidCount");
            return (Criteria) this;
        }

        public Criteria andInvalidCountLessThan(Integer value) {
            addCriterion("invalid_count <", value, "invalidCount");
            return (Criteria) this;
        }

        public Criteria andInvalidCountLessThanOrEqualTo(Integer value) {
            addCriterion("invalid_count <=", value, "invalidCount");
            return (Criteria) this;
        }

        public Criteria andInvalidCountIn(List<Integer> values) {
            addCriterion("invalid_count in", values, "invalidCount");
            return (Criteria) this;
        }

        public Criteria andInvalidCountNotIn(List<Integer> values) {
            addCriterion("invalid_count not in", values, "invalidCount");
            return (Criteria) this;
        }

        public Criteria andInvalidCountBetween(Integer value1, Integer value2) {
            addCriterion("invalid_count between", value1, value2, "invalidCount");
            return (Criteria) this;
        }

        public Criteria andInvalidCountNotBetween(Integer value1, Integer value2) {
            addCriterion("invalid_count not between", value1, value2, "invalidCount");
            return (Criteria) this;
        }

        public Criteria andPrizeSumIsNull() {
            addCriterion("prize_sum is null");
            return (Criteria) this;
        }

        public Criteria andPrizeSumIsNotNull() {
            addCriterion("prize_sum is not null");
            return (Criteria) this;
        }

        public Criteria andPrizeSumEqualTo(Integer value) {
            addCriterion("prize_sum =", value, "prizeSum");
            return (Criteria) this;
        }

        public Criteria andPrizeSumNotEqualTo(Integer value) {
            addCriterion("prize_sum <>", value, "prizeSum");
            return (Criteria) this;
        }

        public Criteria andPrizeSumGreaterThan(Integer value) {
            addCriterion("prize_sum >", value, "prizeSum");
            return (Criteria) this;
        }

        public Criteria andPrizeSumGreaterThanOrEqualTo(Integer value) {
            addCriterion("prize_sum >=", value, "prizeSum");
            return (Criteria) this;
        }

        public Criteria andPrizeSumLessThan(Integer value) {
            addCriterion("prize_sum <", value, "prizeSum");
            return (Criteria) this;
        }

        public Criteria andPrizeSumLessThanOrEqualTo(Integer value) {
            addCriterion("prize_sum <=", value, "prizeSum");
            return (Criteria) this;
        }

        public Criteria andPrizeSumIn(List<Integer> values) {
            addCriterion("prize_sum in", values, "prizeSum");
            return (Criteria) this;
        }

        public Criteria andPrizeSumNotIn(List<Integer> values) {
            addCriterion("prize_sum not in", values, "prizeSum");
            return (Criteria) this;
        }

        public Criteria andPrizeSumBetween(Integer value1, Integer value2) {
            addCriterion("prize_sum between", value1, value2, "prizeSum");
            return (Criteria) this;
        }

        public Criteria andPrizeSumNotBetween(Integer value1, Integer value2) {
            addCriterion("prize_sum not between", value1, value2, "prizeSum");
            return (Criteria) this;
        }

        public Criteria andUserLimitSumIsNull() {
            addCriterion("user_limit_sum is null");
            return (Criteria) this;
        }

        public Criteria andUserLimitSumIsNotNull() {
            addCriterion("user_limit_sum is not null");
            return (Criteria) this;
        }

        public Criteria andUserLimitSumEqualTo(Integer value) {
            addCriterion("user_limit_sum =", value, "userLimitSum");
            return (Criteria) this;
        }

        public Criteria andUserLimitSumNotEqualTo(Integer value) {
            addCriterion("user_limit_sum <>", value, "userLimitSum");
            return (Criteria) this;
        }

        public Criteria andUserLimitSumGreaterThan(Integer value) {
            addCriterion("user_limit_sum >", value, "userLimitSum");
            return (Criteria) this;
        }

        public Criteria andUserLimitSumGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_limit_sum >=", value, "userLimitSum");
            return (Criteria) this;
        }

        public Criteria andUserLimitSumLessThan(Integer value) {
            addCriterion("user_limit_sum <", value, "userLimitSum");
            return (Criteria) this;
        }

        public Criteria andUserLimitSumLessThanOrEqualTo(Integer value) {
            addCriterion("user_limit_sum <=", value, "userLimitSum");
            return (Criteria) this;
        }

        public Criteria andUserLimitSumIn(List<Integer> values) {
            addCriterion("user_limit_sum in", values, "userLimitSum");
            return (Criteria) this;
        }

        public Criteria andUserLimitSumNotIn(List<Integer> values) {
            addCriterion("user_limit_sum not in", values, "userLimitSum");
            return (Criteria) this;
        }

        public Criteria andUserLimitSumBetween(Integer value1, Integer value2) {
            addCriterion("user_limit_sum between", value1, value2, "userLimitSum");
            return (Criteria) this;
        }

        public Criteria andUserLimitSumNotBetween(Integer value1, Integer value2) {
            addCriterion("user_limit_sum not between", value1, value2, "userLimitSum");
            return (Criteria) this;
        }

        public Criteria andParticipatePrizeIsNull() {
            addCriterion("participate_prize is null");
            return (Criteria) this;
        }

        public Criteria andParticipatePrizeIsNotNull() {
            addCriterion("participate_prize is not null");
            return (Criteria) this;
        }

        public Criteria andParticipatePrizeEqualTo(Boolean value) {
            addCriterion("participate_prize =", value, "participatePrize");
            return (Criteria) this;
        }

        public Criteria andParticipatePrizeNotEqualTo(Boolean value) {
            addCriterion("participate_prize <>", value, "participatePrize");
            return (Criteria) this;
        }

        public Criteria andParticipatePrizeGreaterThan(Boolean value) {
            addCriterion("participate_prize >", value, "participatePrize");
            return (Criteria) this;
        }

        public Criteria andParticipatePrizeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("participate_prize >=", value, "participatePrize");
            return (Criteria) this;
        }

        public Criteria andParticipatePrizeLessThan(Boolean value) {
            addCriterion("participate_prize <", value, "participatePrize");
            return (Criteria) this;
        }

        public Criteria andParticipatePrizeLessThanOrEqualTo(Boolean value) {
            addCriterion("participate_prize <=", value, "participatePrize");
            return (Criteria) this;
        }

        public Criteria andParticipatePrizeIn(List<Boolean> values) {
            addCriterion("participate_prize in", values, "participatePrize");
            return (Criteria) this;
        }

        public Criteria andParticipatePrizeNotIn(List<Boolean> values) {
            addCriterion("participate_prize not in", values, "participatePrize");
            return (Criteria) this;
        }

        public Criteria andParticipatePrizeBetween(Boolean value1, Boolean value2) {
            addCriterion("participate_prize between", value1, value2, "participatePrize");
            return (Criteria) this;
        }

        public Criteria andParticipatePrizeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("participate_prize not between", value1, value2, "participatePrize");
            return (Criteria) this;
        }

        public Criteria andParticipatePointsIsNull() {
            addCriterion("participate_points is null");
            return (Criteria) this;
        }

        public Criteria andParticipatePointsIsNotNull() {
            addCriterion("participate_points is not null");
            return (Criteria) this;
        }

        public Criteria andParticipatePointsEqualTo(Integer value) {
            addCriterion("participate_points =", value, "participatePoints");
            return (Criteria) this;
        }

        public Criteria andParticipatePointsNotEqualTo(Integer value) {
            addCriterion("participate_points <>", value, "participatePoints");
            return (Criteria) this;
        }

        public Criteria andParticipatePointsGreaterThan(Integer value) {
            addCriterion("participate_points >", value, "participatePoints");
            return (Criteria) this;
        }

        public Criteria andParticipatePointsGreaterThanOrEqualTo(Integer value) {
            addCriterion("participate_points >=", value, "participatePoints");
            return (Criteria) this;
        }

        public Criteria andParticipatePointsLessThan(Integer value) {
            addCriterion("participate_points <", value, "participatePoints");
            return (Criteria) this;
        }

        public Criteria andParticipatePointsLessThanOrEqualTo(Integer value) {
            addCriterion("participate_points <=", value, "participatePoints");
            return (Criteria) this;
        }

        public Criteria andParticipatePointsIn(List<Integer> values) {
            addCriterion("participate_points in", values, "participatePoints");
            return (Criteria) this;
        }

        public Criteria andParticipatePointsNotIn(List<Integer> values) {
            addCriterion("participate_points not in", values, "participatePoints");
            return (Criteria) this;
        }

        public Criteria andParticipatePointsBetween(Integer value1, Integer value2) {
            addCriterion("participate_points between", value1, value2, "participatePoints");
            return (Criteria) this;
        }

        public Criteria andParticipatePointsNotBetween(Integer value1, Integer value2) {
            addCriterion("participate_points not between", value1, value2, "participatePoints");
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
     * This class corresponds to the database table t_mkt_activity_prize
     *
     * @mbg.generated do_not_delete_during_merge 2018-12-18 15:22:31
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

    /**
     * 只读. t_mkt_activity_prize
     *
     * @mbg.generated 2018-12-18 15:22:31
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