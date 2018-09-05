package com.bizvane.mktcenterservice.models.vo;

import com.bizvane.mktcenterservice.models.po.MktActivityPO;
import com.bizvane.mktcenterservice.models.po.MktActivitySmartPO;
import com.bizvane.mktcenterservice.models.po.MktCouponPO;
import com.bizvane.mktcenterservice.models.po.MktMessagePO;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

/**
 * @author chen.li
 * @date on 2018/7/13 14:22
 * @description 智能营销活动VO
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
public class ActivitySmartVO extends MktActivitySmartPO {

    /**
     * 创建时间开始
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date createDateStart;

    /**
     * 创建时间结束
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date createDateEnd;


    private Integer pageNumber =1;

    private Integer pageSize =10;

    /**
     * 开始日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date startTime;

    /**
     * 结束日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date endTime;

    /**
     * 只读.
     营销名称/分组名称. member_group_name
     *
     * @mbg.generated 2018-08-02 20:38:44
     */
    @io.swagger.annotations.ApiModelProperty(value = "营销名称/分组名称",name = "memberGroupName", required = false,example = "")
    private String memberGroupName;

    /**
     * 只读.
     pkid. mkt_activity_smart_group_id
     *
     * @mbg.generated 2018-08-02 20:38:44
     */
    @io.swagger.annotations.ApiModelProperty(value = "pkid",name = "mktActivitySmartGroupId", required = false,example = "")
    private Long mktActivitySmartGroupId;

    /**
     * 只读.
     会员模块分组编号. member_group_code
     *
     * @mbg.generated 2018-08-02 20:38:44
     */
    @io.swagger.annotations.ApiModelProperty(value = "会员模块分组编号",name = "memberGroupCode", required = false,example = "")
    private String memberGroupCode;

    /**
     * 只读.
     分组状态：0禁用，1启用. status
     *
     * @mbg.generated 2018-08-02 20:38:44
     */
    @io.swagger.annotations.ApiModelProperty(value = "分组状态：0禁用，1启用",name = "status", required = false,example = "")
    private Boolean status;

    /**
     * 优惠券对象列表
     */
    private List<MktCouponPO> mktCouponPOS;

    /**
     * 只读. 所属品牌id. sys_brand_id
     * @mbg.generated  2018-08-02 20:38:44
     */
    @io.swagger.annotations.ApiModelProperty(value = "所属品牌id", name = "sysBrandId", required = false, example = "")
    private Long sysBrandId;

    /**
     * 只读. 活动编号. activity_code
     * @mbg.generated  2018-08-02 20:38:44
     */
    @io.swagger.annotations.ApiModelProperty(value = "活动编号", name = "activityCode", required = false, example = "")
    private String activityCode;
    /**
     * 只读. 活动类型：1开卡活动，2升级活动，3扫码领券，4手动领券，5消费活动，6签到活动，7生日活动，8智能营销. activity_type
     * @mbg.generated  2018-08-02 20:38:44
     */
    @io.swagger.annotations.ApiModelProperty(value = "活动类型：1开卡活动，2升级活动，3扫码领券，4手动领券，5消费活动，6签到活动，7生日活动，8智能营销", name = "activityType", required = false, example = "")
    private Integer activityType;
    /**
     * 只读. 活动名称. activity_name
     * @mbg.generated  2018-08-02 20:38:44
     */
    @io.swagger.annotations.ApiModelProperty(value = "活动名称", name = "activityName", required = false, example = "")
    private String activityName;

    /**
     * 只读. 是否长期：1是，0否. long_term
     * @mbg.generated  2018-08-02 20:38:44
     */
    @io.swagger.annotations.ApiModelProperty(value = "是否长期：1是，0否", name = "longTerm", required = false, example = "")
    private Integer longTerm;
    /**
     * 只读. 赠送积分. points
     * @mbg.generated  2018-08-02 20:38:44
     */
    @io.swagger.annotations.ApiModelProperty(value = "赠送积分", name = "points", required = false, example = "")
    private Integer points;
    /**
     * 只读. 审核状态：0全部，1待审核，2审核中，3已审核，4已驳回. check_status
     * @mbg.generated  2018-08-02 20:38:44
     */
    @io.swagger.annotations.ApiModelProperty(value = "审核状态：0全部，1待审核，2审核中，3已审核，4已驳回", name = "checkStatus", required = false, example = "")
    private Integer checkStatus;
    /**
     * 只读. 活动状态：0全部，1待执行，2执行中，3已结束. activity_status
     * @mbg.generated  2018-08-02 20:38:44
     */
    @io.swagger.annotations.ApiModelProperty(value = "活动状态：0全部，1待执行，2执行中，3已结束", name = "activityStatus", required = false, example = "")
    private Integer activityStatus;


    /**
     * 只读. 活动描述、简介. activity_info
     * @mbg.generated  2018-08-02 20:38:44
     */
    @io.swagger.annotations.ApiModelProperty(value = "活动描述、简介", name = "activityInfo", required = false, example = "")
    private String activityInfo;

    /**
     * 消息对象
     */
    private MktMessagePO mktMessagePO;

    /**
     * 区分是中控调用还是营销模块列表
     */
    private Integer type;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getCreateDateStart() {
        return createDateStart;
    }

    public void setCreateDateStart(Date createDateStart) {
        this.createDateStart = createDateStart;
    }

    public Date getCreateDateEnd() {
        return createDateEnd;
    }

    public void setCreateDateEnd(Date createDateEnd) {
        this.createDateEnd = createDateEnd;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getMemberGroupName() {
        return memberGroupName;
    }

    public void setMemberGroupName(String memberGroupName) {
        this.memberGroupName = memberGroupName;
    }

    public Long getMktActivitySmartGroupId() {
        return mktActivitySmartGroupId;
    }

    public void setMktActivitySmartGroupId(Long mktActivitySmartGroupId) {
        this.mktActivitySmartGroupId = mktActivitySmartGroupId;
    }

    public String getMemberGroupCode() {
        return memberGroupCode;
    }

    public void setMemberGroupCode(String memberGroupCode) {
        this.memberGroupCode = memberGroupCode;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<MktCouponPO> getMktCouponPOS() {
        return mktCouponPOS;
    }

    public void setMktCouponPOS(List<MktCouponPO> mktCouponPOS) {
        this.mktCouponPOS = mktCouponPOS;
    }

    public Long getSysBrandId() {
        return sysBrandId;
    }

    public void setSysBrandId(Long sysBrandId) {
        this.sysBrandId = sysBrandId;
    }

    public String getActivityCode() {
        return activityCode;
    }

    public void setActivityCode(String activityCode) {
        this.activityCode = activityCode;
    }

    public Integer getActivityType() {
        return activityType;
    }

    public void setActivityType(Integer activityType) {
        this.activityType = activityType;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Integer getLongTerm() {
        return longTerm;
    }

    public void setLongTerm(Integer longTerm) {
        this.longTerm = longTerm;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

    public Integer getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(Integer activityStatus) {
        this.activityStatus = activityStatus;
    }

    public String getActivityInfo() {
        return activityInfo;
    }

    public void setActivityInfo(String activityInfo) {
        this.activityInfo = activityInfo;
    }

    public MktMessagePO getMktMessagePO() {
        return mktMessagePO;
    }

    public void setMktMessagePO(MktMessagePO mktMessagePO) {
        this.mktMessagePO = mktMessagePO;
    }
}
