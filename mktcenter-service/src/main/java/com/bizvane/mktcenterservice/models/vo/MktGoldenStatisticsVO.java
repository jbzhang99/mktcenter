package com.bizvane.mktcenterservice.models.vo;

import com.bizvane.mktcenterservice.models.po.MktGoldenStatisticsPO;

public class MktGoldenStatisticsVO extends MktGoldenStatisticsPO {
    private String statisticsTimes;

    public String getStatisticsTimes() {
        return statisticsTimes;
    }

    public void setStatisticsTimes(String statisticsTimes) {
        this.statisticsTimes = statisticsTimes;
    }
}
