package com.bizvane.mktcenterserviceimpl.service.jobhandler;

import com.bizvane.mktcenterservice.models.po.MktActivityPO;
import com.bizvane.mktcenterserviceimpl.common.enums.ActivityStatusEnum;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityPOMapper;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: lijunwei
 * @Time: 2018/12/28 14:56
 */
@JobHandler(value="startPrize")
@Component
public class ActivityStartPrizeJobEndHandler extends IJobHandler {
    @Autowired
    private MktActivityPOMapper mktActivityPOMapper;
    @Override
    public ReturnT<String> execute(String param) throws Exception {
        System.out.println("大转盘 ActivityStartPrizeJobEndHandler param: "+param);
        ReturnT returnT = new ReturnT();
        MktActivityPO po = new MktActivityPO();
        po.setActivityCode(param);
        po.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode());
        //把活动状态改成已结束
        int sum = mktActivityPOMapper.updateActivityStatus(po);
        returnT.setCode(0);
        returnT.setContent("大转盘 ActivityStartPrizeJobEndHandler 活动执行完毕");
        returnT.setMsg("success");
        return returnT;
    }
}