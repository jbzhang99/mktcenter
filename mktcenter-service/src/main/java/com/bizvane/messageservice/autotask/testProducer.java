package com.bizvane.messageservice.autotask;

import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.exception.MQClientException;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.producer.SendResult;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.common.message.Message;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.remoting.exception.RemotingException;

public class testProducer {
		
		public static void main(String[] args) throws MQClientException, RemotingException, MQBrokerException, InterruptedException {
			
			DefaultMQProducer producer=new DefaultMQProducer("TopicTest");
			producer.setNamesrvAddr("192.168.2.18:9876"); 
			producer.start(); 
			Message msg=null; 
			for (int i = 0; i < 100; i++) {
			 
//			   msg=new Message("orders",null, ("orders"+i).getBytes()); 
			   
			    msg = new Message("TopicTest","TagB",("orders"+i).getBytes()); 
			    msg.setKeys(String.valueOf(i));
					SendResult result = producer.send(msg); 
					System.out.println(msg); System.out.println(result); 
					Thread.sleep(1500); 
			  } 
			}
		} 
