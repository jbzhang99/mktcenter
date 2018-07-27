package com.bizvane.mktcenterserviceimpl.service.jobhandler;

import com.bizvane.mktcenterservice.models.po.MktActivityPO;
import com.bizvane.mktcenterservice.models.po.MktActivityPOExample;
import com.bizvane.mktcenterservice.models.po.MktMessagePO;
import com.bizvane.mktcenterservice.models.po.MktMessagePOExample;
import com.bizvane.mktcenterserviceimpl.common.enums.ActivityStatusEnum;
import com.bizvane.mktcenterserviceimpl.common.enums.CheckStatusEnum;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktMessagePOMapper;
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
        if(mktActivityPOs.get(0).getCheckStatus()==CheckStatusEnum.CHECK_STATUS_APPROVED.getCode()){
            MktActivityPO po = new MktActivityPO();
            po.setActivityCode(param);
            po.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode());
            //把活动状态改成执行中
            int sum = mktActivityPOMapper.updateActivityStatus(po);
            //查询消息集合
            MktMessagePOExample example = new MktMessagePOExample();
            example.createCriteria().andBizIdEqualTo(Long.parseLong("param"));
            List<MktMessagePO> ListMktMessage = mktMessagePOMapper.selectByExample(example);
            //发送模板消息和短信消息给会员群体TODO
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
