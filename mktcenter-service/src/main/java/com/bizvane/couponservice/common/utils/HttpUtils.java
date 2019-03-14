package com.bizvane.couponservice.common.utils;

import com.alibaba.fastjson.JSON;
import com.bizvane.centerstageservice.models.po.SysAccountPo;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class HttpUtils {

  public static boolean editCookie(Cookie[] cookies, HttpServletResponse response, String name, String value) {

    if ((cookies == null) || (cookies.length == 0)) {
      return false;
    }
    for (Cookie item : cookies) {
      if (item.getName().equals(name)) {

        Cookie cookie = new Cookie(name, value);
        cookie.setComment(item.getComment());

        String domain = item.getDomain();
        if (StringUtils.isNotBlank(domain)) {
          cookie.setDomain(domain);
        }

        cookie.setMaxAge(item.getMaxAge());
        cookie.setPath("/");
        cookie.setSecure(item.getSecure());
        cookie.setVersion(item.getVersion());

        response.addCookie(cookie);
        return true;
      }
    }
    return false;

  }



  public static SysAccountPo getLoginUser(HttpServletRequest request) {

    String json = "";
    try {
      json = URLDecoder.decode(request.getHeader("sysAccountPo"), "UTF-8");
    } catch (UnsupportedEncodingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } // 解码
    
    SysAccountPo sysAccountPo = JSON.parseObject(json, SysAccountPo.class);

    return sysAccountPo;
  }



}
