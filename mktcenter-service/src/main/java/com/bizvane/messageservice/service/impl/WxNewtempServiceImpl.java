package com.bizvane.messageservice.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bizvane.messagefacade.interfaces.WxNewTempService;
import com.bizvane.messagefacade.models.po.MsgWxTempPO;
import com.bizvane.messagefacade.models.po.MsgWxTempPOExample;
import com.bizvane.messageservice.common.constants.SysRespConstants;
import com.bizvane.messageservice.common.constants.SystemConstants;
import com.bizvane.messageservice.common.constants.WxApiUrlConstants;
import com.bizvane.messageservice.common.utils.AsyncHttpUtil;
import com.bizvane.messageservice.mappers.MsgWxTempPOMapper;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.wechatfacade.interfaces.WxPublicServiceFeign;
import com.bizvane.wechatfacade.models.po.WxPublicPO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 获取微信模板service
 */
@Slf4j
@Service
public class WxNewtempServiceImpl implements WxNewTempService {
	
  @Autowired
  private MsgWxTempPOMapper msgWxTempPOMapper;
  
  @Autowired
  private WxPublicServiceFeign wxPublicServiceFeign;
  
  @Override
	public ResponseData<Object> getWxTemplate(Long sysBrandId) {
	    ResponseData<Object> responseData = new ResponseData<>();
	    
	    //get ACCESS_TOKEN
	    ResponseData<WxPublicPO> publicPO = wxPublicServiceFeign.getWxPublicBySysBrandId(sysBrandId);
	    if(publicPO.getData()==null) {
	    	responseData.setCode(SysRespConstants.FAILED.getStatus());
	    	responseData.setMessage("WxPublicPO是空:"+sysBrandId);
	    	return responseData;
	    }
	    
	  	ResponseData<String> ACCESS_TOKEN= wxPublicServiceFeign.getAccessTokenByAppId(publicPO.getData().getAppid());
	  	
	  	if( ACCESS_TOKEN.getCode()!=SysRespConstants.SUCCESS.getStatus()) {
		    	responseData.setCode(SysRespConstants.FAILED.getStatus());
		    	responseData.setMessage("getAppidREE:"+publicPO.getData().getAppid());
	  	   return responseData;
	  	}
	  	
		String sendResulttemp = AsyncHttpUtil.doPost(WxApiUrlConstants.wx_get_all_template_url + ACCESS_TOKEN.getData(), "");
		
		// 数据转换
		JSONArray dSONArray=JSONArray.parseArray(JSONObject.parseObject(sendResulttemp).getString("template_list"));
		JSONArray newSONArray =new JSONArray();
		if (dSONArray.size() > 0) {
			for (int i = 0; i < dSONArray.size(); i++) {
				JSONObject job = dSONArray.getJSONObject(i); // 遍历 jsonarray 数组，把每一个对象转成 json 对象
				String[] content = job.getString("content").split("\n");
				JSONObject contentJSONObject = new JSONObject();
				int sta=0;
				int end=content.length-1;
				for(String string:content) {
					if(sta!=0&&sta!=end) {
						contentJSONObject.put(String.valueOf(sta), string.substring(0, string.indexOf("：")));
					}
					sta++;
				}
				job.put("content", contentJSONObject);
				newSONArray.add(job);
			}
		}
		
		log.info("have get ACCESS_TOKEN"+JSONObject.toJSONString(sendResulttemp));
		responseData.setData(newSONArray);
	    return responseData;
	  }


	@Override
	public ResponseData<Object> saveWxTemplate(MsgWxTempPO po) {
		ResponseData<Object> responseData = new ResponseData<>();
		// 如果有就更新 没有就新建
		
		if (po.getBusinessType() == null || StringUtils.isBlank(po.getBusinessType().toString())) {
			responseData.setCode(SysRespConstants.SYSTEM_DATA_NOT_REPEAT.getStatus());
			responseData.setMessage("业务类型不能为空！");
			return responseData;
		}
		 
	   if(po.getTemplateType()==null||StringUtils.isBlank(po.getTemplateType().toString())) {
	 	      responseData.setCode(SysRespConstants.SYSTEM_DATA_NOT_REPEAT.getStatus());
		      responseData.setMessage("微信模板类型不能为空！");
	   		 return responseData;
	    }
	   
	    if(po.getStatus()==null||StringUtils.isBlank(po.getStatus().toString())) {
	  	      responseData.setCode(SysRespConstants.SYSTEM_DATA_NOT_REPEAT.getStatus());
		      responseData.setMessage("开启状态不能为空");
	    		 return responseData;
	    }
	   
	   if(po.getContent()==null||StringUtils.isBlank(po.getContent().toString())) {
	 	      responseData.setCode(SysRespConstants.SYSTEM_DATA_NOT_REPEAT.getStatus());
		      responseData.setMessage("微信模板内容不能为空！");
	   		 return responseData;
	   }

	   
	    // 根据品牌找到小程序！appid
		ResponseData<List<WxPublicPO>> wxPublicPOlist = wxPublicServiceFeign.getWxPublicListBySysBrandId(po.getSysBrandId());
		if (CollectionUtils.isEmpty(wxPublicPOlist.getData())) {
			responseData.setCode(SysRespConstants.SYSTEM_DATA_NOT_EMPTY.getStatus());
			responseData.setMessage("该品牌找不到对应的Appid");
			return responseData;
		}
	   	 
	   	 for(WxPublicPO wxPublic :wxPublicPOlist.getData()) {
	   		 if(wxPublic.getMiniProgramType().equals("10")) {
	   			po.setExample(wxPublic.getAppid());
	   			po.setWxPublicId(wxPublic.getWxPublicId());
	   		 }
	   	 }
   
	    MsgWxTempPOExample example = new MsgWxTempPOExample();
	    example.createCriteria().andSysBrandIdEqualTo(po.getSysBrandId()).andValidEqualTo(SystemConstants.TABLE_VALID_EFFECTIVE).andTemplateTypeEqualTo(po.getTemplateType());
	    List<MsgWxTempPO> messageTempPOList = msgWxTempPOMapper.selectByExample(example);
	    if(CollectionUtils.isNotEmpty(messageTempPOList)){
	    	po.setWxMessageTempId(messageTempPOList.get(0).getWxMessageTempId());
		    po.setModifiedDate(new Date());
		    msgWxTempPOMapper.updateByPrimaryKeySelective(po);
		    responseData.setData(msgWxTempPOMapper.updateByPrimaryKeySelective(po));
	    }else {
		    po.setCreateDate(new Date());
		    po.setValid(true);
		    responseData.setData(msgWxTempPOMapper.insert(po));
	    }

		return responseData;
	}

}
