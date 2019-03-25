package com.bizvane.messageservice.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.Producer;
import com.aliyun.openservices.ons.api.SendCallback;
import com.aliyun.openservices.ons.api.SendResult;
import com.aliyun.openservices.ons.api.exception.ONSClientException;
import com.bizvane.messageservice.common.constants.TemplateMessageTypeConstant;
import com.bizvane.messageservice.common.redis.RedisManager;
import com.bizvane.messageservice.mappers.MsgSendTimePOMapper;
import com.bizvane.messageservice.service.RocketMQProducerService;
import com.bizvane.messagefacade.models.po.MsgSendTimePO;
import com.bizvane.messagefacade.models.po.MsgSendTimePOExample;
import com.bizvane.messagefacade.models.vo.Result;
import com.bizvane.utils.redisutils.RedisClient;
import com.bizvane.utils.responseinfo.ResponseData;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 发送MQ消息service
 * 
 * @author 董争光 2018年5月20日下午2:48:19
 */
@Service
public class RocketMQProducerServiceImpl implements RocketMQProducerService {
		
  @Value("${rocketmq.topic}")
  private String rocketmqTopic;
  
  @Value("${rocketmq.producerId}")
  private String rocketmqProducerId;
  
  @Value("${rocketmq.consumerId}")
  private String rocketmqConsumerId;
	
    @Autowired
    private MsgSendTimePOMapper msgSendTimePOMapper;

  private static final Logger logger = LoggerFactory.getLogger(RocketMQProducerServiceImpl.class);

  /**
   * 发送MQ消息service
   * 
   * @author 董争光 2018年5月20日下午2:48:19
   */
  @Override
  public ResponseData<String> sendMessage(final Producer producerOld, final String topic, final String tag, final byte[] messageBody) {
    RocketMQProducerServiceImpl.logger.info("RocketMQProducerServiceImpl.sendMessage:topic:" + topic + ">tag:" + tag);

    if (StringUtils.isBlank(topic) || StringUtils.isBlank(tag)) {
      RocketMQProducerServiceImpl.logger.error("RocketMQProducerServiceImpl.sendMessage:topic、tag不能为空");
    }

    ResponseData<String> result = new ResponseData<>();
    
    //发送主题：改配置读取
    Producer producer = RocketMQManager.getProducer(rocketmqTopic);
    Message message = new Message(rocketmqTopic, tag, messageBody);
    try {
    	
        // 设置代表消息的业务关键属性，请尽可能全局唯一。
        // 以方便您在无法正常收到消息情况下，可通过阿里云服务器管理控制台查询消息并补发
        // 注意：不设置也不会影响消息正常收发
    	  
          message.setKey("message_rocketmq_" + messageBody.hashCode());
      
          // 定时消息，单位毫秒（ms），在指定时间戳（当前时间之后）进行投递，例如 2016-03-07 16:21:00 投递。如果被设置成当前时间戳之前的某个时刻，消息将立刻投递给消费者。
          Result<JSONObject> sendcheck = this.checkID( new String(messageBody));
          if(sendcheck.getStatus()==0) {
        	    Date today = new Date();
        	    SimpleDateFormat formattimeToday=new SimpleDateFormat("yyyy-MM-dd ");
        	    SimpleDateFormat format=new SimpleDateFormat("HH:mm:ss");
        	    String timeToday=formattimeToday.format(new Date());
        	    
        	    //现在时间
        	    long todayNow  = format.parse(format.format(new Date())).getTime();
        	    //停止时间
        	    long todayLong =  sendcheck.getData().getLongValue("sendTimeEnd");  
        	    
        	    //开始时间
        	    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        	    String sendTimeStart = simpleDateFormat.format(sendcheck.getData().getLongValue("sendTimeStart") );
        	    //现在大于设置第二天开始时间在发送
        	    if(todayNow>todayLong) {
                Calendar c = Calendar.getInstance();
                c.setTime(today);
                c.add(Calendar.DAY_OF_MONTH, 1);// 今天+1天
                Date tomorrow = c.getTime();
                String timetomorrow=formattimeToday.format(tomorrow); 
        	    String timeSendTimeStart=timetomorrow+sendTimeStart;//将时间转换成字符串
        	    
        	    long timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(timeSendTimeStart).getTime();
                message.setStartDeliverTime(timeStamp);
        	    }
          }else if(sendcheck.getStatus()==12121){
        	  //定时消息
        	  String dfd=sendcheck.getData().getString("sendtime");
        	  message.setStartDeliverTime(Long.valueOf(dfd));
        	  
          }
          
          // 发送消息，只要不抛异常就是成功
          SendResult sendResult = producer.send(message);
          String messageId = sendResult.getMessageId();
          result.setData(messageId);
      

      RocketMQProducerServiceImpl.logger.info("RocketMQProducerServiceImpl.sendMessage消息发送完成，msgId：" + messageId+"   消息的MessageKey:"+"message_rocketmq_" + messageBody.hashCode());
    } catch (ONSClientException e) {
      RocketMQProducerServiceImpl.logger.info("RocketMQProducerServiceImpl.sendMessage消息异常：" + e.getMessage());
      // 出现异常意味着发送失败，为了避免消息丢失，建议缓存该消息然后进行重试。
    } catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

    return result;
  }
  
