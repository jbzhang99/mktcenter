package com.bizvane.mktcenterserviceimpl.service.impl;

import com.bizvane.mktcenterservice.interfaces.ActivityRedPacketService;
import com.bizvane.mktcenterservice.interfaces.ActivityStatisticsService;
import com.bizvane.mktcenterservice.models.bo.ActivityRedPacketBO;
import com.bizvane.mktcenterservice.models.bo.ActivityStatisticsBO;
import com.bizvane.mktcenterservice.models.po.MktActivityPOWithBLOBs;
import com.bizvane.mktcenterservice.models.po.MktActivityRedPacketPO;
import com.bizvane.mktcenterservice.models.po.MktActivityStatisticsPO;
import com.bizvane.mktcenterservice.models.po.MktActivityStatisticsPOExample;
import com.bizvane.mktcenterservice.models.vo.ActivityRedPacketVO;
import com.bizvane.mktcenterserviceimpl.common.constants.StatisticsConstants;
import com.bizvane.mktcenterserviceimpl.common.enums.StatisticsEnum;
import com.bizvane.mktcenterserviceimpl.common.tools.DateUtil;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityStatisticsPOMapper;
import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.redisutils.RedisTemplateServiceImpl;
import com.bizvane.utils.responseinfo.ResponseData;
import com.qiniu.util.Json;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 红包活动统计处理实现类
 * @author yy
 * @create 2019-01-08 19:54
 */
@Service
@Slf4j
public class ActivityStatisticsServiceImpl implements ActivityStatisticsService{

    @Autowired
    private RedisTemplateServiceImpl redisTemplateService;
    @Autowired
    private MktActivityStatisticsPOMapper mktActivityStatisticsPOMapper;
    @Autowired
    private MktActivityPOMapper mktActivityPOMapper;

