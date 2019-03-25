package com.bizvane.messageservice.service;


import com.bizvane.messagefacade.models.vo.Result;

/**
 * rocketMQ>模板消息service，这里不处理业务
 * 仅仅把消息放到队列，并且记录日志
 * @author 
 * 2018年5月21日下午1:58:45
 */
public interface RocketMQSendMessageSmsService {

   /**
    * 把模板消息放入消息队列
    * @param messageBody
    * @return
    */
  Result<String> sendMessage(String messageBody);

}
