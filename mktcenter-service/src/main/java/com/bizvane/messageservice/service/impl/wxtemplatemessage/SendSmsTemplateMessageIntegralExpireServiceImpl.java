package com.bizvane.messageservice.service.impl.wxtemplatemessage;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bizvane.centercontrolservice.models.po.SysSmsConfigPo;
import com.bizvane.centercontrolservice.rpc.SysSmsConfigServiceRpc;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.members.facade.service.api.MemberInfoApiService;
import com.bizvane.members.facade.service.api.WxChannelInfoApiService;
import com.bizvane.members.facade.vo.MemberInfoApiModel;
import com.bizvane.members.facade.vo.WxChannelInfoVo;
import com.bizvane.messageservice.common.constants.SysRespConstants;
import com.bizvane.messageservice.common.constants.TemplateMessageTypeConstant;
import com.bizvane.messageservice.common.utils.DictHelper;
import com.bizvane.messageservice.service.SendSmsPublicMessageService;
import com.bizvane.messageservice.service.SendSmsTemplateMessageService;
import com.bizvane.messageservice.service.WechatMessageLogService;
import com.bizvane.messageservice.template.UseTemplate;
import com.bizvane.messagefacade.interfaces.SendCommonMessageFeign;
import com.bizvane.messagefacade.models.po.MsgWxLogPO;
import com.bizvane.messagefacade.models.vo.CouponMessageVO;
import com.bizvane.messagefacade.models.vo.Result;
import com.bizvane.messagefacade.models.vo.SysSmsConfigVO;
import com.bizvane.utils.enumutils.SysResponseEnum;
import com.github.pagehelper.PageInfo;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.wechatfacade.models.po.WxPublicPO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author 张迪
 * 
 * @优惠券短信发送接口消费rocketmq消息进行短信的发送
 */
@Service("sendSmsTemplateMessageIntegralExpireServiceImpl")
public class SendSmsTemplateMessageIntegralExpireServiceImpl implements SendSmsTemplateMessageService {

    private static final Logger logger = LoggerFactory.getLogger(SendSmsTemplateMessageIntegralExpireServiceImpl.class);
    @Autowired
    private WechatMessageLogService wechatMessageLogService;
    @Autowired
    private WxChannelInfoApiService wxChannelInfoApiService;
    
    @Autowired
    private MemberInfoApiService memberInfoApiService;

    
    @Autowired
    private SysSmsConfigServiceRpc sysSmsConfigServiceRpc;
    
    @Autowired
    private SendCommonMessageFeign sendCommonMessage;
    
    @Autowired
    private SendSmsPublicMessageService SendSmsPublicMessageService;

