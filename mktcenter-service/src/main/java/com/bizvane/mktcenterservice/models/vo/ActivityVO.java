package com.bizvane.mktcenterservice.models.vo;

import com.bizvane.mktcenterservice.models.po.MktActivityPO;
import com.bizvane.mktcenterservice.models.po.MktActivityRegisterPO;

/**
 * @author chen.li
 * @date on 2018/7/6 20:07
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
public class ActivityVO extends MktActivityPO {

    /**
     * 只读. 活动描述、简介. activity_info
     * @mbg.generated  2018-07-13 10:42:22
     */
    @io.swagger.annotations.ApiModelProperty(value = "活动描述、简介", name = "activityInfo", required = false, example = "")
    private String activityInfo;

    /**
     * 只读. 线下开卡状态：0所有，1未开，2已开. offline_card_status
     * @mbg.generated  2018-07-13 10:42:22
     */
    @io.swagger.annotations.ApiModelProperty(value = "线下开卡状态：0所有，1未开，2已开", name = "offlineCardStatus", required = false, example = "")
    private Integer offlineCardStatus;

    /**
     * 只读. 开卡时等级编号. mbr_level_code
     * @mbg.generated  2018-07-13 10:42:22
     */
    @io.swagger.annotations.ApiModelProperty(value = "活动针对的会员等级编号", name = "mbrLevelCode", required = false, example = "")
    private String mbrLevelCode;
    /**
     * 只读. 开卡时等级名称. mbr_level_name
     * @mbg.generated  2018-07-13 10:42:22
     */
    @io.swagger.annotations.ApiModelProperty(value = "活动针对的会员等级名称", name = "mbrLevelName", required = false, example = "")
    private String mbrLevelName;

    /**
     * 只读. 针对的会员类型：0,所有类型，1微信会员. member_type
     * @mbg.generated  2018-07-13 11:45:27
     */
    @io.swagger.annotations.ApiModelProperty(value = "针对的会员类型：0,所有类型，1微信会员", name = "memberType", required = false, example = "")
    private Integer memberType;

    /**
     * 只读. 提前多少日进行. days_ahead
     * @mbg.generated  2018-07-13 10:42:22
     */
    @io.swagger.annotations.ApiModelProperty(value = "提前多少日进行", name = "daysAhead", required = false, example = "")
    private Integer daysAhead;

    /**
     * 只读. 订单最低金额. order_min_price
     * @mbg.generated  2018-07-13 10:42:22
     */
    @io.swagger.annotations.ApiModelProperty(value = "订单最低金额", name = "orderMinPrice", required = false, example = "")
    private String orderMinPrice;
    /**
     * 只读. 是否限制商品，0否，1是. is_commodity_limit
     * @mbg.generated  2018-07-13 10:42:22
     */
    @io.swagger.annotations.ApiModelProperty(value = "是否限制商品，0否，1是", name = "isCommodityLimit", required = false, example = "")
    private Boolean isCommodityLimit;
    /**
     * 只读. 是否限制门店，0否，1是. is_store_limit
     * @mbg.generated  2018-07-13 10:42:22
     */
    @io.swagger.annotations.ApiModelProperty(value = "是否限制门店，0否，1是", name = "isStoreLimit", required = false, example = "")
    private Boolean isStoreLimit;

    /**
     * 只读. 商品白名单. commodity_whitelist
     * @mbg.generated  2018-07-13 10:42:22
     */
    @io.swagger.annotations.ApiModelProperty(value = "商品白名单", name = "commodityWhitelist", required = false, example = "")
    private String commodityWhitelist;
    /**
     * 只读. 商品黑名单. commodity_blacklist
     * @mbg.generated  2018-07-13 10:42:22
     */
    @io.swagger.annotations.ApiModelProperty(value = "商品黑名单", name = "commodityBlacklist", required = false, example = "")
    private String commodityBlacklist;
    /**
     * 只读. 门店白名单. store_whitelist
     * @mbg.generated  2018-07-13 10:42:22
     */
    @io.swagger.annotations.ApiModelProperty(value = "门店白名单", name = "storeWhitelist", required = false, example = "")
    private String storeWhitelist;
    /**
     * 只读. 门店黑名单. store_blacklist
     * @mbg.generated  2018-07-13 10:42:22
     */
    @io.swagger.annotations.ApiModelProperty(value = "门店黑名单", name = "storeBlacklist", required = false, example = "")
    private String storeBlacklist;

    /**
     * 只读. 签到方式：1连续签到，2累计签到，3单日签到. sign_type
     * @mbg.generated  2018-07-13 10:42:22
     */
    @io.swagger.annotations.ApiModelProperty(value = "签到方式：1连续签到，2累计签到，3单日签到", name = "signType", required = false, example = "")
    private Integer signType;
    /**
     * 只读. 积分方式. integral_type
     * @mbg.generated  2018-07-13 10:42:22
     */
    @io.swagger.annotations.ApiModelProperty(value = "积分方式", name = "integralType", required = false, example = "")
    private String integralType;
    /**
     * 只读. 赠送积分基数. integral_basis
     * @mbg.generated  2018-07-13 10:42:22
     */
    @io.swagger.annotations.ApiModelProperty(value = "赠送积分基数", name = "integralBasis", required = false, example = "")
    private Long integralBasis;
    /**
     * 只读. 每次增加的数值. integral_addend
     * @mbg.generated  2018-07-13 10:42:22
     */
    @io.swagger.annotations.ApiModelProperty(value = "每次增加的数值", name = "integralAddend", required = false, example = "")
    private Long integralAddend;
    /**
     * 只读. 增加后的最高积分上限. integral_max
     * @mbg.generated  2018-07-13 10:42:22
     */
    @io.swagger.annotations.ApiModelProperty(value = "增加后的最高积分上限", name = "integralMax", required = false, example = "")
    private Long integralMax;

    public String getActivityInfo() {
        return activityInfo;
    }

    public void setActivityInfo(String activityInfo) {
        this.activityInfo = activityInfo;
    }

    public Integer getOfflineCardStatus() {
        return offlineCardStatus;
    }

    public void setOfflineCardStatus(Integer offlineCardStatus) {
        this.offlineCardStatus = offlineCardStatus;
    }

    public String getMbrLevelCode() {
        return mbrLevelCode;
    }

    public void setMbrLevelCode(String mbrLevelCode) {
        this.mbrLevelCode = mbrLevelCode;
    }

    public String getMbrLevelName() {
        return mbrLevelName;
    }

    public void setMbrLevelName(String mbrLevelName) {
        this.mbrLevelName = mbrLevelName;
    }

    public Integer getMemberType() {
        return memberType;
    }

    public void setMemberType(Integer memberType) {
        this.memberType = memberType;
    }

    public Integer getDaysAhead() {
        return daysAhead;
    }

    public void setDaysAhead(Integer daysAhead) {
        this.daysAhead = daysAhead;
    }

    public String getOrderMinPrice() {
        return orderMinPrice;
    }

    public void setOrderMinPrice(String orderMinPrice) {
        this.orderMinPrice = orderMinPrice;
    }

    public Boolean getCommodityLimit() {
        return isCommodityLimit;
    }

    public void setCommodityLimit(Boolean commodityLimit) {
        isCommodityLimit = commodityLimit;
    }

    public Boolean getStoreLimit() {
        return isStoreLimit;
    }

    public void setStoreLimit(Boolean storeLimit) {
        isStoreLimit = storeLimit;
    }

    public String getCommodityWhitelist() {
        return commodityWhitelist;
    }

    public void setCommodityWhitelist(String commodityWhitelist) {
        this.commodityWhitelist = commodityWhitelist;
    }

    public String getCommodityBlacklist() {
        return commodityBlacklist;
    }

    public void setCommodityBlacklist(String commodityBlacklist) {
        this.commodityBlacklist = commodityBlacklist;
    }

    public String getStoreWhitelist() {
        return storeWhitelist;
    }

    public void setStoreWhitelist(String storeWhitelist) {
        this.storeWhitelist = storeWhitelist;
    }

    public String getStoreBlacklist() {
        return storeBlacklist;
    }

    public void setStoreBlacklist(String storeBlacklist) {
        this.storeBlacklist = storeBlacklist;
    }

    public Integer getSignType() {
        return signType;
    }

    public void setSignType(Integer signType) {
        this.signType = signType;
    }

    public String getIntegralType() {
        return integralType;
    }

    public void setIntegralType(String integralType) {
        this.integralType = integralType;
    }

    public Long getIntegralBasis() {
        return integralBasis;
    }

    public void setIntegralBasis(Long integralBasis) {
        this.integralBasis = integralBasis;
    }

    public Long getIntegralAddend() {
        return integralAddend;
    }

    public void setIntegralAddend(Long integralAddend) {
        this.integralAddend = integralAddend;
    }

    public Long getIntegralMax() {
        return integralMax;
    }

    public void setIntegralMax(Long integralMax) {
        this.integralMax = integralMax;
    }
}
