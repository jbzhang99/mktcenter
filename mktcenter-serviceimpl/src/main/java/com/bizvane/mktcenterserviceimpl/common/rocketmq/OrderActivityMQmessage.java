package com.bizvane.mktcenterserviceimpl.common.rocketmq;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.openservices.ons.api.Action;
import com.aliyun.openservices.ons.api.ConsumeContext;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.MessageListener;
import com.bizvane.members.facade.models.OrderModel;
import com.bizvane.members.facade.models.OrderServeModel;
import com.bizvane.mktcenterservice.interfaces.ActivityOrderService;
import com.bizvane.mktcenterservice.models.bo.OrderModelBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 消费活动
 * Created by agan on 2018/8/27.
 */
@Component
public class OrderActivityMQmessage implements MessageListener {
    @Autowired
    private ActivityOrderService activityOrderService;
    @Override
    public Action consume(Message message, ConsumeContext consumeContext) {
        //获取订单信息
        String modelStr= new String(message.getBody());
        OrderModel model = JSONObject.parseObject(modelStr, OrderModel.class);
        OrderModelBo bo = new OrderModelBo();
        bo.setMemberCode(Long.parseLong(model.getMemberCode()));
        bo.setBrandId(Math.toIntExact(model.getBrandId()));
        bo.setOrderFrom(model.getOrderFrom());
        bo.setServiceStoreId(model.getServiceStoreId());
        bo.setPayMoney(model.getPayMoney());
        //缺少字段 店铺
        activityOrderService.executeOrder(bo);
        //如果想测试消息重投的功能,可以将Action.CommitMessage 替换成Action.ReconsumeLater
        return Action.CommitMessage;
    }
}
