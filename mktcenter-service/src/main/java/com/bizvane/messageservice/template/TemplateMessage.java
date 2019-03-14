package com.bizvane.messageservice.template;

import com.alibaba.fastjson.JSONObject;
import com.bizvane.messageservice.common.constants.SysRespConstants;
import com.bizvane.messageservice.common.constants.SystemConstants;
import com.bizvane.messageservice.common.constants.WxApiUrlConstants;
import com.bizvane.messageservice.common.utils.AsyncHttpUtil;
import com.bizvane.messagefacade.models.vo.Result;
import com.bizvane.wechatfacade.models.po.WxPublicPO;
import org.apache.commons.lang3.StringUtils;

import java.util.Iterator;

/**
 * 发送模板消息
 */
public class TemplateMessage {

  public static Result<String> sendTemplateMessage(String notAppUrl,WxPublicPO wu, String touser, String template_id, String url,
                                                   JSONObject datajo,String appid)throws Exception {
    return TemplateMessage.sendTemplateMessage(notAppUrl,wu, touser, template_id, url, datajo, true,appid);
  }


  public static Result<String> sendTemplateMessage(String notAppUrl,WxPublicPO wu, String touser, String template_id, String url,
                                               JSONObject datajo, boolean needAuthorize,String appid){
    Result<String> result = new Result<>();
    //JSONObject result = new JSONObject();
    
    Iterator iterator = datajo.keySet().iterator();
    while (iterator.hasNext()){
        String key = (String) iterator.next();
        JSONObject messagevar = new JSONObject();
        messagevar.put("value", datajo.getString(key));
        messagevar.put("color", "#173177");
        datajo.put(key,messagevar);
    }
    
    
    JSONObject message = new JSONObject();
    message.put("touser", touser);
    message.put("template_id", template_id);
//    message.put("url", needAuthorize ? AuthorizeUtil.getAuthorizeUrl(wu, url) : url);
    message.put("url", url);
    message.put("topcolor", "#FF0000");
//    url和miniprogram都是非必填字段，若都不传则模板无跳转；若都传，会优先跳转至小程序。开发者可根据实际需要选择其中一种跳转方式即可。当用户的微信客户端版本不支持跳小程序时，将会跳转至url
    if(notAppUrl!=null&&!(notAppUrl.equals("notAppUrl"))) {
    JSONObject messageminiprogram = new JSONObject();
    messageminiprogram.put("appid", appid);//所需跳转到的小程序appid（该小程序appid必须与发模板消息的公众号是绑定关联关系，暂不支持小游戏）
    messageminiprogram.put("pagepath", url);//所需跳转到小程序的具体页面路径，支持带参数,（示例index?foo=bar），暂不支持小游戏
    message.put("miniprogram", messageminiprogram);
    }
    
    message.put("data", datajo);
    String authorizerAccessToken = wu.getAppid();
    
//    String authorizerAccessToken = "14_ddB9KPDMFdEPUCElmX-xdlBovuDDz4YZlmfJCDiRDuVo1sbtr0Nom1t4uVAj2NTM0P9b6KJoyecf3kRm3Gjn_2cvEAPSWJ2vu5GLhA5wDwTpILfOgqU3HGLWGDByl6xp2_gszKwn5xM6XSxJSTWdAFDZAD";
    if (StringUtils.isBlank(authorizerAccessToken)) {
      result.setStatus(SysRespConstants.WX_ACCESS_TOKEN_NOT_EMPTY.getStatus());
      result.setMsg(SysRespConstants.WX_ACCESS_TOKEN_NOT_EMPTY.getMsg());
      System.out.print("微信 authorizerAccessToken空值！！！！！！！！！！ :" );
      return result;
    }

    String sendResult =
        AsyncHttpUtil.doPost(WxApiUrlConstants.WX_SEND_TEMPLATE_MESSAGE + authorizerAccessToken, message.toString());
    if (StringUtils.isBlank(sendResult)) {
      result.setStatus(SysRespConstants.WX_MESSAGE_TEMPLATE_NETWORK_ERROR.getStatus());
      result.setMsg(SysRespConstants.WX_MESSAGE_TEMPLATE_NETWORK_ERROR.getMsg());
      return result;
    }

    JSONObject sendResultJson = JSONObject.parseObject(sendResult);
    System.out.print("微信发送结果 sendmessage :" + sendResult);
    result.setData(sendResult);
    long errcode = sendResultJson.getLong("errcode");
    if (SystemConstants.WECHAT_MESSAGE_RESULT_ERRORCODE != errcode) {
      result.setStatus(errcode);
      result.setMsg(sendResultJson.getString("errmsg"));
      return result;
    }

    result.setData(sendResult);
    return result;
  }

}
