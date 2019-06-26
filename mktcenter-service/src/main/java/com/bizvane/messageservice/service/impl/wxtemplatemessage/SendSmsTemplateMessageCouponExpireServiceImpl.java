package com.bizvane.messageservice.service.impl.wxtemplatemessage;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bizvane.couponservice.common.system.DictHelper;
import com.bizvane.messageservice.common.constants.SysRespConstants;
import com.bizvane.messageservice.common.constants.SystemConstants;
import com.bizvane.messageservice.mappers.MsgSmsTempPOMapper;
import com.bizvane.messageservice.mappers.SysSmsConfigPOMapper;
import com.bizvane.messageservice.service.SendCommonMessageService;
import com.bizvane.messageservice.service.SendMessageDoingService;
import com.bizvane.messageservice.service.SendSmsTemplateMessageService;
import com.bizvane.messageservice.service.SmsMessageLogService;
import com.bizvane.messagefacade.models.po.*;
import com.bizvane.messagefacade.models.vo.Result;
import com.bizvane.messagefacade.models.vo.SysSmsConfigVO;
import com.bizvane.messageservice.service.impl.centerMsg.SendCommonMessageImpl;
import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.responseinfo.ResponseData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 张迪
 * 
 * @优惠券到期短信发送接口，消费rocketmq消息，进行短信的发送
 * 
 * @date  2018/08/13
 */
@Service("sendSmsTemplateMessageCouponExpireServiceImpl")
public class SendSmsTemplateMessageCouponExpireServiceImpl implements SendSmsTemplateMessageService {

    private static final Logger logger = LoggerFactory.getLogger(SendSmsTemplateMessageCouponExpireServiceImpl.class);
    @Autowired
    private SmsMessageLogService smsMessageLogService;
    @Resource
    private SendMessageDoingService sendMessageDoingService;

    /**
     * 发短信模板消息
     *
     * @param rocketMsgId
     * @param messageBody
     * @return
     */
    @Override
    public Result<String> sendMessage(String rocketMsgId, String messageBody) {
    	Result<String> result = new Result<>();
    	
    	try {
    		logger.info(this.getClass().getName() + ".sendMessage入参：" + messageBody);

	        if (StringUtils.isBlank(messageBody)) {
	            logger.error(this.getClass().getName() + ".sendMessage入参为空");
	            return result;
	        }
	        
	        JSONObject jsonObject = JSON.parseObject(messageBody);
	        
	        // 记录发送消息日志
	        MsgSmsLogPO insertPO = new MsgSmsLogPO();
	        insertPO.setBussinessId(jsonObject.getString("rocketMQBussinessId"));
	        insertPO.setTemplateType(jsonObject.getString("bussinessModuleCode").replace("SMS_",""));
	        insertPO.setTemplateTypeName(DictHelper.getDict("template_type_sms", jsonObject.getString("bussinessModuleCode").replace("SMS_","")).getItemCodeName());
	        if(!(StringUtils.isBlank(jsonObject.getString("memberPhone")))){insertPO.setMemberPhone(jsonObject.getString("memberPhone"));}
	        insertPO.setMessageBody(messageBody);if(!(StringUtils.isBlank(jsonObject.getString("sysBrandId")))){insertPO.setSysBrandId(jsonObject.getLong("sysBrandId"));}
	        

	        Result<String> insertResult = this.smsMessageLogService.insert(insertPO);
	         //发送
	        Result<String> sendResult = sendMessageDoingService.sendMessageDoing( jsonObject);
	        
	         //更新日志发送状态
	       	 Integer sendState = SystemConstants.SMS_MESSAGE_LOG_SEND_STATE_FAIL;
	       	 String resultInfo = null;
	        if (SysRespConstants.SUCCESS.getStatus() == sendResult.getStatus()) {
	        	sendState = SystemConstants.SMS_MESSAGE_LOG_SEND_STATE_SUCCESS;
	            resultInfo = sendResult.getMsg();
	        } else {
	            resultInfo = sendResult.getMsg();
	        }
	        

            //更新发送状态
            insertPO.setMemberName(jsonObject.getString("memberName"));
            insertPO.setMemberPhone(jsonObject.getString("memberPhone"));
            insertPO.set_id(insertResult.getData());
            insertPO.setResultInfoDetail(resultInfo);
            insertPO.setSendState(sendState);
            insertPO.setMessageBody(messageBody+sendResult.getData());
	        this.smsMessageLogService.update(insertPO);
         	logger.info("results====短信发送："+resultInfo);
	        
	        
    	} catch (Exception e) {
    		e.printStackTrace();
    		logger.info("短信发送异常====="+e.getMessage().toString());
    	}
    	return result;
    }
}
