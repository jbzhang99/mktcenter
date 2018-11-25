package com.bizvane.mktcenterservice.interfaces;

import com.bizvane.mktcenterservice.models.po.MktConvertCouponRecordPO;
import com.bizvane.mktcenterservice.models.vo.CouponRecordVO;
import com.bizvane.mktcenterservice.models.vo.MktCouponIntegralExchangeVO;
import com.bizvane.utils.responseinfo.ResponseData;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Author: lijunwei
 * @Time: 2018/11/23 11:28
 */
public interface ConvertCouponService {

    public ResponseData<PageInfo<MktConvertCouponRecordPO>> getCouponRecordLists(CouponRecordVO vo);

    public  ResponseData<PageInfo<MktCouponIntegralExchangeVO>>  getConvernCouponLists(CouponRecordVO vo);
}
