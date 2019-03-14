package com.bizvane.couponfacade.models.vo;

import java.io.Serializable;

/**
 * Created by yunjie.tian on 2018/12/5.
 */
public class CouponUseVO implements Serializable{

    private static final long serialVersionUID = 1L;

    @io.swagger.annotations.ApiModelProperty(value = "券号", name = "couponCode", required = false,example = "")
    private String couponCode;

    @io.swagger.annotations.ApiModelProperty(value = "品牌号", name = "sysBrandId", required = false,example = "")
    private Long brandId;

    @io.swagger.annotations.ApiModelProperty(value = "核销来源", name = "useFrom", required = false,example = "")
    private Byte useFrom;

    @io.swagger.annotations.ApiModelProperty(value = "员工编号", name = "staffCode", required = false,example = "")
    private String staffCode;

    public String getStaffCode() {
        return staffCode;
    }

    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Byte getUseFrom() {
        return useFrom;
    }

    public void setUseFrom(Byte useFrom) {
        this.useFrom = useFrom;
    }
}
