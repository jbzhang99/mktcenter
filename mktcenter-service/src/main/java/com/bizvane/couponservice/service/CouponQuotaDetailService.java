package com.bizvane.couponservice.service;

import com.bizvane.centerstageservice.models.po.SysAccountPo;
import com.bizvane.couponfacade.models.po.CouponQuotaDetailPO;
import com.bizvane.couponfacade.models.po.CouponQuotaSendDetailPO;
import com.bizvane.couponfacade.models.vo.CouponEntityVO;
import com.bizvane.couponfacade.models.vo.CouponQuotaDetailVO;
import com.bizvane.couponfacade.models.vo.SendCouponQuotaBatchRequestVO;
import com.bizvane.couponfacade.utils.PageFormUtil;
import com.github.pagehelper.PageInfo;
import com.bizvane.utils.responseinfo.ResponseData;

/**
 * 企业微信券service
 *
 */
public interface CouponQuotaDetailService {

	ResponseData<PageInfo<CouponQuotaDetailPO>> getCouponQuotaListDetail(CouponQuotaDetailVO vo, SysAccountPo accountPo,
                                                                         PageFormUtil pageForm);

	ResponseData<String> batchRpc(SendCouponQuotaBatchRequestVO vo);

	ResponseData<PageInfo<CouponQuotaSendDetailPO>> getSendCouponQuotaListDetail(CouponQuotaDetailVO vo, SysAccountPo accountPo, PageFormUtil pageForm);

	ResponseData<PageInfo<CouponEntityVO>> getList(CouponEntityVO vo, SysAccountPo accountPo, PageFormUtil pageForm);

	ResponseData<CouponQuotaDetailPO> getCouponQuotaListDetail(CouponQuotaDetailVO vo);
			

}
