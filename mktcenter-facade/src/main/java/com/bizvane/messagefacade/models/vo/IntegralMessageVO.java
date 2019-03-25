package com.bizvane.messagefacade.models.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by yunjie.tian on 2018/7/28.
 */
@ApiModel("微信-积分消息配置")
public class IntegralMessageVO implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "会员code", name = "memberCode", required = false, example = "")
    private String memberCode;
    
    @ApiModelProperty(value = "企业id", name = "sysCompanyId")
    private Long sysCompanyId;

    @ApiModelProperty(value = "入账积分", name = "changeIntegral", required = false, example = "")
    private String changeIntegral;
    
    @ApiModelProperty(value = "使用积分", name = "useIntegral", required = false, example = "")
    private String useIntegral;
    
    @ApiModelProperty(value = "品牌id", name = "sysBrandId", required = false, example = "")
    private Long sysBrandId;

    @ApiModelProperty(value = "手机号", name = "memberPhone", required = false, example = "")
    private String memberPhone;
    
    @ApiModelProperty(value = "时间", name = "changeDate", required = false, example = "")
    private Date changeDate;
    
    @ApiModelProperty(value = "过期积分", name = "changeIntegral", required = false, example = "")
    private String expireIntegral;
    
    /**短信字段 */
    @ApiModelProperty(value = "会员姓名", name = "memberName", required = false, example = "")
    private String memberName;
    @ApiModelProperty(value = "公众号名称", name = "nickName", required = false, example = "")
    private String nickName;
    


    @ApiModelProperty(value = "当前积分", name = "nowIntegral", required = false, example = "")
    private String nowIntegral;
    @ApiModelProperty(value = "卡号", name = "cardnumber", required = false, example = "")
    private String cardnumber;
    
    
    
    @ApiModelProperty(value = "1非微信会员,没有关注，2是微信已经关注", name = "sendWxmember", required = false, example = "")
    private String sendWxmember;


    
    
    public String getSendWxmember() {
		return sendWxmember;
	}

	public void setSendWxmember(String sendWxmember) {
		this.sendWxmember = sendWxmember;
	}

	public String getNowIntegral() {
		return nowIntegral;
	}

	public void setNowIntegral(String nowIntegral) {
		this.nowIntegral = nowIntegral;
	}

	public String getCardnumber() {
		return cardnumber;
	}

	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    public String getChangeIntegral() {
        return changeIntegral;
    }

    public void setChangeIntegral(String changeIntegral) {
        this.changeIntegral = changeIntegral;
    }

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }

	public String getExpireIntegral() {
		return expireIntegral;
	}

	public void setExpireIntegral(String expireIntegral) {
		this.expireIntegral = expireIntegral;
	}

	public String getUseIntegral() {
		return useIntegral;
	}

	public void setUseIntegral(String useIntegral) {
		this.useIntegral = useIntegral;
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

  public Long getSysCompanyId() {
    return sysCompanyId;
  }

  public void setSysCompanyId(Long sysCompanyId) {
    this.sysCompanyId = sysCompanyId;
  }

    
    
    
}
