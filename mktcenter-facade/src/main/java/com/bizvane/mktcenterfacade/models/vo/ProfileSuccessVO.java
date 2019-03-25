package com.bizvane.mktcenterfacade.models.vo;

import java.util.Date;

/**
 * @Author: lijunwei
 * @Time: 2018/9/1 9:35
 * 完善资料任务
 */
public class ProfileSuccessVO {
    private Long mktTaskId;
    //会员code
    private String memberCode;
    //apppid
    private String appId;
    //完善时间
    private Date profileDate;

    private Long brandId;

    private Long companyId;

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public Date getProfileDate() {
        return profileDate;
    }

    public void setProfileDate(Date profileDate) {
        this.profileDate = profileDate;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getMktTaskId() {
        return mktTaskId;
    }

    public void setMktTaskId(Long mktTaskId) {
        this.mktTaskId = mktTaskId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
}
