package com.bizvane.messageservice.common.network;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.bizvane.messageservice.common.sms.request.SmsSendRequest;
import com.bizvane.messageservice.common.sms.response.SmsSendResponse;
import com.bizvane.messageservice.common.sms.util.ChuangLanSmsUtil;
import com.bizvane.messagefacade.models.vo.SysSmsConfigVO;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.apache.commons.codec.EncoderException;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URLEncoder;

/**
 * @Author: lijunwei
 * @Time: 2018/8/20 10:24
 */
@Component
public class NetWorkBatch {
    public static final Logger logger= LoggerFactory.getLogger(NetWorkCommon.class);
    public static final MediaType JSONS = MediaType.parse("application/json; charset=utf-8");

    @Autowired
    private HttpClient httpClient;

    public  Boolean sendMsgMomentsBatch(SysSmsConfigVO vo) throws IOException, DocumentException {
        String channelAccount = vo.getChannelAccount();//账号
        String channelPassword = vo.getChannelPassword();//密码
        String channelService = vo.getChannelService();//路径
        String phones = vo.getPhones();//手机号
        String content = vo.getMsgContent();//内容

        int phonenum = phones.split(",").length;//手机号的数量

        StringBuilder urlParams = new StringBuilder();
        urlParams.append(channelService);
        urlParams.append("?userId=%s&password=%s&pszMobis=%s&pszMsg=%s&iMobiCount=+"+phonenum+"&pszSubPort=*&MsgId="+vo.getMsgId());
        String  msgPath=  String.format(urlParams.toString(), channelAccount,channelPassword,phones,content);

        Request request = new Request.Builder().url(msgPath).addHeader("Host", "192.169.1.130").addHeader("Content-Type", "application/x-www-form-urlencoded").addHeader("Connection", "Close").build();
        Response response = httpClient.post(request);
        String returns = response.body().string();
        Document document = DocumentHelper.parseText(returns);
        Element rootElt = document.getRootElement(); // 获取根节点
        String param = rootElt.getStringValue();
        
        
        if (param.length() > 8) {
        	System.out.println("----------sendMsgMomentsBatch发送成功：--------------："+ msgPath+"==="+ returns +"==="+ rootElt.getStringValue());
            return  Boolean.TRUE;
        }
        System.out.println("----------sendMsgMomentsBatch发送失败：--------------："+ msgPath+"==="+ returns +"==="+ rootElt.getStringValue());
        return Boolean.FALSE;
    }
    
    public  String sendChuangLan253Batch(SysSmsConfigVO vo) throws IOException, DocumentException {
        String account = vo.getChannelAccount();//账号
        String password = vo.getChannelPassword();//密码
        String channelService = vo.getChannelService();//路径
        String phone = vo.getPhones();//手机号
        String msg = vo.getMsgContent();//内容
        String report= "true"; //是否需要状态报告
        String uid = vo.getMsgId();//        uid：该条短信在您业务系统内的ID
        SmsSendRequest smsSingleRequest = new SmsSendRequest(account, password, msg, phone,report,uid);
        String requestJson = JSON.toJSONString(smsSingleRequest);
        String response = ChuangLanSmsUtil.sendSmsByPost(channelService, requestJson);
        SmsSendResponse smsSingleResponse = JSON.parseObject(response, SmsSendResponse.class);

        if (smsSingleResponse.getCode().equals("0")) {
            return  "ture";
        }
        System.out.println("发送短信有误 :" + response);
        return smsSingleResponse.getErrorMsg();
    }
    
    

    public  Boolean sendMsgMomentsNewBatch(SysSmsConfigVO vo) throws EncoderException, JSONException, IOException {
        String dateTime = TimeUtils.getCurrentTimeInString();
        String accountCode = vo.getChannelAccount();
        accountCode = accountCode.toUpperCase();
        String channelPassword = vo.getChannelPassword();
        String channelService = vo.getChannelService();
        String phones = vo.getPhones();
        String msgContent = vo.getMsgContent();

        JSONObject jsonObject = new JSONObject(Boolean.TRUE);
        jsonObject.put("userid",accountCode);
        jsonObject.put("pwd", MD5Util.getMD5Str32(accountCode+"00000000"+channelPassword+dateTime).toLowerCase());
        jsonObject.put("mobile",phones);
        jsonObject.put("content", URLEncoder.encode(msgContent, "GBK"));
        jsonObject.put("timestamp",dateTime);

        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jsonObject.toJSONString());
        Request request = (new Request.Builder()).url(channelService).addHeader("Host","192.168.1.1").addHeader("Connection", "close").addHeader("Content-Length", "252").post(body).build();
        Response response = httpClient.post(request);
        String result = response.body().string();
        logger.info("------------sendMsgMomentsNewBatch-----------"+phones+"----"+jsonObject.toJSONString()+"------------"+result);
        if (JSON.parseObject(result).getString("result").equals("0")) {
            return  Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
	public static void main(String[] args) throws Exception {
		HttpClient httpClient = new  HttpClient();
		  StringBuilder urlParams = new StringBuilder();
	        urlParams.append("http://TSN19.800CT.COM:8901/MWGate/wmgw.asmx/MongateSendSubmit");
	        urlParams.append("?userId=%s&password=%s&pszMobis=%s&pszMsg=%s&iMobiCount=+"+"2"+"&pszSubPort=*&MsgId="+"0000001");
	        String  msgPath=  String.format(urlParams.toString(), "JJ0253","513678","17521178360,15677378674","yanzhenma:1234567");

	        Request request = new Request.Builder().url(msgPath).addHeader("Host", "192.169.1.130").addHeader("Content-Type", "application/x-www-form-urlencoded").addHeader("Connection", "Close").build();
	        Response response = httpClient.post(request);
	        String returns = response.body().string();
	        Document document = DocumentHelper.parseText(returns);
	        Element rootElt = document.getRootElement(); // 获取根节点
	        String param = rootElt.getStringValue();
	        System.out.println("--------------------"+param);
	        
	}
}
