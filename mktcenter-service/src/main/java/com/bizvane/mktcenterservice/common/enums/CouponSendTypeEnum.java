package com.bizvane.mktcenterservice.common.enums;

/**
 * 业务类型枚举类
 */
public enum CouponSendTypeEnum {

   /* SEND_COUPON_OPNE_CARD("10",0,"开卡发券"),*/
    SEND_COUPON_BIRTH("15",7,"生日发券"),
    SEND_COUPON_GIVE("20",0,"受赠"),
    SEND_COUPON_INTEGRAL("25",0,"积分兑换"),
    SEND_COUPON_ONLINE_ACTIVITY("10",1,"线上开卡"),
    SEND_COUPON_UPGRADE_ACTIVITY("35",2,"会员升级"),
    //SEND_COUPON_BIRTH_ACTIVITY("40",7,"会员生日"),
    SEND_COUPON_COUSUME_ACTIVITY("45",5,"会员消费"),
    SEND_COUPON_SIGN_ACTIVITY("50",6,"会员签到"),
    SEND_COUPON_RECEIVE_QRCODE_ACTIVITY("55",3,"扫码领券活动"),
    SEND_COUPON_RECEIVE_MANUAL_ACTIVITY("55",4,"手动领券活动"),
    SEND_COUPON_INFORM_TASK("60",1,"完善资料"),
    SEND_COUPON_WX_SHARE_TASK("65",2,"微信分享"),
    SEND_COUPON_COUSUME_TIMES_TASK("70",4,"消费次数"),
    SEND_COUPON_COUSUME_MONEY_TASK("75",5,"消费金额"),
    SEND_COUPON_INVITE_OPENCARD_TASK("80",3,"邀请注册"),
    SEND_COUPON_Aniversary("90",10,"入会纪念日活动"),
    SEND_COUPON_Evaluation("100",9,"评价奖励活动");

    private String couponModuleCode;
    private String message;
    private int mktModuleCode;
    CouponSendTypeEnum(String couponModuleCode,int mktModuleCode, String message){
        this.couponModuleCode = couponModuleCode;
        this.mktModuleCode = mktModuleCode;
        this.message = message;
    }

    public static CouponSendTypeEnum getCouponSendTypeEnumByMktModuleCode(int mktModuleCode){
        for(CouponSendTypeEnum couponSendTypeEnum : CouponSendTypeEnum.values()){
            if(mktModuleCode==couponSendTypeEnum.getMktModuleCode()){
                return couponSendTypeEnum;
            }
        }
        return null;
    }

    public String getCouponModuleCode() {
        return couponModuleCode;
    }

    public void setCouponModuleCode(String couponModuleCode) {
        this.couponModuleCode = couponModuleCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getMktModuleCode() {
        return mktModuleCode;
    }

    public void setMktModuleCode(int mktModuleCode) {
        this.mktModuleCode = mktModuleCode;
    }
}
