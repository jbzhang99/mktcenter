package com.bizvane.mktcenterservice.models.po;

import java.io.Serializable;
import java.util.Date;

public class MktTaskPO implements Serializable {

	/**
	 * 只读. pkid. mkt_task_id
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	@io.swagger.annotations.ApiModelProperty(value = "pkid", name = "mktTaskId", required = false, example = "")
	private Long mktTaskId;
	/**
	 * 只读. 任务编号. task_code
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	@io.swagger.annotations.ApiModelProperty(value = "任务编号", name = "taskCode", required = false, example = "")
	private String taskCode;
	/**
	 * 只读. 任务类型：1完善资料，2分享任务，3邀请注册，4累计消费次数，5累计消费金额. task_type
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	@io.swagger.annotations.ApiModelProperty(value = "任务类型：1完善资料，2分享任务，3邀请注册，4累计消费次数，5累计消费金额", name = "taskType", required = false, example = "")
	private Integer taskType;
	/**
	 * 只读. 任务名称. task_name
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	@io.swagger.annotations.ApiModelProperty(value = "任务名称", name = "taskName", required = false, example = "")
	private String taskName;
	/**
	 * 只读. 分享次数. share_times
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	@io.swagger.annotations.ApiModelProperty(value = "分享次数", name = "shareTimes", required = false, example = "")
	private Integer shareTimes;
	/**
	 * 只读. 分享标题. share_title
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	@io.swagger.annotations.ApiModelProperty(value = "分享标题", name = "shareTitle", required = false, example = "")
	private String shareTitle;
	/**
	 * 只读. 邀请人数. invite_mbr_num
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	@io.swagger.annotations.ApiModelProperty(value = "邀请人数", name = "inviteMbrNum", required = false, example = "")
	private Integer inviteMbrNum;
	/**
	 * 只读. 赠送积分数值. point
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	@io.swagger.annotations.ApiModelProperty(value = "赠送积分数值", name = "point", required = false, example = "")
	private Integer point;
	/**
	 * 只读. 审核状态：1未审核，2审核中，3已审核，4已驳回. check_status
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	@io.swagger.annotations.ApiModelProperty(value = "审核状态：1未审核，2审核中，3已审核，4已驳回", name = "checkStatus", required = false, example = "")
	private Integer checkStatus;
	/**
	 * 只读. 任务状态：1待执行，2执行中，3已结束. task_status
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	@io.swagger.annotations.ApiModelProperty(value = "任务状态：1待执行，2执行中，3已结束", name = "taskStatus", required = false, example = "")
	private Integer taskStatus;
	/**
	 * 只读. 备注. remark
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	@io.swagger.annotations.ApiModelProperty(value = "备注", name = "remark", required = false, example = "")
	private String remark;
	/**
	 * 只读. 创建人id. create_user_id
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建人id", name = "createUserId", required = false, example = "")
	private Long createUserId;
	/**
	 * 只读. 创建人. create_user_name
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建人", name = "createUserName", required = false, example = "")
	private String createUserName;
	/**
	 * 只读. 创建日期. create_date
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建日期", name = "createDate", required = false, example = "")
	private Date createDate;
	/**
	 * 只读. 修改人id. modified_user_id
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改人id", name = "modifiedUserId", required = false, example = "")
	private Long modifiedUserId;
	/**
	 * 只读. 修改人. modified_user_name
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改人", name = "modifiedUserName", required = false, example = "")
	private String modifiedUserName;
	/**
	 * 只读. 修改时间. modified_date
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改时间", name = "modifiedDate", required = false, example = "")
	private Date modifiedDate;
	/**
	 * 只读. 数据有效性：1=有效；0=无效. valid
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	@io.swagger.annotations.ApiModelProperty(value = "数据有效性：1=有效；0=无效", name = "valid", required = false, example = "")
	private Boolean valid;
	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public Long getMktTaskId() {
		return mktTaskId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public void setMktTaskId(Long mktTaskId) {
		this.mktTaskId = mktTaskId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public String getTaskCode() {
		return taskCode;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public void setTaskCode(String taskCode) {
		this.taskCode = taskCode == null ? null : taskCode.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public Integer getTaskType() {
		return taskType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public void setTaskType(Integer taskType) {
		this.taskType = taskType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public String getTaskName() {
		return taskName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName == null ? null : taskName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public Integer getShareTimes() {
		return shareTimes;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public void setShareTimes(Integer shareTimes) {
		this.shareTimes = shareTimes;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public String getShareTitle() {
		return shareTitle;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public void setShareTitle(String shareTitle) {
		this.shareTitle = shareTitle == null ? null : shareTitle.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public Integer getInviteMbrNum() {
		return inviteMbrNum;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public void setInviteMbrNum(Integer inviteMbrNum) {
		this.inviteMbrNum = inviteMbrNum;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public Integer getPoint() {
		return point;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public void setPoint(Integer point) {
		this.point = point;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public Integer getCheckStatus() {
		return checkStatus;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public void setCheckStatus(Integer checkStatus) {
		this.checkStatus = checkStatus;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public Integer getTaskStatus() {
		return taskStatus;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public void setTaskStatus(Integer taskStatus) {
		this.taskStatus = taskStatus;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public Long getCreateUserId() {
		return createUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public String getCreateUserName() {
		return createUserName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName == null ? null : createUserName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public Long getModifiedUserId() {
		return modifiedUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public void setModifiedUserId(Long modifiedUserId) {
		this.modifiedUserId = modifiedUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public String getModifiedUserName() {
		return modifiedUserName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public void setModifiedUserName(String modifiedUserName) {
		this.modifiedUserName = modifiedUserName == null ? null : modifiedUserName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public Date getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public Boolean getValid() {
		return valid;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
}