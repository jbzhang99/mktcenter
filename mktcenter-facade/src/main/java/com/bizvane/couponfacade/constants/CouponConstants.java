package com.bizvane.couponfacade.constants;


/**
 * 
 * @author 董争光
 */
public class CouponConstants {

  /**
   * 券实例状态 - coupon_status
   */
  //public static final Byte COUPON_STATUS_ONLINE_BIND = 5;  //线上绑定
  public static final Byte COUPON_STATUS_SYNCHROING = 10;  //同步中
  public static final Byte COUPON_STATUS_SYNC_FAIL = 11;  //同步失败
  //public static final Byte COUPON_STATUS_SYNC_SUCCESS = 12;  //同步成功 - 就是未使用
  public static final Byte COUPON_STATUS_UNUSED = 20;  //未使用
  public static final Byte COUPON_STATUS_OVERDUE = 25;  //已过期
  public static final Byte COUPON_STATUS_USED = 30;  //已使用

  /**
   * 转赠状态
   */
  public static final Boolean COUPON_GIVING = true;  //转赠中
  public static final Boolean COUPON_UNGIVE = false;  //未转赠


  /**
   * 核销来源
   */
  public static final Byte COUPON_USE_FROM_QY = 5;

  /**
   * 补发状态
   */
  public static final Byte COUPON_SEND_NO = 1;//待补发
  public static final Byte COUPON_SEND_YES = 2;//已补发
  public static final Byte COUPON_SENDING = 3;//补发中

  /**
   * 券优惠类型
   */
  public static final Byte PREFERENTIAL_TYPE_EXCHANGE = 3;//兑换券
  public static final Byte PREFERENTIAL_TYPE_DISCOUNT = 2;//折扣券
  public static final Byte PREFERENTIAL_TYPE_MONEY = 1;//现金券

  /**
   * 线程池线程数
   */
  public static final int THREAD_NUMBER = 8;

  /**
   * 发券失败原因
   */
  public static final String SEND_COUPON_FAIL_REASON_ERP = "1";
  public static final String SEND_COUPON_FAIL_REASON_ERP_UNCONNECT = "2";

  /**
   * 券定义日期类型
   */
  public static final Byte VALID_TYPE__INTERVAL = 1;//日期区间
  public static final Byte VALID_TYPE__SOMEDAY = 2;//领取后x天有效


  /**
   * 渠道限制
   */
  public static final Byte USE_CHANNEL_ONLINE = 3;    //线上
  public static final Byte USE_CHANNEL_OFFLINE = 1;    //线下
  public static final Byte USE_CHANNEL_ANY = 2;    //全渠道

  /**
   * 是否会员
   */
  public static final Integer IS_MEMBER = 1;    //是会员
  public static final Integer IS_NOT_MEMBER = 0;    //非会员



  /**
   * 判断是否需要审核(中台)
   */
  public static final Integer CHECK_NEED = 1;//需要
  public static final Integer CHECK_UNNEED = 0;//不需要

  /**
   * 分页
   */
  public static final Integer SEARCH_MEMBERS_PAGE_NUMBER = 1;
  public static final Integer SEARCH_MEMBERS_PAGE_SIZE = 1000;

  /**
   * 券定义类型
   */
  public static final Byte COUPON_DEFINITION_TYPE_ONLINE = 1;//线上定义
  public static final Byte COUPON_DEFINITION_TYPE_ERP = 2;//erp生成

  /**
   * 数据有效状态
   */
  public static final Boolean TABLE_VALID_EFFECTIVE = Boolean.TRUE;    //有效
  public static final Boolean TABLE_VALID_INVALID = Boolean.FALSE;    //无效
  
  /**
   * 是否使用
   */
  public static final Boolean COUPON_USE_USED = Boolean.TRUE;
  public static final Boolean COUPON_USE_UNUSED = Boolean.FALSE;

  /**
   * 券使用类型
   */
  public static final Byte COUPON_USE_TYPE_ONLINE = 1;  //线上
  public static final Byte COUPON_USE_TYPE_OFFLINE = 2;  //线下
  public static final Byte COUPON_USE_TYPE_ALL = 3;  //全渠道



