package com.bizvane.mktcenterservice.service.jobhandler;

import com.bizvane.mktcenterfacade.models.po.MktTaskPOExample;
import com.bizvane.mktcenterfacade.models.po.MktTaskPOWithBLOBs;
import com.bizvane.mktcenterservice.common.award.Award;
import com.bizvane.mktcenterservice.common.enums.TaskStatusEnum;
import com.bizvane.mktcenterservice.mappers.MktTaskPOMapper;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: lijunwei
 * @Time: 2018/8/5 20:33
 */

@JobHandler(value="endTaskJob")
@Component
public class TaskEndobHandler extends IJobHandler {

    @Autowired
    private Award award;
    @Autowired
    private MktTaskPOMapper mktTaskPOMapper;

    @Override
    public ReturnT<String> execute(String param) throws Exception {
        ReturnT returnT = new ReturnT();
        System.out.println("job执行参数 " + param);
        String[] split = param.split("&");
        MktTaskPOWithBLOBs mktTaskPOWithBLOBs = new MktTaskPOWithBLOBs();
        mktTaskPOWithBLOBs.setTaskStatus(TaskStatusEnum.TASK_STATUS_FINISHED.getCode());
//        mktTaskPOWithBLOBs.setValid(Boolean.FALSE);
        MktTaskPOExample example = new MktTaskPOExample();
        example.createCriteria().andMktTaskIdEqualTo(Long.valueOf(split[0])).andValidEqualTo(Boolean.TRUE);
        mktTaskPOMapper.updateByExampleSelective(mktTaskPOWithBLOBs,example);

        returnT.setCode(0);
        returnT.setContent("任务执行完毕");
        returnT.setMsg("success");
        return returnT;
    }

}
