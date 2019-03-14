package com.bizvane.mktcenterservice.common.utils;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author chen.li
 * @date on 2018/7/13 9:09
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
public class DateUtil {

    /**
     * 格式化时间
     * @param date
     * @param dateFormat
     * @return
     */
    public static String formatDateByPattern(Date date, String dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        String formatTimeStr = null;
        if (date != null) {
            formatTimeStr = sdf.format(date);
        }
        return formatTimeStr;
    }
    public static Date formatDateByPattern(Date date, SimpleDateFormat dateFormat) throws ParseException {
        Date parse=null;
        if (date != null) {
          String  formatTimeStr = dateFormat.format(date);
          parse = dateFormat.parse(formatTimeStr);
        }
        System.out.println("---"+parse);
        return parse;
    }
    /**
     * 获取cron表达式
     * @param date
     * @return
     */
    public static String getCronExpression(Date date) {
        String dateFormat = "ss mm HH dd MM ? yyyy";
        return formatDateByPattern(date, dateFormat);
    }

    /**
     * 获取某天时间的零点时间
     * @return
     */
    public static Date getZeroTime(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date zero = calendar.getTime();
        return zero;
    }

    /**
     * 获取两个时间间隔
     * @return
     */
    public static String getIntervalBetweenTwoDate(Date date1,Date date2){
        long between = date2.getTime() - date1.getTime();
        long day = between / (24 * 60 * 60 * 1000);
       /* long hour = (between / (60 * 60 * 1000) - day * 24);
        long min = ((between / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (between / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        long ms = (between - day * 24 * 60 * 60 * 1000 - hour * 60 * 60 * 1000
                - min * 60 * 1000 - s * 1000);*/
        String interval = day + "天"; /*+ hour + "小时" + min + "分" + s + "秒" + ms
                + "毫秒";*/
        return interval;
    }

}
