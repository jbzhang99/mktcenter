package com.bizvane.mktcenterserviceimpl.common.enums;

/**
 * 砸金蛋枚举值
 *
 * @author liufq*/
public enum  GoldenStatisticsEnum {
    VISITORS_COUNT(0,"访问人数"),
    PARTICIPATE_MEMBER_COUNT(1,"参与会员数"),
    PAGE_FORWARD_COUNT(2,"页面转发次数"),
    EFFECTIVE_SHARING_COUNT(3,"有效分享人数"),
    REGISTER_MEMBERS_COUNT(4,"注册会员数");


    private int code;
    private String message;


    GoldenStatisticsEnum(int code,String message){
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
