package com.bizvane.couponfacade.models.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CouponOfflineBindPOExample implements Serializable {
    /**
   * 只读. 
   * @mbg.generated  2018-07-26 09:54:19
   */
  protected String orderByClause;
  /**
   * 只读. 
   * @mbg.generated  2018-07-26 09:54:19
   */
  protected boolean distinct;
  /**
   * 只读. 
   * @mbg.generated  2018-07-26 09:54:19
   */
  protected List<Criteria> oredCriteria;
  /**
   * 只读. 
   * @mbg.generated  2018-07-26 09:54:19
   */
  private static final long serialVersionUID = 1L;

  /**
   * 只读. 
   * @mbg.generated  2018-07-26 09:54:19
   */
  public CouponOfflineBindPOExample() {
    oredCriteria = new ArrayList<Criteria>();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-26 09:54:19
   */
  public void setOrderByClause(String orderByClause) {
    this.orderByClause = orderByClause;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-26 09:54:19
   */
  public String getOrderByClause() {
    return orderByClause;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-26 09:54:19
   */
  public void setDistinct(boolean distinct) {
    this.distinct = distinct;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-26 09:54:19
   */
  public boolean isDistinct() {
    return distinct;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-26 09:54:19
   */
  public List<Criteria> getOredCriteria() {
    return oredCriteria;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-26 09:54:19
   */
  public void or(Criteria criteria) {
    oredCriteria.add(criteria);
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-26 09:54:19
   */
  public Criteria or() {
    Criteria criteria = createCriteriaInternal();
    oredCriteria.add(criteria);
    return criteria;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-26 09:54:19
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
   * @mbg.generated  2018-07-26 09:54:19
   */
  protected Criteria createCriteriaInternal() {
    Criteria criteria = new Criteria();
    return criteria;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-26 09:54:19
   */
  public void clear() {
    oredCriteria.clear();
    orderByClause = null;
    distinct = false;
  }

  /**
   * 只读. t_coupon_offline_bind
   * @mbg.generated  2018-07-26 09:54:19
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

    public Criteria andCouponOfflineBindIdIsNull() {
      addCriterion("coupon_offline_bind_id is null");
      return (Criteria) this;
    }

    public Criteria andCouponOfflineBindIdIsNotNull() {
      addCriterion("coupon_offline_bind_id is not null");
      return (Criteria) this;
    }

    public Criteria andCouponOfflineBindIdEqualTo(Long value) {
      addCriterion("coupon_offline_bind_id =", value, "couponOfflineBindId");
      return (Criteria) this;
    }

    public Criteria andCouponOfflineBindIdNotEqualTo(Long value) {
      addCriterion("coupon_offline_bind_id <>", value, "couponOfflineBindId");
      return (Criteria) this;
    }

    public Criteria andCouponOfflineBindIdGreaterThan(Long value) {
      addCriterion("coupon_offline_bind_id >", value, "couponOfflineBindId");
      return (Criteria) this;
    }

    public Criteria andCouponOfflineBindIdGreaterThanOrEqualTo(Long value) {
      addCriterion("coupon_offline_bind_id >=", value, "couponOfflineBindId");
      return (Criteria) this;
    }

    public Criteria andCouponOfflineBindIdLessThan(Long value) {
      addCriterion("coupon_offline_bind_id <", value, "couponOfflineBindId");
      return (Criteria) this;
    }

    public Criteria andCouponOfflineBindIdLessThanOrEqualTo(Long value) {
      addCriterion("coupon_offline_bind_id <=", value, "couponOfflineBindId");
      return (Criteria) this;
    }

    public Criteria andCouponOfflineBindIdIn(List<Long> values) {
      addCriterion("coupon_offline_bind_id in", values, "couponOfflineBindId");
      return (Criteria) this;
    }

    public Criteria andCouponOfflineBindIdNotIn(List<Long> values) {
      addCriterion("coupon_offline_bind_id not in", values, "couponOfflineBindId");
      return (Criteria) this;
    }

    public Criteria andCouponOfflineBindIdBetween(Long value1, Long value2) {
      addCriterion("coupon_offline_bind_id between", value1, value2, "couponOfflineBindId");
      return (Criteria) this;
    }

    public Criteria andCouponOfflineBindIdNotBetween(Long value1, Long value2) {
      addCriterion("coupon_offline_bind_id not between", value1, value2, "couponOfflineBindId");
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

    public Criteria andTypeCodeIsNull() {
      addCriterion("type_code is null");
      return (Criteria) this;
    }

    public Criteria andTypeCodeIsNotNull() {
      addCriterion("type_code is not null");
      return (Criteria) this;
    }

    public Criteria andTypeCodeEqualTo(String value) {
      addCriterion("type_code =", value, "typeCode");
      return (Criteria) this;
    }

    public Criteria andTypeCodeNotEqualTo(String value) {
      addCriterion("type_code <>", value, "typeCode");
      return (Criteria) this;
    }

    public Criteria andTypeCodeGreaterThan(String value) {
      addCriterion("type_code >", value, "typeCode");
      return (Criteria) this;
    }

    public Criteria andTypeCodeGreaterThanOrEqualTo(String value) {
      addCriterion("type_code >=", value, "typeCode");
      return (Criteria) this;
    }

    public Criteria andTypeCodeLessThan(String value) {
      addCriterion("type_code <", value, "typeCode");
      return (Criteria) this;
    }

    public Criteria andTypeCodeLessThanOrEqualTo(String value) {
      addCriterion("type_code <=", value, "typeCode");
      return (Criteria) this;
    }

    public Criteria andTypeCodeLike(String value) {
      addCriterion("type_code like", value, "typeCode");
      return (Criteria) this;
    }

    public Criteria andTypeCodeNotLike(String value) {
      addCriterion("type_code not like", value, "typeCode");
      return (Criteria) this;
    }

    public Criteria andTypeCodeIn(List<String> values) {
      addCriterion("type_code in", values, "typeCode");
      return (Criteria) this;
    }

    public Criteria andTypeCodeNotIn(List<String> values) {
      addCriterion("type_code not in", values, "typeCode");
      return (Criteria) this;
    }

    public Criteria andTypeCodeBetween(String value1, String value2) {
      addCriterion("type_code between", value1, value2, "typeCode");
      return (Criteria) this;
    }

    public Criteria andTypeCodeNotBetween(String value1, String value2) {
      addCriterion("type_code not between", value1, value2, "typeCode");
      return (Criteria) this;
    }

    public Criteria andBatchNoIsNull() {
      addCriterion("batch_no is null");
      return (Criteria) this;
    }

    public Criteria andBatchNoIsNotNull() {
      addCriterion("batch_no is not null");
      return (Criteria) this;
    }

    public Criteria andBatchNoEqualTo(String value) {
      addCriterion("batch_no =", value, "batchNo");
      return (Criteria) this;
    }

    public Criteria andBatchNoNotEqualTo(String value) {
      addCriterion("batch_no <>", value, "batchNo");
      return (Criteria) this;
    }

    public Criteria andBatchNoGreaterThan(String value) {
      addCriterion("batch_no >", value, "batchNo");
      return (Criteria) this;
    }

    public Criteria andBatchNoGreaterThanOrEqualTo(String value) {
      addCriterion("batch_no >=", value, "batchNo");
      return (Criteria) this;
    }

    public Criteria andBatchNoLessThan(String value) {
      addCriterion("batch_no <", value, "batchNo");
      return (Criteria) this;
    }

    public Criteria andBatchNoLessThanOrEqualTo(String value) {
      addCriterion("batch_no <=", value, "batchNo");
      return (Criteria) this;
    }

    public Criteria andBatchNoLike(String value) {
      addCriterion("batch_no like", value, "batchNo");
      return (Criteria) this;
    }

    public Criteria andBatchNoNotLike(String value) {
      addCriterion("batch_no not like", value, "batchNo");
      return (Criteria) this;
    }

    public Criteria andBatchNoIn(List<String> values) {
      addCriterion("batch_no in", values, "batchNo");
      return (Criteria) this;
    }

    public Criteria andBatchNoNotIn(List<String> values) {
      addCriterion("batch_no not in", values, "batchNo");
      return (Criteria) this;
    }

    public Criteria andBatchNoBetween(String value1, String value2) {
      addCriterion("batch_no between", value1, value2, "batchNo");
      return (Criteria) this;
    }

    public Criteria andBatchNoNotBetween(String value1, String value2) {
      addCriterion("batch_no not between", value1, value2, "batchNo");
      return (Criteria) this;
    }

    public Criteria andErrCountIsNull() {
      addCriterion("err_count is null");
      return (Criteria) this;
    }

    public Criteria andErrCountIsNotNull() {
      addCriterion("err_count is not null");
      return (Criteria) this;
    }

    public Criteria andErrCountEqualTo(Integer value) {
      addCriterion("err_count =", value, "errCount");
      return (Criteria) this;
    }

    public Criteria andErrCountNotEqualTo(Integer value) {
      addCriterion("err_count <>", value, "errCount");
      return (Criteria) this;
    }

    public Criteria andErrCountGreaterThan(Integer value) {
      addCriterion("err_count >", value, "errCount");
      return (Criteria) this;
    }

    public Criteria andErrCountGreaterThanOrEqualTo(Integer value) {
      addCriterion("err_count >=", value, "errCount");
      return (Criteria) this;
    }

    public Criteria andErrCountLessThan(Integer value) {
      addCriterion("err_count <", value, "errCount");
      return (Criteria) this;
    }

    public Criteria andErrCountLessThanOrEqualTo(Integer value) {
      addCriterion("err_count <=", value, "errCount");
      return (Criteria) this;
    }

    public Criteria andErrCountIn(List<Integer> values) {
      addCriterion("err_count in", values, "errCount");
      return (Criteria) this;
    }

    public Criteria andErrCountNotIn(List<Integer> values) {
      addCriterion("err_count not in", values, "errCount");
      return (Criteria) this;
    }

    public Criteria andErrCountBetween(Integer value1, Integer value2) {
      addCriterion("err_count between", value1, value2, "errCount");
      return (Criteria) this;
    }

    public Criteria andErrCountNotBetween(Integer value1, Integer value2) {
      addCriterion("err_count not between", value1, value2, "errCount");
      return (Criteria) this;
    }

    public Criteria andSubmitTimeIsNull() {
      addCriterion("submit_time is null");
      return (Criteria) this;
    }

    public Criteria andSubmitTimeIsNotNull() {
      addCriterion("submit_time is not null");
      return (Criteria) this;
    }

    public Criteria andSubmitTimeEqualTo(Date value) {
      addCriterion("submit_time =", value, "submitTime");
      return (Criteria) this;
    }

    public Criteria andSubmitTimeNotEqualTo(Date value) {
      addCriterion("submit_time <>", value, "submitTime");
      return (Criteria) this;
    }

    public Criteria andSubmitTimeGreaterThan(Date value) {
      addCriterion("submit_time >", value, "submitTime");
      return (Criteria) this;
    }

    public Criteria andSubmitTimeGreaterThanOrEqualTo(Date value) {
      addCriterion("submit_time >=", value, "submitTime");
      return (Criteria) this;
    }

    public Criteria andSubmitTimeLessThan(Date value) {
      addCriterion("submit_time <", value, "submitTime");
      return (Criteria) this;
    }

    public Criteria andSubmitTimeLessThanOrEqualTo(Date value) {
      addCriterion("submit_time <=", value, "submitTime");
      return (Criteria) this;
    }

    public Criteria andSubmitTimeIn(List<Date> values) {
      addCriterion("submit_time in", values, "submitTime");
      return (Criteria) this;
    }

    public Criteria andSubmitTimeNotIn(List<Date> values) {
      addCriterion("submit_time not in", values, "submitTime");
      return (Criteria) this;
    }

    public Criteria andSubmitTimeBetween(Date value1, Date value2) {
      addCriterion("submit_time between", value1, value2, "submitTime");
      return (Criteria) this;
    }

    public Criteria andSubmitTimeNotBetween(Date value1, Date value2) {
      addCriterion("submit_time not between", value1, value2, "submitTime");
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
   * 只读. t_coupon_offline_bind
   * @mbg.generated  2018-07-26 09:54:19
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
     * This class corresponds to the database table t_coupon_offline_bind
     *
     * @mbg.generated do_not_delete_during_merge 2018-06-30 15:18:35
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }
}