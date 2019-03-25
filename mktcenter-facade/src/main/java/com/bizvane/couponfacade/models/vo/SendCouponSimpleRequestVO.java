package com.bizvane.couponfacade.models.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class SendCouponSimpleRequestVO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "会员code", name = "memberCode", required = false, example = "")
    private String memberCode;

    @ApiModelProperty(value = "券定义id", name = "couponDefinitionId", required = false, example = "")
    private Long couponDefinitionId;

    @ApiModelProperty(value = "发送类型", name = "sendType", required = false, example = "")
    private String sendType;

    @ApiModelProperty(value = "业务id", name = "sendBussienId", required = false, example = "")
    private Long sendBussienId;

    @ApiModelProperty(value = "任务名称", name = "businessName", required = false, example = "")
    private String businessName;

    @ApiModelProperty(value = "品牌id", name = "brandId", required = false, example = "")
    private Long brandId;

    @ApiModelProperty(value = "企业id", name = "companyId", required = false, example = "")
    private Long companyId;

    @ApiModelProperty(value = "品牌号", name = "brandCode", required = false, example = "")
    private String brandCode;
    
    @ApiModelProperty(value = "涨红包taskId", name = "taskId", required = false, example = "")
    private String taskId;


    public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    public Long getCouponDefinitionId() {
        return couponDefinitionId;
    }

    public void setCouponDefinitionId(Long couponDefinitionId) {
        this.couponDefinitionId = couponDefinitionId;
    }

    public String getSendType() {
        return sendType;
    }

    public void setSendType(String sendType) {
        this.sendType = sendType;
    }

    public Long getSendBussienId() {
        return sendBussienId;
    }

    public void setSendBussienId(Long sendBussienId) {
        this.sendBussienId = sendBussienId;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }
}
