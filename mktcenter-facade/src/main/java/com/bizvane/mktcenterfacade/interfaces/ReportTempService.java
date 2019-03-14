package com.bizvane.mktcenterfacade.interfaces;

import com.bizvane.mktcenterfacade.models.po.FileReportTempPO;
import com.bizvane.utils.tokens.SysAccountPO;

public interface ReportTempService {



	void Export(SysAccountPO sysAccountPO, String nameEnd, String jsonStr, FileReportTempPO fileReportTempPOlist);

}
