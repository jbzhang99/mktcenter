package com.bizvane.couponfacade.models.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CouponQuotaSendDetailPO implements Serializable {
    /**
     * 只读.
    主键. coupon_quota_send_detail_id
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    @io.swagger.annotations.ApiModelProperty(value = "主键",name = "couponQuotaSendDetailId", required = false,example = "")
    private Long couponQuotaSendDetailId;

    /**
     * 只读.
    企业id. sys_company_id
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    @io.swagger.annotations.ApiModelProperty(value = "企业id",name = "sysCompanyId", required = false,example = "")
    private Long sysCompanyId;

    /**
     * 只读.
    品牌id. sys_brand_id
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    @io.swagger.annotations.ApiModelProperty(value = "品牌id",name = "sysBrandId", required = false,example = "")
    private Long sysBrandId;

    /**
     * 只读.
    券配额与员工关系表主键. coupon_quota_detail_id
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    @io.swagger.annotations.ApiModelProperty(value = "券配额与员工关系表主键",name = "couponQuotaDetailId", required = false,example = "")
    private Long couponQuotaDetailId;

    /**
     * 只读.
    员工code. staff_code
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    @io.swagger.annotations.ApiModelProperty(value = "员工code",name = "staffCode", required = false,example = "")
    private String staffCode;

    /**
     * 只读.
    员工名称. staff_name
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    @io.swagger.annotations.ApiModelProperty(value = "员工名称",name = "staffName", required = false,example = "")
    private String staffName;

    /**
     * 只读.
    发送会员code集合. member_code_list
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    @io.swagger.annotations.ApiModelProperty(value = "发送会员code集合",name = "memberCodeList", required = false,example = "")
    private String memberCodeList;

    /**
     * 只读.
    发送会员名称集合. member_name_list
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    @io.swagger.annotations.ApiModelProperty(value = "发送会员名称集合",name = "memberNameList", required = false,example = "")
    private String memberNameList;

    /**
     * 只读.
    发送会员数量. member_num
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    @io.swagger.annotations.ApiModelProperty(value = "发送会员数量",name = "memberNum", required = false,example = "")
    private String memberNum;

    /**
     * 只读.
    券编号. coupon_definition_code
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    @io.swagger.annotations.ApiModelProperty(value = "券编号",name = "couponDefinitionCode", required = false,example = "")
    private String couponDefinitionCode;

    /**
     * 只读.
    券定义id. coupon_definition_id
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    @io.swagger.annotations.ApiModelProperty(value = "券定义id",name = "couponDefinitionId", required = false,example = "")
    private Long couponDefinitionId;

    /**
     * 只读.
    优惠类型（1现金，2折扣，3礼品）. preferential_type
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    @io.swagger.annotations.ApiModelProperty(value = "优惠类型（1现金，2折扣，3礼品）",name = "preferentialType", required = false,example = "")
    private Byte preferentialType;

    /**
     * 只读.
    . valid_type
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    @io.swagger.annotations.ApiModelProperty(value = "",name = "validType", required = false,example = "")
    private Byte validType;

    /**
     * 只读.
    . valid_day
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    @io.swagger.annotations.ApiModelProperty(value = "",name = "validDay", required = false,example = "")
    private Integer validDay;

    /**
     * 只读.
    . min_consume
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    @io.swagger.annotations.ApiModelProperty(value = "",name = "minConsume", required = false,example = "")
    private BigDecimal minConsume;

    /**
     * 只读.
    券名称. coupon_name
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    @io.swagger.annotations.ApiModelProperty(value = "券名称",name = "couponName", required = false,example = "")
    private String couponName;

    /**
     * 只读.
    面额. money
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    @io.swagger.annotations.ApiModelProperty(value = "面额",name = "money", required = false,example = "")
    private BigDecimal money;

    /**
     * 只读.
    折扣. discount
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    @io.swagger.annotations.ApiModelProperty(value = "折扣",name = "discount", required = false,example = "")
    private BigDecimal discount;

    /**
     * 只读.
    券说明. info
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    @io.swagger.annotations.ApiModelProperty(value = "券说明",name = "info", required = false,example = "")
    private String info;

    /**
     * 只读.
    有效期开始时间. valid_date_start
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    @io.swagger.annotations.ApiModelProperty(value = "有效期开始时间",name = "validDateStart", required = false,example = "")
    private Date validDateStart;

    /**
     * 只读.
    有效期结束时间. valid_date_end
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    @io.swagger.annotations.ApiModelProperty(value = "有效期结束时间",name = "validDateEnd", required = false,example = "")
    private Date validDateEnd;

    /**
     * 只读.
    创建人id. create_user_id
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    @io.swagger.annotations.ApiModelProperty(value = "创建人id",name = "createUserId", required = false,example = "")
    private Long createUserId;

    /**
     * 只读.
    创建人. create_user_name
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    @io.swagger.annotations.ApiModelProperty(value = "创建人",name = "createUserName", required = false,example = "")
    private String createUserName;

    /**
     * 只读.
    创建时间. create_date
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    @io.swagger.annotations.ApiModelProperty(value = "创建时间",name = "createDate", required = false,example = "")
    private Date createDate;

    /**
     * 只读.
    修改人id. modified_user_id
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    @io.swagger.annotations.ApiModelProperty(value = "修改人id",name = "modifiedUserId", required = false,example = "")
    private Long modifiedUserId;

    /**
     * 只读.
    修改人. modified_user_name
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    @io.swagger.annotations.ApiModelProperty(value = "修改人",name = "modifiedUserName", required = false,example = "")
    private String modifiedUserName;

    /**
     * 只读.
    修改时间. modified_date
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    @io.swagger.annotations.ApiModelProperty(value = "修改时间",name = "modifiedDate", required = false,example = "")
    private Date modifiedDate;

    /**
     * 只读.
    备注. note
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    @io.swagger.annotations.ApiModelProperty(value = "备注",name = "note", required = false,example = "")
    private String note;

    /**
     * 只读.
    . state_code
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    @io.swagger.annotations.ApiModelProperty(value = "",name = "stateCode", required = false,example = "")
    private String stateCode;

    /**
     * 只读.
    . state_name
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    @io.swagger.annotations.ApiModelProperty(value = "",name = "stateName", required = false,example = "")
    private String stateName;

    /**
     * 只读.
    . extend_code
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    @io.swagger.annotations.ApiModelProperty(value = "",name = "extendCode", required = false,example = "")
    private String extendCode;

    /**
     * 只读.
    . extend_name
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    @io.swagger.annotations.ApiModelProperty(value = "",name = "extendName", required = false,example = "")
    private String extendName;

    /**
     * 只读.
    . extend_note
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    @io.swagger.annotations.ApiModelProperty(value = "",name = "extendNote", required = false,example = "")
    private String extendNote;

    /**
     * 只读.
    数据有效性（1有效，0无效）. valid
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    @io.swagger.annotations.ApiModelProperty(value = "数据有效性（1有效，0无效）",name = "valid", required = false,example = "")
    private Boolean valid;

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    private static final long serialVersionUID = 1L;

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public Long getCouponQuotaSendDetailId() {
        return couponQuotaSendDetailId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public void setCouponQuotaSendDetailId(Long couponQuotaSendDetailId) {
        this.couponQuotaSendDetailId = couponQuotaSendDetailId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public Long getSysCompanyId() {
        return sysCompanyId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public void setSysCompanyId(Long sysCompanyId) {
        this.sysCompanyId = sysCompanyId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public Long getSysBrandId() {
        return sysBrandId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public void setSysBrandId(Long sysBrandId) {
        this.sysBrandId = sysBrandId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public Long getCouponQuotaDetailId() {
        return couponQuotaDetailId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public void setCouponQuotaDetailId(Long couponQuotaDetailId) {
        this.couponQuotaDetailId = couponQuotaDetailId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public String getStaffCode() {
        return staffCode;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode == null ? null : staffCode.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public String getStaffName() {
        return staffName;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public void setStaffName(String staffName) {
        this.staffName = staffName == null ? null : staffName.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public String getMemberCodeList() {
        return memberCodeList;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public void setMemberCodeList(String memberCodeList) {
        this.memberCodeList = memberCodeList == null ? null : memberCodeList.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public String getMemberNameList() {
        return memberNameList;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public void setMemberNameList(String memberNameList) {
        this.memberNameList = memberNameList == null ? null : memberNameList.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public String getMemberNum() {
        return memberNum;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public void setMemberNum(String memberNum) {
        this.memberNum = memberNum == null ? null : memberNum.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public String getCouponDefinitionCode() {
        return couponDefinitionCode;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public void setCouponDefinitionCode(String couponDefinitionCode) {
        this.couponDefinitionCode = couponDefinitionCode == null ? null : couponDefinitionCode.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public Long getCouponDefinitionId() {
        return couponDefinitionId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public void setCouponDefinitionId(Long couponDefinitionId) {
        this.couponDefinitionId = couponDefinitionId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public Byte getPreferentialType() {
        return preferentialType;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public void setPreferentialType(Byte preferentialType) {
        this.preferentialType = preferentialType;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public Byte getValidType() {
        return validType;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public void setValidType(Byte validType) {
        this.validType = validType;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public Integer getValidDay() {
        return validDay;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public void setValidDay(Integer validDay) {
        this.validDay = validDay;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public BigDecimal getMinConsume() {
        return minConsume;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public void setMinConsume(BigDecimal minConsume) {
        this.minConsume = minConsume;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public String getCouponName() {
        return couponName;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public void setCouponName(String couponName) {
        this.couponName = couponName == null ? null : couponName.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public BigDecimal getMoney() {
        return money;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public BigDecimal getDiscount() {
        return discount;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public String getInfo() {
        return info;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public Date getValidDateStart() {
        return validDateStart;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public void setValidDateStart(Date validDateStart) {
        this.validDateStart = validDateStart;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public Date getValidDateEnd() {
        return validDateEnd;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public void setValidDateEnd(Date validDateEnd) {
        this.validDateEnd = validDateEnd;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public Long getCreateUserId() {
        return createUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public String getCreateUserName() {
        return createUserName;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public Long getModifiedUserId() {
        return modifiedUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public void setModifiedUserId(Long modifiedUserId) {
        this.modifiedUserId = modifiedUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public String getModifiedUserName() {
        return modifiedUserName;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public void setModifiedUserName(String modifiedUserName) {
        this.modifiedUserName = modifiedUserName == null ? null : modifiedUserName.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public Date getModifiedDate() {
        return modifiedDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public String getNote() {
        return note;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public String getStateCode() {
        return stateCode;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public void setStateCode(String stateCode) {
        this.stateCode = stateCode == null ? null : stateCode.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public String getStateName() {
        return stateName;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public void setStateName(String stateName) {
        this.stateName = stateName == null ? null : stateName.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public String getExtendCode() {
        return extendCode;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public void setExtendCode(String extendCode) {
        this.extendCode = extendCode == null ? null : extendCode.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public String getExtendName() {
        return extendName;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public void setExtendName(String extendName) {
        this.extendName = extendName == null ? null : extendName.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public String getExtendNote() {
        return extendNote;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public void setExtendNote(String extendNote) {
        this.extendNote = extendNote == null ? null : extendNote.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public Boolean getValid() {
        return valid;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    public void setValid(Boolean valid) {
        this.valid = valid;
    }
}