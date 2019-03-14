package com.bizvane.messageservice.autotask.impl;

import com.bizvane.messageservice.autotask.IWechatMessageTask;
import com.bizvane.messageservice.common.constants.SysRespConstants;
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
public class WechatMessageTaskAccessTokenErrorImpl implements IWechatMessageTask {

  @Autowired
  private WechatMessageLogPOMapper wechatMessageLogPOMapper;
  
  @Autowired
  private WXTemplateMessageManagerService wXTemplateMessageManagerService;
  
  private static final Logger logger = LoggerFactory.getLogger(WechatMessageTaskAccessTokenErrorImpl.class);
  
//  @Scheduled(cron="0 0/4 8-22 * * ?") 
  @Override
  public void reSendMessage() {
    
    logger.info("WechatMessageTaskAccessTokenErrorImpl.reSendMessage.自动任务开始执行");
    WechatMessageLogPOExample example = new WechatMessageLogPOExample();
    Date nowDate = new Date();
    
    WechatMessageLogPOExample.Criteria criteria = example.createCriteria();
    criteria.andSendStateEqualTo(SystemConstants.WECHAT_MESSAGE_LOG_SEND_STATE_FAIL)
      .andResultInfoEqualTo(SysRespConstants.WX_ACCESS_TOKEN_NOT_EMPTY.getMsg())
      .andCreateDateGreaterThanOrEqualTo(DateUtils.getTodayStartTime(nowDate))
      .andIsResendEqualTo(SystemConstants.WECHAT_MESSAGE_LOG_IS_RESEND_YES);
    example.or().andSendStateEqualTo(SystemConstants.WECHAT_MESSAGE_LOG_SEND_STATE_FAIL)
      .andResultInfoLike("access_token" + "%")
      .andCreateDateGreaterThanOrEqualTo(DateUtils.getTodayStartTime(nowDate))
      .andIsResendEqualTo(SystemConstants.WECHAT_MESSAGE_LOG_IS_RESEND_YES);

    List<WechatMessageLogPO> list = this.wechatMessageLogPOMapper.selectByExample(example);
    if (CollectionUtils.isNotEmpty(list)) {
      logger.info("WechatMessageTaskAccessTokenErrorImpl.reSendMessage总数：" + list.size());
      for (WechatMessageLogPO wechatMessageLogPO : list) {
        try {
          this.wXTemplateMessageManagerService.dealReSendMessage(wechatMessageLogPO);
        } catch (Exception e) {
          logger.error("WXTemplateMessageManagerServiceImpl.reSendMessageAll微信模板消息重发异常");
          e.printStackTrace();
        }
      }
    }

  }

}
