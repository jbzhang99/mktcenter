package com.bizvane.couponservice.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.bizvane.centerstageservice.models.po.SysStoreGroupPo;
import com.bizvane.centerstageservice.models.po.SysStorePo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 劵效果分析日期工具类
 *
 * @author liufq
 */
public class DateConversionUtil {
    Logger logger = LoggerFactory.getLogger(DateConversionUtil.class);
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    private static DecimalFormat df = new DecimalFormat("0.00");

    /**
     * 根据日期纬度得到开始日期和结束日期
     * number 查询的天数/周数/月数
     * dateLatitude 日期纬度: 1:日 2:周 3:月
     */
    public String getStartAndEndDate(String yesterday, int number, String dateLatitude) {
        String dateStr = "";
        switch (dateLatitude) {
            case "1":
                dateStr = getDay(yesterday, number);
                break;
            case "2":
                dateStr = getWeek(yesterday, number);
                break;
            case "3":
                dateStr = getMonth(yesterday, number);
                break;
            default:
                break;
        }

        return dateStr;
    }


    /**
     * 处理日
     *
     * @param yesterday
     * @param number
     * @return
     */
    private String getDay(String yesterday, int number) {
        //需要做处理
        number = -number + 1;
        // 将字符串的日期转为Date类型，ParsePosition(0)表示从第一个字符开始解析
        Date date = sdf.parse(yesterday, new ParsePosition(0));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        // add方法中的第二个参数n中，正数表示该日期后n天，负数表示该日期的前n天
        calendar.add(Calendar.DATE, number);
        Date newDate = calendar.getTime();
        String dayStr = sdf.format(newDate);
        return dayStr;
    }

