package com.bizvane.messageservice.service.impl.wxtemplatemessage;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bizvane.couponservice.common.system.DictHelper;
import com.bizvane.members.facade.models.WxChannelInfoModel;
import com.bizvane.members.facade.service.api.WxChannelInfoApiService;
import com.bizvane.members.facade.vo.WxChannelInfoVo;
import com.bizvane.members.facade.vo.WxChannelRelationVo;
import com.bizvane.messageservice.common.constants.SysRespConstants;
import com.bizvane.messageservice.common.constants.SystemConstants;
import com.bizvane.messageservice.common.constants.TemplateMessageTypeConstant;
import com.bizvane.messageservice.service.WXTemplateMessageService;
import com.bizvane.messageservice.service.WechatMessageLogService;
import com.bizvane.messageservice.template.UseTemplate;
import com.bizvane.messagefacade.models.po.MsgWxLogPO;
import com.bizvane.messagefacade.models.vo.ActivityMessageVO;
import com.bizvane.messagefacade.models.vo.Result;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.wechatfacade.interfaces.WxPublicServiceFeign;
import com.bizvane.wechatfacade.models.po.WxPublicPO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Iterator;

/**
 * Created by yunjie.tian on 2018/7/28.
 */
@Service("wXTemplateMessageServiceImpl")
public class WXTemplateMessageServiceImpl implements WXTemplateMessageService {

    private static final Logger logger = LoggerFactory.getLogger(WXTemplateMessageServiceImpl.class);
    @Autowired
    private WechatMessageLogService wechatMessageLogService;
    @Autowired
    private WxChannelInfoApiService wxChannelInfoApiService;
	@Autowired
	private WxPublicServiceFeign wxPublicServiceFeign;


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
        String bussinessId = jsonObject.getString("rocketMQBussinessId");

        // 记录发送消息日志
        MsgWxLogPO insertPO = new MsgWxLogPO();
        if(!(StringUtils.isBlank(jsonObject.getString("templateType")))&&jsonObject.getString("templateType").equals("TASK_TEMPLATE_MESSAGE")){
            insertPO.setTemplateType("TASK_TEMPLATE_MESSAGE");
            insertPO.setTemplateTypeName("任务消息提醒");
        }else if(!(StringUtils.isBlank(jsonObject.getString("templateType")))&&jsonObject.getString("templateType").equals("RED_TEMPLATE_MESSAGE")){
            insertPO.setTemplateType("RED_TEMPLATE_MESSAGE");
            insertPO.setTemplateTypeName("红包面额升级");
        }else {
            insertPO.setTemplateType(jsonObject.getString("bussinessModuleCode"));
            insertPO.setTemplateTypeName(DictHelper.getDict("template_type_wechat", jsonObject.getString("bussinessModuleCode")).getItemCodeName());
        }
        
        insertPO.setRocketMsgId(rocketMsgId);
        insertPO.setResultInfo("发送中");if(!(StringUtils.isBlank(jsonObject.getString("sysBrandId")))){insertPO.setSysBrandId(jsonObject.getLong("sysBrandId"));}if(!(StringUtils.isBlank(jsonObject.getString("memberPhone")))){insertPO.setMemberPhone(jsonObject.getString("memberPhone"));}
        insertPO.setBussinessId(bussinessId);
        insertPO.setDataBody(messageBody);

        Result<String> insertResult = this.wechatMessageLogService.insert(insertPO);
        
