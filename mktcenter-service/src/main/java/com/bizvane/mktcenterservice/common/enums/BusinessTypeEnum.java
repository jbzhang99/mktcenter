package com.bizvane.mktcenterservice.common.enums;

/**
 * @author chen.li
 * @date on 2018/7/13 17:40
 * @description 业务类型枚举
 *
 */
public enum BusinessTypeEnum {

    /**
     * 全部
     */
    ACTIVITY_TYPE_ALL(0,"全部"),
    ACTIVITY_TYPE_ACTIVITY(1,"营销活动"),
    ACTIVITY_TYPE_TASK(2,"营销任务");

    private int code;
    private String message;

    BusinessTypeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static BusinessTypeEnum getBusinessTypeEnumByCode(int code){
        for(BusinessTypeEnum checkStatusEnum : BusinessTypeEnum.values()){
            if(code==checkStatusEnum.getCode()){
                return checkStatusEnum;
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
