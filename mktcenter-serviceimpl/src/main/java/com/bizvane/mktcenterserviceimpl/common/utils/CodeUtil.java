package com.bizvane.mktcenterserviceimpl.common.utils;

import org.bson.types.Code;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: lijunwei
 * @Time: 2018/7/28 15:52
 */
public class CodeUtil {
    private  final  static String  TASK_PREFIX="TC";
    private  final  static String  ACTIVITY_PREFIX="AC";
    private  final  static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    private  final  static Lock lock = new ReentrantLock();

    public synchronized static   String  getTaskCode()  {
        StringBuilder stringBuilder=null;
        String  code="";
        try {
        stringBuilder = new StringBuilder();
        stringBuilder.append(TASK_PREFIX);
        getRaCodedom(stringBuilder);
        code = stringBuilder.toString();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return code;
        }

    }

    public synchronized static  String  getActivityCode()  {
        StringBuilder stringBuilder=null;
        String  code="";
        try {
            stringBuilder = new StringBuilder();
            stringBuilder.append(ACTIVITY_PREFIX);
            getRaCodedom(stringBuilder);
            code = stringBuilder.toString();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
         return code;
        }
    }

    private synchronized static  StringBuilder getRaCodedom(StringBuilder stringBuilder) throws InterruptedException {
        Thread.sleep(10);
        stringBuilder.append(sdf.format(new Date()));
        stringBuilder.append(Math.round(Math.random() * 9));
        return stringBuilder;
    }

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        HashSet<String> objects = new HashSet<>();
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
        }



    }
}




