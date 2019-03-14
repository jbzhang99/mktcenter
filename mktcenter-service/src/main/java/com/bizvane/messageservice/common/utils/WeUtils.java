package com.bizvane.messageservice.common.utils;


import com.bizvane.messagefacade.models.po.WxPublicPO;

import java.io.Serializable;

public class WeUtils implements Serializable {


  /**
  * 
  */
  private static final long serialVersionUID = 1L;
  private WxPublicPO wxPublicPO;

  public WeUtils() {

  }

  public WeUtils(WxPublicPO wxPublicPO) {
    this.wxPublicPO = wxPublicPO;
  }

  public WxPublicPO getWxPublicPO() {
    return this.wxPublicPO;
  }


  public void setWxPublicPO(WxPublicPO wxPublicPO) {
    this.wxPublicPO = wxPublicPO;
  }


  /**
   * 是否认证服务号
   *
   * @return
   */
  public boolean canAuthorizeGetUserInfo() {
    return (Integer.parseInt(this.wxPublicPO.getTypeinfo()) == 2)
        && (Integer.parseInt(this.wxPublicPO.getVerifytype()) >= 0);
  }

}
