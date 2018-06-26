package com.bizvane.mktcenterservice.models.PO;

import java.util.Date;

public class SysStoreGroupPO {
    private Long sysStoreGroupId;

    private Long sysCompanyId;

    private Long sysBrandId;

    private String sysStoreGroupCode;

    private String storeGroupName;

    private String remark;

    private Boolean status;

    private Long createUserId;

    private String createUserName;

    private Date createDate;

    private Long modifiedUserId;

    private String modifiedUserName;

    private Date modifiedDate;

    private Boolean valid;

    public Long getSysStoreGroupId() {
        return sysStoreGroupId;
    }

    public void setSysStoreGroupId(Long sysStoreGroupId) {
        this.sysStoreGroupId = sysStoreGroupId;
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

    public String getSysStoreGroupCode() {
        return sysStoreGroupCode;
    }

    public void setSysStoreGroupCode(String sysStoreGroupCode) {
        this.sysStoreGroupCode = sysStoreGroupCode == null ? null : sysStoreGroupCode.trim();
    }

    public String getStoreGroupName() {
        return storeGroupName;
    }

    public void setStoreGroupName(String storeGroupName) {
        this.storeGroupName = storeGroupName == null ? null : storeGroupName.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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
}