//package com.bizvane.messageservice.controller;
//
//import com.alibaba.fastjson.JSONObject;
//import com.bizvane.messageservice.common.constants.SystemConstants;
//import com.bizvane.messageservice.common.constants.TemplateMessageTypeConstant;
//import com.bizvane.messageservice.mappers.SysSmsConfigPOMapper;
//import com.bizvane.messageservice.service.RocketMQWechatService;
//import com.bizvane.messageservice.service.SmsMessageLogService;
//import com.bizvane.messagefacade.interfaces.SendBatchMessageFeign;
//import com.bizvane.messagefacade.interfaces.SendCommonMessageFeign;
//import com.bizvane.messagefacade.models.po.MsgSmsLogPO;
//import com.bizvane.messagefacade.models.po.SysSmsConfigPO;
//import com.bizvane.messagefacade.models.po.SysSmsConfigPOExample;
//import com.bizvane.messagefacade.models.vo.GenrealSendMessageVO;
//import com.bizvane.messagefacade.models.vo.Result;
//import com.bizvane.messagefacade.models.vo.SysSmsConfigVO;
//import com.bizvane.utils.enumutils.SysResponseEnum;
//import com.bizvane.utils.responseinfo.ResponseData;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Date;
//import java.util.List;
//
///**
// * @Author: lijunwei，短信发送接口
// * @Time: 2018/7/19 14:14
// */
//@RestController
//@RequestMapping(value="/msg",method = RequestMethod.POST)
//public class SendMsgController {
//	  private static final Logger logger = LoggerFactory.getLogger(SendMsgController.class);
//    @Autowired
//    private SendCommonMessageFeign sendCommonMessage;
//
//    @Autowired
//    private SendBatchMessageFeign sendBatchMessage;
//
//    @Autowired
//    private RocketMQWechatService rocketMQWechatService;
//
//    @Autowired
//    private SmsMessageLogService smsMessageLogService;
//
//    @Autowired
//    private  SysSmsConfigPOMapper sysSmsConfigPOMapper;
//
//    @RequestMapping(value="/sendsmg",method = RequestMethod.POST)
//    public ResponseData<Integer> sendSmg(@RequestBody SysSmsConfigVO vo){
//    	logger.info("SendMsgController.sendSmg:短信验证码发送"+vo.getPhone()+JSONObject.parseObject(JSONObject.toJSONString(vo)).toJSONString());
//
//    	ResponseData<Integer> sendResultssysSmsConfig = new ResponseData<Integer>(SysResponseEnum.FAILED.getCode(),SysResponseEnum.FAILED.getMessage(),null);
//
//    	try {
//
//    		//有品牌 按照品牌通道
//        	if(vo.getSysBrandId()!=null) {
//                //获取短信通道 sysBrandId
//                SysSmsConfigPOExample sysSmsConfigPOExample = new SysSmsConfigPOExample();
//                sysSmsConfigPOExample.createCriteria().andSysBrandIdEqualTo(vo.getSysBrandId()).andChannelTypeEqualTo(20).andValidEqualTo(Boolean.TRUE);
//                List<SysSmsConfigPO> sysSmsConfigList= sysSmsConfigPOMapper.selectByExample(sysSmsConfigPOExample);
//                //获取短信通道信息
//
//                if(null == sysSmsConfigList || sysSmsConfigList.size()>0){
//            	    vo.setChannelType(20);
//            		vo.setChannelName(sysSmsConfigList.get(0).getChannelName());
//            		vo.setChannelService(sysSmsConfigList.get(0).getChannelService());
//            		vo.setChannelAccount(sysSmsConfigList.get(0).getChannelAccount());
//            		vo.setChannelPassword(sysSmsConfigList.get(0).getChannelPassword());
//                }else {
//
//                	sendResultssysSmsConfig.setCode(SysResponseEnum.FAILED.getCode());
//                	sendResultssysSmsConfig.setData(1);
//                	sendResultssysSmsConfig.setMessage("当前品牌短信通道没有配置!"+vo.getSysBrandId());
//
//                	MsgSmsLogPO insertPO = new MsgSmsLogPO();
//                    insertPO.setTemplateType("YZM_TEMPLATE_MESSAGE");
//                    insertPO.setTemplateTypeName("验证码短信");
//                    insertPO.setResultInfo("成功");
//                    insertPO.setSysBrandId(vo.getSysBrandId());
//            	    insertPO.setMemberPhone(vo.getPhone());
//            	    insertPO.setMemberName("验证码短信");
//                    insertPO.setSendState(-1);
//                    insertPO.setResultInfoDetail("当前品牌短信通道没有配置!");
//                   insertPO.setMessageBody(JSONObject.toJSONString(vo));
//                   Result<String> insertResult = smsMessageLogService.insert(insertPO);
//                	 return  sendResultssysSmsConfig;
//
//                }
//
//        	}else {
//                //没有品牌按照短信占时固定通道
//        	    vo.setChannelType(20);
//        		vo.setChannelName("chuangLan253");
//        		vo.setChannelService("http://smssh1.253.com/msg/send/json");
//        		vo.setChannelAccount("N410601_N1573677");
//        		vo.setChannelPassword("6kxVYXdoJN4e6c");
//        	}
//
//		} catch (Exception e) {
//        	sendResultssysSmsConfig.setCode(SysResponseEnum.FAILED.getCode());
//        	sendResultssysSmsConfig.setData(1);
//        	sendResultssysSmsConfig.setMessage("找当前品牌通道接口异常！"+vo.getSysBrandId());
//        	 return  sendResultssysSmsConfig;
//
//		}
//
//
//
//    	 ResponseData<Integer> sendResults =sendCommonMessage.sendSmg(vo);
//
//
////    	TDDO//短信发送记录
//    	MsgSmsLogPO insertPO = new MsgSmsLogPO();
//        insertPO.setTemplateType("YZM_TEMPLATE_MESSAGE");
//        insertPO.setTemplateTypeName("验证码短信");
//        insertPO.setResultInfo("成功");
//        insertPO.setSysBrandId(vo.getSysBrandId());
//	    insertPO.setMemberPhone(vo.getPhone());
//	    insertPO.setMemberName("验证码短信");
//
//        if (SysResponseEnum.SUCCESS.getCode() == sendResults.getCode()) {
//            insertPO.setSendState(1);
//        } else {
//        	 insertPO.setSendState(-1);
//        	 insertPO.setResultInfoDetail(sendResults.getMessage());
//        }
//       insertPO.setMessageBody(JSONObject.toJSONString(vo)+sendResults.getMessage());
//       Result<String> insertResult = smsMessageLogService.insert(insertPO);
////   	TDDO//短信发送记录
//
//        return  sendResults;
//    }
//
//    @RequestMapping(value="/sendBatchsmg",method = RequestMethod.POST)
//    public ResponseData<Integer> sendSmgBatch(@RequestBody SysSmsConfigVO vo){
//
//    	//修改推送到MQ
////    	Long taskId =  (long) Integer.parseInt(String.valueOf(UUID.randomUUID().hashCode()).replaceAll("-", ""));
//        logger.info("SendMsgController.sendMessage:"+vo.getMsgId()+JSONObject.parseObject(JSONObject.toJSONString(vo)).toJSONString());
//
//    	GenrealSendMessageVO vosend =new GenrealSendMessageVO();
//    	vosend.setSysBrandId(vo.getSysBrandId());
//    	vosend.setPhoneStr(vo.getPhones());
//    	vosend.setMessageBody(vo.getMsgContent());
//
//    	vosend.setMemberName("营销批量"+vo.getMsgId());
//    	vosend.setTemplateType("BATCH_TEMPLATE_MESSAGE");
//    	vosend.setSendTime(new Date());
//    	vosend.setTaskId(Long.valueOf(vo.getMsgId()));
//
//
//    	 JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(vosend));
//        jsonObject.put("rocketMQTopic", SystemConstants.ROCKET_TOPIC_SIMPLE_MESSAGE);
//        jsonObject.put("rocketMQTag", TemplateMessageTypeConstant.GEN_SMS_TEMPLATE_MESSAGE);
//        jsonObject.put("bussinessModuleCode", TemplateMessageTypeConstant.GEN_SMS_TEMPLATE_MESSAGE);
//        jsonObject.put("bussinessType",SystemConstants.ROCKET_CONFIG_BUSINESS_TYPE_GEN_SMS_TEMPLATE_MESSAGE);
//        jsonObject.put("rocketMQBussinessId",  vo.getMsgId());
//
//        Result<String> result= this.rocketMQWechatService.sendMessage(jsonObject.toJSONString());
//
//
//        ResponseData<Integer> resultInteger = new ResponseData<Integer>(SysResponseEnum.SUCCESS.getCode(),SysResponseEnum.SUCCESS.getMessage(),null);
//        resultInteger.setMessage(result.getMsg());
//        return resultInteger;
//      //修改推送到MQ
//
////        return  sendBatchMessage.sendSmgBatch(vo);
//    }
//}
