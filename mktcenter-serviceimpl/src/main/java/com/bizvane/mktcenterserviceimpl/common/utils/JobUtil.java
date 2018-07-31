package com.bizvane.mktcenterserviceimpl.common.utils;

import com.bizvane.mktcenterservice.models.po.MktActivityPOWithBLOBs;
import com.bizvane.mktcenterservice.models.po.MktTaskPOWithBLOBs;
import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.mktcenterserviceimpl.common.constants.JobHandlerConstants;
import com.bizvane.mktcenterserviceimpl.common.enums.ActivityStatusEnum;
import com.bizvane.mktcenterserviceimpl.common.enums.TaskStatusEnum;
import com.bizvane.mktcenterserviceimpl.common.job.XxlJobConfig;
import com.bizvane.utils.enumutils.JobEnum;
import com.bizvane.utils.jobutils.JobClient;
import com.bizvane.utils.jobutils.XxlJobInfo;
import com.bizvane.utils.tokens.SysAccountPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by agan on 2018/7/19.
 */
@Component
public class JobUtil {
    @Autowired
    private XxlJobConfig xxlJobConfig;

    @Autowired
    private JobClient jobClient;

    /**
     * 创建调度任务
     * @param stageUser
     * @param activityVO
     * @param mktActivityPOWithBLOBs
     * @param activityCode
     */
    public  void addJob(SysAccountPO stageUser, ActivityVO activityVO, MktActivityPOWithBLOBs mktActivityPOWithBLOBs, String activityCode) {
        //活动状态设置为待执行
        mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_PENDING.getCode());
        //构建job对象
        XxlJobInfo xxlJobInfo = new XxlJobInfo();
        //设置appName
        xxlJobInfo.setAppName(xxlJobConfig.getAppName());
        //设置路由策略
        xxlJobInfo.setExecutorRouteStrategy(JobEnum.EXECUTOR_ROUTE_STRATEGY_FIRST.getValue());
        //设置job定时器
        xxlJobInfo.setJobCron(DateUtil.getCronExpression(activityVO.getStartTime()));
        //设置运行模式
        xxlJobInfo.setGlueType(JobEnum.GLUE_TYPE_BEAN.getValue());
        //设置job处理器
        xxlJobInfo.setExecutorHandler(JobHandlerConstants.activity);
        //设置job描述
        xxlJobInfo.setJobDesc(activityVO.getActivityInfo());
        //设置执行参数
        xxlJobInfo.setExecutorParam(activityCode);
        //设置阻塞处理策略
        xxlJobInfo.setExecutorBlockStrategy(JobEnum.EXECUTOR_BLOCK_SERIAL_EXECUTION.getValue());
        //设置失败处理策略
        xxlJobInfo.setExecutorFailStrategy(JobEnum.EXECUTOR_FAIL_STRATEGY_NULL.getValue());
        //设置负责人
        xxlJobInfo.setAuthor(stageUser.getName());
        //添加job
        jobClient.addJob(xxlJobInfo);
    }
    public  void addJobEndTime(SysAccountPO stageUser, ActivityVO activityVO, MktActivityPOWithBLOBs mktActivityPOWithBLOBs, String activityCode) {
        //活动状态设置为待执行
        mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_PENDING.getCode());
        //构建job对象
        XxlJobInfo xxlJobInfo = new XxlJobInfo();
        //设置appName
        xxlJobInfo.setAppName(xxlJobConfig.getAppName());
        //设置路由策略
        xxlJobInfo.setExecutorRouteStrategy(JobEnum.EXECUTOR_ROUTE_STRATEGY_FIRST.getValue());
        //设置job定时器
        xxlJobInfo.setJobCron(DateUtil.getCronExpression(activityVO.getEndTime()));
        //设置运行模式
        xxlJobInfo.setGlueType(JobEnum.GLUE_TYPE_BEAN.getValue());
        //设置job处理器
        xxlJobInfo.setExecutorHandler(JobHandlerConstants.endActivity);
        //设置job描述
        xxlJobInfo.setJobDesc(activityVO.getActivityInfo());
        //设置执行参数
        xxlJobInfo.setExecutorParam(activityCode);
        //设置阻塞处理策略
        xxlJobInfo.setExecutorBlockStrategy(JobEnum.EXECUTOR_BLOCK_SERIAL_EXECUTION.getValue());
        //设置失败处理策略
        xxlJobInfo.setExecutorFailStrategy(JobEnum.EXECUTOR_FAIL_STRATEGY_NULL.getValue());
        //设置负责人
        xxlJobInfo.setAuthor(stageUser.getName());
        //添加job
        jobClient.addJob(xxlJobInfo);
    }

    public  void addStartTaskJob(SysAccountPO stageUser, MktTaskPOWithBLOBs mktTaskPOWithBLOBs) {
        //任务状态设置为待执行:创建时为待执行=1        到结束时间时为:已结束=4
        mktTaskPOWithBLOBs.setCheckStatus(mktTaskPOWithBLOBs.getCheckStatus());
        //构建job对象
        XxlJobInfo xxlJobInfo = new XxlJobInfo();
        //设置appName
        xxlJobInfo.setAppName(xxlJobConfig.getAppName());
        //设置路由策略
        xxlJobInfo.setExecutorRouteStrategy(JobEnum.EXECUTOR_ROUTE_STRATEGY_FIRST.getValue());
        //设置job定时器
        xxlJobInfo.setJobCron(DateUtil.getCronExpression(mktTaskPOWithBLOBs.getStartTime()));
        //设置运行模式
        xxlJobInfo.setGlueType(JobEnum.GLUE_TYPE_BEAN.getValue());
        //设置job处理器
        xxlJobInfo.setExecutorHandler(JobHandlerConstants.task);
        //设置job描述
        xxlJobInfo.setJobDesc(mktTaskPOWithBLOBs.getTaskInfo());
        //设置执行参数
        xxlJobInfo.setExecutorParam(mktTaskPOWithBLOBs.getTaskCode());
        //设置阻塞处理策略
        xxlJobInfo.setExecutorBlockStrategy(JobEnum.EXECUTOR_BLOCK_SERIAL_EXECUTION.getValue());
        //设置失败处理策略
        xxlJobInfo.setExecutorFailStrategy(JobEnum.EXECUTOR_FAIL_STRATEGY_NULL.getValue());
        //设置负责人
        xxlJobInfo.setAuthor(stageUser.getName());
        //添加job
        jobClient.addJob(xxlJobInfo);
    }


}
