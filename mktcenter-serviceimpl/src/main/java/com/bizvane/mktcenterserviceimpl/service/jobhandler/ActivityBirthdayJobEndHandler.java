package com.bizvane.mktcenterserviceimpl.service.jobhandler;

import com.bizvane.mktcenterservice.models.po.MktActivityPO;
import com.bizvane.mktcenterservice.models.po.MktActivityPOExample;
import com.bizvane.mktcenterserviceimpl.common.enums.ActivityStatusEnum;
import com.bizvane.mktcenterserviceimpl.common.enums.BusinessTypeEnum;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityPOMapper;
import com.bizvane.utils.jobutils.JobClient;
import com.bizvane.utils.jobutils.XxlJobInfo;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by agan on 2018/8/1.
 */
@JobHandler(value="endActivityBirthday")
@Component
public class ActivityBirthdayJobEndHandler extends IJobHandler {
    @Autowired
    private MktActivityPOMapper mktActivityPOMapper;
    @Autowired
    private JobClient jobClient;
    @Override
    public ReturnT<String> execute(String param) throws Exception {
        System.out.println("job执行参数 "+param);
        ReturnT returnT = new ReturnT();
        MktActivityPO po = new MktActivityPO();
        po.setActivityCode(param);
        po.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_FINISHED.getCode());
        //把活动状态改成已结束
        int sum = mktActivityPOMapper.updateActivityStatus(po);
        //删除每天那个执行的定时任务
        //查询该活动是否已经审核
        MktActivityPOExample examplem = new MktActivityPOExample();
        examplem.createCriteria().andActivityCodeEqualTo(param);
        examplem.createCriteria().andValidEqualTo(true);
        List<MktActivityPO> mktActivityPOs = mktActivityPOMapper.selectByExample(examplem);
        //查询job
        XxlJobInfo xxlJobInfo = new XxlJobInfo();
        xxlJobInfo.setExecutorParam(mktActivityPOs.get(0).getActivityCode());
        xxlJobInfo.setBizType(BusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode());
        ResponseEntity<String> jobList =jobClient.getJobInfoByBizJob(xxlJobInfo);
        //删除jobTODO
        returnT.setCode(0);
        returnT.setContent("活动执行完毕");
        returnT.setMsg("success");
        return returnT;
    }
}
