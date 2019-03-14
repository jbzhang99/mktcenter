package com.bizvane.mktcenterfacade.models.vo;

import com.bizvane.mktcenterfacade.models.po.MktActivityRecordPO;

/**
 * Created by agan on 2018/8/6.
 */
public class MktActivityRecordVO extends MktActivityRecordPO {
    private String monthDate;//月份

    public String getMonthDate() {
        return monthDate;
    }

    public void setMonthDate(String monthDate) {
        this.monthDate = monthDate;
    }
}
