package com.bizvane.messageservice.controller;

import com.bizvane.messageservice.service.WXTemplateMessageManagerService;
import com.bizvane.messagefacade.models.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 微信模板消息
 * 
 * @author 董争光 2018年5月21日下午1:53:53
 */
@Controller
@RequestMapping("/wechatManager")
public class WechatManagerController {

  @Autowired
  private WXTemplateMessageManagerService wxTemplateMessageManagerService;

  /**
   * 重发所有公众号下失败的消息
   * 
   * @return
   */
  @RequestMapping(value = "/reSendMessageAll", method = RequestMethod.GET)
  @ResponseBody
  public Result<Object> reSendMessageAll() {
    return this.wxTemplateMessageManagerService.reSendMessageAll();
  }

  /**
   * 重发指定公众号下所有失败的消息
   * 
   * @param wxPublicId
   * @return
   */
  @RequestMapping(value = "/reSendMessage/{wxPublicId}", method = RequestMethod.GET)
  @ResponseBody
  public Result<Object> reSendMessage(@PathVariable("wxPublicId") Long wxPublicId) {
    return this.wxTemplateMessageManagerService.reSendMessage(wxPublicId);
  }

  /**
   * 重发指定公众号下指定会员的失败消息
   * 
   * @param wxPublicId
   * @param openIdList
   * @return
   */
  @RequestMapping(value = "/reSendMessageByOpenId", method = RequestMethod.GET)
  @ResponseBody
  public Result<Object> reSendMessageByOpenId(@PathVariable("wxPublicId") Long wxPublicId, List<String> openIdList) {
    return this.wxTemplateMessageManagerService.reSendMessage(wxPublicId, openIdList);
  }

}
