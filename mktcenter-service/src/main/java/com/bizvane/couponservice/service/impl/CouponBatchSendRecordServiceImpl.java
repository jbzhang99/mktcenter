package com.bizvane.couponservice.service.impl;

import com.bizvane.couponfacade.models.po.CouponBatchSendRecordPO;
import com.bizvane.couponfacade.models.po.CouponBatchSendRecordPOExample;
import com.bizvane.couponfacade.constants.CouponConstants;
import com.bizvane.couponservice.mappers.CouponBatchSendRecordPOMapper;
import com.bizvane.couponservice.service.CouponBatchSendRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponBatchSendRecordServiceImpl implements CouponBatchSendRecordService{

    @Autowired
    private CouponBatchSendRecordPOMapper couponBatchSendRecordPOMapper;

    /**
     * 根据批次code查找批次
     * @param batchSendCode
     * @return
     */
    @Override
    public CouponBatchSendRecordPO findBatchSendRecord(String batchSendCode) {

        CouponBatchSendRecordPOExample batchExample = new CouponBatchSendRecordPOExample();
        batchExample.createCriteria().andBatchSendCodeEqualTo(batchSendCode).andValidEqualTo(CouponConstants.TABLE_VALID_EFFECTIVE);
        List<CouponBatchSendRecordPO> batchList = couponBatchSendRecordPOMapper.selectByExample(batchExample);
        CouponBatchSendRecordPO batchPO = batchList.get(0);
        return batchPO;
    }
}
