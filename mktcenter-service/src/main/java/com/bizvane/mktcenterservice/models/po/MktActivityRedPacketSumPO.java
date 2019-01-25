package com.bizvane.mktcenterservice.models.po;

import java.io.Serializable;
import java.util.Date;

public class MktActivityRedPacketSumPO implements Serializable {

	/**
	 * 只读. . mkt_activity_red_packet_sum_id
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "", name = "mktActivityRedPacketSumId", required = false, example = "")
	private Long mktActivityRedPacketSumId;
	/**
	 * 只读. 关联活动id. mkt_activity_id
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "关联活动id", name = "mktActivityId", required = false, example = "")
	private Long mktActivityId;
	/**
	 * 只读. 所属企业id. sys_company_id
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "所属企业id", name = "sysCompanyId", required = false, example = "")
	private Long sysCompanyId;
	/**
	 * 只读. 活动编号. activity_code
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "活动编号", name = "activityCode", required = false, example = "")
	private String activityCode;
	/**
	 * 只读. 活动名称. activity_name
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "活动名称", name = "activityName", required = false, example = "")
	private String activityName;
	/**
	 * 只读. 所属品牌id. sys_brand_id
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "所属品牌id", name = "sysBrandId", required = false, example = "")
	private Long sysBrandId;
	/**
	 * 只读. 发起人数. initiator_num
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "发起人数", name = "initiatorNum", required = false, example = "")
	private Integer initiatorNum;
	/**
	 * 只读. 助理人数. help_num
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "助理人数", name = "helpNum", required = false, example = "")
	private Integer helpNum;
	/**
	 * 只读. 领券人数. get_coupon_num
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "领券人数", name = "getCouponNum", required = false, example = "")
	private Integer getCouponNum;
	/**
	 * 只读. 活动开始时间. start_time
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "活动开始时间", name = "startTime", required = false, example = "")
	private Date startTime;
	/**
	 * 只读. 活动结束时间. end_time
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "活动结束时间", name = "endTime", required = false, example = "")
	private Date endTime;
	/**
	 * 只读. 间隔时长. activity_time
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "间隔时长", name = "activityTime", required = false, example = "")
	private Integer activityTime;
	/**
	 * 只读. 备注. remark
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "备注", name = "remark", required = false, example = "")
	private String remark;
	/**
	 * 只读. 创建人id. create_user_id
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建人id", name = "createUserId", required = false, example = "")
	private Long createUserId;
	/**
	 * 只读. 创建人. create_user_name
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建人", name = "createUserName", required = false, example = "")
	private String createUserName;
	/**
	 * 只读. 创建时间. create_date
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建时间", name = "createDate", required = false, example = "")
	private Date createDate;
	/**
	 * 只读. 修改人id. modified_user_id
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改人id", name = "modifiedUserId", required = false, example = "")
	private Integer modifiedUserId;
	/**
	 * 只读. 修改人. modified_user_name
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改人", name = "modifiedUserName", required = false, example = "")
	private String modifiedUserName;
	/**
	 * 只读. 修改时间. modified_date
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改时间", name = "modifiedDate", required = false, example = "")
	private Date modifiedDate;
	/**
	 * 只读. 数据有效性：1=有效；0=无效. valid
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "数据有效性：1=有效；0=无效", name = "valid", required = false, example = "")
	private Boolean valid;
	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	public Long getMktActivityRedPacketSumId() {
		return mktActivityRedPacketSumId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	public void setMktActivityRedPacketSumId(Long mktActivityRedPacketSumId) {
		this.mktActivityRedPacketSumId = mktActivityRedPacketSumId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	public Long getMktActivityId() {
		return mktActivityId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	public void setMktActivityId(Long mktActivityId) {
		this.mktActivityId = mktActivityId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	public Long getSysCompanyId() {
		return sysCompanyId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	public void setSysCompanyId(Long sysCompanyId) {
		this.sysCompanyId = sysCompanyId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	public String getActivityCode() {
		return activityCode;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	public void setActivityCode(String activityCode) {
		this.activityCode = activityCode == null ? null : activityCode.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	public String getActivityName() {
		return activityName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	public void setActivityName(String activityName) {
		this.activityName = activityName == null ? null : activityName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	public Long getSysBrandId() {
		return sysBrandId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	public void setSysBrandId(Long sysBrandId) {
		this.sysBrandId = sysBrandId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	public Integer getInitiatorNum() {
		return initiatorNum;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	public void setInitiatorNum(Integer initiatorNum) {
		this.initiatorNum = initiatorNum;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	public Integer getHelpNum() {
		return helpNum;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	public void setHelpNum(Integer helpNum) {
		this.helpNum = helpNum;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	public Integer getGetCouponNum() {
		return getCouponNum;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	public void setGetCouponNum(Integer getCouponNum) {
		this.getCouponNum = getCouponNum;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	public Integer getActivityTime() {
		return activityTime;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	public void setActivityTime(Integer activityTime) {
		this.activityTime = activityTime;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	public Long getCreateUserId() {
		return createUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	public String getCreateUserName() {
		return createUserName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName == null ? null : createUserName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	public Integer getModifiedUserId() {
		return modifiedUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	public void setModifiedUserId(Integer modifiedUserId) {
		this.modifiedUserId = modifiedUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	public String getModifiedUserName() {
		return modifiedUserName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	public void setModifiedUserName(String modifiedUserName) {
		this.modifiedUserName = modifiedUserName == null ? null : modifiedUserName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	public Date getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	public Boolean getValid() {
		return valid;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
}