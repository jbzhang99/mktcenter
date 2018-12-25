package com.bizvane.mktcenterservice.rpc;

import com.bizvane.mktcenterservice.models.po.MktActivityPrizePO;
import com.bizvane.mktcenterservice.models.po.MktActivityPrizeRecordPO;
import com.bizvane.mktcenterservice.models.vo.ActivityPriceBO;
import com.bizvane.mktcenterservice.models.vo.ActivityPrizeBO;
import com.bizvane.mktcenterservice.models.vo.MktActivityPrizeRecordVO;
import com.bizvane.utils.responseinfo.ResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by agan on 2018/12/19.
 */
@FeignClient(value = "${feign.client.mktcenter.name}",path = "${feign.client.mktcenter.path}/activityPrizeRpc")
public interface ActivityPrizeServiceRpc {
    /**
     * 小程序获取中奖纪录 和中奖纪录轮播
     * @param po
     * @return
     */
    @RequestMapping("getPrizeRecordListRpc")
    ResponseData<List<MktActivityPrizeRecordPO>> getPrizeRecordListRpc(@RequestBody MktActivityPrizeRecordPO po);

    /**
     * 获取抽奖活动规则
     * @param
     * @return
     */
    @RequestMapping("selectPrizeList")
    ResponseData<ActivityPrizeBO> selectPrizeList(@RequestParam("activePriceCode") String activePriceCode);

    /**
     * 执行抽奖活动
     * @param activePriceCode
     * @return
     */
    ResponseData<MktActivityPrizePO> executeActivityPrize(@RequestParam("activePriceCode") String activePriceCode,@RequestParam("memberCode") String memberCode);
}
