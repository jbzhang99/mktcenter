package com.bizvane.messageservice.controller;


/**
 * @积分短信发送 移动到WechatIntegralController
 * 
 * @author 张迪
 * 
 * @date 2018/08/13
 */
//@RestController
//@RequestMapping("/SendSmsIntegral")
//public class SendSmsIntegralController {
//
//  @Autowired
//  private RocketMQWechatService rocketMQWechatService;
//
//  /**
//   * @积分短信发送，添加rocketmq消息(积分增加)
//   * 
//   * @param vo
//   * 
//   * @return Result<String>
//   */
//  @RequestMapping(value = "/sendSmsIntegralAdd", method = RequestMethod.POST)
//  public Result<String> sendSmsIntegralAdd(@RequestBody IntegralMessageVO vo) {

//    JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(vo));
//
//    jsonObject.put("rocketMQTopic", SystemSendSmsConstants.ROCKET_TOPIC_SIMPLE_MESSAGE);
//    jsonObject.put("rocketMQTag", TemplateMessageTypeConstant.INTEGRAL_ADD);
//    jsonObject.put("bussinessModuleCode", TemplateMessageTypeConstant.INTEGRAL_ADD);
//    jsonObject.put("bussinessType",SystemSendSmsConstants.ROCKET_CONFIG_BUSINESS_TYPE_SEDNSMS_INTEGRAL_ADD_MESSAGE);
//    jsonObject.put("rocketMQBussinessId", vo.getMemberCode());
//    return this.rocketMQWechatService.sendMessage(jsonObject.toJSONString());
//
//  }
//  
//  
//  /**
//   * @积分短信发送，添加rocketmq消息(积分减少)
//   * 
//   * @param vo
//   * 
//   * @return Result<String>
//   */
//  @RequestMapping(value = "/sendSmsIntegralSubtract", method = RequestMethod.POST)
//  public Result<String> sendSmsIntegralSubtract(@RequestBody IntegralMessageVO vo) {
//
//    JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(vo));
//
//    jsonObject.put("rocketMQTopic", SystemSendSmsConstants.ROCKET_TOPIC_SIMPLE_MESSAGE);
//    jsonObject.put("rocketMQTag", TemplateMessageTypeConstant.INTEGRAL_SUBTRACT);
//    jsonObject.put("bussinessModuleCode", TemplateMessageTypeConstant.INTEGRAL_SUBTRACT);
//    jsonObject.put("bussinessType",SystemSendSmsConstants.ROCKET_CONFIG_BUSINESS_TYPE_SEDNSMS_INTEGRAL_SUBTRACT_MESSAGE);
//    jsonObject.put("rocketMQBussinessId", vo.getMemberCode());
//    return this.rocketMQWechatService.sendMessage(jsonObject.toJSONString());
//
//  }
//  
//  
//  
//  /**
//   * @积分短信发送，添加rocketmq消息(积分到期)
//   * 
//   * @param vo
//   * 
//   * @return Result<String>
//   */
//  @RequestMapping(value = "/sendSmsIntegralExpire", method = RequestMethod.POST)
//  public Result<String> sendSmsIntegralExpire(@RequestBody IntegralMessageVO vo) {
//
//    JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(vo));
//
//    jsonObject.put("rocketMQTopic", SystemSendSmsConstants.ROCKET_TOPIC_SIMPLE_MESSAGE);
//    jsonObject.put("rocketMQTag", TemplateSendSmsMessageTypeConstant.INTEGRAL_EXPIRE);
//    jsonObject.put("bussinessModuleCode", TemplateSendSmsMessageTypeConstant.INTEGRAL_EXPIRE);
//    jsonObject.put("bussinessType",SystemSendSmsConstants.ROCKET_CONFIG_BUSINESS_TYPE_SEDNSMS_INTEGRAL_EXPIRE_MESSAGE);
//    jsonObject.put("rocketMQBussinessId", vo.getMemberCode());
//    return this.rocketMQWechatService.sendMessage(jsonObject.toJSONString());
//
//  }
//  
//  
//  /**
//   * @积分短信发送，添加rocketmq消息(积分使用)
//   * 
//   * @param vo
//   * 
//   * @return Result<String>
//   */
//  @RequestMapping(value = "/sendSmsIntegralUse", method = RequestMethod.POST)
//  public Result<String> sendSmsIntegralUse(@RequestBody IntegralMessageVO vo) {
//
//    JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(vo));
//
//    jsonObject.put("rocketMQTopic", SystemSendSmsConstants.ROCKET_TOPIC_SIMPLE_MESSAGE);
//    jsonObject.put("rocketMQTag", TemplateSendSmsMessageTypeConstant.INTEGRAL_USE);
//    jsonObject.put("bussinessModuleCode", TemplateSendSmsMessageTypeConstant.INTEGRAL_USE);
//    jsonObject.put("bussinessType",SystemSendSmsConstants.ROCKET_CONFIG_BUSINESS_TYPE_SEDNSMS_INTEGRAL_USE_MESSAGE);
//    jsonObject.put("rocketMQBussinessId", vo.getMemberCode());
//    return this.rocketMQWechatService.sendMessage(jsonObject.toJSONString());
//
//  }
//  
//  
//  
//  /**
//   * @积分短信批量发送，添加rocketmq消息(批量短信接口)
//   * 
//   * @param vo
//   * 
//   * @return Result<String>
//   */
//  @RequestMapping(value = "/sendSmsIntegralBatchAdd", method = RequestMethod.POST)
//  public Result<String> sendSmsIntegralBatchAdd(@RequestBody CouponMessageVO vo) {
//
//    JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(vo));
//
//    jsonObject.put("rocketMQTopic", SystemSendSmsConstants.ROCKET_TOPIC_SIMPLE_MESSAGE);
//    jsonObject.put("rocketMQTag", TemplateSendSmsMessageTypeConstant.INTEGRAL_ADD);
//    jsonObject.put("bussinessModuleCode", TemplateSendSmsMessageTypeConstant.INTEGRAL_ADD);
//    jsonObject.put("bussinessType",SystemSendSmsConstants.ROCKET_CONFIG_BUSINESS_TYPE_SEDNSMS_INTEGRAL_ADDBATCH_MESSAGE);
//    jsonObject.put("rocketMQBussinessId", vo.getCouponCode());
//    return this.rocketMQWechatService.sendMessage(jsonObject.toJSONString());
//
//  }

