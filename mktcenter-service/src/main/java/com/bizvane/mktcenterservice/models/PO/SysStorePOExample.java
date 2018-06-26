package com.bizvane.mktcenterservice.models.PO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysStorePOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysStorePOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
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

        public Criteria andSysStoreIdIsNull() {
            addCriterion("sys_store_id is null");
            return (Criteria) this;
        }

        public Criteria andSysStoreIdIsNotNull() {
            addCriterion("sys_store_id is not null");
            return (Criteria) this;
        }

        public Criteria andSysStoreIdEqualTo(Long value) {
            addCriterion("sys_store_id =", value, "sysStoreId");
            return (Criteria) this;
        }

        public Criteria andSysStoreIdNotEqualTo(Long value) {
            addCriterion("sys_store_id <>", value, "sysStoreId");
            return (Criteria) this;
        }

        public Criteria andSysStoreIdGreaterThan(Long value) {
            addCriterion("sys_store_id >", value, "sysStoreId");
            return (Criteria) this;
        }

        public Criteria andSysStoreIdGreaterThanOrEqualTo(Long value) {
            addCriterion("sys_store_id >=", value, "sysStoreId");
            return (Criteria) this;
        }

        public Criteria andSysStoreIdLessThan(Long value) {
            addCriterion("sys_store_id <", value, "sysStoreId");
            return (Criteria) this;
        }

        public Criteria andSysStoreIdLessThanOrEqualTo(Long value) {
            addCriterion("sys_store_id <=", value, "sysStoreId");
            return (Criteria) this;
        }

        public Criteria andSysStoreIdIn(List<Long> values) {
            addCriterion("sys_store_id in", values, "sysStoreId");
            return (Criteria) this;
        }

        public Criteria andSysStoreIdNotIn(List<Long> values) {
            addCriterion("sys_store_id not in", values, "sysStoreId");
            return (Criteria) this;
        }

        public Criteria andSysStoreIdBetween(Long value1, Long value2) {
            addCriterion("sys_store_id between", value1, value2, "sysStoreId");
            return (Criteria) this;
        }

        public Criteria andSysStoreIdNotBetween(Long value1, Long value2) {
            addCriterion("sys_store_id not between", value1, value2, "sysStoreId");
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

        public Criteria andSysStoreCodeIsNull() {
            addCriterion("sys_store_code is null");
            return (Criteria) this;
        }

        public Criteria andSysStoreCodeIsNotNull() {
            addCriterion("sys_store_code is not null");
            return (Criteria) this;
        }

        public Criteria andSysStoreCodeEqualTo(String value) {
            addCriterion("sys_store_code =", value, "sysStoreCode");
            return (Criteria) this;
        }

        public Criteria andSysStoreCodeNotEqualTo(String value) {
            addCriterion("sys_store_code <>", value, "sysStoreCode");
            return (Criteria) this;
        }

        public Criteria andSysStoreCodeGreaterThan(String value) {
            addCriterion("sys_store_code >", value, "sysStoreCode");
            return (Criteria) this;
        }

        public Criteria andSysStoreCodeGreaterThanOrEqualTo(String value) {
            addCriterion("sys_store_code >=", value, "sysStoreCode");
            return (Criteria) this;
        }

        public Criteria andSysStoreCodeLessThan(String value) {
            addCriterion("sys_store_code <", value, "sysStoreCode");
            return (Criteria) this;
        }

        public Criteria andSysStoreCodeLessThanOrEqualTo(String value) {
            addCriterion("sys_store_code <=", value, "sysStoreCode");
            return (Criteria) this;
        }

        public Criteria andSysStoreCodeLike(String value) {
            addCriterion("sys_store_code like", value, "sysStoreCode");
            return (Criteria) this;
        }

        public Criteria andSysStoreCodeNotLike(String value) {
            addCriterion("sys_store_code not like", value, "sysStoreCode");
            return (Criteria) this;
        }

        public Criteria andSysStoreCodeIn(List<String> values) {
            addCriterion("sys_store_code in", values, "sysStoreCode");
            return (Criteria) this;
        }

        public Criteria andSysStoreCodeNotIn(List<String> values) {
            addCriterion("sys_store_code not in", values, "sysStoreCode");
            return (Criteria) this;
        }

        public Criteria andSysStoreCodeBetween(String value1, String value2) {
            addCriterion("sys_store_code between", value1, value2, "sysStoreCode");
            return (Criteria) this;
        }

        public Criteria andSysStoreCodeNotBetween(String value1, String value2) {
            addCriterion("sys_store_code not between", value1, value2, "sysStoreCode");
            return (Criteria) this;
        }

        public Criteria andStoreNameIsNull() {
            addCriterion("store_name is null");
            return (Criteria) this;
        }

        public Criteria andStoreNameIsNotNull() {
            addCriterion("store_name is not null");
            return (Criteria) this;
        }

        public Criteria andStoreNameEqualTo(String value) {
            addCriterion("store_name =", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotEqualTo(String value) {
            addCriterion("store_name <>", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameGreaterThan(String value) {
            addCriterion("store_name >", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameGreaterThanOrEqualTo(String value) {
            addCriterion("store_name >=", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLessThan(String value) {
            addCriterion("store_name <", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLessThanOrEqualTo(String value) {
            addCriterion("store_name <=", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLike(String value) {
            addCriterion("store_name like", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotLike(String value) {
            addCriterion("store_name not like", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameIn(List<String> values) {
            addCriterion("store_name in", values, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotIn(List<String> values) {
            addCriterion("store_name not in", values, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameBetween(String value1, String value2) {
            addCriterion("store_name between", value1, value2, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotBetween(String value1, String value2) {
            addCriterion("store_name not between", value1, value2, "storeName");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIsNull() {
            addCriterion("province_code is null");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIsNotNull() {
            addCriterion("province_code is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeEqualTo(String value) {
            addCriterion("province_code =", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotEqualTo(String value) {
            addCriterion("province_code <>", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeGreaterThan(String value) {
            addCriterion("province_code >", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("province_code >=", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLessThan(String value) {
            addCriterion("province_code <", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLessThanOrEqualTo(String value) {
            addCriterion("province_code <=", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLike(String value) {
            addCriterion("province_code like", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotLike(String value) {
            addCriterion("province_code not like", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIn(List<String> values) {
            addCriterion("province_code in", values, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotIn(List<String> values) {
            addCriterion("province_code not in", values, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeBetween(String value1, String value2) {
            addCriterion("province_code between", value1, value2, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotBetween(String value1, String value2) {
            addCriterion("province_code not between", value1, value2, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeIsNull() {
            addCriterion("city_code is null");
            return (Criteria) this;
        }

        public Criteria andCityCodeIsNotNull() {
            addCriterion("city_code is not null");
            return (Criteria) this;
        }

        public Criteria andCityCodeEqualTo(String value) {
            addCriterion("city_code =", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotEqualTo(String value) {
            addCriterion("city_code <>", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeGreaterThan(String value) {
            addCriterion("city_code >", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeGreaterThanOrEqualTo(String value) {
            addCriterion("city_code >=", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeLessThan(String value) {
            addCriterion("city_code <", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeLessThanOrEqualTo(String value) {
            addCriterion("city_code <=", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeLike(String value) {
            addCriterion("city_code like", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotLike(String value) {
            addCriterion("city_code not like", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeIn(List<String> values) {
            addCriterion("city_code in", values, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotIn(List<String> values) {
            addCriterion("city_code not in", values, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeBetween(String value1, String value2) {
            addCriterion("city_code between", value1, value2, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotBetween(String value1, String value2) {
            addCriterion("city_code not between", value1, value2, "cityCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeIsNull() {
            addCriterion("area_code is null");
            return (Criteria) this;
        }

        public Criteria andAreaCodeIsNotNull() {
            addCriterion("area_code is not null");
            return (Criteria) this;
        }

        public Criteria andAreaCodeEqualTo(String value) {
            addCriterion("area_code =", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotEqualTo(String value) {
            addCriterion("area_code <>", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeGreaterThan(String value) {
            addCriterion("area_code >", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeGreaterThanOrEqualTo(String value) {
            addCriterion("area_code >=", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeLessThan(String value) {
            addCriterion("area_code <", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeLessThanOrEqualTo(String value) {
            addCriterion("area_code <=", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeLike(String value) {
            addCriterion("area_code like", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotLike(String value) {
            addCriterion("area_code not like", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeIn(List<String> values) {
            addCriterion("area_code in", values, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotIn(List<String> values) {
            addCriterion("area_code not in", values, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeBetween(String value1, String value2) {
            addCriterion("area_code between", value1, value2, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotBetween(String value1, String value2) {
            addCriterion("area_code not between", value1, value2, "areaCode");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressIsNull() {
            addCriterion("detailed_address is null");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressIsNotNull() {
            addCriterion("detailed_address is not null");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressEqualTo(String value) {
            addCriterion("detailed_address =", value, "detailedAddress");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressNotEqualTo(String value) {
            addCriterion("detailed_address <>", value, "detailedAddress");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressGreaterThan(String value) {
            addCriterion("detailed_address >", value, "detailedAddress");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressGreaterThanOrEqualTo(String value) {
            addCriterion("detailed_address >=", value, "detailedAddress");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressLessThan(String value) {
            addCriterion("detailed_address <", value, "detailedAddress");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressLessThanOrEqualTo(String value) {
            addCriterion("detailed_address <=", value, "detailedAddress");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressLike(String value) {
            addCriterion("detailed_address like", value, "detailedAddress");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressNotLike(String value) {
            addCriterion("detailed_address not like", value, "detailedAddress");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressIn(List<String> values) {
            addCriterion("detailed_address in", values, "detailedAddress");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressNotIn(List<String> values) {
            addCriterion("detailed_address not in", values, "detailedAddress");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressBetween(String value1, String value2) {
            addCriterion("detailed_address between", value1, value2, "detailedAddress");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressNotBetween(String value1, String value2) {
            addCriterion("detailed_address not between", value1, value2, "detailedAddress");
            return (Criteria) this;
        }

        public Criteria andBizAreaIsNull() {
            addCriterion("biz_area is null");
            return (Criteria) this;
        }

        public Criteria andBizAreaIsNotNull() {
            addCriterion("biz_area is not null");
            return (Criteria) this;
        }

        public Criteria andBizAreaEqualTo(String value) {
            addCriterion("biz_area =", value, "bizArea");
            return (Criteria) this;
        }

        public Criteria andBizAreaNotEqualTo(String value) {
            addCriterion("biz_area <>", value, "bizArea");
            return (Criteria) this;
        }

        public Criteria andBizAreaGreaterThan(String value) {
            addCriterion("biz_area >", value, "bizArea");
            return (Criteria) this;
        }

        public Criteria andBizAreaGreaterThanOrEqualTo(String value) {
            addCriterion("biz_area >=", value, "bizArea");
            return (Criteria) this;
        }

        public Criteria andBizAreaLessThan(String value) {
            addCriterion("biz_area <", value, "bizArea");
            return (Criteria) this;
        }

        public Criteria andBizAreaLessThanOrEqualTo(String value) {
            addCriterion("biz_area <=", value, "bizArea");
            return (Criteria) this;
        }

        public Criteria andBizAreaLike(String value) {
            addCriterion("biz_area like", value, "bizArea");
            return (Criteria) this;
        }

        public Criteria andBizAreaNotLike(String value) {
            addCriterion("biz_area not like", value, "bizArea");
            return (Criteria) this;
        }

        public Criteria andBizAreaIn(List<String> values) {
            addCriterion("biz_area in", values, "bizArea");
            return (Criteria) this;
        }

        public Criteria andBizAreaNotIn(List<String> values) {
            addCriterion("biz_area not in", values, "bizArea");
            return (Criteria) this;
        }

        public Criteria andBizAreaBetween(String value1, String value2) {
            addCriterion("biz_area between", value1, value2, "bizArea");
            return (Criteria) this;
        }

        public Criteria andBizAreaNotBetween(String value1, String value2) {
            addCriterion("biz_area not between", value1, value2, "bizArea");
            return (Criteria) this;
        }

        public Criteria andLngIsNull() {
            addCriterion("lng is null");
            return (Criteria) this;
        }

        public Criteria andLngIsNotNull() {
            addCriterion("lng is not null");
            return (Criteria) this;
        }

        public Criteria andLngEqualTo(String value) {
            addCriterion("lng =", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotEqualTo(String value) {
            addCriterion("lng <>", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngGreaterThan(String value) {
            addCriterion("lng >", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngGreaterThanOrEqualTo(String value) {
            addCriterion("lng >=", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngLessThan(String value) {
            addCriterion("lng <", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngLessThanOrEqualTo(String value) {
            addCriterion("lng <=", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngLike(String value) {
            addCriterion("lng like", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotLike(String value) {
            addCriterion("lng not like", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngIn(List<String> values) {
            addCriterion("lng in", values, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotIn(List<String> values) {
            addCriterion("lng not in", values, "lng");
            return (Criteria) this;
        }

        public Criteria andLngBetween(String value1, String value2) {
            addCriterion("lng between", value1, value2, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotBetween(String value1, String value2) {
            addCriterion("lng not between", value1, value2, "lng");
            return (Criteria) this;
        }

        public Criteria andLatIsNull() {
            addCriterion("lat is null");
            return (Criteria) this;
        }

        public Criteria andLatIsNotNull() {
            addCriterion("lat is not null");
            return (Criteria) this;
        }

        public Criteria andLatEqualTo(String value) {
            addCriterion("lat =", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotEqualTo(String value) {
            addCriterion("lat <>", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThan(String value) {
            addCriterion("lat >", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThanOrEqualTo(String value) {
            addCriterion("lat >=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThan(String value) {
            addCriterion("lat <", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThanOrEqualTo(String value) {
            addCriterion("lat <=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLike(String value) {
            addCriterion("lat like", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotLike(String value) {
            addCriterion("lat not like", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatIn(List<String> values) {
            addCriterion("lat in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotIn(List<String> values) {
            addCriterion("lat not in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatBetween(String value1, String value2) {
            addCriterion("lat between", value1, value2, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotBetween(String value1, String value2) {
            addCriterion("lat not between", value1, value2, "lat");
            return (Criteria) this;
        }

        public Criteria andStoreImgsIsNull() {
            addCriterion("store_imgs is null");
            return (Criteria) this;
        }

        public Criteria andStoreImgsIsNotNull() {
            addCriterion("store_imgs is not null");
            return (Criteria) this;
        }

        public Criteria andStoreImgsEqualTo(String value) {
            addCriterion("store_imgs =", value, "storeImgs");
            return (Criteria) this;
        }

        public Criteria andStoreImgsNotEqualTo(String value) {
            addCriterion("store_imgs <>", value, "storeImgs");
            return (Criteria) this;
        }

        public Criteria andStoreImgsGreaterThan(String value) {
            addCriterion("store_imgs >", value, "storeImgs");
            return (Criteria) this;
        }

        public Criteria andStoreImgsGreaterThanOrEqualTo(String value) {
            addCriterion("store_imgs >=", value, "storeImgs");
            return (Criteria) this;
        }

        public Criteria andStoreImgsLessThan(String value) {
            addCriterion("store_imgs <", value, "storeImgs");
            return (Criteria) this;
        }

        public Criteria andStoreImgsLessThanOrEqualTo(String value) {
            addCriterion("store_imgs <=", value, "storeImgs");
            return (Criteria) this;
        }

        public Criteria andStoreImgsLike(String value) {
            addCriterion("store_imgs like", value, "storeImgs");
            return (Criteria) this;
        }

        public Criteria andStoreImgsNotLike(String value) {
            addCriterion("store_imgs not like", value, "storeImgs");
            return (Criteria) this;
        }

        public Criteria andStoreImgsIn(List<String> values) {
            addCriterion("store_imgs in", values, "storeImgs");
            return (Criteria) this;
        }

        public Criteria andStoreImgsNotIn(List<String> values) {
            addCriterion("store_imgs not in", values, "storeImgs");
            return (Criteria) this;
        }

        public Criteria andStoreImgsBetween(String value1, String value2) {
            addCriterion("store_imgs between", value1, value2, "storeImgs");
            return (Criteria) this;
        }

        public Criteria andStoreImgsNotBetween(String value1, String value2) {
            addCriterion("store_imgs not between", value1, value2, "storeImgs");
            return (Criteria) this;
        }

        public Criteria andStoreOrcodeIsNull() {
            addCriterion("store_orcode is null");
            return (Criteria) this;
        }

        public Criteria andStoreOrcodeIsNotNull() {
            addCriterion("store_orcode is not null");
            return (Criteria) this;
        }

        public Criteria andStoreOrcodeEqualTo(String value) {
            addCriterion("store_orcode =", value, "storeOrcode");
            return (Criteria) this;
        }

        public Criteria andStoreOrcodeNotEqualTo(String value) {
            addCriterion("store_orcode <>", value, "storeOrcode");
            return (Criteria) this;
        }

        public Criteria andStoreOrcodeGreaterThan(String value) {
            addCriterion("store_orcode >", value, "storeOrcode");
            return (Criteria) this;
        }

        public Criteria andStoreOrcodeGreaterThanOrEqualTo(String value) {
            addCriterion("store_orcode >=", value, "storeOrcode");
            return (Criteria) this;
        }

        public Criteria andStoreOrcodeLessThan(String value) {
            addCriterion("store_orcode <", value, "storeOrcode");
            return (Criteria) this;
        }

        public Criteria andStoreOrcodeLessThanOrEqualTo(String value) {
            addCriterion("store_orcode <=", value, "storeOrcode");
            return (Criteria) this;
        }

        public Criteria andStoreOrcodeLike(String value) {
            addCriterion("store_orcode like", value, "storeOrcode");
            return (Criteria) this;
        }

        public Criteria andStoreOrcodeNotLike(String value) {
            addCriterion("store_orcode not like", value, "storeOrcode");
            return (Criteria) this;
        }

        public Criteria andStoreOrcodeIn(List<String> values) {
            addCriterion("store_orcode in", values, "storeOrcode");
            return (Criteria) this;
        }

        public Criteria andStoreOrcodeNotIn(List<String> values) {
            addCriterion("store_orcode not in", values, "storeOrcode");
            return (Criteria) this;
        }

        public Criteria andStoreOrcodeBetween(String value1, String value2) {
            addCriterion("store_orcode between", value1, value2, "storeOrcode");
            return (Criteria) this;
        }

        public Criteria andStoreOrcodeNotBetween(String value1, String value2) {
            addCriterion("store_orcode not between", value1, value2, "storeOrcode");
            return (Criteria) this;
        }

        public Criteria andStoreOrcodeRouteUrlIsNull() {
            addCriterion("store_orcode_route_url is null");
            return (Criteria) this;
        }

        public Criteria andStoreOrcodeRouteUrlIsNotNull() {
            addCriterion("store_orcode_route_url is not null");
            return (Criteria) this;
        }

        public Criteria andStoreOrcodeRouteUrlEqualTo(String value) {
            addCriterion("store_orcode_route_url =", value, "storeOrcodeRouteUrl");
            return (Criteria) this;
        }

        public Criteria andStoreOrcodeRouteUrlNotEqualTo(String value) {
            addCriterion("store_orcode_route_url <>", value, "storeOrcodeRouteUrl");
            return (Criteria) this;
        }

        public Criteria andStoreOrcodeRouteUrlGreaterThan(String value) {
            addCriterion("store_orcode_route_url >", value, "storeOrcodeRouteUrl");
            return (Criteria) this;
        }

        public Criteria andStoreOrcodeRouteUrlGreaterThanOrEqualTo(String value) {
            addCriterion("store_orcode_route_url >=", value, "storeOrcodeRouteUrl");
            return (Criteria) this;
        }

        public Criteria andStoreOrcodeRouteUrlLessThan(String value) {
            addCriterion("store_orcode_route_url <", value, "storeOrcodeRouteUrl");
            return (Criteria) this;
        }

        public Criteria andStoreOrcodeRouteUrlLessThanOrEqualTo(String value) {
            addCriterion("store_orcode_route_url <=", value, "storeOrcodeRouteUrl");
            return (Criteria) this;
        }

        public Criteria andStoreOrcodeRouteUrlLike(String value) {
            addCriterion("store_orcode_route_url like", value, "storeOrcodeRouteUrl");
            return (Criteria) this;
        }

        public Criteria andStoreOrcodeRouteUrlNotLike(String value) {
            addCriterion("store_orcode_route_url not like", value, "storeOrcodeRouteUrl");
            return (Criteria) this;
        }

        public Criteria andStoreOrcodeRouteUrlIn(List<String> values) {
            addCriterion("store_orcode_route_url in", values, "storeOrcodeRouteUrl");
            return (Criteria) this;
        }

        public Criteria andStoreOrcodeRouteUrlNotIn(List<String> values) {
            addCriterion("store_orcode_route_url not in", values, "storeOrcodeRouteUrl");
            return (Criteria) this;
        }

        public Criteria andStoreOrcodeRouteUrlBetween(String value1, String value2) {
            addCriterion("store_orcode_route_url between", value1, value2, "storeOrcodeRouteUrl");
            return (Criteria) this;
        }

        public Criteria andStoreOrcodeRouteUrlNotBetween(String value1, String value2) {
            addCriterion("store_orcode_route_url not between", value1, value2, "storeOrcodeRouteUrl");
            return (Criteria) this;
        }

        public Criteria andDistributorNameIsNull() {
            addCriterion("distributor_name is null");
            return (Criteria) this;
        }

        public Criteria andDistributorNameIsNotNull() {
            addCriterion("distributor_name is not null");
            return (Criteria) this;
        }

        public Criteria andDistributorNameEqualTo(String value) {
            addCriterion("distributor_name =", value, "distributorName");
            return (Criteria) this;
        }

        public Criteria andDistributorNameNotEqualTo(String value) {
            addCriterion("distributor_name <>", value, "distributorName");
            return (Criteria) this;
        }

        public Criteria andDistributorNameGreaterThan(String value) {
            addCriterion("distributor_name >", value, "distributorName");
            return (Criteria) this;
        }

        public Criteria andDistributorNameGreaterThanOrEqualTo(String value) {
            addCriterion("distributor_name >=", value, "distributorName");
            return (Criteria) this;
        }

        public Criteria andDistributorNameLessThan(String value) {
            addCriterion("distributor_name <", value, "distributorName");
            return (Criteria) this;
        }

        public Criteria andDistributorNameLessThanOrEqualTo(String value) {
            addCriterion("distributor_name <=", value, "distributorName");
            return (Criteria) this;
        }

        public Criteria andDistributorNameLike(String value) {
            addCriterion("distributor_name like", value, "distributorName");
            return (Criteria) this;
        }

        public Criteria andDistributorNameNotLike(String value) {
            addCriterion("distributor_name not like", value, "distributorName");
            return (Criteria) this;
        }

        public Criteria andDistributorNameIn(List<String> values) {
            addCriterion("distributor_name in", values, "distributorName");
            return (Criteria) this;
        }

        public Criteria andDistributorNameNotIn(List<String> values) {
            addCriterion("distributor_name not in", values, "distributorName");
            return (Criteria) this;
        }

        public Criteria andDistributorNameBetween(String value1, String value2) {
            addCriterion("distributor_name between", value1, value2, "distributorName");
            return (Criteria) this;
        }

        public Criteria andDistributorNameNotBetween(String value1, String value2) {
            addCriterion("distributor_name not between", value1, value2, "distributorName");
            return (Criteria) this;
        }

        public Criteria andStoreTypeIsNull() {
            addCriterion("store_type is null");
            return (Criteria) this;
        }

        public Criteria andStoreTypeIsNotNull() {
            addCriterion("store_type is not null");
            return (Criteria) this;
        }

        public Criteria andStoreTypeEqualTo(Long value) {
            addCriterion("store_type =", value, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeNotEqualTo(Long value) {
            addCriterion("store_type <>", value, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeGreaterThan(Long value) {
            addCriterion("store_type >", value, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeGreaterThanOrEqualTo(Long value) {
            addCriterion("store_type >=", value, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeLessThan(Long value) {
            addCriterion("store_type <", value, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeLessThanOrEqualTo(Long value) {
            addCriterion("store_type <=", value, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeIn(List<Long> values) {
            addCriterion("store_type in", values, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeNotIn(List<Long> values) {
            addCriterion("store_type not in", values, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeBetween(Long value1, Long value2) {
            addCriterion("store_type between", value1, value2, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeNotBetween(Long value1, Long value2) {
            addCriterion("store_type not between", value1, value2, "storeType");
            return (Criteria) this;
        }

        public Criteria andDictionaryCodeIsNull() {
            addCriterion("dictionary_code is null");
            return (Criteria) this;
        }

        public Criteria andDictionaryCodeIsNotNull() {
            addCriterion("dictionary_code is not null");
            return (Criteria) this;
        }

        public Criteria andDictionaryCodeEqualTo(String value) {
            addCriterion("dictionary_code =", value, "dictionaryCode");
            return (Criteria) this;
        }

        public Criteria andDictionaryCodeNotEqualTo(String value) {
            addCriterion("dictionary_code <>", value, "dictionaryCode");
            return (Criteria) this;
        }

        public Criteria andDictionaryCodeGreaterThan(String value) {
            addCriterion("dictionary_code >", value, "dictionaryCode");
            return (Criteria) this;
        }

        public Criteria andDictionaryCodeGreaterThanOrEqualTo(String value) {
            addCriterion("dictionary_code >=", value, "dictionaryCode");
            return (Criteria) this;
        }

        public Criteria andDictionaryCodeLessThan(String value) {
            addCriterion("dictionary_code <", value, "dictionaryCode");
            return (Criteria) this;
        }

        public Criteria andDictionaryCodeLessThanOrEqualTo(String value) {
            addCriterion("dictionary_code <=", value, "dictionaryCode");
            return (Criteria) this;
        }

        public Criteria andDictionaryCodeLike(String value) {
            addCriterion("dictionary_code like", value, "dictionaryCode");
            return (Criteria) this;
        }

        public Criteria andDictionaryCodeNotLike(String value) {
            addCriterion("dictionary_code not like", value, "dictionaryCode");
            return (Criteria) this;
        }

        public Criteria andDictionaryCodeIn(List<String> values) {
            addCriterion("dictionary_code in", values, "dictionaryCode");
            return (Criteria) this;
        }

        public Criteria andDictionaryCodeNotIn(List<String> values) {
            addCriterion("dictionary_code not in", values, "dictionaryCode");
            return (Criteria) this;
        }

        public Criteria andDictionaryCodeBetween(String value1, String value2) {
            addCriterion("dictionary_code between", value1, value2, "dictionaryCode");
            return (Criteria) this;
        }

        public Criteria andDictionaryCodeNotBetween(String value1, String value2) {
            addCriterion("dictionary_code not between", value1, value2, "dictionaryCode");
            return (Criteria) this;
        }

        public Criteria andShopOwnerIsNull() {
            addCriterion("shop_owner is null");
            return (Criteria) this;
        }

        public Criteria andShopOwnerIsNotNull() {
            addCriterion("shop_owner is not null");
            return (Criteria) this;
        }

        public Criteria andShopOwnerEqualTo(String value) {
            addCriterion("shop_owner =", value, "shopOwner");
            return (Criteria) this;
        }

        public Criteria andShopOwnerNotEqualTo(String value) {
            addCriterion("shop_owner <>", value, "shopOwner");
            return (Criteria) this;
        }

        public Criteria andShopOwnerGreaterThan(String value) {
            addCriterion("shop_owner >", value, "shopOwner");
            return (Criteria) this;
        }

        public Criteria andShopOwnerGreaterThanOrEqualTo(String value) {
            addCriterion("shop_owner >=", value, "shopOwner");
            return (Criteria) this;
        }

        public Criteria andShopOwnerLessThan(String value) {
            addCriterion("shop_owner <", value, "shopOwner");
            return (Criteria) this;
        }

        public Criteria andShopOwnerLessThanOrEqualTo(String value) {
            addCriterion("shop_owner <=", value, "shopOwner");
            return (Criteria) this;
        }

        public Criteria andShopOwnerLike(String value) {
            addCriterion("shop_owner like", value, "shopOwner");
            return (Criteria) this;
        }

        public Criteria andShopOwnerNotLike(String value) {
            addCriterion("shop_owner not like", value, "shopOwner");
            return (Criteria) this;
        }

        public Criteria andShopOwnerIn(List<String> values) {
            addCriterion("shop_owner in", values, "shopOwner");
            return (Criteria) this;
        }

        public Criteria andShopOwnerNotIn(List<String> values) {
            addCriterion("shop_owner not in", values, "shopOwner");
            return (Criteria) this;
        }

        public Criteria andShopOwnerBetween(String value1, String value2) {
            addCriterion("shop_owner between", value1, value2, "shopOwner");
            return (Criteria) this;
        }

        public Criteria andShopOwnerNotBetween(String value1, String value2) {
            addCriterion("shop_owner not between", value1, value2, "shopOwner");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Boolean value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Boolean value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Boolean value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Boolean value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Boolean> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Boolean> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andOnDateIsNull() {
            addCriterion("on_date is null");
            return (Criteria) this;
        }

        public Criteria andOnDateIsNotNull() {
            addCriterion("on_date is not null");
            return (Criteria) this;
        }

        public Criteria andOnDateEqualTo(Date value) {
            addCriterion("on_date =", value, "onDate");
            return (Criteria) this;
        }

        public Criteria andOnDateNotEqualTo(Date value) {
            addCriterion("on_date <>", value, "onDate");
            return (Criteria) this;
        }

        public Criteria andOnDateGreaterThan(Date value) {
            addCriterion("on_date >", value, "onDate");
            return (Criteria) this;
        }

        public Criteria andOnDateGreaterThanOrEqualTo(Date value) {
            addCriterion("on_date >=", value, "onDate");
            return (Criteria) this;
        }

        public Criteria andOnDateLessThan(Date value) {
            addCriterion("on_date <", value, "onDate");
            return (Criteria) this;
        }

        public Criteria andOnDateLessThanOrEqualTo(Date value) {
            addCriterion("on_date <=", value, "onDate");
            return (Criteria) this;
        }

        public Criteria andOnDateIn(List<Date> values) {
            addCriterion("on_date in", values, "onDate");
            return (Criteria) this;
        }

        public Criteria andOnDateNotIn(List<Date> values) {
            addCriterion("on_date not in", values, "onDate");
            return (Criteria) this;
        }

        public Criteria andOnDateBetween(Date value1, Date value2) {
            addCriterion("on_date between", value1, value2, "onDate");
            return (Criteria) this;
        }

        public Criteria andOnDateNotBetween(Date value1, Date value2) {
            addCriterion("on_date not between", value1, value2, "onDate");
            return (Criteria) this;
        }

        public Criteria andOffDateIsNull() {
            addCriterion("off_date is null");
            return (Criteria) this;
        }

        public Criteria andOffDateIsNotNull() {
            addCriterion("off_date is not null");
            return (Criteria) this;
        }

        public Criteria andOffDateEqualTo(Date value) {
            addCriterion("off_date =", value, "offDate");
            return (Criteria) this;
        }

        public Criteria andOffDateNotEqualTo(Date value) {
            addCriterion("off_date <>", value, "offDate");
            return (Criteria) this;
        }

        public Criteria andOffDateGreaterThan(Date value) {
            addCriterion("off_date >", value, "offDate");
            return (Criteria) this;
        }

        public Criteria andOffDateGreaterThanOrEqualTo(Date value) {
            addCriterion("off_date >=", value, "offDate");
            return (Criteria) this;
        }

        public Criteria andOffDateLessThan(Date value) {
            addCriterion("off_date <", value, "offDate");
            return (Criteria) this;
        }

        public Criteria andOffDateLessThanOrEqualTo(Date value) {
            addCriterion("off_date <=", value, "offDate");
            return (Criteria) this;
        }

        public Criteria andOffDateIn(List<Date> values) {
            addCriterion("off_date in", values, "offDate");
            return (Criteria) this;
        }

        public Criteria andOffDateNotIn(List<Date> values) {
            addCriterion("off_date not in", values, "offDate");
            return (Criteria) this;
        }

        public Criteria andOffDateBetween(Date value1, Date value2) {
            addCriterion("off_date between", value1, value2, "offDate");
            return (Criteria) this;
        }

        public Criteria andOffDateNotBetween(Date value1, Date value2) {
            addCriterion("off_date not between", value1, value2, "offDate");
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

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
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