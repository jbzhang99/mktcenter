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
 * 券相关模板消息
 * @author 董争光
 * 2018年7月25日下午1:53:02
 */
@FeignClient(value="${feign.client.mktcenter.name}",path="${feign.client.mktcenter.path}/wechatCoupon")
@Api(value = "券相关模板消息",tags = {"API"})
public interface WechatCouponServiceFeign {

  /**
   * 券到账提醒
   * @param vo
   * @return
   */
  @ApiOperation(value = "券到账提醒")
  @RequestMapping(value = "/couponReceive", method = RequestMethod.POST)
  ResponseData<String> couponReceive(@RequestBody CouponMessageVO vo);

  /**
   * 券未领取提醒
   * @param vo
   * @return
   */
  @ApiOperation(value = "券未领取提醒")
  @RequestMapping(value = "/couponUnreceived", method = RequestMethod.POST)
  @ResponseBody
  ResponseData<String> couponUnreceived(@RequestBody CouponMessageVO vo);
  
  /**
   * 券到期提醒
   * @param vo
   * @return
   */
  @ApiOperation(value = "券到期提醒")
  @RequestMapping(value = "/couponExpire", method = RequestMethod.POST)
  @ResponseBody
  ResponseData<String> couponExpire(@RequestBody CouponMessageVO vo);
  
  /**
   * 券使用提醒
   * @param vo
   * @return
   */
  @ApiOperation(value = "券使用")
  @RequestMapping(value = "/couponUse", method = RequestMethod.POST)
  ResponseData<String> couponUse(@RequestBody CouponMessageVO vo);

  /**
   * 券线上使用提醒
   * @param vo
   * @return
   */
  @ApiOperation(value = "券线上使用")
  @RequestMapping(value = "/onlineUse", method = RequestMethod.POST)
  ResponseData<String> onlineUse(@RequestBody CouponMessageVO vo);

  /**
   * 券线下使用提醒
   * @param vo
   * @return
   */
  @ApiOperation(value = "券线下使用")
  @RequestMapping(value = "/offlineUse", method = RequestMethod.POST)
  ResponseData<String> offlineUse(@RequestBody CouponMessageVO vo);
}
