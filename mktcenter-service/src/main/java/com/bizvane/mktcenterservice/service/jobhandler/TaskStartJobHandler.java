package com.bizvane.mktcenterservice.service.jobhandler;

import com.bizvane.mktcenterfacade.interfaces.TaskService;
import com.bizvane.mktcenterfacade.models.po.MktTaskPOExample;
import com.bizvane.mktcenterfacade.models.po.MktTaskPOWithBLOBs;

import com.bizvane.mktcenterservice.common.award.Award;
import com.bizvane.mktcenterservice.common.enums.TaskStatusEnum;
import com.bizvane.mktcenterservice.mappers.MktMessagePOMapper;
import com.bizvane.mktcenterservice.mappers.MktTaskPOMapper;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author chen.li
 * @date on 2018/7/14 20:44
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 * 主要用于定时发送短信和消息
 */
@JobHandler(value="startTaskJob")
@Component
public class TaskStartJobHandler extends IJobHandler {
    @Autowired
    private Award award;
    @Autowired
    private TaskService taskService;
    @Autowired
    private MktTaskPOMapper mktTaskPOMapper;
    @Autowired
    private MktMessagePOMapper mktMessagePOMapper;
    @Override
    public ReturnT<String> execute(String param) throws Exception {
        ReturnT returnT = new ReturnT();
        System.out.println("job执行参数 "+param);
        String[] split = param.split("&");
        Long mktTaskId = Long.valueOf(split[0]);

        MktTaskPOWithBLOBs mktTaskPOWithBLOBs = new MktTaskPOWithBLOBs();
        mktTaskPOWithBLOBs.setTaskStatus(TaskStatusEnum.TASK_STATUS_EXECUTING.getCode());
        MktTaskPOExample example = new MktTaskPOExample();
        example.createCriteria().andMktTaskIdEqualTo(mktTaskId).andValidEqualTo(Boolean.TRUE);
        mktTaskPOMapper.updateByExampleSelective(mktTaskPOWithBLOBs,example);

//        MktTaskPOWithBLOBs mktTask= mktTaskPOMapper.selectByPrimaryKey(mktTaskId);
//
//        MktMessagePOExample exampleMSG = new MktMessagePOExample();
//        exampleMSG.createCriteria().andBizIdEqualTo(mktTaskId).andValidEqualTo(Boolean.TRUE);
//        List<MktMessagePO> mktMessagePOS = mktMessagePOMapper.selectByExample(exampleMSG);

      //  taskService.sendSmg(mktTask,mktMessagePOS);

        returnT.setCode(0);
        returnT.setContent("任务执行完毕");
        returnT.setMsg("success");
        return returnT;
    }
}
