package com.bizvane.mktcenterfacade.models.bo;

import com.bizvane.mktcenterfacade.models.po.MktMessagePO;
import com.bizvane.mktcenterfacade.models.vo.ActivitySmartVO;
import com.bizvane.mktcenterfacade.models.po.MktCouponPO;

import java.util.List;

/**
 * @author chen.li
 * @date on 2018/7/31 19:28
 * @description
 *
 */
public class ActivitySmartBO {

    private ActivitySmartVO activitySmartVO;

    private MktMessagePO mktMessagePO;

    private List<MktCouponPO> mktCouponPOS;

    public ActivitySmartVO getActivitySmartVO() {
        return activitySmartVO;
    }

    public void setActivitySmartVO(ActivitySmartVO activitySmartVO) {
        this.activitySmartVO = activitySmartVO;
    }

    public MktMessagePO getMktMessagePO() {
        return mktMessagePO;
    }

    public void setMktMessagePO(MktMessagePO mktMessagePO) {
        this.mktMessagePO = mktMessagePO;
    }

    public List<MktCouponPO> getMktCouponPOS() {
        return mktCouponPOS;
    }

    public void setMktCouponPOS(List<MktCouponPO> mktCouponPOS) {
        this.mktCouponPOS = mktCouponPOS;
    }
}
