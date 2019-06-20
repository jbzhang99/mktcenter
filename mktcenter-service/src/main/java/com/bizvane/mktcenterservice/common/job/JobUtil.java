package com.bizvane.mktcenterservice.common.job;

import com.alibaba.fastjson.JSON;
import com.bizvane.mktcenterfacade.models.po.MktActivityPOWithBLOBs;
import com.bizvane.mktcenterfacade.models.po.MktMessagePO;
import com.bizvane.mktcenterfacade.models.vo.ActivitySmartVO;
import com.bizvane.mktcenterfacade.models.vo.ActivityVO;
import com.bizvane.mktcenterfacade.models.vo.SendMessageVO;
import com.bizvane.mktcenterservice.common.constants.JobHandlerConstants;
import com.bizvane.mktcenterservice.common.constants.TaskConstants;
import com.bizvane.mktcenterservice.common.utils.DateUtil;
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

    /**
     * 添加智能营销job，只有开始
     * @param stageUser
     * @param vo
     */
    public  void addSmartActivityJob(SysAccountPO stageUser, ActivitySmartVO vo) {
        String param =vo.getMktSmartType()+"&"+vo.getActivityCode();
        addJob(vo.getSendTime(),vo.getActivityName(),param,stageUser.getName(),JobHandlerConstants.smartActivity,JobBusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode(),vo.getActivityCode());
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
        log.info("添加job参数是execuDate="+ execuDate+"desc="+desc+"param+="+param+"author+="+author+"jobHandler+="+jobHandler+"businessType+="+businessType+"bizCode"+bizCode);
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
        log.info("JobUtil.addJob result"+stringResponseEntity);
    }

}
