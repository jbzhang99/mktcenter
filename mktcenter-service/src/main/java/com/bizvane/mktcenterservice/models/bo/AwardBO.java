package com.bizvane.mktcenterservice.models.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author chen.li
 * @date on 2018/8/3 15:10
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
public class AwardBO {

    @ApiModelProperty(
            value = "会员code",
            name = "memberCode",
            required = false,
            example = ""
    )
    private String memberCode;
    @ApiModelProperty(
            value = "券定义id",
            name = "couponDefinitionId",
            required = false,
            example = ""
    )
    private Long couponDefinitionId;
    @ApiModelProperty(
            value = "发送类型",
            name = "sendType",
            required = false,
            example = ""
    )
    private String sendType;
    @ApiModelProperty(
            value = "业务id",
            name = "sendBussienId",
            required = false,
            example = ""
    )
    private Long sendBussienId;

    @ApiModelProperty(
            value = "积分流水id",
            name = "integralRecordId"
    )
    private Integer integralRecordId;

    @ApiModelProperty(
            value = "变更单据",
            name = "changeBills"
    )
    private String changeBills;
    @ApiModelProperty(
            value = "变更积分",
            name = "changeIntegral"
    )
    private Integer changeIntegral;
    @ApiModelProperty(
            value = "变更时间",
            name = "changeDate"
    )
    private Date changeDate;
    @ApiModelProperty(
            value = "变更类型",
            name = "changeWay"
    )
    private String changeWay;
    @ApiModelProperty(
            value = "变更详情",
            name = "changeDetail"
    )
    private String changeDetails;
    @ApiModelProperty(
            value = "业务类型",
            name = "businessWay"
    )
    private String businessWay;
    @ApiModelProperty(
            value = "积分有效期",
            name = "effetiveTime"
    )
    private Date effectiveTime;
    @ApiModelProperty(
            value = "变更积分max",
            name = "changeIntegralMax"
    )
    private Integer changeIntegralMax;
    @ApiModelProperty(
            value = "变更积分min",
            name = "changeIntegralMin"
    )
    private Integer changeIntegralMin;
    @ApiModelProperty(
            value = "会员姓名",
            name = "memberName"
    )
    private String memberName;
    @ApiModelProperty(
            value = "会员卡号",
            name = "cardNo"
    )
    private String cardNo;
    @ApiModelProperty(
            value = "会员手机号",
            name = "phone"
    )
    private  String phone;
    @ApiModelProperty(
            value = "变更时间最大值",
            name = "changeDateMax"
    )
    @DateTimeFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    private Date changeDateMax;
    @ApiModelProperty(
            value = "变更时间最小值",
            name = "changeDateMin"
    )
    @DateTimeFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    private Date changeDateMin;
    @ApiModelProperty(
            value = "高级搜索",
            name = "searchValue"
    )
    private String searchValue;

    /**
     * 营销手段：1券，2积分，3短信，4模板消息
     */
    private Integer mktSmartType;

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    public Long getCouponDefinitionId() {
        return couponDefinitionId;
    }

    public void setCouponDefinitionId(Long couponDefinitionId) {
        this.couponDefinitionId = couponDefinitionId;
    }

    public String getSendType() {
        return sendType;
    }

    public void setSendType(String sendType) {
        this.sendType = sendType;
    }

    public Long getSendBussienId() {
        return sendBussienId;
    }

    public void setSendBussienId(Long sendBussienId) {
        this.sendBussienId = sendBussienId;
    }

    public Integer getIntegralRecordId() {
        return integralRecordId;
    }

    public void setIntegralRecordId(Integer integralRecordId) {
        this.integralRecordId = integralRecordId;
    }

    public String getChangeBills() {
        return changeBills;
    }

    public void setChangeBills(String changeBills) {
        this.changeBills = changeBills;
    }

    public Integer getChangeIntegral() {
        return changeIntegral;
    }

    public void setChangeIntegral(Integer changeIntegral) {
        this.changeIntegral = changeIntegral;
    }

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }

    public String getChangeWay() {
        return changeWay;
    }

    public void setChangeWay(String changeWay) {
        this.changeWay = changeWay;
    }

    public String getChangeDetails() {
        return changeDetails;
    }

    public void setChangeDetails(String changeDetails) {
        this.changeDetails = changeDetails;
    }

    public String getBusinessWay() {
        return businessWay;
    }

    public void setBusinessWay(String businessWay) {
        this.businessWay = businessWay;
    }

    public Date getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public Integer getChangeIntegralMax() {
        return changeIntegralMax;
    }

    public void setChangeIntegralMax(Integer changeIntegralMax) {
        this.changeIntegralMax = changeIntegralMax;
    }

    public Integer getChangeIntegralMin() {
        return changeIntegralMin;
    }

    public void setChangeIntegralMin(Integer changeIntegralMin) {
        this.changeIntegralMin = changeIntegralMin;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public Date getChangeDateMax() {
        return changeDateMax;
    }

    public void setChangeDateMax(Date changeDateMax) {
        this.changeDateMax = changeDateMax;
    }

    public Date getChangeDateMin() {
        return changeDateMin;
    }

    public void setChangeDateMin(Date changeDateMin) {
        this.changeDateMin = changeDateMin;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public Integer getMktSmartType() {
        return mktSmartType;
    }

    public void setMktSmartType(Integer mktSmartType) {
        this.mktSmartType = mktSmartType;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
