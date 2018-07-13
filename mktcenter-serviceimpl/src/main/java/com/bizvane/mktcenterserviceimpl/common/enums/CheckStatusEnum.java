package com.bizvane.mktcenterserviceimpl.common.enums;

/**
 * @author chen.li
 * @date on 2018/7/13 17:40
 * @description 审核状态枚举类
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
public enum CheckStatusEnum {

    CHECK_STATUS_ALL(0,"全部"),
    CHECK_STATUS_PENDING(1,"待审核"),
    CHECK_STATUS_CHECKING(2,"审核中"),
    CHECK_STATUS_APPROVED(3,"已审核"),
    CHECK_STATUS_REJECTED(4,"已驳回");

    private int code;
    private String message;

    CheckStatusEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static CheckStatusEnum getCheckStatusEnumByCode(int code){
        for(CheckStatusEnum checkStatusEnum : CheckStatusEnum.values()){
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
