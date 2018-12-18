package com.bizvane.mktcenterservice.models.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class MktActivityPrizePO implements Serializable {
    /**
     * 只读.
    pkid. mkt_activity_prize_id
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    @io.swagger.annotations.ApiModelProperty(value = "pkid",name = "mktActivityPrizeId", required = false,example = "")
    private Long mktActivityPrizeId;

    /**
     * 只读.
    所属企业id. sys_company_id
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    @io.swagger.annotations.ApiModelProperty(value = "所属企业id",name = "sysCompanyId", required = false,example = "")
    private Long sysCompanyId;

    /**
     * 只读.
    所属品牌id. sys_brand_id
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    @io.swagger.annotations.ApiModelProperty(value = "所属品牌id",name = "sysBrandId", required = false,example = "")
    private Long sysBrandId;

    /**
     * 只读.
    关联活动id. mkt_activity_id
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    @io.swagger.annotations.ApiModelProperty(value = "关联活动id",name = "mktActivityId", required = false,example = "")
    private Long mktActivityId;

    /**
     * 只读.
    奖项类型，10-特等奖，20-一等奖，30-二等奖，40-三等奖，50-谢谢参与. prize_type
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    @io.swagger.annotations.ApiModelProperty(value = "奖项类型，10-特等奖，20-一等奖，30-二等奖，40-三等奖，50-谢谢参与",name = "prizeType", required = false,example = "")
    private Integer prizeType;

    /**
     * 只读.
    奖品名称. prize_name
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    @io.swagger.annotations.ApiModelProperty(value = "奖品名称",name = "prizeName", required = false,example = "")
    private String prizeName;

    /**
     * 只读.
    奖品类型：10-积分，20-优惠券（现金，折扣）,30-兑换券（礼品券）. awad_type
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    @io.swagger.annotations.ApiModelProperty(value = "奖品类型：10-积分，20-优惠券（现金，折扣）,30-兑换券（礼品券）",name = "awadType", required = false,example = "")
    private Integer awadType;

    /**
     * 只读.
    奖励积分. prize_points
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    @io.swagger.annotations.ApiModelProperty(value = "奖励积分",name = "prizePoints", required = false,example = "")
    private Integer prizePoints;

    /**
     * 只读.
    券定义id. coupon_definition_id
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    @io.swagger.annotations.ApiModelProperty(value = "券定义id",name = "couponDefinitionId", required = false,example = "")
    private Long couponDefinitionId;

    /**
     * 只读.
    活动奖励的券名称. coupon_name
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    @io.swagger.annotations.ApiModelProperty(value = "活动奖励的券名称",name = "couponName", required = false,example = "")
    private String couponName;

    /**
     * 只读.
    奖品图片url. image_url
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    @io.swagger.annotations.ApiModelProperty(value = "奖品图片url",name = "imageUrl", required = false,example = "")
    private String imageUrl;

    /**
     * 只读.
    中奖概率%. probability
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    @io.swagger.annotations.ApiModelProperty(value = "中奖概率%",name = "probability", required = false,example = "")
    private BigDecimal probability;

    /**
     * 只读.
    无效次数，前x次不能中奖. invalid_count
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    @io.swagger.annotations.ApiModelProperty(value = "无效次数，前x次不能中奖",name = "invalidCount", required = false,example = "")
    private Integer invalidCount;

    /**
     * 只读.
    奖品数量. prize_sum
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    @io.swagger.annotations.ApiModelProperty(value = "奖品数量",name = "prizeSum", required = false,example = "")
    private Integer prizeSum;

    /**
     * 只读.
    每个用户限制中奖次数. user_limit_sum
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    @io.swagger.annotations.ApiModelProperty(value = "每个用户限制中奖次数",name = "userLimitSum", required = false,example = "")
    private Integer userLimitSum;

    /**
     * 只读.
    参与赠送奖励，1是，0否. participate_prize
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    @io.swagger.annotations.ApiModelProperty(value = "参与赠送奖励，1是，0否",name = "participatePrize", required = false,example = "")
    private Boolean participatePrize;

    /**
     * 只读.
    参与积分. participate_points
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    @io.swagger.annotations.ApiModelProperty(value = "参与积分",name = "participatePoints", required = false,example = "")
    private Integer participatePoints;

    /**
     * 只读.
    备注. remark
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    @io.swagger.annotations.ApiModelProperty(value = "备注",name = "remark", required = false,example = "")
    private String remark;

    /**
     * 只读.
    创建人id. create_user_id
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    @io.swagger.annotations.ApiModelProperty(value = "创建人id",name = "createUserId", required = false,example = "")
    private Long createUserId;

    /**
     * 只读.
    创建人. create_user_name
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    @io.swagger.annotations.ApiModelProperty(value = "创建人",name = "createUserName", required = false,example = "")
    private String createUserName;

    /**
     * 只读.
    创建日期. create_date
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    @io.swagger.annotations.ApiModelProperty(value = "创建日期",name = "createDate", required = false,example = "")
    private Date createDate;

    /**
     * 只读.
    修改人id. modified_user_id
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    @io.swagger.annotations.ApiModelProperty(value = "修改人id",name = "modifiedUserId", required = false,example = "")
    private Long modifiedUserId;

    /**
     * 只读.
    修改人. modified_user_name
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    @io.swagger.annotations.ApiModelProperty(value = "修改人",name = "modifiedUserName", required = false,example = "")
    private String modifiedUserName;

    /**
     * 只读.
    修改时间. modified_date
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    @io.swagger.annotations.ApiModelProperty(value = "修改时间",name = "modifiedDate", required = false,example = "")
    private Date modifiedDate;

    /**
     * 只读.
    数据有效性：1=有效；0=无效. valid
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    @io.swagger.annotations.ApiModelProperty(value = "数据有效性：1=有效；0=无效",name = "valid", required = false,example = "")
    private Boolean valid;

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    private static final long serialVersionUID = 1L;

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    public Long getMktActivityPrizeId() {
        return mktActivityPrizeId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    public void setMktActivityPrizeId(Long mktActivityPrizeId) {
        this.mktActivityPrizeId = mktActivityPrizeId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    public Long getSysCompanyId() {
        return sysCompanyId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    public void setSysCompanyId(Long sysCompanyId) {
        this.sysCompanyId = sysCompanyId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    public Long getSysBrandId() {
        return sysBrandId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    public void setSysBrandId(Long sysBrandId) {
        this.sysBrandId = sysBrandId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    public Long getMktActivityId() {
        return mktActivityId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    public void setMktActivityId(Long mktActivityId) {
        this.mktActivityId = mktActivityId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    public Integer getPrizeType() {
        return prizeType;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    public void setPrizeType(Integer prizeType) {
        this.prizeType = prizeType;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    public String getPrizeName() {
        return prizeName;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName == null ? null : prizeName.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    public Integer getAwadType() {
        return awadType;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    public void setAwadType(Integer awadType) {
        this.awadType = awadType;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    public Integer getPrizePoints() {
        return prizePoints;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    public void setPrizePoints(Integer prizePoints) {
        this.prizePoints = prizePoints;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    public Long getCouponDefinitionId() {
        return couponDefinitionId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    public void setCouponDefinitionId(Long couponDefinitionId) {
        this.couponDefinitionId = couponDefinitionId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    public String getCouponName() {
        return couponName;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    public void setCouponName(String couponName) {
        this.couponName = couponName == null ? null : couponName.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    public BigDecimal getProbability() {
        return probability;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    public void setProbability(BigDecimal probability) {
        this.probability = probability;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    public Integer getInvalidCount() {
        return invalidCount;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    public void setInvalidCount(Integer invalidCount) {
        this.invalidCount = invalidCount;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    public Integer getPrizeSum() {
        return prizeSum;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    public void setPrizeSum(Integer prizeSum) {
        this.prizeSum = prizeSum;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    public Integer getUserLimitSum() {
        return userLimitSum;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    public void setUserLimitSum(Integer userLimitSum) {
        this.userLimitSum = userLimitSum;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    public Boolean getParticipatePrize() {
        return participatePrize;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    public void setParticipatePrize(Boolean participatePrize) {
        this.participatePrize = participatePrize;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    public Integer getParticipatePoints() {
        return participatePoints;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    public void setParticipatePoints(Integer participatePoints) {
        this.participatePoints = participatePoints;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    public Long getCreateUserId() {
        return createUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    public String getCreateUserName() {
        return createUserName;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    public Long getModifiedUserId() {
        return modifiedUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    public void setModifiedUserId(Long modifiedUserId) {
        this.modifiedUserId = modifiedUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    public String getModifiedUserName() {
        return modifiedUserName;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    public void setModifiedUserName(String modifiedUserName) {
        this.modifiedUserName = modifiedUserName == null ? null : modifiedUserName.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    public Date getModifiedDate() {
        return modifiedDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    public Boolean getValid() {
        return valid;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    public void setValid(Boolean valid) {
        this.valid = valid;
    }
}