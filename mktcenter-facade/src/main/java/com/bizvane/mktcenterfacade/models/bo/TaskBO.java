package com.bizvane.mktcenterfacade.models.bo;

import com.bizvane.centerstageservice.models.po.SysStorePo;
import com.bizvane.couponfacade.models.po.CouponDefinitionPO;
import com.bizvane.mktcenterfacade.models.po.MktMessagePO;
import com.bizvane.mktcenterfacade.models.po.MktCouponPO;
import com.bizvane.mktcenterfacade.models.vo.TaskVO;

import java.util.List;

/**
 * @author chen.li
 * @date on 2018/7/24 10:52
 * @description
 *
 */
public class TaskBO {

    /**
     * 任务对象
     */
    private TaskVO taskVO;

    /**
     * 券号列表
     */
    private List<MktCouponPO> mktCouponPOList;

    /**
     * 消息对象
     */
    private List<MktMessagePO> messagePOList;

    /**
     * 券Defination
     * @return
     */
    private List<CouponDefinitionPO> couponDefinitionPOList;
    /**
     * 店铺列表
     */
    List<SysStorePo> storeList;

    public TaskVO getTaskVO() {
        return taskVO;
    }

    public List<SysStorePo> getStoreList() {
        return storeList;
    }

    public void setStoreList(List<SysStorePo> storeList) {
        this.storeList = storeList;
    }

    public void setTaskVO(TaskVO taskVO) {

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

    public List<CouponDefinitionPO> getCouponDefinitionPOList() {
        return couponDefinitionPOList;
    }

    public void setCouponDefinitionPOList(List<CouponDefinitionPO> couponDefinitionPOList) {
        this.couponDefinitionPOList = couponDefinitionPOList;
    }
}
