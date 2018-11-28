package com.bizvane.mktcenterservice.models.bo;

import com.bizvane.mktcenterservice.models.vo.MktCouponIntegralExchangeVO;
import com.github.pagehelper.PageInfo;

/**
 * @Author: lijunwei
 * @Time: 2018/11/28 14:34
 */
public class CouponIntegralExchangeBO {
    private PageInfo<MktCouponIntegralExchangeVO> pageInfo;
    private Integer countIntegral;

    public PageInfo<MktCouponIntegralExchangeVO> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo<MktCouponIntegralExchangeVO> pageInfo) {
        this.pageInfo = pageInfo;
    }

    public Integer getCountIntegral() {
        return countIntegral;
    }

    public void setCountIntegral(Integer countIntegral) {
        this.countIntegral = countIntegral;
    }
}
