package com.bizvane.mktcenterserviceimpl.common.award;

import com.bizvane.mktcenterservice.models.bo.AwardBO;
import com.bizvane.mktcenterserviceimpl.common.enums.MktSmartTypeEnum;
import com.bizvane.utils.responseinfo.ResponseData;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author chen.li
 * @date on 2018/8/3 14:48
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@Component
@Slf4j
public class Award {

    @Autowired
    private AwardFactory awardFactory;

    public ResponseData<T> execute(AwardBO bo){
        ResponseData responseData = new ResponseData();
        try {
            MktSmartTypeEnum mktSmartTypeEnum = MktSmartTypeEnum.getMktSmartTypeEnumByCode(bo.getMktType());
            switch (mktSmartTypeEnum){
                //券奖励
                case SMART_TYPE_COUPON:
                    responseData =awardFactory.awardCouponSimple(bo);
                    break;
                //积分奖励
                case SMART_TYPE_INTEGRAL:
                    responseData =awardFactory.awardIntegral(bo);
                    break;
                //短信消息通知
                case SMART_TYPE_SMS:
                    responseData =awardFactory.sendSms(bo);
                    break;
                //模板消息通知
                case SMART_TYPE_WXMESSAGE:
                    responseData =awardFactory.sendWxTemplateMessage(bo);
                    break;
                //批量发券
                case SMART_TYPE_COUPON_BATCH:
                    responseData =awardFactory.awardCouponBatch(bo);
                    break;
                default:break;
            }
        } catch (Exception e) {
            log.error("com.bizvane.mktcenterserviceimpl.common.award.Award.execute error"+e.getMessage());
        }
        return responseData;
    }
}
