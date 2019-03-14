package com.bizvane.messagefacade.interfaces;

import com.bizvane.messagefacade.models.vo.CouponMessageVO;
import com.bizvane.utils.responseinfo.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @优惠券短信模板消息发送
 * 
 * @author 张迪
 * 
 * @date  2018/08/09
 */
@FeignClient(value="${feign.client.message.name}",path="${feign.client.message.path}/SendSmsCoupon")
@Api(value = "优惠券短信模板消息",tags = {"API"})
public interface SendSmsCouponServiceFeign {

  /**
   * @优惠券到账提醒
   * 
   * @param vo
   * 
   * @return ResponseData<String>
   */
  @ApiOperation(value = "券到账提醒")
  @RequestMapping(value = "/sendCouponReceive", method = RequestMethod.POST)
  ResponseData<String> sendCouponReceive(@RequestBody CouponMessageVO vo);
  
  
  /**
   * @优惠券未领取提醒
   * 
   * @param vo
   * 
   * @return ResponseData<String>
   */
  @ApiOperation(value = "券未领取提醒")
  @RequestMapping(value = "/sendCouponUnreceived", method = RequestMethod.POST)
  ResponseData<String> sendCouponUnreceived(@RequestBody CouponMessageVO vo);
  
  
  
  /**
   * @优惠券到期提醒
   * 
   * @param vo
   * 
   * @return ResponseData<String>
   */
  @ApiOperation(value = "券到期提醒")
  @RequestMapping(value = "/sendCouponExpire", method = RequestMethod.POST)
  ResponseData<String> sendCouponExpire(@RequestBody CouponMessageVO vo);
  
  
  /**
   * @优惠券线上使用提醒
   * 
   * @param vo
   * 
   * @return ResponseData<String>
   */
  @ApiOperation(value = "券线上使用")
  @RequestMapping(value = "/sendCoupononlineUse", method = RequestMethod.POST)
  ResponseData<String> sendCoupononlineUse(@RequestBody CouponMessageVO vo);
  
  
  
  /**
   * @优惠券线下使用提醒
   * 
   * @param vo
   * 
   * @return ResponseData<String>
   */
  @ApiOperation(value = "券线下使用")
  @RequestMapping(value = "/sendCouponofflineUse", method = RequestMethod.POST)
  ResponseData<String> sendCouponofflineUse(@RequestBody CouponMessageVO vo);

  /**
   * @优惠券短信 （支持批量）
   * @param vo
   * @return ResponseData<String>
   */
  @ApiOperation(value = "优惠券短信批量")
  @RequestMapping(value = "/sendBatchCouponreceived", method = RequestMethod.POST)
  @ResponseBody
  ResponseData<String> sendBatchCouponreceived(@RequestBody CouponMessageVO vo);
  
//  /**
//   * 券到期提醒
//   * @param vo
//   * @return
//   */
//  @ApiOperation(value = "券到期提醒")
//  @RequestMapping(value = "/couponExpire", method = RequestMethod.POST)
//  @ResponseBody
//  ResponseData<String> couponExpire(@RequestBody CouponMessageVO vo);
//
//  /**
//   * 券线上使用提醒
//   * @param vo
//   * @return
//   */
//  @ApiOperation(value = "券线上使用")
//  @RequestMapping(value = "/onlineUse", method = RequestMethod.POST)
//  ResponseData<String> onlineUse(@RequestBody CouponMessageVO vo);
//
//  /**
//   * 券线下使用提醒
//   * @param vo
//   * @return
//   */
//  @ApiOperation(value = "券线下使用")
//  @RequestMapping(value = "/offlineUse", method = RequestMethod.POST)
//  ResponseData<String> offlineUse(@RequestBody CouponMessageVO vo);
}
