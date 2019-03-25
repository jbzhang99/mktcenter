package com.bizvane.couponservice.service;

import com.bizvane.couponfacade.models.po.CouponBatchSendRecordPO;

/**
 * Created by yunjie.tian on 2018/9/28.
 */
public interface CouponBatchSendRecordService {


    /**
     * 根据批次code查找批次
     * @param batchSendCode
     * @return
     */
    CouponBatchSendRecordPO findBatchSendRecord(String batchSendCode);
}