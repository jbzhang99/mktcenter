package com.bizvane.mktcenterservice.models.bo;

import com.bizvane.mktcenterservice.models.po.MktActivityRedPacketRecordPO;

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
