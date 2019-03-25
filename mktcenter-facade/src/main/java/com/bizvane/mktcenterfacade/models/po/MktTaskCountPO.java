package com.bizvane.mktcenterfacade.models.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class MktTaskCountPO implements Serializable {
    /**
     * 只读.
    pkid. mkt_task_count_id
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    @io.swagger.annotations.ApiModelProperty(value = "pkid",name = "mktTaskCountId", required = false,example = "")
    private Long mktTaskCountId;

    /**
     * 只读.
    会员任务. mkt_task_id
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    @io.swagger.annotations.ApiModelProperty(value = "会员任务",name = "mktTaskId", required = false,example = "")
    private Long mktTaskId;

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
    此任务的会员数量. member_count
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    @io.swagger.annotations.ApiModelProperty(value = "此任务的会员数量",name = "memberCount", required = false,example = "")
    private Integer memberCount;

    /**
     * 只读.
    参与任务完成的订单金额总和. consume_amount_sum
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    @io.swagger.annotations.ApiModelProperty(value = "参与任务完成的订单金额总和",name = "consumeAmountSum", required = false,example = "")
    private BigDecimal consumeAmountSum;

    /**
     * 只读.
    发券数量总和. coupon_num_sum
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    @io.swagger.annotations.ApiModelProperty(value = "发券数量总和",name = "couponNumSum", required = false,example = "")
    private Integer couponNumSum;

    /**
     * 只读.
    奖励积分总和. points_sum
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    @io.swagger.annotations.ApiModelProperty(value = "奖励积分总和",name = "pointsSum", required = false,example = "")
    private Integer pointsSum;

    /**
     * 只读.
    分享次数总和. share_num_sum
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    @io.swagger.annotations.ApiModelProperty(value = "分享次数总和",name = "shareNumSum", required = false,example = "")
    private Integer shareNumSum;

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
    public Long getMktTaskCountId() {
        return mktTaskCountId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    public void setMktTaskCountId(Long mktTaskCountId) {
        this.mktTaskCountId = mktTaskCountId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    public Long getMktTaskId() {
        return mktTaskId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    public void setMktTaskId(Long mktTaskId) {
        this.mktTaskId = mktTaskId;
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
    public BigDecimal getConsumeAmountSum() {
        return consumeAmountSum;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    public void setConsumeAmountSum(BigDecimal consumeAmountSum) {
        this.consumeAmountSum = consumeAmountSum;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    public Integer getCouponNumSum() {
        return couponNumSum;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    public void setCouponNumSum(Integer couponNumSum) {
        this.couponNumSum = couponNumSum;
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
    public Integer getShareNumSum() {
        return shareNumSum;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-06 15:41:41
     */
    public void setShareNumSum(Integer shareNumSum) {
        this.shareNumSum = shareNumSum;
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