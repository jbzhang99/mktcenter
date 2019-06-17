package com.bizvane.messageservice.service.impl.wxtemplatemessage;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bizvane.couponservice.common.system.DictHelper;
import com.bizvane.messageservice.common.constants.SysRespConstants;
import com.bizvane.messageservice.common.constants.SystemConstants;
import com.bizvane.messageservice.mappers.MsgSmsTempPOMapper;
import com.bizvane.messageservice.mappers.SysSmsConfigPOMapper;
import com.bizvane.messageservice.service.SmsMessageLogService;
import com.bizvane.messageservice.service.SmsTemplateMessageService;
import com.bizvane.messagefacade.models.po.*;
import com.bizvane.messagefacade.models.vo.Result;
import com.bizvane.messagefacade.models.vo.SysSmsConfigVO;
import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.responseinfo.ResponseData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yunjie.tian on 2018/7/28.
 */
@Service("smsTemplateMessageMemberRegisterServiceImpl")
public class SmsTemplateMessageMemberRegisterServiceImpl implements SmsTemplateMessageService {

    private static final Logger logger = LoggerFactory.getLogger(SmsTemplateMessageMemberRegisterServiceImpl.class);
    @Autowired
    private SmsMessageLogService smsMessageLogService;
    
    @Autowired
    private com.bizvane.messageservice.service.impl.centerMsg.SendCommonMessageImpl SendCommonMessageImpl;
    @Autowired
    private MsgSmsTempPOMapper msgSmsTempPOMapper;
    
    @Autowired
    private SysSmsConfigPOMapper sysSmsConfigPOMapper;
    

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
	        if((StringUtils.isBlank(jsonObject.getString("memberName"))))
	        {
	        	jsonObject.put("memberName", "");
	        }
	        if((StringUtils.isBlank(jsonObject.getString("nowLevelMember"))))
	        {
	        	jsonObject.put("nowLevelMember", "");
	        }
	        
