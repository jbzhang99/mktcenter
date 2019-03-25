package com.bizvane.messageservice.service;

import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;

import java.util.Date;

/**
 * Created by Geng on 2018/8/20.
 */
public interface MsgSendTimeService {

	public ResponseData saveSendTime(Date sendTimeStart, Date sendTimeEnd, SysAccountPO stageUser);

    public ResponseData getSendTime(Long sysBrandId);

}
