package com.bizvane.messageservice.service.impl.wxtemplatemessage;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bizvane.couponservice.common.system.DictHelper;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.members.facade.service.api.MemberInfoApiService;
import com.bizvane.members.facade.service.api.WxChannelInfoApiService;
import com.bizvane.members.facade.vo.MemberInfoApiModel;
import com.bizvane.members.facade.vo.WxChannelInfoVo;
import com.bizvane.messageservice.common.constants.SysRespConstants;
import com.bizvane.messageservice.common.constants.SystemConstants;
import com.bizvane.messageservice.common.constants.TemplateMessageTypeConstant;
import com.bizvane.messageservice.service.WXTemplateMessageService;
import com.bizvane.messageservice.service.WechatMessageLogService;
import com.bizvane.messageservice.template.UseTemplate;
import com.bizvane.messagefacade.models.po.MsgWxLogPO;
import com.bizvane.messagefacade.models.vo.OrderMessageVO;
import com.bizvane.messagefacade.models.vo.Result;
import com.github.pagehelper.PageInfo;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.wechatfacade.models.po.WxPublicPO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;


@Service("wXTemplateMessageOrderCancelServiceImpl")
public class WXTemplateMessageOrderCancelServiceImpl implements WXTemplateMessageService {

    private static final Logger logger = LoggerFactory.getLogger(WXTemplateMessageOrderCancelServiceImpl.class);
    @Autowired
    private WechatMessageLogService wechatMessageLogService;
    @Autowired
    private WxChannelInfoApiService wxChannelInfoApiService;
    @Autowired
    private MemberInfoApiService memberInfoApiService;


    /**
     * 发微信模板消息(订单取消)
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
        MemberInfoApiModel infoModel = new MemberInfoApiModel();
        infoModel.setPageNumber(1);
        infoModel.setPageSize(10);
        infoModel.setMemberCode(memberCode);
        ResponseData<PageInfo<MemberInfoModel>> memberResult= memberInfoApiService.getMemberInfo(infoModel);
        List<MemberInfoModel> memberList =  memberResult.getData().getList();
        if(null == memberList || memberList.size()==0){
            result.setStatus(SysRespConstants.WX_VIP_NOT_FOCUS.getStatus());
            result.setMsg(SysRespConstants.WX_VIP_NOT_FOCUS.getMsg());
            return result;
        }
        ObjectMapper mapper = new ObjectMapper();
        MemberInfoModel wxVip = mapper.convertValue(memberList.get(0), MemberInfoModel.class);

        //根据会员号查询渠道信息
        WxChannelInfoVo wxChannelInfoModel = new WxChannelInfoVo();
        wxChannelInfoModel.setMemberCode(memberCode);
        ResponseData<WxChannelInfoVo> channelResult = wxChannelInfoApiService.getWxChannelInfo(wxChannelInfoModel);
        WxChannelInfoVo channelInfoModel =channelResult.getData();
        WxChannelInfoVo channelVal = null;
        if(null!=channelInfoModel){
            channelVal = mapper.convertValue(channelInfoModel, WxChannelInfoVo.class);
        }

        if (wxVip == null) {
            result.setStatus(SysRespConstants.WX_VIP_NOT_FOCUS.getStatus());
            result.setMsg(SysRespConstants.WX_VIP_NOT_FOCUS.getMsg());
            return result;
        }

        JSONObject messagejo = new JSONObject();
        OrderMessageVO vo = jsonObject.toJavaObject(OrderMessageVO.class);
        messagejo.put("first","尊敬的会员，您的订单已取消。");
        messagejo.put("keyword1",vo.getOrderNo());
        messagejo.put("keyword2",vo.getMoney());
        messagejo.put("keyword3",vo.getDate());
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

        String openId = wxVip.getWxOpenId();
        String templateType = TemplateMessageTypeConstant.ORDER_CANCEL;

        // 记录发送内容和接收人openid，为了在发送失败时能够方便重新发送
        MsgWxLogPO wechatMessageLogPO = new MsgWxLogPO();
        wechatMessageLogPO.set_id(wechatMessageLogId);
        wechatMessageLogPO.setWxPublicId(wxVip.getWxPublicId());
        wechatMessageLogPO.setOpenId(openId);
        
        wechatMessageLogPO.setMessageBody(messagejo.toString());
        wechatMessageLogPO.setMemberName(wxVip.getName());
        wechatMessageLogPO.setMemberPhone(wxVip.getPhone());
        if(channelVal != null) {
            wechatMessageLogPO.setWxNick(channelVal.getWxNick());
        }

        this.wechatMessageLogService.update(wechatMessageLogPO);

        WxPublicPO wxPublicPO = new WxPublicPO();
        wxPublicPO.setWxPublicId(wxVip.getWxPublicId());
        // 发送模板消息
        return UseTemplate.sendMessage(wxPublicPO, TemplateMessageTypeConstant.ORDER_CANCEL, openId,
                messagejo);

    }
}



