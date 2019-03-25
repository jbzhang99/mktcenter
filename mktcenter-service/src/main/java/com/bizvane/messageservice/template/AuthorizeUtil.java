package com.bizvane.messageservice.template;

import com.bizvane.messageservice.common.utils.WeUtils;
import com.bizvane.wechatfacade.models.po.WxPublicPO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Service
public class AuthorizeUtil {
  private static final String MEMBERCENTER_URL = "/bizvaneApp/views/member_center.html";
  public static final String ERR_STATE = "40029";
  private static final String SNSAPI_BASE = "snsapi_base"; // 静默授权
  public static final String SNSAPI_USERINFO = "snsapi_userinfo"; // 用户授权

  public static String getAuthorizeUrl(WxPublicPO wu, String url) {
    return AuthorizeUtil.getAuthorizeUrl(wu, url, AuthorizeUtil.SNSAPI_BASE);
  }

  public static String getAuthorizeUrl(WxPublicPO wxPublicPO, String url, String scope) {
    if (!wxPublicPO.canAuthorizeGetUserInfo()) {
      return url;
    }
    if (StringUtils.isBlank(url)) {
      return url;
    }
    try {
      String tempurl = url.substring(0, 4);
      if (!"http".equalsIgnoreCase(tempurl)) {
        url = "http://" + wxPublicPO.getDomain() + url;
      }
      url = URLEncoder.encode(url, "UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    String appId = wxPublicPO.getAppid();
    String publicpartyappid = wxPublicPO.getPlatformAppid();

    return "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + appId + "&redirect_uri=" + url
        + "&response_type=code&scope=" + scope + "&state=123&component_appid=" + publicpartyappid + "#wechat_redirect";
  }

  /**
   * WebAuthorizationMethod 通过code换取网页授权access_token error 2次处理 到会员中心 且state 为 ERR_STATE
   */
  public static String webAuthorization_errUrl(WeUtils wu) {
    try {
      String url =
          URLEncoder.encode("http://" + wu.getWxPublicPO().getDomain() + AuthorizeUtil.MEMBERCENTER_URL, "UTF-8");
      String publicpartyappid = wu.getWxPublicPO().getPublicpartyappid();
      String appId = wu.getWxPublicPO().getAppid();
      return "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + appId + "&redirect_uri=" + url
          + "&response_type=code&scope=snsapi_base&state=" + AuthorizeUtil.ERR_STATE + "&component_appid="
          + publicpartyappid + "#wechat_redirect";
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
      return "";
    }

  }


}
