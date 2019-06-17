package com.bizvane.messageservice.service.impl.wxtemplatemessage;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bizvane.couponservice.common.system.DictHelper;
import com.bizvane.messageservice.common.constants.SysRespConstants;
import com.bizvane.messageservice.common.constants.SystemConstants;
import com.bizvane.messageservice.common.constants.TemplateMessageTypeConstant;
import com.bizvane.messageservice.service.WXTemplateMessageService;
import com.bizvane.messageservice.service.WechatMessageLogService;
import com.bizvane.messageservice.service.WxPublicService;
import com.bizvane.messageservice.service.WxStoreService;
import com.bizvane.messageservice.template.UseTemplate;
import com.bizvane.messagefacade.models.po.MsgWxLogPO;
import com.bizvane.messagefacade.models.po.WxPublicPO;
import com.bizvane.messagefacade.models.po.WxStorePO;
import com.bizvane.messagefacade.models.po.WxVipPO;
import com.bizvane.messagefacade.models.vo.Result;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

/**
 * 发送电子小票微信模板消息
 * 
 * @author 董争光 2018年5月28日下午2:20:46
 */
@Service("wXTemplateMessageOfflineTradeServiceImpl")
public class WXTemplateMessageOfflineTradeServiceImpl implements WXTemplateMessageService {

  private static final Logger logger = LoggerFactory.getLogger(WXTemplateMessageOfflineTradeServiceImpl.class);

  @Autowired
  private WxPublicService wxPublicService;

  @Autowired
  private WxStoreService wxStoreService;

  @Autowired
  private UseTemplate useTemplate;

  @Autowired
  private WechatMessageLogService wechatMessageLogService;

  private static final String nullStr = "~!@#$%&*";

