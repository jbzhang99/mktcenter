package com.bizvane.mktcenterfacade.models.bo;

import com.bizvane.mktcenterfacade.models.po.MktMessagePO;
import com.bizvane.mktcenterfacade.models.po.MktTaskPOWithBLOBs;
import com.bizvane.mktcenterfacade.models.po.MktCouponPO;

import java.util.List;

/**
 * @Author: lijunwei
 * @Time: 2018/8/17 16:36
 */
public class AddTaskBO {

  private MktTaskPOWithBLOBs taskVO;
    /**
     * 券号列表
     */
    private List<MktCouponPO> mktCouponPOList;

    /**
     * 消息对象
     */
    private List<MktMessagePO> messagePOList;


    public MktTaskPOWithBLOBs getTaskVO() {
        return taskVO;
    }

    public void setTaskVO(MktTaskPOWithBLOBs taskVO) {
        this.taskVO = taskVO;
    }

    public List<MktCouponPO> getMktCouponPOList() {
        return mktCouponPOList;
    }

    public void setMktCouponPOList(List<MktCouponPO> mktCouponPOList) {
        this.mktCouponPOList = mktCouponPOList;
    }

    public List<MktMessagePO> getMessagePOList() {
        return messagePOList;
    }

    public void setMessagePOList(List<MktMessagePO> messagePOList) {
        this.messagePOList = messagePOList;
    }
}
