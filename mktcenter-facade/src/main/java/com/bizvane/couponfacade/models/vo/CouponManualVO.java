package com.bizvane.couponfacade.models.vo;

import com.bizvane.couponfacade.models.po.CouponManualPO;

import java.math.BigDecimal;

/**
 * Created by yunjie.tian on 2018/7/19.
 */
public class CouponManualVO extends CouponManualPO{

    @io.swagger.annotations.ApiModelProperty(value = "发券数量",name = "allCount", required = true,example = "")
    private Long allCount;
    @io.swagger.annotations.ApiModelProperty(value = "核销率",name = "cancelRate", required = true,example = "")
    private BigDecimal cancelRate;
    @io.swagger.annotations.ApiModelProperty(value = "合计领券",name = "sumSuccessCount", required = true,example = "")
    private Long sumSuccessCount;
    @io.swagger.annotations.ApiModelProperty(value = "合计核销",name = "sumCancelCount", required = true,example = "")
    private Long sumCancelCount;
    @io.swagger.annotations.ApiModelProperty(value = "合计券收益",name = "sumBusinessAmount", required = true,example = "")
    private BigDecimal sumBusinessAmount;
    @io.swagger.annotations.ApiModelProperty(value = "合计券优惠金额",name = "sumMoney", required = true,example = "")
    private BigDecimal sumMoney;
    @io.swagger.annotations.ApiModelProperty(value = "发券开始时间",name = "sendTimeStart", required = true,example = "")
    private String sendTimeStartStr;
    @io.swagger.annotations.ApiModelProperty(value = "发券结束时间",name = "sendTimeEnd", required = true,example = "")
    private String sendTimeEndStr;

    @io.swagger.annotations.ApiModelProperty(value = "发券时间",name = "sendTimeStr", required = false,example = "")
    private String sendTimeStr;

    @io.swagger.annotations.ApiModelProperty(value = "创建时间",name = "createDateStr", required = false,example = "")
    private String createDateStr;
    @io.swagger.annotations.ApiModelProperty(value = "券收益",name = "useBusinessAmount", required = false,example = "")
    private BigDecimal useBusinessAmount;

    @io.swagger.annotations.ApiModelProperty(value = "审核单id",name = "sysCheckId", required = false,example = "")
    private Long sysCheckId;

    @io.swagger.annotations.ApiModelProperty(value = "当前页数", name = "pageNumber")
    private Integer pageNumber = 1;

    @io.swagger.annotations.ApiModelProperty(value = "显示条数", name = "pageSize")
    private Integer pageSize = 20;

    @io.swagger.annotations.ApiModelProperty(value = "业务id",name = "businessId", required = true,example = "")
    private String businessId;
    @io.swagger.annotations.ApiModelProperty(value = "业务类型",name = "businessType", required = true,example = "")
    private String businessType;

    @io.swagger.annotations.ApiModelProperty(value = "创建时间开始",name = "createDtStart", required = true,example = "")
    private String createDtStart;

    @io.swagger.annotations.ApiModelProperty(value = "创建时间结束",name = "createDtEnd", required = true,example = "")
    private String createDtEnd;

    @io.swagger.annotations.ApiModelProperty(value = "总条数",name = "totalNumber", required = true,example = "")
    private Integer totalNumber;

    @io.swagger.annotations.ApiModelProperty(value = "总页数",name = "totalPages", required = true,example = "")
    private Integer totalPages;

    @io.swagger.annotations.ApiModelProperty(value = "劵定义列表",name = "couponDefinitionIds", required = true,example = "")
    private String couponDefinitionIds;

    public BigDecimal getSumMoney() {
        return sumMoney;
    }

    public void setSumMoney(BigDecimal sumMoney) {
        this.sumMoney = sumMoney;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getSendTimeStr() {
        return sendTimeStr;
    }

    public void setSendTimeStr(String sendTimeStr) {
        this.sendTimeStr = sendTimeStr;
    }

    public String getCreateDateStr() {
        return createDateStr;
    }

    public void setCreateDateStr(String createDateStr) {
        this.createDateStr = createDateStr;
    }

    public Long getSysCheckId() {
        return sysCheckId;
    }

    public void setSysCheckId(Long sysCheckId) {
        this.sysCheckId = sysCheckId;
    }

    public BigDecimal getUseBusinessAmount() {
        return useBusinessAmount;
    }

    public void setUseBusinessAmount(BigDecimal useBusinessAmount) {
        this.useBusinessAmount = useBusinessAmount;
    }

    public BigDecimal getSumBusinessAmount() {
        return sumBusinessAmount;
    }

    public void setSumBusinessAmount(BigDecimal sumBusinessAmount) {
        this.sumBusinessAmount = sumBusinessAmount;
    }

    public Long getAllCount() {
        return allCount;
    }

    public void setAllCount(Long allCount) {
        this.allCount = allCount;
    }

    public Long getSumSuccessCount() {
        return sumSuccessCount;
    }

    public void setSumSuccessCount(Long sumSuccessCount) {
        this.sumSuccessCount = sumSuccessCount;
    }

    public Long getSumCancelCount() {
        return sumCancelCount;
    }

    public void setSumCancelCount(Long sumCancelCount) {
        this.sumCancelCount = sumCancelCount;
    }

    public BigDecimal getCancelRate() {
        return cancelRate;
    }

    public void setCancelRate(BigDecimal cancelRate) {
        this.cancelRate = cancelRate;
    }

    public String getSendTimeStartStr() {
        return sendTimeStartStr;
    }

    public void setSendTimeStartStr(String sendTimeStartStr) {
        this.sendTimeStartStr = sendTimeStartStr;
    }

    public String getSendTimeEndStr() {
        return sendTimeEndStr;
    }

    public void setSendTimeEndStr(String sendTimeEndStr) {
        this.sendTimeEndStr = sendTimeEndStr;
    }

    public String getCreateDtStart() {
        return createDtStart;
    }

    public void setCreateDtStart(String createDtStart) {
        this.createDtStart = createDtStart;
    }

    public String getCreateDtEnd() {
        return createDtEnd;
    }

    public void setCreateDtEnd(String createDtEnd) {
        this.createDtEnd = createDtEnd;
    }

    public Integer getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(Integer totalNumber) {
        this.totalNumber = totalNumber;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public String getCouponDefinitionIds() {
        return couponDefinitionIds;
    }

    public void setCouponDefinitionIds(String couponDefinitionIds) {
        this.couponDefinitionIds = couponDefinitionIds;
    }
}
