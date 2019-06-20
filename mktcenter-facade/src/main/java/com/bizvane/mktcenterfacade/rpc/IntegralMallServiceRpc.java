package com.bizvane.mktcenterfacade.rpc;

import com.bizvane.centercontrolservice.models.bo.AppletFunctionBO;
import com.bizvane.mktcenterfacade.models.bo.CouponIntegralExchangeBO;
import com.bizvane.mktcenterfacade.models.po.MktConvertCouponRecordPO;
import com.bizvane.mktcenterfacade.models.vo.CouponIntegralExchangeVO;
import com.bizvane.mktcenterfacade.models.vo.CouponRecordVO;
import com.bizvane.utils.responseinfo.ResponseData;
import com.github.pagehelper.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Geng on 2018/8/9.
 *  积分兑换券
 */

@FeignClient(value = "${feign.client.mktcenter.name}",path = "${feign.client.mktcenter.path}/integralMallServiceRpc")
public interface IntegralMallServiceRpc {

    //查询对换列表
    @RequestMapping("/getConvernCouponLists")
    public ResponseData<CouponIntegralExchangeBO> getConvernCouponLists(@RequestBody CouponRecordVO vo);
   //券详情和单价
    @RequestMapping("/getCouponAndPrice")
    public ResponseData<CouponIntegralExchangeVO> getCouponAndPrice(@RequestBody CouponRecordVO vo);
    //兑换
    @RequestMapping("/doConvernCoupon")
    public ResponseData<Integer> doConvernCoupon(@RequestBody CouponRecordVO vo);
    //查询已兑换
    @RequestMapping("/getConvernConpouByMember")
    public ResponseData<PageInfo<MktConvertCouponRecordPO>> getConvernConpouByMember(@RequestBody CouponRecordVO vo);
}
