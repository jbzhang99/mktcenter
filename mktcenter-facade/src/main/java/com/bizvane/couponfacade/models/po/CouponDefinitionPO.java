package com.bizvane.couponfacade.models.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModel;
@ApiModel("券定义")
public class CouponDefinitionPO implements Serializable {

  /**
   * @mbg.generated
   */
  @ApiModelProperty(value = "pkid", name = "couponDefinitionId", required = false, example = "")
  private Long couponDefinitionId;
  /**
   * @mbg.generated
   */
  @ApiModelProperty(value = "所属企业id", name = "sysCompanyId", required = false, example = "")
  private Long sysCompanyId;
  /**
   * @mbg.generated
   */
  @ApiModelProperty(value = "所属品牌id", name = "sysBrandId", required = false, example = "")
  private Long sysBrandId;
  /**
   * @mbg.generated
   */
  @ApiModelProperty(value = "所属品牌编号", name = "brandCode", required = false, example = "")
  private String brandCode;
  /**
   * @mbg.generated
   */
  @ApiModelProperty(value = "券编号", name = "couponDefinitionCode", required = false, example = "")
  private String couponDefinitionCode;
  /**
   * @mbg.generated
   */
  @ApiModelProperty(value = "券定义类型：1-线上定义，2-erp生成", name = "couponDefinitionType", required = false, example = "")
  private Byte couponDefinitionType;
  /**
   * @mbg.generated
   */
  @ApiModelProperty(value = "线下券类型号", name = "erpCouponDefinitionCode", required = false, example = "")
  private String erpCouponDefinitionCode;
  /**
   * @mbg.generated
   */
  @ApiModelProperty(value = "券名称", name = "couponName", required = false, example = "")
  private String couponName;
  /**
   * @mbg.generated
   */
  @ApiModelProperty(value = "渠道限制（1仅线下，2全渠道，3仅线上）", name = "useChannel", required = false, example = "")
  private Byte useChannel;
  /**
   * @mbg.generated
   */
  @ApiModelProperty(value = "优惠类型（1现金，2折扣，3兑换）", name = "preferentialType", required = false, example = "")
  private Byte preferentialType;
  /**
   * @mbg.generated
   */
  @ApiModelProperty(value = "券的面额", name = "money", required = false, example = "")
  private BigDecimal money;
  /**
   * @mbg.generated
   */
  @ApiModelProperty(value = "券的折扣", name = "discount", required = false, example = "")
  private BigDecimal discount;
  /**
   * @mbg.generated
   */
  @ApiModelProperty(value = "兑换券商品id", name = "exchangeProductId", required = false, example = "")
  private String exchangeProductId;
  /**
   * @mbg.generated
   */
  @ApiModelProperty(value = "有效期类型：1-日期区间，2-领取后X天有效，3-仅限会员生日当天使用，4-仅限会员生日当月使用", name = "validType", required = false,
      example = "")
  private Byte validType;
  /**
   * @mbg.generated
   */
  @ApiModelProperty(value = "有效期开始时间", name = "validDateStart", required = false, example = "")
  private Date validDateStart;
  /**
   * @mbg.generated
   */
  @ApiModelProperty(value = "有效期结束时间", name = "validDateEnd", required = false, example = "")
  private Date validDateEnd;
  /**
   * @mbg.generated
   */
  @ApiModelProperty(value = "有效天数", name = "validDay", required = false, example = "")
  private Integer validDay;
  /**
   * @mbg.generated
   */
  @ApiModelProperty(value = "二维码", name = "qrCode", required = false, example = "")
  private String qrCode;
  /**
   * @mbg.generated
   */
  @ApiModelProperty(value = "券模板图片", name = "img", required = false, example = "")
  private String img;
  /**
   * @mbg.generated
   */
  @ApiModelProperty(value = "单人最大领取数量限制", name = "perMaxNum", required = false, example = "")
  private Integer perMaxNum;
  /**
   * @mbg.generated
   */
  @ApiModelProperty(value = "是否记名（1记名，0不记名）", name = "isRealName", required = false, example = "")
  private Boolean isRealName;
  /**
   * @mbg.generated
   */
  @ApiModelProperty(value = "是否允许转赠（1允许转赠，0不允许转赠）", name = "isTransfer", required = false, example = "")
  private Boolean isTransfer;
  /**
   * @mbg.generated
   */
  @ApiModelProperty(value = "活动叠加条件：1-不允许叠加其他活动使用，2-允许叠加其他活动使用，3-允许部分活动使用", name = "activitySuperpositionType",
      required = false, example = "")
  private Byte activitySuperpositionType;
  /**
   * @mbg.generated
   */
  @ApiModelProperty(value = "活动叠加白名单", name = "activitySuperpositionWhiteList", required = false, example = "")
  private String activitySuperpositionWhiteList;
  /**
   * @mbg.generated
   */
  @ApiModelProperty(value = "活动叠加黑名单", name = "activitySuperpositionBlackList", required = false, example = "")
  private String activitySuperpositionBlackList;
  /**
   * @mbg.generated
   */
  @ApiModelProperty(value = "是否允许叠加（1是，0否）", name = "isSuperposition", required = false, example = "")
  private Boolean isSuperposition;
  /**
   * @mbg.generated
   */
  @ApiModelProperty(value = "正价购买限制", name = "isTagPriceLimit", required = false, example = "")
  private Boolean isTagPriceLimit;
  /**
   * @mbg.generated
   */
  @ApiModelProperty(value = "", name = "tagPriceMaxPreferentialLimit", required = false, example = "")
  private BigDecimal tagPriceMaxPreferentialLimit;
  /**
   * @mbg.generated
   */
  @ApiModelProperty(value = "最低消费金额(满减金额)", name = "minConsume", required = false, example = "")
  private BigDecimal minConsume;
  /**
   * @mbg.generated
   */
  @ApiModelProperty(value = "最高优惠金额", name = "maxPreferential", required = false, example = "")
  private BigDecimal maxPreferential;
  /**
   * @mbg.generated
   */
  @ApiModelProperty(value = "商品数量最低限制", name = "minCommodityNum", required = false, example = "")
  private Integer minCommodityNum;
  /**
   * @mbg.generated
   */
  @ApiModelProperty(value = "商品数量最高限制", name = "maxCommodityNum", required = false, example = "")
  private Integer maxCommodityNum;
  /**
   * @mbg.generated
   */
  @ApiModelProperty(value = "整单最低折扣限制", name = "minDiscount", required = false, example = "")
  private BigDecimal minDiscount;
  /**
   * @mbg.generated
   */
  @ApiModelProperty(value = "适用商品类型：1-全部适用，2-部分适用", name = "applianceCommodityType", required = false, example = "")
  private Byte applianceCommodityType;
  /**
   * @mbg.generated
   */
  @ApiModelProperty(value = "适用门店类型：1-全部适用，2-部分适用", name = "applianceStoreType", required = false, example = "")
  private Byte applianceStoreType;
  /**
   * @mbg.generated
   */
  @ApiModelProperty(value = "描述", name = "info", required = false, example = "")
  private String info;
  /**
   * @mbg.generated
   */
  @ApiModelProperty(value = "备注", name = "remark", required = false, example = "")
  private String remark;
  /**
   * @mbg.generated
   */
  @ApiModelProperty(value = "券状态（1已启用，0已停用）", name = "status", required = false, example = "")
  private Boolean status;
  /**
   * @mbg.generated
   */
  @ApiModelProperty(value = "创建人id", name = "createUserId", required = false, example = "")
  private Long createUserId;
  /**
   * @mbg.generated
   */
  @ApiModelProperty(value = "创建人", name = "createUserName", required = false, example = "")
  private String createUserName;
  /**
   * @mbg.generated
   */
  @ApiModelProperty(value = "创建时间", name = "createDate", required = false, example = "")
  private Date createDate;
  /**
   * @mbg.generated
   */
  @ApiModelProperty(value = "修改人id", name = "modifiedUserId", required = false, example = "")
  private Long modifiedUserId;
  /**
   * @mbg.generated
   */
  @ApiModelProperty(value = "修改人", name = "modifiedUserName", required = false, example = "")
  private String modifiedUserName;
  /**
   * @mbg.generated
   */
  @ApiModelProperty(value = "修改时间", name = "modifiedDate", required = false, example = "")
  private Date modifiedDate;
  /**
   * @mbg.generated
   */
  @ApiModelProperty(value = "数据有效性（1有效，0无效）", name = "valid", required = false, example = "")
  private Boolean valid;
  /**
   * @mbg.generated
   */
  @ApiModelProperty(value = "添加到券自定义模板(1是，0否)", name = "isAddTemplate", required = false, example = "")
  private Boolean isAddTemplate;
  /**
   * @mbg.generated
   */
  @ApiModelProperty(value = "券叠加条件(1-不允许叠加其他券使用  2-允许叠加其他券使用)", name = "couponSuperpositionType", required = false,
      example = "")
  private Byte couponSuperpositionType;
  /**
   * @mbg.generated
   */
  @ApiModelProperty(value = "能否叠加会员卡使用（0-不能，1-能）", name = "superpositionMemberCard", required = false, example = "")
  private Boolean superpositionMemberCard;
  /**
   * @mbg.generated
   */
  @ApiModelProperty(value = "转增后1核销送券，0不送券", name = "transferSend", required = false, example = "")
  private Boolean transferSend;
  /**
   * @mbg.generated
   */
  @ApiModelProperty(value = "转增后要发的券定义id", name = "transferCouponDefinitionId", required = false, example = "")
  private Long transferCouponDefinitionId;
  /**
   * @mbg.generated
   */
  @ApiModelProperty(value = "转增说明", name = "transferInfo", required = false, example = "")
  private String transferInfo;
  /**
   * @mbg.generated
   */
  @ApiModelProperty(value = "可裂变1，不可以0", name = "transferFission", required = false, example = "")
  private Boolean transferFission;
  /**
   * @mbg.generated
   */
  private static final long serialVersionUID = 1L;

