package com.bizvane.mktcenterfacade.models.vo;

import com.bizvane.mktcenterfacade.models.po.MktActivityUpgradePO;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author chen.li
 * @date on 2018/7/13 14:23
 * @description
 *
 */
public class ActivityUpgradeVO extends MktActivityUpgradePO {
    /**
     * 只读. pkid. mkt_activity_id
     * @mbg.generated  2018-07-14 13:26:02
     */
    @io.swagger.annotations.ApiModelProperty(value = "pkid", name = "mktActivityId", required = false, example = "")
    private Long mktActivityId;
    /**
     * 只读. 所属企业id. sys_company_id
     * @mbg.generated  2018-07-14 13:26:02
     */
    @io.swagger.annotations.ApiModelProperty(value = "所属企业id", name = "sysCompanyId", required = false, example = "")
    private Long sysCompanyId;
    /**
     * 只读. 所属品牌id. sys_brand_id
     * @mbg.generated  2018-07-14 13:26:02
     */
    @io.swagger.annotations.ApiModelProperty(value = "所属品牌id", name = "sysBrandId", required = false, example = "")
    private Long sysBrandId;
    /**
     * 只读. 活动编号. activity_code
     * @mbg.generated  2018-07-14 13:26:02
     */
    @io.swagger.annotations.ApiModelProperty(value = "活动编号", name = "activityCode", required = false, example = "")
    private String activityCode;
    /**
     * 只读. 活动类型：1开卡活动，2升级活动，3扫码领券，4手动领券，5消费活动，6签到活动，7生日活动，8智能营销. activity_type
     * @mbg.generated  2018-07-14 13:26:02
     */
    @io.swagger.annotations.ApiModelProperty(value = "活动类型：1开卡活动，2升级活动，3扫码领券，4手动领券，5消费活动，6签到活动，7生日活动，8智能营销", name = "activityType", required = false, example = "")
    private Integer activityType;
    /**
     * 只读. 活动名称. activity_name
     * @mbg.generated  2018-07-14 13:26:02
     */
    @io.swagger.annotations.ApiModelProperty(value = "活动名称", name = "activityName", required = false, example = "")
    private String activityName;
    /**
     * 只读. 活动开始时间. start_time
     * @mbg.generated  2018-07-14 13:26:02
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @io.swagger.annotations.ApiModelProperty(value = "活动开始时间", name = "startTime", required = false, example = "")
    private Date startTime;
    /**
     * 只读. 活动结束时间. end_time
     * @mbg.generated  2018-07-14 13:26:02
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @io.swagger.annotations.ApiModelProperty(value = "活动结束时间", name = "endTime", required = false, example = "")
    private Date endTime;
    /**
     * 只读. 是否长期：1是，0否. long_term
     * @mbg.generated  2018-07-14 13:26:02
     */
    @io.swagger.annotations.ApiModelProperty(value = "是否长期：1是，0否", name = "longTerm", required = false, example = "")
    private Integer longTerm;
    /**
     * 只读. 赠送积分. points
     * @mbg.generated  2018-07-14 13:26:02
     */
    @io.swagger.annotations.ApiModelProperty(value = "赠送积分", name = "points", required = false, example = "")
    private Integer points;
    /**
     * 只读. 审核状态：0全部，1待审核，2审核中，3已审核，4已驳回. check_status
     * @mbg.generated  2018-07-14 13:26:02
     */
    @io.swagger.annotations.ApiModelProperty(value = "审核状态：0全部，1待审核，2审核中，3已审核，4已驳回", name = "checkStatus", required = false, example = "")
    private Integer checkStatus;
    /**
     * 只读. 活动状态：0全部，1待执行，2执行中，3，已禁用4已结束. activity_status
     * @mbg.generated  2018-07-14 13:26:02
     */
    @io.swagger.annotations.ApiModelProperty(value = "活动状态：0全部，1待执行，2执行中，3，已禁用4已结束", name = "activityStatus", required = false, example = "")
    private Integer activityStatus;
    /**
     * 只读. 备注. remark
     * @mbg.generated  2018-07-14 13:26:02
     */
    @io.swagger.annotations.ApiModelProperty(value = "备注", name = "remark", required = false, example = "")
    private String remark;
    /**
     * 只读. 创建人id. create_user_id
     * @mbg.generated  2018-07-14 13:26:02
     */
    @io.swagger.annotations.ApiModelProperty(value = "创建人id", name = "createUserId", required = false, example = "")
    private Long createUserId;
    /**
     * 只读. 创建人. create_user_name
     * @mbg.generated  2018-07-14 13:26:02
     */
    @io.swagger.annotations.ApiModelProperty(value = "创建人", name = "createUserName", required = false, example = "")
    private String createUserName;
    /**
     * 只读. 创建日期. create_date
     * @mbg.generated  2018-07-14 13:26:02
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @io.swagger.annotations.ApiModelProperty(value = "创建日期", name = "createDate", required = false, example = "")
    private Date createDate;
    /**
     * 只读. 修改人id. modified_user_id
     * @mbg.generated  2018-07-14 13:26:02
     */
    @io.swagger.annotations.ApiModelProperty(value = "修改人id", name = "modifiedUserId", required = false, example = "")
    private Long modifiedUserId;
    /**
     * 只读. 修改人. modified_user_name
     * @mbg.generated  2018-07-14 13:26:02
     */
    @io.swagger.annotations.ApiModelProperty(value = "修改人", name = "modifiedUserName", required = false, example = "")
    private String modifiedUserName;
    /**
     * 只读. 修改时间. modified_date
     * @mbg.generated  2018-07-14 13:26:02
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @io.swagger.annotations.ApiModelProperty(value = "修改时间", name = "modifiedDate", required = false, example = "")
    private Date modifiedDate;
    /**
     * 只读. 数据有效性：1=有效；0=无效. valid
     * @mbg.generated  2018-07-14 13:26:02
     */
    @io.swagger.annotations.ApiModelProperty(value = "数据有效性：1=有效；0=无效", name = "valid", required = false, example = "")
    private Boolean valid;
    /**
     * 只读.
     * @mbg.generated  2018-07-14 13:26:02
     */
    private static final long serialVersionUID = 1L;

