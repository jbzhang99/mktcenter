package com.bizvane.mktcenterfacade.models.vo;

import java.util.Date;

/**
 * @Author: lijunwei
 * @Time: 2018/9/21 10:07
 * 用于审核的PO
 */
public class CheckTaskVO {
    private Long businessId ;
    private Integer businessType;
    private  Integer checkStatus;
    private String remark;
    private Date startTime=new Date();
    private Date endTime;
    private Long sysCheckId;
    private String functionCode;


    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public Integer getBusinessType() {
        return businessType;
    }

    public void setBusinessType(Integer businessType) {
        this.businessType = businessType;
    }

    public Integer getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getSysCheckId() {
        return sysCheckId;
    }

    public void setSysCheckId(Long sysCheckId) {
        this.sysCheckId = sysCheckId;
    }

    public String getFunctionCode() {
        return functionCode;
    }

    public void setFunctionCode(String functionCode) {
        this.functionCode = functionCode;
    }
}
