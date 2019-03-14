package com.bizvane.couponfacade.models.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CouponDefinitionMoneyPO implements Serializable {
    /**
     * 只读.
    pkid. coupon_definition_money_id
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    @io.swagger.annotations.ApiModelProperty(value = "pkid",name = "couponDefinitionMoneyId", required = false,example = "")
    private Long couponDefinitionMoneyId;

    /**
     * 只读.
    所属企业id. sys_company_id
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    @io.swagger.annotations.ApiModelProperty(value = "所属企业id",name = "sysCompanyId", required = false,example = "")
    private Long sysCompanyId;

    /**
     * 只读.
    所属品牌id. sys_brand_id
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    @io.swagger.annotations.ApiModelProperty(value = "所属品牌id",name = "sysBrandId", required = false,example = "")
    private Long sysBrandId;

    /**
     * 只读.
    所属品牌编号. brand_code
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    @io.swagger.annotations.ApiModelProperty(value = "所属品牌编号",name = "brandCode", required = false,example = "")
    private String brandCode;

    /**
     * 只读.
    会员code. member_code
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    @io.swagger.annotations.ApiModelProperty(value = "会员code",name = "memberCode", required = false,example = "")
    private String memberCode;

    /**
     * 只读.
    . task_id
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    @io.swagger.annotations.ApiModelProperty(value = "",name = "taskId", required = false,example = "")
    private String taskId;

    /**
     * 只读.
    券定义id. coupon_definition_id
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    @io.swagger.annotations.ApiModelProperty(value = "券定义id",name = "couponDefinitionId", required = false,example = "")
    private String couponDefinitionId;

    /**
     * 只读.
    原来面额. money_start
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    @io.swagger.annotations.ApiModelProperty(value = "原来面额",name = "moneyStart", required = false,example = "")
    private BigDecimal moneyStart;

    /**
     * 只读.
    叠加面额. money_add
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    @io.swagger.annotations.ApiModelProperty(value = "叠加面额",name = "moneyAdd", required = false,example = "")
    private BigDecimal moneyAdd;

    /**
     * 只读.
    最终面额. money_end
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    @io.swagger.annotations.ApiModelProperty(value = "最终面额",name = "moneyEnd", required = false,example = "")
    private BigDecimal moneyEnd;

    /**
     * 只读.
    加的次数. number
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    @io.swagger.annotations.ApiModelProperty(value = "加的次数",name = "number", required = false,example = "")
    private Byte number;

    /**
     * 只读.
    描述. info
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    @io.swagger.annotations.ApiModelProperty(value = "描述",name = "info", required = false,example = "")
    private String info;

    /**
     * 只读.
    备注. remark
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    @io.swagger.annotations.ApiModelProperty(value = "备注",name = "remark", required = false,example = "")
    private String remark;

    /**
     * 只读.
    创建人id. create_user_id
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    @io.swagger.annotations.ApiModelProperty(value = "创建人id",name = "createUserId", required = false,example = "")
    private Long createUserId;

    /**
     * 只读.
    创建人. create_user_name
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    @io.swagger.annotations.ApiModelProperty(value = "创建人",name = "createUserName", required = false,example = "")
    private String createUserName;

    /**
     * 只读.
    创建时间. create_date
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    @io.swagger.annotations.ApiModelProperty(value = "创建时间",name = "createDate", required = false,example = "")
    private Date createDate;

    /**
     * 只读.
    修改人id. modified_user_id
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    @io.swagger.annotations.ApiModelProperty(value = "修改人id",name = "modifiedUserId", required = false,example = "")
    private Long modifiedUserId;

    /**
     * 只读.
    修改人. modified_user_name
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    @io.swagger.annotations.ApiModelProperty(value = "修改人",name = "modifiedUserName", required = false,example = "")
    private String modifiedUserName;

    /**
     * 只读.
    修改时间. modified_date
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    @io.swagger.annotations.ApiModelProperty(value = "修改时间",name = "modifiedDate", required = false,example = "")
    private Date modifiedDate;

    /**
     * 只读.
    数据有效性（1有效，0无效）. valid
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    @io.swagger.annotations.ApiModelProperty(value = "数据有效性（1有效，0无效）",name = "valid", required = false,example = "")
    private Boolean valid;

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    private static final long serialVersionUID = 1L;

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    public Long getCouponDefinitionMoneyId() {
        return couponDefinitionMoneyId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    public void setCouponDefinitionMoneyId(Long couponDefinitionMoneyId) {
        this.couponDefinitionMoneyId = couponDefinitionMoneyId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    public Long getSysCompanyId() {
        return sysCompanyId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    public void setSysCompanyId(Long sysCompanyId) {
        this.sysCompanyId = sysCompanyId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    public Long getSysBrandId() {
        return sysBrandId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    public void setSysBrandId(Long sysBrandId) {
        this.sysBrandId = sysBrandId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    public String getBrandCode() {
        return brandCode;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode == null ? null : brandCode.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    public String getMemberCode() {
        return memberCode;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode == null ? null : memberCode.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    public void setTaskId(String taskId) {
        this.taskId = taskId == null ? null : taskId.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    public String getCouponDefinitionId() {
        return couponDefinitionId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    public void setCouponDefinitionId(String couponDefinitionId) {
        this.couponDefinitionId = couponDefinitionId == null ? null : couponDefinitionId.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    public BigDecimal getMoneyStart() {
        return moneyStart;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    public void setMoneyStart(BigDecimal moneyStart) {
        this.moneyStart = moneyStart;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    public BigDecimal getMoneyAdd() {
        return moneyAdd;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    public void setMoneyAdd(BigDecimal moneyAdd) {
        this.moneyAdd = moneyAdd;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    public BigDecimal getMoneyEnd() {
        return moneyEnd;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    public void setMoneyEnd(BigDecimal moneyEnd) {
        this.moneyEnd = moneyEnd;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    public Byte getNumber() {
        return number;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    public void setNumber(Byte number) {
        this.number = number;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    public String getInfo() {
        return info;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    public Long getCreateUserId() {
        return createUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    public String getCreateUserName() {
        return createUserName;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    public Long getModifiedUserId() {
        return modifiedUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    public void setModifiedUserId(Long modifiedUserId) {
        this.modifiedUserId = modifiedUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    public String getModifiedUserName() {
        return modifiedUserName;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    public void setModifiedUserName(String modifiedUserName) {
        this.modifiedUserName = modifiedUserName == null ? null : modifiedUserName.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    public Date getModifiedDate() {
        return modifiedDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    public Boolean getValid() {
        return valid;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    public void setValid(Boolean valid) {
        this.valid = valid;
    }
}