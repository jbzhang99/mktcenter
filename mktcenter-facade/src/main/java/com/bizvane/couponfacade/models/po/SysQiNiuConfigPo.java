package com.bizvane.couponfacade.models.po;

import java.io.Serializable;
import java.util.Date;

public class SysQiNiuConfigPo implements Serializable {
    /**
     * 只读.
    pkid. sys_qiniu_config_id
     *
     * @mbg.generated 2018-08-13 20:46:12
     */
    @io.swagger.annotations.ApiModelProperty(value = "pkid",name = "sysQiniuConfigId", required = false,example = "")
    private Long sysQiniuConfigId;

    /**
     * 只读.
    外链域名. domain
     *
     * @mbg.generated 2018-08-13 20:46:12
     */
    @io.swagger.annotations.ApiModelProperty(value = "外链域名",name = "domain", required = false,example = "")
    private String domain;

    /**
     * 只读.
    . access_key
     *
     * @mbg.generated 2018-08-13 20:46:12
     */
    @io.swagger.annotations.ApiModelProperty(value = "",name = "accessKey", required = false,example = "")
    private String accessKey;

    /**
     * 只读.
    . secret_key
     *
     * @mbg.generated 2018-08-13 20:46:12
     */
    @io.swagger.annotations.ApiModelProperty(value = "",name = "secretKey", required = false,example = "")
    private String secretKey;

    /**
     * 只读.
    空间名. bucket
     *
     * @mbg.generated 2018-08-13 20:46:12
     */
    @io.swagger.annotations.ApiModelProperty(value = "空间名",name = "bucket", required = false,example = "")
    private String bucket;

    /**
     * 只读.
    备注. remark
     *
     * @mbg.generated 2018-08-13 20:46:12
     */
    @io.swagger.annotations.ApiModelProperty(value = "备注",name = "remark", required = false,example = "")
    private String remark;

    /**
     * 只读.
    创建人id. create_user_id
     *
     * @mbg.generated 2018-08-13 20:46:12
     */
    @io.swagger.annotations.ApiModelProperty(value = "创建人id",name = "createUserId", required = false,example = "")
    private Long createUserId;

    /**
     * 只读.
    创建人. create_user_name
     *
     * @mbg.generated 2018-08-13 20:46:12
     */
    @io.swagger.annotations.ApiModelProperty(value = "创建人",name = "createUserName", required = false,example = "")
    private String createUserName;

    /**
     * 只读.
    创建日期. create_date
     *
     * @mbg.generated 2018-08-13 20:46:12
     */
    @io.swagger.annotations.ApiModelProperty(value = "创建日期",name = "createDate", required = false,example = "")
    private Date createDate;

    /**
     * 只读.
    修改人id. modified_user_id
     *
     * @mbg.generated 2018-08-13 20:46:12
     */
    @io.swagger.annotations.ApiModelProperty(value = "修改人id",name = "modifiedUserId", required = false,example = "")
    private Long modifiedUserId;

    /**
     * 只读.
    修改人. modified_user_name
     *
     * @mbg.generated 2018-08-13 20:46:12
     */
    @io.swagger.annotations.ApiModelProperty(value = "修改人",name = "modifiedUserName", required = false,example = "")
    private String modifiedUserName;

    /**
     * 只读.
    修改时间. modified_date
     *
     * @mbg.generated 2018-08-13 20:46:12
     */
    @io.swagger.annotations.ApiModelProperty(value = "修改时间",name = "modifiedDate", required = false,example = "")
    private Date modifiedDate;

    /**
     * 只读.
    数据有效性：1=有效；0=无效. valid
     *
     * @mbg.generated 2018-08-13 20:46:12
     */
    @io.swagger.annotations.ApiModelProperty(value = "数据有效性：1=有效；0=无效",name = "valid", required = false,example = "")
    private Boolean valid;

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-13 20:46:12
     */
    private static final long serialVersionUID = 1L;

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-13 20:46:12
     */
    public Long getSysQiniuConfigId() {
        return sysQiniuConfigId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-13 20:46:12
     */
    public void setSysQiniuConfigId(Long sysQiniuConfigId) {
        this.sysQiniuConfigId = sysQiniuConfigId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-13 20:46:12
     */
    public String getDomain() {
        return domain;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-13 20:46:12
     */
    public void setDomain(String domain) {
        this.domain = domain == null ? null : domain.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-13 20:46:12
     */
    public String getAccessKey() {
        return accessKey;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-13 20:46:12
     */
    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey == null ? null : accessKey.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-13 20:46:12
     */
    public String getSecretKey() {
        return secretKey;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-13 20:46:12
     */
    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey == null ? null : secretKey.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-13 20:46:12
     */
    public String getBucket() {
        return bucket;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-13 20:46:12
     */
    public void setBucket(String bucket) {
        this.bucket = bucket == null ? null : bucket.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-13 20:46:12
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-13 20:46:12
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-13 20:46:12
     */
    public Long getCreateUserId() {
        return createUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-13 20:46:12
     */
    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-13 20:46:12
     */
    public String getCreateUserName() {
        return createUserName;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-13 20:46:12
     */
    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-13 20:46:12
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-13 20:46:12
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-13 20:46:12
     */
    public Long getModifiedUserId() {
        return modifiedUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-13 20:46:12
     */
    public void setModifiedUserId(Long modifiedUserId) {
        this.modifiedUserId = modifiedUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-13 20:46:12
     */
    public String getModifiedUserName() {
        return modifiedUserName;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-13 20:46:12
     */
    public void setModifiedUserName(String modifiedUserName) {
        this.modifiedUserName = modifiedUserName == null ? null : modifiedUserName.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-13 20:46:12
     */
    public Date getModifiedDate() {
        return modifiedDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-13 20:46:12
     */
    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-13 20:46:12
     */
    public Boolean getValid() {
        return valid;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-13 20:46:12
     */
    public void setValid(Boolean valid) {
        this.valid = valid;
    }
}