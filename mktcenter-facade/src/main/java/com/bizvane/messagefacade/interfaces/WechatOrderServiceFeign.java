package com.bizvane.messagefacade.interfaces;

import com.bizvane.messagefacade.models.vo.MemberMessageVO;
import com.bizvane.messagefacade.models.vo.OrderMessageVO;
import com.bizvane.utils.responseinfo.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 订单相关模板消息
 * @author 董争光
 * 2018年7月25日下午1:54:03
 */
@FeignClient(value="${feign.client.mktcenter.name}",path="${feign.client.mktcenter.path}/wechatOrder")
@Api(value = "订单相关模板消息",tags = {"订单相关模板消息"})
public interface WechatOrderServiceFeign {

  /**
   * 线下订单提醒
   * @param vo
   * @return
   */
  @ApiOperation(value = "线下订单提醒")
  @RequestMapping(value = "/orderOfflineConsume", method = RequestMethod.POST)
  ResponseData<String> orderOfflineConsume(@RequestBody(required = false) OrderMessageVO vo);

  /**
   * 线上订单提醒
   * @param vo
   * @return
   */
  @ApiOperation(value = "线上订单提醒")
  @RequestMapping(value = "/orderOnlineConsume", method = RequestMethod.POST)
  ResponseData<String> orderOnlineConsume(@RequestBody(required = false) MemberMessageVO vo);
  
  /**
   * 订单支付提醒
   * @param vo
   * @return
   */
  @ApiOperation(value = "订单支付提醒")
  @RequestMapping(value = "/orderPayment", method = RequestMethod.POST)
  ResponseData<String> orderPayment(@RequestBody(required = false) MemberMessageVO vo);
  
  /**
   * 订单发货提醒
   * @param vo
   * @return
   */
  @ApiOperation(value = "订单发货提醒")
  @RequestMapping(value = "/orderShip", method = RequestMethod.POST)
  ResponseData<String> orderShip(@RequestBody(required = false) OrderMessageVO vo);
  
  /**
   * 订单签收提醒
   * @param vo
   * @return
   */
  @ApiOperation(value = "订单签收提醒")
  @RequestMapping(value = "/orderSign", method = RequestMethod.POST)
  ResponseData<String> orderSign(@RequestBody(required = false) MemberMessageVO vo);

  /**
   * 订单取消提醒
   * @param vo
   * @return
   */
  @ApiOperation(value = "订单取消提醒")
  @RequestMapping(value = "/orderCancel", method = RequestMethod.POST)
  ResponseData<String> orderCancel(@RequestBody(required = false) MemberMessageVO vo);
  
  /**
   * 订单评价提醒
   * @param vo
   * @return
   */
  @ApiOperation(value = "订单评价提醒")
  @RequestMapping(value = "/orderAppraisal", method = RequestMethod.POST)
  ResponseData<String> orderAppraisal(@RequestBody(required = false) MemberMessageVO vo);
}
