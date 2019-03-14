package com.bizvane.messageservice.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.openservices.ons.api.Producer;
import com.bizvane.messageservice.common.constants.SysRespConstants;
import com.bizvane.messageservice.common.constants.SystemConstants;
import com.bizvane.messageservice.mappers.RocketLogPOMapper;
import com.bizvane.messageservice.service.RocketLogService;
import com.bizvane.messageservice.service.RocketMQProducerService;
import com.bizvane.messageservice.service.RocketMQWechatService;
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
 * rocketMQ>微信模板消息service，这里不处理业务 仅仅把消息放到队列，并且记录日志
 * 
 * @author 董争光 2018年5月21日下午1:58:45
 */
@Service
public class RocketMQWechatServiceImpl implements RocketMQWechatService {

  private static final Logger logger = LoggerFactory.getLogger(RocketMQWechatServiceImpl.class);

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
    RocketMQWechatServiceImpl.logger.info("RocketMQWechatServiceImpl.sendMessage.param:" + messageBody);
    
    Result<String> result = new Result<>();
    
    if (StringUtils.isBlank(messageBody)) {
      RocketMQWechatServiceImpl.logger.error("RocketMQWechatServiceImpl.sendMessage.param:入参不能为空");
      result.setStatus(SysRespConstants.SYSTEM_DATA_NOT_EMPTY.getStatus());
      result.setMsg(SysRespConstants.SYSTEM_DATA_NOT_EMPTY.getMsg());
      return result;
    }
    
//    int hashCode = messageBody.hashCode();
//    RedisClient redisClient = RedisManager.getInstince();
//    boolean exists = redisClient.exists("message_rocketmq_" + hashCode);
//    if (exists) {
//      RocketMQWechatServiceImpl.logger.error("RocketMQWechatServiceImpl.sendMessage:" + SysRespConstants.SYSTEM_DATA_NOT_REPEAT.getMsg());
//      result.setStatus(SysRespConstants.SYSTEM_DATA_NOT_REPEAT.getStatus());
//      result.setMsg(SysRespConstants.SYSTEM_DATA_NOT_REPEAT.getMsg());
//      return result;
//    }

    JSONObject jsonObject = JSON.parseObject(messageBody);
    
    String topic = jsonObject.getString("rocketMQTopic");
    if (StringUtils.isBlank(topic)) {
      RocketMQWechatServiceImpl.logger.error("WechatServiceImpl.sendMessage.topic:topic不能为空");
      result.setStatus(SysRespConstants.ROCKET_MQ_TOPIC_NOT_EMPTY.getStatus());
      result.setMsg(SysRespConstants.ROCKET_MQ_TOPIC_NOT_EMPTY.getMsg());
      return result;
    }
    
    String tag = jsonObject.getString("rocketMQTag");
    if (StringUtils.isBlank(tag)) {
      RocketMQWechatServiceImpl.logger.error("WechatServiceImpl.sendMessage.tag:tag不能为空");
      result.setStatus(SysRespConstants.ROCKET_MQ_TAG_NOT_EMPTY.getStatus());
      result.setMsg(SysRespConstants.ROCKET_MQ_TAG_NOT_EMPTY.getMsg());
      return result;
    }
    
    String bussinessId = jsonObject.getString("rocketMQBussinessId");
    if (StringUtils.isBlank(bussinessId)) {
      RocketMQWechatServiceImpl.logger.error("WechatServiceImpl.sendMessage.bussinessId：memberCode:业务单据号不能为空");
      result.setStatus(SysRespConstants.BUSSINESS_ID_NOT_EMPTY.getStatus());
      result.setMsg(SysRespConstants.BUSSINESS_ID_NOT_EMPTY.getMsg());
      return result;
    }
    
    String bussinessModuleCode = jsonObject.getString("bussinessModuleCode");
    if (StringUtils.isBlank(bussinessModuleCode)) {
      RocketMQWechatServiceImpl.logger.error("WechatServiceImpl.sendMessage.bussinessCode:业务代码不能为空");
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
    //SystemConstants.ROCKET_CONFIG_BUSINESS_TYPE_WECHAT_SIMPLE_MESSAGE
    Producer producer = RocketMQManager.getProducer(SystemConstants.PID_PUBLIC_BIZVANE_MESSAGE);
    // 调用rocketmq
    ResponseData<String> sendResult = this.rocketMQProducerService.sendMessage(producer, topic, tag, messageBodyByte);
    String sendState = SystemConstants.ROCKET_LOG_SEND_STATE_PRODUCER_FAIL;
    if (SysRespConstants.SUCCESS.getStatus() == sendResult.getCode()) {
      sendState = SystemConstants.ROCKET_LOG_SEND_STATE_PRODUCER_SUCCESS;
//      redisClient.set("message_rocketmq_" + hashCode, "Y", 86400L);
    }
    String messageId = sendResult.getData();

    // 更新调用rocketmq日志
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
