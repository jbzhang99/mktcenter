package com.bizvane.messageservice.common.sms.response;

public class SmsResult {
	
	/**
	 * 消息ID
	 */
	private String msgId;
	private String uid;
	/**
	 * 状态更新时间
	 */
	private String reportTime;
	/**
	 * 接收短信的手机号码
	 */
	private String mobile;
	/**
	 * 状态（详细参考状态报告状态码）
	 */
	private String status;
	/**
	 * 状态说明
	 */
	private String statusDesc;
	/**
	 * 拉取个数
	 */
	private String count;
	
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getMsgId() {
		return msgId;
	}
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	public String getReportTime() {
		return reportTime;
	}
	public void setReportTime(String reportTime) {
		this.reportTime = reportTime;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatusDesc() {
		return statusDesc;
	}
	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	
	
	


}
