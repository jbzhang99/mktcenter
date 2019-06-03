package com.bizvane.couponservice.service;

import com.bizvane.couponfacade.models.bo.CouponPartBo;
import com.bizvane.utils.responseinfo.ResponseData;


public interface SingleCoupleAnalysisService {
    //单券分析发券概况
    ResponseData getCouponSurvey(CouponPartBo bo);
    //得到单券分析订单量
    ResponseData singleSaleNum(CouponPartBo couponPartBo);
    //得到单券分析发券方式
    ResponseData singleSendWayList(CouponPartBo couponPartBo);
}
