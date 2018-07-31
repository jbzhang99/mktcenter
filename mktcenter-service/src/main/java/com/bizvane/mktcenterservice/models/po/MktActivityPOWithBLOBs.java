package com.bizvane.mktcenterservice.models.po;

import java.io.Serializable;

public class MktActivityPOWithBLOBs extends MktActivityPO implements Serializable {

	/**
	 * 只读. 活动描述、简介. activity_info
	 * @mbg.generated  2018-07-31 18:34:31
	 */
	@io.swagger.annotations.ApiModelProperty(value = "活动描述、简介", name = "activityInfo", required = false, example = "")
	private String activityInfo;
	/**
	 * 只读. 活动列表图片，多张逗号分隔. activity_list_img
	 * @mbg.generated  2018-07-31 18:34:31
	 */
	@io.swagger.annotations.ApiModelProperty(value = "活动列表图片，多张逗号分隔", name = "activityListImg", required = false, example = "")
	private String activityListImg;
	/**
	 * 只读. 活动详情图片. activity_detail_img
	 * @mbg.generated  2018-07-31 18:34:31
	 */
	@io.swagger.annotations.ApiModelProperty(value = "活动详情图片", name = "activityDetailImg", required = false, example = "")
	private String activityDetailImg;
	/**
	 * 只读. 
	 * @mbg.generated  2018-07-31 18:34:31
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-31 18:34:31
	 */
	public String getActivityInfo() {
		return activityInfo;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-31 18:34:31
	 */
	public void setActivityInfo(String activityInfo) {
		this.activityInfo = activityInfo == null ? null : activityInfo.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-31 18:34:31
	 */
	public String getActivityListImg() {
		return activityListImg;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-31 18:34:31
	 */
	public void setActivityListImg(String activityListImg) {
		this.activityListImg = activityListImg == null ? null : activityListImg.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-31 18:34:31
	 */
	public String getActivityDetailImg() {
		return activityDetailImg;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-31 18:34:31
	 */
	public void setActivityDetailImg(String activityDetailImg) {
		this.activityDetailImg = activityDetailImg == null ? null : activityDetailImg.trim();
	}
}