package com.bizvane.couponfacade.models.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RocketConfigPOExample implements Serializable {
    /**
   * 只读. 
   * @mbg.generated  2018-07-16 20:34:40
   */
  protected String orderByClause;
  /**
   * 只读. 
   * @mbg.generated  2018-07-16 20:34:40
   */
  protected boolean distinct;
  /**
   * 只读. 
   * @mbg.generated  2018-07-16 20:34:40
   */
  protected List<Criteria> oredCriteria;
  /**
   * 只读. 
   * @mbg.generated  2018-07-16 20:34:40
   */
  private static final long serialVersionUID = 1L;

  /**
   * 只读. 
   * @mbg.generated  2018-07-16 20:34:40
   */
  public RocketConfigPOExample() {
    oredCriteria = new ArrayList<Criteria>();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-16 20:34:40
   */
  public void setOrderByClause(String orderByClause) {
    this.orderByClause = orderByClause;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-16 20:34:40
   */
  public String getOrderByClause() {
    return orderByClause;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-16 20:34:40
   */
  public void setDistinct(boolean distinct) {
    this.distinct = distinct;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-16 20:34:40
   */
  public boolean isDistinct() {
    return distinct;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-16 20:34:40
   */
  public List<Criteria> getOredCriteria() {
    return oredCriteria;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-16 20:34:40
   */
  public void or(Criteria criteria) {
    oredCriteria.add(criteria);
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-16 20:34:40
   */
  public Criteria or() {
    Criteria criteria = createCriteriaInternal();
    oredCriteria.add(criteria);
    return criteria;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-16 20:34:40
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
   * @mbg.generated  2018-07-16 20:34:40
   */
  protected Criteria createCriteriaInternal() {
    Criteria criteria = new Criteria();
    return criteria;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-16 20:34:40
   */
  public void clear() {
    oredCriteria.clear();
    orderByClause = null;
    distinct = false;
  }

  /**
   * 只读. t_rocket_config
   * @mbg.generated  2018-07-16 20:34:40
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

    public Criteria andRocketConfigIdIsNull() {
      addCriterion("rocket_config_id is null");
      return (Criteria) this;
    }

    public Criteria andRocketConfigIdIsNotNull() {
      addCriterion("rocket_config_id is not null");
      return (Criteria) this;
    }

    public Criteria andRocketConfigIdEqualTo(Integer value) {
      addCriterion("rocket_config_id =", value, "rocketConfigId");
      return (Criteria) this;
    }

    public Criteria andRocketConfigIdNotEqualTo(Integer value) {
      addCriterion("rocket_config_id <>", value, "rocketConfigId");
      return (Criteria) this;
    }

    public Criteria andRocketConfigIdGreaterThan(Integer value) {
      addCriterion("rocket_config_id >", value, "rocketConfigId");
      return (Criteria) this;
    }

    public Criteria andRocketConfigIdGreaterThanOrEqualTo(Integer value) {
      addCriterion("rocket_config_id >=", value, "rocketConfigId");
      return (Criteria) this;
    }

    public Criteria andRocketConfigIdLessThan(Integer value) {
      addCriterion("rocket_config_id <", value, "rocketConfigId");
      return (Criteria) this;
    }

    public Criteria andRocketConfigIdLessThanOrEqualTo(Integer value) {
      addCriterion("rocket_config_id <=", value, "rocketConfigId");
      return (Criteria) this;
    }

    public Criteria andRocketConfigIdIn(List<Integer> values) {
      addCriterion("rocket_config_id in", values, "rocketConfigId");
      return (Criteria) this;
    }

    public Criteria andRocketConfigIdNotIn(List<Integer> values) {
      addCriterion("rocket_config_id not in", values, "rocketConfigId");
      return (Criteria) this;
    }

    public Criteria andRocketConfigIdBetween(Integer value1, Integer value2) {
      addCriterion("rocket_config_id between", value1, value2, "rocketConfigId");
      return (Criteria) this;
    }

    public Criteria andRocketConfigIdNotBetween(Integer value1, Integer value2) {
      addCriterion("rocket_config_id not between", value1, value2, "rocketConfigId");
      return (Criteria) this;
    }

    public Criteria andModelNameIsNull() {
      addCriterion("model_name is null");
      return (Criteria) this;
    }

    public Criteria andModelNameIsNotNull() {
      addCriterion("model_name is not null");
      return (Criteria) this;
    }

    public Criteria andModelNameEqualTo(String value) {
      addCriterion("model_name =", value, "modelName");
      return (Criteria) this;
    }

    public Criteria andModelNameNotEqualTo(String value) {
      addCriterion("model_name <>", value, "modelName");
      return (Criteria) this;
    }

    public Criteria andModelNameGreaterThan(String value) {
      addCriterion("model_name >", value, "modelName");
      return (Criteria) this;
    }

    public Criteria andModelNameGreaterThanOrEqualTo(String value) {
      addCriterion("model_name >=", value, "modelName");
      return (Criteria) this;
    }

    public Criteria andModelNameLessThan(String value) {
      addCriterion("model_name <", value, "modelName");
      return (Criteria) this;
    }

    public Criteria andModelNameLessThanOrEqualTo(String value) {
      addCriterion("model_name <=", value, "modelName");
      return (Criteria) this;
    }

    public Criteria andModelNameLike(String value) {
      addCriterion("model_name like", value, "modelName");
      return (Criteria) this;
    }

    public Criteria andModelNameNotLike(String value) {
      addCriterion("model_name not like", value, "modelName");
      return (Criteria) this;
    }

    public Criteria andModelNameIn(List<String> values) {
      addCriterion("model_name in", values, "modelName");
      return (Criteria) this;
    }

    public Criteria andModelNameNotIn(List<String> values) {
      addCriterion("model_name not in", values, "modelName");
      return (Criteria) this;
    }

    public Criteria andModelNameBetween(String value1, String value2) {
      addCriterion("model_name between", value1, value2, "modelName");
      return (Criteria) this;
    }

    public Criteria andModelNameNotBetween(String value1, String value2) {
      addCriterion("model_name not between", value1, value2, "modelName");
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

    public Criteria andBusinessTypeEqualTo(String value) {
      addCriterion("business_type =", value, "businessType");
      return (Criteria) this;
    }

    public Criteria andBusinessTypeNotEqualTo(String value) {
      addCriterion("business_type <>", value, "businessType");
      return (Criteria) this;
    }

    public Criteria andBusinessTypeGreaterThan(String value) {
      addCriterion("business_type >", value, "businessType");
      return (Criteria) this;
    }

    public Criteria andBusinessTypeGreaterThanOrEqualTo(String value) {
      addCriterion("business_type >=", value, "businessType");
      return (Criteria) this;
    }

    public Criteria andBusinessTypeLessThan(String value) {
      addCriterion("business_type <", value, "businessType");
      return (Criteria) this;
    }

    public Criteria andBusinessTypeLessThanOrEqualTo(String value) {
      addCriterion("business_type <=", value, "businessType");
      return (Criteria) this;
    }

    public Criteria andBusinessTypeLike(String value) {
      addCriterion("business_type like", value, "businessType");
      return (Criteria) this;
    }

    public Criteria andBusinessTypeNotLike(String value) {
      addCriterion("business_type not like", value, "businessType");
      return (Criteria) this;
    }

    public Criteria andBusinessTypeIn(List<String> values) {
      addCriterion("business_type in", values, "businessType");
      return (Criteria) this;
    }

    public Criteria andBusinessTypeNotIn(List<String> values) {
      addCriterion("business_type not in", values, "businessType");
      return (Criteria) this;
    }

    public Criteria andBusinessTypeBetween(String value1, String value2) {
      addCriterion("business_type between", value1, value2, "businessType");
      return (Criteria) this;
    }

    public Criteria andBusinessTypeNotBetween(String value1, String value2) {
      addCriterion("business_type not between", value1, value2, "businessType");
      return (Criteria) this;
    }

    public Criteria andRoleTypeIsNull() {
      addCriterion("role_type is null");
      return (Criteria) this;
    }

    public Criteria andRoleTypeIsNotNull() {
      addCriterion("role_type is not null");
      return (Criteria) this;
    }

    public Criteria andRoleTypeEqualTo(String value) {
      addCriterion("role_type =", value, "roleType");
      return (Criteria) this;
    }

    public Criteria andRoleTypeNotEqualTo(String value) {
      addCriterion("role_type <>", value, "roleType");
      return (Criteria) this;
    }

    public Criteria andRoleTypeGreaterThan(String value) {
      addCriterion("role_type >", value, "roleType");
      return (Criteria) this;
    }

    public Criteria andRoleTypeGreaterThanOrEqualTo(String value) {
      addCriterion("role_type >=", value, "roleType");
      return (Criteria) this;
    }

    public Criteria andRoleTypeLessThan(String value) {
      addCriterion("role_type <", value, "roleType");
      return (Criteria) this;
    }

    public Criteria andRoleTypeLessThanOrEqualTo(String value) {
      addCriterion("role_type <=", value, "roleType");
      return (Criteria) this;
    }

    public Criteria andRoleTypeLike(String value) {
      addCriterion("role_type like", value, "roleType");
      return (Criteria) this;
    }

    public Criteria andRoleTypeNotLike(String value) {
      addCriterion("role_type not like", value, "roleType");
      return (Criteria) this;
    }

    public Criteria andRoleTypeIn(List<String> values) {
      addCriterion("role_type in", values, "roleType");
      return (Criteria) this;
    }

    public Criteria andRoleTypeNotIn(List<String> values) {
      addCriterion("role_type not in", values, "roleType");
      return (Criteria) this;
    }

    public Criteria andRoleTypeBetween(String value1, String value2) {
      addCriterion("role_type between", value1, value2, "roleType");
      return (Criteria) this;
    }

    public Criteria andRoleTypeNotBetween(String value1, String value2) {
      addCriterion("role_type not between", value1, value2, "roleType");
      return (Criteria) this;
    }

    public Criteria andRoleIdIsNull() {
      addCriterion("role_id is null");
      return (Criteria) this;
    }

    public Criteria andRoleIdIsNotNull() {
      addCriterion("role_id is not null");
      return (Criteria) this;
    }

    public Criteria andRoleIdEqualTo(String value) {
      addCriterion("role_id =", value, "roleId");
      return (Criteria) this;
    }

    public Criteria andRoleIdNotEqualTo(String value) {
      addCriterion("role_id <>", value, "roleId");
      return (Criteria) this;
    }

    public Criteria andRoleIdGreaterThan(String value) {
      addCriterion("role_id >", value, "roleId");
      return (Criteria) this;
    }

    public Criteria andRoleIdGreaterThanOrEqualTo(String value) {
      addCriterion("role_id >=", value, "roleId");
      return (Criteria) this;
    }

    public Criteria andRoleIdLessThan(String value) {
      addCriterion("role_id <", value, "roleId");
      return (Criteria) this;
    }

    public Criteria andRoleIdLessThanOrEqualTo(String value) {
      addCriterion("role_id <=", value, "roleId");
      return (Criteria) this;
    }

    public Criteria andRoleIdLike(String value) {
      addCriterion("role_id like", value, "roleId");
      return (Criteria) this;
    }

    public Criteria andRoleIdNotLike(String value) {
      addCriterion("role_id not like", value, "roleId");
      return (Criteria) this;
    }

    public Criteria andRoleIdIn(List<String> values) {
      addCriterion("role_id in", values, "roleId");
      return (Criteria) this;
    }

    public Criteria andRoleIdNotIn(List<String> values) {
      addCriterion("role_id not in", values, "roleId");
      return (Criteria) this;
    }

    public Criteria andRoleIdBetween(String value1, String value2) {
      addCriterion("role_id between", value1, value2, "roleId");
      return (Criteria) this;
    }

    public Criteria andRoleIdNotBetween(String value1, String value2) {
      addCriterion("role_id not between", value1, value2, "roleId");
      return (Criteria) this;
    }

    public Criteria andTopicIsNull() {
      addCriterion("topic is null");
      return (Criteria) this;
    }

    public Criteria andTopicIsNotNull() {
      addCriterion("topic is not null");
      return (Criteria) this;
    }

    public Criteria andTopicEqualTo(String value) {
      addCriterion("topic =", value, "topic");
      return (Criteria) this;
    }

    public Criteria andTopicNotEqualTo(String value) {
      addCriterion("topic <>", value, "topic");
      return (Criteria) this;
    }

    public Criteria andTopicGreaterThan(String value) {
      addCriterion("topic >", value, "topic");
      return (Criteria) this;
    }

    public Criteria andTopicGreaterThanOrEqualTo(String value) {
      addCriterion("topic >=", value, "topic");
      return (Criteria) this;
    }

    public Criteria andTopicLessThan(String value) {
      addCriterion("topic <", value, "topic");
      return (Criteria) this;
    }

    public Criteria andTopicLessThanOrEqualTo(String value) {
      addCriterion("topic <=", value, "topic");
      return (Criteria) this;
    }

    public Criteria andTopicLike(String value) {
      addCriterion("topic like", value, "topic");
      return (Criteria) this;
    }

    public Criteria andTopicNotLike(String value) {
      addCriterion("topic not like", value, "topic");
      return (Criteria) this;
    }

    public Criteria andTopicIn(List<String> values) {
      addCriterion("topic in", values, "topic");
      return (Criteria) this;
    }

    public Criteria andTopicNotIn(List<String> values) {
      addCriterion("topic not in", values, "topic");
      return (Criteria) this;
    }

    public Criteria andTopicBetween(String value1, String value2) {
      addCriterion("topic between", value1, value2, "topic");
      return (Criteria) this;
    }

    public Criteria andTopicNotBetween(String value1, String value2) {
      addCriterion("topic not between", value1, value2, "topic");
      return (Criteria) this;
    }

    public Criteria andTagIsNull() {
      addCriterion("tag is null");
      return (Criteria) this;
    }

    public Criteria andTagIsNotNull() {
      addCriterion("tag is not null");
      return (Criteria) this;
    }

    public Criteria andTagEqualTo(String value) {
      addCriterion("tag =", value, "tag");
      return (Criteria) this;
    }

    public Criteria andTagNotEqualTo(String value) {
      addCriterion("tag <>", value, "tag");
      return (Criteria) this;
    }

    public Criteria andTagGreaterThan(String value) {
      addCriterion("tag >", value, "tag");
      return (Criteria) this;
    }

    public Criteria andTagGreaterThanOrEqualTo(String value) {
      addCriterion("tag >=", value, "tag");
      return (Criteria) this;
    }

    public Criteria andTagLessThan(String value) {
      addCriterion("tag <", value, "tag");
      return (Criteria) this;
    }

    public Criteria andTagLessThanOrEqualTo(String value) {
      addCriterion("tag <=", value, "tag");
      return (Criteria) this;
    }

    public Criteria andTagLike(String value) {
      addCriterion("tag like", value, "tag");
      return (Criteria) this;
    }

    public Criteria andTagNotLike(String value) {
      addCriterion("tag not like", value, "tag");
      return (Criteria) this;
    }

    public Criteria andTagIn(List<String> values) {
      addCriterion("tag in", values, "tag");
      return (Criteria) this;
    }

    public Criteria andTagNotIn(List<String> values) {
      addCriterion("tag not in", values, "tag");
      return (Criteria) this;
    }

    public Criteria andTagBetween(String value1, String value2) {
      addCriterion("tag between", value1, value2, "tag");
      return (Criteria) this;
    }

    public Criteria andTagNotBetween(String value1, String value2) {
      addCriterion("tag not between", value1, value2, "tag");
      return (Criteria) this;
    }

    public Criteria andMessageListenerBeanIsNull() {
      addCriterion("message_listener_bean is null");
      return (Criteria) this;
    }

    public Criteria andMessageListenerBeanIsNotNull() {
      addCriterion("message_listener_bean is not null");
      return (Criteria) this;
    }

    public Criteria andMessageListenerBeanEqualTo(String value) {
      addCriterion("message_listener_bean =", value, "messageListenerBean");
      return (Criteria) this;
    }

    public Criteria andMessageListenerBeanNotEqualTo(String value) {
      addCriterion("message_listener_bean <>", value, "messageListenerBean");
      return (Criteria) this;
    }

    public Criteria andMessageListenerBeanGreaterThan(String value) {
      addCriterion("message_listener_bean >", value, "messageListenerBean");
      return (Criteria) this;
    }

    public Criteria andMessageListenerBeanGreaterThanOrEqualTo(String value) {
      addCriterion("message_listener_bean >=", value, "messageListenerBean");
      return (Criteria) this;
    }

    public Criteria andMessageListenerBeanLessThan(String value) {
      addCriterion("message_listener_bean <", value, "messageListenerBean");
      return (Criteria) this;
    }

    public Criteria andMessageListenerBeanLessThanOrEqualTo(String value) {
      addCriterion("message_listener_bean <=", value, "messageListenerBean");
      return (Criteria) this;
    }

    public Criteria andMessageListenerBeanLike(String value) {
      addCriterion("message_listener_bean like", value, "messageListenerBean");
      return (Criteria) this;
    }

    public Criteria andMessageListenerBeanNotLike(String value) {
      addCriterion("message_listener_bean not like", value, "messageListenerBean");
      return (Criteria) this;
    }

    public Criteria andMessageListenerBeanIn(List<String> values) {
      addCriterion("message_listener_bean in", values, "messageListenerBean");
      return (Criteria) this;
    }

    public Criteria andMessageListenerBeanNotIn(List<String> values) {
      addCriterion("message_listener_bean not in", values, "messageListenerBean");
      return (Criteria) this;
    }

    public Criteria andMessageListenerBeanBetween(String value1, String value2) {
      addCriterion("message_listener_bean between", value1, value2, "messageListenerBean");
      return (Criteria) this;
    }

    public Criteria andMessageListenerBeanNotBetween(String value1, String value2) {
      addCriterion("message_listener_bean not between", value1, value2, "messageListenerBean");
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
   * 只读. t_rocket_config
   * @mbg.generated  2018-07-16 20:34:40
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
     * This class corresponds to the database table t_rocket_config
     *
     * @mbg.generated do_not_delete_during_merge 2018-07-13 19:50:32
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }
}