    /**
     * 只读.
     * @mbg.generated  2018-07-14 13:26:02
     */
    public Long getMktActivityId() {
        return mktActivityId;
    }

    /**
     * 只读.
     * @mbg.generated  2018-07-14 13:26:02
     */
    public void setMktActivityId(Long mktActivityId) {
        this.mktActivityId = mktActivityId;
    }

    /**
     * 只读.
     * @mbg.generated  2018-07-14 13:26:02
     */
    public Long getSysCompanyId() {
        return sysCompanyId;
    }

    /**
     * 只读.
     * @mbg.generated  2018-07-14 13:26:02
     */
    public void setSysCompanyId(Long sysCompanyId) {
        this.sysCompanyId = sysCompanyId;
    }

    /**
     * 只读.
     * @mbg.generated  2018-07-14 13:26:02
     */
    public Long getSysBrandId() {
        return sysBrandId;
    }

    /**
     * 只读.
     * @mbg.generated  2018-07-14 13:26:02
     */
    public void setSysBrandId(Long sysBrandId) {
        this.sysBrandId = sysBrandId;
    }

    /**
     * 只读.
     * @mbg.generated  2018-07-14 13:26:02
     */
    public String getActivityCode() {
        return activityCode;
    }

    /**
     * 只读.
     * @mbg.generated  2018-07-14 13:26:02
     */
    public void setActivityCode(String activityCode) {
        this.activityCode = activityCode == null ? null : activityCode.trim();
    }

    /**
     * 只读.
     * @mbg.generated  2018-07-14 13:26:02
     */
    public Integer getActivityType() {
        return activityType;
    }

    /**
     * 只读.
     * @mbg.generated  2018-07-14 13:26:02
     */
    public void setActivityType(Integer activityType) {
        this.activityType = activityType;
    }

