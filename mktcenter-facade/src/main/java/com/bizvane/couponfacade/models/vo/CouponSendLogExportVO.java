package com.bizvane.couponfacade.models.vo;

import java.util.Date;

/**
 * Created by yunjie.tian on 2018/8/13.
 */
public class CouponSendLogExportVO {

    @io.swagger.annotations.ApiModelProperty(value = "创建时间", name = "createDate", required = false, example = "")
    private Date createDate;

    @io.swagger.annotations.ApiModelProperty(value = "券号", name = "couponCode", required = false, example = "")
    private String couponCode;

    @io.swagger.annotations.ApiModelProperty(value = "券定义id", name = "couponDefinitionId", required = false, example = "")
    private String couponDefinitionId;

    @io.swagger.annotations.ApiModelProperty(value = "券名称", name = "couponName", required = false, example = "")
    private String couponName;

    @io.swagger.annotations.ApiModelProperty(value = "优惠形式", name = "preferentialType", required = false, example = "")
    private Byte preferentialType;

    @io.swagger.annotations.ApiModelProperty(value = "有效期", name = "validDate", required = false, example = "")
    private String validDate;

    @io.swagger.annotations.ApiModelProperty(value = "是否使用", name = "isUse", required = false, example = "")
    private Boolean use;

    @io.swagger.annotations.ApiModelProperty(value = "会员号", name = "memberCode", required = false, example = "")
    private String memberCode;

    @io.swagger.annotations.ApiModelProperty(value = "会员卡号", name = "cardNo", required = false, example = "")
    private String cardNo;



    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public String getCouponDefinitionId() {
        return couponDefinitionId;
    }

    public void setCouponDefinitionId(String couponDefinitionId) {
        this.couponDefinitionId = couponDefinitionId;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public Byte getPreferentialType() {
        return preferentialType;
    }

    public void setPreferentialType(Byte preferentialType) {
        this.preferentialType = preferentialType;
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public Boolean getUse() {
        return use;
    }

    public void setUse(Boolean use) {
        this.use = use;
    }

    public String getValidDate() {
        return validDate;
    }

    public void setValidDate(String validDate) {
        this.validDate = validDate;
    }
}