//  
//  /**
//   * 券到期提醒
//   * @param vo
//   * @return
//   */
//  @RequestMapping(value = "/couponExpire", method = RequestMethod.POST)
//  public Result<String> couponExpire(@RequestBody CouponMessageVO vo) {
//    JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(vo));
//
//    jsonObject.put("rocketMQTopic", SystemConstants.ROCKET_TOPIC_SIMPLE_MESSAGE);
//    jsonObject.put("rocketMQTag", TemplateMessageTypeConstant.COUPON_EXPIRE);
//    jsonObject.put("bussinessModuleCode", TemplateMessageTypeConstant.COUPON_EXPIRE);
//    jsonObject.put("bussinessType",SystemConstants.ROCKET_CONFIG_BUSINESS_TYPE_WECHAT_COUPON_EXPIRE_MESSAGE);
//    jsonObject.put("rocketMQBussinessId", vo.getCouponCode());
//    return this.rocketMQWechatService.sendMessage(jsonObject.toJSONString());
//  }
//
//  /**
//   * 券线上使用
//   * @param vo
//   * @return
//   */
//  @RequestMapping(value = "/onlineUse", method = RequestMethod.POST)
//  public Result<String> onlineUse(@RequestBody CouponMessageVO vo) {
//    JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(vo));
//
//    jsonObject.put("rocketMQTopic", SystemConstants.ROCKET_TOPIC_SIMPLE_MESSAGE);
//    jsonObject.put("rocketMQTag", TemplateMessageTypeConstant.COUPON_ONLINE_USE);
//    jsonObject.put("bussinessModuleCode", TemplateMessageTypeConstant.COUPON_ONLINE_USE);
//    jsonObject.put("bussinessType",SystemConstants.ROCKET_CONFIG_BUSINESS_TYPE_WECHAT_COUPON_ONLINE_MESSAGE);
//    jsonObject.put("rocketMQBussinessId", vo.getCouponCode());
//    return this.rocketMQWechatService.sendMessage(jsonObject.toJSONString());
//
//  }
//
//
//  /**
//   * 券线下使用
//   * @param vo
//   * @return
//   */
//  @RequestMapping(value = "/offlineUse", method = RequestMethod.POST)
//  public Result<String> offlineUse(@RequestBody CouponMessageVO vo) {
//    JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(vo));
//
//    jsonObject.put("rocketMQTopic", SystemConstants.ROCKET_TOPIC_SIMPLE_MESSAGE);
//    jsonObject.put("rocketMQTag", TemplateMessageTypeConstant.COUPON_OFFLINE_USE);
//    jsonObject.put("bussinessModuleCode", TemplateMessageTypeConstant.COUPON_OFFLINE_USE);
//    jsonObject.put("bussinessType",SystemConstants.ROCKET_CONFIG_BUSINESS_TYPE_WECHAT_COUPON_OFFLINE_MESSAGE);
//    jsonObject.put("rocketMQBussinessId", vo.getCouponCode());
//    return this.rocketMQWechatService.sendMessage(jsonObject.toJSONString());
//
//  }
	  
//}
