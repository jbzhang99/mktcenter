package com.bizvane.couponservice.service;

import com.bizvane.couponfacade.models.po.CouponBatchSendRecordPO;

public interface CouponBatchSendRecordService {


    /**
     * 根据批次code查找批次
     * @param batchSendCode
     * @return
     */
    CouponBatchSendRecordPO findBatchSendRecord(String batchSendCode);
}