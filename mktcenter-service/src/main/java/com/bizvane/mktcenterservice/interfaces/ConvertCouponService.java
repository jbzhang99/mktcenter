package com.bizvane.mktcenterservice.interfaces;

import com.bizvane.mktcenterservice.models.po.MktConvertCouponRecordPO;
import com.bizvane.mktcenterservice.models.vo.CouponRecordVO;

import java.util.List;

/**
 * @Author: lijunwei
 * @Time: 2018/11/23 11:28
 */
public interface ConvertCouponService {

    public List<MktConvertCouponRecordPO> getCouponRecordLists(CouponRecordVO vo);
}
