package com.bizvane.messageservice.common.constants;//package com.bizvane.message.common.constants;
//
///**
// * 系统常量类
// * 
// * @author 董争光 2018年5月21日下午1:52:55
// */
//public class SystemSendSmsConstants {
//
//  /**
//   * 数据有效状态
//   */
//  public static final Boolean TABLE_VALID_EFFECTIVE = Boolean.TRUE;    //有效
//  public static final Boolean TABLE_VALID_INVALID = Boolean.FALSE;    //无效
//
//  public static final long WECHAT_MESSAGE_RESULT_ERRORCODE = 0;
//
//
//  public static final String CHARSET = "UTF-8";
//
//
//  public static final String BUSSINESS_MODULE_CODE_WECHAT_OFFLINE_TRADE = "wechat_offline_trade";
//
//  public static final String ROCKET_LOG_SEND_STATE_CREATE = "00";
//  public static final String ROCKET_LOG_SEND_STATE_PRODUCER_FAIL = "05";
//  public static final String ROCKET_LOG_SEND_STATE_PRODUCER_SUCCESS = "10";
//  public static final String ROCKET_LOG_SEND_STATE_CONSUMER_FAIL = "15";
//  public static final String ROCKET_LOG_SEND_STATE_CONSUMER_SUCCESS = "20";
//
//
//  public static final String SEDNSMS_MESSAGE_LOG_SEND_STATE_CREATE = "00";
//  public static final String SEDNSMS_MESSAGE_LOG_SEND_STATE_FAIL = "05";
//  public static final String SEDNSMS_MESSAGE_LOG_SEND_STATE_SUCCESS = "10";
//
//  public static final Boolean SEDNSMS_MESSAGE_LOG_IS_RESEND_YES = true;
//  public static final Boolean SEDNSMS_MESSAGE_LOG_IS_RESEND_NO = false;
//
//  public static final String SEDNSMS_VIP_FOCUS_STATE_YES = "Y";
//  public static final String SEDNSMS_VIP_FOCUS_STATE_NO = "N";
//
//  public static final String SYSTEM_TABLE_ACTIVE_STATE_YES = "Y";
//  public static final String SYSTEM_TABLE_ACTIVE_STATE_NO = "N";
//
//  public static final Boolean SEDNSMS_TEMPLATE_SEND_STATE_YES = Boolean.TRUE;
//  public static final Boolean SEDNSMS_TEMPLATE_SEND_STATE_NO = Boolean.FALSE;
//
//  public static final String ROCKET_CONFIG_MODEL_NAME = "message";
//  public static final String ROCKET_CONFIG_ROLE_TYPE_PRODUCER = "producer";
//  public static final String ROCKET_CONFIG_ROLE_TYPE_CONSUMER = "consumer";
//
//  public static final String ROCKET_CONFIG_BUSINESS_TYPE_WECHAT_SIMPLE_MESSAGE = "wechatSimpleMessage";
//
//  public static final String ROCKET_TOPIC_SIMPLE_MESSAGE = "public_bizvane_message";
//
//  public static final String ROCKET_TAG_SIMPLE = "wechat_simple_tag";
//
//  /**
//   * 券模板消息
//   */
//  public static final String ROCKET_CONFIG_BUSINESS_TYPE_SEDNSMS_COUPON_RECEIVE_MESSAGE = "sendSmsCouponReceiveMessage";
//  public static final String ROCKET_CONFIG_BUSINESS_TYPE_SEDNSMS_COUPON_EXPIRE_MESSAGE = "sendSmsCouponExpireMessage";
//  public static final String ROCKET_CONFIG_BUSINESS_TYPE_SEDNSMS_COUPON_OFFLINE_MESSAGE = "sendSmsCouponOfflineMessage";
//  public static final String ROCKET_CONFIG_BUSINESS_TYPE_SEDNSMS_COUPON_ONLINE_MESSAGE = "sendSmsCouponOnlineMessage";
//  public static final String ROCKET_CONFIG_BUSINESS_TYPE_SEDNSMS_COUPON_UNRECEIVE_MESSAGE = "sendSmsCouponUNReceiveMessage";
//
//  /**
//   * 积分模板消息
//   */
//  public static final String ROCKET_CONFIG_BUSINESS_TYPE_SEDNSMS_INTEGRAL_ADD_MESSAGE = "sendSmsIntegralAddMessage";
//  public static final String ROCKET_CONFIG_BUSINESS_TYPE_SEDNSMS_INTEGRAL_EXPIRE_MESSAGE = "sendSmsIntegralExpireMessage";
//  public static final String ROCKET_CONFIG_BUSINESS_TYPE_SEDNSMS_INTEGRAL_USE_MESSAGE = "sendSmsIntegralUseMessage";
//  public static final String ROCKET_CONFIG_BUSINESS_TYPE_SEDNSMS_INTEGRAL_SUBTRACT_MESSAGE = "sendSmsIntegralSubtractMessage";
//  public static final String ROCKET_CONFIG_BUSINESS_TYPE_SEDNSMS_INTEGRAL_ADDBATCH_MESSAGE = "sendSmsIntegralAddBatchMessage";
//
//  /**
//   * 会员模板消息
//   */
//  public static final String ROCKET_CONFIG_BUSINESS_TYPE_SEDNSMS_MEMBER_REGISTER_MESSAGE = "sendSmsMemberRegisterMessage";
//  public static final String ROCKET_CONFIG_BUSINESS_TYPE_SEDNSMS_MEMBER_INVITE_REGISTER_MESSAGE = "sendSmsMemberInviteRegisterMessage";
//  public static final String ROCKET_CONFIG_BUSINESS_TYPE_SEDNSMS_MEMBER_UPGRADE_MESSAGE = "sendSmsMemberUpgradeMessage";
//  public static final String ROCKET_CONFIG_BUSINESS_TYPE_SEDNSMS_MEMBER_DOWNGRADE_MESSAGE = "sendSmsMemberDowngradeMessage";
//
//  /**
//   * 订单模板消息
//   */
//  public static final String ROCKET_CONFIG_BUSINESS_TYPE_SEDNSMS_ORDER_OFFLINE_MESSAGE = "sendSmsOrderOfflineMessage";
//  public static final String ROCKET_CONFIG_BUSINESS_TYPE_SEDNSMS_ORDER_PAYMENT_MESSAGE = "sendSmsOrderPaymentMessage";
//  public static final String ROCKET_CONFIG_BUSINESS_TYPE_SEDNSMS_ORDER_SHIP_MESSAGE = "sendSmsOrderShipMessage";
//  public static final String ROCKET_CONFIG_BUSINESS_TYPE_SEDNSMS_ORDER_CANCEL_MESSAGE = "sendSmsOrderCancelMessage";
//
//}