package com.bizvane.couponfacade.models.vo;

import java.io.Serializable;

/**
 * Created by yunjie.tian on 2018/10/23.
 */
public class CouponSendMemberListRequestVO implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @io.swagger.annotations.ApiModelProperty(value = "业务id", name = "sendBusinessId")
    private Long sendBusinessId;

    @io.swagger.annotations.ApiModelProperty(value = "发送类型", name = "sendType")
    private String sendType;

    @io.swagger.annotations.ApiModelProperty(value = "会员名称", name = "name")
    private String name;

    @io.swagger.annotations.ApiModelProperty(value = "会员卡号", name = "cardNo")
    private String cardNo;

    @io.swagger.annotations.ApiModelProperty(value = "品牌id", name = "brandId")
    private Long brandId;

    @io.swagger.annotations.ApiModelProperty(value = "当前页数", name = "pageNumber")
    private Integer pageNumber = 1;

    @io.swagger.annotations.ApiModelProperty(value = "显示条数", name = "pageSize")
    private Integer pageSize = 20;

    public Long getSendBusinessId() {
        return sendBusinessId;
    }

    public void setSendBusinessId(Long sendBusinessId) {
        this.sendBusinessId = sendBusinessId;
    }

    public String getSendType() {
        return sendType;
    }

    public void setSendType(String sendType) {
        this.sendType = sendType;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
