package com.bizvane.messageservice.service;

import com.bizvane.messagefacade.models.po.MsgCoupontimePO;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;

import java.util.List;

/**
 * Created by Geng on 2018/8/20.
 */
public interface MsgCouponTimeService {

    public ResponseData<Long> saveSendTime(long sendTimeEnd, SysAccountPO stageUser);
    public ResponseData<Long> testCoupon()  ;

    public ResponseData<MsgCoupontimePO> getSendTime(long sysBrandId);


    /**
     * 查询优惠券到期通知集合
     * @return
     */
    ResponseData<List<MsgCoupontimePO>> getCouponTimeList();
}
