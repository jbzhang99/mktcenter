package com.bizvane.couponfacade.models.vo;

import com.bizvane.members.facade.es.vo.MembersInfoSearchVo;

import java.io.Serializable;

/**
 * Created by yunjie.tian on 2018/12/11.
 */
public class CouponManualRequestVO implements Serializable{

    private MembersInfoSearchVo searchVo;

    private Long couponDefinitionId;

    private String taskName;

    private String sendTimeStr;

    private Byte sendType;

    private Integer totalNumber;

    private String couponDefinitionIds;

    public Integer getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(Integer totalNumber) {
        this.totalNumber = totalNumber;
    }

    public MembersInfoSearchVo getSearchVo() {
        return searchVo;
    }

    public void setSearchVo(MembersInfoSearchVo searchVo) {
        this.searchVo = searchVo;
    }

    public Long getCouponDefinitionId() {
        return couponDefinitionId;
    }

    public void setCouponDefinitionId(Long couponDefinitionId) {
        this.couponDefinitionId = couponDefinitionId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getSendTimeStr() {
        return sendTimeStr;
    }

    public void setSendTimeStr(String sendTimeStr) {
        this.sendTimeStr = sendTimeStr;
    }

    public Byte getSendType() {
        return sendType;
    }

    public void setSendType(Byte sendType) {
        this.sendType = sendType;
    }

    public String getCouponDefinitionIds() {
        return couponDefinitionIds;
    }

    public void setCouponDefinitionIds(String couponDefinitionIds) {
        this.couponDefinitionIds = couponDefinitionIds;
    }
}
