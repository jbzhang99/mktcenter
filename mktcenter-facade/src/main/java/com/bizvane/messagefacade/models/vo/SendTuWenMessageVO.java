package com.bizvane.messagefacade.models.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by yunjie.tian on 2018/7/16.
 */
public class SendTuWenMessageVO implements Serializable{

    private static final long serialVersionUID = 1L;

    
    @ApiModelProperty(value = "所属企业id", name = "sysCompanyId", required = false, example = "")
    private Long sysCompanyId;
    
	@ApiModelProperty(value = "品牌", name = "brandId", required = false, example = "")
	private Long brandId;

    @ApiModelProperty(value = "任务Id", name = "taskId", required = false, example = "")
    private Long taskId;

	@ApiModelProperty(value = "会员openid", name = "openId", required = false, example = "")
	private String openIdS;

	@ApiModelProperty(value = "会员人数", name = "openId", required = false, example = "")
	private String memberSum;


	@ApiModelProperty(value = "模板id", name = "mediaId", required = false, example = "")
	private String mediaId;

	@ApiModelProperty(value = "消息类型", name = "msgType", required = false, example = "")
	private String msgType;

	@ApiModelProperty(value = "是否继续群发", name = "图文消息被判定为转载时，是否继续群发。 1为继续群发（转载），0为停止群发。 该参数默认为0。", required = false, example = "")
	private String sendIgnoreReprint;

	@ApiModelProperty(value = "分组名称", name = "groupName", required = false, example = "")
	private String groupName;
	@ApiModelProperty(value = "消息标题", name = "groupName", required = false, example = "")
	private String headlTitle;
    
	

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}



	public String getOpenIdS() {
		return openIdS;
	}

	public void setOpenIdS(String openIdS) {
		this.openIdS = openIdS;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getSendIgnoreReprint() {
		return sendIgnoreReprint;
	}

	public void setSendIgnoreReprint(String sendIgnoreReprint) {
		this.sendIgnoreReprint = sendIgnoreReprint;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getHeadlTitle() {
		return headlTitle;
	}

	public void setHeadlTitle(String headlTitle) {
		this.headlTitle = headlTitle;
	}

	public String getMemberSum() {
		return memberSum;
	}

	public void setMemberSum(String memberSum) {
		this.memberSum = memberSum;
	}

	public Long getSysCompanyId() {
		return sysCompanyId;
	}

	public void setSysCompanyId(Long sysCompanyId) {
		this.sysCompanyId = sysCompanyId;
	}


	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    

}
