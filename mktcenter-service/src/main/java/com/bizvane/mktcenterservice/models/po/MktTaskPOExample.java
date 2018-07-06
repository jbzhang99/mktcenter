package com.bizvane.mktcenterservice.models.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MktTaskPOExample implements Serializable {
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
	public MktTaskPOExample() {
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
	 * 只读. t_mkt_task
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

		public Criteria andMktTaskIdIsNull() {
			addCriterion("mkt_task_id is null");
			return (Criteria) this;
		}

		public Criteria andMktTaskIdIsNotNull() {
			addCriterion("mkt_task_id is not null");
			return (Criteria) this;
		}

		public Criteria andMktTaskIdEqualTo(Long value) {
			addCriterion("mkt_task_id =", value, "mktTaskId");
			return (Criteria) this;
		}

		public Criteria andMktTaskIdNotEqualTo(Long value) {
			addCriterion("mkt_task_id <>", value, "mktTaskId");
			return (Criteria) this;
		}

		public Criteria andMktTaskIdGreaterThan(Long value) {
			addCriterion("mkt_task_id >", value, "mktTaskId");
			return (Criteria) this;
		}

		public Criteria andMktTaskIdGreaterThanOrEqualTo(Long value) {
			addCriterion("mkt_task_id >=", value, "mktTaskId");
			return (Criteria) this;
		}

		public Criteria andMktTaskIdLessThan(Long value) {
			addCriterion("mkt_task_id <", value, "mktTaskId");
			return (Criteria) this;
		}

		public Criteria andMktTaskIdLessThanOrEqualTo(Long value) {
			addCriterion("mkt_task_id <=", value, "mktTaskId");
			return (Criteria) this;
		}

		public Criteria andMktTaskIdIn(List<Long> values) {
			addCriterion("mkt_task_id in", values, "mktTaskId");
			return (Criteria) this;
		}

		public Criteria andMktTaskIdNotIn(List<Long> values) {
			addCriterion("mkt_task_id not in", values, "mktTaskId");
			return (Criteria) this;
		}

		public Criteria andMktTaskIdBetween(Long value1, Long value2) {
			addCriterion("mkt_task_id between", value1, value2, "mktTaskId");
			return (Criteria) this;
		}

		public Criteria andMktTaskIdNotBetween(Long value1, Long value2) {
			addCriterion("mkt_task_id not between", value1, value2, "mktTaskId");
			return (Criteria) this;
		}

		public Criteria andTaskCodeIsNull() {
			addCriterion("task_code is null");
			return (Criteria) this;
		}

		public Criteria andTaskCodeIsNotNull() {
			addCriterion("task_code is not null");
			return (Criteria) this;
		}

		public Criteria andTaskCodeEqualTo(String value) {
			addCriterion("task_code =", value, "taskCode");
			return (Criteria) this;
		}

		public Criteria andTaskCodeNotEqualTo(String value) {
			addCriterion("task_code <>", value, "taskCode");
			return (Criteria) this;
		}

		public Criteria andTaskCodeGreaterThan(String value) {
			addCriterion("task_code >", value, "taskCode");
			return (Criteria) this;
		}

		public Criteria andTaskCodeGreaterThanOrEqualTo(String value) {
			addCriterion("task_code >=", value, "taskCode");
			return (Criteria) this;
		}

		public Criteria andTaskCodeLessThan(String value) {
			addCriterion("task_code <", value, "taskCode");
			return (Criteria) this;
		}

		public Criteria andTaskCodeLessThanOrEqualTo(String value) {
			addCriterion("task_code <=", value, "taskCode");
			return (Criteria) this;
		}

		public Criteria andTaskCodeLike(String value) {
			addCriterion("task_code like", value, "taskCode");
			return (Criteria) this;
		}

		public Criteria andTaskCodeNotLike(String value) {
			addCriterion("task_code not like", value, "taskCode");
			return (Criteria) this;
		}

		public Criteria andTaskCodeIn(List<String> values) {
			addCriterion("task_code in", values, "taskCode");
			return (Criteria) this;
		}

		public Criteria andTaskCodeNotIn(List<String> values) {
			addCriterion("task_code not in", values, "taskCode");
			return (Criteria) this;
		}

		public Criteria andTaskCodeBetween(String value1, String value2) {
			addCriterion("task_code between", value1, value2, "taskCode");
			return (Criteria) this;
		}

		public Criteria andTaskCodeNotBetween(String value1, String value2) {
			addCriterion("task_code not between", value1, value2, "taskCode");
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

		public Criteria andTaskNameIsNull() {
			addCriterion("task_name is null");
			return (Criteria) this;
		}

		public Criteria andTaskNameIsNotNull() {
			addCriterion("task_name is not null");
			return (Criteria) this;
		}

		public Criteria andTaskNameEqualTo(String value) {
			addCriterion("task_name =", value, "taskName");
			return (Criteria) this;
		}

		public Criteria andTaskNameNotEqualTo(String value) {
			addCriterion("task_name <>", value, "taskName");
			return (Criteria) this;
		}

		public Criteria andTaskNameGreaterThan(String value) {
			addCriterion("task_name >", value, "taskName");
			return (Criteria) this;
		}

		public Criteria andTaskNameGreaterThanOrEqualTo(String value) {
			addCriterion("task_name >=", value, "taskName");
			return (Criteria) this;
		}

		public Criteria andTaskNameLessThan(String value) {
			addCriterion("task_name <", value, "taskName");
			return (Criteria) this;
		}

		public Criteria andTaskNameLessThanOrEqualTo(String value) {
			addCriterion("task_name <=", value, "taskName");
			return (Criteria) this;
		}

		public Criteria andTaskNameLike(String value) {
			addCriterion("task_name like", value, "taskName");
			return (Criteria) this;
		}

		public Criteria andTaskNameNotLike(String value) {
			addCriterion("task_name not like", value, "taskName");
			return (Criteria) this;
		}

		public Criteria andTaskNameIn(List<String> values) {
			addCriterion("task_name in", values, "taskName");
			return (Criteria) this;
		}

		public Criteria andTaskNameNotIn(List<String> values) {
			addCriterion("task_name not in", values, "taskName");
			return (Criteria) this;
		}

		public Criteria andTaskNameBetween(String value1, String value2) {
			addCriterion("task_name between", value1, value2, "taskName");
			return (Criteria) this;
		}

		public Criteria andTaskNameNotBetween(String value1, String value2) {
			addCriterion("task_name not between", value1, value2, "taskName");
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

		public Criteria andShareTitleIsNull() {
			addCriterion("share_title is null");
			return (Criteria) this;
		}

		public Criteria andShareTitleIsNotNull() {
			addCriterion("share_title is not null");
			return (Criteria) this;
		}

		public Criteria andShareTitleEqualTo(String value) {
			addCriterion("share_title =", value, "shareTitle");
			return (Criteria) this;
		}

		public Criteria andShareTitleNotEqualTo(String value) {
			addCriterion("share_title <>", value, "shareTitle");
			return (Criteria) this;
		}

		public Criteria andShareTitleGreaterThan(String value) {
			addCriterion("share_title >", value, "shareTitle");
			return (Criteria) this;
		}

		public Criteria andShareTitleGreaterThanOrEqualTo(String value) {
			addCriterion("share_title >=", value, "shareTitle");
			return (Criteria) this;
		}

		public Criteria andShareTitleLessThan(String value) {
			addCriterion("share_title <", value, "shareTitle");
			return (Criteria) this;
		}

		public Criteria andShareTitleLessThanOrEqualTo(String value) {
			addCriterion("share_title <=", value, "shareTitle");
			return (Criteria) this;
		}

		public Criteria andShareTitleLike(String value) {
			addCriterion("share_title like", value, "shareTitle");
			return (Criteria) this;
		}

		public Criteria andShareTitleNotLike(String value) {
			addCriterion("share_title not like", value, "shareTitle");
			return (Criteria) this;
		}

		public Criteria andShareTitleIn(List<String> values) {
			addCriterion("share_title in", values, "shareTitle");
			return (Criteria) this;
		}

		public Criteria andShareTitleNotIn(List<String> values) {
			addCriterion("share_title not in", values, "shareTitle");
			return (Criteria) this;
		}

		public Criteria andShareTitleBetween(String value1, String value2) {
			addCriterion("share_title between", value1, value2, "shareTitle");
			return (Criteria) this;
		}

		public Criteria andShareTitleNotBetween(String value1, String value2) {
			addCriterion("share_title not between", value1, value2, "shareTitle");
			return (Criteria) this;
		}

		public Criteria andInviteMbrNumIsNull() {
			addCriterion("invite_mbr_num is null");
			return (Criteria) this;
		}

		public Criteria andInviteMbrNumIsNotNull() {
			addCriterion("invite_mbr_num is not null");
			return (Criteria) this;
		}

		public Criteria andInviteMbrNumEqualTo(Integer value) {
			addCriterion("invite_mbr_num =", value, "inviteMbrNum");
			return (Criteria) this;
		}

		public Criteria andInviteMbrNumNotEqualTo(Integer value) {
			addCriterion("invite_mbr_num <>", value, "inviteMbrNum");
			return (Criteria) this;
		}

		public Criteria andInviteMbrNumGreaterThan(Integer value) {
			addCriterion("invite_mbr_num >", value, "inviteMbrNum");
			return (Criteria) this;
		}

		public Criteria andInviteMbrNumGreaterThanOrEqualTo(Integer value) {
			addCriterion("invite_mbr_num >=", value, "inviteMbrNum");
			return (Criteria) this;
		}

		public Criteria andInviteMbrNumLessThan(Integer value) {
			addCriterion("invite_mbr_num <", value, "inviteMbrNum");
			return (Criteria) this;
		}

		public Criteria andInviteMbrNumLessThanOrEqualTo(Integer value) {
			addCriterion("invite_mbr_num <=", value, "inviteMbrNum");
			return (Criteria) this;
		}

		public Criteria andInviteMbrNumIn(List<Integer> values) {
			addCriterion("invite_mbr_num in", values, "inviteMbrNum");
			return (Criteria) this;
		}

		public Criteria andInviteMbrNumNotIn(List<Integer> values) {
			addCriterion("invite_mbr_num not in", values, "inviteMbrNum");
			return (Criteria) this;
		}

		public Criteria andInviteMbrNumBetween(Integer value1, Integer value2) {
			addCriterion("invite_mbr_num between", value1, value2, "inviteMbrNum");
			return (Criteria) this;
		}

		public Criteria andInviteMbrNumNotBetween(Integer value1, Integer value2) {
			addCriterion("invite_mbr_num not between", value1, value2, "inviteMbrNum");
			return (Criteria) this;
		}

		public Criteria andPointIsNull() {
			addCriterion("point is null");
			return (Criteria) this;
		}

		public Criteria andPointIsNotNull() {
			addCriterion("point is not null");
			return (Criteria) this;
		}

		public Criteria andPointEqualTo(Integer value) {
			addCriterion("point =", value, "point");
			return (Criteria) this;
		}

		public Criteria andPointNotEqualTo(Integer value) {
			addCriterion("point <>", value, "point");
			return (Criteria) this;
		}

		public Criteria andPointGreaterThan(Integer value) {
			addCriterion("point >", value, "point");
			return (Criteria) this;
		}

		public Criteria andPointGreaterThanOrEqualTo(Integer value) {
			addCriterion("point >=", value, "point");
			return (Criteria) this;
		}

		public Criteria andPointLessThan(Integer value) {
			addCriterion("point <", value, "point");
			return (Criteria) this;
		}

		public Criteria andPointLessThanOrEqualTo(Integer value) {
			addCriterion("point <=", value, "point");
			return (Criteria) this;
		}

		public Criteria andPointIn(List<Integer> values) {
			addCriterion("point in", values, "point");
			return (Criteria) this;
		}

		public Criteria andPointNotIn(List<Integer> values) {
			addCriterion("point not in", values, "point");
			return (Criteria) this;
		}

		public Criteria andPointBetween(Integer value1, Integer value2) {
			addCriterion("point between", value1, value2, "point");
			return (Criteria) this;
		}

		public Criteria andPointNotBetween(Integer value1, Integer value2) {
			addCriterion("point not between", value1, value2, "point");
			return (Criteria) this;
		}

		public Criteria andCheckStatusIsNull() {
			addCriterion("check_status is null");
			return (Criteria) this;
		}

		public Criteria andCheckStatusIsNotNull() {
			addCriterion("check_status is not null");
			return (Criteria) this;
		}

		public Criteria andCheckStatusEqualTo(Integer value) {
			addCriterion("check_status =", value, "checkStatus");
			return (Criteria) this;
		}

		public Criteria andCheckStatusNotEqualTo(Integer value) {
			addCriterion("check_status <>", value, "checkStatus");
			return (Criteria) this;
		}

		public Criteria andCheckStatusGreaterThan(Integer value) {
			addCriterion("check_status >", value, "checkStatus");
			return (Criteria) this;
		}

		public Criteria andCheckStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("check_status >=", value, "checkStatus");
			return (Criteria) this;
		}

		public Criteria andCheckStatusLessThan(Integer value) {
			addCriterion("check_status <", value, "checkStatus");
			return (Criteria) this;
		}

		public Criteria andCheckStatusLessThanOrEqualTo(Integer value) {
			addCriterion("check_status <=", value, "checkStatus");
			return (Criteria) this;
		}

		public Criteria andCheckStatusIn(List<Integer> values) {
			addCriterion("check_status in", values, "checkStatus");
			return (Criteria) this;
		}

		public Criteria andCheckStatusNotIn(List<Integer> values) {
			addCriterion("check_status not in", values, "checkStatus");
			return (Criteria) this;
		}

		public Criteria andCheckStatusBetween(Integer value1, Integer value2) {
			addCriterion("check_status between", value1, value2, "checkStatus");
			return (Criteria) this;
		}

		public Criteria andCheckStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("check_status not between", value1, value2, "checkStatus");
			return (Criteria) this;
		}

		public Criteria andTaskStatusIsNull() {
			addCriterion("task_status is null");
			return (Criteria) this;
		}

		public Criteria andTaskStatusIsNotNull() {
			addCriterion("task_status is not null");
			return (Criteria) this;
		}

		public Criteria andTaskStatusEqualTo(Integer value) {
			addCriterion("task_status =", value, "taskStatus");
			return (Criteria) this;
		}

		public Criteria andTaskStatusNotEqualTo(Integer value) {
			addCriterion("task_status <>", value, "taskStatus");
			return (Criteria) this;
		}

		public Criteria andTaskStatusGreaterThan(Integer value) {
			addCriterion("task_status >", value, "taskStatus");
			return (Criteria) this;
		}

		public Criteria andTaskStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("task_status >=", value, "taskStatus");
			return (Criteria) this;
		}

		public Criteria andTaskStatusLessThan(Integer value) {
			addCriterion("task_status <", value, "taskStatus");
			return (Criteria) this;
		}

		public Criteria andTaskStatusLessThanOrEqualTo(Integer value) {
			addCriterion("task_status <=", value, "taskStatus");
			return (Criteria) this;
		}

		public Criteria andTaskStatusIn(List<Integer> values) {
			addCriterion("task_status in", values, "taskStatus");
			return (Criteria) this;
		}

		public Criteria andTaskStatusNotIn(List<Integer> values) {
			addCriterion("task_status not in", values, "taskStatus");
			return (Criteria) this;
		}

		public Criteria andTaskStatusBetween(Integer value1, Integer value2) {
			addCriterion("task_status between", value1, value2, "taskStatus");
			return (Criteria) this;
		}

		public Criteria andTaskStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("task_status not between", value1, value2, "taskStatus");
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
	 * 只读. t_mkt_task
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
     * This class corresponds to the database table t_mkt_task
     *
     * @mbg.generated do_not_delete_during_merge 2018-07-06 18:29:38
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }
}