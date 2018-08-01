package com.bizvane.mktcenterserviceimpl.service.jobhandler;

import com.bizvane.mktcenterservice.models.po.MktActivityPO;
import com.bizvane.mktcenterservice.models.po.MktActivityPOExample;
import com.bizvane.mktcenterservice.models.po.MktMessagePO;
import com.bizvane.mktcenterservice.models.po.MktMessagePOExample;
import com.bizvane.mktcenterserviceimpl.common.constants.JobHandlerConstants;
import com.bizvane.mktcenterserviceimpl.common.enums.ActivityStatusEnum;
import com.bizvane.mktcenterserviceimpl.common.enums.BusinessTypeEnum;
import com.bizvane.mktcenterserviceimpl.common.enums.CheckStatusEnum;
import com.bizvane.mktcenterserviceimpl.common.job.XxlJobConfig;
import com.bizvane.mktcenterserviceimpl.common.utils.DateUtil;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityPOMapper;
import com.bizvane.utils.enumutils.JobEnum;
import com.bizvane.utils.jobutils.JobClient;
import com.bizvane.utils.jobutils.XxlJobInfo;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by agan on 2018/8/1.
 */
@JobHandler(value="startActivityBirthday")
@Component
public class ActivityBirthdayJobStartHandler extends IJobHandler {
    @Autowired
    private MktActivityPOMapper mktActivityPOMapper;
    @Autowired
    private XxlJobConfig xxlJobConfig;

    @Autowired
    private JobClient jobClient;
    @Override
    public ReturnT<String> execute(String param) throws Exception {

        System.out.println("job执行参数 "+param);
        ReturnT returnT = new ReturnT();
        System.out.println("开始执行活动");
        //查询该活动是否已经审核
        MktActivityPOExample examplem = new MktActivityPOExample();
        examplem.createCriteria().andActivityCodeEqualTo(param);
        examplem.createCriteria().andValidEqualTo(true);
        List<MktActivityPO> mktActivityPOs = mktActivityPOMapper.selectByExample(examplem);
        if(mktActivityPOs.get(0).getCheckStatus()== CheckStatusEnum.CHECK_STATUS_APPROVED.getCode()){
            MktActivityPO po = new MktActivityPO();
            po.setActivityCode(param);
            po.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode());
            //把活动状态改成执行中
            int sum = mktActivityPOMapper.updateActivityStatus(po);
            //新增个定时任务 每天执行
            //构建job对象
            XxlJobInfo xxlJobInfo = new XxlJobInfo();
            //设置appName
            xxlJobInfo.setAppName(xxlJobConfig.getAppName());
            //设置路由策略
            xxlJobInfo.setExecutorRouteStrategy(JobEnum.EXECUTOR_ROUTE_STRATEGY_FIRST.getValue());
            //设置job定时器
            xxlJobInfo.setJobCron("0 0 0 * * ? ");
            //设置运行模式
            xxlJobInfo.setGlueType(JobEnum.GLUE_TYPE_BEAN.getValue());
            //设置job处理器
            xxlJobInfo.setExecutorHandler(JobHandlerConstants.everyDayActivityBirthday);
            //设置job描述
            xxlJobInfo.setJobDesc("每天执行的生日活动");
            //设置执行参数
            xxlJobInfo.setExecutorParam(mktActivityPOs.get(0).getActivityCode());
            //设置阻塞处理策略
            xxlJobInfo.setExecutorBlockStrategy(JobEnum.EXECUTOR_BLOCK_SERIAL_EXECUTION.getValue());
            //设置失败处理策略
            xxlJobInfo.setExecutorFailStrategy(JobEnum.EXECUTOR_FAIL_STRATEGY_NULL.getValue());
            //设置负责人
            xxlJobInfo.setAuthor(mktActivityPOs.get(0).getCreateUserName());
            //设置业务类型
            xxlJobInfo.setBizType(BusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode());
            //添加job
            jobClient.addJob(xxlJobInfo);

        }else{
            returnT.setCode(1);
            returnT.setContent("该活动未审核");
            returnT.setMsg("FAILED");
            return returnT;
        }

        returnT.setCode(0);
        returnT.setContent("活动执行完毕");
        returnT.setMsg("success");
        return returnT;
    }
}
