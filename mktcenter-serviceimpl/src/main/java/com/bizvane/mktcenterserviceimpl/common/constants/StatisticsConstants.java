package com.bizvane.mktcenterserviceimpl.common.constants;

import com.bizvane.mktcenterserviceimpl.common.tools.DateUtil;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 红包活动统计静态类
 * @author yy
 * @create 2019-01-08 17:40
 */
public class StatisticsConstants {

    /**
     * 访问前缀
     */
    public static final String VISITORS_PREFIX = "visitors_";

    /**
     * 发起会员前缀
     */
    public static final String LAUNCH_MEMBERS = "launch_members_";

    /**
     * 助力会员前缀
     */
    public static final String HELP_MEMBERS = "help_members_";

    /**
     * 注册会员前缀
     */
    public static final String REGISTER_MEMBERS = "register_members_";

    /**
     * 领劵数量前缀
     */
    public static final String TAKE_COUPON = "take_coupon_";

    /**
     * 活动id列表前缀
     */
    public static final String ACTIVITY_LIST_PREFIX = "activity_list_prefix_";

    /**
     * 活动类型  0红包膨胀了
     */
    public static final String STATISTICS_TYPE = "0";

    /**
     *  redis缓存过期时间
     *  单位：毫秒
     *  时间设置：48小时
     */
    public static final long REDIS_LIVE_TIME = 48 * 60 * 60 * 1000 ;

    /**
     * 曲线数据类型 小时维度
     */
    public static final int CURVE_HOUR = 1;

    /**
     * 曲线数据类型 日维度
     */
    public static final int CURVE_DAY = 2;

    /**
     * 获取当前日期
     * 格式 yyyyMMdd
     * @return
     */
    public static String getCurrentDate(){
        return DateUtil.getTodateString();
    }

    /**
     * 获取当前时间的小时数
     * 24小时制
     * @return
     */
    public static int getCurrentHour(){
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 获取昨天日期
     * 格式  yyyyMMdd
     * @return
     */
    public static String getYesterday(){
        return DateUtil.getYesterdayString();
    }


    public static String getBeforeOneDate(String time){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DateUtil.stringToDate(time,DateUtil.ymd));
        calendar.add(calendar.DATE,-1);
        Date before = calendar.getTime();
        return DateUtil.format(before,DateUtil.ymd);
    }


    public static Date getFifteenDay(String time){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DateUtil.stringToDate(time,DateUtil.ymd));
        calendar.add(calendar.DATE,-15);
        Date before = calendar.getTime();
        return before;
    }
}
