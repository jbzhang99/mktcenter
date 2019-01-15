package com.bizvane.mktcenterservice.models.po;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class MktActivityStatisticsPO implements Serializable {
    /**
     * 只读.
    主键. mkt_activity_statistics_id
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    @io.swagger.annotations.ApiModelProperty(value = "主键",name = "mktActivityStatisticsId", required = false,example = "")
    private Long mktActivityStatisticsId;

    /**
     * 只读.
    所属企业id. sys_company_id
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    @io.swagger.annotations.ApiModelProperty(value = "所属企业id",name = "sysCompanyId", required = false,example = "")
    private Long sysCompanyId;

    /**
     * 只读.
    所属品牌id. sys_brand_id
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    @io.swagger.annotations.ApiModelProperty(value = "所属品牌id",name = "sysBrandId", required = false,example = "")
    private Long sysBrandId;

    /**
     * 只读.
    活动id. mkt_activity_id
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    @io.swagger.annotations.ApiModelProperty(value = "活动id",name = "mktActivityId", required = false,example = "")
    private Long mktActivityId;

    /**
     * 只读.
    访问人数. visitors_count
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    @io.swagger.annotations.ApiModelProperty(value = "访问人数",name = "visitorsCount", required = false,example = "")
    private Integer visitorsCount;

    /**
     * 只读.
    发起会员人数. launch_members_count
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    @io.swagger.annotations.ApiModelProperty(value = "发起会员人数",name = "launchMembersCount", required = false,example = "")
    private Integer launchMembersCount;

    /**
     * 只读.
    助力会员人数. help_members_count
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    @io.swagger.annotations.ApiModelProperty(value = "助力会员人数",name = "helpMembersCount", required = false,example = "")
    private Integer helpMembersCount;

    /**
     * 只读.
    注册会员人数. register_members_count
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    @io.swagger.annotations.ApiModelProperty(value = "注册会员人数",name = "registerMembersCount", required = false,example = "")
    private Integer registerMembersCount;

    /**
     * 只读.
    领劵数量. take_coupon_count
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    @io.swagger.annotations.ApiModelProperty(value = "领劵数量",name = "takeCouponCount", required = false,example = "")
    private Long takeCouponCount;

    /**
     * 只读.
    统计时间. statistics_time
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    @io.swagger.annotations.ApiModelProperty(value = "统计时间",name = "statisticsTime", required = false,example = "")
    private Date statisticsTime;

    /**
     * 只读.
    统计类型 0红包 其他的以后再说. statistics_type
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    @io.swagger.annotations.ApiModelProperty(value = "统计类型 0红包 其他的以后再说",name = "statisticsType", required = false,example = "")
    private String statisticsType;

    /**
     * 只读.
    预留字段1. other1
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    @io.swagger.annotations.ApiModelProperty(value = "预留字段1",name = "other1", required = false,example = "")
    private String other1;

    /**
     * 只读.
    预留字段2. other2
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    @io.swagger.annotations.ApiModelProperty(value = "预留字段2",name = "other2", required = false,example = "")
    private String other2;

    /**
     * 只读.
    预留字段3. other3
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    @io.swagger.annotations.ApiModelProperty(value = "预留字段3",name = "other3", required = false,example = "")
    private String other3;

    /**
     * 只读.
    小时json数据. hour_json_data
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    @io.swagger.annotations.ApiModelProperty(value = "小时json数据",name = "hourJsonData", required = false,example = "")
    private String hourJsonData;

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    private static final long serialVersionUID = 1L;

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public Long getMktActivityStatisticsId() {
        return mktActivityStatisticsId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public void setMktActivityStatisticsId(Long mktActivityStatisticsId) {
        this.mktActivityStatisticsId = mktActivityStatisticsId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public Long getSysCompanyId() {
        return sysCompanyId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public void setSysCompanyId(Long sysCompanyId) {
        this.sysCompanyId = sysCompanyId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public Long getSysBrandId() {
        return sysBrandId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public void setSysBrandId(Long sysBrandId) {
        this.sysBrandId = sysBrandId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public Long getMktActivityId() {
        return mktActivityId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public void setMktActivityId(Long mktActivityId) {
        this.mktActivityId = mktActivityId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public Integer getVisitorsCount() {
        return visitorsCount;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public void setVisitorsCount(Integer visitorsCount) {
        this.visitorsCount = visitorsCount;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public Integer getLaunchMembersCount() {
        return launchMembersCount;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public void setLaunchMembersCount(Integer launchMembersCount) {
        this.launchMembersCount = launchMembersCount;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public Integer getHelpMembersCount() {
        return helpMembersCount;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public void setHelpMembersCount(Integer helpMembersCount) {
        this.helpMembersCount = helpMembersCount;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public Integer getRegisterMembersCount() {
        return registerMembersCount;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public void setRegisterMembersCount(Integer registerMembersCount) {
        this.registerMembersCount = registerMembersCount;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public Long getTakeCouponCount() {
        return takeCouponCount;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public void setTakeCouponCount(Long takeCouponCount) {
        this.takeCouponCount = takeCouponCount;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public Date getStatisticsTime() {
        return statisticsTime;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public void setStatisticsTime(Date statisticsTime) {
        this.statisticsTime = statisticsTime;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public String getStatisticsType() {
        return statisticsType;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public void setStatisticsType(String statisticsType) {
        this.statisticsType = statisticsType == null ? null : statisticsType.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public String getOther1() {
        return other1;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public void setOther1(String other1) {
        this.other1 = other1 == null ? null : other1.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public String getOther2() {
        return other2;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public void setOther2(String other2) {
        this.other2 = other2 == null ? null : other2.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public String getOther3() {
        return other3;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public void setOther3(String other3) {
        this.other3 = other3 == null ? null : other3.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public String getHourJsonData() {
        return hourJsonData;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    public void setHourJsonData(String hourJsonData) {
        this.hourJsonData = hourJsonData == null ? null : hourJsonData.trim();
    }
}