package com.bizvane.messageservice.common.network;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: lijunwei
 * @Time: 2018/7/17 14:03
 */
public class TimeUtils {
  private  static  final   SimpleDateFormat SIMPLE_Date_Format = new SimpleDateFormat("MMddHHmmss");
  public static final SimpleDateFormat DATETIME_FORMAT_DATE_NO = new SimpleDateFormat("yyyyMMddHHmmss");
  //public static final SimpleDateFormat DATETIME_FORMAT_DATE_NO = new SimpleDateFormat("yyyyMMddHHmmss");
  public static final SimpleDateFormat DATETIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static String getCurrentTimeInString() {
        return SIMPLE_Date_Format.format(new Date());
    }

    public static String getCurrentTimeLYM() {
        return DATETIME_FORMAT_DATE_NO.format(new Date());
    }

    public  static  String  getTimeString(SimpleDateFormat format){
        return format.format(new Date());
    }
}
