package com.bizvane.messageservice.common.constants;

/**
 * 系统常量类
 * 
 * @author 董争光 2018年5月21日下午1:52:55
 */
public class SystemConstants {

  /**
   * 券优惠类型
   */
  public static final String PREFERENTIAL_TYPE_EXCHANGE = "3";//兑换券
  public static final String PREFERENTIAL_TYPE_DISCOUNT = "2";//折扣券
  public static final String PREFERENTIAL_TYPE_MONEY = "1";//现金券

  /**
   * 数据有效状态
   */
  public static final Boolean TABLE_VALID_EFFECTIVE = Boolean.TRUE;    //有效
  public static final Boolean TABLE_VALID_INVALID = Boolean.FALSE;    //无效

  public static final long WECHAT_MESSAGE_RESULT_ERRORCODE = 0;


  public static final String CHARSET = "UTF-8";


  public static final String BUSSINESS_MODULE_CODE_WECHAT_OFFLINE_TRADE = "wechat_offline_trade";
  public static final String BATCH_TEMPLATE_MESSAGE_NOT_SMS_TEMP = "BATCH_TEMPLATE_MESSAGE_NOT_SMS_TEMP";
  

  public static final String ROCKET_LOG_SEND_STATE_CREATE = "00";
  public static final String ROCKET_LOG_SEND_STATE_PRODUCER_FAIL = "05";
  public static final String ROCKET_LOG_SEND_STATE_PRODUCER_SUCCESS = "10";
  public static final String ROCKET_LOG_SEND_STATE_CONSUMER_FAIL = "15";
  public static final String ROCKET_LOG_SEND_STATE_CONSUMER_SUCCESS = "20";


  public static final String WECHAT_MESSAGE_LOG_SEND_STATE_CREATE = "00";
  public static final String WECHAT_MESSAGE_LOG_SEND_STATE_FAIL = "05";
  public static final String WECHAT_MESSAGE_LOG_SEND_STATE_SUCCESS = "10";
  
  
  
  //  0发送中、1发送成功、2发送失败、3已删除
  public static final String TUWEN_MESSAGE_LOG_SEND_STATE_CREATE = "0";
  public static final String TUWEN_MESSAGE_LOG_SEND_STATE_SUCCESS = "1";
  public static final String TUWEN_MESSAGE_LOG_SEND_STATE_FAIL = "2";
  public static final String TUWEN_MESSAGE_LOG_SEND_STATE_DEL = "3";

  public static final Integer SMS_MESSAGE_LOG_SEND_STATE_CREATE =0;
  public static final Integer SMS_MESSAGE_LOG_SEND_STATE_FAIL = -1;
  public static final Integer SMS_MESSAGE_LOG_SEND_STATE_SUCCESS = 1;

  public static final Boolean WECHAT_MESSAGE_LOG_IS_RESEND_YES = true;
  public static final Boolean WECHAT_MESSAGE_LOG_IS_RESEND_NO = false;

  public static final String WECHAT_VIP_FOCUS_STATE_YES = "Y";
  public static final String WECHAT_VIP_FOCUS_STATE_NO = "N";

  public static final String SYSTEM_TABLE_ACTIVE_STATE_YES = "Y";
  public static final String SYSTEM_TABLE_ACTIVE_STATE_NO = "N";

  public static final Boolean WECHAT_TEMPLATE_SEND_STATE_YES = Boolean.TRUE;
  public static final Boolean WECHAT_TEMPLATE_SEND_STATE_NO = Boolean.FALSE;

  public static final String ROCKET_CONFIG_MODEL_NAME = "message";
  public static final String ROCKET_CONFIG_ROLE_TYPE_PRODUCER = "producer";
  public static final String ROCKET_CONFIG_ROLE_TYPE_CONSUMER = "consumer";

  public static final String ROCKET_CONFIG_BUSINESS_TYPE_WECHAT_SIMPLE_MESSAGE = "wechatSimpleMessage";

  public static final String ROCKET_TOPIC_SIMPLE_MESSAGE = "public_bizvane_message";
  public static final String PID_PUBLIC_BIZVANE_MESSAGE = "PID_PUBLIC_BIZVANE_MESSAGE";
  
  

  public static final String ROCKET_TAG_SIMPLE = "wechat_simple_tag";

  /**
   * 企业微信模板消息
   */
  public static final String ROCKET_CONFIG_BUSINESS_TYPE_WECHAT_OFFLINE_INFO_MESSAGE = "wechatOfflineInfoMessage";

  /**
   * 券模板消息
   */
  public static final String ROCKET_CONFIG_BUSINESS_TYPE_WECHAT_COUPON_RECEIVE_MESSAGE = "wechatCouponReceiveMessage";
  public static final String ROCKET_CONFIG_BUSINESS_TYPE_WECHAT_COUPON_EXPIRE_MESSAGE = "wechatCouponExpireMessage";
  public static final String ROCKET_CONFIG_BUSINESS_TYPE_WECHAT_COUPON_ONLINE_MESSAGE = "wechatCouponOnlineMessage";
  public static final String ROCKET_CONFIG_BUSINESS_TYPE_WECHAT_COUPON_OFFLINE_MESSAGE = "wechatCouponOfflineMessage";
  
  /**
   * 券模板消息_短信
   */
  public static final String ROCKET_CONFIG_BUSINESS_TYPE_SEDNSMS_COUPON_RECEIVE_MESSAGE = "sendSmsCouponReceiveMessage";
  public static final String ROCKET_CONFIG_BUSINESS_TYPE_SEDNSMS_COUPON_EXPIRE_MESSAGE = "sendSmsCouponExpireMessage";
  public static final String ROCKET_CONFIG_BUSINESS_TYPE_SEDNSMS_COUPON_ONLINE_MESSAGE = "sendSmsCouponOnlineMessage";
  
