package com.bizvane.mktcenterserviceimpl.controllers;

import com.bizvane.mktcenterservice.interfaces.CouponIntegralExchangeService;
import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.mktcenterservice.models.vo.MktCouponIntegralExchangeVO;
import com.bizvane.mktcenterservice.models.vo.PageForm;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.bizvane.utils.tokens.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by agan on 2018/11/22.
 */
@RestController
@RequestMapping("couponIntegralExchange")
public class CouponIntegralExchangeController {
    @Autowired
    private CouponIntegralExchangeService couponIntegralExchangeService;

    /**
     * 查询积分兑换券列表
     * @param vo
     * @param pageForm
     * @param request
     * @return
     */
    @RequestMapping("getCouponIntegralExchangeList")
    public ResponseData<MktCouponIntegralExchangeVO> getCouponIntegralExchangeList(MktCouponIntegralExchangeVO vo, PageForm pageForm,HttpServletRequest request){
        SysAccountPO stageUser = TokenUtils.getStageUser(request);
        ResponseData<MktCouponIntegralExchangeVO> couponIntegralExchangeList = couponIntegralExchangeService.getCouponIntegralExchangeList(vo, pageForm,stageUser);
        return couponIntegralExchangeList;
    }

    /**
     * 新增积分兑换券规则
     * @param vo
     * @param request
     * @return
     */
    @RequestMapping("addCouponIntegralExchange")
    public ResponseData<Integer> addCouponIntegralExchange(MktCouponIntegralExchangeVO vo,HttpServletRequest request){
        SysAccountPO stageUser = TokenUtils.getStageUser(request);
        ResponseData<Integer> integerResponseData = couponIntegralExchangeService.addCouponIntegralExchange(vo,stageUser);
        return integerResponseData;
    }

    /**
     * 修改积分兑换规则
     * @param vo
     * @param request
     * @return
     */
    @RequestMapping("updateCouponIntegralExchange")
    public ResponseData<Integer> updateCouponIntegralExchange(MktCouponIntegralExchangeVO vo,HttpServletRequest request){
        SysAccountPO stageUser = TokenUtils.getStageUser(request);
        ResponseData<Integer> updateResponseData = couponIntegralExchangeService.updateCouponIntegralExchange(vo,stageUser);
        return updateResponseData;
    }

    /**
     * 查询积分兑换规则详情
     * @param exchangeId
     * @return
     */
    @RequestMapping("selectCouponIntegralExchange")
    public ResponseData<MktCouponIntegralExchangeVO> selectCouponIntegralExchange(Long exchangeId){
        return couponIntegralExchangeService.selectCouponIntegralExchange(exchangeId);
    }

    /**
     * 批量上下架
     * @param vo
     * @param request
     * @return
     */
    @RequestMapping("batchUpdateCouponIntegralExchange")
    public ResponseData<Integer> batchUpdateCouponIntegralExchange(MktCouponIntegralExchangeVO vo,HttpServletRequest request){
        SysAccountPO stageUser = TokenUtils.getStageUser(request);
        ResponseData<Integer> batchResponseData = couponIntegralExchangeService.batchUpdateCouponIntegralExchange(vo,stageUser);
        return batchResponseData;
    }
}
