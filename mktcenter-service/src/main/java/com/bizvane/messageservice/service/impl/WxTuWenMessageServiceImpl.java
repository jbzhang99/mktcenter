package com.bizvane.messageservice.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bizvane.messageservice.common.network.HttpUtil;
import com.bizvane.messageservice.service.WxTuWenMessageService;
import com.bizvane.mktcenterfacade.models.bo.ObtainGraphicBo;
import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.TokenUtils;
import com.bizvane.wechatfacade.interfaces.WxPublicServiceFeign;
import com.bizvane.wechatfacade.models.po.WxPublicPO;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.util.List;

/**
 * @author chen.li
 * @date on 2019/6/28 17:59
 * @description
 */
@Slf4j
@Service
public class WxTuWenMessageServiceImpl implements WxTuWenMessageService {

    public static final Logger logger = LoggerFactory.getLogger(TokenUtils.class);
    //模板查询
    private static final String WXOBTAIN_FRAPHIC = "https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=";
    //模板总数
    private static final String WXOBTAIN_FRAPHIC_CONT = "https://api.weixin.qq.com/cgi-bin/material/get_materialcount?access_token=";
    //群发
    private static final String GROUP_SENDING = "https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token=";
    //群发回执
    private static final String GROUP_SENDING_DOING = "https://api.weixin.qq.com/cgi-bin/message/mass/get?access_token=";

    @Autowired
    private WxPublicServiceFeign wxPublicServiceFeign;

    @Override
    public ResponseData groupSending(ObtainGraphicBo obtainGraphicBo) {
        log.info("groupSending入参:{}", JSON.toJSONString(obtainGraphicBo));
        ResponseData responseData = new ResponseData();

        ResponseData<WxPublicPO> wxPublicBySysBrandId = wxPublicServiceFeign.getWxPublicBySysBrandId(obtainGraphicBo.getBrandId());
        WxPublicPO bySysBrandIdData = wxPublicBySysBrandId.getData();
        if (bySysBrandIdData != null) {
            String appid = bySysBrandIdData.getAppid();
            ResponseData<WxPublicPO> wxPublicPOByAppId = wxPublicServiceFeign.getWxPublicPOByAppId(appid);
            WxPublicPO data = wxPublicPOByAppId.getData();
            String dataAppid = data.getAppid();
            ResponseData<String> accessTokenByAppId = wxPublicServiceFeign.getAccessTokenByAppId(dataAppid);
            String token = accessTokenByAppId.getData();
            List<String> openId = obtainGraphicBo.getOpenId();
            JSONArray array = new JSONArray();
            array.addAll(openId);
            String mediaId = obtainGraphicBo.getMediaId();
            JSONObject objectBig = new JSONObject();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("media_id", mediaId);
            String msgType = obtainGraphicBo.getMsgType();
            String sendIgnoreReprint = obtainGraphicBo.getSendIgnoreReprint();
            objectBig.put("touser", array);
            objectBig.put("mpnews", jsonObject);
            objectBig.put("msgtype", msgType);
            objectBig.put("send_ignore_reprint", "1");
            log.info("token={}", token);
            log.info("stringMap={}", JSON.toJSONString(objectBig));
            String post = HttpUtil.post(GROUP_SENDING + token, objectBig.toString());
            log.info("群发回执={}", JSON.toJSONString(post));
            JSONObject parseObject = JSONObject.parseObject(post);
            String errcode = parseObject.getString("errcode");
            String errmsg = parseObject.getString("errmsg");
            String msg_id = parseObject.getString("msg_id");
            String msg_data_id = parseObject.getString("msg_data_id");
            Integer integer = Integer.valueOf(errcode);
            responseData.setCode(integer);
            responseData.setMessage(errmsg);
            responseData.setData(msg_id);
            return responseData;
        }
        responseData.setCode(100);
        responseData.setMessage(SysResponseEnum.FAILED.getMessage());
        return responseData;
    }
}
