package com.bizvane.mktcenterservice.models.vo;

import java.util.Date;

/**
 * @Author: lijunwei
 * @Time: 2018/11/2 10:48
 */
public class SendMessageVO {
    private Long mktTaskId;
    private Integer taskType;
    private String taskName;
    private Long sysCompanyId;
    private Long sysBrandId;
    private String msgContent;
    private Boolean exceptWechat;
    private String msgType;
    private Integer points;
    private Date startTime;
    private Date endTime;
    private String type;
    public Long getMktTaskId() {
        return mktTaskId;
    }

    public void setMktTaskId(Long mktTaskId) {
        this.mktTaskId = mktTaskId;
    }

    public Integer getTaskType() {
        return taskType;
    }

    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
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

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    public Boolean getExceptWechat() {
        return exceptWechat;
    }

    public void setExceptWechat(Boolean exceptWechat) {
        this.exceptWechat = exceptWechat;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
}
