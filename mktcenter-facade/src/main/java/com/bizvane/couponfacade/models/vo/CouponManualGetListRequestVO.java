package com.bizvane.couponfacade.models.vo;

import java.io.Serializable;

public class CouponManualGetListRequestVO implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @io.swagger.annotations.ApiModelProperty(value = "券定义id",name = "couponDefinitionId", required = false,example = "")
  private Long couponDefinitionId;

  @io.swagger.annotations.ApiModelProperty(value = "品牌id",name = "sysBrandId", required = true,example = "")
  private Long sysBrandId;

  @io.swagger.annotations.ApiModelProperty(value = "任务状态",name = "taskStatus", required = false,example = "")
  private Byte taskStatus;

  @io.swagger.annotations.ApiModelProperty(value = "任务名称",name = "taskName", required = false,example = "")
  private String taskName;

  @io.swagger.annotations.ApiModelProperty(value = "发送开始时间",name = "sendTimeStart", required = false,example = "")
  private String sendTimeStart;

  @io.swagger.annotations.ApiModelProperty(value = "发送结束时间",name = "sendTimeEnd", required = false,example = "")
  private String sendTimeEnd;

  @io.swagger.annotations.ApiModelProperty(value = "创建开始时间",name = "createDateStart", required = false,example = "")
  private String createDateStart;

  @io.swagger.annotations.ApiModelProperty(value = "创建结束时间",name = "createDateEnd", required = false,example = "")
  private String createDateEnd;

  public Long getCouponDefinitionId() {
    return couponDefinitionId;
  }

  public void setCouponDefinitionId(Long couponDefinitionId) {
    this.couponDefinitionId = couponDefinitionId;
  }

  public Byte getTaskStatus() {
    return taskStatus;
  }

  public void setTaskStatus(Byte taskStatus) {
    this.taskStatus = taskStatus;
  }

  public String getTaskName() {
    return taskName;
  }

  public void setTaskName(String taskName) {
    this.taskName = taskName;
  }

  public String getSendTimeStart() {
    return sendTimeStart;
  }

  public void setSendTimeStart(String sendTimeStart) {
    this.sendTimeStart = sendTimeStart;
  }

  public String getSendTimeEnd() {
    return sendTimeEnd;
  }

  public void setSendTimeEnd(String sendTimeEnd) {
    this.sendTimeEnd = sendTimeEnd;
  }

  public String getCreateDateStart() {
    return createDateStart;
  }

  public void setCreateDateStart(String createDateStart) {
    this.createDateStart = createDateStart;
  }

  public String getCreateDateEnd() {
    return createDateEnd;
  }

  public void setCreateDateEnd(String createDateEnd) {
    this.createDateEnd = createDateEnd;
  }

  public Long getSysBrandId() {
    return sysBrandId;
  }

  public void setSysBrandId(Long sysBrandId) {
    this.sysBrandId = sysBrandId;
  }
}
