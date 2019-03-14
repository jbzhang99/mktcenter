package com.bizvane.messagefacade.interfaces;

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
 * 积分相关模板消息
 * @author 董争光
 * 2018年7月25日下午1:53:21
 */
@FeignClient(value="${feign.client.message.name}",path="${feign.client.message.path}/wechatIntegral")
@Api(value = "积分相关模板消息",tags = {"积分相关模板消息"})
public interface WechatIntegralServiceFeign {

  /**
   * 积分增加提醒
   * @param vo
   * @return
   */
  @ApiOperation(value = "积分增加提醒")
  @RequestMapping(value = "/integralAdd", method = RequestMethod.POST)
  @ResponseBody
  ResponseData<String> integralAdd(@RequestBody IntegralMessageVO vo);

  /**
   * 积分减少提醒
   * @param vo
   * @return
   */
  @ApiOperation(value = "积分减少提醒")
  @RequestMapping(value = "/integralSubtract", method = RequestMethod.POST)
  @ResponseBody
  ResponseData<String> integralSubtract(@RequestBody IntegralMessageVO vo);

  /**
   * 积分到期提醒
   * @param vo
   * @return
   */
  @ApiOperation(value = "积分到期提醒")
  @RequestMapping(value = "/integralExpire", method = RequestMethod.POST)
  @ResponseBody
  ResponseData<String> integralExpire(@RequestBody IntegralMessageVO vo);
  
  /**
   * 积分使用提醒
   * @param vo
   * @return
   */
  @ApiOperation(value = "积分使用提醒")
  @RequestMapping(value = "/integralUse", method = RequestMethod.POST)
  @ResponseBody
  ResponseData<String> integralUse(@RequestBody IntegralMessageVO vo);
  

}
