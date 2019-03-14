package com.bizvane.messagefacade.models.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

@ApiModel(value="微信-券到账提醒")
public class CouponMessageVO implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  @ApiModelProperty(value = "会员code", name = "memberCode", required = false, example = "")
  private String memberCode;
  
  @ApiModelProperty(value = "券编号", name = "couponCode", required = false, example = "")
  private String couponCode;
  
  @ApiModelProperty(value = "券名称", name = "couponName", required = false, example = "")
  private String couponName;
  
  @ApiModelProperty(value = "优惠形式", name = "preferentialType", required = false, example = "现金券")
  private String preferentialType;
  
  @ApiModelProperty(value = "面额/折扣,优惠券折扣/金额", name = "denomination", required = false, example = "100元")
  private String denomination;

  @ApiModelProperty(value = "使用/入账时间", name = "useTime", required = false, example = "")
  private Date useTime;

  @ApiModelProperty(value = "有效期开始时间", name = "validDateStart", required = false, example = "")
  private Date validDateStart;

  @ApiModelProperty(value = "有效期结束时间", name = "validDateEnd", required = false, example = "")
  private Date validDateEnd;
  


//短信必填字段
  @ApiModelProperty(value = "会员名称", name = "memberName", required = false, example = "")
  private String memberName;

  @ApiModelProperty(value = "订单号 优惠券使用要填写", name = "orderNo", required = false, example = "")
  private String orderNo;
  
  @ApiModelProperty(value = "品牌id", name = "sysBrandId", required = false, example = "")
  private Long sysBrandId;

  @ApiModelProperty(value = "手机号", name = "memberPhone", required = false, example = "")
  private String memberPhone;
  
  @ApiModelProperty(value = "公众号名称", name = "nickName", required = false, example = "")
  private String nickName;
  
  @ApiModelProperty(value = "1非微信会员,没有关注，2是微信已经关注", name = "sendWxmember", required = false, example = "")
  private String sendWxmember;
  
  

  public String getSendWxmember() {
	return sendWxmember;
}

public void setSendWxmember(String sendWxmember) {
	this.sendWxmember = sendWxmember;
}

@ApiModelProperty(value = "企业id", name = "sysCompanyId")
  private Long sysCompanyId;
  
  
	public Long getSysCompanyId() {
		return sysCompanyId;
	}
	
	public void setSysCompanyId(Long sysCompanyId) {
		this.sysCompanyId = sysCompanyId;
	}
	
	

	public String getMemberPhone() {
			return memberPhone;
		}
		
		public void setMemberPhone(String memberPhone) {
			this.memberPhone = memberPhone;
		}

	public String getMemberCode() {
	    return memberCode;
	  }

  public void setMemberCode(String memberCode) {
    this.memberCode = memberCode;
  }

  public String getCouponCode() {
    return couponCode;
  }

  public void setCouponCode(String couponCode) {
    this.couponCode = couponCode;
  }

  public String getCouponName() {
    return couponName;
  }

  public void setCouponName(String couponName) {
    this.couponName = couponName;
  }

  public String getPreferentialType() {
    return preferentialType;
  }

  public void setPreferentialType(String preferentialType) {
    this.preferentialType = preferentialType;
  }

  public String getDenomination() {
    return denomination;
  }

  public void setDenomination(String denomination) {
    this.denomination = denomination;
  }

  public Date getUseTime() {
    return useTime;
  }

  public void setUseTime(Date useTime) {
    this.useTime = useTime;
  }

  public Date getValidDateStart() {
    return validDateStart;
  }

  public void setValidDateStart(Date validDateStart) {
    this.validDateStart = validDateStart;
  }

  public Date getValidDateEnd() {
    return validDateEnd;
  }

  public void setValidDateEnd(Date validDateEnd) {
    this.validDateEnd = validDateEnd;
  }

	public String getMemberName() {
		return memberName;
	}
	
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	public String getOrderNo() {
		return orderNo;
	}
	
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	
	


	public Long getSysBrandId() {
		return sysBrandId;
	}

	public void setSysBrandId(Long sysBrandId) {
		this.sysBrandId = sysBrandId;
	}


	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}



  
}
