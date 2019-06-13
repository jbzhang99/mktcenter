package com.bizvane.messageservice.service.impl;

import com.aliyun.openservices.ons.api.*;
import com.bizvane.messageservice.common.constants.SystemConstants;
import com.bizvane.messageservice.common.utils.MessageSpringContextUtil;
import com.bizvane.messageservice.mappers.RocketConfigPOMapper;
import com.bizvane.messagefacade.models.po.RocketConfigPO;
import com.bizvane.messagefacade.models.po.RocketConfigPOExample;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * RocketMQ管理类
 * @author 董争光
 * 2018年5月21日下午2:01:31
 */
@Service
public class RocketMQManager {

  @Value("${rocketmq.onsaddr}")
  private String onsaddr;
  
  @Value("${rocketmq.accessKey}")
  private String accessKey;
  
  @Value("${rocketmq.secretKey}")
  private String secretKey;
  
  @Value("${rocketmq.consumerStatus}")
  private String consumerStatus;
  
  @Value("${rocketmq.addr}")
  private String addr;
  
  @Value("${rocketmq.environment}")
  private String environment;
  
  @Value("${rocketmq.topic}")
  private String topic;
  
  @Value("${rocketmq.producerId}")
  private String producerId;
  
  @Value("${rocketmq.consumerId}")
  private String consumerId;
  
  @Autowired
  private RocketConfigPOMapper rocketConfigPOMapper;
  
  private static Map<String, Producer> producerMap = new HashMap<>();
  private static final Logger logger = LoggerFactory.getLogger(RocketMQManager.class);

