package com.bizvane.messageservice.service.impl;

import com.alibaba.fastjson.JSON;
import com.bizvane.messageservice.common.constants.SysRespConstants;
import com.bizvane.messageservice.common.constants.SystemConstants;
import com.bizvane.messageservice.common.utils.WeUtils;
import com.bizvane.messageservice.mappers.WechatMessageLogPOMapper;
import com.bizvane.messageservice.mappers.WxPublicPOMapper;
import com.bizvane.messageservice.service.WXTemplateMessageManagerService;
import com.bizvane.messageservice.template.UseTemplate;
import com.bizvane.messagefacade.models.po.WechatMessageLogPO;
import com.bizvane.messagefacade.models.po.WechatMessageLogPOExample;
import com.bizvane.messagefacade.models.po.WxPublicPO;
import com.bizvane.messagefacade.models.vo.Result;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 微信模板消息管理
 * 
 * @author 董争光 2018年5月23日下午1:20:52
 */
@Service
public class WXTemplateMessageManagerServiceImpl implements WXTemplateMessageManagerService {

  @Autowired
  private WechatMessageLogPOMapper wechatMessageLogPOMapper;

  @Autowired
  private UseTemplate useTemplate;

  @Autowired
  private WxPublicPOMapper wxPublicPOMapper;

  private static final Logger logger = LoggerFactory.getLogger(WXTemplateMessageManagerServiceImpl.class);

  /**
   * 重发所有失败的消息
   * 
   * @return
   */
  @Override
  public Result<Object> reSendMessageAll() {
    logger.info("进入WXTemplateMessageManagerServiceImpl.reSendMessageAll");

    WechatMessageLogPOExample example = new WechatMessageLogPOExample();
    example.createCriteria().andSendStateEqualTo(SystemConstants.WECHAT_MESSAGE_LOG_SEND_STATE_FAIL);

    List<WechatMessageLogPO> list = this.wechatMessageLogPOMapper.selectByExample(example);
    if (CollectionUtils.isNotEmpty(list)) {
      logger.info("WXTemplateMessageManagerServiceImpl.reSendMessageAll失败总记录数：" + list.size());
      for (WechatMessageLogPO wechatMessageLogPO : list) {
        try {
          this.dealReSendMessage(wechatMessageLogPO);
        } catch (Exception e) {
          logger.error("WXTemplateMessageManagerServiceImpl.reSendMessageAll微信模板消息重发异常");
          e.printStackTrace();
        }
      }
    }

    return new Result<>();
  }

  /**
   * 重发指定公众号下的所有失败消息
   * 
   * @param wxPublicId
   * @return
   */
  @Override
  public Result<Object> reSendMessage(Long wxPublicId) {
    logger.info("进入WXTemplateMessageManagerServiceImpl.reSendMessageAll" + wxPublicId);
    
    WechatMessageLogPOExample example = new WechatMessageLogPOExample();
    example.createCriteria().andSendStateEqualTo(SystemConstants.WECHAT_MESSAGE_LOG_SEND_STATE_FAIL)
        .andWxPublicIdEqualTo(wxPublicId);

    List<WechatMessageLogPO> list = this.wechatMessageLogPOMapper.selectByExample(example);
    if (CollectionUtils.isNotEmpty(list)) {
      logger.info("WXTemplateMessageManagerServiceImpl.reSendMessageAll失败总记录数：" + list.size());
      for (WechatMessageLogPO wechatMessageLogPO : list) {
        try {
          this.dealReSendMessage(wechatMessageLogPO);
        } catch (Exception e) {
          logger.error("WXTemplateMessageManagerServiceImpl.reSendMessageAll微信模板消息重发异常");
          e.printStackTrace();
        }
      }
    }

    return new Result<>();
  }

  /**
   * 重发指定会员失败的模板消息
   * 
   * @param wxPublicId
   * @param openIdList
   * @return
   */
  @Override
  public Result<Object> reSendMessage(Long wxPublicId, List<String> openIdList) {
    logger.info("进入WXTemplateMessageManagerServiceImpl.reSendMessageAll" + wxPublicId);
    WechatMessageLogPOExample example = new WechatMessageLogPOExample();
    example.createCriteria().andSendStateEqualTo(SystemConstants.WECHAT_MESSAGE_LOG_SEND_STATE_FAIL)
        .andWxPublicIdEqualTo(wxPublicId).andOpenIdIn(openIdList);

    List<WechatMessageLogPO> list = this.wechatMessageLogPOMapper.selectByExample(example);
    if (CollectionUtils.isNotEmpty(list)) {
      logger.info("进入WXTemplateMessageManagerServiceImpl.reSendMessageAll失败总记录数：" + list.size());
      for (WechatMessageLogPO wechatMessageLogPO : list) {
        try {
          this.dealReSendMessage(wechatMessageLogPO);
        } catch (Exception e) {
          logger.error("进入WXTemplateMessageManagerServiceImpl.reSendMessageAll发生异常");
          e.printStackTrace();
        }

      }
    }

    return new Result<>();
  }

  @Override
  public Result<Object> dealReSendMessage(WechatMessageLogPO wechatMessageLogPO) {
    Long wxPublicId = wechatMessageLogPO.getWxPublicId();
    String templateType = wechatMessageLogPO.getTemplateType();
    String openId = wechatMessageLogPO.getOpenId();
    String messageBody = wechatMessageLogPO.getMessageBody();

    WxPublicPO wxPublicPO = this.wxPublicPOMapper.selectByPrimaryKey(wxPublicId);
    WeUtils weUtils = new WeUtils(wxPublicPO);

    Result<String> sendResult =UseTemplate.sendMessage(null, templateType, openId, JSON.parseObject(messageBody));
    String messageId = null;
    String resultInfo = null;
    String sendState = SystemConstants.WECHAT_MESSAGE_LOG_SEND_STATE_FAIL;
    if (SysRespConstants.SUCCESS.getStatus() == sendResult.getStatus()) {
      sendState = SystemConstants.WECHAT_MESSAGE_LOG_SEND_STATE_SUCCESS;
      resultInfo = sendResult.getData();
      messageId = String.valueOf(JSON.parseObject(resultInfo).getLong("msgid"));
    } else {
      resultInfo = sendResult.getMsg();
    }

    wechatMessageLogPO.setMessageId(messageId);
    wechatMessageLogPO.setResultInfo(resultInfo);
    wechatMessageLogPO.setSendState(sendState);

    this.wechatMessageLogPOMapper.updateByPrimaryKeySelective(wechatMessageLogPO);
    
    return new Result<>();
  }

}
