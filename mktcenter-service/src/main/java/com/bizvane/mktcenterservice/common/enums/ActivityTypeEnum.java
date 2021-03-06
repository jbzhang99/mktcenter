package com.bizvane.mktcenterservice.common.enums;

/**
 * @author chen.li
 * @date on 2018/7/13 11:05
 * @description 活动类型枚举类
 *
 */
public enum ActivityTypeEnum {

    ACTIVITY_TYPE_ALL(0,"全部"),
    ACTIVITY_TYPE_REGISGER(1,"开卡活动"),
    ACTIVITY_TYPE_UPGRADE(2,"升级活动"),
    ACTIVITY_TYPE_QRCODE(3,"扫码领券活动"),
    ACTIVITY_TYPE_MANUAL(4,"手动领券活动"),
    ACTIVITY_TYPE_ORDER(5,"消费活动"),
    ACTIVITY_TYPE_SIGNIN(6,"签到活动"),
    ACTIVITY_TYPE_BIRTHDAY(7,"生日活动"),
    ACTIVITY_TYPE_SMART(8,"智能营销活动"),
    ACTIVITY_TYPE_EVALUATION(9,"评价奖励活动"),
    ACTIVITY_TYPE_ANNIVERSARY(10,"纪念日活动"),
    ACTIVITY_TYPE_PRIZE(11,"大转盘抽奖活动"),
    ACTIVITY_TYPE_REDBAGS(12,"红包膨胀活动"),
    ACTIVITY_TYPE_EGGS(13,"砸金蛋活动"),
    ACTIVITY_TYPE_INVITE(14,"邀请开卡活动");

    private int code;
    private String message;

    ActivityTypeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ActivityTypeEnum getActivityTypeEnumByCode(int code){
        for(ActivityTypeEnum activityTypeEnum : ActivityTypeEnum.values()){
            if(code==activityTypeEnum.getCode()){
                return activityTypeEnum;
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
