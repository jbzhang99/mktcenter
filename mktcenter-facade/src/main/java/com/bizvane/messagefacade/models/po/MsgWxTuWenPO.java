package com.bizvane.messagefacade.models.po;

import java.io.Serializable;
import java.util.Date;

public class MsgWxTuWenPO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String _id;
	 
	private Long sysCompanyId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_msg_wx_log.rocket_msg_id
	 * @mbg.generated  Fri Aug 31 15:35:26 CST 2018
	 */
	@io.swagger.annotations.ApiModelProperty(value = "消息队列msgid", name = "rocketMsgId", required = false, example = "")
	private String rocketMsgId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_msg_wx_log.message_id
	 * @mbg.generated  Fri Aug 31 15:35:26 CST 2018
	 */
	@io.swagger.annotations.ApiModelProperty(value = "消息id", name = "messageId", required = false, example = "")
	private String messageId;
	
	@io.swagger.annotations.ApiModelProperty(value = "消息bussinessId", name = "bussinessId", required = false, example = "")
	private String bussinessId;
	
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_msg_wx_log.bussiness_id
	 * @mbg.generated  Fri Aug 31 15:35:26 CST 2018
	 */
	@io.swagger.annotations.ApiModelProperty(value = "任务id", name = "taskId", required = false, example = "")
	private String taskId;
	@io.swagger.annotations.ApiModelProperty(value = "任务Data", name = "taskData", required = false, example = "")
	private String taskIdData;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_msg_wx_log.wx_public_id
	 * @mbg.generated  Fri Aug 31 15:35:26 CST 2018
	 */
//	微信发送必填字段
	@io.swagger.annotations.ApiModelProperty(value = "会员openid", name = "openId", required = false, example = "")
	private String openId;
	
	@io.swagger.annotations.ApiModelProperty(value = "模板id", name = "mediaId", required = false, example = "")
	private String mediaId;
	
	@io.swagger.annotations.ApiModelProperty(value = "消息类型", name = "msgType", required = false, example = "")
	private String msgType;
	
	@io.swagger.annotations.ApiModelProperty(value = "是否继续群发", name = "图文消息被判定为转载时，是否继续群发。 1为继续群发（转载），0为停止群发。 该参数默认为0。", required = false, example = "")
	private String sendIgnoreReprint;
	
	@io.swagger.annotations.ApiModelProperty(value = "品牌", name = "brandId", required = false, example = "")
	private Long brandId;
	@io.swagger.annotations.ApiModelProperty(value = "分组名称", name = "groupName", required = false, example = "")
	private String groupName;
	@io.swagger.annotations.ApiModelProperty(value = "消息标题", name = "headlTitle", required = false, example = "")
	private String headlTitle;
	
	@io.swagger.annotations.ApiModelProperty(value = "会员量", name = "groupName", required = false, example = "")
	private String memberSum;
	
	@io.swagger.annotations.ApiModelProperty(value = "成功数量", name = "sendYesSum", required = false, example = "")
	private String sendYesSum;
	
	@io.swagger.annotations.ApiModelProperty(value = "失败数量", name = "sendNotSum", required = false, example = "")
	private String sendNotSum;
	
	
	
