package com.bizvane.mktcenterfacade.interfaces;

import com.bizvane.mktcenterfacade.models.po.MktConvertCouponRecordPO;
import com.bizvane.mktcenterfacade.models.vo.CouponRecordVO;
import com.bizvane.mktcenterfacade.models.bo.CouponIntegralExchangeBO;
import com.bizvane.mktcenterfacade.models.vo.CouponIntegralExchangeVO;
import com.bizvane.utils.responseinfo.ResponseData;
import com.github.pagehelper.PageInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: lijunwei
 * @Time: 2018/11/23 11:28
 */
public interface ConvertCouponService {

    public ResponseData<PageInfo<MktConvertCouponRecordPO>> getCouponRecordLists(CouponRecordVO vo);

    public ResponseData<CouponIntegralExchangeBO> getConvernCouponLists(CouponRecordVO vo);

    public ResponseData<Integer> doConvernCoupon(CouponRecordVO vo);

    public ResponseData<PageInfo<MktConvertCouponRecordPO>> getConvernConpouByMember(CouponRecordVO vo);

    public void doExportData(CouponRecordVO vo,HttpServletResponse response) throws IOException;

    public ResponseData doExportData001(CouponRecordVO vo, HttpServletRequest request);

    public ResponseData<CouponIntegralExchangeVO> getCouponAndPrice(CouponRecordVO vo);
}
