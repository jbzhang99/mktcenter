package com.bizvane.mktcenterservice.models.bo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: lijunwei
 * @Time: 2018/7/31 11:42
 */
public class TaskDetailBO {
    private Long mktTaskId;
    private Long sysCompanyId;
    private Long sysBrandId;
    private String taskCode;
    private Integer taskType;
    private String taskName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date startTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date endTime;
    private Integer points;
    private Integer checkStatus;
    private Integer taskStatus;
    private String remark;
    private String taskInfo;
    private String taskListImg;
    private String taskDetailImg;

    private Long mktTaskOrderId;
    private Integer orderSource;
    private BigDecimal consumeAmount;
    private Integer consumeTimes;

    private Long mktTaskInviteId;
    private Integer inviteNum;

    private Long mktCouponId;
    private Long couponId;
    private String couponCode;
    private String couponName;

    private Long mktMsgId;
    private Integer bizType;
    private Long bizId;
    private String msgType;
    private String msgCode;
    private String templateMsgId;
    private Date sendTime;

    public Long getMktTaskId() {
        return mktTaskId;
    }

    public void setMktTaskId(Long mktTaskId) {
        this.mktTaskId = mktTaskId;
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

    public String getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode;
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

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

    public Integer getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTaskInfo() {
        return taskInfo;
    }

    public void setTaskInfo(String taskInfo) {
        this.taskInfo = taskInfo;
    }

    public String getTaskListImg() {
        return taskListImg;
    }

    public void setTaskListImg(String taskListImg) {
        this.taskListImg = taskListImg;
    }

    public String getTaskDetailImg() {
        return taskDetailImg;
    }

    public void setTaskDetailImg(String taskDetailImg) {
        this.taskDetailImg = taskDetailImg;
    }

    public Long getMktTaskOrderId() {
        return mktTaskOrderId;
    }

    public void setMktTaskOrderId(Long mktTaskOrderId) {
        this.mktTaskOrderId = mktTaskOrderId;
    }

    public Integer getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(Integer orderSource) {
        this.orderSource = orderSource;
    }

    public BigDecimal getConsumeAmount() {
        return consumeAmount;
    }

    public void setConsumeAmount(BigDecimal consumeAmount) {
        this.consumeAmount = consumeAmount;
    }

    public Integer getConsumeTimes() {
        return consumeTimes;
    }

    public void setConsumeTimes(Integer consumeTimes) {
        this.consumeTimes = consumeTimes;
    }

    public Long getMktTaskInviteId() {
        return mktTaskInviteId;
    }

    public void setMktTaskInviteId(Long mktTaskInviteId) {
        this.mktTaskInviteId = mktTaskInviteId;
    }

    public Integer getInviteNum() {
        return inviteNum;
    }

    public void setInviteNum(Integer inviteNum) {
        this.inviteNum = inviteNum;
    }

    public Long getMktCouponId() {
        return mktCouponId;
    }

    public void setMktCouponId(Long mktCouponId) {
        this.mktCouponId = mktCouponId;
    }

    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public Long getMktMsgId() {
        return mktMsgId;
    }

    public void setMktMsgId(Long mktMsgId) {
        this.mktMsgId = mktMsgId;
    }

    public Integer getBizType() {
        return bizType;
    }

    public void setBizType(Integer bizType) {
        this.bizType = bizType;
    }

    public Long getBizId() {
        return bizId;
    }

    public void setBizId(Long bizId) {
        this.bizId = bizId;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(String msgCode) {
        this.msgCode = msgCode;
    }

    public String getTemplateMsgId() {
        return templateMsgId;
    }

    public void setTemplateMsgId(String templateMsgId) {
        this.templateMsgId = templateMsgId;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }
}
