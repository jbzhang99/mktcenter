package com.bizvane.couponservice.service;

import com.bizvane.centerstageservice.models.po.SysAccountPo;
import com.bizvane.couponfacade.models.po.CouponQuotaDetailPO;
import com.bizvane.couponfacade.models.po.CouponQuotaPO;
import com.bizvane.couponfacade.models.vo.CouponQuotaDetailVO;
import com.bizvane.couponfacade.models.vo.CouponQuotaVO;
import com.bizvane.couponfacade.utils.PageFormUtil;
import com.bizvane.utils.responseinfo.PageInfo;
import com.bizvane.utils.responseinfo.ResponseData;

import java.util.List;

/**
 * 企业微信券service
 *
 */
public interface CouponQuotaService {

	ResponseData<Long> add(CouponQuotaVO po, SysAccountPo accountPo);

	ResponseData<PageInfo<CouponQuotaPO>> getCouponQuotaList(CouponQuotaVO vo, SysAccountPo accountPo, PageFormUtil pageForm);


	ResponseData<PageInfo<CouponQuotaDetailPO>> getCouponQuotaListDetail(CouponQuotaDetailVO vo, SysAccountPo accountPo,
                                                                         PageFormUtil pageForm);

	ResponseData<String> updateBycouponQuotaId(CouponQuotaVO vo, SysAccountPo accountPo);

	ResponseData<List<CouponQuotaDetailPO>> getCouponQuotaListDetailforupdate(CouponQuotaDetailVO vo, SysAccountPo accountPo);
			
			
			

}
