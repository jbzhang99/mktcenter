package com.bizvane.mktcenterservice.models.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MktActivitySignInRewardPOExample implements Serializable {
    /**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	protected String orderByClause;
	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	protected boolean distinct;
	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	protected List<Criteria> oredCriteria;
	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public MktActivitySignInRewardPOExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
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
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * 只读. t_mkt_activity_sign_in_reward
	 * @mbg.generated  2018-07-06 19:28:16
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

		public Criteria andMktActivitySignInRewardIdIsNull() {
			addCriterion("mkt_activity_sign_in_reward_id is null");
			return (Criteria) this;
		}

		public Criteria andMktActivitySignInRewardIdIsNotNull() {
			addCriterion("mkt_activity_sign_in_reward_id is not null");
			return (Criteria) this;
		}

		public Criteria andMktActivitySignInRewardIdEqualTo(Long value) {
			addCriterion("mkt_activity_sign_in_reward_id =", value, "mktActivitySignInRewardId");
			return (Criteria) this;
		}

		public Criteria andMktActivitySignInRewardIdNotEqualTo(Long value) {
			addCriterion("mkt_activity_sign_in_reward_id <>", value, "mktActivitySignInRewardId");
			return (Criteria) this;
		}

		public Criteria andMktActivitySignInRewardIdGreaterThan(Long value) {
			addCriterion("mkt_activity_sign_in_reward_id >", value, "mktActivitySignInRewardId");
			return (Criteria) this;
		}

		public Criteria andMktActivitySignInRewardIdGreaterThanOrEqualTo(Long value) {
			addCriterion("mkt_activity_sign_in_reward_id >=", value, "mktActivitySignInRewardId");
			return (Criteria) this;
		}

		public Criteria andMktActivitySignInRewardIdLessThan(Long value) {
			addCriterion("mkt_activity_sign_in_reward_id <", value, "mktActivitySignInRewardId");
			return (Criteria) this;
		}

		public Criteria andMktActivitySignInRewardIdLessThanOrEqualTo(Long value) {
			addCriterion("mkt_activity_sign_in_reward_id <=", value, "mktActivitySignInRewardId");
			return (Criteria) this;
		}

		public Criteria andMktActivitySignInRewardIdIn(List<Long> values) {
			addCriterion("mkt_activity_sign_in_reward_id in", values, "mktActivitySignInRewardId");
			return (Criteria) this;
		}

		public Criteria andMktActivitySignInRewardIdNotIn(List<Long> values) {
			addCriterion("mkt_activity_sign_in_reward_id not in", values, "mktActivitySignInRewardId");
			return (Criteria) this;
		}

		public Criteria andMktActivitySignInRewardIdBetween(Long value1, Long value2) {
			addCriterion("mkt_activity_sign_in_reward_id between", value1, value2, "mktActivitySignInRewardId");
			return (Criteria) this;
		}

		public Criteria andMktActivitySignInRewardIdNotBetween(Long value1, Long value2) {
			addCriterion("mkt_activity_sign_in_reward_id not between", value1, value2, "mktActivitySignInRewardId");
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

		public Criteria andMktActivitySignInIdIsNull() {
			addCriterion("mkt_activity_sign_in_id is null");
			return (Criteria) this;
		}

		public Criteria andMktActivitySignInIdIsNotNull() {
			addCriterion("mkt_activity_sign_in_id is not null");
			return (Criteria) this;
		}

		public Criteria andMktActivitySignInIdEqualTo(Long value) {
			addCriterion("mkt_activity_sign_in_id =", value, "mktActivitySignInId");
			return (Criteria) this;
		}

		public Criteria andMktActivitySignInIdNotEqualTo(Long value) {
			addCriterion("mkt_activity_sign_in_id <>", value, "mktActivitySignInId");
			return (Criteria) this;
		}

		public Criteria andMktActivitySignInIdGreaterThan(Long value) {
			addCriterion("mkt_activity_sign_in_id >", value, "mktActivitySignInId");
			return (Criteria) this;
		}

		public Criteria andMktActivitySignInIdGreaterThanOrEqualTo(Long value) {
			addCriterion("mkt_activity_sign_in_id >=", value, "mktActivitySignInId");
			return (Criteria) this;
		}

		public Criteria andMktActivitySignInIdLessThan(Long value) {
			addCriterion("mkt_activity_sign_in_id <", value, "mktActivitySignInId");
			return (Criteria) this;
		}

		public Criteria andMktActivitySignInIdLessThanOrEqualTo(Long value) {
			addCriterion("mkt_activity_sign_in_id <=", value, "mktActivitySignInId");
			return (Criteria) this;
		}

		public Criteria andMktActivitySignInIdIn(List<Long> values) {
			addCriterion("mkt_activity_sign_in_id in", values, "mktActivitySignInId");
			return (Criteria) this;
		}

		public Criteria andMktActivitySignInIdNotIn(List<Long> values) {
			addCriterion("mkt_activity_sign_in_id not in", values, "mktActivitySignInId");
			return (Criteria) this;
		}

		public Criteria andMktActivitySignInIdBetween(Long value1, Long value2) {
			addCriterion("mkt_activity_sign_in_id between", value1, value2, "mktActivitySignInId");
			return (Criteria) this;
		}

		public Criteria andMktActivitySignInIdNotBetween(Long value1, Long value2) {
			addCriterion("mkt_activity_sign_in_id not between", value1, value2, "mktActivitySignInId");
			return (Criteria) this;
		}

		public Criteria andMbrCodeIsNull() {
			addCriterion("mbr_code is null");
			return (Criteria) this;
		}

		public Criteria andMbrCodeIsNotNull() {
			addCriterion("mbr_code is not null");
			return (Criteria) this;
		}

		public Criteria andMbrCodeEqualTo(String value) {
			addCriterion("mbr_code =", value, "mbrCode");
			return (Criteria) this;
		}

		public Criteria andMbrCodeNotEqualTo(String value) {
			addCriterion("mbr_code <>", value, "mbrCode");
			return (Criteria) this;
		}

		public Criteria andMbrCodeGreaterThan(String value) {
			addCriterion("mbr_code >", value, "mbrCode");
			return (Criteria) this;
		}

		public Criteria andMbrCodeGreaterThanOrEqualTo(String value) {
			addCriterion("mbr_code >=", value, "mbrCode");
			return (Criteria) this;
		}

		public Criteria andMbrCodeLessThan(String value) {
			addCriterion("mbr_code <", value, "mbrCode");
			return (Criteria) this;
		}

		public Criteria andMbrCodeLessThanOrEqualTo(String value) {
			addCriterion("mbr_code <=", value, "mbrCode");
			return (Criteria) this;
		}

		public Criteria andMbrCodeLike(String value) {
			addCriterion("mbr_code like", value, "mbrCode");
			return (Criteria) this;
		}

		public Criteria andMbrCodeNotLike(String value) {
			addCriterion("mbr_code not like", value, "mbrCode");
			return (Criteria) this;
		}

		public Criteria andMbrCodeIn(List<String> values) {
			addCriterion("mbr_code in", values, "mbrCode");
			return (Criteria) this;
		}

		public Criteria andMbrCodeNotIn(List<String> values) {
			addCriterion("mbr_code not in", values, "mbrCode");
			return (Criteria) this;
		}

		public Criteria andMbrCodeBetween(String value1, String value2) {
			addCriterion("mbr_code between", value1, value2, "mbrCode");
			return (Criteria) this;
		}

		public Criteria andMbrCodeNotBetween(String value1, String value2) {
			addCriterion("mbr_code not between", value1, value2, "mbrCode");
			return (Criteria) this;
		}

		public Criteria andIntegralIsNull() {
			addCriterion("integral is null");
			return (Criteria) this;
		}

		public Criteria andIntegralIsNotNull() {
			addCriterion("integral is not null");
			return (Criteria) this;
		}

		public Criteria andIntegralEqualTo(Integer value) {
			addCriterion("integral =", value, "integral");
			return (Criteria) this;
		}

		public Criteria andIntegralNotEqualTo(Integer value) {
			addCriterion("integral <>", value, "integral");
			return (Criteria) this;
		}

		public Criteria andIntegralGreaterThan(Integer value) {
			addCriterion("integral >", value, "integral");
			return (Criteria) this;
		}

		public Criteria andIntegralGreaterThanOrEqualTo(Integer value) {
			addCriterion("integral >=", value, "integral");
			return (Criteria) this;
		}

		public Criteria andIntegralLessThan(Integer value) {
			addCriterion("integral <", value, "integral");
			return (Criteria) this;
		}

		public Criteria andIntegralLessThanOrEqualTo(Integer value) {
			addCriterion("integral <=", value, "integral");
			return (Criteria) this;
		}

		public Criteria andIntegralIn(List<Integer> values) {
			addCriterion("integral in", values, "integral");
			return (Criteria) this;
		}

		public Criteria andIntegralNotIn(List<Integer> values) {
			addCriterion("integral not in", values, "integral");
			return (Criteria) this;
		}

		public Criteria andIntegralBetween(Integer value1, Integer value2) {
			addCriterion("integral between", value1, value2, "integral");
			return (Criteria) this;
		}

		public Criteria andIntegralNotBetween(Integer value1, Integer value2) {
			addCriterion("integral not between", value1, value2, "integral");
			return (Criteria) this;
		}

		public Criteria andCouponCodeIsNull() {
			addCriterion("coupon_code is null");
			return (Criteria) this;
		}

		public Criteria andCouponCodeIsNotNull() {
			addCriterion("coupon_code is not null");
			return (Criteria) this;
		}

		public Criteria andCouponCodeEqualTo(String value) {
			addCriterion("coupon_code =", value, "couponCode");
			return (Criteria) this;
		}

		public Criteria andCouponCodeNotEqualTo(String value) {
			addCriterion("coupon_code <>", value, "couponCode");
			return (Criteria) this;
		}

		public Criteria andCouponCodeGreaterThan(String value) {
			addCriterion("coupon_code >", value, "couponCode");
			return (Criteria) this;
		}

		public Criteria andCouponCodeGreaterThanOrEqualTo(String value) {
			addCriterion("coupon_code >=", value, "couponCode");
			return (Criteria) this;
		}

		public Criteria andCouponCodeLessThan(String value) {
			addCriterion("coupon_code <", value, "couponCode");
			return (Criteria) this;
		}

		public Criteria andCouponCodeLessThanOrEqualTo(String value) {
			addCriterion("coupon_code <=", value, "couponCode");
			return (Criteria) this;
		}

		public Criteria andCouponCodeLike(String value) {
			addCriterion("coupon_code like", value, "couponCode");
			return (Criteria) this;
		}

		public Criteria andCouponCodeNotLike(String value) {
			addCriterion("coupon_code not like", value, "couponCode");
			return (Criteria) this;
		}

		public Criteria andCouponCodeIn(List<String> values) {
			addCriterion("coupon_code in", values, "couponCode");
			return (Criteria) this;
		}

		public Criteria andCouponCodeNotIn(List<String> values) {
			addCriterion("coupon_code not in", values, "couponCode");
			return (Criteria) this;
		}

		public Criteria andCouponCodeBetween(String value1, String value2) {
			addCriterion("coupon_code between", value1, value2, "couponCode");
			return (Criteria) this;
		}

		public Criteria andCouponCodeNotBetween(String value1, String value2) {
			addCriterion("coupon_code not between", value1, value2, "couponCode");
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
	 * 只读. t_mkt_activity_sign_in_reward
	 * @mbg.generated  2018-07-06 19:28:16
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
     * This class corresponds to the database table t_mkt_activity_sign_in_reward
     *
     * @mbg.generated do_not_delete_during_merge 2018-07-06 18:29:38
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }
}