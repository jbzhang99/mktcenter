package com.bizvane.mktcenterserviceimpl.service.jobhandler;

import com.alibaba.fastjson.JSONObject;
import com.bizvane.mktcenterservice.models.po.MktActivityPOExample;
import com.bizvane.mktcenterservice.models.po.MktActivityPOWithBLOBs;
import com.bizvane.mktcenterservice.models.po.MktGoldenStatisticsPO;
import com.bizvane.mktcenterserviceimpl.common.enums.ActivityStatusEnum;
import com.bizvane.mktcenterserviceimpl.common.enums.ActivityTypeEnum;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktGoldenStatisticsPOMapper;
import com.bizvane.utils.redisutils.RedisTemplateServiceImpl;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author liufq
 */
@JobHandler(value = "goldenStatisticsJobHandler")
@Component
@Slf4j
public class ActivityGoldenStatisticsJobHandler extends IJobHandler {
    @Autowired
    private MktActivityPOMapper mktActivityPOMapper;
    @Autowired
    private RedisTemplateServiceImpl redisTemplateService;
    @Autowired
    private MktGoldenStatisticsPOMapper mktGoldenStatisticsPOMapper;

    @Override
    public ReturnT<String> execute(String s) {
        log.info("砸金蛋活动统计定时任务开始。。。");
        //获取活动id列表
        MktActivityPOExample example = new MktActivityPOExample();
        example.createCriteria().andActivityTypeGreaterThanOrEqualTo(ActivityTypeEnum.ACTIVITY_TYPE_REDBAGS.getCode()).andActivityStatusEqualTo(ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode()).andValidEqualTo(true);
        List<MktActivityPOWithBLOBs> activityIds = mktActivityPOMapper.selectByExampleWithBLOBs(example);
        if (CollectionUtils.isEmpty(activityIds)) {
            log.info("没有正在进行中的活动!");
            return ReturnT.FAIL;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        for (MktActivityPOWithBLOBs activity : activityIds) {
            MktGoldenStatisticsPO po = new MktGoldenStatisticsPO();
            //根据活动id查询所有时间段的统计数据
            Long activityId = activity.getMktActivityId();

            //得到从活动开始到先在的统计数量
            MktGoldenStatisticsPO totalPo = mktGoldenStatisticsPOMapper.getTotalGoldenStatistics(activityId);
            int totalVisitorsCount = 0;
            int totalParticipateMemberCount = 0;
            int totalPageForwardCount = 0;
            int totalEffectiveSharingCount = 0;
            int totalRegisterMembersCount = 0;
            if (totalPo != null) {
                if (totalPo.getTotalVisitorsCount() != null) {
                    totalVisitorsCount = totalPo.getTotalVisitorsCount();
                }
                if (totalPo.getTotalParticipateMemberCount() != null) {
                    totalParticipateMemberCount = totalPo.getParticipateMemberCount();
                }
                if (totalPo.getTotalPageForwardCount() != null) {
                    totalPageForwardCount = totalPo.getTotalPageForwardCount();
                }
                if (totalPo.getTotalEffectiveSharingCount() != null) {
                    totalEffectiveSharingCount = totalPo.getTotalEffectiveSharingCount();
                }
                if (totalPo.getTotalRegisterMembersCount() != null) {
                    totalRegisterMembersCount = totalPo.getTotalRegisterMembersCount();
                }
            }
            //redisKey定义规则:GOLDEN+活动id+code
            String redisKey = "GOLDEN" + activityId;
            Integer visitorsCount = 0;
            //统计访问人数和获取访问人数每个时间点
            JSONObject visitorsJson = new JSONObject();
            for (int i = 7; i < 22; i++) {
                String timeStr = "";
                if (i < 10) {
                    timeStr = "0" + i;
                } else {
                    timeStr = String.valueOf(i);
                }
                //访问人数统计
                Integer visitorsCountH = (Integer) redisTemplateService.stringGetStringByKey(redisKey + 0 + sdf.format(new Date()) + i);
                if (visitorsCountH != null) {
                    visitorsJson.put(timeStr, visitorsCountH);
                    visitorsCount = visitorsCountH + visitorsCount;
                } else {
                    visitorsJson.put(timeStr, 0);
                }
            }
            po.setHourJsonData(visitorsJson.toJSONString());
            po.setVisitorsCount(visitorsCount);
            po.setTotalVisitorsCount(totalVisitorsCount + visitorsCount);

            //统计参与会员数
            Integer participateMemberCount = (Integer) redisTemplateService.stringGetStringByKey(redisKey + 1);
            if (participateMemberCount != null) {
                participateMemberCount = 0;
            }
            po.setParticipateMemberCount(participateMemberCount);
            po.setTotalParticipateMemberCount(participateMemberCount + totalParticipateMemberCount);

            //统计页面转发次数
            Integer pageForwardCount = (Integer) redisTemplateService.stringGetStringByKey(redisKey + 2);
            if (pageForwardCount == null) {
                pageForwardCount = 0;
            }
            po.setPageForwardCount(pageForwardCount);
            po.setTotalPageForwardCount(pageForwardCount + totalPageForwardCount);

            //有效分享人数
            Integer effectiveSharingCount = (Integer) redisTemplateService.stringGetStringByKey(redisKey + 3);
            if (effectiveSharingCount == null) {
                effectiveSharingCount = 0;
            }
            po.setEffectiveSharingCount(effectiveSharingCount);
            po.setTotalEffectiveSharingCount(effectiveSharingCount + totalEffectiveSharingCount);

            //注册会员数
            //有效分享人数
            Integer registerMembersCount = (Integer) redisTemplateService.stringGetStringByKey(redisKey + 4);
            if (registerMembersCount == null) {
                registerMembersCount = 0;
            }
            po.setRegisterMembersCount(registerMembersCount);
            po.setTotalRegisterMembersCount(registerMembersCount + totalRegisterMembersCount);

            mktGoldenStatisticsPOMapper.insertSelective(po);
        }

        log.info("砸金蛋活动统计定时任务结束。。。");
        return new ReturnT<>("砸金蛋活动统计任务成功执行完毕。");
    }
}
