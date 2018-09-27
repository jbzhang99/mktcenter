package com.bizvane.mktcenterserviceimpl.service.impl;

import com.bizvane.mktcenterservice.interfaces.TaskMessageService;
import com.bizvane.mktcenterservice.models.po.MktMessagePO;
import com.bizvane.mktcenterservice.models.po.MktMessagePOExample;
import com.bizvane.mktcenterserviceimpl.common.constants.TaskConstants;
import com.bizvane.mktcenterserviceimpl.common.utils.TimeUtils;
import com.bizvane.mktcenterserviceimpl.mappers.MktMessagePOMapper;
import com.bizvane.utils.tokens.SysAccountPO;
import com.fasterxml.jackson.databind.node.BooleanNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     * 删除消息或短信
     * @param bizId
     * @param stageUser
     * @return
     */
    @Override
    public Integer deleteTaskMessage(Long bizId, SysAccountPO stageUser) {
        MktMessagePO po = new MktMessagePO();
        po.setModifiedDate(TimeUtils.getNowTime());
        po.setModifiedUserId(stageUser.getSysAccountId());
        po.setCreateUserName(stageUser.getName());
        po.setValid(Boolean.FALSE);
        MktMessagePOExample example = new MktMessagePOExample();
        example.createCriteria().andBizIdEqualTo(bizId).andBizTypeEqualTo(TaskConstants.TASK_TYPE).andValidEqualTo(Boolean.TRUE);
        return mktMessagePOMapper.updateByExampleSelective(po, example);
    }

    /**
     * 任务的消息列表
     * @param bizid
     * @return
     */
    @Override
    public List<MktMessagePO> getMktMessagePOS(Long bizid) {
        MktMessagePOExample example = new MktMessagePOExample();
        example.createCriteria().andBizIdEqualTo(bizid).andBizTypeEqualTo(Integer.valueOf(2)).andValidEqualTo(Boolean.TRUE);
        return mktMessagePOMapper.selectByExample(example);
    }
}
