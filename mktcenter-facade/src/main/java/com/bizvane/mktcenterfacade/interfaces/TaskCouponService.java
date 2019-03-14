package com.bizvane.mktcenterfacade.interfaces;

import com.bizvane.mktcenterfacade.models.po.MktCouponPO;
import com.bizvane.utils.tokens.SysAccountPO;

/**
 * @Author: lijunwei
 * @Time: 2018/7/30 11:14
 */
public interface TaskCouponService {
    /**
     * 新增
     * @return
     */
    public  Integer   addTaskCoupon(MktCouponPO po, SysAccountPO stageUser);
    /**
     * 修改
     * @return
     */
    public  Integer   updateTaskCoupon(MktCouponPO po,SysAccountPO stageUser);

    /**
     * 删除
     * @param bizId
     * @param stageUser
     * @return
     */
    public Integer deleteTaskCoupon(Long  bizId,SysAccountPO stageUser);
}
