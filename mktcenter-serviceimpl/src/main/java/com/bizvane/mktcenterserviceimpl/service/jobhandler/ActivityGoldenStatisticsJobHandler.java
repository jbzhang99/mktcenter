package com.bizvane.mktcenterserviceimpl.service.jobhandler;

import com.bizvane.mktcenterservice.models.po.MktActivityPOExample;
import com.bizvane.mktcenterservice.models.po.MktActivityPOWithBLOBs;
import com.bizvane.mktcenterservice.models.po.MktActivityStatisticsPO;
import com.bizvane.mktcenterserviceimpl.common.constants.StatisticsConstants;
import com.bizvane.mktcenterserviceimpl.common.enums.ActivityStatusEnum;
import com.bizvane.mktcenterserviceimpl.common.enums.ActivityTypeEnum;
import com.bizvane.mktcenterserviceimpl.common.tools.DateUtil;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityStatisticsPOMapper;
import com.bizvane.utils.redisutils.RedisTemplateServiceImpl;
import com.qiniu.util.Json;
import com.qiniu.util.StringUtils;
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
@JobHandler(value = "redPackStatisticalData")
@Component
@Slf4j
public class ActivityGoldenStatisticsJobHandler extends IJobHandler {
    @Autowired
    private MktActivityPOMapper mktActivityPOMapper;
    @Autowired
    private RedisTemplateServiceImpl redisTemplateService;
    @Autowired
    private MktActivityStatisticsPOMapper mktActivityStatisticsPOMapper;

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
        for (MktActivityPOWithBLOBs activity:activityIds) {

            Long activityId = activity.getMktActivityId();
            //redisKey定义规则:GOLDEN+活动id+code
            String redisKey = "GOLDEN" + activityId;
            Integer visitorsCount = 0;
            //统计访问人数和获取访问人数每个时间点
            for (int i = 7; i < 22; i++) {
                redisKey = redisKey + 0 + sdf.format(new Date()) + i;
                //访问人数统计
                Integer visitorsCountH = (Integer) redisTemplateService.stringGetStringByKey(redisKey);
                visitorsCount = visitorsCountH + visitorsCount;
            }


        }
        log.info("砸金蛋活动统计定时任务结束。。。");
        return new ReturnT<>("砸金蛋活动统计任务成功执行完毕。");
    }
}
