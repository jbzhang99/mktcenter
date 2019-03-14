package com.bizvane.messagefacade.models.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class MsgSendTimePOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MsgSendTimePOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        protected void addCriterionForJDBCTime(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Time> timeList = new ArrayList<java.sql.Time>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                timeList.add(new java.sql.Time(iter.next().getTime()));
            }
            addCriterion(condition, timeList, property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value1.getTime()), new java.sql.Time(value2.getTime()), property);
        }

        public Criteria andMsgSendtimeIdIsNull() {
            addCriterion("msg_sendtime_id is null");
            return (Criteria) this;
        }

        public Criteria andMsgSendtimeIdIsNotNull() {
            addCriterion("msg_sendtime_id is not null");
            return (Criteria) this;
        }

        public Criteria andMsgSendtimeIdEqualTo(Long value) {
            addCriterion("msg_sendtime_id =", value, "msgSendtimeId");
            return (Criteria) this;
        }

        public Criteria andMsgSendtimeIdNotEqualTo(Long value) {
            addCriterion("msg_sendtime_id <>", value, "msgSendtimeId");
            return (Criteria) this;
        }

        public Criteria andMsgSendtimeIdGreaterThan(Long value) {
            addCriterion("msg_sendtime_id >", value, "msgSendtimeId");
            return (Criteria) this;
        }

        public Criteria andMsgSendtimeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("msg_sendtime_id >=", value, "msgSendtimeId");
            return (Criteria) this;
        }

        public Criteria andMsgSendtimeIdLessThan(Long value) {
            addCriterion("msg_sendtime_id <", value, "msgSendtimeId");
            return (Criteria) this;
        }

        public Criteria andMsgSendtimeIdLessThanOrEqualTo(Long value) {
            addCriterion("msg_sendtime_id <=", value, "msgSendtimeId");
            return (Criteria) this;
        }

        public Criteria andMsgSendtimeIdIn(List<Long> values) {
            addCriterion("msg_sendtime_id in", values, "msgSendtimeId");
            return (Criteria) this;
        }

        public Criteria andMsgSendtimeIdNotIn(List<Long> values) {
            addCriterion("msg_sendtime_id not in", values, "msgSendtimeId");
            return (Criteria) this;
        }

        public Criteria andMsgSendtimeIdBetween(Long value1, Long value2) {
            addCriterion("msg_sendtime_id between", value1, value2, "msgSendtimeId");
            return (Criteria) this;
        }

        public Criteria andMsgSendtimeIdNotBetween(Long value1, Long value2) {
            addCriterion("msg_sendtime_id not between", value1, value2, "msgSendtimeId");
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
        
        public Criteria andsysCompanyIdIsNull() {
            addCriterion("sys_company_id is null");
            return (Criteria) this;
        }

        public Criteria andsysCompanyIdIsNotNull() {
            addCriterion("sys_company_id is not null");
            return (Criteria) this;
        }

        public Criteria andsysCompanyIdEqualTo(Date value) {
            addCriterionForJDBCTime("sys_company_id =", value, "sysCompanyId");
            return (Criteria) this;
        }

        public Criteria andsysCompanyIdNotEqualTo(Date value) {
            addCriterionForJDBCTime("sys_company_id <>", value, "sysCompanyId");
            return (Criteria) this;
        }

        public Criteria andsysCompanyIdGreaterThan(Date value) {
            addCriterionForJDBCTime("sys_company_id >", value, "sysCompanyId");
            return (Criteria) this;
        }

        public Criteria andsysCompanyIdGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("sys_company_id >=", value, "sysCompanyId");
            return (Criteria) this;
        }

        public Criteria andsysCompanyIdLessThan(Date value) {
            addCriterionForJDBCTime("sys_company_id <", value, "sysCompanyId");
            return (Criteria) this;
        }

        public Criteria andsysCompanyIdLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("sys_company_id <=", value, "sysCompanyId");
            return (Criteria) this;
        }

        public Criteria andsysCompanyIdIn(List<Date> values) {
            addCriterionForJDBCTime("sys_company_id in", values, "sysCompanyId");
            return (Criteria) this;
        }

        public Criteria andsysCompanyIdNotIn(List<Date> values) {
            addCriterionForJDBCTime("sys_company_id not in", values, "sysCompanyId");
            return (Criteria) this;
        }

        public Criteria andsysCompanyIdBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("sys_company_id between", value1, value2, "sysCompanyId");
            return (Criteria) this;
        }

        public Criteria andsysCompanyIdNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("sys_company_id not between", value1, value2, "sysCompanyId");
            return (Criteria) this;
        }


        public Criteria andSendTimeStartIsNull() {
            addCriterion("send_time_start is null");
            return (Criteria) this;
        }

        public Criteria andSendTimeStartIsNotNull() {
            addCriterion("send_time_start is not null");
            return (Criteria) this;
        }

        public Criteria andSendTimeStartEqualTo(Date value) {
            addCriterionForJDBCTime("send_time_start =", value, "sendTimeStart");
            return (Criteria) this;
        }

        public Criteria andSendTimeStartNotEqualTo(Date value) {
            addCriterionForJDBCTime("send_time_start <>", value, "sendTimeStart");
            return (Criteria) this;
        }

        public Criteria andSendTimeStartGreaterThan(Date value) {
            addCriterionForJDBCTime("send_time_start >", value, "sendTimeStart");
            return (Criteria) this;
        }

        public Criteria andSendTimeStartGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("send_time_start >=", value, "sendTimeStart");
            return (Criteria) this;
        }

        public Criteria andSendTimeStartLessThan(Date value) {
            addCriterionForJDBCTime("send_time_start <", value, "sendTimeStart");
            return (Criteria) this;
        }

        public Criteria andSendTimeStartLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("send_time_start <=", value, "sendTimeStart");
            return (Criteria) this;
        }

        public Criteria andSendTimeStartIn(List<Date> values) {
            addCriterionForJDBCTime("send_time_start in", values, "sendTimeStart");
            return (Criteria) this;
        }

        public Criteria andSendTimeStartNotIn(List<Date> values) {
            addCriterionForJDBCTime("send_time_start not in", values, "sendTimeStart");
            return (Criteria) this;
        }

        public Criteria andSendTimeStartBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("send_time_start between", value1, value2, "sendTimeStart");
            return (Criteria) this;
        }

        public Criteria andSendTimeStartNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("send_time_start not between", value1, value2, "sendTimeStart");
            return (Criteria) this;
        }

        public Criteria andSendTimeEndIsNull() {
            addCriterion("send_time_end is null");
            return (Criteria) this;
        }

        public Criteria andSendTimeEndIsNotNull() {
            addCriterion("send_time_end is not null");
            return (Criteria) this;
        }

        public Criteria andSendTimeEndEqualTo(Date value) {
            addCriterionForJDBCTime("send_time_end =", value, "sendTimeEnd");
            return (Criteria) this;
        }

        public Criteria andSendTimeEndNotEqualTo(Date value) {
            addCriterionForJDBCTime("send_time_end <>", value, "sendTimeEnd");
            return (Criteria) this;
        }

        public Criteria andSendTimeEndGreaterThan(Date value) {
            addCriterionForJDBCTime("send_time_end >", value, "sendTimeEnd");
            return (Criteria) this;
        }

        public Criteria andSendTimeEndGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("send_time_end >=", value, "sendTimeEnd");
            return (Criteria) this;
        }

        public Criteria andSendTimeEndLessThan(Date value) {
            addCriterionForJDBCTime("send_time_end <", value, "sendTimeEnd");
            return (Criteria) this;
        }

        public Criteria andSendTimeEndLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("send_time_end <=", value, "sendTimeEnd");
            return (Criteria) this;
        }

        public Criteria andSendTimeEndIn(List<Date> values) {
            addCriterionForJDBCTime("send_time_end in", values, "sendTimeEnd");
            return (Criteria) this;
        }

        public Criteria andSendTimeEndNotIn(List<Date> values) {
            addCriterionForJDBCTime("send_time_end not in", values, "sendTimeEnd");
            return (Criteria) this;
        }

        public Criteria andSendTimeEndBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("send_time_end between", value1, value2, "sendTimeEnd");
            return (Criteria) this;
        }

        public Criteria andSendTimeEndNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("send_time_end not between", value1, value2, "sendTimeEnd");
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

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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
}