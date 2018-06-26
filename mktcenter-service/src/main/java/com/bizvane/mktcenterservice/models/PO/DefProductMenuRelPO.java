package com.bizvane.mktcenterservice.models.PO;

import java.util.Date;

public class DefProductMenuRelPO {
    private Long defProductMenuRelId;

    private Long defProdouctId;

    private Long defMenuId;

    private String remark;

    private Long createUserId;

    private String createUserName;

    private Date createDate;

    private Long modifiedUserId;

    private String modifiedUserName;

    private Date modifiedDate;

    private Boolean valid;

    public Long getDefProductMenuRelId() {
        return defProductMenuRelId;
    }

    public void setDefProductMenuRelId(Long defProductMenuRelId) {
        this.defProductMenuRelId = defProductMenuRelId;
    }

    public Long getDefProdouctId() {
        return defProdouctId;
    }

    public void setDefProdouctId(Long defProdouctId) {
        this.defProdouctId = defProdouctId;
    }

    public Long getDefMenuId() {
        return defMenuId;
    }

    public void setDefMenuId(Long defMenuId) {
        this.defMenuId = defMenuId;
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