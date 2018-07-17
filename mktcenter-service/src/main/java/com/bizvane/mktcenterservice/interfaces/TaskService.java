package com.bizvane.mktcenterservice.interfaces;

import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;

/**
 * @author chen.li
 * @date on 2018/7/16 14:05
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
public interface TaskService {
    /**
     * 禁用/停止任务
     * @param mktTaskId
     * @return
     */
    public ResponseData<Integer> stopTaskById(Long mktTaskId, SysAccountPO sysAccountPO);

    /**
     * 任务审核
     * @param mktTaskId
     * @return
     */
    public ResponseData<Integer> checkTaskById(Long mktTaskId, SysAccountPO sysAccountPO);
}
