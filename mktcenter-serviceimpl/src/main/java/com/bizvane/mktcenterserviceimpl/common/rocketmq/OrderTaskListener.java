package com.bizvane.mktcenterserviceimpl.common.rocketmq;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.openservices.ons.api.Action;
import com.aliyun.openservices.ons.api.ConsumeContext;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.MessageListener;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.members.facade.models.OrderModel;
import com.bizvane.members.facade.models.OrderServeModel;
import com.bizvane.mktcenterservice.interfaces.TaskRecordService;
import com.bizvane.mktcenterservice.interfaces.TaskService;
import com.bizvane.mktcenterservice.models.bo.TaskAwardBO;
import com.bizvane.mktcenterservice.models.bo.TotalStatisticsBO;
import com.bizvane.mktcenterservice.models.po.MktCouponPO;
import com.bizvane.mktcenterservice.models.po.MktTaskRecordPO;
import com.bizvane.mktcenterservice.models.vo.MktTaskRecordVO;
import com.bizvane.mktcenterserviceimpl.common.enums.TaskTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Author: lijunwei
 * @Time: 2018/8/5 23:15
 * 监控订单
 */
@Slf4j
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
        log.info("订单信息--OrderTaskListener--"+modelStr);
        OrderModel model = JSONObject.parseObject(modelStr, OrderModel.class);
        //根据会员code获取会员详情

        String memberCode = model.getMemberCode();
        //订单列表   订单来源 1=线下   2=微商城
        Integer orderSource = model.getOrderFrom();
        Long companyId = model.getSysCompanyId();
        Long brandId = model.getBrandId();
        Date placeOrderTime = model.getPlaceOrderTime();

        MemberInfoModel memeberDetail = taskService.getCompanyMemeberDetail(memberCode);
        if (memeberDetail==null){
            log.info("订单信息--会员详情-不存在!");
            return Action.CommitMessage;
        }
        log.info("订单信息--会员详情--------"+memeberDetail);
          Long serviceStoreId = memeberDetail.getServiceStoreId();
        List<TaskAwardBO> taskOrderAwardList = taskService.getTaskOrderAwardList(companyId, brandId, placeOrderTime, orderSource);
        log.info("根据订单信息 获取的任务列表----"+ JSON.toJSONString(taskOrderAwardList));
        if (CollectionUtils.isNotEmpty(taskOrderAwardList)){
            taskOrderAwardList.stream()
               .filter(obj->{
               Boolean isStoreLimit = obj.getStoreLimit();
               String  StoreLimitList=obj.getStoreLimitList();
               return !isStoreLimit || (serviceStoreId==null) ||(StringUtils.isNotBlank(StoreLimitList) &&  obj.getStoreLimitList().contains(String.valueOf(serviceStoreId)));})
               .forEach(obj->{
               this.doExecuteTask(model, obj,placeOrderTime); });
        }
        //如果想测试消息重投的功能,可以将Action.CommitMessage 替换成Action.ReconsumeLater
      return Action.CommitMessage;
  }

    //任务类型：1完善资料，2分享任务，3邀请注册，4累计消费次数，5累计消费金额',
    private void doExecuteTask(OrderModel model, TaskAwardBO obj,Date placeOrderTime) {
        log.info("开始执行订单奖励----");
        BigDecimal tradeAmount = model.getTradeAmount();//订单金额
        Long brandId = model.getBrandId();
        String memberCode = model.getMemberCode();
        Long sysCompanyId = model.getSysCompanyId();
        // String carNo = model.getCarNo();
        Integer taskType = obj.getTaskType();
        Long mktTaskId = obj.getMktTaskId();
        BigDecimal consumeAmount = obj.getConsumeAmount();//累计金额
        Integer consumeTimes = obj.getConsumeTimes();//消费次数
        Integer points = obj.getPoints();//奖励积分
        List<MktCouponPO> couponPOList = obj.getMktCouponPOList();//券

        MktTaskRecordVO recordVO = new MktTaskRecordVO();
        recordVO.setSysBrandId(brandId);
        recordVO.setTaskType(taskType);
        recordVO.setTaskId(mktTaskId);
        recordVO.setMemberCode(memberCode);

        // 获取会员是否已经成功参与过某一活动
        Boolean isOrNoAward = taskRecordService.getIsOrNoAward(recordVO);

        if (!isOrNoAward){
            MktTaskRecordPO recordPO = new MktTaskRecordPO();
            BeanUtils.copyProperties(recordVO,recordPO);
            recordPO.setConsumeAmount(tradeAmount);
            recordPO.setParticipateDate(placeOrderTime);
            recordPO.setSysCompanyId(sysCompanyId);
            recordPO.setCreateDate(new  Date());
            Long addRecordId = taskRecordService.addTaskRecord(recordPO);

            recordPO.setMktTaskRecordId(addRecordId);
            //获取会员参与某一活动放总金额和总次数
             TotalStatisticsBO totalBO = taskRecordService.getTotalStatistics(recordVO);
            log.info("--获取会员参与某一活动放总金额和总次数--"+JSON.toJSONString(totalBO));
           // taskService.sendCouponAndPoint(memberCode,obj);   //每次都发测试后删除
            //累计消费次数任务=4
                if (TaskTypeEnum.TASK_TYPE_CONSUME_TIMES.getCode()==taskType){
                    if(totalBO!=null && totalBO.getTotalTimes()!=null && totalBO.getTotalTimes().equals(consumeTimes)){
                            recordPO.setPoints(points);
                            recordPO.setRewarded(Integer.valueOf(1));
                            recordPO.setModifiedDate(new Date());
                            recordPO.setPoints(obj.getPoints());
                            taskRecordService.updateTaskRecord(recordPO);
                            taskService.sendCouponAndPoint(memberCode,obj);
                    }
                }

                //累计金额任务=5
                if (TaskTypeEnum.TASK_TYPE_CONSUME_AMOUNT.getCode()==taskType){
                    if(totalBO!=null && totalBO.getTotalConsume()!=null && totalBO.getTotalConsume().compareTo(consumeAmount) == 0){
                            recordPO.setRewarded(Integer.valueOf(1));
                            recordPO.setModifiedDate(new Date());
                            recordPO.setPoints(obj.getPoints());
                            taskRecordService.updateTaskRecord(recordPO);
                            taskService.sendCouponAndPoint(memberCode,obj);

                    }
                }


        }
   }
}

