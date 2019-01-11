package com.bizvane.mktcenterservice.models.po;

import java.io.Serializable;
import java.util.Date;

public class MktActivityRedPacketPO implements Serializable {
    /**
     * 只读.
    pkid. mkt_activity_red_packet_id
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    @io.swagger.annotations.ApiModelProperty(value = "pkid",name = "mktActivityRedPacketId", required = false,example = "")
    private Long mktActivityRedPacketId;

    /**
     * 只读.
    所属企业id. sys_company_id
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    @io.swagger.annotations.ApiModelProperty(value = "所属企业id",name = "sysCompanyId", required = false,example = "")
    private Long sysCompanyId;

    /**
     * 只读.
    所属品牌id. sys_brand_id
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    @io.swagger.annotations.ApiModelProperty(value = "所属品牌id",name = "sysBrandId", required = false,example = "")
    private Long sysBrandId;

    /**
     * 只读.
    关联活动id. mkt_activity_id
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    @io.swagger.annotations.ApiModelProperty(value = "关联活动id",name = "mktActivityId", required = false,example = "")
    private Long mktActivityId;

    /**
     * 只读.
    券定义id. coupon_definition_id
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    @io.swagger.annotations.ApiModelProperty(value = "券定义id",name = "couponDefinitionId", required = false,example = "")
    private Long couponDefinitionId;

    /**
     * 只读.
    活动奖励的券名称. coupon_name
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    @io.swagger.annotations.ApiModelProperty(value = "活动奖励的券名称",name = "couponName", required = false,example = "")
    private String couponName;

    /**
     * 只读.
    券面额. coupon_ denomination
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    @io.swagger.annotations.ApiModelProperty(value = "券面额",name = "couponDenomination", required = false,example = "")
    private Integer couponDenomination;

    /**
     * 只读.
    叠加券面额. add_coupon_ denomination
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    @io.swagger.annotations.ApiModelProperty(value = "叠加券面额",name = "addCouponDenomination", required = false,example = "")
    private Integer addCouponDenomination;

    /**
     * 只读.
    参与赠送积分，1是，0否. do_if_reward
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    @io.swagger.annotations.ApiModelProperty(value = "参与赠送积分，1是，0否",name = "doIfReward", required = false,example = "")
    private Boolean doIfReward;

    /**
     * 只读.
    奖励积分. reward_ integral
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    @io.swagger.annotations.ApiModelProperty(value = "奖励积分",name = "rewardIntegral", required = false,example = "")
    private Integer rewardIntegral;

    /**
     * 只读.
    备注. remark
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    @io.swagger.annotations.ApiModelProperty(value = "备注",name = "remark", required = false,example = "")
    private String remark;

    /**
     * 只读.
    创建人id. create_user_id
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    @io.swagger.annotations.ApiModelProperty(value = "创建人id",name = "createUserId", required = false,example = "")
    private Long createUserId;

    /**
     * 只读.
    创建人. create_user_name
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    @io.swagger.annotations.ApiModelProperty(value = "创建人",name = "createUserName", required = false,example = "")
    private String createUserName;

    /**
     * 只读.
    创建日期. create_date
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    @io.swagger.annotations.ApiModelProperty(value = "创建日期",name = "createDate", required = false,example = "")
    private Date createDate;

    /**
     * 只读.
    修改人id. modified_user_id
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    @io.swagger.annotations.ApiModelProperty(value = "修改人id",name = "modifiedUserId", required = false,example = "")
    private Long modifiedUserId;

    /**
     * 只读.
    修改人. modified_user_name
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    @io.swagger.annotations.ApiModelProperty(value = "修改人",name = "modifiedUserName", required = false,example = "")
    private String modifiedUserName;

    /**
     * 只读.
    修改时间. modified_date
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    @io.swagger.annotations.ApiModelProperty(value = "修改时间",name = "modifiedDate", required = false,example = "")
    private Date modifiedDate;

    /**
     * 只读.
    数据有效性：1=有效；0=无效. valid
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    @io.swagger.annotations.ApiModelProperty(value = "数据有效性：1=有效；0=无效",name = "valid", required = false,example = "")
    private Boolean valid;

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    private static final long serialVersionUID = 1L;

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public Long getMktActivityRedPacketId() {
        return mktActivityRedPacketId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public void setMktActivityRedPacketId(Long mktActivityRedPacketId) {
        this.mktActivityRedPacketId = mktActivityRedPacketId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public Long getSysCompanyId() {
        return sysCompanyId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public void setSysCompanyId(Long sysCompanyId) {
        this.sysCompanyId = sysCompanyId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public Long getSysBrandId() {
        return sysBrandId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public void setSysBrandId(Long sysBrandId) {
        this.sysBrandId = sysBrandId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public Long getMktActivityId() {
        return mktActivityId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public void setMktActivityId(Long mktActivityId) {
        this.mktActivityId = mktActivityId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public Long getCouponDefinitionId() {
        return couponDefinitionId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public void setCouponDefinitionId(Long couponDefinitionId) {
        this.couponDefinitionId = couponDefinitionId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public String getCouponName() {
        return couponName;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public void setCouponName(String couponName) {
        this.couponName = couponName == null ? null : couponName.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public Integer getCouponDenomination() {
        return couponDenomination;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public void setCouponDenomination(Integer couponDenomination) {
        this.couponDenomination = couponDenomination;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public Integer getAddCouponDenomination() {
        return addCouponDenomination;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public void setAddCouponDenomination(Integer addCouponDenomination) {
        this.addCouponDenomination = addCouponDenomination;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public Boolean getDoIfReward() {
        return doIfReward;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public void setDoIfReward(Boolean doIfReward) {
        this.doIfReward = doIfReward;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public Integer getRewardIntegral() {
        return rewardIntegral;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public void setRewardIntegral(Integer rewardIntegral) {
        this.rewardIntegral = rewardIntegral;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public Long getCreateUserId() {
        return createUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public String getCreateUserName() {
        return createUserName;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public Long getModifiedUserId() {
        return modifiedUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public void setModifiedUserId(Long modifiedUserId) {
        this.modifiedUserId = modifiedUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public String getModifiedUserName() {
        return modifiedUserName;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public void setModifiedUserName(String modifiedUserName) {
        this.modifiedUserName = modifiedUserName == null ? null : modifiedUserName.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public Date getModifiedDate() {
        return modifiedDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public Boolean getValid() {
        return valid;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public void setValid(Boolean valid) {
        this.valid = valid;
    }
}