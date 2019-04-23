package com.bizvane.couponfacade.models.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.bizvane.couponfacade.models.po.CouponDefinitionPO;

/**
 * 券详情
 * Created by yunjie.tian on 2018/7/20.
 */
public class CouponEntityAndDefinitionVO extends CouponDefinitionPO implements Serializable{

    

    /**
     * 只读.
     pkid. coupon_entity_id
     *
     * @mbg.generated 2018-08-14 10:18:30
     */
    @io.swagger.annotations.ApiModelProperty(value = "pkid",name = "couponEntityId", required = false,example = "")
    private Long couponEntityId;

    /**
     * 只读.
     所属企业id. sys_company_id
     *
     * @mbg.generated 2018-08-14 10:18:30
     */
    @io.swagger.annotations.ApiModelProperty(value = "所属企业id",name = "sysCompanyId", required = false,example = "")
    private Long sysCompanyId;

    /**
     * 只读.
     所属品牌id. sys_brand_id
     *
     * @mbg.generated 2018-08-14 10:18:30
     */
    @io.swagger.annotations.ApiModelProperty(value = "所属品牌id",name = "sysBrandId", required = false,example = "")
    private Long sysBrandId;

    /**
     * 只读.
     所属品牌编号. brand_code
     *
     * @mbg.generated 2018-08-14 10:18:30
     */
    @io.swagger.annotations.ApiModelProperty(value = "所属品牌编号",name = "brandCode", required = false,example = "")
    private String brandCode;

    /**
     * 只读.
     券号. coupon_code
     *
     * @mbg.generated 2018-08-14 10:18:30
     */
    @io.swagger.annotations.ApiModelProperty(value = "券号",name = "couponCode", required = false,example = "")
    private String couponCode;

    /**
     * 只读.
     券发送记录id. coupon_batch_send_record_id
     *
     * @mbg.generated 2018-08-14 10:18:30
     */
    @io.swagger.annotations.ApiModelProperty(value = "券发送记录id",name = "couponBatchSendRecordId", required = false,example = "")
    private Long couponBatchSendRecordId;

    /**
     * 只读.
     会员code. member_code
     *
     * @mbg.generated 2018-08-14 10:18:30
     */
    @io.swagger.annotations.ApiModelProperty(value = "会员code",name = "memberCode", required = false,example = "")
    private String memberCode;

    /**
     * 只读.
     券名称. coupon_name
     *
     * @mbg.generated 2018-08-14 10:18:30
     */
    @io.swagger.annotations.ApiModelProperty(value = "券名称",name = "couponName", required = false,example = "")
    private String couponName;

    /**
     * 只读.
     面额. money
     *
     * @mbg.generated 2018-08-14 10:18:30
     */
    @io.swagger.annotations.ApiModelProperty(value = "面额",name = "money", required = false,example = "")
    private BigDecimal money;

    /**
     * 只读.
     折扣. discount
     *
     * @mbg.generated 2018-08-14 10:18:30
     */
    @io.swagger.annotations.ApiModelProperty(value = "折扣",name = "discount", required = false,example = "")
    private BigDecimal discount;

    /**
     * 只读.
     券模板图片. img
     *
     * @mbg.generated 2018-08-14 10:18:30
     */
    @io.swagger.annotations.ApiModelProperty(value = "券模板图片",name = "img", required = false,example = "")
    private String img;

    /**
     * 只读.
     券说明. info
     *
     * @mbg.generated 2018-08-14 10:18:30
     */
    @io.swagger.annotations.ApiModelProperty(value = "券说明",name = "info", required = false,example = "")
    private String info;

    /**
     * 只读.
     绑定状态（0未绑定，1已绑定）. bind_status
     *
     * @mbg.generated 2018-08-14 10:18:30
     */
    @io.swagger.annotations.ApiModelProperty(value = "绑定状态（0未绑定，1已绑定）",name = "bindStatus", required = false,example = "")
    private Boolean bindStatus;

    /**
     * 只读.
     有效期开始时间. valid_date_start
     *
     * @mbg.generated 2018-08-14 10:18:30
     */
    @io.swagger.annotations.ApiModelProperty(value = "有效期开始时间",name = "validDateStart", required = false,example = "")
    private Date validDateStart;

    /**
     * 只读.
     有效期结束时间. valid_date_end
     *
     * @mbg.generated 2018-08-14 10:18:30
     */
    @io.swagger.annotations.ApiModelProperty(value = "有效期结束时间",name = "validDateEnd", required = false,example = "")
    private Date validDateEnd;

