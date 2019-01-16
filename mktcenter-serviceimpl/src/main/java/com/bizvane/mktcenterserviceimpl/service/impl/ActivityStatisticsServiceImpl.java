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
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
        log.info("enter ActivityStatisticsServiceImpl method:==>statisticsData,{},{},{}=====START====",activityId,code,memberCode);
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
            String visitorsKey = "";
            String hourKey = "";
            if (StatisticsEnum.LAUNCH_MEMBERS_COUNT.getCode() == code) {
                //发起会员数
                key = StatisticsConstants.LAUNCH_MEMBERS + activityId + "_" + today;
                //访问量
                visitorsKey = StatisticsConstants.VISITORS_PREFIX + activityId + "_" + today;
                //访问量要以小时存一份增量数据
                hourKey = visitorsKey + "_" + StatisticsConstants.getCurrentHour();
            }else if (StatisticsEnum.HELP_MEMBERS_COUNT.getCode() == code) {
                //助力会员数
                key = StatisticsConstants.HELP_MEMBERS + activityId + "_" + today;
                //访问量
                visitorsKey = StatisticsConstants.VISITORS_PREFIX + activityId + "_" + today;
                //访问量要以小时存一份增量数据
                hourKey = visitorsKey + "_" + StatisticsConstants.getCurrentHour();
            }else if (StatisticsEnum.REGISTER_MEMBERS_COUNT.getCode() == code) {
                //注册会员数
                key = StatisticsConstants.REGISTER_MEMBERS + activityId + "_" + today;
            }else if (StatisticsEnum.TAKE_COUPON_COUNT.getCode() == code) {
                //领劵数量
                key = StatisticsConstants.TAKE_COUPON + activityId + "_" + today;
            }
            Set memberCodeSet = (Set) redisTemplateService.stringGetStringByKey(key);
            if (memberCodeSet == null) {
                memberCodeSet = new HashSet();
                memberCodeSet.add(memberCode);
                redisTemplateService.stringSetString(key,memberCodeSet);
            }else {
                memberCodeSet.add(memberCode);
                redisTemplateService.stringSetString(key,memberCodeSet);
            }


            if (StringUtils.isNotBlank(visitorsKey) && StringUtils.isNotBlank(hourKey)) {
                Set visitorsMemberCodeSet = (Set) redisTemplateService.stringGetStringByKey(visitorsKey);
                if (visitorsMemberCodeSet == null) {
                    visitorsMemberCodeSet = new HashSet();
                    visitorsMemberCodeSet.add(memberCode);
                }else {
                    visitorsMemberCodeSet.add(memberCode);
                }
                redisTemplateService.stringSetString(visitorsKey,memberCodeSet);

                Set hourMemberCodeSet = (Set) redisTemplateService.stringGetStringByKey(hourKey);
                if (hourMemberCodeSet == null) {
                    hourMemberCodeSet = new HashSet();
                    hourMemberCodeSet.add(memberCode);
                }else {
                    hourMemberCodeSet.add(memberCode);
                }
                redisTemplateService.stringSetString(hourKey,hourMemberCodeSet);
            }

            log.info("统计类型:{}",StatisticsEnum.getStatisticsEnumByCode(code).getMessage());
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
    public ResponseData getAllDate(Long activityId) {
        log.info("enter ActivityStatisticsServiceImpl method getAllDate ....START....");
        ResponseData responseData = new ResponseData();
        try {
            List<String> dates = mktActivityStatisticsPOMapper.getAllDate(activityId);
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
                            Set hourMemberCodeSet = (Set) redisTemplateService.stringGetStringByKey(key);
                            int count = hourMemberCodeSet == null?0:hourMemberCodeSet.size();
                            map.put(i + ":00",count);
                        }
                        //查询昨天访问人数
                        String visitorsKey = StatisticsConstants.VISITORS_PREFIX + activityId + "_" + yesterday;
                        Set visitorsMemberCodeSet = (Set) redisTemplateService.stringGetStringByKey(visitorsKey);
                        int visitorsCount = visitorsMemberCodeSet == null?0:visitorsMemberCodeSet.size();
                        //查询昨天发起会员数
                        String launchMembersKey = StatisticsConstants.LAUNCH_MEMBERS + activityId + "_" + yesterday;
                        Set launchMemberCodeSet = (Set) redisTemplateService.stringGetStringByKey(launchMembersKey);
                        int launchMembersCount = launchMemberCodeSet == null?0:launchMemberCodeSet.size();
                        //查询助力昨天助力会员数
                        String helpMembersKey = StatisticsConstants.HELP_MEMBERS + activityId + "_" + yesterday;
                        Set helpMemberCodeSet = (Set) redisTemplateService.stringGetStringByKey(helpMembersKey);
                        int helpMembersCount = helpMemberCodeSet == null?0:helpMemberCodeSet.size();
                        //查询注册会员数
                        String registerMembersKey = StatisticsConstants.REGISTER_MEMBERS + activityId + "_" + yesterday;
                        Set registerMemberCodeSet = (Set) redisTemplateService.stringGetStringByKey(registerMembersKey);
                        int registerMembersCount = registerMemberCodeSet == null?0:registerMemberCodeSet.size();
                        //领劵数量
                        String takeCouponKey = StatisticsConstants.TAKE_COUPON + activityId + "_" + yesterday;
                        Set takeCouponMemberCodeSet = (Set) redisTemplateService.stringGetStringByKey(takeCouponKey);
                        int takeCouponCount = takeCouponMemberCodeSet == null?0:takeCouponMemberCodeSet.size();

                        //存储到红包活动分析表中
                        MktActivityStatisticsPO mktActivityStatisticsPO = new MktActivityStatisticsPO();
                        mktActivityStatisticsPO.setSysCompanyId(mktActivityPOWithBLOBs.getSysCompanyId());
                        mktActivityStatisticsPO.setSysBrandId(mktActivityPOWithBLOBs.getSysBrandId());
                        mktActivityStatisticsPO.setMktActivityId(activityId);
                        mktActivityStatisticsPO.setVisitorsCount(visitorsCount);
                        mktActivityStatisticsPO.setLaunchMembersCount(launchMembersCount);
                        mktActivityStatisticsPO.setHelpMembersCount(helpMembersCount);
                        mktActivityStatisticsPO.setRegisterMembersCount(registerMembersCount);
                        mktActivityStatisticsPO.setTakeCouponCount(Long.parseLong(String.valueOf(takeCouponCount)));
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
        String beforeTimeStr = StatisticsConstants.getBeforeOneDate(time);
        map.put("statisticsTime",beforeTimeStr);
        ActivityStatisticsBO yesBO = mktActivityStatisticsPOMapper.getBo(map);
        if (todayBO == null) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage("此活动当天未激活");
            return responseData;
        }
        if (yesBO != null) {
            //昨天为null时就为缺省值
            todayBO.setScaleVisitorsCount(BigDecimal.valueOf(todayBO.getVisitorsCount()-yesBO.getVisitorsCount()).divide(BigDecimal.valueOf(yesBO.getVisitorsCount()),4,BigDecimal.ROUND_HALF_UP).multiply(BigDecimal.valueOf(100L)).setScale(2,BigDecimal.ROUND_HALF_UP));
            todayBO.setScaleLaunchMembersCount(BigDecimal.valueOf(todayBO.getLaunchMembersCount()-yesBO.getLaunchMembersCount()).divide(BigDecimal.valueOf(yesBO.getLaunchMembersCount()),4,BigDecimal.ROUND_HALF_UP).multiply(BigDecimal.valueOf(100L)).setScale(2,BigDecimal.ROUND_HALF_UP));
            todayBO.setScaleHelpMembersCount(BigDecimal.valueOf(todayBO.getHelpMembersCount()-yesBO.getHelpMembersCount()).divide(BigDecimal.valueOf(yesBO.getHelpMembersCount()),4,BigDecimal.ROUND_HALF_UP).multiply(BigDecimal.valueOf(100L)).setScale(2,BigDecimal.ROUND_HALF_UP));
            todayBO.setScaleRegisterMembersCount(BigDecimal.valueOf(todayBO.getRegisterMembersCount()-yesBO.getRegisterMembersCount()).divide(BigDecimal.valueOf(yesBO.getRegisterMembersCount()),4,BigDecimal.ROUND_HALF_UP).multiply(BigDecimal.valueOf(100L)).setScale(2,BigDecimal.ROUND_HALF_UP));
            todayBO.setScaleTakeCouponCount(BigDecimal.valueOf(todayBO.getTakeCouponCount()-yesBO.getTakeCouponCount()).divide(BigDecimal.valueOf(yesBO.getTakeCouponCount()),4,BigDecimal.ROUND_HALF_UP).multiply(BigDecimal.valueOf(100L)).setScale(2,BigDecimal.ROUND_HALF_UP));
        }
        MktActivityPOWithBLOBs mktActivityPOWithBLOBs = mktActivityPOMapper.selectByPrimaryKey(activityId);
        Date startTime = mktActivityPOWithBLOBs.getStartTime();
        Date todayDate = DateUtil.stringToDate(time,DateUtil.ymd);
        MktActivityStatisticsPOExample example = new MktActivityStatisticsPOExample();
        //获取从活动开始时间到当前时间的各项累计数据
        example.createCriteria().andMktActivityIdEqualTo(activityId).andStatisticsTypeEqualTo(StatisticsConstants.STATISTICS_TYPE)
                .andStatisticsTimeBetween(startTime,todayDate);
        List<MktActivityStatisticsPO> todayList = mktActivityStatisticsPOMapper.selectByExample(example);
        if (todayList != null && todayList.size() > 0) {
            todayList.forEach(todayPo -> {
                todayBO.setTotalVisitorsCount((todayBO.getTotalVisitorsCount() == null?0:todayBO.getTotalVisitorsCount()) + todayPo.getVisitorsCount());
                todayBO.setTotalLaunchMembersCount((todayBO.getTotalLaunchMembersCount() == null?0:todayBO.getTotalLaunchMembersCount()) + todayPo.getLaunchMembersCount());
                todayBO.setTotalHelpMembersCount((todayBO.getTotalHelpMembersCount() == null?0:todayBO.getTotalHelpMembersCount()) + todayPo.getHelpMembersCount());
                todayBO.setTotalRegisterMembersCount((todayBO.getTotalRegisterMembersCount()==null?0:todayBO.getTotalRegisterMembersCount()) + todayPo.getRegisterMembersCount());
                todayBO.setTotalTakeCouponCount((todayBO.getTotalTakeCouponCount()==null?0:todayBO.getTotalTakeCouponCount()) + todayPo.getTakeCouponCount());
            });
        }
        //获取从活动开始时间到当前时间前一天的各项累计数据
        Date yesDate = yesBO.getStatisticsTime();
        MktActivityStatisticsPOExample yesExample = new MktActivityStatisticsPOExample();
        yesExample.createCriteria().andMktActivityIdEqualTo(activityId).andStatisticsTypeEqualTo(StatisticsConstants.STATISTICS_TYPE)
                .andStatisticsTimeBetween(startTime,yesDate);
        List<MktActivityStatisticsPO> yesList = mktActivityStatisticsPOMapper.selectByExample(yesExample);
        if (yesList != null && yesList.size() > 0) {
            yesList.forEach(yesPo -> {
                yesBO.setTotalVisitorsCount((yesBO.getTotalVisitorsCount() == null?0:yesBO.getTotalVisitorsCount()) + yesPo.getVisitorsCount());
                yesBO.setTotalLaunchMembersCount((yesBO.getTotalLaunchMembersCount() == null?0:yesBO.getTotalLaunchMembersCount()) + yesPo.getLaunchMembersCount());
                yesBO.setTotalHelpMembersCount((yesBO.getTotalHelpMembersCount() == null?0:yesBO.getTotalHelpMembersCount()) + yesPo.getHelpMembersCount());
                yesBO.setTotalRegisterMembersCount((yesBO.getTotalRegisterMembersCount()==null?0:yesBO.getTotalRegisterMembersCount()) + yesPo.getRegisterMembersCount());
                yesBO.setTotalTakeCouponCount((yesBO.getTotalTakeCouponCount()==null?0:yesBO.getTotalTakeCouponCount()) + yesPo.getTakeCouponCount());
            });
            //算出累计数据的比例
            todayBO.setScaleTotalVisitorsCount(BigDecimal.valueOf(todayBO.getTotalVisitorsCount()-yesBO.getTotalVisitorsCount()).divide(BigDecimal.valueOf(yesBO.getTotalVisitorsCount()),4,BigDecimal.ROUND_HALF_UP).multiply(BigDecimal.valueOf(100L)).setScale(2,BigDecimal.ROUND_HALF_UP));
            todayBO.setScaleTotalLaunchMembersCount(BigDecimal.valueOf(todayBO.getTotalLaunchMembersCount()-yesBO.getTotalLaunchMembersCount()).divide(BigDecimal.valueOf(yesBO.getTotalLaunchMembersCount()),4,BigDecimal.ROUND_HALF_UP).multiply(BigDecimal.valueOf(100L)).setScale(2,BigDecimal.ROUND_HALF_UP));
            todayBO.setScaleTotalHelpMembersCount(BigDecimal.valueOf(todayBO.getTotalHelpMembersCount()-yesBO.getTotalHelpMembersCount()).divide(BigDecimal.valueOf(yesBO.getTotalHelpMembersCount()),4,BigDecimal.ROUND_HALF_UP).multiply(BigDecimal.valueOf(100L)).setScale(2,BigDecimal.ROUND_HALF_UP));
            todayBO.setScaleTotalRegisterMembersCount(BigDecimal.valueOf(todayBO.getTotalRegisterMembersCount()-yesBO.getTotalRegisterMembersCount()).divide(BigDecimal.valueOf(yesBO.getTotalRegisterMembersCount()),4,BigDecimal.ROUND_HALF_UP).multiply(BigDecimal.valueOf(100L)).setScale(2,BigDecimal.ROUND_HALF_UP));
            todayBO.setScaleTotalTakeCouponCount(BigDecimal.valueOf(todayBO.getTotalTakeCouponCount()-yesBO.getTotalTakeCouponCount()).divide(BigDecimal.valueOf(yesBO.getTotalTakeCouponCount()),4,BigDecimal.ROUND_HALF_UP).multiply(BigDecimal.valueOf(100L)).setScale(2,BigDecimal.ROUND_HALF_UP));
        }
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        responseData.setData(todayBO);
        return responseData;
    }

    /**
     * 曲线图数据
     * @param activityId
     * @param time
     * @param type
     * @return
     */
    @Override
    public ResponseData curveData(Long activityId, String time, int type) {
        ResponseData responseData = new ResponseData();
        Date current = DateUtil.stringToDate(time,DateUtil.ymd);
        if (type == StatisticsConstants.CURVE_HOUR) {
            MktActivityStatisticsPOExample example = new MktActivityStatisticsPOExample();
            example.createCriteria().andMktActivityIdEqualTo(activityId).andStatisticsTypeEqualTo(StatisticsConstants.STATISTICS_TYPE)
                    .andStatisticsTimeEqualTo(current);
            List<MktActivityStatisticsPO> statisticsPOList = mktActivityStatisticsPOMapper.selectByExampleWithBLOBs(example);
            if (statisticsPOList != null && statisticsPOList.size() > 0) {
                MktActivityStatisticsPO statisticsPO = statisticsPOList.get(0);
                Map map = Json.decode(statisticsPO.getHourJsonData(),Map.class);
                responseData.setCode(SysResponseEnum.SUCCESS.getCode());
                responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
                responseData.setData(map);
            }else {
                responseData.setCode(SysResponseEnum.FAILED.getCode());
                responseData.setMessage(SysResponseEnum.FAILED.getMessage());
            }
        }if (type == StatisticsConstants.CURVE_DAY) {
            MktActivityStatisticsPOExample example = new MktActivityStatisticsPOExample();
            Date fifteenDate = StatisticsConstants.getFifteenDay(time);
            example.createCriteria().andMktActivityIdEqualTo(activityId).andStatisticsTypeEqualTo(StatisticsConstants.STATISTICS_TYPE)
                    .andStatisticsTimeBetween(fifteenDate,current);
            List<MktActivityStatisticsPO> statisticsPOS = mktActivityStatisticsPOMapper.selectByExampleWithBLOBs(example);
            if (statisticsPOS != null && statisticsPOS.size() > 0) {
                Map map = new HashMap();
                statisticsPOS.forEach(po -> {
                    map.put(DateUtil.format(po.getStatisticsTime(),DateUtil.ymd),po.getVisitorsCount());
                });
                responseData.setCode(SysResponseEnum.SUCCESS.getCode());
                responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
                responseData.setData(map);
            }else {
                responseData.setCode(SysResponseEnum.FAILED.getCode());
                responseData.setMessage(SysResponseEnum.FAILED.getMessage());
            }
        }
        return responseData;
    }

}
