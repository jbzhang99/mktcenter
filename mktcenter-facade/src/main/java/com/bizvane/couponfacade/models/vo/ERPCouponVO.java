package com.bizvane.couponfacade.models.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by yunjie.tian on 2018/8/15.
 * 券模型
 */
public class ERPCouponVO implements Serializable{

    /**
   * 
   */
  private static final long serialVersionUID = 1L;

    @io.swagger.annotations.ApiModelProperty(value = "券定义id",name = "couponDefinitionId", required = false,example = "")
    private String couponDefinitionId;

    @io.swagger.annotations.ApiModelProperty(value = "券名称",name = "couponName", required = false,example = "")
    private String couponName;

    @io.swagger.annotations.ApiModelProperty(value = "券号",name = "couponCode", required = false,example = "")
    private String couponCode;

    @io.swagger.annotations.ApiModelProperty(value = "会员code",name = "memberCode", required = false,example = "")
    private String memberCode;

    @io.swagger.annotations.ApiModelProperty(value = "绑定状态（0未绑定，1已绑定）",name = "bindStatus", required = false,example = "")
    private Boolean bindStatus;

    @io.swagger.annotations.ApiModelProperty(value = "核销密码",name = "usePassword", required = false,example = "")
    private String usePassword;

    @io.swagger.annotations.ApiModelProperty(value = "发放类型（10-开卡发券，15-生日发券，20-受赠，25-积分兑换，30-线上开卡，35-会员升级，40-会员生日，45-会员消费，50-会员签到，55-领券，60-完善资料，65-微信分享，70-消费次数，75-消费金额，80-邀请开卡,85-批量发券）",name = "sendType", required = false,example = "")
    private String sendType;

    @io.swagger.annotations.ApiModelProperty(value = "发券业务单号(手工发券id)",name = "sendBusinessId", required = false,example = "")
    private Long sendBusinessId;

    @io.swagger.annotations.ApiModelProperty(value = "使用类型：1-线上，2-线下",name = "useType", required = false,example = "")
    private Byte useType;

    @io.swagger.annotations.ApiModelProperty(value = "核销门店",name = "useStoreId", required = false,example = "")
    private Long useStoreId;

    @io.swagger.annotations.ApiModelProperty(value = "券使用业务单号",name = "useBusinessCode", required = false,example = "")
    private String useBusinessCode;

    @io.swagger.annotations.ApiModelProperty(value = "使用时间",name = "useTime", required = false,example = "")
    private Date useTime;

    @io.swagger.annotations.ApiModelProperty(value = "是否使用(1-已使用，0-未使用)",name = "isUse", required = false,example = "")
    private Boolean isUse;

    @io.swagger.annotations.ApiModelProperty(value = "渠道限制（1仅线上，2仅线下，3全渠道）", name = "useChannel", required = false,
            example = "")
    private Byte useChannel;

    @io.swagger.annotations.ApiModelProperty(value = "优惠类型（1现金，2折扣，3礼品）",name = "preferentialType", required = false,example = "")
    private Byte preferentialType;

    @io.swagger.annotations.ApiModelProperty(value = "面额",name = "money", required = false,example = "")
    private BigDecimal money;

    @io.swagger.annotations.ApiModelProperty(value = "折扣",name = "discount", required = false,example = "")
    private BigDecimal discount;

    @io.swagger.annotations.ApiModelProperty(value = "有效期开始时间",name = "validDateStart", required = false,example = "")
    private Date validDateStart;

    @io.swagger.annotations.ApiModelProperty(value = "有效期结束时间",name = "validDateEnd", required = false,example = "")
    private Date validDateEnd;

    @io.swagger.annotations.ApiModelProperty(value = "二维码", name = "qrCode", required = false, example = "")
    private String qrCode;

    @io.swagger.annotations.ApiModelProperty(value = "券模板图片",name = "img", required = false,example = "")
    private String img;

