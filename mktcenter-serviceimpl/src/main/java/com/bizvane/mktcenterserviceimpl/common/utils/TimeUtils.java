package com.bizvane.mktcenterserviceimpl.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @Author: lijunwei
 * @Time: 2018/7/30 11:00
 */
public class TimeUtils {
   public static  final  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static  final  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    /**"
     * 获取当前时间
     * @return
     */
    public  static Date  getNowTime(){
        Date currentTime = new Date();
        String dateString = formatter.format(currentTime);
        ParsePosition pos = new ParsePosition(0);
        Date currentTime_2 = formatter.parse(dateString, pos);
        return currentTime_2;

    }
    /**
     * 判断任务是否滞后执行
     *
     */
    
    public static Integer  IsImmediatelyRun(Date timeparam) throws ParseException {
        timeparam=sdf.parse(sdf.format(timeparam));
        Date dateNow = sdf.parse(sdf.format(new Date()));

        if (timeparam.before(dateNow)) {
            //小于当前时间
        return Integer.valueOf(1);
       } else if (timeparam.after(dateNow)) {
            //大于当前时间
            return Integer.valueOf(2);
       } else {
            //等于当前时间
            return Integer.valueOf(1);
       }
    }

    public static Date getNextDay(Date date){
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,1);
        Date date1 = calendar.getTime();
        return date1;
    }


}
