package com.bizvane.mktcenterfacade.models.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MktCouponIntegralExchangePOExample implements Serializable {
    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    protected String orderByClause;

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    protected boolean distinct;

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    protected List<Criteria> oredCriteria;

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    private static final long serialVersionUID = 1L;

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    public MktCouponIntegralExchangePOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
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
     * @mbg.generated 2018-11-22 16:07:57
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * 只读. t_mkt_coupon_integral_exchange
     *
     * @mbg.generated 2018-11-22 16:07:57
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

        public Criteria andExchangePriceIsNull() {
            addCriterion("exchange_price is null");
            return (Criteria) this;
        }

        public Criteria andExchangePriceIsNotNull() {
            addCriterion("exchange_price is not null");
            return (Criteria) this;
        }

        public Criteria andExchangePriceEqualTo(Integer value) {
            addCriterion("exchange_price =", value, "exchangePrice");
            return (Criteria) this;
        }

        public Criteria andExchangePriceNotEqualTo(Integer value) {
            addCriterion("exchange_price <>", value, "exchangePrice");
            return (Criteria) this;
        }

        public Criteria andExchangePriceGreaterThan(Integer value) {
            addCriterion("exchange_price >", value, "exchangePrice");
            return (Criteria) this;
        }

        public Criteria andExchangePriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("exchange_price >=", value, "exchangePrice");
            return (Criteria) this;
        }

        public Criteria andExchangePriceLessThan(Integer value) {
            addCriterion("exchange_price <", value, "exchangePrice");
            return (Criteria) this;
        }

        public Criteria andExchangePriceLessThanOrEqualTo(Integer value) {
            addCriterion("exchange_price <=", value, "exchangePrice");
            return (Criteria) this;
        }

        public Criteria andExchangePriceIn(List<Integer> values) {
            addCriterion("exchange_price in", values, "exchangePrice");
            return (Criteria) this;
        }

        public Criteria andExchangePriceNotIn(List<Integer> values) {
            addCriterion("exchange_price not in", values, "exchangePrice");
            return (Criteria) this;
        }

        public Criteria andExchangePriceBetween(Integer value1, Integer value2) {
            addCriterion("exchange_price between", value1, value2, "exchangePrice");
            return (Criteria) this;
        }

        public Criteria andExchangePriceNotBetween(Integer value1, Integer value2) {
            addCriterion("exchange_price not between", value1, value2, "exchangePrice");
            return (Criteria) this;
        }

        public Criteria andStoreStatusIsNull() {
            addCriterion("store_status is null");
            return (Criteria) this;
        }

        public Criteria andStoreStatusIsNotNull() {
            addCriterion("store_status is not null");
            return (Criteria) this;
        }

        public Criteria andStoreStatusEqualTo(Integer value) {
            addCriterion("store_status =", value, "storeStatus");
            return (Criteria) this;
        }

        public Criteria andStoreStatusNotEqualTo(Integer value) {
            addCriterion("store_status <>", value, "storeStatus");
            return (Criteria) this;
        }

        public Criteria andStoreStatusGreaterThan(Integer value) {
            addCriterion("store_status >", value, "storeStatus");
            return (Criteria) this;
        }

        public Criteria andStoreStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_status >=", value, "storeStatus");
            return (Criteria) this;
        }

        public Criteria andStoreStatusLessThan(Integer value) {
            addCriterion("store_status <", value, "storeStatus");
            return (Criteria) this;
        }

        public Criteria andStoreStatusLessThanOrEqualTo(Integer value) {
            addCriterion("store_status <=", value, "storeStatus");
            return (Criteria) this;
        }

        public Criteria andStoreStatusIn(List<Integer> values) {
            addCriterion("store_status in", values, "storeStatus");
            return (Criteria) this;
        }

        public Criteria andStoreStatusNotIn(List<Integer> values) {
            addCriterion("store_status not in", values, "storeStatus");
            return (Criteria) this;
        }

        public Criteria andStoreStatusBetween(Integer value1, Integer value2) {
            addCriterion("store_status between", value1, value2, "storeStatus");
            return (Criteria) this;
        }

        public Criteria andStoreStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("store_status not between", value1, value2, "storeStatus");
            return (Criteria) this;
        }

        public Criteria andStoreCountIsNull() {
            addCriterion("store_count is null");
            return (Criteria) this;
        }

        public Criteria andStoreCountIsNotNull() {
            addCriterion("store_count is not null");
            return (Criteria) this;
        }

        public Criteria andStoreCountEqualTo(Long value) {
            addCriterion("store_count =", value, "storeCount");
            return (Criteria) this;
        }

        public Criteria andStoreCountNotEqualTo(Long value) {
            addCriterion("store_count <>", value, "storeCount");
            return (Criteria) this;
        }

        public Criteria andStoreCountGreaterThan(Long value) {
            addCriterion("store_count >", value, "storeCount");
            return (Criteria) this;
        }

        public Criteria andStoreCountGreaterThanOrEqualTo(Long value) {
            addCriterion("store_count >=", value, "storeCount");
            return (Criteria) this;
        }

        public Criteria andStoreCountLessThan(Long value) {
            addCriterion("store_count <", value, "storeCount");
            return (Criteria) this;
        }

        public Criteria andStoreCountLessThanOrEqualTo(Long value) {
            addCriterion("store_count <=", value, "storeCount");
            return (Criteria) this;
        }

        public Criteria andStoreCountIn(List<Long> values) {
            addCriterion("store_count in", values, "storeCount");
            return (Criteria) this;
        }

        public Criteria andStoreCountNotIn(List<Long> values) {
            addCriterion("store_count not in", values, "storeCount");
            return (Criteria) this;
        }

        public Criteria andStoreCountBetween(Long value1, Long value2) {
            addCriterion("store_count between", value1, value2, "storeCount");
            return (Criteria) this;
        }

        public Criteria andStoreCountNotBetween(Long value1, Long value2) {
            addCriterion("store_count not between", value1, value2, "storeCount");
            return (Criteria) this;
        }

        public Criteria andExchangeStatusIsNull() {
            addCriterion("exchange_status is null");
            return (Criteria) this;
        }

        public Criteria andExchangeStatusIsNotNull() {
            addCriterion("exchange_status is not null");
            return (Criteria) this;
        }

        public Criteria andExchangeStatusEqualTo(Integer value) {
            addCriterion("exchange_status =", value, "exchangeStatus");
            return (Criteria) this;
        }

        public Criteria andExchangeStatusNotEqualTo(Integer value) {
            addCriterion("exchange_status <>", value, "exchangeStatus");
            return (Criteria) this;
        }

        public Criteria andExchangeStatusGreaterThan(Integer value) {
            addCriterion("exchange_status >", value, "exchangeStatus");
            return (Criteria) this;
        }

        public Criteria andExchangeStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("exchange_status >=", value, "exchangeStatus");
            return (Criteria) this;
        }

        public Criteria andExchangeStatusLessThan(Integer value) {
            addCriterion("exchange_status <", value, "exchangeStatus");
            return (Criteria) this;
        }

        public Criteria andExchangeStatusLessThanOrEqualTo(Integer value) {
            addCriterion("exchange_status <=", value, "exchangeStatus");
            return (Criteria) this;
        }

        public Criteria andExchangeStatusIn(List<Integer> values) {
            addCriterion("exchange_status in", values, "exchangeStatus");
            return (Criteria) this;
        }

        public Criteria andExchangeStatusNotIn(List<Integer> values) {
            addCriterion("exchange_status not in", values, "exchangeStatus");
            return (Criteria) this;
        }

        public Criteria andExchangeStatusBetween(Integer value1, Integer value2) {
            addCriterion("exchange_status between", value1, value2, "exchangeStatus");
            return (Criteria) this;
        }

        public Criteria andExchangeStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("exchange_status not between", value1, value2, "exchangeStatus");
            return (Criteria) this;
        }

        public Criteria andExchangeCountIsNull() {
            addCriterion("exchange_count is null");
            return (Criteria) this;
        }

        public Criteria andExchangeCountIsNotNull() {
            addCriterion("exchange_count is not null");
            return (Criteria) this;
        }

        public Criteria andExchangeCountEqualTo(Long value) {
            addCriterion("exchange_count =", value, "exchangeCount");
            return (Criteria) this;
        }

        public Criteria andExchangeCountNotEqualTo(Long value) {
            addCriterion("exchange_count <>", value, "exchangeCount");
            return (Criteria) this;
        }

        public Criteria andExchangeCountGreaterThan(Long value) {
            addCriterion("exchange_count >", value, "exchangeCount");
            return (Criteria) this;
        }

        public Criteria andExchangeCountGreaterThanOrEqualTo(Long value) {
            addCriterion("exchange_count >=", value, "exchangeCount");
            return (Criteria) this;
        }

        public Criteria andExchangeCountLessThan(Long value) {
            addCriterion("exchange_count <", value, "exchangeCount");
            return (Criteria) this;
        }

        public Criteria andExchangeCountLessThanOrEqualTo(Long value) {
            addCriterion("exchange_count <=", value, "exchangeCount");
            return (Criteria) this;
        }

        public Criteria andExchangeCountIn(List<Long> values) {
            addCriterion("exchange_count in", values, "exchangeCount");
            return (Criteria) this;
        }

        public Criteria andExchangeCountNotIn(List<Long> values) {
            addCriterion("exchange_count not in", values, "exchangeCount");
            return (Criteria) this;
        }

        public Criteria andExchangeCountBetween(Long value1, Long value2) {
            addCriterion("exchange_count between", value1, value2, "exchangeCount");
            return (Criteria) this;
        }

        public Criteria andExchangeCountNotBetween(Long value1, Long value2) {
            addCriterion("exchange_count not between", value1, value2, "exchangeCount");
            return (Criteria) this;
        }

        public Criteria andAlreadyExchangeCountIsNull() {
            addCriterion("already_exchange_count is null");
            return (Criteria) this;
        }

        public Criteria andAlreadyExchangeCountIsNotNull() {
            addCriterion("already_exchange_count is not null");
            return (Criteria) this;
        }

        public Criteria andAlreadyExchangeCountEqualTo(Long value) {
            addCriterion("already_exchange_count =", value, "alreadyExchangeCount");
            return (Criteria) this;
        }

        public Criteria andAlreadyExchangeCountNotEqualTo(Long value) {
            addCriterion("already_exchange_count <>", value, "alreadyExchangeCount");
            return (Criteria) this;
        }

        public Criteria andAlreadyExchangeCountGreaterThan(Long value) {
            addCriterion("already_exchange_count >", value, "alreadyExchangeCount");
            return (Criteria) this;
        }

        public Criteria andAlreadyExchangeCountGreaterThanOrEqualTo(Long value) {
            addCriterion("already_exchange_count >=", value, "alreadyExchangeCount");
            return (Criteria) this;
        }

        public Criteria andAlreadyExchangeCountLessThan(Long value) {
            addCriterion("already_exchange_count <", value, "alreadyExchangeCount");
            return (Criteria) this;
        }

        public Criteria andAlreadyExchangeCountLessThanOrEqualTo(Long value) {
            addCriterion("already_exchange_count <=", value, "alreadyExchangeCount");
            return (Criteria) this;
        }

        public Criteria andAlreadyExchangeCountIn(List<Long> values) {
            addCriterion("already_exchange_count in", values, "alreadyExchangeCount");
            return (Criteria) this;
        }

        public Criteria andAlreadyExchangeCountNotIn(List<Long> values) {
            addCriterion("already_exchange_count not in", values, "alreadyExchangeCount");
            return (Criteria) this;
        }

        public Criteria andAlreadyExchangeCountBetween(Long value1, Long value2) {
            addCriterion("already_exchange_count between", value1, value2, "alreadyExchangeCount");
            return (Criteria) this;
        }

        public Criteria andAlreadyExchangeCountNotBetween(Long value1, Long value2) {
            addCriterion("already_exchange_count not between", value1, value2, "alreadyExchangeCount");
            return (Criteria) this;
        }

        public Criteria andStoreScopeIsNull() {
            addCriterion("store_scope is null");
            return (Criteria) this;
        }

        public Criteria andStoreScopeIsNotNull() {
            addCriterion("store_scope is not null");
            return (Criteria) this;
        }

        public Criteria andStoreScopeEqualTo(Integer value) {
            addCriterion("store_scope =", value, "storeScope");
            return (Criteria) this;
        }

        public Criteria andStoreScopeNotEqualTo(Integer value) {
            addCriterion("store_scope <>", value, "storeScope");
            return (Criteria) this;
        }

        public Criteria andStoreScopeGreaterThan(Integer value) {
            addCriterion("store_scope >", value, "storeScope");
            return (Criteria) this;
        }

        public Criteria andStoreScopeGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_scope >=", value, "storeScope");
            return (Criteria) this;
        }

        public Criteria andStoreScopeLessThan(Integer value) {
            addCriterion("store_scope <", value, "storeScope");
            return (Criteria) this;
        }

        public Criteria andStoreScopeLessThanOrEqualTo(Integer value) {
            addCriterion("store_scope <=", value, "storeScope");
            return (Criteria) this;
        }

        public Criteria andStoreScopeIn(List<Integer> values) {
            addCriterion("store_scope in", values, "storeScope");
            return (Criteria) this;
        }

        public Criteria andStoreScopeNotIn(List<Integer> values) {
            addCriterion("store_scope not in", values, "storeScope");
            return (Criteria) this;
        }

        public Criteria andStoreScopeBetween(Integer value1, Integer value2) {
            addCriterion("store_scope between", value1, value2, "storeScope");
            return (Criteria) this;
        }

        public Criteria andStoreScopeNotBetween(Integer value1, Integer value2) {
            addCriterion("store_scope not between", value1, value2, "storeScope");
            return (Criteria) this;
        }

        public Criteria andStoreListIsNull() {
            addCriterion("store_list is null");
            return (Criteria) this;
        }

        public Criteria andStoreListIsNotNull() {
            addCriterion("store_list is not null");
            return (Criteria) this;
        }

        public Criteria andStoreListEqualTo(String value) {
            addCriterion("store_list =", value, "storeList");
            return (Criteria) this;
        }

        public Criteria andStoreListNotEqualTo(String value) {
            addCriterion("store_list <>", value, "storeList");
            return (Criteria) this;
        }

        public Criteria andStoreListGreaterThan(String value) {
            addCriterion("store_list >", value, "storeList");
            return (Criteria) this;
        }

        public Criteria andStoreListGreaterThanOrEqualTo(String value) {
            addCriterion("store_list >=", value, "storeList");
            return (Criteria) this;
        }

        public Criteria andStoreListLessThan(String value) {
            addCriterion("store_list <", value, "storeList");
            return (Criteria) this;
        }

        public Criteria andStoreListLessThanOrEqualTo(String value) {
            addCriterion("store_list <=", value, "storeList");
            return (Criteria) this;
        }

        public Criteria andStoreListLike(String value) {
            addCriterion("store_list like", value, "storeList");
            return (Criteria) this;
        }

        public Criteria andStoreListNotLike(String value) {
            addCriterion("store_list not like", value, "storeList");
            return (Criteria) this;
        }

        public Criteria andStoreListIn(List<String> values) {
            addCriterion("store_list in", values, "storeList");
            return (Criteria) this;
        }

        public Criteria andStoreListNotIn(List<String> values) {
            addCriterion("store_list not in", values, "storeList");
            return (Criteria) this;
        }

        public Criteria andStoreListBetween(String value1, String value2) {
            addCriterion("store_list between", value1, value2, "storeList");
            return (Criteria) this;
        }

        public Criteria andStoreListNotBetween(String value1, String value2) {
            addCriterion("store_list not between", value1, value2, "storeList");
            return (Criteria) this;
        }

        public Criteria andSalesStatusIsNull() {
            addCriterion("sales_status is null");
            return (Criteria) this;
        }

        public Criteria andSalesStatusIsNotNull() {
            addCriterion("sales_status is not null");
            return (Criteria) this;
        }

        public Criteria andSalesStatusEqualTo(Integer value) {
            addCriterion("sales_status =", value, "salesStatus");
            return (Criteria) this;
        }

        public Criteria andSalesStatusNotEqualTo(Integer value) {
            addCriterion("sales_status <>", value, "salesStatus");
            return (Criteria) this;
        }

        public Criteria andSalesStatusGreaterThan(Integer value) {
            addCriterion("sales_status >", value, "salesStatus");
            return (Criteria) this;
        }

        public Criteria andSalesStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("sales_status >=", value, "salesStatus");
            return (Criteria) this;
        }

        public Criteria andSalesStatusLessThan(Integer value) {
            addCriterion("sales_status <", value, "salesStatus");
            return (Criteria) this;
        }

        public Criteria andSalesStatusLessThanOrEqualTo(Integer value) {
            addCriterion("sales_status <=", value, "salesStatus");
            return (Criteria) this;
        }

        public Criteria andSalesStatusIn(List<Integer> values) {
            addCriterion("sales_status in", values, "salesStatus");
            return (Criteria) this;
        }

        public Criteria andSalesStatusNotIn(List<Integer> values) {
            addCriterion("sales_status not in", values, "salesStatus");
            return (Criteria) this;
        }

        public Criteria andSalesStatusBetween(Integer value1, Integer value2) {
            addCriterion("sales_status between", value1, value2, "salesStatus");
            return (Criteria) this;
        }

        public Criteria andSalesStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("sales_status not between", value1, value2, "salesStatus");
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

        public Criteria andModifyUserIdIsNull() {
            addCriterion("modify_user_id is null");
            return (Criteria) this;
        }

        public Criteria andModifyUserIdIsNotNull() {
            addCriterion("modify_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andModifyUserIdEqualTo(Long value) {
            addCriterion("modify_user_id =", value, "modifyUserId");
            return (Criteria) this;
        }

        public Criteria andModifyUserIdNotEqualTo(Long value) {
            addCriterion("modify_user_id <>", value, "modifyUserId");
            return (Criteria) this;
        }

        public Criteria andModifyUserIdGreaterThan(Long value) {
            addCriterion("modify_user_id >", value, "modifyUserId");
            return (Criteria) this;
        }

        public Criteria andModifyUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("modify_user_id >=", value, "modifyUserId");
            return (Criteria) this;
        }

        public Criteria andModifyUserIdLessThan(Long value) {
            addCriterion("modify_user_id <", value, "modifyUserId");
            return (Criteria) this;
        }

        public Criteria andModifyUserIdLessThanOrEqualTo(Long value) {
            addCriterion("modify_user_id <=", value, "modifyUserId");
            return (Criteria) this;
        }

        public Criteria andModifyUserIdIn(List<Long> values) {
            addCriterion("modify_user_id in", values, "modifyUserId");
            return (Criteria) this;
        }

        public Criteria andModifyUserIdNotIn(List<Long> values) {
            addCriterion("modify_user_id not in", values, "modifyUserId");
            return (Criteria) this;
        }

        public Criteria andModifyUserIdBetween(Long value1, Long value2) {
            addCriterion("modify_user_id between", value1, value2, "modifyUserId");
            return (Criteria) this;
        }

        public Criteria andModifyUserIdNotBetween(Long value1, Long value2) {
            addCriterion("modify_user_id not between", value1, value2, "modifyUserId");
            return (Criteria) this;
        }

        public Criteria andModifyUserNameIsNull() {
            addCriterion("modify_user_name is null");
            return (Criteria) this;
        }

        public Criteria andModifyUserNameIsNotNull() {
            addCriterion("modify_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andModifyUserNameEqualTo(String value) {
            addCriterion("modify_user_name =", value, "modifyUserName");
            return (Criteria) this;
        }

        public Criteria andModifyUserNameNotEqualTo(String value) {
            addCriterion("modify_user_name <>", value, "modifyUserName");
            return (Criteria) this;
        }

        public Criteria andModifyUserNameGreaterThan(String value) {
            addCriterion("modify_user_name >", value, "modifyUserName");
            return (Criteria) this;
        }

        public Criteria andModifyUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("modify_user_name >=", value, "modifyUserName");
            return (Criteria) this;
        }

        public Criteria andModifyUserNameLessThan(String value) {
            addCriterion("modify_user_name <", value, "modifyUserName");
            return (Criteria) this;
        }

        public Criteria andModifyUserNameLessThanOrEqualTo(String value) {
            addCriterion("modify_user_name <=", value, "modifyUserName");
            return (Criteria) this;
        }

        public Criteria andModifyUserNameLike(String value) {
            addCriterion("modify_user_name like", value, "modifyUserName");
            return (Criteria) this;
        }

        public Criteria andModifyUserNameNotLike(String value) {
            addCriterion("modify_user_name not like", value, "modifyUserName");
            return (Criteria) this;
        }

        public Criteria andModifyUserNameIn(List<String> values) {
            addCriterion("modify_user_name in", values, "modifyUserName");
            return (Criteria) this;
        }

        public Criteria andModifyUserNameNotIn(List<String> values) {
            addCriterion("modify_user_name not in", values, "modifyUserName");
            return (Criteria) this;
        }

        public Criteria andModifyUserNameBetween(String value1, String value2) {
            addCriterion("modify_user_name between", value1, value2, "modifyUserName");
            return (Criteria) this;
        }

        public Criteria andModifyUserNameNotBetween(String value1, String value2) {
            addCriterion("modify_user_name not between", value1, value2, "modifyUserName");
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
     * This class corresponds to the database table t_mkt_coupon_integral_exchange
     *
     * @mbg.generated do_not_delete_during_merge 2018-11-22 16:07:57
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

    /**
     * 只读. t_mkt_coupon_integral_exchange
     *
     * @mbg.generated 2018-11-22 16:07:57
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