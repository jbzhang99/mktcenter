package com.bizvane.messagefacade.models.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


public class OrderMessageVO implements Serializable{

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "会员编号",name = "memberCode" ,required = false ,example = "")
    private String memberCode;
    @ApiModelProperty(value = "订单编号",name="orderNo",required = false,example = "")
    private String orderNo;
    @ApiModelProperty(value = "消费金额",name = "money",required = false,example = "")
    private BigDecimal money;
    
    @ApiModelProperty(value = "实际支付金额",name = "payMoney",required = false,example = "")
    private BigDecimal payMoney;
    
    @ApiModelProperty(value = "商户名称",name="merchantsName",required = false,example = "")
    private String merchantsName;
    
    @ApiModelProperty(value = "时间",name="date",required = false,example ="" )
    private Date date;
    @ApiModelProperty(value = "消费地点" , name="position",required = false,example = "")
    private String position;
    @ApiModelProperty(value = "物流单号",name="logisticsNo",required = false,example = "")
    private String logisticsNo;
    
    @ApiModelProperty(value = "物流公司名称",name="logisticsCompanyName",required = false,example = "")
    private String logisticsCompanyName;
    
    @ApiModelProperty(value = "品牌名",name="brandName",required = false,example = "")
    private String brandName;
    @ApiModelProperty(value = "公众号名称",name="nickName",required = false,example = "")
    private String nickName;
    @ApiModelProperty(value = "1非微信会员,没有关注，2是微信已经关注", name = "sendWxmember", required = false, example = "")
    private String sendWxmember;
    @ApiModelProperty(value = "品牌id",name="sysBrandId",required = false,example = "")
    private Long sysBrandId;
    @ApiModelProperty(value = "会员手机号",name="memberPhone",required = false,example = "")
    private String memberPhone;
    @ApiModelProperty(value = "会员姓名",name="memberName",required = false,example = "")
    private String memberName;
    
    @ApiModelProperty(value = "企业id", name = "sysCompanyId")
    private Long sysCompanyId;
    
    
    
    

	public String getLogisticsCompanyName() {
		return logisticsCompanyName;
	}

	public void setLogisticsCompanyName(String logisticsCompanyName) {
		this.logisticsCompanyName = logisticsCompanyName;
	}

	public BigDecimal getPayMoney() {
		return payMoney;
	}

	public void setPayMoney(BigDecimal payMoney) {
		this.payMoney = payMoney;
	}


	public String getMerchantsName() {
		return merchantsName;
	}

	public void setMerchantsName(String merchantsName) {
		this.merchantsName = merchantsName;
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

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLogisticsNo() {
        return logisticsNo;
    }

    public void setLogisticsNo(String logisticsNo) {
        this.logisticsNo = logisticsNo;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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
}
