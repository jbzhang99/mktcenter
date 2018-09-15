package com.bizvane.mktcenterserviceimpl.service.jobhandler;

import com.bizvane.mktcenterservice.interfaces.TaskService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: lijunwei
 * @Time: 2018/9/14 20:20
 * 定时发送消息
 */
@JobHandler(value="messageXXTaskJob")
@Component
public class MessageXXTaskJob extends IJobHandler {
    @Autowired
    private TaskService taskService;
    @Override
    public ReturnT<String> execute(String param) throws Exception {
        ReturnT returnT = new ReturnT();
        String[] split = param.split("&");
        //品牌id
        Long sysbrandId = Long.valueOf(split[0]);
        String msgContent=split[1];
        taskService.sendMemberMessage(sysbrandId,msgContent);

        returnT.setCode(0);
        returnT.setContent("任务执行完毕");
        returnT.setMsg("success");
        return returnT;
    }
}
