package com.bizvane.mktcenterservice.common.enums;

/**
 * Created by agan on 2018/8/23.
 */
public enum ActivityConvertCouponTypeEnum {
    ACTIVITY_TYPE_ALL(0,"0","全部"),
    ACTIVITY_TYPE_REGISGER(1,"10","开卡活动"),
    ACTIVITY_TYPE_UPGRADE(2,"35","升级活动"),
    ACTIVITY_TYPE_QRCODE(3,"55","扫码领券活动"),
    ACTIVITY_TYPE_MANUAL(4,"55","手动领券活动"),
    ACTIVITY_TYPE_ORDER(5,"45","消费活动"),
    ACTIVITY_TYPE_SIGNIN(6,"50","签到活动"),
    ACTIVITY_TYPE_BIRTHDAY(7,"15","生日活动"),
    ACTIVITY_TYPE_SMART(8,"","智能营销活动"),
    ACTIVITY_TYPE_EVALUATION(9,"100","评价奖励活动"),
    ACTIVITY_TYPE_ANNIVERSARY(10,"90","纪念日活动");


    private int Activitycode;
    private String couponCode;
    private String message;


    ActivityConvertCouponTypeEnum(int Activitycode,String couponCode, String message) {
        this.Activitycode = Activitycode;
        this.couponCode = couponCode;
        this.message = message;
    }

    public static ActivityConvertCouponTypeEnum getActivityConvertCouponTypeEnumByCode(int code){
        for(ActivityConvertCouponTypeEnum activityConvertCouponTypeEnum : ActivityConvertCouponTypeEnum.values()){
            if(code==activityConvertCouponTypeEnum.getActivitycode()){
                return activityConvertCouponTypeEnum;
            }
        }
        return null;
    }

    public int getActivitycode() {
        return Activitycode;
    }

    public void setActivitycode(int activitycode) {
        Activitycode = activitycode;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
