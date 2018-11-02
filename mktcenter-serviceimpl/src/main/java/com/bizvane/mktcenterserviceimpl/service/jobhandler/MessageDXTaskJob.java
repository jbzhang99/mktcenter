package com.bizvane.mktcenterserviceimpl.service.jobhandler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bizvane.mktcenterservice.interfaces.TaskService;
import com.bizvane.mktcenterservice.models.po.MktMessagePO;
import com.bizvane.mktcenterservice.models.vo.SendMessageVO;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: lijunwei
 * @Time: 2018/9/14 19:48
 * 定时给粉丝发送短信
 */
@JobHandler(value="messageDXTaskJob")
@Component
@Slf4j
public class MessageDXTaskJob extends IJobHandler {
  @Autowired
  private  TaskService taskService;
    @Override
    public ReturnT<String> execute(String param) throws Exception {
        log.info("MessageDXTaskJob--入参---"+param);
        ReturnT returnT = new ReturnT();
        SendMessageVO sendMessageVO = JSON.parseObject(param, SendMessageVO.class);
        taskService.sendBachMSM(sendMessageVO);
        returnT.setCode(0);
        returnT.setContent("任务执行完毕");
        returnT.setMsg("success");
        return returnT;
    }
}
