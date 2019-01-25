package com.bizvane.mktcenterservice.models.po;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class MktActivityStatisticsPO implements Serializable {

	/**
	 * 只读. 主键. mkt_activity_statistics_id
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	@io.swagger.annotations.ApiModelProperty(value = "主键", name = "mktActivityStatisticsId", required = false, example = "")
	private Long mktActivityStatisticsId;
	/**
	 * 只读. 所属企业id. sys_company_id
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	@io.swagger.annotations.ApiModelProperty(value = "所属企业id", name = "sysCompanyId", required = false, example = "")
	private Long sysCompanyId;
	/**
	 * 只读. 所属品牌id. sys_brand_id
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	@io.swagger.annotations.ApiModelProperty(value = "所属品牌id", name = "sysBrandId", required = false, example = "")
	private Long sysBrandId;
	/**
	 * 只读. 活动id. mkt_activity_id
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	@io.swagger.annotations.ApiModelProperty(value = "活动id", name = "mktActivityId", required = false, example = "")
	private Long mktActivityId;
	/**
	 * 只读. 访问人数. visitors_count
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	@io.swagger.annotations.ApiModelProperty(value = "访问人数", name = "visitorsCount", required = false, example = "")
	private Integer visitorsCount;
	/**
	 * 只读. 发起会员人数. launch_members_count
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	@io.swagger.annotations.ApiModelProperty(value = "发起会员人数", name = "launchMembersCount", required = false, example = "")
	private Integer launchMembersCount;
	/**
	 * 只读. 助力会员人数. help_members_count
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	@io.swagger.annotations.ApiModelProperty(value = "助力会员人数", name = "helpMembersCount", required = false, example = "")
	private Integer helpMembersCount;
	/**
	 * 只读. 注册会员人数. register_members_count
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	@io.swagger.annotations.ApiModelProperty(value = "注册会员人数", name = "registerMembersCount", required = false, example = "")
	private Integer registerMembersCount;
	/**
	 * 只读. 领劵数量. take_coupon_count
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	@io.swagger.annotations.ApiModelProperty(value = "领劵数量", name = "takeCouponCount", required = false, example = "")
	private Long takeCouponCount;
	/**
	 * 只读. 统计时间. statistics_time
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
	@io.swagger.annotations.ApiModelProperty(value = "统计时间", name = "statisticsTime", required = false, example = "")
	private Date statisticsTime;
	/**
	 * 只读. 统计类型 0红包 其他的以后再说. statistics_type
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	@io.swagger.annotations.ApiModelProperty(value = "统计类型 0红包 其他的以后再说", name = "statisticsType", required = false, example = "")
	private String statisticsType;
	/**
	 * 只读. 备注. remark
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	@io.swagger.annotations.ApiModelProperty(value = "备注", name = "remark", required = false, example = "")
	private String remark;
	/**
	 * 只读. 创建人id. create_user_id
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建人id", name = "createUserId", required = false, example = "")
	private Long createUserId;
	/**
	 * 只读. 创建人. create_user_name
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建人", name = "createUserName", required = false, example = "")
	private String createUserName;
	/**
	 * 只读. 创建日期. create_date
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建日期", name = "createDate", required = false, example = "")
	private Date createDate;
	/**
	 * 只读. 修改人id. modified_user_id
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改人id", name = "modifiedUserId", required = false, example = "")
	private Long modifiedUserId;
	/**
	 * 只读. 修改人. modified_user_name
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改人", name = "modifiedUserName", required = false, example = "")
	private String modifiedUserName;
	/**
	 * 只读. 修改时间. modified_date
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改时间", name = "modifiedDate", required = false, example = "")
	private Date modifiedDate;
	/**
	 * 只读. 数据有效性：1=有效；0=无效. valid
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	@io.swagger.annotations.ApiModelProperty(value = "数据有效性：1=有效；0=无效", name = "valid", required = false, example = "")
	private Boolean valid;
	/**
	 * 只读. 小时json数据. hour_json_data
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	@io.swagger.annotations.ApiModelProperty(value = "小时json数据", name = "hourJsonData", required = false, example = "")
	private String hourJsonData;
	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	public Long getMktActivityStatisticsId() {
		return mktActivityStatisticsId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	public void setMktActivityStatisticsId(Long mktActivityStatisticsId) {
		this.mktActivityStatisticsId = mktActivityStatisticsId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	public Long getSysCompanyId() {
		return sysCompanyId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	public void setSysCompanyId(Long sysCompanyId) {
		this.sysCompanyId = sysCompanyId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	public Long getSysBrandId() {
		return sysBrandId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	public void setSysBrandId(Long sysBrandId) {
		this.sysBrandId = sysBrandId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	public Long getMktActivityId() {
		return mktActivityId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	public void setMktActivityId(Long mktActivityId) {
		this.mktActivityId = mktActivityId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	public Integer getVisitorsCount() {
		return visitorsCount;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	public void setVisitorsCount(Integer visitorsCount) {
		this.visitorsCount = visitorsCount;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	public Integer getLaunchMembersCount() {
		return launchMembersCount;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	public void setLaunchMembersCount(Integer launchMembersCount) {
		this.launchMembersCount = launchMembersCount;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	public Integer getHelpMembersCount() {
		return helpMembersCount;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	public void setHelpMembersCount(Integer helpMembersCount) {
		this.helpMembersCount = helpMembersCount;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	public Integer getRegisterMembersCount() {
		return registerMembersCount;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	public void setRegisterMembersCount(Integer registerMembersCount) {
		this.registerMembersCount = registerMembersCount;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	public Long getTakeCouponCount() {
		return takeCouponCount;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	public void setTakeCouponCount(Long takeCouponCount) {
		this.takeCouponCount = takeCouponCount;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	public Date getStatisticsTime() {
		return statisticsTime;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	public void setStatisticsTime(Date statisticsTime) {
		this.statisticsTime = statisticsTime;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	public String getStatisticsType() {
		return statisticsType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	public void setStatisticsType(String statisticsType) {
		this.statisticsType = statisticsType == null ? null : statisticsType.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	public Long getCreateUserId() {
		return createUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	public String getCreateUserName() {
		return createUserName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName == null ? null : createUserName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	public Long getModifiedUserId() {
		return modifiedUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	public void setModifiedUserId(Long modifiedUserId) {
		this.modifiedUserId = modifiedUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	public String getModifiedUserName() {
		return modifiedUserName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	public void setModifiedUserName(String modifiedUserName) {
		this.modifiedUserName = modifiedUserName == null ? null : modifiedUserName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	public Date getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	public Boolean getValid() {
		return valid;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	public void setValid(Boolean valid) {
		this.valid = valid;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	public String getHourJsonData() {
		return hourJsonData;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	public void setHourJsonData(String hourJsonData) {
		this.hourJsonData = hourJsonData == null ? null : hourJsonData.trim();
	}
}