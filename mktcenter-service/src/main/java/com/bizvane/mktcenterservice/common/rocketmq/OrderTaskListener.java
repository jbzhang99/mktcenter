package com.bizvane.mktcenterservice.common.rocketmq;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.openservices.ons.api.Action;
import com.aliyun.openservices.ons.api.ConsumeContext;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.MessageListener;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.members.facade.models.OrderModel;
import com.bizvane.mktcenterfacade.interfaces.TaskRecordService;
import com.bizvane.mktcenterfacade.interfaces.TaskService;
import com.bizvane.mktcenterfacade.models.bo.TaskAwardBO;
import com.bizvane.mktcenterfacade.models.bo.TotalStatisticsBO;
import com.bizvane.mktcenterfacade.models.po.MktTaskRecordPO;
import com.bizvane.mktcenterfacade.models.vo.MktTaskRecordVO;
import com.bizvane.mktcenterservice.common.enums.TaskTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Author: lijunwei
 * @Time: 2018/8/5 23:15
 * 监控订单  消费次数
 */
@Slf4j
@Component
public class OrderTaskListener implements MessageListener {

    @Autowired
    private TaskService taskService;
    @Autowired
    private TaskRecordService taskRecordService;

    @Transactional
    @Override
    public Action consume(Message message, ConsumeContext consumeContext) {
        //获取订单信息
        String modelStr = new String(message.getBody());
        log.info("消费次数 订单信息--OrderTaskListener--" + modelStr);
        OrderModel model = JSONObject.parseObject(modelStr, OrderModel.class);
        String memberCode = model.getMemberCode();
        //订单列表   订单来源 1=线下   2=微商城
        Integer orderSource = model.getOrderFrom();
        Long companyId = model.getSysCompanyId();
        Long brandId = model.getBrandId();
        Date placeOrderTime = model.getPlaceOrderTime();
        MemberInfoModel memeberDetail = taskService.getCompanyMemeberDetail(memberCode);
        if (memeberDetail == null) {
            log.info("消费次数 订单信息--会员详情-不存在!");
            return Action.CommitMessage;
        }
        log.info("消费次数 订单信息--会员详情--------" + memeberDetail);
        Long serviceStoreId = memeberDetail.getServiceStoreId();
        List<TaskAwardBO> taskOrderAwardList = taskService.getTaskOrderAwardList(companyId, brandId, placeOrderTime, orderSource, TaskTypeEnum.TASK_TYPE_CONSUME_TIMES.getCode());
        log.info("消费次数 根据订单信息 获取的任务列表----" + JSON.toJSONString(taskOrderAwardList));
        if (CollectionUtils.isNotEmpty(taskOrderAwardList)) {
            taskOrderAwardList.stream()
                    .filter(obj -> {
                        Boolean isStoreLimit = obj.getStoreLimit();
                        String StoreLimitList = obj.getStoreLimitList();
                        return !isStoreLimit || (serviceStoreId == null) || (StringUtils.isNotBlank(StoreLimitList) && obj.getStoreLimitList().contains(String.valueOf(serviceStoreId)));
                    })
                    .forEach(obj -> {
                        log.info("消费次数 任务开始执行订单奖励----");
                        Integer consumeTimes = obj.getConsumeTimes();//消费次数
                        MktTaskRecordVO recordVO = new MktTaskRecordVO();
                        recordVO.setSysBrandId(brandId);
                        recordVO.setTaskType(TaskTypeEnum.TASK_TYPE_CONSUME_TIMES.getCode());
                        Long mktTaskId = obj.getMktTaskId();
                        recordVO.setTaskId(mktTaskId);
                        recordVO.setMemberCode(memberCode);
                        recordVO.setPoints(obj.getPoints());
                        recordVO.setParticipateDate(placeOrderTime);
                        recordVO.setSysCompanyId(model.getSysCompanyId());
                        recordVO.setCreateDate(new Date());
                        // 获取会员是否已经成功参与过某一任务
                        Boolean isOrNoAward = taskRecordService.getIsOrNoAward(recordVO);
                        log.info("消费次数 员是否已经成功参与" + JSON.toJSONString(recordVO) + "--" + isOrNoAward);
                        if (!isOrNoAward) {
                            MktTaskRecordPO recordPO = new MktTaskRecordPO();
                            BeanUtils.copyProperties(recordVO, recordPO);
                            Long addRecordId = taskRecordService.addTaskRecord(recordPO);
                            //获取会员参与某一活动放总次数
                            TotalStatisticsBO totalBO = taskRecordService.getTotalStatistics(recordVO);
                            log.info(mktTaskId + "消费次数 获取会员参与某一任务放总次数--" + JSON.toJSONString(recordVO) + "-----" + JSON.toJSONString(totalBO));
                            //累计消费次数任务=4
                            if (totalBO.getTotalTimes().equals(consumeTimes)) {
                                log.info(mktTaskId + "消费次数 任务进行奖励--" + memberCode);
                                recordPO.setRewarded(1);
                                recordPO.setModifiedDate(new Date());
                                taskService.sendCouponAndPoint(memberCode, obj);
                                taskRecordService.updateTaskRecord(recordPO);
                            }

                        }
                    });
        }
        //如果想测试消息重投的功能,可以将Action.CommitMessage 替换成Action.ReconsumeLater
        return Action.CommitMessage;
    }
}

