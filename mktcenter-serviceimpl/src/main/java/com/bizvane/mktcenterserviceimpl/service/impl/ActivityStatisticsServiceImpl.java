package com.bizvane.mktcenterserviceimpl.service.impl;

import com.bizvane.mktcenterservice.interfaces.ActivityStatisticsService;
import com.bizvane.mktcenterserviceimpl.common.constants.StatisticsConstants;
import com.bizvane.mktcenterserviceimpl.common.enums.StatisticsEnum;
import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.redisutils.RedisTemplateServiceImpl;
import com.bizvane.utils.responseinfo.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
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
        ResponseData responseData = new ResponseData();
        try {
            //将活动id存入redis中 设置redis的key
            String activityIdsKey = StatisticsConstants.ACTIVITY_LIST_PREFIX + StatisticsConstants.getCurrentDate();
            Set<Long> activityIds = (Set<Long>) redisTemplateService.listLeftPopList(activityIdsKey);
            if (activityIds == null || activityIds.size() == 0) {
                Set<Long> activityIdSet = new HashSet<>();
                activityIdSet.add(activityId);
                redisTemplateService.listLeftPushList(activityIdsKey,activityIdSet);
            }else {
                activityIds.add(activityId);
            }
            String key = "";
            //判断要统计的量
            if (StatisticsEnum.VISITORS_COUNT.getCode() == code) {
                //访问量
                key = StatisticsConstants.VISITORS_PREFIX + activityId + "_" + StatisticsConstants.getCurrentDate();
                //访问量要以小时存一份增量数据
                Calendar calendar = Calendar.getInstance();
                String hourKey = key + "_" + calendar.get(Calendar.HOUR_OF_DAY);
                redisTemplateService.stringIncrementLongString(hourKey,1L);
            }else if (StatisticsEnum.LAUNCH_MEMBERS_COUNT.getCode() == code) {
                //发起会员数
                key = StatisticsConstants.LAUNCH_MEMBERS + activityId + "_" + StatisticsConstants.getCurrentDate();
            }else if (StatisticsEnum.HELP_MEMBERS_COUNT.getCode() == code) {
                //助力会员数
                key = StatisticsConstants.HELP_MEMBERS + activityId + "_" + StatisticsConstants.getCurrentDate();
            }else if (StatisticsEnum.REGISTER_MEMBERS_COUNT.getCode() == code) {
                //注册会员数
                key = StatisticsConstants.REGISTER_MEMBERS + activityId + "_" + StatisticsConstants.getCurrentDate();
            }else if (StatisticsEnum.TAKE_COUPON_COUNT.getCode() == code) {
                //领劵数量
                key = StatisticsConstants.TAKE_COUPON + activityId + "_" + StatisticsConstants.getCurrentDate();
            }
            Long incrId = redisTemplateService.stringIncrementLongString(key,1L);
            //Long id = redisTemplateService.getIncrValue(key); todo 获取自增key的value，还不可用
            log.info("统计类型:{} 量为:{}",StatisticsEnum.getStatisticsEnumByCode(code).getMessage(),incrId);
            responseData.setCode(SysResponseEnum.SUCCESS.getCode());
            responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());

        }catch (Exception e){
            log.error(e.getMessage());
            e.printStackTrace();
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(e.getMessage());
        }
        return responseData;
    }
}
