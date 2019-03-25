//package com.bizvane.couponservice.kafka.consumer;
//
//import com.bizvane.couponservice.common.utils.CouponSpringContextUtil;
//import com.bizvane.utils.kafkautils.KafkaConsumerClient;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.apache.kafka.clients.consumer.ConsumerRecords;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import java.util.function.Consumer;
//
///**
// * @Author: houkai
// * @Date: 2018/8/13 20:08
// * @Description:
// */
//@ConfigurationProperties(prefix = "spring.kafka.consumer")
//@Component
//@Slf4j
//public class KafkaConsumerHandler implements ApplicationRunner {
//
//	private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerHandler.class);
//
//	@Autowired
//	private KafkaConsumerClient<String> kafkaConsumerClient;
//
//	private List<String> topics = new ArrayList<>();
//
//	private Long timeout;
//
//	public List<String> getTopics() {
//		return this.topics;
//	}
//
//	public void setTopics(List<String> topics) {
//		this.topics = topics;
//	}
//
//	public Long getTimeout() {
//		return this.timeout;
//	}
//
//	public void setTimeout(Long timeout) {
//		this.timeout = timeout;
//	}
//
//	@Override
//	public void run(ApplicationArguments args) throws Exception {
//		logger.info("enter kafkaConsumerClient 启动");
//
//		/*
//		 * this.kafkaConsumerClient.receive(this.topics, this.timeout, x -> x.forEach(y
//		 * -> { if (this.topics.get(0).equals(y.topic())) {
//		 *
//		 * } else if (this.topics.get(1).equals(y.topic())) { // 业务处理
//		 * System.out.println(y.key() + "+++++" + y.value()); } else if
//		 * (this.topics.get(2).equals(y.topic())) { // 业务处理 System.out.println(y.key() +
//		 * "+++++" + y.value()); } }));
//		 */
//		new Thread(() -> {
//			this.kafkaConsumerClient.receive(this.topics, this.timeout,
//					new Consumer<ConsumerRecords<String, String>>() {
//						@Override
//						public void accept(ConsumerRecords<String, String> stream) {
//							Iterator<ConsumerRecord<String, String>> iterator = stream.iterator();
//							;
//
//							while (iterator.hasNext()) {
//								ConsumerRecord<String, String> record = iterator.next();
//								String key = record.key();
//								// COUPON_OFFLINE_USE_SIT 测试环境会加sit
//								String topic = record.topic().replaceAll("_SIT", "");
//								String value = record.value();
//
//								logger.info("enter kafkaConsumerClient kafkaConsumerClient method! value:{}", topic);
//
//								KafkaConsumerService kafkaConsumerService = (KafkaConsumerService) (CouponSpringContextUtil
//										.getBean("KAFKA_TOPIC_" + topic));
//								kafkaConsumerService.consumer(topic, key, value);
//							}
//
//						}
//
//					});
//		}).start();
//	}
//}
