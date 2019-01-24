package com.bizvane.mktcenterserviceimpl.service.jobhandler;

import com.bizvane.mktcenterservice.models.po.MktActivityPOExample;
import com.bizvane.mktcenterservice.models.po.MktActivityPOWithBLOBs;
import com.bizvane.mktcenterservice.models.po.MktActivityStatisticsPO;
import com.bizvane.mktcenterserviceimpl.common.constants.StatisticsConstants;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityStatisticsPOMapper;
import com.bizvane.utils.redisutils.RedisTemplateServiceImpl;
import com.qiniu.util.Json;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author yy
 * @create 2019-01-24 19:18
 */
@JobHandler(value = "redPackStatisticalData")
@Component
@Slf4j
public class ActivityStatisticsJobHandler extends IJobHandler {

    @Autowired
    private MktActivityPOMapper mktActivityPOMapper;
    @Autowired
    private RedisTemplateServiceImpl redisTemplateService;
    @Autowired
    private MktActivityStatisticsPOMapper mktActivityStatisticsPOMapper;

    @Override
    public ReturnT<String> execute(String s) throws Exception {
        log.info("红包膨胀了   活动统计   任务开始执行 。。。。");
        ReturnT returnT = new ReturnT();
        //获取活动id列表
        MktActivityPOExample example = new MktActivityPOExample();
        example.createCriteria().andActivityTypeEqualTo(12).andActivityStatusEqualTo(2).andValidEqualTo(true);
        List<MktActivityPOWithBLOBs> activityIds = mktActivityPOMapper.selectByExampleWithBLOBs(example);
        log.info("活动id列表:{}",activityIds);
        if (CollectionUtils.isEmpty(activityIds)) {
            //证明昨天无活动触发 就此结束
            log.info("无活动id列表就此结束定时");
            return null;
        }
        String yesterday = StatisticsConstants.getYesterday();
        //获取昨天24小时内的访问量数据
        Map map = new TreeMap();
        for (MktActivityPOWithBLOBs activity:activityIds) {
            Long activityId = activity.getMktActivityId();
            for (int i = 0; i < 24; i++) {
                String key = StatisticsConstants.VISITORS_PREFIX + activityId + "_" + yesterday + "_" + i;
                Set hourMemberCodeSet = (Set) redisTemplateService.stringGetStringByKey(key);
                int count = hourMemberCodeSet == null ? 0 : hourMemberCodeSet.size();
                if (i < 10) {
                    map.put("0" + i + ":00", count);
                } else {
                    map.put(i + ":00", count);
                }
            }
            //查询昨天访问人数
            String visitorsKey = StatisticsConstants.VISITORS_PREFIX + activityId + "_" + yesterday;
            Set visitorsMemberCodeSet = (Set) redisTemplateService.stringGetStringByKey(visitorsKey);
            int visitorsCount = visitorsMemberCodeSet == null ? 0 : visitorsMemberCodeSet.size();
            //查询昨天发起会员数
            String launchMembersKey = StatisticsConstants.LAUNCH_MEMBERS + activityId + "_" + yesterday;
            Set launchMemberCodeSet = (Set) redisTemplateService.stringGetStringByKey(launchMembersKey);
            int launchMembersCount = launchMemberCodeSet == null ? 0 : launchMemberCodeSet.size();
            //查询助力昨天助力会员数
            String helpMembersKey = StatisticsConstants.HELP_MEMBERS + activityId + "_" + yesterday;
            Set helpMemberCodeSet = (Set) redisTemplateService.stringGetStringByKey(helpMembersKey);
            int helpMembersCount = helpMemberCodeSet == null ? 0 : helpMemberCodeSet.size();
            //查询注册会员数
            String registerMembersKey = StatisticsConstants.REGISTER_MEMBERS + activityId + "_" + yesterday;
            Set registerMemberCodeSet = (Set) redisTemplateService.stringGetStringByKey(registerMembersKey);
            int registerMembersCount = registerMemberCodeSet == null ? 0 : registerMemberCodeSet.size();
            //领劵数量
            String takeCouponKey = StatisticsConstants.TAKE_COUPON + activityId + "_" + yesterday;
            Set takeCouponMemberCodeSet = (Set) redisTemplateService.stringGetStringByKey(takeCouponKey);
            int takeCouponCount = takeCouponMemberCodeSet == null ? 0 : takeCouponMemberCodeSet.size();

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
            calendar.add(Calendar.DATE, -1);
            mktActivityStatisticsPO.setStatisticsTime(calendar.getTime());
            mktActivityStatisticsPO.setStatisticsType(StatisticsConstants.STATISTICS_TYPE);
            mktActivityStatisticsPOMapper.insertSelective(mktActivityStatisticsPO);
        }
        returnT.setCode(0);
        returnT.setContent("活动执行完毕");
        returnT.setMsg("success");
        log.info("红包膨胀了   活动统计   任务执行结束。。。。");
        return returnT;
    }
}
