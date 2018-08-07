package com.bizvane.mktcenterserviceimpl.service.impl;

import com.bizvane.mktcenterservice.interfaces.TaskRecordService;
import com.bizvane.mktcenterservice.models.po.MktTaskRecordPO;
import com.bizvane.mktcenterserviceimpl.common.utils.TimeUtils;
import com.bizvane.mktcenterserviceimpl.mappers.MktTaskRecordPOMapper;
import com.bizvane.utils.tokens.SysAccountPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: lijunwei
 * @Time: 2018/8/6 23:43
 */
@Service
public class TaskRecordServiceImpl implements TaskRecordService {

    @Autowired
    private MktTaskRecordPOMapper mktTaskRecordPOMapper;

    /**
     * 添加记录
     * @param po
     * @param stageUser
     * @return
     */
    @Override
    public Integer addTaskRecord(MktTaskRecordPO po, SysAccountPO stageUser) {
        po.setCreateDate(TimeUtils.getNowTime());
        po.setCreateUserId(stageUser.getSysAccountId());
        po.setCreateUserName(stageUser.getName());
        return mktTaskRecordPOMapper.insertSelective(po);

    }
    /**
     * 修改记录
     */
    @Override
    public Integer updateTaskRecord(MktTaskRecordPO po, SysAccountPO stageUser) {
        po.setModifiedDate(TimeUtils.getNowTime());
        po.setModifiedUserId(stageUser.getSysAccountId());
        po.setModifiedUserName(stageUser.getName());
        return mktTaskRecordPOMapper.insertSelective(po);
    }

    @Override
    public Integer getTaskRecord(MktTaskRecordPO po) {

   return null;
    }

}
