package com.bizvane.mktcenterservice.models.vo;

import com.bizvane.mktcenterservice.models.po.MktActivityPO;
import com.bizvane.mktcenterservice.models.po.MktActivitySmartPO;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

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
     预计目标会员统计. target_mbr_count
     *
     * @mbg.generated 2018-08-02 20:38:44
     */
    @io.swagger.annotations.ApiModelProperty(value = "预计目标会员统计",name = "targetMbrCount", required = false,example = "")
    private Integer targetMbrCount;

    /**
     * 只读.
     预计目标会员数量的统计时间. target_mbr_count_time
     *
     * @mbg.generated 2018-08-02 20:38:44
     */
    @io.swagger.annotations.ApiModelProperty(value = "预计目标会员数量的统计时间",name = "targetMbrCountTime", required = false,example = "")
    private Date targetMbrCountTime;

    /**
     * 只读.
     分组状态：0禁用，1启用. status
     *
     * @mbg.generated 2018-08-02 20:38:44
     */
    @io.swagger.annotations.ApiModelProperty(value = "分组状态：0禁用，1启用",name = "status", required = false,example = "")
    private Boolean status;

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

    @Override
    public Integer getTargetMbrCount() {
        return targetMbrCount;
    }

    @Override
    public void setTargetMbrCount(Integer targetMbrCount) {
        this.targetMbrCount = targetMbrCount;
    }

    @Override
    public Date getTargetMbrCountTime() {
        return targetMbrCountTime;
    }

    @Override
    public void setTargetMbrCountTime(Date targetMbrCountTime) {
        this.targetMbrCountTime = targetMbrCountTime;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
