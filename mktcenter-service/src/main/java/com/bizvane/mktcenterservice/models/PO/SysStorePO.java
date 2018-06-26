package com.bizvane.mktcenterservice.models.PO;

import java.util.Date;

public class SysStorePO {
    private Long sysStoreId;

    private Long sysCompanyId;

    private Long sysBrandId;

    private String sysStoreCode;

    private String storeName;

    private String provinceCode;

    private String cityCode;

    private String areaCode;

    private String detailedAddress;

    private String bizArea;

    private String lng;

    private String lat;

    private String storeImgs;

    private String storeOrcode;

    private String storeOrcodeRouteUrl;

    private String distributorName;

    private Long storeType;

    private String dictionaryCode;

    private String shopOwner;

    private Boolean status;

    private Date onDate;

    private Date offDate;

    private String remark;

    private Long createUserId;

    private String createUserName;

    private Date createDate;

    private Long modifiedUserId;

    private String modifiedUserName;

    private Date modifiedDate;

    private Boolean valid;

    private String storeInfo;

    public Long getSysStoreId() {
        return sysStoreId;
    }

    public void setSysStoreId(Long sysStoreId) {
        this.sysStoreId = sysStoreId;
    }

    public Long getSysCompanyId() {
        return sysCompanyId;
    }

    public void setSysCompanyId(Long sysCompanyId) {
        this.sysCompanyId = sysCompanyId;
    }

    public Long getSysBrandId() {
        return sysBrandId;
    }

    public void setSysBrandId(Long sysBrandId) {
        this.sysBrandId = sysBrandId;
    }

    public String getSysStoreCode() {
        return sysStoreCode;
    }

    public void setSysStoreCode(String sysStoreCode) {
        this.sysStoreCode = sysStoreCode == null ? null : sysStoreCode.trim();
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName == null ? null : storeName.trim();
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode == null ? null : provinceCode.trim();
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress == null ? null : detailedAddress.trim();
    }

    public String getBizArea() {
        return bizArea;
    }

    public void setBizArea(String bizArea) {
        this.bizArea = bizArea == null ? null : bizArea.trim();
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng == null ? null : lng.trim();
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat == null ? null : lat.trim();
    }

    public String getStoreImgs() {
        return storeImgs;
    }

    public void setStoreImgs(String storeImgs) {
        this.storeImgs = storeImgs == null ? null : storeImgs.trim();
    }

    public String getStoreOrcode() {
        return storeOrcode;
    }

    public void setStoreOrcode(String storeOrcode) {
        this.storeOrcode = storeOrcode == null ? null : storeOrcode.trim();
    }

    public String getStoreOrcodeRouteUrl() {
        return storeOrcodeRouteUrl;
    }

    public void setStoreOrcodeRouteUrl(String storeOrcodeRouteUrl) {
        this.storeOrcodeRouteUrl = storeOrcodeRouteUrl == null ? null : storeOrcodeRouteUrl.trim();
    }

    public String getDistributorName() {
        return distributorName;
    }

    public void setDistributorName(String distributorName) {
        this.distributorName = distributorName == null ? null : distributorName.trim();
    }

    public Long getStoreType() {
        return storeType;
    }

    public void setStoreType(Long storeType) {
        this.storeType = storeType;
    }

    public String getDictionaryCode() {
        return dictionaryCode;
    }

    public void setDictionaryCode(String dictionaryCode) {
        this.dictionaryCode = dictionaryCode == null ? null : dictionaryCode.trim();
    }

    public String getShopOwner() {
        return shopOwner;
    }

    public void setShopOwner(String shopOwner) {
        this.shopOwner = shopOwner == null ? null : shopOwner.trim();
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getOnDate() {
        return onDate;
    }

    public void setOnDate(Date onDate) {
        this.onDate = onDate;
    }

    public Date getOffDate() {
        return offDate;
    }

    public void setOffDate(Date offDate) {
        this.offDate = offDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getModifiedUserId() {
        return modifiedUserId;
    }

    public void setModifiedUserId(Long modifiedUserId) {
        this.modifiedUserId = modifiedUserId;
    }

    public String getModifiedUserName() {
        return modifiedUserName;
    }

    public void setModifiedUserName(String modifiedUserName) {
        this.modifiedUserName = modifiedUserName == null ? null : modifiedUserName.trim();
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public String getStoreInfo() {
        return storeInfo;
    }

    public void setStoreInfo(String storeInfo) {
        this.storeInfo = storeInfo == null ? null : storeInfo.trim();
    }
}