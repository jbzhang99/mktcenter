package com.bizvane.mktcenterserviceimpl.service.jobhandler;

import com.alibaba.fastjson.JSON;
import com.bizvane.mktcenterservice.interfaces.TaskService;
import com.bizvane.mktcenterservice.models.po.*;
import com.bizvane.mktcenterserviceimpl.common.award.Award;
import com.bizvane.mktcenterserviceimpl.common.enums.TaskStatusEnum;
import com.bizvane.mktcenterserviceimpl.mappers.MktMessagePOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktTaskPOMapper;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author chen.li
 * @date on 2018/7/14 20:44
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@JobHandler(value="startTaskJob")
@Component
public class TaskStartJobHandler extends IJobHandler {

    @Autowired
    private MktMessagePOMapper mktMessagePOMapper;
    @Autowired
    private Award award;
    @Autowired
    private TaskService taskService;
    @Autowired
    private MktTaskPOMapper mktTaskPOMapper;

    @Override
    public ReturnT<String> execute(String param) throws Exception {
        ReturnT returnT = new ReturnT();
        System.out.println("job执行参数 "+param);
        String[] split = param.split("&");

        MktTaskPOWithBLOBs mktTaskPOWithBLOBs = new MktTaskPOWithBLOBs();
        mktTaskPOWithBLOBs.setTaskStatus(TaskStatusEnum.TASK_STATUS_EXECUTING.getCode());
        MktTaskPOExample example = new MktTaskPOExample();
        example.createCriteria().andMktTaskIdEqualTo(Long.valueOf(split[0])).andValidEqualTo(Boolean.TRUE);
        mktTaskPOMapper.updateByExampleSelective(mktTaskPOWithBLOBs,example);

        MktTaskPOWithBLOBs mktTaskparam = mktTaskPOMapper.selectByPrimaryKey(Long.valueOf(split[0]));

        MktMessagePOExample exampleMSG = new MktMessagePOExample();
        exampleMSG.createCriteria().andBizIdEqualTo(Long.valueOf(split[0])).andValidEqualTo(Boolean.TRUE);
        List<MktMessagePO> mktMessagePOS = mktMessagePOMapper.selectByExample(exampleMSG);

        taskService.sendSmg(mktTaskparam,mktMessagePOS);
        returnT.setCode(0);
        returnT.setContent("任务执行完毕");
        returnT.setMsg("success");
        return returnT;
    }
}
