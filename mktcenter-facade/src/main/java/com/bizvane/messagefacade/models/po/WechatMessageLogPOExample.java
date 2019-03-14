package com.bizvane.messagefacade.models.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WechatMessageLogPOExample implements Serializable {
    /**
   * 只读. 
   * @mbg.generated  2018-07-31 16:15:01
   */
  protected String orderByClause;
  /**
   * 只读. 
   * @mbg.generated  2018-07-31 16:15:01
   */
  protected boolean distinct;
  /**
   * 只读. 
   * @mbg.generated  2018-07-31 16:15:01
   */
  protected List<Criteria> oredCriteria;
  /**
   * 只读. 
   * @mbg.generated  2018-07-31 16:15:01
   */
  private static final long serialVersionUID = 1L;

  /**
   * 只读. 
   * @mbg.generated  2018-07-31 16:15:01
   */
  public WechatMessageLogPOExample() {
    oredCriteria = new ArrayList<Criteria>();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-31 16:15:01
   */
  public void setOrderByClause(String orderByClause) {
    this.orderByClause = orderByClause;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-31 16:15:01
   */
  public String getOrderByClause() {
    return orderByClause;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-31 16:15:01
   */
  public void setDistinct(boolean distinct) {
    this.distinct = distinct;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-31 16:15:01
   */
  public boolean isDistinct() {
    return distinct;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-31 16:15:01
   */
  public List<Criteria> getOredCriteria() {
    return oredCriteria;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-31 16:15:01
   */
  public void or(Criteria criteria) {
    oredCriteria.add(criteria);
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-31 16:15:01
   */
  public Criteria or() {
    Criteria criteria = createCriteriaInternal();
    oredCriteria.add(criteria);
    return criteria;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-31 16:15:01
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
   * @mbg.generated  2018-07-31 16:15:01
   */
  protected Criteria createCriteriaInternal() {
    Criteria criteria = new Criteria();
    return criteria;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-31 16:15:01
   */
  public void clear() {
    oredCriteria.clear();
    orderByClause = null;
    distinct = false;
  }

  /**
   * 只读. t_wechat_message_log
   * @mbg.generated  2018-07-31 16:15:01
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

    public Criteria andWechatMessageLogIdIsNull() {
      addCriterion("wechat_message_log_id is null");
      return (Criteria) this;
    }

    public Criteria andWechatMessageLogIdIsNotNull() {
      addCriterion("wechat_message_log_id is not null");
      return (Criteria) this;
    }

    public Criteria andWechatMessageLogIdEqualTo(Long value) {
      addCriterion("wechat_message_log_id =", value, "wechatMessageLogId");
      return (Criteria) this;
    }

    public Criteria andWechatMessageLogIdNotEqualTo(Long value) {
      addCriterion("wechat_message_log_id <>", value, "wechatMessageLogId");
      return (Criteria) this;
    }

    public Criteria andWechatMessageLogIdGreaterThan(Long value) {
      addCriterion("wechat_message_log_id >", value, "wechatMessageLogId");
      return (Criteria) this;
    }

    public Criteria andWechatMessageLogIdGreaterThanOrEqualTo(Long value) {
      addCriterion("wechat_message_log_id >=", value, "wechatMessageLogId");
      return (Criteria) this;
    }

    public Criteria andWechatMessageLogIdLessThan(Long value) {
      addCriterion("wechat_message_log_id <", value, "wechatMessageLogId");
      return (Criteria) this;
    }

    public Criteria andWechatMessageLogIdLessThanOrEqualTo(Long value) {
      addCriterion("wechat_message_log_id <=", value, "wechatMessageLogId");
      return (Criteria) this;
    }

    public Criteria andWechatMessageLogIdIn(List<Long> values) {
      addCriterion("wechat_message_log_id in", values, "wechatMessageLogId");
      return (Criteria) this;
    }

    public Criteria andWechatMessageLogIdNotIn(List<Long> values) {
      addCriterion("wechat_message_log_id not in", values, "wechatMessageLogId");
      return (Criteria) this;
    }

    public Criteria andWechatMessageLogIdBetween(Long value1, Long value2) {
      addCriterion("wechat_message_log_id between", value1, value2, "wechatMessageLogId");
      return (Criteria) this;
    }

    public Criteria andWechatMessageLogIdNotBetween(Long value1, Long value2) {
      addCriterion("wechat_message_log_id not between", value1, value2, "wechatMessageLogId");
      return (Criteria) this;
    }

    public Criteria andRocketMsgIdIsNull() {
      addCriterion("rocket_msg_id is null");
      return (Criteria) this;
    }

    public Criteria andRocketMsgIdIsNotNull() {
      addCriterion("rocket_msg_id is not null");
      return (Criteria) this;
    }

    public Criteria andRocketMsgIdEqualTo(String value) {
      addCriterion("rocket_msg_id =", value, "rocketMsgId");
      return (Criteria) this;
    }

    public Criteria andRocketMsgIdNotEqualTo(String value) {
      addCriterion("rocket_msg_id <>", value, "rocketMsgId");
      return (Criteria) this;
    }

    public Criteria andRocketMsgIdGreaterThan(String value) {
      addCriterion("rocket_msg_id >", value, "rocketMsgId");
      return (Criteria) this;
    }

    public Criteria andRocketMsgIdGreaterThanOrEqualTo(String value) {
      addCriterion("rocket_msg_id >=", value, "rocketMsgId");
      return (Criteria) this;
    }

    public Criteria andRocketMsgIdLessThan(String value) {
      addCriterion("rocket_msg_id <", value, "rocketMsgId");
      return (Criteria) this;
    }

    public Criteria andRocketMsgIdLessThanOrEqualTo(String value) {
      addCriterion("rocket_msg_id <=", value, "rocketMsgId");
      return (Criteria) this;
    }

    public Criteria andRocketMsgIdLike(String value) {
      addCriterion("rocket_msg_id like", value, "rocketMsgId");
      return (Criteria) this;
    }

    public Criteria andRocketMsgIdNotLike(String value) {
      addCriterion("rocket_msg_id not like", value, "rocketMsgId");
      return (Criteria) this;
    }

    public Criteria andRocketMsgIdIn(List<String> values) {
      addCriterion("rocket_msg_id in", values, "rocketMsgId");
      return (Criteria) this;
    }

    public Criteria andRocketMsgIdNotIn(List<String> values) {
      addCriterion("rocket_msg_id not in", values, "rocketMsgId");
      return (Criteria) this;
    }

    public Criteria andRocketMsgIdBetween(String value1, String value2) {
      addCriterion("rocket_msg_id between", value1, value2, "rocketMsgId");
      return (Criteria) this;
    }

    public Criteria andRocketMsgIdNotBetween(String value1, String value2) {
      addCriterion("rocket_msg_id not between", value1, value2, "rocketMsgId");
      return (Criteria) this;
    }

    public Criteria andMessageIdIsNull() {
      addCriterion("message_id is null");
      return (Criteria) this;
    }

    public Criteria andMessageIdIsNotNull() {
      addCriterion("message_id is not null");
      return (Criteria) this;
    }

    public Criteria andMessageIdEqualTo(String value) {
      addCriterion("message_id =", value, "messageId");
      return (Criteria) this;
    }

    public Criteria andMessageIdNotEqualTo(String value) {
      addCriterion("message_id <>", value, "messageId");
      return (Criteria) this;
    }

    public Criteria andMessageIdGreaterThan(String value) {
      addCriterion("message_id >", value, "messageId");
      return (Criteria) this;
    }

    public Criteria andMessageIdGreaterThanOrEqualTo(String value) {
      addCriterion("message_id >=", value, "messageId");
      return (Criteria) this;
    }

    public Criteria andMessageIdLessThan(String value) {
      addCriterion("message_id <", value, "messageId");
      return (Criteria) this;
    }

    public Criteria andMessageIdLessThanOrEqualTo(String value) {
      addCriterion("message_id <=", value, "messageId");
      return (Criteria) this;
    }

    public Criteria andMessageIdLike(String value) {
      addCriterion("message_id like", value, "messageId");
      return (Criteria) this;
    }

    public Criteria andMessageIdNotLike(String value) {
      addCriterion("message_id not like", value, "messageId");
      return (Criteria) this;
    }

    public Criteria andMessageIdIn(List<String> values) {
      addCriterion("message_id in", values, "messageId");
      return (Criteria) this;
    }

    public Criteria andMessageIdNotIn(List<String> values) {
      addCriterion("message_id not in", values, "messageId");
      return (Criteria) this;
    }

    public Criteria andMessageIdBetween(String value1, String value2) {
      addCriterion("message_id between", value1, value2, "messageId");
      return (Criteria) this;
    }

    public Criteria andMessageIdNotBetween(String value1, String value2) {
      addCriterion("message_id not between", value1, value2, "messageId");
      return (Criteria) this;
    }

    public Criteria andBussinessModuleCodeIsNull() {
      addCriterion("bussiness_module_code is null");
      return (Criteria) this;
    }

    public Criteria andBussinessModuleCodeIsNotNull() {
      addCriterion("bussiness_module_code is not null");
      return (Criteria) this;
    }

    public Criteria andBussinessModuleCodeEqualTo(String value) {
      addCriterion("bussiness_module_code =", value, "bussinessModuleCode");
      return (Criteria) this;
    }

    public Criteria andBussinessModuleCodeNotEqualTo(String value) {
      addCriterion("bussiness_module_code <>", value, "bussinessModuleCode");
      return (Criteria) this;
    }

    public Criteria andBussinessModuleCodeGreaterThan(String value) {
      addCriterion("bussiness_module_code >", value, "bussinessModuleCode");
      return (Criteria) this;
    }

    public Criteria andBussinessModuleCodeGreaterThanOrEqualTo(String value) {
      addCriterion("bussiness_module_code >=", value, "bussinessModuleCode");
      return (Criteria) this;
    }

    public Criteria andBussinessModuleCodeLessThan(String value) {
      addCriterion("bussiness_module_code <", value, "bussinessModuleCode");
      return (Criteria) this;
    }

    public Criteria andBussinessModuleCodeLessThanOrEqualTo(String value) {
      addCriterion("bussiness_module_code <=", value, "bussinessModuleCode");
      return (Criteria) this;
    }

    public Criteria andBussinessModuleCodeLike(String value) {
      addCriterion("bussiness_module_code like", value, "bussinessModuleCode");
      return (Criteria) this;
    }

    public Criteria andBussinessModuleCodeNotLike(String value) {
      addCriterion("bussiness_module_code not like", value, "bussinessModuleCode");
      return (Criteria) this;
    }

    public Criteria andBussinessModuleCodeIn(List<String> values) {
      addCriterion("bussiness_module_code in", values, "bussinessModuleCode");
      return (Criteria) this;
    }

    public Criteria andBussinessModuleCodeNotIn(List<String> values) {
      addCriterion("bussiness_module_code not in", values, "bussinessModuleCode");
      return (Criteria) this;
    }

    public Criteria andBussinessModuleCodeBetween(String value1, String value2) {
      addCriterion("bussiness_module_code between", value1, value2, "bussinessModuleCode");
      return (Criteria) this;
    }

    public Criteria andBussinessModuleCodeNotBetween(String value1, String value2) {
      addCriterion("bussiness_module_code not between", value1, value2, "bussinessModuleCode");
      return (Criteria) this;
    }

    public Criteria andBussinessIdIsNull() {
      addCriterion("bussiness_id is null");
      return (Criteria) this;
    }

    public Criteria andBussinessIdIsNotNull() {
      addCriterion("bussiness_id is not null");
      return (Criteria) this;
    }

    public Criteria andBussinessIdEqualTo(String value) {
      addCriterion("bussiness_id =", value, "bussinessId");
      return (Criteria) this;
    }

    public Criteria andBussinessIdNotEqualTo(String value) {
      addCriterion("bussiness_id <>", value, "bussinessId");
      return (Criteria) this;
    }

    public Criteria andBussinessIdGreaterThan(String value) {
      addCriterion("bussiness_id >", value, "bussinessId");
      return (Criteria) this;
    }

    public Criteria andBussinessIdGreaterThanOrEqualTo(String value) {
      addCriterion("bussiness_id >=", value, "bussinessId");
      return (Criteria) this;
    }

    public Criteria andBussinessIdLessThan(String value) {
      addCriterion("bussiness_id <", value, "bussinessId");
      return (Criteria) this;
    }

    public Criteria andBussinessIdLessThanOrEqualTo(String value) {
      addCriterion("bussiness_id <=", value, "bussinessId");
      return (Criteria) this;
    }

    public Criteria andBussinessIdLike(String value) {
      addCriterion("bussiness_id like", value, "bussinessId");
      return (Criteria) this;
    }

    public Criteria andBussinessIdNotLike(String value) {
      addCriterion("bussiness_id not like", value, "bussinessId");
      return (Criteria) this;
    }

    public Criteria andBussinessIdIn(List<String> values) {
      addCriterion("bussiness_id in", values, "bussinessId");
      return (Criteria) this;
    }

    public Criteria andBussinessIdNotIn(List<String> values) {
      addCriterion("bussiness_id not in", values, "bussinessId");
      return (Criteria) this;
    }

    public Criteria andBussinessIdBetween(String value1, String value2) {
      addCriterion("bussiness_id between", value1, value2, "bussinessId");
      return (Criteria) this;
    }

    public Criteria andBussinessIdNotBetween(String value1, String value2) {
      addCriterion("bussiness_id not between", value1, value2, "bussinessId");
      return (Criteria) this;
    }

    public Criteria andWxPublicIdIsNull() {
      addCriterion("wx_public_id is null");
      return (Criteria) this;
    }

    public Criteria andWxPublicIdIsNotNull() {
      addCriterion("wx_public_id is not null");
      return (Criteria) this;
    }

    public Criteria andWxPublicIdEqualTo(Long value) {
      addCriterion("wx_public_id =", value, "wxPublicId");
      return (Criteria) this;
    }

    public Criteria andWxPublicIdNotEqualTo(Long value) {
      addCriterion("wx_public_id <>", value, "wxPublicId");
      return (Criteria) this;
    }

    public Criteria andWxPublicIdGreaterThan(Long value) {
      addCriterion("wx_public_id >", value, "wxPublicId");
      return (Criteria) this;
    }

    public Criteria andWxPublicIdGreaterThanOrEqualTo(Long value) {
      addCriterion("wx_public_id >=", value, "wxPublicId");
      return (Criteria) this;
    }

    public Criteria andWxPublicIdLessThan(Long value) {
      addCriterion("wx_public_id <", value, "wxPublicId");
      return (Criteria) this;
    }

    public Criteria andWxPublicIdLessThanOrEqualTo(Long value) {
      addCriterion("wx_public_id <=", value, "wxPublicId");
      return (Criteria) this;
    }

    public Criteria andWxPublicIdIn(List<Long> values) {
      addCriterion("wx_public_id in", values, "wxPublicId");
      return (Criteria) this;
    }

    public Criteria andWxPublicIdNotIn(List<Long> values) {
      addCriterion("wx_public_id not in", values, "wxPublicId");
      return (Criteria) this;
    }

    public Criteria andWxPublicIdBetween(Long value1, Long value2) {
      addCriterion("wx_public_id between", value1, value2, "wxPublicId");
      return (Criteria) this;
    }

    public Criteria andWxPublicIdNotBetween(Long value1, Long value2) {
      addCriterion("wx_public_id not between", value1, value2, "wxPublicId");
      return (Criteria) this;
    }

    public Criteria andOpenIdIsNull() {
      addCriterion("open_id is null");
      return (Criteria) this;
    }

    public Criteria andOpenIdIsNotNull() {
      addCriterion("open_id is not null");
      return (Criteria) this;
    }

    public Criteria andOpenIdEqualTo(String value) {
      addCriterion("open_id =", value, "openId");
      return (Criteria) this;
    }

    public Criteria andOpenIdNotEqualTo(String value) {
      addCriterion("open_id <>", value, "openId");
      return (Criteria) this;
    }

    public Criteria andOpenIdGreaterThan(String value) {
      addCriterion("open_id >", value, "openId");
      return (Criteria) this;
    }

    public Criteria andOpenIdGreaterThanOrEqualTo(String value) {
      addCriterion("open_id >=", value, "openId");
      return (Criteria) this;
    }

    public Criteria andOpenIdLessThan(String value) {
      addCriterion("open_id <", value, "openId");
      return (Criteria) this;
    }

    public Criteria andOpenIdLessThanOrEqualTo(String value) {
      addCriterion("open_id <=", value, "openId");
      return (Criteria) this;
    }

    public Criteria andOpenIdLike(String value) {
      addCriterion("open_id like", value, "openId");
      return (Criteria) this;
    }

    public Criteria andOpenIdNotLike(String value) {
      addCriterion("open_id not like", value, "openId");
      return (Criteria) this;
    }

    public Criteria andOpenIdIn(List<String> values) {
      addCriterion("open_id in", values, "openId");
      return (Criteria) this;
    }

    public Criteria andOpenIdNotIn(List<String> values) {
      addCriterion("open_id not in", values, "openId");
      return (Criteria) this;
    }

    public Criteria andOpenIdBetween(String value1, String value2) {
      addCriterion("open_id between", value1, value2, "openId");
      return (Criteria) this;
    }

    public Criteria andOpenIdNotBetween(String value1, String value2) {
      addCriterion("open_id not between", value1, value2, "openId");
      return (Criteria) this;
    }

    public Criteria andMemberNameIsNull() {
      addCriterion("member_name is null");
      return (Criteria) this;
    }

    public Criteria andMemberNameIsNotNull() {
      addCriterion("member_name is not null");
      return (Criteria) this;
    }

    public Criteria andMemberNameEqualTo(String value) {
      addCriterion("member_name =", value, "memberName");
      return (Criteria) this;
    }

    public Criteria andMemberNameNotEqualTo(String value) {
      addCriterion("member_name <>", value, "memberName");
      return (Criteria) this;
    }

    public Criteria andMemberNameGreaterThan(String value) {
      addCriterion("member_name >", value, "memberName");
      return (Criteria) this;
    }

    public Criteria andMemberNameGreaterThanOrEqualTo(String value) {
      addCriterion("member_name >=", value, "memberName");
      return (Criteria) this;
    }

    public Criteria andMemberNameLessThan(String value) {
      addCriterion("member_name <", value, "memberName");
      return (Criteria) this;
    }

    public Criteria andMemberNameLessThanOrEqualTo(String value) {
      addCriterion("member_name <=", value, "memberName");
      return (Criteria) this;
    }

    public Criteria andMemberNameLike(String value) {
      addCriterion("member_name like", value, "memberName");
      return (Criteria) this;
    }

    public Criteria andMemberNameNotLike(String value) {
      addCriterion("member_name not like", value, "memberName");
      return (Criteria) this;
    }

    public Criteria andMemberNameIn(List<String> values) {
      addCriterion("member_name in", values, "memberName");
      return (Criteria) this;
    }

    public Criteria andMemberNameNotIn(List<String> values) {
      addCriterion("member_name not in", values, "memberName");
      return (Criteria) this;
    }

    public Criteria andMemberNameBetween(String value1, String value2) {
      addCriterion("member_name between", value1, value2, "memberName");
      return (Criteria) this;
    }

    public Criteria andMemberNameNotBetween(String value1, String value2) {
      addCriterion("member_name not between", value1, value2, "memberName");
      return (Criteria) this;
    }

    public Criteria andMemberPhoneIsNull() {
      addCriterion("member_phone is null");
      return (Criteria) this;
    }

    public Criteria andMemberPhoneIsNotNull() {
      addCriterion("member_phone is not null");
      return (Criteria) this;
    }

    public Criteria andMemberPhoneEqualTo(String value) {
      addCriterion("member_phone =", value, "memberPhone");
      return (Criteria) this;
    }

    public Criteria andMemberPhoneNotEqualTo(String value) {
      addCriterion("member_phone <>", value, "memberPhone");
      return (Criteria) this;
    }

    public Criteria andMemberPhoneGreaterThan(String value) {
      addCriterion("member_phone >", value, "memberPhone");
      return (Criteria) this;
    }

    public Criteria andMemberPhoneGreaterThanOrEqualTo(String value) {
      addCriterion("member_phone >=", value, "memberPhone");
      return (Criteria) this;
    }

    public Criteria andMemberPhoneLessThan(String value) {
      addCriterion("member_phone <", value, "memberPhone");
      return (Criteria) this;
    }

    public Criteria andMemberPhoneLessThanOrEqualTo(String value) {
      addCriterion("member_phone <=", value, "memberPhone");
      return (Criteria) this;
    }

    public Criteria andMemberPhoneLike(String value) {
      addCriterion("member_phone like", value, "memberPhone");
      return (Criteria) this;
    }

    public Criteria andMemberPhoneNotLike(String value) {
      addCriterion("member_phone not like", value, "memberPhone");
      return (Criteria) this;
    }

    public Criteria andMemberPhoneIn(List<String> values) {
      addCriterion("member_phone in", values, "memberPhone");
      return (Criteria) this;
    }

    public Criteria andMemberPhoneNotIn(List<String> values) {
      addCriterion("member_phone not in", values, "memberPhone");
      return (Criteria) this;
    }

    public Criteria andMemberPhoneBetween(String value1, String value2) {
      addCriterion("member_phone between", value1, value2, "memberPhone");
      return (Criteria) this;
    }

    public Criteria andMemberPhoneNotBetween(String value1, String value2) {
      addCriterion("member_phone not between", value1, value2, "memberPhone");
      return (Criteria) this;
    }

    public Criteria andWxNickIsNull() {
      addCriterion("wx_nick is null");
      return (Criteria) this;
    }

    public Criteria andWxNickIsNotNull() {
      addCriterion("wx_nick is not null");
      return (Criteria) this;
    }

    public Criteria andWxNickEqualTo(String value) {
      addCriterion("wx_nick =", value, "wxNick");
      return (Criteria) this;
    }

    public Criteria andWxNickNotEqualTo(String value) {
      addCriterion("wx_nick <>", value, "wxNick");
      return (Criteria) this;
    }

    public Criteria andWxNickGreaterThan(String value) {
      addCriterion("wx_nick >", value, "wxNick");
      return (Criteria) this;
    }

    public Criteria andWxNickGreaterThanOrEqualTo(String value) {
      addCriterion("wx_nick >=", value, "wxNick");
      return (Criteria) this;
    }

    public Criteria andWxNickLessThan(String value) {
      addCriterion("wx_nick <", value, "wxNick");
      return (Criteria) this;
    }

    public Criteria andWxNickLessThanOrEqualTo(String value) {
      addCriterion("wx_nick <=", value, "wxNick");
      return (Criteria) this;
    }

    public Criteria andWxNickLike(String value) {
      addCriterion("wx_nick like", value, "wxNick");
      return (Criteria) this;
    }

    public Criteria andWxNickNotLike(String value) {
      addCriterion("wx_nick not like", value, "wxNick");
      return (Criteria) this;
    }

    public Criteria andWxNickIn(List<String> values) {
      addCriterion("wx_nick in", values, "wxNick");
      return (Criteria) this;
    }

    public Criteria andWxNickNotIn(List<String> values) {
      addCriterion("wx_nick not in", values, "wxNick");
      return (Criteria) this;
    }

    public Criteria andWxNickBetween(String value1, String value2) {
      addCriterion("wx_nick between", value1, value2, "wxNick");
      return (Criteria) this;
    }

    public Criteria andWxNickNotBetween(String value1, String value2) {
      addCriterion("wx_nick not between", value1, value2, "wxNick");
      return (Criteria) this;
    }

    public Criteria andTemplateTypeIsNull() {
      addCriterion("template_type is null");
      return (Criteria) this;
    }

    public Criteria andTemplateTypeIsNotNull() {
      addCriterion("template_type is not null");
      return (Criteria) this;
    }

    public Criteria andTemplateTypeEqualTo(String value) {
      addCriterion("template_type =", value, "templateType");
      return (Criteria) this;
    }

    public Criteria andTemplateTypeNotEqualTo(String value) {
      addCriterion("template_type <>", value, "templateType");
      return (Criteria) this;
    }

    public Criteria andTemplateTypeGreaterThan(String value) {
      addCriterion("template_type >", value, "templateType");
      return (Criteria) this;
    }

    public Criteria andTemplateTypeGreaterThanOrEqualTo(String value) {
      addCriterion("template_type >=", value, "templateType");
      return (Criteria) this;
    }

    public Criteria andTemplateTypeLessThan(String value) {
      addCriterion("template_type <", value, "templateType");
      return (Criteria) this;
    }

    public Criteria andTemplateTypeLessThanOrEqualTo(String value) {
      addCriterion("template_type <=", value, "templateType");
      return (Criteria) this;
    }

    public Criteria andTemplateTypeLike(String value) {
      addCriterion("template_type like", value, "templateType");
      return (Criteria) this;
    }

    public Criteria andTemplateTypeNotLike(String value) {
      addCriterion("template_type not like", value, "templateType");
      return (Criteria) this;
    }

    public Criteria andTemplateTypeIn(List<String> values) {
      addCriterion("template_type in", values, "templateType");
      return (Criteria) this;
    }

    public Criteria andTemplateTypeNotIn(List<String> values) {
      addCriterion("template_type not in", values, "templateType");
      return (Criteria) this;
    }

    public Criteria andTemplateTypeBetween(String value1, String value2) {
      addCriterion("template_type between", value1, value2, "templateType");
      return (Criteria) this;
    }

    public Criteria andTemplateTypeNotBetween(String value1, String value2) {
      addCriterion("template_type not between", value1, value2, "templateType");
      return (Criteria) this;
    }

    public Criteria andDataBodyIsNull() {
      addCriterion("data_body is null");
      return (Criteria) this;
    }

    public Criteria andDataBodyIsNotNull() {
      addCriterion("data_body is not null");
      return (Criteria) this;
    }

    public Criteria andDataBodyEqualTo(String value) {
      addCriterion("data_body =", value, "dataBody");
      return (Criteria) this;
    }

    public Criteria andDataBodyNotEqualTo(String value) {
      addCriterion("data_body <>", value, "dataBody");
      return (Criteria) this;
    }

    public Criteria andDataBodyGreaterThan(String value) {
      addCriterion("data_body >", value, "dataBody");
      return (Criteria) this;
    }

    public Criteria andDataBodyGreaterThanOrEqualTo(String value) {
      addCriterion("data_body >=", value, "dataBody");
      return (Criteria) this;
    }

    public Criteria andDataBodyLessThan(String value) {
      addCriterion("data_body <", value, "dataBody");
      return (Criteria) this;
    }

    public Criteria andDataBodyLessThanOrEqualTo(String value) {
      addCriterion("data_body <=", value, "dataBody");
      return (Criteria) this;
    }

    public Criteria andDataBodyLike(String value) {
      addCriterion("data_body like", value, "dataBody");
      return (Criteria) this;
    }

    public Criteria andDataBodyNotLike(String value) {
      addCriterion("data_body not like", value, "dataBody");
      return (Criteria) this;
    }

    public Criteria andDataBodyIn(List<String> values) {
      addCriterion("data_body in", values, "dataBody");
      return (Criteria) this;
    }

    public Criteria andDataBodyNotIn(List<String> values) {
      addCriterion("data_body not in", values, "dataBody");
      return (Criteria) this;
    }

    public Criteria andDataBodyBetween(String value1, String value2) {
      addCriterion("data_body between", value1, value2, "dataBody");
      return (Criteria) this;
    }

    public Criteria andDataBodyNotBetween(String value1, String value2) {
      addCriterion("data_body not between", value1, value2, "dataBody");
      return (Criteria) this;
    }

    public Criteria andMessageBodyIsNull() {
      addCriterion("message_body is null");
      return (Criteria) this;
    }

    public Criteria andMessageBodyIsNotNull() {
      addCriterion("message_body is not null");
      return (Criteria) this;
    }

    public Criteria andMessageBodyEqualTo(String value) {
      addCriterion("message_body =", value, "messageBody");
      return (Criteria) this;
    }

    public Criteria andMessageBodyNotEqualTo(String value) {
      addCriterion("message_body <>", value, "messageBody");
      return (Criteria) this;
    }

    public Criteria andMessageBodyGreaterThan(String value) {
      addCriterion("message_body >", value, "messageBody");
      return (Criteria) this;
    }

    public Criteria andMessageBodyGreaterThanOrEqualTo(String value) {
      addCriterion("message_body >=", value, "messageBody");
      return (Criteria) this;
    }

    public Criteria andMessageBodyLessThan(String value) {
      addCriterion("message_body <", value, "messageBody");
      return (Criteria) this;
    }

    public Criteria andMessageBodyLessThanOrEqualTo(String value) {
      addCriterion("message_body <=", value, "messageBody");
      return (Criteria) this;
    }

    public Criteria andMessageBodyLike(String value) {
      addCriterion("message_body like", value, "messageBody");
      return (Criteria) this;
    }

    public Criteria andMessageBodyNotLike(String value) {
      addCriterion("message_body not like", value, "messageBody");
      return (Criteria) this;
    }

    public Criteria andMessageBodyIn(List<String> values) {
      addCriterion("message_body in", values, "messageBody");
      return (Criteria) this;
    }

    public Criteria andMessageBodyNotIn(List<String> values) {
      addCriterion("message_body not in", values, "messageBody");
      return (Criteria) this;
    }

    public Criteria andMessageBodyBetween(String value1, String value2) {
      addCriterion("message_body between", value1, value2, "messageBody");
      return (Criteria) this;
    }

    public Criteria andMessageBodyNotBetween(String value1, String value2) {
      addCriterion("message_body not between", value1, value2, "messageBody");
      return (Criteria) this;
    }

    public Criteria andResultInfoIsNull() {
      addCriterion("result_info is null");
      return (Criteria) this;
    }

    public Criteria andResultInfoIsNotNull() {
      addCriterion("result_info is not null");
      return (Criteria) this;
    }

    public Criteria andResultInfoEqualTo(String value) {
      addCriterion("result_info =", value, "resultInfo");
      return (Criteria) this;
    }

    public Criteria andResultInfoNotEqualTo(String value) {
      addCriterion("result_info <>", value, "resultInfo");
      return (Criteria) this;
    }

    public Criteria andResultInfoGreaterThan(String value) {
      addCriterion("result_info >", value, "resultInfo");
      return (Criteria) this;
    }

    public Criteria andResultInfoGreaterThanOrEqualTo(String value) {
      addCriterion("result_info >=", value, "resultInfo");
      return (Criteria) this;
    }

    public Criteria andResultInfoLessThan(String value) {
      addCriterion("result_info <", value, "resultInfo");
      return (Criteria) this;
    }

    public Criteria andResultInfoLessThanOrEqualTo(String value) {
      addCriterion("result_info <=", value, "resultInfo");
      return (Criteria) this;
    }

    public Criteria andResultInfoLike(String value) {
      addCriterion("result_info like", value, "resultInfo");
      return (Criteria) this;
    }

    public Criteria andResultInfoNotLike(String value) {
      addCriterion("result_info not like", value, "resultInfo");
      return (Criteria) this;
    }

    public Criteria andResultInfoIn(List<String> values) {
      addCriterion("result_info in", values, "resultInfo");
      return (Criteria) this;
    }

    public Criteria andResultInfoNotIn(List<String> values) {
      addCriterion("result_info not in", values, "resultInfo");
      return (Criteria) this;
    }

    public Criteria andResultInfoBetween(String value1, String value2) {
      addCriterion("result_info between", value1, value2, "resultInfo");
      return (Criteria) this;
    }

    public Criteria andResultInfoNotBetween(String value1, String value2) {
      addCriterion("result_info not between", value1, value2, "resultInfo");
      return (Criteria) this;
    }

    public Criteria andSendStateIsNull() {
      addCriterion("send_state is null");
      return (Criteria) this;
    }

    public Criteria andSendStateIsNotNull() {
      addCriterion("send_state is not null");
      return (Criteria) this;
    }

    public Criteria andSendStateEqualTo(String value) {
      addCriterion("send_state =", value, "sendState");
      return (Criteria) this;
    }

    public Criteria andSendStateNotEqualTo(String value) {
      addCriterion("send_state <>", value, "sendState");
      return (Criteria) this;
    }

    public Criteria andSendStateGreaterThan(String value) {
      addCriterion("send_state >", value, "sendState");
      return (Criteria) this;
    }

    public Criteria andSendStateGreaterThanOrEqualTo(String value) {
      addCriterion("send_state >=", value, "sendState");
      return (Criteria) this;
    }

    public Criteria andSendStateLessThan(String value) {
      addCriterion("send_state <", value, "sendState");
      return (Criteria) this;
    }

    public Criteria andSendStateLessThanOrEqualTo(String value) {
      addCriterion("send_state <=", value, "sendState");
      return (Criteria) this;
    }

    public Criteria andSendStateLike(String value) {
      addCriterion("send_state like", value, "sendState");
      return (Criteria) this;
    }

    public Criteria andSendStateNotLike(String value) {
      addCriterion("send_state not like", value, "sendState");
      return (Criteria) this;
    }

    public Criteria andSendStateIn(List<String> values) {
      addCriterion("send_state in", values, "sendState");
      return (Criteria) this;
    }

    public Criteria andSendStateNotIn(List<String> values) {
      addCriterion("send_state not in", values, "sendState");
      return (Criteria) this;
    }

    public Criteria andSendStateBetween(String value1, String value2) {
      addCriterion("send_state between", value1, value2, "sendState");
      return (Criteria) this;
    }

    public Criteria andSendStateNotBetween(String value1, String value2) {
      addCriterion("send_state not between", value1, value2, "sendState");
      return (Criteria) this;
    }

    public Criteria andIsResendIsNull() {
      addCriterion("is_resend is null");
      return (Criteria) this;
    }

    public Criteria andIsResendIsNotNull() {
      addCriterion("is_resend is not null");
      return (Criteria) this;
    }

    public Criteria andIsResendEqualTo(Boolean value) {
      addCriterion("is_resend =", value, "isResend");
      return (Criteria) this;
    }

    public Criteria andIsResendNotEqualTo(Boolean value) {
      addCriterion("is_resend <>", value, "isResend");
      return (Criteria) this;
    }

    public Criteria andIsResendGreaterThan(Boolean value) {
      addCriterion("is_resend >", value, "isResend");
      return (Criteria) this;
    }

    public Criteria andIsResendGreaterThanOrEqualTo(Boolean value) {
      addCriterion("is_resend >=", value, "isResend");
      return (Criteria) this;
    }

    public Criteria andIsResendLessThan(Boolean value) {
      addCriterion("is_resend <", value, "isResend");
      return (Criteria) this;
    }

    public Criteria andIsResendLessThanOrEqualTo(Boolean value) {
      addCriterion("is_resend <=", value, "isResend");
      return (Criteria) this;
    }

    public Criteria andIsResendIn(List<Boolean> values) {
      addCriterion("is_resend in", values, "isResend");
      return (Criteria) this;
    }

    public Criteria andIsResendNotIn(List<Boolean> values) {
      addCriterion("is_resend not in", values, "isResend");
      return (Criteria) this;
    }

    public Criteria andIsResendBetween(Boolean value1, Boolean value2) {
      addCriterion("is_resend between", value1, value2, "isResend");
      return (Criteria) this;
    }

    public Criteria andIsResendNotBetween(Boolean value1, Boolean value2) {
      addCriterion("is_resend not between", value1, value2, "isResend");
      return (Criteria) this;
    }

    public Criteria andUpdateUserIdIsNull() {
      addCriterion("update_user_id is null");
      return (Criteria) this;
    }

    public Criteria andUpdateUserIdIsNotNull() {
      addCriterion("update_user_id is not null");
      return (Criteria) this;
    }

    public Criteria andUpdateUserIdEqualTo(Integer value) {
      addCriterion("update_user_id =", value, "updateUserId");
      return (Criteria) this;
    }

    public Criteria andUpdateUserIdNotEqualTo(Integer value) {
      addCriterion("update_user_id <>", value, "updateUserId");
      return (Criteria) this;
    }

    public Criteria andUpdateUserIdGreaterThan(Integer value) {
      addCriterion("update_user_id >", value, "updateUserId");
      return (Criteria) this;
    }

    public Criteria andUpdateUserIdGreaterThanOrEqualTo(Integer value) {
      addCriterion("update_user_id >=", value, "updateUserId");
      return (Criteria) this;
    }

    public Criteria andUpdateUserIdLessThan(Integer value) {
      addCriterion("update_user_id <", value, "updateUserId");
      return (Criteria) this;
    }

    public Criteria andUpdateUserIdLessThanOrEqualTo(Integer value) {
      addCriterion("update_user_id <=", value, "updateUserId");
      return (Criteria) this;
    }

    public Criteria andUpdateUserIdIn(List<Integer> values) {
      addCriterion("update_user_id in", values, "updateUserId");
      return (Criteria) this;
    }

    public Criteria andUpdateUserIdNotIn(List<Integer> values) {
      addCriterion("update_user_id not in", values, "updateUserId");
      return (Criteria) this;
    }

    public Criteria andUpdateUserIdBetween(Integer value1, Integer value2) {
      addCriterion("update_user_id between", value1, value2, "updateUserId");
      return (Criteria) this;
    }

    public Criteria andUpdateUserIdNotBetween(Integer value1, Integer value2) {
      addCriterion("update_user_id not between", value1, value2, "updateUserId");
      return (Criteria) this;
    }

    public Criteria andUpdateDateIsNull() {
      addCriterion("update_date is null");
      return (Criteria) this;
    }

    public Criteria andUpdateDateIsNotNull() {
      addCriterion("update_date is not null");
      return (Criteria) this;
    }

    public Criteria andUpdateDateEqualTo(Date value) {
      addCriterion("update_date =", value, "updateDate");
      return (Criteria) this;
    }

    public Criteria andUpdateDateNotEqualTo(Date value) {
      addCriterion("update_date <>", value, "updateDate");
      return (Criteria) this;
    }

    public Criteria andUpdateDateGreaterThan(Date value) {
      addCriterion("update_date >", value, "updateDate");
      return (Criteria) this;
    }

    public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
      addCriterion("update_date >=", value, "updateDate");
      return (Criteria) this;
    }

    public Criteria andUpdateDateLessThan(Date value) {
      addCriterion("update_date <", value, "updateDate");
      return (Criteria) this;
    }

    public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
      addCriterion("update_date <=", value, "updateDate");
      return (Criteria) this;
    }

    public Criteria andUpdateDateIn(List<Date> values) {
      addCriterion("update_date in", values, "updateDate");
      return (Criteria) this;
    }

    public Criteria andUpdateDateNotIn(List<Date> values) {
      addCriterion("update_date not in", values, "updateDate");
      return (Criteria) this;
    }

    public Criteria andUpdateDateBetween(Date value1, Date value2) {
      addCriterion("update_date between", value1, value2, "updateDate");
      return (Criteria) this;
    }

    public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
      addCriterion("update_date not between", value1, value2, "updateDate");
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

    public Criteria andCreateUserIdEqualTo(Integer value) {
      addCriterion("create_user_id =", value, "createUserId");
      return (Criteria) this;
    }

    public Criteria andCreateUserIdNotEqualTo(Integer value) {
      addCriterion("create_user_id <>", value, "createUserId");
      return (Criteria) this;
    }

    public Criteria andCreateUserIdGreaterThan(Integer value) {
      addCriterion("create_user_id >", value, "createUserId");
      return (Criteria) this;
    }

    public Criteria andCreateUserIdGreaterThanOrEqualTo(Integer value) {
      addCriterion("create_user_id >=", value, "createUserId");
      return (Criteria) this;
    }

    public Criteria andCreateUserIdLessThan(Integer value) {
      addCriterion("create_user_id <", value, "createUserId");
      return (Criteria) this;
    }

    public Criteria andCreateUserIdLessThanOrEqualTo(Integer value) {
      addCriterion("create_user_id <=", value, "createUserId");
      return (Criteria) this;
    }

    public Criteria andCreateUserIdIn(List<Integer> values) {
      addCriterion("create_user_id in", values, "createUserId");
      return (Criteria) this;
    }

    public Criteria andCreateUserIdNotIn(List<Integer> values) {
      addCriterion("create_user_id not in", values, "createUserId");
      return (Criteria) this;
    }

    public Criteria andCreateUserIdBetween(Integer value1, Integer value2) {
      addCriterion("create_user_id between", value1, value2, "createUserId");
      return (Criteria) this;
    }

    public Criteria andCreateUserIdNotBetween(Integer value1, Integer value2) {
      addCriterion("create_user_id not between", value1, value2, "createUserId");
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
  }

  /**
   * 只读. t_wechat_message_log
   * @mbg.generated  2018-07-31 16:15:01
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
     * This class corresponds to the database table t_wechat_message_log
     *
     * @mbg.generated do_not_delete_during_merge 2018-07-07 16:03:38
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }
}