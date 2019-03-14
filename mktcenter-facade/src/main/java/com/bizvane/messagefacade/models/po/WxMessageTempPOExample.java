package com.bizvane.messagefacade.models.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WxMessageTempPOExample implements Serializable {
    /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  protected String orderByClause;
  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  protected boolean distinct;
  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  protected List<Criteria> oredCriteria;
  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  private static final long serialVersionUID = 1L;

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public WxMessageTempPOExample() {
    oredCriteria = new ArrayList<Criteria>();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public void setOrderByClause(String orderByClause) {
    this.orderByClause = orderByClause;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public String getOrderByClause() {
    return orderByClause;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public void setDistinct(boolean distinct) {
    this.distinct = distinct;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public boolean isDistinct() {
    return distinct;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public List<Criteria> getOredCriteria() {
    return oredCriteria;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public void or(Criteria criteria) {
    oredCriteria.add(criteria);
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public Criteria or() {
    Criteria criteria = createCriteriaInternal();
    oredCriteria.add(criteria);
    return criteria;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
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
   * @mbg.generated  2018-08-02 15:58:49
   */
  protected Criteria createCriteriaInternal() {
    Criteria criteria = new Criteria();
    return criteria;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public void clear() {
    oredCriteria.clear();
    orderByClause = null;
    distinct = false;
  }

  /**
   * 只读. t_wx_message_temp
   * @mbg.generated  2018-08-02 15:58:49
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

    public Criteria andWxMessageTempIdIsNull() {
      addCriterion("wx_message_temp_id is null");
      return (Criteria) this;
    }

    public Criteria andWxMessageTempIdIsNotNull() {
      addCriterion("wx_message_temp_id is not null");
      return (Criteria) this;
    }

    public Criteria andWxMessageTempIdEqualTo(Long value) {
      addCriterion("wx_message_temp_id =", value, "wxMessageTempId");
      return (Criteria) this;
    }

    public Criteria andWxMessageTempIdNotEqualTo(Long value) {
      addCriterion("wx_message_temp_id <>", value, "wxMessageTempId");
      return (Criteria) this;
    }

    public Criteria andWxMessageTempIdGreaterThan(Long value) {
      addCriterion("wx_message_temp_id >", value, "wxMessageTempId");
      return (Criteria) this;
    }

    public Criteria andWxMessageTempIdGreaterThanOrEqualTo(Long value) {
      addCriterion("wx_message_temp_id >=", value, "wxMessageTempId");
      return (Criteria) this;
    }

    public Criteria andWxMessageTempIdLessThan(Long value) {
      addCriterion("wx_message_temp_id <", value, "wxMessageTempId");
      return (Criteria) this;
    }

    public Criteria andWxMessageTempIdLessThanOrEqualTo(Long value) {
      addCriterion("wx_message_temp_id <=", value, "wxMessageTempId");
      return (Criteria) this;
    }

    public Criteria andWxMessageTempIdIn(List<Long> values) {
      addCriterion("wx_message_temp_id in", values, "wxMessageTempId");
      return (Criteria) this;
    }

    public Criteria andWxMessageTempIdNotIn(List<Long> values) {
      addCriterion("wx_message_temp_id not in", values, "wxMessageTempId");
      return (Criteria) this;
    }

    public Criteria andWxMessageTempIdBetween(Long value1, Long value2) {
      addCriterion("wx_message_temp_id between", value1, value2, "wxMessageTempId");
      return (Criteria) this;
    }

    public Criteria andWxMessageTempIdNotBetween(Long value1, Long value2) {
      addCriterion("wx_message_temp_id not between", value1, value2, "wxMessageTempId");
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

    public Criteria andShortCodeIsNull() {
      addCriterion("short_code is null");
      return (Criteria) this;
    }

    public Criteria andShortCodeIsNotNull() {
      addCriterion("short_code is not null");
      return (Criteria) this;
    }

    public Criteria andShortCodeEqualTo(String value) {
      addCriterion("short_code =", value, "shortCode");
      return (Criteria) this;
    }

    public Criteria andShortCodeNotEqualTo(String value) {
      addCriterion("short_code <>", value, "shortCode");
      return (Criteria) this;
    }

    public Criteria andShortCodeGreaterThan(String value) {
      addCriterion("short_code >", value, "shortCode");
      return (Criteria) this;
    }

    public Criteria andShortCodeGreaterThanOrEqualTo(String value) {
      addCriterion("short_code >=", value, "shortCode");
      return (Criteria) this;
    }

    public Criteria andShortCodeLessThan(String value) {
      addCriterion("short_code <", value, "shortCode");
      return (Criteria) this;
    }

    public Criteria andShortCodeLessThanOrEqualTo(String value) {
      addCriterion("short_code <=", value, "shortCode");
      return (Criteria) this;
    }

    public Criteria andShortCodeLike(String value) {
      addCriterion("short_code like", value, "shortCode");
      return (Criteria) this;
    }

    public Criteria andShortCodeNotLike(String value) {
      addCriterion("short_code not like", value, "shortCode");
      return (Criteria) this;
    }

    public Criteria andShortCodeIn(List<String> values) {
      addCriterion("short_code in", values, "shortCode");
      return (Criteria) this;
    }

    public Criteria andShortCodeNotIn(List<String> values) {
      addCriterion("short_code not in", values, "shortCode");
      return (Criteria) this;
    }

    public Criteria andShortCodeBetween(String value1, String value2) {
      addCriterion("short_code between", value1, value2, "shortCode");
      return (Criteria) this;
    }

    public Criteria andShortCodeNotBetween(String value1, String value2) {
      addCriterion("short_code not between", value1, value2, "shortCode");
      return (Criteria) this;
    }

    public Criteria andWxTemplateIdIsNull() {
      addCriterion("wx_template_id is null");
      return (Criteria) this;
    }

    public Criteria andWxTemplateIdIsNotNull() {
      addCriterion("wx_template_id is not null");
      return (Criteria) this;
    }

    public Criteria andWxTemplateIdEqualTo(String value) {
      addCriterion("wx_template_id =", value, "wxTemplateId");
      return (Criteria) this;
    }

    public Criteria andWxTemplateIdNotEqualTo(String value) {
      addCriterion("wx_template_id <>", value, "wxTemplateId");
      return (Criteria) this;
    }

    public Criteria andWxTemplateIdGreaterThan(String value) {
      addCriterion("wx_template_id >", value, "wxTemplateId");
      return (Criteria) this;
    }

    public Criteria andWxTemplateIdGreaterThanOrEqualTo(String value) {
      addCriterion("wx_template_id >=", value, "wxTemplateId");
      return (Criteria) this;
    }

    public Criteria andWxTemplateIdLessThan(String value) {
      addCriterion("wx_template_id <", value, "wxTemplateId");
      return (Criteria) this;
    }

    public Criteria andWxTemplateIdLessThanOrEqualTo(String value) {
      addCriterion("wx_template_id <=", value, "wxTemplateId");
      return (Criteria) this;
    }

    public Criteria andWxTemplateIdLike(String value) {
      addCriterion("wx_template_id like", value, "wxTemplateId");
      return (Criteria) this;
    }

    public Criteria andWxTemplateIdNotLike(String value) {
      addCriterion("wx_template_id not like", value, "wxTemplateId");
      return (Criteria) this;
    }

    public Criteria andWxTemplateIdIn(List<String> values) {
      addCriterion("wx_template_id in", values, "wxTemplateId");
      return (Criteria) this;
    }

    public Criteria andWxTemplateIdNotIn(List<String> values) {
      addCriterion("wx_template_id not in", values, "wxTemplateId");
      return (Criteria) this;
    }

    public Criteria andWxTemplateIdBetween(String value1, String value2) {
      addCriterion("wx_template_id between", value1, value2, "wxTemplateId");
      return (Criteria) this;
    }

    public Criteria andWxTemplateIdNotBetween(String value1, String value2) {
      addCriterion("wx_template_id not between", value1, value2, "wxTemplateId");
      return (Criteria) this;
    }

    public Criteria andPrimaryIndustryIsNull() {
      addCriterion("primary_industry is null");
      return (Criteria) this;
    }

    public Criteria andPrimaryIndustryIsNotNull() {
      addCriterion("primary_industry is not null");
      return (Criteria) this;
    }

    public Criteria andPrimaryIndustryEqualTo(String value) {
      addCriterion("primary_industry =", value, "primaryIndustry");
      return (Criteria) this;
    }

    public Criteria andPrimaryIndustryNotEqualTo(String value) {
      addCriterion("primary_industry <>", value, "primaryIndustry");
      return (Criteria) this;
    }

    public Criteria andPrimaryIndustryGreaterThan(String value) {
      addCriterion("primary_industry >", value, "primaryIndustry");
      return (Criteria) this;
    }

    public Criteria andPrimaryIndustryGreaterThanOrEqualTo(String value) {
      addCriterion("primary_industry >=", value, "primaryIndustry");
      return (Criteria) this;
    }

    public Criteria andPrimaryIndustryLessThan(String value) {
      addCriterion("primary_industry <", value, "primaryIndustry");
      return (Criteria) this;
    }

    public Criteria andPrimaryIndustryLessThanOrEqualTo(String value) {
      addCriterion("primary_industry <=", value, "primaryIndustry");
      return (Criteria) this;
    }

    public Criteria andPrimaryIndustryLike(String value) {
      addCriterion("primary_industry like", value, "primaryIndustry");
      return (Criteria) this;
    }

    public Criteria andPrimaryIndustryNotLike(String value) {
      addCriterion("primary_industry not like", value, "primaryIndustry");
      return (Criteria) this;
    }

    public Criteria andPrimaryIndustryIn(List<String> values) {
      addCriterion("primary_industry in", values, "primaryIndustry");
      return (Criteria) this;
    }

    public Criteria andPrimaryIndustryNotIn(List<String> values) {
      addCriterion("primary_industry not in", values, "primaryIndustry");
      return (Criteria) this;
    }

    public Criteria andPrimaryIndustryBetween(String value1, String value2) {
      addCriterion("primary_industry between", value1, value2, "primaryIndustry");
      return (Criteria) this;
    }

    public Criteria andPrimaryIndustryNotBetween(String value1, String value2) {
      addCriterion("primary_industry not between", value1, value2, "primaryIndustry");
      return (Criteria) this;
    }

    public Criteria andDeputyIndestryIsNull() {
      addCriterion("deputy_indestry is null");
      return (Criteria) this;
    }

    public Criteria andDeputyIndestryIsNotNull() {
      addCriterion("deputy_indestry is not null");
      return (Criteria) this;
    }

    public Criteria andDeputyIndestryEqualTo(String value) {
      addCriterion("deputy_indestry =", value, "deputyIndestry");
      return (Criteria) this;
    }

    public Criteria andDeputyIndestryNotEqualTo(String value) {
      addCriterion("deputy_indestry <>", value, "deputyIndestry");
      return (Criteria) this;
    }

    public Criteria andDeputyIndestryGreaterThan(String value) {
      addCriterion("deputy_indestry >", value, "deputyIndestry");
      return (Criteria) this;
    }

    public Criteria andDeputyIndestryGreaterThanOrEqualTo(String value) {
      addCriterion("deputy_indestry >=", value, "deputyIndestry");
      return (Criteria) this;
    }

    public Criteria andDeputyIndestryLessThan(String value) {
      addCriterion("deputy_indestry <", value, "deputyIndestry");
      return (Criteria) this;
    }

    public Criteria andDeputyIndestryLessThanOrEqualTo(String value) {
      addCriterion("deputy_indestry <=", value, "deputyIndestry");
      return (Criteria) this;
    }

    public Criteria andDeputyIndestryLike(String value) {
      addCriterion("deputy_indestry like", value, "deputyIndestry");
      return (Criteria) this;
    }

    public Criteria andDeputyIndestryNotLike(String value) {
      addCriterion("deputy_indestry not like", value, "deputyIndestry");
      return (Criteria) this;
    }

    public Criteria andDeputyIndestryIn(List<String> values) {
      addCriterion("deputy_indestry in", values, "deputyIndestry");
      return (Criteria) this;
    }

    public Criteria andDeputyIndestryNotIn(List<String> values) {
      addCriterion("deputy_indestry not in", values, "deputyIndestry");
      return (Criteria) this;
    }

    public Criteria andDeputyIndestryBetween(String value1, String value2) {
      addCriterion("deputy_indestry between", value1, value2, "deputyIndestry");
      return (Criteria) this;
    }

    public Criteria andDeputyIndestryNotBetween(String value1, String value2) {
      addCriterion("deputy_indestry not between", value1, value2, "deputyIndestry");
      return (Criteria) this;
    }

    public Criteria andTitleIsNull() {
      addCriterion("title is null");
      return (Criteria) this;
    }

    public Criteria andTitleIsNotNull() {
      addCriterion("title is not null");
      return (Criteria) this;
    }

    public Criteria andTitleEqualTo(String value) {
      addCriterion("title =", value, "title");
      return (Criteria) this;
    }

    public Criteria andTitleNotEqualTo(String value) {
      addCriterion("title <>", value, "title");
      return (Criteria) this;
    }

    public Criteria andTitleGreaterThan(String value) {
      addCriterion("title >", value, "title");
      return (Criteria) this;
    }

    public Criteria andTitleGreaterThanOrEqualTo(String value) {
      addCriterion("title >=", value, "title");
      return (Criteria) this;
    }

    public Criteria andTitleLessThan(String value) {
      addCriterion("title <", value, "title");
      return (Criteria) this;
    }

    public Criteria andTitleLessThanOrEqualTo(String value) {
      addCriterion("title <=", value, "title");
      return (Criteria) this;
    }

    public Criteria andTitleLike(String value) {
      addCriterion("title like", value, "title");
      return (Criteria) this;
    }

    public Criteria andTitleNotLike(String value) {
      addCriterion("title not like", value, "title");
      return (Criteria) this;
    }

    public Criteria andTitleIn(List<String> values) {
      addCriterion("title in", values, "title");
      return (Criteria) this;
    }

    public Criteria andTitleNotIn(List<String> values) {
      addCriterion("title not in", values, "title");
      return (Criteria) this;
    }

    public Criteria andTitleBetween(String value1, String value2) {
      addCriterion("title between", value1, value2, "title");
      return (Criteria) this;
    }

    public Criteria andTitleNotBetween(String value1, String value2) {
      addCriterion("title not between", value1, value2, "title");
      return (Criteria) this;
    }

    public Criteria andFirstIsNull() {
      addCriterion("first is null");
      return (Criteria) this;
    }

    public Criteria andFirstIsNotNull() {
      addCriterion("first is not null");
      return (Criteria) this;
    }

    public Criteria andFirstEqualTo(String value) {
      addCriterion("first =", value, "first");
      return (Criteria) this;
    }

    public Criteria andFirstNotEqualTo(String value) {
      addCriterion("first <>", value, "first");
      return (Criteria) this;
    }

    public Criteria andFirstGreaterThan(String value) {
      addCriterion("first >", value, "first");
      return (Criteria) this;
    }

    public Criteria andFirstGreaterThanOrEqualTo(String value) {
      addCriterion("first >=", value, "first");
      return (Criteria) this;
    }

    public Criteria andFirstLessThan(String value) {
      addCriterion("first <", value, "first");
      return (Criteria) this;
    }

    public Criteria andFirstLessThanOrEqualTo(String value) {
      addCriterion("first <=", value, "first");
      return (Criteria) this;
    }

    public Criteria andFirstLike(String value) {
      addCriterion("first like", value, "first");
      return (Criteria) this;
    }

    public Criteria andFirstNotLike(String value) {
      addCriterion("first not like", value, "first");
      return (Criteria) this;
    }

    public Criteria andFirstIn(List<String> values) {
      addCriterion("first in", values, "first");
      return (Criteria) this;
    }

    public Criteria andFirstNotIn(List<String> values) {
      addCriterion("first not in", values, "first");
      return (Criteria) this;
    }

    public Criteria andFirstBetween(String value1, String value2) {
      addCriterion("first between", value1, value2, "first");
      return (Criteria) this;
    }

    public Criteria andFirstNotBetween(String value1, String value2) {
      addCriterion("first not between", value1, value2, "first");
      return (Criteria) this;
    }

    public Criteria andTailIsNull() {
      addCriterion("tail is null");
      return (Criteria) this;
    }

    public Criteria andTailIsNotNull() {
      addCriterion("tail is not null");
      return (Criteria) this;
    }

    public Criteria andTailEqualTo(String value) {
      addCriterion("tail =", value, "tail");
      return (Criteria) this;
    }

    public Criteria andTailNotEqualTo(String value) {
      addCriterion("tail <>", value, "tail");
      return (Criteria) this;
    }

    public Criteria andTailGreaterThan(String value) {
      addCriterion("tail >", value, "tail");
      return (Criteria) this;
    }

    public Criteria andTailGreaterThanOrEqualTo(String value) {
      addCriterion("tail >=", value, "tail");
      return (Criteria) this;
    }

    public Criteria andTailLessThan(String value) {
      addCriterion("tail <", value, "tail");
      return (Criteria) this;
    }

    public Criteria andTailLessThanOrEqualTo(String value) {
      addCriterion("tail <=", value, "tail");
      return (Criteria) this;
    }

    public Criteria andTailLike(String value) {
      addCriterion("tail like", value, "tail");
      return (Criteria) this;
    }

    public Criteria andTailNotLike(String value) {
      addCriterion("tail not like", value, "tail");
      return (Criteria) this;
    }

    public Criteria andTailIn(List<String> values) {
      addCriterion("tail in", values, "tail");
      return (Criteria) this;
    }

    public Criteria andTailNotIn(List<String> values) {
      addCriterion("tail not in", values, "tail");
      return (Criteria) this;
    }

    public Criteria andTailBetween(String value1, String value2) {
      addCriterion("tail between", value1, value2, "tail");
      return (Criteria) this;
    }

    public Criteria andTailNotBetween(String value1, String value2) {
      addCriterion("tail not between", value1, value2, "tail");
      return (Criteria) this;
    }

    public Criteria andContentIsNull() {
      addCriterion("content is null");
      return (Criteria) this;
    }

    public Criteria andContentIsNotNull() {
      addCriterion("content is not null");
      return (Criteria) this;
    }

    public Criteria andContentEqualTo(String value) {
      addCriterion("content =", value, "content");
      return (Criteria) this;
    }

    public Criteria andContentNotEqualTo(String value) {
      addCriterion("content <>", value, "content");
      return (Criteria) this;
    }

    public Criteria andContentGreaterThan(String value) {
      addCriterion("content >", value, "content");
      return (Criteria) this;
    }

    public Criteria andContentGreaterThanOrEqualTo(String value) {
      addCriterion("content >=", value, "content");
      return (Criteria) this;
    }

    public Criteria andContentLessThan(String value) {
      addCriterion("content <", value, "content");
      return (Criteria) this;
    }

    public Criteria andContentLessThanOrEqualTo(String value) {
      addCriterion("content <=", value, "content");
      return (Criteria) this;
    }

    public Criteria andContentLike(String value) {
      addCriterion("content like", value, "content");
      return (Criteria) this;
    }

    public Criteria andContentNotLike(String value) {
      addCriterion("content not like", value, "content");
      return (Criteria) this;
    }

    public Criteria andContentIn(List<String> values) {
      addCriterion("content in", values, "content");
      return (Criteria) this;
    }

    public Criteria andContentNotIn(List<String> values) {
      addCriterion("content not in", values, "content");
      return (Criteria) this;
    }

    public Criteria andContentBetween(String value1, String value2) {
      addCriterion("content between", value1, value2, "content");
      return (Criteria) this;
    }

    public Criteria andContentNotBetween(String value1, String value2) {
      addCriterion("content not between", value1, value2, "content");
      return (Criteria) this;
    }

    public Criteria andMessageIsNull() {
      addCriterion("message is null");
      return (Criteria) this;
    }

    public Criteria andMessageIsNotNull() {
      addCriterion("message is not null");
      return (Criteria) this;
    }

    public Criteria andMessageEqualTo(String value) {
      addCriterion("message =", value, "message");
      return (Criteria) this;
    }

    public Criteria andMessageNotEqualTo(String value) {
      addCriterion("message <>", value, "message");
      return (Criteria) this;
    }

    public Criteria andMessageGreaterThan(String value) {
      addCriterion("message >", value, "message");
      return (Criteria) this;
    }

    public Criteria andMessageGreaterThanOrEqualTo(String value) {
      addCriterion("message >=", value, "message");
      return (Criteria) this;
    }

    public Criteria andMessageLessThan(String value) {
      addCriterion("message <", value, "message");
      return (Criteria) this;
    }

    public Criteria andMessageLessThanOrEqualTo(String value) {
      addCriterion("message <=", value, "message");
      return (Criteria) this;
    }

    public Criteria andMessageLike(String value) {
      addCriterion("message like", value, "message");
      return (Criteria) this;
    }

    public Criteria andMessageNotLike(String value) {
      addCriterion("message not like", value, "message");
      return (Criteria) this;
    }

    public Criteria andMessageIn(List<String> values) {
      addCriterion("message in", values, "message");
      return (Criteria) this;
    }

    public Criteria andMessageNotIn(List<String> values) {
      addCriterion("message not in", values, "message");
      return (Criteria) this;
    }

    public Criteria andMessageBetween(String value1, String value2) {
      addCriterion("message between", value1, value2, "message");
      return (Criteria) this;
    }

    public Criteria andMessageNotBetween(String value1, String value2) {
      addCriterion("message not between", value1, value2, "message");
      return (Criteria) this;
    }

    public Criteria andExampleIsNull() {
      addCriterion("example is null");
      return (Criteria) this;
    }

    public Criteria andExampleIsNotNull() {
      addCriterion("example is not null");
      return (Criteria) this;
    }

    public Criteria andExampleEqualTo(String value) {
      addCriterion("example =", value, "example");
      return (Criteria) this;
    }

    public Criteria andExampleNotEqualTo(String value) {
      addCriterion("example <>", value, "example");
      return (Criteria) this;
    }

    public Criteria andExampleGreaterThan(String value) {
      addCriterion("example >", value, "example");
      return (Criteria) this;
    }

    public Criteria andExampleGreaterThanOrEqualTo(String value) {
      addCriterion("example >=", value, "example");
      return (Criteria) this;
    }

    public Criteria andExampleLessThan(String value) {
      addCriterion("example <", value, "example");
      return (Criteria) this;
    }

    public Criteria andExampleLessThanOrEqualTo(String value) {
      addCriterion("example <=", value, "example");
      return (Criteria) this;
    }

    public Criteria andExampleLike(String value) {
      addCriterion("example like", value, "example");
      return (Criteria) this;
    }

    public Criteria andExampleNotLike(String value) {
      addCriterion("example not like", value, "example");
      return (Criteria) this;
    }

    public Criteria andExampleIn(List<String> values) {
      addCriterion("example in", values, "example");
      return (Criteria) this;
    }

    public Criteria andExampleNotIn(List<String> values) {
      addCriterion("example not in", values, "example");
      return (Criteria) this;
    }

    public Criteria andExampleBetween(String value1, String value2) {
      addCriterion("example between", value1, value2, "example");
      return (Criteria) this;
    }

    public Criteria andExampleNotBetween(String value1, String value2) {
      addCriterion("example not between", value1, value2, "example");
      return (Criteria) this;
    }

    public Criteria andUrlIsNull() {
      addCriterion("url is null");
      return (Criteria) this;
    }

    public Criteria andUrlIsNotNull() {
      addCriterion("url is not null");
      return (Criteria) this;
    }

    public Criteria andUrlEqualTo(String value) {
      addCriterion("url =", value, "url");
      return (Criteria) this;
    }

    public Criteria andUrlNotEqualTo(String value) {
      addCriterion("url <>", value, "url");
      return (Criteria) this;
    }

    public Criteria andUrlGreaterThan(String value) {
      addCriterion("url >", value, "url");
      return (Criteria) this;
    }

    public Criteria andUrlGreaterThanOrEqualTo(String value) {
      addCriterion("url >=", value, "url");
      return (Criteria) this;
    }

    public Criteria andUrlLessThan(String value) {
      addCriterion("url <", value, "url");
      return (Criteria) this;
    }

    public Criteria andUrlLessThanOrEqualTo(String value) {
      addCriterion("url <=", value, "url");
      return (Criteria) this;
    }

    public Criteria andUrlLike(String value) {
      addCriterion("url like", value, "url");
      return (Criteria) this;
    }

    public Criteria andUrlNotLike(String value) {
      addCriterion("url not like", value, "url");
      return (Criteria) this;
    }

    public Criteria andUrlIn(List<String> values) {
      addCriterion("url in", values, "url");
      return (Criteria) this;
    }

    public Criteria andUrlNotIn(List<String> values) {
      addCriterion("url not in", values, "url");
      return (Criteria) this;
    }

    public Criteria andUrlBetween(String value1, String value2) {
      addCriterion("url between", value1, value2, "url");
      return (Criteria) this;
    }

    public Criteria andUrlNotBetween(String value1, String value2) {
      addCriterion("url not between", value1, value2, "url");
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

    public Criteria andClassPathIsNull() {
      addCriterion("class_path is null");
      return (Criteria) this;
    }

    public Criteria andClassPathIsNotNull() {
      addCriterion("class_path is not null");
      return (Criteria) this;
    }

    public Criteria andClassPathEqualTo(String value) {
      addCriterion("class_path =", value, "classPath");
      return (Criteria) this;
    }

    public Criteria andClassPathNotEqualTo(String value) {
      addCriterion("class_path <>", value, "classPath");
      return (Criteria) this;
    }

    public Criteria andClassPathGreaterThan(String value) {
      addCriterion("class_path >", value, "classPath");
      return (Criteria) this;
    }

    public Criteria andClassPathGreaterThanOrEqualTo(String value) {
      addCriterion("class_path >=", value, "classPath");
      return (Criteria) this;
    }

    public Criteria andClassPathLessThan(String value) {
      addCriterion("class_path <", value, "classPath");
      return (Criteria) this;
    }

    public Criteria andClassPathLessThanOrEqualTo(String value) {
      addCriterion("class_path <=", value, "classPath");
      return (Criteria) this;
    }

    public Criteria andClassPathLike(String value) {
      addCriterion("class_path like", value, "classPath");
      return (Criteria) this;
    }

    public Criteria andClassPathNotLike(String value) {
      addCriterion("class_path not like", value, "classPath");
      return (Criteria) this;
    }

    public Criteria andClassPathIn(List<String> values) {
      addCriterion("class_path in", values, "classPath");
      return (Criteria) this;
    }

    public Criteria andClassPathNotIn(List<String> values) {
      addCriterion("class_path not in", values, "classPath");
      return (Criteria) this;
    }

    public Criteria andClassPathBetween(String value1, String value2) {
      addCriterion("class_path between", value1, value2, "classPath");
      return (Criteria) this;
    }

    public Criteria andClassPathNotBetween(String value1, String value2) {
      addCriterion("class_path not between", value1, value2, "classPath");
      return (Criteria) this;
    }

    public Criteria andIsauthorizeIsNull() {
      addCriterion("isauthorize is null");
      return (Criteria) this;
    }

    public Criteria andIsauthorizeIsNotNull() {
      addCriterion("isauthorize is not null");
      return (Criteria) this;
    }

    public Criteria andIsauthorizeEqualTo(Boolean value) {
      addCriterion("isauthorize =", value, "isauthorize");
      return (Criteria) this;
    }

    public Criteria andIsauthorizeNotEqualTo(Boolean value) {
      addCriterion("isauthorize <>", value, "isauthorize");
      return (Criteria) this;
    }

    public Criteria andIsauthorizeGreaterThan(Boolean value) {
      addCriterion("isauthorize >", value, "isauthorize");
      return (Criteria) this;
    }

    public Criteria andIsauthorizeGreaterThanOrEqualTo(Boolean value) {
      addCriterion("isauthorize >=", value, "isauthorize");
      return (Criteria) this;
    }

    public Criteria andIsauthorizeLessThan(Boolean value) {
      addCriterion("isauthorize <", value, "isauthorize");
      return (Criteria) this;
    }

    public Criteria andIsauthorizeLessThanOrEqualTo(Boolean value) {
      addCriterion("isauthorize <=", value, "isauthorize");
      return (Criteria) this;
    }

    public Criteria andIsauthorizeIn(List<Boolean> values) {
      addCriterion("isauthorize in", values, "isauthorize");
      return (Criteria) this;
    }

    public Criteria andIsauthorizeNotIn(List<Boolean> values) {
      addCriterion("isauthorize not in", values, "isauthorize");
      return (Criteria) this;
    }

    public Criteria andIsauthorizeBetween(Boolean value1, Boolean value2) {
      addCriterion("isauthorize between", value1, value2, "isauthorize");
      return (Criteria) this;
    }

    public Criteria andIsauthorizeNotBetween(Boolean value1, Boolean value2) {
      addCriterion("isauthorize not between", value1, value2, "isauthorize");
      return (Criteria) this;
    }

    public Criteria andIssendmessageIsNull() {
      addCriterion("issendmessage is null");
      return (Criteria) this;
    }

    public Criteria andIssendmessageIsNotNull() {
      addCriterion("issendmessage is not null");
      return (Criteria) this;
    }

    public Criteria andIssendmessageEqualTo(Boolean value) {
      addCriterion("issendmessage =", value, "issendmessage");
      return (Criteria) this;
    }

    public Criteria andIssendmessageNotEqualTo(Boolean value) {
      addCriterion("issendmessage <>", value, "issendmessage");
      return (Criteria) this;
    }

    public Criteria andIssendmessageGreaterThan(Boolean value) {
      addCriterion("issendmessage >", value, "issendmessage");
      return (Criteria) this;
    }

    public Criteria andIssendmessageGreaterThanOrEqualTo(Boolean value) {
      addCriterion("issendmessage >=", value, "issendmessage");
      return (Criteria) this;
    }

    public Criteria andIssendmessageLessThan(Boolean value) {
      addCriterion("issendmessage <", value, "issendmessage");
      return (Criteria) this;
    }

    public Criteria andIssendmessageLessThanOrEqualTo(Boolean value) {
      addCriterion("issendmessage <=", value, "issendmessage");
      return (Criteria) this;
    }

    public Criteria andIssendmessageIn(List<Boolean> values) {
      addCriterion("issendmessage in", values, "issendmessage");
      return (Criteria) this;
    }

    public Criteria andIssendmessageNotIn(List<Boolean> values) {
      addCriterion("issendmessage not in", values, "issendmessage");
      return (Criteria) this;
    }

    public Criteria andIssendmessageBetween(Boolean value1, Boolean value2) {
      addCriterion("issendmessage between", value1, value2, "issendmessage");
      return (Criteria) this;
    }

    public Criteria andIssendmessageNotBetween(Boolean value1, Boolean value2) {
      addCriterion("issendmessage not between", value1, value2, "issendmessage");
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
   * 只读. t_wx_message_temp
   * @mbg.generated  2018-08-02 15:58:49
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
     * This class corresponds to the database table t_wx_message_temp
     *
     * @mbg.generated do_not_delete_during_merge 2018-07-10 21:06:29
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }
}