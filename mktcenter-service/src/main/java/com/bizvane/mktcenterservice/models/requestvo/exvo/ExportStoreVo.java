package com.bizvane.mktcenterservice.models.requestvo.exvo;

/**
 * Created by Gavin on 2018/7/27.
 */
public class ExportStoreVo {

    @io.swagger.annotations.ApiModelProperty(value = "店铺线上编号", name = "sysStoreOnlineCode", required = false, example = "")
    private String sysStoreOnlineCode;

    @io.swagger.annotations.ApiModelProperty(value = "店铺线下编号", name = "sysStoreOfflineCode", required = false, example = "")
    private String sysStoreOfflineCode;

    @io.swagger.annotations.ApiModelProperty(value = "门店名称", name = "storeName", required = false, example = "")
    private String storeName;

    @io.swagger.annotations.ApiModelProperty(value = "所属品牌名称", name = "brandName", required = false)
    private String brandName;

    public String getSysStoreOnlineCode() {
        return sysStoreOnlineCode;
    }

    public void setSysStoreOnlineCode(String sysStoreOnlineCode) {
        this.sysStoreOnlineCode = sysStoreOnlineCode;
    }

    public String getSysStoreOfflineCode() {
        return sysStoreOfflineCode;
    }

    public void setSysStoreOfflineCode(String sysStoreOfflineCode) {
        this.sysStoreOfflineCode = sysStoreOfflineCode;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
