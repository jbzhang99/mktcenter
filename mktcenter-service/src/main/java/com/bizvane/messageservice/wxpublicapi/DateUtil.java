package com.bizvane.messageservice.wxpublicapi;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author xiao.shu
 * @date on 2018/8/9 20:43
 * @description
 *
 */
public class DateUtil {
    /**
     * 获取某天时间的零点时间
     * @return
     */
    public static String getZeroTime(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date zero = calendar.getTime();
        String zeroStr=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(zero);
        return zeroStr;
    }
    
    /**
     * @param date    日期
     * @param pattern 日期格式
     * @return StringString
     * @description 使用用户格式格式化日期
     */
    public static String format(Date date, String pattern) {
        String returnValue = "";
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            returnValue = df.format(date);
        }
        return (returnValue);
    }

}
