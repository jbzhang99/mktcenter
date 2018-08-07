package com.bizvane.mktcenterserviceimpl.common.rocketmq;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.openservices.ons.api.Action;
import com.aliyun.openservices.ons.api.ConsumeContext;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.MessageListener;
import com.bizvane.members.facade.models.OrderServeModel;
import com.bizvane.mktcenterservice.interfaces.TaskService;
import com.bizvane.mktcenterservice.models.vo.TaskDetailVO;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: lijunwei
 * @Time: 2018/8/5 23:15
 * 监控订单
 */
@Component
public class OrderTaskListener implements MessageListener {

    @Autowired
    private TaskService taskService;
    @Override
    public Action consume(Message message, ConsumeContext consumeContext) {
        //获取订单信息
        String modelStr= new String(message.getBody());

//        private String memberCode; //会员code
//        private String carNo; //会员卡号
//        private Long companyId;//公司id
//        private Long brandId;//品牌id
//        private Long mbrOrderId;// 订单id
//        private BigDecimal tradeAmount;//消费金额
//        private Date placeOrderTime;//消费时间

        OrderServeModel orderServeModel1 = JSONObject.parseObject(modelStr, OrderServeModel.class);
        List<TaskDetailVO> tasklists = taskService.getTaskDetailByTaskId(null);
        if (CollectionUtils.isNotEmpty(tasklists)){
            tasklists.stream().forEach(obj->{
             //判断订单时间

            //判断订单累计金额

           //判断消费次数

            });
        }


        //如果想测试消息重投的功能,可以将Action.CommitMessage 替换成Action.ReconsumeLater
        return Action.CommitMessage;
    }

}

