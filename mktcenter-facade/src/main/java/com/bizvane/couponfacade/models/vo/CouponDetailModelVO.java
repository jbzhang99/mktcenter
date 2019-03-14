package com.bizvane.couponfacade.models.vo;

import com.bizvane.couponfacade.models.po.CouponDefinitionPO;
import com.bizvane.couponfacade.models.po.CouponEntityPO;

import java.io.Serializable;

/**
 * Created by yunjie.tian on 2018/10/23.
 */
public class CouponDetailModelVO implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @io.swagger.annotations.ApiModelProperty(value = "券定义对象", name = "couponDefinitionPO", required = false,example = "")
    private CouponDefinitionPO couponDefinitionPO;
    @io.swagger.annotations.ApiModelProperty(value = "券实例对象", name = "couponEntityPO", required = false,example = "")
    private CouponEntityPO couponEntityPO;

    public CouponDefinitionPO getCouponDefinitionPO() {
        return couponDefinitionPO;
    }

    public void setCouponDefinitionPO(CouponDefinitionPO couponDefinitionPO) {
        this.couponDefinitionPO = couponDefinitionPO;
    }

    public CouponEntityPO getCouponEntityPO() {
        return couponEntityPO;
    }

    public void setCouponEntityPO(CouponEntityPO couponEntityPO) {
        this.couponEntityPO = couponEntityPO;
    }
}
