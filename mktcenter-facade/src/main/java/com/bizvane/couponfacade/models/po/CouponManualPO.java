package com.bizvane.couponfacade.models.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CouponManualPO implements Serializable {
	

    /**
     * 只读.
    待发送会员. member_code_list
     *
     * @mbg.generated 2019-01-24 17:16:34
     */
    @io.swagger.annotations.ApiModelProperty(value = "待发送会员",name = "memberCodeList", required = false,example = "")
    private String memberCodeList;

    /**
     * 只读.
    会员查询条件. member_condition
     *
     * @mbg.generated 2019-01-24 17:16:34
     */
    @io.swagger.annotations.ApiModelProperty(value = "会员查询条件",name = "memberCondition", required = false,example = "")
    private String memberCondition;

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-24 17:16:34
     */

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-24 17:16:34
     */
    public String getMemberCodeList() {
        return memberCodeList;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-24 17:16:34
     */
    public void setMemberCodeList(String memberCodeList) {
        this.memberCodeList = memberCodeList == null ? null : memberCodeList.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-24 17:16:34
     */
    public String getMemberCondition() {
        return memberCondition;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-24 17:16:34
     */
    public void setMemberCondition(String memberCondition) {
        this.memberCondition = memberCondition == null ? null : memberCondition.trim();
    }


	/**
	 * 只读. 主键id. coupon_manual_id
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "主键id", name = "couponManualId", required = false, example = "")
	private Long couponManualId;
	/**
	 * 只读. 所属企业id. sys_company_id
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "所属企业id", name = "sysCompanyId", required = false, example = "")
	private Long sysCompanyId;
	/**
	 * 只读. 所属品牌id. sys_brand_id
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "所属品牌id", name = "sysBrandId", required = false, example = "")
	private Long sysBrandId;
	/**
	 * 只读. 所属企业编号. brand_code
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "所属企业编号", name = "brandCode", required = false, example = "")
	private String brandCode;
	/**
	 * 只读. 任务名称. task_name
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "任务名称", name = "taskName", required = false, example = "")
	private String taskName;
	/**
	 * 只读. 券定义id. coupon_definition_id
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "券定义id", name = "couponDefinitionId", required = false, example = "")
	private String couponDefinitionId;
	/**
	 * 只读. 券定义名称. coupon_definition_name
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "券定义名称", name = "couponDefinitionName", required = false, example = "")
	private String couponDefinitionName;
	/**
	 * 只读. 发送人数. member_num
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "发送人数", name = "memberNum", required = false, example = "")
	private Integer memberNum;
	/**
	 * 只读. 发送张数. member_count
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "发送张数", name = "memberCount", required = false, example = "")
	private Integer memberCount;
	/**
	 * 只读. 发券成功数量. success_count
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "发券成功数量", name = "successCount", required = false, example = "")
	private Integer successCount;
	/**
	 * 只读. 失败数量. fail_count
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "失败数量", name = "failCount", required = false, example = "")
	private Integer failCount;
	/**
	 * 只读. 核销数量. cancel_count
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "核销数量", name = "cancelCount", required = false, example = "")
	private Integer cancelCount;
	/**
	 * 只读. 发送类型：1-立即发送，2-指定时间. send_type
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "发送类型：1-立即发送，2-指定时间", name = "sendType", required = false, example = "")
	private Byte sendType;
	/**
	 * 只读. 发券时间. send_time
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "发券时间", name = "sendTime", required = false, example = "")
	private Date sendTime;
	/**
	 * 只读. 任务状态：5-新建，10-待审核，15-待执行，20-审核不通过，25-发送中，30-发送完成，35-部分失败，40-已作废，45-同步中. task_status
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "任务状态：5-新建，10-待审核，15-待执行，20-审核不通过，25-发送中，30-发送完成，35-部分失败，40-已作废，45-同步中", name = "taskStatus", required = false, example = "")
	private Byte taskStatus;
	/**
	 * 只读. 同步失败数量. sync_fail_count
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "同步失败数量", name = "syncFailCount", required = false, example = "")
	private Integer syncFailCount;
	/**
	 * 只读. 核销金额. profit_money
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "核销金额", name = "profitMoney", required = false, example = "")
	private BigDecimal profitMoney;
	/**
	 * 只读. 券优惠金额. discount_money
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "券优惠金额", name = "discountMoney", required = false, example = "")
	private BigDecimal discountMoney;
	/**
	 * 只读. 审核人id. review_user_id
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "审核人id", name = "reviewUserId", required = false, example = "")
	private Long reviewUserId;
	/**
	 * 只读. 审核人名字. review_user_name
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "审核人名字", name = "reviewUserName", required = false, example = "")
	private String reviewUserName;
	/**
	 * 只读. 备注. remark
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "备注", name = "remark", required = false, example = "")
	private String remark;
	/**
	 * 只读. 创建人id. create_user_id
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建人id", name = "createUserId", required = false, example = "")
	private Long createUserId;
	/**
	 * 只读. 创建人. create_user_name
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建人", name = "createUserName", required = false, example = "")
	private String createUserName;
	/**
	 * 只读. 创建时间. create_date
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建时间", name = "createDate", required = false, example = "")
	private Date createDate;
	/**
	 * 只读. 修改人id. modified_user_id
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改人id", name = "modifiedUserId", required = false, example = "")
	private Long modifiedUserId;
	/**
	 * 只读. 修改人. modified_user_name
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改人", name = "modifiedUserName", required = false, example = "")
	private String modifiedUserName;
	/**
	 * 只读. 修改时间. modified_date
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改时间", name = "modifiedDate", required = false, example = "")
	private Date modifiedDate;
	/**
	 * 只读. 数据有效性（1有效，0无效）. valid
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "数据有效性（1有效，0无效）", name = "valid", required = false, example = "")
	private Boolean valid;
	/**
	 * 只读. 店铺id数据. storeIds
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	@io.swagger.annotations.ApiModelProperty(value = "店铺id数据", name = "storeids", required = false, example = "")
	private String storeids;
	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public Long getCouponManualId() {
		return couponManualId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public void setCouponManualId(Long couponManualId) {
		this.couponManualId = couponManualId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public Long getSysCompanyId() {
		return sysCompanyId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public void setSysCompanyId(Long sysCompanyId) {
		this.sysCompanyId = sysCompanyId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public Long getSysBrandId() {
		return sysBrandId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public void setSysBrandId(Long sysBrandId) {
		this.sysBrandId = sysBrandId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public String getBrandCode() {
		return brandCode;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode == null ? null : brandCode.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public String getTaskName() {
		return taskName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName == null ? null : taskName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public String getCouponDefinitionId() {
		return couponDefinitionId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public void setCouponDefinitionId(String couponDefinitionId) {
		this.couponDefinitionId = couponDefinitionId == null ? null : couponDefinitionId.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public String getCouponDefinitionName() {
		return couponDefinitionName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public void setCouponDefinitionName(String couponDefinitionName) {
		this.couponDefinitionName = couponDefinitionName == null ? null : couponDefinitionName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public Integer getMemberNum() {
		return memberNum;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public void setMemberNum(Integer memberNum) {
		this.memberNum = memberNum;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public Integer getMemberCount() {
		return memberCount;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public void setMemberCount(Integer memberCount) {
		this.memberCount = memberCount;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public Integer getSuccessCount() {
		return successCount;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public void setSuccessCount(Integer successCount) {
		this.successCount = successCount;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public Integer getFailCount() {
		return failCount;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public void setFailCount(Integer failCount) {
		this.failCount = failCount;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public Integer getCancelCount() {
		return cancelCount;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public void setCancelCount(Integer cancelCount) {
		this.cancelCount = cancelCount;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public Byte getSendType() {
		return sendType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public void setSendType(Byte sendType) {
		this.sendType = sendType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public Date getSendTime() {
		return sendTime;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public Byte getTaskStatus() {
		return taskStatus;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public void setTaskStatus(Byte taskStatus) {
		this.taskStatus = taskStatus;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public Integer getSyncFailCount() {
		return syncFailCount;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public void setSyncFailCount(Integer syncFailCount) {
		this.syncFailCount = syncFailCount;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public BigDecimal getProfitMoney() {
		return profitMoney;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public void setProfitMoney(BigDecimal profitMoney) {
		this.profitMoney = profitMoney;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public BigDecimal getDiscountMoney() {
		return discountMoney;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public void setDiscountMoney(BigDecimal discountMoney) {
		this.discountMoney = discountMoney;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public Long getReviewUserId() {
		return reviewUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public void setReviewUserId(Long reviewUserId) {
		this.reviewUserId = reviewUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public String getReviewUserName() {
		return reviewUserName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public void setReviewUserName(String reviewUserName) {
		this.reviewUserName = reviewUserName == null ? null : reviewUserName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public Long getCreateUserId() {
		return createUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public String getCreateUserName() {
		return createUserName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName == null ? null : createUserName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public Long getModifiedUserId() {
		return modifiedUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public void setModifiedUserId(Long modifiedUserId) {
		this.modifiedUserId = modifiedUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public String getModifiedUserName() {
		return modifiedUserName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public void setModifiedUserName(String modifiedUserName) {
		this.modifiedUserName = modifiedUserName == null ? null : modifiedUserName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public Date getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public Boolean getValid() {
		return valid;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public void setValid(Boolean valid) {
		this.valid = valid;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public String getStoreids() {
		return storeids;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-24 17:16:34
	 */
	public void setStoreids(String storeids) {
		this.storeids = storeids == null ? null : storeids.trim();
	}
}