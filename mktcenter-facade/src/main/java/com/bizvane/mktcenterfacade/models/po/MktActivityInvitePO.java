package com.bizvane.mktcenterfacade.models.po;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModel;
@ApiModel("")
public class MktActivityInvitePO implements Serializable {
    /**@mbg.generated*/
    @ApiModelProperty(value = "pkid",name = "mktActivityInviteId", required = false,example = "")
    private Long mktActivityInviteId;

    /**@mbg.generated*/
    @ApiModelProperty(value = "",name = "sysCompanyId", required = false,example = "")
    private Long sysCompanyId;

    /**@mbg.generated*/
    @ApiModelProperty(value = "关联活动id",name = "mktActivityId", required = false,example = "")
    private Long mktActivityId;

    /**@mbg.generated*/
    @ApiModelProperty(value = "邀请开卡人数",name = "inviteNum", required = false,example = "")
    private Integer inviteNum;

    /**@mbg.generated*/
    @ApiModelProperty(value = "备注",name = "remark", required = false,example = "")
    private String remark;

    /**@mbg.generated*/
    @ApiModelProperty(value = "创建人id",name = "createUserId", required = false,example = "")
    private Long createUserId;

    /**@mbg.generated*/
    @ApiModelProperty(value = "创建人",name = "createUserName", required = false,example = "")
    private String createUserName;

    /**@mbg.generated*/
    @ApiModelProperty(value = "创建日期",name = "createDate", required = false,example = "")
    private Date createDate;

    /**@mbg.generated*/
    @ApiModelProperty(value = "修改人id",name = "modifiedUserId", required = false,example = "")
    private Long modifiedUserId;

    /**@mbg.generated*/
    @ApiModelProperty(value = "修改人",name = "modifiedUserName", required = false,example = "")
    private String modifiedUserName;

    /**@mbg.generated*/
    @ApiModelProperty(value = "修改时间",name = "modifiedDate", required = false,example = "")
    private Date modifiedDate;

    /**@mbg.generated*/
    @ApiModelProperty(value = "数据有效性：1=有效；0=无效",name = "valid", required = false,example = "")
    private Boolean valid;

    /**@mbg.generated*/
    private static final long serialVersionUID = 1L;

    /**@mbg.generated*/
    public Long getMktActivityInviteId() {
        return mktActivityInviteId;
    }

    /**@mbg.generated*/
    public void setMktActivityInviteId(Long mktActivityInviteId) {
        this.mktActivityInviteId = mktActivityInviteId;
    }

    /**@mbg.generated*/
    public Long getSysCompanyId() {
        return sysCompanyId;
    }

    /**@mbg.generated*/
    public void setSysCompanyId(Long sysCompanyId) {
        this.sysCompanyId = sysCompanyId;
    }

    /**@mbg.generated*/
    public Long getMktActivityId() {
        return mktActivityId;
    }

    /**@mbg.generated*/
    public void setMktActivityId(Long mktActivityId) {
        this.mktActivityId = mktActivityId;
    }

    /**@mbg.generated*/
    public Integer getInviteNum() {
        return inviteNum;
    }

    /**@mbg.generated*/
    public void setInviteNum(Integer inviteNum) {
        this.inviteNum = inviteNum;
    }

    /**@mbg.generated*/
    public String getRemark() {
        return remark;
    }

    /**@mbg.generated*/
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**@mbg.generated*/
    public Long getCreateUserId() {
        return createUserId;
    }

    /**@mbg.generated*/
    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    /**@mbg.generated*/
    public String getCreateUserName() {
        return createUserName;
    }

    /**@mbg.generated*/
    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }

    /**@mbg.generated*/
    public Date getCreateDate() {
        return createDate;
    }

    /**@mbg.generated*/
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**@mbg.generated*/
    public Long getModifiedUserId() {
        return modifiedUserId;
    }

    /**@mbg.generated*/
    public void setModifiedUserId(Long modifiedUserId) {
        this.modifiedUserId = modifiedUserId;
    }

    /**@mbg.generated*/
    public String getModifiedUserName() {
        return modifiedUserName;
    }

    /**@mbg.generated*/
    public void setModifiedUserName(String modifiedUserName) {
        this.modifiedUserName = modifiedUserName == null ? null : modifiedUserName.trim();
    }

    /**@mbg.generated*/
    public Date getModifiedDate() {
        return modifiedDate;
    }

    /**@mbg.generated*/
    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    /**@mbg.generated*/
    public Boolean getValid() {
        return valid;
    }

    /**@mbg.generated*/
    public void setValid(Boolean valid) {
        this.valid = valid;
    }
}