  /**
   * @mbg.generated
   */
  public Long getCouponDefinitionId() {
    return couponDefinitionId;
  }

  /**
   * @mbg.generated
   */
  public void setCouponDefinitionId(Long couponDefinitionId) {
    this.couponDefinitionId = couponDefinitionId;
  }

  /**
   * @mbg.generated
   */
  public Long getSysCompanyId() {
    return sysCompanyId;
  }

  /**
   * @mbg.generated
   */
  public void setSysCompanyId(Long sysCompanyId) {
    this.sysCompanyId = sysCompanyId;
  }

  /**
   * @mbg.generated
   */
  public Long getSysBrandId() {
    return sysBrandId;
  }

  /**
   * @mbg.generated
   */
  public void setSysBrandId(Long sysBrandId) {
    this.sysBrandId = sysBrandId;
  }

  /**
   * @mbg.generated
   */
  public String getBrandCode() {
    return brandCode;
  }

  /**
   * @mbg.generated
   */
  public void setBrandCode(String brandCode) {
    this.brandCode = brandCode == null ? null : brandCode.trim();
  }

  /**
   * @mbg.generated
   */
  public String getCouponDefinitionCode() {
    return couponDefinitionCode;
  }

  /**
   * @mbg.generated
   */
  public void setCouponDefinitionCode(String couponDefinitionCode) {
    this.couponDefinitionCode = couponDefinitionCode == null ? null : couponDefinitionCode.trim();
  }

