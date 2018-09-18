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

   //完善资料任务id
    private Long mktTaskProfileId;
    //完善资料的字段code
    private String propertyCode;

    //分享任务id
    private Long mktTaskShareId;
    //分享任务类型
    private Integer shareUrlType;
    //分享人任务的次数
    private Integer shareTimes;
    //分享内容
    private String shareUrl;

    //门店限制状态：0不限制，1限制
    private Boolean isStoreLimit;
    //门店限制类型：1黑名单，2白名单
    private Integer storeLimitType;
    //白名单店铺list
    private String storeLimitList;

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

    public Long getMktTaskProfileId() {
        return mktTaskProfileId;
    }

    public void setMktTaskProfileId(Long mktTaskProfileId) {
        this.mktTaskProfileId = mktTaskProfileId;
    }

    public String getPropertyCode() {
        return propertyCode;
    }

    public void setPropertyCode(String propertyCode) {
        this.propertyCode = propertyCode;
    }

    public Long getMktTaskShareId() {
        return mktTaskShareId;
    }

    public void setMktTaskShareId(Long mktTaskShareId) {
        this.mktTaskShareId = mktTaskShareId;
    }

    public Integer getShareUrlType() {
        return shareUrlType;
    }

    public void setShareUrlType(Integer shareUrlType) {
        this.shareUrlType = shareUrlType;
    }

    public Integer getShareTimes() {
        return shareTimes;
    }

    public void setShareTimes(Integer shareTimes) {
        this.shareTimes = shareTimes;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public Boolean getStoreLimit() {
        return isStoreLimit;
    }

    public void setStoreLimit(Boolean storeLimit) {
        isStoreLimit = storeLimit;
    }

    public Integer getStoreLimitType() {
        return storeLimitType;
    }

    public void setStoreLimitType(Integer storeLimitType) {
        this.storeLimitType = storeLimitType;
    }

    public String getStoreLimitList() {
        return storeLimitList;
    }

    public void setStoreLimitList(String storeLimitList) {
        this.storeLimitList = storeLimitList;
    }

}
