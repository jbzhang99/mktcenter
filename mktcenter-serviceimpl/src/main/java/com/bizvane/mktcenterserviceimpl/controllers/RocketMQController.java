package com.bizvane.mktcenterserviceimpl.controllers;

import com.aliyun.openservices.ons.api.Producer;
import com.bizvane.mktcenterserviceimpl.common.constants.SystemConstants;
import com.bizvane.mktcenterserviceimpl.common.rocketmq.RocketMQManager;
import com.bizvane.mktcenterserviceimpl.common.rocketmq.RocketMQProducerService;
import com.bizvane.utils.responseinfo.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

/**
 * @author chen.li
 * @date on 2018/7/27 13:28
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@RestController
@RequestMapping("rocketMQ")
public class RocketMQController {

    @Autowired
    private RocketMQProducerService rocketMQProducerService;

    /**
     * 生产消息
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping("produceMsg")
    public ResponseData<String> produceMsg() throws UnsupportedEncodingException {
        String messageBody = "hello world";
        byte[] bytes = messageBody.getBytes(SystemConstants.CHARSET);
        String topic = "public_bizvane_message";
        String tag = "register_tag";
        Producer producer = RocketMQManager.getProducer("memberRegisterListener");
        ResponseData<String> stringResponseData = rocketMQProducerService.sendMessage(producer, topic, tag, bytes);
        System.out.println(stringResponseData);
        return stringResponseData;
    }
}
