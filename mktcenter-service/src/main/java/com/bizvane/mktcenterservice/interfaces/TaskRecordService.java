package com.bizvane.mktcenterservice.interfaces;

import com.bizvane.mktcenterservice.models.po.MktTaskRecordPO;
import com.bizvane.utils.tokens.SysAccountPO;

/**
 * @Author: lijunwei
 * @Time: 2018/8/6 23:44
 */
public interface TaskRecordService {
    /**
     * 添加记录
     * @param po
     * @param stageUser
     * @return
     */
    public Integer addTaskRecord(MktTaskRecordPO po, SysAccountPO stageUser);

    /**
     * 修改记录
     * @param po
     * @param stageUser
     * @return
     */
    public Integer updateTaskRecord(MktTaskRecordPO po, SysAccountPO stageUser);
}
