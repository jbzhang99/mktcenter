package com.bizvane.couponservice.controller;

import com.bizvane.couponfacade.models.bo.CouponPartBo;
import com.bizvane.couponfacade.models.vo.CouponDefinitionPartVo;
import com.bizvane.couponfacade.models.vo.CouponStoreGroupVo;
import com.bizvane.couponfacade.models.vo.CouponStoreVo;
import com.bizvane.couponservice.service.CouponAnalysisService;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.bizvane.utils.tokens.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liufq
 */
@RestController
@RequestMapping("/couponAnalysis")
public class CouponAnalysisController {
    @Autowired
    private CouponAnalysisService couponAnalysisService;

    /**
     * 券效果分析发券概况
     *
     * */
    @RequestMapping(value = "/getCouponSurvey", method = RequestMethod.POST)
    public ResponseData getCouponSurvey(Long sysBrandId) {
        return couponAnalysisService.getCouponSurvey(sysBrandId);
    }

    /**
     * 券按效果分析核销量
     *
     * */
    @RequestMapping(value = "/getCouponUsed", method = RequestMethod.POST)
    public ResponseData getCouponUsed(CouponPartBo bo, HttpServletRequest request) {
        SysAccountPO sysAccountPO = TokenUtils.getStageUser(request);
        bo.setSysCompanyId(sysAccountPO.getSysCompanyId());
        bo.setSysBrandId(sysAccountPO.getBrandId());
       /* bo.setSysCompanyId(3841L);
        bo.setSysBrandId(96L);*/
        return couponAnalysisService.getCouponUsed(bo);
    }

    /**
     * 券效果分析店铺
     *
     * @param vo
     * @return
     * */
    @RequestMapping(value = "/getCouponStore", method = RequestMethod.POST)
    public ResponseData getCouponStore(CouponStoreVo vo, HttpServletRequest request) {
        SysAccountPO sysAccountPO = TokenUtils.getStageUser(request);
        vo.setSysCompanyId(sysAccountPO.getSysCompanyId());
        vo.setSysBrandId(sysAccountPO.getBrandId());
        /*vo.setSysCompanyId(3841L);
        vo.setSysBrandId(96L);*/
        return couponAnalysisService.getCouponStore(vo,request);
    }

    /**
     * 券效果分析店铺群组
     *
     * @param vo
     * @return
     * */
    @RequestMapping(value = "/getCouponStoreGroup", method = RequestMethod.POST)
    public ResponseData getCouponStoreGroup(CouponStoreGroupVo vo, HttpServletRequest request) {
        SysAccountPO sysAccountPO = TokenUtils.getStageUser(request);
        vo.setSysCompanyId(sysAccountPO.getSysCompanyId());
        vo.setSysBrandId(sysAccountPO.getBrandId());
        vo.setSysAccountId(sysAccountPO.getSysAccountId());
       /* vo.setSysCompanyId(3841L);
        vo.setSysBrandId(96L);
        vo.setSysAccountId(2625L);*/
        return couponAnalysisService.getCouponStoreGroup(vo, request);
    }
    /**
     * 券效果分析订单量+成交额
     *
     * @param bo
     * @return
     * */
    @RequestMapping(value = "/couponOrders", method = RequestMethod.POST)
    public ResponseData couponOrders(CouponPartBo bo,HttpServletRequest request) {
        SysAccountPO sysAccountPO = TokenUtils.getStageUser(request);
        bo.setSysCompanyId(sysAccountPO.getSysCompanyId());
        bo.setSysBrandId(sysAccountPO.getBrandId());
       /* bo.setSysCompanyId(3841L);
        bo.setSysBrandId(96L);*/
        return couponAnalysisService.couponOrders(bo);
    }
    /**
     * 券展示
     *
     * @param vo
     * @return
     * */
    @RequestMapping(value = "/couponDisplay", method = RequestMethod.POST)
    public ResponseData couponDisplay(CouponDefinitionPartVo vo,HttpServletRequest request) {
        SysAccountPO sysAccountPO = TokenUtils.getStageUser(request);
        vo.setSysCompanyId(sysAccountPO.getSysCompanyId());
        vo.setSysBrandId(sysAccountPO.getBrandId());
        /*vo.setSysCompanyId(3841L);
        vo.setSysBrandId(96L);*/
        return couponAnalysisService.couponDisplay(vo);
    }


}
