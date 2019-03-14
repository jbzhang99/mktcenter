package com.bizvane.couponfacade.models.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CouponSendFailLogPO implements Serializable {
    /**
     * 只读.
    pkid. coupon_send_fail_log_id
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    @io.swagger.annotations.ApiModelProperty(value = "pkid",name = "couponSendFailLogId", required = false,example = "")
    private Long couponSendFailLogId;

    /**
     * 只读.
    所属品牌id. sys_brand_id
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    @io.swagger.annotations.ApiModelProperty(value = "所属品牌id",name = "sysBrandId", required = false,example = "")
    private Long sysBrandId;

    /**
     * 只读.
    所属企业id. sys_company_id
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    @io.swagger.annotations.ApiModelProperty(value = "所属企业id",name = "sysCompanyId", required = false,example = "")
    private Long sysCompanyId;

    /**
     * 只读.
    所属品牌编号. brand_code
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    @io.swagger.annotations.ApiModelProperty(value = "所属品牌编号",name = "brandCode", required = false,example = "")
    private String brandCode;

    /**
     * 只读.
    券定义id. coupon_definition_id
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    @io.swagger.annotations.ApiModelProperty(value = "券定义id",name = "couponDefinitionId", required = false,example = "")
    private Long couponDefinitionId;

    /**
     * 只读.
    发券批次号（系统）. batch_send_code
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    @io.swagger.annotations.ApiModelProperty(value = "发券批次号（系统）",name = "batchSendCode", required = false,example = "")
    private String batchSendCode;

    /**
     * 只读.
    券实例id. coupon_entity_id
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    @io.swagger.annotations.ApiModelProperty(value = "券实例id",name = "couponEntityId", required = false,example = "")
    private Long couponEntityId;

    /**
     * 只读.
    券号. coupon_code
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    @io.swagger.annotations.ApiModelProperty(value = "券号",name = "couponCode", required = false,example = "")
    private String couponCode;

    /**
     * 只读.
    会员编号. member_code
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    @io.swagger.annotations.ApiModelProperty(value = "会员编号",name = "memberCode", required = false,example = "")
    private String memberCode;

    /**
     * 只读.
    券名称. coupon_name
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    @io.swagger.annotations.ApiModelProperty(value = "券名称",name = "couponName", required = false,example = "")
    private String couponName;

    /**
     * 只读.
    券面额. money
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    @io.swagger.annotations.ApiModelProperty(value = "券面额",name = "money", required = false,example = "")
    private BigDecimal money;

    /**
     * 只读.
    券折扣. discount
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    @io.swagger.annotations.ApiModelProperty(value = "券折扣",name = "discount", required = false,example = "")
    private BigDecimal discount;

    /**
     * 只读.
    券模板图片. img
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    @io.swagger.annotations.ApiModelProperty(value = "券模板图片",name = "img", required = false,example = "")
    private String img;

    /**
     * 只读.
    券类型. coupon_type
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    @io.swagger.annotations.ApiModelProperty(value = "券类型",name = "couponType", required = false,example = "")
    private String couponType;

    /**
     * 只读.
    业务类型. biz_type
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    @io.swagger.annotations.ApiModelProperty(value = "业务类型",name = "bizType", required = false,example = "")
    private String bizType;

    /**
     * 只读.
    业务单号. biz_code
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    @io.swagger.annotations.ApiModelProperty(value = "业务单号",name = "bizCode", required = false,example = "")
    private String bizCode;

    /**
     * 只读.
    券说明. info
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    @io.swagger.annotations.ApiModelProperty(value = "券说明",name = "info", required = false,example = "")
    private String info;

    /**
     * 只读.
    失败原因. fail_reason
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    @io.swagger.annotations.ApiModelProperty(value = "失败原因",name = "failReason", required = false,example = "")
    private String failReason;

    /**
     * 只读.
    失败次数. fail_times
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    @io.swagger.annotations.ApiModelProperty(value = "失败次数",name = "failTimes", required = false,example = "")
    private Integer failTimes;

    /**
     * 只读.
    备注. remark
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    @io.swagger.annotations.ApiModelProperty(value = "备注",name = "remark", required = false,example = "")
    private String remark;

    /**
     * 只读.
    创建人id. create_user_id
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    @io.swagger.annotations.ApiModelProperty(value = "创建人id",name = "createUserId", required = false,example = "")
    private Long createUserId;

    /**
     * 只读.
    创建人. create_user_name
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    @io.swagger.annotations.ApiModelProperty(value = "创建人",name = "createUserName", required = false,example = "")
    private String createUserName;

    /**
     * 只读.
    创建时间. create_date
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    @io.swagger.annotations.ApiModelProperty(value = "创建时间",name = "createDate", required = false,example = "")
    private Date createDate;

    /**
     * 只读.
    修改人id. modified_user_id
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    @io.swagger.annotations.ApiModelProperty(value = "修改人id",name = "modifiedUserId", required = false,example = "")
    private Long modifiedUserId;

    /**
     * 只读.
    修改人. modified_user_name
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    @io.swagger.annotations.ApiModelProperty(value = "修改人",name = "modifiedUserName", required = false,example = "")
    private String modifiedUserName;

    /**
     * 只读.
    修改时间. modified_date
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    @io.swagger.annotations.ApiModelProperty(value = "修改时间",name = "modifiedDate", required = false,example = "")
    private Date modifiedDate;

    /**
     * 只读.
    数据有效性（1有效，0无效）. valid
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    @io.swagger.annotations.ApiModelProperty(value = "数据有效性（1有效，0无效）",name = "valid", required = false,example = "")
    private Boolean valid;

    /**
     * 只读.
    补发状态（1待补发，2已补发,3补发中）. send_status
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    @io.swagger.annotations.ApiModelProperty(value = "补发状态（1待补发，2已补发,3补发中）",name = "sendStatus", required = false,example = "")
    private Byte sendStatus;

    /**
     * 只读.
    补发时间. send_date
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    @io.swagger.annotations.ApiModelProperty(value = "补发时间",name = "sendDate", required = false,example = "")
    private Date sendDate;
    
    
    @io.swagger.annotations.ApiModelProperty(value = "任务名称",name = "businessName", required = false,example = "")
    private String businessName;
    
    

    public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	/**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    private static final long serialVersionUID = 1L;

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    public Long getCouponSendFailLogId() {
        return couponSendFailLogId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    public void setCouponSendFailLogId(Long couponSendFailLogId) {
        this.couponSendFailLogId = couponSendFailLogId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    public Long getSysBrandId() {
        return sysBrandId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    public void setSysBrandId(Long sysBrandId) {
        this.sysBrandId = sysBrandId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    public Long getSysCompanyId() {
        return sysCompanyId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    public void setSysCompanyId(Long sysCompanyId) {
        this.sysCompanyId = sysCompanyId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    public String getBrandCode() {
        return brandCode;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode == null ? null : brandCode.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    public Long getCouponDefinitionId() {
        return couponDefinitionId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    public void setCouponDefinitionId(Long couponDefinitionId) {
        this.couponDefinitionId = couponDefinitionId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    public String getBatchSendCode() {
        return batchSendCode;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    public void setBatchSendCode(String batchSendCode) {
        this.batchSendCode = batchSendCode == null ? null : batchSendCode.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    public Long getCouponEntityId() {
        return couponEntityId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    public void setCouponEntityId(Long couponEntityId) {
        this.couponEntityId = couponEntityId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    public String getCouponCode() {
        return couponCode;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode == null ? null : couponCode.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    public String getMemberCode() {
        return memberCode;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode == null ? null : memberCode.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    public String getCouponName() {
        return couponName;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    public void setCouponName(String couponName) {
        this.couponName = couponName == null ? null : couponName.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    public BigDecimal getMoney() {
        return money;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    public BigDecimal getDiscount() {
        return discount;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    public String getImg() {
        return img;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    public String getCouponType() {
        return couponType;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    public void setCouponType(String couponType) {
        this.couponType = couponType == null ? null : couponType.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    public String getBizType() {
        return bizType;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    public void setBizType(String bizType) {
        this.bizType = bizType == null ? null : bizType.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    public String getBizCode() {
        return bizCode;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    public void setBizCode(String bizCode) {
        this.bizCode = bizCode == null ? null : bizCode.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    public String getInfo() {
        return info;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    public String getFailReason() {
        return failReason;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    public void setFailReason(String failReason) {
        this.failReason = failReason == null ? null : failReason.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    public Integer getFailTimes() {
        return failTimes;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    public void setFailTimes(Integer failTimes) {
        this.failTimes = failTimes;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    public Long getCreateUserId() {
        return createUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    public String getCreateUserName() {
        return createUserName;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    public Long getModifiedUserId() {
        return modifiedUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    public void setModifiedUserId(Long modifiedUserId) {
        this.modifiedUserId = modifiedUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    public String getModifiedUserName() {
        return modifiedUserName;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    public void setModifiedUserName(String modifiedUserName) {
        this.modifiedUserName = modifiedUserName == null ? null : modifiedUserName.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    public Date getModifiedDate() {
        return modifiedDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    public Boolean getValid() {
        return valid;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    public Byte getSendStatus() {
        return sendStatus;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    public void setSendStatus(Byte sendStatus) {
        this.sendStatus = sendStatus;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    public Date getSendDate() {
        return sendDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }
}