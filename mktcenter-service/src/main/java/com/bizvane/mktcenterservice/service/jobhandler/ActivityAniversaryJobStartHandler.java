package com.bizvane.mktcenterservice.service.jobhandler;

import com.bizvane.mktcenterfacade.models.po.MktActivityPO;
import com.bizvane.mktcenterfacade.models.po.MktActivityPOExample;
import com.bizvane.mktcenterservice.common.enums.ActivityStatusEnum;
import com.bizvane.mktcenterservice.common.enums.CheckStatusEnum;
import com.bizvane.mktcenterservice.common.job.XxlJobConfig;
import com.bizvane.mktcenterservice.mappers.MktActivityPOMapper;
import com.bizvane.utils.jobutils.JobClient;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by agan on 2018/8/1.
 */
@JobHandler(value="startActivityAniversary")
@Component
public class ActivityAniversaryJobStartHandler extends IJobHandler {
    @Autowired
    private MktActivityPOMapper mktActivityPOMapper;
    @Autowired
    private XxlJobConfig xxlJobConfig;

    @Autowired
    private JobClient jobClient;
    @Override
    public ReturnT<String> execute(String param) throws Exception {

        System.out.println("job执行参数 "+param);
        ReturnT returnT = new ReturnT();
        System.out.println("开始执行活动");
        //查询该活动是否已经审核
        MktActivityPOExample examplem = new MktActivityPOExample();
        examplem.createCriteria().andActivityCodeEqualTo(param);
        examplem.createCriteria().andValidEqualTo(true);
        List<MktActivityPO> mktActivityPOs = mktActivityPOMapper.selectByExample(examplem);
        if(mktActivityPOs.get(0).getCheckStatus()== CheckStatusEnum.CHECK_STATUS_APPROVED.getCode()){
            MktActivityPO po = new MktActivityPO();
            po.setActivityCode(param);
            po.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode());
            //把活动状态改成执行中
            int sum = mktActivityPOMapper.updateActivityStatus(po);

        }else{
            returnT.setCode(1);
            returnT.setContent("该活动未审核");
            returnT.setMsg("FAILED");
            return returnT;
        }

        returnT.setCode(0);
        returnT.setContent("活动执行完毕");
        returnT.setMsg("success");
        return returnT;
    }
}
