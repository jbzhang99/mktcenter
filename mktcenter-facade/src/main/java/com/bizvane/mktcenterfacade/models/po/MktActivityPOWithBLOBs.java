package com.bizvane.mktcenterfacade.models.po;

import java.io.Serializable;

public class MktActivityPOWithBLOBs extends MktActivityPO implements Serializable {

  /**
   * 只读. 活动描述、简介（积分获取途径说明）. activity_info
   * @mbg.generated  2019-05-24 15:35:50
   */
  @io.swagger.annotations.ApiModelProperty(value = "活动描述、简介（积分获取途径说明）", name = "activityInfo", required = false,
      example = "")
  private String activityInfo;
  /**
   * 只读. 活动规则. activity_rule
   * @mbg.generated  2019-05-24 15:35:50
   */
  @io.swagger.annotations.ApiModelProperty(value = "活动规则", name = "activityRule", required = false, example = "")
  private String activityRule;
  /**
   * 只读. 门店限制名单. store_limit_list
   * @mbg.generated  2019-05-24 15:35:50
   */
  @io.swagger.annotations.ApiModelProperty(value = "门店限制名单", name = "storeLimitList", required = false, example = "")
  private String storeLimitList;
  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  private static final long serialVersionUID = 1L;

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public String getActivityInfo() {
    return activityInfo;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public void setActivityInfo(String activityInfo) {
    this.activityInfo = activityInfo == null ? null : activityInfo.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public String getActivityRule() {
    return activityRule;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public void setActivityRule(String activityRule) {
    this.activityRule = activityRule == null ? null : activityRule.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public String getStoreLimitList() {
    return storeLimitList;
  }

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  public void setStoreLimitList(String storeLimitList) {
    this.storeLimitList = storeLimitList == null ? null : storeLimitList.trim();
  }
}