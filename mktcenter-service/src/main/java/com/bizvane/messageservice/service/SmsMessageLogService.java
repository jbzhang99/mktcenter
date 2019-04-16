package com.bizvane.messageservice.service;


import com.bizvane.messageservice.common.utils.PageForm;
import com.bizvane.messagefacade.models.po.MsgSmsLogPO;
import com.bizvane.messagefacade.models.po.MsgSmsLogPOExample;
import com.bizvane.messagefacade.models.vo.GenrealGetMessageVO;
import com.bizvane.messagefacade.models.vo.Result;
import com.bizvane.messagefacade.models.vo.SmsMessageLogVo;
import com.github.pagehelper.PageInfo;
import com.bizvane.utils.responseinfo.ResponseData;

import java.util.List;

/**
 * Created by Geng on 2018/8/9.
 */
public interface SmsMessageLogService {
	
	  Result<String> insert(MsgSmsLogPO po);

	  Result<Object> update(MsgSmsLogPO po);

	  Result<Object> update(MsgSmsLogPO po, MsgSmsLogPOExample example);

	  ResponseData<Object> getMsgLogPage(SmsMessageLogVo smsMessageLogVo, PageForm pageForm);

	  ResponseData<Object> getStatistics(SmsMessageLogVo smsMessageLogVo);
	  
	  ResponseData<Object> getReturnMessage(GenrealGetMessageVO genrealGetMessageVO);

	/**
	 * @param phone
	 * @return
	 */
 	  PageInfo<MsgSmsLogPO> rocketLogPOList(SmsMessageLogVo msgSmsLogPO, PageForm pageForm);

	 Result<String> insertCreateDate(List<MsgSmsLogPO> insertPO);
	
}
