package com.bizvane.messagefacade.models.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by yunjie.tian on 2019/1/11.
 */
public class WechatEnterpriseMessageVO {

    //企业id
    private Long sysCompanyId;

    //品牌id
    private Long sysBrandId;

    //会员号
    private String memberCode;
    
    @ApiModelProperty(value = "微信openId", name = "openId", required = false, example = "")
    private String openId;
    
    //详情地址
    private String url;
    


	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getSysBrandId() {
        return sysBrandId;
    }

    public void setSysBrandId(Long sysBrandId) {
        this.sysBrandId = sysBrandId;
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
}
