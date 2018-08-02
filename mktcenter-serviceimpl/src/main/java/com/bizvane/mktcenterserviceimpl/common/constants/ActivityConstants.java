package com.bizvane.mktcenterserviceimpl.common.constants;

/**
 * @author chen.li
 * @date on 2018/7/13 10:13
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
public class ActivityConstants {

    //活动主体
    public static String ERROR_MSG_ACTIVITY_NAME_EMPTY ="活动名称为空";
    public static String ERROR_MSG_ACTIVITY_LONG_TERM_EMPTY ="活动是否长期为空";
    public static String ERROR_MSG_ACTIVITY_DATE_EMPTY ="活动起止日期为空";
    public static String ERROR_MSG_ACTIVITY_INFO_EMPTY ="活动说明为空";
    public static String ERROR_MSG_ACTIVITY_TYPE_EMPTY ="活动类型为空";

    public static String ERROR_MSG_ACTIVITY_TYPE_NOT_EXISTS ="活动类型不存在";

    //开卡活动
    public static String ERROR_MSG_OFFLINE_CARD_STATUS_EMPTY ="线下是否开卡为空";
    public static String ERROR_MSG_MBR_LEVEL_CODE_EMPTY ="开卡时会员等级编号为空";
    public static String ERROR_MSG_MBR_LEVEL_NAME_EMPTY ="开卡时会员等级名称为空";

    //升级活动
    public static String ERROR_MSG_MEMBER_TYPE_EMPTY ="针对的会员类型为空";

    //生日活动
    public static String ERROR_MSG_DAYS_AHEAD ="生日券提前多少日为空";

    //消费活动
    public static String ERROR_MSG_ORDER_SOURCE_EMPTY ="订单来源为空";
    public static String ERROR_MSG_ORDER_MIN_PRICE_EMPTY ="消费最低金额为空";

    //智能营销
    public static Long SMART_ACTIVITY_GROUP = 0L;
    public static String SMART_ACTIVITY_TASK_NAME_EMPTY = "智能营销名称为空";
    public static String SMART_ACTIVITY_TARGET_MEMBER_EMPTY = "智能营销会员条件为空";
    public static String SMART_ACTIVITY_COPY = "-副本";
    public static String SMART_ACTIVITY_ID_EMPTY = "活动id为空";


    public static final String CAN_NOT_RECEIVE = "领取已超过限制，不可再领取";
    public static final  String ERROR_SQL="操作失败";
    public static final  String RETURN_EMPTY="数据为空";

}
