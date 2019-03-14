package com.bizvane.messageservice.service;

import com.bizvane.messagefacade.models.po.WechatMessageLogPO;
import com.bizvane.messagefacade.models.vo.Result;

import java.util.List;

/**
 * 微信模板消息管理
 * @author 董争光
 * 2018年5月23日下午1:20:52
 */
public interface WXTemplateMessageManagerService {

  /**
   * 重发所有失败的消息
   * @return
   */
  Result<Object> reSendMessageAll();
  
  /**
   * 重发指定公众号下的所有失败消息
   * @param wxPublicId
   * @return
   */
  Result<Object> reSendMessage(Long wxPublicId);
  
  /**
   * 重发指定会员失败的模板消息
   * @param wxPublicId
   * @param openIdList
   * @return
   */
  Result<Object> reSendMessage(Long wxPublicId, List<String> openIdList);
  
  /**
   * 重发消息执行方法
   * @param wechatMessageLogPO
   * @return
   */
  Result<Object> dealReSendMessage(WechatMessageLogPO wechatMessageLogPO);
}
