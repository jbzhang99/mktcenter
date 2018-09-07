package com.bizvane.mktcenterserviceimpl.common.job;

import com.bizvane.mktcenterservice.models.po.MktTaskPOWithBLOBs;
import com.bizvane.mktcenterservice.models.vo.ActivitySmartVO;
import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.mktcenterserviceimpl.common.constants.JobHandlerConstants;
import com.bizvane.mktcenterserviceimpl.common.utils.DateUtil;
import com.bizvane.utils.enumutils.JobEnum;
import com.bizvane.utils.jobutils.JobBusinessTypeEnum;
import com.bizvane.utils.jobutils.JobClient;
import com.bizvane.utils.jobutils.XxlJobInfo;
import com.bizvane.utils.tokens.SysAccountPO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by agan on 2018/7/19.
 */
@Component
@Slf4j
public class JobUtil {
    @Autowired
    private XxlJobConfig xxlJobConfig;

    @Autowired
    private JobClient jobClient;

    public static final String defaultStr ="无";

    /**
     * 创建调度任务
     * @param stageUser
     * @param activityVO
     * @param
     * @param activityCode
     */
    public  void addJob(SysAccountPO stageUser, ActivityVO activityVO,String activityCode) {
        String activityJobType = JobHandlerConstants.activity;
        int businessType = JobBusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode();
        addJob(activityVO.getStartTime(),activityVO.getActivityInfo(),activityCode,stageUser.getName(),activityJobType,businessType,activityCode);
    }
    public  void addJobEndTime(SysAccountPO stageUser, ActivityVO activityVO, String activityCode) {
        String activityJobType = JobHandlerConstants.endActivity;
        int businessType = JobBusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode();
        addJob(activityVO.getEndTime(),activityVO.getActivityInfo(),activityCode,stageUser.getName(),activityJobType,businessType,activityCode);
    }
    //新增生日开始job
    public  void addStratBirthdayJob(SysAccountPO stageUser, ActivityVO activityVO, String activityCode) {
        String activityJobType = JobHandlerConstants.startActivityBirthday;
        int businessType =JobBusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode();
        addJob(activityVO.getStartTime(),activityVO.getActivityInfo(),activityCode,stageUser.getName(),activityJobType,businessType,activityCode);
    }
    //新增生日结束job
    public  void addEndBirthdayJob(SysAccountPO stageUser, ActivityVO activityVO, String activityCode) {
        String activityJobType = JobHandlerConstants.endActivityBirthday;
        int businessType =JobBusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode();
        addJob(activityVO.getEndTime(),activityVO.getActivityInfo(),activityCode,stageUser.getName(),activityJobType,businessType,activityCode);
    }
    public  void addStartTaskJob(SysAccountPO stageUser, MktTaskPOWithBLOBs po) {
        String jobType = JobHandlerConstants.task;
        int businessType =JobBusinessTypeEnum.ACTIVITY_TYPE_TASK.getCode();
        //任务状态设置为待执行:创建时为待执行=1        到结束时间时为:已结束=4
        addJob(po.getStartTime(),po.getTaskInfo(),po.getTaskCode(),stageUser.getName(),jobType,businessType,po.getTaskCode());
    }
    public  void addEndTaskJob(SysAccountPO stageUser, MktTaskPOWithBLOBs po) {
        String jobType = JobHandlerConstants.task;
        int businessType =JobBusinessTypeEnum.ACTIVITY_TYPE_TASK.getCode();
        //任务状态设置为待执行:创建时为待执行=1        到结束时间时为:已结束=4
        addJob(po.getEndTime(),po.getTaskInfo(),po.getTaskCode(),stageUser.getName(),jobType,businessType,po.getTaskCode());
    }

