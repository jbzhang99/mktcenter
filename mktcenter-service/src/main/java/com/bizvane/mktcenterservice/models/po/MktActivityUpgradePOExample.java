package com.bizvane.mktcenterservice.models.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MktActivityUpgradePOExample implements Serializable {
    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    protected String orderByClause;

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    protected boolean distinct;

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    protected List<Criteria> oredCriteria;

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    private static final long serialVersionUID = 1L;

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    public MktActivityUpgradePOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
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
     * @mbg.generated 2018-07-12 11:48:54
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * 只读. t_mkt_activity_upgrade
     *
     * @mbg.generated 2018-07-12 11:48:54
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

        public Criteria andCurrentLevelCodeIsNull() {
            addCriterion("current_level_code is null");
            return (Criteria) this;
        }

        public Criteria andCurrentLevelCodeIsNotNull() {
            addCriterion("current_level_code is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentLevelCodeEqualTo(String value) {
            addCriterion("current_level_code =", value, "currentLevelCode");
            return (Criteria) this;
        }

        public Criteria andCurrentLevelCodeNotEqualTo(String value) {
            addCriterion("current_level_code <>", value, "currentLevelCode");
            return (Criteria) this;
        }

        public Criteria andCurrentLevelCodeGreaterThan(String value) {
            addCriterion("current_level_code >", value, "currentLevelCode");
            return (Criteria) this;
        }

        public Criteria andCurrentLevelCodeGreaterThanOrEqualTo(String value) {
            addCriterion("current_level_code >=", value, "currentLevelCode");
            return (Criteria) this;
        }

        public Criteria andCurrentLevelCodeLessThan(String value) {
            addCriterion("current_level_code <", value, "currentLevelCode");
            return (Criteria) this;
        }

        public Criteria andCurrentLevelCodeLessThanOrEqualTo(String value) {
            addCriterion("current_level_code <=", value, "currentLevelCode");
            return (Criteria) this;
        }

        public Criteria andCurrentLevelCodeLike(String value) {
            addCriterion("current_level_code like", value, "currentLevelCode");
            return (Criteria) this;
        }

        public Criteria andCurrentLevelCodeNotLike(String value) {
            addCriterion("current_level_code not like", value, "currentLevelCode");
            return (Criteria) this;
        }

        public Criteria andCurrentLevelCodeIn(List<String> values) {
            addCriterion("current_level_code in", values, "currentLevelCode");
            return (Criteria) this;
        }

        public Criteria andCurrentLevelCodeNotIn(List<String> values) {
            addCriterion("current_level_code not in", values, "currentLevelCode");
            return (Criteria) this;
        }

        public Criteria andCurrentLevelCodeBetween(String value1, String value2) {
            addCriterion("current_level_code between", value1, value2, "currentLevelCode");
            return (Criteria) this;
        }

        public Criteria andCurrentLevelCodeNotBetween(String value1, String value2) {
            addCriterion("current_level_code not between", value1, value2, "currentLevelCode");
            return (Criteria) this;
        }

        public Criteria andCurrentLevelNameIsNull() {
            addCriterion("current_level_name is null");
            return (Criteria) this;
        }

        public Criteria andCurrentLevelNameIsNotNull() {
            addCriterion("current_level_name is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentLevelNameEqualTo(String value) {
            addCriterion("current_level_name =", value, "currentLevelName");
            return (Criteria) this;
        }

        public Criteria andCurrentLevelNameNotEqualTo(String value) {
            addCriterion("current_level_name <>", value, "currentLevelName");
            return (Criteria) this;
        }

        public Criteria andCurrentLevelNameGreaterThan(String value) {
            addCriterion("current_level_name >", value, "currentLevelName");
            return (Criteria) this;
        }

        public Criteria andCurrentLevelNameGreaterThanOrEqualTo(String value) {
            addCriterion("current_level_name >=", value, "currentLevelName");
            return (Criteria) this;
        }

        public Criteria andCurrentLevelNameLessThan(String value) {
            addCriterion("current_level_name <", value, "currentLevelName");
            return (Criteria) this;
        }

        public Criteria andCurrentLevelNameLessThanOrEqualTo(String value) {
            addCriterion("current_level_name <=", value, "currentLevelName");
            return (Criteria) this;
        }

        public Criteria andCurrentLevelNameLike(String value) {
            addCriterion("current_level_name like", value, "currentLevelName");
            return (Criteria) this;
        }

        public Criteria andCurrentLevelNameNotLike(String value) {
            addCriterion("current_level_name not like", value, "currentLevelName");
            return (Criteria) this;
        }

        public Criteria andCurrentLevelNameIn(List<String> values) {
            addCriterion("current_level_name in", values, "currentLevelName");
            return (Criteria) this;
        }

        public Criteria andCurrentLevelNameNotIn(List<String> values) {
            addCriterion("current_level_name not in", values, "currentLevelName");
            return (Criteria) this;
        }

        public Criteria andCurrentLevelNameBetween(String value1, String value2) {
            addCriterion("current_level_name between", value1, value2, "currentLevelName");
            return (Criteria) this;
        }

        public Criteria andCurrentLevelNameNotBetween(String value1, String value2) {
            addCriterion("current_level_name not between", value1, value2, "currentLevelName");
            return (Criteria) this;
        }

        public Criteria andTargetLevelCodeIsNull() {
            addCriterion("target_level_code is null");
            return (Criteria) this;
        }

        public Criteria andTargetLevelCodeIsNotNull() {
            addCriterion("target_level_code is not null");
            return (Criteria) this;
        }

        public Criteria andTargetLevelCodeEqualTo(String value) {
            addCriterion("target_level_code =", value, "targetLevelCode");
            return (Criteria) this;
        }

        public Criteria andTargetLevelCodeNotEqualTo(String value) {
            addCriterion("target_level_code <>", value, "targetLevelCode");
            return (Criteria) this;
        }

        public Criteria andTargetLevelCodeGreaterThan(String value) {
            addCriterion("target_level_code >", value, "targetLevelCode");
            return (Criteria) this;
        }

        public Criteria andTargetLevelCodeGreaterThanOrEqualTo(String value) {
            addCriterion("target_level_code >=", value, "targetLevelCode");
            return (Criteria) this;
        }

        public Criteria andTargetLevelCodeLessThan(String value) {
            addCriterion("target_level_code <", value, "targetLevelCode");
            return (Criteria) this;
        }

        public Criteria andTargetLevelCodeLessThanOrEqualTo(String value) {
            addCriterion("target_level_code <=", value, "targetLevelCode");
            return (Criteria) this;
        }

        public Criteria andTargetLevelCodeLike(String value) {
            addCriterion("target_level_code like", value, "targetLevelCode");
            return (Criteria) this;
        }

        public Criteria andTargetLevelCodeNotLike(String value) {
            addCriterion("target_level_code not like", value, "targetLevelCode");
            return (Criteria) this;
        }

        public Criteria andTargetLevelCodeIn(List<String> values) {
            addCriterion("target_level_code in", values, "targetLevelCode");
            return (Criteria) this;
        }

        public Criteria andTargetLevelCodeNotIn(List<String> values) {
            addCriterion("target_level_code not in", values, "targetLevelCode");
            return (Criteria) this;
        }

        public Criteria andTargetLevelCodeBetween(String value1, String value2) {
            addCriterion("target_level_code between", value1, value2, "targetLevelCode");
            return (Criteria) this;
        }

        public Criteria andTargetLevelCodeNotBetween(String value1, String value2) {
            addCriterion("target_level_code not between", value1, value2, "targetLevelCode");
            return (Criteria) this;
        }

        public Criteria andTargetLevelNameIsNull() {
            addCriterion("target_level_name is null");
            return (Criteria) this;
        }

        public Criteria andTargetLevelNameIsNotNull() {
            addCriterion("target_level_name is not null");
            return (Criteria) this;
        }

        public Criteria andTargetLevelNameEqualTo(String value) {
            addCriterion("target_level_name =", value, "targetLevelName");
            return (Criteria) this;
        }

        public Criteria andTargetLevelNameNotEqualTo(String value) {
            addCriterion("target_level_name <>", value, "targetLevelName");
            return (Criteria) this;
        }

        public Criteria andTargetLevelNameGreaterThan(String value) {
            addCriterion("target_level_name >", value, "targetLevelName");
            return (Criteria) this;
        }

        public Criteria andTargetLevelNameGreaterThanOrEqualTo(String value) {
            addCriterion("target_level_name >=", value, "targetLevelName");
            return (Criteria) this;
        }

        public Criteria andTargetLevelNameLessThan(String value) {
            addCriterion("target_level_name <", value, "targetLevelName");
            return (Criteria) this;
        }

        public Criteria andTargetLevelNameLessThanOrEqualTo(String value) {
            addCriterion("target_level_name <=", value, "targetLevelName");
            return (Criteria) this;
        }

        public Criteria andTargetLevelNameLike(String value) {
            addCriterion("target_level_name like", value, "targetLevelName");
            return (Criteria) this;
        }

        public Criteria andTargetLevelNameNotLike(String value) {
            addCriterion("target_level_name not like", value, "targetLevelName");
            return (Criteria) this;
        }

        public Criteria andTargetLevelNameIn(List<String> values) {
            addCriterion("target_level_name in", values, "targetLevelName");
            return (Criteria) this;
        }

        public Criteria andTargetLevelNameNotIn(List<String> values) {
            addCriterion("target_level_name not in", values, "targetLevelName");
            return (Criteria) this;
        }

        public Criteria andTargetLevelNameBetween(String value1, String value2) {
            addCriterion("target_level_name between", value1, value2, "targetLevelName");
            return (Criteria) this;
        }

        public Criteria andTargetLevelNameNotBetween(String value1, String value2) {
            addCriterion("target_level_name not between", value1, value2, "targetLevelName");
            return (Criteria) this;
        }

        public Criteria andFansIsNull() {
            addCriterion("fans is null");
            return (Criteria) this;
        }

        public Criteria andFansIsNotNull() {
            addCriterion("fans is not null");
            return (Criteria) this;
        }

        public Criteria andFansEqualTo(Integer value) {
            addCriterion("fans =", value, "fans");
            return (Criteria) this;
        }

        public Criteria andFansNotEqualTo(Integer value) {
            addCriterion("fans <>", value, "fans");
            return (Criteria) this;
        }

        public Criteria andFansGreaterThan(Integer value) {
            addCriterion("fans >", value, "fans");
            return (Criteria) this;
        }

        public Criteria andFansGreaterThanOrEqualTo(Integer value) {
            addCriterion("fans >=", value, "fans");
            return (Criteria) this;
        }

        public Criteria andFansLessThan(Integer value) {
            addCriterion("fans <", value, "fans");
            return (Criteria) this;
        }

        public Criteria andFansLessThanOrEqualTo(Integer value) {
            addCriterion("fans <=", value, "fans");
            return (Criteria) this;
        }

        public Criteria andFansIn(List<Integer> values) {
            addCriterion("fans in", values, "fans");
            return (Criteria) this;
        }

        public Criteria andFansNotIn(List<Integer> values) {
            addCriterion("fans not in", values, "fans");
            return (Criteria) this;
        }

        public Criteria andFansBetween(Integer value1, Integer value2) {
            addCriterion("fans between", value1, value2, "fans");
            return (Criteria) this;
        }

        public Criteria andFansNotBetween(Integer value1, Integer value2) {
            addCriterion("fans not between", value1, value2, "fans");
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

    /**
     * 只读. t_mkt_activity_upgrade
     *
     * @mbg.generated 2018-07-12 11:48:54
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