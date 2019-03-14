package com.bizvane.messageservice.wxpublicapi;

import com.bizvane.wechatfacade.models.po.WxPublicPO;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


public class AuthorizeUrlUtil {

	private static final String SNSAPI_BASE = "snsapi_base";			//静默授权
	public static final String SNSAPI_USERINFO = "snsapi_userinfo";		//用户授权

	public static String getAuthorizeUrl(WxPublicPO wu, String url) {
		return getAuthorizeUrl(wu,url,SNSAPI_BASE);
	}

	public static String getAuthorizeUrl(WxPublicPO wu, String url,String scope) {
		if(!wu.canAuthorizeGetUserInfo()){
			return url;
		}
		if(StringUtils.isBlank(url)){
			return url;
		}
		try {
			String tempurl=url.substring(0,4);
			if(!"http".equalsIgnoreCase(tempurl)){
				url="http://" + wu.getDomain()+url;
			}
			url = URLEncoder.encode(url, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + wu.getAppid() + "&redirect_uri=" + url + "&response_type=code&scope="+scope+"&state=123&component_appid=" + wu.getPlatformAppid() + "#wechat_redirect";
	}

	/**
	 * WebAuthorizationMethod 通过code换取网页授权access_token error 2次处理 到会员中心 且state 为 ERR_STATE
     */
	public static String webAuthorization_errUrl(WxPublicPO wu){
		try {
			String url = URLEncoder.encode("http://" + wu.getDomain()+MEMBERCENTER_URL, "UTF-8");
			return "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + wu.getAppid() + "&redirect_uri=" + url + "&response_type=code&scope=snsapi_base&state="+ERR_STATE+"&component_appid=" + wu.getPlatformAppid() + "#wechat_redirect";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "";
		}

	}

	private static final String MEMBERCENTER_URL = "/bizvaneApp/views/member_center.html";
	public static final String ERR_STATE = "40029";
}
