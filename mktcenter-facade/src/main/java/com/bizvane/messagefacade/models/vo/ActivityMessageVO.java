package com.bizvane.messagefacade.models.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by yunjie.tian on 2018/7/16.
 */
public class ActivityMessageVO implements Serializable{

    private static final long serialVersionUID = 1L;
     
    //公共必填字段

    
    //微信定向运营活活动模板-必填字段
    @ApiModelProperty(value = "会员code", name = "memberCode", required = false, example = "")
    private String memberCode;
    @ApiModelProperty(value = "所属品牌名称", name = "sysBrandName", required = false, example = "")
    private String sysBrandName;
    @ApiModelProperty(value = "微信openId", name = "openId", required = false, example = "")
    private String openId;
    
    @ApiModelProperty(value = "所属品牌id", name = "sysBrandId", required = false, example = "")
    private Long sysBrandId;
    @ApiModelProperty(value = "导航语", name = "navigation", required = false, example = "")
    private String navigation;
    @ApiModelProperty(value = "活动名称", name = "activityName", required = false, example = "")
    private String activityName;
    @ApiModelProperty(value = "活动结果", name = "activityInterests", required = false, example = "")
    private String activityInterests ;
    @ApiModelProperty(value = "定向运营活动时间", name = "activitytime", required = false, example = "")
    private String activitytime;
    @ApiModelProperty(value = "赞助商家", name = "businessman", required = false, example = "")
    private String businessman;
    @ApiModelProperty(value = "备注remark", name = "remark", required = false, example = "")
    private String remark ;
    @ApiModelProperty(value = "详情分享页面unl", name = "unl", required = false, example = "")
    private String unl ;
    
    @ApiModelProperty(value = "1立即发送，0定时发送", name = "sendtype", required = false, example = "")
    private String sendtype;
    
    @ApiModelProperty(value = "定时发送时间", name = "sendtime", required = false, example = "")
    private Date sendtime;
    @ApiModelProperty(value = "会员姓名", name = "memberName", required = false, example = "")
    private String memberName;
    //微信定向运营活活动模板-必填字段
    
    
    @ApiModelProperty(value = "企业id", name = "sysCompanyId")
    private Long sysCompanyId;
    
	@ApiModelProperty(value = "活动开始时间", name = "activityStartDate", required = false, example = "")
    private Date activityStartDate;
    @ApiModelProperty(value = "活动结束时间", name = "activityEndDate", required = false, example = "")
    private Date activityEndDate;
    
    
    // 短信活动模板-必填字段

    @ApiModelProperty(value = "公众号名称", name = "pubNum", required = false, example = "")
    private String pubNum;
    @ApiModelProperty(value = "会员手机", name = "memberPhone", required = false, example = "")
    private String memberPhone;
    @ApiModelProperty(value = "短信内容", name = "sendWxmember", required = false, example = "")
    private String sendWxmember;
    
    @ApiModelProperty(value = "长期活动", name = "activityLongtime", required = false, example = "")
    private String activityLongtime;
    
    @ApiModelProperty(value = "短信类型：活动ACTIVITY_TEMPLATE_MESSAGE活动消息，任务TASK_TEMPLATE_MESSAGE，红包RED_TEMPLATE_MESSAGE", name = "type", required = false, example = "")
    private String templateType;
    
    
    public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getNavigation() {
		return navigation;
	}

	public void setNavigation(String navigation) {
		this.navigation = navigation;
	}

	public String getActivitytime() {
		return activitytime;
	}

	public void setActivitytime(String activitytime) {
		this.activitytime = activitytime;
	}

	public String getBusinessman() {
		return businessman;
	}

	public void setBusinessman(String businessman) {
		this.businessman = businessman;
	}

	public String getSendtype() {
		return sendtype;
	}

	public void setSendtype(String sendtype) {
		this.sendtype = sendtype;
	}

	public Date getSendtime() {
		return sendtime;
	}

	public void setSendtime(Date sendtime) {
		this.sendtime = sendtime;
	}

	public String getTemplateType() {
		return templateType;
	}

	public void setTemplateType(String templateType) {
		this.templateType = templateType;
	}

	public String getActivityLongtime() {
		return activityLongtime;
	}

	public void setActivityLongtime(String activityLongtime) {
		this.activityLongtime = activityLongtime;
	}

	public String getSysBrandName() {
		return sysBrandName;
	}

	public void setSysBrandName(String sysBrandName) {
		this.sysBrandName = sysBrandName;
	}

	public Long getSysCompanyId() {
		return sysCompanyId;
	}

	public void setSysCompanyId(Long sysCompanyId) {
		this.sysCompanyId = sysCompanyId;
	}

	public String getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}

	public Long getSysBrandId() {
		return sysBrandId;
	}

	public void setSysBrandId(Long sysBrandId) {
		this.sysBrandId = sysBrandId;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public Date getActivityStartDate() {
		return activityStartDate;
	}

	public void setActivityStartDate(Date activityStartDate) {
		this.activityStartDate = activityStartDate;
	}

	public Date getActivityEndDate() {
		return activityEndDate;
	}

	public void setActivityEndDate(Date activityEndDate) {
		this.activityEndDate = activityEndDate;
	}

	public String getActivityInterests() {
		return activityInterests;
	}

	public void setActivityInterests(String activityInterests) {
		this.activityInterests = activityInterests;
	}

	public String getUnl() {
		return unl;
	}

	public void setUnl(String unl) {
		this.unl = unl;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getPubNum() {
		return pubNum;
	}

	public void setPubNum(String pubNum) {
		this.pubNum = pubNum;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getSendWxmember() {
		return sendWxmember;
	}

	public void setSendWxmember(String sendWxmember) {
		this.sendWxmember = sendWxmember;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}
    
    
    

}
