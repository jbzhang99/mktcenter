package com.bizvane.mktcenterservice.interfaces;

import com.bizvane.mktcenterservice.models.po.MktActivityPrizeRecordPO;
import com.bizvane.utils.responseinfo.ResponseData;

import java.util.List;

/**
 * Created by agan on 2018/12/19.
 */
public interface ActivityPrizeServiceWX {
    /**
     * 小程序获取中奖纪录 和中奖纪录轮播
     * @param po
     * @return
     */
    public ResponseData<List<MktActivityPrizeRecordPO>> getPrizeRecordList(MktActivityPrizeRecordPO po);
}
