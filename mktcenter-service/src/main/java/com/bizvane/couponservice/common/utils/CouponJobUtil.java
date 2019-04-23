package com.bizvane.couponservice.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bizvane.couponfacade.enums.SendTypeEnum;
import com.bizvane.couponfacade.models.vo.SendCouponBatchRequestVO;
import com.bizvane.couponservice.common.constants.JobHandlerConstants;
import com.bizvane.couponfacade.constants.CouponConstants;
import com.bizvane.mktcenterservice.common.job.XxlJobConfig;
import com.bizvane.utils.enumutils.JobEnum;
import com.bizvane.utils.jobutils.JobBusinessTypeEnum;
import com.bizvane.utils.jobutils.JobClient;
import com.bizvane.utils.jobutils.XxlJobInfo;
import com.bizvane.utils.responseinfo.ResponseData;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by agan on 2018/7/19.
 */
@Component
public class CouponJobUtil {
    @Autowired
    private XxlJobConfig xxlJobConfig;

    @Autowired
    private JobClient jobClient;

    public static final String defaultStr ="无";


    /**
     * 券到期提醒定时任务
     * @return
     */
    public ResponseData<Integer> sendCouponExpireJob(){
        ResponseData<Integer> responseData = new ResponseData<>();

        //如果手动发券类型为指定时间，则调用定时任务
        String jobHandler = JobHandlerConstants.SEND_EXPIRE_JOBHANDLER;
        String taskName = CouponConstants.COUPON_EXPIRE_DESC;
        String execuRule = "0 0 12 * * ?";

        ResponseEntity<String> responseEntity = addRuleJob(execuRule,taskName,null,null,jobHandler,null,null);

        JSONObject jsonObject = JSON.parseObject(responseEntity.getBody());
        Integer code = jsonObject.getInteger("code");
        String msg = jsonObject.getString("msg");

        responseData.setCode(code);
        responseData.setMessage(msg);
        return responseData;
    }


    /**
     * 批量发券-手动发券
     * @param param
     * @return
     */
    public ResponseData<Integer> addSendCouponBatchJob(SendCouponBatchRequestVO param) {
        ResponseData<Integer> responseData = new ResponseData<>();

        //如果手动发券类型为指定时间，则调用定时任务
        String jobHandler = JobHandlerConstants.SEND_BATCH_JOBHANDLER;
        String businessType = SendTypeEnum.SEND_COUPON_BATCH.getCode();
        String businessCode = param.getBusinessId()+"";

        String jsonStr = JSONObject.toJSONString(param);
        ResponseEntity<String> responseEntity = addDateJob(param.getSendTime(),param.getBusinessName(),jsonStr,param.getCreateUserName(),jobHandler,businessType,businessCode);

        JSONObject jsonObject = JSON.parseObject(responseEntity.getBody());
        Integer code = jsonObject.getInteger("code");
        String msg = jsonObject.getString("msg");

        responseData.setCode(code);
        responseData.setMessage(msg);
        return responseData;
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
    public ResponseEntity<String> addDateJob(Date execuDate,String desc,String param,String author,String jobHandler,String businessType,String bizCode){
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
        xxlJobInfo.setBizType(JobBusinessTypeEnum.ACTIVITY_TYPE_COUPON.getCode());
        //设置任务或活动的Code
        xxlJobInfo.setBizCode(JobBusinessTypeEnum.ACTIVITY_TYPE_COUPON.getCode()+"");
        //添加job
        ResponseEntity<String> responseEntity = jobClient.addJob(xxlJobInfo);

        return responseEntity;
    }


    /**
     * 通用job添加方法
     * @param execuRule
     * @param desc
     * @param param
     * @param author
     * @param jobHandler
     * @param businessType
     */
    public ResponseEntity<String> addRuleJob(String execuRule,String desc,String param,String author,String jobHandler,String businessType,String bizCode){
        //构建job对象
        XxlJobInfo xxlJobInfo = new XxlJobInfo();
        //设置appName
        xxlJobInfo.setAppName(xxlJobConfig.getAppName());
        //设置路由策略
        xxlJobInfo.setExecutorRouteStrategy(JobEnum.EXECUTOR_ROUTE_STRATEGY_FIRST.getValue());
        //设置job定时器
        xxlJobInfo.setJobCron(execuRule);
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
        xxlJobInfo.setBizType(JobBusinessTypeEnum.ACTIVITY_TYPE_COUPON.getCode());
        //设置任务或活动的Code
        xxlJobInfo.setBizCode(JobBusinessTypeEnum.ACTIVITY_TYPE_COUPON.getCode()+"");
        //添加job
        ResponseEntity<String> responseEntity = jobClient.addJob(xxlJobInfo);

        return responseEntity;
    }

}
