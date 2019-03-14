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
public class RocketMQManagerUat {

  /*@Value("${rocketmq.onsaddr}")
  private String onsaddr;*/
  
  @Value("${rocketmq.accessKey}")
  private String accessKey;
  
  @Value("${rocketmq.secretKey}")
  private String secretKey;
  
  @Value("${rocketmq.consumerStatus}")
  private String consumerStatus;
  
  @Autowired
  private RocketConfigPOMapper rocketConfigPOMapper;
  
  private static Map<String, Producer> producerMap = new HashMap<>();
  private static final Logger logger = LoggerFactory.getLogger(RocketMQManagerUat.class);


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
					properties.setProperty("NAMESRV_ADDR", "192.168.2.18:9876");
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
										properties.setProperty("NAMESRV_ADDR", "192.168.2.18:9876");
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
    //properties.setProperty(PropertyKeyConst.ONSAddr, onsaddr);
    
    return properties;
  }
  
  public static Producer getProducer(String businessType) {
    return producerMap.get(businessType);
  }

}
