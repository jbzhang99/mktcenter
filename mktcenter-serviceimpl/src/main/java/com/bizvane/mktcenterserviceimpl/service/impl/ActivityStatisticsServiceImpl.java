package com.bizvane.mktcenterserviceimpl.service.impl;

import com.bizvane.mktcenterservice.interfaces.ActivityStatisticsService;
import com.bizvane.mktcenterserviceimpl.common.constants.StatisticsConstants;
import com.bizvane.mktcenterserviceimpl.common.utils.RedisCache;
import com.bizvane.utils.redisutils.RedisTemplateServiceImpl;
import com.bizvane.utils.responseinfo.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 红包活动统计处理实现类
 * @author yy
 * @create 2019-01-08 19:54
 */
@Service
@Slf4j
public class ActivityStatisticsServiceImpl implements ActivityStatisticsService{

    @Autowired
    private RedisTemplateServiceImpl<String, Object> redisTemplateService;

    @Override
    public ResponseData statisticsData(Long activityId, int code) {
        log.info("enter method:==>statisticsData,{},{}",activityId,code);
        //将活动id存入redis中 设置redis的key
        String activityIdsKey = StatisticsConstants.ACTIVITY_LIST_PREFIX + StatisticsConstants.getCurrentDate();
        Set<Long> activityIds = (Set<Long>) redisTemplateService.listLeftPopList(activityIdsKey);
        if (activityIds == null || activityIds.size() == 0) {
            Set<Long> activityIdSet = new HashSet<>();
            activityIdSet.add(activityId);
            redisTemplateService.listLeftPushList(activityIdsKey,activityIdSet);
        }
        return null;
    }
}
