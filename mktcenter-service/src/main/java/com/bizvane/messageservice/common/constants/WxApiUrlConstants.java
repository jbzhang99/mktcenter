package com.bizvane.messageservice.common.constants;

/**
 * 微信接口url,可添加配置文件读取
 */
public class WxApiUrlConstants {
  // 获取预授权码pre_auth_code
  public static final String WX_GET_PRE_AUTH_CODE_URL =
      "https://api.weixin.qq.com/cgi-bin/component/api_create_preauthcode?component_access_token=";
  // 获取第三方平台component_access_token
  public static final String WX_GETPLATFORM_COMPONENT_ACCESS_TOKEN_URL =
      "https://api.weixin.qq.com/cgi-bin/component/api_component_token";
  // 使用授权码换取公众号的接口调用凭据和授权信息
  public static final String API_QUERY_AUTH =
      "https://api.weixin.qq.com/cgi-bin/component/api_query_auth?component_access_token=";

  // 获取授权方的公众号帐号基本信息
  public static final String WX_GET_AUTHORIZER_INFO =
      "https://api.weixin.qq.com/cgi-bin/component/api_get_authorizer_info?component_access_token=";

  // 获取（刷新）授权公众号的接口调用凭据（令牌）
  public static final String WX_GET_AUTHORIZER_TOKEN =
      "https://api.weixin.qq.com/cgi-bin/component/api_authorizer_token?component_access_token=";

  // 获取（刷新）jssdk_access_token
  public static final String WX_GET_JSSDK_ACCESS_TOKEN_URL =
      "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=%s&type=jsapi";

  // 客服接口-发消息
  public static final String WX_CUSTOM_SEND_MESSAGE =
      "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=";

  // 获取用户基本信息（包括UnionID机制）
  public static final String WX_GET_USER_INFO = "https://api.weixin.qq.com/cgi-bin/user/info?";

  // 通过code换取网页授权access_token
  public static final String WX_GET_WEB_ACCESS_TOKEN_BY_CODE =
      "https://api.weixin.qq.com/sns/oauth2/component/access_token?";

  // 网页授权获取用户基本信息
  public static final String WX_GET_USER_INFO_WEB =
      "https://api.weixin.qq.com/sns/userinfo?access_token=$at$&openid=$openid$&lang=zh_CN";

  // 自定义菜单创建
  public static final String WX_CREATE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=";
  public static final String wx_select_WxMenu_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=";
  public static final String wx_get_WxMenu_URL =
      "https://api.weixin.qq.com/cgi-bin/get_current_selfmenu_info?access_token=";

  // 发送模板消息
  public static final String WX_SEND_TEMPLATE_MESSAGE =
      "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=";
  // 获取模板ID
  public static final String wx_add_template_url =
      "https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=";
  // 获取模板列表
  public static final String wx_get_all_template_url =
      "https://api.weixin.qq.com/cgi-bin/template/get_all_private_template?access_token=";

  // 删除模板
  public static final String wx_delete_template_url =
      "https://api.weixin.qq.com/cgi-bin/template/del_private_template?access_token=%s";

  // 微信素材的URL xudaile
  public static final String we_getMaterialCount_URL =
      "https://api.weixin.qq.com/cgi-bin/material/get_materialcount?access_token=";
  public static final String we_getAllMaterial_URL =
      "https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=";
  public static final String we_uploadnews_URL = "https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=";
  public static final String we_uploadfile_URL =
      "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=";
  public static final String we_editmaterial_URL =
      "https://api.weixin.qq.com/cgi-bin/material/update_news?access_token=";
  public static final String we_deletematerial_URL =
      "https://api.weixin.qq.com/cgi-bin/material/del_material?access_token=";
  public static final String we_getMaterial_URL =
      "https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=";
  // 生成二维码
  public static final String wx_QRcode_URL = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=";
  public static final String wx_QRcode_warn_URL = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=";
  // 群发
  String we_massLable_URL = "https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=";
  String we_massuploadimg_URL = "https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=";
  String we_massuploadnews_URL = "https://api.weixin.qq.com/cgi-bin/media/uploadnews?access_token=";
  String we_massOpenID_URL = "https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token=";
  String we_massDel_URL = "https://api.weixin.qq.com/cgi-bin/message/mass/delete?access_token=";
  String we_massGetOpenID = "https://api.weixin.qq.com/cgi-bin/message/mass/preview?access_token=";
  String we_massGetStatus = "https://api.weixin.qq.com/cgi-bin/message/mass/get?access_token=";
  // 多客服
  String wx_custom_send = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=";
  String wx_custom_onlinekflist = "https://api.weixin.qq.com/cgi-bin/customservice/getonlinekflist?access_token=";
  String wx_kfsession = "https://api.weixin.qq.com/customservice/kfsession/getsession?access_token=";
  String wx_custom_alllist = "https://api.weixin.qq.com/cgi-bin/customservice/getkflist?access_token=";
  // 支付
  String we_pay_createorder_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder?";
  String we_pay_queryorder_URL = "https://api.mch.weixin.qq.com/pay/orderquery?";
  String we_pay_closeorder_URL = "https://api.mch.weixin.qq.com/pay/closeorder?";
  String we_pay_refundorder_URL = "https://api.mch.weixin.qq.com/secapi/pay/refund?";
  String we_pay_queryrefundorder_URL = "https://api.mch.weixin.qq.com/pay/refundquery?";
  String we_pay_reconorder_URL = "https://api.mch.weixin.qq.com/pay/downloadbill?";
  String we_pay_redenvelope_URL = "https://api.mch.weixin.qq.com/mmpaymkttransfers/sendredpack";
  String we_pay_enterprisepayurl_URL = "https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers";

