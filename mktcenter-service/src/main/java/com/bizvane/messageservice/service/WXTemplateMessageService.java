package com.bizvane.messageservice.service;


import com.bizvane.messagefacade.models.vo.Result;

/**
 * 发送微信模板消息service
 * @author 董争光
 * 2018年5月28日下午2:20:46
 */
public interface WXTemplateMessageService {

  /**
   * 发微信模板消息
   * @param rocketMsgId
   * @param messageBody
   * @return
   */
  Result<String> sendMessage(String rocketMsgId, String messageBody);



}
