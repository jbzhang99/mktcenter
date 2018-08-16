package com.bizvane.mktcenterservice.models.po;

import java.io.Serializable;

public class MktActivityOrderPOWithBLOBs extends MktActivityOrderPO implements Serializable {

	/**
	 * 只读. 商品白名单. commodity_whitelist
	 * @mbg.generated  2018-08-16 16:17:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "商品白名单", name = "commodityWhitelist", required = false, example = "")
	private String commodityWhitelist;
	/**
	 * 只读. 商品黑名单. commodity_blacklist
	 * @mbg.generated  2018-08-16 16:17:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "商品黑名单", name = "commodityBlacklist", required = false, example = "")
	private String commodityBlacklist;
	/**
	 * 只读. 门店白名单. store_whitelist
	 * @mbg.generated  2018-08-16 16:17:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "门店白名单", name = "storeWhitelist", required = false, example = "")
	private String storeWhitelist;
	/**
	 * 只读. 门店黑名单. store_blacklist
	 * @mbg.generated  2018-08-16 16:17:49
	 */
	@io.swagger.annotations.ApiModelProperty(value = "门店黑名单", name = "storeBlacklist", required = false, example = "")
	private String storeBlacklist;
	/**
	 * 只读. 
	 * @mbg.generated  2018-08-16 16:17:49
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-16 16:17:49
	 */
	public String getCommodityWhitelist() {
		return commodityWhitelist;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-16 16:17:49
	 */
	public void setCommodityWhitelist(String commodityWhitelist) {
		this.commodityWhitelist = commodityWhitelist == null ? null : commodityWhitelist.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-16 16:17:49
	 */
	public String getCommodityBlacklist() {
		return commodityBlacklist;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-16 16:17:49
	 */
	public void setCommodityBlacklist(String commodityBlacklist) {
		this.commodityBlacklist = commodityBlacklist == null ? null : commodityBlacklist.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-16 16:17:49
	 */
	public String getStoreWhitelist() {
		return storeWhitelist;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-16 16:17:49
	 */
	public void setStoreWhitelist(String storeWhitelist) {
		this.storeWhitelist = storeWhitelist == null ? null : storeWhitelist.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-16 16:17:49
	 */
	public String getStoreBlacklist() {
		return storeBlacklist;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-16 16:17:49
	 */
	public void setStoreBlacklist(String storeBlacklist) {
		this.storeBlacklist = storeBlacklist == null ? null : storeBlacklist.trim();
	}
}