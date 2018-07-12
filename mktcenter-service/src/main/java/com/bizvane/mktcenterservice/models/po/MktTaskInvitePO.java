package com.bizvane.mktcenterservice.models.po;

import java.io.Serializable;
import java.util.Date;

public class MktTaskInvitePO implements Serializable {
    /**
     * 只读.
    pkid. mkt_task_profile_id
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    @io.swagger.annotations.ApiModelProperty(value = "pkid",name = "mktTaskProfileId", required = false,example = "")
    private Long mktTaskProfileId;

    /**
     * 只读.
    关联活动id. mkt_task_id
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    @io.swagger.annotations.ApiModelProperty(value = "关联活动id",name = "mktTaskId", required = false,example = "")
    private Long mktTaskId;

    /**
     * 只读.
    任务限制的参与会员等级编号. mbr_level_code
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    @io.swagger.annotations.ApiModelProperty(value = "任务限制的参与会员等级编号",name = "mbrLevelCode", required = false,example = "")
    private String mbrLevelCode;

    /**
     * 只读.
    任务限制的参与会员等级名称. mbr_level_name
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    @io.swagger.annotations.ApiModelProperty(value = "任务限制的参与会员等级名称",name = "mbrLevelName", required = false,example = "")
    private String mbrLevelName;

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
    需要完善的字段code，逗号分隔. property_code
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    @io.swagger.annotations.ApiModelProperty(value = "需要完善的字段code，逗号分隔",name = "propertyCode", required = false,example = "")
    private String propertyCode;

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
    public Long getMktTaskProfileId() {
        return mktTaskProfileId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    public void setMktTaskProfileId(Long mktTaskProfileId) {
        this.mktTaskProfileId = mktTaskProfileId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    public Long getMktTaskId() {
        return mktTaskId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    public void setMktTaskId(Long mktTaskId) {
        this.mktTaskId = mktTaskId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    public String getMbrLevelCode() {
        return mbrLevelCode;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    public void setMbrLevelCode(String mbrLevelCode) {
        this.mbrLevelCode = mbrLevelCode == null ? null : mbrLevelCode.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    public String getMbrLevelName() {
        return mbrLevelName;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    public void setMbrLevelName(String mbrLevelName) {
        this.mbrLevelName = mbrLevelName == null ? null : mbrLevelName.trim();
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

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    public String getPropertyCode() {
        return propertyCode;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    public void setPropertyCode(String propertyCode) {
        this.propertyCode = propertyCode == null ? null : propertyCode.trim();
    }
}