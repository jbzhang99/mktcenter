package com.bizvane.mktcenterservice.interfaces;

import com.bizvane.mktcenterservice.models.po.MktConvertCouponRecordPO;
import com.bizvane.mktcenterservice.models.vo.CouponRecordVO;
import com.bizvane.mktcenterservice.models.vo.MktCouponIntegralExchangeVO;
import com.bizvane.utils.responseinfo.ResponseData;
import com.github.pagehelper.PageInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author: lijunwei
 * @Time: 2018/11/23 11:28
 */
public interface ConvertCouponService {

    public ResponseData<PageInfo<MktConvertCouponRecordPO>> getCouponRecordLists(CouponRecordVO vo);

    public  ResponseData<PageInfo<MktCouponIntegralExchangeVO>>  getConvernCouponLists(CouponRecordVO vo);

    public ResponseData<Integer> doConvernCoupon(CouponRecordVO vo);

    public ResponseData<PageInfo<MktConvertCouponRecordPO>> getConvernConpouByMember(CouponRecordVO vo);

    public void doExportData(CouponRecordVO vo,HttpServletResponse response) throws IOException;

    public ResponseData doExportData001(CouponRecordVO vo, HttpServletRequest request);
}
