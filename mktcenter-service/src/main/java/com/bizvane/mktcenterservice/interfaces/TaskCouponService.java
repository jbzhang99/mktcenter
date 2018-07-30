package com.bizvane.mktcenterservice.interfaces;

import com.bizvane.mktcenterservice.models.po.MktCouponPO;
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
    public  int   addTaskCoupon(MktCouponPO po, SysAccountPO stageUser);
    /**
     * 修改
     * @return
     */
    public  int   updateTaskCoupon(MktCouponPO po,SysAccountPO stageUser);
}
