package com.bizvane.mktcenterservice.common.rocketmq;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.openservices.ons.api.Action;
import com.aliyun.openservices.ons.api.ConsumeContext;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.MessageListener;
import com.bizvane.members.facade.models.MemberCardLevelModel;
import com.bizvane.members.facade.models.OrderModel;
import com.bizvane.members.facade.service.api.MemberCardProgramApiService;
import com.bizvane.members.facade.service.api.MemberOrderApiService;
import com.bizvane.mktcenterfacade.interfaces.ActivityOrderService;
import com.bizvane.mktcenterfacade.models.bo.OrderModelBo;
import com.bizvane.utils.responseinfo.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 消费活动
 */
@Component
@Slf4j
public class OrderActivityMQmessage implements MessageListener {
    @Autowired
    private ActivityOrderService activityOrderService;
    @Autowired
    private MemberCardProgramApiService memberCardProgramApiService;
    @Autowired
    private MemberOrderApiService memberOrderApiService;
    @Override
    public Action consume(Message message, ConsumeContext consumeContext) {
        //获取订单信息
        String modelStr= new String(message.getBody());
        OrderModel model = JSONObject.parseObject(modelStr, OrderModel.class);
        log.info("MQ消息队列获取参数是+======="+ JSON.toJSONString(model));
        OrderModelBo bo = new OrderModelBo();
        bo.setMemberCode(model.getMemberCode());
        bo.setBrandId((long) Math.toIntExact(model.getBrandId()));
        bo.setOrderFrom(model.getOrderFrom());
        bo.setServiceStoreId(model.getServiceStoreId());
        bo.setPayMoney(model.getPayMoney());
        //会员等级id
        log.info("开始查询会员等级======="+ bo.toString());
        ResponseData<MemberCardLevelModel>  memberCardLevelModel =memberCardProgramApiService.queryMemberCardInfo(model.getMemberCode());
        bo.setLevelId(memberCardLevelModel.getData().getLevelId());
        //
        bo.setMemberType(0);
        log.info("查询会员等级完成+======="+ memberCardLevelModel.getData().getLevelId());
        //商品编码
        ResponseData<String> productNossu = memberOrderApiService.queryOrderProductNo(model.getOrderNo());
        bo.setProductNos(productNossu.getData());
        log.info("查询会员等级完成+======="+ productNossu.getData());
        //店铺code
        log.info("开始执行执行消费活动++++++++++++++=======");
        activityOrderService.executeOrder(bo);
        //如果想测试消息重投的功能,可以将Action.CommitMessage 替换成Action.ReconsumeLater
        return Action.CommitMessage;
    }
}
