package com.bizvane.mktcenterservice.models.bo;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * @Author: lijunwei
 * @Time: 2018/8/15 10:20
 */
public class TaskWXBO {


    private  Long taskId;
    private String   taskCode ;
    private String taskName ;
    private Integer  taskType ;
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
    private Integer  rewarded;  // 1=已完成  0未完成
    private String  task_progress; //进度

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Integer getTaskType() {
        return taskType;
    }

    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
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

    public Integer getRewarded() {
        return rewarded;
    }

    public void setRewarded(Integer rewarded) {
        this.rewarded = rewarded;
    }

    public String getTask_progress() {
        return task_progress;
    }

    public void setTask_progress(String task_progress) {
        this.task_progress = task_progress;
    }
}
