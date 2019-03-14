package com.bizvane.messageservice.common.utils;

import com.bizvane.centerstageservice.models.po.SysAccountPo;

public class WebUtils {

  private static SysAccountPo loginUser;

  public static SysAccountPo getLoginUser() {
    if(loginUser == null){
      loginUser = new SysAccountPo();
      loginUser.setSysCompanyId(1L);
      loginUser.setBrandId(1L);
      loginUser.setSysAccountId(1L);
      loginUser.setName("张三");
    }
    return loginUser;
  }

  public static void setLoginUser(SysAccountPo user) {
    loginUser = user;
  }
  
  
}