  String we_pay_longtoshort_URL = "https://api.mch.weixin.qq.com/tools/shorturl?";

  // 标签管理
  String wx_createlable_URL = "https://api.weixin.qq.com/cgi-bin/tags/create?access_token=";
  String wx_getlable_URL = "https://api.weixin.qq.com/cgi-bin/tags/get?access_token=";
  String wx_editlable_URL = "https://api.weixin.qq.com/cgi-bin/tags/update?access_token=";
  String wx_deletelable_URL = "https://api.weixin.qq.com/cgi-bin/tags/delete?access_token=";
  String wx_getlable_fans_URL = "https://api.weixin.qq.com/cgi-bin/user/tag/get?access_token=";
  String wx_batch_vip = "https://api.weixin.qq.com/cgi-bin/tags/members/batchtagging?access_token=";
  String wx_batch_del = "https://api.weixin.qq.com/cgi-bin/tags/members/batchuntagging?access_token=";

  // 黑名单管理
  String wx_getbatch_URL = "https://api.weixin.qq.com/cgi-bin/tags/members/getblacklist?access_token=";
  String wx_createbatch_URL = "https://api.weixin.qq.com/cgi-bin/tags/members/batchblacklist?access_token=";
  String wx_cancelbatch_URL = "https://api.weixin.qq.com/cgi-bin/tags/members/batchunblacklist?access_token=";

  // 数据分析接口
  String we_datacube_usersummary_URL = "https://api.weixin.qq.com/datacube/getusersummary?access_token=";
  String we_datacube_usercumulate_URL = "https://api.weixin.qq.com/datacube/getusercumulate?access_token=";
  String we_datacube_articlesummary_URL = "https://api.weixin.qq.com/datacube/getarticlesummary?access_token=";
  String we_datacube_articletotal_URL = "https://api.weixin.qq.com/datacube/getarticletotal?access_token=";
  String we_datacube_userread_URL = "https://api.weixin.qq.com/datacube/getuserread?access_token=";
  String we_datacube_userreadhour_URL = "https://api.weixin.qq.com/datacube/getuserreadhour?access_token=";
  String we_datacube_usershare_URL = "https://api.weixin.qq.com/datacube/getusershare?access_token=";
  String we_datacube_usersharehour_URL = "https://api.weixin.qq.com/datacube/getusersharehour?access_token=";

  String we_datacube_upstreammsg_URL = "https://api.weixin.qq.com/datacube/getupstreammsg?access_token=";
  String we_datacube_upstreammsghour_URL = "https://api.weixin.qq.com/datacube/getupstreammsghour?access_token=";
  String we_datacube_upstreammsgweek_URL = "https://api.weixin.qq.com/datacube/getupstreammsgweek?access_token=";
  String we_datacube_upstreammsgmonth_URL = "https://api.weixin.qq.com/datacube/getupstreammsgmonth?access_token=";
  String we_datacube_upstreammsgdist_URL = "https://api.weixin.qq.com/datacube/getupstreammsgdist?access_token=";
  String we_datacube_upstreammsgdistweek_URL =
      "https://api.weixin.qq.com/datacube/getupstreammsgdistweek?access_token=";
  String we_datacube_upstreammsgdistmonth_URL =
      "https://api.weixin.qq.com/datacube/getupstreammsgdistmonth?access_token=";

  // 会员卡卷接口
  String we_card_create_URL = "https://api.weixin.qq.com/card/create?access_token=";
  String we_card_setactivateuserform_URL =
      "https://api.weixin.qq.com/card/membercard/activateuserform/set?access_token=";
  String we_card_getactivateurl_URL = "https://api.weixin.qq.com/card/membercard/activate/geturl?access_token=";
  String we_card_activate_URL = "https://api.weixin.qq.com/card/membercard/activate?access_token=";
  String we_card_codedecrypt_URL = "https://api.weixin.qq.com/card/code/decrypt?access_token=";
  String we_card_updateuser_URL = "https://api.weixin.qq.com/card/membercard/updateuser?access_token=";
  String we_card_getactivatetempinfo_URL =
      "https://api.weixin.qq.com/card/membercard/activatetempinfo/get?access_token=";
  String we_card_paycardrule_URL = "https://api.weixin.qq.com/card/paygiftcard/add?access_token=";
  String we_card_cardupdate_URL = "https://api.weixin.qq.com/card/update?access_token=";

  // 长链接传短链接
  String we_shorturl = "https://api.weixin.qq.com/cgi-bin/shorturl?access_token=";

}
