package com.bizvane.messageservice.controller;




import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @优惠券短信发送 添加rocketmq消息 
 * 
 * @author 张迪
 * 
 * @date 2018/08/09
 */
@RestController
@RequestMapping("/sendSmsCoupon")
public class SendSmsCouponController {
//	券短信消费放到WechatCouponController这个黎
	
//  @Autowired
//  private RocketMQWechatService rocketMQWechatService;

//  /**
//   * @优惠券－入账－短信提醒，
//   * 
//   * @param vo
//   * 
//   * @return Result<String>
//   */
//  @RequestMapping(value = "/sendCouponReceive", method = RequestMethod.POST)
//  public Result<String> sendCouponReceive(@RequestBody CouponMessageVO vo) {
//
//    JSONObject jsonObjectsms = JSONObject.parseObject(JSONObject.toJSONString(vo));
//
//    jsonObjectsms.put("rocketMQTopic", SystemConstants.ROCKET_TOPIC_SIMPLE_MESSAGE);
//    jsonObjectsms.put("rocketMQTag", TemplateMessageTypeConstant.SMS_COUPON_RECEIVE);
//    jsonObjectsms.put("bussinessModuleCode", TemplateMessageTypeConstant.SMS_COUPON_RECEIVE);
//    jsonObjectsms.put("bussinessType",SystemConstants.ROCKET_CONFIG_BUSINESS_TYPE_SEDNSMS_COUPON_RECEIVE_MESSAGE);
//    jsonObjectsms.put("rocketMQBussinessId", vo.getCouponCode());
//    return this.rocketMQWechatService.sendMessage(jsonObjectsms.toJSONString());
//
//  }
//  
//  
//  /**
//   * @优惠券－到期－短信提醒，
//   * 
//   * @param vo
//   * 
//   * @return Result<String>
//   */
//  @RequestMapping(value = "/sendCouponExpire", method = RequestMethod.POST)
//  public Result<String> sendCouponExpire(@RequestBody CouponMessageVO vo) {
//
//    JSONObject jsonObjectsms = JSONObject.parseObject(JSONObject.toJSONString(vo));
//
//    jsonObjectsms.put("rocketMQTopic", SystemConstants.ROCKET_TOPIC_SIMPLE_MESSAGE);
//    jsonObjectsms.put("rocketMQTag", TemplateMessageTypeConstant.SMS_COUPON_EXPIRE);
//    jsonObjectsms.put("bussinessModuleCode", TemplateMessageTypeConstant.SMS_COUPON_EXPIRE);
//    jsonObjectsms.put("bussinessType",SystemConstants.ROCKET_CONFIG_BUSINESS_TYPE_SEDNSMS_COUPON_EXPIRE_MESSAGE);
//    jsonObjectsms.put("rocketMQBussinessId", vo.getCouponCode());
//    return this.rocketMQWechatService.sendMessage(jsonObjectsms.toJSONString());
//
//  }
//  
//  
//  /**
//   * @优惠券－使用－短信提醒，COUPON_USE券使用提醒
//   * 
//   * @param vo
//   * 
//   * @return Result<String>
//   */
//  @RequestMapping(value = "/sendCouponUse", method = RequestMethod.POST)
//  public Result<String> sendCouponUse(@RequestBody CouponMessageVO vo) {
//
//    JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(vo));
//
//    jsonObject.put("rocketMQTopic", SystemConstants.ROCKET_TOPIC_SIMPLE_MESSAGE);
//    jsonObject.put("rocketMQTag", TemplateMessageTypeConstant.SMS_COUPON_USE);
//    jsonObject.put("bussinessModuleCode", TemplateMessageTypeConstant.SMS_COUPON_USE);
//    jsonObject.put("bussinessType",SystemConstants.ROCKET_CONFIG_BUSINESS_TYPE_SEDNSMS_COUPON_ONLINE_MESSAGE);
//    jsonObject.put("rocketMQBussinessId", vo.getCouponCode());
//    return this.rocketMQWechatService.sendMessage(jsonObject.toJSONString());
//
//  }
//  
  
//  
//  
//  
//  
//  /**
//   * @优惠券未领取短信发送，添加rocketmq消息
//   * 
//   * @param vo
//   * 
//   * @return Result<String>
//   */
//  @RequestMapping(value = "/sendCouponUnreceived", method = RequestMethod.POST)
//  public Result<String> sendCouponUnreceived(@RequestBody CouponMessageVO vo) {
//
//    JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(vo));
//
//    jsonObject.put("rocketMQTopic", SystemSendSmsConstants.ROCKET_TOPIC_SIMPLE_MESSAGE);
//    jsonObject.put("rocketMQTag", TemplateSendSmsMessageTypeConstant.COUPON_UNRECEIVED);
//    jsonObject.put("bussinessModuleCode", TemplateSendSmsMessageTypeConstant.COUPON_UNRECEIVED);
//    jsonObject.put("bussinessType",SystemSendSmsConstants.ROCKET_CONFIG_BUSINESS_TYPE_SEDNSMS_COUPON_UNRECEIVE_MESSAGE);
//    jsonObject.put("rocketMQBussinessId", vo.getCouponCode());
//    return this.rocketMQWechatService.sendMessage(jsonObject.toJSONString());
//
//  }
//  
  

  
  
//  
//  /**
//   * @优惠券线上短信发送，添加rocketmq消息
//   * 
//   * @param vo
//   * 
//   * @return Result<String>
//   */
//  @RequestMapping(value = "/sendCoupononlineUse", method = RequestMethod.POST)
//  public Result<String> sendCoupononlineUse(@RequestBody CouponMessageVO vo) {
//
//    JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(vo));
//
//    jsonObject.put("rocketMQTopic", SystemSendSmsConstants.ROCKET_TOPIC_SIMPLE_MESSAGE);
//    jsonObject.put("rocketMQTag", TemplateSendSmsMessageTypeConstant.COUPON_ONLINE_USE);
//    jsonObject.put("bussinessModuleCode", TemplateSendSmsMessageTypeConstant.COUPON_ONLINE_USE);
//    jsonObject.put("bussinessType",SystemSendSmsConstants.ROCKET_CONFIG_BUSINESS_TYPE_SEDNSMS_COUPON_ONLINE_MESSAGE);
//    jsonObject.put("rocketMQBussinessId", vo.getCouponCode());
//    return this.rocketMQWechatService.sendMessage(jsonObject.toJSONString());
//
//  }
//  
//  
//  
//  /**
//   * @优惠券线下短信发送，添加rocketmq消息
//   * 
//   * @param vo
//   * 
//   * @return Result<String>
//   */
//  @RequestMapping(value = "/sendCouponofflineUse", method = RequestMethod.POST)
//  public Result<String> sendCouponofflineUse(@RequestBody CouponMessageVO vo) {
//
//    JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(vo));
//
//    jsonObject.put("rocketMQTopic", SystemSendSmsConstants.ROCKET_TOPIC_SIMPLE_MESSAGE);
//    jsonObject.put("rocketMQTag", TemplateSendSmsMessageTypeConstant.COUPON_OFFLINE_USE);
//    jsonObject.put("bussinessModuleCode", TemplateSendSmsMessageTypeConstant.COUPON_OFFLINE_USE);
//    jsonObject.put("bussinessType",SystemSendSmsConstants.ROCKET_CONFIG_BUSINESS_TYPE_SEDNSMS_COUPON_OFFLINE_MESSAGE);
//    jsonObject.put("rocketMQBussinessId", vo.getCouponCode());
//    return this.rocketMQWechatService.sendMessage(jsonObject.toJSONString());
//
//  }
//  
//  
//  
//  /**
//   * @优惠券短信批量发送，添加rocketmq消息
//   * 
//   * @param vo
//   * 
//   * @return Result<String>
//   */
//  @RequestMapping(value = "/sendBatchCouponreceived", method = RequestMethod.POST)
//  public Result<String> sendBatchCouponreceived(@RequestBody CouponMessageVO vo) {
//
//    JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(vo));
//
//    jsonObject.put("rocketMQTopic", SystemSendSmsConstants.ROCKET_TOPIC_SIMPLE_MESSAGE);
//    jsonObject.put("rocketMQTag", TemplateSendSmsMessageTypeConstant.COUPON_RECEIVE);
//    jsonObject.put("bussinessModuleCode", TemplateSendSmsMessageTypeConstant.COUPON_RECEIVE);
//    jsonObject.put("bussinessType",SystemSendSmsConstants.ROCKET_CONFIG_BUSINESS_TYPE_SEDNSMS_COUPON_RECEIVE_MESSAGE);
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
}
