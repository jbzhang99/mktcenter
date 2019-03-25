package com.bizvane.couponservice.service;

import com.bizvane.centerstageservice.models.po.SysAccountPo;
import com.bizvane.couponservice.common.datavo.BitDataRequestVO;
import com.bizvane.couponservice.common.datavo.BitDataVO;
import com.bizvane.utils.responseinfo.ResponseData;

/**
 * 
 *
 */
public interface BitDataAnalysisService {

	ResponseData<BitDataRequestVO> getCouponQuotaAnalysisDetail(BitDataVO vo, SysAccountPo accountPo);
		

}
