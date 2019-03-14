package com.bizvane.mktcenterfacade.models.bo;

import com.bizvane.mktcenterfacade.models.po.MktActivityRedPacketRecordPO;

/**
 * @Author: lijunwei
 * @Time: 2019/1/15 21:57
 */
public class MktActivityRedPacketRecordBO extends MktActivityRedPacketRecordPO {
    private Integer helpNumber;

    public Integer getHelpNumber() {
        return helpNumber;
    }

    public void setHelpNumber(Integer helpNumber) {
        this.helpNumber = helpNumber;
    }
}
