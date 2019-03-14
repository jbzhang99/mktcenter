package com.bizvane.messagefacade.models.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WxPublicPOExample implements Serializable {
    /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  protected String orderByClause;
  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  protected boolean distinct;
  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  protected List<Criteria> oredCriteria;
  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  private static final long serialVersionUID = 1L;

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public WxPublicPOExample() {
    oredCriteria = new ArrayList<Criteria>();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public void setOrderByClause(String orderByClause) {
    this.orderByClause = orderByClause;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public String getOrderByClause() {
    return orderByClause;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public void setDistinct(boolean distinct) {
    this.distinct = distinct;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public boolean isDistinct() {
    return distinct;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public List<Criteria> getOredCriteria() {
    return oredCriteria;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public void or(Criteria criteria) {
    oredCriteria.add(criteria);
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public Criteria or() {
    Criteria criteria = createCriteriaInternal();
    oredCriteria.add(criteria);
    return criteria;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
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
   * @mbg.generated  2018-07-14 14:12:10
   */
  protected Criteria createCriteriaInternal() {
    Criteria criteria = new Criteria();
    return criteria;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public void clear() {
    oredCriteria.clear();
    orderByClause = null;
    distinct = false;
  }

  /**
   * 只读. t_wx_public
   * @mbg.generated  2018-07-14 14:12:10
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

    public Criteria andAppidIsNull() {
      addCriterion("appid is null");
      return (Criteria) this;
    }

    public Criteria andAppidIsNotNull() {
      addCriterion("appid is not null");
      return (Criteria) this;
    }

    public Criteria andAppidEqualTo(String value) {
      addCriterion("appid =", value, "appid");
      return (Criteria) this;
    }

    public Criteria andAppidNotEqualTo(String value) {
      addCriterion("appid <>", value, "appid");
      return (Criteria) this;
    }

    public Criteria andAppidGreaterThan(String value) {
      addCriterion("appid >", value, "appid");
      return (Criteria) this;
    }

    public Criteria andAppidGreaterThanOrEqualTo(String value) {
      addCriterion("appid >=", value, "appid");
      return (Criteria) this;
    }

    public Criteria andAppidLessThan(String value) {
      addCriterion("appid <", value, "appid");
      return (Criteria) this;
    }

    public Criteria andAppidLessThanOrEqualTo(String value) {
      addCriterion("appid <=", value, "appid");
      return (Criteria) this;
    }

    public Criteria andAppidLike(String value) {
      addCriterion("appid like", value, "appid");
      return (Criteria) this;
    }

    public Criteria andAppidNotLike(String value) {
      addCriterion("appid not like", value, "appid");
      return (Criteria) this;
    }

    public Criteria andAppidIn(List<String> values) {
      addCriterion("appid in", values, "appid");
      return (Criteria) this;
    }

    public Criteria andAppidNotIn(List<String> values) {
      addCriterion("appid not in", values, "appid");
      return (Criteria) this;
    }

    public Criteria andAppidBetween(String value1, String value2) {
      addCriterion("appid between", value1, value2, "appid");
      return (Criteria) this;
    }

    public Criteria andAppidNotBetween(String value1, String value2) {
      addCriterion("appid not between", value1, value2, "appid");
      return (Criteria) this;
    }

    public Criteria andDomainIsNull() {
      addCriterion("domain is null");
      return (Criteria) this;
    }

    public Criteria andDomainIsNotNull() {
      addCriterion("domain is not null");
      return (Criteria) this;
    }

    public Criteria andDomainEqualTo(String value) {
      addCriterion("domain =", value, "domain");
      return (Criteria) this;
    }

    public Criteria andDomainNotEqualTo(String value) {
      addCriterion("domain <>", value, "domain");
      return (Criteria) this;
    }

    public Criteria andDomainGreaterThan(String value) {
      addCriterion("domain >", value, "domain");
      return (Criteria) this;
    }

    public Criteria andDomainGreaterThanOrEqualTo(String value) {
      addCriterion("domain >=", value, "domain");
      return (Criteria) this;
    }

    public Criteria andDomainLessThan(String value) {
      addCriterion("domain <", value, "domain");
      return (Criteria) this;
    }

    public Criteria andDomainLessThanOrEqualTo(String value) {
      addCriterion("domain <=", value, "domain");
      return (Criteria) this;
    }

    public Criteria andDomainLike(String value) {
      addCriterion("domain like", value, "domain");
      return (Criteria) this;
    }

    public Criteria andDomainNotLike(String value) {
      addCriterion("domain not like", value, "domain");
      return (Criteria) this;
    }

    public Criteria andDomainIn(List<String> values) {
      addCriterion("domain in", values, "domain");
      return (Criteria) this;
    }

    public Criteria andDomainNotIn(List<String> values) {
      addCriterion("domain not in", values, "domain");
      return (Criteria) this;
    }

    public Criteria andDomainBetween(String value1, String value2) {
      addCriterion("domain between", value1, value2, "domain");
      return (Criteria) this;
    }

    public Criteria andDomainNotBetween(String value1, String value2) {
      addCriterion("domain not between", value1, value2, "domain");
      return (Criteria) this;
    }

    public Criteria andWxqrcodeurlIsNull() {
      addCriterion("wxqrcodeurl is null");
      return (Criteria) this;
    }

    public Criteria andWxqrcodeurlIsNotNull() {
      addCriterion("wxqrcodeurl is not null");
      return (Criteria) this;
    }

    public Criteria andWxqrcodeurlEqualTo(String value) {
      addCriterion("wxqrcodeurl =", value, "wxqrcodeurl");
      return (Criteria) this;
    }

    public Criteria andWxqrcodeurlNotEqualTo(String value) {
      addCriterion("wxqrcodeurl <>", value, "wxqrcodeurl");
      return (Criteria) this;
    }

    public Criteria andWxqrcodeurlGreaterThan(String value) {
      addCriterion("wxqrcodeurl >", value, "wxqrcodeurl");
      return (Criteria) this;
    }

    public Criteria andWxqrcodeurlGreaterThanOrEqualTo(String value) {
      addCriterion("wxqrcodeurl >=", value, "wxqrcodeurl");
      return (Criteria) this;
    }

    public Criteria andWxqrcodeurlLessThan(String value) {
      addCriterion("wxqrcodeurl <", value, "wxqrcodeurl");
      return (Criteria) this;
    }

    public Criteria andWxqrcodeurlLessThanOrEqualTo(String value) {
      addCriterion("wxqrcodeurl <=", value, "wxqrcodeurl");
      return (Criteria) this;
    }

    public Criteria andWxqrcodeurlLike(String value) {
      addCriterion("wxqrcodeurl like", value, "wxqrcodeurl");
      return (Criteria) this;
    }

    public Criteria andWxqrcodeurlNotLike(String value) {
      addCriterion("wxqrcodeurl not like", value, "wxqrcodeurl");
      return (Criteria) this;
    }

    public Criteria andWxqrcodeurlIn(List<String> values) {
      addCriterion("wxqrcodeurl in", values, "wxqrcodeurl");
      return (Criteria) this;
    }

    public Criteria andWxqrcodeurlNotIn(List<String> values) {
      addCriterion("wxqrcodeurl not in", values, "wxqrcodeurl");
      return (Criteria) this;
    }

    public Criteria andWxqrcodeurlBetween(String value1, String value2) {
      addCriterion("wxqrcodeurl between", value1, value2, "wxqrcodeurl");
      return (Criteria) this;
    }

    public Criteria andWxqrcodeurlNotBetween(String value1, String value2) {
      addCriterion("wxqrcodeurl not between", value1, value2, "wxqrcodeurl");
      return (Criteria) this;
    }

    public Criteria andNickIsNull() {
      addCriterion("nick is null");
      return (Criteria) this;
    }

    public Criteria andNickIsNotNull() {
      addCriterion("nick is not null");
      return (Criteria) this;
    }

    public Criteria andNickEqualTo(String value) {
      addCriterion("nick =", value, "nick");
      return (Criteria) this;
    }

    public Criteria andNickNotEqualTo(String value) {
      addCriterion("nick <>", value, "nick");
      return (Criteria) this;
    }

    public Criteria andNickGreaterThan(String value) {
      addCriterion("nick >", value, "nick");
      return (Criteria) this;
    }

    public Criteria andNickGreaterThanOrEqualTo(String value) {
      addCriterion("nick >=", value, "nick");
      return (Criteria) this;
    }

    public Criteria andNickLessThan(String value) {
      addCriterion("nick <", value, "nick");
      return (Criteria) this;
    }

    public Criteria andNickLessThanOrEqualTo(String value) {
      addCriterion("nick <=", value, "nick");
      return (Criteria) this;
    }

    public Criteria andNickLike(String value) {
      addCriterion("nick like", value, "nick");
      return (Criteria) this;
    }

    public Criteria andNickNotLike(String value) {
      addCriterion("nick not like", value, "nick");
      return (Criteria) this;
    }

    public Criteria andNickIn(List<String> values) {
      addCriterion("nick in", values, "nick");
      return (Criteria) this;
    }

    public Criteria andNickNotIn(List<String> values) {
      addCriterion("nick not in", values, "nick");
      return (Criteria) this;
    }

    public Criteria andNickBetween(String value1, String value2) {
      addCriterion("nick between", value1, value2, "nick");
      return (Criteria) this;
    }

    public Criteria andNickNotBetween(String value1, String value2) {
      addCriterion("nick not between", value1, value2, "nick");
      return (Criteria) this;
    }

    public Criteria andHeadimgIsNull() {
      addCriterion("headimg is null");
      return (Criteria) this;
    }

    public Criteria andHeadimgIsNotNull() {
      addCriterion("headimg is not null");
      return (Criteria) this;
    }

    public Criteria andHeadimgEqualTo(String value) {
      addCriterion("headimg =", value, "headimg");
      return (Criteria) this;
    }

    public Criteria andHeadimgNotEqualTo(String value) {
      addCriterion("headimg <>", value, "headimg");
      return (Criteria) this;
    }

    public Criteria andHeadimgGreaterThan(String value) {
      addCriterion("headimg >", value, "headimg");
      return (Criteria) this;
    }

    public Criteria andHeadimgGreaterThanOrEqualTo(String value) {
      addCriterion("headimg >=", value, "headimg");
      return (Criteria) this;
    }

    public Criteria andHeadimgLessThan(String value) {
      addCriterion("headimg <", value, "headimg");
      return (Criteria) this;
    }

    public Criteria andHeadimgLessThanOrEqualTo(String value) {
      addCriterion("headimg <=", value, "headimg");
      return (Criteria) this;
    }

    public Criteria andHeadimgLike(String value) {
      addCriterion("headimg like", value, "headimg");
      return (Criteria) this;
    }

    public Criteria andHeadimgNotLike(String value) {
      addCriterion("headimg not like", value, "headimg");
      return (Criteria) this;
    }

    public Criteria andHeadimgIn(List<String> values) {
      addCriterion("headimg in", values, "headimg");
      return (Criteria) this;
    }

    public Criteria andHeadimgNotIn(List<String> values) {
      addCriterion("headimg not in", values, "headimg");
      return (Criteria) this;
    }

    public Criteria andHeadimgBetween(String value1, String value2) {
      addCriterion("headimg between", value1, value2, "headimg");
      return (Criteria) this;
    }

    public Criteria andHeadimgNotBetween(String value1, String value2) {
      addCriterion("headimg not between", value1, value2, "headimg");
      return (Criteria) this;
    }

    public Criteria andTypeinfoIsNull() {
      addCriterion("typeinfo is null");
      return (Criteria) this;
    }

    public Criteria andTypeinfoIsNotNull() {
      addCriterion("typeinfo is not null");
      return (Criteria) this;
    }

    public Criteria andTypeinfoEqualTo(String value) {
      addCriterion("typeinfo =", value, "typeinfo");
      return (Criteria) this;
    }

    public Criteria andTypeinfoNotEqualTo(String value) {
      addCriterion("typeinfo <>", value, "typeinfo");
      return (Criteria) this;
    }

    public Criteria andTypeinfoGreaterThan(String value) {
      addCriterion("typeinfo >", value, "typeinfo");
      return (Criteria) this;
    }

    public Criteria andTypeinfoGreaterThanOrEqualTo(String value) {
      addCriterion("typeinfo >=", value, "typeinfo");
      return (Criteria) this;
    }

    public Criteria andTypeinfoLessThan(String value) {
      addCriterion("typeinfo <", value, "typeinfo");
      return (Criteria) this;
    }

    public Criteria andTypeinfoLessThanOrEqualTo(String value) {
      addCriterion("typeinfo <=", value, "typeinfo");
      return (Criteria) this;
    }

    public Criteria andTypeinfoLike(String value) {
      addCriterion("typeinfo like", value, "typeinfo");
      return (Criteria) this;
    }

    public Criteria andTypeinfoNotLike(String value) {
      addCriterion("typeinfo not like", value, "typeinfo");
      return (Criteria) this;
    }

    public Criteria andTypeinfoIn(List<String> values) {
      addCriterion("typeinfo in", values, "typeinfo");
      return (Criteria) this;
    }

    public Criteria andTypeinfoNotIn(List<String> values) {
      addCriterion("typeinfo not in", values, "typeinfo");
      return (Criteria) this;
    }

    public Criteria andTypeinfoBetween(String value1, String value2) {
      addCriterion("typeinfo between", value1, value2, "typeinfo");
      return (Criteria) this;
    }

    public Criteria andTypeinfoNotBetween(String value1, String value2) {
      addCriterion("typeinfo not between", value1, value2, "typeinfo");
      return (Criteria) this;
    }

    public Criteria andVerifytypeIsNull() {
      addCriterion("verifytype is null");
      return (Criteria) this;
    }

    public Criteria andVerifytypeIsNotNull() {
      addCriterion("verifytype is not null");
      return (Criteria) this;
    }

    public Criteria andVerifytypeEqualTo(String value) {
      addCriterion("verifytype =", value, "verifytype");
      return (Criteria) this;
    }

    public Criteria andVerifytypeNotEqualTo(String value) {
      addCriterion("verifytype <>", value, "verifytype");
      return (Criteria) this;
    }

    public Criteria andVerifytypeGreaterThan(String value) {
      addCriterion("verifytype >", value, "verifytype");
      return (Criteria) this;
    }

    public Criteria andVerifytypeGreaterThanOrEqualTo(String value) {
      addCriterion("verifytype >=", value, "verifytype");
      return (Criteria) this;
    }

    public Criteria andVerifytypeLessThan(String value) {
      addCriterion("verifytype <", value, "verifytype");
      return (Criteria) this;
    }

    public Criteria andVerifytypeLessThanOrEqualTo(String value) {
      addCriterion("verifytype <=", value, "verifytype");
      return (Criteria) this;
    }

    public Criteria andVerifytypeLike(String value) {
      addCriterion("verifytype like", value, "verifytype");
      return (Criteria) this;
    }

    public Criteria andVerifytypeNotLike(String value) {
      addCriterion("verifytype not like", value, "verifytype");
      return (Criteria) this;
    }

    public Criteria andVerifytypeIn(List<String> values) {
      addCriterion("verifytype in", values, "verifytype");
      return (Criteria) this;
    }

    public Criteria andVerifytypeNotIn(List<String> values) {
      addCriterion("verifytype not in", values, "verifytype");
      return (Criteria) this;
    }

    public Criteria andVerifytypeBetween(String value1, String value2) {
      addCriterion("verifytype between", value1, value2, "verifytype");
      return (Criteria) this;
    }

    public Criteria andVerifytypeNotBetween(String value1, String value2) {
      addCriterion("verifytype not between", value1, value2, "verifytype");
      return (Criteria) this;
    }

    public Criteria andCodeIsNull() {
      addCriterion("code is null");
      return (Criteria) this;
    }

    public Criteria andCodeIsNotNull() {
      addCriterion("code is not null");
      return (Criteria) this;
    }

    public Criteria andCodeEqualTo(String value) {
      addCriterion("code =", value, "code");
      return (Criteria) this;
    }

    public Criteria andCodeNotEqualTo(String value) {
      addCriterion("code <>", value, "code");
      return (Criteria) this;
    }

    public Criteria andCodeGreaterThan(String value) {
      addCriterion("code >", value, "code");
      return (Criteria) this;
    }

    public Criteria andCodeGreaterThanOrEqualTo(String value) {
      addCriterion("code >=", value, "code");
      return (Criteria) this;
    }

    public Criteria andCodeLessThan(String value) {
      addCriterion("code <", value, "code");
      return (Criteria) this;
    }

    public Criteria andCodeLessThanOrEqualTo(String value) {
      addCriterion("code <=", value, "code");
      return (Criteria) this;
    }

    public Criteria andCodeLike(String value) {
      addCriterion("code like", value, "code");
      return (Criteria) this;
    }

    public Criteria andCodeNotLike(String value) {
      addCriterion("code not like", value, "code");
      return (Criteria) this;
    }

    public Criteria andCodeIn(List<String> values) {
      addCriterion("code in", values, "code");
      return (Criteria) this;
    }

    public Criteria andCodeNotIn(List<String> values) {
      addCriterion("code not in", values, "code");
      return (Criteria) this;
    }

    public Criteria andCodeBetween(String value1, String value2) {
      addCriterion("code between", value1, value2, "code");
      return (Criteria) this;
    }

    public Criteria andCodeNotBetween(String value1, String value2) {
      addCriterion("code not between", value1, value2, "code");
      return (Criteria) this;
    }

    public Criteria andOriginidIsNull() {
      addCriterion("originid is null");
      return (Criteria) this;
    }

    public Criteria andOriginidIsNotNull() {
      addCriterion("originid is not null");
      return (Criteria) this;
    }

    public Criteria andOriginidEqualTo(String value) {
      addCriterion("originid =", value, "originid");
      return (Criteria) this;
    }

    public Criteria andOriginidNotEqualTo(String value) {
      addCriterion("originid <>", value, "originid");
      return (Criteria) this;
    }

    public Criteria andOriginidGreaterThan(String value) {
      addCriterion("originid >", value, "originid");
      return (Criteria) this;
    }

    public Criteria andOriginidGreaterThanOrEqualTo(String value) {
      addCriterion("originid >=", value, "originid");
      return (Criteria) this;
    }

    public Criteria andOriginidLessThan(String value) {
      addCriterion("originid <", value, "originid");
      return (Criteria) this;
    }

    public Criteria andOriginidLessThanOrEqualTo(String value) {
      addCriterion("originid <=", value, "originid");
      return (Criteria) this;
    }

    public Criteria andOriginidLike(String value) {
      addCriterion("originid like", value, "originid");
      return (Criteria) this;
    }

    public Criteria andOriginidNotLike(String value) {
      addCriterion("originid not like", value, "originid");
      return (Criteria) this;
    }

    public Criteria andOriginidIn(List<String> values) {
      addCriterion("originid in", values, "originid");
      return (Criteria) this;
    }

    public Criteria andOriginidNotIn(List<String> values) {
      addCriterion("originid not in", values, "originid");
      return (Criteria) this;
    }

    public Criteria andOriginidBetween(String value1, String value2) {
      addCriterion("originid between", value1, value2, "originid");
      return (Criteria) this;
    }

    public Criteria andOriginidNotBetween(String value1, String value2) {
      addCriterion("originid not between", value1, value2, "originid");
      return (Criteria) this;
    }

    public Criteria andQrcodeurlIsNull() {
      addCriterion("qrcodeurl is null");
      return (Criteria) this;
    }

    public Criteria andQrcodeurlIsNotNull() {
      addCriterion("qrcodeurl is not null");
      return (Criteria) this;
    }

    public Criteria andQrcodeurlEqualTo(String value) {
      addCriterion("qrcodeurl =", value, "qrcodeurl");
      return (Criteria) this;
    }

    public Criteria andQrcodeurlNotEqualTo(String value) {
      addCriterion("qrcodeurl <>", value, "qrcodeurl");
      return (Criteria) this;
    }

    public Criteria andQrcodeurlGreaterThan(String value) {
      addCriterion("qrcodeurl >", value, "qrcodeurl");
      return (Criteria) this;
    }

    public Criteria andQrcodeurlGreaterThanOrEqualTo(String value) {
      addCriterion("qrcodeurl >=", value, "qrcodeurl");
      return (Criteria) this;
    }

    public Criteria andQrcodeurlLessThan(String value) {
      addCriterion("qrcodeurl <", value, "qrcodeurl");
      return (Criteria) this;
    }

    public Criteria andQrcodeurlLessThanOrEqualTo(String value) {
      addCriterion("qrcodeurl <=", value, "qrcodeurl");
      return (Criteria) this;
    }

    public Criteria andQrcodeurlLike(String value) {
      addCriterion("qrcodeurl like", value, "qrcodeurl");
      return (Criteria) this;
    }

    public Criteria andQrcodeurlNotLike(String value) {
      addCriterion("qrcodeurl not like", value, "qrcodeurl");
      return (Criteria) this;
    }

    public Criteria andQrcodeurlIn(List<String> values) {
      addCriterion("qrcodeurl in", values, "qrcodeurl");
      return (Criteria) this;
    }

    public Criteria andQrcodeurlNotIn(List<String> values) {
      addCriterion("qrcodeurl not in", values, "qrcodeurl");
      return (Criteria) this;
    }

    public Criteria andQrcodeurlBetween(String value1, String value2) {
      addCriterion("qrcodeurl between", value1, value2, "qrcodeurl");
      return (Criteria) this;
    }

    public Criteria andQrcodeurlNotBetween(String value1, String value2) {
      addCriterion("qrcodeurl not between", value1, value2, "qrcodeurl");
      return (Criteria) this;
    }

    public Criteria andAuthorizerRefreshTokenIsNull() {
      addCriterion("authorizer_refresh_token is null");
      return (Criteria) this;
    }

    public Criteria andAuthorizerRefreshTokenIsNotNull() {
      addCriterion("authorizer_refresh_token is not null");
      return (Criteria) this;
    }

    public Criteria andAuthorizerRefreshTokenEqualTo(String value) {
      addCriterion("authorizer_refresh_token =", value, "authorizerRefreshToken");
      return (Criteria) this;
    }

    public Criteria andAuthorizerRefreshTokenNotEqualTo(String value) {
      addCriterion("authorizer_refresh_token <>", value, "authorizerRefreshToken");
      return (Criteria) this;
    }

    public Criteria andAuthorizerRefreshTokenGreaterThan(String value) {
      addCriterion("authorizer_refresh_token >", value, "authorizerRefreshToken");
      return (Criteria) this;
    }

    public Criteria andAuthorizerRefreshTokenGreaterThanOrEqualTo(String value) {
      addCriterion("authorizer_refresh_token >=", value, "authorizerRefreshToken");
      return (Criteria) this;
    }

    public Criteria andAuthorizerRefreshTokenLessThan(String value) {
      addCriterion("authorizer_refresh_token <", value, "authorizerRefreshToken");
      return (Criteria) this;
    }

    public Criteria andAuthorizerRefreshTokenLessThanOrEqualTo(String value) {
      addCriterion("authorizer_refresh_token <=", value, "authorizerRefreshToken");
      return (Criteria) this;
    }

    public Criteria andAuthorizerRefreshTokenLike(String value) {
      addCriterion("authorizer_refresh_token like", value, "authorizerRefreshToken");
      return (Criteria) this;
    }

    public Criteria andAuthorizerRefreshTokenNotLike(String value) {
      addCriterion("authorizer_refresh_token not like", value, "authorizerRefreshToken");
      return (Criteria) this;
    }

    public Criteria andAuthorizerRefreshTokenIn(List<String> values) {
      addCriterion("authorizer_refresh_token in", values, "authorizerRefreshToken");
      return (Criteria) this;
    }

    public Criteria andAuthorizerRefreshTokenNotIn(List<String> values) {
      addCriterion("authorizer_refresh_token not in", values, "authorizerRefreshToken");
      return (Criteria) this;
    }

    public Criteria andAuthorizerRefreshTokenBetween(String value1, String value2) {
      addCriterion("authorizer_refresh_token between", value1, value2, "authorizerRefreshToken");
      return (Criteria) this;
    }

    public Criteria andAuthorizerRefreshTokenNotBetween(String value1, String value2) {
      addCriterion("authorizer_refresh_token not between", value1, value2, "authorizerRefreshToken");
      return (Criteria) this;
    }

    public Criteria andAuthorizerAccessTokenIsNull() {
      addCriterion("authorizer_access_token is null");
      return (Criteria) this;
    }

    public Criteria andAuthorizerAccessTokenIsNotNull() {
      addCriterion("authorizer_access_token is not null");
      return (Criteria) this;
    }

    public Criteria andAuthorizerAccessTokenEqualTo(String value) {
      addCriterion("authorizer_access_token =", value, "authorizerAccessToken");
      return (Criteria) this;
    }

    public Criteria andAuthorizerAccessTokenNotEqualTo(String value) {
      addCriterion("authorizer_access_token <>", value, "authorizerAccessToken");
      return (Criteria) this;
    }

    public Criteria andAuthorizerAccessTokenGreaterThan(String value) {
      addCriterion("authorizer_access_token >", value, "authorizerAccessToken");
      return (Criteria) this;
    }

    public Criteria andAuthorizerAccessTokenGreaterThanOrEqualTo(String value) {
      addCriterion("authorizer_access_token >=", value, "authorizerAccessToken");
      return (Criteria) this;
    }

    public Criteria andAuthorizerAccessTokenLessThan(String value) {
      addCriterion("authorizer_access_token <", value, "authorizerAccessToken");
      return (Criteria) this;
    }

    public Criteria andAuthorizerAccessTokenLessThanOrEqualTo(String value) {
      addCriterion("authorizer_access_token <=", value, "authorizerAccessToken");
      return (Criteria) this;
    }

    public Criteria andAuthorizerAccessTokenLike(String value) {
      addCriterion("authorizer_access_token like", value, "authorizerAccessToken");
      return (Criteria) this;
    }

    public Criteria andAuthorizerAccessTokenNotLike(String value) {
      addCriterion("authorizer_access_token not like", value, "authorizerAccessToken");
      return (Criteria) this;
    }

    public Criteria andAuthorizerAccessTokenIn(List<String> values) {
      addCriterion("authorizer_access_token in", values, "authorizerAccessToken");
      return (Criteria) this;
    }

    public Criteria andAuthorizerAccessTokenNotIn(List<String> values) {
      addCriterion("authorizer_access_token not in", values, "authorizerAccessToken");
      return (Criteria) this;
    }

    public Criteria andAuthorizerAccessTokenBetween(String value1, String value2) {
      addCriterion("authorizer_access_token between", value1, value2, "authorizerAccessToken");
      return (Criteria) this;
    }

    public Criteria andAuthorizerAccessTokenNotBetween(String value1, String value2) {
      addCriterion("authorizer_access_token not between", value1, value2, "authorizerAccessToken");
      return (Criteria) this;
    }

    public Criteria andAattimeIsNull() {
      addCriterion("aattime is null");
      return (Criteria) this;
    }

    public Criteria andAattimeIsNotNull() {
      addCriterion("aattime is not null");
      return (Criteria) this;
    }

    public Criteria andAattimeEqualTo(Long value) {
      addCriterion("aattime =", value, "aattime");
      return (Criteria) this;
    }

    public Criteria andAattimeNotEqualTo(Long value) {
      addCriterion("aattime <>", value, "aattime");
      return (Criteria) this;
    }

    public Criteria andAattimeGreaterThan(Long value) {
      addCriterion("aattime >", value, "aattime");
      return (Criteria) this;
    }

    public Criteria andAattimeGreaterThanOrEqualTo(Long value) {
      addCriterion("aattime >=", value, "aattime");
      return (Criteria) this;
    }

    public Criteria andAattimeLessThan(Long value) {
      addCriterion("aattime <", value, "aattime");
      return (Criteria) this;
    }

    public Criteria andAattimeLessThanOrEqualTo(Long value) {
      addCriterion("aattime <=", value, "aattime");
      return (Criteria) this;
    }

    public Criteria andAattimeIn(List<Long> values) {
      addCriterion("aattime in", values, "aattime");
      return (Criteria) this;
    }

    public Criteria andAattimeNotIn(List<Long> values) {
      addCriterion("aattime not in", values, "aattime");
      return (Criteria) this;
    }

    public Criteria andAattimeBetween(Long value1, Long value2) {
      addCriterion("aattime between", value1, value2, "aattime");
      return (Criteria) this;
    }

    public Criteria andAattimeNotBetween(Long value1, Long value2) {
      addCriterion("aattime not between", value1, value2, "aattime");
      return (Criteria) this;
    }

    public Criteria andJssdkAccessTokenIsNull() {
      addCriterion("jssdk_access_token is null");
      return (Criteria) this;
    }

    public Criteria andJssdkAccessTokenIsNotNull() {
      addCriterion("jssdk_access_token is not null");
      return (Criteria) this;
    }

    public Criteria andJssdkAccessTokenEqualTo(String value) {
      addCriterion("jssdk_access_token =", value, "jssdkAccessToken");
      return (Criteria) this;
    }

    public Criteria andJssdkAccessTokenNotEqualTo(String value) {
      addCriterion("jssdk_access_token <>", value, "jssdkAccessToken");
      return (Criteria) this;
    }

    public Criteria andJssdkAccessTokenGreaterThan(String value) {
      addCriterion("jssdk_access_token >", value, "jssdkAccessToken");
      return (Criteria) this;
    }

    public Criteria andJssdkAccessTokenGreaterThanOrEqualTo(String value) {
      addCriterion("jssdk_access_token >=", value, "jssdkAccessToken");
      return (Criteria) this;
    }

    public Criteria andJssdkAccessTokenLessThan(String value) {
      addCriterion("jssdk_access_token <", value, "jssdkAccessToken");
      return (Criteria) this;
    }

    public Criteria andJssdkAccessTokenLessThanOrEqualTo(String value) {
      addCriterion("jssdk_access_token <=", value, "jssdkAccessToken");
      return (Criteria) this;
    }

    public Criteria andJssdkAccessTokenLike(String value) {
      addCriterion("jssdk_access_token like", value, "jssdkAccessToken");
      return (Criteria) this;
    }

    public Criteria andJssdkAccessTokenNotLike(String value) {
      addCriterion("jssdk_access_token not like", value, "jssdkAccessToken");
      return (Criteria) this;
    }

    public Criteria andJssdkAccessTokenIn(List<String> values) {
      addCriterion("jssdk_access_token in", values, "jssdkAccessToken");
      return (Criteria) this;
    }

    public Criteria andJssdkAccessTokenNotIn(List<String> values) {
      addCriterion("jssdk_access_token not in", values, "jssdkAccessToken");
      return (Criteria) this;
    }

    public Criteria andJssdkAccessTokenBetween(String value1, String value2) {
      addCriterion("jssdk_access_token between", value1, value2, "jssdkAccessToken");
      return (Criteria) this;
    }

    public Criteria andJssdkAccessTokenNotBetween(String value1, String value2) {
      addCriterion("jssdk_access_token not between", value1, value2, "jssdkAccessToken");
      return (Criteria) this;
    }

    public Criteria andJattimeIsNull() {
      addCriterion("jattime is null");
      return (Criteria) this;
    }

    public Criteria andJattimeIsNotNull() {
      addCriterion("jattime is not null");
      return (Criteria) this;
    }

    public Criteria andJattimeEqualTo(Long value) {
      addCriterion("jattime =", value, "jattime");
      return (Criteria) this;
    }

    public Criteria andJattimeNotEqualTo(Long value) {
      addCriterion("jattime <>", value, "jattime");
      return (Criteria) this;
    }

    public Criteria andJattimeGreaterThan(Long value) {
      addCriterion("jattime >", value, "jattime");
      return (Criteria) this;
    }

    public Criteria andJattimeGreaterThanOrEqualTo(Long value) {
      addCriterion("jattime >=", value, "jattime");
      return (Criteria) this;
    }

    public Criteria andJattimeLessThan(Long value) {
      addCriterion("jattime <", value, "jattime");
      return (Criteria) this;
    }

    public Criteria andJattimeLessThanOrEqualTo(Long value) {
      addCriterion("jattime <=", value, "jattime");
      return (Criteria) this;
    }

    public Criteria andJattimeIn(List<Long> values) {
      addCriterion("jattime in", values, "jattime");
      return (Criteria) this;
    }

    public Criteria andJattimeNotIn(List<Long> values) {
      addCriterion("jattime not in", values, "jattime");
      return (Criteria) this;
    }

    public Criteria andJattimeBetween(Long value1, Long value2) {
      addCriterion("jattime between", value1, value2, "jattime");
      return (Criteria) this;
    }

    public Criteria andJattimeNotBetween(Long value1, Long value2) {
      addCriterion("jattime not between", value1, value2, "jattime");
      return (Criteria) this;
    }

    public Criteria andPublicpartyappidIsNull() {
      addCriterion("publicpartyappid is null");
      return (Criteria) this;
    }

    public Criteria andPublicpartyappidIsNotNull() {
      addCriterion("publicpartyappid is not null");
      return (Criteria) this;
    }

    public Criteria andPublicpartyappidEqualTo(String value) {
      addCriterion("publicpartyappid =", value, "publicpartyappid");
      return (Criteria) this;
    }

    public Criteria andPublicpartyappidNotEqualTo(String value) {
      addCriterion("publicpartyappid <>", value, "publicpartyappid");
      return (Criteria) this;
    }

    public Criteria andPublicpartyappidGreaterThan(String value) {
      addCriterion("publicpartyappid >", value, "publicpartyappid");
      return (Criteria) this;
    }

    public Criteria andPublicpartyappidGreaterThanOrEqualTo(String value) {
      addCriterion("publicpartyappid >=", value, "publicpartyappid");
      return (Criteria) this;
    }

    public Criteria andPublicpartyappidLessThan(String value) {
      addCriterion("publicpartyappid <", value, "publicpartyappid");
      return (Criteria) this;
    }

    public Criteria andPublicpartyappidLessThanOrEqualTo(String value) {
      addCriterion("publicpartyappid <=", value, "publicpartyappid");
      return (Criteria) this;
    }

    public Criteria andPublicpartyappidLike(String value) {
      addCriterion("publicpartyappid like", value, "publicpartyappid");
      return (Criteria) this;
    }

    public Criteria andPublicpartyappidNotLike(String value) {
      addCriterion("publicpartyappid not like", value, "publicpartyappid");
      return (Criteria) this;
    }

    public Criteria andPublicpartyappidIn(List<String> values) {
      addCriterion("publicpartyappid in", values, "publicpartyappid");
      return (Criteria) this;
    }

    public Criteria andPublicpartyappidNotIn(List<String> values) {
      addCriterion("publicpartyappid not in", values, "publicpartyappid");
      return (Criteria) this;
    }

    public Criteria andPublicpartyappidBetween(String value1, String value2) {
      addCriterion("publicpartyappid between", value1, value2, "publicpartyappid");
      return (Criteria) this;
    }

    public Criteria andPublicpartyappidNotBetween(String value1, String value2) {
      addCriterion("publicpartyappid not between", value1, value2, "publicpartyappid");
      return (Criteria) this;
    }

    public Criteria andIsconnectIsNull() {
      addCriterion("isconnect is null");
      return (Criteria) this;
    }

    public Criteria andIsconnectIsNotNull() {
      addCriterion("isconnect is not null");
      return (Criteria) this;
    }

    public Criteria andIsconnectEqualTo(String value) {
      addCriterion("isconnect =", value, "isconnect");
      return (Criteria) this;
    }

    public Criteria andIsconnectNotEqualTo(String value) {
      addCriterion("isconnect <>", value, "isconnect");
      return (Criteria) this;
    }

    public Criteria andIsconnectGreaterThan(String value) {
      addCriterion("isconnect >", value, "isconnect");
      return (Criteria) this;
    }

    public Criteria andIsconnectGreaterThanOrEqualTo(String value) {
      addCriterion("isconnect >=", value, "isconnect");
      return (Criteria) this;
    }

    public Criteria andIsconnectLessThan(String value) {
      addCriterion("isconnect <", value, "isconnect");
      return (Criteria) this;
    }

    public Criteria andIsconnectLessThanOrEqualTo(String value) {
      addCriterion("isconnect <=", value, "isconnect");
      return (Criteria) this;
    }

    public Criteria andIsconnectLike(String value) {
      addCriterion("isconnect like", value, "isconnect");
      return (Criteria) this;
    }

    public Criteria andIsconnectNotLike(String value) {
      addCriterion("isconnect not like", value, "isconnect");
      return (Criteria) this;
    }

    public Criteria andIsconnectIn(List<String> values) {
      addCriterion("isconnect in", values, "isconnect");
      return (Criteria) this;
    }

    public Criteria andIsconnectNotIn(List<String> values) {
      addCriterion("isconnect not in", values, "isconnect");
      return (Criteria) this;
    }

    public Criteria andIsconnectBetween(String value1, String value2) {
      addCriterion("isconnect between", value1, value2, "isconnect");
      return (Criteria) this;
    }

    public Criteria andIsconnectNotBetween(String value1, String value2) {
      addCriterion("isconnect not between", value1, value2, "isconnect");
      return (Criteria) this;
    }

    public Criteria andBrandNameIsNull() {
      addCriterion("brand_name is null");
      return (Criteria) this;
    }

    public Criteria andBrandNameIsNotNull() {
      addCriterion("brand_name is not null");
      return (Criteria) this;
    }

    public Criteria andBrandNameEqualTo(String value) {
      addCriterion("brand_name =", value, "brandName");
      return (Criteria) this;
    }

    public Criteria andBrandNameNotEqualTo(String value) {
      addCriterion("brand_name <>", value, "brandName");
      return (Criteria) this;
    }

    public Criteria andBrandNameGreaterThan(String value) {
      addCriterion("brand_name >", value, "brandName");
      return (Criteria) this;
    }

    public Criteria andBrandNameGreaterThanOrEqualTo(String value) {
      addCriterion("brand_name >=", value, "brandName");
      return (Criteria) this;
    }

    public Criteria andBrandNameLessThan(String value) {
      addCriterion("brand_name <", value, "brandName");
      return (Criteria) this;
    }

    public Criteria andBrandNameLessThanOrEqualTo(String value) {
      addCriterion("brand_name <=", value, "brandName");
      return (Criteria) this;
    }

    public Criteria andBrandNameLike(String value) {
      addCriterion("brand_name like", value, "brandName");
      return (Criteria) this;
    }

    public Criteria andBrandNameNotLike(String value) {
      addCriterion("brand_name not like", value, "brandName");
      return (Criteria) this;
    }

    public Criteria andBrandNameIn(List<String> values) {
      addCriterion("brand_name in", values, "brandName");
      return (Criteria) this;
    }

    public Criteria andBrandNameNotIn(List<String> values) {
      addCriterion("brand_name not in", values, "brandName");
      return (Criteria) this;
    }

    public Criteria andBrandNameBetween(String value1, String value2) {
      addCriterion("brand_name between", value1, value2, "brandName");
      return (Criteria) this;
    }

    public Criteria andBrandNameNotBetween(String value1, String value2) {
      addCriterion("brand_name not between", value1, value2, "brandName");
      return (Criteria) this;
    }

    public Criteria andBrandPictureIsNull() {
      addCriterion("brand_picture is null");
      return (Criteria) this;
    }

    public Criteria andBrandPictureIsNotNull() {
      addCriterion("brand_picture is not null");
      return (Criteria) this;
    }

    public Criteria andBrandPictureEqualTo(String value) {
      addCriterion("brand_picture =", value, "brandPicture");
      return (Criteria) this;
    }

    public Criteria andBrandPictureNotEqualTo(String value) {
      addCriterion("brand_picture <>", value, "brandPicture");
      return (Criteria) this;
    }

    public Criteria andBrandPictureGreaterThan(String value) {
      addCriterion("brand_picture >", value, "brandPicture");
      return (Criteria) this;
    }

    public Criteria andBrandPictureGreaterThanOrEqualTo(String value) {
      addCriterion("brand_picture >=", value, "brandPicture");
      return (Criteria) this;
    }

    public Criteria andBrandPictureLessThan(String value) {
      addCriterion("brand_picture <", value, "brandPicture");
      return (Criteria) this;
    }

    public Criteria andBrandPictureLessThanOrEqualTo(String value) {
      addCriterion("brand_picture <=", value, "brandPicture");
      return (Criteria) this;
    }

    public Criteria andBrandPictureLike(String value) {
      addCriterion("brand_picture like", value, "brandPicture");
      return (Criteria) this;
    }

    public Criteria andBrandPictureNotLike(String value) {
      addCriterion("brand_picture not like", value, "brandPicture");
      return (Criteria) this;
    }

    public Criteria andBrandPictureIn(List<String> values) {
      addCriterion("brand_picture in", values, "brandPicture");
      return (Criteria) this;
    }

    public Criteria andBrandPictureNotIn(List<String> values) {
      addCriterion("brand_picture not in", values, "brandPicture");
      return (Criteria) this;
    }

    public Criteria andBrandPictureBetween(String value1, String value2) {
      addCriterion("brand_picture between", value1, value2, "brandPicture");
      return (Criteria) this;
    }

    public Criteria andBrandPictureNotBetween(String value1, String value2) {
      addCriterion("brand_picture not between", value1, value2, "brandPicture");
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
   * 只读. t_wx_public
   * @mbg.generated  2018-07-14 14:12:10
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
     * This class corresponds to the database table wx_public
     *
     * @mbg.generated do_not_delete_during_merge 2018-07-07 16:03:38
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }
}