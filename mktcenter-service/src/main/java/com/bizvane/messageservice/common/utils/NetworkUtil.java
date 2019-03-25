package com.bizvane.messageservice.common.utils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 获取真实ip地址处理类
 * 
 * @author 董争光 2018年5月21日下午1:48:51
 */
public final class NetworkUtil {


  /**
   * 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址;
   * 
   * @param request
   * @return
   * @throws IOException
   */
  public final static String getIpAddress(HttpServletRequest request) {
    // 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址
    String ipAddress = request.getHeader("x-forwarded-for");
    if ((ipAddress == null) || (ipAddress.length() == 0) || "unknown".equalsIgnoreCase(ipAddress)) {
      ipAddress = request.getHeader("Proxy-Client-IP");
    }
    if ((ipAddress == null) || (ipAddress.length() == 0) || "unknown".equalsIgnoreCase(ipAddress)) {
      ipAddress = request.getHeader("WL-Proxy-Client-IP");
    }
    if ((ipAddress == null) || (ipAddress.length() == 0) || "unknown".equalsIgnoreCase(ipAddress)) {
      ipAddress = request.getRemoteAddr();
      if ("127.0.0.1".equals(ipAddress)) {
        // 根据网卡取本机配置的IP
        InetAddress inet = null;
        try {
          inet = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
          e.printStackTrace();
        }
        ipAddress = inet.getHostAddress();
      }
    }
    // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
    if ((ipAddress != null) && (ipAddress.length() > 15)) { // "***.***.***.***".length()
      // = 15
      if (ipAddress.indexOf(",") > 0) {
        ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
      }
    }
    return ipAddress;
  }
}
