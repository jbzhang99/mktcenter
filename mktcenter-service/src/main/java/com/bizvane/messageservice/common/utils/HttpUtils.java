package com.bizvane.messageservice.common.utils;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class HttpUtils {

  public static boolean editCookie(Cookie[] cookies, HttpServletResponse response, String name, String value){
    
    if (cookies == null || cookies.length == 0) {
      return false;
    }
    for(Cookie item : cookies){
      if(item.getName().equals(name)){
          
        Cookie cookie = new Cookie(name, value);
          cookie.setComment(item.getComment());
          
          String domain = item.getDomain();
          if (StringUtils.isNotBlank(domain)) {
            cookie.setDomain(domain);
          }
          
          cookie.setMaxAge(item.getMaxAge());
          cookie.setPath(item.getPath());
          cookie.setSecure(item.getSecure());
          cookie.setVersion(item.getVersion());
          
          response.addCookie(cookie);
          return true;
      }
  }
    return false;
     
}
}
