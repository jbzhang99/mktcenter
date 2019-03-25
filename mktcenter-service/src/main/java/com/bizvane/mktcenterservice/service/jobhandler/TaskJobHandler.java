package com.bizvane.mktcenterservice.service.jobhandler;

import com.bizvane.mktcenterfacade.models.po.MktTaskPO;
import com.bizvane.mktcenterfacade.models.po.MktTaskPOExample;
import com.bizvane.mktcenterservice.mappers.MktTaskPOMapper;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author chen.li
 * @date on 2018/7/14 20:44
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@JobHandler(value="task")
@Component
public class TaskJobHandler extends IJobHandler {

    @Autowired
    private MktTaskPOMapper mktTaskPOMapper;

    @Override
    public ReturnT<String> execute(String param) throws Exception {

        System.out.println("job执行参数 "+param);
        ReturnT returnT = new ReturnT();
        System.out.println("开始执行邀请注册任务");
        List<MktTaskPO> mktTaskPOS = mktTaskPOMapper.selectByExample(new MktTaskPOExample());
        System.out.println(mktTaskPOS.toArray().toString());
        returnT.setCode(0);
        returnT.setContent("邀请注册任务执行完毕");
        returnT.setMsg("success");
        return returnT;
    }
}
