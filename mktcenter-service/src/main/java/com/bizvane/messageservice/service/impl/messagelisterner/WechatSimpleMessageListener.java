package com.bizvane.messageservice.service.impl.messagelisterner;

import com.aliyun.openservices.ons.api.Action;
import com.aliyun.openservices.ons.api.ConsumeContext;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.MessageListener;
import com.bizvane.messageservice.common.constants.SystemConstants;
import com.bizvane.messageservice.service.RocketLogService;
import com.bizvane.messageservice.service.WXTemplateMessageService;
import com.bizvane.messagefacade.models.po.RocketLogPO;
import com.bizvane.messagefacade.models.po.RocketLogPOExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;

/**
 * MQ消息处理类
 */
@Component
public class WechatSimpleMessageListener implements MessageListener {
  
  @Resource(name="wXTemplateMessageOfflineTradeServiceImpl")
  private WXTemplateMessageService wxTemplateMessageService;
  
  @Autowired
  private RocketLogService rocketLogService;
  
  private static final Logger logger = LoggerFactory.getLogger(WechatSimpleMessageListener.class);
  
    @Override
    public Action consume(Message message, ConsumeContext consumeContext) {
      
      logger.info("WechatSimpleMessageListenerImpl消费消息 topic:" + message.getTopic() + " messageId:" + message.getMsgID());
//        
//      Runnable runnable = new ThreadExtend("wechatSimpleMessageListener", "deal", message);
//      ThreadPool.run(runnable);
//        //如果想测试消息重投的功能,可以将Action.CommitMessage 替换成Action.ReconsumeLater
//      return Action.CommitMessage;
//    }
//    
//    public void deal(Object objectParam) {
//      
//      Message message = (Message) objectParam;
      String messageBody = null;
      try {
          messageBody = new String(message.getBody(), SystemConstants.CHARSET);
      } catch (UnsupportedEncodingException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      
      String msgId = message.getMsgID();
      
      RocketLogPO record = new RocketLogPO();
      record.setSendState(SystemConstants.ROCKET_LOG_SEND_STATE_CONSUMER_SUCCESS);
      
      RocketLogPOExample example = new RocketLogPOExample();
      example.createCriteria().andMessageIdEqualTo(msgId);

      rocketLogService.update(record, example);
      
     wxTemplateMessageService.sendMessage(msgId, messageBody);
     return Action.CommitMessage;
    }
}
