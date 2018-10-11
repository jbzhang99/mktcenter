package com.bizvane.mktcenterserviceimpl.common.job;

import com.bizvane.mktcenterservice.models.po.MktMessagePO;
import com.bizvane.mktcenterservice.models.po.MktTaskPOWithBLOBs;
import com.bizvane.mktcenterservice.models.vo.ActivitySmartVO;
import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.mktcenterserviceimpl.common.constants.JobHandlerConstants;
import com.bizvane.mktcenterserviceimpl.common.constants.TaskConstants;
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
    //新增纪念日开始job
    public  void addStratAniversaryJob(SysAccountPO stageUser, ActivityVO activityVO, String activityCode) {
        String activityJobType = JobHandlerConstants.startActivityAniversary;
        int businessType =JobBusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode();
        addJob(activityVO.getStartTime(),activityVO.getActivityInfo(),activityCode,stageUser.getName(),activityJobType,businessType,activityCode);
    }
    //新增生日结束job
    public  void addEndBirthdayJob(SysAccountPO stageUser, ActivityVO activityVO, String activityCode) {
        String activityJobType = JobHandlerConstants.endActivityAniversary;
        int businessType =JobBusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode();
        addJob(activityVO.getEndTime(),activityVO.getActivityInfo(),activityCode,stageUser.getName(),activityJobType,businessType,activityCode);
    }
    //新增纪念日结束job
    public  void addEndAniversaryJob(SysAccountPO stageUser, ActivityVO activityVO, String activityCode) {
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
        //20=开始任务
        //int bizType = JobBusinessTypeEnum.ACTIVITY_TYPE_TASK.getCode();
        int bizType =TaskConstants.ACTIVITY_TYPE_TASK_CODE_STARTJOB;
        //任务code
        String taskCode = po.getTaskCode();
        //任务id
        Long mktTaskId = po.getMktTaskId();
        //创建人
        String name = stageUser.getName();
        //公司id
        Long sysCompanyId = po.getSysCompanyId();
        //任务开始时间
        Date startTime = po.getStartTime();
        //拼接参数放入job,用于执行job  任务id&任务类型=2&公司id
        String param = this.getTaskJobParam(bizType, mktTaskId, sysCompanyId,JobHandlerConstants.START_TASK);
        //清除一下job
        doRemoveJobe(bizType, taskCode, param);
        //添加任务
        addJob(startTime,po.getTaskName(),param,stageUser.getName(),JobHandlerConstants.START_TASK,bizType,taskCode);
    }
    /**
     * 添加任务结束job
     * @param stageUser
     * @param po
     */
    public void addTaskEndJob(SysAccountPO stageUser, MktTaskPOWithBLOBs po) {
        //拼接任务job中的    21=结束job
       // int bizType = JobBusinessTypeEnum.ACTIVITY_TYPE_TASK.getCode();
        int bizType =TaskConstants.ACTIVITY_TYPE_TASK_CODE_ENDJOB;
        Long mktTaskId = po.getMktTaskId();
        String taskName = po.getTaskName();
        String name = stageUser.getName();
        String taskCode = po.getTaskCode();
        Long sysCompanyId = po.getSysCompanyId();
        Date endTime = po.getEndTime();
        String param = this.getTaskJobParam(bizType,mktTaskId,sysCompanyId,JobHandlerConstants.END_TASK);
        //清除一下job
        doRemoveJobe(bizType, taskCode, param);
        //添加job
        this.addJob(endTime,taskName,param,name,JobHandlerConstants.END_TASK,bizType,taskCode);
    }

    /**
     * 给粉丝发送短息时,添加定时任务数据
     * @param stageUser
     * @param po
     * @param messagePO
     */
    public void addMessageXXTaskJob(SysAccountPO stageUser, MktTaskPOWithBLOBs po, MktMessagePO messagePO){
        //int bizType = JobBusinessTypeEnum.ACTIVITY_TYPE_TASK.getCode();
        int bizType =TaskConstants.ACTIVITY_TYPE_TASK_CODE_XXOB;
        Long mktTaskId = po.getMktTaskId();
        Integer taskType = po.getTaskType();
        String taskCode = po.getTaskCode();
        String taskName = po.getTaskName();
        String name = stageUser.getName();
        String msgContent = messagePO.getMsgContent();
        Date sendTime = messagePO.getSendTime();
        Long sysBrandId = po.getSysBrandId();
        Boolean exceptWechat = messagePO.getExceptWechat();
        StringBuilder builder = new StringBuilder();
        String param = this.getMessageJobParam(sysBrandId,taskType, msgContent,exceptWechat);
        //清除一下job
        this.doRemoveJobe(bizType, taskCode, param);
        log.info("添加消息的job--addMessageXXTaskJob--"+sendTime+"--"+taskName+"--"+param+"--"+name+"--"+JobHandlerConstants.MESSAGE_SEND_XX+"--"+bizType+"--"+taskCode);
        //添加job
        this.addJob(sendTime,taskName,param,name,JobHandlerConstants.MESSAGE_SEND_XX,bizType,taskCode);
    }
    public void addMessageDXTaskJob(SysAccountPO stageUser, MktTaskPOWithBLOBs po, MktMessagePO messagePO){
       // int bizType = JobBusinessTypeEnum.ACTIVITY_TYPE_TASK.getCode();
        int bizType =TaskConstants.ACTIVITY_TYPE_TASK_CODE_XDOB;
        Long mktTaskId = po.getMktTaskId();
        Integer taskType = po.getTaskType();
        String taskCode = po.getTaskCode();
        String taskName = po.getTaskName();
        Long sysCompanyId = po.getSysCompanyId();
        Long sysBrandId = po.getSysBrandId();
        String name = stageUser.getName();
        String msgContent = messagePO.getMsgContent();
        Date sendTime = messagePO.getSendTime();
        Boolean exceptWechat = messagePO.getExceptWechat();
        String param = this.getMessageJobParam(mktTaskId, taskType, sysCompanyId, sysBrandId, msgContent,exceptWechat);
        //清除一下job
        this.doRemoveJobe(bizType, taskCode, param);
        log.info("添加短信的job--addMessageDXTaskJob--"+sendTime+"--"+taskName+"--"+param+"--"+name+"--"+JobHandlerConstants.MESSAGE_SEND_DX+"--"+bizType+"--"+taskCode);
        //添加job
        this.addJob(sendTime,taskName,param,name,JobHandlerConstants.MESSAGE_SEND_DX,bizType,taskCode);
    }

    //任务清除一下job
    private void doRemoveJobe(int bizType, String taskCode, String param) {
        XxlJobInfo xxlJobInfo = new XxlJobInfo();
        xxlJobInfo.setBizCode(taskCode);
        xxlJobInfo.setBizType(bizType);
        xxlJobInfo.setExecutorParam(param);
        jobClient.removeByBiz(xxlJobInfo);
    }

    //任务  拼接参数放入job,用于执行job  任务id&任务类型=2&公司id
    private String getTaskJobParam(int bizType, Long mktTaskId, Long sysCompanyId,String taskJobStyle) {
        StringBuilder builder = new StringBuilder();
        builder.append(mktTaskId);
        builder.append("&");
        builder.append(bizType);
        builder.append("&");
        builder.append(sysCompanyId);
        builder.append("&");
        builder.append(taskJobStyle);
        return builder.toString();
    }
    //消息或短信类业务的参数拼接
    //(Long mktTaskId, Integer taskType,Long sysCompanyId,Long sysBrandId,String msgContent)
    private String getMessageJobParam(Long mktTaskId, Integer taskType,Long sysCompanyId,Long sysBrandId,String msgContent,Boolean exceptWechat) {
        StringBuilder builder = new StringBuilder();
        builder.append(mktTaskId);
        builder.append("&");
        builder.append(taskType);
        builder.append("&");
        builder.append(sysCompanyId);
        builder.append("&");
        builder.append(sysBrandId);
        builder.append("&");
        builder.append(msgContent);
        builder.append("&");
        builder.append(exceptWechat);
        return builder.toString();
    }
    private String getMessageJobParam(long sysBrandId,Integer taskType, String msgContent,Boolean exceptWechat){
        StringBuilder builder = new StringBuilder();
        builder.append(sysBrandId);
        builder.append("&");
        builder.append(taskType);
        builder.append("&");
        builder.append(msgContent);
        builder.append("&");
        builder.append(exceptWechat);
        return builder.toString();
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
