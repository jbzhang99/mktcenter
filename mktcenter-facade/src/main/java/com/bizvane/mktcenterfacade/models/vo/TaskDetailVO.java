package com.bizvane.mktcenterfacade.models.vo;

import com.bizvane.mktcenterfacade.models.po.MktCouponPO;
import com.bizvane.mktcenterfacade.models.po.MktMessagePO;
import com.bizvane.mktcenterfacade.models.po.MktTaskPOWithBLOBs;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: lijunwei
 * @Time: 2018/7/30 11:07
 */
public class TaskDetailVO extends MktTaskPOWithBLOBs {
    //邀请开卡任务Id
    private Long mktTaskInviteId;
    //邀请开卡人数
    private Integer inviteNum;

    //消费任务
    private Long mktTaskOrderId;
    //任务条件/订单来源限制：0全部类型，1线下订单，2微商城订单
    private Integer orderSource;
    //金额
    private BigDecimal consumeAmount;
    //次数
    private Integer consumeTimes;

    //券奖励
    private List<MktCouponPO> mktCouponPOList;
    //发送消息
    private List<MktMessagePO> mktmessagePOList;

    public Long getMktTaskInviteId() {
        return mktTaskInviteId;
    }

    public void setMktTaskInviteId(Long mktTaskInviteId) {
        this.mktTaskInviteId = mktTaskInviteId;
    }

    public Integer getInviteNum() {
        return inviteNum;
    }

    public void setInviteNum(Integer inviteNum) {
        this.inviteNum = inviteNum;
    }

    public Long getMktTaskOrderId() {
        return mktTaskOrderId;
    }

    public void setMktTaskOrderId(Long mktTaskOrderId) {
        this.mktTaskOrderId = mktTaskOrderId;
    }

    public Integer getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(Integer orderSource) {
        this.orderSource = orderSource;
    }

    public BigDecimal getConsumeAmount() {
        return consumeAmount;
    }

    public void setConsumeAmount(BigDecimal consumeAmount) {
        this.consumeAmount = consumeAmount;
    }

    public Integer getConsumeTimes() {
        return consumeTimes;
    }

    public void setConsumeTimes(Integer consumeTimes) {
        this.consumeTimes = consumeTimes;
    }

    public List<MktCouponPO> getMktCouponPOList() {
        return mktCouponPOList;
    }

    public void setMktCouponPOList(List<MktCouponPO> mktCouponPOList) {
        this.mktCouponPOList = mktCouponPOList;
    }

    public List<MktMessagePO> getMktmessagePOList() {
        return mktmessagePOList;
    }

    public void setMktmessagePOList(List<MktMessagePO> mktmessagePOList) {
        this.mktmessagePOList = mktmessagePOList;
    }
}
