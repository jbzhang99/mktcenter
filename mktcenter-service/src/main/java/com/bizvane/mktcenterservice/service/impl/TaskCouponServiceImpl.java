package com.bizvane.mktcenterservice.service.impl;

import com.bizvane.mktcenterfacade.interfaces.TaskCouponService;
import com.bizvane.mktcenterfacade.models.po.MktCouponPO;
import com.bizvane.mktcenterfacade.models.po.MktCouponPOExample;
import com.bizvane.mktcenterservice.common.constants.TaskConstants;
import com.bizvane.mktcenterservice.common.utils.TimeUtils;
import com.bizvane.mktcenterservice.mappers.MktCouponPOMapper;
import com.bizvane.utils.tokens.SysAccountPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: lijunwei
 * @Time: 2018/7/30 11:38
 */
@Service
public class TaskCouponServiceImpl implements TaskCouponService {

    @Autowired
    private MktCouponPOMapper mktCouponPOMapper;

    /**
     * 新增券
     * @param po
     * @param stageUser
     * @return
     */
    @Override
    public Integer addTaskCoupon(MktCouponPO po,SysAccountPO stageUser) {

        po.setCreateDate(TimeUtils.getNowTime());
        po.setCreateUserId(stageUser.getSysAccountId());
        po.setCreateUserName(stageUser.getName());
        return  mktCouponPOMapper.insertSelective(po);

    }

    /**
     * 修改券
     * @param po
     * @param stageUser
     * @return
     */
    @Override
    public Integer updateTaskCoupon(MktCouponPO po,SysAccountPO stageUser) {
        po.setModifiedDate(TimeUtils.getNowTime());
        po.setModifiedUserId(stageUser.getCtrlAccountId());
        po.setModifiedUserName(stageUser.getName());

        return mktCouponPOMapper.updateByPrimaryKeySelective(po);
    }

    /**
     *  删除券
     * @param bizId
     * @param stageUser
     * @return
     */
    @Override
    public Integer deleteTaskCoupon(Long  bizId,SysAccountPO stageUser) {
        MktCouponPO po = new MktCouponPO();
        po.setModifiedDate(TimeUtils.getNowTime());
        po.setModifiedUserId(stageUser.getCtrlAccountId());
        po.setModifiedUserName(stageUser.getName());
        po.setValid(Boolean.FALSE);
        MktCouponPOExample example = new MktCouponPOExample();
        example.createCriteria().andBizIdEqualTo(bizId).andBizTypeEqualTo(TaskConstants.TASK_TYPE).andValidEqualTo(Boolean.TRUE);
        return mktCouponPOMapper.updateByExampleSelective(po,example);
    }
}
