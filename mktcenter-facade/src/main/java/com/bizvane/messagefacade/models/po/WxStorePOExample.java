package com.bizvane.messagefacade.models.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WxStorePOExample implements Serializable {
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
  public WxStorePOExample() {
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
   * 只读. wx_store
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

    public Criteria andCodeIsNull() {
      addCriterion("CODE is null");
      return (Criteria) this;
    }

    public Criteria andCodeIsNotNull() {
      addCriterion("CODE is not null");
      return (Criteria) this;
    }

    public Criteria andCodeEqualTo(String value) {
      addCriterion("CODE =", value, "code");
      return (Criteria) this;
    }

    public Criteria andCodeNotEqualTo(String value) {
      addCriterion("CODE <>", value, "code");
      return (Criteria) this;
    }

    public Criteria andCodeGreaterThan(String value) {
      addCriterion("CODE >", value, "code");
      return (Criteria) this;
    }

    public Criteria andCodeGreaterThanOrEqualTo(String value) {
      addCriterion("CODE >=", value, "code");
      return (Criteria) this;
    }

    public Criteria andCodeLessThan(String value) {
      addCriterion("CODE <", value, "code");
      return (Criteria) this;
    }

    public Criteria andCodeLessThanOrEqualTo(String value) {
      addCriterion("CODE <=", value, "code");
      return (Criteria) this;
    }

    public Criteria andCodeLike(String value) {
      addCriterion("CODE like", value, "code");
      return (Criteria) this;
    }

    public Criteria andCodeNotLike(String value) {
      addCriterion("CODE not like", value, "code");
      return (Criteria) this;
    }

    public Criteria andCodeIn(List<String> values) {
      addCriterion("CODE in", values, "code");
      return (Criteria) this;
    }

    public Criteria andCodeNotIn(List<String> values) {
      addCriterion("CODE not in", values, "code");
      return (Criteria) this;
    }

    public Criteria andCodeBetween(String value1, String value2) {
      addCriterion("CODE between", value1, value2, "code");
      return (Criteria) this;
    }

    public Criteria andCodeNotBetween(String value1, String value2) {
      addCriterion("CODE not between", value1, value2, "code");
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

    public Criteria andPictureUrlIsNull() {
      addCriterion("PICTURE_URL is null");
      return (Criteria) this;
    }

    public Criteria andPictureUrlIsNotNull() {
      addCriterion("PICTURE_URL is not null");
      return (Criteria) this;
    }

    public Criteria andPictureUrlEqualTo(String value) {
      addCriterion("PICTURE_URL =", value, "pictureUrl");
      return (Criteria) this;
    }

    public Criteria andPictureUrlNotEqualTo(String value) {
      addCriterion("PICTURE_URL <>", value, "pictureUrl");
      return (Criteria) this;
    }

    public Criteria andPictureUrlGreaterThan(String value) {
      addCriterion("PICTURE_URL >", value, "pictureUrl");
      return (Criteria) this;
    }

    public Criteria andPictureUrlGreaterThanOrEqualTo(String value) {
      addCriterion("PICTURE_URL >=", value, "pictureUrl");
      return (Criteria) this;
    }

    public Criteria andPictureUrlLessThan(String value) {
      addCriterion("PICTURE_URL <", value, "pictureUrl");
      return (Criteria) this;
    }

    public Criteria andPictureUrlLessThanOrEqualTo(String value) {
      addCriterion("PICTURE_URL <=", value, "pictureUrl");
      return (Criteria) this;
    }

    public Criteria andPictureUrlLike(String value) {
      addCriterion("PICTURE_URL like", value, "pictureUrl");
      return (Criteria) this;
    }

    public Criteria andPictureUrlNotLike(String value) {
      addCriterion("PICTURE_URL not like", value, "pictureUrl");
      return (Criteria) this;
    }

    public Criteria andPictureUrlIn(List<String> values) {
      addCriterion("PICTURE_URL in", values, "pictureUrl");
      return (Criteria) this;
    }

    public Criteria andPictureUrlNotIn(List<String> values) {
      addCriterion("PICTURE_URL not in", values, "pictureUrl");
      return (Criteria) this;
    }

    public Criteria andPictureUrlBetween(String value1, String value2) {
      addCriterion("PICTURE_URL between", value1, value2, "pictureUrl");
      return (Criteria) this;
    }

    public Criteria andPictureUrlNotBetween(String value1, String value2) {
      addCriterion("PICTURE_URL not between", value1, value2, "pictureUrl");
      return (Criteria) this;
    }

    public Criteria andLbsIsNull() {
      addCriterion("LBS is null");
      return (Criteria) this;
    }

    public Criteria andLbsIsNotNull() {
      addCriterion("LBS is not null");
      return (Criteria) this;
    }

    public Criteria andLbsEqualTo(String value) {
      addCriterion("LBS =", value, "lbs");
      return (Criteria) this;
    }

    public Criteria andLbsNotEqualTo(String value) {
      addCriterion("LBS <>", value, "lbs");
      return (Criteria) this;
    }

    public Criteria andLbsGreaterThan(String value) {
      addCriterion("LBS >", value, "lbs");
      return (Criteria) this;
    }

    public Criteria andLbsGreaterThanOrEqualTo(String value) {
      addCriterion("LBS >=", value, "lbs");
      return (Criteria) this;
    }

    public Criteria andLbsLessThan(String value) {
      addCriterion("LBS <", value, "lbs");
      return (Criteria) this;
    }

    public Criteria andLbsLessThanOrEqualTo(String value) {
      addCriterion("LBS <=", value, "lbs");
      return (Criteria) this;
    }

    public Criteria andLbsLike(String value) {
      addCriterion("LBS like", value, "lbs");
      return (Criteria) this;
    }

    public Criteria andLbsNotLike(String value) {
      addCriterion("LBS not like", value, "lbs");
      return (Criteria) this;
    }

    public Criteria andLbsIn(List<String> values) {
      addCriterion("LBS in", values, "lbs");
      return (Criteria) this;
    }

    public Criteria andLbsNotIn(List<String> values) {
      addCriterion("LBS not in", values, "lbs");
      return (Criteria) this;
    }

    public Criteria andLbsBetween(String value1, String value2) {
      addCriterion("LBS between", value1, value2, "lbs");
      return (Criteria) this;
    }

    public Criteria andLbsNotBetween(String value1, String value2) {
      addCriterion("LBS not between", value1, value2, "lbs");
      return (Criteria) this;
    }

    public Criteria andPhoneIsNull() {
      addCriterion("PHONE is null");
      return (Criteria) this;
    }

    public Criteria andPhoneIsNotNull() {
      addCriterion("PHONE is not null");
      return (Criteria) this;
    }

    public Criteria andPhoneEqualTo(String value) {
      addCriterion("PHONE =", value, "phone");
      return (Criteria) this;
    }

    public Criteria andPhoneNotEqualTo(String value) {
      addCriterion("PHONE <>", value, "phone");
      return (Criteria) this;
    }

    public Criteria andPhoneGreaterThan(String value) {
      addCriterion("PHONE >", value, "phone");
      return (Criteria) this;
    }

    public Criteria andPhoneGreaterThanOrEqualTo(String value) {
      addCriterion("PHONE >=", value, "phone");
      return (Criteria) this;
    }

    public Criteria andPhoneLessThan(String value) {
      addCriterion("PHONE <", value, "phone");
      return (Criteria) this;
    }

    public Criteria andPhoneLessThanOrEqualTo(String value) {
      addCriterion("PHONE <=", value, "phone");
      return (Criteria) this;
    }

    public Criteria andPhoneLike(String value) {
      addCriterion("PHONE like", value, "phone");
      return (Criteria) this;
    }

    public Criteria andPhoneNotLike(String value) {
      addCriterion("PHONE not like", value, "phone");
      return (Criteria) this;
    }

    public Criteria andPhoneIn(List<String> values) {
      addCriterion("PHONE in", values, "phone");
      return (Criteria) this;
    }

    public Criteria andPhoneNotIn(List<String> values) {
      addCriterion("PHONE not in", values, "phone");
      return (Criteria) this;
    }

    public Criteria andPhoneBetween(String value1, String value2) {
      addCriterion("PHONE between", value1, value2, "phone");
      return (Criteria) this;
    }

    public Criteria andPhoneNotBetween(String value1, String value2) {
      addCriterion("PHONE not between", value1, value2, "phone");
      return (Criteria) this;
    }

    public Criteria andAdProvinceIdIsNull() {
      addCriterion("AD_PROVINCE_ID is null");
      return (Criteria) this;
    }

    public Criteria andAdProvinceIdIsNotNull() {
      addCriterion("AD_PROVINCE_ID is not null");
      return (Criteria) this;
    }

    public Criteria andAdProvinceIdEqualTo(Long value) {
      addCriterion("AD_PROVINCE_ID =", value, "adProvinceId");
      return (Criteria) this;
    }

    public Criteria andAdProvinceIdNotEqualTo(Long value) {
      addCriterion("AD_PROVINCE_ID <>", value, "adProvinceId");
      return (Criteria) this;
    }

    public Criteria andAdProvinceIdGreaterThan(Long value) {
      addCriterion("AD_PROVINCE_ID >", value, "adProvinceId");
      return (Criteria) this;
    }

    public Criteria andAdProvinceIdGreaterThanOrEqualTo(Long value) {
      addCriterion("AD_PROVINCE_ID >=", value, "adProvinceId");
      return (Criteria) this;
    }

    public Criteria andAdProvinceIdLessThan(Long value) {
      addCriterion("AD_PROVINCE_ID <", value, "adProvinceId");
      return (Criteria) this;
    }

    public Criteria andAdProvinceIdLessThanOrEqualTo(Long value) {
      addCriterion("AD_PROVINCE_ID <=", value, "adProvinceId");
      return (Criteria) this;
    }

    public Criteria andAdProvinceIdIn(List<Long> values) {
      addCriterion("AD_PROVINCE_ID in", values, "adProvinceId");
      return (Criteria) this;
    }

    public Criteria andAdProvinceIdNotIn(List<Long> values) {
      addCriterion("AD_PROVINCE_ID not in", values, "adProvinceId");
      return (Criteria) this;
    }

    public Criteria andAdProvinceIdBetween(Long value1, Long value2) {
      addCriterion("AD_PROVINCE_ID between", value1, value2, "adProvinceId");
      return (Criteria) this;
    }

    public Criteria andAdProvinceIdNotBetween(Long value1, Long value2) {
      addCriterion("AD_PROVINCE_ID not between", value1, value2, "adProvinceId");
      return (Criteria) this;
    }

    public Criteria andAdCityIdIsNull() {
      addCriterion("AD_CITY_ID is null");
      return (Criteria) this;
    }

    public Criteria andAdCityIdIsNotNull() {
      addCriterion("AD_CITY_ID is not null");
      return (Criteria) this;
    }

    public Criteria andAdCityIdEqualTo(Long value) {
      addCriterion("AD_CITY_ID =", value, "adCityId");
      return (Criteria) this;
    }

    public Criteria andAdCityIdNotEqualTo(Long value) {
      addCriterion("AD_CITY_ID <>", value, "adCityId");
      return (Criteria) this;
    }

    public Criteria andAdCityIdGreaterThan(Long value) {
      addCriterion("AD_CITY_ID >", value, "adCityId");
      return (Criteria) this;
    }

    public Criteria andAdCityIdGreaterThanOrEqualTo(Long value) {
      addCriterion("AD_CITY_ID >=", value, "adCityId");
      return (Criteria) this;
    }

    public Criteria andAdCityIdLessThan(Long value) {
      addCriterion("AD_CITY_ID <", value, "adCityId");
      return (Criteria) this;
    }

    public Criteria andAdCityIdLessThanOrEqualTo(Long value) {
      addCriterion("AD_CITY_ID <=", value, "adCityId");
      return (Criteria) this;
    }

    public Criteria andAdCityIdIn(List<Long> values) {
      addCriterion("AD_CITY_ID in", values, "adCityId");
      return (Criteria) this;
    }

    public Criteria andAdCityIdNotIn(List<Long> values) {
      addCriterion("AD_CITY_ID not in", values, "adCityId");
      return (Criteria) this;
    }

    public Criteria andAdCityIdBetween(Long value1, Long value2) {
      addCriterion("AD_CITY_ID between", value1, value2, "adCityId");
      return (Criteria) this;
    }

    public Criteria andAdCityIdNotBetween(Long value1, Long value2) {
      addCriterion("AD_CITY_ID not between", value1, value2, "adCityId");
      return (Criteria) this;
    }

    public Criteria andAdAreaIdIsNull() {
      addCriterion("AD_AREA_ID is null");
      return (Criteria) this;
    }

    public Criteria andAdAreaIdIsNotNull() {
      addCriterion("AD_AREA_ID is not null");
      return (Criteria) this;
    }

    public Criteria andAdAreaIdEqualTo(Long value) {
      addCriterion("AD_AREA_ID =", value, "adAreaId");
      return (Criteria) this;
    }

    public Criteria andAdAreaIdNotEqualTo(Long value) {
      addCriterion("AD_AREA_ID <>", value, "adAreaId");
      return (Criteria) this;
    }

    public Criteria andAdAreaIdGreaterThan(Long value) {
      addCriterion("AD_AREA_ID >", value, "adAreaId");
      return (Criteria) this;
    }

    public Criteria andAdAreaIdGreaterThanOrEqualTo(Long value) {
      addCriterion("AD_AREA_ID >=", value, "adAreaId");
      return (Criteria) this;
    }

    public Criteria andAdAreaIdLessThan(Long value) {
      addCriterion("AD_AREA_ID <", value, "adAreaId");
      return (Criteria) this;
    }

    public Criteria andAdAreaIdLessThanOrEqualTo(Long value) {
      addCriterion("AD_AREA_ID <=", value, "adAreaId");
      return (Criteria) this;
    }

    public Criteria andAdAreaIdIn(List<Long> values) {
      addCriterion("AD_AREA_ID in", values, "adAreaId");
      return (Criteria) this;
    }

    public Criteria andAdAreaIdNotIn(List<Long> values) {
      addCriterion("AD_AREA_ID not in", values, "adAreaId");
      return (Criteria) this;
    }

    public Criteria andAdAreaIdBetween(Long value1, Long value2) {
      addCriterion("AD_AREA_ID between", value1, value2, "adAreaId");
      return (Criteria) this;
    }

    public Criteria andAdAreaIdNotBetween(Long value1, Long value2) {
      addCriterion("AD_AREA_ID not between", value1, value2, "adAreaId");
      return (Criteria) this;
    }

    public Criteria andAddressIsNull() {
      addCriterion("ADDRESS is null");
      return (Criteria) this;
    }

    public Criteria andAddressIsNotNull() {
      addCriterion("ADDRESS is not null");
      return (Criteria) this;
    }

    public Criteria andAddressEqualTo(String value) {
      addCriterion("ADDRESS =", value, "address");
      return (Criteria) this;
    }

    public Criteria andAddressNotEqualTo(String value) {
      addCriterion("ADDRESS <>", value, "address");
      return (Criteria) this;
    }

    public Criteria andAddressGreaterThan(String value) {
      addCriterion("ADDRESS >", value, "address");
      return (Criteria) this;
    }

    public Criteria andAddressGreaterThanOrEqualTo(String value) {
      addCriterion("ADDRESS >=", value, "address");
      return (Criteria) this;
    }

    public Criteria andAddressLessThan(String value) {
      addCriterion("ADDRESS <", value, "address");
      return (Criteria) this;
    }

    public Criteria andAddressLessThanOrEqualTo(String value) {
      addCriterion("ADDRESS <=", value, "address");
      return (Criteria) this;
    }

    public Criteria andAddressLike(String value) {
      addCriterion("ADDRESS like", value, "address");
      return (Criteria) this;
    }

    public Criteria andAddressNotLike(String value) {
      addCriterion("ADDRESS not like", value, "address");
      return (Criteria) this;
    }

    public Criteria andAddressIn(List<String> values) {
      addCriterion("ADDRESS in", values, "address");
      return (Criteria) this;
    }

    public Criteria andAddressNotIn(List<String> values) {
      addCriterion("ADDRESS not in", values, "address");
      return (Criteria) this;
    }

    public Criteria andAddressBetween(String value1, String value2) {
      addCriterion("ADDRESS between", value1, value2, "address");
      return (Criteria) this;
    }

    public Criteria andAddressNotBetween(String value1, String value2) {
      addCriterion("ADDRESS not between", value1, value2, "address");
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

    public Criteria andIdcodeIsNull() {
      addCriterion("IDCODE is null");
      return (Criteria) this;
    }

    public Criteria andIdcodeIsNotNull() {
      addCriterion("IDCODE is not null");
      return (Criteria) this;
    }

    public Criteria andIdcodeEqualTo(String value) {
      addCriterion("IDCODE =", value, "idcode");
      return (Criteria) this;
    }

    public Criteria andIdcodeNotEqualTo(String value) {
      addCriterion("IDCODE <>", value, "idcode");
      return (Criteria) this;
    }

    public Criteria andIdcodeGreaterThan(String value) {
      addCriterion("IDCODE >", value, "idcode");
      return (Criteria) this;
    }

    public Criteria andIdcodeGreaterThanOrEqualTo(String value) {
      addCriterion("IDCODE >=", value, "idcode");
      return (Criteria) this;
    }

    public Criteria andIdcodeLessThan(String value) {
      addCriterion("IDCODE <", value, "idcode");
      return (Criteria) this;
    }

    public Criteria andIdcodeLessThanOrEqualTo(String value) {
      addCriterion("IDCODE <=", value, "idcode");
      return (Criteria) this;
    }

    public Criteria andIdcodeLike(String value) {
      addCriterion("IDCODE like", value, "idcode");
      return (Criteria) this;
    }

    public Criteria andIdcodeNotLike(String value) {
      addCriterion("IDCODE not like", value, "idcode");
      return (Criteria) this;
    }

    public Criteria andIdcodeIn(List<String> values) {
      addCriterion("IDCODE in", values, "idcode");
      return (Criteria) this;
    }

    public Criteria andIdcodeNotIn(List<String> values) {
      addCriterion("IDCODE not in", values, "idcode");
      return (Criteria) this;
    }

    public Criteria andIdcodeBetween(String value1, String value2) {
      addCriterion("IDCODE between", value1, value2, "idcode");
      return (Criteria) this;
    }

    public Criteria andIdcodeNotBetween(String value1, String value2) {
      addCriterion("IDCODE not between", value1, value2, "idcode");
      return (Criteria) this;
    }

    public Criteria andQrcodeUrlIsNull() {
      addCriterion("QRCODE_URL is null");
      return (Criteria) this;
    }

    public Criteria andQrcodeUrlIsNotNull() {
      addCriterion("QRCODE_URL is not null");
      return (Criteria) this;
    }

    public Criteria andQrcodeUrlEqualTo(String value) {
      addCriterion("QRCODE_URL =", value, "qrcodeUrl");
      return (Criteria) this;
    }

    public Criteria andQrcodeUrlNotEqualTo(String value) {
      addCriterion("QRCODE_URL <>", value, "qrcodeUrl");
      return (Criteria) this;
    }

    public Criteria andQrcodeUrlGreaterThan(String value) {
      addCriterion("QRCODE_URL >", value, "qrcodeUrl");
      return (Criteria) this;
    }

    public Criteria andQrcodeUrlGreaterThanOrEqualTo(String value) {
      addCriterion("QRCODE_URL >=", value, "qrcodeUrl");
      return (Criteria) this;
    }

    public Criteria andQrcodeUrlLessThan(String value) {
      addCriterion("QRCODE_URL <", value, "qrcodeUrl");
      return (Criteria) this;
    }

    public Criteria andQrcodeUrlLessThanOrEqualTo(String value) {
      addCriterion("QRCODE_URL <=", value, "qrcodeUrl");
      return (Criteria) this;
    }

    public Criteria andQrcodeUrlLike(String value) {
      addCriterion("QRCODE_URL like", value, "qrcodeUrl");
      return (Criteria) this;
    }

    public Criteria andQrcodeUrlNotLike(String value) {
      addCriterion("QRCODE_URL not like", value, "qrcodeUrl");
      return (Criteria) this;
    }

    public Criteria andQrcodeUrlIn(List<String> values) {
      addCriterion("QRCODE_URL in", values, "qrcodeUrl");
      return (Criteria) this;
    }

    public Criteria andQrcodeUrlNotIn(List<String> values) {
      addCriterion("QRCODE_URL not in", values, "qrcodeUrl");
      return (Criteria) this;
    }

    public Criteria andQrcodeUrlBetween(String value1, String value2) {
      addCriterion("QRCODE_URL between", value1, value2, "qrcodeUrl");
      return (Criteria) this;
    }

    public Criteria andQrcodeUrlNotBetween(String value1, String value2) {
      addCriterion("QRCODE_URL not between", value1, value2, "qrcodeUrl");
      return (Criteria) this;
    }

    public Criteria andLogoIsNull() {
      addCriterion("LOGO is null");
      return (Criteria) this;
    }

    public Criteria andLogoIsNotNull() {
      addCriterion("LOGO is not null");
      return (Criteria) this;
    }

    public Criteria andLogoEqualTo(String value) {
      addCriterion("LOGO =", value, "logo");
      return (Criteria) this;
    }

    public Criteria andLogoNotEqualTo(String value) {
      addCriterion("LOGO <>", value, "logo");
      return (Criteria) this;
    }

    public Criteria andLogoGreaterThan(String value) {
      addCriterion("LOGO >", value, "logo");
      return (Criteria) this;
    }

    public Criteria andLogoGreaterThanOrEqualTo(String value) {
      addCriterion("LOGO >=", value, "logo");
      return (Criteria) this;
    }

    public Criteria andLogoLessThan(String value) {
      addCriterion("LOGO <", value, "logo");
      return (Criteria) this;
    }

    public Criteria andLogoLessThanOrEqualTo(String value) {
      addCriterion("LOGO <=", value, "logo");
      return (Criteria) this;
    }

    public Criteria andLogoLike(String value) {
      addCriterion("LOGO like", value, "logo");
      return (Criteria) this;
    }

    public Criteria andLogoNotLike(String value) {
      addCriterion("LOGO not like", value, "logo");
      return (Criteria) this;
    }

    public Criteria andLogoIn(List<String> values) {
      addCriterion("LOGO in", values, "logo");
      return (Criteria) this;
    }

    public Criteria andLogoNotIn(List<String> values) {
      addCriterion("LOGO not in", values, "logo");
      return (Criteria) this;
    }

    public Criteria andLogoBetween(String value1, String value2) {
      addCriterion("LOGO between", value1, value2, "logo");
      return (Criteria) this;
    }

    public Criteria andLogoNotBetween(String value1, String value2) {
      addCriterion("LOGO not between", value1, value2, "logo");
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

    public Criteria andIsCrownIsNull() {
      addCriterion("IS_CROWN is null");
      return (Criteria) this;
    }

    public Criteria andIsCrownIsNotNull() {
      addCriterion("IS_CROWN is not null");
      return (Criteria) this;
    }

    public Criteria andIsCrownEqualTo(String value) {
      addCriterion("IS_CROWN =", value, "isCrown");
      return (Criteria) this;
    }

    public Criteria andIsCrownNotEqualTo(String value) {
      addCriterion("IS_CROWN <>", value, "isCrown");
      return (Criteria) this;
    }

    public Criteria andIsCrownGreaterThan(String value) {
      addCriterion("IS_CROWN >", value, "isCrown");
      return (Criteria) this;
    }

    public Criteria andIsCrownGreaterThanOrEqualTo(String value) {
      addCriterion("IS_CROWN >=", value, "isCrown");
      return (Criteria) this;
    }

    public Criteria andIsCrownLessThan(String value) {
      addCriterion("IS_CROWN <", value, "isCrown");
      return (Criteria) this;
    }

    public Criteria andIsCrownLessThanOrEqualTo(String value) {
      addCriterion("IS_CROWN <=", value, "isCrown");
      return (Criteria) this;
    }

    public Criteria andIsCrownLike(String value) {
      addCriterion("IS_CROWN like", value, "isCrown");
      return (Criteria) this;
    }

    public Criteria andIsCrownNotLike(String value) {
      addCriterion("IS_CROWN not like", value, "isCrown");
      return (Criteria) this;
    }

    public Criteria andIsCrownIn(List<String> values) {
      addCriterion("IS_CROWN in", values, "isCrown");
      return (Criteria) this;
    }

    public Criteria andIsCrownNotIn(List<String> values) {
      addCriterion("IS_CROWN not in", values, "isCrown");
      return (Criteria) this;
    }

    public Criteria andIsCrownBetween(String value1, String value2) {
      addCriterion("IS_CROWN between", value1, value2, "isCrown");
      return (Criteria) this;
    }

    public Criteria andIsCrownNotBetween(String value1, String value2) {
      addCriterion("IS_CROWN not between", value1, value2, "isCrown");
      return (Criteria) this;
    }

    public Criteria andIssendquanIsNull() {
      addCriterion("ISSENDQUAN is null");
      return (Criteria) this;
    }

    public Criteria andIssendquanIsNotNull() {
      addCriterion("ISSENDQUAN is not null");
      return (Criteria) this;
    }

    public Criteria andIssendquanEqualTo(String value) {
      addCriterion("ISSENDQUAN =", value, "issendquan");
      return (Criteria) this;
    }

    public Criteria andIssendquanNotEqualTo(String value) {
      addCriterion("ISSENDQUAN <>", value, "issendquan");
      return (Criteria) this;
    }

    public Criteria andIssendquanGreaterThan(String value) {
      addCriterion("ISSENDQUAN >", value, "issendquan");
      return (Criteria) this;
    }

    public Criteria andIssendquanGreaterThanOrEqualTo(String value) {
      addCriterion("ISSENDQUAN >=", value, "issendquan");
      return (Criteria) this;
    }

    public Criteria andIssendquanLessThan(String value) {
      addCriterion("ISSENDQUAN <", value, "issendquan");
      return (Criteria) this;
    }

    public Criteria andIssendquanLessThanOrEqualTo(String value) {
      addCriterion("ISSENDQUAN <=", value, "issendquan");
      return (Criteria) this;
    }

    public Criteria andIssendquanLike(String value) {
      addCriterion("ISSENDQUAN like", value, "issendquan");
      return (Criteria) this;
    }

    public Criteria andIssendquanNotLike(String value) {
      addCriterion("ISSENDQUAN not like", value, "issendquan");
      return (Criteria) this;
    }

    public Criteria andIssendquanIn(List<String> values) {
      addCriterion("ISSENDQUAN in", values, "issendquan");
      return (Criteria) this;
    }

    public Criteria andIssendquanNotIn(List<String> values) {
      addCriterion("ISSENDQUAN not in", values, "issendquan");
      return (Criteria) this;
    }

    public Criteria andIssendquanBetween(String value1, String value2) {
      addCriterion("ISSENDQUAN between", value1, value2, "issendquan");
      return (Criteria) this;
    }

    public Criteria andIssendquanNotBetween(String value1, String value2) {
      addCriterion("ISSENDQUAN not between", value1, value2, "issendquan");
      return (Criteria) this;
    }

    public Criteria andWxCouponIdIsNull() {
      addCriterion("WX_COUPON_ID is null");
      return (Criteria) this;
    }

    public Criteria andWxCouponIdIsNotNull() {
      addCriterion("WX_COUPON_ID is not null");
      return (Criteria) this;
    }

    public Criteria andWxCouponIdEqualTo(Long value) {
      addCriterion("WX_COUPON_ID =", value, "wxCouponId");
      return (Criteria) this;
    }

    public Criteria andWxCouponIdNotEqualTo(Long value) {
      addCriterion("WX_COUPON_ID <>", value, "wxCouponId");
      return (Criteria) this;
    }

    public Criteria andWxCouponIdGreaterThan(Long value) {
      addCriterion("WX_COUPON_ID >", value, "wxCouponId");
      return (Criteria) this;
    }

    public Criteria andWxCouponIdGreaterThanOrEqualTo(Long value) {
      addCriterion("WX_COUPON_ID >=", value, "wxCouponId");
      return (Criteria) this;
    }

    public Criteria andWxCouponIdLessThan(Long value) {
      addCriterion("WX_COUPON_ID <", value, "wxCouponId");
      return (Criteria) this;
    }

    public Criteria andWxCouponIdLessThanOrEqualTo(Long value) {
      addCriterion("WX_COUPON_ID <=", value, "wxCouponId");
      return (Criteria) this;
    }

    public Criteria andWxCouponIdIn(List<Long> values) {
      addCriterion("WX_COUPON_ID in", values, "wxCouponId");
      return (Criteria) this;
    }

    public Criteria andWxCouponIdNotIn(List<Long> values) {
      addCriterion("WX_COUPON_ID not in", values, "wxCouponId");
      return (Criteria) this;
    }

    public Criteria andWxCouponIdBetween(Long value1, Long value2) {
      addCriterion("WX_COUPON_ID between", value1, value2, "wxCouponId");
      return (Criteria) this;
    }

    public Criteria andWxCouponIdNotBetween(Long value1, Long value2) {
      addCriterion("WX_COUPON_ID not between", value1, value2, "wxCouponId");
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

    public Criteria andPostcodeIsNull() {
      addCriterion("POSTCODE is null");
      return (Criteria) this;
    }

    public Criteria andPostcodeIsNotNull() {
      addCriterion("POSTCODE is not null");
      return (Criteria) this;
    }

    public Criteria andPostcodeEqualTo(String value) {
      addCriterion("POSTCODE =", value, "postcode");
      return (Criteria) this;
    }

    public Criteria andPostcodeNotEqualTo(String value) {
      addCriterion("POSTCODE <>", value, "postcode");
      return (Criteria) this;
    }

    public Criteria andPostcodeGreaterThan(String value) {
      addCriterion("POSTCODE >", value, "postcode");
      return (Criteria) this;
    }

    public Criteria andPostcodeGreaterThanOrEqualTo(String value) {
      addCriterion("POSTCODE >=", value, "postcode");
      return (Criteria) this;
    }

    public Criteria andPostcodeLessThan(String value) {
      addCriterion("POSTCODE <", value, "postcode");
      return (Criteria) this;
    }

    public Criteria andPostcodeLessThanOrEqualTo(String value) {
      addCriterion("POSTCODE <=", value, "postcode");
      return (Criteria) this;
    }

    public Criteria andPostcodeLike(String value) {
      addCriterion("POSTCODE like", value, "postcode");
      return (Criteria) this;
    }

    public Criteria andPostcodeNotLike(String value) {
      addCriterion("POSTCODE not like", value, "postcode");
      return (Criteria) this;
    }

    public Criteria andPostcodeIn(List<String> values) {
      addCriterion("POSTCODE in", values, "postcode");
      return (Criteria) this;
    }

    public Criteria andPostcodeNotIn(List<String> values) {
      addCriterion("POSTCODE not in", values, "postcode");
      return (Criteria) this;
    }

    public Criteria andPostcodeBetween(String value1, String value2) {
      addCriterion("POSTCODE between", value1, value2, "postcode");
      return (Criteria) this;
    }

    public Criteria andPostcodeNotBetween(String value1, String value2) {
      addCriterion("POSTCODE not between", value1, value2, "postcode");
      return (Criteria) this;
    }

    public Criteria andErpStoreIdIsNull() {
      addCriterion("ERP_STORE_ID is null");
      return (Criteria) this;
    }

    public Criteria andErpStoreIdIsNotNull() {
      addCriterion("ERP_STORE_ID is not null");
      return (Criteria) this;
    }

    public Criteria andErpStoreIdEqualTo(String value) {
      addCriterion("ERP_STORE_ID =", value, "erpStoreId");
      return (Criteria) this;
    }

    public Criteria andErpStoreIdNotEqualTo(String value) {
      addCriterion("ERP_STORE_ID <>", value, "erpStoreId");
      return (Criteria) this;
    }

    public Criteria andErpStoreIdGreaterThan(String value) {
      addCriterion("ERP_STORE_ID >", value, "erpStoreId");
      return (Criteria) this;
    }

    public Criteria andErpStoreIdGreaterThanOrEqualTo(String value) {
      addCriterion("ERP_STORE_ID >=", value, "erpStoreId");
      return (Criteria) this;
    }

    public Criteria andErpStoreIdLessThan(String value) {
      addCriterion("ERP_STORE_ID <", value, "erpStoreId");
      return (Criteria) this;
    }

    public Criteria andErpStoreIdLessThanOrEqualTo(String value) {
      addCriterion("ERP_STORE_ID <=", value, "erpStoreId");
      return (Criteria) this;
    }

    public Criteria andErpStoreIdLike(String value) {
      addCriterion("ERP_STORE_ID like", value, "erpStoreId");
      return (Criteria) this;
    }

    public Criteria andErpStoreIdNotLike(String value) {
      addCriterion("ERP_STORE_ID not like", value, "erpStoreId");
      return (Criteria) this;
    }

    public Criteria andErpStoreIdIn(List<String> values) {
      addCriterion("ERP_STORE_ID in", values, "erpStoreId");
      return (Criteria) this;
    }

    public Criteria andErpStoreIdNotIn(List<String> values) {
      addCriterion("ERP_STORE_ID not in", values, "erpStoreId");
      return (Criteria) this;
    }

    public Criteria andErpStoreIdBetween(String value1, String value2) {
      addCriterion("ERP_STORE_ID between", value1, value2, "erpStoreId");
      return (Criteria) this;
    }

    public Criteria andErpStoreIdNotBetween(String value1, String value2) {
      addCriterion("ERP_STORE_ID not between", value1, value2, "erpStoreId");
      return (Criteria) this;
    }

    public Criteria andRegionIsNull() {
      addCriterion("REGION is null");
      return (Criteria) this;
    }

    public Criteria andRegionIsNotNull() {
      addCriterion("REGION is not null");
      return (Criteria) this;
    }

    public Criteria andRegionEqualTo(String value) {
      addCriterion("REGION =", value, "region");
      return (Criteria) this;
    }

    public Criteria andRegionNotEqualTo(String value) {
      addCriterion("REGION <>", value, "region");
      return (Criteria) this;
    }

    public Criteria andRegionGreaterThan(String value) {
      addCriterion("REGION >", value, "region");
      return (Criteria) this;
    }

    public Criteria andRegionGreaterThanOrEqualTo(String value) {
      addCriterion("REGION >=", value, "region");
      return (Criteria) this;
    }

    public Criteria andRegionLessThan(String value) {
      addCriterion("REGION <", value, "region");
      return (Criteria) this;
    }

    public Criteria andRegionLessThanOrEqualTo(String value) {
      addCriterion("REGION <=", value, "region");
      return (Criteria) this;
    }

    public Criteria andRegionLike(String value) {
      addCriterion("REGION like", value, "region");
      return (Criteria) this;
    }

    public Criteria andRegionNotLike(String value) {
      addCriterion("REGION not like", value, "region");
      return (Criteria) this;
    }

    public Criteria andRegionIn(List<String> values) {
      addCriterion("REGION in", values, "region");
      return (Criteria) this;
    }

    public Criteria andRegionNotIn(List<String> values) {
      addCriterion("REGION not in", values, "region");
      return (Criteria) this;
    }

    public Criteria andRegionBetween(String value1, String value2) {
      addCriterion("REGION between", value1, value2, "region");
      return (Criteria) this;
    }

    public Criteria andRegionNotBetween(String value1, String value2) {
      addCriterion("REGION not between", value1, value2, "region");
      return (Criteria) this;
    }

    public Criteria andIscloseIsNull() {
      addCriterion("ISCLOSE is null");
      return (Criteria) this;
    }

    public Criteria andIscloseIsNotNull() {
      addCriterion("ISCLOSE is not null");
      return (Criteria) this;
    }

    public Criteria andIscloseEqualTo(String value) {
      addCriterion("ISCLOSE =", value, "isclose");
      return (Criteria) this;
    }

    public Criteria andIscloseNotEqualTo(String value) {
      addCriterion("ISCLOSE <>", value, "isclose");
      return (Criteria) this;
    }

    public Criteria andIscloseGreaterThan(String value) {
      addCriterion("ISCLOSE >", value, "isclose");
      return (Criteria) this;
    }

    public Criteria andIscloseGreaterThanOrEqualTo(String value) {
      addCriterion("ISCLOSE >=", value, "isclose");
      return (Criteria) this;
    }

    public Criteria andIscloseLessThan(String value) {
      addCriterion("ISCLOSE <", value, "isclose");
      return (Criteria) this;
    }

    public Criteria andIscloseLessThanOrEqualTo(String value) {
      addCriterion("ISCLOSE <=", value, "isclose");
      return (Criteria) this;
    }

    public Criteria andIscloseLike(String value) {
      addCriterion("ISCLOSE like", value, "isclose");
      return (Criteria) this;
    }

    public Criteria andIscloseNotLike(String value) {
      addCriterion("ISCLOSE not like", value, "isclose");
      return (Criteria) this;
    }

    public Criteria andIscloseIn(List<String> values) {
      addCriterion("ISCLOSE in", values, "isclose");
      return (Criteria) this;
    }

    public Criteria andIscloseNotIn(List<String> values) {
      addCriterion("ISCLOSE not in", values, "isclose");
      return (Criteria) this;
    }

    public Criteria andIscloseBetween(String value1, String value2) {
      addCriterion("ISCLOSE between", value1, value2, "isclose");
      return (Criteria) this;
    }

    public Criteria andIscloseNotBetween(String value1, String value2) {
      addCriterion("ISCLOSE not between", value1, value2, "isclose");
      return (Criteria) this;
    }

    public Criteria andIsDefaultStoreIsNull() {
      addCriterion("IS_DEFAULT_STORE is null");
      return (Criteria) this;
    }

    public Criteria andIsDefaultStoreIsNotNull() {
      addCriterion("IS_DEFAULT_STORE is not null");
      return (Criteria) this;
    }

    public Criteria andIsDefaultStoreEqualTo(String value) {
      addCriterion("IS_DEFAULT_STORE =", value, "isDefaultStore");
      return (Criteria) this;
    }

    public Criteria andIsDefaultStoreNotEqualTo(String value) {
      addCriterion("IS_DEFAULT_STORE <>", value, "isDefaultStore");
      return (Criteria) this;
    }

    public Criteria andIsDefaultStoreGreaterThan(String value) {
      addCriterion("IS_DEFAULT_STORE >", value, "isDefaultStore");
      return (Criteria) this;
    }

    public Criteria andIsDefaultStoreGreaterThanOrEqualTo(String value) {
      addCriterion("IS_DEFAULT_STORE >=", value, "isDefaultStore");
      return (Criteria) this;
    }

    public Criteria andIsDefaultStoreLessThan(String value) {
      addCriterion("IS_DEFAULT_STORE <", value, "isDefaultStore");
      return (Criteria) this;
    }

    public Criteria andIsDefaultStoreLessThanOrEqualTo(String value) {
      addCriterion("IS_DEFAULT_STORE <=", value, "isDefaultStore");
      return (Criteria) this;
    }

    public Criteria andIsDefaultStoreLike(String value) {
      addCriterion("IS_DEFAULT_STORE like", value, "isDefaultStore");
      return (Criteria) this;
    }

    public Criteria andIsDefaultStoreNotLike(String value) {
      addCriterion("IS_DEFAULT_STORE not like", value, "isDefaultStore");
      return (Criteria) this;
    }

    public Criteria andIsDefaultStoreIn(List<String> values) {
      addCriterion("IS_DEFAULT_STORE in", values, "isDefaultStore");
      return (Criteria) this;
    }

    public Criteria andIsDefaultStoreNotIn(List<String> values) {
      addCriterion("IS_DEFAULT_STORE not in", values, "isDefaultStore");
      return (Criteria) this;
    }

    public Criteria andIsDefaultStoreBetween(String value1, String value2) {
      addCriterion("IS_DEFAULT_STORE between", value1, value2, "isDefaultStore");
      return (Criteria) this;
    }

    public Criteria andIsDefaultStoreNotBetween(String value1, String value2) {
      addCriterion("IS_DEFAULT_STORE not between", value1, value2, "isDefaultStore");
      return (Criteria) this;
    }

    public Criteria andStoreIdIsNull() {
      addCriterion("STORE_ID is null");
      return (Criteria) this;
    }

    public Criteria andStoreIdIsNotNull() {
      addCriterion("STORE_ID is not null");
      return (Criteria) this;
    }

    public Criteria andStoreIdEqualTo(String value) {
      addCriterion("STORE_ID =", value, "storeId");
      return (Criteria) this;
    }

    public Criteria andStoreIdNotEqualTo(String value) {
      addCriterion("STORE_ID <>", value, "storeId");
      return (Criteria) this;
    }

    public Criteria andStoreIdGreaterThan(String value) {
      addCriterion("STORE_ID >", value, "storeId");
      return (Criteria) this;
    }

    public Criteria andStoreIdGreaterThanOrEqualTo(String value) {
      addCriterion("STORE_ID >=", value, "storeId");
      return (Criteria) this;
    }

    public Criteria andStoreIdLessThan(String value) {
      addCriterion("STORE_ID <", value, "storeId");
      return (Criteria) this;
    }

    public Criteria andStoreIdLessThanOrEqualTo(String value) {
      addCriterion("STORE_ID <=", value, "storeId");
      return (Criteria) this;
    }

    public Criteria andStoreIdLike(String value) {
      addCriterion("STORE_ID like", value, "storeId");
      return (Criteria) this;
    }

    public Criteria andStoreIdNotLike(String value) {
      addCriterion("STORE_ID not like", value, "storeId");
      return (Criteria) this;
    }

    public Criteria andStoreIdIn(List<String> values) {
      addCriterion("STORE_ID in", values, "storeId");
      return (Criteria) this;
    }

    public Criteria andStoreIdNotIn(List<String> values) {
      addCriterion("STORE_ID not in", values, "storeId");
      return (Criteria) this;
    }

    public Criteria andStoreIdBetween(String value1, String value2) {
      addCriterion("STORE_ID between", value1, value2, "storeId");
      return (Criteria) this;
    }

    public Criteria andStoreIdNotBetween(String value1, String value2) {
      addCriterion("STORE_ID not between", value1, value2, "storeId");
      return (Criteria) this;
    }
  }

  /**
   * 只读. wx_store
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
     * This class corresponds to the database table wx_store
     *
     * @mbg.generated do_not_delete_during_merge 2018-07-07 16:03:38
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }
}