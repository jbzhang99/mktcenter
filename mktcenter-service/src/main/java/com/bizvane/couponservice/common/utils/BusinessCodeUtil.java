package com.bizvane.couponservice.common.utils;

import java.util.Random;
import java.util.UUID;

/**
 * 业务单号工具类
 * @author 董争光
 * 2018年8月10日下午2:02:33
 */
public class BusinessCodeUtil {

  private static final String base = "zxcvbnmkjhgfdsaqwertyuipQWERTYUPASDFGHJKLZXCVBNM23456789";

  /**
   * 获取券编号
   * @return
   */
  public static String getCouponCode() {
    
    return getRandomString(12);
  }
  
  /**
   * 获取券定义遍号
   * @return
   */
  public static String getCouponDefinitionCode() {
    
    return getRandomString(8);
  }
  
  /**
   * 获取券发送批次号
   * @return
   */
  public static String getCouponBatchSendCode() {
    
    return getRandomString(8);
  }
  public static long getCouponBatchSendCodelong() {
    return (long) Integer.parseInt(String.valueOf(UUID.randomUUID().hashCode()).replaceAll("-", ""));
  }
  private static String getRandomString(int length) {
    // 由Random生成随机数
    Random random = new Random();
    StringBuffer sb = new StringBuffer();
    // 长度为几就循环几次
    for (int i = 0; i < length; ++i) {
      // 产生0-61的数字
      int number = random.nextInt(base.length());
      // 将产生的数字通过length次承载到sb中
      sb.append(BusinessCodeUtil.base.charAt(number));
    }
    // 将承载的字符转换成字符串
    return sb.toString();
  }
  
  public static void main(String[] args) {
    System.out.println(base.length());
    System.out.println(getRandomString(43));
  }

}
