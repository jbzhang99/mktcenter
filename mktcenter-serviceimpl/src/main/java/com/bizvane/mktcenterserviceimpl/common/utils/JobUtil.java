package com.bizvane.mktcenterserviceimpl.common.utils;

import com.bizvane.mktcenterservice.models.po.MktActivityPOWithBLOBs;
import com.bizvane.mktcenterservice.models.po.MktTaskPOWithBLOBs;
import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.mktcenterserviceimpl.common.constants.JobHandlerConstants;
import com.bizvane.mktcenterserviceimpl.common.enums.ActivityStatusEnum;
import com.bizvane.mktcenterserviceimpl.common.enums.BusinessTypeEnum;
import com.bizvane.mktcenterserviceimpl.common.enums.TaskStatusEnum;
import com.bizvane.mktcenterserviceimpl.common.job.XxlJobConfig;
import com.bizvane.utils.enumutils.JobEnum;
import com.bizvane.utils.jobutils.JobClient;
import com.bizvane.utils.jobutils.XxlJobInfo;
import com.bizvane.utils.tokens.SysAccountPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

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
     * @param
     * @param activityCode
     */
    public  void addJob(SysAccountPO stageUser, ActivityVO activityVO,String activityCode) {
        addJob(activityVO.getStartTime(),activityVO.getActivityInfo(),activityCode,stageUser.getName());
    }
    public  void addJobEndTime(SysAccountPO stageUser, ActivityVO activityVO, String activityCode) {
        addJob(activityVO.getEndTime(),activityVO.getActivityInfo(),activityCode,stageUser.getName());
    }
    //新增生日开始job
    public  void addStratBirthdayJob(SysAccountPO stageUser, ActivityVO activityVO, String activityCode) {
        addJob(activityVO.getStartTime(),activityVO.getActivityInfo(),activityCode,stageUser.getName());
    }
    //新增生日结束job
    public  void addEndBirthdayJob(SysAccountPO stageUser, ActivityVO activityVO, String activityCode) {
        addJob(activityVO.getEndTime(),activityVO.getActivityInfo(),activityCode,stageUser.getName());
    }
    public  void addStartTaskJob(SysAccountPO stageUser, MktTaskPOWithBLOBs mktTaskPOWithBLOBs) {
        //任务状态设置为待执行:创建时为待执行=1        到结束时间时为:已结束=4
        addJob(mktTaskPOWithBLOBs.getStartTime(),mktTaskPOWithBLOBs.getTaskInfo(),mktTaskPOWithBLOBs.getTaskCode(),stageUser.getName());
    }
    public  void addEndTaskJob(SysAccountPO stageUser, MktTaskPOWithBLOBs mktTaskPOWithBLOBs) {
        //任务状态设置为待执行:创建时为待执行=1        到结束时间时为:已结束=4
        addJob(mktTaskPOWithBLOBs.getEndTime(),mktTaskPOWithBLOBs.getTaskInfo(),mktTaskPOWithBLOBs.getTaskCode(),stageUser.getName());
    }

    /**
     * 通用job添加方法
     * @param execuDate
     * @param desc
     * @param bizCode
     * @param author
     */
    public void addJob(Date execuDate,String desc,String bizCode,String author){
        //构建job对象
        XxlJobInfo xxlJobInfo = new XxlJobInfo();
        //设置appName
        xxlJobInfo.setAppName(xxlJobConfig.getAppName());
        //设置路由策略
        xxlJobInfo.setExecutorRouteStrategy(JobEnum.EXECUTOR_ROUTE_STRATEGY_FIRST.getValue());
        //设置job定时器
        xxlJobInfo.setJobCron(DateUtil.getCronExpression(execuDate));
        //设置运行模式
        xxlJobInfo.setGlueType(JobEnum.GLUE_TYPE_BEAN.getValue());
        //设置job处理器
        xxlJobInfo.setExecutorHandler(JobHandlerConstants.endActivityBirthday);
        //设置job描述
        xxlJobInfo.setJobDesc(desc);
        //设置执行参数
        xxlJobInfo.setExecutorParam(bizCode);
        //设置阻塞处理策略
        xxlJobInfo.setExecutorBlockStrategy(JobEnum.EXECUTOR_BLOCK_SERIAL_EXECUTION.getValue());
        //设置失败处理策略
        xxlJobInfo.setExecutorFailStrategy(JobEnum.EXECUTOR_FAIL_STRATEGY_NULL.getValue());
        //设置负责人
        xxlJobInfo.setAuthor(author);
        //设置业务类型
        xxlJobInfo.setBizType(BusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode());
        //添加job
        jobClient.addJob(xxlJobInfo);
    }

}
