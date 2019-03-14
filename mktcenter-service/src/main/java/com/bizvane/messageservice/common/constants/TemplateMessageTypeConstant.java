package com.bizvane.messageservice.common.constants;

/**
 * 微信模板消息类型常量
 * @author 董争光
 * 2018年5月28日上午10:16:31
 */
public class TemplateMessageTypeConstant {

  /**
   * 模板业务类型
   */
  public static final String COUPON = "COUPON";//券
  public static final String INTEGRAL = "INTEGRAL";//积分
  public static final String MEMBER = "MEMBER";//会员
  public static final String ORDER = "ORDER";//订单

  /**
   * 企业微信相关模板消息
   */
  public static final String OFFLINE_INFO = "OFFLINE_INFO"; // 离线消息提醒


  /**
   * 券相关模板消息
   */
  public static final String COUPON_RECEIVE = "COUPON_RECEIVE"; // 券到账提醒
  public static final String COUPON_EXPIRE = "COUPON_EXPIRE"; // 券到期提醒
  public static final String COUPON_USE = "COUPON_USE"; //券使用提醒
  
  public static final String COUPON_UNRECEIVED = "COUPON_UNRECEIVED"; // 券未领取提醒
  public static final String COUPON_ONLINE_USE = "COUPON_ONLINE_USE"; // 券线上使用提醒
  public static final String COUPON_OFFLINE_USE = "COUPON_OFFLINE_USE"; // 券线下使用提醒
  
  
	/**
	* 券相短信关模板消息
	*/
  public static final String SMS_COUPON_RECEIVE = "SMS_COUPON_RECEIVE"; // 券到账提醒
  public static final String SMS_COUPON_EXPIRE = "SMS_COUPON_EXPIRE"; // 券到期提醒
  public static final String SMS_COUPON_USE = "SMS_COUPON_USE"; //券使用提醒

	  
  /**
   * 积分相关模板消息
   */
  public static final String INTEGRAL_ADD = "INTEGRAL_ADD"; // 积分增加提醒
  public static final String INTEGRAL_SUBTRACT = "INTEGRAL_SUBTRACT"; // 积分减少提醒
  public static final String INTEGRAL_EXPIRE = "INTEGRAL_EXPIRE"; // 积分到期提醒
  public static final String INTEGRAL_USE = "INTEGRAL_USE"; // 积分使用提醒
  /**
   * 短信积分相关模板消息
   */
  public static final String SMS_INTEGRAL_ADD = "SMS_INTEGRAL_ADD"; // 积分增加提醒
  public static final String SMS_INTEGRAL_USE = "SMS_INTEGRAL_USE"; // 积分使用提醒
  
  /**
   * 会员相关模板消息
   */
  public static final String MEMEBER_REGISTER = "MEMEBER_REGISTER"; // 会员注册提醒
  public static final String MEMEBER_INVITE_REGISTER = "MEMEBER_INVITE_REGISTER"; // 会员绑定成功提醒
  public static final String MEMEBER_UPGRADE = "MEMEBER_UPGRADE"; // 会员升级提醒
  public static final String MEMEBER_DOWNGRADE = "MEMEBER_DOWNGRADE"; // 会员降级提醒
  
  /**
   * 会员短信相关模板消息
   */
  public static final String MEMEBER_SMS_REGISTER = "MEMEBER_SMS_REGISTER"; // 会员注册提醒
  public static final String MEMEBER_SMS_INVITE_REGISTER = "MEMEBER_SMS_INVITE_REGISTER"; // 会员绑定成功提醒
  public static final String MEMEBER_SMS_UPGRADE = "MEMEBER_SMS_UPGRADE"; // 会员升级提醒
  public static final String MEMEBER_SMS_DOWNGRADE = "MEMEBER_SMS_DOWNGRADE"; // 会员降级提醒
  
  /**
   * 活动模板消息
   */
  public static final String RED_TEMPLATE_MESSAGE = "RED_TEMPLATE_MESSAGE"; //红包提醒
  public static final String ACTIVITY_TEMPLATE_MESSAGE = "ACTIVITY_TEMPLATE_MESSAGE"; // 活动微信模板提醒
  public static final String ACTIVITY_SMS_TEMPLATE_MESSAGE = "ACTIVITY_SMS_TEMPLATE_MESSAGE"; // 活动短信模板提醒
  
  public static final String GEN_SMS_TEMPLATE_MESSAGE = "BATCH_TEMPLATE_MESSAGE"; // 通用短信
  public static final String GEN_QY_TEMPLATE_MESSAGE = "GEN_QY_TEMPLATE_MESSAGE"; // 企业微信通用短信
  public static final String TUWEN_TEMPLATE_MESSAGE = "TUWEN_TEMPLATE_MESSAGE"; // 企业微信通用短信
  
  
  /**
   * 订单相关模板消息
   */
  public static final String ORDER_OFFLINE_CONSUME = "ORDER_OFFLINE_CONSUME"; // 线下订单提醒
  public static final String ORDER_ONLINE_CONSUME = "ORDER_ONLINE_CONSUME"; // 线上订单提醒
  public static final String ORDER_PAYMENT = "ORDER_PAYMENT"; // 订单支付提醒
  public static final String ORDER_SHIP = "ORDER_SHIP"; // 订单发货提醒
  public static final String ORDER_SIGN = "ORDER_SIGN"; // 订单签收提醒
  public static final String ORDER_CANCEL = "ORDER_CANCEL"; // 订单取消提醒
  public static final String ORDER_APPRAISAL = "ORDER_APPRAISAL"; // 订单评价提醒
  /**
    * 订单短信相关模板消息
   */
  public static final String ORDER_SMS_SHIP = "ORDER_SMS_SHIP"; // 订单发货短信提醒
  public static final String SMS_ORDER_OFFLINE_CONSUME = "SMS_ORDER_OFFLINE_CONSUME"; // 线下订单提醒

  public static final String ONLINE_VIP_REGIST_SUCCESS = "";
  public static final String OFFLINE_ORDER_PAY_SUCCESS = "";
}