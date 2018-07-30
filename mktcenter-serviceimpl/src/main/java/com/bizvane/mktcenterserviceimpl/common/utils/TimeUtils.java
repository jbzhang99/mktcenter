package com.bizvane.mktcenterserviceimpl.common.utils;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: lijunwei
 * @Time: 2018/7/30 11:00
 */
public class TimeUtils {
    /**
     * 获取当前时间
     * @return
     */
    public  static Date  getNowTime(){
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        ParsePosition pos = new ParsePosition(0);
        Date currentTime_2 = formatter.parse(dateString, pos);
        return currentTime_2;

    }
}
