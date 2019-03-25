package com.bizvane.mktcenterservice.service.jobhandler;

import com.alibaba.fastjson.JSON;
import com.bizvane.mktcenterfacade.models.vo.ActivityVO;
import com.bizvane.mktcenterservice.common.award.MemberMessageSend;
import com.bizvane.mktcenterservice.common.enums.ActivityStatusEnum;
import com.bizvane.mktcenterservice.common.enums.ActivityTypeEnum;
import com.bizvane.mktcenterservice.mappers.MktActivityBirthdayPOMapper;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by agan on 2018/8/1.
 */
@JobHandler(value="everyDayActivityBirthday")
@Component
@Slf4j
public class EveryDayActivityJobHandler extends IJobHandler {
    @Autowired
    private MktActivityBirthdayPOMapper mktActivityBirthdayPOMapper;
    @Autowired
    private MemberMessageSend memberMessage;
    @Override
    public ReturnT<String> execute(String param) throws Exception {
        System.out.println("job执行参数 "+param);
        ReturnT returnT = new ReturnT();
        System.out.println("开始执行活动");
        //查询所有的执行中的生日活动
        ActivityVO vo = new ActivityVO();
        vo.setActivityType(ActivityTypeEnum.ACTIVITY_TYPE_BIRTHDAY.getCode());
        vo.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode());
        List<ActivityVO> activityBirthdayList = mktActivityBirthdayPOMapper.getActivityBirthdayList(vo);
        log.info("定时器开始执行生日活动+++++====="+ JSON.toJSONString(activityBirthdayList));
        memberMessage.sendBirthdayCoupon(activityBirthdayList);
        returnT.setCode(0);
        returnT.setContent("活动执行完毕");
        returnT.setMsg("success");
        return returnT;
    }

}
