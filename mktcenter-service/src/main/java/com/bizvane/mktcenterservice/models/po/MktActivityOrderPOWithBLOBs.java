package com.bizvane.mktcenterservice.models.po;

import java.io.Serializable;

public class MktActivityOrderPOWithBLOBs extends MktActivityOrderPO implements Serializable {

	/**
	 * 只读. 商品限制名单. commodity_limit_list
	 * @mbg.generated  2018-08-16 16:54:21
	 */
	@io.swagger.annotations.ApiModelProperty(value = "商品限制名单", name = "commodityLimitList", required = false, example = "")
	private String commodityLimitList;
	/**
	 * 只读. 门店限制名单. store_limit_list
	 * @mbg.generated  2018-08-16 16:54:21
	 */
	@io.swagger.annotations.ApiModelProperty(value = "门店限制名单", name = "storeLimitList", required = false, example = "")
	private String storeLimitList;
	/**
	 * 只读. 
	 * @mbg.generated  2018-08-16 16:54:21
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-16 16:54:21
	 */
	public String getCommodityLimitList() {
		return commodityLimitList;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-16 16:54:21
	 */
	public void setCommodityLimitList(String commodityLimitList) {
		this.commodityLimitList = commodityLimitList == null ? null : commodityLimitList.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-16 16:54:21
	 */
	public String getStoreLimitList() {
		return storeLimitList;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-16 16:54:21
	 */
	public void setStoreLimitList(String storeLimitList) {
		this.storeLimitList = storeLimitList == null ? null : storeLimitList.trim();
	}
}