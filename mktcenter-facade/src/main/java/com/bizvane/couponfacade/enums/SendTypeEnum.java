package com.bizvane.couponfacade.enums;

/**
 * 券实例发放类型枚举类
 * Created by yunjie.tian on 2018/8/9.
 */
public enum SendTypeEnum {

    SEND_COUPON_OPNE_CARD("10","开卡发券"),
    SEND_COUPON_BIRTH("15","会员生日"),
    SEND_COUPON_GIVE("20","受赠"),
    SEND_COUPON_INTEGRAL("25","积分兑换"),
    //SEND_COUPON_ONLINE_ACTIVITY("30","线上开卡"),
    SEND_COUPON_UPGRADE_ACTIVITY("35","会员升级"),
    //SEND_COUPON_BIRTH_ACTIVITY("40","会员生日"),
    SEND_COUPON_COUSUME_ACTIVITY("45","会员消费"),
    SEND_COUPON_SIGN_ACTIVITY("50","会员签到"),
    SEND_COUPON_RECEIVE_ACTIVITY("55","领券"),
    SEND_COUPON_SOCIAL_ACTIVITY ("56","社交活动"),
    SEND_COUPON_INFORM_TASK("60","完善资料"),
    SEND_COUPON_WX_SHARE_TASK("65","微信分享"),
    SEND_COUPON_COUSUME_TIMES_TASK("70","消费次数"),
    SEND_COUPON_COUSUME_MONEY_TASK("75","消费金额"),
    SEND_COUPON_INVITE_OPENCARD_TASK("80","邀请开卡"),
    SEND_COUPON_BATCH("85","手动发券"),
    SEND_COUPON_MEMORY_DAY("90","入会纪念日"),
    SEND_COUPON_MEMBER_GROUP("94","会员分组运营"),
    SEND_COUPON_ORIENT_MARKET("95","智能营销"),
    SEND_COUPON_REIVEW("100","评价奖励活动"),
    SEND_COUPON_INTEGRAL_MALl("101","积分商城"),
    SEND_COUPON_QUOTA_MALl("102","企业微信配额券"),
    SEND_COUPON_ROTARRY("103","大转盘"),
    SEND_COUPON_RED("104","红包膨胀"),
    SEND_COUPON_EGGS("105","砸金蛋")




    ;
    private String code;
    private String message;
    SendTypeEnum(String code,String message){
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static String getValue(String code){
        for(com.bizvane.couponfacade.enums.SendTypeEnum ele : values()){
            if(ele.getCode().equals(code))
                return ele.getMessage();
        }
        return "无匹配券类型";
    }


}