  public void initMQuatNew() {
	  
	//慢点起动；  
      try {
          Thread.sleep(1000);
      } catch (InterruptedException e) {
          e.printStackTrace(); 
      }
//	 发布者对象，可以通过该对象接口发送普通消息，发送定时/延时消息。
//	  线程安全性: 本接口的实现类都是线程安全的，可以多线并发发送消息。
//	  一个实例可以发送多个主题的消息。
//	  正常情况下，一个实例足够高效完成本模块的发送任务，无需创建多个实例
		Properties propertiesproducer = getProperties();
		propertiesproducer.setProperty(PropertyKeyConst.ProducerId,producerId);
	    if(environment.equals("uat")) {
	    	propertiesproducer.setProperty("NAMESRV_ADDR", addr);
	    }
		//设置发送超时时间，单位毫秒 
		propertiesproducer.setProperty(PropertyKeyConst.SendMsgTimeoutMillis, "3000");
		Producer producer = ONSFactory.createProducer(propertiesproducer);
		producer.start();
		logger.info( "生产初始化成功。");
		producerMap.put(topic, producer);
//		  正常情况下，一个实例足够高效完成本模块的发送任务，无需创建多个实例	  
	    
		//消息者初始化
		          if (consumerStatus.equals("true")) {
						Properties properties = getProperties();
						properties.setProperty(PropertyKeyConst.ConsumerId, consumerId);
					    if(environment.equals("dev")) {
					    	properties.setProperty("NAMESRV_ADDR", addr);
					    }
				        /** * 设置消费端线程数20*/
				        properties.put(PropertyKeyConst.ConsumeThreadNums,"25");
						Consumer consumer = ONSFactory.createConsumer(properties);
						MessageListener messageListener = (MessageListener) MessageSpringContextUtil
								.getBean("allMessageListener");
						consumer.subscribe(topic, "*",
								messageListener);
						consumer.start();
						logger.info( "ALL消费者初始化成功。");
					}

	  }
  /**
   * 初始化rocketMQ
   */
  public void initMQ() {
    
    RocketConfigPOExample example = new RocketConfigPOExample();
    example.createCriteria().andModelNameEqualTo("message").andValidEqualTo(Boolean.TRUE);
    
    List<RocketConfigPO> rocketConfigPOList = rocketConfigPOMapper.selectByExample(example);
    
//    创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
    ExecutorService fixedThreadPool = Executors.newCachedThreadPool(); 
		if (CollectionUtils.isNotEmpty(rocketConfigPOList)) {
			for (RocketConfigPO rocketConfigPO : rocketConfigPOList) {
				if (SystemConstants.ROCKET_CONFIG_ROLE_TYPE_PRODUCER.equals(rocketConfigPO.getRoleType())) {
					Properties properties = getProperties();
					properties.setProperty(PropertyKeyConst.ProducerId, rocketConfigPO.getRoleId());
					// 连接报错，继续尝试
					fixedThreadPool.execute(new Runnable() {
						public void run() {
							try {

								int i = 0;
								while (i < 30) {
									try {
										Producer producer = ONSFactory.createProducer(properties);
										producer.start();
										producerMap.put(rocketConfigPO.getBusinessType(), producer);
										logger.info(rocketConfigPO.getBusinessType() + "生产者初始化成功。");
										i = 30;
									} catch (Exception e) {

										logger.error(rocketConfigPO.getBusinessType() + "生产者初始化失败，有可能是连接不到服务器！"
												+ "失败次数:" + i + e.getMessage());
										i++;
										Thread.sleep(1000);
									}

								}

							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					});

				} else if (consumerStatus.equals("true")&&SystemConstants.ROCKET_CONFIG_ROLE_TYPE_CONSUMER.equals(rocketConfigPO.getRoleType())) {
					fixedThreadPool.execute(new Runnable() {
						public void run() {
							try {
								int i = 0;
								while (i < 30) {
									try {
										Properties properties = getProperties();
										properties.setProperty(PropertyKeyConst.ConsumerId, rocketConfigPO.getRoleId());
										Consumer consumer = ONSFactory.createConsumer(properties);
										MessageListener messageListener = (MessageListener) MessageSpringContextUtil
												.getBean(rocketConfigPO.getMessageListenerBean());
										consumer.subscribe(rocketConfigPO.getTopic(), rocketConfigPO.getTag(),
												messageListener);
										consumer.start();
										logger.info(rocketConfigPO.getBusinessType() + "消费者初始化成功。");
										i = 30;
									} catch (Exception e) {
										i++;
										logger.error(rocketConfigPO.getBusinessType() + "消费者初始化失败，有可能是连接不到服务器！"
												+ "失败次数:" + i + e.getMessage());
										Thread.sleep(1000);
									}

								}
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					});

				}
			}
		}
		//关闭线程池
		fixedThreadPool.shutdown();

  }
  
  public void initMQuat() {
	    
	    RocketConfigPOExample example = new RocketConfigPOExample();
	    example.createCriteria().andModelNameEqualTo("message").andValidEqualTo(Boolean.TRUE);
	    
	    List<RocketConfigPO> rocketConfigPOList = rocketConfigPOMapper.selectByExample(example);
	    
//	    创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
	    ExecutorService fixedThreadPool = Executors.newCachedThreadPool(); 
			if (CollectionUtils.isNotEmpty(rocketConfigPOList)) {
				for (RocketConfigPO rocketConfigPO : rocketConfigPOList) {
					if (SystemConstants.ROCKET_CONFIG_ROLE_TYPE_PRODUCER.equals(rocketConfigPO.getRoleType())) {
						Properties properties = getProperties();
						properties.setProperty(PropertyKeyConst.ProducerId, rocketConfigPO.getRoleId());
						properties.setProperty("NAMESRV_ADDR", addr);
						// 连接报错，继续尝试
						fixedThreadPool.execute(new Runnable() {
							public void run() {
								try {

									int i = 0;
									while (i < 30) {
										try {
											Producer producer = ONSFactory.createProducer(properties);
											producer.start();
											producerMap.put(rocketConfigPO.getBusinessType(), producer);
											logger.info(rocketConfigPO.getBusinessType() + "生产者初始化成功。");
											i = 30;
										} catch (Exception e) {

											logger.error(rocketConfigPO.getBusinessType() + "生产者初始化失败，有可能是连接不到服务器！"
													+ "失败次数:" + i + e.getMessage());
											i++;
											Thread.sleep(1000);
										}

									}

								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						});

					} else if (consumerStatus.equals("true")&&SystemConstants.ROCKET_CONFIG_ROLE_TYPE_CONSUMER.equals(rocketConfigPO.getRoleType())) {
						fixedThreadPool.execute(new Runnable() {
							@Override
							public void run() {
								try {
									int i = 0;
									while (i < 30) {
										try {
											Properties properties = getProperties();
											properties.setProperty(PropertyKeyConst.ConsumerId, rocketConfigPO.getRoleId());
											properties.setProperty("NAMESRV_ADDR", addr);
											Consumer consumer = ONSFactory.createConsumer(properties);
											MessageListener messageListener = (MessageListener) MessageSpringContextUtil
													.getBean(rocketConfigPO.getMessageListenerBean());
											consumer.subscribe(rocketConfigPO.getTopic(), rocketConfigPO.getTag(),
													messageListener);
											consumer.start();
											logger.info(rocketConfigPO.getBusinessType() + "消费者初始化成功。");
											i = 30;
										} catch (Exception e) {
											i++;
											logger.error(rocketConfigPO.getBusinessType() + "消费者初始化失败，有可能是连接不到服务器！"
													+ "失败次数:" + i + e.getMessage());
											Thread.sleep(1000);
										}

									}
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						});

					}
				}
			}
			//关闭线程池
			fixedThreadPool.shutdown();

	  }

  private Properties getProperties() {
    Properties properties = new Properties();
    properties.setProperty(PropertyKeyConst.AccessKey, accessKey);
    properties.setProperty(PropertyKeyConst.SecretKey, secretKey);
    properties.setProperty(PropertyKeyConst.ONSAddr, onsaddr);
    
    return properties;
  }
  
  public static Producer getProducer(String businessType) {
    return producerMap.get(businessType);
  }

}
