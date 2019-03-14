package com.bizvane.couponfacade.models.vo;

import com.bizvane.couponfacade.models.bo.CouponPartBo;

/**
 * Created by 26095 on 2019/1/25.
 */
public class CouponDefinitionPartVo extends CouponPartBo {
    /**
     * 券类型号
     * */
    private Long couponDefinitionId;
    /**
     * 券名称
     * */
    private String couponName;

    public Long getCouponDefinitionId() {
        return couponDefinitionId;
    }

    public void setCouponDefinitionId(Long couponDefinitionId) {
        this.couponDefinitionId = couponDefinitionId;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }
}
