package com.bizvane.mktcenterservice.models.vo;

import com.bizvane.centerstageservice.models.po.SysStorePo;
import com.bizvane.couponfacade.models.po.CouponDefinitionPO;
import com.bizvane.mktcenterservice.models.po.MktCouponIntegralExchangePO;

import java.util.Date;
import java.util.List;

/**
 * Created by agan on 2018/11/22.
 */
public class MktCouponIntegralExchangeVO extends MktCouponIntegralExchangePO{
    private Date startTime;
    private  Date endTime;

    //门店实体类
    private List<SysStorePo> sysStorePos;
    //券剩余数量
    private Integer residueCouponNumber;
    private CouponDefinitionPO couponDefinitionPO;
    public List<SysStorePo> getSysStorePos() {
        return sysStorePos;
    }

    public void setSysStorePos(List<SysStorePo> sysStorePos) {
        this.sysStorePos = sysStorePos;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getResidueCouponNumber() {
        return residueCouponNumber;
    }

    public void setResidueCouponNumber(Integer residueCouponNumber) {
        this.residueCouponNumber = residueCouponNumber;
    }

    public CouponDefinitionPO getCouponDefinitionPO() {
        return couponDefinitionPO;
    }

    public void setCouponDefinitionPO(CouponDefinitionPO couponDefinitionPO) {
        this.couponDefinitionPO = couponDefinitionPO;
    }
}
