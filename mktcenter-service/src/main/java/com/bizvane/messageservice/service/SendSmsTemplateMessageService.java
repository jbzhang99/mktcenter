package com.bizvane.messageservice.service;


import com.bizvane.messagefacade.models.vo.Result;

/**
 * @发送短信模板消息service
 * 
 * @author 张迪
 * 
 * @date 2018/08/09
 */
public interface SendSmsTemplateMessageService {

  /**
   * @发送短信模板消息
   * 
   * @param rocketMsgId
   * 
   * @param messageBody
   * 
   * @return Result<String>
   */
  Result<String> sendMessage(String rocketMsgId, String messageBody);



}