	        // 记录发送消息日志
	        MsgSmsLogPO insertPO = new MsgSmsLogPO();
	        insertPO.setBussinessId(jsonObject.getString("rocketMQBussinessId"));
	        insertPO.setTemplateType(jsonObject.getString("bussinessModuleCode").replace("SMS_",""));
	        insertPO.setTemplateTypeName(DictHelper.getDict("template_type_sms", jsonObject.getString("bussinessModuleCode").replace("SMS_","")).getItemCodeName());
	        if(!(StringUtils.isBlank(jsonObject.getString("memberPhone")))){insertPO.setMemberPhone(jsonObject.getString("memberPhone"));}
	        insertPO.setMessageBody(messageBody);if(!(StringUtils.isBlank(jsonObject.getString("sysBrandId")))){insertPO.setSysBrandId(jsonObject.getLong("sysBrandId"));}
	        Result<String> insertResult = this.smsMessageLogService.insert(insertPO);
	         //发送
	        Result<String> sendResult = this.sendMessageDoing( jsonObject);
	        
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
    
    
    public Result<String> sendMessageDoing( JSONObject jsonObject){
        Result<String> result = new Result<>();
        
   	   String memberName = jsonObject.getString("memberName");
 	    if (StringUtils.isBlank(memberName)) {
// 	      logger.error(this.getClass().getName()+".sendMessage.memberName:会员姓名不能为空");
// 	      result.setStatus(SysRespConstants.MEMBERNSME_MODEL_CODE_NOT_EMPTY.getStatus());
// 	      result.setMsg(SysRespConstants.MEMBERNSME_MODEL_CODE_NOT_EMPTY.getMsg());
// 	      return result;
 	    	
 	    	  jsonObject.fluentPut("memberName","");
 	    }
 	    
 	    
 	    String nowLevelMember = jsonObject.getString("nowLevelMember");
 	    if (StringUtils.isBlank(nowLevelMember)) {
// 	      logger.error(this.getClass().getName()+".sendMessage.nowLevelMember:当前会员等级不能为空");
// 	      result.setStatus(SysRespConstants.NOWLEVELMERBER_MODEL_CODE_NOT_EMPTY.getStatus());
// 	      result.setMsg(SysRespConstants.NOWLEVELMERBER_MODEL_CODE_NOT_EMPTY.getMsg());
// 	      return result;
 	    	
 	    	  jsonObject.fluentPut("nowLevelMember","");
 	    }
 	    
 	    
 	    String pubNum = jsonObject.getString("pubNum");
 	    if (StringUtils.isBlank(pubNum)) {
// 	      logger.error(this.getClass().getName()+".sendMessage.pubNum:公众号不能为空");
// 	      result.setStatus(SysRespConstants.PUBNUM_MODEL_CODE_NOT_EMPTY.getStatus());
// 	      result.setMsg(SysRespConstants.PUBNUM_MODEL_CODE_NOT_EMPTY.getMsg());
// 	      return result;
 	    	  jsonObject.fluentPut("pubNum","");
 	    }
 	    
 	    String memberPhone = jsonObject.getString("memberPhone");
 	    if (StringUtils.isBlank(memberPhone)) {
 	      logger.error(this.getClass().getName()+".sendMessage.memberPhone:手机号不能为空");
 	      result.setStatus(SysRespConstants.MEMBERPHONE_MODEL_CODE_NOT_EMPTY.getStatus());
 	      result.setMsg(SysRespConstants.MEMBERPHONE_MODEL_CODE_NOT_EMPTY.getMsg());
 	      return result;
 	    }
 	    
 	    String sendWxmember = jsonObject.getString("sendWxmember");
 	    if (StringUtils.isBlank(sendWxmember)) {
 	      logger.error(this.getClass().getName()+".sendMessage.sendWxmember:是否微信会员不能为空");
 	      result.setStatus(SysRespConstants.SENGWXMENBER_MODEL_CODE_NOT_EMPTY.getStatus());
 	      result.setMsg(SysRespConstants.SENGWXMENBER_MODEL_CODE_NOT_EMPTY.getMsg());
 	      return result;
 	    }

 	    
 	  Long sysBrandId = jsonObject.getLong("sysBrandId");
 	    if (sysBrandId==null) {
 	      logger.error(this.getClass().getName()+".sendMessage.sysBrandId:品牌id内容不能为空");
 	      result.setStatus(SysRespConstants.SYSBRANDID_MODEL_CODE_NOT_EMPTY.getStatus());
 	      result.setMsg(SysRespConstants.SYSBRANDID_MODEL_CODE_NOT_EMPTY.getMsg());
 	      return result;
 	    }
      //找到短信模板信息
        MsgSmsTempPOExample msgSmsTempPOExample = new MsgSmsTempPOExample();
        msgSmsTempPOExample.createCriteria().andSysBrandIdEqualTo(sysBrandId).andTemplateTypeEqualTo(jsonObject.getString("bussinessModuleCode").replace("SMS_","")).andValidEqualTo(Boolean.TRUE);
        List<MsgSmsTempPO> smsTempPOList= msgSmsTempPOMapper.selectByExample(msgSmsTempPOExample);
        if(null == smsTempPOList || smsTempPOList.size()==0){
            result.setStatus(SysRespConstants.SMS_MESSAGETEMP_NOT_EXISTS.getStatus());
            result.setMsg(SysRespConstants.SMS_MESSAGETEMP_NOT_EXISTS.getMsg());
            return result;
        }
        
        //  校验是否发送短信  是否开启 短信配置开关 0.关闭1.开启
        MsgSmsTempPO smsTempPO= smsTempPOList.get(0);
        if(smsTempPO.getStatus()==false){
            logger.error("该会员发送短信未开启！");
            result.setStatus(SysRespConstants.SMS_MESSAGETEMP_OFF.getStatus());
            result.setMsg(SysRespConstants.SMS_MESSAGETEMP_OFF.getMsg());
            return result;
        }
        
        
        jsonObject.getString("memberPhone");
        //判断短信是否发送微信会员  0.全部发送 1.向微信会员发送短信2.向非微信会员发送短信
         //如果模板只向微信会员发送
        
//        	是微信会员
        	if("2".equals(jsonObject.getString("sendWxmember"))) {
//        		设置不是微信会员发送就放回
        		if(smsTempPO.getSendWxmember()==1) {
           		 logger.error("该模板设置不向微信会员发短信");
                 result.setStatus(SysRespConstants.SMS_CONFIG_MESSAGETEMP_WX_OFF.getStatus());
                 result.setMsg(SysRespConstants.SMS_CONFIG_MESSAGETEMP_WX_OFF.getMsg());
                 return result;
        		}

        	}
        	
        
    	
        //获取短信通道 sysBrandId
        SysSmsConfigPOExample sysSmsConfigPOExample = new SysSmsConfigPOExample();
        sysSmsConfigPOExample.createCriteria().andSysBrandIdEqualTo(sysBrandId).andChannelTypeEqualTo(10).andValidEqualTo(Boolean.TRUE);
        List<SysSmsConfigPO> sysSmsConfigList= sysSmsConfigPOMapper.selectByExample(sysSmsConfigPOExample);
       
        //获取短信通道信息
        ResponseData<Integer> sendResults = new ResponseData<Integer>(SysResponseEnum.FAILED.getCode(),SysResponseEnum.FAILED.getMessage(),null);
        if(null == sysSmsConfigList || sysSmsConfigList.size()>0){
        	 ObjectMapper mapper = new ObjectMapper();
        	SysSmsConfigVO syssmsconfigvo = mapper.convertValue(sysSmsConfigList.get(0), SysSmsConfigVO.class);
        	//处理短信内容
        	syssmsconfigvo.setMsgContent(smsTempPO.getContent().replace("@[会员姓名]",jsonObject.getString("memberName")).replace("@[当前会员等级]", jsonObject.getString("nowLevelMember")).replace("@[公众号]", jsonObject.getString("pubNum")));
        	//手机号码
        	syssmsconfigvo.setPhone(jsonObject.getString("memberPhone"));     result.setData(syssmsconfigvo.getMsgContent());
        	//发送短信
        	sendResults =  SendCommonMessageImpl.sendSmg(syssmsconfigvo);
             
             if (SysResponseEnum.SUCCESS.getCode() == sendResults.getCode()) {
                 result.setStatus(SysRespConstants.SUCCESS.getStatus());
                 result.setMsg(sendResults.getMessage());
             } else {
            	 result.setStatus(SysRespConstants.FAILED.getStatus());
            	 result.setMsg("发送异常"+sendResults.getMessage());
             }

        }else {
        	
            result.setStatus(SysRespConstants.SMS_CONFIG_MESSAGETEMP_NOT_EXISTS.getStatus());
            result.setMsg(SysRespConstants.SMS_CONFIG_MESSAGETEMP_NOT_EXISTS.getMsg());
            return result;
        	  
        }
        
        // 发送模板消息
        return result;

    }


}


