package com.bizvane.messageservice.service.impl.messagelisterner;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.openservices.ons.api.Action;
import com.aliyun.openservices.ons.api.ConsumeContext;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.MessageListener;
import com.bizvane.messageservice.common.constants.SystemConstants;
import com.bizvane.messageservice.common.utils.MessageSpringContextUtil;
import com.bizvane.messageservice.mappers.RocketConfigPOMapper;
import com.bizvane.messagefacade.models.po.RocketConfigPO;
import com.bizvane.messagefacade.models.po.RocketConfigPOExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * 模板消息
 * Created by yunjie.tian on 2018/7/28.
 */
@Component
public class AllMessageListener implements MessageListener {

    private static final Logger logger = LoggerFactory.getLogger(AllMessageListener.class);
    @Autowired
    private RocketConfigPOMapper rocketConfigPOMapper;
    
    @Override
    public Action consume(Message message, ConsumeContext consumeContext) {
        logger.info("AllMessageListener消费消息 Tag:" + message.getTag() + " messageId:" + message.getMsgID());
        
        try {
            JSONObject jsonObject = JSON.parseObject(new String(message.getBody(), SystemConstants.CHARSET));
            String beanName = jsonObject.getString("bussinessType");
//            TODO
            RocketConfigPOExample example = new RocketConfigPOExample();
            example.createCriteria().andBusinessTypeEqualTo(beanName).andModelNameEqualTo("message").andValidEqualTo(Boolean.TRUE);
            List<RocketConfigPO> rocketConfigPOList = rocketConfigPOMapper.selectByExample(example);
            
        	Object messageListener = (Object) MessageSpringContextUtil.getBean(rocketConfigPOList.get(0).getMessageListenerBean());
        	return	((MessageListener) messageListener).consume( message, consumeContext);
        } catch (UnsupportedEncodingException e) {
        	  logger.info("AllMessageListener消费有误有误有误有误消息 Tag:" + message.getTag() + " messageId:" + message.getMsgID());
            e.printStackTrace();
        }
        
        return Action.CommitMessage;
    }


}


