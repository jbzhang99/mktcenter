package com.bizvane.couponfacade.models.po;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModel;
@ApiModel("")
public class CouponDefinitionPOWithBLOBs extends CouponDefinitionPO implements Serializable {

  /**
   * @mbg.generated
   */
  @ApiModelProperty(value = "商品白名单", name = "commodityWhitelist", required = false, example = "")
  private String commodityWhitelist;
  /**
   * @mbg.generated
   */
  @ApiModelProperty(value = "商品黑名单", name = "commodityBlacklist", required = false, example = "")
  private String commodityBlacklist;
  /**
   * @mbg.generated
   */
  @ApiModelProperty(value = "门店白名单", name = "storeWhitelist", required = false, example = "")
  private String storeWhitelist;
  /**
   * @mbg.generated
   */
  @ApiModelProperty(value = "门店黑名单", name = "storeBlacklist", required = false, example = "")
  private String storeBlacklist;
  /**
   * @mbg.generated
   */
  private static final long serialVersionUID = 1L;

  /**
   * @mbg.generated
   */
  public String getCommodityWhitelist() {
    return commodityWhitelist;
  }

  /**
   * @mbg.generated
   */
  public void setCommodityWhitelist(String commodityWhitelist) {
    this.commodityWhitelist = commodityWhitelist == null ? null : commodityWhitelist.trim();
  }

  /**
   * @mbg.generated
   */
  public String getCommodityBlacklist() {
    return commodityBlacklist;
  }

  /**
   * @mbg.generated
   */
  public void setCommodityBlacklist(String commodityBlacklist) {
    this.commodityBlacklist = commodityBlacklist == null ? null : commodityBlacklist.trim();
  }

  /**
   * @mbg.generated
   */
  public String getStoreWhitelist() {
    return storeWhitelist;
  }

  /**
   * @mbg.generated
   */
  public void setStoreWhitelist(String storeWhitelist) {
    this.storeWhitelist = storeWhitelist == null ? null : storeWhitelist.trim();
  }

  /**
   * @mbg.generated
   */
  public String getStoreBlacklist() {
    return storeBlacklist;
  }

  /**
   * @mbg.generated
   */
  public void setStoreBlacklist(String storeBlacklist) {
    this.storeBlacklist = storeBlacklist == null ? null : storeBlacklist.trim();
  }
}