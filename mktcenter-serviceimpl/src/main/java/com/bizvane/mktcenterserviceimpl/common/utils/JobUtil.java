package com.bizvane.mktcenterserviceimpl.common.utils;

import com.bizvane.mktcenterservice.models.po.MktActivityPOWithBLOBs;
import com.bizvane.mktcenterservice.models.po.MktTaskPOWithBLOBs;
import com.bizvane.mktcenterservice.models.vo.ActivitySmartVO;
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
        String activityJobType = JobHandlerConstants.activity;
        int businessType =BusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode();
        addJob(activityVO.getStartTime(),activityVO.getActivityInfo(),activityCode,stageUser.getName(),activityJobType,businessType);
    }
    public  void addJobEndTime(SysAccountPO stageUser, ActivityVO activityVO, String activityCode) {
        String activityJobType = JobHandlerConstants.endActivity;
        int businessType =BusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode();
        addJob(activityVO.getEndTime(),activityVO.getActivityInfo(),activityCode,stageUser.getName(),activityJobType,businessType);
    }
    //新增生日开始job
    public  void addStratBirthdayJob(SysAccountPO stageUser, ActivityVO activityVO, String activityCode) {
        String activityJobType = JobHandlerConstants.startActivityBirthday;
        int businessType =BusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode();
        addJob(activityVO.getStartTime(),activityVO.getActivityInfo(),activityCode,stageUser.getName(),activityJobType,businessType);
    }
    //新增生日结束job
    public  void addEndBirthdayJob(SysAccountPO stageUser, ActivityVO activityVO, String activityCode) {
        String activityJobType = JobHandlerConstants.endActivityBirthday;
        int businessType =BusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode();
        addJob(activityVO.getEndTime(),activityVO.getActivityInfo(),activityCode,stageUser.getName(),activityJobType,businessType);
    }
    public  void addStartTaskJob(SysAccountPO stageUser, MktTaskPOWithBLOBs mktTaskPOWithBLOBs) {
        String activityJobType = JobHandlerConstants.task;
        int businessType =BusinessTypeEnum.ACTIVITY_TYPE_TASK.getCode();
        //任务状态设置为待执行:创建时为待执行=1        到结束时间时为:已结束=4
        addJob(mktTaskPOWithBLOBs.getStartTime(),mktTaskPOWithBLOBs.getTaskInfo(),mktTaskPOWithBLOBs.getTaskCode(),stageUser.getName(),activityJobType,businessType);
    }
    public  void addEndTaskJob(SysAccountPO stageUser, MktTaskPOWithBLOBs mktTaskPOWithBLOBs) {
        String activityJobType = JobHandlerConstants.task;
        int businessType =BusinessTypeEnum.ACTIVITY_TYPE_TASK.getCode();
        //任务状态设置为待执行:创建时为待执行=1        到结束时间时为:已结束=4
        addJob(mktTaskPOWithBLOBs.getEndTime(),mktTaskPOWithBLOBs.getTaskInfo(),mktTaskPOWithBLOBs.getTaskCode(),stageUser.getName(),activityJobType,businessType);
    }

    /**
     * 添加智能营销job，只有开始
     * @param stageUser
     * @param vo
     */
    public  void addSmartActivityJob(SysAccountPO stageUser, ActivitySmartVO vo) {
        String param =vo.getMktSmartType()+"&"+vo.getActivityCode();
        addJob(vo.getStartTime(),vo.getActivityName(),param,stageUser.getName(),JobHandlerConstants.smartActivity,BusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode());
    }

    /**
     * 通用job添加方法
     * @param execuDate
     * @param desc
     * @param bizCode
     * @param author
     */
    public void addJob(Date execuDate,String desc,String param,String author,String jobHandler,int businessType){
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
        xxlJobInfo.setExecutorHandler(jobHandler);
        //设置job描述
        xxlJobInfo.setJobDesc(desc);
        //设置执行参数
        xxlJobInfo.setExecutorParam(param);
        //设置阻塞处理策略
        xxlJobInfo.setExecutorBlockStrategy(JobEnum.EXECUTOR_BLOCK_SERIAL_EXECUTION.getValue());
        //设置失败处理策略
        xxlJobInfo.setExecutorFailStrategy(JobEnum.EXECUTOR_FAIL_STRATEGY_NULL.getValue());
        //设置负责人
        xxlJobInfo.setAuthor(author);
        //设置业务类型
        xxlJobInfo.setBizType(businessType);
        //添加job
        jobClient.addJob(xxlJobInfo);
    }

}
