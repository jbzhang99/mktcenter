package com.bizvane.mktcenterservice.common.constants;

/**
 * @author chen.li
 * @date on 2018/7/14 20:46
 * @description
 *
 */
public class JobHandlerConstants {
    //开始执行活动
    public static String activity = "activity";
    //任务
    public static String task = "task";
    public static String START_TASK = "startTaskJob";
    public static String END_TASK = "endTaskJob";
    //短信
    public static String MESSAGE_SEND_DX= "messageDXTaskJob";
    //消息
    public static String MESSAGE_SEND_XX= "messageXXTaskJob";

    //结束活动
    public static String endActivity = "endActivity";
    //生日活动开始
    public static String startActivityBirthday = "startActivityBirthday";
    //生日活动结束
    public static String endActivityBirthday = "endActivityBirthday";
    //纪念日活动开始
    public static String startActivityAniversary = "startActivityAniversary";
    //纪念日活动结束
    public static String endActivityAniversary = "endActivityAniversary";
    //每日执行的生日活动
    public  static String everyDayActivityBirthday = "everyDayActivityBirthday";
    //入会纪念日
    public  static String everyDayActivityAniversary ="everyDayActivityAniversary";
    public static String smartActivity = "smartActivity";

    public static String sendMessageActivity = "sendMessageActivity";

    //纪念日活动开始
    public static String START_PRIZE = "startPrize";
    //纪念日活动结束
    public static String END_PRIZE= "endPrize";


    public static String START_RED_PACKET= "startRedPacket";
    public static String END_RED_PACKET= "endRedPacket";
}
