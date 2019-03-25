/**
 * @(#)Test.java
 *
 * @author win7
 * @version 1.0 2017年9月6日
 *
 * Copyright (C) 2000,2017 , TeamSun, Inc.
 */
package com.bizvane.messageservice.common.thread;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Purpose:
 * 
 * @author win7
 * @see	    
 * @since   6.1.0
 */
@Service
public class Test {

  public void hello(Object object) {
    System.out.println(object + "开始" + System.currentTimeMillis());
    Map<Integer, Integer> data = new HashMap<>();
    for (Integer i = 0; i < 10000000; i++) {
      data.put(i.hashCode(), i);
      data.get(i.hashCode());
    }
    System.out.println(object + "结束" + System.currentTimeMillis());
  }
}