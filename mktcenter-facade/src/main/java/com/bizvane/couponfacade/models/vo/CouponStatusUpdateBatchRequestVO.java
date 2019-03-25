package com.bizvane.couponfacade.models.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yunjie.tian on 2018/8/16.
 */
public class CouponStatusUpdateBatchRequestVO implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @io.swagger.annotations.ApiModelProperty(value = "成功券集合", name = "couponSuccessList", required = false,example = "")
    private List<String> couponSuccessList;

    @io.swagger.annotations.ApiModelProperty(value = "失败券集合", name = "couponFailList", required = false,example = "")
    private List<String> couponFailList;

    @io.swagger.annotations.ApiModelProperty(value = "是否补发", name = "iFsendAgain", required = false,example = "")
    private Integer ifSendAgain;

    @io.swagger.annotations.ApiModelProperty(value = "发券批次号", name = "batchSendCode", required = false,example = "")
    private String batchSendCode;

    public List<String> getCouponSuccessList() {
        return couponSuccessList;
    }

    public void setCouponSuccessList(List<String> couponSuccessList) {
        this.couponSuccessList = couponSuccessList;
    }

    public List<String> getCouponFailList() {
        return couponFailList;
    }

    public void setCouponFailList(List<String> couponFailList) {
        this.couponFailList = couponFailList;
    }

    public Integer getIfSendAgain() {
        return ifSendAgain;
    }

    public void setIfSendAgain(Integer ifSendAgain) {
        this.ifSendAgain = ifSendAgain;
    }

    public String getBatchSendCode() {
        return batchSendCode;
    }

    public void setBatchSendCode(String batchSendCode) {
        this.batchSendCode = batchSendCode;
    }
}
