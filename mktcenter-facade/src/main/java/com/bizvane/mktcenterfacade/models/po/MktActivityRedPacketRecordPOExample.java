package com.bizvane.mktcenterfacade.models.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MktActivityRedPacketRecordPOExample implements Serializable {
    /**
	 * 只读. 
	 * @mbg.generated  2019-01-21 14:43:18
	 */
	protected String orderByClause;
	/**
	 * 只读. 
	 * @mbg.generated  2019-01-21 14:43:18
	 */
	protected boolean distinct;
	/**
	 * 只读. 
	 * @mbg.generated  2019-01-21 14:43:18
	 */
	protected List<Criteria> oredCriteria;
	/**
	 * 只读. 
	 * @mbg.generated  2019-01-21 14:43:18
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-21 14:43:18
	 */
	public MktActivityRedPacketRecordPOExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-21 14:43:18
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-21 14:43:18
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-21 14:43:18
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-21 14:43:18
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-21 14:43:18
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-21 14:43:18
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-21 14:43:18
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-21 14:43:18
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
	 * @mbg.generated  2019-01-21 14:43:18
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-21 14:43:18
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * 只读. t_mkt_activity_red_packet_record
	 * @mbg.generated  2019-01-21 14:43:18
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

		public Criteria andMktActivityRedPacketRecordIdIsNull() {
			addCriterion("mkt_activity_red_packet_record_id is null");
			return (Criteria) this;
		}

		public Criteria andMktActivityRedPacketRecordIdIsNotNull() {
			addCriterion("mkt_activity_red_packet_record_id is not null");
			return (Criteria) this;
		}

		public Criteria andMktActivityRedPacketRecordIdEqualTo(Long value) {
			addCriterion("mkt_activity_red_packet_record_id =", value, "mktActivityRedPacketRecordId");
			return (Criteria) this;
		}

		public Criteria andMktActivityRedPacketRecordIdNotEqualTo(Long value) {
			addCriterion("mkt_activity_red_packet_record_id <>", value, "mktActivityRedPacketRecordId");
			return (Criteria) this;
		}

		public Criteria andMktActivityRedPacketRecordIdGreaterThan(Long value) {
			addCriterion("mkt_activity_red_packet_record_id >", value, "mktActivityRedPacketRecordId");
			return (Criteria) this;
		}

		public Criteria andMktActivityRedPacketRecordIdGreaterThanOrEqualTo(Long value) {
			addCriterion("mkt_activity_red_packet_record_id >=", value, "mktActivityRedPacketRecordId");
			return (Criteria) this;
		}

		public Criteria andMktActivityRedPacketRecordIdLessThan(Long value) {
			addCriterion("mkt_activity_red_packet_record_id <", value, "mktActivityRedPacketRecordId");
			return (Criteria) this;
		}

		public Criteria andMktActivityRedPacketRecordIdLessThanOrEqualTo(Long value) {
			addCriterion("mkt_activity_red_packet_record_id <=", value, "mktActivityRedPacketRecordId");
			return (Criteria) this;
		}

		public Criteria andMktActivityRedPacketRecordIdIn(List<Long> values) {
			addCriterion("mkt_activity_red_packet_record_id in", values, "mktActivityRedPacketRecordId");
			return (Criteria) this;
		}

		public Criteria andMktActivityRedPacketRecordIdNotIn(List<Long> values) {
			addCriterion("mkt_activity_red_packet_record_id not in", values, "mktActivityRedPacketRecordId");
			return (Criteria) this;
		}

		public Criteria andMktActivityRedPacketRecordIdBetween(Long value1, Long value2) {
			addCriterion("mkt_activity_red_packet_record_id between", value1, value2, "mktActivityRedPacketRecordId");
			return (Criteria) this;
		}

		public Criteria andMktActivityRedPacketRecordIdNotBetween(Long value1, Long value2) {
			addCriterion("mkt_activity_red_packet_record_id not between", value1, value2,
					"mktActivityRedPacketRecordId");
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

		public Criteria andWxHeadUrlIsNull() {
			addCriterion("wx_head_url is null");
			return (Criteria) this;
		}

		public Criteria andWxHeadUrlIsNotNull() {
			addCriterion("wx_head_url is not null");
			return (Criteria) this;
		}

		public Criteria andWxHeadUrlEqualTo(String value) {
			addCriterion("wx_head_url =", value, "wxHeadUrl");
			return (Criteria) this;
		}

		public Criteria andWxHeadUrlNotEqualTo(String value) {
			addCriterion("wx_head_url <>", value, "wxHeadUrl");
			return (Criteria) this;
		}

		public Criteria andWxHeadUrlGreaterThan(String value) {
			addCriterion("wx_head_url >", value, "wxHeadUrl");
			return (Criteria) this;
		}

		public Criteria andWxHeadUrlGreaterThanOrEqualTo(String value) {
			addCriterion("wx_head_url >=", value, "wxHeadUrl");
			return (Criteria) this;
		}

		public Criteria andWxHeadUrlLessThan(String value) {
			addCriterion("wx_head_url <", value, "wxHeadUrl");
			return (Criteria) this;
		}

		public Criteria andWxHeadUrlLessThanOrEqualTo(String value) {
			addCriterion("wx_head_url <=", value, "wxHeadUrl");
			return (Criteria) this;
		}

		public Criteria andWxHeadUrlLike(String value) {
			addCriterion("wx_head_url like", value, "wxHeadUrl");
			return (Criteria) this;
		}

		public Criteria andWxHeadUrlNotLike(String value) {
			addCriterion("wx_head_url not like", value, "wxHeadUrl");
			return (Criteria) this;
		}

		public Criteria andWxHeadUrlIn(List<String> values) {
			addCriterion("wx_head_url in", values, "wxHeadUrl");
			return (Criteria) this;
		}

		public Criteria andWxHeadUrlNotIn(List<String> values) {
			addCriterion("wx_head_url not in", values, "wxHeadUrl");
			return (Criteria) this;
		}

		public Criteria andWxHeadUrlBetween(String value1, String value2) {
			addCriterion("wx_head_url between", value1, value2, "wxHeadUrl");
			return (Criteria) this;
		}

		public Criteria andWxHeadUrlNotBetween(String value1, String value2) {
			addCriterion("wx_head_url not between", value1, value2, "wxHeadUrl");
			return (Criteria) this;
		}

		public Criteria andWxNicknameIsNull() {
			addCriterion("wx_nickname is null");
			return (Criteria) this;
		}

		public Criteria andWxNicknameIsNotNull() {
			addCriterion("wx_nickname is not null");
			return (Criteria) this;
		}

		public Criteria andWxNicknameEqualTo(String value) {
			addCriterion("wx_nickname =", value, "wxNickname");
			return (Criteria) this;
		}

		public Criteria andWxNicknameNotEqualTo(String value) {
			addCriterion("wx_nickname <>", value, "wxNickname");
			return (Criteria) this;
		}

		public Criteria andWxNicknameGreaterThan(String value) {
			addCriterion("wx_nickname >", value, "wxNickname");
			return (Criteria) this;
		}

		public Criteria andWxNicknameGreaterThanOrEqualTo(String value) {
			addCriterion("wx_nickname >=", value, "wxNickname");
			return (Criteria) this;
		}

		public Criteria andWxNicknameLessThan(String value) {
			addCriterion("wx_nickname <", value, "wxNickname");
			return (Criteria) this;
		}

		public Criteria andWxNicknameLessThanOrEqualTo(String value) {
			addCriterion("wx_nickname <=", value, "wxNickname");
			return (Criteria) this;
		}

		public Criteria andWxNicknameLike(String value) {
			addCriterion("wx_nickname like", value, "wxNickname");
			return (Criteria) this;
		}

		public Criteria andWxNicknameNotLike(String value) {
			addCriterion("wx_nickname not like", value, "wxNickname");
			return (Criteria) this;
		}

		public Criteria andWxNicknameIn(List<String> values) {
			addCriterion("wx_nickname in", values, "wxNickname");
			return (Criteria) this;
		}

		public Criteria andWxNicknameNotIn(List<String> values) {
			addCriterion("wx_nickname not in", values, "wxNickname");
			return (Criteria) this;
		}

		public Criteria andWxNicknameBetween(String value1, String value2) {
			addCriterion("wx_nickname between", value1, value2, "wxNickname");
			return (Criteria) this;
		}

		public Criteria andWxNicknameNotBetween(String value1, String value2) {
			addCriterion("wx_nickname not between", value1, value2, "wxNickname");
			return (Criteria) this;
		}

		public Criteria andSponsorCodeIsNull() {
			addCriterion("sponsor_code is null");
			return (Criteria) this;
		}

		public Criteria andSponsorCodeIsNotNull() {
			addCriterion("sponsor_code is not null");
			return (Criteria) this;
		}

		public Criteria andSponsorCodeEqualTo(String value) {
			addCriterion("sponsor_code =", value, "sponsorCode");
			return (Criteria) this;
		}

		public Criteria andSponsorCodeNotEqualTo(String value) {
			addCriterion("sponsor_code <>", value, "sponsorCode");
			return (Criteria) this;
		}

		public Criteria andSponsorCodeGreaterThan(String value) {
			addCriterion("sponsor_code >", value, "sponsorCode");
			return (Criteria) this;
		}

		public Criteria andSponsorCodeGreaterThanOrEqualTo(String value) {
			addCriterion("sponsor_code >=", value, "sponsorCode");
			return (Criteria) this;
		}

		public Criteria andSponsorCodeLessThan(String value) {
			addCriterion("sponsor_code <", value, "sponsorCode");
			return (Criteria) this;
		}

		public Criteria andSponsorCodeLessThanOrEqualTo(String value) {
			addCriterion("sponsor_code <=", value, "sponsorCode");
			return (Criteria) this;
		}

		public Criteria andSponsorCodeLike(String value) {
			addCriterion("sponsor_code like", value, "sponsorCode");
			return (Criteria) this;
		}

		public Criteria andSponsorCodeNotLike(String value) {
			addCriterion("sponsor_code not like", value, "sponsorCode");
			return (Criteria) this;
		}

		public Criteria andSponsorCodeIn(List<String> values) {
			addCriterion("sponsor_code in", values, "sponsorCode");
			return (Criteria) this;
		}

		public Criteria andSponsorCodeNotIn(List<String> values) {
			addCriterion("sponsor_code not in", values, "sponsorCode");
			return (Criteria) this;
		}

		public Criteria andSponsorCodeBetween(String value1, String value2) {
			addCriterion("sponsor_code between", value1, value2, "sponsorCode");
			return (Criteria) this;
		}

		public Criteria andSponsorCodeNotBetween(String value1, String value2) {
			addCriterion("sponsor_code not between", value1, value2, "sponsorCode");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionIdIsNull() {
			addCriterion("coupon_definition_id is null");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionIdIsNotNull() {
			addCriterion("coupon_definition_id is not null");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionIdEqualTo(Long value) {
			addCriterion("coupon_definition_id =", value, "couponDefinitionId");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionIdNotEqualTo(Long value) {
			addCriterion("coupon_definition_id <>", value, "couponDefinitionId");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionIdGreaterThan(Long value) {
			addCriterion("coupon_definition_id >", value, "couponDefinitionId");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionIdGreaterThanOrEqualTo(Long value) {
			addCriterion("coupon_definition_id >=", value, "couponDefinitionId");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionIdLessThan(Long value) {
			addCriterion("coupon_definition_id <", value, "couponDefinitionId");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionIdLessThanOrEqualTo(Long value) {
			addCriterion("coupon_definition_id <=", value, "couponDefinitionId");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionIdIn(List<Long> values) {
			addCriterion("coupon_definition_id in", values, "couponDefinitionId");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionIdNotIn(List<Long> values) {
			addCriterion("coupon_definition_id not in", values, "couponDefinitionId");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionIdBetween(Long value1, Long value2) {
			addCriterion("coupon_definition_id between", value1, value2, "couponDefinitionId");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionIdNotBetween(Long value1, Long value2) {
			addCriterion("coupon_definition_id not between", value1, value2, "couponDefinitionId");
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

		public Criteria andCouponNameIsNull() {
			addCriterion("coupon_name is null");
			return (Criteria) this;
		}

		public Criteria andCouponNameIsNotNull() {
			addCriterion("coupon_name is not null");
			return (Criteria) this;
		}

		public Criteria andCouponNameEqualTo(String value) {
			addCriterion("coupon_name =", value, "couponName");
			return (Criteria) this;
		}

		public Criteria andCouponNameNotEqualTo(String value) {
			addCriterion("coupon_name <>", value, "couponName");
			return (Criteria) this;
		}

		public Criteria andCouponNameGreaterThan(String value) {
			addCriterion("coupon_name >", value, "couponName");
			return (Criteria) this;
		}

		public Criteria andCouponNameGreaterThanOrEqualTo(String value) {
			addCriterion("coupon_name >=", value, "couponName");
			return (Criteria) this;
		}

		public Criteria andCouponNameLessThan(String value) {
			addCriterion("coupon_name <", value, "couponName");
			return (Criteria) this;
		}

		public Criteria andCouponNameLessThanOrEqualTo(String value) {
			addCriterion("coupon_name <=", value, "couponName");
			return (Criteria) this;
		}

		public Criteria andCouponNameLike(String value) {
			addCriterion("coupon_name like", value, "couponName");
			return (Criteria) this;
		}

		public Criteria andCouponNameNotLike(String value) {
			addCriterion("coupon_name not like", value, "couponName");
			return (Criteria) this;
		}

		public Criteria andCouponNameIn(List<String> values) {
			addCriterion("coupon_name in", values, "couponName");
			return (Criteria) this;
		}

		public Criteria andCouponNameNotIn(List<String> values) {
			addCriterion("coupon_name not in", values, "couponName");
			return (Criteria) this;
		}

		public Criteria andCouponNameBetween(String value1, String value2) {
			addCriterion("coupon_name between", value1, value2, "couponName");
			return (Criteria) this;
		}

		public Criteria andCouponNameNotBetween(String value1, String value2) {
			addCriterion("coupon_name not between", value1, value2, "couponName");
			return (Criteria) this;
		}

		public Criteria andCouponQuotaIsNull() {
			addCriterion("coupon_quota is null");
			return (Criteria) this;
		}

		public Criteria andCouponQuotaIsNotNull() {
			addCriterion("coupon_quota is not null");
			return (Criteria) this;
		}

		public Criteria andCouponQuotaEqualTo(Integer value) {
			addCriterion("coupon_quota =", value, "couponQuota");
			return (Criteria) this;
		}

		public Criteria andCouponQuotaNotEqualTo(Integer value) {
			addCriterion("coupon_quota <>", value, "couponQuota");
			return (Criteria) this;
		}

		public Criteria andCouponQuotaGreaterThan(Integer value) {
			addCriterion("coupon_quota >", value, "couponQuota");
			return (Criteria) this;
		}

		public Criteria andCouponQuotaGreaterThanOrEqualTo(Integer value) {
			addCriterion("coupon_quota >=", value, "couponQuota");
			return (Criteria) this;
		}

		public Criteria andCouponQuotaLessThan(Integer value) {
			addCriterion("coupon_quota <", value, "couponQuota");
			return (Criteria) this;
		}

		public Criteria andCouponQuotaLessThanOrEqualTo(Integer value) {
			addCriterion("coupon_quota <=", value, "couponQuota");
			return (Criteria) this;
		}

		public Criteria andCouponQuotaIn(List<Integer> values) {
			addCriterion("coupon_quota in", values, "couponQuota");
			return (Criteria) this;
		}

		public Criteria andCouponQuotaNotIn(List<Integer> values) {
			addCriterion("coupon_quota not in", values, "couponQuota");
			return (Criteria) this;
		}

		public Criteria andCouponQuotaBetween(Integer value1, Integer value2) {
			addCriterion("coupon_quota between", value1, value2, "couponQuota");
			return (Criteria) this;
		}

		public Criteria andCouponQuotaNotBetween(Integer value1, Integer value2) {
			addCriterion("coupon_quota not between", value1, value2, "couponQuota");
			return (Criteria) this;
		}

		public Criteria andAddCouponDenominationIsNull() {
			addCriterion("add_coupon_denomination is null");
			return (Criteria) this;
		}

		public Criteria andAddCouponDenominationIsNotNull() {
			addCriterion("add_coupon_denomination is not null");
			return (Criteria) this;
		}

		public Criteria andAddCouponDenominationEqualTo(Integer value) {
			addCriterion("add_coupon_denomination =", value, "addCouponDenomination");
			return (Criteria) this;
		}

		public Criteria andAddCouponDenominationNotEqualTo(Integer value) {
			addCriterion("add_coupon_denomination <>", value, "addCouponDenomination");
			return (Criteria) this;
		}

		public Criteria andAddCouponDenominationGreaterThan(Integer value) {
			addCriterion("add_coupon_denomination >", value, "addCouponDenomination");
			return (Criteria) this;
		}

		public Criteria andAddCouponDenominationGreaterThanOrEqualTo(Integer value) {
			addCriterion("add_coupon_denomination >=", value, "addCouponDenomination");
			return (Criteria) this;
		}

		public Criteria andAddCouponDenominationLessThan(Integer value) {
			addCriterion("add_coupon_denomination <", value, "addCouponDenomination");
			return (Criteria) this;
		}

		public Criteria andAddCouponDenominationLessThanOrEqualTo(Integer value) {
			addCriterion("add_coupon_denomination <=", value, "addCouponDenomination");
			return (Criteria) this;
		}

		public Criteria andAddCouponDenominationIn(List<Integer> values) {
			addCriterion("add_coupon_denomination in", values, "addCouponDenomination");
			return (Criteria) this;
		}

		public Criteria andAddCouponDenominationNotIn(List<Integer> values) {
			addCriterion("add_coupon_denomination not in", values, "addCouponDenomination");
			return (Criteria) this;
		}

		public Criteria andAddCouponDenominationBetween(Integer value1, Integer value2) {
			addCriterion("add_coupon_denomination between", value1, value2, "addCouponDenomination");
			return (Criteria) this;
		}

		public Criteria andAddCouponDenominationNotBetween(Integer value1, Integer value2) {
			addCriterion("add_coupon_denomination not between", value1, value2, "addCouponDenomination");
			return (Criteria) this;
		}

		public Criteria andGetCouponDateIsNull() {
			addCriterion("get_coupon_date is null");
			return (Criteria) this;
		}

		public Criteria andGetCouponDateIsNotNull() {
			addCriterion("get_coupon_date is not null");
			return (Criteria) this;
		}

		public Criteria andGetCouponDateEqualTo(Date value) {
			addCriterion("get_coupon_date =", value, "getCouponDate");
			return (Criteria) this;
		}

		public Criteria andGetCouponDateNotEqualTo(Date value) {
			addCriterion("get_coupon_date <>", value, "getCouponDate");
			return (Criteria) this;
		}

		public Criteria andGetCouponDateGreaterThan(Date value) {
			addCriterion("get_coupon_date >", value, "getCouponDate");
			return (Criteria) this;
		}

		public Criteria andGetCouponDateGreaterThanOrEqualTo(Date value) {
			addCriterion("get_coupon_date >=", value, "getCouponDate");
			return (Criteria) this;
		}

		public Criteria andGetCouponDateLessThan(Date value) {
			addCriterion("get_coupon_date <", value, "getCouponDate");
			return (Criteria) this;
		}

		public Criteria andGetCouponDateLessThanOrEqualTo(Date value) {
			addCriterion("get_coupon_date <=", value, "getCouponDate");
			return (Criteria) this;
		}

		public Criteria andGetCouponDateIn(List<Date> values) {
			addCriterion("get_coupon_date in", values, "getCouponDate");
			return (Criteria) this;
		}

		public Criteria andGetCouponDateNotIn(List<Date> values) {
			addCriterion("get_coupon_date not in", values, "getCouponDate");
			return (Criteria) this;
		}

		public Criteria andGetCouponDateBetween(Date value1, Date value2) {
			addCriterion("get_coupon_date between", value1, value2, "getCouponDate");
			return (Criteria) this;
		}

		public Criteria andGetCouponDateNotBetween(Date value1, Date value2) {
			addCriterion("get_coupon_date not between", value1, value2, "getCouponDate");
			return (Criteria) this;
		}

		public Criteria andRewardIntegralIsNull() {
			addCriterion("reward_integral is null");
			return (Criteria) this;
		}

		public Criteria andRewardIntegralIsNotNull() {
			addCriterion("reward_integral is not null");
			return (Criteria) this;
		}

		public Criteria andRewardIntegralEqualTo(Integer value) {
			addCriterion("reward_integral =", value, "rewardIntegral");
			return (Criteria) this;
		}

		public Criteria andRewardIntegralNotEqualTo(Integer value) {
			addCriterion("reward_integral <>", value, "rewardIntegral");
			return (Criteria) this;
		}

		public Criteria andRewardIntegralGreaterThan(Integer value) {
			addCriterion("reward_integral >", value, "rewardIntegral");
			return (Criteria) this;
		}

		public Criteria andRewardIntegralGreaterThanOrEqualTo(Integer value) {
			addCriterion("reward_integral >=", value, "rewardIntegral");
			return (Criteria) this;
		}

		public Criteria andRewardIntegralLessThan(Integer value) {
			addCriterion("reward_integral <", value, "rewardIntegral");
			return (Criteria) this;
		}

		public Criteria andRewardIntegralLessThanOrEqualTo(Integer value) {
			addCriterion("reward_integral <=", value, "rewardIntegral");
			return (Criteria) this;
		}

		public Criteria andRewardIntegralIn(List<Integer> values) {
			addCriterion("reward_integral in", values, "rewardIntegral");
			return (Criteria) this;
		}

		public Criteria andRewardIntegralNotIn(List<Integer> values) {
			addCriterion("reward_integral not in", values, "rewardIntegral");
			return (Criteria) this;
		}

		public Criteria andRewardIntegralBetween(Integer value1, Integer value2) {
			addCriterion("reward_integral between", value1, value2, "rewardIntegral");
			return (Criteria) this;
		}

		public Criteria andRewardIntegralNotBetween(Integer value1, Integer value2) {
			addCriterion("reward_integral not between", value1, value2, "rewardIntegral");
			return (Criteria) this;
		}

		public Criteria andTypeIsNull() {
			addCriterion("type is null");
			return (Criteria) this;
		}

		public Criteria andTypeIsNotNull() {
			addCriterion("type is not null");
			return (Criteria) this;
		}

		public Criteria andTypeEqualTo(Integer value) {
			addCriterion("type =", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotEqualTo(Integer value) {
			addCriterion("type <>", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeGreaterThan(Integer value) {
			addCriterion("type >", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("type >=", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLessThan(Integer value) {
			addCriterion("type <", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLessThanOrEqualTo(Integer value) {
			addCriterion("type <=", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeIn(List<Integer> values) {
			addCriterion("type in", values, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotIn(List<Integer> values) {
			addCriterion("type not in", values, "type");
			return (Criteria) this;
		}

		public Criteria andTypeBetween(Integer value1, Integer value2) {
			addCriterion("type between", value1, value2, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("type not between", value1, value2, "type");
			return (Criteria) this;
		}

		public Criteria andOtherIsNull() {
			addCriterion("other is null");
			return (Criteria) this;
		}

		public Criteria andOtherIsNotNull() {
			addCriterion("other is not null");
			return (Criteria) this;
		}

		public Criteria andOtherEqualTo(String value) {
			addCriterion("other =", value, "other");
			return (Criteria) this;
		}

		public Criteria andOtherNotEqualTo(String value) {
			addCriterion("other <>", value, "other");
			return (Criteria) this;
		}

		public Criteria andOtherGreaterThan(String value) {
			addCriterion("other >", value, "other");
			return (Criteria) this;
		}

		public Criteria andOtherGreaterThanOrEqualTo(String value) {
			addCriterion("other >=", value, "other");
			return (Criteria) this;
		}

		public Criteria andOtherLessThan(String value) {
			addCriterion("other <", value, "other");
			return (Criteria) this;
		}

		public Criteria andOtherLessThanOrEqualTo(String value) {
			addCriterion("other <=", value, "other");
			return (Criteria) this;
		}

		public Criteria andOtherLike(String value) {
			addCriterion("other like", value, "other");
			return (Criteria) this;
		}

		public Criteria andOtherNotLike(String value) {
			addCriterion("other not like", value, "other");
			return (Criteria) this;
		}

		public Criteria andOtherIn(List<String> values) {
			addCriterion("other in", values, "other");
			return (Criteria) this;
		}

		public Criteria andOtherNotIn(List<String> values) {
			addCriterion("other not in", values, "other");
			return (Criteria) this;
		}

		public Criteria andOtherBetween(String value1, String value2) {
			addCriterion("other between", value1, value2, "other");
			return (Criteria) this;
		}

		public Criteria andOtherNotBetween(String value1, String value2) {
			addCriterion("other not between", value1, value2, "other");
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

		public Criteria andModifiedUserIdEqualTo(Integer value) {
			addCriterion("modified_user_id =", value, "modifiedUserId");
			return (Criteria) this;
		}

		public Criteria andModifiedUserIdNotEqualTo(Integer value) {
			addCriterion("modified_user_id <>", value, "modifiedUserId");
			return (Criteria) this;
		}

		public Criteria andModifiedUserIdGreaterThan(Integer value) {
			addCriterion("modified_user_id >", value, "modifiedUserId");
			return (Criteria) this;
		}

		public Criteria andModifiedUserIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("modified_user_id >=", value, "modifiedUserId");
			return (Criteria) this;
		}

		public Criteria andModifiedUserIdLessThan(Integer value) {
			addCriterion("modified_user_id <", value, "modifiedUserId");
			return (Criteria) this;
		}

		public Criteria andModifiedUserIdLessThanOrEqualTo(Integer value) {
			addCriterion("modified_user_id <=", value, "modifiedUserId");
			return (Criteria) this;
		}

		public Criteria andModifiedUserIdIn(List<Integer> values) {
			addCriterion("modified_user_id in", values, "modifiedUserId");
			return (Criteria) this;
		}

		public Criteria andModifiedUserIdNotIn(List<Integer> values) {
			addCriterion("modified_user_id not in", values, "modifiedUserId");
			return (Criteria) this;
		}

		public Criteria andModifiedUserIdBetween(Integer value1, Integer value2) {
			addCriterion("modified_user_id between", value1, value2, "modifiedUserId");
			return (Criteria) this;
		}

		public Criteria andModifiedUserIdNotBetween(Integer value1, Integer value2) {
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
	 * 只读. t_mkt_activity_red_packet_record
	 * @mbg.generated  2019-01-21 14:43:18
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
     * This class corresponds to the database table t_mkt_activity_red_packet_record
     *
     * @mbg.generated do_not_delete_during_merge 2019-01-11 11:03:19
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }
}