  public static final String ROCKET_CONFIG_BUSINESS_TYPE_SEDNSMS_COUPON_OFFLINE_MESSAGE = "sendSmsCouponOfflineMessage";
  public static final String ROCKET_CONFIG_BUSINESS_TYPE_SEDNSMS_COUPON_UNRECEIVE_MESSAGE = "sendSmsCouponUNReceiveMessage";

  /**
   * 积分模板消息
   */
  public static final String ROCKET_CONFIG_BUSINESS_TYPE_WECHAT_INTEGRAL_ADD_MESSAGE = "wechatIntegralAddMessage";
  public static final String ROCKET_CONFIG_BUSINESS_TYPE_WECHAT_INTEGRAL_EXPIRE_MESSAGE = "wechatIntegralExpireMessage";
  public static final String ROCKET_CONFIG_BUSINESS_TYPE_WECHAT_INTEGRAL_USE_MESSAGE = "wechatIntegralUseMessage";
  public static final String ROCKET_CONFIG_BUSINESS_TYPE_WECHAT_INTEGRAL_SUBTRACT_MESSAGE = "wechatIntegralSubtractMessage";
  
  /**
   * 积分模板消息_短信
   */
  public static final String ROCKET_CONFIG_BUSINESS_TYPE_SEDNSMS_INTEGRAL_ADD_MESSAGE = "sendSmsIntegralAddMessage";
  public static final String ROCKET_CONFIG_BUSINESS_TYPE_SEDNSMS_INTEGRAL_USE_MESSAGE = "sendSmsIntegralUseMessage";
  
  public static final String ROCKET_CONFIG_BUSINESS_TYPE_SEDNSMS_INTEGRAL_EXPIRE_MESSAGE = "sendSmsIntegralExpireMessage";
  public static final String ROCKET_CONFIG_BUSINESS_TYPE_SEDNSMS_INTEGRAL_SUBTRACT_MESSAGE = "sendSmsIntegralSubtractMessage";
  public static final String ROCKET_CONFIG_BUSINESS_TYPE_SEDNSMS_INTEGRAL_ADDBATCH_MESSAGE = "sendSmsIntegralAddBatchMessage";

  /**
   * 会员模板消息
   */
  public static final String ROCKET_CONFIG_BUSINESS_TYPE_WECHAT_MEMBER_REGISTER_MESSAGE = "wechatMemberRegisterMessage";
  public static final String ROCKET_CONFIG_BUSINESS_TYPE_WECHAT_MEMBER_INVITE_REGISTER_MESSAGE = "wechatMemberInviteRegisterMessage";
  public static final String ROCKET_CONFIG_BUSINESS_TYPE_WECHAT_MEMBER_UPGRADE_MESSAGE = "wechatMemberUpgradeMessage";
  public static final String ROCKET_CONFIG_BUSINESS_TYPE_WECHAT_MEMBER_DOWNGRADE_MESSAGE = "wechatMemberDowngradeMessage";
  
  /**
   * 会员短信模板消息
   */
  public static final String ROCKET_CONFIG_BUSINESS_TYPE_SMS_MEMBER_REGISTER_MESSAGE = "smsMemberRegisterMessage";
  public static final String ROCKET_CONFIG_BUSINESS_TYPE_SMS_MEMBER_INVITE_REGISTER_MESSAGE = "smsMemberInviteRegisterMessage";
  public static final String ROCKET_CONFIG_BUSINESS_TYPE_SMS_MEMBER_UPGRADE_MESSAGE = "smsMemberUpgradeMessage";
  public static final String ROCKET_CONFIG_BUSINESS_TYPE_SMS_MEMBER_DOWNGRADE_MESSAGE = "smsMemberDowngradeMessage";
  /**
   * 模板消息营销
   */
  public static final String ROCKET_CONFIG_BUSINESS_TYPE_WECHAT_TEMPLATE_MESSAGE = "wechatTemplateMessage";
  public static final String ROCKET_CONFIG_BUSINESS_TYPE_SMS_TEMPLATE_MESSAGE = "smsTemplateMessage";
  
  public static final String ROCKET_CONFIG_BUSINESS_TYPE_GEN_SMS_TEMPLATE_MESSAGE = "genSmsTemplateMessage";
  public static final String ROCKET_CONFIG_BUSINESS_TYPE_GEN_QY_TEMPLATE_MESSAGE = "genYeTemplateMessage";
  /**
   * 图文
   */
  public static final String ROCKET_CONFIG_BUSINESS_TYPE_TUWEN_TEMPLATE_MESSAGE = "tuWenTemplateMessage";
  
  

  /**
   * 订单模板消息
   */
  public static final String ROCKET_CONFIG_BUSINESS_TYPE_WECHAT_ORDER_OFFLINE_MESSAGE = "wechatOrderOfflineMessage";
  public static final String ROCKET_CONFIG_BUSINESS_TYPE_WECHAT_ORDER_PAYMENT_MESSAGE = "wechatOrderPaymentMessage";
  public static final String ROCKET_CONFIG_BUSINESS_TYPE_WECHAT_ORDER_SHIP_MESSAGE = "wechatOrderShipMessage";
  public static final String ROCKET_CONFIG_BUSINESS_TYPE_WECHAT_ORDER_CANCEL_MESSAGE = "wechatOrderCancelMessage";
  
  public static final String ROCKET_CONFIG_BUSINESS_TYPE_SMS_ORDER_SHIP_MESSAGE = "smsOrderShipMessage";

  /**
   * 线下订单短信消息
   */
  public static final String ROCKET_CONFIG_BUSINESS_TYPE_SMS_ORDER_OFFLINE_MESSAGE = "smsOrderOfflineMessage";
}