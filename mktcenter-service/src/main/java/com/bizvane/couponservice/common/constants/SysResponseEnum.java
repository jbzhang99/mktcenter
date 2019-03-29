package com.bizvane.couponservice.common.constants;

/**
 * @author chen.li
 * @date on 2018/6/21 10:30
 * @description 系统响应返回码枚举类，此处定义所有该系统对外响应的返回码及释义
 * @version 1.0
 *
 */
public enum SysResponseEnum {
    SUCCESS(0, "操作成功！"),
    SYSTEM_NOT_LOGIN(-2, "未登录！"),
    
    FAILED(100, "操作失败！"),

    OPERATE_FAILED_DATA_NOT_EXISTS(101, "查询数据不存在！"),
    SYSTEM_DATA_NOT_EMPTY(118, "数据不能为空！"),

    OPERATE_FAILED_ADD_ERROR(102, "新增数据失败！"),
    OPERATE_FAILED_UPDATE_ERROR(103, "更新数据失败！"),
    OPERATE_FAILED_FILE_NOT_EXISTS(104, "操作失败，文件不存在！"),
    OPERATE_FAILED_FILE_UPLOAD_ERROR(105, "操作失败，文件上传错误！"),

    USER_LOGIN_FAILED_VALIDATECODE_NOT_EXISTS(106, "验证码不存在！"),
    USER_LOGIN_FAILED_VALIDATECODE_ERROR(107, "验证码错误！"),
    USER_LOGIN_SMS_CODE_OVERTIME(108, "短信验证码已过期！"),
    USER_LOGIN_FAILED_USERID_NOT_EXISTS(109, "登录失败，用户名不存在！"),
    USER_BIND_THIRD_LOGIN_ERROR(110, "登录失败，用户被禁用！"),
    USER_LOGIN_FAILED_USER_DISABLE(111, "登录失败，密码错误！"),
    USER_UPDATE_ERROR(112, "修改用户失败！"),
    USER_MIBILE_NOT_EXIST(113, "该手机号不存在！"),

    NETWORK_ERROR(114,"网络异常！"),
    SYSTEM_ERROR(115,"系统内部错误！"),

    UPLOAD_SUCCESS(116,"导入成功！"),
    UPLOAD_FAILED(117,"导入失败！"),

    COUPON_NOT_EXIST(10005, "券不存在！"),

    COUPON_DEFINITION_ID_NOT_NULL(1100,"券定义id不能为空"),
    COUPON_MEMBER_CODE_NOT_NULL(1101,"会员code不能为空"),
    COUPON_SEND_BUSINESS_ID_NOT_NULL(1102,"业务单号不能为空"),
    SYS_BRAND_ID_NOT_NULL(1103,"品牌id不能为空"),
    CHOOSE_MEMBER(1104,"请选择会员"),
    COUPON_MANUAL_ID_NOT_NULL(1105,"手动发券id不能为空"),
    CHECK_STATUS_NOT_NULL(1106,"审核状态不能为空"),
    COUPON_SEND_TYPE_NOT_NULL(1107,"业务类型不能为空"),
    CREATE_QUARTZ_FAIL(1108,"创建定时任务失败"),
    EXPIRE_DAY_NOT_NULL(1109,"到期时间不能为空"),
    DATE_TRANSFER_EXCEPTION(1110,"日期转换异常"),
    MEMBER_SEND_EMPTY(1111,"没有可发送的会员"),
    USE_CHANNEL_NOT_NULL(1112,"渠道限制不能为空"),
    COUPON_ENTITY_ID_NOT_NULL(1103,"券实例id不能为空"),
    USE_CHANNEL_NOT_EXISTS(1104,"渠道不存在"),
    SEND_TYPE_NOT_EXISTS(1105,"发送类型不存在"),
    COUPON_DEFINITION_TYPE_NOT_EXISTS(1106,"券定义类型不存在"),
    COUPON_CODE_NOT_NULL(1107,"券号不能为空"),
    COUPON_STATUS_NOT_NULL(1108,"券状态不能为空"),
    COUPON_DEFINITION_CODE_NOT_NULL(1109,"券定义号不能为空"),
    COMPANY_CODE_NOT_NULL(1110,"企业号不能为空"),
    COUPON_DEFINITION_IS_EMPTY(1111,"券定义为空"),
    COUPON_SEND_AGAIN_EMPTY(1112,"补发状态为空"),
    USE_BUSINESS_CODE_NOT_NULL(1113,"券使用业务单号不能为空"),
    IF_SEND_AGAIN_NOT_NULL(1114,"是否补发不能为空"),
    DATE_NOT_NULL(1115,"时间不能为空"),
    TASK_NAME_NOT_NULL(1116,"任务名称不能为空"),
    COUPON_SEND_FAIL_LOG_ID_NOT_NULL(1117,"发券失败id不能为空"),
    ERP_COUPON_DEFINITION_CODE_NOT_NULL(1118,"线下券类型号不能为空"),
    COUPON_EXPORT_LOG(1119,"券发放记录导出"),
    SEND_TIME_NOT_NULL(1120,"发送时间不能为空"),
    TASK_STATUS_NOT_NULL(1121,"审核状态不能为空"),
    WECHAT_CHANNEL_NOT_EXISTS(1122,"微信渠道不存在"),
    GIVEN_SEND_COUPON_NOT_ALLOW(1123,"转赠不允许发券"),
    MEMBER_IS_EMPTY(1124,"会员不存在"),
    COUPON_EXPIRED(1125,"券已过期"),
    COUPON_USED(1126,"券已被核销"),


    COUPON_NOT_VALID(1127,"该券未到有效使用期"),
    MEMBER_IS_NULL(1128,"会员为空"),
    WECHAT_ENTERPRISE_COUPON_ONLINE_NOT_USE(1129,"微商城券不可核销"),
    COUPON_DEFINITION_ID_LIST_NOT_NULL(1130,"券定义id列表不能为空"),
    COUPON_DEFINITION_ID_LIST_MORE_20(1131,"所选择优惠券不能超过20个")











    ;







    

    private int code;

    private String message;

    SysResponseEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

} 

