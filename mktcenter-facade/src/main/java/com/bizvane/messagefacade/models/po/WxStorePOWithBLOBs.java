package com.bizvane.messagefacade.models.po;

import java.io.Serializable;

public class WxStorePOWithBLOBs extends WxStorePO implements Serializable {

  /**
   * 只读. 说明. REMARK
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String remark;
  /**
   * 只读. 门店属性. STORE_ATTR
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String storeAttr;
  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  private static final long serialVersionUID = 1L;

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getRemark() {
    return remark;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setRemark(String remark) {
    this.remark = remark == null ? null : remark.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getStoreAttr() {
    return storeAttr;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setStoreAttr(String storeAttr) {
    this.storeAttr = storeAttr == null ? null : storeAttr.trim();
  }
}