package com.bizvane.mktcenterservice.controllers.rpc;

import com.bizvane.mktcenterfacade.interfaces.ConvertCouponService;
import com.bizvane.mktcenterfacade.models.bo.CouponIntegralExchangeBO;
import com.bizvane.mktcenterfacade.models.po.MktActivityRecordPO;
import com.bizvane.mktcenterfacade.models.po.MktConvertCouponRecordPO;
import com.bizvane.mktcenterfacade.models.vo.CouponRecordVO;
import com.bizvane.mktcenterfacade.models.vo.MktActivityRecordVO;
import com.bizvane.utils.responseinfo.ResponseData;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author chen.li
 * @date on 2019/5/11 23:44
 * @description
 */
@RestController
@RequestMapping("taskForWXRpc")
public class IntegralMallRpcController {

    @Autowired
    private ConvertCouponService convertCouponService;

    //积分兑换券
    //查询对换列表
    @RequestMapping("/getConvernCouponLists")
    public ResponseData<CouponIntegralExchangeBO> getConvernCouponLists(@RequestBody CouponRecordVO vo){
        return convertCouponService.getConvernCouponLists(vo);
    }

    //兑换
    @RequestMapping("/doConvernCoupon")
    public ResponseData<Integer> doConvernCoupon(@RequestBody CouponRecordVO vo){
        return convertCouponService.doConvernCoupon(vo);
    }
    //查询已兑换
    @RequestMapping("/getConvernConpouByMember")
    public ResponseData<PageInfo<MktConvertCouponRecordPO>> getConvernConpouByMember(@RequestBody CouponRecordVO vo){
        return convertCouponService.getConvernConpouByMember(vo);
    }
}
