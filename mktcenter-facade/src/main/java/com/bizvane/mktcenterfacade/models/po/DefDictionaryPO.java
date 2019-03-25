package com.bizvane.mktcenterfacade.models.po;

import java.io.Serializable;
import java.util.Date;

public class DefDictionaryPO implements Serializable {
    /**
     * 只读.
    主键id示例8888. def_dictionary_id
     *
     * @mbg.generated 2018-08-31 12:40:26
     */
    @io.swagger.annotations.ApiModelProperty(value = "主键id",name = "defDictionaryId", required = false,example = "8888")
    private Long defDictionaryId;

    /**
     * 只读.
    code. code
     *
     * @mbg.generated 2018-08-31 12:40:26
     */
    @io.swagger.annotations.ApiModelProperty(value = "code",name = "code", required = false,example = "")
    private String code;

    /**
     * 只读.
    类型. type
     *
     * @mbg.generated 2018-08-31 12:40:26
     */
    @io.swagger.annotations.ApiModelProperty(value = "类型",name = "type", required = false,example = "")
    private String type;

    /**
     * 只读.
    名称. name
     *
     * @mbg.generated 2018-08-31 12:40:26
     */
    @io.swagger.annotations.ApiModelProperty(value = "名称",name = "name", required = false,example = "")
    private String name;

    /**
     * 只读.
    值. value
     *
     * @mbg.generated 2018-08-31 12:40:26
     */
    @io.swagger.annotations.ApiModelProperty(value = "值",name = "value", required = false,example = "")
    private String value;

    /**
     * 只读.
    显示顺序. sort
     *
     * @mbg.generated 2018-08-31 12:40:26
     */
    @io.swagger.annotations.ApiModelProperty(value = "显示顺序",name = "sort", required = false,example = "")
    private Long sort;

    /**
     * 只读.
    备注. remark
     *
     * @mbg.generated 2018-08-31 12:40:26
     */
    @io.swagger.annotations.ApiModelProperty(value = "备注",name = "remark", required = false,example = "")
    private String remark;

    /**
     * 只读.
    创建人id. create_user_id
     *
     * @mbg.generated 2018-08-31 12:40:26
     */
    @io.swagger.annotations.ApiModelProperty(value = "创建人id",name = "createUserId", required = false,example = "")
    private Long createUserId;

    /**
     * 只读.
    创建人. create_user_name
     *
     * @mbg.generated 2018-08-31 12:40:26
     */
    @io.swagger.annotations.ApiModelProperty(value = "创建人",name = "createUserName", required = false,example = "")
    private String createUserName;

    /**
     * 只读.
    创建日期. create_date
     *
     * @mbg.generated 2018-08-31 12:40:26
     */
    @io.swagger.annotations.ApiModelProperty(value = "创建日期",name = "createDate", required = false,example = "")
    private Date createDate;

    /**
     * 只读.
    修改人id. modified_user_id
     *
     * @mbg.generated 2018-08-31 12:40:26
     */
    @io.swagger.annotations.ApiModelProperty(value = "修改人id",name = "modifiedUserId", required = false,example = "")
    private Long modifiedUserId;

    /**
     * 只读.
    修改人. modified_user_name
     *
     * @mbg.generated 2018-08-31 12:40:26
     */
    @io.swagger.annotations.ApiModelProperty(value = "修改人",name = "modifiedUserName", required = false,example = "")
    private String modifiedUserName;

    /**
     * 只读.
    修改时间. modified_date
     *
     * @mbg.generated 2018-08-31 12:40:26
     */
    @io.swagger.annotations.ApiModelProperty(value = "修改时间",name = "modifiedDate", required = false,example = "")
    private Date modifiedDate;

    /**
     * 只读.
    数据有效性：1=有效；0=无效. valid
     *
     * @mbg.generated 2018-08-31 12:40:26
     */
    @io.swagger.annotations.ApiModelProperty(value = "数据有效性：1=有效；0=无效",name = "valid", required = false,example = "")
    private Boolean valid;

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-31 12:40:26
     */
    private static final long serialVersionUID = 1L;

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-31 12:40:26
     */
    public Long getDefDictionaryId() {
        return defDictionaryId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-31 12:40:26
     */
    public void setDefDictionaryId(Long defDictionaryId) {
        this.defDictionaryId = defDictionaryId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-31 12:40:26
     */
    public String getCode() {
        return code;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-31 12:40:26
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-31 12:40:26
     */
    public String getType() {
        return type;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-31 12:40:26
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-31 12:40:26
     */
    public String getName() {
        return name;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-31 12:40:26
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-31 12:40:26
     */
    public String getValue() {
        return value;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-31 12:40:26
     */
    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-31 12:40:26
     */
    public Long getSort() {
        return sort;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-31 12:40:26
     */
    public void setSort(Long sort) {
        this.sort = sort;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-31 12:40:26
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-31 12:40:26
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-31 12:40:26
     */
    public Long getCreateUserId() {
        return createUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-31 12:40:26
     */
    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-31 12:40:26
     */
    public String getCreateUserName() {
        return createUserName;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-31 12:40:26
     */
    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-31 12:40:26
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-31 12:40:26
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-31 12:40:26
     */
    public Long getModifiedUserId() {
        return modifiedUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-31 12:40:26
     */
    public void setModifiedUserId(Long modifiedUserId) {
        this.modifiedUserId = modifiedUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-31 12:40:26
     */
    public String getModifiedUserName() {
        return modifiedUserName;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-31 12:40:26
     */
    public void setModifiedUserName(String modifiedUserName) {
        this.modifiedUserName = modifiedUserName == null ? null : modifiedUserName.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-31 12:40:26
     */
    public Date getModifiedDate() {
        return modifiedDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-31 12:40:26
     */
    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-31 12:40:26
     */
    public Boolean getValid() {
        return valid;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-31 12:40:26
     */
    public void setValid(Boolean valid) {
        this.valid = valid;
    }
}