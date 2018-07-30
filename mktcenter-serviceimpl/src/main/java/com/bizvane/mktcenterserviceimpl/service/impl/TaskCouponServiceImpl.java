package com.bizvane.mktcenterserviceimpl.service.impl;

import com.bizvane.mktcenterservice.interfaces.TaskCouponService;
import com.bizvane.mktcenterservice.models.po.MktCouponPO;
import com.bizvane.mktcenterserviceimpl.common.utils.TimeUtils;
import com.bizvane.mktcenterserviceimpl.mappers.MktCouponPOMapper;
import com.bizvane.utils.tokens.SysAccountPO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: lijunwei
 * @Time: 2018/7/30 11:38
 */
public class TaskCouponServiceImpl implements TaskCouponService {

    @Autowired
    private MktCouponPOMapper mktCouponPOMapper;


    @Override
    public Integer addTaskCoupon(MktCouponPO po,SysAccountPO stageUser) {

        po.setCreateDate(TimeUtils.getNowTime());
        po.setCreateUserId(stageUser.getSysAccountId());
        po.setCreateUserName(stageUser.getName());
        return  mktCouponPOMapper.insertSelective(po);

    }

    @Override
    public Integer updateTaskCoupon(MktCouponPO po,SysAccountPO stageUser) {
        po.setModifiedDate(TimeUtils.getNowTime());
        po.setModifiedUserId(stageUser.getCtrlAccountId());
        po.setModifiedUserName(stageUser.getName());

        return mktCouponPOMapper.updateByPrimaryKeySelective(po);
    }
}