    /**
     * @消费rocketmq短信发送(积分短信消息)
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
  	            result.setStatus(SysRespConstants.SYSTEM_DATA_NOT_EMPTY.getStatus());
  		         result.setMsg(SysRespConstants.SYSTEM_DATA_NOT_EMPTY.getMsg());
  		         return result;
  	        }
  	        
  	        JSONObject jsonObject = JSON.parseObject(messageBody);
  	        
  	        //判断手机号
  	        if(StringUtils.isBlank(jsonObject.getString("phone"))){
  	        	 logger.error(jsonObject.getString("phone") + "手机号为空");
  	        	 result.setStatus(SysRespConstants.SENDSMS_PHONE_NOT_EMPTY.getStatus());
  		         result.setMsg(SysRespConstants.SENDSMS_PHONE_NOT_EMPTY.getMsg());
  		         return result;
  	        }
  	        
  	        if(StringUtils.isBlank(jsonObject.getLong("sysBrandId").toString())){
  	        	 logger.error("sysBrandId不能为空========================");
  	        	 result.setStatus(SysRespConstants.SYSTEM_DATA_NOT_EMPTY.getStatus());
  		         result.setMsg(SysRespConstants.SYSTEM_DATA_NOT_EMPTY.getMsg());
  		         return result;
  	        }
	        
	
	        String bussinessId = jsonObject.getString("rocketMQBussinessId");
	
	        // 记录发送消息日志
	        MsgWxLogPO insertPO = new MsgWxLogPO();
	        insertPO.setTemplateType(jsonObject.getString("bussinessModuleCode").replace("SMS_",""));
	        insertPO.setTemplateTypeName(DictHelper.getDict("template_type_sms", jsonObject.getString("bussinessModuleCode").replace("SMS_","")).getItemCodeName());
	        if(!(StringUtils.isBlank(jsonObject.getString("memberPhone")))){insertPO.setMemberPhone(jsonObject.getString("memberPhone"));}
	        insertPO.setRocketMsgId(rocketMsgId);insertPO.setResultInfo("发送中");if(!(StringUtils.isBlank(jsonObject.getString("sysBrandId")))){insertPO.setSysBrandId(jsonObject.getLong("sysBrandId"));}if(!(StringUtils.isBlank(jsonObject.getString("memberPhone")))){insertPO.setMemberPhone(jsonObject.getString("memberPhone"));};
	        insertPO.setBussinessId(bussinessId);
	        insertPO.setDataBody(messageBody);
	
	        Result<String> insertResult = this.wechatMessageLogService.insert(insertPO);
	        
	        String wechatMessageLogId = insertResult.getData();
	//        Long wechatMessageLogId = insertResult.getData();
	
	        //获取短信通道 sysBrandId
	        Long sysBrandId = jsonObject.getLong("sysBrandId");
	        List<SysSmsConfigPo> listsyssmsconfiglist= sysSmsConfigServiceRpc.getByBrandIdSmsConfigList(sysBrandId);
	        ObjectMapper mapper = new ObjectMapper();
	        //获取短信通道信息
	        ResponseData<Integer> results = new ResponseData<Integer>(SysResponseEnum.FAILED.getCode(),SysResponseEnum.FAILED.getMessage(),null);
	        if(StringUtils.isNotBlank(listsyssmsconfiglist.toString())){
	        	//SysSmsConfigVO syssmsconfigvo = mapper.convertValue(listsyssmsconfiglist.get(0), SysSmsConfigVO.class);
	        	SysSmsConfigVO syssmsconfigvo = new SysSmsConfigVO();
	        	//赋值短信通道的账号密码
	        	syssmsconfigvo.setChannel(listsyssmsconfiglist.get(0).getChannel());
	        	syssmsconfigvo.setChannelName(listsyssmsconfiglist.get(0).getChannelName());
	        	syssmsconfigvo.setChannelAccount(listsyssmsconfiglist.get(0).getChannelAccount());
	        	syssmsconfigvo.setChannelPassword(listsyssmsconfiglist.get(0).getChannelPassword());
	        	syssmsconfigvo.setChannelService(listsyssmsconfiglist.get(0).getChannelService());
	        	//替换数据
	        	String Content = SendSmsPublicMessageService.GetReplaceContent(jsonObject);
	        			
	        	syssmsconfigvo.setMsgContent(Content);
	        	//手机号码
	        	syssmsconfigvo.setPhone(jsonObject.getString("phone"));
	        //	syssmsconfigvo.setCountryCode(jsonObject.getString("countryCode")); //区号
	        	results =  sendCommonMessage.sendSmg(syssmsconfigvo);
	        	logger.info("results===================================="+results.toString());
	        	if(results.getCode()==0){
	        		logger.info("优惠券短信发送成功===================================="+results.toString());
	        		//表示发送成功
	        		 result.setStatus(SysRespConstants.SUCCESS.getStatus());
			         result.setMsg(SysRespConstants.SUCCESS.getMsg());
			         return result;
	        	}else{
	        		logger.info("优惠券短信发送成功===================================="+results.toString());
	        		 result.setStatus(SysRespConstants.FAILED.getStatus());
			         result.setMsg(SysRespConstants.FAILED.getMsg());
			         return result;
	        	}
	        }
    	} catch (Exception e) {
    		e.printStackTrace();
    		logger.info("SendSmsTemplateMessageCouponServiceImpl====="+e.getMessage().toString());
    	}
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
        infoModel.setMemberCode(memberCode);
        ResponseData<PageInfo<MemberInfoModel>> memberResult= memberInfoApiService.getMemberInfo(infoModel);
        ArrayList memberList = (ArrayList) memberResult.getData().getList();
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
        //根据品牌id查询短信通道
        

        if (wxVip == null) {
            result.setStatus(SysRespConstants.WX_VIP_NOT_FOCUS.getStatus());
            result.setMsg(SysRespConstants.WX_VIP_NOT_FOCUS.getMsg());
            return result;
        }

        JSONObject messagejo = new JSONObject();
        CouponMessageVO couponMessageVO = jsonObject.toJavaObject(CouponMessageVO.class);
        messagejo.put("first","尊敬的会员，您有一张优惠券刚刚被使用。");
        messagejo.put("keyword1",couponMessageVO.getCouponName());
        messagejo.put("keyword2",couponMessageVO.getPreferentialType());
        messagejo.put("keyword3",couponMessageVO.getDenomination());
        messagejo.put("keyword4",couponMessageVO.getUseTime());
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
        String templateType = TemplateMessageTypeConstant.COUPON_ONLINE_USE;

        // 记录发送内容和接收人openid，为了在发送失败时能够方便重新发送
        MsgWxLogPO wechatMessageLogPO = new MsgWxLogPO();
        wechatMessageLogPO.set_id(wechatMessageLogId);
        wechatMessageLogPO.setWxPublicId(wxVip.getWxPublicId());
        wechatMessageLogPO.setOpenId(openId);
        
        wechatMessageLogPO.setMessageBody(messagejo.toString());
        wechatMessageLogPO.setMemberName(wxVip.getName());
        wechatMessageLogPO.setMemberPhone(wxVip.getPhone());
//        if(channelVal != null) {
//            wechatMessageLogPO.setWxNick(channelVal.getWxNick());
//        }

        this.wechatMessageLogService.update(wechatMessageLogPO);

        WxPublicPO wxPublicPO = new WxPublicPO();
        wxPublicPO.setWxPublicId(wxVip.getWxPublicId());
        // 发送模板消息
        return UseTemplate.sendMessage(wxPublicPO, TemplateMessageTypeConstant.COUPON_ONLINE_USE, openId,
                messagejo);

    }
}
