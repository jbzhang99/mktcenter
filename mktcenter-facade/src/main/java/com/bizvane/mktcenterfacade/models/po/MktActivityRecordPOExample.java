package com.bizvane.mktcenterfacade.models.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MktActivityRecordPOExample implements Serializable {
    /**
	 * @mbg.generated
	 */
	protected String orderByClause;
	/**
	 * @mbg.generated
	 */
	protected boolean distinct;
	/**
	 * @mbg.generated
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * 只读. 
	 * @mbg.generated
	 */
	public MktActivityRecordPOExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * 只读. 
	 * @mbg.generated
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * 只读. 
	 * @mbg.generated
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * 只读. 
	 * @mbg.generated
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * 只读. 
	 * @mbg.generated
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * 只读. 
	 * @mbg.generated
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * 只读. 
	 * @mbg.generated
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * 只读. 
	 * @mbg.generated
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * 只读. 
	 * @mbg.generated
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
	 * @mbg.generated
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * 只读. 
	 * @mbg.generated
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * 只读. t_mkt_activity_record
	 * @mbg.generated
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

		public Criteria andMktActivityRecordIdIsNull() {
			addCriterion("mkt_activity_record_id is null");
			return (Criteria) this;
		}

		public Criteria andMktActivityRecordIdIsNotNull() {
			addCriterion("mkt_activity_record_id is not null");
			return (Criteria) this;
		}

		public Criteria andMktActivityRecordIdEqualTo(Long value) {
			addCriterion("mkt_activity_record_id =", value, "mktActivityRecordId");
			return (Criteria) this;
		}

		public Criteria andMktActivityRecordIdNotEqualTo(Long value) {
			addCriterion("mkt_activity_record_id <>", value, "mktActivityRecordId");
			return (Criteria) this;
		}

		public Criteria andMktActivityRecordIdGreaterThan(Long value) {
			addCriterion("mkt_activity_record_id >", value, "mktActivityRecordId");
			return (Criteria) this;
		}

		public Criteria andMktActivityRecordIdGreaterThanOrEqualTo(Long value) {
			addCriterion("mkt_activity_record_id >=", value, "mktActivityRecordId");
			return (Criteria) this;
		}

		public Criteria andMktActivityRecordIdLessThan(Long value) {
			addCriterion("mkt_activity_record_id <", value, "mktActivityRecordId");
			return (Criteria) this;
		}

		public Criteria andMktActivityRecordIdLessThanOrEqualTo(Long value) {
			addCriterion("mkt_activity_record_id <=", value, "mktActivityRecordId");
			return (Criteria) this;
		}

		public Criteria andMktActivityRecordIdIn(List<Long> values) {
			addCriterion("mkt_activity_record_id in", values, "mktActivityRecordId");
			return (Criteria) this;
		}

		public Criteria andMktActivityRecordIdNotIn(List<Long> values) {
			addCriterion("mkt_activity_record_id not in", values, "mktActivityRecordId");
			return (Criteria) this;
		}

		public Criteria andMktActivityRecordIdBetween(Long value1, Long value2) {
			addCriterion("mkt_activity_record_id between", value1, value2, "mktActivityRecordId");
			return (Criteria) this;
		}

		public Criteria andMktActivityRecordIdNotBetween(Long value1, Long value2) {
			addCriterion("mkt_activity_record_id not between", value1, value2, "mktActivityRecordId");
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

		public Criteria andAcitivityIdIsNull() {
			addCriterion("acitivity_id is null");
			return (Criteria) this;
		}

		public Criteria andAcitivityIdIsNotNull() {
			addCriterion("acitivity_id is not null");
			return (Criteria) this;
		}

		public Criteria andAcitivityIdEqualTo(Long value) {
			addCriterion("acitivity_id =", value, "acitivityId");
			return (Criteria) this;
		}

		public Criteria andAcitivityIdNotEqualTo(Long value) {
			addCriterion("acitivity_id <>", value, "acitivityId");
			return (Criteria) this;
		}

		public Criteria andAcitivityIdGreaterThan(Long value) {
			addCriterion("acitivity_id >", value, "acitivityId");
			return (Criteria) this;
		}

		public Criteria andAcitivityIdGreaterThanOrEqualTo(Long value) {
			addCriterion("acitivity_id >=", value, "acitivityId");
			return (Criteria) this;
		}

		public Criteria andAcitivityIdLessThan(Long value) {
			addCriterion("acitivity_id <", value, "acitivityId");
			return (Criteria) this;
		}

		public Criteria andAcitivityIdLessThanOrEqualTo(Long value) {
			addCriterion("acitivity_id <=", value, "acitivityId");
			return (Criteria) this;
		}

		public Criteria andAcitivityIdIn(List<Long> values) {
			addCriterion("acitivity_id in", values, "acitivityId");
			return (Criteria) this;
		}

		public Criteria andAcitivityIdNotIn(List<Long> values) {
			addCriterion("acitivity_id not in", values, "acitivityId");
			return (Criteria) this;
		}

		public Criteria andAcitivityIdBetween(Long value1, Long value2) {
			addCriterion("acitivity_id between", value1, value2, "acitivityId");
			return (Criteria) this;
		}

		public Criteria andAcitivityIdNotBetween(Long value1, Long value2) {
			addCriterion("acitivity_id not between", value1, value2, "acitivityId");
			return (Criteria) this;
		}

		public Criteria andMemberCodeIsNull() {
			addCriterion("member_code is null");
			return (Criteria) this;
		}

		public Criteria andMemberCodeIsNotNull() {
			addCriterion("member_code is not null");
			return (Criteria) this;
		}

		public Criteria andMemberCodeEqualTo(String value) {
			addCriterion("member_code =", value, "memberCode");
			return (Criteria) this;
		}

		public Criteria andMemberCodeNotEqualTo(String value) {
			addCriterion("member_code <>", value, "memberCode");
			return (Criteria) this;
		}

		public Criteria andMemberCodeGreaterThan(String value) {
			addCriterion("member_code >", value, "memberCode");
			return (Criteria) this;
		}

		public Criteria andMemberCodeGreaterThanOrEqualTo(String value) {
			addCriterion("member_code >=", value, "memberCode");
			return (Criteria) this;
		}

		public Criteria andMemberCodeLessThan(String value) {
			addCriterion("member_code <", value, "memberCode");
			return (Criteria) this;
		}

		public Criteria andMemberCodeLessThanOrEqualTo(String value) {
			addCriterion("member_code <=", value, "memberCode");
			return (Criteria) this;
		}

		public Criteria andMemberCodeLike(String value) {
			addCriterion("member_code like", value, "memberCode");
			return (Criteria) this;
		}

		public Criteria andMemberCodeNotLike(String value) {
			addCriterion("member_code not like", value, "memberCode");
			return (Criteria) this;
		}

		public Criteria andMemberCodeIn(List<String> values) {
			addCriterion("member_code in", values, "memberCode");
			return (Criteria) this;
		}

		public Criteria andMemberCodeNotIn(List<String> values) {
			addCriterion("member_code not in", values, "memberCode");
			return (Criteria) this;
		}

		public Criteria andMemberCodeBetween(String value1, String value2) {
			addCriterion("member_code between", value1, value2, "memberCode");
			return (Criteria) this;
		}

		public Criteria andMemberCodeNotBetween(String value1, String value2) {
			addCriterion("member_code not between", value1, value2, "memberCode");
			return (Criteria) this;
		}

		public Criteria andInvitedMemberCodeIsNull() {
			addCriterion("invited_member_code is null");
			return (Criteria) this;
		}

		public Criteria andInvitedMemberCodeIsNotNull() {
			addCriterion("invited_member_code is not null");
			return (Criteria) this;
		}

		public Criteria andInvitedMemberCodeEqualTo(String value) {
			addCriterion("invited_member_code =", value, "invitedMemberCode");
			return (Criteria) this;
		}

		public Criteria andInvitedMemberCodeNotEqualTo(String value) {
			addCriterion("invited_member_code <>", value, "invitedMemberCode");
			return (Criteria) this;
		}

		public Criteria andInvitedMemberCodeGreaterThan(String value) {
			addCriterion("invited_member_code >", value, "invitedMemberCode");
			return (Criteria) this;
		}

		public Criteria andInvitedMemberCodeGreaterThanOrEqualTo(String value) {
			addCriterion("invited_member_code >=", value, "invitedMemberCode");
			return (Criteria) this;
		}

		public Criteria andInvitedMemberCodeLessThan(String value) {
			addCriterion("invited_member_code <", value, "invitedMemberCode");
			return (Criteria) this;
		}

		public Criteria andInvitedMemberCodeLessThanOrEqualTo(String value) {
			addCriterion("invited_member_code <=", value, "invitedMemberCode");
			return (Criteria) this;
		}

		public Criteria andInvitedMemberCodeLike(String value) {
			addCriterion("invited_member_code like", value, "invitedMemberCode");
			return (Criteria) this;
		}

		public Criteria andInvitedMemberCodeNotLike(String value) {
			addCriterion("invited_member_code not like", value, "invitedMemberCode");
			return (Criteria) this;
		}

		public Criteria andInvitedMemberCodeIn(List<String> values) {
			addCriterion("invited_member_code in", values, "invitedMemberCode");
			return (Criteria) this;
		}

		public Criteria andInvitedMemberCodeNotIn(List<String> values) {
			addCriterion("invited_member_code not in", values, "invitedMemberCode");
			return (Criteria) this;
		}

		public Criteria andInvitedMemberCodeBetween(String value1, String value2) {
			addCriterion("invited_member_code between", value1, value2, "invitedMemberCode");
			return (Criteria) this;
		}

		public Criteria andInvitedMemberCodeNotBetween(String value1, String value2) {
			addCriterion("invited_member_code not between", value1, value2, "invitedMemberCode");
			return (Criteria) this;
		}

		public Criteria andOrderAmountIsNull() {
			addCriterion("order_amount is null");
			return (Criteria) this;
		}

		public Criteria andOrderAmountIsNotNull() {
			addCriterion("order_amount is not null");
			return (Criteria) this;
		}

		public Criteria andOrderAmountEqualTo(BigDecimal value) {
			addCriterion("order_amount =", value, "orderAmount");
			return (Criteria) this;
		}

		public Criteria andOrderAmountNotEqualTo(BigDecimal value) {
			addCriterion("order_amount <>", value, "orderAmount");
			return (Criteria) this;
		}

		public Criteria andOrderAmountGreaterThan(BigDecimal value) {
			addCriterion("order_amount >", value, "orderAmount");
			return (Criteria) this;
		}

		public Criteria andOrderAmountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("order_amount >=", value, "orderAmount");
			return (Criteria) this;
		}

		public Criteria andOrderAmountLessThan(BigDecimal value) {
			addCriterion("order_amount <", value, "orderAmount");
			return (Criteria) this;
		}

		public Criteria andOrderAmountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("order_amount <=", value, "orderAmount");
			return (Criteria) this;
		}

		public Criteria andOrderAmountIn(List<BigDecimal> values) {
			addCriterion("order_amount in", values, "orderAmount");
			return (Criteria) this;
		}

		public Criteria andOrderAmountNotIn(List<BigDecimal> values) {
			addCriterion("order_amount not in", values, "orderAmount");
			return (Criteria) this;
		}

		public Criteria andOrderAmountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("order_amount between", value1, value2, "orderAmount");
			return (Criteria) this;
		}

		public Criteria andOrderAmountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("order_amount not between", value1, value2, "orderAmount");
			return (Criteria) this;
		}

		public Criteria andParticipateDateIsNull() {
			addCriterion("participate_date is null");
			return (Criteria) this;
		}

		public Criteria andParticipateDateIsNotNull() {
			addCriterion("participate_date is not null");
			return (Criteria) this;
		}

		public Criteria andParticipateDateEqualTo(Date value) {
			addCriterion("participate_date =", value, "participateDate");
			return (Criteria) this;
		}

		public Criteria andParticipateDateNotEqualTo(Date value) {
			addCriterion("participate_date <>", value, "participateDate");
			return (Criteria) this;
		}

		public Criteria andParticipateDateGreaterThan(Date value) {
			addCriterion("participate_date >", value, "participateDate");
			return (Criteria) this;
		}

		public Criteria andParticipateDateGreaterThanOrEqualTo(Date value) {
			addCriterion("participate_date >=", value, "participateDate");
			return (Criteria) this;
		}

		public Criteria andParticipateDateLessThan(Date value) {
			addCriterion("participate_date <", value, "participateDate");
			return (Criteria) this;
		}

		public Criteria andParticipateDateLessThanOrEqualTo(Date value) {
			addCriterion("participate_date <=", value, "participateDate");
			return (Criteria) this;
		}

		public Criteria andParticipateDateIn(List<Date> values) {
			addCriterion("participate_date in", values, "participateDate");
			return (Criteria) this;
		}

		public Criteria andParticipateDateNotIn(List<Date> values) {
			addCriterion("participate_date not in", values, "participateDate");
			return (Criteria) this;
		}

		public Criteria andParticipateDateBetween(Date value1, Date value2) {
			addCriterion("participate_date between", value1, value2, "participateDate");
			return (Criteria) this;
		}

		public Criteria andParticipateDateNotBetween(Date value1, Date value2) {
			addCriterion("participate_date not between", value1, value2, "participateDate");
			return (Criteria) this;
		}

		public Criteria andRewardedIsNull() {
			addCriterion("rewarded is null");
			return (Criteria) this;
		}

		public Criteria andRewardedIsNotNull() {
			addCriterion("rewarded is not null");
			return (Criteria) this;
		}

		public Criteria andRewardedEqualTo(Integer value) {
			addCriterion("rewarded =", value, "rewarded");
			return (Criteria) this;
		}

		public Criteria andRewardedNotEqualTo(Integer value) {
			addCriterion("rewarded <>", value, "rewarded");
			return (Criteria) this;
		}

		public Criteria andRewardedGreaterThan(Integer value) {
			addCriterion("rewarded >", value, "rewarded");
			return (Criteria) this;
		}

		public Criteria andRewardedGreaterThanOrEqualTo(Integer value) {
			addCriterion("rewarded >=", value, "rewarded");
			return (Criteria) this;
		}

		public Criteria andRewardedLessThan(Integer value) {
			addCriterion("rewarded <", value, "rewarded");
			return (Criteria) this;
		}

		public Criteria andRewardedLessThanOrEqualTo(Integer value) {
			addCriterion("rewarded <=", value, "rewarded");
			return (Criteria) this;
		}

		public Criteria andRewardedIn(List<Integer> values) {
			addCriterion("rewarded in", values, "rewarded");
			return (Criteria) this;
		}

		public Criteria andRewardedNotIn(List<Integer> values) {
			addCriterion("rewarded not in", values, "rewarded");
			return (Criteria) this;
		}

		public Criteria andRewardedBetween(Integer value1, Integer value2) {
			addCriterion("rewarded between", value1, value2, "rewarded");
			return (Criteria) this;
		}

		public Criteria andRewardedNotBetween(Integer value1, Integer value2) {
			addCriterion("rewarded not between", value1, value2, "rewarded");
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
	 * 只读. t_mkt_activity_record
	 * @mbg.generated
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
     * This class corresponds to the database table t_mkt_activity_record
     *
     * @mbg.generated do_not_delete_during_merge 2018-07-12 11:48:54
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }
}