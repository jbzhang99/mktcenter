package com.bizvane.mktcenterservice.models.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MktActivityUpgradePOExample implements Serializable {
    /**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	protected String orderByClause;
	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	protected boolean distinct;
	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	protected List<Criteria> oredCriteria;
	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public MktActivityUpgradePOExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
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
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * 只读. t_mkt_activity_upgrade
	 * @mbg.generated  2018-07-14 13:26:02
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

		public Criteria andMktActivityUpgradeIdIsNull() {
			addCriterion("mkt_activity_upgrade_id is null");
			return (Criteria) this;
		}

		public Criteria andMktActivityUpgradeIdIsNotNull() {
			addCriterion("mkt_activity_upgrade_id is not null");
			return (Criteria) this;
		}

		public Criteria andMktActivityUpgradeIdEqualTo(Long value) {
			addCriterion("mkt_activity_upgrade_id =", value, "mktActivityUpgradeId");
			return (Criteria) this;
		}

		public Criteria andMktActivityUpgradeIdNotEqualTo(Long value) {
			addCriterion("mkt_activity_upgrade_id <>", value, "mktActivityUpgradeId");
			return (Criteria) this;
		}

		public Criteria andMktActivityUpgradeIdGreaterThan(Long value) {
			addCriterion("mkt_activity_upgrade_id >", value, "mktActivityUpgradeId");
			return (Criteria) this;
		}

		public Criteria andMktActivityUpgradeIdGreaterThanOrEqualTo(Long value) {
			addCriterion("mkt_activity_upgrade_id >=", value, "mktActivityUpgradeId");
			return (Criteria) this;
		}

		public Criteria andMktActivityUpgradeIdLessThan(Long value) {
			addCriterion("mkt_activity_upgrade_id <", value, "mktActivityUpgradeId");
			return (Criteria) this;
		}

		public Criteria andMktActivityUpgradeIdLessThanOrEqualTo(Long value) {
			addCriterion("mkt_activity_upgrade_id <=", value, "mktActivityUpgradeId");
			return (Criteria) this;
		}

		public Criteria andMktActivityUpgradeIdIn(List<Long> values) {
			addCriterion("mkt_activity_upgrade_id in", values, "mktActivityUpgradeId");
			return (Criteria) this;
		}

		public Criteria andMktActivityUpgradeIdNotIn(List<Long> values) {
			addCriterion("mkt_activity_upgrade_id not in", values, "mktActivityUpgradeId");
			return (Criteria) this;
		}

		public Criteria andMktActivityUpgradeIdBetween(Long value1, Long value2) {
			addCriterion("mkt_activity_upgrade_id between", value1, value2, "mktActivityUpgradeId");
			return (Criteria) this;
		}

		public Criteria andMktActivityUpgradeIdNotBetween(Long value1, Long value2) {
			addCriterion("mkt_activity_upgrade_id not between", value1, value2, "mktActivityUpgradeId");
			return (Criteria) this;
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

		public Criteria andMbrLevelCodeIsNull() {
			addCriterion("mbr_level_code is null");
			return (Criteria) this;
		}

		public Criteria andMbrLevelCodeIsNotNull() {
			addCriterion("mbr_level_code is not null");
			return (Criteria) this;
		}

		public Criteria andMbrLevelCodeEqualTo(String value) {
			addCriterion("mbr_level_code =", value, "mbrLevelCode");
			return (Criteria) this;
		}

		public Criteria andMbrLevelCodeNotEqualTo(String value) {
			addCriterion("mbr_level_code <>", value, "mbrLevelCode");
			return (Criteria) this;
		}

		public Criteria andMbrLevelCodeGreaterThan(String value) {
			addCriterion("mbr_level_code >", value, "mbrLevelCode");
			return (Criteria) this;
		}

		public Criteria andMbrLevelCodeGreaterThanOrEqualTo(String value) {
			addCriterion("mbr_level_code >=", value, "mbrLevelCode");
			return (Criteria) this;
		}

		public Criteria andMbrLevelCodeLessThan(String value) {
			addCriterion("mbr_level_code <", value, "mbrLevelCode");
			return (Criteria) this;
		}

		public Criteria andMbrLevelCodeLessThanOrEqualTo(String value) {
			addCriterion("mbr_level_code <=", value, "mbrLevelCode");
			return (Criteria) this;
		}

		public Criteria andMbrLevelCodeLike(String value) {
			addCriterion("mbr_level_code like", value, "mbrLevelCode");
			return (Criteria) this;
		}

		public Criteria andMbrLevelCodeNotLike(String value) {
			addCriterion("mbr_level_code not like", value, "mbrLevelCode");
			return (Criteria) this;
		}

		public Criteria andMbrLevelCodeIn(List<String> values) {
			addCriterion("mbr_level_code in", values, "mbrLevelCode");
			return (Criteria) this;
		}

		public Criteria andMbrLevelCodeNotIn(List<String> values) {
			addCriterion("mbr_level_code not in", values, "mbrLevelCode");
			return (Criteria) this;
		}

		public Criteria andMbrLevelCodeBetween(String value1, String value2) {
			addCriterion("mbr_level_code between", value1, value2, "mbrLevelCode");
			return (Criteria) this;
		}

		public Criteria andMbrLevelCodeNotBetween(String value1, String value2) {
			addCriterion("mbr_level_code not between", value1, value2, "mbrLevelCode");
			return (Criteria) this;
		}

		public Criteria andMbrLevelNameIsNull() {
			addCriterion("mbr_level_name is null");
			return (Criteria) this;
		}

		public Criteria andMbrLevelNameIsNotNull() {
			addCriterion("mbr_level_name is not null");
			return (Criteria) this;
		}

		public Criteria andMbrLevelNameEqualTo(String value) {
			addCriterion("mbr_level_name =", value, "mbrLevelName");
			return (Criteria) this;
		}

		public Criteria andMbrLevelNameNotEqualTo(String value) {
			addCriterion("mbr_level_name <>", value, "mbrLevelName");
			return (Criteria) this;
		}

		public Criteria andMbrLevelNameGreaterThan(String value) {
			addCriterion("mbr_level_name >", value, "mbrLevelName");
			return (Criteria) this;
		}

		public Criteria andMbrLevelNameGreaterThanOrEqualTo(String value) {
			addCriterion("mbr_level_name >=", value, "mbrLevelName");
			return (Criteria) this;
		}

		public Criteria andMbrLevelNameLessThan(String value) {
			addCriterion("mbr_level_name <", value, "mbrLevelName");
			return (Criteria) this;
		}

		public Criteria andMbrLevelNameLessThanOrEqualTo(String value) {
			addCriterion("mbr_level_name <=", value, "mbrLevelName");
			return (Criteria) this;
		}

		public Criteria andMbrLevelNameLike(String value) {
			addCriterion("mbr_level_name like", value, "mbrLevelName");
			return (Criteria) this;
		}

		public Criteria andMbrLevelNameNotLike(String value) {
			addCriterion("mbr_level_name not like", value, "mbrLevelName");
			return (Criteria) this;
		}

		public Criteria andMbrLevelNameIn(List<String> values) {
			addCriterion("mbr_level_name in", values, "mbrLevelName");
			return (Criteria) this;
		}

		public Criteria andMbrLevelNameNotIn(List<String> values) {
			addCriterion("mbr_level_name not in", values, "mbrLevelName");
			return (Criteria) this;
		}

		public Criteria andMbrLevelNameBetween(String value1, String value2) {
			addCriterion("mbr_level_name between", value1, value2, "mbrLevelName");
			return (Criteria) this;
		}

		public Criteria andMbrLevelNameNotBetween(String value1, String value2) {
			addCriterion("mbr_level_name not between", value1, value2, "mbrLevelName");
			return (Criteria) this;
		}

		public Criteria andMemberTypeIsNull() {
			addCriterion("member_type is null");
			return (Criteria) this;
		}

		public Criteria andMemberTypeIsNotNull() {
			addCriterion("member_type is not null");
			return (Criteria) this;
		}

		public Criteria andMemberTypeEqualTo(Integer value) {
			addCriterion("member_type =", value, "memberType");
			return (Criteria) this;
		}

		public Criteria andMemberTypeNotEqualTo(Integer value) {
			addCriterion("member_type <>", value, "memberType");
			return (Criteria) this;
		}

		public Criteria andMemberTypeGreaterThan(Integer value) {
			addCriterion("member_type >", value, "memberType");
			return (Criteria) this;
		}

		public Criteria andMemberTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("member_type >=", value, "memberType");
			return (Criteria) this;
		}

		public Criteria andMemberTypeLessThan(Integer value) {
			addCriterion("member_type <", value, "memberType");
			return (Criteria) this;
		}

		public Criteria andMemberTypeLessThanOrEqualTo(Integer value) {
			addCriterion("member_type <=", value, "memberType");
			return (Criteria) this;
		}

		public Criteria andMemberTypeIn(List<Integer> values) {
			addCriterion("member_type in", values, "memberType");
			return (Criteria) this;
		}

		public Criteria andMemberTypeNotIn(List<Integer> values) {
			addCriterion("member_type not in", values, "memberType");
			return (Criteria) this;
		}

		public Criteria andMemberTypeBetween(Integer value1, Integer value2) {
			addCriterion("member_type between", value1, value2, "memberType");
			return (Criteria) this;
		}

		public Criteria andMemberTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("member_type not between", value1, value2, "memberType");
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
	 * 只读. t_mkt_activity_upgrade
	 * @mbg.generated  2018-07-14 13:26:02
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
     * This class corresponds to the database table t_mkt_activity_upgrade
     *
     * @mbg.generated do_not_delete_during_merge 2018-07-12 11:48:54
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }
}