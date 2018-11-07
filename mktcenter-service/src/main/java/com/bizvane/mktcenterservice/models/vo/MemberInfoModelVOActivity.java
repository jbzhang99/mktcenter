package com.bizvane.mktcenterservice.models.vo;

import com.bizvane.members.facade.models.MemberInfoModel;

/**
 * Created by agan on 2018/11/7.
 */
public class MemberInfoModelVOActivity extends MemberInfoModel {
    private Integer offlineCardStatus;//开卡 未开卡

    public Integer getOfflineCardStatus() {
        return offlineCardStatus;
    }

    public void setOfflineCardStatus(Integer offlineCardStatus) {
        this.offlineCardStatus = offlineCardStatus;
    }
}
