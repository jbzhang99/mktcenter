package com.bizvane.couponservice.controller;

import com.bizvane.centerstageservice.rpc.CompanyServiceRpc;
import com.bizvane.couponfacade.models.bo.CouponPartBo;
import com.bizvane.couponservice.service.SingleCoupleAnalysisService;
import com.bizvane.mktcenterservice.common.report.BaseUrl;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.bizvane.utils.tokens.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/singleCouponAnalysis")
public class SingleCoupleAnalysisController {
    @Autowired
    private SingleCoupleAnalysisService singleCoupleAnalysisService;

    @Autowired
    private com.bizvane.mktcenterservice.common.report.BaseUrl BaseUrl;

    @Autowired
    private CompanyServiceRpc companyServiceRpc;
    /**
     * 单券分析统计
     *
     * */
    @RequestMapping("/getCouponSurvey")
    public ResponseData getCouponSurvey(CouponPartBo bo,HttpServletRequest request) {
        SysAccountPO sysAccountPO = TokenUtils.getStageUser(request);
        bo.setSysCompanyId(sysAccountPO.getSysCompanyId());
        bo.setSysBrandId(sysAccountPO.getBrandId());
       /* bo.setSysCompanyId(3841L);
        bo.setSysBrandId(96L);*/
        return singleCoupleAnalysisService.getCouponSurvey(bo);
    }
    /**
     * 单券订单量和成交额
     *
     * */
    @RequestMapping("/singleSaleNum")
    public ResponseData singleSaleNum(CouponPartBo couponPartBo,HttpServletRequest request) {
        SysAccountPO sysAccountPO = TokenUtils.getStageUser(request);
        couponPartBo.setSysCompanyId(sysAccountPO.getSysCompanyId());
        couponPartBo.setSysBrandId(sysAccountPO.getBrandId());
        /*couponPartBo.setSysCompanyId(3841L);
        couponPartBo.setSysBrandId(96L);*/
        return singleCoupleAnalysisService.singleSaleNum(couponPartBo);
    }
    /**
     * 单券发券方式
     *
     * */
    @RequestMapping("/singleSendWayList")
    public ResponseData singleSendWayList(HttpServletRequest request,CouponPartBo couponPartBo) {
        SysAccountPO sysAccountPO = TokenUtils.getStageUser(request);
        couponPartBo.setSysCompanyId(sysAccountPO.getSysCompanyId());
        couponPartBo.setSysBrandId(sysAccountPO.getBrandId());
        /*couponPartBo.setSysCompanyId(3841L);
        couponPartBo.setSysBrandId(96L);*/
        return singleCoupleAnalysisService.singleSendWayList(couponPartBo);
    }
}
