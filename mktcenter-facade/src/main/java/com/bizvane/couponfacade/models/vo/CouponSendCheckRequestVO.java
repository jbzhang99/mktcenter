package com.bizvane.couponfacade.models.vo;

import java.io.Serializable;

/**
 * 发券审核
 * Created by yunjie.tian on 2018/8/23.
 */
public class CouponSendCheckRequestVO implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Byte taskStatus;

    private Long couponManualId;

    private String remark;

    @io.swagger.annotations.ApiModelProperty(value = "总条数",name = "totalNumber", required = true,example = "")
    private Integer totalNumber;

    @io.swagger.annotations.ApiModelProperty(value = "总页数",name = "totalPages", required = true,example = "")
    private Integer totalPages;

    @io.swagger.annotations.ApiModelProperty(value = "审核中心id",name = "sysCheckId", required = true,example = "")
    private Long sysCheckId;


    public Long getSysCheckId() {
        return sysCheckId;
    }

    public void setSysCheckId(Long sysCheckId) {
        this.sysCheckId = sysCheckId;
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

    public Byte getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Byte taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Long getCouponManualId() {
        return couponManualId;
    }

    public void setCouponManualId(Long couponManualId) {
        this.couponManualId = couponManualId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
