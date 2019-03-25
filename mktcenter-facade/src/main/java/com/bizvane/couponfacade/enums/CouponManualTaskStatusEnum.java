package com.bizvane.couponfacade.enums;

/**
 * 手动发券任务状态
 * Created by yunjie.tian on 2018/8/24.
 */
public enum CouponManualTaskStatusEnum {

    TASK_STATUS_NEW(5,"新建"),
    TASK_STATUS_CHECK_WAIT(10,"待审核"),
    TASK_STATUS_CHECK_PASS(15,"待执行(审核通过)"),
    TASK_STATUS_CHECK_UNPASS(20,"审核不通过"),
    TASK_STATUS_SENDING(25,"发送中"),
    TASK_STATUS_SEND_SUCCESS(30,"发送完成"),
    TASK_STATUS_PART_FAIL(35,"部分失败"),
    TASK_STATUS_CANCEL(40,"已作废"),
    TASK_STATUS_SYNCING(45,"同步中");




    private Integer code;
    private String msg;
    CouponManualTaskStatusEnum(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
