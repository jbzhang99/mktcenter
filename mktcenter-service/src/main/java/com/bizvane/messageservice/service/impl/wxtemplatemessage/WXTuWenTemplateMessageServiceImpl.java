package com.bizvane.messageservice.service.impl.wxtemplatemessage;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bizvane.appletservice.models.bo.ObtainGraphicBo;
import com.bizvane.appletservice.rpc.GraphicTemplateServiceRpc;
import com.bizvane.messageservice.common.constants.SysRespConstants;
import com.bizvane.messageservice.service.WXTemplateMessageService;
import com.bizvane.messageservice.service.WechatTuWenMessageLogService;
import com.bizvane.messagefacade.models.po.MsgWxTuWenPO;
import com.bizvane.messagefacade.models.vo.Result;
import com.bizvane.utils.responseinfo.ResponseData;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yunjie.tian on 2018/7/28.
 */
@Service("wXTuWenTemplateMessageServiceImpl")
public class WXTuWenTemplateMessageServiceImpl implements WXTemplateMessageService {

    private static final Logger logger = LoggerFactory.getLogger(WXTuWenTemplateMessageServiceImpl.class);
    @Autowired
    private WechatTuWenMessageLogService wechatTuWenMessageLogService;
	
	@Autowired
	private  GraphicTemplateServiceRpc graphicTemplateServiceRpc;


    /**
     * 发微信模板消息
     *
     * @param rocketMsgId
     * @param messageBody
     * @return
     */
    @Override
    public Result<String> sendMessage(String rocketMsgId, String messageBody) {
        logger.info(this.getClass().getName() + ".sendMessage入参：" + messageBody);

        Result<String> result = new Result<>();
        if (StringUtils.isBlank(messageBody)) {
            logger.error(this.getClass().getName() + ".sendMessage入参为空");
            return result;
        }

        JSONObject jsonObject = JSON.parseObject(messageBody);
    	
        // 记录发送消息日志
        MsgWxTuWenPO msgWxTuWenPO = new MsgWxTuWenPO();
        msgWxTuWenPO.setSysCompanyId(jsonObject.getLong("sysCompanyId"));
        msgWxTuWenPO.setBrandId(jsonObject.getLong("brandId"));
        msgWxTuWenPO.setTaskId(jsonObject.getString("taskId"));
        msgWxTuWenPO.setMessageId(rocketMsgId);
        
        msgWxTuWenPO.setGroupName(jsonObject.getString("groupName"));
        msgWxTuWenPO.setHeadlTitle(jsonObject.getString("headlTitle"));
        msgWxTuWenPO.setMemberSum(jsonObject.getString("memberSum"));
        
        msgWxTuWenPO.setSendState("2");
        msgWxTuWenPO.setSendStateName("发送中");
        msgWxTuWenPO.setOpenId(jsonObject.getString("openIdS"));
        
        msgWxTuWenPO.setMediaId(jsonObject.getString("mediaId"));
        msgWxTuWenPO.setMsgType(jsonObject.getString("msgType"));
        msgWxTuWenPO.setSendIgnoreReprint(jsonObject.getString("sendIgnoreReprint"));
        msgWxTuWenPO.setDataBody(jsonObject.toJSONString());

        Result<String> insertResult = this.wechatTuWenMessageLogService.insert(msgWxTuWenPO);
        
        String wechatMessageLogId = insertResult.getData();

              Result<String> sendResult = new Result<>();
        	  sendResult = this.sendMessage(wechatMessageLogId, msgWxTuWenPO);
        	  
        	  MsgWxTuWenPO updatePO = new MsgWxTuWenPO();
              updatePO.set_id(wechatMessageLogId);
              updatePO.setMessageId(wechatMessageLogId);
              updatePO.setMessageId(wechatMessageLogId);
              updatePO.setResultInfo(sendResult.getMsg());
             
              if(sendResult.getStatus()==0) {
            	  updatePO.setTaskIdData(sendResult.getData());
            	  updatePO.setSendState("0");
            	  updatePO.setSendStateName("发送成功");
            	  
            	  updatePO.setSendYesSum(msgWxTuWenPO.getMemberSum());
            	  updatePO.setSendNotSum("0");
              }else {
            	  updatePO.setSendState("1");
            	  updatePO.setSendStateName("发送失败");
            	  updatePO.setSendYesSum("0");
            	  updatePO.setSendNotSum(msgWxTuWenPO.getMemberSum());
              }
        this.wechatTuWenMessageLogService.update(updatePO);
        return result;

    }

    public Result<String> sendMessage(String wechatMessageLogId,MsgWxTuWenPO msgWxTuWenPO){
        Result<String> result = new Result<>();
        
	//        mediaId（模板id）
	//        msgType（群发的消息类型，图文消息为mpnews，文本消息为text，语音为voice，音乐为music，图片为image，视频为video，卡券为wxcard）
	//        sendIgnoreReprint（图文消息被判定为转载时，是否继续群发。 1为继续群发（转载），0为停止群发。 该参数默认为0。）
       try {

             List<String> openIdlsit =new ArrayList<String>();
             
                for(String openId : msgWxTuWenPO.getOpenId().split(",")) {
                	openIdlsit.add(openId);
                }
         
           
        ObtainGraphicBo obtainGraphicBo = new ObtainGraphicBo();
        
        obtainGraphicBo.setBrandId(msgWxTuWenPO.getBrandId());
        obtainGraphicBo.setOpenId(openIdlsit);
        obtainGraphicBo.setMediaId(msgWxTuWenPO.getMediaId());
        obtainGraphicBo.setMsgType(msgWxTuWenPO.getMsgType());
        obtainGraphicBo.setSendIgnoreReprint(msgWxTuWenPO.getSendIgnoreReprint());
        
        logger.info(this.getClass().getName() + ".sendMessage发送图文消息入参：" + JSONObject.toJSONString(obtainGraphicBo));

        ResponseData responseData=    graphicTemplateServiceRpc.groupSending(obtainGraphicBo);
        logger.info(this.getClass().getName() + ".sendMessage发送图文消息出参：" + JSONObject.toJSONString(responseData));
        
        if(responseData.getData()!=null) {
        	result.setStatus(SysRespConstants.SUCCESS.getStatus());
        	result.setData(responseData.getData().toString());
        	result.setMsg(responseData.getMessage());
        }else {
        	result.setStatus(SysRespConstants.FAILED.getStatus());
        	result.setMsg(responseData.getMessage());
        }
        
       } catch (Exception e) {
       	result.setStatus(SysRespConstants.FAILED.getStatus());
       	result.setMsg("发送异常"+e.getMessage());
       }
       
		return result;

    }
    
    
}


