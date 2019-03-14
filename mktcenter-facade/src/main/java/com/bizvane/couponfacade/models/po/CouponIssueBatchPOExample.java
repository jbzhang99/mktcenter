package com.bizvane.couponfacade.models.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CouponIssueBatchPOExample implements Serializable {
    /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  protected String orderByClause;
  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  protected boolean distinct;
  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  protected List<Criteria> oredCriteria;
  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  private static final long serialVersionUID = 1L;

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  public CouponIssueBatchPOExample() {
    oredCriteria = new ArrayList<Criteria>();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  public void setOrderByClause(String orderByClause) {
    this.orderByClause = orderByClause;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  public String getOrderByClause() {
    return orderByClause;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  public void setDistinct(boolean distinct) {
    this.distinct = distinct;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  public boolean isDistinct() {
    return distinct;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  public List<Criteria> getOredCriteria() {
    return oredCriteria;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  public void or(Criteria criteria) {
    oredCriteria.add(criteria);
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  public Criteria or() {
    Criteria criteria = createCriteriaInternal();
    oredCriteria.add(criteria);
    return criteria;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
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
   * @mbg.generated  2018-07-06 10:56:28
   */
  protected Criteria createCriteriaInternal() {
    Criteria criteria = new Criteria();
    return criteria;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  public void clear() {
    oredCriteria.clear();
    orderByClause = null;
    distinct = false;
  }

  /**
   * 只读. t_coupon_issue_batch
   * @mbg.generated  2018-07-06 10:56:28
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

    public Criteria andCouponIssueBatchIdIsNull() {
      addCriterion("coupon_issue_batch_id is null");
      return (Criteria) this;
    }

    public Criteria andCouponIssueBatchIdIsNotNull() {
      addCriterion("coupon_issue_batch_id is not null");
      return (Criteria) this;
    }

    public Criteria andCouponIssueBatchIdEqualTo(Long value) {
      addCriterion("coupon_issue_batch_id =", value, "couponIssueBatchId");
      return (Criteria) this;
    }

    public Criteria andCouponIssueBatchIdNotEqualTo(Long value) {
      addCriterion("coupon_issue_batch_id <>", value, "couponIssueBatchId");
      return (Criteria) this;
    }

    public Criteria andCouponIssueBatchIdGreaterThan(Long value) {
      addCriterion("coupon_issue_batch_id >", value, "couponIssueBatchId");
      return (Criteria) this;
    }

    public Criteria andCouponIssueBatchIdGreaterThanOrEqualTo(Long value) {
      addCriterion("coupon_issue_batch_id >=", value, "couponIssueBatchId");
      return (Criteria) this;
    }

    public Criteria andCouponIssueBatchIdLessThan(Long value) {
      addCriterion("coupon_issue_batch_id <", value, "couponIssueBatchId");
      return (Criteria) this;
    }

    public Criteria andCouponIssueBatchIdLessThanOrEqualTo(Long value) {
      addCriterion("coupon_issue_batch_id <=", value, "couponIssueBatchId");
      return (Criteria) this;
    }

    public Criteria andCouponIssueBatchIdIn(List<Long> values) {
      addCriterion("coupon_issue_batch_id in", values, "couponIssueBatchId");
      return (Criteria) this;
    }

    public Criteria andCouponIssueBatchIdNotIn(List<Long> values) {
      addCriterion("coupon_issue_batch_id not in", values, "couponIssueBatchId");
      return (Criteria) this;
    }

    public Criteria andCouponIssueBatchIdBetween(Long value1, Long value2) {
      addCriterion("coupon_issue_batch_id between", value1, value2, "couponIssueBatchId");
      return (Criteria) this;
    }

    public Criteria andCouponIssueBatchIdNotBetween(Long value1, Long value2) {
      addCriterion("coupon_issue_batch_id not between", value1, value2, "couponIssueBatchId");
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

    public Criteria andIssueBatchCodeIsNull() {
      addCriterion("issue_batch_code is null");
      return (Criteria) this;
    }

    public Criteria andIssueBatchCodeIsNotNull() {
      addCriterion("issue_batch_code is not null");
      return (Criteria) this;
    }

    public Criteria andIssueBatchCodeEqualTo(String value) {
      addCriterion("issue_batch_code =", value, "issueBatchCode");
      return (Criteria) this;
    }

    public Criteria andIssueBatchCodeNotEqualTo(String value) {
      addCriterion("issue_batch_code <>", value, "issueBatchCode");
      return (Criteria) this;
    }

    public Criteria andIssueBatchCodeGreaterThan(String value) {
      addCriterion("issue_batch_code >", value, "issueBatchCode");
      return (Criteria) this;
    }

    public Criteria andIssueBatchCodeGreaterThanOrEqualTo(String value) {
      addCriterion("issue_batch_code >=", value, "issueBatchCode");
      return (Criteria) this;
    }

    public Criteria andIssueBatchCodeLessThan(String value) {
      addCriterion("issue_batch_code <", value, "issueBatchCode");
      return (Criteria) this;
    }

    public Criteria andIssueBatchCodeLessThanOrEqualTo(String value) {
      addCriterion("issue_batch_code <=", value, "issueBatchCode");
      return (Criteria) this;
    }

    public Criteria andIssueBatchCodeLike(String value) {
      addCriterion("issue_batch_code like", value, "issueBatchCode");
      return (Criteria) this;
    }

    public Criteria andIssueBatchCodeNotLike(String value) {
      addCriterion("issue_batch_code not like", value, "issueBatchCode");
      return (Criteria) this;
    }

    public Criteria andIssueBatchCodeIn(List<String> values) {
      addCriterion("issue_batch_code in", values, "issueBatchCode");
      return (Criteria) this;
    }

    public Criteria andIssueBatchCodeNotIn(List<String> values) {
      addCriterion("issue_batch_code not in", values, "issueBatchCode");
      return (Criteria) this;
    }

    public Criteria andIssueBatchCodeBetween(String value1, String value2) {
      addCriterion("issue_batch_code between", value1, value2, "issueBatchCode");
      return (Criteria) this;
    }

    public Criteria andIssueBatchCodeNotBetween(String value1, String value2) {
      addCriterion("issue_batch_code not between", value1, value2, "issueBatchCode");
      return (Criteria) this;
    }

    public Criteria andIssueNumIsNull() {
      addCriterion("issue_num is null");
      return (Criteria) this;
    }

    public Criteria andIssueNumIsNotNull() {
      addCriterion("issue_num is not null");
      return (Criteria) this;
    }

    public Criteria andIssueNumEqualTo(Integer value) {
      addCriterion("issue_num =", value, "issueNum");
      return (Criteria) this;
    }

    public Criteria andIssueNumNotEqualTo(Integer value) {
      addCriterion("issue_num <>", value, "issueNum");
      return (Criteria) this;
    }

    public Criteria andIssueNumGreaterThan(Integer value) {
      addCriterion("issue_num >", value, "issueNum");
      return (Criteria) this;
    }

    public Criteria andIssueNumGreaterThanOrEqualTo(Integer value) {
      addCriterion("issue_num >=", value, "issueNum");
      return (Criteria) this;
    }

    public Criteria andIssueNumLessThan(Integer value) {
      addCriterion("issue_num <", value, "issueNum");
      return (Criteria) this;
    }

    public Criteria andIssueNumLessThanOrEqualTo(Integer value) {
      addCriterion("issue_num <=", value, "issueNum");
      return (Criteria) this;
    }

    public Criteria andIssueNumIn(List<Integer> values) {
      addCriterion("issue_num in", values, "issueNum");
      return (Criteria) this;
    }

    public Criteria andIssueNumNotIn(List<Integer> values) {
      addCriterion("issue_num not in", values, "issueNum");
      return (Criteria) this;
    }

    public Criteria andIssueNumBetween(Integer value1, Integer value2) {
      addCriterion("issue_num between", value1, value2, "issueNum");
      return (Criteria) this;
    }

    public Criteria andIssueNumNotBetween(Integer value1, Integer value2) {
      addCriterion("issue_num not between", value1, value2, "issueNum");
      return (Criteria) this;
    }

    public Criteria andIssueFailNumIsNull() {
      addCriterion("issue_fail_num is null");
      return (Criteria) this;
    }

    public Criteria andIssueFailNumIsNotNull() {
      addCriterion("issue_fail_num is not null");
      return (Criteria) this;
    }

    public Criteria andIssueFailNumEqualTo(Integer value) {
      addCriterion("issue_fail_num =", value, "issueFailNum");
      return (Criteria) this;
    }

    public Criteria andIssueFailNumNotEqualTo(Integer value) {
      addCriterion("issue_fail_num <>", value, "issueFailNum");
      return (Criteria) this;
    }

    public Criteria andIssueFailNumGreaterThan(Integer value) {
      addCriterion("issue_fail_num >", value, "issueFailNum");
      return (Criteria) this;
    }

    public Criteria andIssueFailNumGreaterThanOrEqualTo(Integer value) {
      addCriterion("issue_fail_num >=", value, "issueFailNum");
      return (Criteria) this;
    }

    public Criteria andIssueFailNumLessThan(Integer value) {
      addCriterion("issue_fail_num <", value, "issueFailNum");
      return (Criteria) this;
    }

    public Criteria andIssueFailNumLessThanOrEqualTo(Integer value) {
      addCriterion("issue_fail_num <=", value, "issueFailNum");
      return (Criteria) this;
    }

    public Criteria andIssueFailNumIn(List<Integer> values) {
      addCriterion("issue_fail_num in", values, "issueFailNum");
      return (Criteria) this;
    }

    public Criteria andIssueFailNumNotIn(List<Integer> values) {
      addCriterion("issue_fail_num not in", values, "issueFailNum");
      return (Criteria) this;
    }

    public Criteria andIssueFailNumBetween(Integer value1, Integer value2) {
      addCriterion("issue_fail_num between", value1, value2, "issueFailNum");
      return (Criteria) this;
    }

    public Criteria andIssueFailNumNotBetween(Integer value1, Integer value2) {
      addCriterion("issue_fail_num not between", value1, value2, "issueFailNum");
      return (Criteria) this;
    }

    public Criteria andIssueUserIdIsNull() {
      addCriterion("issue_user_id is null");
      return (Criteria) this;
    }

    public Criteria andIssueUserIdIsNotNull() {
      addCriterion("issue_user_id is not null");
      return (Criteria) this;
    }

    public Criteria andIssueUserIdEqualTo(Long value) {
      addCriterion("issue_user_id =", value, "issueUserId");
      return (Criteria) this;
    }

    public Criteria andIssueUserIdNotEqualTo(Long value) {
      addCriterion("issue_user_id <>", value, "issueUserId");
      return (Criteria) this;
    }

    public Criteria andIssueUserIdGreaterThan(Long value) {
      addCriterion("issue_user_id >", value, "issueUserId");
      return (Criteria) this;
    }

    public Criteria andIssueUserIdGreaterThanOrEqualTo(Long value) {
      addCriterion("issue_user_id >=", value, "issueUserId");
      return (Criteria) this;
    }

    public Criteria andIssueUserIdLessThan(Long value) {
      addCriterion("issue_user_id <", value, "issueUserId");
      return (Criteria) this;
    }

    public Criteria andIssueUserIdLessThanOrEqualTo(Long value) {
      addCriterion("issue_user_id <=", value, "issueUserId");
      return (Criteria) this;
    }

    public Criteria andIssueUserIdIn(List<Long> values) {
      addCriterion("issue_user_id in", values, "issueUserId");
      return (Criteria) this;
    }

    public Criteria andIssueUserIdNotIn(List<Long> values) {
      addCriterion("issue_user_id not in", values, "issueUserId");
      return (Criteria) this;
    }

    public Criteria andIssueUserIdBetween(Long value1, Long value2) {
      addCriterion("issue_user_id between", value1, value2, "issueUserId");
      return (Criteria) this;
    }

    public Criteria andIssueUserIdNotBetween(Long value1, Long value2) {
      addCriterion("issue_user_id not between", value1, value2, "issueUserId");
      return (Criteria) this;
    }

    public Criteria andIssueUserNameIsNull() {
      addCriterion("issue_user_name is null");
      return (Criteria) this;
    }

    public Criteria andIssueUserNameIsNotNull() {
      addCriterion("issue_user_name is not null");
      return (Criteria) this;
    }

    public Criteria andIssueUserNameEqualTo(String value) {
      addCriterion("issue_user_name =", value, "issueUserName");
      return (Criteria) this;
    }

    public Criteria andIssueUserNameNotEqualTo(String value) {
      addCriterion("issue_user_name <>", value, "issueUserName");
      return (Criteria) this;
    }

    public Criteria andIssueUserNameGreaterThan(String value) {
      addCriterion("issue_user_name >", value, "issueUserName");
      return (Criteria) this;
    }

    public Criteria andIssueUserNameGreaterThanOrEqualTo(String value) {
      addCriterion("issue_user_name >=", value, "issueUserName");
      return (Criteria) this;
    }

    public Criteria andIssueUserNameLessThan(String value) {
      addCriterion("issue_user_name <", value, "issueUserName");
      return (Criteria) this;
    }

    public Criteria andIssueUserNameLessThanOrEqualTo(String value) {
      addCriterion("issue_user_name <=", value, "issueUserName");
      return (Criteria) this;
    }

    public Criteria andIssueUserNameLike(String value) {
      addCriterion("issue_user_name like", value, "issueUserName");
      return (Criteria) this;
    }

    public Criteria andIssueUserNameNotLike(String value) {
      addCriterion("issue_user_name not like", value, "issueUserName");
      return (Criteria) this;
    }

    public Criteria andIssueUserNameIn(List<String> values) {
      addCriterion("issue_user_name in", values, "issueUserName");
      return (Criteria) this;
    }

    public Criteria andIssueUserNameNotIn(List<String> values) {
      addCriterion("issue_user_name not in", values, "issueUserName");
      return (Criteria) this;
    }

    public Criteria andIssueUserNameBetween(String value1, String value2) {
      addCriterion("issue_user_name between", value1, value2, "issueUserName");
      return (Criteria) this;
    }

    public Criteria andIssueUserNameNotBetween(String value1, String value2) {
      addCriterion("issue_user_name not between", value1, value2, "issueUserName");
      return (Criteria) this;
    }

    public Criteria andIssueTimeIsNull() {
      addCriterion("issue_time is null");
      return (Criteria) this;
    }

    public Criteria andIssueTimeIsNotNull() {
      addCriterion("issue_time is not null");
      return (Criteria) this;
    }

    public Criteria andIssueTimeEqualTo(Date value) {
      addCriterion("issue_time =", value, "issueTime");
      return (Criteria) this;
    }

    public Criteria andIssueTimeNotEqualTo(Date value) {
      addCriterion("issue_time <>", value, "issueTime");
      return (Criteria) this;
    }

    public Criteria andIssueTimeGreaterThan(Date value) {
      addCriterion("issue_time >", value, "issueTime");
      return (Criteria) this;
    }

    public Criteria andIssueTimeGreaterThanOrEqualTo(Date value) {
      addCriterion("issue_time >=", value, "issueTime");
      return (Criteria) this;
    }

    public Criteria andIssueTimeLessThan(Date value) {
      addCriterion("issue_time <", value, "issueTime");
      return (Criteria) this;
    }

    public Criteria andIssueTimeLessThanOrEqualTo(Date value) {
      addCriterion("issue_time <=", value, "issueTime");
      return (Criteria) this;
    }

    public Criteria andIssueTimeIn(List<Date> values) {
      addCriterion("issue_time in", values, "issueTime");
      return (Criteria) this;
    }

    public Criteria andIssueTimeNotIn(List<Date> values) {
      addCriterion("issue_time not in", values, "issueTime");
      return (Criteria) this;
    }

    public Criteria andIssueTimeBetween(Date value1, Date value2) {
      addCriterion("issue_time between", value1, value2, "issueTime");
      return (Criteria) this;
    }

    public Criteria andIssueTimeNotBetween(Date value1, Date value2) {
      addCriterion("issue_time not between", value1, value2, "issueTime");
      return (Criteria) this;
    }

    public Criteria andCheckUserIdIsNull() {
      addCriterion("check_user_id is null");
      return (Criteria) this;
    }

    public Criteria andCheckUserIdIsNotNull() {
      addCriterion("check_user_id is not null");
      return (Criteria) this;
    }

    public Criteria andCheckUserIdEqualTo(Long value) {
      addCriterion("check_user_id =", value, "checkUserId");
      return (Criteria) this;
    }

    public Criteria andCheckUserIdNotEqualTo(Long value) {
      addCriterion("check_user_id <>", value, "checkUserId");
      return (Criteria) this;
    }

    public Criteria andCheckUserIdGreaterThan(Long value) {
      addCriterion("check_user_id >", value, "checkUserId");
      return (Criteria) this;
    }

    public Criteria andCheckUserIdGreaterThanOrEqualTo(Long value) {
      addCriterion("check_user_id >=", value, "checkUserId");
      return (Criteria) this;
    }

    public Criteria andCheckUserIdLessThan(Long value) {
      addCriterion("check_user_id <", value, "checkUserId");
      return (Criteria) this;
    }

    public Criteria andCheckUserIdLessThanOrEqualTo(Long value) {
      addCriterion("check_user_id <=", value, "checkUserId");
      return (Criteria) this;
    }

    public Criteria andCheckUserIdIn(List<Long> values) {
      addCriterion("check_user_id in", values, "checkUserId");
      return (Criteria) this;
    }

    public Criteria andCheckUserIdNotIn(List<Long> values) {
      addCriterion("check_user_id not in", values, "checkUserId");
      return (Criteria) this;
    }

    public Criteria andCheckUserIdBetween(Long value1, Long value2) {
      addCriterion("check_user_id between", value1, value2, "checkUserId");
      return (Criteria) this;
    }

    public Criteria andCheckUserIdNotBetween(Long value1, Long value2) {
      addCriterion("check_user_id not between", value1, value2, "checkUserId");
      return (Criteria) this;
    }

    public Criteria andCheckUserNameIsNull() {
      addCriterion("check_user_name is null");
      return (Criteria) this;
    }

    public Criteria andCheckUserNameIsNotNull() {
      addCriterion("check_user_name is not null");
      return (Criteria) this;
    }

    public Criteria andCheckUserNameEqualTo(String value) {
      addCriterion("check_user_name =", value, "checkUserName");
      return (Criteria) this;
    }

    public Criteria andCheckUserNameNotEqualTo(String value) {
      addCriterion("check_user_name <>", value, "checkUserName");
      return (Criteria) this;
    }

    public Criteria andCheckUserNameGreaterThan(String value) {
      addCriterion("check_user_name >", value, "checkUserName");
      return (Criteria) this;
    }

    public Criteria andCheckUserNameGreaterThanOrEqualTo(String value) {
      addCriterion("check_user_name >=", value, "checkUserName");
      return (Criteria) this;
    }

    public Criteria andCheckUserNameLessThan(String value) {
      addCriterion("check_user_name <", value, "checkUserName");
      return (Criteria) this;
    }

    public Criteria andCheckUserNameLessThanOrEqualTo(String value) {
      addCriterion("check_user_name <=", value, "checkUserName");
      return (Criteria) this;
    }

    public Criteria andCheckUserNameLike(String value) {
      addCriterion("check_user_name like", value, "checkUserName");
      return (Criteria) this;
    }

    public Criteria andCheckUserNameNotLike(String value) {
      addCriterion("check_user_name not like", value, "checkUserName");
      return (Criteria) this;
    }

    public Criteria andCheckUserNameIn(List<String> values) {
      addCriterion("check_user_name in", values, "checkUserName");
      return (Criteria) this;
    }

    public Criteria andCheckUserNameNotIn(List<String> values) {
      addCriterion("check_user_name not in", values, "checkUserName");
      return (Criteria) this;
    }

    public Criteria andCheckUserNameBetween(String value1, String value2) {
      addCriterion("check_user_name between", value1, value2, "checkUserName");
      return (Criteria) this;
    }

    public Criteria andCheckUserNameNotBetween(String value1, String value2) {
      addCriterion("check_user_name not between", value1, value2, "checkUserName");
      return (Criteria) this;
    }

    public Criteria andIssueStatusIsNull() {
      addCriterion("issue_status is null");
      return (Criteria) this;
    }

    public Criteria andIssueStatusIsNotNull() {
      addCriterion("issue_status is not null");
      return (Criteria) this;
    }

    public Criteria andIssueStatusEqualTo(Byte value) {
      addCriterion("issue_status =", value, "issueStatus");
      return (Criteria) this;
    }

    public Criteria andIssueStatusNotEqualTo(Byte value) {
      addCriterion("issue_status <>", value, "issueStatus");
      return (Criteria) this;
    }

    public Criteria andIssueStatusGreaterThan(Byte value) {
      addCriterion("issue_status >", value, "issueStatus");
      return (Criteria) this;
    }

    public Criteria andIssueStatusGreaterThanOrEqualTo(Byte value) {
      addCriterion("issue_status >=", value, "issueStatus");
      return (Criteria) this;
    }

    public Criteria andIssueStatusLessThan(Byte value) {
      addCriterion("issue_status <", value, "issueStatus");
      return (Criteria) this;
    }

    public Criteria andIssueStatusLessThanOrEqualTo(Byte value) {
      addCriterion("issue_status <=", value, "issueStatus");
      return (Criteria) this;
    }

    public Criteria andIssueStatusIn(List<Byte> values) {
      addCriterion("issue_status in", values, "issueStatus");
      return (Criteria) this;
    }

    public Criteria andIssueStatusNotIn(List<Byte> values) {
      addCriterion("issue_status not in", values, "issueStatus");
      return (Criteria) this;
    }

    public Criteria andIssueStatusBetween(Byte value1, Byte value2) {
      addCriterion("issue_status between", value1, value2, "issueStatus");
      return (Criteria) this;
    }

    public Criteria andIssueStatusNotBetween(Byte value1, Byte value2) {
      addCriterion("issue_status not between", value1, value2, "issueStatus");
      return (Criteria) this;
    }

    public Criteria andOfflineSyncIsNull() {
      addCriterion("offline_sync is null");
      return (Criteria) this;
    }

    public Criteria andOfflineSyncIsNotNull() {
      addCriterion("offline_sync is not null");
      return (Criteria) this;
    }

    public Criteria andOfflineSyncEqualTo(Boolean value) {
      addCriterion("offline_sync =", value, "offlineSync");
      return (Criteria) this;
    }

    public Criteria andOfflineSyncNotEqualTo(Boolean value) {
      addCriterion("offline_sync <>", value, "offlineSync");
      return (Criteria) this;
    }

    public Criteria andOfflineSyncGreaterThan(Boolean value) {
      addCriterion("offline_sync >", value, "offlineSync");
      return (Criteria) this;
    }

    public Criteria andOfflineSyncGreaterThanOrEqualTo(Boolean value) {
      addCriterion("offline_sync >=", value, "offlineSync");
      return (Criteria) this;
    }

    public Criteria andOfflineSyncLessThan(Boolean value) {
      addCriterion("offline_sync <", value, "offlineSync");
      return (Criteria) this;
    }

    public Criteria andOfflineSyncLessThanOrEqualTo(Boolean value) {
      addCriterion("offline_sync <=", value, "offlineSync");
      return (Criteria) this;
    }

    public Criteria andOfflineSyncIn(List<Boolean> values) {
      addCriterion("offline_sync in", values, "offlineSync");
      return (Criteria) this;
    }

    public Criteria andOfflineSyncNotIn(List<Boolean> values) {
      addCriterion("offline_sync not in", values, "offlineSync");
      return (Criteria) this;
    }

    public Criteria andOfflineSyncBetween(Boolean value1, Boolean value2) {
      addCriterion("offline_sync between", value1, value2, "offlineSync");
      return (Criteria) this;
    }

    public Criteria andOfflineSyncNotBetween(Boolean value1, Boolean value2) {
      addCriterion("offline_sync not between", value1, value2, "offlineSync");
      return (Criteria) this;
    }

    public Criteria andSyncStatusIsNull() {
      addCriterion("sync_status is null");
      return (Criteria) this;
    }

    public Criteria andSyncStatusIsNotNull() {
      addCriterion("sync_status is not null");
      return (Criteria) this;
    }

    public Criteria andSyncStatusEqualTo(Byte value) {
      addCriterion("sync_status =", value, "syncStatus");
      return (Criteria) this;
    }

    public Criteria andSyncStatusNotEqualTo(Byte value) {
      addCriterion("sync_status <>", value, "syncStatus");
      return (Criteria) this;
    }

    public Criteria andSyncStatusGreaterThan(Byte value) {
      addCriterion("sync_status >", value, "syncStatus");
      return (Criteria) this;
    }

    public Criteria andSyncStatusGreaterThanOrEqualTo(Byte value) {
      addCriterion("sync_status >=", value, "syncStatus");
      return (Criteria) this;
    }

    public Criteria andSyncStatusLessThan(Byte value) {
      addCriterion("sync_status <", value, "syncStatus");
      return (Criteria) this;
    }

    public Criteria andSyncStatusLessThanOrEqualTo(Byte value) {
      addCriterion("sync_status <=", value, "syncStatus");
      return (Criteria) this;
    }

    public Criteria andSyncStatusIn(List<Byte> values) {
      addCriterion("sync_status in", values, "syncStatus");
      return (Criteria) this;
    }

    public Criteria andSyncStatusNotIn(List<Byte> values) {
      addCriterion("sync_status not in", values, "syncStatus");
      return (Criteria) this;
    }

    public Criteria andSyncStatusBetween(Byte value1, Byte value2) {
      addCriterion("sync_status between", value1, value2, "syncStatus");
      return (Criteria) this;
    }

    public Criteria andSyncStatusNotBetween(Byte value1, Byte value2) {
      addCriterion("sync_status not between", value1, value2, "syncStatus");
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
   * 只读. t_coupon_issue_batch
   * @mbg.generated  2018-07-06 10:56:28
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
     * This class corresponds to the database table t_coupon_issue_batch
     *
     * @mbg.generated do_not_delete_during_merge 2018-06-30 15:18:35
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }
}