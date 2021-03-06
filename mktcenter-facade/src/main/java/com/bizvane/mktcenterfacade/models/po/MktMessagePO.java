package com.bizvane.mktcenterfacade.models.po;

import java.io.Serializable;
import java.util.Date;

public class MktMessagePO implements Serializable {

	/**
	 * 只读. pkid. mkt_msg_id
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	@io.swagger.annotations.ApiModelProperty(value = "pkid", name = "mktMsgId", required = false, example = "")
	private Long mktMsgId;
	/**
	 * 只读. . sys_company_id
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	@io.swagger.annotations.ApiModelProperty(value = "", name = "sysCompanyId", required = false, example = "")
	private Long sysCompanyId;
	/**
	 * 只读. 消息业务类型：1活动，2任务. biz_type
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	@io.swagger.annotations.ApiModelProperty(value = "消息业务类型：1活动，2任务", name = "bizType", required = false, example = "")
	private Integer bizType;
	/**
	 * 只读. 业务单号id. biz_id
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	@io.swagger.annotations.ApiModelProperty(value = "业务单号id", name = "bizId", required = false, example = "")
	private Long bizId;
	/**
	 * 只读. 消息类型，1模板消息，2短信,3图文消息. msg_type
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	@io.swagger.annotations.ApiModelProperty(value = "消息类型，1模板消息，2短信,3图文消息", name = "msgType", required = false, example = "")
	private String msgType;
	/**
	 * 只读. 消息编号. msg_code
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	@io.swagger.annotations.ApiModelProperty(value = "消息编号", name = "msgCode", required = false, example = "")
	private String msgCode;
	/**
	 * 只读. 模板消息id. template_msg_id
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	@io.swagger.annotations.ApiModelProperty(value = "模板消息id", name = "templateMsgId", required = false, example = "")
	private String templateMsgId;
	/**
	 * 只读. 立即发送：1是，0否（完善资料任务：1=启用 0=禁止）. send_immediately
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	@io.swagger.annotations.ApiModelProperty(value = "立即发送：1是，0否（完善资料任务：1=启用 0=禁止）", name = "sendImmediately", required = false, example = "")
	private Boolean sendImmediately;
	/**
	 * 只读. 开始发送时间. send_time
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	@io.swagger.annotations.ApiModelProperty(value = "开始发送时间", name = "sendTime", required = false, example = "")
	private Date sendTime;
	/**
	 * 只读. 消息发送是否排除微信会员，1是，0否. except_wechat
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	@io.swagger.annotations.ApiModelProperty(value = "消息发送是否排除微信会员，1是，0否", name = "exceptWechat", required = false, example = "")
	private Boolean exceptWechat;
	/**
	 * 只读. 备注. remark
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	@io.swagger.annotations.ApiModelProperty(value = "备注", name = "remark", required = false, example = "")
	private String remark;
	/**
	 * 只读. 导航语. navigation
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	@io.swagger.annotations.ApiModelProperty(value = "导航语", name = "navigation", required = false, example = "")
	private String navigation;
	/**
	 * 只读. 活动时间（定向运行和智能营销模板消息的字段）. activity_time
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	@io.swagger.annotations.ApiModelProperty(value = "活动时间（定向运行和智能营销模板消息的字段）", name = "activityTime", required = false, example = "")
	private String activityTime;
	/**
	 * 只读. 赞助商. sponsor
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	@io.swagger.annotations.ApiModelProperty(value = "赞助商", name = "sponsor", required = false, example = "")
	private String sponsor;
	/**
	 * 只读. 链接地址. link
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	@io.swagger.annotations.ApiModelProperty(value = "链接地址", name = "link", required = false, example = "")
	private String link;
	/**
	 * 只读. 创建人id. create_user_id
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建人id", name = "createUserId", required = false, example = "")
	private Long createUserId;
	/**
	 * 只读. 创建人. create_user_name
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建人", name = "createUserName", required = false, example = "")
	private String createUserName;
	/**
	 * 只读. 创建日期. create_date
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建日期", name = "createDate", required = false, example = "")
	private Date createDate;
	/**
	 * 只读. 修改人id. modified_user_id
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改人id", name = "modifiedUserId", required = false, example = "")
	private Long modifiedUserId;
	/**
	 * 只读. 修改人. modified_user_name
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改人", name = "modifiedUserName", required = false, example = "")
	private String modifiedUserName;
	/**
	 * 只读. 修改时间. modified_date
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改时间", name = "modifiedDate", required = false, example = "")
	private Date modifiedDate;
	/**
	 * 只读. 数据有效性：1=有效；0=无效. valid
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	@io.swagger.annotations.ApiModelProperty(value = "数据有效性：1=有效；0=无效", name = "valid", required = false, example = "")
	private Boolean valid;
	/**
	 * 只读. 消息内容. msg_content
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	@io.swagger.annotations.ApiModelProperty(value = "消息内容", name = "msgContent", required = false, example = "")
	private String msgContent;
	/**
	 * 只读. 
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	public Long getMktMsgId() {
		return mktMsgId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	public void setMktMsgId(Long mktMsgId) {
		this.mktMsgId = mktMsgId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	public Long getSysCompanyId() {
		return sysCompanyId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	public void setSysCompanyId(Long sysCompanyId) {
		this.sysCompanyId = sysCompanyId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	public Integer getBizType() {
		return bizType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	public void setBizType(Integer bizType) {
		this.bizType = bizType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	public Long getBizId() {
		return bizId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	public void setBizId(Long bizId) {
		this.bizId = bizId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	public String getMsgType() {
		return msgType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	public void setMsgType(String msgType) {
		this.msgType = msgType == null ? null : msgType.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	public String getMsgCode() {
		return msgCode;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	public void setMsgCode(String msgCode) {
		this.msgCode = msgCode == null ? null : msgCode.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	public String getTemplateMsgId() {
		return templateMsgId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	public void setTemplateMsgId(String templateMsgId) {
		this.templateMsgId = templateMsgId == null ? null : templateMsgId.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	public Boolean getSendImmediately() {
		return sendImmediately;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	public void setSendImmediately(Boolean sendImmediately) {
		this.sendImmediately = sendImmediately;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	public Date getSendTime() {
		return sendTime;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	public Boolean getExceptWechat() {
		return exceptWechat;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	public void setExceptWechat(Boolean exceptWechat) {
		this.exceptWechat = exceptWechat;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	public String getNavigation() {
		return navigation;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	public void setNavigation(String navigation) {
		this.navigation = navigation == null ? null : navigation.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	public String getActivityTime() {
		return activityTime;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	public void setActivityTime(String activityTime) {
		this.activityTime = activityTime == null ? null : activityTime.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	public String getSponsor() {
		return sponsor;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	public void setSponsor(String sponsor) {
		this.sponsor = sponsor == null ? null : sponsor.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	public String getLink() {
		return link;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	public void setLink(String link) {
		this.link = link == null ? null : link.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	public Long getCreateUserId() {
		return createUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	public String getCreateUserName() {
		return createUserName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName == null ? null : createUserName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	public Long getModifiedUserId() {
		return modifiedUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	public void setModifiedUserId(Long modifiedUserId) {
		this.modifiedUserId = modifiedUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	public String getModifiedUserName() {
		return modifiedUserName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	public void setModifiedUserName(String modifiedUserName) {
		this.modifiedUserName = modifiedUserName == null ? null : modifiedUserName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	public Date getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	public Boolean getValid() {
		return valid;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	public void setValid(Boolean valid) {
		this.valid = valid;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	public String getMsgContent() {
		return msgContent;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent == null ? null : msgContent.trim();
	}
}