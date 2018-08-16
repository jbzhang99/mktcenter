package com.bizvane.mktcenterservice.models.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @Author: lijunwei
 * @Time: 2018/8/15 11:50
 */
public class TaskWXDetailBO {
    private Long mktTaskId;
    private String taskName ;
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            locale = "zh",
            timezone = "GMT+8"
    )
    @DateTimeFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    private Date start_time;
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            locale = "zh",
            timezone = "GMT+8"
    )
    @DateTimeFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    private Date   end_time;
    private  String  taskInfo;
    private Integer points;
    List<TaskCouponWXBO>  taskCouponWXBOs;

    public Long getMktTaskId() {
        return mktTaskId;
    }

    public void setMktTaskId(Long mktTaskId) {
        this.mktTaskId = mktTaskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public List<TaskCouponWXBO> getTaskCouponWXBOs() {
        return taskCouponWXBOs;
    }

    public void setTaskCouponWXBOs(List<TaskCouponWXBO> taskCouponWXBOs) {
        this.taskCouponWXBOs = taskCouponWXBOs;
    }

    public String getTaskInfo() {
        return taskInfo;
    }

    public void setTaskInfo(String taskInfo) {
        this.taskInfo = taskInfo;
    }
}