    /**
     * 只读.
     是否锁定(0-未锁定 1-锁定). is_lock
     *
     * @mbg.generated 2018-08-14 10:18:30
     */
    @io.swagger.annotations.ApiModelProperty(value = "是否锁定(0-未锁定 1-锁定)",name = "isLock", required = false,example = "")
    private Boolean isLock;

    /**
     * 只读.
     核销密码. use_password
     *
     * @mbg.generated 2018-08-14 10:18:30
     */
    @io.swagger.annotations.ApiModelProperty(value = "核销密码",name = "usePassword", required = false,example = "")
    private String usePassword;

    /**
     * 只读.
     发放类型（10-开卡发券，15-生日发券，20-受赠，25-积分兑换，30-线上开卡，35-会员升级，40-会员生日，45-会员消费，50-会员签到，55-领券，60-完善资料，65-微信分享，70-消费次数，75-消费金额，80-邀请开卡,85-批量发券）. send_type
     *
     * @mbg.generated 2018-08-14 10:18:30
     */
    @io.swagger.annotations.ApiModelProperty(value = "发放类型（10-开卡发券，15-生日发券，20-受赠，25-积分兑换，30-线上开卡，35-会员升级，40-会员生日，45-会员消费，50-会员签到，55-领券，60-完善资料，65-微信分享，70-消费次数，75-消费金额，80-邀请开卡,85-批量发券）",name = "sendType", required = false,example = "")
    private String sendType;

    /**
     * 只读.
     发券业务单号(手工发券id). send_business_id
     *
     * @mbg.generated 2018-08-14 10:18:30
     */
    @io.swagger.annotations.ApiModelProperty(value = "发券业务单号(手工发券id)",name = "sendBusinessId", required = false,example = "")
    private Long sendBusinessId;

    /**
     * 只读.
     使用类型：1-线上，2-线下. use_type
     *
     * @mbg.generated 2018-08-14 10:18:30
     */
    @io.swagger.annotations.ApiModelProperty(value = "使用类型：1-线上，2-线下",name = "useType", required = false,example = "")
    private Byte useType;

    /**
     * 只读.
     核销门店. use_store_id
     *
     * @mbg.generated 2018-08-14 10:18:30
     */
    @io.swagger.annotations.ApiModelProperty(value = "核销门店",name = "useStoreId", required = false,example = "")
    private Long useStoreId;

    /**
     * 只读.
     券使用业务单号. use_business_code
     *
     * @mbg.generated 2018-08-14 10:18:30
     */
    @io.swagger.annotations.ApiModelProperty(value = "券使用业务单号",name = "useBusinessCode", required = false,example = "")
    private String useBusinessCode;

    /**
     * 只读.
     券使用订单金额(券收益)示例88.88. use_business_amount
     *
     * @mbg.generated 2018-08-14 10:18:30
     */
    @io.swagger.annotations.ApiModelProperty(value = "券使用订单金额(券收益)",name = "useBusinessAmount", required = false,example = "88.88")
    private BigDecimal useBusinessAmount;

    /**
     * 只读.
     使用时间. use_time
     *
     * @mbg.generated 2018-08-14 10:18:30
     */
    @io.swagger.annotations.ApiModelProperty(value = "使用时间",name = "useTime", required = false,example = "")
    private Date useTime;

    /**
     * 只读.
     是否使用(1-已使用，0-未使用). is_use
     *
     * @mbg.generated 2018-08-14 10:18:30
     */
    @io.swagger.annotations.ApiModelProperty(value = "是否使用(1-已使用，0-未使用)",name = "isUse", required = false,example = "")
    private Boolean isUse;

    /**
     * 只读.
     1-新建，5-线上绑定，10-同步中，20-可使用，25-已过期，30-已核销. coupon_status
     *
     * @mbg.generated 2018-08-14 10:18:30
     */
    @io.swagger.annotations.ApiModelProperty(value = "1-新建，5-线上绑定，10-同步中，20-可使用，25-已过期，30-已核销",name = "couponStatus", required = false,example = "")
    private Byte couponStatus;

    /**
     * 只读.
     备注. remark
     *
     * @mbg.generated 2018-08-14 10:18:30
     */
    @io.swagger.annotations.ApiModelProperty(value = "备注",name = "remark", required = false,example = "")
    private String remark;
    
    @io.swagger.annotations.ApiModelProperty(value = "转增说明",name = "transferInfo", required = false,example = "")
    private String transferInfo;
    
