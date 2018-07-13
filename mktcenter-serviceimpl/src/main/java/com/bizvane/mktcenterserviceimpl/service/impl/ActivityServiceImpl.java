package com.bizvane.mktcenterserviceimpl.service.impl;

import com.bizvane.mktcenterservice.interfaces.ActivityService;
import com.bizvane.mktcenterservice.models.po.MktActivityPOWithBLOBs;
import com.bizvane.mktcenterserviceimpl.common.enums.ActivityStatusEnum;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityPOMapper;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author chen.li
 * @date on 2018/7/6 19:50
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private MktActivityPOMapper mktActivityPOMapper;

    /**
     * 禁用/停止活动
     * @param mktActivityId
     * @return
     */
    @Override
    public ResponseData<Integer> stopActivityById(Long mktActivityId, SysAccountPO sysAccountPO) {
        ResponseData responseData = new ResponseData();
        MktActivityPOWithBLOBs mktActivityPOWithBLOBs = new MktActivityPOWithBLOBs();
        mktActivityPOWithBLOBs.setMktActivityId(mktActivityId);
        mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_DISABLED.getCode());
        mktActivityPOWithBLOBs.setModifiedUserId(sysAccountPO.getSysAccountId());
        mktActivityPOWithBLOBs.setModifiedDate(new Date());
        mktActivityPOWithBLOBs.setModifiedUserName(sysAccountPO.getName());
        int i = mktActivityPOMapper.updateByPrimaryKeySelective(mktActivityPOWithBLOBs);
        return responseData;
    }
}
