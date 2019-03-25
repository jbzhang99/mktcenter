package com.bizvane.messageservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.bizvane.messageservice.common.constants.SystemConstants;
import com.bizvane.messageservice.common.constants.TemplateMessageTypeConstant;
import com.bizvane.messageservice.service.RocketMQSendOrderSmsService;
import com.bizvane.messageservice.service.RocketMQWechatService;
import com.bizvane.messagefacade.models.vo.OrderMessageVO;
import com.bizvane.messagefacade.models.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 订单相关模板消息
 * @author 董争光
 * 2018年7月25日下午1:54:03
 */
@Controller
@RequestMapping("/wechatOrder")
public class WechatOrderController {

  @Autowired
  private RocketMQWechatService rocketMQWechatService;
  @Autowired
  private RocketMQSendOrderSmsService rocketMQSendOrderSmsService;


  /**
   * 线下订单提醒
   * @param vo
   * @return
   */
  @RequestMapping(value = "/orderOfflineConsume", method = RequestMethod.POST)
  @ResponseBody
  public Result<String> orderOfflineConsume(@RequestBody(required = false) OrderMessageVO vo) {
    JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(vo));

    jsonObject.put("rocketMQTopic", SystemConstants.ROCKET_TOPIC_SIMPLE_MESSAGE);
    jsonObject.put("rocketMQTag", TemplateMessageTypeConstant.ORDER_OFFLINE_CONSUME);
    jsonObject.put("bussinessModuleCode", TemplateMessageTypeConstant.ORDER_OFFLINE_CONSUME);
    jsonObject.put("bussinessType",SystemConstants.ROCKET_CONFIG_BUSINESS_TYPE_WECHAT_ORDER_OFFLINE_MESSAGE);
    jsonObject.put("rocketMQBussinessId", vo.getOrderNo());
    this.rocketMQWechatService.sendMessage(jsonObject.toJSONString());
     

    
    
    JSONObject jsonObjectsms = JSONObject.parseObject(JSONObject.toJSONString(vo));

    jsonObjectsms.put("rocketMQTopic", SystemConstants.ROCKET_TOPIC_SIMPLE_MESSAGE);
    jsonObjectsms.put("rocketMQTag", TemplateMessageTypeConstant.SMS_ORDER_OFFLINE_CONSUME);
    jsonObjectsms.put("bussinessModuleCode", TemplateMessageTypeConstant.SMS_ORDER_OFFLINE_CONSUME);
    jsonObjectsms.put("bussinessType",SystemConstants.ROCKET_CONFIG_BUSINESS_TYPE_SMS_ORDER_OFFLINE_MESSAGE);
    jsonObjectsms.put("rocketMQBussinessId", vo.getOrderNo());

    return this.rocketMQSendOrderSmsService.sendMessage(jsonObjectsms.toJSONString());
  }

  /**
   * 线上订单提醒
   * @param param
   * @return
   */
  @RequestMapping(value = "/orderOnlineConsume", method = RequestMethod.POST)
  @ResponseBody
  public Result<String> orderOnlineConsume(@RequestBody(required = false) Object param) {
    return null;

  }
  
  /**
   * 订单支付提醒
   * @param vo
   * @return
   */
  @RequestMapping(value = "/orderPayment", method = RequestMethod.POST)
  @ResponseBody
  public Result<String> orderPayment(@RequestBody(required = false) OrderMessageVO vo) {
    if(null == vo){
      vo = new OrderMessageVO();
    }

    JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(vo));

    jsonObject.put("rocketMQTopic", SystemConstants.ROCKET_TOPIC_SIMPLE_MESSAGE);
    jsonObject.put("rocketMQTag", TemplateMessageTypeConstant.ORDER_PAYMENT);
    jsonObject.put("bussinessModuleCode", TemplateMessageTypeConstant.ORDER_PAYMENT);
    jsonObject.put("bussinessType",SystemConstants.ROCKET_CONFIG_BUSINESS_TYPE_WECHAT_ORDER_PAYMENT_MESSAGE);
    jsonObject.put("rocketMQBussinessId", vo.getOrderNo());
    return this.rocketMQWechatService.sendMessage(jsonObject.toJSONString());

  }
  
  /**
   * 订单发货提醒
   * @param vo
   * @return
   */
  @RequestMapping(value = "/orderShip", method = RequestMethod.POST)
  @ResponseBody
  public Result<String> orderShip(@RequestBody OrderMessageVO vo) {
    JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(vo));

    jsonObject.put("rocketMQTopic", SystemConstants.ROCKET_TOPIC_SIMPLE_MESSAGE);
    jsonObject.put("rocketMQTag", TemplateMessageTypeConstant.ORDER_SHIP);
    jsonObject.put("bussinessModuleCode", TemplateMessageTypeConstant.ORDER_SHIP);
    jsonObject.put("bussinessType",SystemConstants.ROCKET_CONFIG_BUSINESS_TYPE_WECHAT_ORDER_SHIP_MESSAGE);
    jsonObject.put("rocketMQBussinessId", vo.getOrderNo());
     this.rocketMQWechatService.sendMessage(jsonObject.toJSONString());
    
    /**
        *订单发货 短信提醒
     */
    JSONObject jsonObjectsms = JSONObject.parseObject(JSONObject.toJSONString(vo));

    jsonObjectsms.put("rocketMQTopic", SystemConstants.ROCKET_TOPIC_SIMPLE_MESSAGE);
    jsonObjectsms.put("rocketMQTag", TemplateMessageTypeConstant.ORDER_SMS_SHIP);
    jsonObjectsms.put("bussinessModuleCode", TemplateMessageTypeConstant.ORDER_SMS_SHIP);
    jsonObjectsms.put("bussinessType",SystemConstants.ROCKET_CONFIG_BUSINESS_TYPE_SMS_ORDER_SHIP_MESSAGE);
    jsonObjectsms.put("rocketMQBussinessId", vo.getOrderNo());
    return this.rocketMQSendOrderSmsService.sendMessage(jsonObjectsms.toJSONString());

  }
  
  /**
   * 订单签收提醒
   * @param param
   * @return
   */
  @RequestMapping(value = "/orderSign", method = RequestMethod.POST)
  @ResponseBody
  public Result<String> orderSign(@RequestBody(required = false) Object param) {
    return null;

  }

  /**
   * 订单取消提醒
   * @param vo
   * @return
   */
  @RequestMapping(value = "/orderCancel", method = RequestMethod.POST)
  @ResponseBody
  public Result<String> orderCancel(@RequestBody(required = false) OrderMessageVO vo) {
    JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(vo));

    jsonObject.put("rocketMQTopic", SystemConstants.ROCKET_TOPIC_SIMPLE_MESSAGE);
    jsonObject.put("rocketMQTag", TemplateMessageTypeConstant.ORDER_CANCEL);
    jsonObject.put("bussinessModuleCode", TemplateMessageTypeConstant.ORDER_CANCEL);
    jsonObject.put("bussinessType",SystemConstants.ROCKET_CONFIG_BUSINESS_TYPE_WECHAT_ORDER_CANCEL_MESSAGE);
    jsonObject.put("rocketMQBussinessId", vo.getOrderNo());
    return this.rocketMQWechatService.sendMessage(jsonObject.toJSONString());

  }
  
  /**
   * 订单评价提醒
   * @param param
   * @return
   */
  @RequestMapping(value = "/orderAppraisal", method = RequestMethod.POST)
  @ResponseBody
  public Result<String> orderAppraisal(@RequestBody(required = false) Object param) {
    return null;

  }
}
