package com.bizvane.mktcenterservice.models.po;

import java.io.Serializable;
import java.util.Date;

public class MktActivitySmartPO implements Serializable {

	/**
	 * 只读. pkid. mkt_activity_birthday_id
	 * @mbg.generated  2018-07-27 15:31:38
	 */
	@io.swagger.annotations.ApiModelProperty(value = "pkid", name = "mktActivityBirthdayId", required = false, example = "")
	private Long mktActivityBirthdayId;
	/**
	 * 只读. 关联活动id. mkt_activity_id
	 * @mbg.generated  2018-07-27 15:31:38
	 */
	@io.swagger.annotations.ApiModelProperty(value = "关联活动id", name = "mktActivityId", required = false, example = "")
	private Long mktActivityId;
	/**
	 * 只读. 营销方式：1优惠券营销，2积分营销，3短信营销，4微信模板消息营销. mtk_type
	 * @mbg.generated  2018-07-27 15:31:38
	 */
	@io.swagger.annotations.ApiModelProperty(value = "营销方式：1优惠券营销，2积分营销，3短信营销，4微信模板消息营销", name = "mtkType", required = false, example = "")
	private Integer mtkType;
	/**
	 * 只读. 会员分组id. member_group_id
	 * @mbg.generated  2018-07-27 15:31:38
	 */
	@io.swagger.annotations.ApiModelProperty(value = "会员分组id", name = "memberGroupId", required = false, example = "")
	private Long memberGroupId;
	/**
	 * 只读. 会员分组编号. member_group_code
	 * @mbg.generated  2018-07-27 15:31:38
	 */
	@io.swagger.annotations.ApiModelProperty(value = "会员分组编号", name = "memberGroupCode", required = false, example = "")
	private String memberGroupCode;
	/**
	 * 只读. 预计目标会员统计. target_mbr_count
	 * @mbg.generated  2018-07-27 15:31:38
	 */
	@io.swagger.annotations.ApiModelProperty(value = "预计目标会员统计", name = "targetMbrCount", required = false, example = "")
	private Integer targetMbrCount;
	/**
	 * 只读. 预计目标会员数量的统计时间. target_mbr_count_time
	 * @mbg.generated  2018-07-27 15:31:38
	 */
	@io.swagger.annotations.ApiModelProperty(value = "预计目标会员数量的统计时间", name = "targetMbrCountTime", required = false, example = "")
	private Date targetMbrCountTime;
	/**
	 * 只读. 备注. remark
	 * @mbg.generated  2018-07-27 15:31:38
	 */
	@io.swagger.annotations.ApiModelProperty(value = "备注", name = "remark", required = false, example = "")
	private String remark;
	/**
	 * 只读. 创建人id. create_user_id
	 * @mbg.generated  2018-07-27 15:31:38
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建人id", name = "createUserId", required = false, example = "")
	private Long createUserId;
	/**
	 * 只读. 创建人. create_user_name
	 * @mbg.generated  2018-07-27 15:31:38
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建人", name = "createUserName", required = false, example = "")
	private String createUserName;
	/**
	 * 只读. 创建日期. create_date
	 * @mbg.generated  2018-07-27 15:31:38
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建日期", name = "createDate", required = false, example = "")
	private Date createDate;
	/**
	 * 只读. 修改人id. modified_user_id
	 * @mbg.generated  2018-07-27 15:31:38
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改人id", name = "modifiedUserId", required = false, example = "")
	private Long modifiedUserId;
	/**
	 * 只读. 修改人. modified_user_name
	 * @mbg.generated  2018-07-27 15:31:38
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改人", name = "modifiedUserName", required = false, example = "")
	private String modifiedUserName;
	/**
	 * 只读. 修改时间. modified_date
	 * @mbg.generated  2018-07-27 15:31:38
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改时间", name = "modifiedDate", required = false, example = "")
	private Date modifiedDate;
	/**
	 * 只读. 数据有效性：1=有效；0=无效. valid
	 * @mbg.generated  2018-07-27 15:31:38
	 */
	@io.swagger.annotations.ApiModelProperty(value = "数据有效性：1=有效；0=无效", name = "valid", required = false, example = "")
	private Boolean valid;
	/**
	 * 只读. 目标会员在会员模块中的搜索条件. target_mbr
	 * @mbg.generated  2018-07-27 15:31:38
	 */
	@io.swagger.annotations.ApiModelProperty(value = "目标会员在会员模块中的搜索条件", name = "targetMbr", required = false, example = "")
	private String targetMbr;
	/**
	 * 只读. 
	 * @mbg.generated  2018-07-27 15:31:38
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-27 15:31:38
	 */
	public Long getMktActivityBirthdayId() {
		return mktActivityBirthdayId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-27 15:31:38
	 */
	public void setMktActivityBirthdayId(Long mktActivityBirthdayId) {
		this.mktActivityBirthdayId = mktActivityBirthdayId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-27 15:31:38
	 */
	public Long getMktActivityId() {
		return mktActivityId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-27 15:31:38
	 */
	public void setMktActivityId(Long mktActivityId) {
		this.mktActivityId = mktActivityId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-27 15:31:38
	 */
	public Integer getMtkType() {
		return mtkType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-27 15:31:38
	 */
	public void setMtkType(Integer mtkType) {
		this.mtkType = mtkType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-27 15:31:38
	 */
	public Long getMemberGroupId() {
		return memberGroupId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-27 15:31:38
	 */
	public void setMemberGroupId(Long memberGroupId) {
		this.memberGroupId = memberGroupId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-27 15:31:38
	 */
	public String getMemberGroupCode() {
		return memberGroupCode;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-27 15:31:38
	 */
	public void setMemberGroupCode(String memberGroupCode) {
		this.memberGroupCode = memberGroupCode == null ? null : memberGroupCode.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-27 15:31:38
	 */
	public Integer getTargetMbrCount() {
		return targetMbrCount;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-27 15:31:38
	 */
	public void setTargetMbrCount(Integer targetMbrCount) {
		this.targetMbrCount = targetMbrCount;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-27 15:31:38
	 */
	public Date getTargetMbrCountTime() {
		return targetMbrCountTime;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-27 15:31:38
	 */
	public void setTargetMbrCountTime(Date targetMbrCountTime) {
		this.targetMbrCountTime = targetMbrCountTime;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-27 15:31:38
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-27 15:31:38
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-27 15:31:38
	 */
	public Long getCreateUserId() {
		return createUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-27 15:31:38
	 */
	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-27 15:31:38
	 */
	public String getCreateUserName() {
		return createUserName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-27 15:31:38
	 */
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName == null ? null : createUserName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-27 15:31:38
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-27 15:31:38
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-27 15:31:38
	 */
	public Long getModifiedUserId() {
		return modifiedUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-27 15:31:38
	 */
	public void setModifiedUserId(Long modifiedUserId) {
		this.modifiedUserId = modifiedUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-27 15:31:38
	 */
	public String getModifiedUserName() {
		return modifiedUserName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-27 15:31:38
	 */
	public void setModifiedUserName(String modifiedUserName) {
		this.modifiedUserName = modifiedUserName == null ? null : modifiedUserName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-27 15:31:38
	 */
	public Date getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-27 15:31:38
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-27 15:31:38
	 */
	public Boolean getValid() {
		return valid;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-27 15:31:38
	 */
	public void setValid(Boolean valid) {
		this.valid = valid;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-27 15:31:38
	 */
	public String getTargetMbr() {
		return targetMbr;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-27 15:31:38
	 */
	public void setTargetMbr(String targetMbr) {
		this.targetMbr = targetMbr == null ? null : targetMbr.trim();
	}
}