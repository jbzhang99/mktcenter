package com.bizvane.messageservice.service.impl.wxtemplatemessage;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bizvane.members.facade.models.query.CouponMemberPo;
import com.bizvane.members.facade.service.api.MemberInfoApiService;
import com.bizvane.messageservice.common.constants.SysRespConstants;
import com.bizvane.messageservice.common.constants.SystemConstants;
import com.bizvane.messageservice.common.utils.DictHelper;
import com.bizvane.messageservice.mappers.SysSmsConfigPOMapper;
import com.bizvane.messageservice.service.SmsMessageLogService;
import com.bizvane.messageservice.service.SmsTemplateMessageService;
import com.bizvane.messageservice.service.impl.centerMsg.SendCommonMessageImpl;
import com.bizvane.messagefacade.interfaces.SendBatchMessageFeign;
import com.bizvane.messagefacade.models.po.MsgSmsLogPO;
import com.bizvane.messagefacade.models.po.SysSmsConfigPO;
import com.bizvane.messagefacade.models.po.SysSmsConfigPOExample;
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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by yunjie.tian on 2018/7/28.
 */
@Service("smsGenTemplateMessageServiceImpl")
public class SmsGenTemplateMessageServiceImpl implements SmsTemplateMessageService {

    private static final Logger logger = LoggerFactory.getLogger(SmsGenTemplateMessageServiceImpl.class);
    @Autowired
    private SmsMessageLogService smsMessageLogService;
    
    @Autowired
    private SendCommonMessageImpl SendCommonMessageImpl;
    
    @Autowired
    private SendBatchMessageFeign sendBatchMessage;
    
    @Autowired
    private SysSmsConfigPOMapper sysSmsConfigPOMapper;
    
    @Autowired
    private  MemberInfoApiService memberInfoApiService;
    /**
     * 批量发短信模板消息
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
	        
	        String phoneStr = jsonObject.getString("phoneStr");
	        String sysBrandId = jsonObject.getString("sysBrandId");
	        
	         //发送
	        Result<String> sendResult = this.sendMessageDoing( jsonObject,phoneStr);
	       	 String resultInfoDetail = null;
	    	 String resultInfo = null;
	       	Integer sendState = SystemConstants.SMS_MESSAGE_LOG_SEND_STATE_FAIL;
	        if (SysRespConstants.SUCCESS.getStatus() == sendResult.getStatus()) {
	        	sendState = SystemConstants.SMS_MESSAGE_LOG_SEND_STATE_SUCCESS;
	            resultInfo="成功";
	        } else {
	            resultInfoDetail = sendResult.getMsg();
	            resultInfo="失败";
	        } 
	        
	        CouponMemberPo couponMemberPo =new CouponMemberPo();
	        
	        couponMemberPo.setPhonesStr(phoneStr);
	        couponMemberPo.setBrandId(Long.valueOf(sysBrandId));
	        ResponseData<Map<String, String>> getMemberNameByPhones= memberInfoApiService.getMemberNameByPhones(couponMemberPo);
	        

            //	        发送任务MsgId+手机号+唯一标识
    	    //细化每个电话保全到数据库
        List<MsgSmsLogPO>  MsgSmsLogPOlist = new ArrayList<MsgSmsLogPO>();
			        for(String memberPhone :phoneStr.split(",")){
				        // 记录发送消息日志
				        MsgSmsLogPO insertPO = new MsgSmsLogPO();
				        insertPO.setBussinessId(jsonObject.getString("rocketMQBussinessId"));
				        insertPO.setTemplateType(jsonObject.getString("bussinessModuleCode"));
				        insertPO.setTemplateTypeName(DictHelper.getDict("template_type_sms", jsonObject.getString("bussinessModuleCode").replace("SMS_","")).getItemCodeName());
				        insertPO.setSysBrandId(jsonObject.getLong("sysBrandId"));
				        insertPO.setMessageBody(messageBody);
			            insertPO.setResultInfoDetail(resultInfoDetail);
			            insertPO.setSendState(sendState);
				        insertPO.setResultInfo(resultInfo);
				        
				        try {
				        	insertPO.setMemberName(getMemberNameByPhones.getData().get(memberPhone));
				        	SimpleDateFormat sdfo = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				            String d = sdfo.format(jsonObject.getLong("sendTime"));  
							insertPO.setCreateDate(sdfo.parse(d));
						} catch (ParseException e) {
							e.printStackTrace();
						}
				        
		
				        insertPO.setMemberPhone(memberPhone);
			            MsgSmsLogPOlist.add(insertPO);
		              }
			        
			        Result<String> insertResult = smsMessageLogService.insertCreateDate(MsgSmsLogPOlist);
			        
			        
	        

	       
	        
    	} catch (Exception e) {
    		e.printStackTrace();
    		logger.info("短信发送异常====="+e.getMessage().toString());
    	}
    	return result;
    }
    
    
    private SimpleDateFormat newSimpleDateFormat(String string) {
		// TODO Auto-generated method stub
		return null;
	}


	public Result<String> sendMessageDoing( JSONObject jsonObject,String memberPhone){
        Result<String> result = new Result<>();
        
	    
	    String messageBody = jsonObject.getString("messageBody");
	    if (StringUtils.isBlank(messageBody)) {
	      logger.error(this.getClass().getName()+".sendMessage.messageBody:短信内容不能为空");
	      result.setStatus(SysRespConstants.MSGCONTENT_MODEL_CODE_NOT_EMPTY.getStatus());
	      result.setMsg(SysRespConstants.MSGCONTENT_MODEL_CODE_NOT_EMPTY.getMsg());
	      return result;
	    }

  	  Long sysBrandId = jsonObject.getLong("sysBrandId");
	    if (sysBrandId==null) {
	      logger.error(this.getClass().getName()+".sendMessage.sysBrandId:品牌id内容不能为空");
	      result.setStatus(SysRespConstants.SYSBRANDID_MODEL_CODE_NOT_EMPTY.getStatus());
	      result.setMsg(SysRespConstants.SYSBRANDID_MODEL_CODE_NOT_EMPTY.getMsg());
	      return result;
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
        	syssmsconfigvo.setMsgContent(messageBody+" 退订回复TD");
        	
        	result.setData(syssmsconfigvo.getMsgContent());
        	
        	//批量发送短信TODO
        	String phoneStr = jsonObject.getString("phoneStr");
        	//手机号码
        	syssmsconfigvo.setPhones(phoneStr); 
        	//业务id
        	syssmsconfigvo.setMsgId(jsonObject.getString("rocketMQBussinessId"));
        	sendResults =sendBatchMessage.sendSmgBatch(syssmsconfigvo);
        	
        	//单个发送
//        	sendResults =  SendCommonMessageImpl.sendSmg(syssmsconfigvo);
        	
             
             if (SysResponseEnum.SUCCESS.getCode() == sendResults.getCode()) {
                 result.setStatus(SysRespConstants.SUCCESS.getStatus());
                 result.setMsg(sendResults.getMessage());
             } else {
            	 result.setStatus(SysRespConstants.FAILED.getStatus());
            	 result.setMsg("发送异常："+sendResults.getMessage());
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


