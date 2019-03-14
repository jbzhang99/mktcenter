package com.bizvane.mktcenterfacade.interfaces;

import com.bizvane.mktcenterfacade.models.po.MktActivityRecordPO;
import com.bizvane.mktcenterfacade.models.vo.MktActivityRecordVO;
import com.bizvane.utils.responseinfo.ResponseData;

import java.util.List;

/**
 * 活动记录表
 * Created by agan on 2018/8/6.
 */
public interface ActivityRecordService{
    public ResponseData<List<MktActivityRecordPO>> getActivityRecordPOList(MktActivityRecordVO vp);
}
