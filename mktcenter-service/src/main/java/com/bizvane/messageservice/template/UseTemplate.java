package com.bizvane.messageservice.template;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bizvane.messageservice.common.constants.SysRespConstants;
import com.bizvane.messageservice.common.constants.TemplateMessageTypeConstant;
import com.bizvane.messageservice.common.constants.WxApiUrlConstants;
import com.bizvane.messageservice.common.utils.AsyncHttpUtil;
import com.bizvane.messageservice.common.utils.MessageSpringContextUtil;
import com.bizvane.messageservice.service.WxMessagetempService;
import com.bizvane.messagefacade.models.po.MsgWxTempPO;
import com.bizvane.messagefacade.models.vo.Result;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.wechatfacade.interfaces.WxPublicServiceFeign;
import com.bizvane.wechatfacade.models.po.WxPublicPO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 微信模板消息统一入口
 * 
 * @author 董争光 2018年5月28日下午2:27:40
 */
@Component
public class UseTemplate {

  @Autowired
  private WxMessagetempService wxMessagetempService;

  /**
   * 发送微信模板消息
   * 
   * @param templateMessageType 模板类型
   * @param openid
   * @param outdoorjo
   * @return
   * @throws Exception
   */
  public static Result<String> sendMessage(WxPublicPO wxPublicPO, String templateMessageType, String openid, JSONObject outdoorjo){
    Result<String> result = new Result<>();
    //JSONObject returnjo = new JSONObject();

    WxMessagetempService wxMessagetempService = MessageSpringContextUtil.getBean(WxMessagetempService.class);
    WxPublicServiceFeign wxPublicServiceFeign = MessageSpringContextUtil.getBean(WxPublicServiceFeign.class);
    
    
    Result<MsgWxTempPO> findTemplateResult = wxMessagetempService.findCanSendMessagetempPOByType(templateMessageType, wxPublicPO.getWxPublicId());
    if (SysRespConstants.SUCCESS.getStatus() != findTemplateResult.getStatus()) {
	if( findTemplateResult.getStatus()==310) {
	      result.setStatus(findTemplateResult.getStatus());
	      result.setMsg(SysRespConstants.WX_MESSAGETEMP_STATE_NOT_SEND.getMsg());
	}
      //同步一个模板 
      
      Result<MsgWxTempPO> findTemp = wxMessagetempService.findCanSendMessagetempPOByType(templateMessageType, 999999103L);
  	if( findTemp.getData()==null) {
	      result.setStatus(findTemplateResult.getStatus());
	      result.setMsg("固定103L模板："+SysRespConstants.WX_MESSAGETEMP_STATE_NOT_SEND.getMsg());
	}
      MsgWxTempPO findTemppo = findTemp.getData();
      JSONObject messagetemplate = new JSONObject();
      messagetemplate.put("template_id_short", findTemppo.getShortCode());
      String sendResulttemp = AsyncHttpUtil.doPost(WxApiUrlConstants.wx_add_template_url + wxPublicPO.getAppid(), messagetemplate.toString());
      JSONObject jsonObjecttemp  = JSON.parseObject(sendResulttemp);
      
        if(!(StringUtils.isBlank(jsonObjecttemp.getString("template_id")))) {
    	 //找到就更新
//        	根据品牌找到小程序！appid
        	 ResponseData<WxPublicPO> wxPublicPOBysysBrandId=wxPublicServiceFeign.selectByPrimaryKey(wxPublicPO.getWxPublicId());
        	 ResponseData<List<WxPublicPO>>wxPublicPOlist =wxPublicServiceFeign.getWxPublicListBySysBrandId(wxPublicPOBysysBrandId.getData().getSysBrandId());
        	 for(WxPublicPO wxPublic :wxPublicPOlist.getData()) {
        		 if(wxPublic.getMiniProgramType().equals("10")) {
        			 findTemppo.setExample(wxPublic.getAppid());
        		 }
        	 }
        	findTemppo.setWxTemplateId(jsonObjecttemp.getString("template_id"));
        	findTemppo.setWxPublicId(wxPublicPO.getWxPublicId());
        	findTemppo.setSysCompanyId(wxPublicPO.getSysCompanyId());
        	findTemppo.setSysBrandId(wxPublicPOBysysBrandId.getData().getSysBrandId());
        	
        	
        	 ResponseData<Object> responseData   = 	wxMessagetempService.updateMsgSmsTempById(findTemppo);
        	 
        	 if( responseData.getCode()!=SysRespConstants.SUCCESS.getStatus()) {
	              result.setStatus(responseData.getCode());
	       	      result.setMsg(responseData.getMessage()+jsonObjecttemp.toJSONString());
	       	      return result; 
        	  }
        	
        	findTemplateResult = wxMessagetempService.findCanSendMessagetempPOByType(templateMessageType, wxPublicPO.getWxPublicId());
    	  }else {//找不到模板就报错
    	      result.setStatus(findTemplateResult.getStatus());
    	      result.setMsg(findTemplateResult.getMsg()+jsonObjecttemp.toJSONString());
    	      return result;
    	  }
      
    }

    MsgWxTempPO wxMessagetempPOWithBLOBs = findTemplateResult.getData();
    String template_id = wxMessagetempPOWithBLOBs.getWxTemplateId();
    String message = wxMessagetempPOWithBLOBs.getMessage();
    String firstConfig = wxMessagetempPOWithBLOBs.getFirst();
    String remarkConfig = wxMessagetempPOWithBLOBs.getTail(); //尾部
    String appid = wxMessagetempPOWithBLOBs.getExample(); //appid
     

    // first和remark以数据库配置为主，如果数据库配置不为空，用数据库配置，否则用传入的数据
		if (StringUtils.isNotBlank(firstConfig)) {
			outdoorjo.put("first", firstConfig);
		}
		if (StringUtils.isNotBlank(remarkConfig)) {
			outdoorjo.put("remark", remarkConfig);
		}

		boolean isauthorize = false;
		String url = wxMessagetempPOWithBLOBs.getUrl();
		//如果有自定义地址就用自定义的
		if (StringUtils.isNotBlank(outdoorjo.getString("url"))) {
			url = outdoorjo.getString("url");
		}

		// 如果是活动模
		if (templateMessageType.equals(TemplateMessageTypeConstant.ACTIVITY_TEMPLATE_MESSAGE)) {
			url = outdoorjo.getString("url");
			// 定向运行用自定义模板
			if (!(StringUtils.isBlank(outdoorjo.getString("firstDY")))) {
				outdoorjo.put("first", outdoorjo.getString("firstDY"));
				outdoorjo.put("remark", outdoorjo.getString("remarkDY"));
			}
		}
      

    // 处理url
    if (StringUtils.isNotBlank(url)) {
      Pattern filp = Pattern.compile("^\\s*http", Pattern.CASE_INSENSITIVE);
      Matcher film = filp.matcher(url);
      if (film.find()) {
        isauthorize = false;
      } else {
        isauthorize = "Y".equals(wxMessagetempPOWithBLOBs.getIsauthorize());
      }
    }

    // 给模板消息详情url传参
    if (StringUtils.isNotBlank(url)) {
      url = url.replaceAll("@objid@", outdoorjo.getString("id"));
      outdoorjo.remove("id");
    }

    Set<String> set = outdoorjo.keySet();
    Iterator iterator = set.iterator();
    Pattern pattern;
    Matcher matcher;
    String regex;

    // 处理数据
    while (iterator.hasNext()) {
      String key = (String) iterator.next();
      String value = outdoorjo.getString(key);
      if (StringUtils.isBlank(value)) {
        value = "";
      }
      regex = "(\\{\\{)" + key + "(\\}\\})";
      pattern = Pattern.compile(regex);
      matcher = pattern.matcher(message);
      if (matcher.find()) {
        message = message.replaceAll(regex, value);
      }
    }


    Result<String> sendResult =
        TemplateMessage.sendTemplateMessage(wxMessagetempPOWithBLOBs.getUrl(),wxPublicPO, openid, template_id, url,outdoorjo, isauthorize,appid);

    return sendResult;
  }
}
