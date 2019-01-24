package com.bizvane.mktcenterserviceimpl.service.impl;


import com.bizvane.mktcenterservice.interfaces.ActivityStatisticsService;
import com.bizvane.mktcenterservice.models.bo.ActivityStatisticsBO;
import com.bizvane.mktcenterservice.models.po.MktActivityPOExample;
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
            String today = StatisticsConstants.getCurrentDate();
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
            }
            memberCodeSet.add(memberCode);
            redisTemplateService.stringSetValueAndExpireTime(key,memberCodeSet,StatisticsConstants.REDIS_LIVE_TIME);

            if (StringUtils.isNotBlank(visitorsKey) && StringUtils.isNotBlank(hourKey)) {
                Set visitorsMemberCodeSet = (Set) redisTemplateService.stringGetStringByKey(visitorsKey);
                if (CollectionUtils.isEmpty(visitorsMemberCodeSet)) {
                    visitorsMemberCodeSet = new HashSet();
                }
                visitorsMemberCodeSet.add(memberCode);
                redisTemplateService.stringSetValueAndExpireTime(visitorsKey,visitorsMemberCodeSet,StatisticsConstants.REDIS_LIVE_TIME);

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

                ActivityStatisticsBO todayBO = new ActivityStatisticsBO();
                todayBO.setVisitorsCount(0);
                todayBO.setLaunchMembersCount(0);
                todayBO.setHelpMembersCount(0);
                todayBO.setRegisterMembersCount(0);
                todayBO.setTakeCouponCount(0L);
                todayBO.setTotalVisitorsCount(0);
                todayBO.setTotalLaunchMembersCount(0);
                todayBO.setTotalHelpMembersCount(0);
                todayBO.setTotalRegisterMembersCount(0);
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
    @Override
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
    }

    /**
     * 活动分析
     * @param activityId
     * @param time
     * @return
     */
    @Override
    public ResponseData activityAnalysis(Long activityId, String time, SysAccountPO sysAccountPO) {
        ResponseData responseData = new ResponseData();
        Map map = new HashMap();
        //查询当天活动统计记录
        map.put("activityId",activityId);
        map.put("statisticsTime",time);
        map.put("statisticsType",StatisticsConstants.STATISTICS_TYPE);
        map.put("sysCompanyId",sysAccountPO.getSysCompanyId());
        map.put("sysBrandId",sysAccountPO.getBrandId());
        ActivityStatisticsBO todayBO = mktActivityStatisticsPOMapper.getBo(map);
        //获取前一天数据
        /*String beforeTimeStr = StatisticsConstants.getBeforeOneDate(time);
        map.put("statisticsTime",beforeTimeStr);
        ActivityStatisticsBO yesBO = mktActivityStatisticsPOMapper.getBo(map);*/
        if (todayBO == null) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage("此活动当天未激活");
            return responseData;
        }
        /*Date yesDate = null;
        if (yesBO != null) {
            //昨天为null时就为缺省值
            todayBO.setScaleVisitorsCount(BigDecimal.valueOf(Long.parseLong(String.valueOf(todayBO.getVisitorsCount()-yesBO.getVisitorsCount()))).divide(BigDecimal.valueOf(yesBO.getVisitorsCount()),4,BigDecimal.ROUND_HALF_UP).multiply(BigDecimal.valueOf(100L)).setScale(2,BigDecimal.ROUND_HALF_UP));
            todayBO.setScaleLaunchMembersCount(BigDecimal.valueOf(Long.parseLong(String.valueOf(todayBO.getLaunchMembersCount()-yesBO.getLaunchMembersCount()))).divide(BigDecimal.valueOf(yesBO.getLaunchMembersCount()),4,BigDecimal.ROUND_HALF_UP).multiply(BigDecimal.valueOf(100L)).setScale(2,BigDecimal.ROUND_HALF_UP));
            todayBO.setScaleHelpMembersCount(BigDecimal.valueOf(Long.parseLong(String.valueOf(todayBO.getHelpMembersCount()-yesBO.getHelpMembersCount()))).divide(BigDecimal.valueOf(yesBO.getHelpMembersCount()),4,BigDecimal.ROUND_HALF_UP).multiply(BigDecimal.valueOf(100L)).setScale(2,BigDecimal.ROUND_HALF_UP));
            todayBO.setScaleRegisterMembersCount(BigDecimal.valueOf(Long.parseLong(String.valueOf(todayBO.getRegisterMembersCount()-yesBO.getRegisterMembersCount()))).divide(BigDecimal.valueOf(yesBO.getRegisterMembersCount()),4,BigDecimal.ROUND_HALF_UP).multiply(BigDecimal.valueOf(100L)).setScale(2,BigDecimal.ROUND_HALF_UP));
            todayBO.setScaleTakeCouponCount(BigDecimal.valueOf(Long.parseLong(String.valueOf(todayBO.getTakeCouponCount()-yesBO.getTakeCouponCount()))).divide(BigDecimal.valueOf(yesBO.getTakeCouponCount()),4,BigDecimal.ROUND_HALF_UP).multiply(BigDecimal.valueOf(100L)).setScale(2,BigDecimal.ROUND_HALF_UP));
            yesDate = yesBO.getStatisticsTime();
        }*/
        MktActivityPOWithBLOBs mktActivityPOWithBLOBs = mktActivityPOMapper.selectByPrimaryKey(activityId);
        Date startTime = mktActivityPOWithBLOBs.getStartTime();
        Date todayDate = DateUtil.stringToDate(time,DateUtil.ymd);
        MktActivityStatisticsPOExample example = new MktActivityStatisticsPOExample();
        //获取从活动开始时间到当前时间的各项累计数据
        example.createCriteria().andMktActivityIdEqualTo(activityId).andStatisticsTypeEqualTo(StatisticsConstants.STATISTICS_TYPE)
                .andStatisticsTimeBetween(startTime,todayDate).andSysBrandIdEqualTo(sysAccountPO.getBrandId()).andSysCompanyIdEqualTo(sysAccountPO.getSysCompanyId());
        List<MktActivityStatisticsPO> todayList = mktActivityStatisticsPOMapper.selectByExample(example);
        if (!todayList.isEmpty()) {
            todayList.forEach(todayPo -> {
                todayBO.setTotalVisitorsCount((todayBO.getTotalVisitorsCount() == null?0:todayBO.getTotalVisitorsCount()) + todayPo.getVisitorsCount());
                todayBO.setTotalLaunchMembersCount((todayBO.getTotalLaunchMembersCount() == null?0:todayBO.getTotalLaunchMembersCount()) + todayPo.getLaunchMembersCount());
                todayBO.setTotalHelpMembersCount((todayBO.getTotalHelpMembersCount() == null?0:todayBO.getTotalHelpMembersCount()) + todayPo.getHelpMembersCount());
                todayBO.setTotalRegisterMembersCount((todayBO.getTotalRegisterMembersCount()==null?0:todayBO.getTotalRegisterMembersCount()) + todayPo.getRegisterMembersCount());
                todayBO.setTotalTakeCouponCount((todayBO.getTotalTakeCouponCount()==null?0:todayBO.getTotalTakeCouponCount()) + todayPo.getTakeCouponCount());
            });
        }
        //获取从活动开始时间到当前时间前一天的各项累计数据

        /*MktActivityStatisticsPOExample yesExample = new MktActivityStatisticsPOExample();
        yesExample.createCriteria().andMktActivityIdEqualTo(activityId).andStatisticsTypeEqualTo(StatisticsConstants.STATISTICS_TYPE)
                .andStatisticsTimeBetween(startTime,yesDate);
        List<MktActivityStatisticsPO> yesList = mktActivityStatisticsPOMapper.selectByExample(yesExample);*/
        /*if (!yesList.isEmpty() && yesBO != null) {
            yesList.forEach(yesPo -> {
                yesBO.setTotalVisitorsCount((yesBO.getTotalVisitorsCount() == null?0:yesBO.getTotalVisitorsCount()) + yesPo.getVisitorsCount());
                yesBO.setTotalLaunchMembersCount((yesBO.getTotalLaunchMembersCount() == null?0:yesBO.getTotalLaunchMembersCount()) + yesPo.getLaunchMembersCount());
                yesBO.setTotalHelpMembersCount((yesBO.getTotalHelpMembersCount() == null?0:yesBO.getTotalHelpMembersCount()) + yesPo.getHelpMembersCount());
                yesBO.setTotalRegisterMembersCount((yesBO.getTotalRegisterMembersCount()==null?0:yesBO.getTotalRegisterMembersCount()) + yesPo.getRegisterMembersCount());
                yesBO.setTotalTakeCouponCount((yesBO.getTotalTakeCouponCount()==null?0:yesBO.getTotalTakeCouponCount()) + yesPo.getTakeCouponCount());
            });
            //算出累计数据的比例
            todayBO.setScaleTotalVisitorsCount(BigDecimal.valueOf(Long.parseLong(String.valueOf(todayBO.getTotalVisitorsCount()-yesBO.getTotalVisitorsCount()))).divide(BigDecimal.valueOf(yesBO.getTotalVisitorsCount()),4,BigDecimal.ROUND_HALF_UP).multiply(BigDecimal.valueOf(100L)).setScale(2,BigDecimal.ROUND_HALF_UP));
            todayBO.setScaleTotalLaunchMembersCount(BigDecimal.valueOf(Long.parseLong(String.valueOf(todayBO.getTotalLaunchMembersCount()-yesBO.getTotalLaunchMembersCount()))).divide(BigDecimal.valueOf(yesBO.getTotalLaunchMembersCount()),4,BigDecimal.ROUND_HALF_UP).multiply(BigDecimal.valueOf(100L)).setScale(2,BigDecimal.ROUND_HALF_UP));
            todayBO.setScaleTotalHelpMembersCount(BigDecimal.valueOf(Long.parseLong(String.valueOf(todayBO.getTotalHelpMembersCount()-yesBO.getTotalHelpMembersCount()))).divide(BigDecimal.valueOf(yesBO.getTotalHelpMembersCount()),4,BigDecimal.ROUND_HALF_UP).multiply(BigDecimal.valueOf(100L)).setScale(2,BigDecimal.ROUND_HALF_UP));
            todayBO.setScaleTotalRegisterMembersCount(BigDecimal.valueOf(Long.parseLong(String.valueOf(todayBO.getTotalRegisterMembersCount()-yesBO.getTotalRegisterMembersCount()))).divide(BigDecimal.valueOf(yesBO.getTotalRegisterMembersCount()),4,BigDecimal.ROUND_HALF_UP).multiply(BigDecimal.valueOf(100L)).setScale(2,BigDecimal.ROUND_HALF_UP));
            todayBO.setScaleTotalTakeCouponCount(BigDecimal.valueOf(Long.parseLong(String.valueOf(todayBO.getTotalTakeCouponCount()-yesBO.getTotalTakeCouponCount()))).divide(BigDecimal.valueOf(yesBO.getTotalTakeCouponCount()),4,BigDecimal.ROUND_HALF_UP).multiply(BigDecimal.valueOf(100L)).setScale(2,BigDecimal.ROUND_HALF_UP));
        }*/
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
    public ResponseData curveData(Long activityId, String time, int type, SysAccountPO sysAccountPO) {
        ResponseData responseData = new ResponseData();
        Date current = DateUtil.stringToDate(time,DateUtil.ymd);
        if (type == StatisticsConstants.CURVE_HOUR) {
            MktActivityStatisticsPOExample example = new MktActivityStatisticsPOExample();
            example.createCriteria().andMktActivityIdEqualTo(activityId).andStatisticsTypeEqualTo(StatisticsConstants.STATISTICS_TYPE)
                    .andStatisticsTimeEqualTo(current).andSysCompanyIdEqualTo(sysAccountPO.getSysCompanyId()).andSysBrandIdEqualTo(sysAccountPO.getBrandId());
            List<MktActivityStatisticsPO> statisticsPOList = mktActivityStatisticsPOMapper.selectByExampleWithBLOBs(example);
            if (!statisticsPOList.isEmpty()) {
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
                    .andStatisticsTimeBetween(fifteenDate,current).andSysCompanyIdEqualTo(sysAccountPO.getSysCompanyId()).andSysBrandIdEqualTo(sysAccountPO.getBrandId());
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
