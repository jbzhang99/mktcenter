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
}