	@io.swagger.annotations.ApiModelProperty(value = "转增有奖1核销送券，0不送券", name = "transferSend", required = false, example = "")
	private Boolean transferSend;
    
	@io.swagger.annotations.ApiModelProperty(value = "核销渠道", name = "", required = false, example = "")
	private String useFrom;

	
	
    public String getUseFrom() {
		return useFrom;
	}

	public void setUseFrom(String useFrom) {
		this.useFrom = useFrom;
	}

	public Boolean getTransferSend() {
		return transferSend;
	}

	public void setTransferSend(Boolean transferSend) {
		this.transferSend = transferSend;
	}

	public String getTransferInfo() {
		return transferInfo;
	}

	public void setTransferInfo(String transferInfo) {
		this.transferInfo = transferInfo;
	}

	/**
     * 只读.
     优惠类型（1现金，2折扣，3礼品）. preferential_type
     *
     * @mbg.generated 2018-08-14 10:18:30
     */
    @io.swagger.annotations.ApiModelProperty(value = "优惠类型（1现金，2折扣，3礼品）",name = "preferentialType", required = false,example = "")
    private Byte preferentialType;

    @io.swagger.annotations.ApiModelProperty(value = "券领取时间",name = "getDate", required = false,example = "")
    private Date getDate;

    public Date getGetDate() {
        return getDate;
    }

    public void setGetDate(Date getDate) {
        this.getDate = getDate;
    }

    public Long getCouponEntityId() {
        return couponEntityId;
    }

    public void setCouponEntityId(Long couponEntityId) {
        this.couponEntityId = couponEntityId;
    }

    public Long getSysCompanyId() {
        return sysCompanyId;
    }

    public void setSysCompanyId(Long sysCompanyId) {
        this.sysCompanyId = sysCompanyId;
    }

    public Long getSysBrandId() {
        return sysBrandId;
    }

    public void setSysBrandId(Long sysBrandId) {
        this.sysBrandId = sysBrandId;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public Long getCouponBatchSendRecordId() {
        return couponBatchSendRecordId;
    }

    public void setCouponBatchSendRecordId(Long couponBatchSendRecordId) {
        this.couponBatchSendRecordId = couponBatchSendRecordId;
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Boolean getBindStatus() {
        return bindStatus;
    }

    public void setBindStatus(Boolean bindStatus) {
        this.bindStatus = bindStatus;
    }

    public Date getValidDateStart() {
        return validDateStart;
    }

    public void setValidDateStart(Date validDateStart) {
        this.validDateStart = validDateStart;
    }

    public Date getValidDateEnd() {
        return validDateEnd;
    }

    public void setValidDateEnd(Date validDateEnd) {
        this.validDateEnd = validDateEnd;
    }

    public Boolean getLock() {
        return isLock;
    }

    public void setLock(Boolean lock) {
        isLock = lock;
    }

    public String getUsePassword() {
        return usePassword;
    }

    public void setUsePassword(String usePassword) {
        this.usePassword = usePassword;
    }

    public String getSendType() {
        return sendType;
    }

    public void setSendType(String sendType) {
        this.sendType = sendType;
    }

    public Long getSendBusinessId() {
        return sendBusinessId;
    }

    public void setSendBusinessId(Long sendBusinessId) {
        this.sendBusinessId = sendBusinessId;
    }

    public Byte getUseType() {
        return useType;
    }

    public void setUseType(Byte useType) {
        this.useType = useType;
    }

    public Long getUseStoreId() {
        return useStoreId;
    }

    public void setUseStoreId(Long useStoreId) {
        this.useStoreId = useStoreId;
    }

    public String getUseBusinessCode() {
        return useBusinessCode;
    }

    public void setUseBusinessCode(String useBusinessCode) {
        this.useBusinessCode = useBusinessCode;
    }



    public BigDecimal getUseBusinessAmount() {
		return useBusinessAmount;
	}

	public void setUseBusinessAmount(BigDecimal useBusinessAmount) {
		this.useBusinessAmount = useBusinessAmount;
	}

	public Date getUseTime() {
        return useTime;
    }

    public void setUseTime(Date useTime) {
        this.useTime = useTime;
    }

    public Boolean getUse() {
        return isUse;
    }

    public void setUse(Boolean use) {
        isUse = use;
    }

    public Byte getCouponStatus() {
        return couponStatus;
    }

    public void setCouponStatus(Byte couponStatus) {
        this.couponStatus = couponStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Byte getPreferentialType() {
        return preferentialType;
    }

    public void setPreferentialType(Byte preferentialType) {
        this.preferentialType = preferentialType;
    }
}
