package com.bizvane.couponservice.service;

import com.bizvane.couponfacade.models.bo.CouponPartBo;
import com.bizvane.couponfacade.models.vo.CouponDefinitionPartVo;
import com.bizvane.couponfacade.models.vo.CouponStoreGroupVo;
import com.bizvane.couponfacade.models.vo.CouponStoreVo;
import com.bizvane.utils.responseinfo.ResponseData;

import javax.servlet.http.HttpServletRequest;


public interface CouponAnalysisService {
    /**
     * 券效果分析发券概况
     *
     * @param sysBrandId
     * @return
     */
    ResponseData getCouponSurvey(Long sysBrandId);

    /**
     * 券效果分析核销量
     *
     * @param bo
     * @return
     */
    ResponseData getCouponUsed(CouponPartBo bo);

    /**
     * 券效果分析店铺
     *
     * @param vo
     * @return
     * */
    ResponseData getCouponStore(CouponStoreVo vo, HttpServletRequest request);

    /**
     * 券效果分析店铺群组
     *
     * @param vo
     * @return
     * */
    ResponseData getCouponStoreGroup(CouponStoreGroupVo vo, HttpServletRequest request);
    /**
     * 券效果分析券订单量
     *
     * @param bo
     * @return
     * */
    ResponseData couponOrders(CouponPartBo bo);

    /**
     * 券展示
     *
     * @param vo
     * @return
     * */
    ResponseData couponDisplay(CouponDefinitionPartVo vo);
}
