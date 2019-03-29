package com.bizvane.mktcenterfacade.models.bo;

import com.bizvane.couponfacade.models.vo.CouponDetailResponseVO;
import com.bizvane.mktcenterfacade.models.po.MktMessagePO;
import com.bizvane.mktcenterfacade.models.po.MktCouponPO;
import com.bizvane.mktcenterfacade.models.vo.ActivityVO;

import java.util.List;

/**
 * @author chen.li
 * @date on 2018/7/14 10:20
 * @description 活动业务大对象
 *
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
    private List<MktMessagePO> messageVOList;

    /**
     * 调用券接口的券对象
     */
    private List<CouponDetailResponseVO> couponEntityAndDefinitionVOList;

    public List<CouponDetailResponseVO> getCouponEntityAndDefinitionVOList() {
        return couponEntityAndDefinitionVOList;
    }

    public void setCouponEntityAndDefinitionVOList(List<CouponDetailResponseVO> couponEntityAndDefinitionVOList) {
        this.couponEntityAndDefinitionVOList = couponEntityAndDefinitionVOList;
    }

    public List<MktMessagePO> getMessageVOList() {
        return messageVOList;
    }

    public void setMessageVOList(List<MktMessagePO> messageVOList) {
        this.messageVOList = messageVOList;
    }

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
}
