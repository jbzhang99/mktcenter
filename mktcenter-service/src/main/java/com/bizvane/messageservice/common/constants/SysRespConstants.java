package com.bizvane.messageservice.common.constants;

/**
 * 系统响应吗枚举类 此处定义所有的系统内容的错误码
 * 
 * @author 董争光 2018年5月21日下午1:52:24
 */
public enum SysRespConstants {
  SUCCESS(0, "操作成功！"), FAILED(1, "操作失败！"),

  SYSTEM_DATA_NOT_EMPTY(101, "数据不能为空！"),
  
  SYSTEM_DATA_NOT_REPEAT(111, "数据不能重复！"),
  
  SYSTEM_DATA_DISABLE(116, "数据被禁用！"),

  BUSSINESS_ID_NOT_EMPTY(201, "业务单据号不能为空！"),
  
  BUSSINESS_MODEL_CODE_NOT_EMPTY(210, "业务代码不能为空！"),

  WX_MESSAGETEMP_NOT_EXISTS(301, "模板消息不存在！"), 
  WX_MESSAGETEMP_NOT_INIT(305, "没有初始化模板消息！"), 
  WX_MESSAGETEMP_STATE_NOT_SEND(310, "模板消息状态：不发送！"), 
  WX_MESSAGETEMP_USER_INFO_NOT_EMPTY(315, "用户关键信息不能为空！"),

  WX_ACCESS_TOKEN_NOT_EMPTY(400, "微信ACCESS_TOKEN不能为空！"), 
  WX_MESSAGE_TEMPLATE_NETWORK_ERROR(405, "调用微信模板发消息异常：网络错误！"), 
  WX_MESSAGE_TEMPLATE_SEND_FAIL(410, "调用微信模板消息失败：网络错误！"),
  
  SMS_MESSAGETEMP_OFF(510, "短信模板配置没有开启！"),
  SMS_MESSAGETEMP_NOT_EXISTS(511, "短信模板消息不存在！"), 
  SMS_CONFIG_MESSAGETEMP_NOT_EXISTS(512, "短信通道消息不存在！"),
  SMS_CONFIG_MESSAGETEMP_NOT_PHONE(513, "该手机号不是白名单，不发送短信！"),
  SMS_CONFIG_MESSAGETEMP_IN_PHONE(514, "该手机号是黑名单，不发送短信！"),
  
  
  MEMBERNSME_MODEL_CODE_NOT_EMPTY(513, "会员姓名不能为空！"),
  NOWLEVELMERBER_MODEL_CODE_NOT_EMPTY(514, "当前会员等级不能为空！"),
  PUBNUM_MODEL_CODE_NOT_EMPTY(515, "公众号不能为空！"),
  MEMBERPHONE_MODEL_CODE_NOT_EMPTY(516, "手机号不能为空！"),
  MSGCONTENT_MODEL_CODE_NOT_EMPTY(517, "短信内容不能为空！"),
  SYSBRANDID_MODEL_CODE_NOT_EMPTY(518, "品牌id内容不能为空！"),
  MONEY_MODEL_CODE_NOT_EMPTY(519, "消费金额金额内容不能为空！"),
  SENGWXMENBER_MODEL_CODE_NOT_EMPTY(520, "是否微信会员状态不能为空！"),
  POSITION_MONEY_MODEL_CODE_NOT_EMPTY(519, "消费地点内容不能为空！"),
  SMS_CONFIG_MESSAGETEMP_WX_OFF(521, "该模板设置不向微信会员发短信！"),
  SMS_CONFIG_MESSAGETEMP_NOT_WX_OFF(522, "该模板设置只向非微信会员发短信，微信会员不能发送！"),
  ACTIVITY_NAME_CONFIG_MESSAGETEMP_NOT_WX_OFF(523, "活动名称不能是空！"),
  ACTIVITY_DATE_CONFIG_MESSAGETEMP_NOT_WX_OFF(524, "该模板设置只向非微信会员发短信，微信会员不能发送！"),
  ACTIVITY_QUANYI_CONFIG_MESSAGETEMP_NOT_WX_OFF(525, "活动权益不能是空！"),
   CHANG_INTEGRAL_CONFIG_MESSAGETEMP_NOT_WX_OFF(526, "入账积分数额不能是空！"),
   USE_INTEGRAL_MESSAGETEMP_NOT_WX_OFF(527, "使用积分数额不能是空！"),
   COUPON_MONEY_MODEL_CODE_NOT_EMPTY(528, "优惠券名称不能是空！"),
   COUPONCODE_MONEY_MODEL_CODE_NOT_EMPTY(529, "优惠券名称不能是空！"),
   ORDERNO_MONEY_MODEL_CODE_NOT_EMPTY(530, "订单号不能是空！"),

  DATA_NOT_TOTAY(2100, "数据推送延迟1天以上！"),
   
   
  


  ROCKET_MQ_TOPIC_NOT_EMPTY(1000, "rocketMQ_TOPIC不能为空！"),
  ROCKET_MQ_TAG_NOT_EMPTY(1010, "rocketMQ_TAG不能为空！"),
  
  WX_PUBLIC_NOT_EXISTS(10001, "公众号不存在！"),

  WX_VIP_NOT_EXISTS(10101, "会员不存在！"),
  
  WX_VIP_NOT_FOCUS(10111, "会员未关注公众号，找不到会员信息！"),
  
  WX_STORE_NOT_EMPTY(10112, "门店不存在！"),

  SYSTEM_AMOUNT_NOT_NEGATIVE(20001, "金额必须大于零！"),

  WX_COUPON_NOT_EXISTS(10301,"券不存在"),WX_COUPON_NOT_EMPTY(10305,"券不能为空"),

  
  SENDSMS_PHONE_NOT_EXISTS(10301,"手机号不存在"),SENDSMS_PHONE_NOT_EMPTY(10305,"手机号不能为空")

  ;

  private int status;

  private String msg;

  private SysRespConstants(int status, String msg) {
    this.status = status;
    this.msg = msg;
  }

  public int getStatus() {
    return this.status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public String getMsg() {
    return this.msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

}

