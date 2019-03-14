package com.bizvane.couponfacade.models.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SysCodeValuePOExample implements Serializable {
    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-13 19:28:06
     */
    protected String orderByClause;

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-13 19:28:06
     */
    protected boolean distinct;

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-13 19:28:06
     */
    protected List<Criteria> oredCriteria;

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-13 19:28:06
     */
    private static final long serialVersionUID = 1L;

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-13 19:28:06
     */
    public SysCodeValuePOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-13 19:28:06
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-13 19:28:06
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-13 19:28:06
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-13 19:28:06
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-13 19:28:06
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-13 19:28:06
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-13 19:28:06
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-13 19:28:06
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
     * @mbg.generated 2018-07-13 19:28:06
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-13 19:28:06
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * 只读. t_sys_code_value
     *
     * @mbg.generated 2018-07-13 19:28:06
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

        public Criteria andSysCodeValueIdIsNull() {
            addCriterion("sys_code_value_id is null");
            return (Criteria) this;
        }

        public Criteria andSysCodeValueIdIsNotNull() {
            addCriterion("sys_code_value_id is not null");
            return (Criteria) this;
        }

        public Criteria andSysCodeValueIdEqualTo(Integer value) {
            addCriterion("sys_code_value_id =", value, "sysCodeValueId");
            return (Criteria) this;
        }

        public Criteria andSysCodeValueIdNotEqualTo(Integer value) {
            addCriterion("sys_code_value_id <>", value, "sysCodeValueId");
            return (Criteria) this;
        }

        public Criteria andSysCodeValueIdGreaterThan(Integer value) {
            addCriterion("sys_code_value_id >", value, "sysCodeValueId");
            return (Criteria) this;
        }

        public Criteria andSysCodeValueIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sys_code_value_id >=", value, "sysCodeValueId");
            return (Criteria) this;
        }

        public Criteria andSysCodeValueIdLessThan(Integer value) {
            addCriterion("sys_code_value_id <", value, "sysCodeValueId");
            return (Criteria) this;
        }

        public Criteria andSysCodeValueIdLessThanOrEqualTo(Integer value) {
            addCriterion("sys_code_value_id <=", value, "sysCodeValueId");
            return (Criteria) this;
        }

        public Criteria andSysCodeValueIdIn(List<Integer> values) {
            addCriterion("sys_code_value_id in", values, "sysCodeValueId");
            return (Criteria) this;
        }

        public Criteria andSysCodeValueIdNotIn(List<Integer> values) {
            addCriterion("sys_code_value_id not in", values, "sysCodeValueId");
            return (Criteria) this;
        }

        public Criteria andSysCodeValueIdBetween(Integer value1, Integer value2) {
            addCriterion("sys_code_value_id between", value1, value2, "sysCodeValueId");
            return (Criteria) this;
        }

        public Criteria andSysCodeValueIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sys_code_value_id not between", value1, value2, "sysCodeValueId");
            return (Criteria) this;
        }

        public Criteria andCodeTypeIsNull() {
            addCriterion("code_type is null");
            return (Criteria) this;
        }

        public Criteria andCodeTypeIsNotNull() {
            addCriterion("code_type is not null");
            return (Criteria) this;
        }

        public Criteria andCodeTypeEqualTo(String value) {
            addCriterion("code_type =", value, "codeType");
            return (Criteria) this;
        }

        public Criteria andCodeTypeNotEqualTo(String value) {
            addCriterion("code_type <>", value, "codeType");
            return (Criteria) this;
        }

        public Criteria andCodeTypeGreaterThan(String value) {
            addCriterion("code_type >", value, "codeType");
            return (Criteria) this;
        }

        public Criteria andCodeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("code_type >=", value, "codeType");
            return (Criteria) this;
        }

        public Criteria andCodeTypeLessThan(String value) {
            addCriterion("code_type <", value, "codeType");
            return (Criteria) this;
        }

        public Criteria andCodeTypeLessThanOrEqualTo(String value) {
            addCriterion("code_type <=", value, "codeType");
            return (Criteria) this;
        }

        public Criteria andCodeTypeLike(String value) {
            addCriterion("code_type like", value, "codeType");
            return (Criteria) this;
        }

        public Criteria andCodeTypeNotLike(String value) {
            addCriterion("code_type not like", value, "codeType");
            return (Criteria) this;
        }

        public Criteria andCodeTypeIn(List<String> values) {
            addCriterion("code_type in", values, "codeType");
            return (Criteria) this;
        }

        public Criteria andCodeTypeNotIn(List<String> values) {
            addCriterion("code_type not in", values, "codeType");
            return (Criteria) this;
        }

        public Criteria andCodeTypeBetween(String value1, String value2) {
            addCriterion("code_type between", value1, value2, "codeType");
            return (Criteria) this;
        }

        public Criteria andCodeTypeNotBetween(String value1, String value2) {
            addCriterion("code_type not between", value1, value2, "codeType");
            return (Criteria) this;
        }

        public Criteria andCodeTypeNameIsNull() {
            addCriterion("code_type_name is null");
            return (Criteria) this;
        }

        public Criteria andCodeTypeNameIsNotNull() {
            addCriterion("code_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andCodeTypeNameEqualTo(String value) {
            addCriterion("code_type_name =", value, "codeTypeName");
            return (Criteria) this;
        }

        public Criteria andCodeTypeNameNotEqualTo(String value) {
            addCriterion("code_type_name <>", value, "codeTypeName");
            return (Criteria) this;
        }

        public Criteria andCodeTypeNameGreaterThan(String value) {
            addCriterion("code_type_name >", value, "codeTypeName");
            return (Criteria) this;
        }

        public Criteria andCodeTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("code_type_name >=", value, "codeTypeName");
            return (Criteria) this;
        }

        public Criteria andCodeTypeNameLessThan(String value) {
            addCriterion("code_type_name <", value, "codeTypeName");
            return (Criteria) this;
        }

        public Criteria andCodeTypeNameLessThanOrEqualTo(String value) {
            addCriterion("code_type_name <=", value, "codeTypeName");
            return (Criteria) this;
        }

        public Criteria andCodeTypeNameLike(String value) {
            addCriterion("code_type_name like", value, "codeTypeName");
            return (Criteria) this;
        }

        public Criteria andCodeTypeNameNotLike(String value) {
            addCriterion("code_type_name not like", value, "codeTypeName");
            return (Criteria) this;
        }

        public Criteria andCodeTypeNameIn(List<String> values) {
            addCriterion("code_type_name in", values, "codeTypeName");
            return (Criteria) this;
        }

        public Criteria andCodeTypeNameNotIn(List<String> values) {
            addCriterion("code_type_name not in", values, "codeTypeName");
            return (Criteria) this;
        }

        public Criteria andCodeTypeNameBetween(String value1, String value2) {
            addCriterion("code_type_name between", value1, value2, "codeTypeName");
            return (Criteria) this;
        }

        public Criteria andCodeTypeNameNotBetween(String value1, String value2) {
            addCriterion("code_type_name not between", value1, value2, "codeTypeName");
            return (Criteria) this;
        }

        public Criteria andItemCodeIsNull() {
            addCriterion("item_code is null");
            return (Criteria) this;
        }

        public Criteria andItemCodeIsNotNull() {
            addCriterion("item_code is not null");
            return (Criteria) this;
        }

        public Criteria andItemCodeEqualTo(String value) {
            addCriterion("item_code =", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeNotEqualTo(String value) {
            addCriterion("item_code <>", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeGreaterThan(String value) {
            addCriterion("item_code >", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeGreaterThanOrEqualTo(String value) {
            addCriterion("item_code >=", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeLessThan(String value) {
            addCriterion("item_code <", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeLessThanOrEqualTo(String value) {
            addCriterion("item_code <=", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeLike(String value) {
            addCriterion("item_code like", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeNotLike(String value) {
            addCriterion("item_code not like", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeIn(List<String> values) {
            addCriterion("item_code in", values, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeNotIn(List<String> values) {
            addCriterion("item_code not in", values, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeBetween(String value1, String value2) {
            addCriterion("item_code between", value1, value2, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeNotBetween(String value1, String value2) {
            addCriterion("item_code not between", value1, value2, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeNameIsNull() {
            addCriterion("item_code_name is null");
            return (Criteria) this;
        }

        public Criteria andItemCodeNameIsNotNull() {
            addCriterion("item_code_name is not null");
            return (Criteria) this;
        }

        public Criteria andItemCodeNameEqualTo(String value) {
            addCriterion("item_code_name =", value, "itemCodeName");
            return (Criteria) this;
        }

        public Criteria andItemCodeNameNotEqualTo(String value) {
            addCriterion("item_code_name <>", value, "itemCodeName");
            return (Criteria) this;
        }

        public Criteria andItemCodeNameGreaterThan(String value) {
            addCriterion("item_code_name >", value, "itemCodeName");
            return (Criteria) this;
        }

        public Criteria andItemCodeNameGreaterThanOrEqualTo(String value) {
            addCriterion("item_code_name >=", value, "itemCodeName");
            return (Criteria) this;
        }

        public Criteria andItemCodeNameLessThan(String value) {
            addCriterion("item_code_name <", value, "itemCodeName");
            return (Criteria) this;
        }

        public Criteria andItemCodeNameLessThanOrEqualTo(String value) {
            addCriterion("item_code_name <=", value, "itemCodeName");
            return (Criteria) this;
        }

        public Criteria andItemCodeNameLike(String value) {
            addCriterion("item_code_name like", value, "itemCodeName");
            return (Criteria) this;
        }

        public Criteria andItemCodeNameNotLike(String value) {
            addCriterion("item_code_name not like", value, "itemCodeName");
            return (Criteria) this;
        }

        public Criteria andItemCodeNameIn(List<String> values) {
            addCriterion("item_code_name in", values, "itemCodeName");
            return (Criteria) this;
        }

        public Criteria andItemCodeNameNotIn(List<String> values) {
            addCriterion("item_code_name not in", values, "itemCodeName");
            return (Criteria) this;
        }

        public Criteria andItemCodeNameBetween(String value1, String value2) {
            addCriterion("item_code_name between", value1, value2, "itemCodeName");
            return (Criteria) this;
        }

        public Criteria andItemCodeNameNotBetween(String value1, String value2) {
            addCriterion("item_code_name not between", value1, value2, "itemCodeName");
            return (Criteria) this;
        }

        public Criteria andExtend1IsNull() {
            addCriterion("extend1 is null");
            return (Criteria) this;
        }

        public Criteria andExtend1IsNotNull() {
            addCriterion("extend1 is not null");
            return (Criteria) this;
        }

        public Criteria andExtend1EqualTo(String value) {
            addCriterion("extend1 =", value, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1NotEqualTo(String value) {
            addCriterion("extend1 <>", value, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1GreaterThan(String value) {
            addCriterion("extend1 >", value, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1GreaterThanOrEqualTo(String value) {
            addCriterion("extend1 >=", value, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1LessThan(String value) {
            addCriterion("extend1 <", value, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1LessThanOrEqualTo(String value) {
            addCriterion("extend1 <=", value, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1Like(String value) {
            addCriterion("extend1 like", value, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1NotLike(String value) {
            addCriterion("extend1 not like", value, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1In(List<String> values) {
            addCriterion("extend1 in", values, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1NotIn(List<String> values) {
            addCriterion("extend1 not in", values, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1Between(String value1, String value2) {
            addCriterion("extend1 between", value1, value2, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1NotBetween(String value1, String value2) {
            addCriterion("extend1 not between", value1, value2, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend2IsNull() {
            addCriterion("extend2 is null");
            return (Criteria) this;
        }

        public Criteria andExtend2IsNotNull() {
            addCriterion("extend2 is not null");
            return (Criteria) this;
        }

        public Criteria andExtend2EqualTo(String value) {
            addCriterion("extend2 =", value, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2NotEqualTo(String value) {
            addCriterion("extend2 <>", value, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2GreaterThan(String value) {
            addCriterion("extend2 >", value, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2GreaterThanOrEqualTo(String value) {
            addCriterion("extend2 >=", value, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2LessThan(String value) {
            addCriterion("extend2 <", value, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2LessThanOrEqualTo(String value) {
            addCriterion("extend2 <=", value, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2Like(String value) {
            addCriterion("extend2 like", value, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2NotLike(String value) {
            addCriterion("extend2 not like", value, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2In(List<String> values) {
            addCriterion("extend2 in", values, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2NotIn(List<String> values) {
            addCriterion("extend2 not in", values, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2Between(String value1, String value2) {
            addCriterion("extend2 between", value1, value2, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2NotBetween(String value1, String value2) {
            addCriterion("extend2 not between", value1, value2, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend3IsNull() {
            addCriterion("extend3 is null");
            return (Criteria) this;
        }

        public Criteria andExtend3IsNotNull() {
            addCriterion("extend3 is not null");
            return (Criteria) this;
        }

        public Criteria andExtend3EqualTo(String value) {
            addCriterion("extend3 =", value, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3NotEqualTo(String value) {
            addCriterion("extend3 <>", value, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3GreaterThan(String value) {
            addCriterion("extend3 >", value, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3GreaterThanOrEqualTo(String value) {
            addCriterion("extend3 >=", value, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3LessThan(String value) {
            addCriterion("extend3 <", value, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3LessThanOrEqualTo(String value) {
            addCriterion("extend3 <=", value, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3Like(String value) {
            addCriterion("extend3 like", value, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3NotLike(String value) {
            addCriterion("extend3 not like", value, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3In(List<String> values) {
            addCriterion("extend3 in", values, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3NotIn(List<String> values) {
            addCriterion("extend3 not in", values, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3Between(String value1, String value2) {
            addCriterion("extend3 between", value1, value2, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3NotBetween(String value1, String value2) {
            addCriterion("extend3 not between", value1, value2, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend4IsNull() {
            addCriterion("extend4 is null");
            return (Criteria) this;
        }

        public Criteria andExtend4IsNotNull() {
            addCriterion("extend4 is not null");
            return (Criteria) this;
        }

        public Criteria andExtend4EqualTo(String value) {
            addCriterion("extend4 =", value, "extend4");
            return (Criteria) this;
        }

        public Criteria andExtend4NotEqualTo(String value) {
            addCriterion("extend4 <>", value, "extend4");
            return (Criteria) this;
        }

        public Criteria andExtend4GreaterThan(String value) {
            addCriterion("extend4 >", value, "extend4");
            return (Criteria) this;
        }

        public Criteria andExtend4GreaterThanOrEqualTo(String value) {
            addCriterion("extend4 >=", value, "extend4");
            return (Criteria) this;
        }

        public Criteria andExtend4LessThan(String value) {
            addCriterion("extend4 <", value, "extend4");
            return (Criteria) this;
        }

        public Criteria andExtend4LessThanOrEqualTo(String value) {
            addCriterion("extend4 <=", value, "extend4");
            return (Criteria) this;
        }

        public Criteria andExtend4Like(String value) {
            addCriterion("extend4 like", value, "extend4");
            return (Criteria) this;
        }

        public Criteria andExtend4NotLike(String value) {
            addCriterion("extend4 not like", value, "extend4");
            return (Criteria) this;
        }

        public Criteria andExtend4In(List<String> values) {
            addCriterion("extend4 in", values, "extend4");
            return (Criteria) this;
        }

        public Criteria andExtend4NotIn(List<String> values) {
            addCriterion("extend4 not in", values, "extend4");
            return (Criteria) this;
        }

        public Criteria andExtend4Between(String value1, String value2) {
            addCriterion("extend4 between", value1, value2, "extend4");
            return (Criteria) this;
        }

        public Criteria andExtend4NotBetween(String value1, String value2) {
            addCriterion("extend4 not between", value1, value2, "extend4");
            return (Criteria) this;
        }

        public Criteria andExtend5IsNull() {
            addCriterion("extend5 is null");
            return (Criteria) this;
        }

        public Criteria andExtend5IsNotNull() {
            addCriterion("extend5 is not null");
            return (Criteria) this;
        }

        public Criteria andExtend5EqualTo(String value) {
            addCriterion("extend5 =", value, "extend5");
            return (Criteria) this;
        }

        public Criteria andExtend5NotEqualTo(String value) {
            addCriterion("extend5 <>", value, "extend5");
            return (Criteria) this;
        }

        public Criteria andExtend5GreaterThan(String value) {
            addCriterion("extend5 >", value, "extend5");
            return (Criteria) this;
        }

        public Criteria andExtend5GreaterThanOrEqualTo(String value) {
            addCriterion("extend5 >=", value, "extend5");
            return (Criteria) this;
        }

        public Criteria andExtend5LessThan(String value) {
            addCriterion("extend5 <", value, "extend5");
            return (Criteria) this;
        }

        public Criteria andExtend5LessThanOrEqualTo(String value) {
            addCriterion("extend5 <=", value, "extend5");
            return (Criteria) this;
        }

        public Criteria andExtend5Like(String value) {
            addCriterion("extend5 like", value, "extend5");
            return (Criteria) this;
        }

        public Criteria andExtend5NotLike(String value) {
            addCriterion("extend5 not like", value, "extend5");
            return (Criteria) this;
        }

        public Criteria andExtend5In(List<String> values) {
            addCriterion("extend5 in", values, "extend5");
            return (Criteria) this;
        }

        public Criteria andExtend5NotIn(List<String> values) {
            addCriterion("extend5 not in", values, "extend5");
            return (Criteria) this;
        }

        public Criteria andExtend5Between(String value1, String value2) {
            addCriterion("extend5 between", value1, value2, "extend5");
            return (Criteria) this;
        }

        public Criteria andExtend5NotBetween(String value1, String value2) {
            addCriterion("extend5 not between", value1, value2, "extend5");
            return (Criteria) this;
        }

        public Criteria andExtend6IsNull() {
            addCriterion("extend6 is null");
            return (Criteria) this;
        }

        public Criteria andExtend6IsNotNull() {
            addCriterion("extend6 is not null");
            return (Criteria) this;
        }

        public Criteria andExtend6EqualTo(String value) {
            addCriterion("extend6 =", value, "extend6");
            return (Criteria) this;
        }

        public Criteria andExtend6NotEqualTo(String value) {
            addCriterion("extend6 <>", value, "extend6");
            return (Criteria) this;
        }

        public Criteria andExtend6GreaterThan(String value) {
            addCriterion("extend6 >", value, "extend6");
            return (Criteria) this;
        }

        public Criteria andExtend6GreaterThanOrEqualTo(String value) {
            addCriterion("extend6 >=", value, "extend6");
            return (Criteria) this;
        }

        public Criteria andExtend6LessThan(String value) {
            addCriterion("extend6 <", value, "extend6");
            return (Criteria) this;
        }

        public Criteria andExtend6LessThanOrEqualTo(String value) {
            addCriterion("extend6 <=", value, "extend6");
            return (Criteria) this;
        }

        public Criteria andExtend6Like(String value) {
            addCriterion("extend6 like", value, "extend6");
            return (Criteria) this;
        }

        public Criteria andExtend6NotLike(String value) {
            addCriterion("extend6 not like", value, "extend6");
            return (Criteria) this;
        }

        public Criteria andExtend6In(List<String> values) {
            addCriterion("extend6 in", values, "extend6");
            return (Criteria) this;
        }

        public Criteria andExtend6NotIn(List<String> values) {
            addCriterion("extend6 not in", values, "extend6");
            return (Criteria) this;
        }

        public Criteria andExtend6Between(String value1, String value2) {
            addCriterion("extend6 between", value1, value2, "extend6");
            return (Criteria) this;
        }

        public Criteria andExtend6NotBetween(String value1, String value2) {
            addCriterion("extend6 not between", value1, value2, "extend6");
            return (Criteria) this;
        }

        public Criteria andExtend7IsNull() {
            addCriterion("extend7 is null");
            return (Criteria) this;
        }

        public Criteria andExtend7IsNotNull() {
            addCriterion("extend7 is not null");
            return (Criteria) this;
        }

        public Criteria andExtend7EqualTo(String value) {
            addCriterion("extend7 =", value, "extend7");
            return (Criteria) this;
        }

        public Criteria andExtend7NotEqualTo(String value) {
            addCriterion("extend7 <>", value, "extend7");
            return (Criteria) this;
        }

        public Criteria andExtend7GreaterThan(String value) {
            addCriterion("extend7 >", value, "extend7");
            return (Criteria) this;
        }

        public Criteria andExtend7GreaterThanOrEqualTo(String value) {
            addCriterion("extend7 >=", value, "extend7");
            return (Criteria) this;
        }

        public Criteria andExtend7LessThan(String value) {
            addCriterion("extend7 <", value, "extend7");
            return (Criteria) this;
        }

        public Criteria andExtend7LessThanOrEqualTo(String value) {
            addCriterion("extend7 <=", value, "extend7");
            return (Criteria) this;
        }

        public Criteria andExtend7Like(String value) {
            addCriterion("extend7 like", value, "extend7");
            return (Criteria) this;
        }

        public Criteria andExtend7NotLike(String value) {
            addCriterion("extend7 not like", value, "extend7");
            return (Criteria) this;
        }

        public Criteria andExtend7In(List<String> values) {
            addCriterion("extend7 in", values, "extend7");
            return (Criteria) this;
        }

        public Criteria andExtend7NotIn(List<String> values) {
            addCriterion("extend7 not in", values, "extend7");
            return (Criteria) this;
        }

        public Criteria andExtend7Between(String value1, String value2) {
            addCriterion("extend7 between", value1, value2, "extend7");
            return (Criteria) this;
        }

        public Criteria andExtend7NotBetween(String value1, String value2) {
            addCriterion("extend7 not between", value1, value2, "extend7");
            return (Criteria) this;
        }

        public Criteria andExtend8IsNull() {
            addCriterion("extend8 is null");
            return (Criteria) this;
        }

        public Criteria andExtend8IsNotNull() {
            addCriterion("extend8 is not null");
            return (Criteria) this;
        }

        public Criteria andExtend8EqualTo(String value) {
            addCriterion("extend8 =", value, "extend8");
            return (Criteria) this;
        }

        public Criteria andExtend8NotEqualTo(String value) {
            addCriterion("extend8 <>", value, "extend8");
            return (Criteria) this;
        }

        public Criteria andExtend8GreaterThan(String value) {
            addCriterion("extend8 >", value, "extend8");
            return (Criteria) this;
        }

        public Criteria andExtend8GreaterThanOrEqualTo(String value) {
            addCriterion("extend8 >=", value, "extend8");
            return (Criteria) this;
        }

        public Criteria andExtend8LessThan(String value) {
            addCriterion("extend8 <", value, "extend8");
            return (Criteria) this;
        }

        public Criteria andExtend8LessThanOrEqualTo(String value) {
            addCriterion("extend8 <=", value, "extend8");
            return (Criteria) this;
        }

        public Criteria andExtend8Like(String value) {
            addCriterion("extend8 like", value, "extend8");
            return (Criteria) this;
        }

        public Criteria andExtend8NotLike(String value) {
            addCriterion("extend8 not like", value, "extend8");
            return (Criteria) this;
        }

        public Criteria andExtend8In(List<String> values) {
            addCriterion("extend8 in", values, "extend8");
            return (Criteria) this;
        }

        public Criteria andExtend8NotIn(List<String> values) {
            addCriterion("extend8 not in", values, "extend8");
            return (Criteria) this;
        }

        public Criteria andExtend8Between(String value1, String value2) {
            addCriterion("extend8 between", value1, value2, "extend8");
            return (Criteria) this;
        }

        public Criteria andExtend8NotBetween(String value1, String value2) {
            addCriterion("extend8 not between", value1, value2, "extend8");
            return (Criteria) this;
        }
    }

    /**9
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_sys_code_value
     *
     * @mbg.generated do_not_delete_during_merge 2018-07-13 19:28:06
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

    /**
     * 只读. t_sys_code_value
     *
     * @mbg.generated 2018-07-13 19:28:06
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