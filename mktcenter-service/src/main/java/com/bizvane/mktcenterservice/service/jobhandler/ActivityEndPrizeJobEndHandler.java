package com.bizvane.mktcenterservice.service.jobhandler;

import com.bizvane.mktcenterfacade.models.po.MktActivityPO;
import com.bizvane.mktcenterservice.common.enums.ActivityStatusEnum;
import com.bizvane.mktcenterservice.mappers.MktActivityPOMapper;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: lijunwei
 * @Time: 2018/12/28 14:55
 */
@JobHandler(value="endPrize")
@Component
public class ActivityEndPrizeJobEndHandler extends IJobHandler {
    @Autowired
    private MktActivityPOMapper mktActivityPOMapper;
    @Override
    public ReturnT<String> execute(String param) throws Exception {
        System.out.println("大转盘 ActivityEndPrizeJobEndHandler param: "+param);
        ReturnT returnT = new ReturnT();
        MktActivityPO po = new MktActivityPO();
        po.setActivityCode(param);
        po.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_FINISHED.getCode());
        //把活动状态改成已结束
        int sum = mktActivityPOMapper.updateActivityStatus(po);
        returnT.setCode(0);
        returnT.setContent("大转盘 ActivityEndPrizeJobEndHandler 活动执行完毕");
        returnT.setMsg("success");
        return returnT;
    }
}
