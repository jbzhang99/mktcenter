package com.bizvane.mktcenterservice.interfaces;

import com.bizvane.mktcenterservice.models.po.MktActivityPrizePO;
import com.bizvane.mktcenterservice.models.po.MktActivityPrizeRecordPO;
import com.bizvane.mktcenterservice.models.vo.ActivityPriceBO;
import com.bizvane.mktcenterservice.models.vo.MktActivityPrizeRecordVO;
import com.bizvane.utils.responseinfo.ResponseData;
import org.springframework.web.bind.annotation.RequestParam;

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

    /**
     * 获取抽奖活动规则
     * @return
     */
    public ResponseData<ActivityPriceBO> selectPrizeList(MktActivityPrizeRecordVO vo);

    /**
     * 执行抽奖活动
     * @param activePriceCode
     * @return
     */
    public ResponseData<MktActivityPrizePO> executeActivityPrize(@RequestParam("activePriceCode") String activePriceCode);
}