    /**
     * 处理周
     *
     * @param yesterday
     * @param number
     * @return
     */
    private String getWeek(String yesterday, int number) {
        Date date = null;
        try {
            date = sdf.parse(yesterday);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setTime(date);

        int weekOfMonth = calendar.get(Calendar.WEEK_OF_YEAR);
        System.out.println("=======" + weekOfMonth);
        int value = weekOfMonth - number;
        int week = 0;
        SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
        int year = Integer.parseInt(sdfYear.format(new Date()));
        logger.info("劵消费分析周处理,value:" + value);
        if (value >= 0) {
            week = value + 1;
        } else {
            //跨年的情况
            year = year - 1;
            week = getWeekOfYear(year) + value;
        }

        String weekFistDate = getWeekFistDate(year, week);
        return weekFistDate;
    }

    /**
     * 处理月
     *
     * @param yesterday
     * @param number
     * @return
     */
    private String getMonth(String yesterday, int number) {
        number = number - 1;
        Date date = null;
        try {
            date = sdf.parse(yesterday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat sdfMonth = new SimpleDateFormat("MM");
        int month = Integer.parseInt(sdfMonth.format(date));
        SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
        int year = Integer.parseInt(sdfYear.format(new Date()));
        int value = month - number;
        logger.info("劵消费分析月处理,value:" + value);
        if (value > 0) {
            month = value;
        } else {
            year = year - 1;
            month = 12 + value;
        }

        String monthFistDate = String.valueOf(year) + "-" + String.valueOf(month) + "-1";
        return monthFistDate;
    }

    /**
     * 获取前一天的日期
     */
    public String getYesterday() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        Date d = cal.getTime();

        String yesterday = sdf.format(d);

        return yesterday;
    }

    /**
     * 根据年份获取该年有多少周
     *
     * @param year
     * @return
     */
    private int getWeekOfYear(int year) {
        Calendar cal = new GregorianCalendar();
        cal.set(year, Calendar.DECEMBER, 31, 23, 59, 59);

        Calendar cal1 = new GregorianCalendar();
        cal1.setFirstDayOfWeek(Calendar.MONDAY);
        cal1.setMinimalDaysInFirstWeek(7);
        cal1.setTime(cal.getTime());

        return cal1.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * 根据年份和周数获取该周的第一天日期
     *
     * @param year 年
     * @param week 周
     * @return
     */
    private String getWeekFistDate(int year, int week) {
        logger.info("劵效果分析周=====year:" + year + ",week:" + week);
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR, year);
        //设置周
        cal.set(Calendar.WEEK_OF_YEAR, week);
        //设置该周第一天为星期一
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        //格式化日期
        String firstDayOfWeek = sdf.format(cal.getTime());

        return firstDayOfWeek;
    }

    /**
     * 根据日期得到该日期是星期几
     */
    private String getDayNum(String newDate) {
       /* Date date = null;
        try {
            date = sdf.parse(newDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        SimpleDateFormat dateFm = new SimpleDateFormat("EEEE");

        return dateFm.format(date);*/
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
        Calendar cal = Calendar.getInstance(); // 获得一个日历
        Date datet = null;
        try {
            datet = f.parse(newDate);
            cal.setTime(datet);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1; // 指示一个星期中的某天。
        if (w < 0)
            w = 0;
        return weekDays[w];

    }

    /**
     * 根据日期得到该日期是今年的第几周
     *
     * @param newDate 日期
     * @return
     */
    public JSONObject getWeekNum(String newDate) {
        SimpleDateFormat formatMon = new SimpleDateFormat("MM");
        SimpleDateFormat formatYear = new SimpleDateFormat("yyyy");
        Date date = null;
        try {
            date = sdf.parse(newDate);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int month = Integer.valueOf(formatMon.format(date));
        int year = Integer.valueOf(formatYear.format(date));

        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setTime(date);

        int week = calendar.get(Calendar.WEEK_OF_YEAR);
        JSONObject dateJson = new JSONObject();
        dateJson.put("week", week);
        if (week == 1 && month == 12) {
            dateJson.put("year", year + 1);
        } else {
            dateJson.put("year", year);
        }

        return dateJson;
    }

    /**
     * 根据日期得到日期的月份
     *
     * @param newDate 日期
     * @return
     */
    public String getMonthNum(String newDate) {
        SimpleDateFormat sdfs = new SimpleDateFormat("MM");
        Date date = null;
        try {
            date = sdf.parse(newDate);
            sdfs.parse(newDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String monthStr = sdfs.format(date);
        return monthStr;
    }

    /**
     * 券效果分析数据处理
     */
    public JSONArray getDataHandle(JSONObject dataJson, String dateLatitude) {
        LinkedHashMap<String, String> jsonMap = JSON.parseObject(JSON.toJSONString(dataJson), new TypeReference<LinkedHashMap<String, String>>() {
        });
        //用于返回的json
        JSONArray jsonArrayback = new JSONArray();
        //创建用于排序的treeMap
        TreeMap<String,String> treeMap = new TreeMap<String,String>(new yComparator());

        for (Map.Entry<String, String> entry : jsonMap.entrySet()) {
            treeMap.put(dateToStamp(entry.getKey()),entry.getValue());
        }

        for(Map.Entry<String,String> entry : treeMap.entrySet()){
            String dateStr = stampToDate(entry.getKey());
            String weekStr = "";
            switch (dateLatitude) {
                case "1":
                    weekStr = dateStr.substring(0, 10) + "(" + getDayNum(dateStr) + ")";
                    break;
                case "2":
                    JSONObject dateJson = getWeekNum(dateStr);
                    weekStr = dateJson.getString("year") + "年" + dateJson.getString("week") + "周";
                    break;
                case "3":
                    weekStr = dateStr.substring(0, 7).replace("-", "年") + "月";
                    break;
                default:
                    break;
            }
            JSONObject json = new JSONObject();
            json.put("time",weekStr);
            json.put("value",entry.getValue());
            jsonArrayback.add(json);
        }
        return jsonArrayback;
    }

    /**
     * 券效果分析店铺数据处理
     */
    public JSONArray getCouponStore(JSONArray dataJson, JSONObject storeJson,String isStore) {
        JSONArray resultDataArray = new JSONArray();
        /*LinkedHashMap<String, String> jsonMap = JSON.parseObject(JSON.toJSONString(dataJson), new TypeReference<LinkedHashMap<String, String>>() {
        });*/
        //遍历dataJson
        for(int i = 0;i<dataJson.size();i++){
            JSONObject json = new JSONObject();
            logger.info("value:" + dataJson.getJSONObject(i));
            JSONObject dataValueJson = dataJson.getJSONObject(i);
            //客单价=券收益/用券订单笔数
            //连带率=核销量/用券订单笔数
            //ROI=券收益/券优惠金额*100%
            //核销量
            String salesVolume = dataValueJson.getString("salesVolume");
            if(salesVolume.indexOf(".")>0){
                salesVolume = salesVolume.replaceAll("0+?$","");
                salesVolume = salesVolume.replaceAll("[.]$", "");
            }
            //券收益
            String achievements = dataValueJson.getString("achievements");
            //用券订单笔数
            String penNumber = dataValueJson.getString("penNumber");
            //券优惠金额
            String discount = dataValueJson.getString("discount");
            //客单价
            String unitPrice = df.format(Double.parseDouble(achievements) / Double.parseDouble(penNumber));
            //连带率
            String jointRate = df.format(Double.parseDouble(salesVolume) / Double.parseDouble(penNumber));
            if(jointRate.indexOf(".")>0){
                jointRate = jointRate.replaceAll("0+?$","");
                jointRate = jointRate.replaceAll("[.]$", "");
            }
            //ROI
            Double achievementsDouble = Double.parseDouble(achievements);
            Double disAccountDouble = Double.parseDouble(discount);
            String roi;
            if(achievementsDouble==0.0 || disAccountDouble == 0.0){
                roi = "0";
            }else{
                roi = df.format((Double.parseDouble(achievements) / Double.parseDouble(discount))*100);
            }
            if (isStore.equals("store")) {
                String id = dataValueJson.getString("id");
                SysStorePo sysStorePo = (SysStorePo) storeJson.get(id);
                if (sysStorePo != null) {
                    json.put("storeId", sysStorePo.getStoreId());
                    json.put("storeCode", sysStorePo.getSysStoreOfflineCode());
                    json.put("storeName", sysStorePo.getStoreName());
                    json.put("salesVolume", salesVolume);
                    json.put("unitPrice","￥"+unitPrice);
                    json.put("jointRate", jointRate);
                    json.put("achievements", "￥"+df.format(achievementsDouble));
                    json.put("roi", roi+"%");
                    resultDataArray.add(json);
                }
            } else if (isStore.equals("storeGroup")) {
                String id = dataValueJson.getString("id");
                SysStoreGroupPo sysStoreGroupPo = (SysStoreGroupPo) storeJson.get(id);
                if(sysStoreGroupPo!=null){
                    json.put("storeGroupCode", sysStoreGroupPo.getSysStoreGroupCode());
                    json.put("storeGroupName", sysStoreGroupPo.getStoreGroupName());
                    json.put("salesVolume", salesVolume);
                    json.put("unitPrice", "￥"+unitPrice);
                    json.put("jointRate", jointRate);
                    json.put("achievements", "￥"+df.format(achievementsDouble));
                    json.put("roi", roi+"%");
                    resultDataArray.add(json);
                }
            }


        }

        return resultDataArray;
    }

    /**
     * 将时间转换为时间戳
     */
    public static String dateToStamp(String s){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = simpleDateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long ts = date.getTime();
        res = String.valueOf(ts);
        return res;
    }
    /**
     * 将时间戳转换为时间
     */
    public static String stampToDate(String s){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }

    /**
     * 将Double类型装换为String，并且没有小数点
     * */
    public String eraseZero(Double number){
        //设置Double类型的格式
        DecimalFormat df = new DecimalFormat("0.00");
        String numberString = df.format(number);
        //对于得到的百分比后面要去零操作
        if(numberString.indexOf(".")>0){
            numberString = numberString.replaceAll("0+?$","");
            numberString = numberString.replaceAll("[.]$", "");
        }
        return numberString;
    }

}


class yComparator implements Comparator{
    public int compare(Object o1,Object o2){
        String i1=(String)o1;
        String i2=(String)o2;
        return i1.compareTo(i2);
    }



}
