package com.bizvane.mktcenterfacade.models.po;

import java.io.Serializable;
import java.util.Date;

public class MktGoldenStatisticsPO implements Serializable {
    /**
     * 只读.
    . mkt_golden_statistics_id
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    @io.swagger.annotations.ApiModelProperty(value = "",name = "mktGoldenStatisticsId", required = false,example = "")
    private Long mktGoldenStatisticsId;

    /**
     * 只读.
    企业id. sys_company_id
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    @io.swagger.annotations.ApiModelProperty(value = "企业id",name = "sysCompanyId", required = false,example = "")
    private Long sysCompanyId;

    /**
     * 只读.
    品牌id. sys_brand_id
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    @io.swagger.annotations.ApiModelProperty(value = "品牌id",name = "sysBrandId", required = false,example = "")
    private Long sysBrandId;

    /**
     * 只读.
    活动id. mkt_activity_id
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    @io.swagger.annotations.ApiModelProperty(value = "活动id",name = "mktActivityId", required = false,example = "")
    private Long mktActivityId;

    /**
     * 只读.
    访问人数. visitors_count
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    @io.swagger.annotations.ApiModelProperty(value = "访问人数",name = "visitorsCount", required = false,example = "")
    private Integer visitorsCount;

    /**
     * 只读.
    参与会员数. participate_member_count
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    @io.swagger.annotations.ApiModelProperty(value = "参与会员数",name = "participateMemberCount", required = false,example = "")
    private Integer participateMemberCount;

    /**
     * 只读.
    页面转发次数. page_forward_count
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    @io.swagger.annotations.ApiModelProperty(value = "页面转发次数",name = "pageForwardCount", required = false,example = "")
    private Integer pageForwardCount;

    /**
     * 只读.
    有效分享人数. effective_sharing_count
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    @io.swagger.annotations.ApiModelProperty(value = "有效分享人数",name = "effectiveSharingCount", required = false,example = "")
    private Integer effectiveSharingCount;

    /**
     * 只读.
    注册会员数. register_members_count
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    @io.swagger.annotations.ApiModelProperty(value = "注册会员数",name = "registerMembersCount", required = false,example = "")
    private Integer registerMembersCount;

    /**
     * 只读.
    累计访问人数. total_visitors_count
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    @io.swagger.annotations.ApiModelProperty(value = "累计访问人数",name = "totalVisitorsCount", required = false,example = "")
    private Integer totalVisitorsCount;

    /**
     * 只读.
    累计参与会员数. total_participate_member_count
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    @io.swagger.annotations.ApiModelProperty(value = "累计参与会员数",name = "totalParticipateMemberCount", required = false,example = "")
    private Integer totalParticipateMemberCount;

    /**
     * 只读.
    累计页面转发次数. total_page_forward_count
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    @io.swagger.annotations.ApiModelProperty(value = "累计页面转发次数",name = "totalPageForwardCount", required = false,example = "")
    private Integer totalPageForwardCount;

    /**
     * 只读.
    累计有效分享人数. total_effective_sharing_count
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    @io.swagger.annotations.ApiModelProperty(value = "累计有效分享人数",name = "totalEffectiveSharingCount", required = false,example = "")
    private Integer totalEffectiveSharingCount;

    /**
     * 只读.
    累计注册会员数. total_register_members_count
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    @io.swagger.annotations.ApiModelProperty(value = "累计注册会员数",name = "totalRegisterMembersCount", required = false,example = "")
    private Integer totalRegisterMembersCount;

    /**
     * 只读.
    统计时间. statistics_time
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    @io.swagger.annotations.ApiModelProperty(value = "统计时间",name = "statisticsTime", required = false,example = "")
    private Date statisticsTime;

    /**
     * 只读.
    类型 1:砸金蛋. statistics_type
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    @io.swagger.annotations.ApiModelProperty(value = "类型 1:砸金蛋",name = "statisticsType", required = false,example = "")
    private String statisticsType;

    /**
     * 只读.
    备注. remark
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    @io.swagger.annotations.ApiModelProperty(value = "备注",name = "remark", required = false,example = "")
    private String remark;

    /**
     * 只读.
    创建人id. create_user_id
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    @io.swagger.annotations.ApiModelProperty(value = "创建人id",name = "createUserId", required = false,example = "")
    private Long createUserId;

    /**
     * 只读.
    创建人名. create_user_name
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    @io.swagger.annotations.ApiModelProperty(value = "创建人名",name = "createUserName", required = false,example = "")
    private String createUserName;

    /**
     * 只读.
    创建时间. create_date
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    @io.swagger.annotations.ApiModelProperty(value = "创建时间",name = "createDate", required = false,example = "")
    private Date createDate;

    /**
     * 只读.
    修改人id. modified_user_id
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    @io.swagger.annotations.ApiModelProperty(value = "修改人id",name = "modifiedUserId", required = false,example = "")
    private Long modifiedUserId;

    /**
     * 只读.
    修改人名. modified_user_name
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    @io.swagger.annotations.ApiModelProperty(value = "修改人名",name = "modifiedUserName", required = false,example = "")
    private String modifiedUserName;

    /**
     * 只读.
    修改时间. modified_date
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    @io.swagger.annotations.ApiModelProperty(value = "修改时间",name = "modifiedDate", required = false,example = "")
    private Date modifiedDate;

    /**
     * 只读.
    数据有效性：1=有效；0=无效. valid
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    @io.swagger.annotations.ApiModelProperty(value = "数据有效性：1=有效；0=无效",name = "valid", required = false,example = "")
    private Boolean valid;

    /**
     * 只读.
    小时json数据. hour_json_data
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    @io.swagger.annotations.ApiModelProperty(value = "小时json数据",name = "hourJsonData", required = false,example = "")
    private String hourJsonData;

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    private static final long serialVersionUID = 1L;

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    public Long getMktGoldenStatisticsId() {
        return mktGoldenStatisticsId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    public void setMktGoldenStatisticsId(Long mktGoldenStatisticsId) {
        this.mktGoldenStatisticsId = mktGoldenStatisticsId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    public Long getSysCompanyId() {
        return sysCompanyId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    public void setSysCompanyId(Long sysCompanyId) {
        this.sysCompanyId = sysCompanyId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    public Long getSysBrandId() {
        return sysBrandId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    public void setSysBrandId(Long sysBrandId) {
        this.sysBrandId = sysBrandId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    public Long getMktActivityId() {
        return mktActivityId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    public void setMktActivityId(Long mktActivityId) {
        this.mktActivityId = mktActivityId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    public Integer getVisitorsCount() {
        return visitorsCount;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    public void setVisitorsCount(Integer visitorsCount) {
        this.visitorsCount = visitorsCount;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    public Integer getParticipateMemberCount() {
        return participateMemberCount;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    public void setParticipateMemberCount(Integer participateMemberCount) {
        this.participateMemberCount = participateMemberCount;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    public Integer getPageForwardCount() {
        return pageForwardCount;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    public void setPageForwardCount(Integer pageForwardCount) {
        this.pageForwardCount = pageForwardCount;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    public Integer getEffectiveSharingCount() {
        return effectiveSharingCount;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    public void setEffectiveSharingCount(Integer effectiveSharingCount) {
        this.effectiveSharingCount = effectiveSharingCount;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    public Integer getRegisterMembersCount() {
        return registerMembersCount;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    public void setRegisterMembersCount(Integer registerMembersCount) {
        this.registerMembersCount = registerMembersCount;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    public Integer getTotalVisitorsCount() {
        return totalVisitorsCount;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    public void setTotalVisitorsCount(Integer totalVisitorsCount) {
        this.totalVisitorsCount = totalVisitorsCount;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    public Integer getTotalParticipateMemberCount() {
        return totalParticipateMemberCount;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    public void setTotalParticipateMemberCount(Integer totalParticipateMemberCount) {
        this.totalParticipateMemberCount = totalParticipateMemberCount;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    public Integer getTotalPageForwardCount() {
        return totalPageForwardCount;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    public void setTotalPageForwardCount(Integer totalPageForwardCount) {
        this.totalPageForwardCount = totalPageForwardCount;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    public Integer getTotalEffectiveSharingCount() {
        return totalEffectiveSharingCount;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    public void setTotalEffectiveSharingCount(Integer totalEffectiveSharingCount) {
        this.totalEffectiveSharingCount = totalEffectiveSharingCount;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    public Integer getTotalRegisterMembersCount() {
        return totalRegisterMembersCount;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    public void setTotalRegisterMembersCount(Integer totalRegisterMembersCount) {
        this.totalRegisterMembersCount = totalRegisterMembersCount;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    public Date getStatisticsTime() {
        return statisticsTime;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    public void setStatisticsTime(Date statisticsTime) {
        this.statisticsTime = statisticsTime;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    public String getStatisticsType() {
        return statisticsType;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    public void setStatisticsType(String statisticsType) {
        this.statisticsType = statisticsType == null ? null : statisticsType.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    public Long getCreateUserId() {
        return createUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    public String getCreateUserName() {
        return createUserName;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    public Long getModifiedUserId() {
        return modifiedUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    public void setModifiedUserId(Long modifiedUserId) {
        this.modifiedUserId = modifiedUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    public String getModifiedUserName() {
        return modifiedUserName;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    public void setModifiedUserName(String modifiedUserName) {
        this.modifiedUserName = modifiedUserName == null ? null : modifiedUserName.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    public Date getModifiedDate() {
        return modifiedDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    public Boolean getValid() {
        return valid;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    public String getHourJsonData() {
        return hourJsonData;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    public void setHourJsonData(String hourJsonData) {
        this.hourJsonData = hourJsonData == null ? null : hourJsonData.trim();
    }
}