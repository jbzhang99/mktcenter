package com.bizvane.couponfacade.models.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by yunjie.tian on 2018/8/10.
 */

public class JobVO implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @io.swagger.annotations.ApiModelProperty(value = "会员号", name = "execuDate", required = false,example = "")
    private Date execuDate;

    @io.swagger.annotations.ApiModelProperty(value = "会员号", name = "execuDate", required = false,example = "")
    private String desc;

    @io.swagger.annotations.ApiModelProperty(value = "会员号", name = "execuDate", required = false,example = "")
    private String param;

    @io.swagger.annotations.ApiModelProperty(value = "会员号", name = "execuDate", required = false,example = "")
    private String author;

    @io.swagger.annotations.ApiModelProperty(value = "会员号", name = "execuDate", required = false,example = "")
    private String jobHandler;

    @io.swagger.annotations.ApiModelProperty(value = "会员号", name = "execuDate", required = false,example = "")
    private String businessType;

    @io.swagger.annotations.ApiModelProperty(value = "会员号", name = "execuDate", required = false,example = "")
    private String bizCode;

    public Date getExecuDate() {
        return execuDate;
    }

    public void setExecuDate(Date execuDate) {
        this.execuDate = execuDate;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getJobHandler() {
        return jobHandler;
    }

    public void setJobHandler(String jobHandler) {
        this.jobHandler = jobHandler;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }
}
