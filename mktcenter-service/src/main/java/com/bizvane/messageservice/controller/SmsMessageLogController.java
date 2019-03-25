package com.bizvane.messageservice.controller;

import com.bizvane.messageservice.common.utils.PageForm;
import com.bizvane.messageservice.service.SmsMessageLogService;
import com.bizvane.messagefacade.models.vo.SmsMessageLogVo;
import com.bizvane.utils.responseinfo.ResponseData;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Geng on 2018/8/9.
 */

@RestController
@RequestMapping("smsMessageLog")
public class SmsMessageLogController {

    @Autowired
    private SmsMessageLogService smsMessageLogService;
    
    @ApiOperation(value = "消息工具>>短信消息记录", notes = "消息工具>>短信消息记录", tags = {"消息工具>>短信消息记录"},httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "baseSearchValue", value = "基本查询条件", required = true, dataType = "String"),
            @ApiImplicitParam(name = "memberPhone", value = "高级查询：手机", required = true, dataType = "String"),
            @ApiImplicitParam(name = "templateType", value = "消息类型：手机，短信模板类型(COUPON_RECEIVE-券到账提醒，COUPON_UNRECEIVED-券未领取提醒，COUPON_EXPIRE-券到期提醒，COUPON_USE券使用提醒，INTEGRAL_ADD-积分增加提醒，INTEGRAL_SUBTRACT-积分减少提醒，INTEGRAL_EXPIRE-积分到期提醒，INTEGRAL_USE-积分使用提醒，MEMEBER_REGISTER-会员注册提醒，MEMEBER_INVITE_REGISTER-会员邀请注册提醒，MEMEBER_UPGRADE-会员升级提醒，MEMEBER_DOWNGRADE-会员降级提醒，ORDER_OFFLINE_CONSUME-线下订单提醒，ORDER_ONLINE_CONSUME-线上订单提醒，ORDER_PAYMENT-订单支付提醒，ORDER_SHIP-订单发货提醒，ORDER_SIGN-订单签收提醒，ORDER_CANCEL-订单取消提醒，ORDER_APPRAISAL-订单评价提醒,ACTIVITY_TEMPLATE_MESSAGE活动消息)',", required = true, dataType = "String"),
            @ApiImplicitParam(name = "sendTimeStart", value = "高级查询：发送开始时间", required = true, dataType = "Date"),
            @ApiImplicitParam(name = "sendTimeEnd", value = "高级查询：发送结束时间", required = true, dataType = "Date")
            
    })
    @RequestMapping("getMsgLogPage")
    public ResponseData<Object> getMsgLogPage(SmsMessageLogVo smsMessageLogVo ){
    	PageForm pageForm = new PageForm();
        pageForm.setPageNum(smsMessageLogVo.getPageNumber());
        pageForm.setPageSize(smsMessageLogVo.getPageSize());
        return smsMessageLogService.getMsgLogPage(smsMessageLogVo,pageForm);
    }


    @RequestMapping("getStatistics")
    public ResponseData getStatistics(SmsMessageLogVo smsMessageLogVo){

        return smsMessageLogService.getStatistics(smsMessageLogVo);
    }


}
