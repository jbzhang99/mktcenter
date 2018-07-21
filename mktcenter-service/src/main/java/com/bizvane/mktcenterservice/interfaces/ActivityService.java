package com.bizvane.mktcenterservice.interfaces;

import com.bizvane.mktcenterservice.models.po.MktActivityPOWithBLOBs;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;

/**
 * @author chen.li
 * @date on 2018/7/6 19:49
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
public interface ActivityService {

    /**
     * 禁用/停止活动
     * @param mktActivityId
     * @return
     */
    public ResponseData<Integer> stopActivityById(Long mktActivityId, SysAccountPO sysAccountPO);

    /**
     * 活动审核
     * @param
     * @return
     */
    public ResponseData<Integer> checkActivityById(MktActivityPOWithBLOBs bs, SysAccountPO sysAccountPO);

}
