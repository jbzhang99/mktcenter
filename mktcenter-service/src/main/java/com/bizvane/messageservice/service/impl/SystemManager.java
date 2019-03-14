package com.bizvane.messageservice.service.impl;

import com.bizvane.couponservice.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SystemManager implements ApplicationRunner {

  @Autowired
  private DictService dictService;

  @Autowired
  private RocketMQManager rocketMQManager;
  @Autowired
  private RocketMQManagerUat rocketMQManagerUat;
  
  @Value("${rocketmq.environment}")
  private String environment;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    // TODO Auto-generated method stub
    dictService.init();
    rocketMQManager.initMQuatNew();
//    if(environment.equals("uat")) {
//      rocketMQManager.initMQuat();
//    }else {
//      rocketMQManager.initMQ();
//    }
  }
}