  /**
   * @mbg.generated
   */
  public Byte getCouponDefinitionType() {
    return couponDefinitionType;
  }

  /**
   * @mbg.generated
   */
  public void setCouponDefinitionType(Byte couponDefinitionType) {
    this.couponDefinitionType = couponDefinitionType;
  }

  /**
   * @mbg.generated
   */
  public String getErpCouponDefinitionCode() {
    return erpCouponDefinitionCode;
  }

  /**
   * @mbg.generated
   */
  public void setErpCouponDefinitionCode(String erpCouponDefinitionCode) {
    this.erpCouponDefinitionCode = erpCouponDefinitionCode == null ? null : erpCouponDefinitionCode.trim();
  }

  /**
   * @mbg.generated
   */
  public String getCouponName() {
    return couponName;
  }

  /**
   * @mbg.generated
   */
  public void setCouponName(String couponName) {
    this.couponName = couponName == null ? null : couponName.trim();
  }

  /**
   * @mbg.generated
   */
  public Byte getUseChannel() {
    return useChannel;
  }

  /**
   * @mbg.generated
   */
  public void setUseChannel(Byte useChannel) {
    this.useChannel = useChannel;
  }

  /**
   * @mbg.generated
   */
  public Byte getPreferentialType() {
    return preferentialType;
  }