  /**
   * 发微信模板消息
   */
  @Override
  public Result<String> sendMessage(String rocketMsgId, String messageBody) {
    WXTemplateMessageOfflineTradeServiceImpl.logger.info(this.getClass().getName() + ".sendMessage入参：" + messageBody);
    Result<String> result = new Result<>();
    if (StringUtils.isBlank(messageBody)) {
      WXTemplateMessageOfflineTradeServiceImpl.logger.error(this.getClass().getName() + ".sendMessage入参为空");
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

  public Result<String> sendMessage(String wechatMessageLogId, JSONObject jsonObject) {
    Result<String> result = new Result<>();

    String corpCode = jsonObject.getString("CORP_ID");
    String erpid = jsonObject.getString("VIP_ID");
    if (StringUtils.isBlank(erpid) || StringUtils.isBlank(corpCode)) {
      result.setStatus(SysRespConstants.WX_MESSAGETEMP_USER_INFO_NOT_EMPTY.getStatus());
      result.setMsg(SysRespConstants.WX_MESSAGETEMP_USER_INFO_NOT_EMPTY.getMsg());
      return result;
    }

    List<WxPublicPO> wxPublicList = this.wxPublicService.getWxPublicPOListByCorpCode(corpCode);
    if (CollectionUtils.isEmpty(wxPublicList)) {
      result.setStatus(SysRespConstants.WX_PUBLIC_NOT_EXISTS.getStatus());
      result.setMsg(SysRespConstants.WX_PUBLIC_NOT_EXISTS.getMsg());
      return result;
    }

    // 获取公众号和会员信息
    WxPublicPO wxPublicPO = null;
    WxVipPO wxVipPO = null;
    for (WxPublicPO po : wxPublicList) {
      /*List<WxVipPO> wxVipPOList = this.wxVipService.getWxVipPOListByErpId(erpid, po.getAdClientId());*/
      
      List<WxVipPO> wxVipPOList = null; 
      if (CollectionUtils.isNotEmpty(wxVipPOList)) {
        for (WxVipPO item : wxVipPOList) {
          if (SystemConstants.WECHAT_VIP_FOCUS_STATE_YES.equals(item.getIsfocus())) {
            wxVipPO = item;
            wxPublicPO = po;
            break;
          }
        }
      }
      
      if (wxVipPO != null) {
        break;
      }
    }

    if (wxVipPO == null) {
      result.setStatus(SysRespConstants.WX_VIP_NOT_FOCUS.getStatus());
      result.setMsg(SysRespConstants.WX_VIP_NOT_FOCUS.getMsg());
      return result;
    }

    Long wxPublicId = wxVipPO.getWxPublicId();

    String erpStoreId = jsonObject.getString("STORE_ID");
    if (StringUtils.isBlank(erpStoreId)) {
      result.setStatus(SysRespConstants.WX_STORE_NOT_EMPTY.getStatus());
      result.setMsg(SysRespConstants.WX_STORE_NOT_EMPTY.getMsg());
      return result;
    }

    // 获取erp门店信息
    String storename = "";
    List<WxStorePO> list = this.wxStoreService.getWxStorePOListByErpStoreId(erpStoreId, wxPublicId);
    if (CollectionUtils.isEmpty(list)) {
      result.setStatus(SysRespConstants.WX_VIP_NOT_FOCUS.getStatus());
      result.setMsg(SysRespConstants.WX_VIP_NOT_FOCUS.getMsg());
      return result;
    }
    for (WxStorePO wxStorePO : list) {
      storename = storename + wxStorePO.getName();
    }

    if (StringUtils.isBlank(storename)) {
      result.setStatus(SysRespConstants.WX_VIP_NOT_FOCUS.getStatus());
      result.setMsg(SysRespConstants.WX_VIP_NOT_FOCUS.getMsg());
      return result;
    }

    String time = jsonObject.getString("T_BL");
    if (StringUtils.isBlank(time)) {
      time = jsonObject.getString("T_CR");
    }

    // String total = jo.optString("TOTALT");
    double total = jsonObject.getDoubleValue("TOTALT");
    if (total <= 0) {
      result.setStatus(SysRespConstants.SYSTEM_AMOUNT_NOT_NEGATIVE.getStatus());
      result.setMsg(SysRespConstants.SYSTEM_AMOUNT_NOT_NEGATIVE.getMsg());
      return result;
    }

    String points = jsonObject.getString("POINTS");
    String pointsMessage = "";
    if (StringUtils.isNotBlank(points) && !WXTemplateMessageOfflineTradeServiceImpl.nullStr.equals(points)) {
      pointsMessage = "积分余额：" + points + "\\\\n";
    }

    JSONObject messagejo = new JSONObject();
    messagejo.put("first", "您好，您已成功支付。");
    messagejo.put("keyword1", storename);
    messagejo.put("keyword2", jsonObject.getString("ORDER_ID"));
    messagejo.put("keyword3", total);
    messagejo.put("keyword4", time);
    messagejo.put("isreplaceremark", "Y");
    messagejo.put("remark", pointsMessage + "感谢您的光临，祝您购物愉快！");

    // json数据中value为空时，转字符串后key也会去除，重发时会有问题，这里做个转换，如果value为空，用" "代替
    Iterator iterator = messagejo.keySet().iterator();
    while (iterator.hasNext()) {
      String key = (String) iterator.next();
      String value = messagejo.getString(key);
      if (StringUtils.isBlank(value)) {
        value = " ";
        messagejo.put(key, value);
      }
    }

    WXTemplateMessageOfflineTradeServiceImpl.logger.info("tempate message :" + messagejo.toString());

    String openId = wxVipPO.getOpenid();
    String templateType = TemplateMessageTypeConstant.ORDER_OFFLINE_CONSUME;

    // 记录发送内容和接收人openid，为了在发送失败时能够方便重新发送
    MsgWxLogPO wechatMessageLogPO = new MsgWxLogPO();
    wechatMessageLogPO.set_id(wechatMessageLogId);
    wechatMessageLogPO.setWxPublicId(wxPublicId);
    wechatMessageLogPO.setOpenId(openId);
    
    wechatMessageLogPO.setMessageBody(messagejo.toString());

    this.wechatMessageLogService.update(wechatMessageLogPO);

    // 发送模板消息
    return UseTemplate.sendMessage(null, TemplateMessageTypeConstant.ORDER_OFFLINE_CONSUME, openId,
        messagejo);

  }

}
