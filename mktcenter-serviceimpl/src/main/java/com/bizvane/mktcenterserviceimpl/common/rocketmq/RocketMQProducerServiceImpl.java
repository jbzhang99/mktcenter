package com.bizvane.mktcenterserviceimpl.common.rocketmq;

import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.Producer;
import com.aliyun.openservices.ons.api.SendCallback;
import com.aliyun.openservices.ons.api.SendResult;
import com.aliyun.openservices.ons.api.exception.ONSClientException;
import com.bizvane.utils.responseinfo.ResponseData;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 发送MQ消息service
 * 
 * @author 董争光 2018年5月20日下午2:48:19
 */
@Service
public class RocketMQProducerServiceImpl implements RocketMQProducerService {

  private static final Logger logger = LoggerFactory.getLogger(RocketMQProducerServiceImpl.class);

  /**
   * 发送MQ消息service
   * 
   * @author 董争光 2018年5月20日下午2:48:19
   */
  @Override
  public ResponseData<String> sendMessage(final Producer producer, final String topic, final String tag, final byte[] messageBody) {
    RocketMQProducerServiceImpl.logger.info("RocketMQProducerServiceImpl.sendMessage:topic:" + topic + ">tag:" + tag);

    if (StringUtils.isBlank(topic) || StringUtils.isBlank(tag)) {
      RocketMQProducerServiceImpl.logger.error("RocketMQProducerServiceImpl.sendMessage:topic、tag不能为空");
    }

    ResponseData<String> result = new ResponseData<>();
    Message message = new Message(topic, tag, messageBody);
    try {
      SendResult sendResult = producer.send(message);
      String messageId = sendResult.getMessageId();
      result.setData(messageId);
      RocketMQProducerServiceImpl.logger.info("RocketMQProducerServiceImpl.sendMessage消息发送完成，msgId：" + messageId);
    } catch (ONSClientException e) {
      RocketMQProducerServiceImpl.logger.info("RocketMQProducerServiceImpl.sendMessage：" + e.getMessage());
      // 出现异常意味着发送失败，为了避免消息丢失，建议缓存该消息然后进行重试。
    }

    return result;
  }

  /**
   * 异步发送MQ,提供回调函数，超时时间默认3s
   * 
   * @param topic
   * @param tag
   * @param messageBody
   * @param sendCallback
   * @return
   */
  @Override
  public ResponseData<Object> sendMessage(final Producer producer, final String topic, final String tag, final byte[] messageBody,
      SendCallback sendCallback) {
    return null;


  }

  /**
   * 单向发送MQ，不等待服务器回应且没有回调函数触发 适用于某些耗时非常短，但对可靠性要求并不高的场景，例如日志收集。
   * 
   * @param topic
   * @param tag
   * @param messageBody
   * @return
   */
  @Override
  public ResponseData<Object> sendOnewayMessage(final Producer producer, final String topic, final String tag, final byte[] messageBody) {
    // TODO Auto-generated method stub

    return new ResponseData<>();
  }

}
