package com.bizvane.mktcenterfacade.models.vo;

import com.bizvane.centerstageservice.models.po.SysStorePo;
import com.bizvane.couponfacade.models.po.CouponDefinitionPO;
import com.bizvane.couponfacade.models.vo.CouponDetailResponseVO;
import com.bizvane.mktcenterfacade.models.po.MktCouponIntegralExchangePO;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by agan on 2018/11/22.
 */
public class MktCouponIntegralExchangeVO extends MktCouponIntegralExchangePO {
    @ApiModelProperty(name = "startTime", value = "券有效期的开始时间")
    private String startTime;
    @ApiModelProperty(name = "endTime", value = "券有效期的结束时间")
    private  String endTime;
    @ApiModelProperty(name = "exchangeIds", value = "兑换券id集合")
    private List<Long> exchangeIds;//id集合
    @ApiModelProperty(name = "restCount", value = "剩余库存")
    private Integer restCount;//剩余库存
    //门店实体类
    @ApiModelProperty(name = "sysStorePos", value = "门店信息")
    private List<SysStorePo> sysStorePos;
    //券剩余数量
    @ApiModelProperty(name = "residueCouponNumber", value = "券剩余数量")
    private Integer residueCouponNumber;
    @ApiModelProperty(name = "couponDefinitionPO", value = "券定义实体")
    private CouponDefinitionPO couponDefinitionPO;
    //券
    @ApiModelProperty(name = "couponDetailResponseVO", value = "券详情实体")
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
