package com.bizvane.couponfacade.models.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by yunjie.tian on 2018/12/19.
 */
public class SendCouponQuotaBatchRequestVO implements Serializable{

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "券定义id", name = "couponDefinitionId", required = false,example = "")
    private Long couponDefinitionId;

    @ApiModelProperty(value = "任务名称" , name = "businessName" , required = false , example = "")
    private String businessName;

    @ApiModelProperty(value = "业务id" , name = "businessId" , required = false , example = "")
    private Long businessId;

    @ApiModelProperty(value = "业务类型" , name = "businessType" , required = false , example = "")
    private String businessType;

    @ApiModelProperty(value = "创建人id",name = "createUserId", required = false,example = "")
    private Long createUserId;

    @ApiModelProperty(value = "创建人",name = "createUserName", required = false,example = "")
    private String createUserName;

    @ApiModelProperty(value = "员工code",name = "staffCode", required = true,example = "")
    private String staffCode;
    @ApiModelProperty(value = "员工名称",name = "staffName", required = true,example = "")
    private String staffName;
    @ApiModelProperty(value = "企业id",name = "企业id", required = true,example = "")
    private Long sysCompanyId;
    @ApiModelProperty(value = "品牌id",name = "品牌id", required = true,example = "")
    private Long sysBrandId;

    @ApiModelProperty(value = "发送会员数量",name = "发送会员数量", required = true,example = "")
    private String memberNum;

    @ApiModelProperty(value = "券配额表主键",name = "券配额表主键", required = true,example = "")
    private Long couponQuotaId;

    @ApiModelProperty(value = "会员code,逗号拼接",name = "会员code,逗号拼接", required = true,example = "")
    private String memberCodeStr;

    @ApiModelProperty(value = "会员姓名,逗号拼接",name = "会员姓名,逗号拼接", required = true,example = "")
    private String memberNameStr;


    public Long getCouponDefinitionId() {
        return couponDefinitionId;
    }

    public void setCouponDefinitionId(Long couponDefinitionId) {
        this.couponDefinitionId = couponDefinitionId;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
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
        this.createUserName = createUserName;
    }

    public String getStaffCode() {
        return staffCode;
    }

    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
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

    public String getMemberNum() {
        return memberNum;
    }

    public void setMemberNum(String memberNum) {
        this.memberNum = memberNum;
    }

    public Long getCouponQuotaId() {
        return couponQuotaId;
    }

    public void setCouponQuotaId(Long couponQuotaId) {
        this.couponQuotaId = couponQuotaId;
    }

    public String getMemberCodeStr() {
        return memberCodeStr;
    }

    public void setMemberCodeStr(String memberCodeStr) {
        this.memberCodeStr = memberCodeStr;
    }

    public String getMemberNameStr() {
        return memberNameStr;
    }

    public void setMemberNameStr(String memberNameStr) {
        this.memberNameStr = memberNameStr;
    }
}
