package com.bizvane.messageservice.common.utils;

import java.util.Random;

/**
 * 生成随机数工具类
 * 
 * @author 董争光 2018年5月21日下午1:47:33
 */
public class CreateRandomUtil {
  /**
   * 产生随机的六位数
   * 
   * @return
   */
  public static String getLoginSmsCode() {
    Random random = new Random();

    return (random.nextInt(9000) + 1000) + "";
  }

}
