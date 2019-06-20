package com.bizvane.mktcenterservice.controllers.rpc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bizvane.mktcenterfacade.interfaces.ConvertCouponService;
import com.bizvane.mktcenterfacade.models.bo.CouponIntegralExchangeBO;
import com.bizvane.mktcenterfacade.models.po.MktConvertCouponRecordPO;
import com.bizvane.mktcenterfacade.models.vo.CouponIntegralExchangeVO;
import com.bizvane.mktcenterfacade.models.vo.CouponRecordVO;
import com.bizvane.mktcenterfacade.rpc.IntegralMallServiceRpc;
import com.bizvane.utils.responseinfo.ResponseData;
import com.github.pagehelper.PageInfo;

/**
 * @author chen.li
 * @date on 2019/5/11 23:44
 * @description
 */
@RestController
@RequestMapping("integralMallServiceRpc")
public class IntegralMallRpcController implements IntegralMallServiceRpc {

    @Autowired
    private ConvertCouponService convertCouponService;

    //积分兑换券
    //查询对换列表
    @Override
    public ResponseData<CouponIntegralExchangeBO> getConvernCouponLists(@RequestBody CouponRecordVO vo){
        return convertCouponService.getConvernCouponLists(vo);
    }

    //兑换
    @Override
    public ResponseData<Integer> doConvernCoupon(@RequestBody CouponRecordVO vo){
        return convertCouponService.doConvernCoupon(vo);
    }
    //查询已兑换
    @Override
    public ResponseData<PageInfo<MktConvertCouponRecordPO>> getConvernConpouByMember(@RequestBody CouponRecordVO vo){
        return convertCouponService.getConvernConpouByMember(vo);
    }

    @Override
    public ResponseData<CouponIntegralExchangeVO> getCouponAndPrice(@RequestBody CouponRecordVO vo) {
      // TODO Auto-generated method stub
      return convertCouponService.getCouponAndPrice(vo);
    }
}
