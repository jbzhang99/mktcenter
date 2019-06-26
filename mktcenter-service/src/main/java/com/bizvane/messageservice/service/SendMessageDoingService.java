package com.bizvane.messageservice.service;

import com.alibaba.fastjson.JSONObject;
import com.bizvane.messagefacade.models.vo.Result;

/**
 * @author chen.li
 * @date on 2019/6/26 19:07
 * @description
 */
public interface SendMessageDoingService {

    public Result<String> sendMessageDoing(JSONObject jsonObject);
}