  /**
   * 发送MQ消息service
   * 
   * @author 董争光 2018年5月20日下午2:48:19
   */
  @Override
  public ResponseData<String> sendMessageStartDeliverTime(final Producer producer, final String topic, final String tag, final byte[] messageBody) {
    RocketMQProducerServiceImpl.logger.info("RocketMQProducerServiceImpl.sendMessage:topic:" + topic + ">tag:" + tag);

    if (StringUtils.isBlank(topic) || StringUtils.isBlank(tag)) {
      RocketMQProducerServiceImpl.logger.error("RocketMQProducerServiceImpl.sendMessage:topic、tag不能为空");
    }

    ResponseData<String> result = new ResponseData<>();
    Message message = new Message(topic, tag, messageBody);
    try {
    	
        // 设置代表消息的业务关键属性，请尽可能全局唯一。
        // 以方便您在无法正常收到消息情况下，可通过阿里云服务器管理控制台查询消息并补发
        // 注意：不设置也不会影响消息正常收发
    	  
          message.setKey("message_rocketmq_" + messageBody.hashCode());
      
          // 定时消息，单位毫秒（ms），在指定时间戳（当前时间之后）进行投递，例如 2016-03-07 16:21:00 投递。如果被设置成当前时间戳之前的某个时刻，消息将立刻投递给消费者。
          Result<JSONObject> sendcheck = this.checkID( new String(messageBody));
          if(sendcheck.getStatus()==0) {
        	    Date today = new Date();
        	    SimpleDateFormat formattimeToday=new SimpleDateFormat("yyyy-MM-dd ");
        	    SimpleDateFormat format=new SimpleDateFormat("HH:mm:ss");
        	    String timeToday=formattimeToday.format(new Date());
        	    
        	    //现在时间
        	    long todayNow  = format.parse(format.format(new Date())).getTime();
        	    //停止时间
        	    long todayLong =  sendcheck.getData().getLongValue("sendTimeEnd");  
        	    
        	    //开始时间
        	    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        	    String sendTimeStart = simpleDateFormat.format(sendcheck.getData().getLongValue("sendTimeStart") );
        	    //现在大于设置第二天开始时间在发送
        	    if(todayNow>todayLong) {
                Calendar c = Calendar.getInstance();
                c.setTime(today);
                c.add(Calendar.DAY_OF_MONTH, 1);// 今天+1天
                Date tomorrow = c.getTime();
                String timetomorrow=formattimeToday.format(tomorrow); 
        	    String timeSendTimeStart=timetomorrow+sendTimeStart;//将时间转换成字符串
        	    
        	    long timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(timeSendTimeStart).getTime();
                message.setStartDeliverTime(timeStamp);
        	    }
          }
          
          // 发送消息，只要不抛异常就是成功
          SendResult sendResult = producer.send(message);
          String messageId = sendResult.getMessageId();
          result.setData(messageId);
      

      RocketMQProducerServiceImpl.logger.info("RocketMQProducerServiceImpl.sendMessage消息发送完成，msgId：" + messageId+"   消息的MessageKey:"+"message_rocketmq_" + messageBody.hashCode());
    } catch (ONSClientException e) {
      RocketMQProducerServiceImpl.logger.info("RocketMQProducerServiceImpl.sendMessage：" + e.getMessage());
      // 出现异常意味着发送失败，为了避免消息丢失，建议缓存该消息然后进行重试。
    } catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

    return result;
  }
  
