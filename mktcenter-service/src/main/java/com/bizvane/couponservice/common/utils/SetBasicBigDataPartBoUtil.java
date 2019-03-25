package com.bizvane.couponservice.common.utils;

import com.bizvane.couponfacade.models.bo.BigDataPartBo;
import com.bizvane.couponfacade.models.bo.CouponPartBo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * Created by 26095 on 2019/1/25.
 */
@Component
public class SetBasicBigDataPartBoUtil {
    //给商家编号，ApiKey,开始时间和结束时间赋值;
    public  BigDataPartBo setBigDataPartBo(BigDataPartBo bigDataPartBo, CouponPartBo bo){
       /* BaseUrl baseUrl = new BaseUrl();
        bigDataPartBo.setBusinessNum(baseUrl.getBusinessNum());
        bigDataPartBo.setApiKey(baseUrl.getApiKey());*/

        String startDate = bo.getStartDate();
        String endDate = bo.getEndDate();
        //日期转化的实体类
        DateConversionUtil dateConversionUtil = new DateConversionUtil();
        //针对不同的情况给初始时间和结束时间赋予初始值
        if(StringUtils.isNotEmpty(startDate)&&StringUtils.isNotEmpty(endDate)){
            bigDataPartBo.setStartDate(startDate);
            bigDataPartBo.setEndDate(endDate);
        }else{
            //获取前一天的日期(结束时间)
            String yesterday = dateConversionUtil.getYesterday();
            bigDataPartBo.setEndDate(yesterday+" 23:59:59");
            startDate = dateConversionUtil.getStartAndEndDate(yesterday,bo.getNumber(),bo.getParticleSize());
            bigDataPartBo.setStartDate(startDate+" 00:00:00");
        }
        if(StringUtils.isNotBlank(bo.getParticleSize())){
            bigDataPartBo.setParticleSize(bo.getParticleSize());
        }
        return bigDataPartBo;
    }
}