  /**
   * @mbg.generated
   */
  public void setPreferentialType(Byte preferentialType) {
    this.preferentialType = preferentialType;
  }

  /**
   * @mbg.generated
   */
  public BigDecimal getMoney() {
    return money;
  }

  /**
   * @mbg.generated
   */
  public void setMoney(BigDecimal money) {
    this.money = money;
  }

  /**
   * @mbg.generated
   */
  public BigDecimal getDiscount() {
    return discount;
  }

  /**
   * @mbg.generated
   */
  public void setDiscount(BigDecimal discount) {
    this.discount = discount;
  }

  /**
   * @mbg.generated
   */
  public String getExchangeProductId() {
    return exchangeProductId;
  }

  /**
   * @mbg.generated
   */
  public void setExchangeProductId(String exchangeProductId) {
    this.exchangeProductId = exchangeProductId == null ? null : exchangeProductId.trim();
  }

  /**
   * @mbg.generated
   */
  public Byte getValidType() {
    return validType;
  }

  /**
   * @mbg.generated
   */
  public void setValidType(Byte validType) {
    this.validType = validType;
  }

  /**
   * @mbg.generated
   */
  public Date getValidDateStart() {
    return validDateStart;
  }

  /**
   * @mbg.generated
   */
  public void setValidDateStart(Date validDateStart) {
    this.validDateStart = validDateStart;
  }

  /**
   * @mbg.generated
   */
  public Date getValidDateEnd() {
    return validDateEnd;
  }

  /**
   * @mbg.generated
   */
  public void setValidDateEnd(Date validDateEnd) {
    this.validDateEnd = validDateEnd;
  }

  /**
   * @mbg.generated
   */
  public Integer getValidDay() {
    return validDay;
  }

  /**
   * @mbg.generated
   */
  public void setValidDay(Integer validDay) {
    this.validDay = validDay;
  }

  /**
   * @mbg.generated
   */
  public String getQrCode() {
    return qrCode;
  }

  /**
   * @mbg.generated
   */
  public void setQrCode(String qrCode) {
    this.qrCode = qrCode == null ? null : qrCode.trim();
  }

  /**
   * @mbg.generated
   */
  public String getImg() {
    return img;
  }

  /**
   * @mbg.generated
   */
  public void setImg(String img) {
    this.img = img == null ? null : img.trim();
  }

  /**
   * @mbg.generated
   */
  public Integer getPerMaxNum() {
    return perMaxNum;
  }

  /**
   * @mbg.generated
   */
  public void setPerMaxNum(Integer perMaxNum) {
    this.perMaxNum = perMaxNum;
  }

  /**
   * @mbg.generated
   */
  public Boolean getIsRealName() {
    return isRealName;
  }

  /**
   * @mbg.generated
   */
  public void setIsRealName(Boolean isRealName) {
    this.isRealName = isRealName;
  }

  /**
   * @mbg.generated
   */
  public Boolean getIsTransfer() {
    return isTransfer;
  }

  /**
   * @mbg.generated
   */
  public void setIsTransfer(Boolean isTransfer) {
    this.isTransfer = isTransfer;
  }

  /**
   * @mbg.generated
   */
  public Byte getActivitySuperpositionType() {
    return activitySuperpositionType;
  }

  /**
   * @mbg.generated
   */
  public void setActivitySuperpositionType(Byte activitySuperpositionType) {
    this.activitySuperpositionType = activitySuperpositionType;
  }

  /**
   * @mbg.generated
   */
  public String getActivitySuperpositionWhiteList() {
    return activitySuperpositionWhiteList;
  }

  /**
   * @mbg.generated
   */
  public void setActivitySuperpositionWhiteList(String activitySuperpositionWhiteList) {
    this.activitySuperpositionWhiteList =
        activitySuperpositionWhiteList == null ? null : activitySuperpositionWhiteList.trim();
  }

