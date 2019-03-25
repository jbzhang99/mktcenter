package com.bizvane.messagefacade.models.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by yunjie.tian on 2018/7/16.
 */
public class GenrealSendMessageVO implements Serializable{

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "会员姓名", name = "memberName", required = false, example = "")
    private String memberName;
    
    @ApiModelProperty(value = "所属企业id", name = "sysCompanyId", required = false, example = "")
    private Long sysCompanyId;
    
    @ApiModelProperty(value = "所属品牌id", name = "sysBrandId", required = false, example = "")
    private Long sysBrandId;
    
    @ApiModelProperty(value = "任务Id", name = "taskId", required = false, example = "")
    private Long taskId;
    
    @ApiModelProperty(value = "批量短信类型消息：BATCH_TEMPLATE_MESSAGE,批量短信类型消息无模板：BATCH_TEMPLATE_MESSAGE_NOT_SMS_TEMP", name = "templateType", required = false, example = "")
    private String templateType;

    @ApiModelProperty(value = "手机号", name = "phoneStr", required = false, example = "")
    private String phoneStr;
    @ApiModelProperty(value = "短信内容", name = "messageBody", required = false, example = "")
    private String messageBody;
    
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "短信发送时间",name = "sendTime",required = false,example = "")
    private Date sendTime;
    

	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public Long getSysCompanyId() {
		return sysCompanyId;
	}
	public void setSysCompanyId(Long sysCompanyId) {
		this.sysCompanyId = sysCompanyId;
	}
	public Long getSysBrandId() {
		return sysBrandId;
	}
	public void setSysBrandId(Long sysBrandId) {
		this.sysBrandId = sysBrandId;
	}
	public Long getTaskId() {
		return taskId;
	}
	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}
	public String getTemplateType() {
		return templateType;
	}
	public void setTemplateType(String templateType) {
		this.templateType = templateType;
	}
	public String getPhoneStr() {
		return phoneStr;
	}
	public void setPhoneStr(String phoneStr) {
		this.phoneStr = phoneStr;
	}
	public String getMessageBody() {
		return messageBody;
	}
	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}
    

    

}
