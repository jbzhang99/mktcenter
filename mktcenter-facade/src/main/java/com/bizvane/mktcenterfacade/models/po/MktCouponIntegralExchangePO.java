package com.bizvane.mktcenterfacade.models.po;

import java.io.Serializable;
import java.util.Date;

public class MktCouponIntegralExchangePO implements Serializable {
    /**
     * 只读.
    . exchange_id
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    @io.swagger.annotations.ApiModelProperty(value = "",name = "exchangeId", required = false,example = "")
    private Long exchangeId;

    /**
     * 只读.
    编号. exchange_code
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    @io.swagger.annotations.ApiModelProperty(value = "编号",name = "exchangeCode", required = false,example = "")
    private String exchangeCode;

    /**
     * 只读.
    品牌id. sys_brand_id
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    @io.swagger.annotations.ApiModelProperty(value = "品牌id",name = "sysBrandId", required = false,example = "")
    private Long sysBrandId;

    /**
     * 只读.
    企业id. sys_company_id
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    @io.swagger.annotations.ApiModelProperty(value = "企业id",name = "sysCompanyId", required = false,example = "")
    private Long sysCompanyId;

    /**
     * 只读.
    券实例id. coupon_entity_id
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    @io.swagger.annotations.ApiModelProperty(value = "券实例id",name = "couponEntityId", required = false,example = "")
    private Long couponEntityId;

    /**
     * 只读.
    券名称. coupon_name
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    @io.swagger.annotations.ApiModelProperty(value = "券名称",name = "couponName", required = false,example = "")
    private String couponName;

    /**
     * 只读.
    积分兑换价格. exchange_price
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    @io.swagger.annotations.ApiModelProperty(value = "积分兑换价格",name = "exchangePrice", required = false,example = "")
    private Integer exchangePrice;

    /**
     * 只读.
    是否限制库存数量 0：限制 1：不限制. store_status
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    @io.swagger.annotations.ApiModelProperty(value = "是否限制库存数量 0：限制 1：不限制",name = "storeStatus", required = false,example = "")
    private Integer storeStatus;

    /**
     * 只读.
    库存数量. store_count
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    @io.swagger.annotations.ApiModelProperty(value = "库存数量",name = "storeCount", required = false,example = "")
    private Long storeCount;

    /**
     * 只读.
    是否限兑 0：限制 1：不限制. exchange_status
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    @io.swagger.annotations.ApiModelProperty(value = "是否限兑 0：限制 1：不限制",name = "exchangeStatus", required = false,example = "")
    private Integer exchangeStatus;

    /**
     * 只读.
    如果限制，限制数量. exchange_count
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    @io.swagger.annotations.ApiModelProperty(value = "如果限制，限制数量",name = "exchangeCount", required = false,example = "")
    private Long exchangeCount;

    /**
     * 只读.
    已经兑换数量. already_exchange_count
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    @io.swagger.annotations.ApiModelProperty(value = "已经兑换数量",name = "alreadyExchangeCount", required = false,example = "")
    private Long alreadyExchangeCount;

    /**
     * 只读.
    会员范围 0:全部会员 1：部分会员. store_scope
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    @io.swagger.annotations.ApiModelProperty(value = "会员范围 0:全部会员 1：部分会员",name = "storeScope", required = false,example = "")
    private Integer storeScope;

    /**
     * 只读.
    会员范围店铺范围. store_list
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    @io.swagger.annotations.ApiModelProperty(value = "会员范围店铺范围",name = "storeList", required = false,example = "")
    private String storeList;

    /**
     * 只读.
    上架状态 0：下架 1：上架. sales_status
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    @io.swagger.annotations.ApiModelProperty(value = "上架状态 0：下架 1：上架",name = "salesStatus", required = false,example = "")
    private Integer salesStatus;

    /**
     * 只读.
    . create_user_id
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    @io.swagger.annotations.ApiModelProperty(value = "",name = "createUserId", required = false,example = "")
    private Long createUserId;

    /**
     * 只读.
    . create_user_name
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    @io.swagger.annotations.ApiModelProperty(value = "",name = "createUserName", required = false,example = "")
    private String createUserName;

    /**
     * 只读.
    . create_date
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    @io.swagger.annotations.ApiModelProperty(value = "",name = "createDate", required = false,example = "")
    private Date createDate;

    /**
     * 只读.
    . modify_user_id
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    @io.swagger.annotations.ApiModelProperty(value = "",name = "modifyUserId", required = false,example = "")
    private Long modifyUserId;

    /**
     * 只读.
    . modify_user_name
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    @io.swagger.annotations.ApiModelProperty(value = "",name = "modifyUserName", required = false,example = "")
    private String modifyUserName;

    /**
     * 只读.
    . modified_date
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    @io.swagger.annotations.ApiModelProperty(value = "",name = "modifiedDate", required = false,example = "")
    private Date modifiedDate;

    /**
     * 只读.
    数据有效性：1=有效；0=无效. valid
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    @io.swagger.annotations.ApiModelProperty(value = "数据有效性：1=有效；0=无效",name = "valid", required = false,example = "")
    private Boolean valid;

    /**
     * 只读.
    说明. exchange_info
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    @io.swagger.annotations.ApiModelProperty(value = "说明",name = "exchangeInfo", required = false,example = "")
    private String exchangeInfo;

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    private static final long serialVersionUID = 1L;

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    public Long getExchangeId() {
        return exchangeId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    public void setExchangeId(Long exchangeId) {
        this.exchangeId = exchangeId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    public String getExchangeCode() {
        return exchangeCode;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    public void setExchangeCode(String exchangeCode) {
        this.exchangeCode = exchangeCode == null ? null : exchangeCode.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    public Long getSysBrandId() {
        return sysBrandId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    public void setSysBrandId(Long sysBrandId) {
        this.sysBrandId = sysBrandId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    public Long getSysCompanyId() {
        return sysCompanyId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    public void setSysCompanyId(Long sysCompanyId) {
        this.sysCompanyId = sysCompanyId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    public Long getCouponEntityId() {
        return couponEntityId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    public void setCouponEntityId(Long couponEntityId) {
        this.couponEntityId = couponEntityId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    public String getCouponName() {
        return couponName;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    public void setCouponName(String couponName) {
        this.couponName = couponName == null ? null : couponName.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    public Integer getExchangePrice() {
        return exchangePrice;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    public void setExchangePrice(Integer exchangePrice) {
        this.exchangePrice = exchangePrice;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    public Integer getStoreStatus() {
        return storeStatus;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    public void setStoreStatus(Integer storeStatus) {
        this.storeStatus = storeStatus;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    public Long getStoreCount() {
        return storeCount;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    public void setStoreCount(Long storeCount) {
        this.storeCount = storeCount;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    public Integer getExchangeStatus() {
        return exchangeStatus;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    public void setExchangeStatus(Integer exchangeStatus) {
        this.exchangeStatus = exchangeStatus;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    public Long getExchangeCount() {
        return exchangeCount;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    public void setExchangeCount(Long exchangeCount) {
        this.exchangeCount = exchangeCount;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    public Long getAlreadyExchangeCount() {
        return alreadyExchangeCount;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    public void setAlreadyExchangeCount(Long alreadyExchangeCount) {
        this.alreadyExchangeCount = alreadyExchangeCount;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    public Integer getStoreScope() {
        return storeScope;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    public void setStoreScope(Integer storeScope) {
        this.storeScope = storeScope;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    public String getStoreList() {
        return storeList;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    public void setStoreList(String storeList) {
        this.storeList = storeList == null ? null : storeList.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    public Integer getSalesStatus() {
        return salesStatus;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    public void setSalesStatus(Integer salesStatus) {
        this.salesStatus = salesStatus;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    public Long getCreateUserId() {
        return createUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    public String getCreateUserName() {
        return createUserName;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    public Long getModifyUserId() {
        return modifyUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    public void setModifyUserId(Long modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    public String getModifyUserName() {
        return modifyUserName;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    public void setModifyUserName(String modifyUserName) {
        this.modifyUserName = modifyUserName == null ? null : modifyUserName.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    public Date getModifiedDate() {
        return modifiedDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    public Boolean getValid() {
        return valid;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    public String getExchangeInfo() {
        return exchangeInfo;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    public void setExchangeInfo(String exchangeInfo) {
        this.exchangeInfo = exchangeInfo == null ? null : exchangeInfo.trim();
    }
}