  /**
   * @mbg.generated
   */
  public String getActivitySuperpositionBlackList() {
    return activitySuperpositionBlackList;
  }

  /**
   * @mbg.generated
   */
  public void setActivitySuperpositionBlackList(String activitySuperpositionBlackList) {
    this.activitySuperpositionBlackList =
        activitySuperpositionBlackList == null ? null : activitySuperpositionBlackList.trim();
  }

  /**
   * @mbg.generated
   */
  public Boolean getIsSuperposition() {
    return isSuperposition;
  }

  /**
   * @mbg.generated
   */
  public void setIsSuperposition(Boolean isSuperposition) {
    this.isSuperposition = isSuperposition;
  }

  /**
   * @mbg.generated
   */
  public Boolean getIsTagPriceLimit() {
    return isTagPriceLimit;
  }

  /**
   * @mbg.generated
   */
  public void setIsTagPriceLimit(Boolean isTagPriceLimit) {
    this.isTagPriceLimit = isTagPriceLimit;
  }

  /**
   * @mbg.generated
   */
  public BigDecimal getTagPriceMaxPreferentialLimit() {
    return tagPriceMaxPreferentialLimit;
  }

  /**
   * @mbg.generated
   */
  public void setTagPriceMaxPreferentialLimit(BigDecimal tagPriceMaxPreferentialLimit) {
    this.tagPriceMaxPreferentialLimit = tagPriceMaxPreferentialLimit;
  }

  /**
   * @mbg.generated
   */
  public BigDecimal getMinConsume() {
    return minConsume;
  }

  /**
   * @mbg.generated
   */
  public void setMinConsume(BigDecimal minConsume) {
    this.minConsume = minConsume;
  }

  /**
   * @mbg.generated
   */
  public BigDecimal getMaxPreferential() {
    return maxPreferential;
  }

  /**
   * @mbg.generated
   */
  public void setMaxPreferential(BigDecimal maxPreferential) {
    this.maxPreferential = maxPreferential;
  }

  /**
   * @mbg.generated
   */
  public Integer getMinCommodityNum() {
    return minCommodityNum;
  }

  /**
   * @mbg.generated
   */
  public void setMinCommodityNum(Integer minCommodityNum) {
    this.minCommodityNum = minCommodityNum;
  }

  /**
   * @mbg.generated
   */
  public Integer getMaxCommodityNum() {
    return maxCommodityNum;
  }

  /**
   * @mbg.generated
   */
  public void setMaxCommodityNum(Integer maxCommodityNum) {
    this.maxCommodityNum = maxCommodityNum;
  }

  /**
   * @mbg.generated
   */
  public BigDecimal getMinDiscount() {
    return minDiscount;
  }

  /**
   * @mbg.generated
   */
  public void setMinDiscount(BigDecimal minDiscount) {
    this.minDiscount = minDiscount;
  }

  /**
   * @mbg.generated
   */
  public Byte getApplianceCommodityType() {
    return applianceCommodityType;
  }

  /**
   * @mbg.generated
   */
  public void setApplianceCommodityType(Byte applianceCommodityType) {
    this.applianceCommodityType = applianceCommodityType;
  }

  /**
   * @mbg.generated
   */
  public Byte getApplianceStoreType() {
    return applianceStoreType;
  }

  /**
   * @mbg.generated
   */
  public void setApplianceStoreType(Byte applianceStoreType) {
    this.applianceStoreType = applianceStoreType;
  }

  /**
   * @mbg.generated
   */
  public String getInfo() {
    return info;
  }

  /**
   * @mbg.generated
   */
  public void setInfo(String info) {
    this.info = info == null ? null : info.trim();
  }

  /**
   * @mbg.generated
   */
  public String getRemark() {
    return remark;
  }

  /**
   * @mbg.generated
   */
  public void setRemark(String remark) {
    this.remark = remark == null ? null : remark.trim();
  }

  /**
   * @mbg.generated
   */
  public Boolean getStatus() {
    return status;
  }

  /**
   * @mbg.generated
   */
  public void setStatus(Boolean status) {
    this.status = status;
  }

