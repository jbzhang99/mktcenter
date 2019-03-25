package com.bizvane.messageservice.service;


import com.bizvane.messagefacade.models.vo.Result;


public interface SmsTemplateMessageService {

  /**
   * 发短信模板消息
   * @param rocketMsgId
   * @param messageBody
   * @return
   */
  Result<String> sendMessage(String rocketMsgId, String messageBody);



}
