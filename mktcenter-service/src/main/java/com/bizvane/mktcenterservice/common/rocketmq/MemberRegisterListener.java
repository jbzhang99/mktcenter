package com.bizvane.mktcenterservice.common.rocketmq;

import com.aliyun.openservices.ons.api.Action;
import com.aliyun.openservices.ons.api.ConsumeContext;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.MessageListener;
import org.springframework.stereotype.Component;

/**
 * @author chen.li
 * @date on 2018-7-17 16:26:14
 * @description
 *
 */
@Component
public class MemberRegisterListener implements MessageListener {

    @Override
    public Action consume(Message message, ConsumeContext consumeContext) {
        String s = new String(message.getBody());
        System.out.println(s);
        System.out.println("===============");
        System.out.println(consumeContext.toString());

        //如果想测试消息重投的功能,可以将Action.CommitMessage 替换成Action.ReconsumeLater
        return Action.CommitMessage;
    }

}
