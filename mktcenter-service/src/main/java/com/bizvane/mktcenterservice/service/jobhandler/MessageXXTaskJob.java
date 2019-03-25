package com.bizvane.mktcenterservice.service.jobhandler;

import com.alibaba.fastjson.JSON;
import com.bizvane.mktcenterfacade.interfaces.TaskService;
import com.bizvane.mktcenterfacade.models.vo.SendMessageVO;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: lijunwei
 * @Time: 2018/9/14 20:20
 * 定时发送消息
 */
@JobHandler(value="messageXXTaskJob")
@Component
@Slf4j
public class MessageXXTaskJob extends IJobHandler {
    @Autowired
    private TaskService taskService;
    @Override
    public ReturnT<String> execute(String param) throws Exception {
        log.info("MessageXXTaskJob--入参---"+param);
        ReturnT returnT = new ReturnT();
        SendMessageVO sendMessageVO = JSON.parseObject(param, SendMessageVO.class);
        taskService.sendMemberMessage(sendMessageVO);

        returnT.setCode(0);
        returnT.setContent("任务执行完毕");
        returnT.setMsg("success");
        return returnT;
    }
}
