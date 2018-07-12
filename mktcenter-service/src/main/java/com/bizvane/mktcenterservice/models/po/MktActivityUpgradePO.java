package com.bizvane.mktcenterservice.models.po;

import java.io.Serializable;
import java.util.Date;

public class MktActivityUpgradePO implements Serializable {
    /**
     * 只读.
    pkid. mkt_activity_upgrade_id
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    @io.swagger.annotations.ApiModelProperty(value = "pkid",name = "mktActivityUpgradeId", required = false,example = "")
    private Long mktActivityUpgradeId;

    /**
     * 只读.
    关联活动id. mkt_activity_id
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    @io.swagger.annotations.ApiModelProperty(value = "关联活动id",name = "mktActivityId", required = false,example = "")
    private Long mktActivityId;

    /**
     * 只读.
    当前会员等级编号. current_level_code
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    @io.swagger.annotations.ApiModelProperty(value = "当前会员等级编号",name = "currentLevelCode", required = false,example = "")
    private String currentLevelCode;

    /**
     * 只读.
    当前会员等级名称. current_level_name
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    @io.swagger.annotations.ApiModelProperty(value = "当前会员等级名称",name = "currentLevelName", required = false,example = "")
    private String currentLevelName;

    /**
     * 只读.
    目标会员等级编号. target_level_code
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    @io.swagger.annotations.ApiModelProperty(value = "目标会员等级编号",name = "targetLevelCode", required = false,example = "")
    private String targetLevelCode;

    /**
     * 只读.
    目标会员等级名称. target_level_name
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    @io.swagger.annotations.ApiModelProperty(value = "目标会员等级名称",name = "targetLevelName", required = false,example = "")
    private String targetLevelName;

    /**
     * 只读.
    是否针对粉丝：0否，1是. fans
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    @io.swagger.annotations.ApiModelProperty(value = "是否针对粉丝：0否，1是",name = "fans", required = false,example = "")
    private Integer fans;

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
    public Long getMktActivityUpgradeId() {
        return mktActivityUpgradeId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    public void setMktActivityUpgradeId(Long mktActivityUpgradeId) {
        this.mktActivityUpgradeId = mktActivityUpgradeId;
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
    public String getCurrentLevelCode() {
        return currentLevelCode;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    public void setCurrentLevelCode(String currentLevelCode) {
        this.currentLevelCode = currentLevelCode == null ? null : currentLevelCode.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    public String getCurrentLevelName() {
        return currentLevelName;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    public void setCurrentLevelName(String currentLevelName) {
        this.currentLevelName = currentLevelName == null ? null : currentLevelName.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    public String getTargetLevelCode() {
        return targetLevelCode;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    public void setTargetLevelCode(String targetLevelCode) {
        this.targetLevelCode = targetLevelCode == null ? null : targetLevelCode.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    public String getTargetLevelName() {
        return targetLevelName;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    public void setTargetLevelName(String targetLevelName) {
        this.targetLevelName = targetLevelName == null ? null : targetLevelName.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    public Integer getFans() {
        return fans;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    public void setFans(Integer fans) {
        this.fans = fans;
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