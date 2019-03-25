package com.bizvane.couponfacade.models.vo;

import com.bizvane.couponfacade.models.bo.CouponPartBo;

public class CouponStoreGroupVo extends CouponPartBo {
    private String storeGroupCode;
    private String storeGroupName;

    public String getStoreGroupCode() {
        return storeGroupCode;
    }

    public void setStoreGroupCode(String storeGroupCode) {
        this.storeGroupCode = storeGroupCode;
    }

    public String getStoreGroupName() {
        return storeGroupName;
    }

    public void setStoreGroupName(String storeGroupName) {
        this.storeGroupName = storeGroupName;
    }
}
