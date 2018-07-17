package com.bizvane.mktcenterserviceimpl.common.constants;


public class RocketConstants {

  public static final long WECHAT_MESSAGE_RESULT_ERRORCODE = 0;


  public static final String CHARSET = "UTF-8";


  public static final String BUSSINESS_MODULE_CODE_WECHAT_OFFLINE_TRADE = "wechat_offline_trade";


  public static final String ROCKET_LOG_SEND_STATE_CREATE = "00";
  public static final String ROCKET_LOG_SEND_STATE_PRODUCER_FAIL = "05";
  public static final String ROCKET_LOG_SEND_STATE_PRODUCER_SUCCESS = "10";
  public static final String ROCKET_LOG_SEND_STATE_CONSUMER_FAIL = "15";
  public static final String ROCKET_LOG_SEND_STATE_CONSUMER_SUCCESS = "20";


  public static final String WECHAT_MESSAGE_LOG_SEND_STATE_CREATE = "00";
  public static final String WECHAT_MESSAGE_LOG_SEND_STATE_FAIL = "05";
  public static final String WECHAT_MESSAGE_LOG_SEND_STATE_SUCCESS = "10";
  
  public static final Boolean WECHAT_MESSAGE_LOG_IS_RESEND_YES = true;
  public static final Boolean WECHAT_MESSAGE_LOG_IS_RESEND_NO = false;
  
  public static final String WECHAT_VIP_FOCUS_STATE_YES = "Y"; 
  public static final String WECHAT_VIP_FOCUS_STATE_NO = "N";
  
  public static final String SYSTEM_TABLE_ACTIVE_STATE_YES = "Y";
  public static final String SYSTEM_TABLE_ACTIVE_STATE_NO = "N";
  
  public static final String WECHAT_TEMPLATE_SEND_STATE_YES = "Y";
  public static final String WECHAT_TEMPLATE_SEND_STATE_NO = "N";
  
  public static final String ROCKET_CONFIG_MODEL_NAME = "message";
  public static final String ROCKET_CONFIG_ROLE_TYPE_PRODUCER = "producer";
  public static final String ROCKET_CONFIG_ROLE_TYPE_CONSUMER = "consumer";
  
  public static final String ROCKET_CONFIG_BUSINESS_TYPE_WECHAT_SIMPLE_MESSAGE = "wechatSimpleMessage";
  
  public static final String ROCKET_TOPIC_SIMPLE_MESSAGE = "public_bizvane_message";
  
  public static final String ROCKET_TAG_SIMPLE = "wechat_simple_tag";

}
