package com.bizvane.mktcenterservice.service.jobhandler;

import com.bizvane.members.facade.service.api.MemberInfoApiService;
import com.bizvane.members.facade.service.api.MemberLevelApiService;
import com.bizvane.mktcenterfacade.models.po.MktActivityPO;
import com.bizvane.mktcenterfacade.models.po.MktActivityPOExample;
import com.bizvane.mktcenterservice.common.award.Award;
import com.bizvane.mktcenterservice.common.award.MemberMessageSend;
import com.bizvane.mktcenterservice.common.enums.ActivityStatusEnum;
import com.bizvane.mktcenterservice.common.enums.CheckStatusEnum;
import com.bizvane.mktcenterservice.mappers.MktActivityOrderPOMapper;
import com.bizvane.mktcenterservice.mappers.MktActivityPOMapper;
import com.bizvane.mktcenterservice.mappers.MktActivityUpgradePOMapper;
import com.bizvane.mktcenterservice.mappers.MktMessagePOMapper;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@JobHandler(value="activity")
@Component
public class ActivityJobHandler extends IJobHandler {

    @Autowired
    private MktActivityPOMapper mktActivityPOMapper;
    @Autowired
    private MktMessagePOMapper mktMessagePOMapper;
    @Autowired
    private MemberInfoApiService memberInfoApiService;
    @Autowired
    private MemberLevelApiService memberLevelApiService;
    @Autowired
    private MktActivityUpgradePOMapper mktActivityUpgradePOMapper;
    @Autowired
    private MktActivityOrderPOMapper mktActivityOrderPOMapper;
    @Autowired
    private Award award;
    private MemberMessageSend memberMessage;
    @Override
    public ReturnT<String> execute(String param) throws Exception {

        System.out.println("job执行参数 "+param);
        ReturnT returnT = new ReturnT();
        System.out.println("开始执行活动");
        //查询该活动是否已经审核
        MktActivityPOExample examplem = new MktActivityPOExample();
        examplem.createCriteria().andActivityCodeEqualTo(param).andValidEqualTo(true);
        List<MktActivityPO> mktActivityPOs = mktActivityPOMapper.selectByExample(examplem);
        MktActivityPO mktActivityPO = mktActivityPOs.get(0);
           //如果是审核通过把活动状态置为执行中
            if (mktActivityPO.getCheckStatus()==CheckStatusEnum.CHECK_STATUS_APPROVED.getCode()){
                MktActivityPO po = new MktActivityPO();
                po.setActivityCode(param);
                po.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode());
                //把活动状态改成执行中
                int sum = mktActivityPOMapper.updateActivityStatus(po);
            }


        returnT.setCode(0);
        returnT.setContent("活动执行完毕");
        returnT.setMsg("success");
        return returnT;
    }
}
