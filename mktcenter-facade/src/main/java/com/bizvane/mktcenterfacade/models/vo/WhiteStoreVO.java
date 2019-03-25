package com.bizvane.mktcenterfacade.models.vo;

import java.util.Date;

/**
 * @Author: lijunwei
 * @Time: 2018/11/5 9:39
 */
public class WhiteStoreVO {
  private  Long sysbrandId;
  private  Integer taskType;
  private  Date startTime;
  private  Date endTime;
  private Integer activityType;
  private String mbrLevelCode;
  private String date1;
  private String date2;

    public Integer getActivityType() {
        return activityType;
    }

    public void setActivityType(Integer activityType) {
        this.activityType = activityType;
    }

    public String getMbrLevelCode() {
        return mbrLevelCode;
    }

    public void setMbrLevelCode(String mbrLevelCode) {
        this.mbrLevelCode = mbrLevelCode;
    }

    public Long getSysbrandId() {
        return sysbrandId;
    }

    public void setSysbrandId(Long sysbrandId) {
        this.sysbrandId = sysbrandId;
    }

    public Integer getTaskType() {
        return taskType;
    }

    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
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

    public String getDate1() {
        return date1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }

    public String getDate2() {
        return date2;
    }

    public void setDate2(String date2) {
        this.date2 = date2;
    }

}
