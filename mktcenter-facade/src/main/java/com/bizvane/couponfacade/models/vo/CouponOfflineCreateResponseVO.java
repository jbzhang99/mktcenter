package com.bizvane.couponfacade.models.vo;

import java.io.Serializable;

/**
 * Created by yunjie.tian on 2018/8/17.
 */
public class CouponOfflineCreateResponseVO implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;



    @io.swagger.annotations.ApiModelProperty(value = "会员code", name = "memberCode", required = false,example = "")
    private String memberCode;
    
    private String	couponCode;//券号
    private String	brandCode;//所属品牌
    private String	companyCode;//所属企业
    private String	couponDefinitioncode;//线下券定义编号
    private String	couponStartDate;//券有效开始时间
    private String	couponEndDate;//券有效结束时间
    private String	offlineUpdateDate;//线下更新时间
    
    
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
	public String getBrandCode() {
		return brandCode;
	}
	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getCouponDefinitioncode() {
		return couponDefinitioncode;
	}
	public void setCouponDefinitioncode(String couponDefinitioncode) {
		this.couponDefinitioncode = couponDefinitioncode;
	}
	public String getCouponStartDate() {
		return couponStartDate;
	}
	public void setCouponStartDate(String couponStartDate) {
		this.couponStartDate = couponStartDate;
	}
	public String getCouponEndDate() {
		return couponEndDate;
	}
	public void setCouponEndDate(String couponEndDate) {
		this.couponEndDate = couponEndDate;
	}
	public String getOfflineUpdateDate() {
		return offlineUpdateDate;
	}
	public void setOfflineUpdateDate(String offlineUpdateDate) {
		this.offlineUpdateDate = offlineUpdateDate;
	}




}
