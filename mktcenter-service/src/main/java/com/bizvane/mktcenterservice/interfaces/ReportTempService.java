package com.bizvane.mktcenterservice.interfaces;

import com.bizvane.mktcenterservice.models.po.FileReportTempPO;
import com.bizvane.utils.tokens.SysAccountPO;

public interface ReportTempService {



	void Export(SysAccountPO sysAccountPO, String nameEnd, String jsonStr, FileReportTempPO fileReportTempPOlist);

}
