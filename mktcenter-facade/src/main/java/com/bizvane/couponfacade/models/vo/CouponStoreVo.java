package com.bizvane.couponfacade.models.vo;

import com.bizvane.couponfacade.models.bo.CouponPartBo;

public class CouponStoreVo extends CouponPartBo {
    private String storeCode;
    private String storeName;

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
}
