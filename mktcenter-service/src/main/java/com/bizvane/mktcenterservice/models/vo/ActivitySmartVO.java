package com.bizvane.mktcenterservice.models.vo;

import com.bizvane.mktcenterservice.models.po.MktActivityPO;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author chen.li
 * @date on 2018/7/13 14:22
 * @description 智能营销活动VO
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
public class ActivitySmartVO extends MktActivityPO {
    /**
     * 只读. 营销方式：1优惠券营销，2积分营销，3短信营销，4微信模板消息营销. mkt_type
     * @mbg.generated  2018-07-27 20:48:29
     */
    @io.swagger.annotations.ApiModelProperty(value = "营销方式：1优惠券营销，2积分营销，3短信营销，4微信模板消息营销", name = "mktType", required = false, example = "")
    private Integer mktType;
    /**
     * 只读. 会员分组id. member_group_id
     * @mbg.generated  2018-07-27 20:48:29
     */
    @io.swagger.annotations.ApiModelProperty(value = "会员分组id", name = "memberGroupId", required = false, example = "")
    private Long memberGroupId;
    /**
     * 只读. 会员分组编号. member_group_code
     * @mbg.generated  2018-07-27 20:48:29
     */
    @io.swagger.annotations.ApiModelProperty(value = "会员分组编号", name = "memberGroupCode", required = false, example = "")
    private String memberGroupCode;
    /**
     * 只读. 预计目标会员统计. target_mbr_count
     * @mbg.generated  2018-07-27 20:48:29
     */
    @io.swagger.annotations.ApiModelProperty(value = "预计目标会员统计", name = "targetMbrCount", required = false, example = "")
    private Integer targetMbrCount;
    /**
     * 只读. 预计目标会员数量的统计时间. target_mbr_count_time
     * @mbg.generated  2018-07-27 20:48:29
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @io.swagger.annotations.ApiModelProperty(value = "预计目标会员数量的统计时间", name = "targetMbrCountTime", required = false, example = "")
    private Date targetMbrCountTime;
    /**
     * 只读. 目标会员在会员模块中的搜索条件. target_mbr
     * @mbg.generated  2018-07-27 20:48:29
     */
    @io.swagger.annotations.ApiModelProperty(value = "目标会员在会员模块中的搜索条件", name = "targetMbr", required = false, example = "")
    private String targetMbr;

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

    /**
     * 活动描述
     */
    private String activityInfo;

    /**
     * 活动任务名称
     */
    private String mktTaskName;


    private Integer pageNumber =1;

    private Integer pageSize =10;

    /**
     * 状态： 1启用，0禁用
     */
    private Integer status;

    /**
     * pkid
     */
    private Long mktActivitySmartId;

    public Integer getMktType() {
        return mktType;
    }

    public void setMktType(Integer mktType) {
        this.mktType = mktType;
    }

    public Long getMemberGroupId() {
        return memberGroupId;
    }

    public void setMemberGroupId(Long memberGroupId) {
        this.memberGroupId = memberGroupId;
    }

    public String getMemberGroupCode() {
        return memberGroupCode;
    }

    public void setMemberGroupCode(String memberGroupCode) {
        this.memberGroupCode = memberGroupCode;
    }

    public Integer getTargetMbrCount() {
        return targetMbrCount;
    }

    public void setTargetMbrCount(Integer targetMbrCount) {
        this.targetMbrCount = targetMbrCount;
    }

    public Date getTargetMbrCountTime() {
        return targetMbrCountTime;
    }

    public void setTargetMbrCountTime(Date targetMbrCountTime) {
        this.targetMbrCountTime = targetMbrCountTime;
    }

    public String getTargetMbr() {
        return targetMbr;
    }

    public void setTargetMbr(String targetMbr) {
        this.targetMbr = targetMbr;
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

    public String getActivityInfo() {
        return activityInfo;
    }

    public void setActivityInfo(String activityInfo) {
        this.activityInfo = activityInfo;
    }

    public String getMktTaskName() {
        return mktTaskName;
    }

    public void setMktTaskName(String mktTaskName) {
        this.mktTaskName = mktTaskName;
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

    public Long getMktActivitySmartId() {
        return mktActivitySmartId;
    }

    public void setMktActivitySmartId(Long mktActivitySmartId) {
        this.mktActivitySmartId = mktActivitySmartId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
