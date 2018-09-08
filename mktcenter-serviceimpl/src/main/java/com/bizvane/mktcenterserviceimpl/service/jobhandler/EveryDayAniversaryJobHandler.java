package com.bizvane.mktcenterserviceimpl.service.jobhandler;

import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.mktcenterserviceimpl.common.award.MemberMessageSend;
import com.bizvane.mktcenterserviceimpl.common.enums.ActivityTypeEnum;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityVipAniversaryPOMapper;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by agan on 2018/8/1.
 */
@JobHandler(value="everyDayActivityAniversary")
@Component
public class EveryDayAniversaryJobHandler extends IJobHandler {
    @Autowired
    private MktActivityVipAniversaryPOMapper mktActivityVipAniversaryPOMapper;
    @Autowired
    private MemberMessageSend memberMessage;
    @Override
    public ReturnT<String> execute(String param) throws Exception {
        System.out.println("job执行参数 "+param);
        ReturnT returnT = new ReturnT();
        System.out.println("开始执行活动");
        //查询所有的执行中的纪念日活动
        ActivityVO vo = new ActivityVO();
        vo.setActivityType(ActivityTypeEnum.ACTIVITY_TYPE_ANNIVERSARY.getCode());
        List<ActivityVO> activityAniversaryList = mktActivityVipAniversaryPOMapper.getActivityAniversaryList(vo);
        memberMessage.sendAniversaryCoupon(activityAniversaryList);
        returnT.setCode(0);
        returnT.setContent("活动执行完毕");
        returnT.setMsg("success");
        return returnT;
    }

}
