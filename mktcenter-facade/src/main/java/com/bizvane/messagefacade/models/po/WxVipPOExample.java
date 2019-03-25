package com.bizvane.messagefacade.models.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class WxVipPOExample implements Serializable {
    /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  protected String orderByClause;
  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  protected boolean distinct;
  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  protected List<Criteria> oredCriteria;
  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  private static final long serialVersionUID = 1L;

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public WxVipPOExample() {
    oredCriteria = new ArrayList<Criteria>();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setOrderByClause(String orderByClause) {
    this.orderByClause = orderByClause;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getOrderByClause() {
    return orderByClause;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setDistinct(boolean distinct) {
    this.distinct = distinct;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public boolean isDistinct() {
    return distinct;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public List<Criteria> getOredCriteria() {
    return oredCriteria;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void or(Criteria criteria) {
    oredCriteria.add(criteria);
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public Criteria or() {
    Criteria criteria = createCriteriaInternal();
    oredCriteria.add(criteria);
    return criteria;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
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
   * @mbg.generated  2018-07-07 17:52:51
   */
  protected Criteria createCriteriaInternal() {
    Criteria criteria = new Criteria();
    return criteria;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void clear() {
    oredCriteria.clear();
    orderByClause = null;
    distinct = false;
  }

  /**
   * 只读. wx_vip
   * @mbg.generated  2018-07-07 17:52:51
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

    protected void addCriterionForJDBCDate(String condition, Date value, String property) {
      if (value == null) {
        throw new RuntimeException("Value for " + property + " cannot be null");
      }
      addCriterion(condition, new java.sql.Date(value.getTime()), property);
    }

    protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
      if (values == null || values.size() == 0) {
        throw new RuntimeException("Value list for " + property + " cannot be null or empty");
      }
      List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
      Iterator<Date> iter = values.iterator();
      while (iter.hasNext()) {
        dateList.add(new java.sql.Date(iter.next().getTime()));
      }
      addCriterion(condition, dateList, property);
    }

    protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
      if (value1 == null || value2 == null) {
        throw new RuntimeException("Between values for " + property + " cannot be null");
      }
      addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
    }

    public Criteria andIdIsNull() {
      addCriterion("ID is null");
      return (Criteria) this;
    }

    public Criteria andIdIsNotNull() {
      addCriterion("ID is not null");
      return (Criteria) this;
    }

    public Criteria andIdEqualTo(Long value) {
      addCriterion("ID =", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdNotEqualTo(Long value) {
      addCriterion("ID <>", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdGreaterThan(Long value) {
      addCriterion("ID >", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdGreaterThanOrEqualTo(Long value) {
      addCriterion("ID >=", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdLessThan(Long value) {
      addCriterion("ID <", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdLessThanOrEqualTo(Long value) {
      addCriterion("ID <=", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdIn(List<Long> values) {
      addCriterion("ID in", values, "id");
      return (Criteria) this;
    }

    public Criteria andIdNotIn(List<Long> values) {
      addCriterion("ID not in", values, "id");
      return (Criteria) this;
    }

    public Criteria andIdBetween(Long value1, Long value2) {
      addCriterion("ID between", value1, value2, "id");
      return (Criteria) this;
    }

    public Criteria andIdNotBetween(Long value1, Long value2) {
      addCriterion("ID not between", value1, value2, "id");
      return (Criteria) this;
    }

    public Criteria andAdClientIdIsNull() {
      addCriterion("AD_CLIENT_ID is null");
      return (Criteria) this;
    }

    public Criteria andAdClientIdIsNotNull() {
      addCriterion("AD_CLIENT_ID is not null");
      return (Criteria) this;
    }

    public Criteria andAdClientIdEqualTo(Long value) {
      addCriterion("AD_CLIENT_ID =", value, "adClientId");
      return (Criteria) this;
    }

    public Criteria andAdClientIdNotEqualTo(Long value) {
      addCriterion("AD_CLIENT_ID <>", value, "adClientId");
      return (Criteria) this;
    }

    public Criteria andAdClientIdGreaterThan(Long value) {
      addCriterion("AD_CLIENT_ID >", value, "adClientId");
      return (Criteria) this;
    }

    public Criteria andAdClientIdGreaterThanOrEqualTo(Long value) {
      addCriterion("AD_CLIENT_ID >=", value, "adClientId");
      return (Criteria) this;
    }

    public Criteria andAdClientIdLessThan(Long value) {
      addCriterion("AD_CLIENT_ID <", value, "adClientId");
      return (Criteria) this;
    }

    public Criteria andAdClientIdLessThanOrEqualTo(Long value) {
      addCriterion("AD_CLIENT_ID <=", value, "adClientId");
      return (Criteria) this;
    }

    public Criteria andAdClientIdIn(List<Long> values) {
      addCriterion("AD_CLIENT_ID in", values, "adClientId");
      return (Criteria) this;
    }

    public Criteria andAdClientIdNotIn(List<Long> values) {
      addCriterion("AD_CLIENT_ID not in", values, "adClientId");
      return (Criteria) this;
    }

    public Criteria andAdClientIdBetween(Long value1, Long value2) {
      addCriterion("AD_CLIENT_ID between", value1, value2, "adClientId");
      return (Criteria) this;
    }

    public Criteria andAdClientIdNotBetween(Long value1, Long value2) {
      addCriterion("AD_CLIENT_ID not between", value1, value2, "adClientId");
      return (Criteria) this;
    }

    public Criteria andCreateidIsNull() {
      addCriterion("CREATEID is null");
      return (Criteria) this;
    }

    public Criteria andCreateidIsNotNull() {
      addCriterion("CREATEID is not null");
      return (Criteria) this;
    }

    public Criteria andCreateidEqualTo(Long value) {
      addCriterion("CREATEID =", value, "createid");
      return (Criteria) this;
    }

    public Criteria andCreateidNotEqualTo(Long value) {
      addCriterion("CREATEID <>", value, "createid");
      return (Criteria) this;
    }

    public Criteria andCreateidGreaterThan(Long value) {
      addCriterion("CREATEID >", value, "createid");
      return (Criteria) this;
    }

    public Criteria andCreateidGreaterThanOrEqualTo(Long value) {
      addCriterion("CREATEID >=", value, "createid");
      return (Criteria) this;
    }

    public Criteria andCreateidLessThan(Long value) {
      addCriterion("CREATEID <", value, "createid");
      return (Criteria) this;
    }

    public Criteria andCreateidLessThanOrEqualTo(Long value) {
      addCriterion("CREATEID <=", value, "createid");
      return (Criteria) this;
    }

    public Criteria andCreateidIn(List<Long> values) {
      addCriterion("CREATEID in", values, "createid");
      return (Criteria) this;
    }

    public Criteria andCreateidNotIn(List<Long> values) {
      addCriterion("CREATEID not in", values, "createid");
      return (Criteria) this;
    }

    public Criteria andCreateidBetween(Long value1, Long value2) {
      addCriterion("CREATEID between", value1, value2, "createid");
      return (Criteria) this;
    }

    public Criteria andCreateidNotBetween(Long value1, Long value2) {
      addCriterion("CREATEID not between", value1, value2, "createid");
      return (Criteria) this;
    }

    public Criteria andCreatedateIsNull() {
      addCriterion("CREATEDATE is null");
      return (Criteria) this;
    }

    public Criteria andCreatedateIsNotNull() {
      addCriterion("CREATEDATE is not null");
      return (Criteria) this;
    }

    public Criteria andCreatedateEqualTo(Date value) {
      addCriterion("CREATEDATE =", value, "createdate");
      return (Criteria) this;
    }

    public Criteria andCreatedateNotEqualTo(Date value) {
      addCriterion("CREATEDATE <>", value, "createdate");
      return (Criteria) this;
    }

    public Criteria andCreatedateGreaterThan(Date value) {
      addCriterion("CREATEDATE >", value, "createdate");
      return (Criteria) this;
    }

    public Criteria andCreatedateGreaterThanOrEqualTo(Date value) {
      addCriterion("CREATEDATE >=", value, "createdate");
      return (Criteria) this;
    }

    public Criteria andCreatedateLessThan(Date value) {
      addCriterion("CREATEDATE <", value, "createdate");
      return (Criteria) this;
    }

    public Criteria andCreatedateLessThanOrEqualTo(Date value) {
      addCriterion("CREATEDATE <=", value, "createdate");
      return (Criteria) this;
    }

    public Criteria andCreatedateIn(List<Date> values) {
      addCriterion("CREATEDATE in", values, "createdate");
      return (Criteria) this;
    }

    public Criteria andCreatedateNotIn(List<Date> values) {
      addCriterion("CREATEDATE not in", values, "createdate");
      return (Criteria) this;
    }

    public Criteria andCreatedateBetween(Date value1, Date value2) {
      addCriterion("CREATEDATE between", value1, value2, "createdate");
      return (Criteria) this;
    }

    public Criteria andCreatedateNotBetween(Date value1, Date value2) {
      addCriterion("CREATEDATE not between", value1, value2, "createdate");
      return (Criteria) this;
    }

    public Criteria andModifyidIsNull() {
      addCriterion("MODIFYID is null");
      return (Criteria) this;
    }

    public Criteria andModifyidIsNotNull() {
      addCriterion("MODIFYID is not null");
      return (Criteria) this;
    }

    public Criteria andModifyidEqualTo(Long value) {
      addCriterion("MODIFYID =", value, "modifyid");
      return (Criteria) this;
    }

    public Criteria andModifyidNotEqualTo(Long value) {
      addCriterion("MODIFYID <>", value, "modifyid");
      return (Criteria) this;
    }

    public Criteria andModifyidGreaterThan(Long value) {
      addCriterion("MODIFYID >", value, "modifyid");
      return (Criteria) this;
    }

    public Criteria andModifyidGreaterThanOrEqualTo(Long value) {
      addCriterion("MODIFYID >=", value, "modifyid");
      return (Criteria) this;
    }

    public Criteria andModifyidLessThan(Long value) {
      addCriterion("MODIFYID <", value, "modifyid");
      return (Criteria) this;
    }

    public Criteria andModifyidLessThanOrEqualTo(Long value) {
      addCriterion("MODIFYID <=", value, "modifyid");
      return (Criteria) this;
    }

    public Criteria andModifyidIn(List<Long> values) {
      addCriterion("MODIFYID in", values, "modifyid");
      return (Criteria) this;
    }

    public Criteria andModifyidNotIn(List<Long> values) {
      addCriterion("MODIFYID not in", values, "modifyid");
      return (Criteria) this;
    }

    public Criteria andModifyidBetween(Long value1, Long value2) {
      addCriterion("MODIFYID between", value1, value2, "modifyid");
      return (Criteria) this;
    }

    public Criteria andModifyidNotBetween(Long value1, Long value2) {
      addCriterion("MODIFYID not between", value1, value2, "modifyid");
      return (Criteria) this;
    }

    public Criteria andModifydateIsNull() {
      addCriterion("MODIFYDATE is null");
      return (Criteria) this;
    }

    public Criteria andModifydateIsNotNull() {
      addCriterion("MODIFYDATE is not null");
      return (Criteria) this;
    }

    public Criteria andModifydateEqualTo(Date value) {
      addCriterion("MODIFYDATE =", value, "modifydate");
      return (Criteria) this;
    }

    public Criteria andModifydateNotEqualTo(Date value) {
      addCriterion("MODIFYDATE <>", value, "modifydate");
      return (Criteria) this;
    }

    public Criteria andModifydateGreaterThan(Date value) {
      addCriterion("MODIFYDATE >", value, "modifydate");
      return (Criteria) this;
    }

    public Criteria andModifydateGreaterThanOrEqualTo(Date value) {
      addCriterion("MODIFYDATE >=", value, "modifydate");
      return (Criteria) this;
    }

    public Criteria andModifydateLessThan(Date value) {
      addCriterion("MODIFYDATE <", value, "modifydate");
      return (Criteria) this;
    }

    public Criteria andModifydateLessThanOrEqualTo(Date value) {
      addCriterion("MODIFYDATE <=", value, "modifydate");
      return (Criteria) this;
    }

    public Criteria andModifydateIn(List<Date> values) {
      addCriterion("MODIFYDATE in", values, "modifydate");
      return (Criteria) this;
    }

    public Criteria andModifydateNotIn(List<Date> values) {
      addCriterion("MODIFYDATE not in", values, "modifydate");
      return (Criteria) this;
    }

    public Criteria andModifydateBetween(Date value1, Date value2) {
      addCriterion("MODIFYDATE between", value1, value2, "modifydate");
      return (Criteria) this;
    }

    public Criteria andModifydateNotBetween(Date value1, Date value2) {
      addCriterion("MODIFYDATE not between", value1, value2, "modifydate");
      return (Criteria) this;
    }

    public Criteria andIsactiveIsNull() {
      addCriterion("ISACTIVE is null");
      return (Criteria) this;
    }

    public Criteria andIsactiveIsNotNull() {
      addCriterion("ISACTIVE is not null");
      return (Criteria) this;
    }

    public Criteria andIsactiveEqualTo(String value) {
      addCriterion("ISACTIVE =", value, "isactive");
      return (Criteria) this;
    }

    public Criteria andIsactiveNotEqualTo(String value) {
      addCriterion("ISACTIVE <>", value, "isactive");
      return (Criteria) this;
    }

    public Criteria andIsactiveGreaterThan(String value) {
      addCriterion("ISACTIVE >", value, "isactive");
      return (Criteria) this;
    }

    public Criteria andIsactiveGreaterThanOrEqualTo(String value) {
      addCriterion("ISACTIVE >=", value, "isactive");
      return (Criteria) this;
    }

    public Criteria andIsactiveLessThan(String value) {
      addCriterion("ISACTIVE <", value, "isactive");
      return (Criteria) this;
    }

    public Criteria andIsactiveLessThanOrEqualTo(String value) {
      addCriterion("ISACTIVE <=", value, "isactive");
      return (Criteria) this;
    }

    public Criteria andIsactiveLike(String value) {
      addCriterion("ISACTIVE like", value, "isactive");
      return (Criteria) this;
    }

    public Criteria andIsactiveNotLike(String value) {
      addCriterion("ISACTIVE not like", value, "isactive");
      return (Criteria) this;
    }

    public Criteria andIsactiveIn(List<String> values) {
      addCriterion("ISACTIVE in", values, "isactive");
      return (Criteria) this;
    }

    public Criteria andIsactiveNotIn(List<String> values) {
      addCriterion("ISACTIVE not in", values, "isactive");
      return (Criteria) this;
    }

    public Criteria andIsactiveBetween(String value1, String value2) {
      addCriterion("ISACTIVE between", value1, value2, "isactive");
      return (Criteria) this;
    }

    public Criteria andIsactiveNotBetween(String value1, String value2) {
      addCriterion("ISACTIVE not between", value1, value2, "isactive");
      return (Criteria) this;
    }

    public Criteria andNameIsNull() {
      addCriterion("NAME is null");
      return (Criteria) this;
    }

    public Criteria andNameIsNotNull() {
      addCriterion("NAME is not null");
      return (Criteria) this;
    }

    public Criteria andNameEqualTo(String value) {
      addCriterion("NAME =", value, "name");
      return (Criteria) this;
    }

    public Criteria andNameNotEqualTo(String value) {
      addCriterion("NAME <>", value, "name");
      return (Criteria) this;
    }

    public Criteria andNameGreaterThan(String value) {
      addCriterion("NAME >", value, "name");
      return (Criteria) this;
    }

    public Criteria andNameGreaterThanOrEqualTo(String value) {
      addCriterion("NAME >=", value, "name");
      return (Criteria) this;
    }

    public Criteria andNameLessThan(String value) {
      addCriterion("NAME <", value, "name");
      return (Criteria) this;
    }

    public Criteria andNameLessThanOrEqualTo(String value) {
      addCriterion("NAME <=", value, "name");
      return (Criteria) this;
    }

    public Criteria andNameLike(String value) {
      addCriterion("NAME like", value, "name");
      return (Criteria) this;
    }

    public Criteria andNameNotLike(String value) {
      addCriterion("NAME not like", value, "name");
      return (Criteria) this;
    }

    public Criteria andNameIn(List<String> values) {
      addCriterion("NAME in", values, "name");
      return (Criteria) this;
    }

    public Criteria andNameNotIn(List<String> values) {
      addCriterion("NAME not in", values, "name");
      return (Criteria) this;
    }

    public Criteria andNameBetween(String value1, String value2) {
      addCriterion("NAME between", value1, value2, "name");
      return (Criteria) this;
    }

    public Criteria andNameNotBetween(String value1, String value2) {
      addCriterion("NAME not between", value1, value2, "name");
      return (Criteria) this;
    }

    public Criteria andNicknameIsNull() {
      addCriterion("NICKNAME is null");
      return (Criteria) this;
    }

    public Criteria andNicknameIsNotNull() {
      addCriterion("NICKNAME is not null");
      return (Criteria) this;
    }

    public Criteria andNicknameEqualTo(String value) {
      addCriterion("NICKNAME =", value, "nickname");
      return (Criteria) this;
    }

    public Criteria andNicknameNotEqualTo(String value) {
      addCriterion("NICKNAME <>", value, "nickname");
      return (Criteria) this;
    }

    public Criteria andNicknameGreaterThan(String value) {
      addCriterion("NICKNAME >", value, "nickname");
      return (Criteria) this;
    }

    public Criteria andNicknameGreaterThanOrEqualTo(String value) {
      addCriterion("NICKNAME >=", value, "nickname");
      return (Criteria) this;
    }

    public Criteria andNicknameLessThan(String value) {
      addCriterion("NICKNAME <", value, "nickname");
      return (Criteria) this;
    }

    public Criteria andNicknameLessThanOrEqualTo(String value) {
      addCriterion("NICKNAME <=", value, "nickname");
      return (Criteria) this;
    }

    public Criteria andNicknameLike(String value) {
      addCriterion("NICKNAME like", value, "nickname");
      return (Criteria) this;
    }

    public Criteria andNicknameNotLike(String value) {
      addCriterion("NICKNAME not like", value, "nickname");
      return (Criteria) this;
    }

    public Criteria andNicknameIn(List<String> values) {
      addCriterion("NICKNAME in", values, "nickname");
      return (Criteria) this;
    }

    public Criteria andNicknameNotIn(List<String> values) {
      addCriterion("NICKNAME not in", values, "nickname");
      return (Criteria) this;
    }

    public Criteria andNicknameBetween(String value1, String value2) {
      addCriterion("NICKNAME between", value1, value2, "nickname");
      return (Criteria) this;
    }

    public Criteria andNicknameNotBetween(String value1, String value2) {
      addCriterion("NICKNAME not between", value1, value2, "nickname");
      return (Criteria) this;
    }

    public Criteria andVipNoIsNull() {
      addCriterion("VIP_NO is null");
      return (Criteria) this;
    }

    public Criteria andVipNoIsNotNull() {
      addCriterion("VIP_NO is not null");
      return (Criteria) this;
    }

    public Criteria andVipNoEqualTo(String value) {
      addCriterion("VIP_NO =", value, "vipNo");
      return (Criteria) this;
    }

    public Criteria andVipNoNotEqualTo(String value) {
      addCriterion("VIP_NO <>", value, "vipNo");
      return (Criteria) this;
    }

    public Criteria andVipNoGreaterThan(String value) {
      addCriterion("VIP_NO >", value, "vipNo");
      return (Criteria) this;
    }

    public Criteria andVipNoGreaterThanOrEqualTo(String value) {
      addCriterion("VIP_NO >=", value, "vipNo");
      return (Criteria) this;
    }

    public Criteria andVipNoLessThan(String value) {
      addCriterion("VIP_NO <", value, "vipNo");
      return (Criteria) this;
    }

    public Criteria andVipNoLessThanOrEqualTo(String value) {
      addCriterion("VIP_NO <=", value, "vipNo");
      return (Criteria) this;
    }

    public Criteria andVipNoLike(String value) {
      addCriterion("VIP_NO like", value, "vipNo");
      return (Criteria) this;
    }

    public Criteria andVipNoNotLike(String value) {
      addCriterion("VIP_NO not like", value, "vipNo");
      return (Criteria) this;
    }

    public Criteria andVipNoIn(List<String> values) {
      addCriterion("VIP_NO in", values, "vipNo");
      return (Criteria) this;
    }

    public Criteria andVipNoNotIn(List<String> values) {
      addCriterion("VIP_NO not in", values, "vipNo");
      return (Criteria) this;
    }

    public Criteria andVipNoBetween(String value1, String value2) {
      addCriterion("VIP_NO between", value1, value2, "vipNo");
      return (Criteria) this;
    }

    public Criteria andVipNoNotBetween(String value1, String value2) {
      addCriterion("VIP_NO not between", value1, value2, "vipNo");
      return (Criteria) this;
    }

    public Criteria andWxViptypeIdIsNull() {
      addCriterion("WX_VIPTYPE_ID is null");
      return (Criteria) this;
    }

    public Criteria andWxViptypeIdIsNotNull() {
      addCriterion("WX_VIPTYPE_ID is not null");
      return (Criteria) this;
    }

    public Criteria andWxViptypeIdEqualTo(Long value) {
      addCriterion("WX_VIPTYPE_ID =", value, "wxViptypeId");
      return (Criteria) this;
    }

    public Criteria andWxViptypeIdNotEqualTo(Long value) {
      addCriterion("WX_VIPTYPE_ID <>", value, "wxViptypeId");
      return (Criteria) this;
    }

    public Criteria andWxViptypeIdGreaterThan(Long value) {
      addCriterion("WX_VIPTYPE_ID >", value, "wxViptypeId");
      return (Criteria) this;
    }

    public Criteria andWxViptypeIdGreaterThanOrEqualTo(Long value) {
      addCriterion("WX_VIPTYPE_ID >=", value, "wxViptypeId");
      return (Criteria) this;
    }

    public Criteria andWxViptypeIdLessThan(Long value) {
      addCriterion("WX_VIPTYPE_ID <", value, "wxViptypeId");
      return (Criteria) this;
    }

    public Criteria andWxViptypeIdLessThanOrEqualTo(Long value) {
      addCriterion("WX_VIPTYPE_ID <=", value, "wxViptypeId");
      return (Criteria) this;
    }

    public Criteria andWxViptypeIdIn(List<Long> values) {
      addCriterion("WX_VIPTYPE_ID in", values, "wxViptypeId");
      return (Criteria) this;
    }

    public Criteria andWxViptypeIdNotIn(List<Long> values) {
      addCriterion("WX_VIPTYPE_ID not in", values, "wxViptypeId");
      return (Criteria) this;
    }

    public Criteria andWxViptypeIdBetween(Long value1, Long value2) {
      addCriterion("WX_VIPTYPE_ID between", value1, value2, "wxViptypeId");
      return (Criteria) this;
    }

    public Criteria andWxViptypeIdNotBetween(Long value1, Long value2) {
      addCriterion("WX_VIPTYPE_ID not between", value1, value2, "wxViptypeId");
      return (Criteria) this;
    }

    public Criteria andPetCardIsNull() {
      addCriterion("PET_CARD is null");
      return (Criteria) this;
    }

    public Criteria andPetCardIsNotNull() {
      addCriterion("PET_CARD is not null");
      return (Criteria) this;
    }

    public Criteria andPetCardEqualTo(String value) {
      addCriterion("PET_CARD =", value, "petCard");
      return (Criteria) this;
    }

    public Criteria andPetCardNotEqualTo(String value) {
      addCriterion("PET_CARD <>", value, "petCard");
      return (Criteria) this;
    }

    public Criteria andPetCardGreaterThan(String value) {
      addCriterion("PET_CARD >", value, "petCard");
      return (Criteria) this;
    }

    public Criteria andPetCardGreaterThanOrEqualTo(String value) {
      addCriterion("PET_CARD >=", value, "petCard");
      return (Criteria) this;
    }

    public Criteria andPetCardLessThan(String value) {
      addCriterion("PET_CARD <", value, "petCard");
      return (Criteria) this;
    }

    public Criteria andPetCardLessThanOrEqualTo(String value) {
      addCriterion("PET_CARD <=", value, "petCard");
      return (Criteria) this;
    }

    public Criteria andPetCardLike(String value) {
      addCriterion("PET_CARD like", value, "petCard");
      return (Criteria) this;
    }

    public Criteria andPetCardNotLike(String value) {
      addCriterion("PET_CARD not like", value, "petCard");
      return (Criteria) this;
    }

    public Criteria andPetCardIn(List<String> values) {
      addCriterion("PET_CARD in", values, "petCard");
      return (Criteria) this;
    }

    public Criteria andPetCardNotIn(List<String> values) {
      addCriterion("PET_CARD not in", values, "petCard");
      return (Criteria) this;
    }

    public Criteria andPetCardBetween(String value1, String value2) {
      addCriterion("PET_CARD between", value1, value2, "petCard");
      return (Criteria) this;
    }

    public Criteria andPetCardNotBetween(String value1, String value2) {
      addCriterion("PET_CARD not between", value1, value2, "petCard");
      return (Criteria) this;
    }

    public Criteria andPasswordIsNull() {
      addCriterion("PASSWORD is null");
      return (Criteria) this;
    }

    public Criteria andPasswordIsNotNull() {
      addCriterion("PASSWORD is not null");
      return (Criteria) this;
    }

    public Criteria andPasswordEqualTo(String value) {
      addCriterion("PASSWORD =", value, "password");
      return (Criteria) this;
    }

    public Criteria andPasswordNotEqualTo(String value) {
      addCriterion("PASSWORD <>", value, "password");
      return (Criteria) this;
    }

    public Criteria andPasswordGreaterThan(String value) {
      addCriterion("PASSWORD >", value, "password");
      return (Criteria) this;
    }

    public Criteria andPasswordGreaterThanOrEqualTo(String value) {
      addCriterion("PASSWORD >=", value, "password");
      return (Criteria) this;
    }

    public Criteria andPasswordLessThan(String value) {
      addCriterion("PASSWORD <", value, "password");
      return (Criteria) this;
    }

    public Criteria andPasswordLessThanOrEqualTo(String value) {
      addCriterion("PASSWORD <=", value, "password");
      return (Criteria) this;
    }

    public Criteria andPasswordLike(String value) {
      addCriterion("PASSWORD like", value, "password");
      return (Criteria) this;
    }

    public Criteria andPasswordNotLike(String value) {
      addCriterion("PASSWORD not like", value, "password");
      return (Criteria) this;
    }

    public Criteria andPasswordIn(List<String> values) {
      addCriterion("PASSWORD in", values, "password");
      return (Criteria) this;
    }

    public Criteria andPasswordNotIn(List<String> values) {
      addCriterion("PASSWORD not in", values, "password");
      return (Criteria) this;
    }

    public Criteria andPasswordBetween(String value1, String value2) {
      addCriterion("PASSWORD between", value1, value2, "password");
      return (Criteria) this;
    }

    public Criteria andPasswordNotBetween(String value1, String value2) {
      addCriterion("PASSWORD not between", value1, value2, "password");
      return (Criteria) this;
    }

    public Criteria andIssetpasswordIsNull() {
      addCriterion("ISSETPASSWORD is null");
      return (Criteria) this;
    }

    public Criteria andIssetpasswordIsNotNull() {
      addCriterion("ISSETPASSWORD is not null");
      return (Criteria) this;
    }

    public Criteria andIssetpasswordEqualTo(String value) {
      addCriterion("ISSETPASSWORD =", value, "issetpassword");
      return (Criteria) this;
    }

    public Criteria andIssetpasswordNotEqualTo(String value) {
      addCriterion("ISSETPASSWORD <>", value, "issetpassword");
      return (Criteria) this;
    }

    public Criteria andIssetpasswordGreaterThan(String value) {
      addCriterion("ISSETPASSWORD >", value, "issetpassword");
      return (Criteria) this;
    }

    public Criteria andIssetpasswordGreaterThanOrEqualTo(String value) {
      addCriterion("ISSETPASSWORD >=", value, "issetpassword");
      return (Criteria) this;
    }

    public Criteria andIssetpasswordLessThan(String value) {
      addCriterion("ISSETPASSWORD <", value, "issetpassword");
      return (Criteria) this;
    }

    public Criteria andIssetpasswordLessThanOrEqualTo(String value) {
      addCriterion("ISSETPASSWORD <=", value, "issetpassword");
      return (Criteria) this;
    }

    public Criteria andIssetpasswordLike(String value) {
      addCriterion("ISSETPASSWORD like", value, "issetpassword");
      return (Criteria) this;
    }

    public Criteria andIssetpasswordNotLike(String value) {
      addCriterion("ISSETPASSWORD not like", value, "issetpassword");
      return (Criteria) this;
    }

    public Criteria andIssetpasswordIn(List<String> values) {
      addCriterion("ISSETPASSWORD in", values, "issetpassword");
      return (Criteria) this;
    }

    public Criteria andIssetpasswordNotIn(List<String> values) {
      addCriterion("ISSETPASSWORD not in", values, "issetpassword");
      return (Criteria) this;
    }

    public Criteria andIssetpasswordBetween(String value1, String value2) {
      addCriterion("ISSETPASSWORD between", value1, value2, "issetpassword");
      return (Criteria) this;
    }

    public Criteria andIssetpasswordNotBetween(String value1, String value2) {
      addCriterion("ISSETPASSWORD not between", value1, value2, "issetpassword");
      return (Criteria) this;
    }

    public Criteria andOpencardTimeIsNull() {
      addCriterion("OPENCARD_TIME is null");
      return (Criteria) this;
    }

    public Criteria andOpencardTimeIsNotNull() {
      addCriterion("OPENCARD_TIME is not null");
      return (Criteria) this;
    }

    public Criteria andOpencardTimeEqualTo(Date value) {
      addCriterion("OPENCARD_TIME =", value, "opencardTime");
      return (Criteria) this;
    }

    public Criteria andOpencardTimeNotEqualTo(Date value) {
      addCriterion("OPENCARD_TIME <>", value, "opencardTime");
      return (Criteria) this;
    }

    public Criteria andOpencardTimeGreaterThan(Date value) {
      addCriterion("OPENCARD_TIME >", value, "opencardTime");
      return (Criteria) this;
    }

    public Criteria andOpencardTimeGreaterThanOrEqualTo(Date value) {
      addCriterion("OPENCARD_TIME >=", value, "opencardTime");
      return (Criteria) this;
    }

    public Criteria andOpencardTimeLessThan(Date value) {
      addCriterion("OPENCARD_TIME <", value, "opencardTime");
      return (Criteria) this;
    }

    public Criteria andOpencardTimeLessThanOrEqualTo(Date value) {
      addCriterion("OPENCARD_TIME <=", value, "opencardTime");
      return (Criteria) this;
    }

    public Criteria andOpencardTimeIn(List<Date> values) {
      addCriterion("OPENCARD_TIME in", values, "opencardTime");
      return (Criteria) this;
    }

    public Criteria andOpencardTimeNotIn(List<Date> values) {
      addCriterion("OPENCARD_TIME not in", values, "opencardTime");
      return (Criteria) this;
    }

    public Criteria andOpencardTimeBetween(Date value1, Date value2) {
      addCriterion("OPENCARD_TIME between", value1, value2, "opencardTime");
      return (Criteria) this;
    }

    public Criteria andOpencardTimeNotBetween(Date value1, Date value2) {
      addCriterion("OPENCARD_TIME not between", value1, value2, "opencardTime");
      return (Criteria) this;
    }

    public Criteria andOvercardTimeIsNull() {
      addCriterion("OVERCARD_TIME is null");
      return (Criteria) this;
    }

    public Criteria andOvercardTimeIsNotNull() {
      addCriterion("OVERCARD_TIME is not null");
      return (Criteria) this;
    }

    public Criteria andOvercardTimeEqualTo(Date value) {
      addCriterionForJDBCDate("OVERCARD_TIME =", value, "overcardTime");
      return (Criteria) this;
    }

    public Criteria andOvercardTimeNotEqualTo(Date value) {
      addCriterionForJDBCDate("OVERCARD_TIME <>", value, "overcardTime");
      return (Criteria) this;
    }

    public Criteria andOvercardTimeGreaterThan(Date value) {
      addCriterionForJDBCDate("OVERCARD_TIME >", value, "overcardTime");
      return (Criteria) this;
    }

    public Criteria andOvercardTimeGreaterThanOrEqualTo(Date value) {
      addCriterionForJDBCDate("OVERCARD_TIME >=", value, "overcardTime");
      return (Criteria) this;
    }

    public Criteria andOvercardTimeLessThan(Date value) {
      addCriterionForJDBCDate("OVERCARD_TIME <", value, "overcardTime");
      return (Criteria) this;
    }

    public Criteria andOvercardTimeLessThanOrEqualTo(Date value) {
      addCriterionForJDBCDate("OVERCARD_TIME <=", value, "overcardTime");
      return (Criteria) this;
    }

    public Criteria andOvercardTimeIn(List<Date> values) {
      addCriterionForJDBCDate("OVERCARD_TIME in", values, "overcardTime");
      return (Criteria) this;
    }

    public Criteria andOvercardTimeNotIn(List<Date> values) {
      addCriterionForJDBCDate("OVERCARD_TIME not in", values, "overcardTime");
      return (Criteria) this;
    }

    public Criteria andOvercardTimeBetween(Date value1, Date value2) {
      addCriterionForJDBCDate("OVERCARD_TIME between", value1, value2, "overcardTime");
      return (Criteria) this;
    }

    public Criteria andOvercardTimeNotBetween(Date value1, Date value2) {
      addCriterionForJDBCDate("OVERCARD_TIME not between", value1, value2, "overcardTime");
      return (Criteria) this;
    }

    public Criteria andTotalIntegralIsNull() {
      addCriterion("TOTAL_INTEGRAL is null");
      return (Criteria) this;
    }

    public Criteria andTotalIntegralIsNotNull() {
      addCriterion("TOTAL_INTEGRAL is not null");
      return (Criteria) this;
    }

    public Criteria andTotalIntegralEqualTo(Integer value) {
      addCriterion("TOTAL_INTEGRAL =", value, "totalIntegral");
      return (Criteria) this;
    }

    public Criteria andTotalIntegralNotEqualTo(Integer value) {
      addCriterion("TOTAL_INTEGRAL <>", value, "totalIntegral");
      return (Criteria) this;
    }

    public Criteria andTotalIntegralGreaterThan(Integer value) {
      addCriterion("TOTAL_INTEGRAL >", value, "totalIntegral");
      return (Criteria) this;
    }

    public Criteria andTotalIntegralGreaterThanOrEqualTo(Integer value) {
      addCriterion("TOTAL_INTEGRAL >=", value, "totalIntegral");
      return (Criteria) this;
    }

    public Criteria andTotalIntegralLessThan(Integer value) {
      addCriterion("TOTAL_INTEGRAL <", value, "totalIntegral");
      return (Criteria) this;
    }

    public Criteria andTotalIntegralLessThanOrEqualTo(Integer value) {
      addCriterion("TOTAL_INTEGRAL <=", value, "totalIntegral");
      return (Criteria) this;
    }

    public Criteria andTotalIntegralIn(List<Integer> values) {
      addCriterion("TOTAL_INTEGRAL in", values, "totalIntegral");
      return (Criteria) this;
    }

    public Criteria andTotalIntegralNotIn(List<Integer> values) {
      addCriterion("TOTAL_INTEGRAL not in", values, "totalIntegral");
      return (Criteria) this;
    }

    public Criteria andTotalIntegralBetween(Integer value1, Integer value2) {
      addCriterion("TOTAL_INTEGRAL between", value1, value2, "totalIntegral");
      return (Criteria) this;
    }

    public Criteria andTotalIntegralNotBetween(Integer value1, Integer value2) {
      addCriterion("TOTAL_INTEGRAL not between", value1, value2, "totalIntegral");
      return (Criteria) this;
    }

    public Criteria andBalanceIsNull() {
      addCriterion("BALANCE is null");
      return (Criteria) this;
    }

    public Criteria andBalanceIsNotNull() {
      addCriterion("BALANCE is not null");
      return (Criteria) this;
    }

    public Criteria andBalanceEqualTo(BigDecimal value) {
      addCriterion("BALANCE =", value, "balance");
      return (Criteria) this;
    }

    public Criteria andBalanceNotEqualTo(BigDecimal value) {
      addCriterion("BALANCE <>", value, "balance");
      return (Criteria) this;
    }

    public Criteria andBalanceGreaterThan(BigDecimal value) {
      addCriterion("BALANCE >", value, "balance");
      return (Criteria) this;
    }

    public Criteria andBalanceGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("BALANCE >=", value, "balance");
      return (Criteria) this;
    }

    public Criteria andBalanceLessThan(BigDecimal value) {
      addCriterion("BALANCE <", value, "balance");
      return (Criteria) this;
    }

    public Criteria andBalanceLessThanOrEqualTo(BigDecimal value) {
      addCriterion("BALANCE <=", value, "balance");
      return (Criteria) this;
    }

    public Criteria andBalanceIn(List<BigDecimal> values) {
      addCriterion("BALANCE in", values, "balance");
      return (Criteria) this;
    }

    public Criteria andBalanceNotIn(List<BigDecimal> values) {
      addCriterion("BALANCE not in", values, "balance");
      return (Criteria) this;
    }

    public Criteria andBalanceBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("BALANCE between", value1, value2, "balance");
      return (Criteria) this;
    }

    public Criteria andBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("BALANCE not between", value1, value2, "balance");
      return (Criteria) this;
    }

    public Criteria andStatusNameIsNull() {
      addCriterion("STATUS_NAME is null");
      return (Criteria) this;
    }

    public Criteria andStatusNameIsNotNull() {
      addCriterion("STATUS_NAME is not null");
      return (Criteria) this;
    }

    public Criteria andStatusNameEqualTo(String value) {
      addCriterion("STATUS_NAME =", value, "statusName");
      return (Criteria) this;
    }

    public Criteria andStatusNameNotEqualTo(String value) {
      addCriterion("STATUS_NAME <>", value, "statusName");
      return (Criteria) this;
    }

    public Criteria andStatusNameGreaterThan(String value) {
      addCriterion("STATUS_NAME >", value, "statusName");
      return (Criteria) this;
    }

    public Criteria andStatusNameGreaterThanOrEqualTo(String value) {
      addCriterion("STATUS_NAME >=", value, "statusName");
      return (Criteria) this;
    }

    public Criteria andStatusNameLessThan(String value) {
      addCriterion("STATUS_NAME <", value, "statusName");
      return (Criteria) this;
    }

    public Criteria andStatusNameLessThanOrEqualTo(String value) {
      addCriterion("STATUS_NAME <=", value, "statusName");
      return (Criteria) this;
    }

    public Criteria andStatusNameLike(String value) {
      addCriterion("STATUS_NAME like", value, "statusName");
      return (Criteria) this;
    }

    public Criteria andStatusNameNotLike(String value) {
      addCriterion("STATUS_NAME not like", value, "statusName");
      return (Criteria) this;
    }

    public Criteria andStatusNameIn(List<String> values) {
      addCriterion("STATUS_NAME in", values, "statusName");
      return (Criteria) this;
    }

    public Criteria andStatusNameNotIn(List<String> values) {
      addCriterion("STATUS_NAME not in", values, "statusName");
      return (Criteria) this;
    }

    public Criteria andStatusNameBetween(String value1, String value2) {
      addCriterion("STATUS_NAME between", value1, value2, "statusName");
      return (Criteria) this;
    }

    public Criteria andStatusNameNotBetween(String value1, String value2) {
      addCriterion("STATUS_NAME not between", value1, value2, "statusName");
      return (Criteria) this;
    }

    public Criteria andPhoneNumberIsNull() {
      addCriterion("PHONE_NUMBER is null");
      return (Criteria) this;
    }

    public Criteria andPhoneNumberIsNotNull() {
      addCriterion("PHONE_NUMBER is not null");
      return (Criteria) this;
    }

    public Criteria andPhoneNumberEqualTo(String value) {
      addCriterion("PHONE_NUMBER =", value, "phoneNumber");
      return (Criteria) this;
    }

    public Criteria andPhoneNumberNotEqualTo(String value) {
      addCriterion("PHONE_NUMBER <>", value, "phoneNumber");
      return (Criteria) this;
    }

    public Criteria andPhoneNumberGreaterThan(String value) {
      addCriterion("PHONE_NUMBER >", value, "phoneNumber");
      return (Criteria) this;
    }

    public Criteria andPhoneNumberGreaterThanOrEqualTo(String value) {
      addCriterion("PHONE_NUMBER >=", value, "phoneNumber");
      return (Criteria) this;
    }

    public Criteria andPhoneNumberLessThan(String value) {
      addCriterion("PHONE_NUMBER <", value, "phoneNumber");
      return (Criteria) this;
    }

    public Criteria andPhoneNumberLessThanOrEqualTo(String value) {
      addCriterion("PHONE_NUMBER <=", value, "phoneNumber");
      return (Criteria) this;
    }

    public Criteria andPhoneNumberLike(String value) {
      addCriterion("PHONE_NUMBER like", value, "phoneNumber");
      return (Criteria) this;
    }

    public Criteria andPhoneNumberNotLike(String value) {
      addCriterion("PHONE_NUMBER not like", value, "phoneNumber");
      return (Criteria) this;
    }

    public Criteria andPhoneNumberIn(List<String> values) {
      addCriterion("PHONE_NUMBER in", values, "phoneNumber");
      return (Criteria) this;
    }

    public Criteria andPhoneNumberNotIn(List<String> values) {
      addCriterion("PHONE_NUMBER not in", values, "phoneNumber");
      return (Criteria) this;
    }

    public Criteria andPhoneNumberBetween(String value1, String value2) {
      addCriterion("PHONE_NUMBER between", value1, value2, "phoneNumber");
      return (Criteria) this;
    }

    public Criteria andPhoneNumberNotBetween(String value1, String value2) {
      addCriterion("PHONE_NUMBER not between", value1, value2, "phoneNumber");
      return (Criteria) this;
    }

    public Criteria andIdNumberIsNull() {
      addCriterion("ID_NUMBER is null");
      return (Criteria) this;
    }

    public Criteria andIdNumberIsNotNull() {
      addCriterion("ID_NUMBER is not null");
      return (Criteria) this;
    }

    public Criteria andIdNumberEqualTo(String value) {
      addCriterion("ID_NUMBER =", value, "idNumber");
      return (Criteria) this;
    }

    public Criteria andIdNumberNotEqualTo(String value) {
      addCriterion("ID_NUMBER <>", value, "idNumber");
      return (Criteria) this;
    }

    public Criteria andIdNumberGreaterThan(String value) {
      addCriterion("ID_NUMBER >", value, "idNumber");
      return (Criteria) this;
    }

    public Criteria andIdNumberGreaterThanOrEqualTo(String value) {
      addCriterion("ID_NUMBER >=", value, "idNumber");
      return (Criteria) this;
    }

    public Criteria andIdNumberLessThan(String value) {
      addCriterion("ID_NUMBER <", value, "idNumber");
      return (Criteria) this;
    }

    public Criteria andIdNumberLessThanOrEqualTo(String value) {
      addCriterion("ID_NUMBER <=", value, "idNumber");
      return (Criteria) this;
    }

    public Criteria andIdNumberLike(String value) {
      addCriterion("ID_NUMBER like", value, "idNumber");
      return (Criteria) this;
    }

    public Criteria andIdNumberNotLike(String value) {
      addCriterion("ID_NUMBER not like", value, "idNumber");
      return (Criteria) this;
    }

    public Criteria andIdNumberIn(List<String> values) {
      addCriterion("ID_NUMBER in", values, "idNumber");
      return (Criteria) this;
    }

    public Criteria andIdNumberNotIn(List<String> values) {
      addCriterion("ID_NUMBER not in", values, "idNumber");
      return (Criteria) this;
    }

    public Criteria andIdNumberBetween(String value1, String value2) {
      addCriterion("ID_NUMBER between", value1, value2, "idNumber");
      return (Criteria) this;
    }

    public Criteria andIdNumberNotBetween(String value1, String value2) {
      addCriterion("ID_NUMBER not between", value1, value2, "idNumber");
      return (Criteria) this;
    }

    public Criteria andGenderIsNull() {
      addCriterion("GENDER is null");
      return (Criteria) this;
    }

    public Criteria andGenderIsNotNull() {
      addCriterion("GENDER is not null");
      return (Criteria) this;
    }

    public Criteria andGenderEqualTo(String value) {
      addCriterion("GENDER =", value, "gender");
      return (Criteria) this;
    }

    public Criteria andGenderNotEqualTo(String value) {
      addCriterion("GENDER <>", value, "gender");
      return (Criteria) this;
    }

    public Criteria andGenderGreaterThan(String value) {
      addCriterion("GENDER >", value, "gender");
      return (Criteria) this;
    }

    public Criteria andGenderGreaterThanOrEqualTo(String value) {
      addCriterion("GENDER >=", value, "gender");
      return (Criteria) this;
    }

    public Criteria andGenderLessThan(String value) {
      addCriterion("GENDER <", value, "gender");
      return (Criteria) this;
    }

    public Criteria andGenderLessThanOrEqualTo(String value) {
      addCriterion("GENDER <=", value, "gender");
      return (Criteria) this;
    }

    public Criteria andGenderLike(String value) {
      addCriterion("GENDER like", value, "gender");
      return (Criteria) this;
    }

    public Criteria andGenderNotLike(String value) {
      addCriterion("GENDER not like", value, "gender");
      return (Criteria) this;
    }

    public Criteria andGenderIn(List<String> values) {
      addCriterion("GENDER in", values, "gender");
      return (Criteria) this;
    }

    public Criteria andGenderNotIn(List<String> values) {
      addCriterion("GENDER not in", values, "gender");
      return (Criteria) this;
    }

    public Criteria andGenderBetween(String value1, String value2) {
      addCriterion("GENDER between", value1, value2, "gender");
      return (Criteria) this;
    }

    public Criteria andGenderNotBetween(String value1, String value2) {
      addCriterion("GENDER not between", value1, value2, "gender");
      return (Criteria) this;
    }

    public Criteria andBirthdayIsNull() {
      addCriterion("BIRTHDAY is null");
      return (Criteria) this;
    }

    public Criteria andBirthdayIsNotNull() {
      addCriterion("BIRTHDAY is not null");
      return (Criteria) this;
    }

    public Criteria andBirthdayEqualTo(Date value) {
      addCriterionForJDBCDate("BIRTHDAY =", value, "birthday");
      return (Criteria) this;
    }

    public Criteria andBirthdayNotEqualTo(Date value) {
      addCriterionForJDBCDate("BIRTHDAY <>", value, "birthday");
      return (Criteria) this;
    }

    public Criteria andBirthdayGreaterThan(Date value) {
      addCriterionForJDBCDate("BIRTHDAY >", value, "birthday");
      return (Criteria) this;
    }

    public Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
      addCriterionForJDBCDate("BIRTHDAY >=", value, "birthday");
      return (Criteria) this;
    }

    public Criteria andBirthdayLessThan(Date value) {
      addCriterionForJDBCDate("BIRTHDAY <", value, "birthday");
      return (Criteria) this;
    }

    public Criteria andBirthdayLessThanOrEqualTo(Date value) {
      addCriterionForJDBCDate("BIRTHDAY <=", value, "birthday");
      return (Criteria) this;
    }

    public Criteria andBirthdayIn(List<Date> values) {
      addCriterionForJDBCDate("BIRTHDAY in", values, "birthday");
      return (Criteria) this;
    }

    public Criteria andBirthdayNotIn(List<Date> values) {
      addCriterionForJDBCDate("BIRTHDAY not in", values, "birthday");
      return (Criteria) this;
    }

    public Criteria andBirthdayBetween(Date value1, Date value2) {
      addCriterionForJDBCDate("BIRTHDAY between", value1, value2, "birthday");
      return (Criteria) this;
    }

    public Criteria andBirthdayNotBetween(Date value1, Date value2) {
      addCriterionForJDBCDate("BIRTHDAY not between", value1, value2, "birthday");
      return (Criteria) this;
    }

    public Criteria andEmailIsNull() {
      addCriterion("EMAIL is null");
      return (Criteria) this;
    }

    public Criteria andEmailIsNotNull() {
      addCriterion("EMAIL is not null");
      return (Criteria) this;
    }

    public Criteria andEmailEqualTo(String value) {
      addCriterion("EMAIL =", value, "email");
      return (Criteria) this;
    }

    public Criteria andEmailNotEqualTo(String value) {
      addCriterion("EMAIL <>", value, "email");
      return (Criteria) this;
    }

    public Criteria andEmailGreaterThan(String value) {
      addCriterion("EMAIL >", value, "email");
      return (Criteria) this;
    }

    public Criteria andEmailGreaterThanOrEqualTo(String value) {
      addCriterion("EMAIL >=", value, "email");
      return (Criteria) this;
    }

    public Criteria andEmailLessThan(String value) {
      addCriterion("EMAIL <", value, "email");
      return (Criteria) this;
    }

    public Criteria andEmailLessThanOrEqualTo(String value) {
      addCriterion("EMAIL <=", value, "email");
      return (Criteria) this;
    }

    public Criteria andEmailLike(String value) {
      addCriterion("EMAIL like", value, "email");
      return (Criteria) this;
    }

    public Criteria andEmailNotLike(String value) {
      addCriterion("EMAIL not like", value, "email");
      return (Criteria) this;
    }

    public Criteria andEmailIn(List<String> values) {
      addCriterion("EMAIL in", values, "email");
      return (Criteria) this;
    }

    public Criteria andEmailNotIn(List<String> values) {
      addCriterion("EMAIL not in", values, "email");
      return (Criteria) this;
    }

    public Criteria andEmailBetween(String value1, String value2) {
      addCriterion("EMAIL between", value1, value2, "email");
      return (Criteria) this;
    }

    public Criteria andEmailNotBetween(String value1, String value2) {
      addCriterion("EMAIL not between", value1, value2, "email");
      return (Criteria) this;
    }

    public Criteria andProvincesIsNull() {
      addCriterion("PROVINCES is null");
      return (Criteria) this;
    }

    public Criteria andProvincesIsNotNull() {
      addCriterion("PROVINCES is not null");
      return (Criteria) this;
    }

    public Criteria andProvincesEqualTo(String value) {
      addCriterion("PROVINCES =", value, "provinces");
      return (Criteria) this;
    }

    public Criteria andProvincesNotEqualTo(String value) {
      addCriterion("PROVINCES <>", value, "provinces");
      return (Criteria) this;
    }

    public Criteria andProvincesGreaterThan(String value) {
      addCriterion("PROVINCES >", value, "provinces");
      return (Criteria) this;
    }

    public Criteria andProvincesGreaterThanOrEqualTo(String value) {
      addCriterion("PROVINCES >=", value, "provinces");
      return (Criteria) this;
    }

    public Criteria andProvincesLessThan(String value) {
      addCriterion("PROVINCES <", value, "provinces");
      return (Criteria) this;
    }

    public Criteria andProvincesLessThanOrEqualTo(String value) {
      addCriterion("PROVINCES <=", value, "provinces");
      return (Criteria) this;
    }

    public Criteria andProvincesLike(String value) {
      addCriterion("PROVINCES like", value, "provinces");
      return (Criteria) this;
    }

    public Criteria andProvincesNotLike(String value) {
      addCriterion("PROVINCES not like", value, "provinces");
      return (Criteria) this;
    }

    public Criteria andProvincesIn(List<String> values) {
      addCriterion("PROVINCES in", values, "provinces");
      return (Criteria) this;
    }

    public Criteria andProvincesNotIn(List<String> values) {
      addCriterion("PROVINCES not in", values, "provinces");
      return (Criteria) this;
    }

    public Criteria andProvincesBetween(String value1, String value2) {
      addCriterion("PROVINCES between", value1, value2, "provinces");
      return (Criteria) this;
    }

    public Criteria andProvincesNotBetween(String value1, String value2) {
      addCriterion("PROVINCES not between", value1, value2, "provinces");
      return (Criteria) this;
    }

    public Criteria andCitiesIsNull() {
      addCriterion("CITIES is null");
      return (Criteria) this;
    }

    public Criteria andCitiesIsNotNull() {
      addCriterion("CITIES is not null");
      return (Criteria) this;
    }

    public Criteria andCitiesEqualTo(String value) {
      addCriterion("CITIES =", value, "cities");
      return (Criteria) this;
    }

    public Criteria andCitiesNotEqualTo(String value) {
      addCriterion("CITIES <>", value, "cities");
      return (Criteria) this;
    }

    public Criteria andCitiesGreaterThan(String value) {
      addCriterion("CITIES >", value, "cities");
      return (Criteria) this;
    }

    public Criteria andCitiesGreaterThanOrEqualTo(String value) {
      addCriterion("CITIES >=", value, "cities");
      return (Criteria) this;
    }

    public Criteria andCitiesLessThan(String value) {
      addCriterion("CITIES <", value, "cities");
      return (Criteria) this;
    }

    public Criteria andCitiesLessThanOrEqualTo(String value) {
      addCriterion("CITIES <=", value, "cities");
      return (Criteria) this;
    }

    public Criteria andCitiesLike(String value) {
      addCriterion("CITIES like", value, "cities");
      return (Criteria) this;
    }

    public Criteria andCitiesNotLike(String value) {
      addCriterion("CITIES not like", value, "cities");
      return (Criteria) this;
    }

    public Criteria andCitiesIn(List<String> values) {
      addCriterion("CITIES in", values, "cities");
      return (Criteria) this;
    }

    public Criteria andCitiesNotIn(List<String> values) {
      addCriterion("CITIES not in", values, "cities");
      return (Criteria) this;
    }

    public Criteria andCitiesBetween(String value1, String value2) {
      addCriterion("CITIES between", value1, value2, "cities");
      return (Criteria) this;
    }

    public Criteria andCitiesNotBetween(String value1, String value2) {
      addCriterion("CITIES not between", value1, value2, "cities");
      return (Criteria) this;
    }

    public Criteria andCountiesIsNull() {
      addCriterion("COUNTIES is null");
      return (Criteria) this;
    }

    public Criteria andCountiesIsNotNull() {
      addCriterion("COUNTIES is not null");
      return (Criteria) this;
    }

    public Criteria andCountiesEqualTo(String value) {
      addCriterion("COUNTIES =", value, "counties");
      return (Criteria) this;
    }

    public Criteria andCountiesNotEqualTo(String value) {
      addCriterion("COUNTIES <>", value, "counties");
      return (Criteria) this;
    }

    public Criteria andCountiesGreaterThan(String value) {
      addCriterion("COUNTIES >", value, "counties");
      return (Criteria) this;
    }

    public Criteria andCountiesGreaterThanOrEqualTo(String value) {
      addCriterion("COUNTIES >=", value, "counties");
      return (Criteria) this;
    }

    public Criteria andCountiesLessThan(String value) {
      addCriterion("COUNTIES <", value, "counties");
      return (Criteria) this;
    }

    public Criteria andCountiesLessThanOrEqualTo(String value) {
      addCriterion("COUNTIES <=", value, "counties");
      return (Criteria) this;
    }

    public Criteria andCountiesLike(String value) {
      addCriterion("COUNTIES like", value, "counties");
      return (Criteria) this;
    }

    public Criteria andCountiesNotLike(String value) {
      addCriterion("COUNTIES not like", value, "counties");
      return (Criteria) this;
    }

    public Criteria andCountiesIn(List<String> values) {
      addCriterion("COUNTIES in", values, "counties");
      return (Criteria) this;
    }

    public Criteria andCountiesNotIn(List<String> values) {
      addCriterion("COUNTIES not in", values, "counties");
      return (Criteria) this;
    }

    public Criteria andCountiesBetween(String value1, String value2) {
      addCriterion("COUNTIES between", value1, value2, "counties");
      return (Criteria) this;
    }

    public Criteria andCountiesNotBetween(String value1, String value2) {
      addCriterion("COUNTIES not between", value1, value2, "counties");
      return (Criteria) this;
    }

    public Criteria andOpenidIsNull() {
      addCriterion("OPENID is null");
      return (Criteria) this;
    }

    public Criteria andOpenidIsNotNull() {
      addCriterion("OPENID is not null");
      return (Criteria) this;
    }

    public Criteria andOpenidEqualTo(String value) {
      addCriterion("OPENID =", value, "openid");
      return (Criteria) this;
    }

    public Criteria andOpenidNotEqualTo(String value) {
      addCriterion("OPENID <>", value, "openid");
      return (Criteria) this;
    }

    public Criteria andOpenidGreaterThan(String value) {
      addCriterion("OPENID >", value, "openid");
      return (Criteria) this;
    }

    public Criteria andOpenidGreaterThanOrEqualTo(String value) {
      addCriterion("OPENID >=", value, "openid");
      return (Criteria) this;
    }

    public Criteria andOpenidLessThan(String value) {
      addCriterion("OPENID <", value, "openid");
      return (Criteria) this;
    }

    public Criteria andOpenidLessThanOrEqualTo(String value) {
      addCriterion("OPENID <=", value, "openid");
      return (Criteria) this;
    }

    public Criteria andOpenidLike(String value) {
      addCriterion("OPENID like", value, "openid");
      return (Criteria) this;
    }

    public Criteria andOpenidNotLike(String value) {
      addCriterion("OPENID not like", value, "openid");
      return (Criteria) this;
    }

    public Criteria andOpenidIn(List<String> values) {
      addCriterion("OPENID in", values, "openid");
      return (Criteria) this;
    }

    public Criteria andOpenidNotIn(List<String> values) {
      addCriterion("OPENID not in", values, "openid");
      return (Criteria) this;
    }

    public Criteria andOpenidBetween(String value1, String value2) {
      addCriterion("OPENID between", value1, value2, "openid");
      return (Criteria) this;
    }

    public Criteria andOpenidNotBetween(String value1, String value2) {
      addCriterion("OPENID not between", value1, value2, "openid");
      return (Criteria) this;
    }

    public Criteria andOffCardIdIsNull() {
      addCriterion("OFF_CARD_ID is null");
      return (Criteria) this;
    }

    public Criteria andOffCardIdIsNotNull() {
      addCriterion("OFF_CARD_ID is not null");
      return (Criteria) this;
    }

    public Criteria andOffCardIdEqualTo(String value) {
      addCriterion("OFF_CARD_ID =", value, "offCardId");
      return (Criteria) this;
    }

    public Criteria andOffCardIdNotEqualTo(String value) {
      addCriterion("OFF_CARD_ID <>", value, "offCardId");
      return (Criteria) this;
    }

    public Criteria andOffCardIdGreaterThan(String value) {
      addCriterion("OFF_CARD_ID >", value, "offCardId");
      return (Criteria) this;
    }

    public Criteria andOffCardIdGreaterThanOrEqualTo(String value) {
      addCriterion("OFF_CARD_ID >=", value, "offCardId");
      return (Criteria) this;
    }

    public Criteria andOffCardIdLessThan(String value) {
      addCriterion("OFF_CARD_ID <", value, "offCardId");
      return (Criteria) this;
    }

    public Criteria andOffCardIdLessThanOrEqualTo(String value) {
      addCriterion("OFF_CARD_ID <=", value, "offCardId");
      return (Criteria) this;
    }

    public Criteria andOffCardIdLike(String value) {
      addCriterion("OFF_CARD_ID like", value, "offCardId");
      return (Criteria) this;
    }

    public Criteria andOffCardIdNotLike(String value) {
      addCriterion("OFF_CARD_ID not like", value, "offCardId");
      return (Criteria) this;
    }

    public Criteria andOffCardIdIn(List<String> values) {
      addCriterion("OFF_CARD_ID in", values, "offCardId");
      return (Criteria) this;
    }

    public Criteria andOffCardIdNotIn(List<String> values) {
      addCriterion("OFF_CARD_ID not in", values, "offCardId");
      return (Criteria) this;
    }

    public Criteria andOffCardIdBetween(String value1, String value2) {
      addCriterion("OFF_CARD_ID between", value1, value2, "offCardId");
      return (Criteria) this;
    }

    public Criteria andOffCardIdNotBetween(String value1, String value2) {
      addCriterion("OFF_CARD_ID not between", value1, value2, "offCardId");
      return (Criteria) this;
    }

    public Criteria andIstiedcardIsNull() {
      addCriterion("ISTIEDCARD is null");
      return (Criteria) this;
    }

    public Criteria andIstiedcardIsNotNull() {
      addCriterion("ISTIEDCARD is not null");
      return (Criteria) this;
    }

    public Criteria andIstiedcardEqualTo(String value) {
      addCriterion("ISTIEDCARD =", value, "istiedcard");
      return (Criteria) this;
    }

    public Criteria andIstiedcardNotEqualTo(String value) {
      addCriterion("ISTIEDCARD <>", value, "istiedcard");
      return (Criteria) this;
    }

    public Criteria andIstiedcardGreaterThan(String value) {
      addCriterion("ISTIEDCARD >", value, "istiedcard");
      return (Criteria) this;
    }

    public Criteria andIstiedcardGreaterThanOrEqualTo(String value) {
      addCriterion("ISTIEDCARD >=", value, "istiedcard");
      return (Criteria) this;
    }

    public Criteria andIstiedcardLessThan(String value) {
      addCriterion("ISTIEDCARD <", value, "istiedcard");
      return (Criteria) this;
    }

    public Criteria andIstiedcardLessThanOrEqualTo(String value) {
      addCriterion("ISTIEDCARD <=", value, "istiedcard");
      return (Criteria) this;
    }

    public Criteria andIstiedcardLike(String value) {
      addCriterion("ISTIEDCARD like", value, "istiedcard");
      return (Criteria) this;
    }

    public Criteria andIstiedcardNotLike(String value) {
      addCriterion("ISTIEDCARD not like", value, "istiedcard");
      return (Criteria) this;
    }

    public Criteria andIstiedcardIn(List<String> values) {
      addCriterion("ISTIEDCARD in", values, "istiedcard");
      return (Criteria) this;
    }

    public Criteria andIstiedcardNotIn(List<String> values) {
      addCriterion("ISTIEDCARD not in", values, "istiedcard");
      return (Criteria) this;
    }

    public Criteria andIstiedcardBetween(String value1, String value2) {
      addCriterion("ISTIEDCARD between", value1, value2, "istiedcard");
      return (Criteria) this;
    }

    public Criteria andIstiedcardNotBetween(String value1, String value2) {
      addCriterion("ISTIEDCARD not between", value1, value2, "istiedcard");
      return (Criteria) this;
    }

    public Criteria andHeadimgUrlIsNull() {
      addCriterion("HEADIMG_URL is null");
      return (Criteria) this;
    }

    public Criteria andHeadimgUrlIsNotNull() {
      addCriterion("HEADIMG_URL is not null");
      return (Criteria) this;
    }

    public Criteria andHeadimgUrlEqualTo(String value) {
      addCriterion("HEADIMG_URL =", value, "headimgUrl");
      return (Criteria) this;
    }

    public Criteria andHeadimgUrlNotEqualTo(String value) {
      addCriterion("HEADIMG_URL <>", value, "headimgUrl");
      return (Criteria) this;
    }

    public Criteria andHeadimgUrlGreaterThan(String value) {
      addCriterion("HEADIMG_URL >", value, "headimgUrl");
      return (Criteria) this;
    }

    public Criteria andHeadimgUrlGreaterThanOrEqualTo(String value) {
      addCriterion("HEADIMG_URL >=", value, "headimgUrl");
      return (Criteria) this;
    }

    public Criteria andHeadimgUrlLessThan(String value) {
      addCriterion("HEADIMG_URL <", value, "headimgUrl");
      return (Criteria) this;
    }

    public Criteria andHeadimgUrlLessThanOrEqualTo(String value) {
      addCriterion("HEADIMG_URL <=", value, "headimgUrl");
      return (Criteria) this;
    }

    public Criteria andHeadimgUrlLike(String value) {
      addCriterion("HEADIMG_URL like", value, "headimgUrl");
      return (Criteria) this;
    }

    public Criteria andHeadimgUrlNotLike(String value) {
      addCriterion("HEADIMG_URL not like", value, "headimgUrl");
      return (Criteria) this;
    }

    public Criteria andHeadimgUrlIn(List<String> values) {
      addCriterion("HEADIMG_URL in", values, "headimgUrl");
      return (Criteria) this;
    }

    public Criteria andHeadimgUrlNotIn(List<String> values) {
      addCriterion("HEADIMG_URL not in", values, "headimgUrl");
      return (Criteria) this;
    }

    public Criteria andHeadimgUrlBetween(String value1, String value2) {
      addCriterion("HEADIMG_URL between", value1, value2, "headimgUrl");
      return (Criteria) this;
    }

    public Criteria andHeadimgUrlNotBetween(String value1, String value2) {
      addCriterion("HEADIMG_URL not between", value1, value2, "headimgUrl");
      return (Criteria) this;
    }

    public Criteria andWxStoreIdIsNull() {
      addCriterion("WX_STORE_ID is null");
      return (Criteria) this;
    }

    public Criteria andWxStoreIdIsNotNull() {
      addCriterion("WX_STORE_ID is not null");
      return (Criteria) this;
    }

    public Criteria andWxStoreIdEqualTo(Long value) {
      addCriterion("WX_STORE_ID =", value, "wxStoreId");
      return (Criteria) this;
    }

    public Criteria andWxStoreIdNotEqualTo(Long value) {
      addCriterion("WX_STORE_ID <>", value, "wxStoreId");
      return (Criteria) this;
    }

    public Criteria andWxStoreIdGreaterThan(Long value) {
      addCriterion("WX_STORE_ID >", value, "wxStoreId");
      return (Criteria) this;
    }

    public Criteria andWxStoreIdGreaterThanOrEqualTo(Long value) {
      addCriterion("WX_STORE_ID >=", value, "wxStoreId");
      return (Criteria) this;
    }

    public Criteria andWxStoreIdLessThan(Long value) {
      addCriterion("WX_STORE_ID <", value, "wxStoreId");
      return (Criteria) this;
    }

    public Criteria andWxStoreIdLessThanOrEqualTo(Long value) {
      addCriterion("WX_STORE_ID <=", value, "wxStoreId");
      return (Criteria) this;
    }

    public Criteria andWxStoreIdIn(List<Long> values) {
      addCriterion("WX_STORE_ID in", values, "wxStoreId");
      return (Criteria) this;
    }

    public Criteria andWxStoreIdNotIn(List<Long> values) {
      addCriterion("WX_STORE_ID not in", values, "wxStoreId");
      return (Criteria) this;
    }

    public Criteria andWxStoreIdBetween(Long value1, Long value2) {
      addCriterion("WX_STORE_ID between", value1, value2, "wxStoreId");
      return (Criteria) this;
    }

    public Criteria andWxStoreIdNotBetween(Long value1, Long value2) {
      addCriterion("WX_STORE_ID not between", value1, value2, "wxStoreId");
      return (Criteria) this;
    }

    public Criteria andWxGuideIdIsNull() {
      addCriterion("WX_GUIDE_ID is null");
      return (Criteria) this;
    }

    public Criteria andWxGuideIdIsNotNull() {
      addCriterion("WX_GUIDE_ID is not null");
      return (Criteria) this;
    }

    public Criteria andWxGuideIdEqualTo(Long value) {
      addCriterion("WX_GUIDE_ID =", value, "wxGuideId");
      return (Criteria) this;
    }

    public Criteria andWxGuideIdNotEqualTo(Long value) {
      addCriterion("WX_GUIDE_ID <>", value, "wxGuideId");
      return (Criteria) this;
    }

    public Criteria andWxGuideIdGreaterThan(Long value) {
      addCriterion("WX_GUIDE_ID >", value, "wxGuideId");
      return (Criteria) this;
    }

    public Criteria andWxGuideIdGreaterThanOrEqualTo(Long value) {
      addCriterion("WX_GUIDE_ID >=", value, "wxGuideId");
      return (Criteria) this;
    }

    public Criteria andWxGuideIdLessThan(Long value) {
      addCriterion("WX_GUIDE_ID <", value, "wxGuideId");
      return (Criteria) this;
    }

    public Criteria andWxGuideIdLessThanOrEqualTo(Long value) {
      addCriterion("WX_GUIDE_ID <=", value, "wxGuideId");
      return (Criteria) this;
    }

    public Criteria andWxGuideIdIn(List<Long> values) {
      addCriterion("WX_GUIDE_ID in", values, "wxGuideId");
      return (Criteria) this;
    }

    public Criteria andWxGuideIdNotIn(List<Long> values) {
      addCriterion("WX_GUIDE_ID not in", values, "wxGuideId");
      return (Criteria) this;
    }

    public Criteria andWxGuideIdBetween(Long value1, Long value2) {
      addCriterion("WX_GUIDE_ID between", value1, value2, "wxGuideId");
      return (Criteria) this;
    }

    public Criteria andWxGuideIdNotBetween(Long value1, Long value2) {
      addCriterion("WX_GUIDE_ID not between", value1, value2, "wxGuideId");
      return (Criteria) this;
    }

    public Criteria andWxStoreCurIdIsNull() {
      addCriterion("WX_STORE_CUR_ID is null");
      return (Criteria) this;
    }

    public Criteria andWxStoreCurIdIsNotNull() {
      addCriterion("WX_STORE_CUR_ID is not null");
      return (Criteria) this;
    }

    public Criteria andWxStoreCurIdEqualTo(Long value) {
      addCriterion("WX_STORE_CUR_ID =", value, "wxStoreCurId");
      return (Criteria) this;
    }

    public Criteria andWxStoreCurIdNotEqualTo(Long value) {
      addCriterion("WX_STORE_CUR_ID <>", value, "wxStoreCurId");
      return (Criteria) this;
    }

    public Criteria andWxStoreCurIdGreaterThan(Long value) {
      addCriterion("WX_STORE_CUR_ID >", value, "wxStoreCurId");
      return (Criteria) this;
    }

    public Criteria andWxStoreCurIdGreaterThanOrEqualTo(Long value) {
      addCriterion("WX_STORE_CUR_ID >=", value, "wxStoreCurId");
      return (Criteria) this;
    }

    public Criteria andWxStoreCurIdLessThan(Long value) {
      addCriterion("WX_STORE_CUR_ID <", value, "wxStoreCurId");
      return (Criteria) this;
    }

    public Criteria andWxStoreCurIdLessThanOrEqualTo(Long value) {
      addCriterion("WX_STORE_CUR_ID <=", value, "wxStoreCurId");
      return (Criteria) this;
    }

    public Criteria andWxStoreCurIdIn(List<Long> values) {
      addCriterion("WX_STORE_CUR_ID in", values, "wxStoreCurId");
      return (Criteria) this;
    }

    public Criteria andWxStoreCurIdNotIn(List<Long> values) {
      addCriterion("WX_STORE_CUR_ID not in", values, "wxStoreCurId");
      return (Criteria) this;
    }

    public Criteria andWxStoreCurIdBetween(Long value1, Long value2) {
      addCriterion("WX_STORE_CUR_ID between", value1, value2, "wxStoreCurId");
      return (Criteria) this;
    }

    public Criteria andWxStoreCurIdNotBetween(Long value1, Long value2) {
      addCriterion("WX_STORE_CUR_ID not between", value1, value2, "wxStoreCurId");
      return (Criteria) this;
    }

    public Criteria andWxGuideCurIdIsNull() {
      addCriterion("WX_GUIDE_CUR_ID is null");
      return (Criteria) this;
    }

    public Criteria andWxGuideCurIdIsNotNull() {
      addCriterion("WX_GUIDE_CUR_ID is not null");
      return (Criteria) this;
    }

    public Criteria andWxGuideCurIdEqualTo(Long value) {
      addCriterion("WX_GUIDE_CUR_ID =", value, "wxGuideCurId");
      return (Criteria) this;
    }

    public Criteria andWxGuideCurIdNotEqualTo(Long value) {
      addCriterion("WX_GUIDE_CUR_ID <>", value, "wxGuideCurId");
      return (Criteria) this;
    }

    public Criteria andWxGuideCurIdGreaterThan(Long value) {
      addCriterion("WX_GUIDE_CUR_ID >", value, "wxGuideCurId");
      return (Criteria) this;
    }

    public Criteria andWxGuideCurIdGreaterThanOrEqualTo(Long value) {
      addCriterion("WX_GUIDE_CUR_ID >=", value, "wxGuideCurId");
      return (Criteria) this;
    }

    public Criteria andWxGuideCurIdLessThan(Long value) {
      addCriterion("WX_GUIDE_CUR_ID <", value, "wxGuideCurId");
      return (Criteria) this;
    }

    public Criteria andWxGuideCurIdLessThanOrEqualTo(Long value) {
      addCriterion("WX_GUIDE_CUR_ID <=", value, "wxGuideCurId");
      return (Criteria) this;
    }

    public Criteria andWxGuideCurIdIn(List<Long> values) {
      addCriterion("WX_GUIDE_CUR_ID in", values, "wxGuideCurId");
      return (Criteria) this;
    }

    public Criteria andWxGuideCurIdNotIn(List<Long> values) {
      addCriterion("WX_GUIDE_CUR_ID not in", values, "wxGuideCurId");
      return (Criteria) this;
    }

    public Criteria andWxGuideCurIdBetween(Long value1, Long value2) {
      addCriterion("WX_GUIDE_CUR_ID between", value1, value2, "wxGuideCurId");
      return (Criteria) this;
    }

    public Criteria andWxGuideCurIdNotBetween(Long value1, Long value2) {
      addCriterion("WX_GUIDE_CUR_ID not between", value1, value2, "wxGuideCurId");
      return (Criteria) this;
    }

    public Criteria andIsfocusIsNull() {
      addCriterion("ISFOCUS is null");
      return (Criteria) this;
    }

    public Criteria andIsfocusIsNotNull() {
      addCriterion("ISFOCUS is not null");
      return (Criteria) this;
    }

    public Criteria andIsfocusEqualTo(String value) {
      addCriterion("ISFOCUS =", value, "isfocus");
      return (Criteria) this;
    }

    public Criteria andIsfocusNotEqualTo(String value) {
      addCriterion("ISFOCUS <>", value, "isfocus");
      return (Criteria) this;
    }

    public Criteria andIsfocusGreaterThan(String value) {
      addCriterion("ISFOCUS >", value, "isfocus");
      return (Criteria) this;
    }

    public Criteria andIsfocusGreaterThanOrEqualTo(String value) {
      addCriterion("ISFOCUS >=", value, "isfocus");
      return (Criteria) this;
    }

    public Criteria andIsfocusLessThan(String value) {
      addCriterion("ISFOCUS <", value, "isfocus");
      return (Criteria) this;
    }

    public Criteria andIsfocusLessThanOrEqualTo(String value) {
      addCriterion("ISFOCUS <=", value, "isfocus");
      return (Criteria) this;
    }

    public Criteria andIsfocusLike(String value) {
      addCriterion("ISFOCUS like", value, "isfocus");
      return (Criteria) this;
    }

    public Criteria andIsfocusNotLike(String value) {
      addCriterion("ISFOCUS not like", value, "isfocus");
      return (Criteria) this;
    }

    public Criteria andIsfocusIn(List<String> values) {
      addCriterion("ISFOCUS in", values, "isfocus");
      return (Criteria) this;
    }

    public Criteria andIsfocusNotIn(List<String> values) {
      addCriterion("ISFOCUS not in", values, "isfocus");
      return (Criteria) this;
    }

    public Criteria andIsfocusBetween(String value1, String value2) {
      addCriterion("ISFOCUS between", value1, value2, "isfocus");
      return (Criteria) this;
    }

    public Criteria andIsfocusNotBetween(String value1, String value2) {
      addCriterion("ISFOCUS not between", value1, value2, "isfocus");
      return (Criteria) this;
    }

    public Criteria andUnionidIsNull() {
      addCriterion("UNIONID is null");
      return (Criteria) this;
    }

    public Criteria andUnionidIsNotNull() {
      addCriterion("UNIONID is not null");
      return (Criteria) this;
    }

    public Criteria andUnionidEqualTo(String value) {
      addCriterion("UNIONID =", value, "unionid");
      return (Criteria) this;
    }

    public Criteria andUnionidNotEqualTo(String value) {
      addCriterion("UNIONID <>", value, "unionid");
      return (Criteria) this;
    }

    public Criteria andUnionidGreaterThan(String value) {
      addCriterion("UNIONID >", value, "unionid");
      return (Criteria) this;
    }

    public Criteria andUnionidGreaterThanOrEqualTo(String value) {
      addCriterion("UNIONID >=", value, "unionid");
      return (Criteria) this;
    }

    public Criteria andUnionidLessThan(String value) {
      addCriterion("UNIONID <", value, "unionid");
      return (Criteria) this;
    }

    public Criteria andUnionidLessThanOrEqualTo(String value) {
      addCriterion("UNIONID <=", value, "unionid");
      return (Criteria) this;
    }

    public Criteria andUnionidLike(String value) {
      addCriterion("UNIONID like", value, "unionid");
      return (Criteria) this;
    }

    public Criteria andUnionidNotLike(String value) {
      addCriterion("UNIONID not like", value, "unionid");
      return (Criteria) this;
    }

    public Criteria andUnionidIn(List<String> values) {
      addCriterion("UNIONID in", values, "unionid");
      return (Criteria) this;
    }

    public Criteria andUnionidNotIn(List<String> values) {
      addCriterion("UNIONID not in", values, "unionid");
      return (Criteria) this;
    }

    public Criteria andUnionidBetween(String value1, String value2) {
      addCriterion("UNIONID between", value1, value2, "unionid");
      return (Criteria) this;
    }

    public Criteria andUnionidNotBetween(String value1, String value2) {
      addCriterion("UNIONID not between", value1, value2, "unionid");
      return (Criteria) this;
    }

    public Criteria andLastAccessTimeIsNull() {
      addCriterion("LAST_ACCESS_TIME is null");
      return (Criteria) this;
    }

    public Criteria andLastAccessTimeIsNotNull() {
      addCriterion("LAST_ACCESS_TIME is not null");
      return (Criteria) this;
    }

    public Criteria andLastAccessTimeEqualTo(Date value) {
      addCriterion("LAST_ACCESS_TIME =", value, "lastAccessTime");
      return (Criteria) this;
    }

    public Criteria andLastAccessTimeNotEqualTo(Date value) {
      addCriterion("LAST_ACCESS_TIME <>", value, "lastAccessTime");
      return (Criteria) this;
    }

    public Criteria andLastAccessTimeGreaterThan(Date value) {
      addCriterion("LAST_ACCESS_TIME >", value, "lastAccessTime");
      return (Criteria) this;
    }

    public Criteria andLastAccessTimeGreaterThanOrEqualTo(Date value) {
      addCriterion("LAST_ACCESS_TIME >=", value, "lastAccessTime");
      return (Criteria) this;
    }

    public Criteria andLastAccessTimeLessThan(Date value) {
      addCriterion("LAST_ACCESS_TIME <", value, "lastAccessTime");
      return (Criteria) this;
    }

    public Criteria andLastAccessTimeLessThanOrEqualTo(Date value) {
      addCriterion("LAST_ACCESS_TIME <=", value, "lastAccessTime");
      return (Criteria) this;
    }

    public Criteria andLastAccessTimeIn(List<Date> values) {
      addCriterion("LAST_ACCESS_TIME in", values, "lastAccessTime");
      return (Criteria) this;
    }

    public Criteria andLastAccessTimeNotIn(List<Date> values) {
      addCriterion("LAST_ACCESS_TIME not in", values, "lastAccessTime");
      return (Criteria) this;
    }

    public Criteria andLastAccessTimeBetween(Date value1, Date value2) {
      addCriterion("LAST_ACCESS_TIME between", value1, value2, "lastAccessTime");
      return (Criteria) this;
    }

    public Criteria andLastAccessTimeNotBetween(Date value1, Date value2) {
      addCriterion("LAST_ACCESS_TIME not between", value1, value2, "lastAccessTime");
      return (Criteria) this;
    }

    public Criteria andFocusTimeIsNull() {
      addCriterion("FOCUS_TIME is null");
      return (Criteria) this;
    }

    public Criteria andFocusTimeIsNotNull() {
      addCriterion("FOCUS_TIME is not null");
      return (Criteria) this;
    }

    public Criteria andFocusTimeEqualTo(Date value) {
      addCriterion("FOCUS_TIME =", value, "focusTime");
      return (Criteria) this;
    }

    public Criteria andFocusTimeNotEqualTo(Date value) {
      addCriterion("FOCUS_TIME <>", value, "focusTime");
      return (Criteria) this;
    }

    public Criteria andFocusTimeGreaterThan(Date value) {
      addCriterion("FOCUS_TIME >", value, "focusTime");
      return (Criteria) this;
    }

    public Criteria andFocusTimeGreaterThanOrEqualTo(Date value) {
      addCriterion("FOCUS_TIME >=", value, "focusTime");
      return (Criteria) this;
    }

    public Criteria andFocusTimeLessThan(Date value) {
      addCriterion("FOCUS_TIME <", value, "focusTime");
      return (Criteria) this;
    }

    public Criteria andFocusTimeLessThanOrEqualTo(Date value) {
      addCriterion("FOCUS_TIME <=", value, "focusTime");
      return (Criteria) this;
    }

    public Criteria andFocusTimeIn(List<Date> values) {
      addCriterion("FOCUS_TIME in", values, "focusTime");
      return (Criteria) this;
    }

    public Criteria andFocusTimeNotIn(List<Date> values) {
      addCriterion("FOCUS_TIME not in", values, "focusTime");
      return (Criteria) this;
    }

    public Criteria andFocusTimeBetween(Date value1, Date value2) {
      addCriterion("FOCUS_TIME between", value1, value2, "focusTime");
      return (Criteria) this;
    }

    public Criteria andFocusTimeNotBetween(Date value1, Date value2) {
      addCriterion("FOCUS_TIME not between", value1, value2, "focusTime");
      return (Criteria) this;
    }

    public Criteria andUpdateTimeIsNull() {
      addCriterion("UPDATE_TIME is null");
      return (Criteria) this;
    }

    public Criteria andUpdateTimeIsNotNull() {
      addCriterion("UPDATE_TIME is not null");
      return (Criteria) this;
    }

    public Criteria andUpdateTimeEqualTo(Date value) {
      addCriterion("UPDATE_TIME =", value, "updateTime");
      return (Criteria) this;
    }

    public Criteria andUpdateTimeNotEqualTo(Date value) {
      addCriterion("UPDATE_TIME <>", value, "updateTime");
      return (Criteria) this;
    }

    public Criteria andUpdateTimeGreaterThan(Date value) {
      addCriterion("UPDATE_TIME >", value, "updateTime");
      return (Criteria) this;
    }

    public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
      addCriterion("UPDATE_TIME >=", value, "updateTime");
      return (Criteria) this;
    }

    public Criteria andUpdateTimeLessThan(Date value) {
      addCriterion("UPDATE_TIME <", value, "updateTime");
      return (Criteria) this;
    }

    public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
      addCriterion("UPDATE_TIME <=", value, "updateTime");
      return (Criteria) this;
    }

    public Criteria andUpdateTimeIn(List<Date> values) {
      addCriterion("UPDATE_TIME in", values, "updateTime");
      return (Criteria) this;
    }

    public Criteria andUpdateTimeNotIn(List<Date> values) {
      addCriterion("UPDATE_TIME not in", values, "updateTime");
      return (Criteria) this;
    }

    public Criteria andUpdateTimeBetween(Date value1, Date value2) {
      addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
      return (Criteria) this;
    }

    public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
      addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
      return (Criteria) this;
    }

    public Criteria andCancelTimeIsNull() {
      addCriterion("CANCEL_TIME is null");
      return (Criteria) this;
    }

    public Criteria andCancelTimeIsNotNull() {
      addCriterion("CANCEL_TIME is not null");
      return (Criteria) this;
    }

    public Criteria andCancelTimeEqualTo(Date value) {
      addCriterion("CANCEL_TIME =", value, "cancelTime");
      return (Criteria) this;
    }

    public Criteria andCancelTimeNotEqualTo(Date value) {
      addCriterion("CANCEL_TIME <>", value, "cancelTime");
      return (Criteria) this;
    }

    public Criteria andCancelTimeGreaterThan(Date value) {
      addCriterion("CANCEL_TIME >", value, "cancelTime");
      return (Criteria) this;
    }

    public Criteria andCancelTimeGreaterThanOrEqualTo(Date value) {
      addCriterion("CANCEL_TIME >=", value, "cancelTime");
      return (Criteria) this;
    }

    public Criteria andCancelTimeLessThan(Date value) {
      addCriterion("CANCEL_TIME <", value, "cancelTime");
      return (Criteria) this;
    }

    public Criteria andCancelTimeLessThanOrEqualTo(Date value) {
      addCriterion("CANCEL_TIME <=", value, "cancelTime");
      return (Criteria) this;
    }

    public Criteria andCancelTimeIn(List<Date> values) {
      addCriterion("CANCEL_TIME in", values, "cancelTime");
      return (Criteria) this;
    }

    public Criteria andCancelTimeNotIn(List<Date> values) {
      addCriterion("CANCEL_TIME not in", values, "cancelTime");
      return (Criteria) this;
    }

    public Criteria andCancelTimeBetween(Date value1, Date value2) {
      addCriterion("CANCEL_TIME between", value1, value2, "cancelTime");
      return (Criteria) this;
    }

    public Criteria andCancelTimeNotBetween(Date value1, Date value2) {
      addCriterion("CANCEL_TIME not between", value1, value2, "cancelTime");
      return (Criteria) this;
    }

    public Criteria andWxPublicIdIsNull() {
      addCriterion("WX_PUBLIC_ID is null");
      return (Criteria) this;
    }

    public Criteria andWxPublicIdIsNotNull() {
      addCriterion("WX_PUBLIC_ID is not null");
      return (Criteria) this;
    }

    public Criteria andWxPublicIdEqualTo(Long value) {
      addCriterion("WX_PUBLIC_ID =", value, "wxPublicId");
      return (Criteria) this;
    }

    public Criteria andWxPublicIdNotEqualTo(Long value) {
      addCriterion("WX_PUBLIC_ID <>", value, "wxPublicId");
      return (Criteria) this;
    }

    public Criteria andWxPublicIdGreaterThan(Long value) {
      addCriterion("WX_PUBLIC_ID >", value, "wxPublicId");
      return (Criteria) this;
    }

    public Criteria andWxPublicIdGreaterThanOrEqualTo(Long value) {
      addCriterion("WX_PUBLIC_ID >=", value, "wxPublicId");
      return (Criteria) this;
    }

    public Criteria andWxPublicIdLessThan(Long value) {
      addCriterion("WX_PUBLIC_ID <", value, "wxPublicId");
      return (Criteria) this;
    }

    public Criteria andWxPublicIdLessThanOrEqualTo(Long value) {
      addCriterion("WX_PUBLIC_ID <=", value, "wxPublicId");
      return (Criteria) this;
    }

    public Criteria andWxPublicIdIn(List<Long> values) {
      addCriterion("WX_PUBLIC_ID in", values, "wxPublicId");
      return (Criteria) this;
    }

    public Criteria andWxPublicIdNotIn(List<Long> values) {
      addCriterion("WX_PUBLIC_ID not in", values, "wxPublicId");
      return (Criteria) this;
    }

    public Criteria andWxPublicIdBetween(Long value1, Long value2) {
      addCriterion("WX_PUBLIC_ID between", value1, value2, "wxPublicId");
      return (Criteria) this;
    }

    public Criteria andWxPublicIdNotBetween(Long value1, Long value2) {
      addCriterion("WX_PUBLIC_ID not between", value1, value2, "wxPublicId");
      return (Criteria) this;
    }

    public Criteria andCustcodeIsNull() {
      addCriterion("CUSTCODE is null");
      return (Criteria) this;
    }

    public Criteria andCustcodeIsNotNull() {
      addCriterion("CUSTCODE is not null");
      return (Criteria) this;
    }

    public Criteria andCustcodeEqualTo(String value) {
      addCriterion("CUSTCODE =", value, "custcode");
      return (Criteria) this;
    }

    public Criteria andCustcodeNotEqualTo(String value) {
      addCriterion("CUSTCODE <>", value, "custcode");
      return (Criteria) this;
    }

    public Criteria andCustcodeGreaterThan(String value) {
      addCriterion("CUSTCODE >", value, "custcode");
      return (Criteria) this;
    }

    public Criteria andCustcodeGreaterThanOrEqualTo(String value) {
      addCriterion("CUSTCODE >=", value, "custcode");
      return (Criteria) this;
    }

    public Criteria andCustcodeLessThan(String value) {
      addCriterion("CUSTCODE <", value, "custcode");
      return (Criteria) this;
    }

    public Criteria andCustcodeLessThanOrEqualTo(String value) {
      addCriterion("CUSTCODE <=", value, "custcode");
      return (Criteria) this;
    }

    public Criteria andCustcodeLike(String value) {
      addCriterion("CUSTCODE like", value, "custcode");
      return (Criteria) this;
    }

    public Criteria andCustcodeNotLike(String value) {
      addCriterion("CUSTCODE not like", value, "custcode");
      return (Criteria) this;
    }

    public Criteria andCustcodeIn(List<String> values) {
      addCriterion("CUSTCODE in", values, "custcode");
      return (Criteria) this;
    }

    public Criteria andCustcodeNotIn(List<String> values) {
      addCriterion("CUSTCODE not in", values, "custcode");
      return (Criteria) this;
    }

    public Criteria andCustcodeBetween(String value1, String value2) {
      addCriterion("CUSTCODE between", value1, value2, "custcode");
      return (Criteria) this;
    }

    public Criteria andCustcodeNotBetween(String value1, String value2) {
      addCriterion("CUSTCODE not between", value1, value2, "custcode");
      return (Criteria) this;
    }

    public Criteria andNeedErpupdateIsNull() {
      addCriterion("NEED_ERPUPDATE is null");
      return (Criteria) this;
    }

    public Criteria andNeedErpupdateIsNotNull() {
      addCriterion("NEED_ERPUPDATE is not null");
      return (Criteria) this;
    }

    public Criteria andNeedErpupdateEqualTo(String value) {
      addCriterion("NEED_ERPUPDATE =", value, "needErpupdate");
      return (Criteria) this;
    }

    public Criteria andNeedErpupdateNotEqualTo(String value) {
      addCriterion("NEED_ERPUPDATE <>", value, "needErpupdate");
      return (Criteria) this;
    }

    public Criteria andNeedErpupdateGreaterThan(String value) {
      addCriterion("NEED_ERPUPDATE >", value, "needErpupdate");
      return (Criteria) this;
    }

    public Criteria andNeedErpupdateGreaterThanOrEqualTo(String value) {
      addCriterion("NEED_ERPUPDATE >=", value, "needErpupdate");
      return (Criteria) this;
    }

    public Criteria andNeedErpupdateLessThan(String value) {
      addCriterion("NEED_ERPUPDATE <", value, "needErpupdate");
      return (Criteria) this;
    }

    public Criteria andNeedErpupdateLessThanOrEqualTo(String value) {
      addCriterion("NEED_ERPUPDATE <=", value, "needErpupdate");
      return (Criteria) this;
    }

    public Criteria andNeedErpupdateLike(String value) {
      addCriterion("NEED_ERPUPDATE like", value, "needErpupdate");
      return (Criteria) this;
    }

    public Criteria andNeedErpupdateNotLike(String value) {
      addCriterion("NEED_ERPUPDATE not like", value, "needErpupdate");
      return (Criteria) this;
    }

    public Criteria andNeedErpupdateIn(List<String> values) {
      addCriterion("NEED_ERPUPDATE in", values, "needErpupdate");
      return (Criteria) this;
    }

    public Criteria andNeedErpupdateNotIn(List<String> values) {
      addCriterion("NEED_ERPUPDATE not in", values, "needErpupdate");
      return (Criteria) this;
    }

    public Criteria andNeedErpupdateBetween(String value1, String value2) {
      addCriterion("NEED_ERPUPDATE between", value1, value2, "needErpupdate");
      return (Criteria) this;
    }

    public Criteria andNeedErpupdateNotBetween(String value1, String value2) {
      addCriterion("NEED_ERPUPDATE not between", value1, value2, "needErpupdate");
      return (Criteria) this;
    }

    public Criteria andLastDateIsNull() {
      addCriterion("LAST_DATE is null");
      return (Criteria) this;
    }

    public Criteria andLastDateIsNotNull() {
      addCriterion("LAST_DATE is not null");
      return (Criteria) this;
    }

    public Criteria andLastDateEqualTo(Date value) {
      addCriterion("LAST_DATE =", value, "lastDate");
      return (Criteria) this;
    }

    public Criteria andLastDateNotEqualTo(Date value) {
      addCriterion("LAST_DATE <>", value, "lastDate");
      return (Criteria) this;
    }

    public Criteria andLastDateGreaterThan(Date value) {
      addCriterion("LAST_DATE >", value, "lastDate");
      return (Criteria) this;
    }

    public Criteria andLastDateGreaterThanOrEqualTo(Date value) {
      addCriterion("LAST_DATE >=", value, "lastDate");
      return (Criteria) this;
    }

    public Criteria andLastDateLessThan(Date value) {
      addCriterion("LAST_DATE <", value, "lastDate");
      return (Criteria) this;
    }

    public Criteria andLastDateLessThanOrEqualTo(Date value) {
      addCriterion("LAST_DATE <=", value, "lastDate");
      return (Criteria) this;
    }

    public Criteria andLastDateIn(List<Date> values) {
      addCriterion("LAST_DATE in", values, "lastDate");
      return (Criteria) this;
    }

    public Criteria andLastDateNotIn(List<Date> values) {
      addCriterion("LAST_DATE not in", values, "lastDate");
      return (Criteria) this;
    }

    public Criteria andLastDateBetween(Date value1, Date value2) {
      addCriterion("LAST_DATE between", value1, value2, "lastDate");
      return (Criteria) this;
    }

    public Criteria andLastDateNotBetween(Date value1, Date value2) {
      addCriterion("LAST_DATE not between", value1, value2, "lastDate");
      return (Criteria) this;
    }

    public Criteria andAmountIsNull() {
      addCriterion("AMOUNT is null");
      return (Criteria) this;
    }

    public Criteria andAmountIsNotNull() {
      addCriterion("AMOUNT is not null");
      return (Criteria) this;
    }

    public Criteria andAmountEqualTo(BigDecimal value) {
      addCriterion("AMOUNT =", value, "amount");
      return (Criteria) this;
    }

    public Criteria andAmountNotEqualTo(BigDecimal value) {
      addCriterion("AMOUNT <>", value, "amount");
      return (Criteria) this;
    }

    public Criteria andAmountGreaterThan(BigDecimal value) {
      addCriterion("AMOUNT >", value, "amount");
      return (Criteria) this;
    }

    public Criteria andAmountGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("AMOUNT >=", value, "amount");
      return (Criteria) this;
    }

    public Criteria andAmountLessThan(BigDecimal value) {
      addCriterion("AMOUNT <", value, "amount");
      return (Criteria) this;
    }

    public Criteria andAmountLessThanOrEqualTo(BigDecimal value) {
      addCriterion("AMOUNT <=", value, "amount");
      return (Criteria) this;
    }

    public Criteria andAmountIn(List<BigDecimal> values) {
      addCriterion("AMOUNT in", values, "amount");
      return (Criteria) this;
    }

    public Criteria andAmountNotIn(List<BigDecimal> values) {
      addCriterion("AMOUNT not in", values, "amount");
      return (Criteria) this;
    }

    public Criteria andAmountBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("AMOUNT between", value1, value2, "amount");
      return (Criteria) this;
    }

    public Criteria andAmountNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("AMOUNT not between", value1, value2, "amount");
      return (Criteria) this;
    }

    public Criteria andProfessionalIsNull() {
      addCriterion("PROFESSIONAL is null");
      return (Criteria) this;
    }

    public Criteria andProfessionalIsNotNull() {
      addCriterion("PROFESSIONAL is not null");
      return (Criteria) this;
    }

    public Criteria andProfessionalEqualTo(String value) {
      addCriterion("PROFESSIONAL =", value, "professional");
      return (Criteria) this;
    }

    public Criteria andProfessionalNotEqualTo(String value) {
      addCriterion("PROFESSIONAL <>", value, "professional");
      return (Criteria) this;
    }

    public Criteria andProfessionalGreaterThan(String value) {
      addCriterion("PROFESSIONAL >", value, "professional");
      return (Criteria) this;
    }

    public Criteria andProfessionalGreaterThanOrEqualTo(String value) {
      addCriterion("PROFESSIONAL >=", value, "professional");
      return (Criteria) this;
    }

    public Criteria andProfessionalLessThan(String value) {
      addCriterion("PROFESSIONAL <", value, "professional");
      return (Criteria) this;
    }

    public Criteria andProfessionalLessThanOrEqualTo(String value) {
      addCriterion("PROFESSIONAL <=", value, "professional");
      return (Criteria) this;
    }

    public Criteria andProfessionalLike(String value) {
      addCriterion("PROFESSIONAL like", value, "professional");
      return (Criteria) this;
    }

    public Criteria andProfessionalNotLike(String value) {
      addCriterion("PROFESSIONAL not like", value, "professional");
      return (Criteria) this;
    }

    public Criteria andProfessionalIn(List<String> values) {
      addCriterion("PROFESSIONAL in", values, "professional");
      return (Criteria) this;
    }

    public Criteria andProfessionalNotIn(List<String> values) {
      addCriterion("PROFESSIONAL not in", values, "professional");
      return (Criteria) this;
    }

    public Criteria andProfessionalBetween(String value1, String value2) {
      addCriterion("PROFESSIONAL between", value1, value2, "professional");
      return (Criteria) this;
    }

    public Criteria andProfessionalNotBetween(String value1, String value2) {
      addCriterion("PROFESSIONAL not between", value1, value2, "professional");
      return (Criteria) this;
    }

    public Criteria andBusinessIsNull() {
      addCriterion("BUSINESS is null");
      return (Criteria) this;
    }

    public Criteria andBusinessIsNotNull() {
      addCriterion("BUSINESS is not null");
      return (Criteria) this;
    }

    public Criteria andBusinessEqualTo(String value) {
      addCriterion("BUSINESS =", value, "business");
      return (Criteria) this;
    }

    public Criteria andBusinessNotEqualTo(String value) {
      addCriterion("BUSINESS <>", value, "business");
      return (Criteria) this;
    }

    public Criteria andBusinessGreaterThan(String value) {
      addCriterion("BUSINESS >", value, "business");
      return (Criteria) this;
    }

    public Criteria andBusinessGreaterThanOrEqualTo(String value) {
      addCriterion("BUSINESS >=", value, "business");
      return (Criteria) this;
    }

    public Criteria andBusinessLessThan(String value) {
      addCriterion("BUSINESS <", value, "business");
      return (Criteria) this;
    }

    public Criteria andBusinessLessThanOrEqualTo(String value) {
      addCriterion("BUSINESS <=", value, "business");
      return (Criteria) this;
    }

    public Criteria andBusinessLike(String value) {
      addCriterion("BUSINESS like", value, "business");
      return (Criteria) this;
    }

    public Criteria andBusinessNotLike(String value) {
      addCriterion("BUSINESS not like", value, "business");
      return (Criteria) this;
    }

    public Criteria andBusinessIn(List<String> values) {
      addCriterion("BUSINESS in", values, "business");
      return (Criteria) this;
    }

    public Criteria andBusinessNotIn(List<String> values) {
      addCriterion("BUSINESS not in", values, "business");
      return (Criteria) this;
    }

    public Criteria andBusinessBetween(String value1, String value2) {
      addCriterion("BUSINESS between", value1, value2, "business");
      return (Criteria) this;
    }

    public Criteria andBusinessNotBetween(String value1, String value2) {
      addCriterion("BUSINESS not between", value1, value2, "business");
      return (Criteria) this;
    }

    public Criteria andHobbyIsNull() {
      addCriterion("HOBBY is null");
      return (Criteria) this;
    }

    public Criteria andHobbyIsNotNull() {
      addCriterion("HOBBY is not null");
      return (Criteria) this;
    }

    public Criteria andHobbyEqualTo(String value) {
      addCriterion("HOBBY =", value, "hobby");
      return (Criteria) this;
    }

    public Criteria andHobbyNotEqualTo(String value) {
      addCriterion("HOBBY <>", value, "hobby");
      return (Criteria) this;
    }

    public Criteria andHobbyGreaterThan(String value) {
      addCriterion("HOBBY >", value, "hobby");
      return (Criteria) this;
    }

    public Criteria andHobbyGreaterThanOrEqualTo(String value) {
      addCriterion("HOBBY >=", value, "hobby");
      return (Criteria) this;
    }

    public Criteria andHobbyLessThan(String value) {
      addCriterion("HOBBY <", value, "hobby");
      return (Criteria) this;
    }

    public Criteria andHobbyLessThanOrEqualTo(String value) {
      addCriterion("HOBBY <=", value, "hobby");
      return (Criteria) this;
    }

    public Criteria andHobbyLike(String value) {
      addCriterion("HOBBY like", value, "hobby");
      return (Criteria) this;
    }

    public Criteria andHobbyNotLike(String value) {
      addCriterion("HOBBY not like", value, "hobby");
      return (Criteria) this;
    }

    public Criteria andHobbyIn(List<String> values) {
      addCriterion("HOBBY in", values, "hobby");
      return (Criteria) this;
    }

    public Criteria andHobbyNotIn(List<String> values) {
      addCriterion("HOBBY not in", values, "hobby");
      return (Criteria) this;
    }

    public Criteria andHobbyBetween(String value1, String value2) {
      addCriterion("HOBBY between", value1, value2, "hobby");
      return (Criteria) this;
    }

    public Criteria andHobbyNotBetween(String value1, String value2) {
      addCriterion("HOBBY not between", value1, value2, "hobby");
      return (Criteria) this;
    }

    public Criteria andErpidIsNull() {
      addCriterion("ERPID is null");
      return (Criteria) this;
    }

    public Criteria andErpidIsNotNull() {
      addCriterion("ERPID is not null");
      return (Criteria) this;
    }

    public Criteria andErpidEqualTo(String value) {
      addCriterion("ERPID =", value, "erpid");
      return (Criteria) this;
    }

    public Criteria andErpidNotEqualTo(String value) {
      addCriterion("ERPID <>", value, "erpid");
      return (Criteria) this;
    }

    public Criteria andErpidGreaterThan(String value) {
      addCriterion("ERPID >", value, "erpid");
      return (Criteria) this;
    }

    public Criteria andErpidGreaterThanOrEqualTo(String value) {
      addCriterion("ERPID >=", value, "erpid");
      return (Criteria) this;
    }

    public Criteria andErpidLessThan(String value) {
      addCriterion("ERPID <", value, "erpid");
      return (Criteria) this;
    }

    public Criteria andErpidLessThanOrEqualTo(String value) {
      addCriterion("ERPID <=", value, "erpid");
      return (Criteria) this;
    }

    public Criteria andErpidLike(String value) {
      addCriterion("ERPID like", value, "erpid");
      return (Criteria) this;
    }

    public Criteria andErpidNotLike(String value) {
      addCriterion("ERPID not like", value, "erpid");
      return (Criteria) this;
    }

    public Criteria andErpidIn(List<String> values) {
      addCriterion("ERPID in", values, "erpid");
      return (Criteria) this;
    }

    public Criteria andErpidNotIn(List<String> values) {
      addCriterion("ERPID not in", values, "erpid");
      return (Criteria) this;
    }

    public Criteria andErpidBetween(String value1, String value2) {
      addCriterion("ERPID between", value1, value2, "erpid");
      return (Criteria) this;
    }

    public Criteria andErpidNotBetween(String value1, String value2) {
      addCriterion("ERPID not between", value1, value2, "erpid");
      return (Criteria) this;
    }

    public Criteria andAmountYearIsNull() {
      addCriterion("AMOUNT_YEAR is null");
      return (Criteria) this;
    }

    public Criteria andAmountYearIsNotNull() {
      addCriterion("AMOUNT_YEAR is not null");
      return (Criteria) this;
    }

    public Criteria andAmountYearEqualTo(BigDecimal value) {
      addCriterion("AMOUNT_YEAR =", value, "amountYear");
      return (Criteria) this;
    }

    public Criteria andAmountYearNotEqualTo(BigDecimal value) {
      addCriterion("AMOUNT_YEAR <>", value, "amountYear");
      return (Criteria) this;
    }

    public Criteria andAmountYearGreaterThan(BigDecimal value) {
      addCriterion("AMOUNT_YEAR >", value, "amountYear");
      return (Criteria) this;
    }

    public Criteria andAmountYearGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("AMOUNT_YEAR >=", value, "amountYear");
      return (Criteria) this;
    }

    public Criteria andAmountYearLessThan(BigDecimal value) {
      addCriterion("AMOUNT_YEAR <", value, "amountYear");
      return (Criteria) this;
    }

    public Criteria andAmountYearLessThanOrEqualTo(BigDecimal value) {
      addCriterion("AMOUNT_YEAR <=", value, "amountYear");
      return (Criteria) this;
    }

    public Criteria andAmountYearIn(List<BigDecimal> values) {
      addCriterion("AMOUNT_YEAR in", values, "amountYear");
      return (Criteria) this;
    }

    public Criteria andAmountYearNotIn(List<BigDecimal> values) {
      addCriterion("AMOUNT_YEAR not in", values, "amountYear");
      return (Criteria) this;
    }

    public Criteria andAmountYearBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("AMOUNT_YEAR between", value1, value2, "amountYear");
      return (Criteria) this;
    }

    public Criteria andAmountYearNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("AMOUNT_YEAR not between", value1, value2, "amountYear");
      return (Criteria) this;
    }

    public Criteria andErpopencardstatusIsNull() {
      addCriterion("ERPOPENCARDSTATUS is null");
      return (Criteria) this;
    }

    public Criteria andErpopencardstatusIsNotNull() {
      addCriterion("ERPOPENCARDSTATUS is not null");
      return (Criteria) this;
    }

    public Criteria andErpopencardstatusEqualTo(String value) {
      addCriterion("ERPOPENCARDSTATUS =", value, "erpopencardstatus");
      return (Criteria) this;
    }

    public Criteria andErpopencardstatusNotEqualTo(String value) {
      addCriterion("ERPOPENCARDSTATUS <>", value, "erpopencardstatus");
      return (Criteria) this;
    }

    public Criteria andErpopencardstatusGreaterThan(String value) {
      addCriterion("ERPOPENCARDSTATUS >", value, "erpopencardstatus");
      return (Criteria) this;
    }

    public Criteria andErpopencardstatusGreaterThanOrEqualTo(String value) {
      addCriterion("ERPOPENCARDSTATUS >=", value, "erpopencardstatus");
      return (Criteria) this;
    }

    public Criteria andErpopencardstatusLessThan(String value) {
      addCriterion("ERPOPENCARDSTATUS <", value, "erpopencardstatus");
      return (Criteria) this;
    }

    public Criteria andErpopencardstatusLessThanOrEqualTo(String value) {
      addCriterion("ERPOPENCARDSTATUS <=", value, "erpopencardstatus");
      return (Criteria) this;
    }

    public Criteria andErpopencardstatusLike(String value) {
      addCriterion("ERPOPENCARDSTATUS like", value, "erpopencardstatus");
      return (Criteria) this;
    }

    public Criteria andErpopencardstatusNotLike(String value) {
      addCriterion("ERPOPENCARDSTATUS not like", value, "erpopencardstatus");
      return (Criteria) this;
    }

    public Criteria andErpopencardstatusIn(List<String> values) {
      addCriterion("ERPOPENCARDSTATUS in", values, "erpopencardstatus");
      return (Criteria) this;
    }

    public Criteria andErpopencardstatusNotIn(List<String> values) {
      addCriterion("ERPOPENCARDSTATUS not in", values, "erpopencardstatus");
      return (Criteria) this;
    }

    public Criteria andErpopencardstatusBetween(String value1, String value2) {
      addCriterion("ERPOPENCARDSTATUS between", value1, value2, "erpopencardstatus");
      return (Criteria) this;
    }

    public Criteria andErpopencardstatusNotBetween(String value1, String value2) {
      addCriterion("ERPOPENCARDSTATUS not between", value1, value2, "erpopencardstatus");
      return (Criteria) this;
    }

    public Criteria andErpvipstateIsNull() {
      addCriterion("ERPVIPSTATE is null");
      return (Criteria) this;
    }

    public Criteria andErpvipstateIsNotNull() {
      addCriterion("ERPVIPSTATE is not null");
      return (Criteria) this;
    }

    public Criteria andErpvipstateEqualTo(String value) {
      addCriterion("ERPVIPSTATE =", value, "erpvipstate");
      return (Criteria) this;
    }

    public Criteria andErpvipstateNotEqualTo(String value) {
      addCriterion("ERPVIPSTATE <>", value, "erpvipstate");
      return (Criteria) this;
    }

    public Criteria andErpvipstateGreaterThan(String value) {
      addCriterion("ERPVIPSTATE >", value, "erpvipstate");
      return (Criteria) this;
    }

    public Criteria andErpvipstateGreaterThanOrEqualTo(String value) {
      addCriterion("ERPVIPSTATE >=", value, "erpvipstate");
      return (Criteria) this;
    }

    public Criteria andErpvipstateLessThan(String value) {
      addCriterion("ERPVIPSTATE <", value, "erpvipstate");
      return (Criteria) this;
    }

    public Criteria andErpvipstateLessThanOrEqualTo(String value) {
      addCriterion("ERPVIPSTATE <=", value, "erpvipstate");
      return (Criteria) this;
    }

    public Criteria andErpvipstateLike(String value) {
      addCriterion("ERPVIPSTATE like", value, "erpvipstate");
      return (Criteria) this;
    }

    public Criteria andErpvipstateNotLike(String value) {
      addCriterion("ERPVIPSTATE not like", value, "erpvipstate");
      return (Criteria) this;
    }

    public Criteria andErpvipstateIn(List<String> values) {
      addCriterion("ERPVIPSTATE in", values, "erpvipstate");
      return (Criteria) this;
    }

    public Criteria andErpvipstateNotIn(List<String> values) {
      addCriterion("ERPVIPSTATE not in", values, "erpvipstate");
      return (Criteria) this;
    }

    public Criteria andErpvipstateBetween(String value1, String value2) {
      addCriterion("ERPVIPSTATE between", value1, value2, "erpvipstate");
      return (Criteria) this;
    }

    public Criteria andErpvipstateNotBetween(String value1, String value2) {
      addCriterion("ERPVIPSTATE not between", value1, value2, "erpvipstate");
      return (Criteria) this;
    }

    public Criteria andIsoldvipIsNull() {
      addCriterion("ISOLDVIP is null");
      return (Criteria) this;
    }

    public Criteria andIsoldvipIsNotNull() {
      addCriterion("ISOLDVIP is not null");
      return (Criteria) this;
    }

    public Criteria andIsoldvipEqualTo(String value) {
      addCriterion("ISOLDVIP =", value, "isoldvip");
      return (Criteria) this;
    }

    public Criteria andIsoldvipNotEqualTo(String value) {
      addCriterion("ISOLDVIP <>", value, "isoldvip");
      return (Criteria) this;
    }

    public Criteria andIsoldvipGreaterThan(String value) {
      addCriterion("ISOLDVIP >", value, "isoldvip");
      return (Criteria) this;
    }

    public Criteria andIsoldvipGreaterThanOrEqualTo(String value) {
      addCriterion("ISOLDVIP >=", value, "isoldvip");
      return (Criteria) this;
    }

    public Criteria andIsoldvipLessThan(String value) {
      addCriterion("ISOLDVIP <", value, "isoldvip");
      return (Criteria) this;
    }

    public Criteria andIsoldvipLessThanOrEqualTo(String value) {
      addCriterion("ISOLDVIP <=", value, "isoldvip");
      return (Criteria) this;
    }

    public Criteria andIsoldvipLike(String value) {
      addCriterion("ISOLDVIP like", value, "isoldvip");
      return (Criteria) this;
    }

    public Criteria andIsoldvipNotLike(String value) {
      addCriterion("ISOLDVIP not like", value, "isoldvip");
      return (Criteria) this;
    }

    public Criteria andIsoldvipIn(List<String> values) {
      addCriterion("ISOLDVIP in", values, "isoldvip");
      return (Criteria) this;
    }

    public Criteria andIsoldvipNotIn(List<String> values) {
      addCriterion("ISOLDVIP not in", values, "isoldvip");
      return (Criteria) this;
    }

    public Criteria andIsoldvipBetween(String value1, String value2) {
      addCriterion("ISOLDVIP between", value1, value2, "isoldvip");
      return (Criteria) this;
    }

    public Criteria andIsoldvipNotBetween(String value1, String value2) {
      addCriterion("ISOLDVIP not between", value1, value2, "isoldvip");
      return (Criteria) this;
    }

    public Criteria andIsUnsubscribeIsNull() {
      addCriterion("IS_UNSUBSCRIBE is null");
      return (Criteria) this;
    }

    public Criteria andIsUnsubscribeIsNotNull() {
      addCriterion("IS_UNSUBSCRIBE is not null");
      return (Criteria) this;
    }

    public Criteria andIsUnsubscribeEqualTo(String value) {
      addCriterion("IS_UNSUBSCRIBE =", value, "isUnsubscribe");
      return (Criteria) this;
    }

    public Criteria andIsUnsubscribeNotEqualTo(String value) {
      addCriterion("IS_UNSUBSCRIBE <>", value, "isUnsubscribe");
      return (Criteria) this;
    }

    public Criteria andIsUnsubscribeGreaterThan(String value) {
      addCriterion("IS_UNSUBSCRIBE >", value, "isUnsubscribe");
      return (Criteria) this;
    }

    public Criteria andIsUnsubscribeGreaterThanOrEqualTo(String value) {
      addCriterion("IS_UNSUBSCRIBE >=", value, "isUnsubscribe");
      return (Criteria) this;
    }

    public Criteria andIsUnsubscribeLessThan(String value) {
      addCriterion("IS_UNSUBSCRIBE <", value, "isUnsubscribe");
      return (Criteria) this;
    }

    public Criteria andIsUnsubscribeLessThanOrEqualTo(String value) {
      addCriterion("IS_UNSUBSCRIBE <=", value, "isUnsubscribe");
      return (Criteria) this;
    }

    public Criteria andIsUnsubscribeLike(String value) {
      addCriterion("IS_UNSUBSCRIBE like", value, "isUnsubscribe");
      return (Criteria) this;
    }

    public Criteria andIsUnsubscribeNotLike(String value) {
      addCriterion("IS_UNSUBSCRIBE not like", value, "isUnsubscribe");
      return (Criteria) this;
    }

    public Criteria andIsUnsubscribeIn(List<String> values) {
      addCriterion("IS_UNSUBSCRIBE in", values, "isUnsubscribe");
      return (Criteria) this;
    }

    public Criteria andIsUnsubscribeNotIn(List<String> values) {
      addCriterion("IS_UNSUBSCRIBE not in", values, "isUnsubscribe");
      return (Criteria) this;
    }

    public Criteria andIsUnsubscribeBetween(String value1, String value2) {
      addCriterion("IS_UNSUBSCRIBE between", value1, value2, "isUnsubscribe");
      return (Criteria) this;
    }

    public Criteria andIsUnsubscribeNotBetween(String value1, String value2) {
      addCriterion("IS_UNSUBSCRIBE not between", value1, value2, "isUnsubscribe");
      return (Criteria) this;
    }

    public Criteria andCardidIsNull() {
      addCriterion("CARDID is null");
      return (Criteria) this;
    }

    public Criteria andCardidIsNotNull() {
      addCriterion("CARDID is not null");
      return (Criteria) this;
    }

    public Criteria andCardidEqualTo(String value) {
      addCriterion("CARDID =", value, "cardid");
      return (Criteria) this;
    }

    public Criteria andCardidNotEqualTo(String value) {
      addCriterion("CARDID <>", value, "cardid");
      return (Criteria) this;
    }

    public Criteria andCardidGreaterThan(String value) {
      addCriterion("CARDID >", value, "cardid");
      return (Criteria) this;
    }

    public Criteria andCardidGreaterThanOrEqualTo(String value) {
      addCriterion("CARDID >=", value, "cardid");
      return (Criteria) this;
    }

    public Criteria andCardidLessThan(String value) {
      addCriterion("CARDID <", value, "cardid");
      return (Criteria) this;
    }

    public Criteria andCardidLessThanOrEqualTo(String value) {
      addCriterion("CARDID <=", value, "cardid");
      return (Criteria) this;
    }

    public Criteria andCardidLike(String value) {
      addCriterion("CARDID like", value, "cardid");
      return (Criteria) this;
    }

    public Criteria andCardidNotLike(String value) {
      addCriterion("CARDID not like", value, "cardid");
      return (Criteria) this;
    }

    public Criteria andCardidIn(List<String> values) {
      addCriterion("CARDID in", values, "cardid");
      return (Criteria) this;
    }

    public Criteria andCardidNotIn(List<String> values) {
      addCriterion("CARDID not in", values, "cardid");
      return (Criteria) this;
    }

    public Criteria andCardidBetween(String value1, String value2) {
      addCriterion("CARDID between", value1, value2, "cardid");
      return (Criteria) this;
    }

    public Criteria andCardidNotBetween(String value1, String value2) {
      addCriterion("CARDID not between", value1, value2, "cardid");
      return (Criteria) this;
    }

    public Criteria andIsbingIsNull() {
      addCriterion("ISBING is null");
      return (Criteria) this;
    }

    public Criteria andIsbingIsNotNull() {
      addCriterion("ISBING is not null");
      return (Criteria) this;
    }

    public Criteria andIsbingEqualTo(String value) {
      addCriterion("ISBING =", value, "isbing");
      return (Criteria) this;
    }

    public Criteria andIsbingNotEqualTo(String value) {
      addCriterion("ISBING <>", value, "isbing");
      return (Criteria) this;
    }

    public Criteria andIsbingGreaterThan(String value) {
      addCriterion("ISBING >", value, "isbing");
      return (Criteria) this;
    }

    public Criteria andIsbingGreaterThanOrEqualTo(String value) {
      addCriterion("ISBING >=", value, "isbing");
      return (Criteria) this;
    }

    public Criteria andIsbingLessThan(String value) {
      addCriterion("ISBING <", value, "isbing");
      return (Criteria) this;
    }

    public Criteria andIsbingLessThanOrEqualTo(String value) {
      addCriterion("ISBING <=", value, "isbing");
      return (Criteria) this;
    }

    public Criteria andIsbingLike(String value) {
      addCriterion("ISBING like", value, "isbing");
      return (Criteria) this;
    }

    public Criteria andIsbingNotLike(String value) {
      addCriterion("ISBING not like", value, "isbing");
      return (Criteria) this;
    }

    public Criteria andIsbingIn(List<String> values) {
      addCriterion("ISBING in", values, "isbing");
      return (Criteria) this;
    }

    public Criteria andIsbingNotIn(List<String> values) {
      addCriterion("ISBING not in", values, "isbing");
      return (Criteria) this;
    }

    public Criteria andIsbingBetween(String value1, String value2) {
      addCriterion("ISBING between", value1, value2, "isbing");
      return (Criteria) this;
    }

    public Criteria andIsbingNotBetween(String value1, String value2) {
      addCriterion("ISBING not between", value1, value2, "isbing");
      return (Criteria) this;
    }

    public Criteria andWxCardidIsNull() {
      addCriterion("WX_CARDID is null");
      return (Criteria) this;
    }

    public Criteria andWxCardidIsNotNull() {
      addCriterion("WX_CARDID is not null");
      return (Criteria) this;
    }

    public Criteria andWxCardidEqualTo(String value) {
      addCriterion("WX_CARDID =", value, "wxCardid");
      return (Criteria) this;
    }

    public Criteria andWxCardidNotEqualTo(String value) {
      addCriterion("WX_CARDID <>", value, "wxCardid");
      return (Criteria) this;
    }

    public Criteria andWxCardidGreaterThan(String value) {
      addCriterion("WX_CARDID >", value, "wxCardid");
      return (Criteria) this;
    }

    public Criteria andWxCardidGreaterThanOrEqualTo(String value) {
      addCriterion("WX_CARDID >=", value, "wxCardid");
      return (Criteria) this;
    }

    public Criteria andWxCardidLessThan(String value) {
      addCriterion("WX_CARDID <", value, "wxCardid");
      return (Criteria) this;
    }

    public Criteria andWxCardidLessThanOrEqualTo(String value) {
      addCriterion("WX_CARDID <=", value, "wxCardid");
      return (Criteria) this;
    }

    public Criteria andWxCardidLike(String value) {
      addCriterion("WX_CARDID like", value, "wxCardid");
      return (Criteria) this;
    }

    public Criteria andWxCardidNotLike(String value) {
      addCriterion("WX_CARDID not like", value, "wxCardid");
      return (Criteria) this;
    }

    public Criteria andWxCardidIn(List<String> values) {
      addCriterion("WX_CARDID in", values, "wxCardid");
      return (Criteria) this;
    }

    public Criteria andWxCardidNotIn(List<String> values) {
      addCriterion("WX_CARDID not in", values, "wxCardid");
      return (Criteria) this;
    }

    public Criteria andWxCardidBetween(String value1, String value2) {
      addCriterion("WX_CARDID between", value1, value2, "wxCardid");
      return (Criteria) this;
    }

    public Criteria andWxCardidNotBetween(String value1, String value2) {
      addCriterion("WX_CARDID not between", value1, value2, "wxCardid");
      return (Criteria) this;
    }

    public Criteria andWxCodeIsNull() {
      addCriterion("WX_CODE is null");
      return (Criteria) this;
    }

    public Criteria andWxCodeIsNotNull() {
      addCriterion("WX_CODE is not null");
      return (Criteria) this;
    }

    public Criteria andWxCodeEqualTo(String value) {
      addCriterion("WX_CODE =", value, "wxCode");
      return (Criteria) this;
    }

    public Criteria andWxCodeNotEqualTo(String value) {
      addCriterion("WX_CODE <>", value, "wxCode");
      return (Criteria) this;
    }

    public Criteria andWxCodeGreaterThan(String value) {
      addCriterion("WX_CODE >", value, "wxCode");
      return (Criteria) this;
    }

    public Criteria andWxCodeGreaterThanOrEqualTo(String value) {
      addCriterion("WX_CODE >=", value, "wxCode");
      return (Criteria) this;
    }

    public Criteria andWxCodeLessThan(String value) {
      addCriterion("WX_CODE <", value, "wxCode");
      return (Criteria) this;
    }

    public Criteria andWxCodeLessThanOrEqualTo(String value) {
      addCriterion("WX_CODE <=", value, "wxCode");
      return (Criteria) this;
    }

    public Criteria andWxCodeLike(String value) {
      addCriterion("WX_CODE like", value, "wxCode");
      return (Criteria) this;
    }

    public Criteria andWxCodeNotLike(String value) {
      addCriterion("WX_CODE not like", value, "wxCode");
      return (Criteria) this;
    }

    public Criteria andWxCodeIn(List<String> values) {
      addCriterion("WX_CODE in", values, "wxCode");
      return (Criteria) this;
    }

    public Criteria andWxCodeNotIn(List<String> values) {
      addCriterion("WX_CODE not in", values, "wxCode");
      return (Criteria) this;
    }

    public Criteria andWxCodeBetween(String value1, String value2) {
      addCriterion("WX_CODE between", value1, value2, "wxCode");
      return (Criteria) this;
    }

    public Criteria andWxCodeNotBetween(String value1, String value2) {
      addCriterion("WX_CODE not between", value1, value2, "wxCode");
      return (Criteria) this;
    }

    public Criteria andVipSourceIsNull() {
      addCriterion("VIP_SOURCE is null");
      return (Criteria) this;
    }

    public Criteria andVipSourceIsNotNull() {
      addCriterion("VIP_SOURCE is not null");
      return (Criteria) this;
    }

    public Criteria andVipSourceEqualTo(String value) {
      addCriterion("VIP_SOURCE =", value, "vipSource");
      return (Criteria) this;
    }

    public Criteria andVipSourceNotEqualTo(String value) {
      addCriterion("VIP_SOURCE <>", value, "vipSource");
      return (Criteria) this;
    }

    public Criteria andVipSourceGreaterThan(String value) {
      addCriterion("VIP_SOURCE >", value, "vipSource");
      return (Criteria) this;
    }

    public Criteria andVipSourceGreaterThanOrEqualTo(String value) {
      addCriterion("VIP_SOURCE >=", value, "vipSource");
      return (Criteria) this;
    }

    public Criteria andVipSourceLessThan(String value) {
      addCriterion("VIP_SOURCE <", value, "vipSource");
      return (Criteria) this;
    }

    public Criteria andVipSourceLessThanOrEqualTo(String value) {
      addCriterion("VIP_SOURCE <=", value, "vipSource");
      return (Criteria) this;
    }

    public Criteria andVipSourceLike(String value) {
      addCriterion("VIP_SOURCE like", value, "vipSource");
      return (Criteria) this;
    }

    public Criteria andVipSourceNotLike(String value) {
      addCriterion("VIP_SOURCE not like", value, "vipSource");
      return (Criteria) this;
    }

    public Criteria andVipSourceIn(List<String> values) {
      addCriterion("VIP_SOURCE in", values, "vipSource");
      return (Criteria) this;
    }

    public Criteria andVipSourceNotIn(List<String> values) {
      addCriterion("VIP_SOURCE not in", values, "vipSource");
      return (Criteria) this;
    }

    public Criteria andVipSourceBetween(String value1, String value2) {
      addCriterion("VIP_SOURCE between", value1, value2, "vipSource");
      return (Criteria) this;
    }

    public Criteria andVipSourceNotBetween(String value1, String value2) {
      addCriterion("VIP_SOURCE not between", value1, value2, "vipSource");
      return (Criteria) this;
    }

    public Criteria andOnlineOpentimeIsNull() {
      addCriterion("ONLINE_OPENTIME is null");
      return (Criteria) this;
    }

    public Criteria andOnlineOpentimeIsNotNull() {
      addCriterion("ONLINE_OPENTIME is not null");
      return (Criteria) this;
    }

    public Criteria andOnlineOpentimeEqualTo(Date value) {
      addCriterion("ONLINE_OPENTIME =", value, "onlineOpentime");
      return (Criteria) this;
    }

    public Criteria andOnlineOpentimeNotEqualTo(Date value) {
      addCriterion("ONLINE_OPENTIME <>", value, "onlineOpentime");
      return (Criteria) this;
    }

    public Criteria andOnlineOpentimeGreaterThan(Date value) {
      addCriterion("ONLINE_OPENTIME >", value, "onlineOpentime");
      return (Criteria) this;
    }

    public Criteria andOnlineOpentimeGreaterThanOrEqualTo(Date value) {
      addCriterion("ONLINE_OPENTIME >=", value, "onlineOpentime");
      return (Criteria) this;
    }

    public Criteria andOnlineOpentimeLessThan(Date value) {
      addCriterion("ONLINE_OPENTIME <", value, "onlineOpentime");
      return (Criteria) this;
    }

    public Criteria andOnlineOpentimeLessThanOrEqualTo(Date value) {
      addCriterion("ONLINE_OPENTIME <=", value, "onlineOpentime");
      return (Criteria) this;
    }

    public Criteria andOnlineOpentimeIn(List<Date> values) {
      addCriterion("ONLINE_OPENTIME in", values, "onlineOpentime");
      return (Criteria) this;
    }

    public Criteria andOnlineOpentimeNotIn(List<Date> values) {
      addCriterion("ONLINE_OPENTIME not in", values, "onlineOpentime");
      return (Criteria) this;
    }

    public Criteria andOnlineOpentimeBetween(Date value1, Date value2) {
      addCriterion("ONLINE_OPENTIME between", value1, value2, "onlineOpentime");
      return (Criteria) this;
    }

    public Criteria andOnlineOpentimeNotBetween(Date value1, Date value2) {
      addCriterion("ONLINE_OPENTIME not between", value1, value2, "onlineOpentime");
      return (Criteria) this;
    }

    public Criteria andGiveMoneyIsNull() {
      addCriterion("GIVE_MONEY is null");
      return (Criteria) this;
    }

    public Criteria andGiveMoneyIsNotNull() {
      addCriterion("GIVE_MONEY is not null");
      return (Criteria) this;
    }

    public Criteria andGiveMoneyEqualTo(Long value) {
      addCriterion("GIVE_MONEY =", value, "giveMoney");
      return (Criteria) this;
    }

    public Criteria andGiveMoneyNotEqualTo(Long value) {
      addCriterion("GIVE_MONEY <>", value, "giveMoney");
      return (Criteria) this;
    }

    public Criteria andGiveMoneyGreaterThan(Long value) {
      addCriterion("GIVE_MONEY >", value, "giveMoney");
      return (Criteria) this;
    }

    public Criteria andGiveMoneyGreaterThanOrEqualTo(Long value) {
      addCriterion("GIVE_MONEY >=", value, "giveMoney");
      return (Criteria) this;
    }

    public Criteria andGiveMoneyLessThan(Long value) {
      addCriterion("GIVE_MONEY <", value, "giveMoney");
      return (Criteria) this;
    }

    public Criteria andGiveMoneyLessThanOrEqualTo(Long value) {
      addCriterion("GIVE_MONEY <=", value, "giveMoney");
      return (Criteria) this;
    }

    public Criteria andGiveMoneyIn(List<Long> values) {
      addCriterion("GIVE_MONEY in", values, "giveMoney");
      return (Criteria) this;
    }

    public Criteria andGiveMoneyNotIn(List<Long> values) {
      addCriterion("GIVE_MONEY not in", values, "giveMoney");
      return (Criteria) this;
    }

    public Criteria andGiveMoneyBetween(Long value1, Long value2) {
      addCriterion("GIVE_MONEY between", value1, value2, "giveMoney");
      return (Criteria) this;
    }

    public Criteria andGiveMoneyNotBetween(Long value1, Long value2) {
      addCriterion("GIVE_MONEY not between", value1, value2, "giveMoney");
      return (Criteria) this;
    }

    public Criteria andAlipayUserIdIsNull() {
      addCriterion("ALIPAY_USER_ID is null");
      return (Criteria) this;
    }

    public Criteria andAlipayUserIdIsNotNull() {
      addCriterion("ALIPAY_USER_ID is not null");
      return (Criteria) this;
    }

    public Criteria andAlipayUserIdEqualTo(String value) {
      addCriterion("ALIPAY_USER_ID =", value, "alipayUserId");
      return (Criteria) this;
    }

    public Criteria andAlipayUserIdNotEqualTo(String value) {
      addCriterion("ALIPAY_USER_ID <>", value, "alipayUserId");
      return (Criteria) this;
    }

    public Criteria andAlipayUserIdGreaterThan(String value) {
      addCriterion("ALIPAY_USER_ID >", value, "alipayUserId");
      return (Criteria) this;
    }

    public Criteria andAlipayUserIdGreaterThanOrEqualTo(String value) {
      addCriterion("ALIPAY_USER_ID >=", value, "alipayUserId");
      return (Criteria) this;
    }

    public Criteria andAlipayUserIdLessThan(String value) {
      addCriterion("ALIPAY_USER_ID <", value, "alipayUserId");
      return (Criteria) this;
    }

    public Criteria andAlipayUserIdLessThanOrEqualTo(String value) {
      addCriterion("ALIPAY_USER_ID <=", value, "alipayUserId");
      return (Criteria) this;
    }

    public Criteria andAlipayUserIdLike(String value) {
      addCriterion("ALIPAY_USER_ID like", value, "alipayUserId");
      return (Criteria) this;
    }

    public Criteria andAlipayUserIdNotLike(String value) {
      addCriterion("ALIPAY_USER_ID not like", value, "alipayUserId");
      return (Criteria) this;
    }

    public Criteria andAlipayUserIdIn(List<String> values) {
      addCriterion("ALIPAY_USER_ID in", values, "alipayUserId");
      return (Criteria) this;
    }

    public Criteria andAlipayUserIdNotIn(List<String> values) {
      addCriterion("ALIPAY_USER_ID not in", values, "alipayUserId");
      return (Criteria) this;
    }

    public Criteria andAlipayUserIdBetween(String value1, String value2) {
      addCriterion("ALIPAY_USER_ID between", value1, value2, "alipayUserId");
      return (Criteria) this;
    }

    public Criteria andAlipayUserIdNotBetween(String value1, String value2) {
      addCriterion("ALIPAY_USER_ID not between", value1, value2, "alipayUserId");
      return (Criteria) this;
    }

    public Criteria andWxConsumeareaIdIsNull() {
      addCriterion("WX_CONSUMEAREA_ID is null");
      return (Criteria) this;
    }

    public Criteria andWxConsumeareaIdIsNotNull() {
      addCriterion("WX_CONSUMEAREA_ID is not null");
      return (Criteria) this;
    }

    public Criteria andWxConsumeareaIdEqualTo(Long value) {
      addCriterion("WX_CONSUMEAREA_ID =", value, "wxConsumeareaId");
      return (Criteria) this;
    }

    public Criteria andWxConsumeareaIdNotEqualTo(Long value) {
      addCriterion("WX_CONSUMEAREA_ID <>", value, "wxConsumeareaId");
      return (Criteria) this;
    }

    public Criteria andWxConsumeareaIdGreaterThan(Long value) {
      addCriterion("WX_CONSUMEAREA_ID >", value, "wxConsumeareaId");
      return (Criteria) this;
    }

    public Criteria andWxConsumeareaIdGreaterThanOrEqualTo(Long value) {
      addCriterion("WX_CONSUMEAREA_ID >=", value, "wxConsumeareaId");
      return (Criteria) this;
    }

    public Criteria andWxConsumeareaIdLessThan(Long value) {
      addCriterion("WX_CONSUMEAREA_ID <", value, "wxConsumeareaId");
      return (Criteria) this;
    }

    public Criteria andWxConsumeareaIdLessThanOrEqualTo(Long value) {
      addCriterion("WX_CONSUMEAREA_ID <=", value, "wxConsumeareaId");
      return (Criteria) this;
    }

    public Criteria andWxConsumeareaIdIn(List<Long> values) {
      addCriterion("WX_CONSUMEAREA_ID in", values, "wxConsumeareaId");
      return (Criteria) this;
    }

    public Criteria andWxConsumeareaIdNotIn(List<Long> values) {
      addCriterion("WX_CONSUMEAREA_ID not in", values, "wxConsumeareaId");
      return (Criteria) this;
    }

    public Criteria andWxConsumeareaIdBetween(Long value1, Long value2) {
      addCriterion("WX_CONSUMEAREA_ID between", value1, value2, "wxConsumeareaId");
      return (Criteria) this;
    }

    public Criteria andWxConsumeareaIdNotBetween(Long value1, Long value2) {
      addCriterion("WX_CONSUMEAREA_ID not between", value1, value2, "wxConsumeareaId");
      return (Criteria) this;
    }

    public Criteria andUnbindTimeIsNull() {
      addCriterion("UNBIND_TIME is null");
      return (Criteria) this;
    }

    public Criteria andUnbindTimeIsNotNull() {
      addCriterion("UNBIND_TIME is not null");
      return (Criteria) this;
    }

    public Criteria andUnbindTimeEqualTo(Date value) {
      addCriterion("UNBIND_TIME =", value, "unbindTime");
      return (Criteria) this;
    }

    public Criteria andUnbindTimeNotEqualTo(Date value) {
      addCriterion("UNBIND_TIME <>", value, "unbindTime");
      return (Criteria) this;
    }

    public Criteria andUnbindTimeGreaterThan(Date value) {
      addCriterion("UNBIND_TIME >", value, "unbindTime");
      return (Criteria) this;
    }

    public Criteria andUnbindTimeGreaterThanOrEqualTo(Date value) {
      addCriterion("UNBIND_TIME >=", value, "unbindTime");
      return (Criteria) this;
    }

    public Criteria andUnbindTimeLessThan(Date value) {
      addCriterion("UNBIND_TIME <", value, "unbindTime");
      return (Criteria) this;
    }

    public Criteria andUnbindTimeLessThanOrEqualTo(Date value) {
      addCriterion("UNBIND_TIME <=", value, "unbindTime");
      return (Criteria) this;
    }

    public Criteria andUnbindTimeIn(List<Date> values) {
      addCriterion("UNBIND_TIME in", values, "unbindTime");
      return (Criteria) this;
    }

    public Criteria andUnbindTimeNotIn(List<Date> values) {
      addCriterion("UNBIND_TIME not in", values, "unbindTime");
      return (Criteria) this;
    }

    public Criteria andUnbindTimeBetween(Date value1, Date value2) {
      addCriterion("UNBIND_TIME between", value1, value2, "unbindTime");
      return (Criteria) this;
    }

    public Criteria andUnbindTimeNotBetween(Date value1, Date value2) {
      addCriterion("UNBIND_TIME not between", value1, value2, "unbindTime");
      return (Criteria) this;
    }

    public Criteria andIssendcouponIsNull() {
      addCriterion("ISSENDCOUPON is null");
      return (Criteria) this;
    }

    public Criteria andIssendcouponIsNotNull() {
      addCriterion("ISSENDCOUPON is not null");
      return (Criteria) this;
    }

    public Criteria andIssendcouponEqualTo(String value) {
      addCriterion("ISSENDCOUPON =", value, "issendcoupon");
      return (Criteria) this;
    }

    public Criteria andIssendcouponNotEqualTo(String value) {
      addCriterion("ISSENDCOUPON <>", value, "issendcoupon");
      return (Criteria) this;
    }

    public Criteria andIssendcouponGreaterThan(String value) {
      addCriterion("ISSENDCOUPON >", value, "issendcoupon");
      return (Criteria) this;
    }

    public Criteria andIssendcouponGreaterThanOrEqualTo(String value) {
      addCriterion("ISSENDCOUPON >=", value, "issendcoupon");
      return (Criteria) this;
    }

    public Criteria andIssendcouponLessThan(String value) {
      addCriterion("ISSENDCOUPON <", value, "issendcoupon");
      return (Criteria) this;
    }

    public Criteria andIssendcouponLessThanOrEqualTo(String value) {
      addCriterion("ISSENDCOUPON <=", value, "issendcoupon");
      return (Criteria) this;
    }

    public Criteria andIssendcouponLike(String value) {
      addCriterion("ISSENDCOUPON like", value, "issendcoupon");
      return (Criteria) this;
    }

    public Criteria andIssendcouponNotLike(String value) {
      addCriterion("ISSENDCOUPON not like", value, "issendcoupon");
      return (Criteria) this;
    }

    public Criteria andIssendcouponIn(List<String> values) {
      addCriterion("ISSENDCOUPON in", values, "issendcoupon");
      return (Criteria) this;
    }

    public Criteria andIssendcouponNotIn(List<String> values) {
      addCriterion("ISSENDCOUPON not in", values, "issendcoupon");
      return (Criteria) this;
    }

    public Criteria andIssendcouponBetween(String value1, String value2) {
      addCriterion("ISSENDCOUPON between", value1, value2, "issendcoupon");
      return (Criteria) this;
    }

    public Criteria andIssendcouponNotBetween(String value1, String value2) {
      addCriterion("ISSENDCOUPON not between", value1, value2, "issendcoupon");
      return (Criteria) this;
    }

    public Criteria andIssendintegralIsNull() {
      addCriterion("ISSENDINTEGRAL is null");
      return (Criteria) this;
    }

    public Criteria andIssendintegralIsNotNull() {
      addCriterion("ISSENDINTEGRAL is not null");
      return (Criteria) this;
    }

    public Criteria andIssendintegralEqualTo(String value) {
      addCriterion("ISSENDINTEGRAL =", value, "issendintegral");
      return (Criteria) this;
    }

    public Criteria andIssendintegralNotEqualTo(String value) {
      addCriterion("ISSENDINTEGRAL <>", value, "issendintegral");
      return (Criteria) this;
    }

    public Criteria andIssendintegralGreaterThan(String value) {
      addCriterion("ISSENDINTEGRAL >", value, "issendintegral");
      return (Criteria) this;
    }

    public Criteria andIssendintegralGreaterThanOrEqualTo(String value) {
      addCriterion("ISSENDINTEGRAL >=", value, "issendintegral");
      return (Criteria) this;
    }

    public Criteria andIssendintegralLessThan(String value) {
      addCriterion("ISSENDINTEGRAL <", value, "issendintegral");
      return (Criteria) this;
    }

    public Criteria andIssendintegralLessThanOrEqualTo(String value) {
      addCriterion("ISSENDINTEGRAL <=", value, "issendintegral");
      return (Criteria) this;
    }

    public Criteria andIssendintegralLike(String value) {
      addCriterion("ISSENDINTEGRAL like", value, "issendintegral");
      return (Criteria) this;
    }

    public Criteria andIssendintegralNotLike(String value) {
      addCriterion("ISSENDINTEGRAL not like", value, "issendintegral");
      return (Criteria) this;
    }

    public Criteria andIssendintegralIn(List<String> values) {
      addCriterion("ISSENDINTEGRAL in", values, "issendintegral");
      return (Criteria) this;
    }

    public Criteria andIssendintegralNotIn(List<String> values) {
      addCriterion("ISSENDINTEGRAL not in", values, "issendintegral");
      return (Criteria) this;
    }

    public Criteria andIssendintegralBetween(String value1, String value2) {
      addCriterion("ISSENDINTEGRAL between", value1, value2, "issendintegral");
      return (Criteria) this;
    }

    public Criteria andIssendintegralNotBetween(String value1, String value2) {
      addCriterion("ISSENDINTEGRAL not between", value1, value2, "issendintegral");
      return (Criteria) this;
    }

    public Criteria andSendintegralTimeIsNull() {
      addCriterion("SENDINTEGRAL_TIME is null");
      return (Criteria) this;
    }

    public Criteria andSendintegralTimeIsNotNull() {
      addCriterion("SENDINTEGRAL_TIME is not null");
      return (Criteria) this;
    }

    public Criteria andSendintegralTimeEqualTo(Date value) {
      addCriterion("SENDINTEGRAL_TIME =", value, "sendintegralTime");
      return (Criteria) this;
    }

    public Criteria andSendintegralTimeNotEqualTo(Date value) {
      addCriterion("SENDINTEGRAL_TIME <>", value, "sendintegralTime");
      return (Criteria) this;
    }

    public Criteria andSendintegralTimeGreaterThan(Date value) {
      addCriterion("SENDINTEGRAL_TIME >", value, "sendintegralTime");
      return (Criteria) this;
    }

    public Criteria andSendintegralTimeGreaterThanOrEqualTo(Date value) {
      addCriterion("SENDINTEGRAL_TIME >=", value, "sendintegralTime");
      return (Criteria) this;
    }

    public Criteria andSendintegralTimeLessThan(Date value) {
      addCriterion("SENDINTEGRAL_TIME <", value, "sendintegralTime");
      return (Criteria) this;
    }

    public Criteria andSendintegralTimeLessThanOrEqualTo(Date value) {
      addCriterion("SENDINTEGRAL_TIME <=", value, "sendintegralTime");
      return (Criteria) this;
    }

    public Criteria andSendintegralTimeIn(List<Date> values) {
      addCriterion("SENDINTEGRAL_TIME in", values, "sendintegralTime");
      return (Criteria) this;
    }

    public Criteria andSendintegralTimeNotIn(List<Date> values) {
      addCriterion("SENDINTEGRAL_TIME not in", values, "sendintegralTime");
      return (Criteria) this;
    }

    public Criteria andSendintegralTimeBetween(Date value1, Date value2) {
      addCriterion("SENDINTEGRAL_TIME between", value1, value2, "sendintegralTime");
      return (Criteria) this;
    }

    public Criteria andSendintegralTimeNotBetween(Date value1, Date value2) {
      addCriterion("SENDINTEGRAL_TIME not between", value1, value2, "sendintegralTime");
      return (Criteria) this;
    }

    public Criteria andSendcouponTimeIsNull() {
      addCriterion("SENDCOUPON_TIME is null");
      return (Criteria) this;
    }

    public Criteria andSendcouponTimeIsNotNull() {
      addCriterion("SENDCOUPON_TIME is not null");
      return (Criteria) this;
    }

    public Criteria andSendcouponTimeEqualTo(Date value) {
      addCriterion("SENDCOUPON_TIME =", value, "sendcouponTime");
      return (Criteria) this;
    }

    public Criteria andSendcouponTimeNotEqualTo(Date value) {
      addCriterion("SENDCOUPON_TIME <>", value, "sendcouponTime");
      return (Criteria) this;
    }

    public Criteria andSendcouponTimeGreaterThan(Date value) {
      addCriterion("SENDCOUPON_TIME >", value, "sendcouponTime");
      return (Criteria) this;
    }

    public Criteria andSendcouponTimeGreaterThanOrEqualTo(Date value) {
      addCriterion("SENDCOUPON_TIME >=", value, "sendcouponTime");
      return (Criteria) this;
    }

    public Criteria andSendcouponTimeLessThan(Date value) {
      addCriterion("SENDCOUPON_TIME <", value, "sendcouponTime");
      return (Criteria) this;
    }

    public Criteria andSendcouponTimeLessThanOrEqualTo(Date value) {
      addCriterion("SENDCOUPON_TIME <=", value, "sendcouponTime");
      return (Criteria) this;
    }

    public Criteria andSendcouponTimeIn(List<Date> values) {
      addCriterion("SENDCOUPON_TIME in", values, "sendcouponTime");
      return (Criteria) this;
    }

    public Criteria andSendcouponTimeNotIn(List<Date> values) {
      addCriterion("SENDCOUPON_TIME not in", values, "sendcouponTime");
      return (Criteria) this;
    }

    public Criteria andSendcouponTimeBetween(Date value1, Date value2) {
      addCriterion("SENDCOUPON_TIME between", value1, value2, "sendcouponTime");
      return (Criteria) this;
    }

    public Criteria andSendcouponTimeNotBetween(Date value1, Date value2) {
      addCriterion("SENDCOUPON_TIME not between", value1, value2, "sendcouponTime");
      return (Criteria) this;
    }

    public Criteria andWxDealersIdIsNull() {
      addCriterion("WX_DEALERS_ID is null");
      return (Criteria) this;
    }

    public Criteria andWxDealersIdIsNotNull() {
      addCriterion("WX_DEALERS_ID is not null");
      return (Criteria) this;
    }

    public Criteria andWxDealersIdEqualTo(Long value) {
      addCriterion("WX_DEALERS_ID =", value, "wxDealersId");
      return (Criteria) this;
    }

    public Criteria andWxDealersIdNotEqualTo(Long value) {
      addCriterion("WX_DEALERS_ID <>", value, "wxDealersId");
      return (Criteria) this;
    }

    public Criteria andWxDealersIdGreaterThan(Long value) {
      addCriterion("WX_DEALERS_ID >", value, "wxDealersId");
      return (Criteria) this;
    }

    public Criteria andWxDealersIdGreaterThanOrEqualTo(Long value) {
      addCriterion("WX_DEALERS_ID >=", value, "wxDealersId");
      return (Criteria) this;
    }

    public Criteria andWxDealersIdLessThan(Long value) {
      addCriterion("WX_DEALERS_ID <", value, "wxDealersId");
      return (Criteria) this;
    }

    public Criteria andWxDealersIdLessThanOrEqualTo(Long value) {
      addCriterion("WX_DEALERS_ID <=", value, "wxDealersId");
      return (Criteria) this;
    }

    public Criteria andWxDealersIdIn(List<Long> values) {
      addCriterion("WX_DEALERS_ID in", values, "wxDealersId");
      return (Criteria) this;
    }

    public Criteria andWxDealersIdNotIn(List<Long> values) {
      addCriterion("WX_DEALERS_ID not in", values, "wxDealersId");
      return (Criteria) this;
    }

    public Criteria andWxDealersIdBetween(Long value1, Long value2) {
      addCriterion("WX_DEALERS_ID between", value1, value2, "wxDealersId");
      return (Criteria) this;
    }

    public Criteria andWxDealersIdNotBetween(Long value1, Long value2) {
      addCriterion("WX_DEALERS_ID not between", value1, value2, "wxDealersId");
      return (Criteria) this;
    }

    public Criteria andIscrmsendcouponIsNull() {
      addCriterion("ISCRMSENDCOUPON is null");
      return (Criteria) this;
    }

    public Criteria andIscrmsendcouponIsNotNull() {
      addCriterion("ISCRMSENDCOUPON is not null");
      return (Criteria) this;
    }

    public Criteria andIscrmsendcouponEqualTo(String value) {
      addCriterion("ISCRMSENDCOUPON =", value, "iscrmsendcoupon");
      return (Criteria) this;
    }

    public Criteria andIscrmsendcouponNotEqualTo(String value) {
      addCriterion("ISCRMSENDCOUPON <>", value, "iscrmsendcoupon");
      return (Criteria) this;
    }

    public Criteria andIscrmsendcouponGreaterThan(String value) {
      addCriterion("ISCRMSENDCOUPON >", value, "iscrmsendcoupon");
      return (Criteria) this;
    }

    public Criteria andIscrmsendcouponGreaterThanOrEqualTo(String value) {
      addCriterion("ISCRMSENDCOUPON >=", value, "iscrmsendcoupon");
      return (Criteria) this;
    }

    public Criteria andIscrmsendcouponLessThan(String value) {
      addCriterion("ISCRMSENDCOUPON <", value, "iscrmsendcoupon");
      return (Criteria) this;
    }

    public Criteria andIscrmsendcouponLessThanOrEqualTo(String value) {
      addCriterion("ISCRMSENDCOUPON <=", value, "iscrmsendcoupon");
      return (Criteria) this;
    }

    public Criteria andIscrmsendcouponLike(String value) {
      addCriterion("ISCRMSENDCOUPON like", value, "iscrmsendcoupon");
      return (Criteria) this;
    }

    public Criteria andIscrmsendcouponNotLike(String value) {
      addCriterion("ISCRMSENDCOUPON not like", value, "iscrmsendcoupon");
      return (Criteria) this;
    }

    public Criteria andIscrmsendcouponIn(List<String> values) {
      addCriterion("ISCRMSENDCOUPON in", values, "iscrmsendcoupon");
      return (Criteria) this;
    }

    public Criteria andIscrmsendcouponNotIn(List<String> values) {
      addCriterion("ISCRMSENDCOUPON not in", values, "iscrmsendcoupon");
      return (Criteria) this;
    }

    public Criteria andIscrmsendcouponBetween(String value1, String value2) {
      addCriterion("ISCRMSENDCOUPON between", value1, value2, "iscrmsendcoupon");
      return (Criteria) this;
    }

    public Criteria andIscrmsendcouponNotBetween(String value1, String value2) {
      addCriterion("ISCRMSENDCOUPON not between", value1, value2, "iscrmsendcoupon");
      return (Criteria) this;
    }

    public Criteria andShareOpenIdIsNull() {
      addCriterion("SHARE_OPEN_ID is null");
      return (Criteria) this;
    }

    public Criteria andShareOpenIdIsNotNull() {
      addCriterion("SHARE_OPEN_ID is not null");
      return (Criteria) this;
    }

    public Criteria andShareOpenIdEqualTo(String value) {
      addCriterion("SHARE_OPEN_ID =", value, "shareOpenId");
      return (Criteria) this;
    }

    public Criteria andShareOpenIdNotEqualTo(String value) {
      addCriterion("SHARE_OPEN_ID <>", value, "shareOpenId");
      return (Criteria) this;
    }

    public Criteria andShareOpenIdGreaterThan(String value) {
      addCriterion("SHARE_OPEN_ID >", value, "shareOpenId");
      return (Criteria) this;
    }

    public Criteria andShareOpenIdGreaterThanOrEqualTo(String value) {
      addCriterion("SHARE_OPEN_ID >=", value, "shareOpenId");
      return (Criteria) this;
    }

    public Criteria andShareOpenIdLessThan(String value) {
      addCriterion("SHARE_OPEN_ID <", value, "shareOpenId");
      return (Criteria) this;
    }

    public Criteria andShareOpenIdLessThanOrEqualTo(String value) {
      addCriterion("SHARE_OPEN_ID <=", value, "shareOpenId");
      return (Criteria) this;
    }

    public Criteria andShareOpenIdLike(String value) {
      addCriterion("SHARE_OPEN_ID like", value, "shareOpenId");
      return (Criteria) this;
    }

    public Criteria andShareOpenIdNotLike(String value) {
      addCriterion("SHARE_OPEN_ID not like", value, "shareOpenId");
      return (Criteria) this;
    }

    public Criteria andShareOpenIdIn(List<String> values) {
      addCriterion("SHARE_OPEN_ID in", values, "shareOpenId");
      return (Criteria) this;
    }

    public Criteria andShareOpenIdNotIn(List<String> values) {
      addCriterion("SHARE_OPEN_ID not in", values, "shareOpenId");
      return (Criteria) this;
    }

    public Criteria andShareOpenIdBetween(String value1, String value2) {
      addCriterion("SHARE_OPEN_ID between", value1, value2, "shareOpenId");
      return (Criteria) this;
    }

    public Criteria andShareOpenIdNotBetween(String value1, String value2) {
      addCriterion("SHARE_OPEN_ID not between", value1, value2, "shareOpenId");
      return (Criteria) this;
    }

    public Criteria andWxCrossBrandIdIsNull() {
      addCriterion("WX_CROSS_BRAND_ID is null");
      return (Criteria) this;
    }

    public Criteria andWxCrossBrandIdIsNotNull() {
      addCriterion("WX_CROSS_BRAND_ID is not null");
      return (Criteria) this;
    }

    public Criteria andWxCrossBrandIdEqualTo(Long value) {
      addCriterion("WX_CROSS_BRAND_ID =", value, "wxCrossBrandId");
      return (Criteria) this;
    }

    public Criteria andWxCrossBrandIdNotEqualTo(Long value) {
      addCriterion("WX_CROSS_BRAND_ID <>", value, "wxCrossBrandId");
      return (Criteria) this;
    }

    public Criteria andWxCrossBrandIdGreaterThan(Long value) {
      addCriterion("WX_CROSS_BRAND_ID >", value, "wxCrossBrandId");
      return (Criteria) this;
    }

    public Criteria andWxCrossBrandIdGreaterThanOrEqualTo(Long value) {
      addCriterion("WX_CROSS_BRAND_ID >=", value, "wxCrossBrandId");
      return (Criteria) this;
    }

    public Criteria andWxCrossBrandIdLessThan(Long value) {
      addCriterion("WX_CROSS_BRAND_ID <", value, "wxCrossBrandId");
      return (Criteria) this;
    }

    public Criteria andWxCrossBrandIdLessThanOrEqualTo(Long value) {
      addCriterion("WX_CROSS_BRAND_ID <=", value, "wxCrossBrandId");
      return (Criteria) this;
    }

    public Criteria andWxCrossBrandIdIn(List<Long> values) {
      addCriterion("WX_CROSS_BRAND_ID in", values, "wxCrossBrandId");
      return (Criteria) this;
    }

    public Criteria andWxCrossBrandIdNotIn(List<Long> values) {
      addCriterion("WX_CROSS_BRAND_ID not in", values, "wxCrossBrandId");
      return (Criteria) this;
    }

    public Criteria andWxCrossBrandIdBetween(Long value1, Long value2) {
      addCriterion("WX_CROSS_BRAND_ID between", value1, value2, "wxCrossBrandId");
      return (Criteria) this;
    }

    public Criteria andWxCrossBrandIdNotBetween(Long value1, Long value2) {
      addCriterion("WX_CROSS_BRAND_ID not between", value1, value2, "wxCrossBrandId");
      return (Criteria) this;
    }

    public Criteria andWxCrossBrandItemIdIsNull() {
      addCriterion("WX_CROSS_BRAND_ITEM_ID is null");
      return (Criteria) this;
    }

    public Criteria andWxCrossBrandItemIdIsNotNull() {
      addCriterion("WX_CROSS_BRAND_ITEM_ID is not null");
      return (Criteria) this;
    }

    public Criteria andWxCrossBrandItemIdEqualTo(Long value) {
      addCriterion("WX_CROSS_BRAND_ITEM_ID =", value, "wxCrossBrandItemId");
      return (Criteria) this;
    }

    public Criteria andWxCrossBrandItemIdNotEqualTo(Long value) {
      addCriterion("WX_CROSS_BRAND_ITEM_ID <>", value, "wxCrossBrandItemId");
      return (Criteria) this;
    }

    public Criteria andWxCrossBrandItemIdGreaterThan(Long value) {
      addCriterion("WX_CROSS_BRAND_ITEM_ID >", value, "wxCrossBrandItemId");
      return (Criteria) this;
    }

    public Criteria andWxCrossBrandItemIdGreaterThanOrEqualTo(Long value) {
      addCriterion("WX_CROSS_BRAND_ITEM_ID >=", value, "wxCrossBrandItemId");
      return (Criteria) this;
    }

    public Criteria andWxCrossBrandItemIdLessThan(Long value) {
      addCriterion("WX_CROSS_BRAND_ITEM_ID <", value, "wxCrossBrandItemId");
      return (Criteria) this;
    }

    public Criteria andWxCrossBrandItemIdLessThanOrEqualTo(Long value) {
      addCriterion("WX_CROSS_BRAND_ITEM_ID <=", value, "wxCrossBrandItemId");
      return (Criteria) this;
    }

    public Criteria andWxCrossBrandItemIdIn(List<Long> values) {
      addCriterion("WX_CROSS_BRAND_ITEM_ID in", values, "wxCrossBrandItemId");
      return (Criteria) this;
    }

    public Criteria andWxCrossBrandItemIdNotIn(List<Long> values) {
      addCriterion("WX_CROSS_BRAND_ITEM_ID not in", values, "wxCrossBrandItemId");
      return (Criteria) this;
    }

    public Criteria andWxCrossBrandItemIdBetween(Long value1, Long value2) {
      addCriterion("WX_CROSS_BRAND_ITEM_ID between", value1, value2, "wxCrossBrandItemId");
      return (Criteria) this;
    }

    public Criteria andWxCrossBrandItemIdNotBetween(Long value1, Long value2) {
      addCriterion("WX_CROSS_BRAND_ITEM_ID not between", value1, value2, "wxCrossBrandItemId");
      return (Criteria) this;
    }

    public Criteria andCrossIdIsNull() {
      addCriterion("CROSS_ID is null");
      return (Criteria) this;
    }

    public Criteria andCrossIdIsNotNull() {
      addCriterion("CROSS_ID is not null");
      return (Criteria) this;
    }

    public Criteria andCrossIdEqualTo(Long value) {
      addCriterion("CROSS_ID =", value, "crossId");
      return (Criteria) this;
    }

    public Criteria andCrossIdNotEqualTo(Long value) {
      addCriterion("CROSS_ID <>", value, "crossId");
      return (Criteria) this;
    }

    public Criteria andCrossIdGreaterThan(Long value) {
      addCriterion("CROSS_ID >", value, "crossId");
      return (Criteria) this;
    }

    public Criteria andCrossIdGreaterThanOrEqualTo(Long value) {
      addCriterion("CROSS_ID >=", value, "crossId");
      return (Criteria) this;
    }

    public Criteria andCrossIdLessThan(Long value) {
      addCriterion("CROSS_ID <", value, "crossId");
      return (Criteria) this;
    }

    public Criteria andCrossIdLessThanOrEqualTo(Long value) {
      addCriterion("CROSS_ID <=", value, "crossId");
      return (Criteria) this;
    }

    public Criteria andCrossIdIn(List<Long> values) {
      addCriterion("CROSS_ID in", values, "crossId");
      return (Criteria) this;
    }

    public Criteria andCrossIdNotIn(List<Long> values) {
      addCriterion("CROSS_ID not in", values, "crossId");
      return (Criteria) this;
    }

    public Criteria andCrossIdBetween(Long value1, Long value2) {
      addCriterion("CROSS_ID between", value1, value2, "crossId");
      return (Criteria) this;
    }

    public Criteria andCrossIdNotBetween(Long value1, Long value2) {
      addCriterion("CROSS_ID not between", value1, value2, "crossId");
      return (Criteria) this;
    }

    public Criteria andIsCrossIsNull() {
      addCriterion("IS_CROSS is null");
      return (Criteria) this;
    }

    public Criteria andIsCrossIsNotNull() {
      addCriterion("IS_CROSS is not null");
      return (Criteria) this;
    }

    public Criteria andIsCrossEqualTo(String value) {
      addCriterion("IS_CROSS =", value, "isCross");
      return (Criteria) this;
    }

    public Criteria andIsCrossNotEqualTo(String value) {
      addCriterion("IS_CROSS <>", value, "isCross");
      return (Criteria) this;
    }

    public Criteria andIsCrossGreaterThan(String value) {
      addCriterion("IS_CROSS >", value, "isCross");
      return (Criteria) this;
    }

    public Criteria andIsCrossGreaterThanOrEqualTo(String value) {
      addCriterion("IS_CROSS >=", value, "isCross");
      return (Criteria) this;
    }

    public Criteria andIsCrossLessThan(String value) {
      addCriterion("IS_CROSS <", value, "isCross");
      return (Criteria) this;
    }

    public Criteria andIsCrossLessThanOrEqualTo(String value) {
      addCriterion("IS_CROSS <=", value, "isCross");
      return (Criteria) this;
    }

    public Criteria andIsCrossLike(String value) {
      addCriterion("IS_CROSS like", value, "isCross");
      return (Criteria) this;
    }

    public Criteria andIsCrossNotLike(String value) {
      addCriterion("IS_CROSS not like", value, "isCross");
      return (Criteria) this;
    }

    public Criteria andIsCrossIn(List<String> values) {
      addCriterion("IS_CROSS in", values, "isCross");
      return (Criteria) this;
    }

    public Criteria andIsCrossNotIn(List<String> values) {
      addCriterion("IS_CROSS not in", values, "isCross");
      return (Criteria) this;
    }

    public Criteria andIsCrossBetween(String value1, String value2) {
      addCriterion("IS_CROSS between", value1, value2, "isCross");
      return (Criteria) this;
    }

    public Criteria andIsCrossNotBetween(String value1, String value2) {
      addCriterion("IS_CROSS not between", value1, value2, "isCross");
      return (Criteria) this;
    }

    public Criteria andAreaCodeIsNull() {
      addCriterion("AREA_CODE is null");
      return (Criteria) this;
    }

    public Criteria andAreaCodeIsNotNull() {
      addCriterion("AREA_CODE is not null");
      return (Criteria) this;
    }

    public Criteria andAreaCodeEqualTo(String value) {
      addCriterion("AREA_CODE =", value, "areaCode");
      return (Criteria) this;
    }

    public Criteria andAreaCodeNotEqualTo(String value) {
      addCriterion("AREA_CODE <>", value, "areaCode");
      return (Criteria) this;
    }

    public Criteria andAreaCodeGreaterThan(String value) {
      addCriterion("AREA_CODE >", value, "areaCode");
      return (Criteria) this;
    }

    public Criteria andAreaCodeGreaterThanOrEqualTo(String value) {
      addCriterion("AREA_CODE >=", value, "areaCode");
      return (Criteria) this;
    }

    public Criteria andAreaCodeLessThan(String value) {
      addCriterion("AREA_CODE <", value, "areaCode");
      return (Criteria) this;
    }

    public Criteria andAreaCodeLessThanOrEqualTo(String value) {
      addCriterion("AREA_CODE <=", value, "areaCode");
      return (Criteria) this;
    }

    public Criteria andAreaCodeLike(String value) {
      addCriterion("AREA_CODE like", value, "areaCode");
      return (Criteria) this;
    }

    public Criteria andAreaCodeNotLike(String value) {
      addCriterion("AREA_CODE not like", value, "areaCode");
      return (Criteria) this;
    }

    public Criteria andAreaCodeIn(List<String> values) {
      addCriterion("AREA_CODE in", values, "areaCode");
      return (Criteria) this;
    }

    public Criteria andAreaCodeNotIn(List<String> values) {
      addCriterion("AREA_CODE not in", values, "areaCode");
      return (Criteria) this;
    }

    public Criteria andAreaCodeBetween(String value1, String value2) {
      addCriterion("AREA_CODE between", value1, value2, "areaCode");
      return (Criteria) this;
    }

    public Criteria andAreaCodeNotBetween(String value1, String value2) {
      addCriterion("AREA_CODE not between", value1, value2, "areaCode");
      return (Criteria) this;
    }

    public Criteria andWxHeadimgIsNull() {
      addCriterion("WX_HEADIMG is null");
      return (Criteria) this;
    }

    public Criteria andWxHeadimgIsNotNull() {
      addCriterion("WX_HEADIMG is not null");
      return (Criteria) this;
    }

    public Criteria andWxHeadimgEqualTo(String value) {
      addCriterion("WX_HEADIMG =", value, "wxHeadimg");
      return (Criteria) this;
    }

    public Criteria andWxHeadimgNotEqualTo(String value) {
      addCriterion("WX_HEADIMG <>", value, "wxHeadimg");
      return (Criteria) this;
    }

    public Criteria andWxHeadimgGreaterThan(String value) {
      addCriterion("WX_HEADIMG >", value, "wxHeadimg");
      return (Criteria) this;
    }

    public Criteria andWxHeadimgGreaterThanOrEqualTo(String value) {
      addCriterion("WX_HEADIMG >=", value, "wxHeadimg");
      return (Criteria) this;
    }

    public Criteria andWxHeadimgLessThan(String value) {
      addCriterion("WX_HEADIMG <", value, "wxHeadimg");
      return (Criteria) this;
    }

    public Criteria andWxHeadimgLessThanOrEqualTo(String value) {
      addCriterion("WX_HEADIMG <=", value, "wxHeadimg");
      return (Criteria) this;
    }

    public Criteria andWxHeadimgLike(String value) {
      addCriterion("WX_HEADIMG like", value, "wxHeadimg");
      return (Criteria) this;
    }

    public Criteria andWxHeadimgNotLike(String value) {
      addCriterion("WX_HEADIMG not like", value, "wxHeadimg");
      return (Criteria) this;
    }

    public Criteria andWxHeadimgIn(List<String> values) {
      addCriterion("WX_HEADIMG in", values, "wxHeadimg");
      return (Criteria) this;
    }

    public Criteria andWxHeadimgNotIn(List<String> values) {
      addCriterion("WX_HEADIMG not in", values, "wxHeadimg");
      return (Criteria) this;
    }

    public Criteria andWxHeadimgBetween(String value1, String value2) {
      addCriterion("WX_HEADIMG between", value1, value2, "wxHeadimg");
      return (Criteria) this;
    }

    public Criteria andWxHeadimgNotBetween(String value1, String value2) {
      addCriterion("WX_HEADIMG not between", value1, value2, "wxHeadimg");
      return (Criteria) this;
    }

    public Criteria andMixMobileIsNull() {
      addCriterion("MIX_MOBILE is null");
      return (Criteria) this;
    }

    public Criteria andMixMobileIsNotNull() {
      addCriterion("MIX_MOBILE is not null");
      return (Criteria) this;
    }

    public Criteria andMixMobileEqualTo(String value) {
      addCriterion("MIX_MOBILE =", value, "mixMobile");
      return (Criteria) this;
    }

    public Criteria andMixMobileNotEqualTo(String value) {
      addCriterion("MIX_MOBILE <>", value, "mixMobile");
      return (Criteria) this;
    }

    public Criteria andMixMobileGreaterThan(String value) {
      addCriterion("MIX_MOBILE >", value, "mixMobile");
      return (Criteria) this;
    }

    public Criteria andMixMobileGreaterThanOrEqualTo(String value) {
      addCriterion("MIX_MOBILE >=", value, "mixMobile");
      return (Criteria) this;
    }

    public Criteria andMixMobileLessThan(String value) {
      addCriterion("MIX_MOBILE <", value, "mixMobile");
      return (Criteria) this;
    }

    public Criteria andMixMobileLessThanOrEqualTo(String value) {
      addCriterion("MIX_MOBILE <=", value, "mixMobile");
      return (Criteria) this;
    }

    public Criteria andMixMobileLike(String value) {
      addCriterion("MIX_MOBILE like", value, "mixMobile");
      return (Criteria) this;
    }

    public Criteria andMixMobileNotLike(String value) {
      addCriterion("MIX_MOBILE not like", value, "mixMobile");
      return (Criteria) this;
    }

    public Criteria andMixMobileIn(List<String> values) {
      addCriterion("MIX_MOBILE in", values, "mixMobile");
      return (Criteria) this;
    }

    public Criteria andMixMobileNotIn(List<String> values) {
      addCriterion("MIX_MOBILE not in", values, "mixMobile");
      return (Criteria) this;
    }

    public Criteria andMixMobileBetween(String value1, String value2) {
      addCriterion("MIX_MOBILE between", value1, value2, "mixMobile");
      return (Criteria) this;
    }

    public Criteria andMixMobileNotBetween(String value1, String value2) {
      addCriterion("MIX_MOBILE not between", value1, value2, "mixMobile");
      return (Criteria) this;
    }

    public Criteria andTaobaoNickIsNull() {
      addCriterion("TAOBAO_NICK is null");
      return (Criteria) this;
    }

    public Criteria andTaobaoNickIsNotNull() {
      addCriterion("TAOBAO_NICK is not null");
      return (Criteria) this;
    }

    public Criteria andTaobaoNickEqualTo(String value) {
      addCriterion("TAOBAO_NICK =", value, "taobaoNick");
      return (Criteria) this;
    }

    public Criteria andTaobaoNickNotEqualTo(String value) {
      addCriterion("TAOBAO_NICK <>", value, "taobaoNick");
      return (Criteria) this;
    }

    public Criteria andTaobaoNickGreaterThan(String value) {
      addCriterion("TAOBAO_NICK >", value, "taobaoNick");
      return (Criteria) this;
    }

    public Criteria andTaobaoNickGreaterThanOrEqualTo(String value) {
      addCriterion("TAOBAO_NICK >=", value, "taobaoNick");
      return (Criteria) this;
    }

    public Criteria andTaobaoNickLessThan(String value) {
      addCriterion("TAOBAO_NICK <", value, "taobaoNick");
      return (Criteria) this;
    }

    public Criteria andTaobaoNickLessThanOrEqualTo(String value) {
      addCriterion("TAOBAO_NICK <=", value, "taobaoNick");
      return (Criteria) this;
    }

    public Criteria andTaobaoNickLike(String value) {
      addCriterion("TAOBAO_NICK like", value, "taobaoNick");
      return (Criteria) this;
    }

    public Criteria andTaobaoNickNotLike(String value) {
      addCriterion("TAOBAO_NICK not like", value, "taobaoNick");
      return (Criteria) this;
    }

    public Criteria andTaobaoNickIn(List<String> values) {
      addCriterion("TAOBAO_NICK in", values, "taobaoNick");
      return (Criteria) this;
    }

    public Criteria andTaobaoNickNotIn(List<String> values) {
      addCriterion("TAOBAO_NICK not in", values, "taobaoNick");
      return (Criteria) this;
    }

    public Criteria andTaobaoNickBetween(String value1, String value2) {
      addCriterion("TAOBAO_NICK between", value1, value2, "taobaoNick");
      return (Criteria) this;
    }

    public Criteria andTaobaoNickNotBetween(String value1, String value2) {
      addCriterion("TAOBAO_NICK not between", value1, value2, "taobaoNick");
      return (Criteria) this;
    }

    public Criteria andOuterStrIsNull() {
      addCriterion("OUTER_STR is null");
      return (Criteria) this;
    }

    public Criteria andOuterStrIsNotNull() {
      addCriterion("OUTER_STR is not null");
      return (Criteria) this;
    }

    public Criteria andOuterStrEqualTo(String value) {
      addCriterion("OUTER_STR =", value, "outerStr");
      return (Criteria) this;
    }

    public Criteria andOuterStrNotEqualTo(String value) {
      addCriterion("OUTER_STR <>", value, "outerStr");
      return (Criteria) this;
    }

    public Criteria andOuterStrGreaterThan(String value) {
      addCriterion("OUTER_STR >", value, "outerStr");
      return (Criteria) this;
    }

    public Criteria andOuterStrGreaterThanOrEqualTo(String value) {
      addCriterion("OUTER_STR >=", value, "outerStr");
      return (Criteria) this;
    }

    public Criteria andOuterStrLessThan(String value) {
      addCriterion("OUTER_STR <", value, "outerStr");
      return (Criteria) this;
    }

    public Criteria andOuterStrLessThanOrEqualTo(String value) {
      addCriterion("OUTER_STR <=", value, "outerStr");
      return (Criteria) this;
    }

    public Criteria andOuterStrLike(String value) {
      addCriterion("OUTER_STR like", value, "outerStr");
      return (Criteria) this;
    }

    public Criteria andOuterStrNotLike(String value) {
      addCriterion("OUTER_STR not like", value, "outerStr");
      return (Criteria) this;
    }

    public Criteria andOuterStrIn(List<String> values) {
      addCriterion("OUTER_STR in", values, "outerStr");
      return (Criteria) this;
    }

    public Criteria andOuterStrNotIn(List<String> values) {
      addCriterion("OUTER_STR not in", values, "outerStr");
      return (Criteria) this;
    }

    public Criteria andOuterStrBetween(String value1, String value2) {
      addCriterion("OUTER_STR between", value1, value2, "outerStr");
      return (Criteria) this;
    }

    public Criteria andOuterStrNotBetween(String value1, String value2) {
      addCriterion("OUTER_STR not between", value1, value2, "outerStr");
      return (Criteria) this;
    }

    public Criteria andWxOuterStrIsNull() {
      addCriterion("WX_OUTER_STR is null");
      return (Criteria) this;
    }

    public Criteria andWxOuterStrIsNotNull() {
      addCriterion("WX_OUTER_STR is not null");
      return (Criteria) this;
    }

    public Criteria andWxOuterStrEqualTo(String value) {
      addCriterion("WX_OUTER_STR =", value, "wxOuterStr");
      return (Criteria) this;
    }

    public Criteria andWxOuterStrNotEqualTo(String value) {
      addCriterion("WX_OUTER_STR <>", value, "wxOuterStr");
      return (Criteria) this;
    }

    public Criteria andWxOuterStrGreaterThan(String value) {
      addCriterion("WX_OUTER_STR >", value, "wxOuterStr");
      return (Criteria) this;
    }

    public Criteria andWxOuterStrGreaterThanOrEqualTo(String value) {
      addCriterion("WX_OUTER_STR >=", value, "wxOuterStr");
      return (Criteria) this;
    }

    public Criteria andWxOuterStrLessThan(String value) {
      addCriterion("WX_OUTER_STR <", value, "wxOuterStr");
      return (Criteria) this;
    }

    public Criteria andWxOuterStrLessThanOrEqualTo(String value) {
      addCriterion("WX_OUTER_STR <=", value, "wxOuterStr");
      return (Criteria) this;
    }

    public Criteria andWxOuterStrLike(String value) {
      addCriterion("WX_OUTER_STR like", value, "wxOuterStr");
      return (Criteria) this;
    }

    public Criteria andWxOuterStrNotLike(String value) {
      addCriterion("WX_OUTER_STR not like", value, "wxOuterStr");
      return (Criteria) this;
    }

    public Criteria andWxOuterStrIn(List<String> values) {
      addCriterion("WX_OUTER_STR in", values, "wxOuterStr");
      return (Criteria) this;
    }

    public Criteria andWxOuterStrNotIn(List<String> values) {
      addCriterion("WX_OUTER_STR not in", values, "wxOuterStr");
      return (Criteria) this;
    }

    public Criteria andWxOuterStrBetween(String value1, String value2) {
      addCriterion("WX_OUTER_STR between", value1, value2, "wxOuterStr");
      return (Criteria) this;
    }

    public Criteria andWxOuterStrNotBetween(String value1, String value2) {
      addCriterion("WX_OUTER_STR not between", value1, value2, "wxOuterStr");
      return (Criteria) this;
    }

    public Criteria andAlipayOpencardTimeIsNull() {
      addCriterion("ALIPAY_OPENCARD_TIME is null");
      return (Criteria) this;
    }

    public Criteria andAlipayOpencardTimeIsNotNull() {
      addCriterion("ALIPAY_OPENCARD_TIME is not null");
      return (Criteria) this;
    }

    public Criteria andAlipayOpencardTimeEqualTo(Date value) {
      addCriterion("ALIPAY_OPENCARD_TIME =", value, "alipayOpencardTime");
      return (Criteria) this;
    }

    public Criteria andAlipayOpencardTimeNotEqualTo(Date value) {
      addCriterion("ALIPAY_OPENCARD_TIME <>", value, "alipayOpencardTime");
      return (Criteria) this;
    }

    public Criteria andAlipayOpencardTimeGreaterThan(Date value) {
      addCriterion("ALIPAY_OPENCARD_TIME >", value, "alipayOpencardTime");
      return (Criteria) this;
    }

    public Criteria andAlipayOpencardTimeGreaterThanOrEqualTo(Date value) {
      addCriterion("ALIPAY_OPENCARD_TIME >=", value, "alipayOpencardTime");
      return (Criteria) this;
    }

    public Criteria andAlipayOpencardTimeLessThan(Date value) {
      addCriterion("ALIPAY_OPENCARD_TIME <", value, "alipayOpencardTime");
      return (Criteria) this;
    }

    public Criteria andAlipayOpencardTimeLessThanOrEqualTo(Date value) {
      addCriterion("ALIPAY_OPENCARD_TIME <=", value, "alipayOpencardTime");
      return (Criteria) this;
    }

    public Criteria andAlipayOpencardTimeIn(List<Date> values) {
      addCriterion("ALIPAY_OPENCARD_TIME in", values, "alipayOpencardTime");
      return (Criteria) this;
    }

    public Criteria andAlipayOpencardTimeNotIn(List<Date> values) {
      addCriterion("ALIPAY_OPENCARD_TIME not in", values, "alipayOpencardTime");
      return (Criteria) this;
    }

    public Criteria andAlipayOpencardTimeBetween(Date value1, Date value2) {
      addCriterion("ALIPAY_OPENCARD_TIME between", value1, value2, "alipayOpencardTime");
      return (Criteria) this;
    }

    public Criteria andAlipayOpencardTimeNotBetween(Date value1, Date value2) {
      addCriterion("ALIPAY_OPENCARD_TIME not between", value1, value2, "alipayOpencardTime");
      return (Criteria) this;
    }

    public Criteria andWxecardOpencardTimeIsNull() {
      addCriterion("WXECARD_OPENCARD_TIME is null");
      return (Criteria) this;
    }

    public Criteria andWxecardOpencardTimeIsNotNull() {
      addCriterion("WXECARD_OPENCARD_TIME is not null");
      return (Criteria) this;
    }

    public Criteria andWxecardOpencardTimeEqualTo(Date value) {
      addCriterion("WXECARD_OPENCARD_TIME =", value, "wxecardOpencardTime");
      return (Criteria) this;
    }

    public Criteria andWxecardOpencardTimeNotEqualTo(Date value) {
      addCriterion("WXECARD_OPENCARD_TIME <>", value, "wxecardOpencardTime");
      return (Criteria) this;
    }

    public Criteria andWxecardOpencardTimeGreaterThan(Date value) {
      addCriterion("WXECARD_OPENCARD_TIME >", value, "wxecardOpencardTime");
      return (Criteria) this;
    }

    public Criteria andWxecardOpencardTimeGreaterThanOrEqualTo(Date value) {
      addCriterion("WXECARD_OPENCARD_TIME >=", value, "wxecardOpencardTime");
      return (Criteria) this;
    }

    public Criteria andWxecardOpencardTimeLessThan(Date value) {
      addCriterion("WXECARD_OPENCARD_TIME <", value, "wxecardOpencardTime");
      return (Criteria) this;
    }

    public Criteria andWxecardOpencardTimeLessThanOrEqualTo(Date value) {
      addCriterion("WXECARD_OPENCARD_TIME <=", value, "wxecardOpencardTime");
      return (Criteria) this;
    }

    public Criteria andWxecardOpencardTimeIn(List<Date> values) {
      addCriterion("WXECARD_OPENCARD_TIME in", values, "wxecardOpencardTime");
      return (Criteria) this;
    }

    public Criteria andWxecardOpencardTimeNotIn(List<Date> values) {
      addCriterion("WXECARD_OPENCARD_TIME not in", values, "wxecardOpencardTime");
      return (Criteria) this;
    }

    public Criteria andWxecardOpencardTimeBetween(Date value1, Date value2) {
      addCriterion("WXECARD_OPENCARD_TIME between", value1, value2, "wxecardOpencardTime");
      return (Criteria) this;
    }

    public Criteria andWxecardOpencardTimeNotBetween(Date value1, Date value2) {
      addCriterion("WXECARD_OPENCARD_TIME not between", value1, value2, "wxecardOpencardTime");
      return (Criteria) this;
    }

    public Criteria andTmallOpencardTimeIsNull() {
      addCriterion("TMALL_OPENCARD_TIME is null");
      return (Criteria) this;
    }

    public Criteria andTmallOpencardTimeIsNotNull() {
      addCriterion("TMALL_OPENCARD_TIME is not null");
      return (Criteria) this;
    }

    public Criteria andTmallOpencardTimeEqualTo(Date value) {
      addCriterion("TMALL_OPENCARD_TIME =", value, "tmallOpencardTime");
      return (Criteria) this;
    }

    public Criteria andTmallOpencardTimeNotEqualTo(Date value) {
      addCriterion("TMALL_OPENCARD_TIME <>", value, "tmallOpencardTime");
      return (Criteria) this;
    }

    public Criteria andTmallOpencardTimeGreaterThan(Date value) {
      addCriterion("TMALL_OPENCARD_TIME >", value, "tmallOpencardTime");
      return (Criteria) this;
    }

    public Criteria andTmallOpencardTimeGreaterThanOrEqualTo(Date value) {
      addCriterion("TMALL_OPENCARD_TIME >=", value, "tmallOpencardTime");
      return (Criteria) this;
    }

    public Criteria andTmallOpencardTimeLessThan(Date value) {
      addCriterion("TMALL_OPENCARD_TIME <", value, "tmallOpencardTime");
      return (Criteria) this;
    }

    public Criteria andTmallOpencardTimeLessThanOrEqualTo(Date value) {
      addCriterion("TMALL_OPENCARD_TIME <=", value, "tmallOpencardTime");
      return (Criteria) this;
    }

    public Criteria andTmallOpencardTimeIn(List<Date> values) {
      addCriterion("TMALL_OPENCARD_TIME in", values, "tmallOpencardTime");
      return (Criteria) this;
    }

    public Criteria andTmallOpencardTimeNotIn(List<Date> values) {
      addCriterion("TMALL_OPENCARD_TIME not in", values, "tmallOpencardTime");
      return (Criteria) this;
    }

    public Criteria andTmallOpencardTimeBetween(Date value1, Date value2) {
      addCriterion("TMALL_OPENCARD_TIME between", value1, value2, "tmallOpencardTime");
      return (Criteria) this;
    }

    public Criteria andTmallOpencardTimeNotBetween(Date value1, Date value2) {
      addCriterion("TMALL_OPENCARD_TIME not between", value1, value2, "tmallOpencardTime");
      return (Criteria) this;
    }

    public Criteria andBizCardNoIsNull() {
      addCriterion("BIZ_CARD_NO is null");
      return (Criteria) this;
    }

    public Criteria andBizCardNoIsNotNull() {
      addCriterion("BIZ_CARD_NO is not null");
      return (Criteria) this;
    }

    public Criteria andBizCardNoEqualTo(String value) {
      addCriterion("BIZ_CARD_NO =", value, "bizCardNo");
      return (Criteria) this;
    }

    public Criteria andBizCardNoNotEqualTo(String value) {
      addCriterion("BIZ_CARD_NO <>", value, "bizCardNo");
      return (Criteria) this;
    }

    public Criteria andBizCardNoGreaterThan(String value) {
      addCriterion("BIZ_CARD_NO >", value, "bizCardNo");
      return (Criteria) this;
    }

    public Criteria andBizCardNoGreaterThanOrEqualTo(String value) {
      addCriterion("BIZ_CARD_NO >=", value, "bizCardNo");
      return (Criteria) this;
    }

    public Criteria andBizCardNoLessThan(String value) {
      addCriterion("BIZ_CARD_NO <", value, "bizCardNo");
      return (Criteria) this;
    }

    public Criteria andBizCardNoLessThanOrEqualTo(String value) {
      addCriterion("BIZ_CARD_NO <=", value, "bizCardNo");
      return (Criteria) this;
    }

    public Criteria andBizCardNoLike(String value) {
      addCriterion("BIZ_CARD_NO like", value, "bizCardNo");
      return (Criteria) this;
    }

    public Criteria andBizCardNoNotLike(String value) {
      addCriterion("BIZ_CARD_NO not like", value, "bizCardNo");
      return (Criteria) this;
    }

    public Criteria andBizCardNoIn(List<String> values) {
      addCriterion("BIZ_CARD_NO in", values, "bizCardNo");
      return (Criteria) this;
    }

    public Criteria andBizCardNoNotIn(List<String> values) {
      addCriterion("BIZ_CARD_NO not in", values, "bizCardNo");
      return (Criteria) this;
    }

    public Criteria andBizCardNoBetween(String value1, String value2) {
      addCriterion("BIZ_CARD_NO between", value1, value2, "bizCardNo");
      return (Criteria) this;
    }

    public Criteria andBizCardNoNotBetween(String value1, String value2) {
      addCriterion("BIZ_CARD_NO not between", value1, value2, "bizCardNo");
      return (Criteria) this;
    }

    public Criteria andNickIsNull() {
      addCriterion("NICK is null");
      return (Criteria) this;
    }

    public Criteria andNickIsNotNull() {
      addCriterion("NICK is not null");
      return (Criteria) this;
    }

    public Criteria andNickEqualTo(String value) {
      addCriterion("NICK =", value, "nick");
      return (Criteria) this;
    }

    public Criteria andNickNotEqualTo(String value) {
      addCriterion("NICK <>", value, "nick");
      return (Criteria) this;
    }

    public Criteria andNickGreaterThan(String value) {
      addCriterion("NICK >", value, "nick");
      return (Criteria) this;
    }

    public Criteria andNickGreaterThanOrEqualTo(String value) {
      addCriterion("NICK >=", value, "nick");
      return (Criteria) this;
    }

    public Criteria andNickLessThan(String value) {
      addCriterion("NICK <", value, "nick");
      return (Criteria) this;
    }

    public Criteria andNickLessThanOrEqualTo(String value) {
      addCriterion("NICK <=", value, "nick");
      return (Criteria) this;
    }

    public Criteria andNickLike(String value) {
      addCriterion("NICK like", value, "nick");
      return (Criteria) this;
    }

    public Criteria andNickNotLike(String value) {
      addCriterion("NICK not like", value, "nick");
      return (Criteria) this;
    }

    public Criteria andNickIn(List<String> values) {
      addCriterion("NICK in", values, "nick");
      return (Criteria) this;
    }

    public Criteria andNickNotIn(List<String> values) {
      addCriterion("NICK not in", values, "nick");
      return (Criteria) this;
    }

    public Criteria andNickBetween(String value1, String value2) {
      addCriterion("NICK between", value1, value2, "nick");
      return (Criteria) this;
    }

    public Criteria andNickNotBetween(String value1, String value2) {
      addCriterion("NICK not between", value1, value2, "nick");
      return (Criteria) this;
    }

    public Criteria andIsSendbirthdayCouponIsNull() {
      addCriterion("IS_SENDBIRTHDAY_COUPON is null");
      return (Criteria) this;
    }

    public Criteria andIsSendbirthdayCouponIsNotNull() {
      addCriterion("IS_SENDBIRTHDAY_COUPON is not null");
      return (Criteria) this;
    }

    public Criteria andIsSendbirthdayCouponEqualTo(String value) {
      addCriterion("IS_SENDBIRTHDAY_COUPON =", value, "isSendbirthdayCoupon");
      return (Criteria) this;
    }

    public Criteria andIsSendbirthdayCouponNotEqualTo(String value) {
      addCriterion("IS_SENDBIRTHDAY_COUPON <>", value, "isSendbirthdayCoupon");
      return (Criteria) this;
    }

    public Criteria andIsSendbirthdayCouponGreaterThan(String value) {
      addCriterion("IS_SENDBIRTHDAY_COUPON >", value, "isSendbirthdayCoupon");
      return (Criteria) this;
    }

    public Criteria andIsSendbirthdayCouponGreaterThanOrEqualTo(String value) {
      addCriterion("IS_SENDBIRTHDAY_COUPON >=", value, "isSendbirthdayCoupon");
      return (Criteria) this;
    }

    public Criteria andIsSendbirthdayCouponLessThan(String value) {
      addCriterion("IS_SENDBIRTHDAY_COUPON <", value, "isSendbirthdayCoupon");
      return (Criteria) this;
    }

    public Criteria andIsSendbirthdayCouponLessThanOrEqualTo(String value) {
      addCriterion("IS_SENDBIRTHDAY_COUPON <=", value, "isSendbirthdayCoupon");
      return (Criteria) this;
    }

    public Criteria andIsSendbirthdayCouponLike(String value) {
      addCriterion("IS_SENDBIRTHDAY_COUPON like", value, "isSendbirthdayCoupon");
      return (Criteria) this;
    }

    public Criteria andIsSendbirthdayCouponNotLike(String value) {
      addCriterion("IS_SENDBIRTHDAY_COUPON not like", value, "isSendbirthdayCoupon");
      return (Criteria) this;
    }

    public Criteria andIsSendbirthdayCouponIn(List<String> values) {
      addCriterion("IS_SENDBIRTHDAY_COUPON in", values, "isSendbirthdayCoupon");
      return (Criteria) this;
    }

    public Criteria andIsSendbirthdayCouponNotIn(List<String> values) {
      addCriterion("IS_SENDBIRTHDAY_COUPON not in", values, "isSendbirthdayCoupon");
      return (Criteria) this;
    }

    public Criteria andIsSendbirthdayCouponBetween(String value1, String value2) {
      addCriterion("IS_SENDBIRTHDAY_COUPON between", value1, value2, "isSendbirthdayCoupon");
      return (Criteria) this;
    }

    public Criteria andIsSendbirthdayCouponNotBetween(String value1, String value2) {
      addCriterion("IS_SENDBIRTHDAY_COUPON not between", value1, value2, "isSendbirthdayCoupon");
      return (Criteria) this;
    }

    public Criteria andHbaseAutoTimeIsNull() {
      addCriterion("HBASE_AUTO_TIME is null");
      return (Criteria) this;
    }

    public Criteria andHbaseAutoTimeIsNotNull() {
      addCriterion("HBASE_AUTO_TIME is not null");
      return (Criteria) this;
    }

    public Criteria andHbaseAutoTimeEqualTo(Date value) {
      addCriterion("HBASE_AUTO_TIME =", value, "hbaseAutoTime");
      return (Criteria) this;
    }

    public Criteria andHbaseAutoTimeNotEqualTo(Date value) {
      addCriterion("HBASE_AUTO_TIME <>", value, "hbaseAutoTime");
      return (Criteria) this;
    }

    public Criteria andHbaseAutoTimeGreaterThan(Date value) {
      addCriterion("HBASE_AUTO_TIME >", value, "hbaseAutoTime");
      return (Criteria) this;
    }

    public Criteria andHbaseAutoTimeGreaterThanOrEqualTo(Date value) {
      addCriterion("HBASE_AUTO_TIME >=", value, "hbaseAutoTime");
      return (Criteria) this;
    }

    public Criteria andHbaseAutoTimeLessThan(Date value) {
      addCriterion("HBASE_AUTO_TIME <", value, "hbaseAutoTime");
      return (Criteria) this;
    }

    public Criteria andHbaseAutoTimeLessThanOrEqualTo(Date value) {
      addCriterion("HBASE_AUTO_TIME <=", value, "hbaseAutoTime");
      return (Criteria) this;
    }

    public Criteria andHbaseAutoTimeIn(List<Date> values) {
      addCriterion("HBASE_AUTO_TIME in", values, "hbaseAutoTime");
      return (Criteria) this;
    }

    public Criteria andHbaseAutoTimeNotIn(List<Date> values) {
      addCriterion("HBASE_AUTO_TIME not in", values, "hbaseAutoTime");
      return (Criteria) this;
    }

    public Criteria andHbaseAutoTimeBetween(Date value1, Date value2) {
      addCriterion("HBASE_AUTO_TIME between", value1, value2, "hbaseAutoTime");
      return (Criteria) this;
    }

    public Criteria andHbaseAutoTimeNotBetween(Date value1, Date value2) {
      addCriterion("HBASE_AUTO_TIME not between", value1, value2, "hbaseAutoTime");
      return (Criteria) this;
    }

    public Criteria andClearPointIsNull() {
      addCriterion("CLEAR_POINT is null");
      return (Criteria) this;
    }

    public Criteria andClearPointIsNotNull() {
      addCriterion("CLEAR_POINT is not null");
      return (Criteria) this;
    }

    public Criteria andClearPointEqualTo(Integer value) {
      addCriterion("CLEAR_POINT =", value, "clearPoint");
      return (Criteria) this;
    }

    public Criteria andClearPointNotEqualTo(Integer value) {
      addCriterion("CLEAR_POINT <>", value, "clearPoint");
      return (Criteria) this;
    }

    public Criteria andClearPointGreaterThan(Integer value) {
      addCriterion("CLEAR_POINT >", value, "clearPoint");
      return (Criteria) this;
    }

    public Criteria andClearPointGreaterThanOrEqualTo(Integer value) {
      addCriterion("CLEAR_POINT >=", value, "clearPoint");
      return (Criteria) this;
    }

    public Criteria andClearPointLessThan(Integer value) {
      addCriterion("CLEAR_POINT <", value, "clearPoint");
      return (Criteria) this;
    }

    public Criteria andClearPointLessThanOrEqualTo(Integer value) {
      addCriterion("CLEAR_POINT <=", value, "clearPoint");
      return (Criteria) this;
    }

    public Criteria andClearPointIn(List<Integer> values) {
      addCriterion("CLEAR_POINT in", values, "clearPoint");
      return (Criteria) this;
    }

    public Criteria andClearPointNotIn(List<Integer> values) {
      addCriterion("CLEAR_POINT not in", values, "clearPoint");
      return (Criteria) this;
    }

    public Criteria andClearPointBetween(Integer value1, Integer value2) {
      addCriterion("CLEAR_POINT between", value1, value2, "clearPoint");
      return (Criteria) this;
    }

    public Criteria andClearPointNotBetween(Integer value1, Integer value2) {
      addCriterion("CLEAR_POINT not between", value1, value2, "clearPoint");
      return (Criteria) this;
    }

    public Criteria andVipHeightIsNull() {
      addCriterion("VIP_HEIGHT is null");
      return (Criteria) this;
    }

    public Criteria andVipHeightIsNotNull() {
      addCriterion("VIP_HEIGHT is not null");
      return (Criteria) this;
    }

    public Criteria andVipHeightEqualTo(String value) {
      addCriterion("VIP_HEIGHT =", value, "vipHeight");
      return (Criteria) this;
    }

    public Criteria andVipHeightNotEqualTo(String value) {
      addCriterion("VIP_HEIGHT <>", value, "vipHeight");
      return (Criteria) this;
    }

    public Criteria andVipHeightGreaterThan(String value) {
      addCriterion("VIP_HEIGHT >", value, "vipHeight");
      return (Criteria) this;
    }

    public Criteria andVipHeightGreaterThanOrEqualTo(String value) {
      addCriterion("VIP_HEIGHT >=", value, "vipHeight");
      return (Criteria) this;
    }

    public Criteria andVipHeightLessThan(String value) {
      addCriterion("VIP_HEIGHT <", value, "vipHeight");
      return (Criteria) this;
    }

    public Criteria andVipHeightLessThanOrEqualTo(String value) {
      addCriterion("VIP_HEIGHT <=", value, "vipHeight");
      return (Criteria) this;
    }

    public Criteria andVipHeightLike(String value) {
      addCriterion("VIP_HEIGHT like", value, "vipHeight");
      return (Criteria) this;
    }

    public Criteria andVipHeightNotLike(String value) {
      addCriterion("VIP_HEIGHT not like", value, "vipHeight");
      return (Criteria) this;
    }

    public Criteria andVipHeightIn(List<String> values) {
      addCriterion("VIP_HEIGHT in", values, "vipHeight");
      return (Criteria) this;
    }

    public Criteria andVipHeightNotIn(List<String> values) {
      addCriterion("VIP_HEIGHT not in", values, "vipHeight");
      return (Criteria) this;
    }

    public Criteria andVipHeightBetween(String value1, String value2) {
      addCriterion("VIP_HEIGHT between", value1, value2, "vipHeight");
      return (Criteria) this;
    }

    public Criteria andVipHeightNotBetween(String value1, String value2) {
      addCriterion("VIP_HEIGHT not between", value1, value2, "vipHeight");
      return (Criteria) this;
    }

    public Criteria andVipWeightIsNull() {
      addCriterion("VIP_WEIGHT is null");
      return (Criteria) this;
    }

    public Criteria andVipWeightIsNotNull() {
      addCriterion("VIP_WEIGHT is not null");
      return (Criteria) this;
    }

    public Criteria andVipWeightEqualTo(String value) {
      addCriterion("VIP_WEIGHT =", value, "vipWeight");
      return (Criteria) this;
    }

    public Criteria andVipWeightNotEqualTo(String value) {
      addCriterion("VIP_WEIGHT <>", value, "vipWeight");
      return (Criteria) this;
    }

    public Criteria andVipWeightGreaterThan(String value) {
      addCriterion("VIP_WEIGHT >", value, "vipWeight");
      return (Criteria) this;
    }

    public Criteria andVipWeightGreaterThanOrEqualTo(String value) {
      addCriterion("VIP_WEIGHT >=", value, "vipWeight");
      return (Criteria) this;
    }

    public Criteria andVipWeightLessThan(String value) {
      addCriterion("VIP_WEIGHT <", value, "vipWeight");
      return (Criteria) this;
    }

    public Criteria andVipWeightLessThanOrEqualTo(String value) {
      addCriterion("VIP_WEIGHT <=", value, "vipWeight");
      return (Criteria) this;
    }

    public Criteria andVipWeightLike(String value) {
      addCriterion("VIP_WEIGHT like", value, "vipWeight");
      return (Criteria) this;
    }

    public Criteria andVipWeightNotLike(String value) {
      addCriterion("VIP_WEIGHT not like", value, "vipWeight");
      return (Criteria) this;
    }

    public Criteria andVipWeightIn(List<String> values) {
      addCriterion("VIP_WEIGHT in", values, "vipWeight");
      return (Criteria) this;
    }

    public Criteria andVipWeightNotIn(List<String> values) {
      addCriterion("VIP_WEIGHT not in", values, "vipWeight");
      return (Criteria) this;
    }

    public Criteria andVipWeightBetween(String value1, String value2) {
      addCriterion("VIP_WEIGHT between", value1, value2, "vipWeight");
      return (Criteria) this;
    }

    public Criteria andVipWeightNotBetween(String value1, String value2) {
      addCriterion("VIP_WEIGHT not between", value1, value2, "vipWeight");
      return (Criteria) this;
    }

    public Criteria andShoesSizeIsNull() {
      addCriterion("SHOES_SIZE is null");
      return (Criteria) this;
    }

    public Criteria andShoesSizeIsNotNull() {
      addCriterion("SHOES_SIZE is not null");
      return (Criteria) this;
    }

    public Criteria andShoesSizeEqualTo(String value) {
      addCriterion("SHOES_SIZE =", value, "shoesSize");
      return (Criteria) this;
    }

    public Criteria andShoesSizeNotEqualTo(String value) {
      addCriterion("SHOES_SIZE <>", value, "shoesSize");
      return (Criteria) this;
    }

    public Criteria andShoesSizeGreaterThan(String value) {
      addCriterion("SHOES_SIZE >", value, "shoesSize");
      return (Criteria) this;
    }

    public Criteria andShoesSizeGreaterThanOrEqualTo(String value) {
      addCriterion("SHOES_SIZE >=", value, "shoesSize");
      return (Criteria) this;
    }

    public Criteria andShoesSizeLessThan(String value) {
      addCriterion("SHOES_SIZE <", value, "shoesSize");
      return (Criteria) this;
    }

    public Criteria andShoesSizeLessThanOrEqualTo(String value) {
      addCriterion("SHOES_SIZE <=", value, "shoesSize");
      return (Criteria) this;
    }

    public Criteria andShoesSizeLike(String value) {
      addCriterion("SHOES_SIZE like", value, "shoesSize");
      return (Criteria) this;
    }

    public Criteria andShoesSizeNotLike(String value) {
      addCriterion("SHOES_SIZE not like", value, "shoesSize");
      return (Criteria) this;
    }

    public Criteria andShoesSizeIn(List<String> values) {
      addCriterion("SHOES_SIZE in", values, "shoesSize");
      return (Criteria) this;
    }

    public Criteria andShoesSizeNotIn(List<String> values) {
      addCriterion("SHOES_SIZE not in", values, "shoesSize");
      return (Criteria) this;
    }

    public Criteria andShoesSizeBetween(String value1, String value2) {
      addCriterion("SHOES_SIZE between", value1, value2, "shoesSize");
      return (Criteria) this;
    }

    public Criteria andShoesSizeNotBetween(String value1, String value2) {
      addCriterion("SHOES_SIZE not between", value1, value2, "shoesSize");
      return (Criteria) this;
    }
  }

  /**
   * 只读. wx_vip
   * @mbg.generated  2018-07-07 17:52:51
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
     * This class corresponds to the database table wx_vip
     *
     * @mbg.generated do_not_delete_during_merge 2018-07-07 16:03:38
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }
}