  /**
   * 线下券状态
   */
  public static final Byte COUPON_ERP_SUCCESS = 1;  //成功
  public static final Byte COUPON_ERP_FAIL = 0;  //失败



  /**
   * 券状态日志记录变更状态
   */
  public static final Byte COUPON_STATUS_CHANGE_BUSINESS_TYPE_OVERDUE = 1;  //过期
  public static final Byte COUPON_STATUS_CHANGE_BUSINESS_TYPE_USE = 2;  //核销
  public static final Byte COUPON_STATUS_CHANGE_BUSINESS_TYPE_TRANSFER = 3;  //转赠
  public static final Byte COUPON_STATUS_CHANGE_BUSINESS_TYPE_CANCEL_USE = 4;  //冲正

  /**
   * 券锁定类型
   */
  public static final Boolean COUPON_STATUS_CHANGE_IS_LOCK = Boolean.TRUE; //锁定
  public static final Boolean COUPON_STATUS_CHANGE_IS_UNLOCK = Boolean.FALSE; //未锁定

  /**
   * 券发放类型
   */
 // public static final Byte COUPON_STATUS_CHANGE_SEND_TYPE = 20;  //受赠

  /**
   * 券实例绑定状态
   */
  public static final Boolean COUPON_BIND_STATUS_BIND = Boolean.TRUE;//绑定
  public static final Boolean COUPON_BIND_STATUS_UNBIND = Boolean.FALSE;//未绑定

  /**
   * 券批量绑定状态
   */
  public static final Byte COUPON_BIND_BATCH_STATUS_BINDING = 1;//绑定中
  public static final Byte COUPON_BIND_BATCH_STATUS_COMPLETE = 2;//绑定完成
  public static final Byte COUPON_BIND_BATCH_STATUS_FAIL = 3;//绑定失败

  /**
   * 券同步状态
   */
  public static final Byte COUPON_SYNC_STATUS_UNSYNC = 1;//未同步
  public static final Byte COUPON_SYNC_STATUS_SYNC = 2;//已同步
  public static final Byte COUPON_SYNC_STATUS_SYNCING = 3;//同步中

  /**
   * 需要审核的功能编号
   */
  public static final String COUPON_CHECK_FUNCTION_CODE = "C0001";//发券任务



  /**
   * 审核状态(中台)
   */
  public static final Integer CHECK_STATUS_ALL = 0;//全部
  public static final Integer CHECK_STATUS_WAIT = 1;//待审核
  public static final Integer CHECK_STATUS_CHECKING = 2;//审核中
  public static final Integer CHECK_STATUS_CHECKED = 3;//已审核
  public static final Integer CHECK_STATUS_REJECTED = 4;//已驳回

  /**
   * 定时任务desc
   */
  public static final String COUPON_EXPIRE_DESC = "券到期提醒";


  /**
   * 券到期提醒字典表类型
   */
  public static final String COUPON_EXPIRE_CODE_TYPE = "expire_day";

  /**
   * 补发券重试次数
   */
  public static final Byte COUPON_SEND_FAIL_TIMES_ZERO = 0;
  public static final Byte COUPON_SEND_FAIL_TIMES_ONE = 1;

  /**
   * 是否补发
   */
  public static final Integer COUPON_SEND_AGAIN_NO = 0;//初次发
  public static final Integer COUPON_SEND_AGAIN_YES = 1;//补发


  /**
   * 券定义状态
   */
  public static final Boolean COUPON_DEFINITION_STATUS_USE = Boolean.TRUE;
  public static final Boolean COUPON_DEFINITION_STATUS_UNUSE = Boolean.FALSE;

  /**
   * 导出文件类型
   */
  public static  final  String FILE_TYPE_EXPORT="EXPORT";

  /**
   * 文件地址
   */
 // public static  final  String FILE_UNL_ADDR="E://";

  /*public static final long WECHAT_MESSAGE_RESULT_ERRORCODE = 0;


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

  public static final String ROCKET_TAG_SEND_COUPON = "wechat_tag_sendCoupon";

  public static final String ROCKET_CONFIG_BUSINESS_TYPE_WECHAT_SEND_COUPON = "wechatSendCoupon";*/

  public static final Integer defaultPageNumber=1;
  public static final Integer defaultPageSize=10;
}
