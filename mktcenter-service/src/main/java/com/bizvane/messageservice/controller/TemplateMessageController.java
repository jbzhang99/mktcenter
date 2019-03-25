package com.bizvane.messageservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.bizvane.messageservice.common.constants.SystemConstants;
import com.bizvane.messageservice.common.constants.TemplateMessageTypeConstant;
import com.bizvane.messageservice.service.MsgSmsTempService;
import com.bizvane.messageservice.service.RocketMQSendSmsService;
import com.bizvane.messageservice.service.RocketMQWechatService;
import com.bizvane.messageservice.service.SmsMessageLogService;
import com.bizvane.messagefacade.models.po.MsgSmsTempPO;
import com.bizvane.messagefacade.models.vo.*;
import com.bizvane.utils.responseinfo.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * 活动模板消息
 * @author liangzanwen
 *2018年8月13日上午9:16:44
 */
@Controller
@RequestMapping("/templateMessage")
public class TemplateMessageController {

  @Autowired
  private RocketMQWechatService rocketMQWechatService;
  @Autowired
  private RocketMQSendSmsService rocketMQSendSmsService;
  
  @Autowired
  private SmsMessageLogService smsMessageLogService;
  

  @Autowired
  private MsgSmsTempService msgSmsTempService;
  
  
  
  //图文消息
  @RequestMapping(value = "/sendTuWenMessage", method = RequestMethod.POST)
  @ResponseBody
  public Result<String> sendTuWenMessage(@RequestBody SendTuWenMessageVO vo) {
    JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(vo));

    jsonObject.put("rocketMQTopic", SystemConstants.ROCKET_TOPIC_SIMPLE_MESSAGE);
    jsonObject.put("rocketMQTag", TemplateMessageTypeConstant.TUWEN_TEMPLATE_MESSAGE);
    jsonObject.put("bussinessModuleCode", TemplateMessageTypeConstant.TUWEN_TEMPLATE_MESSAGE);
    jsonObject.put("bussinessType",SystemConstants.ROCKET_CONFIG_BUSINESS_TYPE_TUWEN_TEMPLATE_MESSAGE);
    jsonObject.put("rocketMQBussinessId", vo.getTaskId());
    return  this.rocketMQWechatService.sendMessage(jsonObject.toJSONString());
    }
  
  //企业通用短信通道
  @RequestMapping(value = "/sendQyGenrealBatch", method = RequestMethod.POST)
  @ResponseBody
  public Result<String> sendQyGenrealBatch(@RequestBody GenrealSendMessageVO vo) {
    JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(vo));

    jsonObject.put("rocketMQTopic", SystemConstants.ROCKET_TOPIC_SIMPLE_MESSAGE);
    jsonObject.put("rocketMQTag", TemplateMessageTypeConstant.GEN_QY_TEMPLATE_MESSAGE);
    jsonObject.put("bussinessModuleCode", TemplateMessageTypeConstant.GEN_QY_TEMPLATE_MESSAGE);
    jsonObject.put("bussinessType",SystemConstants.ROCKET_CONFIG_BUSINESS_TYPE_GEN_QY_TEMPLATE_MESSAGE);
    jsonObject.put("rocketMQBussinessId", vo.getTaskId());

    return  this.rocketMQWechatService.sendMessage(jsonObject.toJSONString());
    }
  
  @RequestMapping("/getTemplateType")
  @ResponseBody
  public ResponseData<List<MsgSmsTempPO>> getTemplateType(@RequestBody GenrealTemMessage vo){
	  
	  return msgSmsTempService.getQyTemplateByType(vo.getSysBrandId(),vo.getTemplateType(),vo.getTemplateType());
	  
  }
  
  
  
  @RequestMapping(value = "/sendGenrealBatch", method = RequestMethod.POST)
  @ResponseBody
  public Result<String> sendGenrealBatch(@RequestBody GenrealSendMessageVO vo) {
    JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(vo));

    jsonObject.put("rocketMQTopic", SystemConstants.ROCKET_TOPIC_SIMPLE_MESSAGE);
    jsonObject.put("rocketMQTag", TemplateMessageTypeConstant.GEN_SMS_TEMPLATE_MESSAGE);
    jsonObject.put("bussinessModuleCode", TemplateMessageTypeConstant.GEN_SMS_TEMPLATE_MESSAGE);
    jsonObject.put("bussinessType",SystemConstants.ROCKET_CONFIG_BUSINESS_TYPE_GEN_SMS_TEMPLATE_MESSAGE);
    jsonObject.put("rocketMQBussinessId", vo.getTaskId());

    return  this.rocketMQWechatService.sendMessage(jsonObject.toJSONString());

 

    }
  
  @RequestMapping("getReturnMessage")
  @ResponseBody
  public ResponseData<SmsStatisticsVO> getReturnMessage(@RequestBody GenrealGetMessageVO genrealGetMessageVO){
	  ResponseData<Object> genreal =smsMessageLogService.getReturnMessage(genrealGetMessageVO);
	  SmsStatisticsVO smsStatisticsVO =(SmsStatisticsVO) genreal.getData();
	  ResponseData<SmsStatisticsVO> smsStatistics= new ResponseData<SmsStatisticsVO>();
	  smsStatistics.setData(smsStatisticsVO);
      return smsStatistics;
  }



/**
 * 活动消费模板-微信发送
 * @param vo
 * @return
 */
  @RequestMapping(value = "/sendTemplateMessage", method = RequestMethod.POST)
  @ResponseBody
  public Result<String> sendTemplateMessage(@RequestBody ActivityMessageVO vo) {
    JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(vo));

    jsonObject.put("rocketMQTopic", SystemConstants.ROCKET_TOPIC_SIMPLE_MESSAGE);
    jsonObject.put("rocketMQTag", TemplateMessageTypeConstant.ACTIVITY_TEMPLATE_MESSAGE);
    jsonObject.put("bussinessModuleCode", TemplateMessageTypeConstant.ACTIVITY_TEMPLATE_MESSAGE);
    jsonObject.put("bussinessType",SystemConstants.ROCKET_CONFIG_BUSINESS_TYPE_WECHAT_TEMPLATE_MESSAGE);
    jsonObject.put("rocketMQBussinessId", vo.getMemberCode());

    return  this.rocketMQWechatService.sendMessage(jsonObject.toJSONString());

 

    }
  /**
   * 活动消费模板-短信发送
   * @param vo
   * @return
   */
    @RequestMapping(value = "/sendSmsTemplateMessage", method = RequestMethod.POST)
    @ResponseBody
    public Result<String> sendSmsTemplateMessage(@RequestBody ActivityMessageVO vo) {
      JSONObject jsonObjectSms = JSONObject.parseObject(JSONObject.toJSONString(vo));
   
      // 短信消息
      jsonObjectSms.put("rocketMQTopic", SystemConstants.ROCKET_TOPIC_SIMPLE_MESSAGE);
      jsonObjectSms.put("rocketMQTag", TemplateMessageTypeConstant.ACTIVITY_SMS_TEMPLATE_MESSAGE);
      jsonObjectSms.put("bussinessModuleCode", TemplateMessageTypeConstant.ACTIVITY_SMS_TEMPLATE_MESSAGE);
      jsonObjectSms.put("bussinessType",SystemConstants.ROCKET_CONFIG_BUSINESS_TYPE_SMS_TEMPLATE_MESSAGE);
      jsonObjectSms.put("rocketMQBussinessId", vo.getMemberPhone());
      return  this.rocketMQSendSmsService.sendMessage(jsonObjectSms.toJSONString());
      }
 

}
