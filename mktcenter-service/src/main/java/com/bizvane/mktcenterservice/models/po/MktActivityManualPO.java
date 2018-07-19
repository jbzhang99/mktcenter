package com.bizvane.mktcenterservice.models.po;

import java.io.Serializable;
import java.util.Date;

public class MktActivityManualPO implements Serializable {
    /**
     * 只读.
    pkid. mkt_activity_manual_id
     *
     * @mbg.generated 2018-07-19 16:07:25
     */
    @io.swagger.annotations.ApiModelProperty(value = "pkid",name = "mktActivityManualId", required = false,example = "")
    private Long mktActivityManualId;

    /**
     * 只读.
    关联活动id. mkt_activity_id
     *
     * @mbg.generated 2018-07-19 16:07:25
     */
    @io.swagger.annotations.ApiModelProperty(value = "关联活动id",name = "mktActivityId", required = false,example = "")
    private Long mktActivityId;

    /**
     * 只读.
    领取方式：1扫码领券，2手动领券. receive_type
     *
     * @mbg.generated 2018-07-19 16:07:25
     */
    @io.swagger.annotations.ApiModelProperty(value = "领取方式：1扫码领券，2手动领券",name = "receiveType", required = false,example = "")
    private Integer receiveType;

    /**
     * 只读.
    每人每日最多领取多少张. per_person_per_day_max
     *
     * @mbg.generated 2018-07-19 16:07:25
     */
    @io.swagger.annotations.ApiModelProperty(value = "每人每日最多领取多少张",name = "perPersonPerDayMax", required = false,example = "")
    private Integer perPersonPerDayMax;

    /**
     * 只读.
    每人最多领取. per_person_max
     *
     * @mbg.generated 2018-07-19 16:07:25
     */
    @io.swagger.annotations.ApiModelProperty(value = "每人最多领取",name = "perPersonMax", required = false,example = "")
    private Integer perPersonMax;

    /**
     * 只读.
    备注. remark
     *
     * @mbg.generated 2018-07-19 16:07:25
     */
    @io.swagger.annotations.ApiModelProperty(value = "备注",name = "remark", required = false,example = "")
    private String remark;

    /**
     * 只读.
    创建人id. create_user_id
     *
     * @mbg.generated 2018-07-19 16:07:25
     */
    @io.swagger.annotations.ApiModelProperty(value = "创建人id",name = "createUserId", required = false,example = "")
    private Long createUserId;

    /**
     * 只读.
    创建人. create_user_name
     *
     * @mbg.generated 2018-07-19 16:07:25
     */
    @io.swagger.annotations.ApiModelProperty(value = "创建人",name = "createUserName", required = false,example = "")
    private String createUserName;

    /**
     * 只读.
    创建日期. create_date
     *
     * @mbg.generated 2018-07-19 16:07:25
     */
    @io.swagger.annotations.ApiModelProperty(value = "创建日期",name = "createDate", required = false,example = "")
    private Date createDate;

    /**
     * 只读.
    修改人id. modified_user_id
     *
     * @mbg.generated 2018-07-19 16:07:25
     */
    @io.swagger.annotations.ApiModelProperty(value = "修改人id",name = "modifiedUserId", required = false,example = "")
    private Long modifiedUserId;

    /**
     * 只读.
    修改人. modified_user_name
     *
     * @mbg.generated 2018-07-19 16:07:25
     */
    @io.swagger.annotations.ApiModelProperty(value = "修改人",name = "modifiedUserName", required = false,example = "")
    private String modifiedUserName;

    /**
     * 只读.
    修改时间. modified_date
     *
     * @mbg.generated 2018-07-19 16:07:25
     */
    @io.swagger.annotations.ApiModelProperty(value = "修改时间",name = "modifiedDate", required = false,example = "")
    private Date modifiedDate;

    /**
     * 只读.
    数据有效性：1=有效；0=无效. valid
     *
     * @mbg.generated 2018-07-19 16:07:25
     */
    @io.swagger.annotations.ApiModelProperty(value = "数据有效性：1=有效；0=无效",name = "valid", required = false,example = "")
    private Boolean valid;

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-19 16:07:25
     */
    private static final long serialVersionUID = 1L;

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-19 16:07:25
     */
    public Long getMktActivityManualId() {
        return mktActivityManualId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-19 16:07:25
     */
    public void setMktActivityManualId(Long mktActivityManualId) {
        this.mktActivityManualId = mktActivityManualId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-19 16:07:25
     */
    public Long getMktActivityId() {
        return mktActivityId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-19 16:07:25
     */
    public void setMktActivityId(Long mktActivityId) {
        this.mktActivityId = mktActivityId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-19 16:07:25
     */
    public Integer getReceiveType() {
        return receiveType;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-19 16:07:25
     */
    public void setReceiveType(Integer receiveType) {
        this.receiveType = receiveType;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-19 16:07:25
     */
    public Integer getPerPersonPerDayMax() {
        return perPersonPerDayMax;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-19 16:07:25
     */
    public void setPerPersonPerDayMax(Integer perPersonPerDayMax) {
        this.perPersonPerDayMax = perPersonPerDayMax;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-19 16:07:25
     */
    public Integer getPerPersonMax() {
        return perPersonMax;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-19 16:07:25
     */
    public void setPerPersonMax(Integer perPersonMax) {
        this.perPersonMax = perPersonMax;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-19 16:07:25
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-19 16:07:25
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-19 16:07:25
     */
    public Long getCreateUserId() {
        return createUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-19 16:07:25
     */
    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-19 16:07:25
     */
    public String getCreateUserName() {
        return createUserName;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-19 16:07:25
     */
    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-19 16:07:25
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-19 16:07:25
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-19 16:07:25
     */
    public Long getModifiedUserId() {
        return modifiedUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-19 16:07:25
     */
    public void setModifiedUserId(Long modifiedUserId) {
        this.modifiedUserId = modifiedUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-19 16:07:25
     */
    public String getModifiedUserName() {
        return modifiedUserName;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-19 16:07:25
     */
    public void setModifiedUserName(String modifiedUserName) {
        this.modifiedUserName = modifiedUserName == null ? null : modifiedUserName.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-19 16:07:25
     */
    public Date getModifiedDate() {
        return modifiedDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-19 16:07:25
     */
    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-19 16:07:25
     */
    public Boolean getValid() {
        return valid;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-19 16:07:25
     */
    public void setValid(Boolean valid) {
        this.valid = valid;
    }
}