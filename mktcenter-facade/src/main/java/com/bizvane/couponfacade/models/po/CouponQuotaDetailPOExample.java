package com.bizvane.couponfacade.models.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CouponQuotaDetailPOExample implements Serializable {
    /**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	protected String orderByClause;
	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	protected boolean distinct;
	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	protected List<Criteria> oredCriteria;
	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public CouponQuotaDetailPOExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
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
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * 只读. t_coupon_quota_detail
	 * @mbg.generated  2018-12-12 17:54:49
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

		public Criteria andCouponQuotaDetailIdIsNull() {
			addCriterion("coupon_quota_detail_id is null");
			return (Criteria) this;
		}

		public Criteria andCouponQuotaDetailIdIsNotNull() {
			addCriterion("coupon_quota_detail_id is not null");
			return (Criteria) this;
		}

		public Criteria andCouponQuotaDetailIdEqualTo(Long value) {
			addCriterion("coupon_quota_detail_id =", value, "couponQuotaDetailId");
			return (Criteria) this;
		}

		public Criteria andCouponQuotaDetailIdNotEqualTo(Long value) {
			addCriterion("coupon_quota_detail_id <>", value, "couponQuotaDetailId");
			return (Criteria) this;
		}

		public Criteria andCouponQuotaDetailIdGreaterThan(Long value) {
			addCriterion("coupon_quota_detail_id >", value, "couponQuotaDetailId");
			return (Criteria) this;
		}

		public Criteria andCouponQuotaDetailIdGreaterThanOrEqualTo(Long value) {
			addCriterion("coupon_quota_detail_id >=", value, "couponQuotaDetailId");
			return (Criteria) this;
		}

		public Criteria andCouponQuotaDetailIdLessThan(Long value) {
			addCriterion("coupon_quota_detail_id <", value, "couponQuotaDetailId");
			return (Criteria) this;
		}

		public Criteria andCouponQuotaDetailIdLessThanOrEqualTo(Long value) {
			addCriterion("coupon_quota_detail_id <=", value, "couponQuotaDetailId");
			return (Criteria) this;
		}

		public Criteria andCouponQuotaDetailIdIn(List<Long> values) {
			addCriterion("coupon_quota_detail_id in", values, "couponQuotaDetailId");
			return (Criteria) this;
		}

		public Criteria andCouponQuotaDetailIdNotIn(List<Long> values) {
			addCriterion("coupon_quota_detail_id not in", values, "couponQuotaDetailId");
			return (Criteria) this;
		}

		public Criteria andCouponQuotaDetailIdBetween(Long value1, Long value2) {
			addCriterion("coupon_quota_detail_id between", value1, value2, "couponQuotaDetailId");
			return (Criteria) this;
		}

		public Criteria andCouponQuotaDetailIdNotBetween(Long value1, Long value2) {
			addCriterion("coupon_quota_detail_id not between", value1, value2, "couponQuotaDetailId");
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

		public Criteria andCouponQuotaIdIsNull() {
			addCriterion("coupon_quota_id is null");
			return (Criteria) this;
		}

		public Criteria andCouponQuotaIdIsNotNull() {
			addCriterion("coupon_quota_id is not null");
			return (Criteria) this;
		}

		public Criteria andCouponQuotaIdEqualTo(Long value) {
			addCriterion("coupon_quota_id =", value, "couponQuotaId");
			return (Criteria) this;
		}

		public Criteria andCouponQuotaIdNotEqualTo(Long value) {
			addCriterion("coupon_quota_id <>", value, "couponQuotaId");
			return (Criteria) this;
		}

		public Criteria andCouponQuotaIdGreaterThan(Long value) {
			addCriterion("coupon_quota_id >", value, "couponQuotaId");
			return (Criteria) this;
		}

		public Criteria andCouponQuotaIdGreaterThanOrEqualTo(Long value) {
			addCriterion("coupon_quota_id >=", value, "couponQuotaId");
			return (Criteria) this;
		}

		public Criteria andCouponQuotaIdLessThan(Long value) {
			addCriterion("coupon_quota_id <", value, "couponQuotaId");
			return (Criteria) this;
		}

		public Criteria andCouponQuotaIdLessThanOrEqualTo(Long value) {
			addCriterion("coupon_quota_id <=", value, "couponQuotaId");
			return (Criteria) this;
		}

		public Criteria andCouponQuotaIdIn(List<Long> values) {
			addCriterion("coupon_quota_id in", values, "couponQuotaId");
			return (Criteria) this;
		}

		public Criteria andCouponQuotaIdNotIn(List<Long> values) {
			addCriterion("coupon_quota_id not in", values, "couponQuotaId");
			return (Criteria) this;
		}

		public Criteria andCouponQuotaIdBetween(Long value1, Long value2) {
			addCriterion("coupon_quota_id between", value1, value2, "couponQuotaId");
			return (Criteria) this;
		}

		public Criteria andCouponQuotaIdNotBetween(Long value1, Long value2) {
			addCriterion("coupon_quota_id not between", value1, value2, "couponQuotaId");
			return (Criteria) this;
		}

		public Criteria andQuotaTopicIsNull() {
			addCriterion("quota_topic is null");
			return (Criteria) this;
		}

		public Criteria andQuotaTopicIsNotNull() {
			addCriterion("quota_topic is not null");
			return (Criteria) this;
		}

		public Criteria andQuotaTopicEqualTo(String value) {
			addCriterion("quota_topic =", value, "quotaTopic");
			return (Criteria) this;
		}

		public Criteria andQuotaTopicNotEqualTo(String value) {
			addCriterion("quota_topic <>", value, "quotaTopic");
			return (Criteria) this;
		}

		public Criteria andQuotaTopicGreaterThan(String value) {
			addCriterion("quota_topic >", value, "quotaTopic");
			return (Criteria) this;
		}

		public Criteria andQuotaTopicGreaterThanOrEqualTo(String value) {
			addCriterion("quota_topic >=", value, "quotaTopic");
			return (Criteria) this;
		}

		public Criteria andQuotaTopicLessThan(String value) {
			addCriterion("quota_topic <", value, "quotaTopic");
			return (Criteria) this;
		}

		public Criteria andQuotaTopicLessThanOrEqualTo(String value) {
			addCriterion("quota_topic <=", value, "quotaTopic");
			return (Criteria) this;
		}

		public Criteria andQuotaTopicLike(String value) {
			addCriterion("quota_topic like", value, "quotaTopic");
			return (Criteria) this;
		}

		public Criteria andQuotaTopicNotLike(String value) {
			addCriterion("quota_topic not like", value, "quotaTopic");
			return (Criteria) this;
		}

		public Criteria andQuotaTopicIn(List<String> values) {
			addCriterion("quota_topic in", values, "quotaTopic");
			return (Criteria) this;
		}

		public Criteria andQuotaTopicNotIn(List<String> values) {
			addCriterion("quota_topic not in", values, "quotaTopic");
			return (Criteria) this;
		}

		public Criteria andQuotaTopicBetween(String value1, String value2) {
			addCriterion("quota_topic between", value1, value2, "quotaTopic");
			return (Criteria) this;
		}

		public Criteria andQuotaTopicNotBetween(String value1, String value2) {
			addCriterion("quota_topic not between", value1, value2, "quotaTopic");
			return (Criteria) this;
		}

		public Criteria andSysStaffIdIsNull() {
			addCriterion("sys_staff_id is null");
			return (Criteria) this;
		}

		public Criteria andSysStaffIdIsNotNull() {
			addCriterion("sys_staff_id is not null");
			return (Criteria) this;
		}

		public Criteria andSysStaffIdEqualTo(Long value) {
			addCriterion("sys_staff_id =", value, "sysStaffId");
			return (Criteria) this;
		}

		public Criteria andSysStaffIdNotEqualTo(Long value) {
			addCriterion("sys_staff_id <>", value, "sysStaffId");
			return (Criteria) this;
		}

		public Criteria andSysStaffIdGreaterThan(Long value) {
			addCriterion("sys_staff_id >", value, "sysStaffId");
			return (Criteria) this;
		}

		public Criteria andSysStaffIdGreaterThanOrEqualTo(Long value) {
			addCriterion("sys_staff_id >=", value, "sysStaffId");
			return (Criteria) this;
		}

		public Criteria andSysStaffIdLessThan(Long value) {
			addCriterion("sys_staff_id <", value, "sysStaffId");
			return (Criteria) this;
		}

		public Criteria andSysStaffIdLessThanOrEqualTo(Long value) {
			addCriterion("sys_staff_id <=", value, "sysStaffId");
			return (Criteria) this;
		}

		public Criteria andSysStaffIdIn(List<Long> values) {
			addCriterion("sys_staff_id in", values, "sysStaffId");
			return (Criteria) this;
		}

		public Criteria andSysStaffIdNotIn(List<Long> values) {
			addCriterion("sys_staff_id not in", values, "sysStaffId");
			return (Criteria) this;
		}

		public Criteria andSysStaffIdBetween(Long value1, Long value2) {
			addCriterion("sys_staff_id between", value1, value2, "sysStaffId");
			return (Criteria) this;
		}

		public Criteria andSysStaffIdNotBetween(Long value1, Long value2) {
			addCriterion("sys_staff_id not between", value1, value2, "sysStaffId");
			return (Criteria) this;
		}

		public Criteria andStaffCodeIsNull() {
			addCriterion("staff_code is null");
			return (Criteria) this;
		}

		public Criteria andStaffCodeIsNotNull() {
			addCriterion("staff_code is not null");
			return (Criteria) this;
		}

		public Criteria andStaffCodeEqualTo(String value) {
			addCriterion("staff_code =", value, "staffCode");
			return (Criteria) this;
		}

		public Criteria andStaffCodeNotEqualTo(String value) {
			addCriterion("staff_code <>", value, "staffCode");
			return (Criteria) this;
		}

		public Criteria andStaffCodeGreaterThan(String value) {
			addCriterion("staff_code >", value, "staffCode");
			return (Criteria) this;
		}

		public Criteria andStaffCodeGreaterThanOrEqualTo(String value) {
			addCriterion("staff_code >=", value, "staffCode");
			return (Criteria) this;
		}

		public Criteria andStaffCodeLessThan(String value) {
			addCriterion("staff_code <", value, "staffCode");
			return (Criteria) this;
		}

		public Criteria andStaffCodeLessThanOrEqualTo(String value) {
			addCriterion("staff_code <=", value, "staffCode");
			return (Criteria) this;
		}

		public Criteria andStaffCodeLike(String value) {
			addCriterion("staff_code like", value, "staffCode");
			return (Criteria) this;
		}

		public Criteria andStaffCodeNotLike(String value) {
			addCriterion("staff_code not like", value, "staffCode");
			return (Criteria) this;
		}

		public Criteria andStaffCodeIn(List<String> values) {
			addCriterion("staff_code in", values, "staffCode");
			return (Criteria) this;
		}

		public Criteria andStaffCodeNotIn(List<String> values) {
			addCriterion("staff_code not in", values, "staffCode");
			return (Criteria) this;
		}

		public Criteria andStaffCodeBetween(String value1, String value2) {
			addCriterion("staff_code between", value1, value2, "staffCode");
			return (Criteria) this;
		}

		public Criteria andStaffCodeNotBetween(String value1, String value2) {
			addCriterion("staff_code not between", value1, value2, "staffCode");
			return (Criteria) this;
		}

		public Criteria andStaffNameIsNull() {
			addCriterion("staff_name is null");
			return (Criteria) this;
		}

		public Criteria andStaffNameIsNotNull() {
			addCriterion("staff_name is not null");
			return (Criteria) this;
		}

		public Criteria andStaffNameEqualTo(String value) {
			addCriterion("staff_name =", value, "staffName");
			return (Criteria) this;
		}

		public Criteria andStaffNameNotEqualTo(String value) {
			addCriterion("staff_name <>", value, "staffName");
			return (Criteria) this;
		}

		public Criteria andStaffNameGreaterThan(String value) {
			addCriterion("staff_name >", value, "staffName");
			return (Criteria) this;
		}

		public Criteria andStaffNameGreaterThanOrEqualTo(String value) {
			addCriterion("staff_name >=", value, "staffName");
			return (Criteria) this;
		}

		public Criteria andStaffNameLessThan(String value) {
			addCriterion("staff_name <", value, "staffName");
			return (Criteria) this;
		}

		public Criteria andStaffNameLessThanOrEqualTo(String value) {
			addCriterion("staff_name <=", value, "staffName");
			return (Criteria) this;
		}

		public Criteria andStaffNameLike(String value) {
			addCriterion("staff_name like", value, "staffName");
			return (Criteria) this;
		}

		public Criteria andStaffNameNotLike(String value) {
			addCriterion("staff_name not like", value, "staffName");
			return (Criteria) this;
		}

		public Criteria andStaffNameIn(List<String> values) {
			addCriterion("staff_name in", values, "staffName");
			return (Criteria) this;
		}

		public Criteria andStaffNameNotIn(List<String> values) {
			addCriterion("staff_name not in", values, "staffName");
			return (Criteria) this;
		}

		public Criteria andStaffNameBetween(String value1, String value2) {
			addCriterion("staff_name between", value1, value2, "staffName");
			return (Criteria) this;
		}

		public Criteria andStaffNameNotBetween(String value1, String value2) {
			addCriterion("staff_name not between", value1, value2, "staffName");
			return (Criteria) this;
		}

		public Criteria andStoreNameIsNull() {
			addCriterion("store_name is null");
			return (Criteria) this;
		}

		public Criteria andStoreNameIsNotNull() {
			addCriterion("store_name is not null");
			return (Criteria) this;
		}

		public Criteria andStoreNameEqualTo(String value) {
			addCriterion("store_name =", value, "storeName");
			return (Criteria) this;
		}

		public Criteria andStoreNameNotEqualTo(String value) {
			addCriterion("store_name <>", value, "storeName");
			return (Criteria) this;
		}

		public Criteria andStoreNameGreaterThan(String value) {
			addCriterion("store_name >", value, "storeName");
			return (Criteria) this;
		}

		public Criteria andStoreNameGreaterThanOrEqualTo(String value) {
			addCriterion("store_name >=", value, "storeName");
			return (Criteria) this;
		}

		public Criteria andStoreNameLessThan(String value) {
			addCriterion("store_name <", value, "storeName");
			return (Criteria) this;
		}

		public Criteria andStoreNameLessThanOrEqualTo(String value) {
			addCriterion("store_name <=", value, "storeName");
			return (Criteria) this;
		}

		public Criteria andStoreNameLike(String value) {
			addCriterion("store_name like", value, "storeName");
			return (Criteria) this;
		}

		public Criteria andStoreNameNotLike(String value) {
			addCriterion("store_name not like", value, "storeName");
			return (Criteria) this;
		}

		public Criteria andStoreNameIn(List<String> values) {
			addCriterion("store_name in", values, "storeName");
			return (Criteria) this;
		}

		public Criteria andStoreNameNotIn(List<String> values) {
			addCriterion("store_name not in", values, "storeName");
			return (Criteria) this;
		}

		public Criteria andStoreNameBetween(String value1, String value2) {
			addCriterion("store_name between", value1, value2, "storeName");
			return (Criteria) this;
		}

		public Criteria andStoreNameNotBetween(String value1, String value2) {
			addCriterion("store_name not between", value1, value2, "storeName");
			return (Criteria) this;
		}

		public Criteria andStoreOfflineCodeIsNull() {
			addCriterion("store_offline_code is null");
			return (Criteria) this;
		}

		public Criteria andStoreOfflineCodeIsNotNull() {
			addCriterion("store_offline_code is not null");
			return (Criteria) this;
		}

		public Criteria andStoreOfflineCodeEqualTo(String value) {
			addCriterion("store_offline_code =", value, "storeOfflineCode");
			return (Criteria) this;
		}

		public Criteria andStoreOfflineCodeNotEqualTo(String value) {
			addCriterion("store_offline_code <>", value, "storeOfflineCode");
			return (Criteria) this;
		}

		public Criteria andStoreOfflineCodeGreaterThan(String value) {
			addCriterion("store_offline_code >", value, "storeOfflineCode");
			return (Criteria) this;
		}

		public Criteria andStoreOfflineCodeGreaterThanOrEqualTo(String value) {
			addCriterion("store_offline_code >=", value, "storeOfflineCode");
			return (Criteria) this;
		}

		public Criteria andStoreOfflineCodeLessThan(String value) {
			addCriterion("store_offline_code <", value, "storeOfflineCode");
			return (Criteria) this;
		}

		public Criteria andStoreOfflineCodeLessThanOrEqualTo(String value) {
			addCriterion("store_offline_code <=", value, "storeOfflineCode");
			return (Criteria) this;
		}

		public Criteria andStoreOfflineCodeLike(String value) {
			addCriterion("store_offline_code like", value, "storeOfflineCode");
			return (Criteria) this;
		}

		public Criteria andStoreOfflineCodeNotLike(String value) {
			addCriterion("store_offline_code not like", value, "storeOfflineCode");
			return (Criteria) this;
		}

		public Criteria andStoreOfflineCodeIn(List<String> values) {
			addCriterion("store_offline_code in", values, "storeOfflineCode");
			return (Criteria) this;
		}

		public Criteria andStoreOfflineCodeNotIn(List<String> values) {
			addCriterion("store_offline_code not in", values, "storeOfflineCode");
			return (Criteria) this;
		}

		public Criteria andStoreOfflineCodeBetween(String value1, String value2) {
			addCriterion("store_offline_code between", value1, value2, "storeOfflineCode");
			return (Criteria) this;
		}

		public Criteria andStoreOfflineCodeNotBetween(String value1, String value2) {
			addCriterion("store_offline_code not between", value1, value2, "storeOfflineCode");
			return (Criteria) this;
		}

		public Criteria andTotalNumberIsNull() {
			addCriterion("total_number is null");
			return (Criteria) this;
		}

		public Criteria andTotalNumberIsNotNull() {
			addCriterion("total_number is not null");
			return (Criteria) this;
		}

		public Criteria andTotalNumberEqualTo(Integer value) {
			addCriterion("total_number =", value, "totalNumber");
			return (Criteria) this;
		}

		public Criteria andTotalNumberNotEqualTo(Integer value) {
			addCriterion("total_number <>", value, "totalNumber");
			return (Criteria) this;
		}

		public Criteria andTotalNumberGreaterThan(Integer value) {
			addCriterion("total_number >", value, "totalNumber");
			return (Criteria) this;
		}

		public Criteria andTotalNumberGreaterThanOrEqualTo(Integer value) {
			addCriterion("total_number >=", value, "totalNumber");
			return (Criteria) this;
		}

		public Criteria andTotalNumberLessThan(Integer value) {
			addCriterion("total_number <", value, "totalNumber");
			return (Criteria) this;
		}

		public Criteria andTotalNumberLessThanOrEqualTo(Integer value) {
			addCriterion("total_number <=", value, "totalNumber");
			return (Criteria) this;
		}

		public Criteria andTotalNumberIn(List<Integer> values) {
			addCriterion("total_number in", values, "totalNumber");
			return (Criteria) this;
		}

		public Criteria andTotalNumberNotIn(List<Integer> values) {
			addCriterion("total_number not in", values, "totalNumber");
			return (Criteria) this;
		}

		public Criteria andTotalNumberBetween(Integer value1, Integer value2) {
			addCriterion("total_number between", value1, value2, "totalNumber");
			return (Criteria) this;
		}

		public Criteria andTotalNumberNotBetween(Integer value1, Integer value2) {
			addCriterion("total_number not between", value1, value2, "totalNumber");
			return (Criteria) this;
		}

		public Criteria andUseNumberIsNull() {
			addCriterion("use_number is null");
			return (Criteria) this;
		}

		public Criteria andUseNumberIsNotNull() {
			addCriterion("use_number is not null");
			return (Criteria) this;
		}

		public Criteria andUseNumberEqualTo(Integer value) {
			addCriterion("use_number =", value, "useNumber");
			return (Criteria) this;
		}

		public Criteria andUseNumberNotEqualTo(Integer value) {
			addCriterion("use_number <>", value, "useNumber");
			return (Criteria) this;
		}

		public Criteria andUseNumberGreaterThan(Integer value) {
			addCriterion("use_number >", value, "useNumber");
			return (Criteria) this;
		}

		public Criteria andUseNumberGreaterThanOrEqualTo(Integer value) {
			addCriterion("use_number >=", value, "useNumber");
			return (Criteria) this;
		}

		public Criteria andUseNumberLessThan(Integer value) {
			addCriterion("use_number <", value, "useNumber");
			return (Criteria) this;
		}

		public Criteria andUseNumberLessThanOrEqualTo(Integer value) {
			addCriterion("use_number <=", value, "useNumber");
			return (Criteria) this;
		}

		public Criteria andUseNumberIn(List<Integer> values) {
			addCriterion("use_number in", values, "useNumber");
			return (Criteria) this;
		}

		public Criteria andUseNumberNotIn(List<Integer> values) {
			addCriterion("use_number not in", values, "useNumber");
			return (Criteria) this;
		}

		public Criteria andUseNumberBetween(Integer value1, Integer value2) {
			addCriterion("use_number between", value1, value2, "useNumber");
			return (Criteria) this;
		}

		public Criteria andUseNumberNotBetween(Integer value1, Integer value2) {
			addCriterion("use_number not between", value1, value2, "useNumber");
			return (Criteria) this;
		}

		public Criteria andUnuseNumberIsNull() {
			addCriterion("unuse_number is null");
			return (Criteria) this;
		}

		public Criteria andUnuseNumberIsNotNull() {
			addCriterion("unuse_number is not null");
			return (Criteria) this;
		}

		public Criteria andUnuseNumberEqualTo(Integer value) {
			addCriterion("unuse_number =", value, "unuseNumber");
			return (Criteria) this;
		}

		public Criteria andUnuseNumberNotEqualTo(Integer value) {
			addCriterion("unuse_number <>", value, "unuseNumber");
			return (Criteria) this;
		}

		public Criteria andUnuseNumberGreaterThan(Integer value) {
			addCriterion("unuse_number >", value, "unuseNumber");
			return (Criteria) this;
		}

		public Criteria andUnuseNumberGreaterThanOrEqualTo(Integer value) {
			addCriterion("unuse_number >=", value, "unuseNumber");
			return (Criteria) this;
		}

		public Criteria andUnuseNumberLessThan(Integer value) {
			addCriterion("unuse_number <", value, "unuseNumber");
			return (Criteria) this;
		}

		public Criteria andUnuseNumberLessThanOrEqualTo(Integer value) {
			addCriterion("unuse_number <=", value, "unuseNumber");
			return (Criteria) this;
		}

		public Criteria andUnuseNumberIn(List<Integer> values) {
			addCriterion("unuse_number in", values, "unuseNumber");
			return (Criteria) this;
		}

		public Criteria andUnuseNumberNotIn(List<Integer> values) {
			addCriterion("unuse_number not in", values, "unuseNumber");
			return (Criteria) this;
		}

		public Criteria andUnuseNumberBetween(Integer value1, Integer value2) {
			addCriterion("unuse_number between", value1, value2, "unuseNumber");
			return (Criteria) this;
		}

		public Criteria andUnuseNumberNotBetween(Integer value1, Integer value2) {
			addCriterion("unuse_number not between", value1, value2, "unuseNumber");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionCodeIsNull() {
			addCriterion("coupon_definition_code is null");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionCodeIsNotNull() {
			addCriterion("coupon_definition_code is not null");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionCodeEqualTo(String value) {
			addCriterion("coupon_definition_code =", value, "couponDefinitionCode");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionCodeNotEqualTo(String value) {
			addCriterion("coupon_definition_code <>", value, "couponDefinitionCode");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionCodeGreaterThan(String value) {
			addCriterion("coupon_definition_code >", value, "couponDefinitionCode");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionCodeGreaterThanOrEqualTo(String value) {
			addCriterion("coupon_definition_code >=", value, "couponDefinitionCode");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionCodeLessThan(String value) {
			addCriterion("coupon_definition_code <", value, "couponDefinitionCode");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionCodeLessThanOrEqualTo(String value) {
			addCriterion("coupon_definition_code <=", value, "couponDefinitionCode");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionCodeLike(String value) {
			addCriterion("coupon_definition_code like", value, "couponDefinitionCode");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionCodeNotLike(String value) {
			addCriterion("coupon_definition_code not like", value, "couponDefinitionCode");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionCodeIn(List<String> values) {
			addCriterion("coupon_definition_code in", values, "couponDefinitionCode");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionCodeNotIn(List<String> values) {
			addCriterion("coupon_definition_code not in", values, "couponDefinitionCode");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionCodeBetween(String value1, String value2) {
			addCriterion("coupon_definition_code between", value1, value2, "couponDefinitionCode");
			return (Criteria) this;
		}

		public Criteria andCouponDefinitionCodeNotBetween(String value1, String value2) {
			addCriterion("coupon_definition_code not between", value1, value2, "couponDefinitionCode");
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

		public Criteria andPreferentialTypeIsNull() {
			addCriterion("preferential_type is null");
			return (Criteria) this;
		}

		public Criteria andPreferentialTypeIsNotNull() {
			addCriterion("preferential_type is not null");
			return (Criteria) this;
		}

		public Criteria andPreferentialTypeEqualTo(Byte value) {
			addCriterion("preferential_type =", value, "preferentialType");
			return (Criteria) this;
		}

		public Criteria andPreferentialTypeNotEqualTo(Byte value) {
			addCriterion("preferential_type <>", value, "preferentialType");
			return (Criteria) this;
		}

		public Criteria andPreferentialTypeGreaterThan(Byte value) {
			addCriterion("preferential_type >", value, "preferentialType");
			return (Criteria) this;
		}

		public Criteria andPreferentialTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("preferential_type >=", value, "preferentialType");
			return (Criteria) this;
		}

		public Criteria andPreferentialTypeLessThan(Byte value) {
			addCriterion("preferential_type <", value, "preferentialType");
			return (Criteria) this;
		}

		public Criteria andPreferentialTypeLessThanOrEqualTo(Byte value) {
			addCriterion("preferential_type <=", value, "preferentialType");
			return (Criteria) this;
		}

		public Criteria andPreferentialTypeIn(List<Byte> values) {
			addCriterion("preferential_type in", values, "preferentialType");
			return (Criteria) this;
		}

		public Criteria andPreferentialTypeNotIn(List<Byte> values) {
			addCriterion("preferential_type not in", values, "preferentialType");
			return (Criteria) this;
		}

		public Criteria andPreferentialTypeBetween(Byte value1, Byte value2) {
			addCriterion("preferential_type between", value1, value2, "preferentialType");
			return (Criteria) this;
		}

		public Criteria andPreferentialTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("preferential_type not between", value1, value2, "preferentialType");
			return (Criteria) this;
		}

		public Criteria andMinConsumeIsNull() {
			addCriterion("min_consume is null");
			return (Criteria) this;
		}

		public Criteria andMinConsumeIsNotNull() {
			addCriterion("min_consume is not null");
			return (Criteria) this;
		}

		public Criteria andMinConsumeEqualTo(BigDecimal value) {
			addCriterion("min_consume =", value, "minConsume");
			return (Criteria) this;
		}

		public Criteria andMinConsumeNotEqualTo(BigDecimal value) {
			addCriterion("min_consume <>", value, "minConsume");
			return (Criteria) this;
		}

		public Criteria andMinConsumeGreaterThan(BigDecimal value) {
			addCriterion("min_consume >", value, "minConsume");
			return (Criteria) this;
		}

		public Criteria andMinConsumeGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("min_consume >=", value, "minConsume");
			return (Criteria) this;
		}

		public Criteria andMinConsumeLessThan(BigDecimal value) {
			addCriterion("min_consume <", value, "minConsume");
			return (Criteria) this;
		}

		public Criteria andMinConsumeLessThanOrEqualTo(BigDecimal value) {
			addCriterion("min_consume <=", value, "minConsume");
			return (Criteria) this;
		}

		public Criteria andMinConsumeIn(List<BigDecimal> values) {
			addCriterion("min_consume in", values, "minConsume");
			return (Criteria) this;
		}

		public Criteria andMinConsumeNotIn(List<BigDecimal> values) {
			addCriterion("min_consume not in", values, "minConsume");
			return (Criteria) this;
		}

		public Criteria andMinConsumeBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("min_consume between", value1, value2, "minConsume");
			return (Criteria) this;
		}

		public Criteria andMinConsumeNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("min_consume not between", value1, value2, "minConsume");
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

		public Criteria andMoneyIsNull() {
			addCriterion("money is null");
			return (Criteria) this;
		}

		public Criteria andMoneyIsNotNull() {
			addCriterion("money is not null");
			return (Criteria) this;
		}

		public Criteria andMoneyEqualTo(BigDecimal value) {
			addCriterion("money =", value, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyNotEqualTo(BigDecimal value) {
			addCriterion("money <>", value, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyGreaterThan(BigDecimal value) {
			addCriterion("money >", value, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("money >=", value, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyLessThan(BigDecimal value) {
			addCriterion("money <", value, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyLessThanOrEqualTo(BigDecimal value) {
			addCriterion("money <=", value, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyIn(List<BigDecimal> values) {
			addCriterion("money in", values, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyNotIn(List<BigDecimal> values) {
			addCriterion("money not in", values, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("money between", value1, value2, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("money not between", value1, value2, "money");
			return (Criteria) this;
		}

		public Criteria andDiscountIsNull() {
			addCriterion("discount is null");
			return (Criteria) this;
		}

		public Criteria andDiscountIsNotNull() {
			addCriterion("discount is not null");
			return (Criteria) this;
		}

		public Criteria andDiscountEqualTo(BigDecimal value) {
			addCriterion("discount =", value, "discount");
			return (Criteria) this;
		}

		public Criteria andDiscountNotEqualTo(BigDecimal value) {
			addCriterion("discount <>", value, "discount");
			return (Criteria) this;
		}

		public Criteria andDiscountGreaterThan(BigDecimal value) {
			addCriterion("discount >", value, "discount");
			return (Criteria) this;
		}

		public Criteria andDiscountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("discount >=", value, "discount");
			return (Criteria) this;
		}

		public Criteria andDiscountLessThan(BigDecimal value) {
			addCriterion("discount <", value, "discount");
			return (Criteria) this;
		}

		public Criteria andDiscountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("discount <=", value, "discount");
			return (Criteria) this;
		}

		public Criteria andDiscountIn(List<BigDecimal> values) {
			addCriterion("discount in", values, "discount");
			return (Criteria) this;
		}

		public Criteria andDiscountNotIn(List<BigDecimal> values) {
			addCriterion("discount not in", values, "discount");
			return (Criteria) this;
		}

		public Criteria andDiscountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("discount between", value1, value2, "discount");
			return (Criteria) this;
		}

		public Criteria andDiscountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("discount not between", value1, value2, "discount");
			return (Criteria) this;
		}

		public Criteria andValidDayIsNull() {
			addCriterion("valid_day is null");
			return (Criteria) this;
		}

		public Criteria andValidDayIsNotNull() {
			addCriterion("valid_day is not null");
			return (Criteria) this;
		}

		public Criteria andValidDayEqualTo(Integer value) {
			addCriterion("valid_day =", value, "validDay");
			return (Criteria) this;
		}

		public Criteria andValidDayNotEqualTo(Integer value) {
			addCriterion("valid_day <>", value, "validDay");
			return (Criteria) this;
		}

		public Criteria andValidDayGreaterThan(Integer value) {
			addCriterion("valid_day >", value, "validDay");
			return (Criteria) this;
		}

		public Criteria andValidDayGreaterThanOrEqualTo(Integer value) {
			addCriterion("valid_day >=", value, "validDay");
			return (Criteria) this;
		}

		public Criteria andValidDayLessThan(Integer value) {
			addCriterion("valid_day <", value, "validDay");
			return (Criteria) this;
		}

		public Criteria andValidDayLessThanOrEqualTo(Integer value) {
			addCriterion("valid_day <=", value, "validDay");
			return (Criteria) this;
		}

		public Criteria andValidDayIn(List<Integer> values) {
			addCriterion("valid_day in", values, "validDay");
			return (Criteria) this;
		}

		public Criteria andValidDayNotIn(List<Integer> values) {
			addCriterion("valid_day not in", values, "validDay");
			return (Criteria) this;
		}

		public Criteria andValidDayBetween(Integer value1, Integer value2) {
			addCriterion("valid_day between", value1, value2, "validDay");
			return (Criteria) this;
		}

		public Criteria andValidDayNotBetween(Integer value1, Integer value2) {
			addCriterion("valid_day not between", value1, value2, "validDay");
			return (Criteria) this;
		}

		public Criteria andValidTypeIsNull() {
			addCriterion("valid_type is null");
			return (Criteria) this;
		}

		public Criteria andValidTypeIsNotNull() {
			addCriterion("valid_type is not null");
			return (Criteria) this;
		}

		public Criteria andValidTypeEqualTo(Byte value) {
			addCriterion("valid_type =", value, "validType");
			return (Criteria) this;
		}

		public Criteria andValidTypeNotEqualTo(Byte value) {
			addCriterion("valid_type <>", value, "validType");
			return (Criteria) this;
		}

		public Criteria andValidTypeGreaterThan(Byte value) {
			addCriterion("valid_type >", value, "validType");
			return (Criteria) this;
		}

		public Criteria andValidTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("valid_type >=", value, "validType");
			return (Criteria) this;
		}

		public Criteria andValidTypeLessThan(Byte value) {
			addCriterion("valid_type <", value, "validType");
			return (Criteria) this;
		}

		public Criteria andValidTypeLessThanOrEqualTo(Byte value) {
			addCriterion("valid_type <=", value, "validType");
			return (Criteria) this;
		}

		public Criteria andValidTypeIn(List<Byte> values) {
			addCriterion("valid_type in", values, "validType");
			return (Criteria) this;
		}

		public Criteria andValidTypeNotIn(List<Byte> values) {
			addCriterion("valid_type not in", values, "validType");
			return (Criteria) this;
		}

		public Criteria andValidTypeBetween(Byte value1, Byte value2) {
			addCriterion("valid_type between", value1, value2, "validType");
			return (Criteria) this;
		}

		public Criteria andValidTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("valid_type not between", value1, value2, "validType");
			return (Criteria) this;
		}

		public Criteria andInfoIsNull() {
			addCriterion("info is null");
			return (Criteria) this;
		}

		public Criteria andInfoIsNotNull() {
			addCriterion("info is not null");
			return (Criteria) this;
		}

		public Criteria andInfoEqualTo(String value) {
			addCriterion("info =", value, "info");
			return (Criteria) this;
		}

		public Criteria andInfoNotEqualTo(String value) {
			addCriterion("info <>", value, "info");
			return (Criteria) this;
		}

		public Criteria andInfoGreaterThan(String value) {
			addCriterion("info >", value, "info");
			return (Criteria) this;
		}

		public Criteria andInfoGreaterThanOrEqualTo(String value) {
			addCriterion("info >=", value, "info");
			return (Criteria) this;
		}

		public Criteria andInfoLessThan(String value) {
			addCriterion("info <", value, "info");
			return (Criteria) this;
		}

		public Criteria andInfoLessThanOrEqualTo(String value) {
			addCriterion("info <=", value, "info");
			return (Criteria) this;
		}

		public Criteria andInfoLike(String value) {
			addCriterion("info like", value, "info");
			return (Criteria) this;
		}

		public Criteria andInfoNotLike(String value) {
			addCriterion("info not like", value, "info");
			return (Criteria) this;
		}

		public Criteria andInfoIn(List<String> values) {
			addCriterion("info in", values, "info");
			return (Criteria) this;
		}

		public Criteria andInfoNotIn(List<String> values) {
			addCriterion("info not in", values, "info");
			return (Criteria) this;
		}

		public Criteria andInfoBetween(String value1, String value2) {
			addCriterion("info between", value1, value2, "info");
			return (Criteria) this;
		}

		public Criteria andInfoNotBetween(String value1, String value2) {
			addCriterion("info not between", value1, value2, "info");
			return (Criteria) this;
		}

		public Criteria andValidDateStartIsNull() {
			addCriterion("valid_date_start is null");
			return (Criteria) this;
		}

		public Criteria andValidDateStartIsNotNull() {
			addCriterion("valid_date_start is not null");
			return (Criteria) this;
		}

		public Criteria andValidDateStartEqualTo(Date value) {
			addCriterion("valid_date_start =", value, "validDateStart");
			return (Criteria) this;
		}

		public Criteria andValidDateStartNotEqualTo(Date value) {
			addCriterion("valid_date_start <>", value, "validDateStart");
			return (Criteria) this;
		}

		public Criteria andValidDateStartGreaterThan(Date value) {
			addCriterion("valid_date_start >", value, "validDateStart");
			return (Criteria) this;
		}

		public Criteria andValidDateStartGreaterThanOrEqualTo(Date value) {
			addCriterion("valid_date_start >=", value, "validDateStart");
			return (Criteria) this;
		}

		public Criteria andValidDateStartLessThan(Date value) {
			addCriterion("valid_date_start <", value, "validDateStart");
			return (Criteria) this;
		}

		public Criteria andValidDateStartLessThanOrEqualTo(Date value) {
			addCriterion("valid_date_start <=", value, "validDateStart");
			return (Criteria) this;
		}

		public Criteria andValidDateStartIn(List<Date> values) {
			addCriterion("valid_date_start in", values, "validDateStart");
			return (Criteria) this;
		}

		public Criteria andValidDateStartNotIn(List<Date> values) {
			addCriterion("valid_date_start not in", values, "validDateStart");
			return (Criteria) this;
		}

		public Criteria andValidDateStartBetween(Date value1, Date value2) {
			addCriterion("valid_date_start between", value1, value2, "validDateStart");
			return (Criteria) this;
		}

		public Criteria andValidDateStartNotBetween(Date value1, Date value2) {
			addCriterion("valid_date_start not between", value1, value2, "validDateStart");
			return (Criteria) this;
		}

		public Criteria andValidDateEndIsNull() {
			addCriterion("valid_date_end is null");
			return (Criteria) this;
		}

		public Criteria andValidDateEndIsNotNull() {
			addCriterion("valid_date_end is not null");
			return (Criteria) this;
		}

		public Criteria andValidDateEndEqualTo(Date value) {
			addCriterion("valid_date_end =", value, "validDateEnd");
			return (Criteria) this;
		}

		public Criteria andValidDateEndNotEqualTo(Date value) {
			addCriterion("valid_date_end <>", value, "validDateEnd");
			return (Criteria) this;
		}

		public Criteria andValidDateEndGreaterThan(Date value) {
			addCriterion("valid_date_end >", value, "validDateEnd");
			return (Criteria) this;
		}

		public Criteria andValidDateEndGreaterThanOrEqualTo(Date value) {
			addCriterion("valid_date_end >=", value, "validDateEnd");
			return (Criteria) this;
		}

		public Criteria andValidDateEndLessThan(Date value) {
			addCriterion("valid_date_end <", value, "validDateEnd");
			return (Criteria) this;
		}

		public Criteria andValidDateEndLessThanOrEqualTo(Date value) {
			addCriterion("valid_date_end <=", value, "validDateEnd");
			return (Criteria) this;
		}

		public Criteria andValidDateEndIn(List<Date> values) {
			addCriterion("valid_date_end in", values, "validDateEnd");
			return (Criteria) this;
		}

		public Criteria andValidDateEndNotIn(List<Date> values) {
			addCriterion("valid_date_end not in", values, "validDateEnd");
			return (Criteria) this;
		}

		public Criteria andValidDateEndBetween(Date value1, Date value2) {
			addCriterion("valid_date_end between", value1, value2, "validDateEnd");
			return (Criteria) this;
		}

		public Criteria andValidDateEndNotBetween(Date value1, Date value2) {
			addCriterion("valid_date_end not between", value1, value2, "validDateEnd");
			return (Criteria) this;
		}

		public Criteria andStartDateStartIsNull() {
			addCriterion("start_date_start is null");
			return (Criteria) this;
		}

		public Criteria andStartDateStartIsNotNull() {
			addCriterion("start_date_start is not null");
			return (Criteria) this;
		}

		public Criteria andStartDateStartEqualTo(Date value) {
			addCriterion("start_date_start =", value, "startDateStart");
			return (Criteria) this;
		}

		public Criteria andStartDateStartNotEqualTo(Date value) {
			addCriterion("start_date_start <>", value, "startDateStart");
			return (Criteria) this;
		}

		public Criteria andStartDateStartGreaterThan(Date value) {
			addCriterion("start_date_start >", value, "startDateStart");
			return (Criteria) this;
		}

		public Criteria andStartDateStartGreaterThanOrEqualTo(Date value) {
			addCriterion("start_date_start >=", value, "startDateStart");
			return (Criteria) this;
		}

		public Criteria andStartDateStartLessThan(Date value) {
			addCriterion("start_date_start <", value, "startDateStart");
			return (Criteria) this;
		}

		public Criteria andStartDateStartLessThanOrEqualTo(Date value) {
			addCriterion("start_date_start <=", value, "startDateStart");
			return (Criteria) this;
		}

		public Criteria andStartDateStartIn(List<Date> values) {
			addCriterion("start_date_start in", values, "startDateStart");
			return (Criteria) this;
		}

		public Criteria andStartDateStartNotIn(List<Date> values) {
			addCriterion("start_date_start not in", values, "startDateStart");
			return (Criteria) this;
		}

		public Criteria andStartDateStartBetween(Date value1, Date value2) {
			addCriterion("start_date_start between", value1, value2, "startDateStart");
			return (Criteria) this;
		}

		public Criteria andStartDateStartNotBetween(Date value1, Date value2) {
			addCriterion("start_date_start not between", value1, value2, "startDateStart");
			return (Criteria) this;
		}

		public Criteria andStartDateEndIsNull() {
			addCriterion("start_date_end is null");
			return (Criteria) this;
		}

		public Criteria andStartDateEndIsNotNull() {
			addCriterion("start_date_end is not null");
			return (Criteria) this;
		}

		public Criteria andStartDateEndEqualTo(Date value) {
			addCriterion("start_date_end =", value, "startDateEnd");
			return (Criteria) this;
		}

		public Criteria andStartDateEndNotEqualTo(Date value) {
			addCriterion("start_date_end <>", value, "startDateEnd");
			return (Criteria) this;
		}

		public Criteria andStartDateEndGreaterThan(Date value) {
			addCriterion("start_date_end >", value, "startDateEnd");
			return (Criteria) this;
		}

		public Criteria andStartDateEndGreaterThanOrEqualTo(Date value) {
			addCriterion("start_date_end >=", value, "startDateEnd");
			return (Criteria) this;
		}

		public Criteria andStartDateEndLessThan(Date value) {
			addCriterion("start_date_end <", value, "startDateEnd");
			return (Criteria) this;
		}

		public Criteria andStartDateEndLessThanOrEqualTo(Date value) {
			addCriterion("start_date_end <=", value, "startDateEnd");
			return (Criteria) this;
		}

		public Criteria andStartDateEndIn(List<Date> values) {
			addCriterion("start_date_end in", values, "startDateEnd");
			return (Criteria) this;
		}

		public Criteria andStartDateEndNotIn(List<Date> values) {
			addCriterion("start_date_end not in", values, "startDateEnd");
			return (Criteria) this;
		}

		public Criteria andStartDateEndBetween(Date value1, Date value2) {
			addCriterion("start_date_end between", value1, value2, "startDateEnd");
			return (Criteria) this;
		}

		public Criteria andStartDateEndNotBetween(Date value1, Date value2) {
			addCriterion("start_date_end not between", value1, value2, "startDateEnd");
			return (Criteria) this;
		}

		public Criteria andEndDateStartIsNull() {
			addCriterion("end_date_start is null");
			return (Criteria) this;
		}

		public Criteria andEndDateStartIsNotNull() {
			addCriterion("end_date_start is not null");
			return (Criteria) this;
		}

		public Criteria andEndDateStartEqualTo(Date value) {
			addCriterion("end_date_start =", value, "endDateStart");
			return (Criteria) this;
		}

		public Criteria andEndDateStartNotEqualTo(Date value) {
			addCriterion("end_date_start <>", value, "endDateStart");
			return (Criteria) this;
		}

		public Criteria andEndDateStartGreaterThan(Date value) {
			addCriterion("end_date_start >", value, "endDateStart");
			return (Criteria) this;
		}

		public Criteria andEndDateStartGreaterThanOrEqualTo(Date value) {
			addCriterion("end_date_start >=", value, "endDateStart");
			return (Criteria) this;
		}

		public Criteria andEndDateStartLessThan(Date value) {
			addCriterion("end_date_start <", value, "endDateStart");
			return (Criteria) this;
		}

		public Criteria andEndDateStartLessThanOrEqualTo(Date value) {
			addCriterion("end_date_start <=", value, "endDateStart");
			return (Criteria) this;
		}

		public Criteria andEndDateStartIn(List<Date> values) {
			addCriterion("end_date_start in", values, "endDateStart");
			return (Criteria) this;
		}

		public Criteria andEndDateStartNotIn(List<Date> values) {
			addCriterion("end_date_start not in", values, "endDateStart");
			return (Criteria) this;
		}

		public Criteria andEndDateStartBetween(Date value1, Date value2) {
			addCriterion("end_date_start between", value1, value2, "endDateStart");
			return (Criteria) this;
		}

		public Criteria andEndDateStartNotBetween(Date value1, Date value2) {
			addCriterion("end_date_start not between", value1, value2, "endDateStart");
			return (Criteria) this;
		}

		public Criteria andEndDateEndIsNull() {
			addCriterion("end_date_end is null");
			return (Criteria) this;
		}

		public Criteria andEndDateEndIsNotNull() {
			addCriterion("end_date_end is not null");
			return (Criteria) this;
		}

		public Criteria andEndDateEndEqualTo(Date value) {
			addCriterion("end_date_end =", value, "endDateEnd");
			return (Criteria) this;
		}

		public Criteria andEndDateEndNotEqualTo(Date value) {
			addCriterion("end_date_end <>", value, "endDateEnd");
			return (Criteria) this;
		}

		public Criteria andEndDateEndGreaterThan(Date value) {
			addCriterion("end_date_end >", value, "endDateEnd");
			return (Criteria) this;
		}

		public Criteria andEndDateEndGreaterThanOrEqualTo(Date value) {
			addCriterion("end_date_end >=", value, "endDateEnd");
			return (Criteria) this;
		}

		public Criteria andEndDateEndLessThan(Date value) {
			addCriterion("end_date_end <", value, "endDateEnd");
			return (Criteria) this;
		}

		public Criteria andEndDateEndLessThanOrEqualTo(Date value) {
			addCriterion("end_date_end <=", value, "endDateEnd");
			return (Criteria) this;
		}

		public Criteria andEndDateEndIn(List<Date> values) {
			addCriterion("end_date_end in", values, "endDateEnd");
			return (Criteria) this;
		}

		public Criteria andEndDateEndNotIn(List<Date> values) {
			addCriterion("end_date_end not in", values, "endDateEnd");
			return (Criteria) this;
		}

		public Criteria andEndDateEndBetween(Date value1, Date value2) {
			addCriterion("end_date_end between", value1, value2, "endDateEnd");
			return (Criteria) this;
		}

		public Criteria andEndDateEndNotBetween(Date value1, Date value2) {
			addCriterion("end_date_end not between", value1, value2, "endDateEnd");
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

		public Criteria andNoteIsNull() {
			addCriterion("note is null");
			return (Criteria) this;
		}

		public Criteria andNoteIsNotNull() {
			addCriterion("note is not null");
			return (Criteria) this;
		}

		public Criteria andNoteEqualTo(String value) {
			addCriterion("note =", value, "note");
			return (Criteria) this;
		}

		public Criteria andNoteNotEqualTo(String value) {
			addCriterion("note <>", value, "note");
			return (Criteria) this;
		}

		public Criteria andNoteGreaterThan(String value) {
			addCriterion("note >", value, "note");
			return (Criteria) this;
		}

		public Criteria andNoteGreaterThanOrEqualTo(String value) {
			addCriterion("note >=", value, "note");
			return (Criteria) this;
		}

		public Criteria andNoteLessThan(String value) {
			addCriterion("note <", value, "note");
			return (Criteria) this;
		}

		public Criteria andNoteLessThanOrEqualTo(String value) {
			addCriterion("note <=", value, "note");
			return (Criteria) this;
		}

		public Criteria andNoteLike(String value) {
			addCriterion("note like", value, "note");
			return (Criteria) this;
		}

		public Criteria andNoteNotLike(String value) {
			addCriterion("note not like", value, "note");
			return (Criteria) this;
		}

		public Criteria andNoteIn(List<String> values) {
			addCriterion("note in", values, "note");
			return (Criteria) this;
		}

		public Criteria andNoteNotIn(List<String> values) {
			addCriterion("note not in", values, "note");
			return (Criteria) this;
		}

		public Criteria andNoteBetween(String value1, String value2) {
			addCriterion("note between", value1, value2, "note");
			return (Criteria) this;
		}

		public Criteria andNoteNotBetween(String value1, String value2) {
			addCriterion("note not between", value1, value2, "note");
			return (Criteria) this;
		}

		public Criteria andStateCodeIsNull() {
			addCriterion("state_code is null");
			return (Criteria) this;
		}

		public Criteria andStateCodeIsNotNull() {
			addCriterion("state_code is not null");
			return (Criteria) this;
		}

		public Criteria andStateCodeEqualTo(String value) {
			addCriterion("state_code =", value, "stateCode");
			return (Criteria) this;
		}

		public Criteria andStateCodeNotEqualTo(String value) {
			addCriterion("state_code <>", value, "stateCode");
			return (Criteria) this;
		}

		public Criteria andStateCodeGreaterThan(String value) {
			addCriterion("state_code >", value, "stateCode");
			return (Criteria) this;
		}

		public Criteria andStateCodeGreaterThanOrEqualTo(String value) {
			addCriterion("state_code >=", value, "stateCode");
			return (Criteria) this;
		}

		public Criteria andStateCodeLessThan(String value) {
			addCriterion("state_code <", value, "stateCode");
			return (Criteria) this;
		}

		public Criteria andStateCodeLessThanOrEqualTo(String value) {
			addCriterion("state_code <=", value, "stateCode");
			return (Criteria) this;
		}

		public Criteria andStateCodeLike(String value) {
			addCriterion("state_code like", value, "stateCode");
			return (Criteria) this;
		}

		public Criteria andStateCodeNotLike(String value) {
			addCriterion("state_code not like", value, "stateCode");
			return (Criteria) this;
		}

		public Criteria andStateCodeIn(List<String> values) {
			addCriterion("state_code in", values, "stateCode");
			return (Criteria) this;
		}

		public Criteria andStateCodeNotIn(List<String> values) {
			addCriterion("state_code not in", values, "stateCode");
			return (Criteria) this;
		}

		public Criteria andStateCodeBetween(String value1, String value2) {
			addCriterion("state_code between", value1, value2, "stateCode");
			return (Criteria) this;
		}

		public Criteria andStateCodeNotBetween(String value1, String value2) {
			addCriterion("state_code not between", value1, value2, "stateCode");
			return (Criteria) this;
		}

		public Criteria andStateNameIsNull() {
			addCriterion("state_name is null");
			return (Criteria) this;
		}

		public Criteria andStateNameIsNotNull() {
			addCriterion("state_name is not null");
			return (Criteria) this;
		}

		public Criteria andStateNameEqualTo(String value) {
			addCriterion("state_name =", value, "stateName");
			return (Criteria) this;
		}

		public Criteria andStateNameNotEqualTo(String value) {
			addCriterion("state_name <>", value, "stateName");
			return (Criteria) this;
		}

		public Criteria andStateNameGreaterThan(String value) {
			addCriterion("state_name >", value, "stateName");
			return (Criteria) this;
		}

		public Criteria andStateNameGreaterThanOrEqualTo(String value) {
			addCriterion("state_name >=", value, "stateName");
			return (Criteria) this;
		}

		public Criteria andStateNameLessThan(String value) {
			addCriterion("state_name <", value, "stateName");
			return (Criteria) this;
		}

		public Criteria andStateNameLessThanOrEqualTo(String value) {
			addCriterion("state_name <=", value, "stateName");
			return (Criteria) this;
		}

		public Criteria andStateNameLike(String value) {
			addCriterion("state_name like", value, "stateName");
			return (Criteria) this;
		}

		public Criteria andStateNameNotLike(String value) {
			addCriterion("state_name not like", value, "stateName");
			return (Criteria) this;
		}

		public Criteria andStateNameIn(List<String> values) {
			addCriterion("state_name in", values, "stateName");
			return (Criteria) this;
		}

		public Criteria andStateNameNotIn(List<String> values) {
			addCriterion("state_name not in", values, "stateName");
			return (Criteria) this;
		}

		public Criteria andStateNameBetween(String value1, String value2) {
			addCriterion("state_name between", value1, value2, "stateName");
			return (Criteria) this;
		}

		public Criteria andStateNameNotBetween(String value1, String value2) {
			addCriterion("state_name not between", value1, value2, "stateName");
			return (Criteria) this;
		}

		public Criteria andExtendCodeIsNull() {
			addCriterion("extend_code is null");
			return (Criteria) this;
		}

		public Criteria andExtendCodeIsNotNull() {
			addCriterion("extend_code is not null");
			return (Criteria) this;
		}

		public Criteria andExtendCodeEqualTo(String value) {
			addCriterion("extend_code =", value, "extendCode");
			return (Criteria) this;
		}

		public Criteria andExtendCodeNotEqualTo(String value) {
			addCriterion("extend_code <>", value, "extendCode");
			return (Criteria) this;
		}

		public Criteria andExtendCodeGreaterThan(String value) {
			addCriterion("extend_code >", value, "extendCode");
			return (Criteria) this;
		}

		public Criteria andExtendCodeGreaterThanOrEqualTo(String value) {
			addCriterion("extend_code >=", value, "extendCode");
			return (Criteria) this;
		}

		public Criteria andExtendCodeLessThan(String value) {
			addCriterion("extend_code <", value, "extendCode");
			return (Criteria) this;
		}

		public Criteria andExtendCodeLessThanOrEqualTo(String value) {
			addCriterion("extend_code <=", value, "extendCode");
			return (Criteria) this;
		}

		public Criteria andExtendCodeLike(String value) {
			addCriterion("extend_code like", value, "extendCode");
			return (Criteria) this;
		}

		public Criteria andExtendCodeNotLike(String value) {
			addCriterion("extend_code not like", value, "extendCode");
			return (Criteria) this;
		}

		public Criteria andExtendCodeIn(List<String> values) {
			addCriterion("extend_code in", values, "extendCode");
			return (Criteria) this;
		}

		public Criteria andExtendCodeNotIn(List<String> values) {
			addCriterion("extend_code not in", values, "extendCode");
			return (Criteria) this;
		}

		public Criteria andExtendCodeBetween(String value1, String value2) {
			addCriterion("extend_code between", value1, value2, "extendCode");
			return (Criteria) this;
		}

		public Criteria andExtendCodeNotBetween(String value1, String value2) {
			addCriterion("extend_code not between", value1, value2, "extendCode");
			return (Criteria) this;
		}

		public Criteria andExtendNameIsNull() {
			addCriterion("extend_name is null");
			return (Criteria) this;
		}

		public Criteria andExtendNameIsNotNull() {
			addCriterion("extend_name is not null");
			return (Criteria) this;
		}

		public Criteria andExtendNameEqualTo(String value) {
			addCriterion("extend_name =", value, "extendName");
			return (Criteria) this;
		}

		public Criteria andExtendNameNotEqualTo(String value) {
			addCriterion("extend_name <>", value, "extendName");
			return (Criteria) this;
		}

		public Criteria andExtendNameGreaterThan(String value) {
			addCriterion("extend_name >", value, "extendName");
			return (Criteria) this;
		}

		public Criteria andExtendNameGreaterThanOrEqualTo(String value) {
			addCriterion("extend_name >=", value, "extendName");
			return (Criteria) this;
		}

		public Criteria andExtendNameLessThan(String value) {
			addCriterion("extend_name <", value, "extendName");
			return (Criteria) this;
		}

		public Criteria andExtendNameLessThanOrEqualTo(String value) {
			addCriterion("extend_name <=", value, "extendName");
			return (Criteria) this;
		}

		public Criteria andExtendNameLike(String value) {
			addCriterion("extend_name like", value, "extendName");
			return (Criteria) this;
		}

		public Criteria andExtendNameNotLike(String value) {
			addCriterion("extend_name not like", value, "extendName");
			return (Criteria) this;
		}

		public Criteria andExtendNameIn(List<String> values) {
			addCriterion("extend_name in", values, "extendName");
			return (Criteria) this;
		}

		public Criteria andExtendNameNotIn(List<String> values) {
			addCriterion("extend_name not in", values, "extendName");
			return (Criteria) this;
		}

		public Criteria andExtendNameBetween(String value1, String value2) {
			addCriterion("extend_name between", value1, value2, "extendName");
			return (Criteria) this;
		}

		public Criteria andExtendNameNotBetween(String value1, String value2) {
			addCriterion("extend_name not between", value1, value2, "extendName");
			return (Criteria) this;
		}

		public Criteria andExtendNoteIsNull() {
			addCriterion("extend_note is null");
			return (Criteria) this;
		}

		public Criteria andExtendNoteIsNotNull() {
			addCriterion("extend_note is not null");
			return (Criteria) this;
		}

		public Criteria andExtendNoteEqualTo(String value) {
			addCriterion("extend_note =", value, "extendNote");
			return (Criteria) this;
		}

		public Criteria andExtendNoteNotEqualTo(String value) {
			addCriterion("extend_note <>", value, "extendNote");
			return (Criteria) this;
		}

		public Criteria andExtendNoteGreaterThan(String value) {
			addCriterion("extend_note >", value, "extendNote");
			return (Criteria) this;
		}

		public Criteria andExtendNoteGreaterThanOrEqualTo(String value) {
			addCriterion("extend_note >=", value, "extendNote");
			return (Criteria) this;
		}

		public Criteria andExtendNoteLessThan(String value) {
			addCriterion("extend_note <", value, "extendNote");
			return (Criteria) this;
		}

		public Criteria andExtendNoteLessThanOrEqualTo(String value) {
			addCriterion("extend_note <=", value, "extendNote");
			return (Criteria) this;
		}

		public Criteria andExtendNoteLike(String value) {
			addCriterion("extend_note like", value, "extendNote");
			return (Criteria) this;
		}

		public Criteria andExtendNoteNotLike(String value) {
			addCriterion("extend_note not like", value, "extendNote");
			return (Criteria) this;
		}

		public Criteria andExtendNoteIn(List<String> values) {
			addCriterion("extend_note in", values, "extendNote");
			return (Criteria) this;
		}

		public Criteria andExtendNoteNotIn(List<String> values) {
			addCriterion("extend_note not in", values, "extendNote");
			return (Criteria) this;
		}

		public Criteria andExtendNoteBetween(String value1, String value2) {
			addCriterion("extend_note between", value1, value2, "extendNote");
			return (Criteria) this;
		}

		public Criteria andExtendNoteNotBetween(String value1, String value2) {
			addCriterion("extend_note not between", value1, value2, "extendNote");
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
	 * 只读. t_coupon_quota_detail
	 * @mbg.generated  2018-12-12 17:54:49
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
     * This class corresponds to the database table t_coupon_quota_detail
     *
     * @mbg.generated do_not_delete_during_merge 2018-11-23 14:39:38
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }
}