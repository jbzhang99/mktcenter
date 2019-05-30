package com.bizvane.messagefacade.interfaces;

import com.bizvane.messagefacade.models.po.MsgWxTempPO;
import com.bizvane.utils.responseinfo.ResponseData;

public interface WxNewTempService {

	ResponseData<Object> getWxTemplate(Long sysBrandId);

	ResponseData<Object> saveWxTemplate(MsgWxTempPO msgWxTempPO);

}
