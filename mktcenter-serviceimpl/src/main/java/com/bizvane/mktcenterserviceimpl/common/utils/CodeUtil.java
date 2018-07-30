package com.bizvane.mktcenterserviceimpl.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: lijunwei
 * @Time: 2018/7/28 15:52
 */
public class CodeUtil {
    private  final  static String  TASK_PREFIX="TC";
    private  final  static String  ACTIVITY_PREFIX="AC";
    private  final  static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");

    public static synchronized  String  getTaskCode(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TASK_PREFIX);
        getRaCodedom(stringBuilder);
        return stringBuilder.toString();
    }

    public static String  getActivityCode(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(ACTIVITY_PREFIX);
        getRaCodedom(stringBuilder);
        return stringBuilder.toString();
    }

    private static synchronized  StringBuilder getRaCodedom(StringBuilder stringBuilder) {
        stringBuilder.append(sdf.format(new Date()));
        stringBuilder.append(Math.round(Math.random() * 9));
        return stringBuilder;
    }
}




