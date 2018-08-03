package com.bizvane.mktcenterserviceimpl.service.impl;

import com.bizvane.mktcenterservice.interfaces.TaskMessageService;
import com.bizvane.mktcenterservice.models.po.MktMessagePO;
import com.bizvane.mktcenterservice.models.po.MktMessagePOExample;
import com.bizvane.mktcenterserviceimpl.common.utils.TimeUtils;
import com.bizvane.mktcenterserviceimpl.mappers.MktMessagePOMapper;
import com.bizvane.utils.tokens.SysAccountPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: lijunwei
 * @Time: 2018/7/30 11:25
 */
@Service
public class TaskMessageServiceImpl implements TaskMessageService {
    @Autowired
    private MktMessagePOMapper mktMessagePOMapper;


    @Override
    public Integer addTaskMessage(MktMessagePO po, SysAccountPO stageUser) {
        po.setCreateDate(TimeUtils.getNowTime());
        po.setCreateUserId(stageUser.getSysAccountId());
        po.setCreateUserName(stageUser.getName());

        return mktMessagePOMapper.insertSelective(po);

    }

    @Override
    public Integer updateTaskMessage(MktMessagePO po, SysAccountPO stageUser) {
        po.setModifiedDate(TimeUtils.getNowTime());
        po.setModifiedUserId(stageUser.getSysAccountId());
        po.setCreateUserName(stageUser.getName());

        return mktMessagePOMapper.updateByPrimaryKeySelective(po);

    }

    @Override
    public Integer deleteTaskMessage(Long bizId, SysAccountPO stageUser) {
        MktMessagePO po = new MktMessagePO();
        po.setModifiedDate(TimeUtils.getNowTime());
        po.setModifiedUserId(stageUser.getSysAccountId());
        po.setCreateUserName(stageUser.getName());
        po.setValid(Boolean.FALSE);

        MktMessagePOExample example = new MktMessagePOExample();
        example.createCriteria().andBizIdEqualTo(bizId).andValidEqualTo(Boolean.TRUE);

        return mktMessagePOMapper.updateByExampleSelective(po, example);
    }
}
