package com.bizvane.mktcenterservice.models.vo;

import com.bizvane.mktcenterservice.models.po.MktCouponPO;
import com.bizvane.mktcenterservice.models.po.MktMessagePO;
import com.bizvane.mktcenterservice.models.po.MktTaskOrderPO;
import com.bizvane.mktcenterservice.models.po.MktTaskPOWithBLOBs;

import java.util.List;

/**
 * @Author: lijunwei
 * @Time: 2018/7/30 11:07
 */
public class TaskConsumeVO {
    /**
     * 任务主表
     */
    private MktTaskPOWithBLOBs mktTaskPOWithBLOBs;
    /**
     * 会员订单与消费
     */
    private MktTaskOrderPO  mktTaskOrderPO;

    /**
     * 券号列表(奖励)
     */
    private List<MktCouponPO> mktCouponPOList;

    /**
     * 消息对象
     */
    private List<MktMessagePO> mktmessagePOList;


    public MktTaskPOWithBLOBs getMktTaskPOWithBLOBs() {
        return mktTaskPOWithBLOBs;
    }

    public void setMktTaskPOWithBLOBs(MktTaskPOWithBLOBs mktTaskPOWithBLOBs) {
        this.mktTaskPOWithBLOBs = mktTaskPOWithBLOBs;
    }

    public MktTaskOrderPO getMktTaskOrderPO() {
        return mktTaskOrderPO;
    }

    public void setMktTaskOrderPO(MktTaskOrderPO mktTaskOrderPO) {
        this.mktTaskOrderPO = mktTaskOrderPO;
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