    @io.swagger.annotations.ApiModelProperty(value = "单人最大领取数量限制", name = "perMaxNum", required = false, example = "")
    private Integer perMaxNum;

    @io.swagger.annotations.ApiModelProperty(value = "是否记名（1记名，0不记名）", name = "isRealName", required = false,
            example = "")
    private Boolean isRealName;

    @io.swagger.annotations.ApiModelProperty(value = "是否允许转赠（1允许转赠，0不允许转赠）", name = "isTransfer", required = false,
            example = "")
    private Boolean isTransfer;

    @io.swagger.annotations.ApiModelProperty(value = "活动叠加白名单", name = "activitySuperpositionWhiteList", required = false,
            example = "")
    private String activitySuperpositionWhiteList;

    @io.swagger.annotations.ApiModelProperty(value = "活动叠加黑名单", name = "activitySuperpositionBlackList", required = false,
            example = "")
    private String activitySuperpositionBlackList;

    @io.swagger.annotations.ApiModelProperty(value = "是否允许叠加（1是，0否）", name = "isSuperposition", required = false,
            example = "")
    private Boolean isSuperposition;

    @io.swagger.annotations.ApiModelProperty(value = "正价购买限制", name = "isTagPriceLimit", required = false, example = "")
    private Boolean isTagPriceLimit;

    @io.swagger.annotations.ApiModelProperty(value = "最低消费金额(满减金额)", name = "minConsume", required = false, example = "")
    private BigDecimal minConsume;

    @io.swagger.annotations.ApiModelProperty(value = "最高优惠金额", name = "maxPreferential", required = false, example = "")
    private BigDecimal maxPreferential;

    @io.swagger.annotations.ApiModelProperty(value = "商品数量最低限制", name = "minCommodityNum", required = false, example = "")
    private Integer minCommodityNum;

    @io.swagger.annotations.ApiModelProperty(value = "商品数量最高限制", name = "maxCommodityNum", required = false, example = "")
    private Integer maxCommodityNum;

    @io.swagger.annotations.ApiModelProperty(value = "整单最低折扣限制", name = "minDiscount", required = false, example = "")
    private BigDecimal minDiscount;

    @io.swagger.annotations.ApiModelProperty(value = "适用商品类型：1-全部适用，2-部分适用", name = "applianceCommodityType",
            required = false, example = "")
    private Byte applianceCommodityType;

    @io.swagger.annotations.ApiModelProperty(value = "适用门店类型：1-全部适用，2-部分适用", name = "applianceStoreType",
            required = false, example = "")
    private Byte applianceStoreType;

    @io.swagger.annotations.ApiModelProperty(value = "商品白名单", name = "commodityWhitelist", required = false, example = "")
    private String commodityWhitelist;

    @io.swagger.annotations.ApiModelProperty(value = "商品黑名单", name = "commodityBlacklist", required = false, example = "")
    private String commodityBlacklist;

    @io.swagger.annotations.ApiModelProperty(value = "门店白名单", name = "storeWhitelist", required = false, example = "")
    private String storeWhitelist;

    @io.swagger.annotations.ApiModelProperty(value = "门店黑名单", name = "storeBlacklist", required = false, example = "")
    private String storeBlacklist;

    @io.swagger.annotations.ApiModelProperty(value = "所属品牌id", name = "brandCode", required = false, example = "")
    private Long sysBrandId;

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

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    public Boolean getBindStatus() {
        return bindStatus;
    }

