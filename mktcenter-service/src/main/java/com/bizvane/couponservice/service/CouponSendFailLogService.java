package com.bizvane.couponservice.service;

import com.bizvane.couponfacade.models.po.CouponDefinitionPO;
import com.bizvane.couponfacade.models.po.CouponEntityPO;

import java.util.Date;

/**
 * Created by yunjie.tian on 2018/9/30.
 */
public interface CouponSendFailLogService {

    /**
     * 新增发券失败记录
     * @param definitionPO
     * @param entityPO
     */
    void saveCouponSendFailLog(CouponDefinitionPO definitionPO, CouponEntityPO entityPO);

    /**
     * 更新券发放状态
      * @param sendStatus
     * @param couponCode
     */
    void updateSendStatus(Byte sendStatus, String couponCode);


    /**
     * 更新发券失败信息
     * @param sendStatus
     * @param sendDate
     * @param couponSendFailLogId
     */
    void updateSendStatusAndSendTimes(Byte sendStatus, Date sendDate, Long couponSendFailLogId);
}
