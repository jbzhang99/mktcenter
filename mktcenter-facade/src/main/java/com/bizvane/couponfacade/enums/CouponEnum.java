package com.bizvane.couponfacade.enums;

/**
 * 券枚举类
 * Created by yunjie.tian on 2018/8/9.
 */
public enum CouponEnum {

    /**
     * 手动发券类型
     */
    COUPON_MANUAL_SEND_TYPE_NOW("1","立即发送"),
    COUPON_MANUAL_SEND_TYPE_SOMEDAY("2","指定时间"),

    /**
     * 发券失败原因
     */
    FAIL_REASON_ERT("1","同步到线下erp失败");

    private String code;
    private String msg;
    CouponEnum(String code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
