package com.bizvane.messageservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.bizvane.messageservice.common.constants.SystemConstants;
import com.bizvane.messageservice.common.constants.TemplateMessageTypeConstant;
import com.bizvane.messageservice.service.RocketMQSendMessageSmsService;
import com.bizvane.messageservice.service.RocketMQWechatService;
import com.bizvane.messagefacade.models.vo.CouponMessageVO;
import com.bizvane.messagefacade.models.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 券相关模板消息
 * @author 董争光
 * 2018年7月25日下午1:53:02
 */
@RestController
@RequestMapping("/wechatCoupon")
public class WechatCouponController {

  @Autowired
  private RocketMQWechatService rocketMQWechatService;
  
  @Autowired
  private RocketMQSendMessageSmsService rocketMQSendMessageSmsService;

  /**
   * 券入账提醒
   * @param vo
   * @return
   */
  @RequestMapping(value = "/couponReceive", method = RequestMethod.POST)
  public Result<String> couponReceive(@RequestBody CouponMessageVO vo) {

    JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(vo));

    jsonObject.put("rocketMQTopic", SystemConstants.ROCKET_TOPIC_SIMPLE_MESSAGE);
    jsonObject.put("rocketMQTag", TemplateMessageTypeConstant.COUPON_RECEIVE);
    jsonObject.put("bussinessModuleCode", TemplateMessageTypeConstant.COUPON_RECEIVE);
    jsonObject.put("bussinessType",SystemConstants.ROCKET_CONFIG_BUSINESS_TYPE_WECHAT_COUPON_RECEIVE_MESSAGE);
    jsonObject.put("rocketMQBussinessId", vo.getCouponCode());
    rocketMQWechatService.sendMessage(jsonObject.toJSONString());
    
    
    JSONObject jsonObjectsms = JSONObject.parseObject(JSONObject.toJSONString(vo));

    jsonObjectsms.put("rocketMQTopic", SystemConstants.ROCKET_TOPIC_SIMPLE_MESSAGE);
    jsonObjectsms.put("rocketMQTag", TemplateMessageTypeConstant.SMS_COUPON_RECEIVE);
    jsonObjectsms.put("bussinessModuleCode", TemplateMessageTypeConstant.SMS_COUPON_RECEIVE);
    jsonObjectsms.put("bussinessType",SystemConstants.ROCKET_CONFIG_BUSINESS_TYPE_SEDNSMS_COUPON_RECEIVE_MESSAGE);
    jsonObjectsms.put("rocketMQBussinessId", vo.getCouponCode());
    return this.rocketMQSendMessageSmsService.sendMessage(jsonObjectsms.toJSONString());

  }


  
  /**
   * 券到期提醒
   * @param vo
   * @return
   */
  @RequestMapping(value = "/couponExpire", method = RequestMethod.POST)
  public Result<String> couponExpire(@RequestBody CouponMessageVO vo) {
    JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(vo));

    jsonObject.put("rocketMQTopic", SystemConstants.ROCKET_TOPIC_SIMPLE_MESSAGE);
    jsonObject.put("rocketMQTag", TemplateMessageTypeConstant.COUPON_EXPIRE);
    jsonObject.put("bussinessModuleCode", TemplateMessageTypeConstant.COUPON_EXPIRE);
    jsonObject.put("bussinessType",SystemConstants.ROCKET_CONFIG_BUSINESS_TYPE_WECHAT_COUPON_EXPIRE_MESSAGE);
    jsonObject.put("rocketMQBussinessId", vo.getCouponCode());
    rocketMQWechatService.sendMessage(jsonObject.toJSONString());
    
    JSONObject jsonObjectsms = JSONObject.parseObject(JSONObject.toJSONString(vo));
    jsonObjectsms.put("rocketMQTopic", SystemConstants.ROCKET_TOPIC_SIMPLE_MESSAGE);
    jsonObjectsms.put("rocketMQTag", TemplateMessageTypeConstant.SMS_COUPON_EXPIRE);
    jsonObjectsms.put("bussinessModuleCode", TemplateMessageTypeConstant.SMS_COUPON_EXPIRE);
    jsonObjectsms.put("bussinessType",SystemConstants.ROCKET_CONFIG_BUSINESS_TYPE_SEDNSMS_COUPON_EXPIRE_MESSAGE);
    jsonObjectsms.put("rocketMQBussinessId", vo.getCouponCode());
    return this.rocketMQSendMessageSmsService.sendMessage(jsonObjectsms.toJSONString());
  }
  
  



  /**
   * 券使用
   * @param vo
   * @return
   */
  @RequestMapping(value = "/couponUse", method = RequestMethod.POST)
  public Result<String> couponUse(@RequestBody CouponMessageVO vo) {
    JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(vo));

    jsonObject.put("rocketMQTopic", SystemConstants.ROCKET_TOPIC_SIMPLE_MESSAGE);
    jsonObject.put("rocketMQTag", TemplateMessageTypeConstant.COUPON_USE);
    jsonObject.put("bussinessModuleCode", TemplateMessageTypeConstant.COUPON_USE);
    jsonObject.put("bussinessType",SystemConstants.ROCKET_CONFIG_BUSINESS_TYPE_WECHAT_COUPON_ONLINE_MESSAGE);
    jsonObject.put("rocketMQBussinessId", vo.getCouponCode());
    rocketMQWechatService.sendMessage(jsonObject.toJSONString());
    
    
    JSONObject jsonObjectsms = JSONObject.parseObject(JSONObject.toJSONString(vo));

    jsonObjectsms.put("rocketMQTopic", SystemConstants.ROCKET_TOPIC_SIMPLE_MESSAGE);
    jsonObjectsms.put("rocketMQTag", TemplateMessageTypeConstant.SMS_COUPON_USE);
    jsonObjectsms.put("bussinessModuleCode", TemplateMessageTypeConstant.SMS_COUPON_USE);
    jsonObjectsms.put("bussinessType",SystemConstants.ROCKET_CONFIG_BUSINESS_TYPE_SEDNSMS_COUPON_ONLINE_MESSAGE);
    jsonObjectsms.put("rocketMQBussinessId", vo.getCouponCode());
    
    return this.rocketMQSendMessageSmsService.sendMessage(jsonObjectsms.toJSONString());

  }
  
  



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
//  
//  
//  /**
//   * 券未领取提醒
//   * @param param
//   * @return
//   */
//  @RequestMapping(value = "/couponUnreceived", method = RequestMethod.POST)
//  public Result<String> couponUnreceived(@RequestBody Object param) {
//    return null;
//
//  }
}



