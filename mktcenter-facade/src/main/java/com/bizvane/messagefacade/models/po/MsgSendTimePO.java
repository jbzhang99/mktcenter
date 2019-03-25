package com.bizvane.messagefacade.models.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class MsgSendTimePO {
    private Long msgSendtimeId;

	private Long sysCompanyId;
    
    private Long sysBrandId;

    @DateTimeFormat(pattern = "HH:mm:ss")
    @JsonFormat(pattern="HH:mm:ss",timezone = "GMT+8")
    private Date sendTimeStart;
    @DateTimeFormat(pattern = "HH:mm:ss")
    @JsonFormat(pattern="HH:mm:ss",timezone = "GMT+8")
    private Date sendTimeEnd;

    private Long modifiedUserId;

    private String modifiedUserName;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date modifiedDate;

    private Long createUserId;

    private String createUserName;

    private Date createDate;

    private Boolean valid;
    
    

    public Long getSysCompanyId() {
		return sysCompanyId;
	}

	public void setSysCompanyId(Long sysCompanyId) {
		this.sysCompanyId = sysCompanyId;
	}

	public Long getMsgSendtimeId() {
        return msgSendtimeId;
    }

    public void setMsgSendtimeId(Long msgSendtimeId) {
        this.msgSendtimeId = msgSendtimeId;
    }

    public Long getSysBrandId() {
        return sysBrandId;
    }

    public void setSysBrandId(Long sysBrandId) {
        this.sysBrandId = sysBrandId;
    }

    public Date getSendTimeStart() {
        return sendTimeStart;
    }

    public void setSendTimeStart(Date sendTimeStart) {
        this.sendTimeStart = sendTimeStart;
    }

    public Date getSendTimeEnd() {
        return sendTimeEnd;
    }

    public void setSendTimeEnd(Date sendTimeEnd) {
        this.sendTimeEnd = sendTimeEnd;
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

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }
}