package com.bizvane.mktcenterservice.interfaces;

import com.bizvane.mktcenterservice.models.po.MktMessagePO;
import com.bizvane.utils.tokens.SysAccountPO;

import java.util.List;

/**
 * @Author: lijunwei
 * @Time: 2018/7/30 11:13
 */
public interface TaskMessageService {
    /**
     * 新增
     *
     * @param po
     * @param stageUser
     * @return
     */
    public Integer addTaskMessage(MktMessagePO po, SysAccountPO stageUser);

    /**
     * 修改
     *
     * @param po
     * @param stageUser
     * @return
     */
    public Integer updateTaskMessage(MktMessagePO po, SysAccountPO stageUser);

    /**
     * @param stageUser
     * @return
     */
    public Integer deleteTaskMessage(Long bizId, SysAccountPO stageUser);

    public List<MktMessagePO> getMktMessagePOS(Long bizid);
}
