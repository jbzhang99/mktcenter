package com.bizvane.mktcenterservice.models.bo;

import com.bizvane.mktcenterservice.models.po.MktCouponPO;
import com.bizvane.mktcenterservice.models.po.MktMessagePO;
import com.bizvane.mktcenterservice.models.vo.ActivitySmartVO;

import java.util.List;

/**
 * @author chen.li
 * @date on 2018/7/31 19:28
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
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