        String wechatMessageLogId = insertResult.getData();

//        Result<String> sendResult = this.sendMessage(wechatMessageLogId, jsonObject);
        Result<String> sendResult = new Result<>();
        if(!(StringUtils.isBlank(jsonObject.getString("templateType")))&&jsonObject.getString("templateType").equals("TASK_TEMPLATE_MESSAGE")){
        	  sendResult = this.sendMessage(wechatMessageLogId, jsonObject);
        }else if(!(StringUtils.isBlank(jsonObject.getString("templateType")))&&jsonObject.getString("templateType").equals("RED_TEMPLATE_MESSAGE")){
        	 sendResult = this.sendMessageRed(wechatMessageLogId, jsonObject);
        }else if(!(StringUtils.isBlank(jsonObject.getString("sendtype")))){
        	//根据openId发
        	 sendResult = this.sendDingXiangMessageHuoDong(wechatMessageLogId, jsonObject);
        } else{
        	
        	 String openId = jsonObject.getString("openId");
        	 
        	 if(StringUtils.isBlank(openId)){
        		 sendResult = this.sendMessage(wechatMessageLogId, jsonObject);
        	 }else {
        		 //如果openId不是空就根据openId 那
        		 sendResult = this.sendMessageHuoDong(wechatMessageLogId, jsonObject);
			}
        	  
        	
        }
        String messageId = null;
        String resultInfo = null;
        String sendState = SystemConstants.WECHAT_MESSAGE_LOG_SEND_STATE_FAIL;
        if (SysRespConstants.SUCCESS.getStatus() == sendResult.getStatus()) {
            sendState = SystemConstants.WECHAT_MESSAGE_LOG_SEND_STATE_SUCCESS;
            resultInfo = sendResult.getData();
            messageId = String.valueOf(JSON.parseObject(resultInfo).getLong("msgid"));
        } else {
            resultInfo = sendResult.getMsg();
        }

        MsgWxLogPO updatePO = new MsgWxLogPO();
        updatePO.set_id(wechatMessageLogId);
        updatePO.setMessageId(messageId);
        updatePO.setResultInfo(resultInfo);
        updatePO.setSendState(sendState);