    /**
     * 添加智能营销job，只有开始
     * @param stageUser
     * @param vo
     */
    public  void addSmartActivityJob(SysAccountPO stageUser, ActivitySmartVO vo) {
        String param =vo.getMktSmartType()+"&"+vo.getActivityCode();
        addJob(vo.getSendTime(),vo.getActivityName(),param,stageUser.getName(),JobHandlerConstants.smartActivity,JobBusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode(),vo.getActivityCode());
    }
/**
 * 添加任务开始job
 */
public  void addTaskStartJob(SysAccountPO stageUser, MktTaskPOWithBLOBs po) {
    //2=任务
    int bizType = JobBusinessTypeEnum.ACTIVITY_TYPE_TASK.getCode();
    //任务code
    String taskCode = po.getTaskCode();
    XxlJobInfo xxlJobInfo = new XxlJobInfo();
    xxlJobInfo.setBizCode(taskCode);
    xxlJobInfo.setBizType(bizType);
    jobClient.removeByBiz(xxlJobInfo);

    //添加任务
    StringBuilder builder = new StringBuilder();
    builder.append(po.getMktTaskId());
    builder.append("&");
    //任务=2
    builder.append(JobBusinessTypeEnum.ACTIVITY_TYPE_TASK.getCode());
    builder.append("&");
    builder.append(po.getSysCompanyId());
    String param =builder.toString();
    addJob(po.getStartTime(),po.getTaskName(),param,stageUser.getName(),JobHandlerConstants.START_TASK,JobBusinessTypeEnum.ACTIVITY_TYPE_TASK.getCode(),po.getTaskCode());
}

    /**
     * 添加任务结束job
     * @param stageUser
     * @param po
     */
    public void addTaskEndJob(SysAccountPO stageUser, MktTaskPOWithBLOBs po) {
        StringBuilder builder = new StringBuilder();
        builder.append(po.getMktTaskId());
        builder.append("&");
        //2="营销任务"
        builder.append(JobBusinessTypeEnum.ACTIVITY_TYPE_TASK.getCode());
        builder.append("&");
        builder.append(po.getSysCompanyId());
        String param =builder.toString();
        addJob(po.getStartTime(),po.getTaskName(),param,stageUser.getName(),JobHandlerConstants.END_TASK,JobBusinessTypeEnum.ACTIVITY_TYPE_TASK.getCode(),po.getTaskCode());
    }

    /**
     * 发送信息job
     * @param stageUser
     * @param activityVO
     * @param activityCode
     */
    public  void addSendMessageJob(SysAccountPO stageUser, ActivityVO activityVO,String activityCode) {
        String activityJobType = JobHandlerConstants.sendMessageActivity;
        int businessType = JobBusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode();
        addJob(activityVO.getSendTime(),activityVO.getActivityInfo(),activityCode,stageUser.getName(),activityJobType,businessType,activityCode);
    }
    /**
     * 通用job添加方法
     * @param execuDate
     * @param desc
     * @param param
     * @param author
     * @param jobHandler
     * @param businessType
     */
    public void addJob(Date execuDate,String desc,String param,String author,String jobHandler,int businessType,String bizCode){
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
        if(StringUtils.isBlank(desc)){
            desc = defaultStr;
        }
        xxlJobInfo.setJobDesc(desc);
        //设置执行参数
        xxlJobInfo.setExecutorParam(param);
        //设置阻塞处理策略
        xxlJobInfo.setExecutorBlockStrategy(JobEnum.EXECUTOR_BLOCK_SERIAL_EXECUTION.getValue());
        //设置失败处理策略
        xxlJobInfo.setExecutorFailStrategy(JobEnum.EXECUTOR_FAIL_STRATEGY_NULL.getValue());
        //设置负责人
        if(StringUtils.isBlank(author)){
            author = defaultStr;
        }
        xxlJobInfo.setAuthor(author);
        //设置业务类型
        xxlJobInfo.setBizType(businessType);
        //设置任务或活动的Code
        xxlJobInfo.setBizCode(bizCode);
        //添加job
        ResponseEntity<String> stringResponseEntity = jobClient.addJob(xxlJobInfo);
        log.info("com.bizvane.mktcenterserviceimpl.common.job.JobUtil.addJob result"+stringResponseEntity);
    }

}