    @Override
    public ResponseData statisticsData(Long activityId, int code,String memberCode) {
        log.info("enter ActivityStatisticsServiceImpl method:==>statisticsData,{},{} =====START====",activityId,code);
        ResponseData responseData = new ResponseData();
        try {
            //将活动id存入redis中 设置redis的key
            String today = StatisticsConstants.getCurrentDate();
            String activityIdsKey = StatisticsConstants.ACTIVITY_LIST_PREFIX + today;
            Set activityIds = (Set) redisTemplateService.stringGetStringByKey(activityIdsKey);
            if (activityIds == null || activityIds.size() == 0) {
                Set activityIdSet = new HashSet();
                activityIdSet.add(activityId);
                redisTemplateService.stringSetString(activityIdsKey,activityIdSet);
            }else {
                activityIds.add(activityId);
                redisTemplateService.stringSetString(activityIdsKey,activityIds);
            }
            String key = "";
            //判断要统计的量
            if (StatisticsEnum.VISITORS_COUNT.getCode() == code) {
                //访问量
                key = StatisticsConstants.VISITORS_PREFIX + activityId + "_" + today;
                //访问量要以小时存一份增量数据
                String hourKey = key + "_" + StatisticsConstants.getCurrentHour();
                redisTemplateService.incr(hourKey,StatisticsConstants.REDIS_LIVE_TIME);
            }else if (StatisticsEnum.LAUNCH_MEMBERS_COUNT.getCode() == code) {
                //发起会员数
                key = StatisticsConstants.LAUNCH_MEMBERS + activityId + "_" + today;
            }else if (StatisticsEnum.HELP_MEMBERS_COUNT.getCode() == code) {
                //助力会员数
                key = StatisticsConstants.HELP_MEMBERS + activityId + "_" + today;
            }else if (StatisticsEnum.REGISTER_MEMBERS_COUNT.getCode() == code) {
                //注册会员数
                key = StatisticsConstants.REGISTER_MEMBERS + activityId + "_" + today;
            }else if (StatisticsEnum.TAKE_COUPON_COUNT.getCode() == code) {
                //领劵数量
                key = StatisticsConstants.TAKE_COUPON + activityId + "_" + today;
            }
            redisTemplateService.incr(key,StatisticsConstants.REDIS_LIVE_TIME);
            //获取自增后的值
            Long incrValue = redisTemplateService.getIncrValue(key);
            log.info("统计类型:{} 量为:{}",StatisticsEnum.getStatisticsEnumByCode(code).getMessage(),incrValue);
            responseData.setCode(SysResponseEnum.SUCCESS.getCode());
            responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());

        }catch (Exception e){
            log.error(e.getMessage());
            e.printStackTrace();
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(e.getMessage());
        }
        log.info("enter ActivityStatisticsServiceImpl method =====END====");
        return responseData;
    }

    @Override
    public ResponseData getAllDate() {
        log.info("enter ActivityStatisticsServiceImpl method getAllDate ....START....");
        ResponseData responseData = new ResponseData();
        try {
            List<String> dates = mktActivityStatisticsPOMapper.getAllDate();
            responseData.setCode(SysResponseEnum.SUCCESS.getCode());
            responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
            responseData.setData(dates);
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.FAILED.getMessage());
        }
        log.info("enter ActivityStatisticsServiceImpl method getAllDate ....END....");
        return responseData;
    }

    /**
     * 定时任务 将统计的量入库至数据库中
     * 每天0点1分执行
     */
    @Override
    @Scheduled(cron="0 1 0 * * ?")
    public void schedule() {
        log.info("enter ActivityStatisticsServiceImpl method schedule ....START....");
        try {
            //获取昨天存储的活动id列表
            String yesterday = StatisticsConstants.getYesterday();
            String activityIdsKey = StatisticsConstants.ACTIVITY_LIST_PREFIX;
            String yesterdayKey = activityIdsKey + yesterday;
            Set<Long> activityIds = (Set<Long>) redisTemplateService.stringGetStringByKey(yesterdayKey);
            log.info("昨天的redisKey:{}",yesterdayKey);
            log.info("昨天的活动id列表:{}",activityIds);
            if (activityIds == null || activityIds.size() == 0) {
                //证明昨天无活动触发 就此结束
                log.info(yesterday + " 无活动触发 就此结束定时");
                return;
            }else {
                //获取昨天24小时内的访问量数据
                Map map = new HashMap();
                for (Long activityId:activityIds) {
                    //查询活动详情
                    MktActivityPOWithBLOBs mktActivityPOWithBLOBs = mktActivityPOMapper.selectByPrimaryKey(activityId);
                    if (mktActivityPOWithBLOBs != null) {
                        for (int i = 0; i < 24; i++) {
                            String key = StatisticsConstants.VISITORS_PREFIX + activityId + "_" + yesterday + "_" + i;
                            Long incrValue = redisTemplateService.getIncrValue(key);
                            map.put(i,incrValue);
                        }
                        //查询昨天访问人数
                        String visitorsKey = StatisticsConstants.VISITORS_PREFIX + activityId + "_" + yesterday;
                        Long visitorsCount = redisTemplateService.getIncrValue(visitorsKey);
                        //查询昨天发起会员数
                        String launchMembersKey = StatisticsConstants.LAUNCH_MEMBERS + activityId + "_" + yesterday;
                        Long launchMembersCount = redisTemplateService.getIncrValue(launchMembersKey);
                        //查询助力昨天助力会员数
                        String helpMembersKey = StatisticsConstants.HELP_MEMBERS + activityId + "_" + yesterday;
                        Long helpMembersCount = redisTemplateService.getIncrValue(helpMembersKey);
                        //查询注册会员数
                        String registerMembersKey = StatisticsConstants.REGISTER_MEMBERS + activityId + "_" + yesterday;
                        Long registerMembersCount = redisTemplateService.getIncrValue(registerMembersKey);
                        //领劵数量
                        String takeCouponKey = StatisticsConstants.TAKE_COUPON + activityId + "_" + yesterday;
                        Long takeCouponCount = redisTemplateService.getIncrValue(takeCouponKey);
                        //存储到红包活动分析表中
                        MktActivityStatisticsPO mktActivityStatisticsPO = new MktActivityStatisticsPO();
                        mktActivityStatisticsPO.setSysCompanyId(mktActivityPOWithBLOBs.getSysCompanyId());
                        mktActivityStatisticsPO.setSysBrandId(mktActivityPOWithBLOBs.getSysBrandId());
                        mktActivityStatisticsPO.setMktActivityId(activityId);
                        mktActivityStatisticsPO.setVisitorsCount(visitorsCount.intValue());
                        mktActivityStatisticsPO.setLaunchMembersCount(launchMembersCount.intValue());
                        mktActivityStatisticsPO.setHelpMembersCount(helpMembersCount.intValue());
                        mktActivityStatisticsPO.setRegisterMembersCount(registerMembersCount.intValue());
                        mktActivityStatisticsPO.setTakeCouponCount(takeCouponCount);
                        String json = Json.encode(map);
                        mktActivityStatisticsPO.setHourJsonData(json);
                        mktActivityStatisticsPO.setStatisticsTime(new Date());
                        mktActivityStatisticsPO.setStatisticsType(StatisticsConstants.STATISTICS_TYPE);
                        mktActivityStatisticsPOMapper.insertSelective(mktActivityStatisticsPO);
                    }else {
                        //此活动查不到
                        log.info("活动id：[" + activityId + "],无此活动。");
                        continue;
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
        }
        log.info("enter ActivityStatisticsServiceImpl method schedule ....END....");
    }

    /**
     * 活动分析
     * @param activityId
     * @param time
     * @return
     */
    @Override
    public ResponseData activityAnalysis(Long activityId, String time) {
        ResponseData responseData = new ResponseData();
        Map map = new HashMap();
        //查询当天活动统计记录
        map.put("activityId",activityId);
        map.put("statisticsTime",time);
        map.put("statisticsType",StatisticsConstants.STATISTICS_TYPE);
        ActivityStatisticsBO todayBO = mktActivityStatisticsPOMapper.getBo(map);
        //获取前一天数据
        map.put("statisticsTime",StatisticsConstants.getBeforeOneDate(time));
        ActivityStatisticsBO yesBO = mktActivityStatisticsPOMapper.getBo(map);
        if (todayBO != null) {
            //获取当天的活动详情 todo 获通过今天和昨天的算出比例

        }else {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage("此活动当天未激活");
        }
        return null;
    }

}
