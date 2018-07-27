package com.bizvane.mktcenterservice.models.bo;

import com.bizvane.mktcenterservice.models.po.MktCouponPO;
import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.mktcenterservice.models.vo.MessageVO;

import java.util.List;

/**
 * @author chen.li
 * @date on 2018/7/14 10:20
 * @description 活动业务大对象
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
public class ActivityBO {

    /**
     * 活动对象
     */
    private ActivityVO activityVO;

    /**
     * 券对象
     */
    private List<MktCouponPO> couponCodeList;

    /**
     * 消息对象
     */
    private List<MessageVO> messageVOList;

    public List<MktCouponPO> getCouponCodeList() {
        return couponCodeList;
    }

    public void setCouponCodeList(List<MktCouponPO> couponCodeList) {
        this.couponCodeList = couponCodeList;
    }

    public ActivityVO getActivityVO() {
        return activityVO;
    }

    public void setActivityVO(ActivityVO activityVO) {
        this.activityVO = activityVO;
    }

    public List<MessageVO> getMessageVOList() {
        return messageVOList;
    }

    public void setMessageVOList(List<MessageVO> messageVOList) {
        this.messageVOList = messageVOList;
    }
}
