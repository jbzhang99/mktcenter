package com.bizvane.mktcenterservice.interfaces;

import com.bizvane.utils.responseinfo.ResponseData;

/**
 * @author yy
 * @create 2019-01-10 11:19
 */
public interface ActivityStatisticsService {

    public ResponseData statisticsData(Long activityId, int code);
}
