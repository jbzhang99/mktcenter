package com.bizvane.mktcenterfacade.models.bo;

import com.bizvane.mktcenterfacade.models.vo.ActivityVO;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author xiao.shu
 * @date on 2018/8/7 13:43
 * @description
 *
 */
public class ActivityManualBO {
      private List<ActivityVO> activityVOList;
    /***
     * 券总数量
     */
    private Long sumCouponReceive;
  /**
   * 券使用数量*/
    private Long sumCouponUse;

    private BigDecimal sumCouponMoney;


    public List<ActivityVO> getActivityVOList() {
        return activityVOList;
    }

    public void setActivityVOList(List<ActivityVO> activityVOList) {
        this.activityVOList = activityVOList;
    }

    public Long getSumCouponReceive() {
        return sumCouponReceive;
    }

    public void setSumCouponReceive(Long sumCouponReceive) {
        this.sumCouponReceive = sumCouponReceive;
    }

    public Long getSumCouponUse() {
        return sumCouponUse;
    }

    public void setSumCouponUse(Long sumCouponUse) {
        this.sumCouponUse = sumCouponUse;
    }

    public BigDecimal getSumCouponMoney() {
        return sumCouponMoney;
    }

    public void setSumCouponMoney(BigDecimal sumCouponMoney) {
        this.sumCouponMoney = sumCouponMoney;
    }
}