        this.wechatMessageLogService.update(updatePO);
        return result;

    }

    public Result<String> sendMessage(String wechatMessageLogId, JSONObject jsonObject){
        Result<String> result = new Result<>();
        String memberCode = jsonObject.getString("memberCode");

        if(StringUtils.isBlank(memberCode)){
            result.setStatus(SysRespConstants.WX_MESSAGETEMP_USER_INFO_NOT_EMPTY.getStatus());
            result.setMsg(SysRespConstants.WX_MESSAGETEMP_USER_INFO_NOT_EMPTY.getMsg());
            return result;
        }

        //根据会员号查询会员信息
        Long sysCompanyId = jsonObject.getLongValue("sysCompanyId");
        Long brandId = jsonObject.getLongValue("sysBrandId");
        WxChannelRelationVo wxChannelRelationVo = new WxChannelRelationVo();
        wxChannelRelationVo.setMemberCode(memberCode);
        wxChannelRelationVo.setSysCompanyId(sysCompanyId);
        wxChannelRelationVo.setBrandId(brandId);wxChannelRelationVo.setMiniProgram(1);
        ResponseData<WxChannelInfoModel> memberResult= wxChannelInfoApiService.getWxChannelInfoRelation(wxChannelRelationVo);
        WxChannelInfoModel wxChannelInfoVip =  memberResult.getData();
        if(null == wxChannelInfoVip){
            result.setStatus(SysRespConstants.WX_VIP_NOT_FOCUS.getStatus());
            result.setMsg(SysRespConstants.WX_VIP_NOT_FOCUS.getMsg());
            return result;
        }

        //根据会员号查询会员信息
        ObjectMapper mapper = new ObjectMapper();

        //根据会员号查询渠道信息
        WxChannelInfoVo wxChannelInfoModel = new WxChannelInfoVo();
        wxChannelInfoModel.setMemberCode(memberCode);
        ResponseData<WxChannelInfoVo> channelResult = wxChannelInfoApiService.getWxChannelInfo(wxChannelInfoModel);
        WxChannelInfoVo channelInfoModel =channelResult.getData();
        WxChannelInfoVo channelVal = null;
        if(null!=channelInfoModel){
            channelVal = mapper.convertValue(channelInfoModel, WxChannelInfoVo.class);
        }



        JSONObject messagejo = new JSONObject();
        ActivityMessageVO integralMessageVO = jsonObject.toJavaObject(ActivityMessageVO.class);
        messagejo.put("first","尊敬的会员，活动微信发送");
        messagejo.put("keyword1",integralMessageVO.getActivityName());//活动名称
        messagejo.put("keyword2",integralMessageVO.getActivityInterests());//活动结果
        if(!(StringUtils.isBlank(jsonObject.getString("activityLongtime")))||StringUtils.isBlank(jsonObject.getString("activityStartDate")))
        {
        	  messagejo.put("keyword3","长期有效");//赞助商家
        }else {
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
        messagejo.put("keyword3",formatter.format(integralMessageVO.getActivityStartDate())+"-"+formatter.format(integralMessageVO.getActivityEndDate()));//活动时间
        } 
        messagejo.put("keyword4",integralMessageVO.getSysBrandName());//赞助商家

        messagejo.put("remark","感谢您的支持");
        messagejo.put("url",jsonObject.getString("unl"));

        Iterator iterator = messagejo.keySet().iterator();
        while (iterator.hasNext()){
            String key = (String) iterator.next();
            String value = messagejo.getString(key);
            if(StringUtils.isBlank(value)){
                value = " ";
            }
            messagejo.put(key,value);
        }

        logger.info("tempate message :" + messagejo.toString());

        // 记录发送内容和接收人openid，为了在发送失败时能够方便重新发送
        String openId = wxChannelInfoVip.getOpenId();
        MsgWxLogPO wechatMessageLogPO = new MsgWxLogPO();
        wechatMessageLogPO.set_id(wechatMessageLogId);
        wechatMessageLogPO.setWxPublicId(wxChannelInfoVip.getPublicId());
        wechatMessageLogPO.setOpenId(openId);
        
        wechatMessageLogPO.setMessageBody(messagejo.toString());
        wechatMessageLogPO.setMemberName(channelInfoModel.getName());
        if(channelVal != null) {
            wechatMessageLogPO.setWxNick(channelVal.getWxNick());
        }
        this.wechatMessageLogService.update(wechatMessageLogPO);

        WxPublicPO wxPublicPO = new WxPublicPO();
        wxPublicPO.setWxPublicId(wxChannelInfoVip.getPublicId());
        ResponseData<String> Stringkey= wxPublicServiceFeign.getAccessTokenByAppId(wxChannelInfoVip.getAppId());
        wxPublicPO.setAppid(Stringkey.getData());
        // 记录发送内容和接收人openid，为了在发送失败时能够方便重新发送
        // 发送模板消息
        return UseTemplate.sendMessage(wxPublicPO, TemplateMessageTypeConstant.ACTIVITY_TEMPLATE_MESSAGE, openId,
                messagejo);

    }
    
    public Result<String> sendMessageRed(String wechatMessageLogId, JSONObject jsonObject){
        Result<String> result = new Result<>();
        String memberCode = jsonObject.getString("memberCode");

        if(StringUtils.isBlank(memberCode)){
            result.setStatus(SysRespConstants.WX_MESSAGETEMP_USER_INFO_NOT_EMPTY.getStatus());
            result.setMsg(SysRespConstants.WX_MESSAGETEMP_USER_INFO_NOT_EMPTY.getMsg());
            return result;
        }

        //根据会员号查询会员信息
        Long sysCompanyId = jsonObject.getLongValue("sysCompanyId");
        Long brandId = jsonObject.getLongValue("sysBrandId");
        WxChannelRelationVo wxChannelRelationVo = new WxChannelRelationVo();
        wxChannelRelationVo.setMemberCode(memberCode);
        wxChannelRelationVo.setSysCompanyId(sysCompanyId);
        wxChannelRelationVo.setBrandId(brandId);wxChannelRelationVo.setMiniProgram(1);
        ResponseData<WxChannelInfoModel> memberResult= wxChannelInfoApiService.getWxChannelInfoRelation(wxChannelRelationVo);
        WxChannelInfoModel wxChannelInfoVip =  memberResult.getData();
        if(null == wxChannelInfoVip){
            result.setStatus(SysRespConstants.WX_VIP_NOT_FOCUS.getStatus());
            result.setMsg(SysRespConstants.WX_VIP_NOT_FOCUS.getMsg());
            return result;
        }

        //根据会员号查询会员信息
        ObjectMapper mapper = new ObjectMapper();

        //根据会员号查询渠道信息
        WxChannelInfoVo wxChannelInfoModel = new WxChannelInfoVo();
        wxChannelInfoModel.setMemberCode(memberCode);
        ResponseData<WxChannelInfoVo> channelResult = wxChannelInfoApiService.getWxChannelInfo(wxChannelInfoModel);
        WxChannelInfoVo channelInfoModel =channelResult.getData();
        WxChannelInfoVo channelVal = null;
        if(null!=channelInfoModel){
            channelVal = mapper.convertValue(channelInfoModel, WxChannelInfoVo.class);
        }



        JSONObject messagejo = new JSONObject();
        ActivityMessageVO integralMessageVO = jsonObject.toJavaObject(ActivityMessageVO.class);
        messagejo.put("first","有好友帮你助力啦，红包面额升级！");
        messagejo.put("keyword1",integralMessageVO.getActivityName());//活动名称
        messagejo.put("keyword2",integralMessageVO.getActivityInterests());//活动结果-人数
        messagejo.put("remark","快去拆红包吧~");
        messagejo.put("url",jsonObject.getString("unl"));

        Iterator iterator = messagejo.keySet().iterator();
        while (iterator.hasNext()){
            String key = (String) iterator.next();
            String value = messagejo.getString(key);
            if(StringUtils.isBlank(value)){
                value = " ";
            }
            messagejo.put(key,value);
        }

        logger.info("tempate message :" + messagejo.toString());

        // 记录发送内容和接收人openid，为了在发送失败时能够方便重新发送
        String openId = wxChannelInfoVip.getOpenId();
        MsgWxLogPO wechatMessageLogPO = new MsgWxLogPO();
        wechatMessageLogPO.set_id(wechatMessageLogId);
        wechatMessageLogPO.setWxPublicId(wxChannelInfoVip.getPublicId());
        wechatMessageLogPO.setOpenId(openId);
        
        wechatMessageLogPO.setMessageBody(messagejo.toString());
        wechatMessageLogPO.setMemberName(channelInfoModel.getName());
        if(channelVal != null) {
            wechatMessageLogPO.setWxNick(channelVal.getWxNick());
        }
        this.wechatMessageLogService.update(wechatMessageLogPO);

        WxPublicPO wxPublicPO = new WxPublicPO();
        wxPublicPO.setWxPublicId(wxChannelInfoVip.getPublicId());
        ResponseData<String> Stringkey= wxPublicServiceFeign.getAccessTokenByAppId(wxChannelInfoVip.getAppId());
        wxPublicPO.setAppid(Stringkey.getData());
        // 记录发送内容和接收人openid，为了在发送失败时能够方便重新发送
        // 发送模板消息
        return UseTemplate.sendMessage(wxPublicPO, TemplateMessageTypeConstant.RED_TEMPLATE_MESSAGE, openId,
                messagejo);

    }
    
    //活动场景发送模板
    public Result<String> sendMessageHuoDong(String wechatMessageLogId, JSONObject jsonObject){
        Result<String> result = new Result<>();
    

        //根据会员号查询会员信息
//        Long sysCompanyId = jsonObject.getLongValue("sysCompanyId");
//        Long brandId = jsonObject.getLongValue("sysBrandId");
//        WxChannelRelationVo wxChannelRelationVo = new WxChannelRelationVo();
//        wxChannelRelationVo.setMemberCode(memberCode);
//        wxChannelRelationVo.setSysCompanyId(sysCompanyId);
//        wxChannelRelationVo.setBrandId(brandId);wxChannelRelationVo.setMiniProgram(1);
//        ResponseData<WxChannelInfoModel> memberResult= wxChannelInfoApiService.getWxChannelInfoRelation(wxChannelRelationVo);
//        WxChannelInfoModel wxChannelInfoVip =  memberResult.getData();
        
        WxChannelInfoVo wxChannelInfoVo=new WxChannelInfoVo();
        String openId = jsonObject.getString("openId");
        wxChannelInfoVo.setWxOpenId(openId);
        
        ResponseData<WxChannelInfoVo>  wxChannelInfoVonew =  wxChannelInfoApiService.getWxChannelInfo(wxChannelInfoVo);
        
        if(null == wxChannelInfoVonew.getData()){
            result.setStatus(SysRespConstants.WX_VIP_NOT_FOCUS.getStatus());
            result.setMsg(SysRespConstants.WX_VIP_NOT_FOCUS.getMsg());
            return result;
        }
        WxChannelInfoVo wxChannelInfoVip =  wxChannelInfoVonew.getData();
        


        //根据会员号查询会员信息
//        ObjectMapper mapper = new ObjectMapper();
//
//        //根据会员号查询渠道信息
//        WxChannelInfoVo wxChannelInfoModel = new WxChannelInfoVo();
//        wxChannelInfoModel.setMemberCode(memberCode);
//        ResponseData<WxChannelInfoVo> channelResult = wxChannelInfoApiService.getWxChannelInfo(wxChannelInfoModel);
//        WxChannelInfoVo channelInfoModel =channelResult.getData();
//        WxChannelInfoVo channelVal = null;
//        if(null!=channelInfoModel){
//            channelVal = mapper.convertValue(channelInfoModel, WxChannelInfoVo.class);
//        }



        JSONObject messagejo = new JSONObject();
        ActivityMessageVO integralMessageVO = jsonObject.toJavaObject(ActivityMessageVO.class);
        messagejo.put("first","尊敬的会员，活动微信发送");
        messagejo.put("keyword1",integralMessageVO.getActivityName());//活动名称
        messagejo.put("keyword2",integralMessageVO.getActivityInterests());//活动结果
        if(!(StringUtils.isBlank(jsonObject.getString("activityLongtime")))||StringUtils.isBlank(jsonObject.getString("activityStartDate")))
        {
        	  messagejo.put("keyword3","长期有效");//赞助商家
        }else {
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
        messagejo.put("keyword3",formatter.format(integralMessageVO.getActivityStartDate())+"-"+formatter.format(integralMessageVO.getActivityEndDate()));//活动时间
        } 
        messagejo.put("keyword4",integralMessageVO.getSysBrandName());//赞助商家

        messagejo.put("remark","感谢您的支持");
        messagejo.put("url",jsonObject.getString("unl"));
        Iterator iterator = messagejo.keySet().iterator();
        while (iterator.hasNext()){
            String key = (String) iterator.next();
            String value = messagejo.getString(key);
            if(StringUtils.isBlank(value)){
                value = " ";
            }
            messagejo.put(key,value);
        }

        logger.info("tempate message :" + messagejo.toString());

        // 记录发送内容和接收人openid，为了在发送失败时能够方便重新发送
        MsgWxLogPO wechatMessageLogPO = new MsgWxLogPO();
        wechatMessageLogPO.set_id(wechatMessageLogId);
        wechatMessageLogPO.setWxPublicId(wxChannelInfoVip.getWxPublicId());
        wechatMessageLogPO.setOpenId(openId);
        
        wechatMessageLogPO.setMessageBody(messagejo.toString());
        
        
        String memberName = jsonObject.getString("memberName");
        
        wechatMessageLogPO.setMemberName(memberName);
        wechatMessageLogPO.setWxNick(wxChannelInfoVip.getWxNick());
        this.wechatMessageLogService.update(wechatMessageLogPO);

        WxPublicPO wxPublicPO = new WxPublicPO();
        wxPublicPO.setWxPublicId(wxChannelInfoVip.getWxPublicId());
        ResponseData<String> Stringkey= wxPublicServiceFeign.getAccessTokenByAppId(wxChannelInfoVip.getAppId());
        wxPublicPO.setAppid(Stringkey.getData());
        // 记录发送内容和接收人openid，为了在发送失败时能够方便重新发送
        // 发送模板消息
        return UseTemplate.sendMessage(wxPublicPO, TemplateMessageTypeConstant.ACTIVITY_TEMPLATE_MESSAGE, openId,
                messagejo);

    }
    
    
    //活动场景发送模板
    public Result<String> sendDingXiangMessageHuoDong(String wechatMessageLogId, JSONObject jsonObject){
        Result<String> result = new Result<>();
    

        
        Long sysCompanyId = jsonObject.getLongValue("sysCompanyId");
        Long brandId = jsonObject.getLongValue("sysBrandId");
        String memberCode = jsonObject.getString("memberCode");
        
        WxChannelRelationVo wxChannelRelationVo = new WxChannelRelationVo();
        wxChannelRelationVo.setMemberCode(memberCode);
        wxChannelRelationVo.setSysCompanyId(sysCompanyId);
        wxChannelRelationVo.setBrandId(brandId);wxChannelRelationVo.setMiniProgram(1);
        ResponseData<WxChannelInfoModel> wxChannelInfoVonew= wxChannelInfoApiService.getWxChannelInfoRelation(wxChannelRelationVo);
        
        
        
        
        
        if(null == wxChannelInfoVonew.getData()){
            result.setStatus(SysRespConstants.WX_VIP_NOT_FOCUS.getStatus());
            result.setMsg(SysRespConstants.WX_VIP_NOT_FOCUS.getMsg());
            return result;
        }
        
        WxChannelInfoModel wxChannelInfoVip =  wxChannelInfoVonew.getData();
        


        JSONObject messagejo = new JSONObject();
        ActivityMessageVO integralMessageVO = jsonObject.toJavaObject(ActivityMessageVO.class);
        messagejo.put("firstDY",integralMessageVO.getNavigation());
        messagejo.put("keyword1",integralMessageVO.getActivityName());//活动名称
        messagejo.put("keyword2",integralMessageVO.getActivityInterests());//活动结果
        messagejo.put("keyword3",integralMessageVO.getActivitytime());//活动时间
        messagejo.put("keyword4",integralMessageVO.getBusinessman());//赞助商家
        messagejo.put("remarkDY",integralMessageVO.getRemark());
        messagejo.put("url",jsonObject.getString("unl"));
        
        
        Iterator iterator = messagejo.keySet().iterator();
        while (iterator.hasNext()){
            String key = (String) iterator.next();
            String value = messagejo.getString(key);
            if(StringUtils.isBlank(value)){
                value = " ";
            }
            messagejo.put(key,value);
        }

        logger.info("tempate message :" + messagejo.toString());

        // 记录发送内容和接收人openid，为了在发送失败时能够方便重新发送
        MsgWxLogPO wechatMessageLogPO = new MsgWxLogPO();
        wechatMessageLogPO.set_id(wechatMessageLogId);
        wechatMessageLogPO.setWxPublicId(wxChannelInfoVip.getPublicId());
        wechatMessageLogPO.setOpenId(wxChannelInfoVip.getOpenId());
        
        wechatMessageLogPO.setMessageBody(messagejo.toString());
        
        
        String memberName = jsonObject.getString("memberName");
        
        wechatMessageLogPO.setMemberName(memberName);
        wechatMessageLogPO.setWxNick(wxChannelInfoVip.getWxNick());
        this.wechatMessageLogService.update(wechatMessageLogPO);

        WxPublicPO wxPublicPO = new WxPublicPO();
        wxPublicPO.setWxPublicId(wxChannelInfoVip.getPublicId());
        ResponseData<String> Stringkey= wxPublicServiceFeign.getAccessTokenByAppId(wxChannelInfoVip.getAppId());
        wxPublicPO.setAppid(Stringkey.getData());
        // 记录发送内容和接收人openid，为了在发送失败时能够方便重新发送
        // 发送模板消息
        return UseTemplate.sendMessage(wxPublicPO, TemplateMessageTypeConstant.ACTIVITY_TEMPLATE_MESSAGE, wxChannelInfoVip.getOpenId(),
                messagejo);

    }
}


