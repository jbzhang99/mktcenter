package com.bizvane.mktcenterserviceimpl.service.jobhandler;

import com.alibaba.fastjson.JSON;
import com.bizvane.couponfacade.interfaces.CouponEntityServiceFeign;
import com.bizvane.couponfacade.interfaces.SendCouponServiceFeign;
import com.bizvane.couponfacade.models.po.CouponEntityPO;
import com.bizvane.couponfacade.models.vo.SendCouponSimpleRequestVO;
import com.bizvane.members.facade.enums.IntegralChangeTypeEnum;
import com.bizvane.members.facade.models.IntegralRecordModel;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.members.facade.service.api.IntegralRecordApiService;
import com.bizvane.members.facade.service.api.MemberInfoApiService;
import com.bizvane.members.facade.vo.MemberInfoApiModel;
import com.bizvane.mktcenterservice.interfaces.ActivityBirthdayService;
import com.bizvane.mktcenterservice.models.po.MktActivityPO;
import com.bizvane.mktcenterservice.models.po.MktActivityPOExample;
import com.bizvane.mktcenterservice.models.po.MktCouponPO;
import com.bizvane.mktcenterservice.models.po.MktCouponPOExample;
import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.mktcenterserviceimpl.common.award.MemberMessageSend;
import com.bizvane.mktcenterserviceimpl.common.enums.ActivityTypeEnum;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityBirthdayPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktCouponPOMapper;
import com.bizvane.utils.responseinfo.PageInfo;
import com.bizvane.utils.responseinfo.ResponseData;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
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
        List<ActivityVO> activityBirthdayList = mktActivityBirthdayPOMapper.getActivityBirthdayList(vo);
        log.info("定时器开始执行生日活动+++++====="+ JSON.toJSONString(activityBirthdayList));
        memberMessage.sendBirthdayCoupon(activityBirthdayList);
        returnT.setCode(0);
        returnT.setContent("活动执行完毕");
        returnT.setMsg("success");
        return returnT;
    }

}
