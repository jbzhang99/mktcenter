package com.bizvane.mktcenterserviceimpl.common.rocketmq;

import com.aliyun.openservices.ons.api.*;
import com.bizvane.mktcenterservice.models.po.RocketConfigPO;
import com.bizvane.mktcenterservice.models.po.RocketConfigPOExample;
import com.bizvane.mktcenterserviceimpl.common.constants.RocketConstants;
import com.bizvane.mktcenterserviceimpl.common.utils.SpringContextUtil;
import com.bizvane.mktcenterserviceimpl.mappers.RocketConfigPOMapper;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * RocketMQ管理类
 * @author 董争光
 * 2018年5月21日下午2:01:31
 */

@Component
//@EnableApolloConfig({"RocketMQManager"})
public class RocketMQManager implements ApplicationRunner {

  @Value("${rocketmq.onsaddr}")
  private String onsaddr;
  
  @Value("${rocketmq.accessKey}")
  private String accessKey;
  
  @Value("${rocketmq.secretKey}")
  private String secretKey;

  @Value("${spring.application.name}")//mktcenter
  private String modelName;
  
  @Value("${rocketmq.environment}")
  private String environment;
  
  @Value("${rocketmq.addr}")
  private String addr;

  @Autowired
  private RocketConfigPOMapper rocketConfigPOMapper;
  
  private static Map<String, Producer> producerMap = new HashMap<>();

  @Override
  public void run(ApplicationArguments args) throws Exception {
    initMQ();
  }

  /**
   * 初始化rocketMQ
   */
  public void initMQ() {
    
    RocketConfigPOExample example = new RocketConfigPOExample();
    //mktcenter
    example.createCriteria().andModelNameEqualTo(modelName).andValidEqualTo(Boolean.TRUE);
    
    List<RocketConfigPO> rocketConfigPOList = rocketConfigPOMapper.selectByExample(example);
    
    if (CollectionUtils.isNotEmpty(rocketConfigPOList)) {
      for (RocketConfigPO rocketConfigPO : rocketConfigPOList) {
        if (RocketConstants.ROCKET_CONFIG_ROLE_TYPE_PRODUCER.equals(rocketConfigPO.getRoleType())) {
          Properties properties = getProperties();
          properties.setProperty(PropertyKeyConst.ProducerId, rocketConfigPO.getRoleId());
          if(environment.equals("uat")) {

        	  properties.setProperty("NAMESRV_ADDR", addr);
        	  
          }
          Producer producer = ONSFactory.createProducer(properties);
          producer.start();
          
          producerMap.put(rocketConfigPO.getBusinessType(), producer);
        } else if (RocketConstants.ROCKET_CONFIG_ROLE_TYPE_CONSUMER.equals(rocketConfigPO.getRoleType())) {
          Properties properties = getProperties();
          properties.setProperty(PropertyKeyConst.ConsumerId, rocketConfigPO.getRoleId());
          if(environment.equals("uat")) {
        	  properties.setProperty("NAMESRV_ADDR", addr);
        	  
          }
          
          Consumer consumer = ONSFactory.createConsumer(properties);
          
          
          
          MessageListener messageListener = (MessageListener) SpringContextUtil.getBean(rocketConfigPO.getMessageListenerBean());
          consumer.subscribe(rocketConfigPO.getTopic(), rocketConfigPO.getTag(), messageListener);

          consumer.start();
        }
      }
    }

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
