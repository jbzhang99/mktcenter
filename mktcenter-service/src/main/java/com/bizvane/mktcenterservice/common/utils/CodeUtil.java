package com.bizvane.mktcenterservice.common.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

/**
 * @Time: 2018/7/28 15:52
 */
public class CodeUtil {
    private  final  static String  TASK_PREFIX="TC";
    private  final  static String  ACTIVITY_PREFIX="AC";
    private  final  static String  MEMBER_GROUP_CODE_PREFIX="MGC";
    private  final  static String  COUPON_EXCHANGE="NC";
    private  final  static String  COUPON_RECORD_PREFIX="IC";
    private  final  static String  ACTIVE_ZP_PREFIX="ZP";
    private  final  static String  ACTIVE_RP_PREFIX="RP";
    private  final  static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");

    public synchronized static   String  getTaskCode()  {
        return generateCode(TASK_PREFIX);
    }

    public synchronized static  String  getActivityCode()  {
        return generateCode(ACTIVITY_PREFIX);
    }

    public static String getMemberGroupCode()  {
        return generateCode(MEMBER_GROUP_CODE_PREFIX);
    }
    public synchronized static   String  getCouponIntegralExchangeCode()  {
        return generateCode(COUPON_EXCHANGE);
    }

    public synchronized static   String  getCouponRecordCode()  {
        return generateCode(COUPON_RECORD_PREFIX);
    }
    //通用
    public synchronized static   String  getActiveCode(String prefix)  {
        return generateCode(prefix);
    }

    public synchronized static   String  getActivePriceCode()  {
        return generateCode(ACTIVE_ZP_PREFIX);
    }

    public synchronized static   String  getActiveRedPacketCode()  {
        return generateCode(ACTIVE_RP_PREFIX);
    }

    public synchronized static  String  generateCode(String feature)  {
        StringBuilder stringBuilder=null;
        String  code="";
        try {
            stringBuilder = new StringBuilder();
            stringBuilder.append(feature);
            getRaCodedom(stringBuilder);
            code = stringBuilder.toString();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return code;
        }
    }

    private synchronized static  StringBuilder getRaCodedom(StringBuilder stringBuilder) throws InterruptedException {
        Thread.sleep(1);
        stringBuilder.append(sdf.format(new Date()));
        stringBuilder.append(Math.round(Math.random() * 9));
        return stringBuilder;
    }

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        try {
            for (int i=0;i<100;i++){
                new Thread() {
                    @Override
                    public void run() {
//          long l = System.currentTimeMillis();
                        String activityCode = getActivityCode();
                        System.out.println(getActivityCode());
                        strings.add(activityCode);
//                    System.out.println(UUID.randomUUID().toString().replace("-", ""));
                    }
                }.start();
            }
        }catch (Exception e){

        }finally {
            System.out.println("-------------------"+strings.size());
            System.out.println(Math.round(Math.random() * 9));
        }
    }
}




