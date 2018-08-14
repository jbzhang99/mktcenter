package com.bizvane.mktcenterserviceimpl.common.enums;

/**
 * @author chen.li
 * @date on 2018/7/30 17:17
 * @description 营销方式
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
public enum MktSmartTypeEnum {

    SMART_TYPE_ALL(0,"全部"),
    SMART_TYPE_COUPON(1,"优惠券营销"),
    SMART_TYPE_INTEGRAL(2,"积分营销"),
    SMART_TYPE_SMS(3,"短信营销"),
    SMART_TYPE_WXMESSAGE(4,"微信模板消息营销"),
    SMART_TYPE_MESSAGE(5,"短信营销/微信模板消息营销"),
    SMART_TYPE_COUPON_BATCH(6,"批量券");

    private int code;
    private String message;

    MktSmartTypeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static MktSmartTypeEnum getMktSmartTypeEnumByCode(int code){
        for(MktSmartTypeEnum mktTypeEnum : MktSmartTypeEnum.values()){
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
