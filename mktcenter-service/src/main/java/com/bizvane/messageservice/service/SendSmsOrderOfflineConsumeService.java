package com.bizvane.messageservice.service;

import com.bizvane.messagefacade.models.vo.Result;

/**
 * @author xiao.shu
 * @date on 2018/8/9 19:53
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
public interface SendSmsOrderOfflineConsumeService {

    Result<String> sendMessage(String rocketMsgId, String messageBody);


}