public String getTaskIdData() {
		return taskIdData;
	}


	public void setTaskIdData(String taskIdData) {
		this.taskIdData = taskIdData;
	}


	//	微信发送必填字段
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_msg_wx_log.data_body
	 * @mbg.generated  Fri Aug 31 15:35:26 CST 2018
	 */
	@io.swagger.annotations.ApiModelProperty(value = "发送数据", name = "dataBody", required = false, example = "")
	private String dataBody;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_msg_wx_log.message_body
	 * @mbg.generated  Fri Aug 31 15:35:26 CST 2018
	 */
	@io.swagger.annotations.ApiModelProperty(value = "微信消息体(消息内容)", name = "messageBody", required = false, example = "")
	private String messageBody;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_msg_wx_log.result_info
	 * @mbg.generated  Fri Aug 31 15:35:26 CST 2018
	 */
	@io.swagger.annotations.ApiModelProperty(value = "返回数据", name = "resultInfo", required = false, example = "")
	private String resultInfo;
	
	@io.swagger.annotations.ApiModelProperty(value = "返回数据明细信息", name = "resultInfoDetail", required = false, example = "")
	private String resultInfoDetail;
	

	@io.swagger.annotations.ApiModelProperty(value = "发送状态：0发送成功、1发送失败、 2发送中、3已删除", name = "sendState", required = false, example = "")
	private String sendState;
	@io.swagger.annotations.ApiModelProperty(value = "发送状态：0发送成功、1发送失败、 2发送中、3已删除", name = "sendState", required = false, example = "")
	private String sendStateName;


	@io.swagger.annotations.ApiModelProperty(value = "最后修改日期", name = "updateDate", required = false, example = "")
	private Date updateDate;


	@io.swagger.annotations.ApiModelProperty(value = "创建日期（发送时间）", name = "createDate", required = false, example = "")
	private Date createDate;


	
	public String getSendStateName() {
		return sendStateName;
	}


	public void setSendStateName(String sendStateName) {
		this.sendStateName = sendStateName;
	}


	public String getMemberSum() {
		return memberSum;
	}


	public void setMemberSum(String memberSum) {
		this.memberSum = memberSum;
	}


	public String getSendYesSum() {
		return sendYesSum;
	}


	public void setSendYesSum(String sendYesSum) {
		this.sendYesSum = sendYesSum;
	}


	public String getSendNotSum() {
		return sendNotSum;
	}


	public void setSendNotSum(String sendNotSum) {
		this.sendNotSum = sendNotSum;
	}


	public String getBussinessId() {
		return bussinessId;
	}


	public void setBussinessId(String bussinessId) {
		this.bussinessId = bussinessId;
	}


	public String get_id() {
		return _id;
	}


	public void set_id(String _id) {
		this._id = _id;
	}


	public Long getSysCompanyId() {
		return sysCompanyId;
	}


	public void setSysCompanyId(Long sysCompanyId) {
		this.sysCompanyId = sysCompanyId;
	}


	public String getRocketMsgId() {
		return rocketMsgId;
	}


	public void setRocketMsgId(String rocketMsgId) {
		this.rocketMsgId = rocketMsgId;
	}


	public String getMessageId() {
		return messageId;
	}


	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}


	public String getTaskId() {
		return taskId;
	}


	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}




	public String getOpenId() {
		return openId;
	}


	public void setOpenId(String openId) {
		this.openId = openId;
	}


	public String getMediaId() {
		return mediaId;
	}


	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}


	public String getMsgType() {
		return msgType;
	}


	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}


	public String getSendIgnoreReprint() {
		return sendIgnoreReprint;
	}


	public void setSendIgnoreReprint(String sendIgnoreReprint) {
		this.sendIgnoreReprint = sendIgnoreReprint;
	}


	public Long getBrandId() {
		return brandId;
	}


	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}


	public String getGroupName() {
		return groupName;
	}


	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}


	public String getHeadlTitle() {
		return headlTitle;
	}


	public void setHeadlTitle(String headlTitle) {
		this.headlTitle = headlTitle;
	}


	public String getDataBody() {
		return dataBody;
	}


	public void setDataBody(String dataBody) {
		this.dataBody = dataBody;
	}


	public String getMessageBody() {
		return messageBody;
	}


	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}


	public String getResultInfo() {
		return resultInfo;
	}


	public void setResultInfo(String resultInfo) {
		this.resultInfo = resultInfo;
	}


	public String getResultInfoDetail() {
		return resultInfoDetail;
	}


	public void setResultInfoDetail(String resultInfoDetail) {
		this.resultInfoDetail = resultInfoDetail;
	}


	public String getSendState() {
		return sendState;
	}


	public void setSendState(String sendState) {
		this.sendState = sendState;
	}


	public Date getUpdateDate() {
		return updateDate;
	}


	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}


	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	

	
	
    
}