    public void setBindStatus(Boolean bindStatus) {
        this.bindStatus = bindStatus;
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

    public Byte getUseChannel() {
        return useChannel;
    }

    public void setUseChannel(Byte useChannel) {
        this.useChannel = useChannel;
    }

    public Byte getPreferentialType() {
        return preferentialType;
    }

    public void setPreferentialType(Byte preferentialType) {
        this.preferentialType = preferentialType;
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

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getPerMaxNum() {
        return perMaxNum;
    }

    public void setPerMaxNum(Integer perMaxNum) {
        this.perMaxNum = perMaxNum;
    }

    public Boolean getRealName() {
        return isRealName;
    }

    public void setRealName(Boolean realName) {
        isRealName = realName;
    }

    public Boolean getTransfer() {
        return isTransfer;
    }

    public void setTransfer(Boolean transfer) {
        isTransfer = transfer;
    }

    public String getActivitySuperpositionWhiteList() {
        return activitySuperpositionWhiteList;
    }

    public void setActivitySuperpositionWhiteList(String activitySuperpositionWhiteList) {
        this.activitySuperpositionWhiteList = activitySuperpositionWhiteList;
    }

    public String getActivitySuperpositionBlackList() {
        return activitySuperpositionBlackList;
    }

    public void setActivitySuperpositionBlackList(String activitySuperpositionBlackList) {
        this.activitySuperpositionBlackList = activitySuperpositionBlackList;
    }

    public Boolean getSuperposition() {
        return isSuperposition;
    }

    public void setSuperposition(Boolean superposition) {
        isSuperposition = superposition;
    }

    public Boolean getTagPriceLimit() {
        return isTagPriceLimit;
    }

    public void setTagPriceLimit(Boolean tagPriceLimit) {
        isTagPriceLimit = tagPriceLimit;
    }

    public BigDecimal getMinConsume() {
        return minConsume;
    }

    public void setMinConsume(BigDecimal minConsume) {
        this.minConsume = minConsume;
    }

    public BigDecimal getMaxPreferential() {
        return maxPreferential;
    }

    public void setMaxPreferential(BigDecimal maxPreferential) {
        this.maxPreferential = maxPreferential;
    }

    public Integer getMinCommodityNum() {
        return minCommodityNum;
    }

    public void setMinCommodityNum(Integer minCommodityNum) {
        this.minCommodityNum = minCommodityNum;
    }

    public Integer getMaxCommodityNum() {
        return maxCommodityNum;
    }

    public void setMaxCommodityNum(Integer maxCommodityNum) {
        this.maxCommodityNum = maxCommodityNum;
    }

    public BigDecimal getMinDiscount() {
        return minDiscount;
    }

    public void setMinDiscount(BigDecimal minDiscount) {
        this.minDiscount = minDiscount;
    }

    public Byte getApplianceCommodityType() {
        return applianceCommodityType;
    }

    public void setApplianceCommodityType(Byte applianceCommodityType) {
        this.applianceCommodityType = applianceCommodityType;
    }

    public Byte getApplianceStoreType() {
        return applianceStoreType;
    }

    public void setApplianceStoreType(Byte applianceStoreType) {
        this.applianceStoreType = applianceStoreType;
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

    public Boolean getIsUse() {
      return isUse;
    }

    public void setIsUse(Boolean isUse) {
      this.isUse = isUse;
    }

    public Boolean getIsRealName() {
      return isRealName;
    }

    public void setIsRealName(Boolean isRealName) {
      this.isRealName = isRealName;
    }

    public Boolean getIsTransfer() {
      return isTransfer;
    }

    public void setIsTransfer(Boolean isTransfer) {
      this.isTransfer = isTransfer;
    }

    public Boolean getIsSuperposition() {
      return isSuperposition;
    }

    public void setIsSuperposition(Boolean isSuperposition) {
      this.isSuperposition = isSuperposition;
    }

    public Boolean getIsTagPriceLimit() {
      return isTagPriceLimit;
    }

    public void setIsTagPriceLimit(Boolean isTagPriceLimit) {
      this.isTagPriceLimit = isTagPriceLimit;
    }

    public Long getSysBrandId() {
      return sysBrandId;
    }

    public void setSysBrandId(Long sysBrandId) {
      this.sysBrandId = sysBrandId;
    }

}
