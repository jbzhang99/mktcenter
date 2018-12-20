package com.bizvane.mktcenterserviceimpl.controllers.rpc;

import com.bizvane.mktcenterservice.interfaces.ActivityPrizeServiceWX;
import com.bizvane.mktcenterservice.models.po.MktActivityPrizeRecordPO;
import com.bizvane.mktcenterservice.models.vo.ActivityPriceBO;
import com.bizvane.mktcenterservice.models.vo.MktActivityPrizeRecordVO;
import com.bizvane.utils.responseinfo.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by agan on 2018/12/19.
 */
@RestController
@RequestMapping("activityPrizeRpc")
public class ActivityPrizeRpcController {

    @Autowired
    private ActivityPrizeServiceWX activityPrizeServiceWX;
    /**
     * 小程序获取中奖纪录 和中奖纪录轮播
     * @param po
     * @return
     */
    @RequestMapping("getPrizeRecordListRpc")
    ResponseData<List<MktActivityPrizeRecordPO>> getPrizeRecordListRpc(@RequestBody MktActivityPrizeRecordPO po){
        return activityPrizeServiceWX.getPrizeRecordList(po);
    }

    /**
     * 获取抽奖活动规则
     * @param vo
     * @return
     */
    @RequestMapping("selectPrizeList")
    ResponseData<ActivityPriceBO> selectPrizeList(@RequestBody MktActivityPrizeRecordVO vo){
        return activityPrizeServiceWX.selectPrizeList(vo);
    }
}
