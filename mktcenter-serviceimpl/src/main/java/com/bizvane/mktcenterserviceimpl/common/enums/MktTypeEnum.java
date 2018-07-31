package com.bizvane.mktcenterserviceimpl.common.enums;

/**
 * @author chen.li
 * @date on 2018/7/30 17:17
 * @description 营销方式
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
public enum MktTypeEnum {

    TASK_STATUS_ALL(0,"全部"),
    TASK_STATUS_PENDING(1,"优惠券营销"),
    TASK_STATUS_EXECUTING(2,"积分营销"),
    TASK_STATUS_DISABLED(3,"短信营销"),
    TASK_STATUS_FINISHED(4,"微信模板消息营销");

    private int code;
    private String message;

    MktTypeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static MktTypeEnum getMktTypeEnumByCode(int code){
        for(MktTypeEnum mktTypeEnum : MktTypeEnum.values()){
            if(code==mktTypeEnum.getCode()){
                return mktTypeEnum;
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
