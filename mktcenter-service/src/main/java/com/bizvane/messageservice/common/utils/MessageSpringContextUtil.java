/*jadclipse*/// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) radix(10) lradix(10) 
// Source File Name:   SpringContextHolder.java

package com.bizvane.messageservice.common.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * spring容器上下文管理类
 * @author 董争光
 * 2018年5月28日上午10:20:14
 */
@Component
public class MessageSpringContextUtil implements ApplicationContextAware {

    private static ApplicationContext context;

    public MessageSpringContextUtil() {
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
      context = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        checkApplicationContext();
        return context;
    }

    public static Object getBean(String name) {
        checkApplicationContext();
        return context.getBean(name);
    }

    public static <T> T getBean(Class<T> beanClass) {
        checkApplicationContext();
        return context.getBean(beanClass);
    }

    public static void cleanApplicationContext() {
      context = null;
    }

    private static void checkApplicationContext() {
        if (context == null)
            throw new IllegalStateException("applicaitonContext\u672A\u6CE8\u5165,\u8BF7\u5728applicationContext.xml\u4E2D\u5B9A\u4E49SpringContextHolder");
        else
            return;
    }


}