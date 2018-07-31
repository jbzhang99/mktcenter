package com.bizvane.mktcenterservice.models.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MktTaskRecordPOExample implements Serializable {
    /**
	 * 只读. 
	 * @mbg.generated  2018-07-31 14:19:14
	 */
	protected String orderByClause;
	/**
	 * 只读. 
	 * @mbg.generated  2018-07-31 14:19:14
	 */
	protected boolean distinct;
	/**
	 * 只读. 
	 * @mbg.generated  2018-07-31 14:19:14
	 */
	protected List<Criteria> oredCriteria;
	/**
	 * 只读. 
	 * @mbg.generated  2018-07-31 14:19:14
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-31 14:19:14
	 */
	public MktTaskRecordPOExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-31 14:19:14
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-31 14:19:14
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-31 14:19:14
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-31 14:19:14
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-31 14:19:14
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-31 14:19:14
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-31 14:19:14
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-31 14:19:14
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
	 * @mbg.generated  2018-07-31 14:19:14
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-31 14:19:14
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * 只读. t_mkt_task_record
	 * @mbg.generated  2018-07-31 14:19:14
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

		public Criteria andMktTaskRecordIdIsNull() {
			addCriterion("mkt_task_record_id is null");
			return (Criteria) this;
		}

		public Criteria andMktTaskRecordIdIsNotNull() {
			addCriterion("mkt_task_record_id is not null");
			return (Criteria) this;
		}

		public Criteria andMktTaskRecordIdEqualTo(Long value) {
			addCriterion("mkt_task_record_id =", value, "mktTaskRecordId");
			return (Criteria) this;
		}

		public Criteria andMktTaskRecordIdNotEqualTo(Long value) {
			addCriterion("mkt_task_record_id <>", value, "mktTaskRecordId");
			return (Criteria) this;
		}

		public Criteria andMktTaskRecordIdGreaterThan(Long value) {
			addCriterion("mkt_task_record_id >", value, "mktTaskRecordId");
			return (Criteria) this;
		}

		public Criteria andMktTaskRecordIdGreaterThanOrEqualTo(Long value) {
			addCriterion("mkt_task_record_id >=", value, "mktTaskRecordId");
			return (Criteria) this;
		}

		public Criteria andMktTaskRecordIdLessThan(Long value) {
			addCriterion("mkt_task_record_id <", value, "mktTaskRecordId");
			return (Criteria) this;
		}

		public Criteria andMktTaskRecordIdLessThanOrEqualTo(Long value) {
			addCriterion("mkt_task_record_id <=", value, "mktTaskRecordId");
			return (Criteria) this;
		}

		public Criteria andMktTaskRecordIdIn(List<Long> values) {
			addCriterion("mkt_task_record_id in", values, "mktTaskRecordId");
			return (Criteria) this;
		}

		public Criteria andMktTaskRecordIdNotIn(List<Long> values) {
			addCriterion("mkt_task_record_id not in", values, "mktTaskRecordId");
			return (Criteria) this;
		}

		public Criteria andMktTaskRecordIdBetween(Long value1, Long value2) {
			addCriterion("mkt_task_record_id between", value1, value2, "mktTaskRecordId");
			return (Criteria) this;
		}

		public Criteria andMktTaskRecordIdNotBetween(Long value1, Long value2) {
			addCriterion("mkt_task_record_id not between", value1, value2, "mktTaskRecordId");
			return (Criteria) this;
		}

		public Criteria andTaskTypeIsNull() {
			addCriterion("task_type is null");
			return (Criteria) this;
		}

		public Criteria andTaskTypeIsNotNull() {
			addCriterion("task_type is not null");
			return (Criteria) this;
		}

		public Criteria andTaskTypeEqualTo(Integer value) {
			addCriterion("task_type =", value, "taskType");
			return (Criteria) this;
		}

		public Criteria andTaskTypeNotEqualTo(Integer value) {
			addCriterion("task_type <>", value, "taskType");
			return (Criteria) this;
		}

		public Criteria andTaskTypeGreaterThan(Integer value) {
			addCriterion("task_type >", value, "taskType");
			return (Criteria) this;
		}

		public Criteria andTaskTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("task_type >=", value, "taskType");
			return (Criteria) this;
		}

		public Criteria andTaskTypeLessThan(Integer value) {
			addCriterion("task_type <", value, "taskType");
			return (Criteria) this;
		}

		public Criteria andTaskTypeLessThanOrEqualTo(Integer value) {
			addCriterion("task_type <=", value, "taskType");
			return (Criteria) this;
		}

		public Criteria andTaskTypeIn(List<Integer> values) {
			addCriterion("task_type in", values, "taskType");
			return (Criteria) this;
		}

		public Criteria andTaskTypeNotIn(List<Integer> values) {
			addCriterion("task_type not in", values, "taskType");
			return (Criteria) this;
		}

		public Criteria andTaskTypeBetween(Integer value1, Integer value2) {
			addCriterion("task_type between", value1, value2, "taskType");
			return (Criteria) this;
		}

		public Criteria andTaskTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("task_type not between", value1, value2, "taskType");
			return (Criteria) this;
		}

		public Criteria andTaskIdIsNull() {
			addCriterion("task_id is null");
			return (Criteria) this;
		}

		public Criteria andTaskIdIsNotNull() {
			addCriterion("task_id is not null");
			return (Criteria) this;
		}

		public Criteria andTaskIdEqualTo(Long value) {
			addCriterion("task_id =", value, "taskId");
			return (Criteria) this;
		}

		public Criteria andTaskIdNotEqualTo(Long value) {
			addCriterion("task_id <>", value, "taskId");
			return (Criteria) this;
		}

		public Criteria andTaskIdGreaterThan(Long value) {
			addCriterion("task_id >", value, "taskId");
			return (Criteria) this;
		}

		public Criteria andTaskIdGreaterThanOrEqualTo(Long value) {
			addCriterion("task_id >=", value, "taskId");
			return (Criteria) this;
		}

		public Criteria andTaskIdLessThan(Long value) {
			addCriterion("task_id <", value, "taskId");
			return (Criteria) this;
		}

		public Criteria andTaskIdLessThanOrEqualTo(Long value) {
			addCriterion("task_id <=", value, "taskId");
			return (Criteria) this;
		}

		public Criteria andTaskIdIn(List<Long> values) {
			addCriterion("task_id in", values, "taskId");
			return (Criteria) this;
		}

		public Criteria andTaskIdNotIn(List<Long> values) {
			addCriterion("task_id not in", values, "taskId");
			return (Criteria) this;
		}

		public Criteria andTaskIdBetween(Long value1, Long value2) {
			addCriterion("task_id between", value1, value2, "taskId");
			return (Criteria) this;
		}

		public Criteria andTaskIdNotBetween(Long value1, Long value2) {
			addCriterion("task_id not between", value1, value2, "taskId");
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

		public Criteria andShareTimesIsNull() {
			addCriterion("share_times is null");
			return (Criteria) this;
		}

		public Criteria andShareTimesIsNotNull() {
			addCriterion("share_times is not null");
			return (Criteria) this;
		}

		public Criteria andShareTimesEqualTo(Integer value) {
			addCriterion("share_times =", value, "shareTimes");
			return (Criteria) this;
		}

		public Criteria andShareTimesNotEqualTo(Integer value) {
			addCriterion("share_times <>", value, "shareTimes");
			return (Criteria) this;
		}

		public Criteria andShareTimesGreaterThan(Integer value) {
			addCriterion("share_times >", value, "shareTimes");
			return (Criteria) this;
		}

		public Criteria andShareTimesGreaterThanOrEqualTo(Integer value) {
			addCriterion("share_times >=", value, "shareTimes");
			return (Criteria) this;
		}

		public Criteria andShareTimesLessThan(Integer value) {
			addCriterion("share_times <", value, "shareTimes");
			return (Criteria) this;
		}

		public Criteria andShareTimesLessThanOrEqualTo(Integer value) {
			addCriterion("share_times <=", value, "shareTimes");
			return (Criteria) this;
		}

		public Criteria andShareTimesIn(List<Integer> values) {
			addCriterion("share_times in", values, "shareTimes");
			return (Criteria) this;
		}

		public Criteria andShareTimesNotIn(List<Integer> values) {
			addCriterion("share_times not in", values, "shareTimes");
			return (Criteria) this;
		}

		public Criteria andShareTimesBetween(Integer value1, Integer value2) {
			addCriterion("share_times between", value1, value2, "shareTimes");
			return (Criteria) this;
		}

		public Criteria andShareTimesNotBetween(Integer value1, Integer value2) {
			addCriterion("share_times not between", value1, value2, "shareTimes");
			return (Criteria) this;
		}

		public Criteria andConsumeAmountIsNull() {
			addCriterion("consume_amount is null");
			return (Criteria) this;
		}

		public Criteria andConsumeAmountIsNotNull() {
			addCriterion("consume_amount is not null");
			return (Criteria) this;
		}

		public Criteria andConsumeAmountEqualTo(BigDecimal value) {
			addCriterion("consume_amount =", value, "consumeAmount");
			return (Criteria) this;
		}

		public Criteria andConsumeAmountNotEqualTo(BigDecimal value) {
			addCriterion("consume_amount <>", value, "consumeAmount");
			return (Criteria) this;
		}

		public Criteria andConsumeAmountGreaterThan(BigDecimal value) {
			addCriterion("consume_amount >", value, "consumeAmount");
			return (Criteria) this;
		}

		public Criteria andConsumeAmountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("consume_amount >=", value, "consumeAmount");
			return (Criteria) this;
		}

		public Criteria andConsumeAmountLessThan(BigDecimal value) {
			addCriterion("consume_amount <", value, "consumeAmount");
			return (Criteria) this;
		}

		public Criteria andConsumeAmountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("consume_amount <=", value, "consumeAmount");
			return (Criteria) this;
		}

		public Criteria andConsumeAmountIn(List<BigDecimal> values) {
			addCriterion("consume_amount in", values, "consumeAmount");
			return (Criteria) this;
		}

		public Criteria andConsumeAmountNotIn(List<BigDecimal> values) {
			addCriterion("consume_amount not in", values, "consumeAmount");
			return (Criteria) this;
		}

		public Criteria andConsumeAmountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("consume_amount between", value1, value2, "consumeAmount");
			return (Criteria) this;
		}

		public Criteria andConsumeAmountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("consume_amount not between", value1, value2, "consumeAmount");
			return (Criteria) this;
		}

		public Criteria andParticipateIsNull() {
			addCriterion("participate is null");
			return (Criteria) this;
		}

		public Criteria andParticipateIsNotNull() {
			addCriterion("participate is not null");
			return (Criteria) this;
		}

		public Criteria andParticipateEqualTo(Date value) {
			addCriterion("participate =", value, "participate");
			return (Criteria) this;
		}

		public Criteria andParticipateNotEqualTo(Date value) {
			addCriterion("participate <>", value, "participate");
			return (Criteria) this;
		}

		public Criteria andParticipateGreaterThan(Date value) {
			addCriterion("participate >", value, "participate");
			return (Criteria) this;
		}

		public Criteria andParticipateGreaterThanOrEqualTo(Date value) {
			addCriterion("participate >=", value, "participate");
			return (Criteria) this;
		}

		public Criteria andParticipateLessThan(Date value) {
			addCriterion("participate <", value, "participate");
			return (Criteria) this;
		}

		public Criteria andParticipateLessThanOrEqualTo(Date value) {
			addCriterion("participate <=", value, "participate");
			return (Criteria) this;
		}

		public Criteria andParticipateIn(List<Date> values) {
			addCriterion("participate in", values, "participate");
			return (Criteria) this;
		}

		public Criteria andParticipateNotIn(List<Date> values) {
			addCriterion("participate not in", values, "participate");
			return (Criteria) this;
		}

		public Criteria andParticipateBetween(Date value1, Date value2) {
			addCriterion("participate between", value1, value2, "participate");
			return (Criteria) this;
		}

		public Criteria andParticipateNotBetween(Date value1, Date value2) {
			addCriterion("participate not between", value1, value2, "participate");
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
	 * 只读. t_mkt_task_record
	 * @mbg.generated  2018-07-31 14:19:14
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
     * This class corresponds to the database table t_mkt_task_record
     *
     * @mbg.generated do_not_delete_during_merge 2018-07-12 11:48:54
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }
}