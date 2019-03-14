package com.bizvane.messageservice.service.impl.wxtemplatemessage;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bizvane.members.facade.models.WxChannelInfoModel;
import com.bizvane.members.facade.service.api.WxChannelInfoApiService;
import com.bizvane.members.facade.vo.WxChannelInfoVo;
import com.bizvane.members.facade.vo.WxChannelRelationVo;
import com.bizvane.messageservice.common.constants.SysRespConstants;
import com.bizvane.messageservice.common.constants.SystemConstants;
import com.bizvane.messageservice.common.constants.TemplateMessageTypeConstant;
import com.bizvane.messageservice.common.utils.DictHelper;
import com.bizvane.messageservice.service.WXTemplateMessageService;
import com.bizvane.messageservice.service.WechatMessageLogService;
import com.bizvane.messageservice.template.UseTemplate;
import com.bizvane.messagefacade.models.po.MsgWxLogPO;
import com.bizvane.messagefacade.models.vo.MemberMessageVO;
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
@Service("wXTemplateMessageMemberRegisterServiceImpl")
public class WXTemplateMessageMemberRegisterServiceImpl implements WXTemplateMessageService {

    private static final Logger logger = LoggerFactory.getLogger(WXTemplateMessageMemberRegisterServiceImpl.class);
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
        insertPO.setTemplateType(jsonObject.getString("bussinessModuleCode"));
        insertPO.setTemplateTypeName(DictHelper.getDict("template_type_wechat", jsonObject.getString("bussinessModuleCode")).getItemCodeName());
        insertPO.setRocketMsgId(rocketMsgId);
        insertPO.setResultInfo("发送中");if(!(StringUtils.isBlank(jsonObject.getString("sysBrandId")))){insertPO.setSysBrandId(jsonObject.getLong("sysBrandId"));}if(!(StringUtils.isBlank(jsonObject.getString("memberPhone")))){insertPO.setMemberPhone(jsonObject.getString("memberPhone"));}
        insertPO.setBussinessId(bussinessId);
        insertPO.setDataBody(messageBody);

        Result<String> insertResult = this.wechatMessageLogService.insert(insertPO);
        
        String wechatMessageLogId = insertResult.getData();

        Result<String> sendResult = this.sendMessage(wechatMessageLogId, jsonObject);
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
        MemberMessageVO integralMessageVO = jsonObject.toJavaObject(MemberMessageVO.class);
        messagejo.put("first","尊敬的会员，您已成功注册成为"+integralMessageVO.getBrandName()+"会员");
        
        messagejo.put("keyword1",integralMessageVO.getCardNumber());//会员卡号
        messagejo.put("keyword2",integralMessageVO.getNowLevelMember());//会员等级
        messagejo.put("keyword3",integralMessageVO.getStoresName());//入会门店
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        messagejo.put("keyword4",formatter.format(integralMessageVO.getDate()));//当前时间
        messagejo.put("remark","感谢您的支持");

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
        wxPublicPO.setWxPublicId(wxChannelInfoVip.getPublicId());ResponseData<String> Stringkey= wxPublicServiceFeign.getAccessTokenByAppId(wxChannelInfoVip.getAppId());wxPublicPO.setAppid(Stringkey.getData());
        // 记录发送内容和接收人openid，为了在发送失败时能够方便重新发送
        // 发送模板消息
        return UseTemplate.sendMessage(wxPublicPO, TemplateMessageTypeConstant.MEMEBER_REGISTER, openId,
                messagejo);

    }
}


