package com.bizvane.mktcenterservice.models.bo;

import com.bizvane.mktcenterservice.models.po.MktCouponPO;
import com.bizvane.mktcenterservice.models.po.MktTaskPOWithBLOBs;

import java.util.List;

/**
 * @Author: lijunwei
 * @Time: 2018/8/7 16:56
 */
public class TaskInviteAwardBO extends MktTaskPOWithBLOBs {
    //邀请开卡任务Id
    private Long mktTaskInviteId;
    //邀请开卡人数
    private Integer inviteNum;
    //券奖励
    private List<MktCouponPO> mktCouponPOList;

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

    public List<MktCouponPO> getMktCouponPOList() {
        return mktCouponPOList;
    }

    public void setMktCouponPOList(List<MktCouponPO> mktCouponPOList) {
        this.mktCouponPOList = mktCouponPOList;
    }
}
