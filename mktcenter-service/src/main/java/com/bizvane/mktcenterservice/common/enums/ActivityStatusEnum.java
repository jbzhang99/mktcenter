package com.bizvane.mktcenterservice.common.enums;

/**
 * @author chen.li
 * @date on 2018/7/13 17:18
 * @description 活动状态枚举类
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
public enum ActivityStatusEnum {

    ACTIVITY_STATUS_ALL(0,"全部"),
    ACTIVITY_STATUS_PENDING(1,"待执行"),
    ACTIVITY_STATUS_EXECUTING(2,"执行中"),
    ACTIVITY_STATUS_FINISHED(3,"已结束");

    private int code;
    private String message;

    ActivityStatusEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ActivityStatusEnum getActivityStatusEnumByCode(int code){
        for(ActivityStatusEnum activityStatusEnum : ActivityStatusEnum.values()){
            if(code==activityStatusEnum.getCode()){
                return activityStatusEnum;
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
