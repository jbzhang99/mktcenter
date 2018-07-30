package com.bizvane.mktcenterservice.interfaces;

import com.bizvane.mktcenterservice.models.po.MktMessagePO;
import com.bizvane.utils.tokens.SysAccountPO;

/**
 * @Author: lijunwei
 * @Time: 2018/7/30 11:13
 */
public interface TaskMessageService {
    /**
     * 新增
     * @param po
     * @param stageUser
     * @return
     */
    public  int  addTaskMessage(MktMessagePO po,SysAccountPO stageUser);

    /**
     * 修改
     * @param po
     * @param stageUser
     * @return
     */
    public  int  updateTaskMessage(MktMessagePO po,SysAccountPO stageUser);


}
