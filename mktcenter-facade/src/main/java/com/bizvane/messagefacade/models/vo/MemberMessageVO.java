package com.bizvane.messagefacade.models.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by yunjie.tian on 2018/7/16.
 */
public class MemberMessageVO implements Serializable{

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "会员code", name = "memberCode", required = false, example = "")
    private String memberCode;
    
    @ApiModelProperty(value = "微信openId", name = "openId", required = false, example = "")
    private String openId;
  
    @ApiModelProperty(value = "会员等级", name = "levelName", required = false, example = "")
    private String levelName;


    @ApiModelProperty(value = "原会员等级", name = "originLevelName", required = false, example = "")
    private String originLevelName;

    @ApiModelProperty(value = "开卡渠道", name = "channelName", required = false, example = "")
    private String channelName;

    @ApiModelProperty(value = "时间", name = "date", required = false, example = "")
    private Date date;


    @ApiModelProperty(value = "品牌名", name = "brandName", required = false, example = "")
    private String brandName;
    
      // 微信活动模板字段
    @ApiModelProperty(value = "活动名称", name = "activityName", required = false, example = "")
    private String activityName;
    
    @ApiModelProperty(value = "活动时间", name = "activityDate", required = false, example = "")
    private Date activityDate;
    
    @ApiModelProperty(value = "活动权益", name = "activityInterests", required = false, example = "")
    private String activityInterests ;
    
    
    
    
    
    /**短信字段 */
    @ApiModelProperty(value = "会员姓名", name = "memberName", required = false, example = "")
    private String memberName;
    
    @ApiModelProperty(value = "当前会员等级", name = "nowLevelMember", required = false, example = "")
    private String nowLevelMember;
    
    @ApiModelProperty(value = "公众号名称", name = "pubNum", required = false, example = "")
    private String pubNum;

    @ApiModelProperty(value = "会员手机", name = "memberPhone", required = false, example = "")
    private String memberPhone;

    
    @ApiModelProperty(value = "所属品牌id", name = "sysBrandId", required = false, example = "")
    private Long sysBrandId;
    
    @ApiModelProperty(value = "1非微信会员,没有关注，2是微信已经关注", name = "sendWxmember", required = false, example = "")
    private String sendWxmember;
    
    @ApiModelProperty(value = "入会门店", name = "入会门店", required = false, example = "")
    private String storesName;
    
    @ApiModelProperty(value = "注册时间", name = "注册时间", required = false, example = "")
    private String inviteRegisterTime;
    
     
    @ApiModelProperty(value = "积分", name = "Integral")
    private String integral;
    
    
    @ApiModelProperty(value = "企业id", name = "sysCompanyId")
    private Long sysCompanyId;
    
    @ApiModelProperty(value = "卡号", name = "cardNumber")
    private String cardNumber;
    


	public String getInviteRegisterTime() {
		return inviteRegisterTime;
	}

	public void setInviteRegisterTime(String inviteRegisterTime) {
		this.inviteRegisterTime = inviteRegisterTime;
	}

	public String getStoresName() {
		return storesName;
	}

	public void setStoresName(String storesName) {
		this.storesName = storesName;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getIntegral() {
		return integral;
	}

	public void setIntegral(String integral) {
		this.integral = integral;
	}

	public Long getSysCompanyId() {
		return sysCompanyId;
	}

	public void setSysCompanyId(Long sysCompanyId) {
		this.sysCompanyId = sysCompanyId;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public Date getActivityDate() {
		return activityDate;
	}

	public void setActivityDate(Date activityDate) {
		this.activityDate = activityDate;
	}

	public String getActivityInterests() {
		return activityInterests;
	}

	public void setActivityInterests(String activityInterests) {
		this.activityInterests = activityInterests;
	}


	public String getSendWxmember() {
		return sendWxmember;
	}

	public void setSendWxmember(String sendWxmember) {
		this.sendWxmember = sendWxmember;
	}


	public Long getSysBrandId() {
		return sysBrandId;
	}

	public void setSysBrandId(Long sysBrandId) {
		this.sysBrandId = sysBrandId;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}



	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getNowLevelMember() {
		return nowLevelMember;
	}

	public void setNowLevelMember(String nowLevelMember) {
		this.nowLevelMember = nowLevelMember;
	}

	public String getPubNum() {
		return pubNum;
	}

	public void setPubNum(String pubNum) {
		this.pubNum = pubNum;
	}

	public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }


    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getOriginLevelName() {
        return originLevelName;
    }

    public void setOriginLevelName(String originLevelName) {
        this.originLevelName = originLevelName;
    }
}
