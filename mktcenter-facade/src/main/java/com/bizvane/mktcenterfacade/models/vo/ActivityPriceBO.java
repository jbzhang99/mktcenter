package com.bizvane.mktcenterfacade.models.vo;

import com.bizvane.centerstageservice.models.po.SysStorePo;
import com.bizvane.mktcenterfacade.models.po.MktActivityPOWithBLOBs;
import lombok.Data;

import java.util.List;

/**
 * @Author: lijunwei
 * @Time: 2018/12/19 14:22
 * 大转盘活动
 */
@Data
public class ActivityPriceBO {
    //主表
    private MktActivityPOWithBLOBs activityPO;
    //奖项
    private List<MktActivityPrizeVO> activityPrizePOList;

    private  List<SysStorePo> storeList;

}
