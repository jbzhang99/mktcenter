package com.bizvane.mktcenterservice.models.po;

import java.io.Serializable;

public class MktActivityPOWithBLOBs extends MktActivityPO implements Serializable {

	/**
	 * 只读. 活动描述、简介（积分获取途径说明）. activity_info
	 * @mbg.generated  2019-02-25 09:06:54
	 */
	@io.swagger.annotations.ApiModelProperty(value = "活动描述、简介（积分获取途径说明）", name = "activityInfo", required = false, example = "")
	private String activityInfo;
	/**
	 * 只读. 活动规则. activity_rule
	 * @mbg.generated  2019-02-25 09:06:54
	 */
	@io.swagger.annotations.ApiModelProperty(value = "活动规则", name = "activityRule", required = false, example = "")
	private String activityRule;
	/**
	 * 只读. 活动列表图片，多张逗号分隔. activity_list_img
	 * @mbg.generated  2019-02-25 09:06:54
	 */
	@io.swagger.annotations.ApiModelProperty(value = "活动列表图片，多张逗号分隔", name = "activityListImg", required = false, example = "")
	private String activityListImg;
	/**
	 * 只读. 活动详情图片. activity_detail_img
	 * @mbg.generated  2019-02-25 09:06:54
	 */
	@io.swagger.annotations.ApiModelProperty(value = "活动详情图片", name = "activityDetailImg", required = false, example = "")
	private String activityDetailImg;
	/**
	 * 只读. 门店限制名单. store_limit_list
	 * @mbg.generated  2019-02-25 09:06:54
	 */
	@io.swagger.annotations.ApiModelProperty(value = "门店限制名单", name = "storeLimitList", required = false, example = "")
	private String storeLimitList;
	/**
	 * 只读. 
	 * @mbg.generated  2019-02-25 09:06:54
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 只读. 
	 * @mbg.generated  2019-02-25 09:06:54
	 */
	public String getActivityInfo() {
		return activityInfo;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-02-25 09:06:54
	 */
	public void setActivityInfo(String activityInfo) {
		this.activityInfo = activityInfo == null ? null : activityInfo.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-02-25 09:06:54
	 */
	public String getActivityRule() {
		return activityRule;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-02-25 09:06:54
	 */
	public void setActivityRule(String activityRule) {
		this.activityRule = activityRule == null ? null : activityRule.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-02-25 09:06:54
	 */
	public String getActivityListImg() {
		return activityListImg;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-02-25 09:06:54
	 */
	public void setActivityListImg(String activityListImg) {
		this.activityListImg = activityListImg == null ? null : activityListImg.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-02-25 09:06:54
	 */
	public String getActivityDetailImg() {
		return activityDetailImg;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-02-25 09:06:54
	 */
	public void setActivityDetailImg(String activityDetailImg) {
		this.activityDetailImg = activityDetailImg == null ? null : activityDetailImg.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-02-25 09:06:54
	 */
	public String getStoreLimitList() {
		return storeLimitList;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-02-25 09:06:54
	 */
	public void setStoreLimitList(String storeLimitList) {
		this.storeLimitList = storeLimitList == null ? null : storeLimitList.trim();
	}
}