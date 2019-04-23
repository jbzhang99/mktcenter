package com.bizvane.couponservice.service.jobHandler;

import com.bizvane.couponfacade.models.po.CouponEntityPO;
import com.bizvane.couponfacade.models.po.CouponEntityPOExample;
import com.bizvane.couponservice.common.constants.SysResponseEnum;
import com.bizvane.couponfacade.constants.CouponConstants;
import com.bizvane.couponservice.common.utils.DateUtil;
import com.bizvane.couponservice.mappers.CouponEntityPOMapper;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 每天凌晨24点将已经过期的券设为已过期
 * Created by yunjie.tian on 2018/8/10.
 */
@JobHandler("couponStatusExpireJobHandler")
@Component
public class CouponStatusExpireJobHandler extends IJobHandler{

    private static final Logger logger = LoggerFactory.getLogger(CouponStatusExpireJobHandler.class);

    @Autowired
    private CouponEntityPOMapper couponEntityPOMapper;

    /**
     * 每天凌晨24点将已经过期的券设为已过期
     * @param s
     * @return
     * @throws Exception
     */
    @Override
    public ReturnT<String> execute(String s) throws Exception {

        logger.info("enter CouponStatusExpireJobHandler execute method !");

        ReturnT<String> returnT = new ReturnT<>();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        //大前天零点
        Date yesterDayZeroHour = DateUtil.getYesterDayZeroHour(-3);
        if(StringUtils.isNotBlank(s)) {
        	yesterDayZeroHour=DateUtil.getYesterDayZeroHour(Integer.valueOf(s));
        }
        //昨日23:59:59
        Date yesterDay24Hour = DateUtil.getYesterDay24Hour();
        CouponEntityPOExample entityPOExample = new CouponEntityPOExample();
        //每天0点将有效期在大前天0点至23:59分59秒置为过期（3日）
        entityPOExample.createCriteria().andValidDateEndGreaterThanOrEqualTo(yesterDayZeroHour)
                .andValidDateEndLessThanOrEqualTo(yesterDay24Hour)
                .andValidEqualTo(CouponConstants.TABLE_VALID_EFFECTIVE)
                .andCouponStatusNotEqualTo(CouponConstants.COUPON_STATUS_USED);
       // List<CouponEntityPO> entityPOList = couponEntityPOMapper.selectByExample(entityPOExample);
        CouponEntityPO entityPO = new CouponEntityPO();
        entityPO.setCouponStatus(CouponConstants.COUPON_STATUS_OVERDUE);
        couponEntityPOMapper.updateByExampleSelective(entityPO,entityPOExample);

        returnT.setCode(SysResponseEnum.SUCCESS.getCode());
        returnT.setMsg(SysResponseEnum.SUCCESS.getMessage());
        return returnT;
    }

}
