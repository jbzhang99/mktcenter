package com.bizvane.mktcenterfacade.models.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class MktActivityCountPO implements Serializable {
    /**
     * 只读.
    pkid. mkt_activity_count_id
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    @io.swagger.annotations.ApiModelProperty(value = "pkid",name = "mktActivityCountId", required = false,example = "")
    private Long mktActivityCountId;

    /**
     * 只读.
    活动主表id. mkt_activity_id
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    @io.swagger.annotations.ApiModelProperty(value = "活动主表id",name = "mktActivityId", required = false,example = "")
    private Long mktActivityId;

    /**
     * 只读.
    所属企业id. sys_company_id
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    @io.swagger.annotations.ApiModelProperty(value = "所属企业id",name = "sysCompanyId", required = false,example = "")
    private Long sysCompanyId;

    /**
     * 只读.
    所属品牌id. sys_brand_id
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    @io.swagger.annotations.ApiModelProperty(value = "所属品牌id",name = "sysBrandId", required = false,example = "")
    private Long sysBrandId;

    /**
     * 只读.
    此活动的会员数量. member_count
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    @io.swagger.annotations.ApiModelProperty(value = "此活动的会员数量",name = "memberCount", required = false,example = "")
    private Integer memberCount;

    /**
     * 只读.
    此活动订单金额总和. order_amount_sum
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    @io.swagger.annotations.ApiModelProperty(value = "此活动订单金额总和",name = "orderAmountSum", required = false,example = "")
    private BigDecimal orderAmountSum;

    /**
     * 只读.
    此活动奖励积分总和. points_sum
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    @io.swagger.annotations.ApiModelProperty(value = "此活动奖励积分总和",name = "pointsSum", required = false,example = "")
    private Integer pointsSum;

    /**
     * 只读.
    备注. remark
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    @io.swagger.annotations.ApiModelProperty(value = "备注",name = "remark", required = false,example = "")
    private String remark;

    /**
     * 只读.
    创建人id. create_user_id
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    @io.swagger.annotations.ApiModelProperty(value = "创建人id",name = "createUserId", required = false,example = "")
    private Long createUserId;

    /**
     * 只读.
    创建人. create_user_name
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    @io.swagger.annotations.ApiModelProperty(value = "创建人",name = "createUserName", required = false,example = "")
    private String createUserName;

    /**
     * 只读.
    创建日期. create_date
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    @io.swagger.annotations.ApiModelProperty(value = "创建日期",name = "createDate", required = false,example = "")
    private Date createDate;

    /**
     * 只读.
    修改人id. modified_user_id
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    @io.swagger.annotations.ApiModelProperty(value = "修改人id",name = "modifiedUserId", required = false,example = "")
    private Long modifiedUserId;

    /**
     * 只读.
    修改人. modified_user_name
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    @io.swagger.annotations.ApiModelProperty(value = "修改人",name = "modifiedUserName", required = false,example = "")
    private String modifiedUserName;

    /**
     * 只读.
    修改时间. modified_date
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    @io.swagger.annotations.ApiModelProperty(value = "修改时间",name = "modifiedDate", required = false,example = "")
    private Date modifiedDate;

    /**
     * 只读.
    数据有效性：1=有效；0=无效. valid
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    @io.swagger.annotations.ApiModelProperty(value = "数据有效性：1=有效；0=无效",name = "valid", required = false,example = "")
    private Boolean valid;

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    private static final long serialVersionUID = 1L;

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    public Long getMktActivityCountId() {
        return mktActivityCountId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    public void setMktActivityCountId(Long mktActivityCountId) {
        this.mktActivityCountId = mktActivityCountId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    public Long getMktActivityId() {
        return mktActivityId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    public void setMktActivityId(Long mktActivityId) {
        this.mktActivityId = mktActivityId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    public Long getSysCompanyId() {
        return sysCompanyId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    public void setSysCompanyId(Long sysCompanyId) {
        this.sysCompanyId = sysCompanyId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    public Long getSysBrandId() {
        return sysBrandId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    public void setSysBrandId(Long sysBrandId) {
        this.sysBrandId = sysBrandId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    public Integer getMemberCount() {
        return memberCount;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    public void setMemberCount(Integer memberCount) {
        this.memberCount = memberCount;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    public BigDecimal getOrderAmountSum() {
        return orderAmountSum;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    public void setOrderAmountSum(BigDecimal orderAmountSum) {
        this.orderAmountSum = orderAmountSum;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    public Integer getPointsSum() {
        return pointsSum;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    public void setPointsSum(Integer pointsSum) {
        this.pointsSum = pointsSum;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    public Long getCreateUserId() {
        return createUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    public String getCreateUserName() {
        return createUserName;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    public Long getModifiedUserId() {
        return modifiedUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    public void setModifiedUserId(Long modifiedUserId) {
        this.modifiedUserId = modifiedUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    public String getModifiedUserName() {
        return modifiedUserName;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    public void setModifiedUserName(String modifiedUserName) {
        this.modifiedUserName = modifiedUserName == null ? null : modifiedUserName.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    public Date getModifiedDate() {
        return modifiedDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    public Boolean getValid() {
        return valid;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    public void setValid(Boolean valid) {
        this.valid = valid;
    }
}