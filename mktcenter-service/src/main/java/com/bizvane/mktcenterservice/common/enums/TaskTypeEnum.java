package com.bizvane.mktcenterservice.common.enums;

/**
 * @author chen.li
 * @date on 2018/7/17 9:06
 * @description 任务类型枚举类
 *
 */
public enum TaskTypeEnum {

    TASK_TYPE_ALL(0,"全部"),
    TASK_TYPE_PROFILE(1,"完善资料"),
    TASK_TYPE_SHARE(2,"分享任务"),
    TASK_TYPE_INVITE(3,"邀请注册"),
    TASK_TYPE_CONSUME_TIMES(4,"累计消费次数"),
    TASK_TYPE_CONSUME_AMOUNT(5,"累计消费金额");

    private int code;
    private String message;

    TaskTypeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static TaskTypeEnum getTaskTypeEnumByCode(int code){
        for(TaskTypeEnum taskTypeEnum : TaskTypeEnum.values()){
            if(code==taskTypeEnum.getCode()){
                return taskTypeEnum;
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
