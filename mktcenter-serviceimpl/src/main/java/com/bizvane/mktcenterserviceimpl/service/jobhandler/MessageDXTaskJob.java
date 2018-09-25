package com.bizvane.mktcenterserviceimpl.service.jobhandler;

import com.bizvane.mktcenterservice.interfaces.TaskService;
import com.bizvane.mktcenterservice.models.po.MktMessagePO;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: lijunwei
 * @Time: 2018/9/14 19:48
 * 定时给粉丝发送短信
 */
@JobHandler(value="messageDXTaskJob")
@Component
public class MessageDXTaskJob extends IJobHandler {
  @Autowired
  private  TaskService taskService;
    @Override
    public ReturnT<String> execute(String param) throws Exception {
        ReturnT returnT = new ReturnT();
        String[] split = param.split("&");
        Long mktTaskId=Long.valueOf(split[0]);
        Integer taskType=Integer.valueOf(split[1]);
        Long sysCompanyId=Long.valueOf(split[2]);
        Long sysBrandId=Long.valueOf(split[3]);
        String messageContent=split[4];
        Boolean exceptWechat = Boolean.valueOf(split[5]);
        taskService.sendBachMSM(mktTaskId,taskType,sysCompanyId,sysBrandId,messageContent,exceptWechat);

        returnT.setCode(0);
        returnT.setContent("任务执行完毕");
        returnT.setMsg("success");
        return returnT;
    }
}
