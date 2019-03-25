package com.bizvane.messagefacade.models.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by yunjie.tian on 2018/7/16.
 */
public class GenrealGetMessageVO implements Serializable{

    private static final long serialVersionUID = 1L;

    
    @ApiModelProperty(value = "所属品牌id", name = "sysBrandId", required = false, example = "")
    private Long sysBrandId;
    
    @ApiModelProperty(value = "任务Id", name = "taskId", required = false, example = "")
    private Long taskId;
    
    @ApiModelProperty(value = "批量消息类型消息：BATCH_TEMPLATE_MESSAGE", name = "批量消息类型消息类型", required = false, example = "")
    private String templateType;

    
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "短信发送的最早时间",name = "sentTimeStart",required = false,example = "")
    private Date sendTimeStart;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "短信发送的最晚时间",name = "sendTimeEnd",required = false,example = "")
    private Date sendTimeEnd;
    
    

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

	public Date getSendTimeStart() {
		return sendTimeStart;
	}
	public void setSendTimeStart(Date sendTimeStart) {
		this.sendTimeStart = sendTimeStart;
	}
	public Date getSendTimeEnd() {
		return sendTimeEnd;
	}
	public void setSendTimeEnd(Date sendTimeEnd) {
		this.sendTimeEnd = sendTimeEnd;
	}

 
    

}
