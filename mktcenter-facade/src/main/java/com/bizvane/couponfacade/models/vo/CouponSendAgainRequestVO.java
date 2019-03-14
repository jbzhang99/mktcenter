package com.bizvane.couponfacade.models.vo;

import com.bizvane.connectorservice.entity.common.CouponRequestVO;

/**
 * 补发券
 * Created by yunjie.tian on 2018/8/21.
 */
public class CouponSendAgainRequestVO extends CouponRequestVO{

    private String batchSendCode;

    private Long sysBrandId;

    private Long couponEntityId;

    private Long couponSendFailLogId;

    private Long couponDefinitionId;

    public Long getCouponDefinitionId() {
        return couponDefinitionId;
    }

    public void setCouponDefinitionId(Long couponDefinitionId) {
        this.couponDefinitionId = couponDefinitionId;
    }

    public String getBatchSendCode() {
        return batchSendCode;
    }

    public void setBatchSendCode(String batchSendCode) {
        this.batchSendCode = batchSendCode;
    }

    public Long getSysBrandId() {
        return sysBrandId;
    }

    public void setSysBrandId(Long sysBrandId) {
        this.sysBrandId = sysBrandId;
    }

    public Long getCouponEntityId() {
        return couponEntityId;
    }

    public void setCouponEntityId(Long couponEntityId) {
        this.couponEntityId = couponEntityId;
    }

    public Long getCouponSendFailLogId() {
        return couponSendFailLogId;
    }

    public void setCouponSendFailLogId(Long couponSendFailLogId) {
        this.couponSendFailLogId = couponSendFailLogId;
    }
}
