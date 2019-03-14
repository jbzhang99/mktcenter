package com.bizvane.messageservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.bizvane.messageservice.common.constants.SystemConstants;
import com.bizvane.messageservice.common.constants.TemplateMessageTypeConstant;
import com.bizvane.messageservice.service.RocketMQSendIntegralSmsService;
import com.bizvane.messageservice.service.RocketMQWechatService;
import com.bizvane.messagefacade.models.vo.IntegralMessageVO;
import com.bizvane.messagefacade.models.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 积分相关模板消息
 * @author 董争光
 * 2018年7月25日下午1:53:21
 */
@Controller
@RequestMapping("/wechatIntegral")
public class WechatIntegralController {

  @Autowired
  private RocketMQWechatService rocketMQWechatService;
  
  @Autowired
  private RocketMQSendIntegralSmsService rocketMQSendIntegralSmsService;

  /**
   * 积分积分入账
   * @param vo
   * @return
   */
  @RequestMapping(value = "/integralAdd", method = RequestMethod.POST)
  @ResponseBody
  public Result<String> integralAdd(@RequestBody IntegralMessageVO vo) {
    JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(vo));

    jsonObject.put("rocketMQTopic", SystemConstants.ROCKET_TOPIC_SIMPLE_MESSAGE);
    jsonObject.put("rocketMQTag", TemplateMessageTypeConstant.INTEGRAL_ADD);
    jsonObject.put("bussinessModuleCode", TemplateMessageTypeConstant.INTEGRAL_ADD);
    jsonObject.put("bussinessType",SystemConstants.ROCKET_CONFIG_BUSINESS_TYPE_WECHAT_INTEGRAL_ADD_MESSAGE);
    jsonObject.put("rocketMQBussinessId", vo.getMemberCode());
    rocketMQWechatService.sendMessage(jsonObject.toJSONString());
    
    JSONObject jsonObjectsms = JSONObject.parseObject(JSONObject.toJSONString(vo));

	  jsonObjectsms.put("rocketMQTopic", SystemConstants.ROCKET_TOPIC_SIMPLE_MESSAGE);
	  jsonObjectsms.put("rocketMQTag", TemplateMessageTypeConstant.SMS_INTEGRAL_ADD);
	  jsonObjectsms.put("bussinessModuleCode", TemplateMessageTypeConstant.SMS_INTEGRAL_ADD);
	  jsonObjectsms.put("bussinessType",SystemConstants.ROCKET_CONFIG_BUSINESS_TYPE_SEDNSMS_INTEGRAL_ADD_MESSAGE);
	  jsonObjectsms.put("rocketMQBussinessId", vo.getMemberCode());
	  return this.rocketMQSendIntegralSmsService.sendMessage(jsonObjectsms.toJSONString());

  }
  
  
  /**
   * 积分使用提醒
   * @param vo
   * @return
   */
  @RequestMapping(value = "/integralUse", method = RequestMethod.POST)
  @ResponseBody
  public Result<String> integralUse(@RequestBody IntegralMessageVO vo) {
    JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(vo));

    jsonObject.put("rocketMQTopic", SystemConstants.ROCKET_TOPIC_SIMPLE_MESSAGE);
    jsonObject.put("rocketMQTag", TemplateMessageTypeConstant.INTEGRAL_USE);
    jsonObject.put("bussinessModuleCode", TemplateMessageTypeConstant.INTEGRAL_USE);
    jsonObject.put("bussinessType",SystemConstants.ROCKET_CONFIG_BUSINESS_TYPE_WECHAT_INTEGRAL_USE_MESSAGE);
    jsonObject.put("rocketMQBussinessId", vo.getMemberCode());
    rocketMQWechatService.sendMessage(jsonObject.toJSONString());
    
    JSONObject jsonObjectsms = JSONObject.parseObject(JSONObject.toJSONString(vo));
    jsonObjectsms.put("rocketMQTopic", SystemConstants.ROCKET_TOPIC_SIMPLE_MESSAGE);
    jsonObjectsms.put("rocketMQTag", TemplateMessageTypeConstant.SMS_INTEGRAL_USE);
    jsonObjectsms.put("bussinessModuleCode", TemplateMessageTypeConstant.SMS_INTEGRAL_USE);
    jsonObjectsms.put("bussinessType",SystemConstants.ROCKET_CONFIG_BUSINESS_TYPE_SEDNSMS_INTEGRAL_USE_MESSAGE);
    jsonObjectsms.put("rocketMQBussinessId", vo.getMemberCode());
    return this.rocketMQSendIntegralSmsService.sendMessage(jsonObjectsms.toJSONString());

  }

  /**
   * 积分减少提醒
   * @param vo
   * @return
   */
  @RequestMapping(value = "/integralSubtract", method = RequestMethod.POST)
  @ResponseBody
  public Result<String> integralSubtract(@RequestBody IntegralMessageVO vo) {
    JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(vo));

    jsonObject.put("rocketMQTopic", SystemConstants.ROCKET_TOPIC_SIMPLE_MESSAGE);
    jsonObject.put("rocketMQTag", TemplateMessageTypeConstant.INTEGRAL_SUBTRACT);
    jsonObject.put("bussinessModuleCode", TemplateMessageTypeConstant.INTEGRAL_SUBTRACT);
    jsonObject.put("bussinessType",SystemConstants.ROCKET_CONFIG_BUSINESS_TYPE_WECHAT_INTEGRAL_SUBTRACT_MESSAGE);
    jsonObject.put("rocketMQBussinessId", vo.getChangeIntegral());
    return this.rocketMQWechatService.sendMessage(jsonObject.toJSONString());

  }
  
  /**
   * 积分到期提醒
   * @param vo
   * @return
   */
  @RequestMapping(value = "/integralExpire", method = RequestMethod.POST)
  @ResponseBody
  public Result<String> integralExpire(@RequestBody IntegralMessageVO vo) {
    JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(vo));

    jsonObject.put("rocketMQTopic", SystemConstants.ROCKET_TOPIC_SIMPLE_MESSAGE);
    jsonObject.put("rocketMQTag", TemplateMessageTypeConstant.INTEGRAL_EXPIRE);
    jsonObject.put("bussinessModuleCode", TemplateMessageTypeConstant.INTEGRAL_EXPIRE);
    jsonObject.put("bussinessType",SystemConstants.ROCKET_CONFIG_BUSINESS_TYPE_WECHAT_INTEGRAL_EXPIRE_MESSAGE);
    jsonObject.put("rocketMQBussinessId", vo.getChangeIntegral());
    return this.rocketMQWechatService.sendMessage(jsonObject.toJSONString());

  }
  



}