    /**
     * 只读.
     * @mbg.generated  2018-07-14 13:26:02
     */
    public String getActivityName() {
        return activityName;
    }

    /**
     * 只读.
     * @mbg.generated  2018-07-14 13:26:02
     */
    public void setActivityName(String activityName) {
        this.activityName = activityName == null ? null : activityName.trim();
    }

    /**
     * 只读.
     * @mbg.generated  2018-07-14 13:26:02
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 只读.
     * @mbg.generated  2018-07-14 13:26:02
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 只读.
     * @mbg.generated  2018-07-14 13:26:02
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 只读.
     * @mbg.generated  2018-07-14 13:26:02
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 只读.
     * @mbg.generated  2018-07-14 13:26:02
     */
    public Integer getLongTerm() {
        return longTerm;
    }

    /**
     * 只读.
     * @mbg.generated  2018-07-14 13:26:02
     */
    public void setLongTerm(Integer longTerm) {
        this.longTerm = longTerm;
    }

    /**
     * 只读.
     * @mbg.generated  2018-07-14 13:26:02
     */
    public Integer getPoints() {
        return points;
    }

    /**
     * 只读.
     * @mbg.generated  2018-07-14 13:26:02
     */
    public void setPoints(Integer points) {
        this.points = points;
    }

    /**
     * 只读.
     * @mbg.generated  2018-07-14 13:26:02
     */
    public Integer getCheckStatus() {
        return checkStatus;
    }

    /**
     * 只读.
     * @mbg.generated  2018-07-14 13:26:02
     */
    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

    /**
     * 只读.
     * @mbg.generated  2018-07-14 13:26:02
     */
    public Integer getActivityStatus() {
        return activityStatus;
    }

    /**
     * 只读.
     * @mbg.generated  2018-07-14 13:26:02
     */
    public void setActivityStatus(Integer activityStatus) {
        this.activityStatus = activityStatus;
    }

    /**
     * 只读.
     * @mbg.generated  2018-07-14 13:26:02
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 只读.
     * @mbg.generated  2018-07-14 13:26:02
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 只读.
     * @mbg.generated  2018-07-14 13:26:02
     */
    public Long getCreateUserId() {
        return createUserId;
    }

    /**
     * 只读.
     * @mbg.generated  2018-07-14 13:26:02
     */
    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * 只读.
     * @mbg.generated  2018-07-14 13:26:02
     */
    public String getCreateUserName() {
        return createUserName;
    }

    /**
     * 只读.
     * @mbg.generated  2018-07-14 13:26:02
     */
    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }

    /**
     * 只读.
     * @mbg.generated  2018-07-14 13:26:02
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 只读.
     * @mbg.generated  2018-07-14 13:26:02
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 只读.
     * @mbg.generated  2018-07-14 13:26:02
     */
    public Long getModifiedUserId() {
        return modifiedUserId;
    }

    /**
     * 只读.
     * @mbg.generated  2018-07-14 13:26:02
     */
    public void setModifiedUserId(Long modifiedUserId) {
        this.modifiedUserId = modifiedUserId;
    }

    /**
     * 只读.
     * @mbg.generated  2018-07-14 13:26:02
     */
    public String getModifiedUserName() {
        return modifiedUserName;
    }

    /**
     * 只读.
     * @mbg.generated  2018-07-14 13:26:02
     */
    public void setModifiedUserName(String modifiedUserName) {
        this.modifiedUserName = modifiedUserName == null ? null : modifiedUserName.trim();
    }

    /**
     * 只读.
     * @mbg.generated  2018-07-14 13:26:02
     */
    public Date getModifiedDate() {
        return modifiedDate;
    }

    /**
     * 只读.
     * @mbg.generated  2018-07-14 13:26:02
     */
    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    /**
     * 只读.
     * @mbg.generated  2018-07-14 13:26:02
     */
    public Boolean getValid() {
        return valid;
    }

    /**
     * 只读.
     * @mbg.generated  2018-07-14 13:26:02
     */
    public void setValid(Boolean valid) {
        this.valid = valid;
    }
}
