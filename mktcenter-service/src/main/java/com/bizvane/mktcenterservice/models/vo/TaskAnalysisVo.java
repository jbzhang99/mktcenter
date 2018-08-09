package com.bizvane.mktcenterservice.models.vo;

import java.util.Date;

/**
 * @Author: lijunwei
 * @Time: 2018/8/9 14:47
 * 分析结果分析
 */
public class TaskAnalysisVo {
 private  Long sysBrandId;
    private  Integer taskType;
    private String  taskName;
    private Date endTime;
    private Date  startTime;

    public Long getSysBrandId() {
        return sysBrandId;
    }

    public void setSysBrandId(Long sysBrandId) {
        this.sysBrandId = sysBrandId;
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

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
}
