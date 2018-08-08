package com.bizvane.mktcenterservice.models.bo;

import java.math.BigDecimal;

/**
 * @Author: lijunwei
 * @Time: 2018/8/8 13:06
 */
public class TotalStatisticsBO {
    private BigDecimal totalConsume;
    private  Long totalTimes;

    public BigDecimal getTotalConsume() {
        return totalConsume;
    }

    public void setTotalConsume(BigDecimal totalConsume) {
        this.totalConsume = totalConsume;
    }

    public Long getTotalTimes() {
        return totalTimes;
    }

    public void setTotalTimes(Long totalTimes) {
        this.totalTimes = totalTimes;
    }
}
