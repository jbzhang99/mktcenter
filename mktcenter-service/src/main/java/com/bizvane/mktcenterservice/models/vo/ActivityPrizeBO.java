package com.bizvane.mktcenterservice.models.vo;

import com.bizvane.mktcenterservice.models.po.MktActivityPOWithBLOBs;
import com.bizvane.mktcenterservice.models.po.MktActivityPrizePO;
import lombok.Data;

import java.util.List;

/**
 * @Author: lijunwei
 * @Time: 2018/12/25 14:55
 */
@Data
public class ActivityPrizeBO {
    //主表
    private MktActivityPOWithBLOBs activityPO;
    //奖项
    private List<MktActivityPrizePO> activityPrizePOList;
}
