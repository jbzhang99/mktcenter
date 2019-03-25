package com.bizvane.messageservice.wxpublicapi;

import com.alibaba.fastjson.JSONObject;
import com.bizvane.wechatfacade.models.po.WxPublicPO;

/**
 * @Author paco
 * @Date 2017/12/22
 */
public interface ISendWXTemplateMessage {
    void send(JSONObject data, JSONObject templateData, WxPublicPO wu, String touser)/* throws ApiException;*/;
}
