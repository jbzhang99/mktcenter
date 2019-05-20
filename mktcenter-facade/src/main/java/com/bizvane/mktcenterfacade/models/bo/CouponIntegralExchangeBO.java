package com.bizvane.mktcenterfacade.models.bo;

import com.bizvane.mktcenterfacade.models.vo.MktCouponIntegralExchangeVO;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author: lijunwei
 * @Time: 2018/11/28 14:34
 */
public class CouponIntegralExchangeBO {
    @ApiModelProperty(name = "pageInfoMktCouponIntegralExchangeVO", value = "出参数据")
    private PageInfo<MktCouponIntegralExchangeVO> pageInfo;
    @ApiModelProperty(name = "countIntegral", value = "会员当前积分")
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
