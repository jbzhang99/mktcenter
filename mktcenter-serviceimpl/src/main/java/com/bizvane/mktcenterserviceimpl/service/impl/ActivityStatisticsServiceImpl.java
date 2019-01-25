package com.bizvane.mktcenterserviceimpl.service.impl;


import com.bizvane.mktcenterservice.interfaces.ActivityStatisticsService;
import com.bizvane.mktcenterservice.models.po.MktActivityPOWithBLOBs;
import com.bizvane.mktcenterservice.models.po.MktActivityStatisticsPO;
import com.bizvane.mktcenterservice.models.po.MktActivityStatisticsPOExample;
import com.bizvane.mktcenterserviceimpl.common.constants.StatisticsConstants;
import com.bizvane.mktcenterserviceimpl.common.enums.StatisticsEnum;
import com.bizvane.mktcenterserviceimpl.common.tools.DateUtil;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityStatisticsPOMapper;
import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.redisutils.RedisTemplateServiceImpl;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.qiniu.util.Json;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
        log.info("enter ActivityStatisticsServiceImpl method:==>statisticsData,{},{},{}=====START====",activityId,code,memberCode);
        ResponseData responseData = new ResponseData();
        try {
            //查询活动id
            MktActivityPOWithBLOBs mktActivityPOWithBLOBs = mktActivityPOMapper.selectByPrimaryKey(activityId);
            String today = StatisticsConstants.getCurrentDate();
            String key = "";
            String visitorsKey = "";
            String hourKey = "";
            if (StatisticsEnum.LAUNCH_MEMBERS_COUNT.getCode() == code) {
                //发起会员数
                key = StatisticsConstants.LAUNCH_MEMBERS + activityId + "_" + today;
                //访问量要以小时存一份增量数据
                visitorsKey = StatisticsConstants.VISITORS_PREFIX + activityId + "_" + today;
                hourKey = visitorsKey + "_" + StatisticsConstants.getCurrentHour();
                //累计发起会员数
                String totalLaunch = StatisticsConstants.TOTAL_LAUNCH_MEMBERS + activityId;
                Set totalLaunchSet = (Set) redisTemplateService.stringGetStringByKey(totalLaunch);
                if (totalLaunchSet == null) {
                    totalLaunchSet = new HashSet();
                }
                totalLaunchSet.add(memberCode);
                redisTemplateService.stringSetValueAndExpireTime(totalLaunch,totalLaunchSet,StatisticsConstants.getTimeIntervalMilliseconds(mktActivityPOWithBLOBs.getStartTime(),mktActivityPOWithBLOBs.getEndTime()));
            }else if (StatisticsEnum.HELP_MEMBERS_COUNT.getCode() == code) {
                //助力会员数
                key = StatisticsConstants.HELP_MEMBERS + activityId + "_" + today;
                //访问量
                visitorsKey = StatisticsConstants.VISITORS_PREFIX + activityId + "_" + today;
                hourKey = visitorsKey + "_" + StatisticsConstants.getCurrentHour();
                //累计助力会员数
                String totalHelp = StatisticsConstants.TOTAL_HELP_MEMBERS + activityId;
                Set totalHelpSet = (Set) redisTemplateService.stringGetStringByKey(totalHelp);
                if (totalHelpSet == null) {
                    totalHelpSet = new HashSet();
                }
                totalHelpSet.add(memberCode);
                redisTemplateService.stringSetValueAndExpireTime(totalHelp,totalHelpSet,StatisticsConstants.getTimeIntervalMilliseconds(mktActivityPOWithBLOBs.getStartTime(),mktActivityPOWithBLOBs.getEndTime()));
            }else if (StatisticsEnum.REGISTER_MEMBERS_COUNT.getCode() == code) {
                //注册会员数
                key = StatisticsConstants.REGISTER_MEMBERS + activityId + "_" + today;
                //累计注册会员数
                String totalregister = StatisticsConstants.TOTAL_REGISTER_MEMBERS + activityId;
                Set totalregisterSet = (Set) redisTemplateService.stringGetStringByKey(totalregister);
                if (totalregisterSet == null) {
                    totalregisterSet = new HashSet();
                }
                totalregisterSet.add(memberCode);
                redisTemplateService.stringSetValueAndExpireTime(totalregister,totalregisterSet,StatisticsConstants.getTimeIntervalMilliseconds(mktActivityPOWithBLOBs.getStartTime(),mktActivityPOWithBLOBs.getEndTime()));
            }else if (StatisticsEnum.TAKE_COUPON_COUNT.getCode() == code) {
                //领劵数量
                key = StatisticsConstants.TAKE_COUPON + activityId + "_" + today;
                //累计领劵数量
                String totaltake = StatisticsConstants.TOTAL_TAKE_COUPON + activityId;
                Set totaltakeSet = (Set) redisTemplateService.stringGetStringByKey(totaltake);
                if (totaltakeSet == null) {
                    totaltakeSet = new HashSet();
                }
                totaltakeSet.add(memberCode);
                redisTemplateService.stringSetValueAndExpireTime(totaltake,totaltakeSet,StatisticsConstants.getTimeIntervalMilliseconds(mktActivityPOWithBLOBs.getStartTime(),mktActivityPOWithBLOBs.getEndTime()));
            }
            Set memberCodeSet = (Set) redisTemplateService.stringGetStringByKey(key);
            if (memberCodeSet == null) {
                memberCodeSet = new HashSet();
            }
            memberCodeSet.add(memberCode);
            redisTemplateService.stringSetValueAndExpireTime(key,memberCodeSet,StatisticsConstants.REDIS_LIVE_TIME);

            if (StringUtils.isNotBlank(visitorsKey) && StringUtils.isNotBlank(hourKey)) {
                /*Set visitorsMemberCodeSet = (Set) redisTemplateService.stringGetStringByKey(visitorsKey);
                if (CollectionUtils.isEmpty(visitorsMemberCodeSet)) {
                    visitorsMemberCodeSet = new HashSet();
                }
                visitorsMemberCodeSet.add(memberCode);
                redisTemplateService.stringSetValueAndExpireTime(visitorsKey,visitorsMemberCodeSet,StatisticsConstants.REDIS_LIVE_TIME);*/

                Set hourMemberCodeSet = (Set) redisTemplateService.stringGetStringByKey(hourKey);
                if (CollectionUtils.isEmpty(hourMemberCodeSet)) {
                    hourMemberCodeSet = new HashSet();
                }
                hourMemberCodeSet.add(memberCode);
                redisTemplateService.stringSetValueAndExpireTime(hourKey,hourMemberCodeSet,StatisticsConstants.REDIS_LIVE_TIME);
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
            if (dates.isEmpty()) {
                responseData.setCode(SysResponseEnum.OPERATE_FAILED_DATA_NOT_EXISTS.getCode());
                responseData.setMessage(SysResponseEnum.OPERATE_FAILED_DATA_NOT_EXISTS.getMessage());

                MktActivityStatisticsPO todayBO = new MktActivityStatisticsPO();
                todayBO.setVisitorsCount(0);
                todayBO.setLaunchMembersCount(0);
                todayBO.setHelpMembersCount(0);
                todayBO.setRegisterMembersCount(0);
                todayBO.setTakeCouponCount(0L);
                todayBO.setTotalVisitorsCount(0L);
                todayBO.setTotalLaunchMembersCount(0L);
                todayBO.setTotalHelpMembersCount(0L);
                todayBO.setTotalRegisterMembersCount(0L);
                todayBO.setTotalTakeCouponCount(0L);

                responseData.setData(todayBO);
            }else {
                responseData.setCode(SysResponseEnum.SUCCESS.getCode());
                responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
                responseData.setData(dates);
            }
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
    /*@Override
    @Scheduled(cron="0 1 0 * * ?")
    public void schedule() {
        log.info("enter ActivityStatisticsServiceImpl method schedule ....START....");
        try {
            //获取活动id列表
            MktActivityPOExample example = new MktActivityPOExample();
            example.createCriteria().andActivityTypeEqualTo(12).andActivityStatusEqualTo(2).andValidEqualTo(true);
            List<MktActivityPOWithBLOBs> activityIds = mktActivityPOMapper.selectByExampleWithBLOBs(example);
            log.info("活动id列表:{}",activityIds);
            if (CollectionUtils.isEmpty(activityIds)) {
                //证明昨天无活动触发 就此结束
                log.info("无活动id列表就此结束定时");
                return;
            }
            String yesterday = StatisticsConstants.getYesterday();
            //获取昨天24小时内的访问量数据
            Map map = new TreeMap();
            for (MktActivityPOWithBLOBs activity:activityIds) {
                Long activityId = activity.getMktActivityId();
                for (int i = 0; i < 24; i++) {
                    String key = StatisticsConstants.VISITORS_PREFIX + activityId + "_" + yesterday + "_" + i;
                    Set hourMemberCodeSet = (Set) redisTemplateService.stringGetStringByKey(key);
                    int count = hourMemberCodeSet == null?0:hourMemberCodeSet.size();
                    if (i < 10) {
                        map.put("0" + i + ":00" ,count);
                    }else {
                        map.put(i + ":00" ,count);
                    }
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
                mktActivityStatisticsPO.setSysCompanyId(activity.getSysCompanyId());
                mktActivityStatisticsPO.setSysBrandId(activity.getSysBrandId());
                mktActivityStatisticsPO.setMktActivityId(activityId);
                mktActivityStatisticsPO.setVisitorsCount(visitorsCount);
                mktActivityStatisticsPO.setLaunchMembersCount(launchMembersCount);
                mktActivityStatisticsPO.setHelpMembersCount(helpMembersCount);
                mktActivityStatisticsPO.setRegisterMembersCount(registerMembersCount);
                mktActivityStatisticsPO.setTakeCouponCount(Long.parseLong(String.valueOf(takeCouponCount)));
                String json = Json.encode(map);
                mktActivityStatisticsPO.setHourJsonData(json);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(new Date());
                calendar.add(Calendar.DATE,-1);
                mktActivityStatisticsPO.setStatisticsTime(calendar.getTime());
                mktActivityStatisticsPO.setStatisticsType(StatisticsConstants.STATISTICS_TYPE);
                mktActivityStatisticsPOMapper.insertSelective(mktActivityStatisticsPO);
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
        }
        log.info("enter ActivityStatisticsServiceImpl method schedule ....END....");
    }*/

    /**
     * 活动分析
     * @param activityId
     * @param time
     * @return
     */
    @Override
    public ResponseData activityAnalysis(Long activityId, String time, SysAccountPO sysAccountPO) {
        ResponseData responseData = new ResponseData();
        Date todayDate = DateUtil.stringToDate(time,DateUtil.ymd);
        MktActivityStatisticsPOExample example = new MktActivityStatisticsPOExample();
        //获取从活动开始时间到当前时间的各项累计数据
        example.createCriteria().andMktActivityIdEqualTo(activityId).andStatisticsTypeEqualTo(StatisticsConstants.STATISTICS_TYPE)
                .andStatisticsTimeEqualTo(todayDate).andSysBrandIdEqualTo(sysAccountPO.getBrandId()).andSysCompanyIdEqualTo(sysAccountPO.getSysCompanyId()).andValidEqualTo(true);
        List<MktActivityStatisticsPO> todayList = mktActivityStatisticsPOMapper.selectByExample(example);
        if (CollectionUtils.isNotEmpty(todayList)) {
            responseData.setCode(SysResponseEnum.SUCCESS.getCode());
            responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
            responseData.setData(todayList.get(0));
        }else {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.FAILED.getMessage());
        }
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
    public ResponseData curveData(Long activityId, String time, int type, SysAccountPO sysAccountPO) {
        ResponseData responseData = new ResponseData();
        Date current = DateUtil.stringToDate(time,DateUtil.ymd);
        if (type == StatisticsConstants.CURVE_HOUR) {
            MktActivityStatisticsPOExample example = new MktActivityStatisticsPOExample();
            example.createCriteria().andMktActivityIdEqualTo(activityId).andStatisticsTypeEqualTo(StatisticsConstants.STATISTICS_TYPE)
                    .andStatisticsTimeEqualTo(current).andSysCompanyIdEqualTo(sysAccountPO.getSysCompanyId()).andSysBrandIdEqualTo(sysAccountPO.getBrandId()).andValidEqualTo(true);
            List<MktActivityStatisticsPO> statisticsPOList = mktActivityStatisticsPOMapper.selectByExampleWithBLOBs(example);
            if (CollectionUtils.isNotEmpty(statisticsPOList)) {
                MktActivityStatisticsPO statisticsPO = statisticsPOList.get(0);
                Map map = Json.decode(statisticsPO.getHourJsonData(),Map.class);
                responseData.setCode(SysResponseEnum.SUCCESS.getCode());
                responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
                responseData.setData(map);
            }else {
                responseData.setCode(SysResponseEnum.FAILED.getCode());
                responseData.setMessage(SysResponseEnum.FAILED.getMessage());
            }
        }else if (type == StatisticsConstants.CURVE_DAY) {
            MktActivityStatisticsPOExample example = new MktActivityStatisticsPOExample();
            Date fifteenDate = StatisticsConstants.getFifteenDay(time);
            example.createCriteria().andMktActivityIdEqualTo(activityId).andStatisticsTypeEqualTo(StatisticsConstants.STATISTICS_TYPE)
                    .andStatisticsTimeBetween(fifteenDate,current).andSysCompanyIdEqualTo(sysAccountPO.getSysCompanyId()).andSysBrandIdEqualTo(sysAccountPO.getBrandId()).andValidEqualTo(true);
            List<MktActivityStatisticsPO> statisticsPOS = mktActivityStatisticsPOMapper.selectByExampleWithBLOBs(example);
            if (!statisticsPOS.isEmpty()) {
                Map map = new TreeMap();
                for (MktActivityStatisticsPO po:statisticsPOS) {
                    map.put(DateUtil.format(po.getStatisticsTime(),DateUtil.ymd),po.getVisitorsCount());
                }
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
