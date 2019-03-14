package com.bizvane.mktcenterfacade.interfaces;

import com.bizvane.mktcenterfacade.models.bo.ActivityGoldenStatisticsBo;
import com.bizvane.utils.responseinfo.ResponseData;

/**
 * 砸金蛋活动统计
 *
 * @author liufq
 * */
public interface ActivityGoldenStatisticsService {
    /**
     * 砸金蛋活动统计
     *
     * @param bo
     * @return
     * */
    ResponseData goldenStatisticsData(ActivityGoldenStatisticsBo bo);

    /**
     * 砸金蛋活动概括
     *
     * @param activityId
     *
     * @return
     * */
    ResponseData goldenActivityGeneralization(Long activityId);

    /**
     * 根据日期区间获取统计数据
     *
     * @param bo
     * @return
     * */
    ResponseData goldenActivityGeneralizationDate(ActivityGoldenStatisticsBo bo);

    /**
     * 定时任务测试接口
     *
     * */
    ResponseData goldenExecute();
}
