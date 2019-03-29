package com.bizvane.messageservice.service.impl.messagelisterner;

import com.aliyun.openservices.ons.api.Action;
import com.aliyun.openservices.ons.api.ConsumeContext;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.MessageListener;
import com.bizvane.messageservice.common.constants.SystemConstants;
import com.bizvane.messageservice.service.RocketLogService;
import com.bizvane.messageservice.service.SendSmsOrderOfflineConsumeService;
import com.bizvane.messagefacade.models.po.RocketLogPO;
import com.bizvane.messagefacade.models.po.RocketLogPOExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author xiao.shu
 * @date on 2018/8/9 18:19
 * @description
 *
 */
@Component
public class SendSmsOrderOfflineListener implements MessageListener {
    private static final Logger logger = LoggerFactory.getLogger(SendSmsOrderOfflineListener.class);
   @Autowired
    private RocketLogService rocketLogService;
    @Resource(name="sendSmsTemplateMessageOrderOfflineServiceImpl")
   private SendSmsOrderOfflineConsumeService sendSmsOrderOfflineConsumeService;

    @Override
    public Action consume(Message message, ConsumeContext consumeContext) {
        logger.info("SendSmsTemplateMessageOrderOfflineServiceImpl,topic:"+message.getTopic()+",messageId:"+message.getMsgID());
//        
//        Runnable runnable = new ThreadExtend("sendSmsOrderOfflineListener", "sendMemberCustomer", message);
//        ThreadPool.run(runnable);
//        return Action.CommitMessage;
//    }
//
//    public  void sendMemberCustomer(Object objectParam){
//        Message message = (Message) objectParam;
      String messageBody= null;
      try {
         messageBody= new String(message.getBody(),SystemConstants.CHARSET);
      }catch (Exception e){
         e.getStackTrace();
      }
        String msgId = message.getMsgID();
        RocketLogPO rocketLogPO = new RocketLogPO();
        rocketLogPO.setSendState(SystemConstants.ROCKET_LOG_SEND_STATE_CONSUMER_SUCCESS);
        RocketLogPOExample rocketLogPOExample = new RocketLogPOExample();
        rocketLogPOExample.createCriteria().andMessageIdEqualTo(msgId);
        rocketLogService.update(rocketLogPO,rocketLogPOExample);
        sendSmsOrderOfflineConsumeService.sendMessage(msgId,messageBody);
        return Action.CommitMessage;
    }
}
