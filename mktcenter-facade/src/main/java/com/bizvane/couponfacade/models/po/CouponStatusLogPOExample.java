package com.bizvane.couponfacade.models.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CouponStatusLogPOExample implements Serializable {
    /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  protected String orderByClause;
  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  protected boolean distinct;
  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  protected List<Criteria> oredCriteria;
  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  private static final long serialVersionUID = 1L;

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  public CouponStatusLogPOExample() {
    oredCriteria = new ArrayList<Criteria>();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  public void setOrderByClause(String orderByClause) {
    this.orderByClause = orderByClause;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  public String getOrderByClause() {
    return orderByClause;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  public void setDistinct(boolean distinct) {
    this.distinct = distinct;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  public boolean isDistinct() {
    return distinct;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  public List<Criteria> getOredCriteria() {
    return oredCriteria;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  public void or(Criteria criteria) {
    oredCriteria.add(criteria);
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  public Criteria or() {
    Criteria criteria = createCriteriaInternal();
    oredCriteria.add(criteria);
    return criteria;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
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
   * @mbg.generated  2018-07-27 16:45:43
   */
  protected Criteria createCriteriaInternal() {
    Criteria criteria = new Criteria();
    return criteria;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  public void clear() {
    oredCriteria.clear();
    orderByClause = null;
    distinct = false;
  }

  /**
   * 只读. t_coupon_status_log
   * @mbg.generated  2018-07-27 16:45:43
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

    public Criteria andCouponStatusLogIdIsNull() {
      addCriterion("coupon_status_log_id is null");
      return (Criteria) this;
    }

    public Criteria andCouponStatusLogIdIsNotNull() {
      addCriterion("coupon_status_log_id is not null");
      return (Criteria) this;
    }

    public Criteria andCouponStatusLogIdEqualTo(Long value) {
      addCriterion("coupon_status_log_id =", value, "couponStatusLogId");
      return (Criteria) this;
    }

    public Criteria andCouponStatusLogIdNotEqualTo(Long value) {
      addCriterion("coupon_status_log_id <>", value, "couponStatusLogId");
      return (Criteria) this;
    }

    public Criteria andCouponStatusLogIdGreaterThan(Long value) {
      addCriterion("coupon_status_log_id >", value, "couponStatusLogId");
      return (Criteria) this;
    }

    public Criteria andCouponStatusLogIdGreaterThanOrEqualTo(Long value) {
      addCriterion("coupon_status_log_id >=", value, "couponStatusLogId");
      return (Criteria) this;
    }

    public Criteria andCouponStatusLogIdLessThan(Long value) {
      addCriterion("coupon_status_log_id <", value, "couponStatusLogId");
      return (Criteria) this;
    }

    public Criteria andCouponStatusLogIdLessThanOrEqualTo(Long value) {
      addCriterion("coupon_status_log_id <=", value, "couponStatusLogId");
      return (Criteria) this;
    }

    public Criteria andCouponStatusLogIdIn(List<Long> values) {
      addCriterion("coupon_status_log_id in", values, "couponStatusLogId");
      return (Criteria) this;
    }

    public Criteria andCouponStatusLogIdNotIn(List<Long> values) {
      addCriterion("coupon_status_log_id not in", values, "couponStatusLogId");
      return (Criteria) this;
    }

    public Criteria andCouponStatusLogIdBetween(Long value1, Long value2) {
      addCriterion("coupon_status_log_id between", value1, value2, "couponStatusLogId");
      return (Criteria) this;
    }

    public Criteria andCouponStatusLogIdNotBetween(Long value1, Long value2) {
      addCriterion("coupon_status_log_id not between", value1, value2, "couponStatusLogId");
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

    public Criteria andCouponCodeIsNull() {
      addCriterion("coupon_code is null");
      return (Criteria) this;
    }

    public Criteria andCouponCodeIsNotNull() {
      addCriterion("coupon_code is not null");
      return (Criteria) this;
    }

    public Criteria andCouponCodeEqualTo(String value) {
      addCriterion("coupon_code =", value, "couponCode");
      return (Criteria) this;
    }

    public Criteria andCouponCodeNotEqualTo(String value) {
      addCriterion("coupon_code <>", value, "couponCode");
      return (Criteria) this;
    }

    public Criteria andCouponCodeGreaterThan(String value) {
      addCriterion("coupon_code >", value, "couponCode");
      return (Criteria) this;
    }

    public Criteria andCouponCodeGreaterThanOrEqualTo(String value) {
      addCriterion("coupon_code >=", value, "couponCode");
      return (Criteria) this;
    }

    public Criteria andCouponCodeLessThan(String value) {
      addCriterion("coupon_code <", value, "couponCode");
      return (Criteria) this;
    }

    public Criteria andCouponCodeLessThanOrEqualTo(String value) {
      addCriterion("coupon_code <=", value, "couponCode");
      return (Criteria) this;
    }

    public Criteria andCouponCodeLike(String value) {
      addCriterion("coupon_code like", value, "couponCode");
      return (Criteria) this;
    }

    public Criteria andCouponCodeNotLike(String value) {
      addCriterion("coupon_code not like", value, "couponCode");
      return (Criteria) this;
    }

    public Criteria andCouponCodeIn(List<String> values) {
      addCriterion("coupon_code in", values, "couponCode");
      return (Criteria) this;
    }

    public Criteria andCouponCodeNotIn(List<String> values) {
      addCriterion("coupon_code not in", values, "couponCode");
      return (Criteria) this;
    }

    public Criteria andCouponCodeBetween(String value1, String value2) {
      addCriterion("coupon_code between", value1, value2, "couponCode");
      return (Criteria) this;
    }

    public Criteria andCouponCodeNotBetween(String value1, String value2) {
      addCriterion("coupon_code not between", value1, value2, "couponCode");
      return (Criteria) this;
    }

    public Criteria andBusinessTypeIsNull() {
      addCriterion("business_type is null");
      return (Criteria) this;
    }

    public Criteria andBusinessTypeIsNotNull() {
      addCriterion("business_type is not null");
      return (Criteria) this;
    }

    public Criteria andBusinessTypeEqualTo(Byte value) {
      addCriterion("business_type =", value, "businessType");
      return (Criteria) this;
    }

    public Criteria andBusinessTypeNotEqualTo(Byte value) {
      addCriterion("business_type <>", value, "businessType");
      return (Criteria) this;
    }

    public Criteria andBusinessTypeGreaterThan(Byte value) {
      addCriterion("business_type >", value, "businessType");
      return (Criteria) this;
    }

    public Criteria andBusinessTypeGreaterThanOrEqualTo(Byte value) {
      addCriterion("business_type >=", value, "businessType");
      return (Criteria) this;
    }

    public Criteria andBusinessTypeLessThan(Byte value) {
      addCriterion("business_type <", value, "businessType");
      return (Criteria) this;
    }

    public Criteria andBusinessTypeLessThanOrEqualTo(Byte value) {
      addCriterion("business_type <=", value, "businessType");
      return (Criteria) this;
    }

    public Criteria andBusinessTypeIn(List<Byte> values) {
      addCriterion("business_type in", values, "businessType");
      return (Criteria) this;
    }

    public Criteria andBusinessTypeNotIn(List<Byte> values) {
      addCriterion("business_type not in", values, "businessType");
      return (Criteria) this;
    }

    public Criteria andBusinessTypeBetween(Byte value1, Byte value2) {
      addCriterion("business_type between", value1, value2, "businessType");
      return (Criteria) this;
    }

    public Criteria andBusinessTypeNotBetween(Byte value1, Byte value2) {
      addCriterion("business_type not between", value1, value2, "businessType");
      return (Criteria) this;
    }

    public Criteria andBusinessCodeIsNull() {
      addCriterion("business_code is null");
      return (Criteria) this;
    }

    public Criteria andBusinessCodeIsNotNull() {
      addCriterion("business_code is not null");
      return (Criteria) this;
    }

    public Criteria andBusinessCodeEqualTo(String value) {
      addCriterion("business_code =", value, "businessCode");
      return (Criteria) this;
    }

    public Criteria andBusinessCodeNotEqualTo(String value) {
      addCriterion("business_code <>", value, "businessCode");
      return (Criteria) this;
    }

    public Criteria andBusinessCodeGreaterThan(String value) {
      addCriterion("business_code >", value, "businessCode");
      return (Criteria) this;
    }

    public Criteria andBusinessCodeGreaterThanOrEqualTo(String value) {
      addCriterion("business_code >=", value, "businessCode");
      return (Criteria) this;
    }

    public Criteria andBusinessCodeLessThan(String value) {
      addCriterion("business_code <", value, "businessCode");
      return (Criteria) this;
    }

    public Criteria andBusinessCodeLessThanOrEqualTo(String value) {
      addCriterion("business_code <=", value, "businessCode");
      return (Criteria) this;
    }

    public Criteria andBusinessCodeLike(String value) {
      addCriterion("business_code like", value, "businessCode");
      return (Criteria) this;
    }

    public Criteria andBusinessCodeNotLike(String value) {
      addCriterion("business_code not like", value, "businessCode");
      return (Criteria) this;
    }

    public Criteria andBusinessCodeIn(List<String> values) {
      addCriterion("business_code in", values, "businessCode");
      return (Criteria) this;
    }

    public Criteria andBusinessCodeNotIn(List<String> values) {
      addCriterion("business_code not in", values, "businessCode");
      return (Criteria) this;
    }

    public Criteria andBusinessCodeBetween(String value1, String value2) {
      addCriterion("business_code between", value1, value2, "businessCode");
      return (Criteria) this;
    }

    public Criteria andBusinessCodeNotBetween(String value1, String value2) {
      addCriterion("business_code not between", value1, value2, "businessCode");
      return (Criteria) this;
    }

    public Criteria andBusinessTimeIsNull() {
      addCriterion("business_time is null");
      return (Criteria) this;
    }

    public Criteria andBusinessTimeIsNotNull() {
      addCriterion("business_time is not null");
      return (Criteria) this;
    }

    public Criteria andBusinessTimeEqualTo(Date value) {
      addCriterion("business_time =", value, "businessTime");
      return (Criteria) this;
    }

    public Criteria andBusinessTimeNotEqualTo(Date value) {
      addCriterion("business_time <>", value, "businessTime");
      return (Criteria) this;
    }

    public Criteria andBusinessTimeGreaterThan(Date value) {
      addCriterion("business_time >", value, "businessTime");
      return (Criteria) this;
    }

    public Criteria andBusinessTimeGreaterThanOrEqualTo(Date value) {
      addCriterion("business_time >=", value, "businessTime");
      return (Criteria) this;
    }

    public Criteria andBusinessTimeLessThan(Date value) {
      addCriterion("business_time <", value, "businessTime");
      return (Criteria) this;
    }

    public Criteria andBusinessTimeLessThanOrEqualTo(Date value) {
      addCriterion("business_time <=", value, "businessTime");
      return (Criteria) this;
    }

    public Criteria andBusinessTimeIn(List<Date> values) {
      addCriterion("business_time in", values, "businessTime");
      return (Criteria) this;
    }

    public Criteria andBusinessTimeNotIn(List<Date> values) {
      addCriterion("business_time not in", values, "businessTime");
      return (Criteria) this;
    }

    public Criteria andBusinessTimeBetween(Date value1, Date value2) {
      addCriterion("business_time between", value1, value2, "businessTime");
      return (Criteria) this;
    }

    public Criteria andBusinessTimeNotBetween(Date value1, Date value2) {
      addCriterion("business_time not between", value1, value2, "businessTime");
      return (Criteria) this;
    }

    public Criteria andTransferMemberCodeIsNull() {
      addCriterion("transfer_member_code is null");
      return (Criteria) this;
    }

    public Criteria andTransferMemberCodeIsNotNull() {
      addCriterion("transfer_member_code is not null");
      return (Criteria) this;
    }

    public Criteria andTransferMemberCodeEqualTo(String value) {
      addCriterion("transfer_member_code =", value, "transferMemberCode");
      return (Criteria) this;
    }

    public Criteria andTransferMemberCodeNotEqualTo(String value) {
      addCriterion("transfer_member_code <>", value, "transferMemberCode");
      return (Criteria) this;
    }

    public Criteria andTransferMemberCodeGreaterThan(String value) {
      addCriterion("transfer_member_code >", value, "transferMemberCode");
      return (Criteria) this;
    }

    public Criteria andTransferMemberCodeGreaterThanOrEqualTo(String value) {
      addCriterion("transfer_member_code >=", value, "transferMemberCode");
      return (Criteria) this;
    }

    public Criteria andTransferMemberCodeLessThan(String value) {
      addCriterion("transfer_member_code <", value, "transferMemberCode");
      return (Criteria) this;
    }

    public Criteria andTransferMemberCodeLessThanOrEqualTo(String value) {
      addCriterion("transfer_member_code <=", value, "transferMemberCode");
      return (Criteria) this;
    }

    public Criteria andTransferMemberCodeLike(String value) {
      addCriterion("transfer_member_code like", value, "transferMemberCode");
      return (Criteria) this;
    }

    public Criteria andTransferMemberCodeNotLike(String value) {
      addCriterion("transfer_member_code not like", value, "transferMemberCode");
      return (Criteria) this;
    }

    public Criteria andTransferMemberCodeIn(List<String> values) {
      addCriterion("transfer_member_code in", values, "transferMemberCode");
      return (Criteria) this;
    }

    public Criteria andTransferMemberCodeNotIn(List<String> values) {
      addCriterion("transfer_member_code not in", values, "transferMemberCode");
      return (Criteria) this;
    }

    public Criteria andTransferMemberCodeBetween(String value1, String value2) {
      addCriterion("transfer_member_code between", value1, value2, "transferMemberCode");
      return (Criteria) this;
    }

    public Criteria andTransferMemberCodeNotBetween(String value1, String value2) {
      addCriterion("transfer_member_code not between", value1, value2, "transferMemberCode");
      return (Criteria) this;
    }

    public Criteria andTransferMemberNameIsNull() {
      addCriterion("transfer_member_name is null");
      return (Criteria) this;
    }

    public Criteria andTransferMemberNameIsNotNull() {
      addCriterion("transfer_member_name is not null");
      return (Criteria) this;
    }

    public Criteria andTransferMemberNameEqualTo(String value) {
      addCriterion("transfer_member_name =", value, "transferMemberName");
      return (Criteria) this;
    }

    public Criteria andTransferMemberNameNotEqualTo(String value) {
      addCriterion("transfer_member_name <>", value, "transferMemberName");
      return (Criteria) this;
    }

    public Criteria andTransferMemberNameGreaterThan(String value) {
      addCriterion("transfer_member_name >", value, "transferMemberName");
      return (Criteria) this;
    }

    public Criteria andTransferMemberNameGreaterThanOrEqualTo(String value) {
      addCriterion("transfer_member_name >=", value, "transferMemberName");
      return (Criteria) this;
    }

    public Criteria andTransferMemberNameLessThan(String value) {
      addCriterion("transfer_member_name <", value, "transferMemberName");
      return (Criteria) this;
    }

    public Criteria andTransferMemberNameLessThanOrEqualTo(String value) {
      addCriterion("transfer_member_name <=", value, "transferMemberName");
      return (Criteria) this;
    }

    public Criteria andTransferMemberNameLike(String value) {
      addCriterion("transfer_member_name like", value, "transferMemberName");
      return (Criteria) this;
    }

    public Criteria andTransferMemberNameNotLike(String value) {
      addCriterion("transfer_member_name not like", value, "transferMemberName");
      return (Criteria) this;
    }

    public Criteria andTransferMemberNameIn(List<String> values) {
      addCriterion("transfer_member_name in", values, "transferMemberName");
      return (Criteria) this;
    }

    public Criteria andTransferMemberNameNotIn(List<String> values) {
      addCriterion("transfer_member_name not in", values, "transferMemberName");
      return (Criteria) this;
    }

    public Criteria andTransferMemberNameBetween(String value1, String value2) {
      addCriterion("transfer_member_name between", value1, value2, "transferMemberName");
      return (Criteria) this;
    }

    public Criteria andTransferMemberNameNotBetween(String value1, String value2) {
      addCriterion("transfer_member_name not between", value1, value2, "transferMemberName");
      return (Criteria) this;
    }

    public Criteria andReceivedMemberCodeIsNull() {
      addCriterion("received_member_code is null");
      return (Criteria) this;
    }

    public Criteria andReceivedMemberCodeIsNotNull() {
      addCriterion("received_member_code is not null");
      return (Criteria) this;
    }

    public Criteria andReceivedMemberCodeEqualTo(String value) {
      addCriterion("received_member_code =", value, "receivedMemberCode");
      return (Criteria) this;
    }

    public Criteria andReceivedMemberCodeNotEqualTo(String value) {
      addCriterion("received_member_code <>", value, "receivedMemberCode");
      return (Criteria) this;
    }

    public Criteria andReceivedMemberCodeGreaterThan(String value) {
      addCriterion("received_member_code >", value, "receivedMemberCode");
      return (Criteria) this;
    }

    public Criteria andReceivedMemberCodeGreaterThanOrEqualTo(String value) {
      addCriterion("received_member_code >=", value, "receivedMemberCode");
      return (Criteria) this;
    }

    public Criteria andReceivedMemberCodeLessThan(String value) {
      addCriterion("received_member_code <", value, "receivedMemberCode");
      return (Criteria) this;
    }

    public Criteria andReceivedMemberCodeLessThanOrEqualTo(String value) {
      addCriterion("received_member_code <=", value, "receivedMemberCode");
      return (Criteria) this;
    }

    public Criteria andReceivedMemberCodeLike(String value) {
      addCriterion("received_member_code like", value, "receivedMemberCode");
      return (Criteria) this;
    }

    public Criteria andReceivedMemberCodeNotLike(String value) {
      addCriterion("received_member_code not like", value, "receivedMemberCode");
      return (Criteria) this;
    }

    public Criteria andReceivedMemberCodeIn(List<String> values) {
      addCriterion("received_member_code in", values, "receivedMemberCode");
      return (Criteria) this;
    }

    public Criteria andReceivedMemberCodeNotIn(List<String> values) {
      addCriterion("received_member_code not in", values, "receivedMemberCode");
      return (Criteria) this;
    }

    public Criteria andReceivedMemberCodeBetween(String value1, String value2) {
      addCriterion("received_member_code between", value1, value2, "receivedMemberCode");
      return (Criteria) this;
    }

    public Criteria andReceivedMemberCodeNotBetween(String value1, String value2) {
      addCriterion("received_member_code not between", value1, value2, "receivedMemberCode");
      return (Criteria) this;
    }

    public Criteria andReceivedMemberNameIsNull() {
      addCriterion("received_member_name is null");
      return (Criteria) this;
    }

    public Criteria andReceivedMemberNameIsNotNull() {
      addCriterion("received_member_name is not null");
      return (Criteria) this;
    }

    public Criteria andReceivedMemberNameEqualTo(String value) {
      addCriterion("received_member_name =", value, "receivedMemberName");
      return (Criteria) this;
    }

    public Criteria andReceivedMemberNameNotEqualTo(String value) {
      addCriterion("received_member_name <>", value, "receivedMemberName");
      return (Criteria) this;
    }

    public Criteria andReceivedMemberNameGreaterThan(String value) {
      addCriterion("received_member_name >", value, "receivedMemberName");
      return (Criteria) this;
    }

    public Criteria andReceivedMemberNameGreaterThanOrEqualTo(String value) {
      addCriterion("received_member_name >=", value, "receivedMemberName");
      return (Criteria) this;
    }

    public Criteria andReceivedMemberNameLessThan(String value) {
      addCriterion("received_member_name <", value, "receivedMemberName");
      return (Criteria) this;
    }

    public Criteria andReceivedMemberNameLessThanOrEqualTo(String value) {
      addCriterion("received_member_name <=", value, "receivedMemberName");
      return (Criteria) this;
    }

    public Criteria andReceivedMemberNameLike(String value) {
      addCriterion("received_member_name like", value, "receivedMemberName");
      return (Criteria) this;
    }

    public Criteria andReceivedMemberNameNotLike(String value) {
      addCriterion("received_member_name not like", value, "receivedMemberName");
      return (Criteria) this;
    }

    public Criteria andReceivedMemberNameIn(List<String> values) {
      addCriterion("received_member_name in", values, "receivedMemberName");
      return (Criteria) this;
    }

    public Criteria andReceivedMemberNameNotIn(List<String> values) {
      addCriterion("received_member_name not in", values, "receivedMemberName");
      return (Criteria) this;
    }

    public Criteria andReceivedMemberNameBetween(String value1, String value2) {
      addCriterion("received_member_name between", value1, value2, "receivedMemberName");
      return (Criteria) this;
    }

    public Criteria andReceivedMemberNameNotBetween(String value1, String value2) {
      addCriterion("received_member_name not between", value1, value2, "receivedMemberName");
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
   * 只读. t_coupon_status_log
   * @mbg.generated  2018-07-27 16:45:43
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
     * This class corresponds to the database table t_coupon_status_log
     *
     * @mbg.generated do_not_delete_during_merge 2018-06-30 15:18:35
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }
}