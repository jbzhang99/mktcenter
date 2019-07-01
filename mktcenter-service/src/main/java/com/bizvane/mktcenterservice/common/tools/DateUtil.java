package com.bizvane.mktcenterservice.common.tools;


import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtil {

    public static String ymdhms = "yyyy-MM-dd HH:mm:ss";
    public static String ymdhmsS = "yyyy-MM-dd HH:mm:ss SSS";

    public static String ymd = "yyyy-MM-dd";

    public static SimpleDateFormat ymdSDF = new SimpleDateFormat(ymd);

    private static String year = "yyyy";

    private static String month = "MM";

    private static String day = "dd";

    private static String yyyyMMdd_yd = "yyyyMMdd";

    public static SimpleDateFormat yyyyMMddHHmmss = new SimpleDateFormat(ymdhms);

    public static SimpleDateFormat yearSDF = new SimpleDateFormat(year);

    public static SimpleDateFormat monthSDF = new SimpleDateFormat(month);

    public static SimpleDateFormat daySDF = new SimpleDateFormat(day);


    private static final ThreadLocal<DateFormat> messageFormat = new ThreadLocal<DateFormat>();

    private static final DateFormat getYesterdayStringThreadLocal() {
        DateFormat format = messageFormat.get();
        if (format == null) {
            format = new SimpleDateFormat(yyyyMMdd_yd, Locale.getDefault());
            messageFormat.set(format);
        }
        return format;
    }

    private static final ThreadLocal<DateFormat> messageFormatyyyyMMdd = new ThreadLocal<DateFormat>();

    private static final DateFormat getYesterdayyyyyMMddStringThreadLocal() {
        DateFormat format = messageFormatyyyyMMdd.get();
        if (format == null) {
            format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            messageFormatyyyyMMdd.set(format);
        }
        return format;
    }

    private static final ThreadLocal<DateFormat> messageFormatymdhms = new ThreadLocal<DateFormat>();

    private static final DateFormat getYesterdayymdhmsStringThreadLocal() {
        DateFormat format = messageFormatymdhms.get();
        if (format == null) {
            format = new SimpleDateFormat(ymdhms, Locale.getDefault());
            messageFormatymdhms.set(format);
        }
        return format;
    }

    public static SimpleDateFormat yyyyMMddHHmm = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm");

    public static SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyy-MM-dd");

    public static SimpleDateFormat yyyyMMddHH_NOT_ = new SimpleDateFormat(
            "yyyyMMdd");

    public static long DATEMM = 86400L;

    /**
     * 获得当前时间
     * 格式：2014-12-02 10:38:53
     *
     * @return String
     */
    public static String getCurrentTime() {
        return yyyyMMddHHmmss.format(new Date());
    }

    /**
     * 可以获取昨天的日期
     * 格式：2014-12-01
     *
     * @return String
     */
    public static String getYesterdayYYYYMMDD() {
        Date date = new Date(System.currentTimeMillis() - DATEMM * 1000L);
        String str = yyyyMMdd.format(date);
        try {
            date = getYesterdayymdhmsStringThreadLocal().parse(str + " 00:00:00");
            return getYesterdayyyyyMMddStringThreadLocal().format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 可以获取当前时间后退N天的日期
     * 格式：传入2 得到2014-11-30
     *
     * @param backDay
     * @return String
     */
    public static String getStrDateByDay(String backDay) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, Integer.parseInt("-" + backDay));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String back = sdf.format(calendar.getTime());
        return back;
    }

    /**
     * 可以获取当前时间后退N月的日期
     * 格式：传入2 得到2014-10-02
     *
     * @param backMonth
     * @return String
     */
    public static String getStrDateByMonth(String backMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, Integer.parseInt("-" + backMonth));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String back = sdf.format(calendar.getTime());
        return back;
    }

    /**
     * 获取当前的年、月、日
     *
     * @return String
     */
    public static String getCurrentYear() {
        return yearSDF.format(new Date());
    }

    public static String getCurrentMonth() {
        return monthSDF.format(new Date());
    }

    public static String getCurrentDay() {
        return daySDF.format(new Date());
    }

    /**
     * 获取年月日 也就是当前时间
     * 格式：2014-12-02
     *
     * @return String
     */
    public static String getCurrentymd() {
        return ymdSDF.format(new Date());
    }

    /**
     * 获得当前的日期毫秒
     *
     * @return
     */
    public static long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }

    /**
     * 获取今天0点开始的秒数
     *
     * @return long
     */
    public static long getTimeNumberToday() {
        Date date = new Date();
        String str = yyyyMMdd.format(date);
        try {
            date = yyyyMMdd.parse(str);
            return date.getTime() / 1000L;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0L;
    }

    /**
     * 获取今天的日期
     * 格式：20141202
     *
     * @return String
     */
    public static String getTodateString() {
        String str = yyyyMMddHH_NOT_.format(new Date());
        return str;
    }

    /**
     * 获取昨天的日期
     * 格式：20141201
     *
     * @return String
     */
    public static String getYesterdayString() {
        Date date = new Date(System.currentTimeMillis() - DATEMM * 1000L);
        String str = getYesterdayStringThreadLocal().format(date);
        return str;
    }

    /**
     * 获得昨天零点
     *
     * @return Date
     */
    public static Date getYesterDayZeroHour() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        return cal.getTime();
    }

    /**
     * 获得今天的零点
     *
     * @return Date
     */
    public static Date getStartDateOfDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        return cal.getTime();
    }

    /**
     * 获得今天的23点
     *
     * @return Date
     */
    public static Date getEndDateOfDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        return cal.getTime();
    }

    /**
     * 把long型日期转String ；---OK
     *
     * @param date   long型日期；
     * @param format 日期格式；
     * @return
     */
    public static String longToString(long date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        // 前面的lSysTime是秒数，先乘1000得到毫秒数，再转为java.util.Date类型    
        Date dt2 = new Date(date);
        String sDateTime = sdf.format(dt2); // 得到精确到秒的表示：08/31/2006 21:08:00
        return sDateTime;
    }

    /**
     * 获得今天零点
     *
     * @return Date
     */
    public static Date getTodayZeroHour() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        return cal.getTime();
    }

    /**
     * 获得昨天23时59分59秒
     *
     * @return
     */
    public static Date getYesterDay24Hour() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.HOUR, 23);
        return cal.getTime();
    }

    /**
     * String To Date ---OK
     *
     * @param date   待转换的字符串型日期；
     * @param format 转化的日期格式
     * @return 返回该字符串的日期型数据；
     */
    public static Date stringToDate(String date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 获得指定日期所在的自然周的第一天，即周日
     *
     * @param date 日期
     * @return 自然周的第一天
     */
    public static Date getStartDayOfWeek(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, 1);
        date = c.getTime();
        return date;
    }

    /**
     * 获得指定日期所在的自然周的最后一天，即周六
     *
     * @param date
     * @return
     */
    public static Date getLastDayOfWeek(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, 7);
        date = c.getTime();
        return date;
    }

    /**
     * 获得指定日期所在当月第一天
     *
     * @param date
     * @return
     */
    public static Date getStartDayOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, 1);
        date = c.getTime();
        return date;
    }

    /**
     * 获得指定日期所在当月最后一天
     *
     * @param date
     * @return
     */
    public static Date getLastDayOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DATE, 1);
        c.add(Calendar.MONTH, 1);
        c.add(Calendar.DATE, -1);
        date = c.getTime();
        return date;
    }

    /**
     * 获得指定日期的下一个月的第一天
     *
     * @param date
     * @return
     */
    public static Date getStartDayOfNextMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, 1);
        c.set(Calendar.DAY_OF_MONTH, 1);
        date = c.getTime();
        return date;
    }

    /**
     * 获得指定日期的下一个月的最后一天
     *
     * @param date
     * @return
     */
    public static Date getLastDayOfNextMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DATE, 1);
        c.add(Calendar.MONTH, 2);
        c.add(Calendar.DATE, -1);
        date = c.getTime();
        return date;
    }

    /**
     * 求某一个时间向前多少秒的时间(currentTimeToBefer)---OK
     *
     * @param givedTime        给定的时间
     * @param interval         间隔时间的毫秒数；计算方式 ：n(天)*24(小时)*60(分钟)*60(秒)(类型)
     * @param format_Date_Sign 输出日期的格式；如yyyy-MM-dd、yyyyMMdd等；
     */
    public static String givedTimeToBefer(String givedTime, long interval,
                                          String format_Date_Sign) {
        String tomorrow = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format_Date_Sign);
            Date gDate = sdf.parse(givedTime);
            long current = gDate.getTime(); // 将Calendar表示的时间转换成毫秒
            long beforeOrAfter = current - interval * 1000L; // 将Calendar表示的时间转换成毫秒
            Date date = new Date(beforeOrAfter); // 用timeTwo作参数构造date2
            tomorrow = new SimpleDateFormat(format_Date_Sign).format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return tomorrow;
    }

    /**
     * 把String 日期转换成long型日期；---OK
     *
     * @param date   String 型日期；
     * @param format 日期格式；
     * @return
     */
    public static long stringToLong(String date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date dt2 = null;
        long lTime = 0;
        try {
            dt2 = sdf.parse(date);
            // 继续转换得到秒数的long型
            lTime = dt2.getTime() / 1000;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return lTime;
    }

    /**
     * 得到二个日期间的间隔日期；
     *
     * @param endTime   结束时间
     * @param beginTime 开始时间
     * @param isEndTime 是否包含结束日期；
     * @return
     */
    public static Map<String, String> getTwoDay(String endTime,
                                                String beginTime, boolean isEndTime) {
        Map<String, String> result = new HashMap<String, String>();
        if ((endTime == null || endTime.equals("") || (beginTime == null || beginTime
                .equals(""))))
            return null;
        try {
            Date date = ymdSDF.parse(endTime);
            endTime = ymdSDF.format(date);
            Date mydate = ymdSDF.parse(beginTime);
            long day = (date.getTime() - mydate.getTime())
                    / (24 * 60 * 60 * 1000);
            result = getDate(endTime, Integer.parseInt(day + ""), isEndTime);
        } catch (Exception e) {
        }
        return result;
    }

    /**
     * 得到二个日期间的间隔日期；
     *
     * @param endTime   结束时间
     * @param beginTime 开始时间
     * @param isEndTime 是否包含结束日期；
     * @return
     */
    public static Integer getTwoDayInterval(String endTime, String beginTime,
                                            boolean isEndTime) {
        if ((endTime == null || endTime.equals("") || (beginTime == null || beginTime
                .equals(""))))
            return 0;
        long day = 0l;
        try {
            Date date = ymdSDF.parse(endTime);
            endTime = ymdSDF.format(date);
            Date mydate = ymdSDF.parse(beginTime);
            day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
        } catch (Exception e) {
            return 0;
        }
        return Integer.parseInt(day + "");
    }

    /**
     * 根据结束时间以及间隔差值，求符合要求的日期集合；
     *
     * @param endTime
     * @param interval
     * @param isEndTime
     * @return
     */
    public static Map<String, String> getDate(String endTime, Integer interval,
                                              boolean isEndTime) {
        Map<String, String> result = new HashMap<String, String>();
        if (interval == 0 || isEndTime) {
            if (isEndTime)
                result.put(endTime, endTime);
        }
        if (interval > 0) {
            int begin = 0;
            for (int i = begin; i < interval; i++) {
                endTime = givedTimeToBefer(endTime, DATEMM, ymd);
                result.put(endTime, endTime);
            }
        }
        return result;
    }

    /**
     * 根据开始时间和结束时间返回时间的集合,时间单位为毫秒
     *
     * @param beginDate
     * @param endDate
     * @return
     * @throws ParseException
     */
    public static List<Long> getDatesBetweenTwoDate(String beginDate, String endDate) throws ParseException {
        Date bDate = ymdSDF.parse(beginDate);
        Date eDate = ymdSDF.parse(endDate);
        List<Long> lDate = new ArrayList<Long>();
        lDate.add(bDate.getTime());// 把开始时间加入集合
        Calendar cal = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        cal.setTime(bDate);
        boolean bContinue = true;
        while (bContinue) {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            cal.add(Calendar.DAY_OF_MONTH, 1);
            // 测试此日期是否在指定日期之后
            if (eDate.after(cal.getTime())) {
                lDate.add(cal.getTime().getTime());
            } else {
                break;
            }
        }
        lDate.add(eDate.getTime());// 把结束时间加入集合
        return lDate;
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

    /**
     * @param strDate 日期
     * @param pattern 日期格式
     * @return StringString
     * @description 使用用户格式解析日期
     */
    public static Date parse(String strDate, String pattern) {
        if (StringUtils.isEmpty(strDate)) {
            return null;
        }
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        try {
            return df.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 在日期上增加数个整月
     *
     * @param date 日期
     * @param n    要增加的月数
     * @return Date
     */
    public static Date addMonth(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, n);
        return cal.getTime();
    }

    /**
     * 在日期上增加天数
     *
     * @param date 日期
     * @param n    要增加的天数
     * @return Date
     */
    public static Date addDay(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, n);
        return cal.getTime();
    }

    /**
     * 在日期上增加小时
     *
     * @param date 日期
     * @param n    要增加的小时数
     * @return Date
     */
    public static Date addHour(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, n);
        return cal.getTime();
    }

    /**
     * 在日期上增加分钟
     *
     * @param date 日期
     * @param n    要增加的天数
     * @return Date
     */
    public static Date addMinute(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, n);
        return cal.getTime();
    }

    /**
     * 两个日期间隔天数
     *
     * @param date      日期
     * @param otherDate 另一个日期
     * @return int
     */
    public static int getIntervalDays(Date date, Date otherDate) {
        long time = Math.abs(date.getTime() - otherDate.getTime());
        return (int) (time / (24 * 60 * 60 * 1000));
    }

    /**
     * @param date      日期
     * @param otherDate 另一个日期
     * @return Long
     * @Description:日期相差分钟数
     */
    public static Long getIntervalMinutes(Date date, Date otherDate) {
        long time = Math.abs(date.getTime() - otherDate.getTime());
        return time == 0 ? 0 : time / (60 * 1000);
    }

    /**
     * @param date  日期
     * @param field Calendar.DATE,Calendar.MONTH
     * @decription:时间截断
     */
    public static Date truncate(Date date, int field) {
        return org.apache.commons.lang3.time.DateUtils.truncate(date, field);
    }

    /**
     * @description 获取当前月有多少天
     */
    public int getDayOfMonth() {
        Calendar aCalendar = Calendar.getInstance(Locale.CHINA);
        int day = aCalendar.getActualMaximum(Calendar.DATE);
        return day;
    }


    /**
     * @description 根据用户格式返回当前日期
     */
    public static String getNow(String format) {
        return format(new Date(), format);
    }


    public static String getBirthFirst(String year) {
        if (StringUtils.isBlank(year)) {
            year = "0";
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        return String.valueOf(Integer.parseInt(format.format(new Date())) - Integer.valueOf(year)) + "-12-31";
    }

    public static String getBirthLast(String year) {
        if (StringUtils.isBlank(year)) {
            year = "100";
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        return String.valueOf(Integer.parseInt(format.format(new Date())) - Integer.valueOf(year)) + "-01-01";
    }

    public static void main(String[] args) {
        System.out.println(getBirthFirst("1"));
        System.out.println(getBirthLast("22"));
    }


}
