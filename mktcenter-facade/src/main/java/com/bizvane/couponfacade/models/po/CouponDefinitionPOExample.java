package com.bizvane.couponfacade.models.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CouponDefinitionPOExample {
    /**
   * @mbg.generated
   */
  protected String orderByClause;
  /**
   * @mbg.generated
   */
  protected boolean distinct;
  /**
   * @mbg.generated
   */
  protected List<Criteria> oredCriteria;

  /**
   * 只读. 
   * @mbg.generated  2019-04-23 15:56:26
   */
  public CouponDefinitionPOExample() {
    oredCriteria = new ArrayList<Criteria>();
  }

  /**
   * 只读. 
   * @mbg.generated  2019-04-23 15:56:26
   */
  public void setOrderByClause(String orderByClause) {
    this.orderByClause = orderByClause;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-04-23 15:56:26
   */
  public String getOrderByClause() {
    return orderByClause;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-04-23 15:56:26
   */
  public void setDistinct(boolean distinct) {
    this.distinct = distinct;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-04-23 15:56:26
   */
  public boolean isDistinct() {
    return distinct;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-04-23 15:56:26
   */
  public List<Criteria> getOredCriteria() {
    return oredCriteria;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-04-23 15:56:26
   */
  public void or(Criteria criteria) {
    oredCriteria.add(criteria);
  }

  /**
   * 只读. 
   * @mbg.generated  2019-04-23 15:56:26
   */
  public Criteria or() {
    Criteria criteria = createCriteriaInternal();
    oredCriteria.add(criteria);
    return criteria;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-04-23 15:56:26
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
   * @mbg.generated  2019-04-23 15:56:26
   */
  protected Criteria createCriteriaInternal() {
    Criteria criteria = new Criteria();
    return criteria;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-04-23 15:56:26
   */
  public void clear() {
    oredCriteria.clear();
    orderByClause = null;
    distinct = false;
  }

  /**
   * 只读. t_coupon_definition
   * @mbg.generated  2019-04-23 15:56:26
   */
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

    public Criteria andCouponDefinitionCodeIsNull() {
      addCriterion("coupon_definition_code is null");
      return (Criteria) this;
    }

    public Criteria andCouponDefinitionCodeIsNotNull() {
      addCriterion("coupon_definition_code is not null");
      return (Criteria) this;
    }

    public Criteria andCouponDefinitionCodeEqualTo(String value) {
      addCriterion("coupon_definition_code =", value, "couponDefinitionCode");
      return (Criteria) this;
    }

    public Criteria andCouponDefinitionCodeNotEqualTo(String value) {
      addCriterion("coupon_definition_code <>", value, "couponDefinitionCode");
      return (Criteria) this;
    }

    public Criteria andCouponDefinitionCodeGreaterThan(String value) {
      addCriterion("coupon_definition_code >", value, "couponDefinitionCode");
      return (Criteria) this;
    }

    public Criteria andCouponDefinitionCodeGreaterThanOrEqualTo(String value) {
      addCriterion("coupon_definition_code >=", value, "couponDefinitionCode");
      return (Criteria) this;
    }

    public Criteria andCouponDefinitionCodeLessThan(String value) {
      addCriterion("coupon_definition_code <", value, "couponDefinitionCode");
      return (Criteria) this;
    }

    public Criteria andCouponDefinitionCodeLessThanOrEqualTo(String value) {
      addCriterion("coupon_definition_code <=", value, "couponDefinitionCode");
      return (Criteria) this;
    }

    public Criteria andCouponDefinitionCodeLike(String value) {
      addCriterion("coupon_definition_code like", value, "couponDefinitionCode");
      return (Criteria) this;
    }

    public Criteria andCouponDefinitionCodeNotLike(String value) {
      addCriterion("coupon_definition_code not like", value, "couponDefinitionCode");
      return (Criteria) this;
    }

    public Criteria andCouponDefinitionCodeIn(List<String> values) {
      addCriterion("coupon_definition_code in", values, "couponDefinitionCode");
      return (Criteria) this;
    }

    public Criteria andCouponDefinitionCodeNotIn(List<String> values) {
      addCriterion("coupon_definition_code not in", values, "couponDefinitionCode");
      return (Criteria) this;
    }

    public Criteria andCouponDefinitionCodeBetween(String value1, String value2) {
      addCriterion("coupon_definition_code between", value1, value2, "couponDefinitionCode");
      return (Criteria) this;
    }

    public Criteria andCouponDefinitionCodeNotBetween(String value1, String value2) {
      addCriterion("coupon_definition_code not between", value1, value2, "couponDefinitionCode");
      return (Criteria) this;
    }

    public Criteria andCouponDefinitionTypeIsNull() {
      addCriterion("coupon_definition_type is null");
      return (Criteria) this;
    }

    public Criteria andCouponDefinitionTypeIsNotNull() {
      addCriterion("coupon_definition_type is not null");
      return (Criteria) this;
    }

    public Criteria andCouponDefinitionTypeEqualTo(Byte value) {
      addCriterion("coupon_definition_type =", value, "couponDefinitionType");
      return (Criteria) this;
    }

    public Criteria andCouponDefinitionTypeNotEqualTo(Byte value) {
      addCriterion("coupon_definition_type <>", value, "couponDefinitionType");
      return (Criteria) this;
    }

    public Criteria andCouponDefinitionTypeGreaterThan(Byte value) {
      addCriterion("coupon_definition_type >", value, "couponDefinitionType");
      return (Criteria) this;
    }

    public Criteria andCouponDefinitionTypeGreaterThanOrEqualTo(Byte value) {
      addCriterion("coupon_definition_type >=", value, "couponDefinitionType");
      return (Criteria) this;
    }

    public Criteria andCouponDefinitionTypeLessThan(Byte value) {
      addCriterion("coupon_definition_type <", value, "couponDefinitionType");
      return (Criteria) this;
    }

    public Criteria andCouponDefinitionTypeLessThanOrEqualTo(Byte value) {
      addCriterion("coupon_definition_type <=", value, "couponDefinitionType");
      return (Criteria) this;
    }

    public Criteria andCouponDefinitionTypeIn(List<Byte> values) {
      addCriterion("coupon_definition_type in", values, "couponDefinitionType");
      return (Criteria) this;
    }

    public Criteria andCouponDefinitionTypeNotIn(List<Byte> values) {
      addCriterion("coupon_definition_type not in", values, "couponDefinitionType");
      return (Criteria) this;
    }

    public Criteria andCouponDefinitionTypeBetween(Byte value1, Byte value2) {
      addCriterion("coupon_definition_type between", value1, value2, "couponDefinitionType");
      return (Criteria) this;
    }

    public Criteria andCouponDefinitionTypeNotBetween(Byte value1, Byte value2) {
      addCriterion("coupon_definition_type not between", value1, value2, "couponDefinitionType");
      return (Criteria) this;
    }

    public Criteria andErpCouponDefinitionCodeIsNull() {
      addCriterion("erp_coupon_definition_code is null");
      return (Criteria) this;
    }

    public Criteria andErpCouponDefinitionCodeIsNotNull() {
      addCriterion("erp_coupon_definition_code is not null");
      return (Criteria) this;
    }

    public Criteria andErpCouponDefinitionCodeEqualTo(String value) {
      addCriterion("erp_coupon_definition_code =", value, "erpCouponDefinitionCode");
      return (Criteria) this;
    }

    public Criteria andErpCouponDefinitionCodeNotEqualTo(String value) {
      addCriterion("erp_coupon_definition_code <>", value, "erpCouponDefinitionCode");
      return (Criteria) this;
    }

    public Criteria andErpCouponDefinitionCodeGreaterThan(String value) {
      addCriterion("erp_coupon_definition_code >", value, "erpCouponDefinitionCode");
      return (Criteria) this;
    }

    public Criteria andErpCouponDefinitionCodeGreaterThanOrEqualTo(String value) {
      addCriterion("erp_coupon_definition_code >=", value, "erpCouponDefinitionCode");
      return (Criteria) this;
    }

    public Criteria andErpCouponDefinitionCodeLessThan(String value) {
      addCriterion("erp_coupon_definition_code <", value, "erpCouponDefinitionCode");
      return (Criteria) this;
    }

    public Criteria andErpCouponDefinitionCodeLessThanOrEqualTo(String value) {
      addCriterion("erp_coupon_definition_code <=", value, "erpCouponDefinitionCode");
      return (Criteria) this;
    }

    public Criteria andErpCouponDefinitionCodeLike(String value) {
      addCriterion("erp_coupon_definition_code like", value, "erpCouponDefinitionCode");
      return (Criteria) this;
    }

    public Criteria andErpCouponDefinitionCodeNotLike(String value) {
      addCriterion("erp_coupon_definition_code not like", value, "erpCouponDefinitionCode");
      return (Criteria) this;
    }

    public Criteria andErpCouponDefinitionCodeIn(List<String> values) {
      addCriterion("erp_coupon_definition_code in", values, "erpCouponDefinitionCode");
      return (Criteria) this;
    }

    public Criteria andErpCouponDefinitionCodeNotIn(List<String> values) {
      addCriterion("erp_coupon_definition_code not in", values, "erpCouponDefinitionCode");
      return (Criteria) this;
    }

    public Criteria andErpCouponDefinitionCodeBetween(String value1, String value2) {
      addCriterion("erp_coupon_definition_code between", value1, value2, "erpCouponDefinitionCode");
      return (Criteria) this;
    }

    public Criteria andErpCouponDefinitionCodeNotBetween(String value1, String value2) {
      addCriterion("erp_coupon_definition_code not between", value1, value2, "erpCouponDefinitionCode");
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

    public Criteria andUseChannelIsNull() {
      addCriterion("use_channel is null");
      return (Criteria) this;
    }

    public Criteria andUseChannelIsNotNull() {
      addCriterion("use_channel is not null");
      return (Criteria) this;
    }

    public Criteria andUseChannelEqualTo(Byte value) {
      addCriterion("use_channel =", value, "useChannel");
      return (Criteria) this;
    }

    public Criteria andUseChannelNotEqualTo(Byte value) {
      addCriterion("use_channel <>", value, "useChannel");
      return (Criteria) this;
    }

    public Criteria andUseChannelGreaterThan(Byte value) {
      addCriterion("use_channel >", value, "useChannel");
      return (Criteria) this;
    }

    public Criteria andUseChannelGreaterThanOrEqualTo(Byte value) {
      addCriterion("use_channel >=", value, "useChannel");
      return (Criteria) this;
    }

    public Criteria andUseChannelLessThan(Byte value) {
      addCriterion("use_channel <", value, "useChannel");
      return (Criteria) this;
    }

    public Criteria andUseChannelLessThanOrEqualTo(Byte value) {
      addCriterion("use_channel <=", value, "useChannel");
      return (Criteria) this;
    }

    public Criteria andUseChannelIn(List<Byte> values) {
      addCriterion("use_channel in", values, "useChannel");
      return (Criteria) this;
    }

    public Criteria andUseChannelNotIn(List<Byte> values) {
      addCriterion("use_channel not in", values, "useChannel");
      return (Criteria) this;
    }

    public Criteria andUseChannelBetween(Byte value1, Byte value2) {
      addCriterion("use_channel between", value1, value2, "useChannel");
      return (Criteria) this;
    }

    public Criteria andUseChannelNotBetween(Byte value1, Byte value2) {
      addCriterion("use_channel not between", value1, value2, "useChannel");
      return (Criteria) this;
    }

    public Criteria andPreferentialTypeIsNull() {
      addCriterion("preferential_type is null");
      return (Criteria) this;
    }

    public Criteria andPreferentialTypeIsNotNull() {
      addCriterion("preferential_type is not null");
      return (Criteria) this;
    }

    public Criteria andPreferentialTypeEqualTo(Byte value) {
      addCriterion("preferential_type =", value, "preferentialType");
      return (Criteria) this;
    }

    public Criteria andPreferentialTypeNotEqualTo(Byte value) {
      addCriterion("preferential_type <>", value, "preferentialType");
      return (Criteria) this;
    }

    public Criteria andPreferentialTypeGreaterThan(Byte value) {
      addCriterion("preferential_type >", value, "preferentialType");
      return (Criteria) this;
    }

    public Criteria andPreferentialTypeGreaterThanOrEqualTo(Byte value) {
      addCriterion("preferential_type >=", value, "preferentialType");
      return (Criteria) this;
    }

    public Criteria andPreferentialTypeLessThan(Byte value) {
      addCriterion("preferential_type <", value, "preferentialType");
      return (Criteria) this;
    }

    public Criteria andPreferentialTypeLessThanOrEqualTo(Byte value) {
      addCriterion("preferential_type <=", value, "preferentialType");
      return (Criteria) this;
    }

    public Criteria andPreferentialTypeIn(List<Byte> values) {
      addCriterion("preferential_type in", values, "preferentialType");
      return (Criteria) this;
    }

    public Criteria andPreferentialTypeNotIn(List<Byte> values) {
      addCriterion("preferential_type not in", values, "preferentialType");
      return (Criteria) this;
    }

    public Criteria andPreferentialTypeBetween(Byte value1, Byte value2) {
      addCriterion("preferential_type between", value1, value2, "preferentialType");
      return (Criteria) this;
    }

    public Criteria andPreferentialTypeNotBetween(Byte value1, Byte value2) {
      addCriterion("preferential_type not between", value1, value2, "preferentialType");
      return (Criteria) this;
    }

    public Criteria andMoneyIsNull() {
      addCriterion("money is null");
      return (Criteria) this;
    }

    public Criteria andMoneyIsNotNull() {
      addCriterion("money is not null");
      return (Criteria) this;
    }

    public Criteria andMoneyEqualTo(BigDecimal value) {
      addCriterion("money =", value, "money");
      return (Criteria) this;
    }

    public Criteria andMoneyNotEqualTo(BigDecimal value) {
      addCriterion("money <>", value, "money");
      return (Criteria) this;
    }

    public Criteria andMoneyGreaterThan(BigDecimal value) {
      addCriterion("money >", value, "money");
      return (Criteria) this;
    }

    public Criteria andMoneyGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("money >=", value, "money");
      return (Criteria) this;
    }

    public Criteria andMoneyLessThan(BigDecimal value) {
      addCriterion("money <", value, "money");
      return (Criteria) this;
    }

    public Criteria andMoneyLessThanOrEqualTo(BigDecimal value) {
      addCriterion("money <=", value, "money");
      return (Criteria) this;
    }

    public Criteria andMoneyIn(List<BigDecimal> values) {
      addCriterion("money in", values, "money");
      return (Criteria) this;
    }

    public Criteria andMoneyNotIn(List<BigDecimal> values) {
      addCriterion("money not in", values, "money");
      return (Criteria) this;
    }

    public Criteria andMoneyBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("money between", value1, value2, "money");
      return (Criteria) this;
    }

    public Criteria andMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("money not between", value1, value2, "money");
      return (Criteria) this;
    }

    public Criteria andDiscountIsNull() {
      addCriterion("discount is null");
      return (Criteria) this;
    }

    public Criteria andDiscountIsNotNull() {
      addCriterion("discount is not null");
      return (Criteria) this;
    }

    public Criteria andDiscountEqualTo(BigDecimal value) {
      addCriterion("discount =", value, "discount");
      return (Criteria) this;
    }

    public Criteria andDiscountNotEqualTo(BigDecimal value) {
      addCriterion("discount <>", value, "discount");
      return (Criteria) this;
    }

    public Criteria andDiscountGreaterThan(BigDecimal value) {
      addCriterion("discount >", value, "discount");
      return (Criteria) this;
    }

    public Criteria andDiscountGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("discount >=", value, "discount");
      return (Criteria) this;
    }

    public Criteria andDiscountLessThan(BigDecimal value) {
      addCriterion("discount <", value, "discount");
      return (Criteria) this;
    }

    public Criteria andDiscountLessThanOrEqualTo(BigDecimal value) {
      addCriterion("discount <=", value, "discount");
      return (Criteria) this;
    }

    public Criteria andDiscountIn(List<BigDecimal> values) {
      addCriterion("discount in", values, "discount");
      return (Criteria) this;
    }

    public Criteria andDiscountNotIn(List<BigDecimal> values) {
      addCriterion("discount not in", values, "discount");
      return (Criteria) this;
    }

    public Criteria andDiscountBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("discount between", value1, value2, "discount");
      return (Criteria) this;
    }

    public Criteria andDiscountNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("discount not between", value1, value2, "discount");
      return (Criteria) this;
    }

    public Criteria andExchangeProductIdIsNull() {
      addCriterion("exchange_product_id is null");
      return (Criteria) this;
    }

    public Criteria andExchangeProductIdIsNotNull() {
      addCriterion("exchange_product_id is not null");
      return (Criteria) this;
    }

    public Criteria andExchangeProductIdEqualTo(String value) {
      addCriterion("exchange_product_id =", value, "exchangeProductId");
      return (Criteria) this;
    }

    public Criteria andExchangeProductIdNotEqualTo(String value) {
      addCriterion("exchange_product_id <>", value, "exchangeProductId");
      return (Criteria) this;
    }

    public Criteria andExchangeProductIdGreaterThan(String value) {
      addCriterion("exchange_product_id >", value, "exchangeProductId");
      return (Criteria) this;
    }

    public Criteria andExchangeProductIdGreaterThanOrEqualTo(String value) {
      addCriterion("exchange_product_id >=", value, "exchangeProductId");
      return (Criteria) this;
    }

    public Criteria andExchangeProductIdLessThan(String value) {
      addCriterion("exchange_product_id <", value, "exchangeProductId");
      return (Criteria) this;
    }

    public Criteria andExchangeProductIdLessThanOrEqualTo(String value) {
      addCriterion("exchange_product_id <=", value, "exchangeProductId");
      return (Criteria) this;
    }

    public Criteria andExchangeProductIdLike(String value) {
      addCriterion("exchange_product_id like", value, "exchangeProductId");
      return (Criteria) this;
    }

    public Criteria andExchangeProductIdNotLike(String value) {
      addCriterion("exchange_product_id not like", value, "exchangeProductId");
      return (Criteria) this;
    }

    public Criteria andExchangeProductIdIn(List<String> values) {
      addCriterion("exchange_product_id in", values, "exchangeProductId");
      return (Criteria) this;
    }

    public Criteria andExchangeProductIdNotIn(List<String> values) {
      addCriterion("exchange_product_id not in", values, "exchangeProductId");
      return (Criteria) this;
    }

    public Criteria andExchangeProductIdBetween(String value1, String value2) {
      addCriterion("exchange_product_id between", value1, value2, "exchangeProductId");
      return (Criteria) this;
    }

    public Criteria andExchangeProductIdNotBetween(String value1, String value2) {
      addCriterion("exchange_product_id not between", value1, value2, "exchangeProductId");
      return (Criteria) this;
    }

    public Criteria andValidTypeIsNull() {
      addCriterion("valid_type is null");
      return (Criteria) this;
    }

    public Criteria andValidTypeIsNotNull() {
      addCriterion("valid_type is not null");
      return (Criteria) this;
    }

    public Criteria andValidTypeEqualTo(Byte value) {
      addCriterion("valid_type =", value, "validType");
      return (Criteria) this;
    }

    public Criteria andValidTypeNotEqualTo(Byte value) {
      addCriterion("valid_type <>", value, "validType");
      return (Criteria) this;
    }

    public Criteria andValidTypeGreaterThan(Byte value) {
      addCriterion("valid_type >", value, "validType");
      return (Criteria) this;
    }

    public Criteria andValidTypeGreaterThanOrEqualTo(Byte value) {
      addCriterion("valid_type >=", value, "validType");
      return (Criteria) this;
    }

    public Criteria andValidTypeLessThan(Byte value) {
      addCriterion("valid_type <", value, "validType");
      return (Criteria) this;
    }

    public Criteria andValidTypeLessThanOrEqualTo(Byte value) {
      addCriterion("valid_type <=", value, "validType");
      return (Criteria) this;
    }

    public Criteria andValidTypeIn(List<Byte> values) {
      addCriterion("valid_type in", values, "validType");
      return (Criteria) this;
    }

    public Criteria andValidTypeNotIn(List<Byte> values) {
      addCriterion("valid_type not in", values, "validType");
      return (Criteria) this;
    }

    public Criteria andValidTypeBetween(Byte value1, Byte value2) {
      addCriterion("valid_type between", value1, value2, "validType");
      return (Criteria) this;
    }

    public Criteria andValidTypeNotBetween(Byte value1, Byte value2) {
      addCriterion("valid_type not between", value1, value2, "validType");
      return (Criteria) this;
    }

    public Criteria andValidDateStartIsNull() {
      addCriterion("valid_date_start is null");
      return (Criteria) this;
    }

    public Criteria andValidDateStartIsNotNull() {
      addCriterion("valid_date_start is not null");
      return (Criteria) this;
    }

    public Criteria andValidDateStartEqualTo(Date value) {
      addCriterion("valid_date_start =", value, "validDateStart");
      return (Criteria) this;
    }

    public Criteria andValidDateStartNotEqualTo(Date value) {
      addCriterion("valid_date_start <>", value, "validDateStart");
      return (Criteria) this;
    }

    public Criteria andValidDateStartGreaterThan(Date value) {
      addCriterion("valid_date_start >", value, "validDateStart");
      return (Criteria) this;
    }

    public Criteria andValidDateStartGreaterThanOrEqualTo(Date value) {
      addCriterion("valid_date_start >=", value, "validDateStart");
      return (Criteria) this;
    }

    public Criteria andValidDateStartLessThan(Date value) {
      addCriterion("valid_date_start <", value, "validDateStart");
      return (Criteria) this;
    }

    public Criteria andValidDateStartLessThanOrEqualTo(Date value) {
      addCriterion("valid_date_start <=", value, "validDateStart");
      return (Criteria) this;
    }

    public Criteria andValidDateStartIn(List<Date> values) {
      addCriterion("valid_date_start in", values, "validDateStart");
      return (Criteria) this;
    }

    public Criteria andValidDateStartNotIn(List<Date> values) {
      addCriterion("valid_date_start not in", values, "validDateStart");
      return (Criteria) this;
    }

    public Criteria andValidDateStartBetween(Date value1, Date value2) {
      addCriterion("valid_date_start between", value1, value2, "validDateStart");
      return (Criteria) this;
    }

    public Criteria andValidDateStartNotBetween(Date value1, Date value2) {
      addCriterion("valid_date_start not between", value1, value2, "validDateStart");
      return (Criteria) this;
    }

    public Criteria andValidDateEndIsNull() {
      addCriterion("valid_date_end is null");
      return (Criteria) this;
    }

    public Criteria andValidDateEndIsNotNull() {
      addCriterion("valid_date_end is not null");
      return (Criteria) this;
    }

    public Criteria andValidDateEndEqualTo(Date value) {
      addCriterion("valid_date_end =", value, "validDateEnd");
      return (Criteria) this;
    }

    public Criteria andValidDateEndNotEqualTo(Date value) {
      addCriterion("valid_date_end <>", value, "validDateEnd");
      return (Criteria) this;
    }

    public Criteria andValidDateEndGreaterThan(Date value) {
      addCriterion("valid_date_end >", value, "validDateEnd");
      return (Criteria) this;
    }

    public Criteria andValidDateEndGreaterThanOrEqualTo(Date value) {
      addCriterion("valid_date_end >=", value, "validDateEnd");
      return (Criteria) this;
    }

    public Criteria andValidDateEndLessThan(Date value) {
      addCriterion("valid_date_end <", value, "validDateEnd");
      return (Criteria) this;
    }

    public Criteria andValidDateEndLessThanOrEqualTo(Date value) {
      addCriterion("valid_date_end <=", value, "validDateEnd");
      return (Criteria) this;
    }

    public Criteria andValidDateEndIn(List<Date> values) {
      addCriterion("valid_date_end in", values, "validDateEnd");
      return (Criteria) this;
    }

    public Criteria andValidDateEndNotIn(List<Date> values) {
      addCriterion("valid_date_end not in", values, "validDateEnd");
      return (Criteria) this;
    }

    public Criteria andValidDateEndBetween(Date value1, Date value2) {
      addCriterion("valid_date_end between", value1, value2, "validDateEnd");
      return (Criteria) this;
    }

    public Criteria andValidDateEndNotBetween(Date value1, Date value2) {
      addCriterion("valid_date_end not between", value1, value2, "validDateEnd");
      return (Criteria) this;
    }

    public Criteria andValidDayIsNull() {
      addCriterion("valid_day is null");
      return (Criteria) this;
    }

    public Criteria andValidDayIsNotNull() {
      addCriterion("valid_day is not null");
      return (Criteria) this;
    }

    public Criteria andValidDayEqualTo(Integer value) {
      addCriterion("valid_day =", value, "validDay");
      return (Criteria) this;
    }

    public Criteria andValidDayNotEqualTo(Integer value) {
      addCriterion("valid_day <>", value, "validDay");
      return (Criteria) this;
    }

    public Criteria andValidDayGreaterThan(Integer value) {
      addCriterion("valid_day >", value, "validDay");
      return (Criteria) this;
    }

    public Criteria andValidDayGreaterThanOrEqualTo(Integer value) {
      addCriterion("valid_day >=", value, "validDay");
      return (Criteria) this;
    }

    public Criteria andValidDayLessThan(Integer value) {
      addCriterion("valid_day <", value, "validDay");
      return (Criteria) this;
    }

    public Criteria andValidDayLessThanOrEqualTo(Integer value) {
      addCriterion("valid_day <=", value, "validDay");
      return (Criteria) this;
    }

    public Criteria andValidDayIn(List<Integer> values) {
      addCriterion("valid_day in", values, "validDay");
      return (Criteria) this;
    }

    public Criteria andValidDayNotIn(List<Integer> values) {
      addCriterion("valid_day not in", values, "validDay");
      return (Criteria) this;
    }

    public Criteria andValidDayBetween(Integer value1, Integer value2) {
      addCriterion("valid_day between", value1, value2, "validDay");
      return (Criteria) this;
    }

    public Criteria andValidDayNotBetween(Integer value1, Integer value2) {
      addCriterion("valid_day not between", value1, value2, "validDay");
      return (Criteria) this;
    }

    public Criteria andQrCodeIsNull() {
      addCriterion("qr_code is null");
      return (Criteria) this;
    }

    public Criteria andQrCodeIsNotNull() {
      addCriterion("qr_code is not null");
      return (Criteria) this;
    }

    public Criteria andQrCodeEqualTo(String value) {
      addCriterion("qr_code =", value, "qrCode");
      return (Criteria) this;
    }

    public Criteria andQrCodeNotEqualTo(String value) {
      addCriterion("qr_code <>", value, "qrCode");
      return (Criteria) this;
    }

    public Criteria andQrCodeGreaterThan(String value) {
      addCriterion("qr_code >", value, "qrCode");
      return (Criteria) this;
    }

    public Criteria andQrCodeGreaterThanOrEqualTo(String value) {
      addCriterion("qr_code >=", value, "qrCode");
      return (Criteria) this;
    }

    public Criteria andQrCodeLessThan(String value) {
      addCriterion("qr_code <", value, "qrCode");
      return (Criteria) this;
    }

    public Criteria andQrCodeLessThanOrEqualTo(String value) {
      addCriterion("qr_code <=", value, "qrCode");
      return (Criteria) this;
    }

    public Criteria andQrCodeLike(String value) {
      addCriterion("qr_code like", value, "qrCode");
      return (Criteria) this;
    }

    public Criteria andQrCodeNotLike(String value) {
      addCriterion("qr_code not like", value, "qrCode");
      return (Criteria) this;
    }

    public Criteria andQrCodeIn(List<String> values) {
      addCriterion("qr_code in", values, "qrCode");
      return (Criteria) this;
    }

    public Criteria andQrCodeNotIn(List<String> values) {
      addCriterion("qr_code not in", values, "qrCode");
      return (Criteria) this;
    }

    public Criteria andQrCodeBetween(String value1, String value2) {
      addCriterion("qr_code between", value1, value2, "qrCode");
      return (Criteria) this;
    }

    public Criteria andQrCodeNotBetween(String value1, String value2) {
      addCriterion("qr_code not between", value1, value2, "qrCode");
      return (Criteria) this;
    }

    public Criteria andImgIsNull() {
      addCriterion("img is null");
      return (Criteria) this;
    }

    public Criteria andImgIsNotNull() {
      addCriterion("img is not null");
      return (Criteria) this;
    }

    public Criteria andImgEqualTo(String value) {
      addCriterion("img =", value, "img");
      return (Criteria) this;
    }

    public Criteria andImgNotEqualTo(String value) {
      addCriterion("img <>", value, "img");
      return (Criteria) this;
    }

    public Criteria andImgGreaterThan(String value) {
      addCriterion("img >", value, "img");
      return (Criteria) this;
    }

    public Criteria andImgGreaterThanOrEqualTo(String value) {
      addCriterion("img >=", value, "img");
      return (Criteria) this;
    }

    public Criteria andImgLessThan(String value) {
      addCriterion("img <", value, "img");
      return (Criteria) this;
    }

    public Criteria andImgLessThanOrEqualTo(String value) {
      addCriterion("img <=", value, "img");
      return (Criteria) this;
    }

    public Criteria andImgLike(String value) {
      addCriterion("img like", value, "img");
      return (Criteria) this;
    }

    public Criteria andImgNotLike(String value) {
      addCriterion("img not like", value, "img");
      return (Criteria) this;
    }

    public Criteria andImgIn(List<String> values) {
      addCriterion("img in", values, "img");
      return (Criteria) this;
    }

    public Criteria andImgNotIn(List<String> values) {
      addCriterion("img not in", values, "img");
      return (Criteria) this;
    }

    public Criteria andImgBetween(String value1, String value2) {
      addCriterion("img between", value1, value2, "img");
      return (Criteria) this;
    }

    public Criteria andImgNotBetween(String value1, String value2) {
      addCriterion("img not between", value1, value2, "img");
      return (Criteria) this;
    }

    public Criteria andPerMaxNumIsNull() {
      addCriterion("per_max_num is null");
      return (Criteria) this;
    }

    public Criteria andPerMaxNumIsNotNull() {
      addCriterion("per_max_num is not null");
      return (Criteria) this;
    }

    public Criteria andPerMaxNumEqualTo(Integer value) {
      addCriterion("per_max_num =", value, "perMaxNum");
      return (Criteria) this;
    }

    public Criteria andPerMaxNumNotEqualTo(Integer value) {
      addCriterion("per_max_num <>", value, "perMaxNum");
      return (Criteria) this;
    }

    public Criteria andPerMaxNumGreaterThan(Integer value) {
      addCriterion("per_max_num >", value, "perMaxNum");
      return (Criteria) this;
    }

    public Criteria andPerMaxNumGreaterThanOrEqualTo(Integer value) {
      addCriterion("per_max_num >=", value, "perMaxNum");
      return (Criteria) this;
    }

    public Criteria andPerMaxNumLessThan(Integer value) {
      addCriterion("per_max_num <", value, "perMaxNum");
      return (Criteria) this;
    }

    public Criteria andPerMaxNumLessThanOrEqualTo(Integer value) {
      addCriterion("per_max_num <=", value, "perMaxNum");
      return (Criteria) this;
    }

    public Criteria andPerMaxNumIn(List<Integer> values) {
      addCriterion("per_max_num in", values, "perMaxNum");
      return (Criteria) this;
    }

    public Criteria andPerMaxNumNotIn(List<Integer> values) {
      addCriterion("per_max_num not in", values, "perMaxNum");
      return (Criteria) this;
    }

    public Criteria andPerMaxNumBetween(Integer value1, Integer value2) {
      addCriterion("per_max_num between", value1, value2, "perMaxNum");
      return (Criteria) this;
    }

    public Criteria andPerMaxNumNotBetween(Integer value1, Integer value2) {
      addCriterion("per_max_num not between", value1, value2, "perMaxNum");
      return (Criteria) this;
    }

    public Criteria andIsRealNameIsNull() {
      addCriterion("is_real_name is null");
      return (Criteria) this;
    }

    public Criteria andIsRealNameIsNotNull() {
      addCriterion("is_real_name is not null");
      return (Criteria) this;
    }

    public Criteria andIsRealNameEqualTo(Boolean value) {
      addCriterion("is_real_name =", value, "isRealName");
      return (Criteria) this;
    }

    public Criteria andIsRealNameNotEqualTo(Boolean value) {
      addCriterion("is_real_name <>", value, "isRealName");
      return (Criteria) this;
    }

    public Criteria andIsRealNameGreaterThan(Boolean value) {
      addCriterion("is_real_name >", value, "isRealName");
      return (Criteria) this;
    }

    public Criteria andIsRealNameGreaterThanOrEqualTo(Boolean value) {
      addCriterion("is_real_name >=", value, "isRealName");
      return (Criteria) this;
    }

    public Criteria andIsRealNameLessThan(Boolean value) {
      addCriterion("is_real_name <", value, "isRealName");
      return (Criteria) this;
    }

    public Criteria andIsRealNameLessThanOrEqualTo(Boolean value) {
      addCriterion("is_real_name <=", value, "isRealName");
      return (Criteria) this;
    }

    public Criteria andIsRealNameIn(List<Boolean> values) {
      addCriterion("is_real_name in", values, "isRealName");
      return (Criteria) this;
    }

    public Criteria andIsRealNameNotIn(List<Boolean> values) {
      addCriterion("is_real_name not in", values, "isRealName");
      return (Criteria) this;
    }

    public Criteria andIsRealNameBetween(Boolean value1, Boolean value2) {
      addCriterion("is_real_name between", value1, value2, "isRealName");
      return (Criteria) this;
    }

    public Criteria andIsRealNameNotBetween(Boolean value1, Boolean value2) {
      addCriterion("is_real_name not between", value1, value2, "isRealName");
      return (Criteria) this;
    }

    public Criteria andIsTransferIsNull() {
      addCriterion("is_transfer is null");
      return (Criteria) this;
    }

    public Criteria andIsTransferIsNotNull() {
      addCriterion("is_transfer is not null");
      return (Criteria) this;
    }

    public Criteria andIsTransferEqualTo(Boolean value) {
      addCriterion("is_transfer =", value, "isTransfer");
      return (Criteria) this;
    }

    public Criteria andIsTransferNotEqualTo(Boolean value) {
      addCriterion("is_transfer <>", value, "isTransfer");
      return (Criteria) this;
    }

    public Criteria andIsTransferGreaterThan(Boolean value) {
      addCriterion("is_transfer >", value, "isTransfer");
      return (Criteria) this;
    }

    public Criteria andIsTransferGreaterThanOrEqualTo(Boolean value) {
      addCriterion("is_transfer >=", value, "isTransfer");
      return (Criteria) this;
    }

    public Criteria andIsTransferLessThan(Boolean value) {
      addCriterion("is_transfer <", value, "isTransfer");
      return (Criteria) this;
    }

    public Criteria andIsTransferLessThanOrEqualTo(Boolean value) {
      addCriterion("is_transfer <=", value, "isTransfer");
      return (Criteria) this;
    }

    public Criteria andIsTransferIn(List<Boolean> values) {
      addCriterion("is_transfer in", values, "isTransfer");
      return (Criteria) this;
    }

    public Criteria andIsTransferNotIn(List<Boolean> values) {
      addCriterion("is_transfer not in", values, "isTransfer");
      return (Criteria) this;
    }

    public Criteria andIsTransferBetween(Boolean value1, Boolean value2) {
      addCriterion("is_transfer between", value1, value2, "isTransfer");
      return (Criteria) this;
    }

    public Criteria andIsTransferNotBetween(Boolean value1, Boolean value2) {
      addCriterion("is_transfer not between", value1, value2, "isTransfer");
      return (Criteria) this;
    }

    public Criteria andActivitySuperpositionTypeIsNull() {
      addCriterion("activity_superposition_type is null");
      return (Criteria) this;
    }

    public Criteria andActivitySuperpositionTypeIsNotNull() {
      addCriterion("activity_superposition_type is not null");
      return (Criteria) this;
    }

    public Criteria andActivitySuperpositionTypeEqualTo(Byte value) {
      addCriterion("activity_superposition_type =", value, "activitySuperpositionType");
      return (Criteria) this;
    }

    public Criteria andActivitySuperpositionTypeNotEqualTo(Byte value) {
      addCriterion("activity_superposition_type <>", value, "activitySuperpositionType");
      return (Criteria) this;
    }

    public Criteria andActivitySuperpositionTypeGreaterThan(Byte value) {
      addCriterion("activity_superposition_type >", value, "activitySuperpositionType");
      return (Criteria) this;
    }

    public Criteria andActivitySuperpositionTypeGreaterThanOrEqualTo(Byte value) {
      addCriterion("activity_superposition_type >=", value, "activitySuperpositionType");
      return (Criteria) this;
    }

    public Criteria andActivitySuperpositionTypeLessThan(Byte value) {
      addCriterion("activity_superposition_type <", value, "activitySuperpositionType");
      return (Criteria) this;
    }

    public Criteria andActivitySuperpositionTypeLessThanOrEqualTo(Byte value) {
      addCriterion("activity_superposition_type <=", value, "activitySuperpositionType");
      return (Criteria) this;
    }

    public Criteria andActivitySuperpositionTypeIn(List<Byte> values) {
      addCriterion("activity_superposition_type in", values, "activitySuperpositionType");
      return (Criteria) this;
    }

    public Criteria andActivitySuperpositionTypeNotIn(List<Byte> values) {
      addCriterion("activity_superposition_type not in", values, "activitySuperpositionType");
      return (Criteria) this;
    }

    public Criteria andActivitySuperpositionTypeBetween(Byte value1, Byte value2) {
      addCriterion("activity_superposition_type between", value1, value2, "activitySuperpositionType");
      return (Criteria) this;
    }

    public Criteria andActivitySuperpositionTypeNotBetween(Byte value1, Byte value2) {
      addCriterion("activity_superposition_type not between", value1, value2, "activitySuperpositionType");
      return (Criteria) this;
    }

    public Criteria andActivitySuperpositionWhiteListIsNull() {
      addCriterion("activity_superposition_white_list is null");
      return (Criteria) this;
    }

    public Criteria andActivitySuperpositionWhiteListIsNotNull() {
      addCriterion("activity_superposition_white_list is not null");
      return (Criteria) this;
    }

    public Criteria andActivitySuperpositionWhiteListEqualTo(String value) {
      addCriterion("activity_superposition_white_list =", value, "activitySuperpositionWhiteList");
      return (Criteria) this;
    }

    public Criteria andActivitySuperpositionWhiteListNotEqualTo(String value) {
      addCriterion("activity_superposition_white_list <>", value, "activitySuperpositionWhiteList");
      return (Criteria) this;
    }

    public Criteria andActivitySuperpositionWhiteListGreaterThan(String value) {
      addCriterion("activity_superposition_white_list >", value, "activitySuperpositionWhiteList");
      return (Criteria) this;
    }

    public Criteria andActivitySuperpositionWhiteListGreaterThanOrEqualTo(String value) {
      addCriterion("activity_superposition_white_list >=", value, "activitySuperpositionWhiteList");
      return (Criteria) this;
    }

    public Criteria andActivitySuperpositionWhiteListLessThan(String value) {
      addCriterion("activity_superposition_white_list <", value, "activitySuperpositionWhiteList");
      return (Criteria) this;
    }

    public Criteria andActivitySuperpositionWhiteListLessThanOrEqualTo(String value) {
      addCriterion("activity_superposition_white_list <=", value, "activitySuperpositionWhiteList");
      return (Criteria) this;
    }

    public Criteria andActivitySuperpositionWhiteListLike(String value) {
      addCriterion("activity_superposition_white_list like", value, "activitySuperpositionWhiteList");
      return (Criteria) this;
    }

    public Criteria andActivitySuperpositionWhiteListNotLike(String value) {
      addCriterion("activity_superposition_white_list not like", value, "activitySuperpositionWhiteList");
      return (Criteria) this;
    }

    public Criteria andActivitySuperpositionWhiteListIn(List<String> values) {
      addCriterion("activity_superposition_white_list in", values, "activitySuperpositionWhiteList");
      return (Criteria) this;
    }

    public Criteria andActivitySuperpositionWhiteListNotIn(List<String> values) {
      addCriterion("activity_superposition_white_list not in", values, "activitySuperpositionWhiteList");
      return (Criteria) this;
    }

    public Criteria andActivitySuperpositionWhiteListBetween(String value1, String value2) {
      addCriterion("activity_superposition_white_list between", value1, value2, "activitySuperpositionWhiteList");
      return (Criteria) this;
    }

    public Criteria andActivitySuperpositionWhiteListNotBetween(String value1, String value2) {
      addCriterion("activity_superposition_white_list not between", value1, value2, "activitySuperpositionWhiteList");
      return (Criteria) this;
    }

    public Criteria andActivitySuperpositionBlackListIsNull() {
      addCriterion("activity_superposition_black_list is null");
      return (Criteria) this;
    }

    public Criteria andActivitySuperpositionBlackListIsNotNull() {
      addCriterion("activity_superposition_black_list is not null");
      return (Criteria) this;
    }

    public Criteria andActivitySuperpositionBlackListEqualTo(String value) {
      addCriterion("activity_superposition_black_list =", value, "activitySuperpositionBlackList");
      return (Criteria) this;
    }

    public Criteria andActivitySuperpositionBlackListNotEqualTo(String value) {
      addCriterion("activity_superposition_black_list <>", value, "activitySuperpositionBlackList");
      return (Criteria) this;
    }

    public Criteria andActivitySuperpositionBlackListGreaterThan(String value) {
      addCriterion("activity_superposition_black_list >", value, "activitySuperpositionBlackList");
      return (Criteria) this;
    }

    public Criteria andActivitySuperpositionBlackListGreaterThanOrEqualTo(String value) {
      addCriterion("activity_superposition_black_list >=", value, "activitySuperpositionBlackList");
      return (Criteria) this;
    }

    public Criteria andActivitySuperpositionBlackListLessThan(String value) {
      addCriterion("activity_superposition_black_list <", value, "activitySuperpositionBlackList");
      return (Criteria) this;
    }

    public Criteria andActivitySuperpositionBlackListLessThanOrEqualTo(String value) {
      addCriterion("activity_superposition_black_list <=", value, "activitySuperpositionBlackList");
      return (Criteria) this;
    }

    public Criteria andActivitySuperpositionBlackListLike(String value) {
      addCriterion("activity_superposition_black_list like", value, "activitySuperpositionBlackList");
      return (Criteria) this;
    }

    public Criteria andActivitySuperpositionBlackListNotLike(String value) {
      addCriterion("activity_superposition_black_list not like", value, "activitySuperpositionBlackList");
      return (Criteria) this;
    }

    public Criteria andActivitySuperpositionBlackListIn(List<String> values) {
      addCriterion("activity_superposition_black_list in", values, "activitySuperpositionBlackList");
      return (Criteria) this;
    }

    public Criteria andActivitySuperpositionBlackListNotIn(List<String> values) {
      addCriterion("activity_superposition_black_list not in", values, "activitySuperpositionBlackList");
      return (Criteria) this;
    }

    public Criteria andActivitySuperpositionBlackListBetween(String value1, String value2) {
      addCriterion("activity_superposition_black_list between", value1, value2, "activitySuperpositionBlackList");
      return (Criteria) this;
    }

    public Criteria andActivitySuperpositionBlackListNotBetween(String value1, String value2) {
      addCriterion("activity_superposition_black_list not between", value1, value2, "activitySuperpositionBlackList");
      return (Criteria) this;
    }

    public Criteria andIsSuperpositionIsNull() {
      addCriterion("is_superposition is null");
      return (Criteria) this;
    }

    public Criteria andIsSuperpositionIsNotNull() {
      addCriterion("is_superposition is not null");
      return (Criteria) this;
    }

    public Criteria andIsSuperpositionEqualTo(Boolean value) {
      addCriterion("is_superposition =", value, "isSuperposition");
      return (Criteria) this;
    }

    public Criteria andIsSuperpositionNotEqualTo(Boolean value) {
      addCriterion("is_superposition <>", value, "isSuperposition");
      return (Criteria) this;
    }

    public Criteria andIsSuperpositionGreaterThan(Boolean value) {
      addCriterion("is_superposition >", value, "isSuperposition");
      return (Criteria) this;
    }

    public Criteria andIsSuperpositionGreaterThanOrEqualTo(Boolean value) {
      addCriterion("is_superposition >=", value, "isSuperposition");
      return (Criteria) this;
    }

    public Criteria andIsSuperpositionLessThan(Boolean value) {
      addCriterion("is_superposition <", value, "isSuperposition");
      return (Criteria) this;
    }

    public Criteria andIsSuperpositionLessThanOrEqualTo(Boolean value) {
      addCriterion("is_superposition <=", value, "isSuperposition");
      return (Criteria) this;
    }

    public Criteria andIsSuperpositionIn(List<Boolean> values) {
      addCriterion("is_superposition in", values, "isSuperposition");
      return (Criteria) this;
    }

    public Criteria andIsSuperpositionNotIn(List<Boolean> values) {
      addCriterion("is_superposition not in", values, "isSuperposition");
      return (Criteria) this;
    }

    public Criteria andIsSuperpositionBetween(Boolean value1, Boolean value2) {
      addCriterion("is_superposition between", value1, value2, "isSuperposition");
      return (Criteria) this;
    }

    public Criteria andIsSuperpositionNotBetween(Boolean value1, Boolean value2) {
      addCriterion("is_superposition not between", value1, value2, "isSuperposition");
      return (Criteria) this;
    }

    public Criteria andIsTagPriceLimitIsNull() {
      addCriterion("is_tag_price_limit is null");
      return (Criteria) this;
    }

    public Criteria andIsTagPriceLimitIsNotNull() {
      addCriterion("is_tag_price_limit is not null");
      return (Criteria) this;
    }

    public Criteria andIsTagPriceLimitEqualTo(Boolean value) {
      addCriterion("is_tag_price_limit =", value, "isTagPriceLimit");
      return (Criteria) this;
    }

    public Criteria andIsTagPriceLimitNotEqualTo(Boolean value) {
      addCriterion("is_tag_price_limit <>", value, "isTagPriceLimit");
      return (Criteria) this;
    }

    public Criteria andIsTagPriceLimitGreaterThan(Boolean value) {
      addCriterion("is_tag_price_limit >", value, "isTagPriceLimit");
      return (Criteria) this;
    }

    public Criteria andIsTagPriceLimitGreaterThanOrEqualTo(Boolean value) {
      addCriterion("is_tag_price_limit >=", value, "isTagPriceLimit");
      return (Criteria) this;
    }

    public Criteria andIsTagPriceLimitLessThan(Boolean value) {
      addCriterion("is_tag_price_limit <", value, "isTagPriceLimit");
      return (Criteria) this;
    }

    public Criteria andIsTagPriceLimitLessThanOrEqualTo(Boolean value) {
      addCriterion("is_tag_price_limit <=", value, "isTagPriceLimit");
      return (Criteria) this;
    }

    public Criteria andIsTagPriceLimitIn(List<Boolean> values) {
      addCriterion("is_tag_price_limit in", values, "isTagPriceLimit");
      return (Criteria) this;
    }

    public Criteria andIsTagPriceLimitNotIn(List<Boolean> values) {
      addCriterion("is_tag_price_limit not in", values, "isTagPriceLimit");
      return (Criteria) this;
    }

    public Criteria andIsTagPriceLimitBetween(Boolean value1, Boolean value2) {
      addCriterion("is_tag_price_limit between", value1, value2, "isTagPriceLimit");
      return (Criteria) this;
    }

    public Criteria andIsTagPriceLimitNotBetween(Boolean value1, Boolean value2) {
      addCriterion("is_tag_price_limit not between", value1, value2, "isTagPriceLimit");
      return (Criteria) this;
    }

    public Criteria andTagPriceMaxPreferentialLimitIsNull() {
      addCriterion("tag_price_max_preferential_limit is null");
      return (Criteria) this;
    }

    public Criteria andTagPriceMaxPreferentialLimitIsNotNull() {
      addCriterion("tag_price_max_preferential_limit is not null");
      return (Criteria) this;
    }

    public Criteria andTagPriceMaxPreferentialLimitEqualTo(BigDecimal value) {
      addCriterion("tag_price_max_preferential_limit =", value, "tagPriceMaxPreferentialLimit");
      return (Criteria) this;
    }

    public Criteria andTagPriceMaxPreferentialLimitNotEqualTo(BigDecimal value) {
      addCriterion("tag_price_max_preferential_limit <>", value, "tagPriceMaxPreferentialLimit");
      return (Criteria) this;
    }

    public Criteria andTagPriceMaxPreferentialLimitGreaterThan(BigDecimal value) {
      addCriterion("tag_price_max_preferential_limit >", value, "tagPriceMaxPreferentialLimit");
      return (Criteria) this;
    }

    public Criteria andTagPriceMaxPreferentialLimitGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("tag_price_max_preferential_limit >=", value, "tagPriceMaxPreferentialLimit");
      return (Criteria) this;
    }

    public Criteria andTagPriceMaxPreferentialLimitLessThan(BigDecimal value) {
      addCriterion("tag_price_max_preferential_limit <", value, "tagPriceMaxPreferentialLimit");
      return (Criteria) this;
    }

    public Criteria andTagPriceMaxPreferentialLimitLessThanOrEqualTo(BigDecimal value) {
      addCriterion("tag_price_max_preferential_limit <=", value, "tagPriceMaxPreferentialLimit");
      return (Criteria) this;
    }

    public Criteria andTagPriceMaxPreferentialLimitIn(List<BigDecimal> values) {
      addCriterion("tag_price_max_preferential_limit in", values, "tagPriceMaxPreferentialLimit");
      return (Criteria) this;
    }

    public Criteria andTagPriceMaxPreferentialLimitNotIn(List<BigDecimal> values) {
      addCriterion("tag_price_max_preferential_limit not in", values, "tagPriceMaxPreferentialLimit");
      return (Criteria) this;
    }

    public Criteria andTagPriceMaxPreferentialLimitBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("tag_price_max_preferential_limit between", value1, value2, "tagPriceMaxPreferentialLimit");
      return (Criteria) this;
    }

    public Criteria andTagPriceMaxPreferentialLimitNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("tag_price_max_preferential_limit not between", value1, value2, "tagPriceMaxPreferentialLimit");
      return (Criteria) this;
    }

    public Criteria andMinConsumeIsNull() {
      addCriterion("min_consume is null");
      return (Criteria) this;
    }

    public Criteria andMinConsumeIsNotNull() {
      addCriterion("min_consume is not null");
      return (Criteria) this;
    }

    public Criteria andMinConsumeEqualTo(BigDecimal value) {
      addCriterion("min_consume =", value, "minConsume");
      return (Criteria) this;
    }

    public Criteria andMinConsumeNotEqualTo(BigDecimal value) {
      addCriterion("min_consume <>", value, "minConsume");
      return (Criteria) this;
    }

    public Criteria andMinConsumeGreaterThan(BigDecimal value) {
      addCriterion("min_consume >", value, "minConsume");
      return (Criteria) this;
    }

    public Criteria andMinConsumeGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("min_consume >=", value, "minConsume");
      return (Criteria) this;
    }

    public Criteria andMinConsumeLessThan(BigDecimal value) {
      addCriterion("min_consume <", value, "minConsume");
      return (Criteria) this;
    }

    public Criteria andMinConsumeLessThanOrEqualTo(BigDecimal value) {
      addCriterion("min_consume <=", value, "minConsume");
      return (Criteria) this;
    }

    public Criteria andMinConsumeIn(List<BigDecimal> values) {
      addCriterion("min_consume in", values, "minConsume");
      return (Criteria) this;
    }

    public Criteria andMinConsumeNotIn(List<BigDecimal> values) {
      addCriterion("min_consume not in", values, "minConsume");
      return (Criteria) this;
    }

    public Criteria andMinConsumeBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("min_consume between", value1, value2, "minConsume");
      return (Criteria) this;
    }

    public Criteria andMinConsumeNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("min_consume not between", value1, value2, "minConsume");
      return (Criteria) this;
    }

    public Criteria andMaxPreferentialIsNull() {
      addCriterion("max_preferential is null");
      return (Criteria) this;
    }

    public Criteria andMaxPreferentialIsNotNull() {
      addCriterion("max_preferential is not null");
      return (Criteria) this;
    }

    public Criteria andMaxPreferentialEqualTo(BigDecimal value) {
      addCriterion("max_preferential =", value, "maxPreferential");
      return (Criteria) this;
    }

    public Criteria andMaxPreferentialNotEqualTo(BigDecimal value) {
      addCriterion("max_preferential <>", value, "maxPreferential");
      return (Criteria) this;
    }

    public Criteria andMaxPreferentialGreaterThan(BigDecimal value) {
      addCriterion("max_preferential >", value, "maxPreferential");
      return (Criteria) this;
    }

    public Criteria andMaxPreferentialGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("max_preferential >=", value, "maxPreferential");
      return (Criteria) this;
    }

    public Criteria andMaxPreferentialLessThan(BigDecimal value) {
      addCriterion("max_preferential <", value, "maxPreferential");
      return (Criteria) this;
    }

    public Criteria andMaxPreferentialLessThanOrEqualTo(BigDecimal value) {
      addCriterion("max_preferential <=", value, "maxPreferential");
      return (Criteria) this;
    }

    public Criteria andMaxPreferentialIn(List<BigDecimal> values) {
      addCriterion("max_preferential in", values, "maxPreferential");
      return (Criteria) this;
    }

    public Criteria andMaxPreferentialNotIn(List<BigDecimal> values) {
      addCriterion("max_preferential not in", values, "maxPreferential");
      return (Criteria) this;
    }

    public Criteria andMaxPreferentialBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("max_preferential between", value1, value2, "maxPreferential");
      return (Criteria) this;
    }

    public Criteria andMaxPreferentialNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("max_preferential not between", value1, value2, "maxPreferential");
      return (Criteria) this;
    }

    public Criteria andMinCommodityNumIsNull() {
      addCriterion("min_commodity_num is null");
      return (Criteria) this;
    }

    public Criteria andMinCommodityNumIsNotNull() {
      addCriterion("min_commodity_num is not null");
      return (Criteria) this;
    }

    public Criteria andMinCommodityNumEqualTo(Integer value) {
      addCriterion("min_commodity_num =", value, "minCommodityNum");
      return (Criteria) this;
    }

    public Criteria andMinCommodityNumNotEqualTo(Integer value) {
      addCriterion("min_commodity_num <>", value, "minCommodityNum");
      return (Criteria) this;
    }

    public Criteria andMinCommodityNumGreaterThan(Integer value) {
      addCriterion("min_commodity_num >", value, "minCommodityNum");
      return (Criteria) this;
    }

    public Criteria andMinCommodityNumGreaterThanOrEqualTo(Integer value) {
      addCriterion("min_commodity_num >=", value, "minCommodityNum");
      return (Criteria) this;
    }

    public Criteria andMinCommodityNumLessThan(Integer value) {
      addCriterion("min_commodity_num <", value, "minCommodityNum");
      return (Criteria) this;
    }

    public Criteria andMinCommodityNumLessThanOrEqualTo(Integer value) {
      addCriterion("min_commodity_num <=", value, "minCommodityNum");
      return (Criteria) this;
    }

    public Criteria andMinCommodityNumIn(List<Integer> values) {
      addCriterion("min_commodity_num in", values, "minCommodityNum");
      return (Criteria) this;
    }

    public Criteria andMinCommodityNumNotIn(List<Integer> values) {
      addCriterion("min_commodity_num not in", values, "minCommodityNum");
      return (Criteria) this;
    }

    public Criteria andMinCommodityNumBetween(Integer value1, Integer value2) {
      addCriterion("min_commodity_num between", value1, value2, "minCommodityNum");
      return (Criteria) this;
    }

    public Criteria andMinCommodityNumNotBetween(Integer value1, Integer value2) {
      addCriterion("min_commodity_num not between", value1, value2, "minCommodityNum");
      return (Criteria) this;
    }

    public Criteria andMaxCommodityNumIsNull() {
      addCriterion("max_commodity_num is null");
      return (Criteria) this;
    }

    public Criteria andMaxCommodityNumIsNotNull() {
      addCriterion("max_commodity_num is not null");
      return (Criteria) this;
    }

    public Criteria andMaxCommodityNumEqualTo(Integer value) {
      addCriterion("max_commodity_num =", value, "maxCommodityNum");
      return (Criteria) this;
    }

    public Criteria andMaxCommodityNumNotEqualTo(Integer value) {
      addCriterion("max_commodity_num <>", value, "maxCommodityNum");
      return (Criteria) this;
    }

    public Criteria andMaxCommodityNumGreaterThan(Integer value) {
      addCriterion("max_commodity_num >", value, "maxCommodityNum");
      return (Criteria) this;
    }

    public Criteria andMaxCommodityNumGreaterThanOrEqualTo(Integer value) {
      addCriterion("max_commodity_num >=", value, "maxCommodityNum");
      return (Criteria) this;
    }

    public Criteria andMaxCommodityNumLessThan(Integer value) {
      addCriterion("max_commodity_num <", value, "maxCommodityNum");
      return (Criteria) this;
    }

    public Criteria andMaxCommodityNumLessThanOrEqualTo(Integer value) {
      addCriterion("max_commodity_num <=", value, "maxCommodityNum");
      return (Criteria) this;
    }

    public Criteria andMaxCommodityNumIn(List<Integer> values) {
      addCriterion("max_commodity_num in", values, "maxCommodityNum");
      return (Criteria) this;
    }

    public Criteria andMaxCommodityNumNotIn(List<Integer> values) {
      addCriterion("max_commodity_num not in", values, "maxCommodityNum");
      return (Criteria) this;
    }

    public Criteria andMaxCommodityNumBetween(Integer value1, Integer value2) {
      addCriterion("max_commodity_num between", value1, value2, "maxCommodityNum");
      return (Criteria) this;
    }

    public Criteria andMaxCommodityNumNotBetween(Integer value1, Integer value2) {
      addCriterion("max_commodity_num not between", value1, value2, "maxCommodityNum");
      return (Criteria) this;
    }

    public Criteria andMinDiscountIsNull() {
      addCriterion("min_discount is null");
      return (Criteria) this;
    }

    public Criteria andMinDiscountIsNotNull() {
      addCriterion("min_discount is not null");
      return (Criteria) this;
    }

    public Criteria andMinDiscountEqualTo(BigDecimal value) {
      addCriterion("min_discount =", value, "minDiscount");
      return (Criteria) this;
    }

    public Criteria andMinDiscountNotEqualTo(BigDecimal value) {
      addCriterion("min_discount <>", value, "minDiscount");
      return (Criteria) this;
    }

    public Criteria andMinDiscountGreaterThan(BigDecimal value) {
      addCriterion("min_discount >", value, "minDiscount");
      return (Criteria) this;
    }

    public Criteria andMinDiscountGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("min_discount >=", value, "minDiscount");
      return (Criteria) this;
    }

    public Criteria andMinDiscountLessThan(BigDecimal value) {
      addCriterion("min_discount <", value, "minDiscount");
      return (Criteria) this;
    }

    public Criteria andMinDiscountLessThanOrEqualTo(BigDecimal value) {
      addCriterion("min_discount <=", value, "minDiscount");
      return (Criteria) this;
    }

    public Criteria andMinDiscountIn(List<BigDecimal> values) {
      addCriterion("min_discount in", values, "minDiscount");
      return (Criteria) this;
    }

    public Criteria andMinDiscountNotIn(List<BigDecimal> values) {
      addCriterion("min_discount not in", values, "minDiscount");
      return (Criteria) this;
    }

    public Criteria andMinDiscountBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("min_discount between", value1, value2, "minDiscount");
      return (Criteria) this;
    }

    public Criteria andMinDiscountNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("min_discount not between", value1, value2, "minDiscount");
      return (Criteria) this;
    }

    public Criteria andApplianceCommodityTypeIsNull() {
      addCriterion("appliance_commodity_type is null");
      return (Criteria) this;
    }

    public Criteria andApplianceCommodityTypeIsNotNull() {
      addCriterion("appliance_commodity_type is not null");
      return (Criteria) this;
    }

    public Criteria andApplianceCommodityTypeEqualTo(Byte value) {
      addCriterion("appliance_commodity_type =", value, "applianceCommodityType");
      return (Criteria) this;
    }

    public Criteria andApplianceCommodityTypeNotEqualTo(Byte value) {
      addCriterion("appliance_commodity_type <>", value, "applianceCommodityType");
      return (Criteria) this;
    }

    public Criteria andApplianceCommodityTypeGreaterThan(Byte value) {
      addCriterion("appliance_commodity_type >", value, "applianceCommodityType");
      return (Criteria) this;
    }

    public Criteria andApplianceCommodityTypeGreaterThanOrEqualTo(Byte value) {
      addCriterion("appliance_commodity_type >=", value, "applianceCommodityType");
      return (Criteria) this;
    }

    public Criteria andApplianceCommodityTypeLessThan(Byte value) {
      addCriterion("appliance_commodity_type <", value, "applianceCommodityType");
      return (Criteria) this;
    }

    public Criteria andApplianceCommodityTypeLessThanOrEqualTo(Byte value) {
      addCriterion("appliance_commodity_type <=", value, "applianceCommodityType");
      return (Criteria) this;
    }

    public Criteria andApplianceCommodityTypeIn(List<Byte> values) {
      addCriterion("appliance_commodity_type in", values, "applianceCommodityType");
      return (Criteria) this;
    }

    public Criteria andApplianceCommodityTypeNotIn(List<Byte> values) {
      addCriterion("appliance_commodity_type not in", values, "applianceCommodityType");
      return (Criteria) this;
    }

    public Criteria andApplianceCommodityTypeBetween(Byte value1, Byte value2) {
      addCriterion("appliance_commodity_type between", value1, value2, "applianceCommodityType");
      return (Criteria) this;
    }

    public Criteria andApplianceCommodityTypeNotBetween(Byte value1, Byte value2) {
      addCriterion("appliance_commodity_type not between", value1, value2, "applianceCommodityType");
      return (Criteria) this;
    }

    public Criteria andApplianceStoreTypeIsNull() {
      addCriterion("appliance_store_type is null");
      return (Criteria) this;
    }

    public Criteria andApplianceStoreTypeIsNotNull() {
      addCriterion("appliance_store_type is not null");
      return (Criteria) this;
    }

    public Criteria andApplianceStoreTypeEqualTo(Byte value) {
      addCriterion("appliance_store_type =", value, "applianceStoreType");
      return (Criteria) this;
    }

    public Criteria andApplianceStoreTypeNotEqualTo(Byte value) {
      addCriterion("appliance_store_type <>", value, "applianceStoreType");
      return (Criteria) this;
    }

    public Criteria andApplianceStoreTypeGreaterThan(Byte value) {
      addCriterion("appliance_store_type >", value, "applianceStoreType");
      return (Criteria) this;
    }

    public Criteria andApplianceStoreTypeGreaterThanOrEqualTo(Byte value) {
      addCriterion("appliance_store_type >=", value, "applianceStoreType");
      return (Criteria) this;
    }

    public Criteria andApplianceStoreTypeLessThan(Byte value) {
      addCriterion("appliance_store_type <", value, "applianceStoreType");
      return (Criteria) this;
    }

    public Criteria andApplianceStoreTypeLessThanOrEqualTo(Byte value) {
      addCriterion("appliance_store_type <=", value, "applianceStoreType");
      return (Criteria) this;
    }

    public Criteria andApplianceStoreTypeIn(List<Byte> values) {
      addCriterion("appliance_store_type in", values, "applianceStoreType");
      return (Criteria) this;
    }

    public Criteria andApplianceStoreTypeNotIn(List<Byte> values) {
      addCriterion("appliance_store_type not in", values, "applianceStoreType");
      return (Criteria) this;
    }

    public Criteria andApplianceStoreTypeBetween(Byte value1, Byte value2) {
      addCriterion("appliance_store_type between", value1, value2, "applianceStoreType");
      return (Criteria) this;
    }

    public Criteria andApplianceStoreTypeNotBetween(Byte value1, Byte value2) {
      addCriterion("appliance_store_type not between", value1, value2, "applianceStoreType");
      return (Criteria) this;
    }

    public Criteria andInfoIsNull() {
      addCriterion("info is null");
      return (Criteria) this;
    }

    public Criteria andInfoIsNotNull() {
      addCriterion("info is not null");
      return (Criteria) this;
    }

    public Criteria andInfoEqualTo(String value) {
      addCriterion("info =", value, "info");
      return (Criteria) this;
    }

    public Criteria andInfoNotEqualTo(String value) {
      addCriterion("info <>", value, "info");
      return (Criteria) this;
    }

    public Criteria andInfoGreaterThan(String value) {
      addCriterion("info >", value, "info");
      return (Criteria) this;
    }

    public Criteria andInfoGreaterThanOrEqualTo(String value) {
      addCriterion("info >=", value, "info");
      return (Criteria) this;
    }

    public Criteria andInfoLessThan(String value) {
      addCriterion("info <", value, "info");
      return (Criteria) this;
    }

    public Criteria andInfoLessThanOrEqualTo(String value) {
      addCriterion("info <=", value, "info");
      return (Criteria) this;
    }

    public Criteria andInfoLike(String value) {
      addCriterion("info like", value, "info");
      return (Criteria) this;
    }

    public Criteria andInfoNotLike(String value) {
      addCriterion("info not like", value, "info");
      return (Criteria) this;
    }

    public Criteria andInfoIn(List<String> values) {
      addCriterion("info in", values, "info");
      return (Criteria) this;
    }

    public Criteria andInfoNotIn(List<String> values) {
      addCriterion("info not in", values, "info");
      return (Criteria) this;
    }

    public Criteria andInfoBetween(String value1, String value2) {
      addCriterion("info between", value1, value2, "info");
      return (Criteria) this;
    }

    public Criteria andInfoNotBetween(String value1, String value2) {
      addCriterion("info not between", value1, value2, "info");
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

    public Criteria andIsAddTemplateIsNull() {
      addCriterion("is_add_template is null");
      return (Criteria) this;
    }

    public Criteria andIsAddTemplateIsNotNull() {
      addCriterion("is_add_template is not null");
      return (Criteria) this;
    }

    public Criteria andIsAddTemplateEqualTo(Boolean value) {
      addCriterion("is_add_template =", value, "isAddTemplate");
      return (Criteria) this;
    }

    public Criteria andIsAddTemplateNotEqualTo(Boolean value) {
      addCriterion("is_add_template <>", value, "isAddTemplate");
      return (Criteria) this;
    }

    public Criteria andIsAddTemplateGreaterThan(Boolean value) {
      addCriterion("is_add_template >", value, "isAddTemplate");
      return (Criteria) this;
    }

    public Criteria andIsAddTemplateGreaterThanOrEqualTo(Boolean value) {
      addCriterion("is_add_template >=", value, "isAddTemplate");
      return (Criteria) this;
    }

    public Criteria andIsAddTemplateLessThan(Boolean value) {
      addCriterion("is_add_template <", value, "isAddTemplate");
      return (Criteria) this;
    }

    public Criteria andIsAddTemplateLessThanOrEqualTo(Boolean value) {
      addCriterion("is_add_template <=", value, "isAddTemplate");
      return (Criteria) this;
    }

    public Criteria andIsAddTemplateIn(List<Boolean> values) {
      addCriterion("is_add_template in", values, "isAddTemplate");
      return (Criteria) this;
    }

    public Criteria andIsAddTemplateNotIn(List<Boolean> values) {
      addCriterion("is_add_template not in", values, "isAddTemplate");
      return (Criteria) this;
    }

    public Criteria andIsAddTemplateBetween(Boolean value1, Boolean value2) {
      addCriterion("is_add_template between", value1, value2, "isAddTemplate");
      return (Criteria) this;
    }

    public Criteria andIsAddTemplateNotBetween(Boolean value1, Boolean value2) {
      addCriterion("is_add_template not between", value1, value2, "isAddTemplate");
      return (Criteria) this;
    }

    public Criteria andCouponSuperpositionTypeIsNull() {
      addCriterion("coupon_superposition_type is null");
      return (Criteria) this;
    }

    public Criteria andCouponSuperpositionTypeIsNotNull() {
      addCriterion("coupon_superposition_type is not null");
      return (Criteria) this;
    }

    public Criteria andCouponSuperpositionTypeEqualTo(Byte value) {
      addCriterion("coupon_superposition_type =", value, "couponSuperpositionType");
      return (Criteria) this;
    }

    public Criteria andCouponSuperpositionTypeNotEqualTo(Byte value) {
      addCriterion("coupon_superposition_type <>", value, "couponSuperpositionType");
      return (Criteria) this;
    }

    public Criteria andCouponSuperpositionTypeGreaterThan(Byte value) {
      addCriterion("coupon_superposition_type >", value, "couponSuperpositionType");
      return (Criteria) this;
    }

    public Criteria andCouponSuperpositionTypeGreaterThanOrEqualTo(Byte value) {
      addCriterion("coupon_superposition_type >=", value, "couponSuperpositionType");
      return (Criteria) this;
    }

    public Criteria andCouponSuperpositionTypeLessThan(Byte value) {
      addCriterion("coupon_superposition_type <", value, "couponSuperpositionType");
      return (Criteria) this;
    }

    public Criteria andCouponSuperpositionTypeLessThanOrEqualTo(Byte value) {
      addCriterion("coupon_superposition_type <=", value, "couponSuperpositionType");
      return (Criteria) this;
    }

    public Criteria andCouponSuperpositionTypeIn(List<Byte> values) {
      addCriterion("coupon_superposition_type in", values, "couponSuperpositionType");
      return (Criteria) this;
    }

    public Criteria andCouponSuperpositionTypeNotIn(List<Byte> values) {
      addCriterion("coupon_superposition_type not in", values, "couponSuperpositionType");
      return (Criteria) this;
    }

    public Criteria andCouponSuperpositionTypeBetween(Byte value1, Byte value2) {
      addCriterion("coupon_superposition_type between", value1, value2, "couponSuperpositionType");
      return (Criteria) this;
    }

    public Criteria andCouponSuperpositionTypeNotBetween(Byte value1, Byte value2) {
      addCriterion("coupon_superposition_type not between", value1, value2, "couponSuperpositionType");
      return (Criteria) this;
    }

    public Criteria andSuperpositionMemberCardIsNull() {
      addCriterion("superposition_member_card is null");
      return (Criteria) this;
    }

    public Criteria andSuperpositionMemberCardIsNotNull() {
      addCriterion("superposition_member_card is not null");
      return (Criteria) this;
    }

    public Criteria andSuperpositionMemberCardEqualTo(Boolean value) {
      addCriterion("superposition_member_card =", value, "superpositionMemberCard");
      return (Criteria) this;
    }

    public Criteria andSuperpositionMemberCardNotEqualTo(Boolean value) {
      addCriterion("superposition_member_card <>", value, "superpositionMemberCard");
      return (Criteria) this;
    }

    public Criteria andSuperpositionMemberCardGreaterThan(Boolean value) {
      addCriterion("superposition_member_card >", value, "superpositionMemberCard");
      return (Criteria) this;
    }

    public Criteria andSuperpositionMemberCardGreaterThanOrEqualTo(Boolean value) {
      addCriterion("superposition_member_card >=", value, "superpositionMemberCard");
      return (Criteria) this;
    }

    public Criteria andSuperpositionMemberCardLessThan(Boolean value) {
      addCriterion("superposition_member_card <", value, "superpositionMemberCard");
      return (Criteria) this;
    }

    public Criteria andSuperpositionMemberCardLessThanOrEqualTo(Boolean value) {
      addCriterion("superposition_member_card <=", value, "superpositionMemberCard");
      return (Criteria) this;
    }

    public Criteria andSuperpositionMemberCardIn(List<Boolean> values) {
      addCriterion("superposition_member_card in", values, "superpositionMemberCard");
      return (Criteria) this;
    }

    public Criteria andSuperpositionMemberCardNotIn(List<Boolean> values) {
      addCriterion("superposition_member_card not in", values, "superpositionMemberCard");
      return (Criteria) this;
    }

    public Criteria andSuperpositionMemberCardBetween(Boolean value1, Boolean value2) {
      addCriterion("superposition_member_card between", value1, value2, "superpositionMemberCard");
      return (Criteria) this;
    }

    public Criteria andSuperpositionMemberCardNotBetween(Boolean value1, Boolean value2) {
      addCriterion("superposition_member_card not between", value1, value2, "superpositionMemberCard");
      return (Criteria) this;
    }

    public Criteria andTransferSendIsNull() {
      addCriterion("transfer_send is null");
      return (Criteria) this;
    }

    public Criteria andTransferSendIsNotNull() {
      addCriterion("transfer_send is not null");
      return (Criteria) this;
    }

    public Criteria andTransferSendEqualTo(Boolean value) {
      addCriterion("transfer_send =", value, "transferSend");
      return (Criteria) this;
    }

    public Criteria andTransferSendNotEqualTo(Boolean value) {
      addCriterion("transfer_send <>", value, "transferSend");
      return (Criteria) this;
    }

    public Criteria andTransferSendGreaterThan(Boolean value) {
      addCriterion("transfer_send >", value, "transferSend");
      return (Criteria) this;
    }

    public Criteria andTransferSendGreaterThanOrEqualTo(Boolean value) {
      addCriterion("transfer_send >=", value, "transferSend");
      return (Criteria) this;
    }

    public Criteria andTransferSendLessThan(Boolean value) {
      addCriterion("transfer_send <", value, "transferSend");
      return (Criteria) this;
    }

    public Criteria andTransferSendLessThanOrEqualTo(Boolean value) {
      addCriterion("transfer_send <=", value, "transferSend");
      return (Criteria) this;
    }

    public Criteria andTransferSendIn(List<Boolean> values) {
      addCriterion("transfer_send in", values, "transferSend");
      return (Criteria) this;
    }

    public Criteria andTransferSendNotIn(List<Boolean> values) {
      addCriterion("transfer_send not in", values, "transferSend");
      return (Criteria) this;
    }

    public Criteria andTransferSendBetween(Boolean value1, Boolean value2) {
      addCriterion("transfer_send between", value1, value2, "transferSend");
      return (Criteria) this;
    }

    public Criteria andTransferSendNotBetween(Boolean value1, Boolean value2) {
      addCriterion("transfer_send not between", value1, value2, "transferSend");
      return (Criteria) this;
    }

    public Criteria andTransferCouponDefinitionIdIsNull() {
      addCriterion("transfer_coupon_definition_id is null");
      return (Criteria) this;
    }

    public Criteria andTransferCouponDefinitionIdIsNotNull() {
      addCriterion("transfer_coupon_definition_id is not null");
      return (Criteria) this;
    }

    public Criteria andTransferCouponDefinitionIdEqualTo(Long value) {
      addCriterion("transfer_coupon_definition_id =", value, "transferCouponDefinitionId");
      return (Criteria) this;
    }

    public Criteria andTransferCouponDefinitionIdNotEqualTo(Long value) {
      addCriterion("transfer_coupon_definition_id <>", value, "transferCouponDefinitionId");
      return (Criteria) this;
    }

    public Criteria andTransferCouponDefinitionIdGreaterThan(Long value) {
      addCriterion("transfer_coupon_definition_id >", value, "transferCouponDefinitionId");
      return (Criteria) this;
    }

    public Criteria andTransferCouponDefinitionIdGreaterThanOrEqualTo(Long value) {
      addCriterion("transfer_coupon_definition_id >=", value, "transferCouponDefinitionId");
      return (Criteria) this;
    }

    public Criteria andTransferCouponDefinitionIdLessThan(Long value) {
      addCriterion("transfer_coupon_definition_id <", value, "transferCouponDefinitionId");
      return (Criteria) this;
    }

    public Criteria andTransferCouponDefinitionIdLessThanOrEqualTo(Long value) {
      addCriterion("transfer_coupon_definition_id <=", value, "transferCouponDefinitionId");
      return (Criteria) this;
    }

    public Criteria andTransferCouponDefinitionIdIn(List<Long> values) {
      addCriterion("transfer_coupon_definition_id in", values, "transferCouponDefinitionId");
      return (Criteria) this;
    }

    public Criteria andTransferCouponDefinitionIdNotIn(List<Long> values) {
      addCriterion("transfer_coupon_definition_id not in", values, "transferCouponDefinitionId");
      return (Criteria) this;
    }

    public Criteria andTransferCouponDefinitionIdBetween(Long value1, Long value2) {
      addCriterion("transfer_coupon_definition_id between", value1, value2, "transferCouponDefinitionId");
      return (Criteria) this;
    }

    public Criteria andTransferCouponDefinitionIdNotBetween(Long value1, Long value2) {
      addCriterion("transfer_coupon_definition_id not between", value1, value2, "transferCouponDefinitionId");
      return (Criteria) this;
    }

    public Criteria andTransferInfoIsNull() {
      addCriterion("transfer_info is null");
      return (Criteria) this;
    }

    public Criteria andTransferInfoIsNotNull() {
      addCriterion("transfer_info is not null");
      return (Criteria) this;
    }

    public Criteria andTransferInfoEqualTo(String value) {
      addCriterion("transfer_info =", value, "transferInfo");
      return (Criteria) this;
    }

    public Criteria andTransferInfoNotEqualTo(String value) {
      addCriterion("transfer_info <>", value, "transferInfo");
      return (Criteria) this;
    }

    public Criteria andTransferInfoGreaterThan(String value) {
      addCriterion("transfer_info >", value, "transferInfo");
      return (Criteria) this;
    }

    public Criteria andTransferInfoGreaterThanOrEqualTo(String value) {
      addCriterion("transfer_info >=", value, "transferInfo");
      return (Criteria) this;
    }

    public Criteria andTransferInfoLessThan(String value) {
      addCriterion("transfer_info <", value, "transferInfo");
      return (Criteria) this;
    }

    public Criteria andTransferInfoLessThanOrEqualTo(String value) {
      addCriterion("transfer_info <=", value, "transferInfo");
      return (Criteria) this;
    }

    public Criteria andTransferInfoLike(String value) {
      addCriterion("transfer_info like", value, "transferInfo");
      return (Criteria) this;
    }

    public Criteria andTransferInfoNotLike(String value) {
      addCriterion("transfer_info not like", value, "transferInfo");
      return (Criteria) this;
    }

    public Criteria andTransferInfoIn(List<String> values) {
      addCriterion("transfer_info in", values, "transferInfo");
      return (Criteria) this;
    }

    public Criteria andTransferInfoNotIn(List<String> values) {
      addCriterion("transfer_info not in", values, "transferInfo");
      return (Criteria) this;
    }

    public Criteria andTransferInfoBetween(String value1, String value2) {
      addCriterion("transfer_info between", value1, value2, "transferInfo");
      return (Criteria) this;
    }

    public Criteria andTransferInfoNotBetween(String value1, String value2) {
      addCriterion("transfer_info not between", value1, value2, "transferInfo");
      return (Criteria) this;
    }

    public Criteria andTransferFissionIsNull() {
      addCriterion("transfer_fission is null");
      return (Criteria) this;
    }

    public Criteria andTransferFissionIsNotNull() {
      addCriterion("transfer_fission is not null");
      return (Criteria) this;
    }

    public Criteria andTransferFissionEqualTo(Boolean value) {
      addCriterion("transfer_fission =", value, "transferFission");
      return (Criteria) this;
    }

    public Criteria andTransferFissionNotEqualTo(Boolean value) {
      addCriterion("transfer_fission <>", value, "transferFission");
      return (Criteria) this;
    }

    public Criteria andTransferFissionGreaterThan(Boolean value) {
      addCriterion("transfer_fission >", value, "transferFission");
      return (Criteria) this;
    }

    public Criteria andTransferFissionGreaterThanOrEqualTo(Boolean value) {
      addCriterion("transfer_fission >=", value, "transferFission");
      return (Criteria) this;
    }

    public Criteria andTransferFissionLessThan(Boolean value) {
      addCriterion("transfer_fission <", value, "transferFission");
      return (Criteria) this;
    }

    public Criteria andTransferFissionLessThanOrEqualTo(Boolean value) {
      addCriterion("transfer_fission <=", value, "transferFission");
      return (Criteria) this;
    }

    public Criteria andTransferFissionIn(List<Boolean> values) {
      addCriterion("transfer_fission in", values, "transferFission");
      return (Criteria) this;
    }

    public Criteria andTransferFissionNotIn(List<Boolean> values) {
      addCriterion("transfer_fission not in", values, "transferFission");
      return (Criteria) this;
    }

    public Criteria andTransferFissionBetween(Boolean value1, Boolean value2) {
      addCriterion("transfer_fission between", value1, value2, "transferFission");
      return (Criteria) this;
    }

    public Criteria andTransferFissionNotBetween(Boolean value1, Boolean value2) {
      addCriterion("transfer_fission not between", value1, value2, "transferFission");
      return (Criteria) this;
    }
  }

  /**
   * 只读. t_coupon_definition
   * @mbg.generated  2019-04-23 15:56:26
   */
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

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_coupon_definition
     *
     * @mbg.generated do_not_delete_during_merge 2019-04-23 15:48:46
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}