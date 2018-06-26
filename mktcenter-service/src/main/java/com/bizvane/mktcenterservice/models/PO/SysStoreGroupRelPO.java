package com.bizvane.mktcenterservice.models.PO;

import java.util.Date;

public class SysStoreGroupRelPO {
    private Long sysStoreGroupRelId;

    private Long sysCompanyId;

    private Long sysStoreGroupId;

    private Long sysStoreId;

    private String remark;

    private Long createUserId;

    private String createUserName;

    private Date createDate;

    private Long modifiedUserId;

    private String modifiedUserName;

    private Date modifiedDate;

    private Boolean valid;

    public Long getSysStoreGroupRelId() {
        return sysStoreGroupRelId;
    }

    public void setSysStoreGroupRelId(Long sysStoreGroupRelId) {
        this.sysStoreGroupRelId = sysStoreGroupRelId;
    }

    public Long getSysCompanyId() {
        return sysCompanyId;
    }

    public void setSysCompanyId(Long sysCompanyId) {
        this.sysCompanyId = sysCompanyId;
    }

    public Long getSysStoreGroupId() {
        return sysStoreGroupId;
    }

    public void setSysStoreGroupId(Long sysStoreGroupId) {
        this.sysStoreGroupId = sysStoreGroupId;
    }

    public Long getSysStoreId() {
        return sysStoreId;
    }

    public void setSysStoreId(Long sysStoreId) {
        this.sysStoreId = sysStoreId;
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
}