  public Result<JSONObject> checkID( String messageBody) {
      logger.info(this.getClass().getName() + ".sendMessage入参：" + messageBody);

      Result<JSONObject> result = new Result<>();
      result.setStatus(1);
      JSONObject jsonObject = JSON.parseObject(messageBody);
      
      //0定时消息
      if(!(StringUtils.isBlank(jsonObject.getString("sendtype")))&&jsonObject.getString("sendtype").equals("0")) {
    	  
		    JSONObject sendtype = new JSONObject();
		    sendtype.put("sendtime", jsonObject.getString("sendtime"));
		    result.setStatus(12121);
         	result.setData(sendtype);
           return result;
      }
      
      Long sysBrandId = jsonObject.getLong("sysBrandId");
      String bussinessModuleCode = jsonObject.getString("bussinessModuleCode");
      
//     活动，优惠入账，优惠到期，积分入账
      if (null!=sysBrandId&&(bussinessModuleCode.equals(TemplateMessageTypeConstant.ACTIVITY_TEMPLATE_MESSAGE)
    		  ||bussinessModuleCode.equals(TemplateMessageTypeConstant.SMS_COUPON_RECEIVE)	
    		  ||bussinessModuleCode.equals(TemplateMessageTypeConstant.SMS_COUPON_EXPIRE)	
    		  || bussinessModuleCode.equals(TemplateMessageTypeConstant.SMS_INTEGRAL_ADD))) {
    	  RedisClient redisClient = RedisManager.getInstince();
    	  //缓存找
    	 Object sysBrandIdVal= redisClient.get("send_message_sysBrandId:"+sysBrandId);
    	 
    	  if(sysBrandIdVal==null) {
		              //如果不命中就找数据库
		   	        MsgSendTimePOExample msgSendTimePOExample  =  new MsgSendTimePOExample();
		   	        msgSendTimePOExample.createCriteria().andSysBrandIdEqualTo(sysBrandId).andValidEqualTo(true);
		   	        List<MsgSendTimePO> msgSendTimePOS  = msgSendTimePOMapper.selectByExample(msgSendTimePOExample);
		   	        if(null!=msgSendTimePOS&&msgSendTimePOS.size()>0) {
		   	        	MsgSendTimePO msgSendTimePO = msgSendTimePOS.get(0);
		   	        	result.setStatus(0);//找到有防骚扰设置
		   	        	
		   	           JSONObject jsonObjectSms = JSONObject.parseObject(JSONObject.toJSONString(msgSendTimePO));
		   	            result.setData(jsonObjectSms);
		   	        	 redisClient.set("send_message_sysBrandId:"+sysBrandId, jsonObjectSms);
		   	        }
    		      
    	  }else {
    		    JSONObject sysBrandIdVal0 = (JSONObject)sysBrandIdVal;
    		    result.setStatus(0);
 	        	result.setData(sysBrandIdVal0);
    		  
    	  }
    	  
    	  
    	  
    	  
      }
     
      return result;

  }

  /**
   * 异步发送MQ,提供回调函数，超时时间默认3s
   * 
   * @param topic
   * @param tag
   * @param messageBody
   * @param sendCallback
   * @return
   */
  @Override
  public ResponseData<Object> sendMessage(final Producer producer, final String topic, final String tag, final byte[] messageBody,
      SendCallback sendCallback) {
    return null;


  }

  /**
   * 单向发送MQ，不等待服务器回应且没有回调函数触发 适用于某些耗时非常短，但对可靠性要求并不高的场景，例如日志收集。
   * 
   * @param topic
   * @param tag
   * @param messageBody
   * @return
   */
  @Override
  public ResponseData<Object> sendOnewayMessage(final Producer producer, final String topic, final String tag, final byte[] messageBody) {
    // TODO Auto-generated method stub

    return new ResponseData<>();
  }

}
