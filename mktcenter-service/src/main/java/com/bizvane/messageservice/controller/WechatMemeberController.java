package com.bizvane.messageservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.bizvane.messageservice.common.constants.SystemConstants;
import com.bizvane.messageservice.common.constants.TemplateMessageTypeConstant;
import com.bizvane.messageservice.service.RocketMQSendSmsService;
import com.bizvane.messageservice.service.RocketMQWechatService;
import com.bizvane.messagefacade.models.vo.MemberMessageVO;
import com.bizvane.messagefacade.models.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 会员相关模板消息
 * @author 董争光
 * 2018年7月25日下午1:53:44
 */
@Controller
@RequestMapping("/wechatMemeber")
public class WechatMemeberController {

  @Autowired
  private RocketMQWechatService rocketMQWechatService;
  @Autowired
  private RocketMQSendSmsService rocketMQSendSmsService;

  /**
   * 会员注册提醒
   * @param vo
   * @return
   */
  @RequestMapping(value = "/memeberRegister", method = RequestMethod.POST)
  @ResponseBody
  public Result<String> memeberRegister(@RequestBody MemberMessageVO vo) {
    JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(vo));
    JSONObject jsonObjectSms = JSONObject.parseObject(JSONObject.toJSONString(vo));

    jsonObject.put("rocketMQTopic", SystemConstants.ROCKET_TOPIC_SIMPLE_MESSAGE);
    jsonObject.put("rocketMQTag", TemplateMessageTypeConstant.MEMEBER_REGISTER);
    jsonObject.put("bussinessModuleCode", TemplateMessageTypeConstant.MEMEBER_REGISTER);
    jsonObject.put("bussinessType",SystemConstants.ROCKET_CONFIG_BUSINESS_TYPE_WECHAT_MEMBER_REGISTER_MESSAGE);
    jsonObject.put("rocketMQBussinessId", vo.getMemberCode());

    rocketMQWechatService.sendMessage(jsonObject.toJSONString());

