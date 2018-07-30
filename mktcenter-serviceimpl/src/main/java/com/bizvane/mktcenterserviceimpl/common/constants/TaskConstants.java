package com.bizvane.mktcenterserviceimpl.common.constants;

import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.responseinfo.ResponseData;

/**
 * @author chen.li
 * @date on 2018/7/13 10:13
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
public class TaskConstants {

    //任务主体
    public final  static String ERROR_MSG_TASK_NAME_EMPTY ="任务名称为空";
    public final static String ERROR_MSG_TASK_DATE_EMPTY ="活动起止日期为空";
    public final static String ERROR_MSG_TASK_INFO_EMPTY ="任务说明为空";
    public final static String ERROR_MSG_TASK_TYPE_EMPTY ="任务类型为空";
    public final static String ERROR_MSG_TASK_TYPE_NOT_EXISTS ="任务类型不存在";

    //分享任务
    public final static String ERROR_MSG_SHARE_TIMES_EMPTY ="分享次数为空";
    public final static String ERROR_MSG_SHARE_URL_TYPE_EMPTY ="分享链接类型为空";
    public final static String ERROR_MSG_SHARE_URL_EMPTY ="分享日志为空";

    //消费任务
    public final static String ERROR_MSG_ORDER_SOURCE_EMPTY ="订单来源限制为空";
    public final static String ERROR_MSG_TCONSUME_AMOUNT_EMPTY ="累计消费金额为空";
    public final static String ERROR_MSG_CONSUME_TIMES_EMPTY ="累计消费次数为空";

    //邀请注册
    public final static String ERROR_MSG_invite_num_EMPTY ="邀请注册人数为空";

    //任务类型
    //活动
    public  final static Integer  ACTIVITY_TYPE=1;
    //任务
    public  final static Integer  TASK_TYPE=2;
}
