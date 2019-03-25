package com.bizvane.couponservice.service;

import com.bizvane.couponservice.common.datavo.ReportTempPO;
import com.bizvane.utils.tokens.SysAccountPO;

public interface CouponReportTempService {



	void Export(SysAccountPO sysAccountPO, String nameEnd, String jsonStr, ReportTempPO fileReportTempPOlist);

}