  /**
   * @mbg.generated
   */
  public Long getCreateUserId() {
    return createUserId;
  }

  /**
   * @mbg.generated
   */
  public void setCreateUserId(Long createUserId) {
    this.createUserId = createUserId;
  }

  /**
   * @mbg.generated
   */
  public String getCreateUserName() {
    return createUserName;
  }

  /**
   * @mbg.generated
   */
  public void setCreateUserName(String createUserName) {
    this.createUserName = createUserName == null ? null : createUserName.trim();
  }

  /**
   * @mbg.generated
   */
  public Date getCreateDate() {
    return createDate;
  }

  /**
   * @mbg.generated
   */
  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  /**
   * @mbg.generated
   */
  public Long getModifiedUserId() {
    return modifiedUserId;
  }

  /**
   * @mbg.generated
   */
  public void setModifiedUserId(Long modifiedUserId) {
    this.modifiedUserId = modifiedUserId;
  }

  /**
   * @mbg.generated
   */
  public String getModifiedUserName() {
    return modifiedUserName;
  }

  /**
   * @mbg.generated
   */
  public void setModifiedUserName(String modifiedUserName) {
    this.modifiedUserName = modifiedUserName == null ? null : modifiedUserName.trim();
  }

  /**
   * @mbg.generated
   */
  public Date getModifiedDate() {
    return modifiedDate;
  }

  /**
   * @mbg.generated
   */
  public void setModifiedDate(Date modifiedDate) {
    this.modifiedDate = modifiedDate;
  }

  /**
   * @mbg.generated
   */
  public Boolean getValid() {
    return valid;
  }

  /**
   * @mbg.generated
   */
  public void setValid(Boolean valid) {
    this.valid = valid;
  }

  /**
   * @mbg.generated
   */
  public Boolean getIsAddTemplate() {
    return isAddTemplate;
  }

  /**
   * @mbg.generated
   */
  public void setIsAddTemplate(Boolean isAddTemplate) {
    this.isAddTemplate = isAddTemplate;
  }

  /**
   * @mbg.generated
   */
  public Byte getCouponSuperpositionType() {
    return couponSuperpositionType;
  }

  /**
   * @mbg.generated
   */
  public void setCouponSuperpositionType(Byte couponSuperpositionType) {
    this.couponSuperpositionType = couponSuperpositionType;
  }

  /**
   * @mbg.generated
   */
  public Boolean getSuperpositionMemberCard() {
    return superpositionMemberCard;
  }

  /**
   * @mbg.generated
   */
  public void setSuperpositionMemberCard(Boolean superpositionMemberCard) {
    this.superpositionMemberCard = superpositionMemberCard;
  }

  /**
   * @mbg.generated
   */
  public Boolean getTransferSend() {
    return transferSend;
  }

  /**
   * @mbg.generated
   */
  public void setTransferSend(Boolean transferSend) {
    this.transferSend = transferSend;
  }

  /**
   * @mbg.generated
   */
  public Long getTransferCouponDefinitionId() {
    return transferCouponDefinitionId;
  }

  /**
   * @mbg.generated
   */
  public void setTransferCouponDefinitionId(Long transferCouponDefinitionId) {
    this.transferCouponDefinitionId = transferCouponDefinitionId;
  }

  /**
   * @mbg.generated
   */
  public String getTransferInfo() {
    return transferInfo;
  }

  /**
   * @mbg.generated
   */
  public void setTransferInfo(String transferInfo) {
    this.transferInfo = transferInfo == null ? null : transferInfo.trim();
  }

  /**
   * @mbg.generated
   */
  public Boolean getTransferFission() {
    return transferFission;
  }

  /**
   * @mbg.generated
   */
  public void setTransferFission(Boolean transferFission) {
    this.transferFission = transferFission;
  }

  @ApiModelProperty(value = "发券二级批次号（系统）",name = "发券二级批次号（系统）", required = true,example = "")
  private Long batchSendCodeDetail;

  public Long getBatchSendCodeDetail() {
    return batchSendCodeDetail;
  }

  public void setBatchSendCodeDetail(Long batchSendCodeDetail) {
    this.batchSendCodeDetail = batchSendCodeDetail;
  }
  
  
}