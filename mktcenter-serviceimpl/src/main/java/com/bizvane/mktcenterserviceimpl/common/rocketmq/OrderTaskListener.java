package com.bizvane.mktcenterserviceimpl.common.rocketmq;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.openservices.ons.api.Action;
import com.aliyun.openservices.ons.api.ConsumeContext;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.MessageListener;
import com.bizvane.members.facade.models.OrderServeModel;
import com.bizvane.mktcenterservice.interfaces.TaskRecordService;
import com.bizvane.mktcenterservice.interfaces.TaskService;
import com.bizvane.mktcenterservice.models.bo.TaskOrderAwardBO;
import com.bizvane.mktcenterservice.models.po.MktTaskRecordPO;
import com.bizvane.mktcenterservice.models.vo.TaskDetailVO;
import com.bizvane.mktcenterserviceimpl.common.enums.TaskTypeEnum;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
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
    @Autowired
    private TaskRecordService taskRecordService;
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

        OrderServeModel model = JSONObject.parseObject(modelStr, OrderServeModel.class);
        Long companyId = model.getCompanyId();
        Long brandId = model.getBrandId();
        Date placeOrderTime = model.getPlaceOrderTime();
        List<TaskOrderAwardBO> taskOrderAwardList = taskService.getTaskOrderAwardList(companyId, brandId, placeOrderTime);
        if (CollectionUtils.isNotEmpty(taskOrderAwardList)){
            taskOrderAwardList.stream().forEach(obj->{
                this.doExecuteTask(model, obj);
                //判断订单累计金额
                //判断消费次数
            });
        }
        //如果想测试消息重投的功能,可以将Action.CommitMessage 替换成Action.ReconsumeLater
        return Action.CommitMessage;
    }

    private void doExecuteTask(OrderServeModel model, TaskOrderAwardBO obj) {
        Long brandId = model.getBrandId();
        String memberCode = model.getMemberCode();
        Integer taskType = obj.getTaskType();
        Long mktTaskId = obj.getMktTaskId();
        BigDecimal consumeAmount = obj.getConsumeAmount();//累计金额

        Integer points = obj.getPoints();//奖励积分

        MktTaskRecordPO recordPO = new MktTaskRecordPO();
        recordPO.setSysBrandId(brandId);
        //任务类型：1完善资料，2分享任务，3邀请注册，4累计消费次数，5累计消费金额',
        recordPO.setTaskType(taskType);
        recordPO.setTaskId(mktTaskId);
        recordPO.setMemberCode(memberCode);
        List<MktTaskRecordPO> taskRecords = taskRecordService.getTaskRecord(recordPO);
        if (CollectionUtils.isNotEmpty(taskRecords)){
            MktTaskRecordPO mktTaskRecordPO = taskRecords.get(0);
            //累计消费=4
            if (TaskTypeEnum.TASK_TYPE_CONSUME_TIMES.getCode()==taskType){

            }
            //累计金额=5
            if (TaskTypeEnum.TASK_TYPE_CONSUME_AMOUNT.getCode()==taskType){

            }

        }else {

        }
    }

}

