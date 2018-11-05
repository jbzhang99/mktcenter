package com.bizvane.mktcenterservice.models.vo;

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
}
