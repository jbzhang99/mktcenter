package com.bizvane.mktcenterfacade.models.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MktActivityPOExample implements Serializable {
    /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  protected String orderByClause;
  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  protected boolean distinct;
  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  protected List<Criteria> oredCriteria;

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public MktActivityPOExample() {
    oredCriteria = new ArrayList<Criteria>();
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public void setOrderByClause(String orderByClause) {
    this.orderByClause = orderByClause;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public String getOrderByClause() {
    return orderByClause;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public void setDistinct(boolean distinct) {
    this.distinct = distinct;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public boolean isDistinct() {
    return distinct;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public List<Criteria> getOredCriteria() {
    return oredCriteria;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public void or(Criteria criteria) {
    oredCriteria.add(criteria);
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public Criteria or() {
    Criteria criteria = createCriteriaInternal();
    oredCriteria.add(criteria);
    return criteria;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
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
   * @mbg.generated  2019-05-24 15:35:50
   */
  protected Criteria createCriteriaInternal() {
    Criteria criteria = new Criteria();
    return criteria;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public void clear() {
    oredCriteria.clear();
    orderByClause = null;
    distinct = false;
  }

  /**
   * 只读. t_mkt_activity
   * @mbg.generated  2019-05-24 15:35:50
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

    public Criteria andMbrGroupDefIdIsNull() {
      addCriterion("mbr_group_def_id is null");
      return (Criteria) this;
    }

    public Criteria andMbrGroupDefIdIsNotNull() {
      addCriterion("mbr_group_def_id is not null");
      return (Criteria) this;
    }

    public Criteria andMbrGroupDefIdEqualTo(Long value) {
      addCriterion("mbr_group_def_id =", value, "mbrGroupDefId");
      return (Criteria) this;
    }

    public Criteria andMbrGroupDefIdNotEqualTo(Long value) {
      addCriterion("mbr_group_def_id <>", value, "mbrGroupDefId");
      return (Criteria) this;
    }

    public Criteria andMbrGroupDefIdGreaterThan(Long value) {
      addCriterion("mbr_group_def_id >", value, "mbrGroupDefId");
      return (Criteria) this;
    }

    public Criteria andMbrGroupDefIdGreaterThanOrEqualTo(Long value) {
      addCriterion("mbr_group_def_id >=", value, "mbrGroupDefId");
      return (Criteria) this;
    }

    public Criteria andMbrGroupDefIdLessThan(Long value) {
      addCriterion("mbr_group_def_id <", value, "mbrGroupDefId");
      return (Criteria) this;
    }

    public Criteria andMbrGroupDefIdLessThanOrEqualTo(Long value) {
      addCriterion("mbr_group_def_id <=", value, "mbrGroupDefId");
      return (Criteria) this;
    }

    public Criteria andMbrGroupDefIdIn(List<Long> values) {
      addCriterion("mbr_group_def_id in", values, "mbrGroupDefId");
      return (Criteria) this;
    }

    public Criteria andMbrGroupDefIdNotIn(List<Long> values) {
      addCriterion("mbr_group_def_id not in", values, "mbrGroupDefId");
      return (Criteria) this;
    }

    public Criteria andMbrGroupDefIdBetween(Long value1, Long value2) {
      addCriterion("mbr_group_def_id between", value1, value2, "mbrGroupDefId");
      return (Criteria) this;
    }

    public Criteria andMbrGroupDefIdNotBetween(Long value1, Long value2) {
      addCriterion("mbr_group_def_id not between", value1, value2, "mbrGroupDefId");
      return (Criteria) this;
    }

    public Criteria andMktActivitySmartGroupIdIsNull() {
      addCriterion("mkt_activity_smart_group_id is null");
      return (Criteria) this;
    }

    public Criteria andMktActivitySmartGroupIdIsNotNull() {
      addCriterion("mkt_activity_smart_group_id is not null");
      return (Criteria) this;
    }

    public Criteria andMktActivitySmartGroupIdEqualTo(Long value) {
      addCriterion("mkt_activity_smart_group_id =", value, "mktActivitySmartGroupId");
      return (Criteria) this;
    }

    public Criteria andMktActivitySmartGroupIdNotEqualTo(Long value) {
      addCriterion("mkt_activity_smart_group_id <>", value, "mktActivitySmartGroupId");
      return (Criteria) this;
    }

    public Criteria andMktActivitySmartGroupIdGreaterThan(Long value) {
      addCriterion("mkt_activity_smart_group_id >", value, "mktActivitySmartGroupId");
      return (Criteria) this;
    }

    public Criteria andMktActivitySmartGroupIdGreaterThanOrEqualTo(Long value) {
      addCriterion("mkt_activity_smart_group_id >=", value, "mktActivitySmartGroupId");
      return (Criteria) this;
    }

    public Criteria andMktActivitySmartGroupIdLessThan(Long value) {
      addCriterion("mkt_activity_smart_group_id <", value, "mktActivitySmartGroupId");
      return (Criteria) this;
    }

    public Criteria andMktActivitySmartGroupIdLessThanOrEqualTo(Long value) {
      addCriterion("mkt_activity_smart_group_id <=", value, "mktActivitySmartGroupId");
      return (Criteria) this;
    }

    public Criteria andMktActivitySmartGroupIdIn(List<Long> values) {
      addCriterion("mkt_activity_smart_group_id in", values, "mktActivitySmartGroupId");
      return (Criteria) this;
    }

    public Criteria andMktActivitySmartGroupIdNotIn(List<Long> values) {
      addCriterion("mkt_activity_smart_group_id not in", values, "mktActivitySmartGroupId");
      return (Criteria) this;
    }

    public Criteria andMktActivitySmartGroupIdBetween(Long value1, Long value2) {
      addCriterion("mkt_activity_smart_group_id between", value1, value2, "mktActivitySmartGroupId");
      return (Criteria) this;
    }

    public Criteria andMktActivitySmartGroupIdNotBetween(Long value1, Long value2) {
      addCriterion("mkt_activity_smart_group_id not between", value1, value2, "mktActivitySmartGroupId");
      return (Criteria) this;
    }

    public Criteria andActivityCodeIsNull() {
      addCriterion("activity_code is null");
      return (Criteria) this;
    }

    public Criteria andActivityCodeIsNotNull() {
      addCriterion("activity_code is not null");
      return (Criteria) this;
    }

    public Criteria andActivityCodeEqualTo(String value) {
      addCriterion("activity_code =", value, "activityCode");
      return (Criteria) this;
    }

    public Criteria andActivityCodeNotEqualTo(String value) {
      addCriterion("activity_code <>", value, "activityCode");
      return (Criteria) this;
    }

    public Criteria andActivityCodeGreaterThan(String value) {
      addCriterion("activity_code >", value, "activityCode");
      return (Criteria) this;
    }

    public Criteria andActivityCodeGreaterThanOrEqualTo(String value) {
      addCriterion("activity_code >=", value, "activityCode");
      return (Criteria) this;
    }

    public Criteria andActivityCodeLessThan(String value) {
      addCriterion("activity_code <", value, "activityCode");
      return (Criteria) this;
    }

    public Criteria andActivityCodeLessThanOrEqualTo(String value) {
      addCriterion("activity_code <=", value, "activityCode");
      return (Criteria) this;
    }

    public Criteria andActivityCodeLike(String value) {
      addCriterion("activity_code like", value, "activityCode");
      return (Criteria) this;
    }

    public Criteria andActivityCodeNotLike(String value) {
      addCriterion("activity_code not like", value, "activityCode");
      return (Criteria) this;
    }

    public Criteria andActivityCodeIn(List<String> values) {
      addCriterion("activity_code in", values, "activityCode");
      return (Criteria) this;
    }

    public Criteria andActivityCodeNotIn(List<String> values) {
      addCriterion("activity_code not in", values, "activityCode");
      return (Criteria) this;
    }

    public Criteria andActivityCodeBetween(String value1, String value2) {
      addCriterion("activity_code between", value1, value2, "activityCode");
      return (Criteria) this;
    }

    public Criteria andActivityCodeNotBetween(String value1, String value2) {
      addCriterion("activity_code not between", value1, value2, "activityCode");
      return (Criteria) this;
    }

    public Criteria andActivityTypeIsNull() {
      addCriterion("activity_type is null");
      return (Criteria) this;
    }

    public Criteria andActivityTypeIsNotNull() {
      addCriterion("activity_type is not null");
      return (Criteria) this;
    }

    public Criteria andActivityTypeEqualTo(Integer value) {
      addCriterion("activity_type =", value, "activityType");
      return (Criteria) this;
    }

    public Criteria andActivityTypeNotEqualTo(Integer value) {
      addCriterion("activity_type <>", value, "activityType");
      return (Criteria) this;
    }

    public Criteria andActivityTypeGreaterThan(Integer value) {
      addCriterion("activity_type >", value, "activityType");
      return (Criteria) this;
    }

    public Criteria andActivityTypeGreaterThanOrEqualTo(Integer value) {
      addCriterion("activity_type >=", value, "activityType");
      return (Criteria) this;
    }

    public Criteria andActivityTypeLessThan(Integer value) {
      addCriterion("activity_type <", value, "activityType");
      return (Criteria) this;
    }

    public Criteria andActivityTypeLessThanOrEqualTo(Integer value) {
      addCriterion("activity_type <=", value, "activityType");
      return (Criteria) this;
    }

    public Criteria andActivityTypeIn(List<Integer> values) {
      addCriterion("activity_type in", values, "activityType");
      return (Criteria) this;
    }

    public Criteria andActivityTypeNotIn(List<Integer> values) {
      addCriterion("activity_type not in", values, "activityType");
      return (Criteria) this;
    }

    public Criteria andActivityTypeBetween(Integer value1, Integer value2) {
      addCriterion("activity_type between", value1, value2, "activityType");
      return (Criteria) this;
    }

    public Criteria andActivityTypeNotBetween(Integer value1, Integer value2) {
      addCriterion("activity_type not between", value1, value2, "activityType");
      return (Criteria) this;
    }

    public Criteria andActivityNameIsNull() {
      addCriterion("activity_name is null");
      return (Criteria) this;
    }

    public Criteria andActivityNameIsNotNull() {
      addCriterion("activity_name is not null");
      return (Criteria) this;
    }

    public Criteria andActivityNameEqualTo(String value) {
      addCriterion("activity_name =", value, "activityName");
      return (Criteria) this;
    }

    public Criteria andActivityNameNotEqualTo(String value) {
      addCriterion("activity_name <>", value, "activityName");
      return (Criteria) this;
    }

    public Criteria andActivityNameGreaterThan(String value) {
      addCriterion("activity_name >", value, "activityName");
      return (Criteria) this;
    }

    public Criteria andActivityNameGreaterThanOrEqualTo(String value) {
      addCriterion("activity_name >=", value, "activityName");
      return (Criteria) this;
    }

    public Criteria andActivityNameLessThan(String value) {
      addCriterion("activity_name <", value, "activityName");
      return (Criteria) this;
    }

    public Criteria andActivityNameLessThanOrEqualTo(String value) {
      addCriterion("activity_name <=", value, "activityName");
      return (Criteria) this;
    }

    public Criteria andActivityNameLike(String value) {
      addCriterion("activity_name like", value, "activityName");
      return (Criteria) this;
    }

    public Criteria andActivityNameNotLike(String value) {
      addCriterion("activity_name not like", value, "activityName");
      return (Criteria) this;
    }

    public Criteria andActivityNameIn(List<String> values) {
      addCriterion("activity_name in", values, "activityName");
      return (Criteria) this;
    }

    public Criteria andActivityNameNotIn(List<String> values) {
      addCriterion("activity_name not in", values, "activityName");
      return (Criteria) this;
    }

    public Criteria andActivityNameBetween(String value1, String value2) {
      addCriterion("activity_name between", value1, value2, "activityName");
      return (Criteria) this;
    }

    public Criteria andActivityNameNotBetween(String value1, String value2) {
      addCriterion("activity_name not between", value1, value2, "activityName");
      return (Criteria) this;
    }

    public Criteria andStartTimeIsNull() {
      addCriterion("start_time is null");
      return (Criteria) this;
    }

    public Criteria andStartTimeIsNotNull() {
      addCriterion("start_time is not null");
      return (Criteria) this;
    }

    public Criteria andStartTimeEqualTo(Date value) {
      addCriterion("start_time =", value, "startTime");
      return (Criteria) this;
    }

    public Criteria andStartTimeNotEqualTo(Date value) {
      addCriterion("start_time <>", value, "startTime");
      return (Criteria) this;
    }

    public Criteria andStartTimeGreaterThan(Date value) {
      addCriterion("start_time >", value, "startTime");
      return (Criteria) this;
    }

    public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
      addCriterion("start_time >=", value, "startTime");
      return (Criteria) this;
    }

    public Criteria andStartTimeLessThan(Date value) {
      addCriterion("start_time <", value, "startTime");
      return (Criteria) this;
    }

    public Criteria andStartTimeLessThanOrEqualTo(Date value) {
      addCriterion("start_time <=", value, "startTime");
      return (Criteria) this;
    }

    public Criteria andStartTimeIn(List<Date> values) {
      addCriterion("start_time in", values, "startTime");
      return (Criteria) this;
    }

    public Criteria andStartTimeNotIn(List<Date> values) {
      addCriterion("start_time not in", values, "startTime");
      return (Criteria) this;
    }

    public Criteria andStartTimeBetween(Date value1, Date value2) {
      addCriterion("start_time between", value1, value2, "startTime");
      return (Criteria) this;
    }

    public Criteria andStartTimeNotBetween(Date value1, Date value2) {
      addCriterion("start_time not between", value1, value2, "startTime");
      return (Criteria) this;
    }

    public Criteria andEndTimeIsNull() {
      addCriterion("end_time is null");
      return (Criteria) this;
    }

    public Criteria andEndTimeIsNotNull() {
      addCriterion("end_time is not null");
      return (Criteria) this;
    }

    public Criteria andEndTimeEqualTo(Date value) {
      addCriterion("end_time =", value, "endTime");
      return (Criteria) this;
    }

    public Criteria andEndTimeNotEqualTo(Date value) {
      addCriterion("end_time <>", value, "endTime");
      return (Criteria) this;
    }

    public Criteria andEndTimeGreaterThan(Date value) {
      addCriterion("end_time >", value, "endTime");
      return (Criteria) this;
    }

    public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
      addCriterion("end_time >=", value, "endTime");
      return (Criteria) this;
    }

    public Criteria andEndTimeLessThan(Date value) {
      addCriterion("end_time <", value, "endTime");
      return (Criteria) this;
    }

    public Criteria andEndTimeLessThanOrEqualTo(Date value) {
      addCriterion("end_time <=", value, "endTime");
      return (Criteria) this;
    }

    public Criteria andEndTimeIn(List<Date> values) {
      addCriterion("end_time in", values, "endTime");
      return (Criteria) this;
    }

    public Criteria andEndTimeNotIn(List<Date> values) {
      addCriterion("end_time not in", values, "endTime");
      return (Criteria) this;
    }

    public Criteria andEndTimeBetween(Date value1, Date value2) {
      addCriterion("end_time between", value1, value2, "endTime");
      return (Criteria) this;
    }

    public Criteria andEndTimeNotBetween(Date value1, Date value2) {
      addCriterion("end_time not between", value1, value2, "endTime");
      return (Criteria) this;
    }

    public Criteria andLongTermIsNull() {
      addCriterion("long_term is null");
      return (Criteria) this;
    }

    public Criteria andLongTermIsNotNull() {
      addCriterion("long_term is not null");
      return (Criteria) this;
    }

    public Criteria andLongTermEqualTo(Integer value) {
      addCriterion("long_term =", value, "longTerm");
      return (Criteria) this;
    }

    public Criteria andLongTermNotEqualTo(Integer value) {
      addCriterion("long_term <>", value, "longTerm");
      return (Criteria) this;
    }

    public Criteria andLongTermGreaterThan(Integer value) {
      addCriterion("long_term >", value, "longTerm");
      return (Criteria) this;
    }

    public Criteria andLongTermGreaterThanOrEqualTo(Integer value) {
      addCriterion("long_term >=", value, "longTerm");
      return (Criteria) this;
    }

    public Criteria andLongTermLessThan(Integer value) {
      addCriterion("long_term <", value, "longTerm");
      return (Criteria) this;
    }

    public Criteria andLongTermLessThanOrEqualTo(Integer value) {
      addCriterion("long_term <=", value, "longTerm");
      return (Criteria) this;
    }

    public Criteria andLongTermIn(List<Integer> values) {
      addCriterion("long_term in", values, "longTerm");
      return (Criteria) this;
    }

    public Criteria andLongTermNotIn(List<Integer> values) {
      addCriterion("long_term not in", values, "longTerm");
      return (Criteria) this;
    }

    public Criteria andLongTermBetween(Integer value1, Integer value2) {
      addCriterion("long_term between", value1, value2, "longTerm");
      return (Criteria) this;
    }

    public Criteria andLongTermNotBetween(Integer value1, Integer value2) {
      addCriterion("long_term not between", value1, value2, "longTerm");
      return (Criteria) this;
    }

    public Criteria andSendImmediatelyIsNull() {
      addCriterion("send_immediately is null");
      return (Criteria) this;
    }

    public Criteria andSendImmediatelyIsNotNull() {
      addCriterion("send_immediately is not null");
      return (Criteria) this;
    }

    public Criteria andSendImmediatelyEqualTo(Boolean value) {
      addCriterion("send_immediately =", value, "sendImmediately");
      return (Criteria) this;
    }

    public Criteria andSendImmediatelyNotEqualTo(Boolean value) {
      addCriterion("send_immediately <>", value, "sendImmediately");
      return (Criteria) this;
    }

    public Criteria andSendImmediatelyGreaterThan(Boolean value) {
      addCriterion("send_immediately >", value, "sendImmediately");
      return (Criteria) this;
    }

    public Criteria andSendImmediatelyGreaterThanOrEqualTo(Boolean value) {
      addCriterion("send_immediately >=", value, "sendImmediately");
      return (Criteria) this;
    }

    public Criteria andSendImmediatelyLessThan(Boolean value) {
      addCriterion("send_immediately <", value, "sendImmediately");
      return (Criteria) this;
    }

    public Criteria andSendImmediatelyLessThanOrEqualTo(Boolean value) {
      addCriterion("send_immediately <=", value, "sendImmediately");
      return (Criteria) this;
    }

    public Criteria andSendImmediatelyIn(List<Boolean> values) {
      addCriterion("send_immediately in", values, "sendImmediately");
      return (Criteria) this;
    }

    public Criteria andSendImmediatelyNotIn(List<Boolean> values) {
      addCriterion("send_immediately not in", values, "sendImmediately");
      return (Criteria) this;
    }

    public Criteria andSendImmediatelyBetween(Boolean value1, Boolean value2) {
      addCriterion("send_immediately between", value1, value2, "sendImmediately");
      return (Criteria) this;
    }

    public Criteria andSendImmediatelyNotBetween(Boolean value1, Boolean value2) {
      addCriterion("send_immediately not between", value1, value2, "sendImmediately");
      return (Criteria) this;
    }

    public Criteria andSendTimeIsNull() {
      addCriterion("send_time is null");
      return (Criteria) this;
    }

    public Criteria andSendTimeIsNotNull() {
      addCriterion("send_time is not null");
      return (Criteria) this;
    }

    public Criteria andSendTimeEqualTo(Date value) {
      addCriterion("send_time =", value, "sendTime");
      return (Criteria) this;
    }

    public Criteria andSendTimeNotEqualTo(Date value) {
      addCriterion("send_time <>", value, "sendTime");
      return (Criteria) this;
    }

    public Criteria andSendTimeGreaterThan(Date value) {
      addCriterion("send_time >", value, "sendTime");
      return (Criteria) this;
    }

    public Criteria andSendTimeGreaterThanOrEqualTo(Date value) {
      addCriterion("send_time >=", value, "sendTime");
      return (Criteria) this;
    }

    public Criteria andSendTimeLessThan(Date value) {
      addCriterion("send_time <", value, "sendTime");
      return (Criteria) this;
    }

    public Criteria andSendTimeLessThanOrEqualTo(Date value) {
      addCriterion("send_time <=", value, "sendTime");
      return (Criteria) this;
    }

    public Criteria andSendTimeIn(List<Date> values) {
      addCriterion("send_time in", values, "sendTime");
      return (Criteria) this;
    }

    public Criteria andSendTimeNotIn(List<Date> values) {
      addCriterion("send_time not in", values, "sendTime");
      return (Criteria) this;
    }

    public Criteria andSendTimeBetween(Date value1, Date value2) {
      addCriterion("send_time between", value1, value2, "sendTime");
      return (Criteria) this;
    }

    public Criteria andSendTimeNotBetween(Date value1, Date value2) {
      addCriterion("send_time not between", value1, value2, "sendTime");
      return (Criteria) this;
    }

    public Criteria andPointsIsNull() {
      addCriterion("points is null");
      return (Criteria) this;
    }

    public Criteria andPointsIsNotNull() {
      addCriterion("points is not null");
      return (Criteria) this;
    }

    public Criteria andPointsEqualTo(Integer value) {
      addCriterion("points =", value, "points");
      return (Criteria) this;
    }

    public Criteria andPointsNotEqualTo(Integer value) {
      addCriterion("points <>", value, "points");
      return (Criteria) this;
    }

    public Criteria andPointsGreaterThan(Integer value) {
      addCriterion("points >", value, "points");
      return (Criteria) this;
    }

    public Criteria andPointsGreaterThanOrEqualTo(Integer value) {
      addCriterion("points >=", value, "points");
      return (Criteria) this;
    }

    public Criteria andPointsLessThan(Integer value) {
      addCriterion("points <", value, "points");
      return (Criteria) this;
    }

    public Criteria andPointsLessThanOrEqualTo(Integer value) {
      addCriterion("points <=", value, "points");
      return (Criteria) this;
    }

    public Criteria andPointsIn(List<Integer> values) {
      addCriterion("points in", values, "points");
      return (Criteria) this;
    }

    public Criteria andPointsNotIn(List<Integer> values) {
      addCriterion("points not in", values, "points");
      return (Criteria) this;
    }

    public Criteria andPointsBetween(Integer value1, Integer value2) {
      addCriterion("points between", value1, value2, "points");
      return (Criteria) this;
    }

    public Criteria andPointsNotBetween(Integer value1, Integer value2) {
      addCriterion("points not between", value1, value2, "points");
      return (Criteria) this;
    }

    public Criteria andActivityListImgIsNull() {
      addCriterion("activity_list_img is null");
      return (Criteria) this;
    }

    public Criteria andActivityListImgIsNotNull() {
      addCriterion("activity_list_img is not null");
      return (Criteria) this;
    }

    public Criteria andActivityListImgEqualTo(String value) {
      addCriterion("activity_list_img =", value, "activityListImg");
      return (Criteria) this;
    }

    public Criteria andActivityListImgNotEqualTo(String value) {
      addCriterion("activity_list_img <>", value, "activityListImg");
      return (Criteria) this;
    }

    public Criteria andActivityListImgGreaterThan(String value) {
      addCriterion("activity_list_img >", value, "activityListImg");
      return (Criteria) this;
    }

    public Criteria andActivityListImgGreaterThanOrEqualTo(String value) {
      addCriterion("activity_list_img >=", value, "activityListImg");
      return (Criteria) this;
    }

    public Criteria andActivityListImgLessThan(String value) {
      addCriterion("activity_list_img <", value, "activityListImg");
      return (Criteria) this;
    }

    public Criteria andActivityListImgLessThanOrEqualTo(String value) {
      addCriterion("activity_list_img <=", value, "activityListImg");
      return (Criteria) this;
    }

    public Criteria andActivityListImgLike(String value) {
      addCriterion("activity_list_img like", value, "activityListImg");
      return (Criteria) this;
    }

    public Criteria andActivityListImgNotLike(String value) {
      addCriterion("activity_list_img not like", value, "activityListImg");
      return (Criteria) this;
    }

    public Criteria andActivityListImgIn(List<String> values) {
      addCriterion("activity_list_img in", values, "activityListImg");
      return (Criteria) this;
    }

    public Criteria andActivityListImgNotIn(List<String> values) {
      addCriterion("activity_list_img not in", values, "activityListImg");
      return (Criteria) this;
    }

    public Criteria andActivityListImgBetween(String value1, String value2) {
      addCriterion("activity_list_img between", value1, value2, "activityListImg");
      return (Criteria) this;
    }

    public Criteria andActivityListImgNotBetween(String value1, String value2) {
      addCriterion("activity_list_img not between", value1, value2, "activityListImg");
      return (Criteria) this;
    }

    public Criteria andActivityDetailImgIsNull() {
      addCriterion("activity_detail_img is null");
      return (Criteria) this;
    }

    public Criteria andActivityDetailImgIsNotNull() {
      addCriterion("activity_detail_img is not null");
      return (Criteria) this;
    }

    public Criteria andActivityDetailImgEqualTo(String value) {
      addCriterion("activity_detail_img =", value, "activityDetailImg");
      return (Criteria) this;
    }

    public Criteria andActivityDetailImgNotEqualTo(String value) {
      addCriterion("activity_detail_img <>", value, "activityDetailImg");
      return (Criteria) this;
    }

    public Criteria andActivityDetailImgGreaterThan(String value) {
      addCriterion("activity_detail_img >", value, "activityDetailImg");
      return (Criteria) this;
    }

    public Criteria andActivityDetailImgGreaterThanOrEqualTo(String value) {
      addCriterion("activity_detail_img >=", value, "activityDetailImg");
      return (Criteria) this;
    }

    public Criteria andActivityDetailImgLessThan(String value) {
      addCriterion("activity_detail_img <", value, "activityDetailImg");
      return (Criteria) this;
    }

    public Criteria andActivityDetailImgLessThanOrEqualTo(String value) {
      addCriterion("activity_detail_img <=", value, "activityDetailImg");
      return (Criteria) this;
    }

    public Criteria andActivityDetailImgLike(String value) {
      addCriterion("activity_detail_img like", value, "activityDetailImg");
      return (Criteria) this;
    }

    public Criteria andActivityDetailImgNotLike(String value) {
      addCriterion("activity_detail_img not like", value, "activityDetailImg");
      return (Criteria) this;
    }

    public Criteria andActivityDetailImgIn(List<String> values) {
      addCriterion("activity_detail_img in", values, "activityDetailImg");
      return (Criteria) this;
    }

    public Criteria andActivityDetailImgNotIn(List<String> values) {
      addCriterion("activity_detail_img not in", values, "activityDetailImg");
      return (Criteria) this;
    }

    public Criteria andActivityDetailImgBetween(String value1, String value2) {
      addCriterion("activity_detail_img between", value1, value2, "activityDetailImg");
      return (Criteria) this;
    }

    public Criteria andActivityDetailImgNotBetween(String value1, String value2) {
      addCriterion("activity_detail_img not between", value1, value2, "activityDetailImg");
      return (Criteria) this;
    }

    public Criteria andQrCodeUrlIsNull() {
      addCriterion("qr_code_url is null");
      return (Criteria) this;
    }

    public Criteria andQrCodeUrlIsNotNull() {
      addCriterion("qr_code_url is not null");
      return (Criteria) this;
    }

    public Criteria andQrCodeUrlEqualTo(String value) {
      addCriterion("qr_code_url =", value, "qrCodeUrl");
      return (Criteria) this;
    }

    public Criteria andQrCodeUrlNotEqualTo(String value) {
      addCriterion("qr_code_url <>", value, "qrCodeUrl");
      return (Criteria) this;
    }

    public Criteria andQrCodeUrlGreaterThan(String value) {
      addCriterion("qr_code_url >", value, "qrCodeUrl");
      return (Criteria) this;
    }

    public Criteria andQrCodeUrlGreaterThanOrEqualTo(String value) {
      addCriterion("qr_code_url >=", value, "qrCodeUrl");
      return (Criteria) this;
    }

    public Criteria andQrCodeUrlLessThan(String value) {
      addCriterion("qr_code_url <", value, "qrCodeUrl");
      return (Criteria) this;
    }

    public Criteria andQrCodeUrlLessThanOrEqualTo(String value) {
      addCriterion("qr_code_url <=", value, "qrCodeUrl");
      return (Criteria) this;
    }

    public Criteria andQrCodeUrlLike(String value) {
      addCriterion("qr_code_url like", value, "qrCodeUrl");
      return (Criteria) this;
    }

    public Criteria andQrCodeUrlNotLike(String value) {
      addCriterion("qr_code_url not like", value, "qrCodeUrl");
      return (Criteria) this;
    }

    public Criteria andQrCodeUrlIn(List<String> values) {
      addCriterion("qr_code_url in", values, "qrCodeUrl");
      return (Criteria) this;
    }

    public Criteria andQrCodeUrlNotIn(List<String> values) {
      addCriterion("qr_code_url not in", values, "qrCodeUrl");
      return (Criteria) this;
    }

    public Criteria andQrCodeUrlBetween(String value1, String value2) {
      addCriterion("qr_code_url between", value1, value2, "qrCodeUrl");
      return (Criteria) this;
    }

    public Criteria andQrCodeUrlNotBetween(String value1, String value2) {
      addCriterion("qr_code_url not between", value1, value2, "qrCodeUrl");
      return (Criteria) this;
    }

    public Criteria andCheckStatusIsNull() {
      addCriterion("check_status is null");
      return (Criteria) this;
    }

    public Criteria andCheckStatusIsNotNull() {
      addCriterion("check_status is not null");
      return (Criteria) this;
    }

    public Criteria andCheckStatusEqualTo(Integer value) {
      addCriterion("check_status =", value, "checkStatus");
      return (Criteria) this;
    }

    public Criteria andCheckStatusNotEqualTo(Integer value) {
      addCriterion("check_status <>", value, "checkStatus");
      return (Criteria) this;
    }

    public Criteria andCheckStatusGreaterThan(Integer value) {
      addCriterion("check_status >", value, "checkStatus");
      return (Criteria) this;
    }

    public Criteria andCheckStatusGreaterThanOrEqualTo(Integer value) {
      addCriterion("check_status >=", value, "checkStatus");
      return (Criteria) this;
    }

    public Criteria andCheckStatusLessThan(Integer value) {
      addCriterion("check_status <", value, "checkStatus");
      return (Criteria) this;
    }

    public Criteria andCheckStatusLessThanOrEqualTo(Integer value) {
      addCriterion("check_status <=", value, "checkStatus");
      return (Criteria) this;
    }

    public Criteria andCheckStatusIn(List<Integer> values) {
      addCriterion("check_status in", values, "checkStatus");
      return (Criteria) this;
    }

    public Criteria andCheckStatusNotIn(List<Integer> values) {
      addCriterion("check_status not in", values, "checkStatus");
      return (Criteria) this;
    }

    public Criteria andCheckStatusBetween(Integer value1, Integer value2) {
      addCriterion("check_status between", value1, value2, "checkStatus");
      return (Criteria) this;
    }

    public Criteria andCheckStatusNotBetween(Integer value1, Integer value2) {
      addCriterion("check_status not between", value1, value2, "checkStatus");
      return (Criteria) this;
    }

    public Criteria andActivityStatusIsNull() {
      addCriterion("activity_status is null");
      return (Criteria) this;
    }

    public Criteria andActivityStatusIsNotNull() {
      addCriterion("activity_status is not null");
      return (Criteria) this;
    }

    public Criteria andActivityStatusEqualTo(Integer value) {
      addCriterion("activity_status =", value, "activityStatus");
      return (Criteria) this;
    }

    public Criteria andActivityStatusNotEqualTo(Integer value) {
      addCriterion("activity_status <>", value, "activityStatus");
      return (Criteria) this;
    }

    public Criteria andActivityStatusGreaterThan(Integer value) {
      addCriterion("activity_status >", value, "activityStatus");
      return (Criteria) this;
    }

    public Criteria andActivityStatusGreaterThanOrEqualTo(Integer value) {
      addCriterion("activity_status >=", value, "activityStatus");
      return (Criteria) this;
    }

    public Criteria andActivityStatusLessThan(Integer value) {
      addCriterion("activity_status <", value, "activityStatus");
      return (Criteria) this;
    }

    public Criteria andActivityStatusLessThanOrEqualTo(Integer value) {
      addCriterion("activity_status <=", value, "activityStatus");
      return (Criteria) this;
    }

    public Criteria andActivityStatusIn(List<Integer> values) {
      addCriterion("activity_status in", values, "activityStatus");
      return (Criteria) this;
    }

    public Criteria andActivityStatusNotIn(List<Integer> values) {
      addCriterion("activity_status not in", values, "activityStatus");
      return (Criteria) this;
    }

    public Criteria andActivityStatusBetween(Integer value1, Integer value2) {
      addCriterion("activity_status between", value1, value2, "activityStatus");
      return (Criteria) this;
    }

    public Criteria andActivityStatusNotBetween(Integer value1, Integer value2) {
      addCriterion("activity_status not between", value1, value2, "activityStatus");
      return (Criteria) this;
    }

    public Criteria andIsStoreLimitIsNull() {
      addCriterion("is_store_limit is null");
      return (Criteria) this;
    }

    public Criteria andIsStoreLimitIsNotNull() {
      addCriterion("is_store_limit is not null");
      return (Criteria) this;
    }

    public Criteria andIsStoreLimitEqualTo(Boolean value) {
      addCriterion("is_store_limit =", value, "isStoreLimit");
      return (Criteria) this;
    }

    public Criteria andIsStoreLimitNotEqualTo(Boolean value) {
      addCriterion("is_store_limit <>", value, "isStoreLimit");
      return (Criteria) this;
    }

    public Criteria andIsStoreLimitGreaterThan(Boolean value) {
      addCriterion("is_store_limit >", value, "isStoreLimit");
      return (Criteria) this;
    }

    public Criteria andIsStoreLimitGreaterThanOrEqualTo(Boolean value) {
      addCriterion("is_store_limit >=", value, "isStoreLimit");
      return (Criteria) this;
    }

    public Criteria andIsStoreLimitLessThan(Boolean value) {
      addCriterion("is_store_limit <", value, "isStoreLimit");
      return (Criteria) this;
    }

    public Criteria andIsStoreLimitLessThanOrEqualTo(Boolean value) {
      addCriterion("is_store_limit <=", value, "isStoreLimit");
      return (Criteria) this;
    }

    public Criteria andIsStoreLimitIn(List<Boolean> values) {
      addCriterion("is_store_limit in", values, "isStoreLimit");
      return (Criteria) this;
    }

    public Criteria andIsStoreLimitNotIn(List<Boolean> values) {
      addCriterion("is_store_limit not in", values, "isStoreLimit");
      return (Criteria) this;
    }

    public Criteria andIsStoreLimitBetween(Boolean value1, Boolean value2) {
      addCriterion("is_store_limit between", value1, value2, "isStoreLimit");
      return (Criteria) this;
    }

    public Criteria andIsStoreLimitNotBetween(Boolean value1, Boolean value2) {
      addCriterion("is_store_limit not between", value1, value2, "isStoreLimit");
      return (Criteria) this;
    }

    public Criteria andStoreLimitTypeIsNull() {
      addCriterion("store_limit_type is null");
      return (Criteria) this;
    }

    public Criteria andStoreLimitTypeIsNotNull() {
      addCriterion("store_limit_type is not null");
      return (Criteria) this;
    }

    public Criteria andStoreLimitTypeEqualTo(Integer value) {
      addCriterion("store_limit_type =", value, "storeLimitType");
      return (Criteria) this;
    }

    public Criteria andStoreLimitTypeNotEqualTo(Integer value) {
      addCriterion("store_limit_type <>", value, "storeLimitType");
      return (Criteria) this;
    }

    public Criteria andStoreLimitTypeGreaterThan(Integer value) {
      addCriterion("store_limit_type >", value, "storeLimitType");
      return (Criteria) this;
    }

    public Criteria andStoreLimitTypeGreaterThanOrEqualTo(Integer value) {
      addCriterion("store_limit_type >=", value, "storeLimitType");
      return (Criteria) this;
    }

    public Criteria andStoreLimitTypeLessThan(Integer value) {
      addCriterion("store_limit_type <", value, "storeLimitType");
      return (Criteria) this;
    }

    public Criteria andStoreLimitTypeLessThanOrEqualTo(Integer value) {
      addCriterion("store_limit_type <=", value, "storeLimitType");
      return (Criteria) this;
    }

    public Criteria andStoreLimitTypeIn(List<Integer> values) {
      addCriterion("store_limit_type in", values, "storeLimitType");
      return (Criteria) this;
    }

    public Criteria andStoreLimitTypeNotIn(List<Integer> values) {
      addCriterion("store_limit_type not in", values, "storeLimitType");
      return (Criteria) this;
    }

    public Criteria andStoreLimitTypeBetween(Integer value1, Integer value2) {
      addCriterion("store_limit_type between", value1, value2, "storeLimitType");
      return (Criteria) this;
    }

    public Criteria andStoreLimitTypeNotBetween(Integer value1, Integer value2) {
      addCriterion("store_limit_type not between", value1, value2, "storeLimitType");
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

    public Criteria andTriesLimitIsNull() {
      addCriterion("tries_limit is null");
      return (Criteria) this;
    }

    public Criteria andTriesLimitIsNotNull() {
      addCriterion("tries_limit is not null");
      return (Criteria) this;
    }

    public Criteria andTriesLimitEqualTo(Integer value) {
      addCriterion("tries_limit =", value, "triesLimit");
      return (Criteria) this;
    }

    public Criteria andTriesLimitNotEqualTo(Integer value) {
      addCriterion("tries_limit <>", value, "triesLimit");
      return (Criteria) this;
    }

    public Criteria andTriesLimitGreaterThan(Integer value) {
      addCriterion("tries_limit >", value, "triesLimit");
      return (Criteria) this;
    }

    public Criteria andTriesLimitGreaterThanOrEqualTo(Integer value) {
      addCriterion("tries_limit >=", value, "triesLimit");
      return (Criteria) this;
    }

    public Criteria andTriesLimitLessThan(Integer value) {
      addCriterion("tries_limit <", value, "triesLimit");
      return (Criteria) this;
    }

    public Criteria andTriesLimitLessThanOrEqualTo(Integer value) {
      addCriterion("tries_limit <=", value, "triesLimit");
      return (Criteria) this;
    }

    public Criteria andTriesLimitIn(List<Integer> values) {
      addCriterion("tries_limit in", values, "triesLimit");
      return (Criteria) this;
    }

    public Criteria andTriesLimitNotIn(List<Integer> values) {
      addCriterion("tries_limit not in", values, "triesLimit");
      return (Criteria) this;
    }

    public Criteria andTriesLimitBetween(Integer value1, Integer value2) {
      addCriterion("tries_limit between", value1, value2, "triesLimit");
      return (Criteria) this;
    }

    public Criteria andTriesLimitNotBetween(Integer value1, Integer value2) {
      addCriterion("tries_limit not between", value1, value2, "triesLimit");
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
   * 只读. t_mkt_activity
   * @mbg.generated  2019-05-24 15:35:50
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

    /**9
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_mkt_activity
     *
     * @mbg.generated do_not_delete_during_merge 2018-07-12 11:48:54
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }
}