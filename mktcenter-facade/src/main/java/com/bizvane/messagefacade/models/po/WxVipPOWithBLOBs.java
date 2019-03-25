package com.bizvane.messagefacade.models.po;

import java.io.Serializable;

public class WxVipPOWithBLOBs extends WxVipPO implements Serializable {

  /**
   * 只读. 详细地址. DETAIL_ADDRESS
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String detailAddress;
  /**
   * 只读. 说明. DESCRIPTION
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String description;
  /**
   * 只读. 错误信息. ERRLOG
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String errlog;
  /**
   * 只读. 标签ids. LABLES
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String lables;
  /**
   * 只读. hbase同步日志. HBASE_AUTO_LOG
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String hbaseAutoLog;
  /**
   * 只读. 合并日志. MERGE_LOG
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String mergeLog;
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
  public String getDetailAddress() {
    return detailAddress;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setDetailAddress(String detailAddress) {
    this.detailAddress = detailAddress == null ? null : detailAddress.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getDescription() {
    return description;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setDescription(String description) {
    this.description = description == null ? null : description.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getErrlog() {
    return errlog;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setErrlog(String errlog) {
    this.errlog = errlog == null ? null : errlog.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getLables() {
    return lables;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setLables(String lables) {
    this.lables = lables == null ? null : lables.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getHbaseAutoLog() {
    return hbaseAutoLog;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setHbaseAutoLog(String hbaseAutoLog) {
    this.hbaseAutoLog = hbaseAutoLog == null ? null : hbaseAutoLog.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getMergeLog() {
    return mergeLog;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setMergeLog(String mergeLog) {
    this.mergeLog = mergeLog == null ? null : mergeLog.trim();
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