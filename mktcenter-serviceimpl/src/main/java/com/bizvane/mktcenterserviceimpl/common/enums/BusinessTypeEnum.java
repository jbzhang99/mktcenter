package com.bizvane.mktcenterserviceimpl.common.enums;

/**
 * @author chen.li
 * @date on 2018/7/14 13:35
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
public enum BusinessTypeEnum {

    ACTIVITY_TYPE_ACTIVITY(1,"营销活动"),
    ACTIVITY_TYPE_TASK(2,"营销任务");

    private int code;
    private String message;

    BusinessTypeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static BusinessTypeEnum getBusinessTypeEnumByCode(int code){
        for(BusinessTypeEnum businessTypeEnum : BusinessTypeEnum.values()){
            if(code==businessTypeEnum.getCode()){
                return businessTypeEnum;
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
