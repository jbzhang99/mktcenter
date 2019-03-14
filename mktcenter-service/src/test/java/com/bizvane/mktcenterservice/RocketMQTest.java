//package com.bizvane.mktcenterservice;
//
//import com.aliyun.openservices.ons.api.Producer;
//import MktcenterApplication;
//import RocketConstants;
//import RocketMQManager;
//import RocketMQProducerService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.ApplicationContext;
//import org.springframework.test.context.junit4.SpringRunner;
//
///**
// * @author chen.li
// * @date on 2018/7/17 16:35
// * @description
// * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes={MktcenterApplication.class})
//public class RocketMQTest {
//
//    @Autowired
//    private RocketMQProducerService rocketMQProducerService;
//
//    @Autowired
//    private ApplicationContext context;
//    @Test
//    public void test1(){
//        String topic = "public_bizvane_message";
//        String tag = "register_tag";
//        String content = "lichen";
//        byte[] bytes = content.getBytes();
//        //  public static final String ROCKET_CONFIG_BUSINESS_TYPE_REGISTER_SIMPLE_MESSAGE = "memberRegisterListener";`
//        Producer producer = RocketMQManager.getProducer(RocketConstants.ROCKET_CONFIG_BUSINESS_TYPE_REGISTER_SIMPLE_MESSAGE);
//        rocketMQProducerService.sendMessage(producer,topic,tag,bytes);
//    }
//}
