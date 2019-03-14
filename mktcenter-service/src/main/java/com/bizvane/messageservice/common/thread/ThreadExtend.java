package com.bizvane.messageservice.common.thread;

import com.bizvane.messageservice.common.utils.MessageSpringContextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 * 创建一个线程对象
 * 
 * @author 董争光 2018年5月21日下午1:45:31
 */
public class ThreadExtend implements Runnable {

  private static final Logger logger = LoggerFactory.getLogger(ThreadExtend.class);
  private String className;
  private String method;
  private Object data;


  public ThreadExtend(String className, String method, Object data) {
    this.className = className;
    this.data = data;
    this.method = method;
  }

  public ThreadExtend(String className, String method, Object[] data) {
    this.className = className;
    this.data = data;
    this.method = method;
  }

  @Override
  public void run() {
    ThreadExtend.logger.info("Thread start ");
    try {
      Object bean = MessageSpringContextUtil.getBean(this.className);

      Class<?> classObject = bean.getClass();

      Method method2 = classObject.getMethod(this.method, Object.class);

      method2.invoke(bean, this.data);
    } catch (NoSuchMethodException e2) {
      ThreadExtend.logger.info("NoSuchMethodException：", e2);
    } catch (SecurityException e3) {
      ThreadExtend.logger.info("SecurityException：", e3);
    } catch (IllegalAccessException e4) {
      ThreadExtend.logger.info("IllegalAccessException：", e4);
    } catch (IllegalArgumentException e5) {
      ThreadExtend.logger.info("IllegalArgumentException：", e5);
    } catch (InvocationTargetException e6) {
      ThreadExtend.logger.info("InvocationTargetException：", e6);
    }

    ThreadExtend.logger.info("Thread end ");
  }

  public static void main(String[] args) {
    try {
      Class<?> classObject = Class.forName("35445");
      System.out.println(classObject);
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
