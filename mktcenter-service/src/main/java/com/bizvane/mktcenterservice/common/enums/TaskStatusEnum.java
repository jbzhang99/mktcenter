package com.bizvane.mktcenterservice.common.enums;

/**
 * @author chen.li
 * @date on 2018/7/17 9:06
 * @description 任务状态枚举类
 *
 */
public enum TaskStatusEnum {

    TASK_STATUS_ALL(0,"全部"),
    TASK_STATUS_PENDING(1,"待执行"),
    TASK_STATUS_EXECUTING(2,"执行中"),
    TASK_STATUS_DISABLED(3,"已禁用"),
    TASK_STATUS_FINISHED(4,"已结束");

    private int code;
    private String message;

    TaskStatusEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static TaskStatusEnum getTaskStatusEnumByCode(int code){
        for(TaskStatusEnum taskStatusEnum : TaskStatusEnum.values()){
            if(code==taskStatusEnum.getCode()){
                return taskStatusEnum;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
