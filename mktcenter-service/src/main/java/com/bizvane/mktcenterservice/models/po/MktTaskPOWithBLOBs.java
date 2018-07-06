package com.bizvane.mktcenterservice.models.po;

import java.io.Serializable;

public class MktTaskPOWithBLOBs extends MktTaskPO implements Serializable {

	/**
	 * 只读. 分享内容. share_content
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	@io.swagger.annotations.ApiModelProperty(value = "分享内容", name = "shareContent", required = false, example = "")
	private String shareContent;
	/**
	 * 只读. 任务描述. task_info
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	@io.swagger.annotations.ApiModelProperty(value = "任务描述", name = "taskInfo", required = false, example = "")
	private String taskInfo;
	/**
	 * 只读. 会员需要完善的信息. mbr_profile
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	@io.swagger.annotations.ApiModelProperty(value = "会员需要完善的信息", name = "mbrProfile", required = false, example = "")
	private String mbrProfile;
	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public String getShareContent() {
		return shareContent;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public void setShareContent(String shareContent) {
		this.shareContent = shareContent == null ? null : shareContent.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public String getTaskInfo() {
		return taskInfo;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public void setTaskInfo(String taskInfo) {
		this.taskInfo = taskInfo == null ? null : taskInfo.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public String getMbrProfile() {
		return mbrProfile;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	public void setMbrProfile(String mbrProfile) {
		this.mbrProfile = mbrProfile == null ? null : mbrProfile.trim();
	}
}