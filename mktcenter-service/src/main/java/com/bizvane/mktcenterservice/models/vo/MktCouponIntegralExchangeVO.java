package com.bizvane.mktcenterservice.models.vo;

import com.bizvane.centerstageservice.models.po.SysStorePo;
import com.bizvane.couponfacade.models.po.CouponDefinitionPO;
import com.bizvane.couponfacade.models.vo.CouponDetailResponseVO;
import com.bizvane.mktcenterservice.models.po.MktCouponIntegralExchangePO;

import java.util.Date;
import java.util.List;

/**
 * Created by agan on 2018/11/22.
 */
public class MktCouponIntegralExchangeVO extends MktCouponIntegralExchangePO{
    private String startTime;
    private  String endTime;

    private List<Long> exchangeIds;//id集合
    private Integer restCount;//剩余库存
    //门店实体类
    private List<SysStorePo> sysStorePos;
    //券剩余数量
    private Integer residueCouponNumber;
    private CouponDefinitionPO couponDefinitionPO;
    //券
    private CouponDetailResponseVO couponDetailResponseVO;

    public List<Long> getExchangeIds() {
        return exchangeIds;
    }

    public void setExchangeIds(List<Long> exchangeIds) {
        this.exchangeIds = exchangeIds;
    }

    public Integer getRestCount() {
        return restCount;
    }

    public void setRestCount(Integer restCount) {
        this.restCount = restCount;
    }

    public CouponDetailResponseVO getCouponDetailResponseVO() {
        return couponDetailResponseVO;
    }

    public void setCouponDetailResponseVO(CouponDetailResponseVO couponDetailResponseVO) {
        this.couponDetailResponseVO = couponDetailResponseVO;
    }

    public List<SysStorePo> getSysStorePos() {
        return sysStorePos;
    }

    public void setSysStorePos(List<SysStorePo> sysStorePos) {
        this.sysStorePos = sysStorePos;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
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
