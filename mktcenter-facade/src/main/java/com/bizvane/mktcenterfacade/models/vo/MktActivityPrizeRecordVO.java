package com.bizvane.mktcenterfacade.models.vo;

import com.bizvane.mktcenterfacade.models.po.MktActivityPrizeRecordPO;

/**
 * Created by agan on 2018/12/19.
 */
public class MktActivityPrizeRecordVO extends MktActivityPrizeRecordPO {
    private Long serviceStoreId;//服务门店id

    private Integer activityType;//活动类型

    private Integer activityStatus;//活动状态

    public Long getServiceStoreId() {
        return serviceStoreId;
    }

    public void setServiceStoreId(Long serviceStoreId) {
        this.serviceStoreId = serviceStoreId;
    }

    public Integer getActivityType() {
        return activityType;
    }

    public void setActivityType(Integer activityType) {
        this.activityType = activityType;
    }

    public Integer getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(Integer activityStatus) {
        this.activityStatus = activityStatus;
    }
}
