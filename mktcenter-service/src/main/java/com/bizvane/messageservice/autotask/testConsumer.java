package com.bizvane.messageservice.autotask;

import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.exception.MQClientException;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.common.message.MessageExt;
import com.bizvane.messageservice.service.impl.messagelisterner.smsGenTemplateMessageListener;

import java.util.List;

public class testConsumer { 
	public static void main(String[] args) throws MQClientException { 
		DefaultMQPushConsumer consumer=new DefaultMQPushConsumer("TopicTest"); 
		consumer.setNamesrvAddr("192.168.2.18:9876"); //开始订阅指定topic和tag的消息 
//		consumer.subscribe("orders", ""); //设置从什么位置开始读取消息 
		 
        consumer.subscribe("TopicTest", "TagB"); // 订阅PushTopic下Tag为push的消息,都订阅消息  
        
        // 程序第一次启动从消息队列头获取数据  
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);  
        //可以修改每次消费消息的数量，默认设置是每次消费一条  
        // consumer.setConsumeMessageBatchMaxSize(10);  
		 //注册监听器 
		consumer.registerMessageListener(new MessageListenerConcurrently() { 
			@Override 
			public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext arg1) {
				
				smsGenTemplateMessageListener listener = new smsGenTemplateMessageListener();
				MessageExt msg = list.get(0); 
				System.out.println(new String(msg.getBody())); 
				
				Message Message =new Message();
				Message.setBody(msg.getBody());
				listener.consume(Message, null).toString();
				
//				return ConsumeConcurrentlyStatus.valueOf(listener.consume(null, null).toString());
//			 MessageExt msg = list.get(0); System.out.println(new String(msg.getBody())); 
			return ConsumeConcurrentlyStatus.CONSUME_SUCCESS; } 
			}); //开始消费 
               consumer.start(); 
               
	}
  }