    /**
         短信消息
     */
    jsonObjectSms.put("rocketMQTopic", SystemConstants.ROCKET_TOPIC_SIMPLE_MESSAGE);
    jsonObjectSms.put("rocketMQTag", TemplateMessageTypeConstant.MEMEBER_SMS_REGISTER);
    jsonObjectSms.put("bussinessModuleCode", TemplateMessageTypeConstant.MEMEBER_SMS_REGISTER);
    jsonObjectSms.put("bussinessType",SystemConstants.ROCKET_CONFIG_BUSINESS_TYPE_SMS_MEMBER_REGISTER_MESSAGE);
    jsonObjectSms.put("rocketMQBussinessId", vo.getMemberCode());
    return  this.rocketMQSendSmsService.sendMessage(jsonObjectSms.toJSONString());
    }
  


  /**
   * 会员绑定成功提醒
   * @param vo
   * @return
   */
  @RequestMapping(value = "/memeberInviteRegister", method = RequestMethod.POST)
  @ResponseBody
  public Result<String> memeberInviteRegister(@RequestBody MemberMessageVO vo) {
    JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(vo));

    jsonObject.put("rocketMQTopic", SystemConstants.ROCKET_TOPIC_SIMPLE_MESSAGE);
    jsonObject.put("rocketMQTag", TemplateMessageTypeConstant.MEMEBER_INVITE_REGISTER);
    jsonObject.put("bussinessModuleCode", TemplateMessageTypeConstant.MEMEBER_INVITE_REGISTER);
    jsonObject.put("bussinessType",SystemConstants.ROCKET_CONFIG_BUSINESS_TYPE_WECHAT_MEMBER_INVITE_REGISTER_MESSAGE);
    jsonObject.put("rocketMQBussinessId", vo.getMemberCode());
    rocketMQWechatService.sendMessage(jsonObject.toJSONString());
    
    /**
       短信消息
     */
    JSONObject jsonObjectSms = JSONObject.parseObject(JSONObject.toJSONString(vo));
    jsonObjectSms.put("rocketMQTopic", SystemConstants.ROCKET_TOPIC_SIMPLE_MESSAGE);
    jsonObjectSms.put("rocketMQTag", TemplateMessageTypeConstant.MEMEBER_SMS_INVITE_REGISTER);
    jsonObjectSms.put("bussinessModuleCode", TemplateMessageTypeConstant.MEMEBER_SMS_INVITE_REGISTER);
    jsonObjectSms.put("bussinessType",SystemConstants.ROCKET_CONFIG_BUSINESS_TYPE_SMS_MEMBER_INVITE_REGISTER_MESSAGE);
    jsonObjectSms.put("rocketMQBussinessId", vo.getMemberCode());
    return this.rocketMQSendSmsService.sendMessage(jsonObjectSms.toJSONString());

  }
  
  /**
   * 会员升级提醒
   * @param vo
   * @return
   */
  @RequestMapping(value = "/memeberUpgrade", method = RequestMethod.POST)
  @ResponseBody
  public Result<String> memeberUpgrade(@RequestBody MemberMessageVO vo) {
    JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(vo));

    jsonObject.put("rocketMQTopic", SystemConstants.ROCKET_TOPIC_SIMPLE_MESSAGE);
    jsonObject.put("rocketMQTag", TemplateMessageTypeConstant.MEMEBER_UPGRADE);
    jsonObject.put("bussinessModuleCode", TemplateMessageTypeConstant.MEMEBER_UPGRADE);
    jsonObject.put("bussinessType",SystemConstants.ROCKET_CONFIG_BUSINESS_TYPE_WECHAT_MEMBER_UPGRADE_MESSAGE);
    jsonObject.put("rocketMQBussinessId", vo.getMemberCode());
    rocketMQWechatService.sendMessage(jsonObject.toJSONString());
     
    /**
     短信消息
    */
     JSONObject jsonObjectSms = JSONObject.parseObject(JSONObject.toJSONString(vo));
     jsonObjectSms.put("rocketMQTopic", SystemConstants.ROCKET_TOPIC_SIMPLE_MESSAGE);
     jsonObjectSms.put("rocketMQTag", TemplateMessageTypeConstant.MEMEBER_SMS_UPGRADE);
     jsonObjectSms.put("bussinessModuleCode", TemplateMessageTypeConstant.MEMEBER_SMS_UPGRADE);
     jsonObjectSms.put("bussinessType",SystemConstants.ROCKET_CONFIG_BUSINESS_TYPE_SMS_MEMBER_UPGRADE_MESSAGE);
     jsonObjectSms.put("rocketMQBussinessId", vo.getMemberCode());
     return this.rocketMQSendSmsService.sendMessage(jsonObjectSms.toJSONString());

  }
  
  /**
   * 会员降级提醒
   * @param vo
   * @return
   */
  @RequestMapping(value = "/memeberDowngrade", method = RequestMethod.POST)
  @ResponseBody
  public Result<String> memeberDowngrade(@RequestBody MemberMessageVO vo) {
    JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(vo));

    jsonObject.put("rocketMQTopic", SystemConstants.ROCKET_TOPIC_SIMPLE_MESSAGE);
    jsonObject.put("rocketMQTag", TemplateMessageTypeConstant.MEMEBER_DOWNGRADE);
    jsonObject.put("bussinessModuleCode", TemplateMessageTypeConstant.MEMEBER_DOWNGRADE);
    jsonObject.put("bussinessType",SystemConstants.ROCKET_CONFIG_BUSINESS_TYPE_WECHAT_MEMBER_DOWNGRADE_MESSAGE);
    jsonObject.put("rocketMQBussinessId", vo.getMemberCode());
    rocketMQWechatService.sendMessage(jsonObject.toJSONString());
    
    /**
       短信消息
   */
    JSONObject jsonObjectSms = JSONObject.parseObject(JSONObject.toJSONString(vo));
    jsonObjectSms.put("rocketMQTopic", SystemConstants.ROCKET_TOPIC_SIMPLE_MESSAGE);
    jsonObjectSms.put("rocketMQTag", TemplateMessageTypeConstant.MEMEBER_SMS_DOWNGRADE);
    jsonObjectSms.put("bussinessModuleCode", TemplateMessageTypeConstant.MEMEBER_SMS_DOWNGRADE);
    jsonObjectSms.put("bussinessType",SystemConstants.ROCKET_CONFIG_BUSINESS_TYPE_SMS_MEMBER_DOWNGRADE_MESSAGE);
    jsonObjectSms.put("rocketMQBussinessId", vo.getMemberCode());
    return this.rocketMQSendSmsService.sendMessage(jsonObjectSms.toJSONString());

  }


}
