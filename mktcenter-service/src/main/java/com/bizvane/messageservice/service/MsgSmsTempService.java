package com.bizvane.messageservice.service;

import com.bizvane.messagefacade.models.po.MsgSmsTempPO;
import com.bizvane.utils.responseinfo.ResponseData;

import java.util.List;


public interface MsgSmsTempService {
	
	  /**
	   * 根据模板类型查询
	   * @param templateType
	   * @return
	   */
	    ResponseData<Object> getTemplateByType(Long sysBrandId, String businessType, String templateType);
	    ResponseData<Object> findBytemplateType(String templateType);
	    
	    /**
	     * 根据id更新
	     */
	    ResponseData<Object> updateMsgSmsTempById(MsgSmsTempPO po);

		ResponseData<Object> insert(MsgSmsTempPO po);
		ResponseData<List<MsgSmsTempPO>> getQyTemplateByType(Long sysBrandId, String businessType, String templateType);
}
