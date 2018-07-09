package com.bizvane.mktcenterserviceimpl.service.jobhandler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.springframework.stereotype.Component;

@JobHandler(value="activity")
@Component
public class ActivityJobHandler extends IJobHandler {

    @Override
    public ReturnT<String> execute(String param) throws Exception {
        System.out.println("开始执行生日活动");
        return null;
    }
}
