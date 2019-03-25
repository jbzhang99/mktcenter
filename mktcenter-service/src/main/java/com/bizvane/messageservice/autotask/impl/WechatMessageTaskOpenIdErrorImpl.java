package com.bizvane.messageservice.autotask.impl;

import com.bizvane.messageservice.autotask.IWechatMessageTask;
import com.bizvane.messageservice.common.constants.SystemConstants;
import com.bizvane.messageservice.common.utils.DateUtils;
import com.bizvane.messageservice.mappers.WechatMessageLogPOMapper;
import com.bizvane.messageservice.service.WXTemplateMessageManagerService;
import com.bizvane.messagefacade.models.po.WechatMessageLogPO;
import com.bizvane.messagefacade.models.po.WechatMessageLogPOExample;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class WechatMessageTaskOpenIdErrorImpl implements IWechatMessageTask {

  @Autowired
  private WechatMessageLogPOMapper wechatMessageLogPOMapper;
  
  @Autowired
  private WXTemplateMessageManagerService wXTemplateMessageManagerService;
  
  private static final Logger logger = LoggerFactory.getLogger(WechatMessageTaskOpenIdErrorImpl.class);
  
//  @Scheduled(cron="0 0/4 8-22 * * ?") 
  @Override
  public void reSendMessage() {
    
    logger.info("WechatMessageTaskOpenIdErrorImpl.reSendMessage.自动任务开始执行");
    WechatMessageLogPOExample example = new WechatMessageLogPOExample();
    Date nowDate = new Date();
    
    WechatMessageLogPOExample.Criteria criteria = example.createCriteria();
    criteria.andSendStateEqualTo(SystemConstants.WECHAT_MESSAGE_LOG_SEND_STATE_FAIL)
      .andResultInfoLike("invalid openid hint" + "%")
      .andCreateDateGreaterThanOrEqualTo(DateUtils.getTodayStartTime(nowDate))
      .andIsResendEqualTo(SystemConstants.WECHAT_MESSAGE_LOG_IS_RESEND_YES);

    List<WechatMessageLogPO> list = this.wechatMessageLogPOMapper.selectByExample(example);
    if (CollectionUtils.isNotEmpty(list)) {
      logger.info("WechatMessageTaskOpenIdErrorImpl.reSendMessage总数：" + list.size());
      for (WechatMessageLogPO wechatMessageLogPO : list) {
        try {
          this.wXTemplateMessageManagerService.dealReSendMessage(wechatMessageLogPO);
        } catch (Exception e) {
          logger.error("WechatMessageTaskOpenIdErrorImpl.reSendMessageAll微信模板消息重发异常");
          e.printStackTrace();
        }
      }
    }

  }

}
