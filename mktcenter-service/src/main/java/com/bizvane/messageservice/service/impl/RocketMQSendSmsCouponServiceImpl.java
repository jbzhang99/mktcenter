package com.bizvane.messageservice.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.openservices.ons.api.Producer;
import com.bizvane.messageservice.common.constants.SysRespConstants;
import com.bizvane.messageservice.common.constants.SystemConstants;
import com.bizvane.messageservice.mappers.RocketLogPOMapper;
import com.bizvane.messageservice.service.RocketLogService;
import com.bizvane.messageservice.service.RocketMQProducerService;
import com.bizvane.messageservice.service.RocketMQSendMessageSmsService;
import com.bizvane.messagefacade.models.po.RocketLogPO;
import com.bizvane.messagefacade.models.vo.Result;
import com.bizvane.utils.responseinfo.ResponseData;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * rocketMQ>短信模板消息service，
 * 
 * @author 梁赞文
 */
@Service
public class RocketMQSendSmsCouponServiceImpl implements RocketMQSendMessageSmsService {

  private static final Logger logger = LoggerFactory.getLogger(RocketMQSendSmsCouponServiceImpl.class);

  @Autowired
  private RocketMQProducerService rocketMQProducerService;

  @Autowired
  private RocketLogService rocketLogService;
  
  @Autowired
  private RocketLogPOMapper rocketLogPOMapper;

  /**
   * 把模板消息放入消息队列
   * @param messageBody
   * @return
   */
  @Override
  public Result<String> sendMessage(String messageBody) {
    RocketMQSendSmsCouponServiceImpl.logger.info("RocketMQSendSmsServiceImpl.sendMessage.param:" + messageBody);
    
    
    Result<String> result = new Result<>();

    if (StringUtils.isBlank(messageBody)) {
      RocketMQSendSmsCouponServiceImpl.logger.error("RocketMQSendSmsServiceImpl.sendMessage.param:入参不能为空");
      result.setStatus(SysRespConstants.SYSTEM_DATA_NOT_EMPTY.getStatus());
      result.setMsg(SysRespConstants.SYSTEM_DATA_NOT_EMPTY.getMsg());
      return result;
    }
    
//    int hashCode = messageBody.hashCode();
//    RedisClient redisClient = RedisManager.getInstince();
//    boolean exists = redisClient.exists("message_rocketmq" + hashCode);
//    if (exists) {
//      RocketMQSendSmsCouponServiceImpl.logger.error("RocketMQSendSmsServiceImpl.sendMessage:" + SysRespConstants.SYSTEM_DATA_NOT_REPEAT.getMsg());
//      result.setStatus(SysRespConstants.SYSTEM_DATA_NOT_REPEAT.getStatus());
//      result.setMsg(SysRespConstants.SYSTEM_DATA_NOT_REPEAT.getMsg());
//      return result;
//    }

    JSONObject jsonObject = JSON.parseObject(messageBody);
    String topic = jsonObject.getString("rocketMQTopic");
    if (StringUtils.isBlank(topic)) {
      RocketMQSendSmsCouponServiceImpl.logger.error("SmsServiceImpl.sendMessage.topic:topic不能为空");
      result.setStatus(SysRespConstants.ROCKET_MQ_TOPIC_NOT_EMPTY.getStatus());
      result.setMsg(SysRespConstants.ROCKET_MQ_TOPIC_NOT_EMPTY.getMsg());
      return result;
    }
    
    String tag = jsonObject.getString("rocketMQTag");
    if (StringUtils.isBlank(tag)) {
      RocketMQSendSmsCouponServiceImpl.logger.error("SmsServiceImpl.sendMessage.tag:tag不能为空");
      result.setStatus(SysRespConstants.ROCKET_MQ_TAG_NOT_EMPTY.getStatus());
      result.setMsg(SysRespConstants.ROCKET_MQ_TAG_NOT_EMPTY.getMsg());
      return result;
    }
    
    String bussinessId = jsonObject.getString("rocketMQBussinessId");
    if (StringUtils.isBlank(bussinessId)) {
      RocketMQSendSmsCouponServiceImpl.logger.error("SmsServiceImpl.sendMessage.bussinessId:业务单据号不能为空");
      result.setStatus(SysRespConstants.BUSSINESS_ID_NOT_EMPTY.getStatus());
      result.setMsg(SysRespConstants.BUSSINESS_ID_NOT_EMPTY.getMsg());
      return result;
    }
    
    String bussinessModuleCode = jsonObject.getString("bussinessModuleCode");
    if (StringUtils.isBlank(bussinessModuleCode)) {
      RocketMQSendSmsCouponServiceImpl.logger.error("SmsServiceImpl.sendMessage.bussinessCode:业务代码不能为空");
      result.setStatus(SysRespConstants.BUSSINESS_MODEL_CODE_NOT_EMPTY.getStatus());
      result.setMsg(SysRespConstants.BUSSINESS_MODEL_CODE_NOT_EMPTY.getMsg());
      return result;
    }
    
    
    
    // 记录调用rocketmq日志
    RocketLogPO rocketLogPO = new RocketLogPO();
    rocketLogPO.setBussinessModuleCode(bussinessModuleCode);
    rocketLogPO.setBussinessId(bussinessId);
    rocketLogPO.setDataBody(messageBody);

    Result<String> insertResult = this.rocketLogService.insert(rocketLogPO);

    byte[] messageBodyByte = null;
    try {
      messageBodyByte = messageBody.getBytes(SystemConstants.CHARSET);
    } catch (UnsupportedEncodingException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    //SystemConstants.ROCKET_CONFIG_BUSINESS_TYPE_Sms_SIMPLE_MESSAGE
    Producer producer = RocketMQManager.getProducer(SystemConstants.PID_PUBLIC_BIZVANE_MESSAGE);
    // 调用rocketmq
    ResponseData<String> sendResult = this.rocketMQProducerService.sendMessage(producer, topic, tag, messageBodyByte);
    String sendState = SystemConstants.ROCKET_LOG_SEND_STATE_PRODUCER_FAIL;
    if (SysRespConstants.SUCCESS.getStatus() == sendResult.getCode()) {
      sendState = SystemConstants.ROCKET_LOG_SEND_STATE_PRODUCER_SUCCESS;
//      redisClient.set("message_rocketmq_" + hashCode, "Y", 86400L);
    }
    String messageId = sendResult.getData();
    logger.info("RocketMQSendMessageSmsServiceImplMQ消息发送成功： " + bussinessId);
    // 更新调用rocketmq日志
   rocketLogPO.set_id(insertResult.getData());
    rocketLogPO.setMessageId(messageId);
    rocketLogPO.setSendState(sendState);
    rocketLogPO.setUpdateDate(new Date());
    this.rocketLogService.update(rocketLogPO);
    result.setMsg(SysRespConstants.SUCCESS.getMsg());
    result.setData(messageId);

    return result;
  }

}
