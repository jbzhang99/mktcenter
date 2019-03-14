package com.bizvane.messagefacade.models.vo;

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

  ROCKET_MQ_TOPIC_NOT_EMPTY(1000, "rocketMQ_TOPIC不能为空！"),
  ROCKET_MQ_TAG_NOT_EMPTY(1010, "rocketMQ_TAG不能为空！"),
  
  WX_PUBLIC_NOT_EXISTS(10001, "公众号不存在！"),

  WX_VIP_NOT_EXISTS(10101, "会员不存在！"),
  
  WX_VIP_NOT_FOCUS(10111, "会员未关注公众号！"),

  WX_STORE_NOT_EMPTY(10201, "门店不存在！"),

  SYSTEM_AMOUNT_NOT_NEGATIVE(20001, "金额必须大于零！"),



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

