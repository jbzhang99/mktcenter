package com.bizvane.mktcenterfacade.models.bo;

import java.math.BigDecimal;

/**
 * @Author: lijunwei
 * @Time: 2018/8/8 13:06
 */
public class TotalStatisticsBO {
    private BigDecimal totalConsume;
    private  Integer totalTimes;

    public BigDecimal getTotalConsume() {
        return totalConsume;
    }

    public void setTotalConsume(BigDecimal totalConsume) {
        this.totalConsume = totalConsume;
    }

    public Integer getTotalTimes() {
        return totalTimes;
    }

    public void setTotalTimes(Integer totalTimes) {
        this.totalTimes = totalTimes;
    }
}
