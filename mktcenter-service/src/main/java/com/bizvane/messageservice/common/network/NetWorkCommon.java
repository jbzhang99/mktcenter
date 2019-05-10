package com.bizvane.messageservice.common.network;

import com.alibaba.fastjson.JSON;
import com.bizvane.messageservice.common.sms.request.SmsSendRequest;
import com.bizvane.messageservice.common.sms.response.SmsSendResponse;
import com.bizvane.messageservice.common.sms.util.ChuangLanSmsUtil;
import com.bizvane.messagefacade.models.vo.SysSmsConfigVO;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;


/**
 * @Author: lijunwei
 * @Time: 2018/7/16 22:11
 */
@Component
public class NetWorkCommon {
    public static final Logger logger=LoggerFactory.getLogger(NetWorkCommon.class);
    public static final MediaType JSONS = MediaType.parse("application/json; charset=utf-8");

    @Autowired
    private  HttpClient httpClient;

    public  Boolean sendMsgMoments(SysSmsConfigVO vo) throws IOException, DocumentException {
        String channelAccount = vo.getChannelAccount();//账号
        String channelPassword = vo.getChannelPassword();//密码
        String channelService = vo.getChannelService();//路径
        String phone = vo.getPhone();//手机号
        String content = vo.getMsgContent();//内容

        StringBuilder urlParams = new StringBuilder();
        urlParams.append(channelService);
        urlParams.append("?userId=%s&password=%s&pszMobis=%s&pszMsg=%s&iMobiCount=1&pszSubPort=*&MsgId=12312123");
        String  msgPath=  String.format(urlParams.toString(), channelAccount,channelPassword,phone,content);

        Request request = new Request.Builder().url(msgPath).addHeader("Host", "192.169.1.130").addHeader("Content-Type", "application/x-www-form-urlencoded").addHeader("Connection", "Close").build();
        Response response = httpClient.post(request);
        String returns = response.body().string();
        Document document = DocumentHelper.parseText(returns);
        Element rootElt = document.getRootElement(); // 获取根节点
        System.out.println("----------sendMsgMoments--------------："+ msgPath+"==="+ returns +"==="+ rootElt.getStringValue());
        String param = rootElt.getStringValue();
        if (param.length() > 8) {
            return  Boolean.TRUE;
        }
        
        System.out.println("------梦网短信发送异常-----"+ param);
        return Boolean.FALSE;
    }
    
    
    public  String sendChuangLan253(SysSmsConfigVO vo) throws IOException, DocumentException {
        String account = vo.getChannelAccount();//账号
        String password = vo.getChannelPassword();//密码
        String channelService = vo.getChannelService();//路径
        String phone = vo.getPhone();//手机号
        String msg = vo.getMsgContent();//内容
//        营销短信加+" 退订回复TD"
        if(vo.getChannelType().equals(10)) {
        	  msg = vo.getMsgContent()+" 退订回复TD";//内容
        }
        
        String report= "true"; //true是否需要状态报告
        String uid = vo.getMsgId();//        uid：该条短信在您业务系统内的ID
        SmsSendRequest smsSingleRequest = new SmsSendRequest(account, password, msg, phone,report,uid);
        String requestJson = JSON.toJSONString(smsSingleRequest);
        String response = ChuangLanSmsUtil.sendSmsByPost(channelService, requestJson);
        SmsSendResponse smsSingleResponse = JSON.parseObject(response, SmsSendResponse.class);

        if (smsSingleResponse.getCode().equals("0")) {
            return  "true";
        }
        System.out.println("发送短信有误 :" + response);
        return smsSingleResponse.getErrorMsg();
    }
	public static void main(String[] args) throws Exception {
        String msg = "您的随机密码为：9067401。";
        SmsSendRequest smsSingleRequest2 = new SmsSendRequest("N4646531", "ka2fUAZox", msg, "13348394145","true");
        String requestJson2 = JSON.toJSONString(smsSingleRequest2);
        String response2 = ChuangLanSmsUtil.sendSmsByPost("http://smssh1.253.com/msg/send/json", requestJson2);
        SmsSendResponse smsSingleResponse2 = JSON.parseObject(response2, SmsSendResponse.class);
        System.out.println("response  toString is :" + smsSingleResponse2);
	}
    
}
