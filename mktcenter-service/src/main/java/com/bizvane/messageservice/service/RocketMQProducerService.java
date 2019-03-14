package com.bizvane.messageservice.service;

import com.aliyun.openservices.ons.api.Producer;
import com.aliyun.openservices.ons.api.SendCallback;
import com.bizvane.utils.responseinfo.ResponseData;

/**
 * 发送MQ消息service
 * 
 * @author 董争光 2018年5月20日下午2:48:19
 */
public interface RocketMQProducerService {


  /**
   * 同步发送MQ
   * 
   * @param topic
   * @param tag
   * @param messageBody 消息内容
   * @return
   */
  ResponseData<String> sendMessage(final Producer producer, final String topic, final String tag, final byte[] messageBody);

  /**
   * 异步发送MQ,提供回调函数，超时时间默认3s
   * 
   * @param topic
   * @param tag
   * @param messageBody
   * @param sendCallback
   * @return
   */
  ResponseData<Object> sendMessage(final Producer producer, final String topic, final String tag, final byte[] messageBody, SendCallback sendCallback);

  /**
   * 单向发送MQ，不等待服务器回应且没有回调函数触发 适用于某些耗时非常短，但对可靠性要求并不高的场景，例如日志收集。
   * 
   * @param topic
   * @param tag
   * @param messageBody
   * @return
   */
  ResponseData<Object> sendOnewayMessage(final Producer producer, final String topic, final String tag, final byte[] messageBody);

/**同步发送MQ
 * @param producer
 * @param topic
 * @param tag
 * @param messageBody
 * @return
 */
  ResponseData<String> sendMessageStartDeliverTime(Producer producer, String topic, String tag, byte[] messageBody);

}
