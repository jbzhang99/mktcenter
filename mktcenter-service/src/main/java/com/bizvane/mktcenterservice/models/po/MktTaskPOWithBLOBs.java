package com.bizvane.mktcenterservice.models.po;

import java.io.Serializable;

public class MktTaskPOWithBLOBs extends MktTaskPO implements Serializable {

	/**
	 * 只读. 任务描述. task_info
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	@io.swagger.annotations.ApiModelProperty(value = "任务描述", name = "taskInfo", required = false, example = "")
	private String taskInfo;
	/**
	 * 只读. 任务列表图片，多张逗号分隔. task_list_img
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	@io.swagger.annotations.ApiModelProperty(value = "任务列表图片，多张逗号分隔", name = "taskListImg", required = false, example = "")
	private String taskListImg;
	/**
	 * 只读. 任务详情图片. task_detail_img
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	@io.swagger.annotations.ApiModelProperty(value = "任务详情图片", name = "taskDetailImg", required = false, example = "")
	private String taskDetailImg;
	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public String getTaskInfo() {
		return taskInfo;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public void setTaskInfo(String taskInfo) {
		this.taskInfo = taskInfo == null ? null : taskInfo.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public String getTaskListImg() {
		return taskListImg;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public void setTaskListImg(String taskListImg) {
		this.taskListImg = taskListImg == null ? null : taskListImg.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public String getTaskDetailImg() {
		return taskDetailImg;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public void setTaskDetailImg(String taskDetailImg) {
		this.taskDetailImg = taskDetailImg == null ? null : taskDetailImg.trim();
	}
}