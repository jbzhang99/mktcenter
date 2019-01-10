package com.bizvane.mktcenterserviceimpl.common.enums;

/**
 * 红包统计枚举类
 * @author yy
 * @create 2019-01-08 19:45
 */
public enum StatisticsEnum {
    VISITORS_COUNT(0,"访问人数"),
    LAUNCH_MEMBERS_COUNT(1,"发起会员人数"),
    HELP_MEMBERS_COUNT(2,"助力会员人数"),
    REGISTER_MEMBERS_COUNT(3,"注册会员人数"),
    TAKE_COUPON_COUNT(4,"领劵数量");


    private int code;
    private String message;


     StatisticsEnum(int code,String message){
        this.code = code;
        this.message = message;
    }

    public static StatisticsEnum getStatisticsEnumByCode(int code){
        for(StatisticsEnum statisticsEnum : StatisticsEnum.values()){
            if(code==statisticsEnum.getCode()){
                return statisticsEnum;
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
