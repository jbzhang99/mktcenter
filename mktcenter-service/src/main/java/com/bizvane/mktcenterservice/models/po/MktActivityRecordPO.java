package com.bizvane.mktcenterservice.models.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class MktActivityRecordPO implements Serializable {
    /**
     * 只读.
    pkid. mkt_activity_record_id
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    @io.swagger.annotations.ApiModelProperty(value = "pkid",name = "mktActivityRecordId", required = false,example = "")
    private Long mktActivityRecordId;

    /**
     * 只读.
    参与的活动id. mkt_activity_id
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    @io.swagger.annotations.ApiModelProperty(value = "参与的活动id",name = "mktActivityId", required = false,example = "")
    private Long mktActivityId;

    /**
     * 只读.
    参与活动的会员编号. member_code
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    @io.swagger.annotations.ApiModelProperty(value = "参与活动的会员编号",name = "memberCode", required = false,example = "")
    private String memberCode;

    /**
     * 只读.
    活动参与一次的订单金额. order_amount
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    @io.swagger.annotations.ApiModelProperty(value = "活动参与一次的订单金额",name = "orderAmount", required = false,example = "")
    private BigDecimal orderAmount;

    /**
     * 只读.
    备注. remark
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    @io.swagger.annotations.ApiModelProperty(value = "备注",name = "remark", required = false,example = "")
    private String remark;

    /**
     * 只读.
    创建人id. create_user_id
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    @io.swagger.annotations.ApiModelProperty(value = "创建人id",name = "createUserId", required = false,example = "")
    private Long createUserId;

    /**
     * 只读.
    创建人. create_user_name
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    @io.swagger.annotations.ApiModelProperty(value = "创建人",name = "createUserName", required = false,example = "")
    private String createUserName;

    /**
     * 只读.
    创建日期. create_date
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    @io.swagger.annotations.ApiModelProperty(value = "创建日期",name = "createDate", required = false,example = "")
    private Date createDate;

    /**
     * 只读.
    修改人id. modified_user_id
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    @io.swagger.annotations.ApiModelProperty(value = "修改人id",name = "modifiedUserId", required = false,example = "")
    private Long modifiedUserId;

    /**
     * 只读.
    修改人. modified_user_name
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    @io.swagger.annotations.ApiModelProperty(value = "修改人",name = "modifiedUserName", required = false,example = "")
    private String modifiedUserName;

    /**
     * 只读.
    修改时间. modified_date
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    @io.swagger.annotations.ApiModelProperty(value = "修改时间",name = "modifiedDate", required = false,example = "")
    private Date modifiedDate;

    /**
     * 只读.
    数据有效性：1=有效；0=无效. valid
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    @io.swagger.annotations.ApiModelProperty(value = "数据有效性：1=有效；0=无效",name = "valid", required = false,example = "")
    private Boolean valid;

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    private static final long serialVersionUID = 1L;

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    public Long getMktActivityRecordId() {
        return mktActivityRecordId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    public void setMktActivityRecordId(Long mktActivityRecordId) {
        this.mktActivityRecordId = mktActivityRecordId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    public Long getMktActivityId() {
        return mktActivityId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    public void setMktActivityId(Long mktActivityId) {
        this.mktActivityId = mktActivityId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    public String getMemberCode() {
        return memberCode;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode == null ? null : memberCode.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    public Long getCreateUserId() {
        return createUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    public String getCreateUserName() {
        return createUserName;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    public Long getModifiedUserId() {
        return modifiedUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    public void setModifiedUserId(Long modifiedUserId) {
        this.modifiedUserId = modifiedUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    public String getModifiedUserName() {
        return modifiedUserName;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    public void setModifiedUserName(String modifiedUserName) {
        this.modifiedUserName = modifiedUserName == null ? null : modifiedUserName.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    public Date getModifiedDate() {
        return modifiedDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    public Boolean getValid() {
        return valid;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    public void setValid(Boolean valid) {
        this.valid = valid;
    }
}