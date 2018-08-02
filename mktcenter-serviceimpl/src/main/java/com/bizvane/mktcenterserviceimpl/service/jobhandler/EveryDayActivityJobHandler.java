package com.bizvane.mktcenterserviceimpl.service.jobhandler;

import com.bizvane.couponfacade.interfaces.SendCouponServiceFeign;
import com.bizvane.couponfacade.models.vo.SendCouponSimpleRequestVO;
import com.bizvane.members.facade.enums.IntegralChangeTypeEnum;
import com.bizvane.members.facade.models.IntegralRecordModel;
import com.bizvane.members.facade.service.api.IntegralRecordApiService;
import com.bizvane.mktcenterservice.models.po.MktActivityPO;
import com.bizvane.mktcenterservice.models.po.MktActivityPOExample;
import com.bizvane.mktcenterservice.models.po.MktCouponPO;
import com.bizvane.mktcenterservice.models.po.MktCouponPOExample;
import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.mktcenterserviceimpl.common.enums.ActivityTypeEnum;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityBirthdayPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktCouponPOMapper;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by agan on 2018/8/1.
 */
@JobHandler(value="everyDayActivityBirthday")
@Component
public class EveryDayActivityJobHandler extends IJobHandler {
    @Autowired
    private MktActivityBirthdayPOMapper mktActivityBirthdayPOMapper;
    @Autowired
    private IntegralRecordApiService integralRecordApiService;
    @Autowired
    private MktCouponPOMapper mktCouponPOMapper;
    @Autowired
    private SendCouponServiceFeign sendCouponServiceFeign;
    @Override
    public ReturnT<String> execute(String param) throws Exception {
        System.out.println("job执行参数 "+param);
        ReturnT returnT = new ReturnT();
        System.out.println("开始执行活动");
        //查询所有的执行中的生日活动
        ActivityVO vo = new ActivityVO();
        vo.setActivityType(ActivityTypeEnum.ACTIVITY_TYPE_BIRTHDAY.getCode());
        List<ActivityVO> activityBirthdayList = mktActivityBirthdayPOMapper.getActivityBirthdayList(vo);
            for (ActivityVO activityBirthday:activityBirthdayList) {
                //根据品牌id 会员等级 会员范围  时间周期 查询会员信息 循环

                //拿到会员 在到券那里确认有没有发卷 没有执行发券和积分操作

                //增加积分奖励新增接口
                IntegralRecordModel var1 = new IntegralRecordModel();
                var1.setMemberCode("会员编号");
                var1.setChangeBills(activityBirthday.getActivityCode());
                var1.setChangeIntegral(activityBirthday.getPoints());
                var1.setChangeWay(IntegralChangeTypeEnum.INCOME.getCode());
                integralRecordApiService.updateMemberIntegral(var1);
                //新增券奖励
                // 增加卷奖励接口
                MktCouponPOExample example = new  MktCouponPOExample();
                example.createCriteria().andBizIdEqualTo(activityBirthday.getMktActivityId());
                example.createCriteria().andValidEqualTo(true);
                List<MktCouponPO> mktCouponPOs= mktCouponPOMapper.selectByExample(example);
                for (MktCouponPO mktCouponPO:mktCouponPOs) {
                    SendCouponSimpleRequestVO va = new SendCouponSimpleRequestVO();
                    va.setMemberCode("会员编号");
                    va.setCouponDefinitionId(mktCouponPO.getCouponId());
                    va.setSendBussienId(mktCouponPO.getBizId());
                    va.setSendType("10");
                    sendCouponServiceFeign.simple(va);
                }
            }
        //查询品牌下所有会员 发送奖励TODO
        return null;
    }
}
