package com.bizvane.mktcenterservice.models.po;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class MktActivitySmartPO implements Serializable {

	/**
	 * 只读. pkid. mkt_activity_smart_id
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	@io.swagger.annotations.ApiModelProperty(value = "pkid", name = "mktActivitySmartId", required = false, example = "")
	private Long mktActivitySmartId;
	/**
	 * 只读. 会员分组id. member_group_id
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	@io.swagger.annotations.ApiModelProperty(value = "会员分组id", name = "memberGroupId", required = false, example = "")
	private Long memberGroupId;
	/**
	 * 只读. 会员分组编号. member_group_code
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	@io.swagger.annotations.ApiModelProperty(value = "会员分组编号", name = "memberGroupCode", required = false, example = "")
	private String memberGroupCode;
	/**
	 * 只读. 营销名称/分组名称. member_group_name
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	@io.swagger.annotations.ApiModelProperty(value = "营销名称/分组名称", name = "memberGroupName", required = false, example = "")
	private String memberGroupName;
	/**
	 * 只读. 预计目标会员统计. target_mbr_count
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	@io.swagger.annotations.ApiModelProperty(value = "预计目标会员统计", name = "targetMbrCount", required = false, example = "")
	private Integer targetMbrCount;
	/**
	 * 只读. 预计目标会员数量的统计时间. target_mbr_count_time
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
	@io.swagger.annotations.ApiModelProperty(value = "预计目标会员数量的统计时间", name = "targetMbrCountTime", required = false, example = "")
	private Date targetMbrCountTime;
	/**
	 * 只读. 分组状态：0禁用，1启用. status
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	@io.swagger.annotations.ApiModelProperty(value = "分组状态：0禁用，1启用", name = "status", required = false, example = "")
	private Boolean status;
	/**
	 * 只读. 备注. remark
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	@io.swagger.annotations.ApiModelProperty(value = "备注", name = "remark", required = false, example = "")
	private String remark;
	/**
	 * 只读. 创建人id. create_user_id
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建人id", name = "createUserId", required = false, example = "")
	private Long createUserId;
	/**
	 * 只读. 创建人. create_user_name
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建人", name = "createUserName", required = false, example = "")
	private String createUserName;
	/**
	 * 只读. 创建日期. create_date
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
	@io.swagger.annotations.ApiModelProperty(value = "创建日期", name = "createDate", required = false, example = "")
	private Date createDate;
	/**
	 * 只读. 修改人id. modified_user_id
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改人id", name = "modifiedUserId", required = false, example = "")
	private Long modifiedUserId;
	/**
	 * 只读. 修改人. modified_user_name
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改人", name = "modifiedUserName", required = false, example = "")
	private String modifiedUserName;
	/**
	 * 只读. 修改时间. modified_date
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
	@io.swagger.annotations.ApiModelProperty(value = "修改时间", name = "modifiedDate", required = false, example = "")
	private Date modifiedDate;
	/**
	 * 只读. 数据有效性：1=有效；0=无效. valid
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	@io.swagger.annotations.ApiModelProperty(value = "数据有效性：1=有效；0=无效", name = "valid", required = false, example = "")
	private Boolean valid;
	/**
	 * 只读. 目标会员在会员模块中的搜索条件. target_mbr
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	@io.swagger.annotations.ApiModelProperty(value = "目标会员在会员模块中的搜索条件", name = "targetMbr", required = false, example = "")
	private String targetMbr;
	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	public Long getMktActivitySmartId() {
		return mktActivitySmartId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	public void setMktActivitySmartId(Long mktActivitySmartId) {
		this.mktActivitySmartId = mktActivitySmartId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	public Long getMemberGroupId() {
		return memberGroupId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	public void setMemberGroupId(Long memberGroupId) {
		this.memberGroupId = memberGroupId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	public String getMemberGroupCode() {
		return memberGroupCode;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	public void setMemberGroupCode(String memberGroupCode) {
		this.memberGroupCode = memberGroupCode == null ? null : memberGroupCode.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	public String getMemberGroupName() {
		return memberGroupName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	public void setMemberGroupName(String memberGroupName) {
		this.memberGroupName = memberGroupName == null ? null : memberGroupName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	public Integer getTargetMbrCount() {
		return targetMbrCount;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	public void setTargetMbrCount(Integer targetMbrCount) {
		this.targetMbrCount = targetMbrCount;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	public Date getTargetMbrCountTime() {
		return targetMbrCountTime;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	public void setTargetMbrCountTime(Date targetMbrCountTime) {
		this.targetMbrCountTime = targetMbrCountTime;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	public Boolean getStatus() {
		return status;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	public void setStatus(Boolean status) {
		this.status = status;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	public Long getCreateUserId() {
		return createUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	public String getCreateUserName() {
		return createUserName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName == null ? null : createUserName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	public Long getModifiedUserId() {
		return modifiedUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	public void setModifiedUserId(Long modifiedUserId) {
		this.modifiedUserId = modifiedUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	public String getModifiedUserName() {
		return modifiedUserName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	public void setModifiedUserName(String modifiedUserName) {
		this.modifiedUserName = modifiedUserName == null ? null : modifiedUserName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	public Date getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	public Boolean getValid() {
		return valid;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	public void setValid(Boolean valid) {
		this.valid = valid;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	public String getTargetMbr() {
		return targetMbr;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	public void setTargetMbr(String targetMbr) {
		this.targetMbr = targetMbr == null ? null : targetMbr.trim();
	}
}