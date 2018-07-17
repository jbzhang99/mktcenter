package com.bizvane.mktcenterservice.models.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RocketLogPOExample implements Serializable {
    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-17 10:38:52
     */
    protected String orderByClause;

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-17 10:38:52
     */
    protected boolean distinct;

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-17 10:38:52
     */
    protected List<Criteria> oredCriteria;

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-17 10:38:52
     */
    private static final long serialVersionUID = 1L;

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-17 10:38:52
     */
    public RocketLogPOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-17 10:38:52
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-17 10:38:52
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-17 10:38:52
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-17 10:38:52
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-17 10:38:52
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-17 10:38:52
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-17 10:38:52
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-17 10:38:52
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
     *
     * @mbg.generated 2018-07-17 10:38:52
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-17 10:38:52
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * 只读. t_rocket_log
     *
     * @mbg.generated 2018-07-17 10:38:52
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

        public Criteria andRocketLogIdIsNull() {
            addCriterion("rocket_log_id is null");
            return (Criteria) this;
        }

        public Criteria andRocketLogIdIsNotNull() {
            addCriterion("rocket_log_id is not null");
            return (Criteria) this;
        }

        public Criteria andRocketLogIdEqualTo(Long value) {
            addCriterion("rocket_log_id =", value, "rocketLogId");
            return (Criteria) this;
        }

        public Criteria andRocketLogIdNotEqualTo(Long value) {
            addCriterion("rocket_log_id <>", value, "rocketLogId");
            return (Criteria) this;
        }

        public Criteria andRocketLogIdGreaterThan(Long value) {
            addCriterion("rocket_log_id >", value, "rocketLogId");
            return (Criteria) this;
        }

        public Criteria andRocketLogIdGreaterThanOrEqualTo(Long value) {
            addCriterion("rocket_log_id >=", value, "rocketLogId");
            return (Criteria) this;
        }

        public Criteria andRocketLogIdLessThan(Long value) {
            addCriterion("rocket_log_id <", value, "rocketLogId");
            return (Criteria) this;
        }

        public Criteria andRocketLogIdLessThanOrEqualTo(Long value) {
            addCriterion("rocket_log_id <=", value, "rocketLogId");
            return (Criteria) this;
        }

        public Criteria andRocketLogIdIn(List<Long> values) {
            addCriterion("rocket_log_id in", values, "rocketLogId");
            return (Criteria) this;
        }

        public Criteria andRocketLogIdNotIn(List<Long> values) {
            addCriterion("rocket_log_id not in", values, "rocketLogId");
            return (Criteria) this;
        }

        public Criteria andRocketLogIdBetween(Long value1, Long value2) {
            addCriterion("rocket_log_id between", value1, value2, "rocketLogId");
            return (Criteria) this;
        }

        public Criteria andRocketLogIdNotBetween(Long value1, Long value2) {
            addCriterion("rocket_log_id not between", value1, value2, "rocketLogId");
            return (Criteria) this;
        }

        public Criteria andMessageIdIsNull() {
            addCriterion("message_id is null");
            return (Criteria) this;
        }

        public Criteria andMessageIdIsNotNull() {
            addCriterion("message_id is not null");
            return (Criteria) this;
        }

        public Criteria andMessageIdEqualTo(String value) {
            addCriterion("message_id =", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdNotEqualTo(String value) {
            addCriterion("message_id <>", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdGreaterThan(String value) {
            addCriterion("message_id >", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdGreaterThanOrEqualTo(String value) {
            addCriterion("message_id >=", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdLessThan(String value) {
            addCriterion("message_id <", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdLessThanOrEqualTo(String value) {
            addCriterion("message_id <=", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdLike(String value) {
            addCriterion("message_id like", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdNotLike(String value) {
            addCriterion("message_id not like", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdIn(List<String> values) {
            addCriterion("message_id in", values, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdNotIn(List<String> values) {
            addCriterion("message_id not in", values, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdBetween(String value1, String value2) {
            addCriterion("message_id between", value1, value2, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdNotBetween(String value1, String value2) {
            addCriterion("message_id not between", value1, value2, "messageId");
            return (Criteria) this;
        }

        public Criteria andBussinessIdIsNull() {
            addCriterion("bussiness_id is null");
            return (Criteria) this;
        }

        public Criteria andBussinessIdIsNotNull() {
            addCriterion("bussiness_id is not null");
            return (Criteria) this;
        }

        public Criteria andBussinessIdEqualTo(String value) {
            addCriterion("bussiness_id =", value, "bussinessId");
            return (Criteria) this;
        }

        public Criteria andBussinessIdNotEqualTo(String value) {
            addCriterion("bussiness_id <>", value, "bussinessId");
            return (Criteria) this;
        }

        public Criteria andBussinessIdGreaterThan(String value) {
            addCriterion("bussiness_id >", value, "bussinessId");
            return (Criteria) this;
        }

        public Criteria andBussinessIdGreaterThanOrEqualTo(String value) {
            addCriterion("bussiness_id >=", value, "bussinessId");
            return (Criteria) this;
        }

        public Criteria andBussinessIdLessThan(String value) {
            addCriterion("bussiness_id <", value, "bussinessId");
            return (Criteria) this;
        }

        public Criteria andBussinessIdLessThanOrEqualTo(String value) {
            addCriterion("bussiness_id <=", value, "bussinessId");
            return (Criteria) this;
        }

        public Criteria andBussinessIdLike(String value) {
            addCriterion("bussiness_id like", value, "bussinessId");
            return (Criteria) this;
        }

        public Criteria andBussinessIdNotLike(String value) {
            addCriterion("bussiness_id not like", value, "bussinessId");
            return (Criteria) this;
        }

        public Criteria andBussinessIdIn(List<String> values) {
            addCriterion("bussiness_id in", values, "bussinessId");
            return (Criteria) this;
        }

        public Criteria andBussinessIdNotIn(List<String> values) {
            addCriterion("bussiness_id not in", values, "bussinessId");
            return (Criteria) this;
        }

        public Criteria andBussinessIdBetween(String value1, String value2) {
            addCriterion("bussiness_id between", value1, value2, "bussinessId");
            return (Criteria) this;
        }

        public Criteria andBussinessIdNotBetween(String value1, String value2) {
            addCriterion("bussiness_id not between", value1, value2, "bussinessId");
            return (Criteria) this;
        }

        public Criteria andBussinessModuleCodeIsNull() {
            addCriterion("bussiness_module_code is null");
            return (Criteria) this;
        }

        public Criteria andBussinessModuleCodeIsNotNull() {
            addCriterion("bussiness_module_code is not null");
            return (Criteria) this;
        }

        public Criteria andBussinessModuleCodeEqualTo(String value) {
            addCriterion("bussiness_module_code =", value, "bussinessModuleCode");
            return (Criteria) this;
        }

        public Criteria andBussinessModuleCodeNotEqualTo(String value) {
            addCriterion("bussiness_module_code <>", value, "bussinessModuleCode");
            return (Criteria) this;
        }

        public Criteria andBussinessModuleCodeGreaterThan(String value) {
            addCriterion("bussiness_module_code >", value, "bussinessModuleCode");
            return (Criteria) this;
        }

        public Criteria andBussinessModuleCodeGreaterThanOrEqualTo(String value) {
            addCriterion("bussiness_module_code >=", value, "bussinessModuleCode");
            return (Criteria) this;
        }

        public Criteria andBussinessModuleCodeLessThan(String value) {
            addCriterion("bussiness_module_code <", value, "bussinessModuleCode");
            return (Criteria) this;
        }

        public Criteria andBussinessModuleCodeLessThanOrEqualTo(String value) {
            addCriterion("bussiness_module_code <=", value, "bussinessModuleCode");
            return (Criteria) this;
        }

        public Criteria andBussinessModuleCodeLike(String value) {
            addCriterion("bussiness_module_code like", value, "bussinessModuleCode");
            return (Criteria) this;
        }

        public Criteria andBussinessModuleCodeNotLike(String value) {
            addCriterion("bussiness_module_code not like", value, "bussinessModuleCode");
            return (Criteria) this;
        }

        public Criteria andBussinessModuleCodeIn(List<String> values) {
            addCriterion("bussiness_module_code in", values, "bussinessModuleCode");
            return (Criteria) this;
        }

        public Criteria andBussinessModuleCodeNotIn(List<String> values) {
            addCriterion("bussiness_module_code not in", values, "bussinessModuleCode");
            return (Criteria) this;
        }

        public Criteria andBussinessModuleCodeBetween(String value1, String value2) {
            addCriterion("bussiness_module_code between", value1, value2, "bussinessModuleCode");
            return (Criteria) this;
        }

        public Criteria andBussinessModuleCodeNotBetween(String value1, String value2) {
            addCriterion("bussiness_module_code not between", value1, value2, "bussinessModuleCode");
            return (Criteria) this;
        }

        public Criteria andDataBodyIsNull() {
            addCriterion("data_body is null");
            return (Criteria) this;
        }

        public Criteria andDataBodyIsNotNull() {
            addCriterion("data_body is not null");
            return (Criteria) this;
        }

        public Criteria andDataBodyEqualTo(String value) {
            addCriterion("data_body =", value, "dataBody");
            return (Criteria) this;
        }

        public Criteria andDataBodyNotEqualTo(String value) {
            addCriterion("data_body <>", value, "dataBody");
            return (Criteria) this;
        }

        public Criteria andDataBodyGreaterThan(String value) {
            addCriterion("data_body >", value, "dataBody");
            return (Criteria) this;
        }

        public Criteria andDataBodyGreaterThanOrEqualTo(String value) {
            addCriterion("data_body >=", value, "dataBody");
            return (Criteria) this;
        }

        public Criteria andDataBodyLessThan(String value) {
            addCriterion("data_body <", value, "dataBody");
            return (Criteria) this;
        }

        public Criteria andDataBodyLessThanOrEqualTo(String value) {
            addCriterion("data_body <=", value, "dataBody");
            return (Criteria) this;
        }

        public Criteria andDataBodyLike(String value) {
            addCriterion("data_body like", value, "dataBody");
            return (Criteria) this;
        }

        public Criteria andDataBodyNotLike(String value) {
            addCriterion("data_body not like", value, "dataBody");
            return (Criteria) this;
        }

        public Criteria andDataBodyIn(List<String> values) {
            addCriterion("data_body in", values, "dataBody");
            return (Criteria) this;
        }

        public Criteria andDataBodyNotIn(List<String> values) {
            addCriterion("data_body not in", values, "dataBody");
            return (Criteria) this;
        }

        public Criteria andDataBodyBetween(String value1, String value2) {
            addCriterion("data_body between", value1, value2, "dataBody");
            return (Criteria) this;
        }

        public Criteria andDataBodyNotBetween(String value1, String value2) {
            addCriterion("data_body not between", value1, value2, "dataBody");
            return (Criteria) this;
        }

        public Criteria andResultInfoIsNull() {
            addCriterion("result_info is null");
            return (Criteria) this;
        }

        public Criteria andResultInfoIsNotNull() {
            addCriterion("result_info is not null");
            return (Criteria) this;
        }

        public Criteria andResultInfoEqualTo(String value) {
            addCriterion("result_info =", value, "resultInfo");
            return (Criteria) this;
        }

        public Criteria andResultInfoNotEqualTo(String value) {
            addCriterion("result_info <>", value, "resultInfo");
            return (Criteria) this;
        }

        public Criteria andResultInfoGreaterThan(String value) {
            addCriterion("result_info >", value, "resultInfo");
            return (Criteria) this;
        }

        public Criteria andResultInfoGreaterThanOrEqualTo(String value) {
            addCriterion("result_info >=", value, "resultInfo");
            return (Criteria) this;
        }

        public Criteria andResultInfoLessThan(String value) {
            addCriterion("result_info <", value, "resultInfo");
            return (Criteria) this;
        }

        public Criteria andResultInfoLessThanOrEqualTo(String value) {
            addCriterion("result_info <=", value, "resultInfo");
            return (Criteria) this;
        }

        public Criteria andResultInfoLike(String value) {
            addCriterion("result_info like", value, "resultInfo");
            return (Criteria) this;
        }

        public Criteria andResultInfoNotLike(String value) {
            addCriterion("result_info not like", value, "resultInfo");
            return (Criteria) this;
        }

        public Criteria andResultInfoIn(List<String> values) {
            addCriterion("result_info in", values, "resultInfo");
            return (Criteria) this;
        }

        public Criteria andResultInfoNotIn(List<String> values) {
            addCriterion("result_info not in", values, "resultInfo");
            return (Criteria) this;
        }

        public Criteria andResultInfoBetween(String value1, String value2) {
            addCriterion("result_info between", value1, value2, "resultInfo");
            return (Criteria) this;
        }

        public Criteria andResultInfoNotBetween(String value1, String value2) {
            addCriterion("result_info not between", value1, value2, "resultInfo");
            return (Criteria) this;
        }

        public Criteria andSendStateIsNull() {
            addCriterion("send_state is null");
            return (Criteria) this;
        }

        public Criteria andSendStateIsNotNull() {
            addCriterion("send_state is not null");
            return (Criteria) this;
        }

        public Criteria andSendStateEqualTo(String value) {
            addCriterion("send_state =", value, "sendState");
            return (Criteria) this;
        }

        public Criteria andSendStateNotEqualTo(String value) {
            addCriterion("send_state <>", value, "sendState");
            return (Criteria) this;
        }

        public Criteria andSendStateGreaterThan(String value) {
            addCriterion("send_state >", value, "sendState");
            return (Criteria) this;
        }

        public Criteria andSendStateGreaterThanOrEqualTo(String value) {
            addCriterion("send_state >=", value, "sendState");
            return (Criteria) this;
        }

        public Criteria andSendStateLessThan(String value) {
            addCriterion("send_state <", value, "sendState");
            return (Criteria) this;
        }

        public Criteria andSendStateLessThanOrEqualTo(String value) {
            addCriterion("send_state <=", value, "sendState");
            return (Criteria) this;
        }

        public Criteria andSendStateLike(String value) {
            addCriterion("send_state like", value, "sendState");
            return (Criteria) this;
        }

        public Criteria andSendStateNotLike(String value) {
            addCriterion("send_state not like", value, "sendState");
            return (Criteria) this;
        }

        public Criteria andSendStateIn(List<String> values) {
            addCriterion("send_state in", values, "sendState");
            return (Criteria) this;
        }

        public Criteria andSendStateNotIn(List<String> values) {
            addCriterion("send_state not in", values, "sendState");
            return (Criteria) this;
        }

        public Criteria andSendStateBetween(String value1, String value2) {
            addCriterion("send_state between", value1, value2, "sendState");
            return (Criteria) this;
        }

        public Criteria andSendStateNotBetween(String value1, String value2) {
            addCriterion("send_state not between", value1, value2, "sendState");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIsNull() {
            addCriterion("update_user_id is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIsNotNull() {
            addCriterion("update_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdEqualTo(Integer value) {
            addCriterion("update_user_id =", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotEqualTo(Integer value) {
            addCriterion("update_user_id <>", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdGreaterThan(Integer value) {
            addCriterion("update_user_id >", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("update_user_id >=", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLessThan(Integer value) {
            addCriterion("update_user_id <", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("update_user_id <=", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIn(List<Integer> values) {
            addCriterion("update_user_id in", values, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotIn(List<Integer> values) {
            addCriterion("update_user_id not in", values, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdBetween(Integer value1, Integer value2) {
            addCriterion("update_user_id between", value1, value2, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("update_user_id not between", value1, value2, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("update_date is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("update_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterion("update_date =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterion("update_date <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterion("update_date >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("update_date >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterion("update_date <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("update_date <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterion("update_date in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterion("update_date not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterion("update_date between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("update_date not between", value1, value2, "updateDate");
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

        public Criteria andCreateUserIdEqualTo(Integer value) {
            addCriterion("create_user_id =", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotEqualTo(Integer value) {
            addCriterion("create_user_id <>", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThan(Integer value) {
            addCriterion("create_user_id >", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_user_id >=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThan(Integer value) {
            addCriterion("create_user_id <", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("create_user_id <=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIn(List<Integer> values) {
            addCriterion("create_user_id in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotIn(List<Integer> values) {
            addCriterion("create_user_id not in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdBetween(Integer value1, Integer value2) {
            addCriterion("create_user_id between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("create_user_id not between", value1, value2, "createUserId");
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
    }

    /**9
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_rocket_log
     *
     * @mbg.generated do_not_delete_during_merge 2018-07-17 10:38:52
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

    /**
     * 只读. t_rocket_log
     *
     * @mbg.generated 2018-07-17 10:38:52
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
}