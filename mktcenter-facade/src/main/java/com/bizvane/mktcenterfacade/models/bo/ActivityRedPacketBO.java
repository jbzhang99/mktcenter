package com.bizvane.mktcenterfacade.models.bo;

import com.bizvane.centerstageservice.models.po.SysStorePo;
import com.bizvane.couponfacade.models.po.CouponDefinitionPO;
import com.bizvane.mktcenterfacade.models.po.MktActivityPOWithBLOBs;
import com.bizvane.mktcenterfacade.models.po.MktActivityRedPacketPO;
import com.bizvane.mktcenterfacade.models.vo.DefinedVO;
import lombok.Data;

import java.util.List;

/**
 * @Author: lijunwei
 * @Time: 2019/1/11 13:46
 */
@Data
public class ActivityRedPacketBO {
    //主表
    private MktActivityPOWithBLOBs activityPO;
    //奖励
    private MktActivityRedPacketPO activityRedPacketPO;

    private List<SysStorePo> storeList;

    private CouponDefinitionPO couponDefinitionPO;

    private DefinedVO definedVO;
}
