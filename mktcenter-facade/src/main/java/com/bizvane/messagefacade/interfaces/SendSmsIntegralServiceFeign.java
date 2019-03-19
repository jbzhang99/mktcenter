package com.bizvane.messagefacade.interfaces;

import com.bizvane.messagefacade.models.vo.CouponMessageVO;
import com.bizvane.messagefacade.models.vo.IntegralMessageVO;
import com.bizvane.utils.responseinfo.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @积分短信模板消息发送
 * 
 * @author 张迪
 * 
 * @date  2018/08/09
 */
@FeignClient(value="${feign.client.mktcenter.name}",path="${feign.client.mktcenter.path}/SendSmsIntegral")
@RequestMapping("${feign.client.mktcenter.path}/SendSmsIntegral")
@Api(value = "积分短信模板消息",tags = {"API"})
public interface SendSmsIntegralServiceFeign {

	 /**
	   * 积分增加提醒
	   * @param vo
	   * @return
	   */
	  @ApiOperation(value = "积分增加提醒")
	  @RequestMapping(value = "/sendSmsIntegralAdd", method = RequestMethod.POST)
	  @ResponseBody
	  ResponseData<String> sendSmsintegralAdd(@RequestBody IntegralMessageVO vo);

	  /**
	   * 积分减少提醒
	   * @param vo
	   * @return ResponseData<String>
	   */
	  @ApiOperation(value = "积分减少提醒")
	  @RequestMapping(value = "/sendSmsIntegralSubtract", method = RequestMethod.POST)
	  @ResponseBody
	  ResponseData<String> sendSmsIntegralSubtract(@RequestBody IntegralMessageVO vo);

	  /**
	   * 积分到期提醒
	   * @param vo
	   * @return
	   */
	  @ApiOperation(value = "积分到期提醒")
	  @RequestMapping(value = "/sendSmsIntegralExpire", method = RequestMethod.POST)
	  @ResponseBody
	  ResponseData<String> sendSmsIntegralExpire(@RequestBody IntegralMessageVO vo);
	  
	  /**
	   * 积分使用提醒
	   * @param vo
	   * @return
	   */
	  @ApiOperation(value = "积分使用提醒")
	  @RequestMapping(value = "/sendSmsIntegralUse", method = RequestMethod.POST)
	  @ResponseBody
	  ResponseData<String> sendSmsIntegralUse(@RequestBody IntegralMessageVO vo);


	  /**
	   * @优惠券短信 （支持批量）
	   * @param vo
	   * @return ResponseData<String>
	   */
	  @ApiOperation(value = "积分短信批量发送")
	  @RequestMapping(value = "/sendBatchIntegralReceived", method = RequestMethod.POST)
	  @ResponseBody
	  ResponseData<String> sendBatchIntegralReceived(@RequestBody CouponMessageVO vo);
  
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
