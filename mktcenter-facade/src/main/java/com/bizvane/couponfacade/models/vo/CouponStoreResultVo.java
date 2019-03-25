package com.bizvane.couponfacade.models.vo;

import com.bizvane.couponfacade.models.bo.SingleCouponSurveyBo;

public class CouponStoreResultVo extends SingleCouponSurveyBo {
    private String storeId;
    private String storeCode;
    private String storeName;
    private String storeGroupCode;
    private String storeGroupName;

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

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
