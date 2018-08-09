package com.bizvane.mktcenterservice.models.bo;

import com.bizvane.mktcenterservice.models.po.MktCouponPO;
import com.bizvane.mktcenterservice.models.po.MktTaskPOWithBLOBs;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: lijunwei
 * @Time: 2018/8/7 16:49
 * 消费奖励相关的判断Bo
 */
public class TaskAwardBO extends MktTaskPOWithBLOBs {
    //消费任务
    private Long mktTaskOrderId;
    //任务条件/订单来源限制：0全部类型，1线下订单，2微商城订单
    private Integer orderSource;
    //金额
    private BigDecimal consumeAmount;
    //次数
    private Integer consumeTimes;

    //邀请开卡任务Id
    private Long mktTaskInviteId;
    //邀请开卡人数
    private Integer inviteNum;

    //券奖励
    private List<MktCouponPO> mktCouponPOList;

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
}
