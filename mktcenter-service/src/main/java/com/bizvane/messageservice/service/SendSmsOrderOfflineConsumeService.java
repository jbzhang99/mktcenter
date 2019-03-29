package com.bizvane.messageservice.service;

import com.bizvane.messagefacade.models.vo.Result;

/**
 * @author xiao.shu
 * @date on 2018/8/9 19:53
 * @description
 *
 */
public interface SendSmsOrderOfflineConsumeService {

    Result<String> sendMessage(String rocketMsgId, String messageBody);


}
