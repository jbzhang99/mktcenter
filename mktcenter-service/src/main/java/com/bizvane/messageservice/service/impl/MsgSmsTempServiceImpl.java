package com.bizvane.messageservice.service.impl;

import com.bizvane.messageservice.common.constants.SysRespConstants;
import com.bizvane.messageservice.common.constants.SystemConstants;
import com.bizvane.messageservice.mappers.MsgMenuPlaceHolderRelPOMapper;
import com.bizvane.messageservice.mappers.MsgSmsTempPOMapper;
import com.bizvane.messageservice.service.MsgSmsTempService;
import com.bizvane.messagefacade.models.po.MsgMenuPlaceHolderRelPO;
import com.bizvane.messagefacade.models.po.MsgSmsTempPO;
import com.bizvane.messagefacade.models.po.MsgSmsTempPOExample;
import com.bizvane.utils.responseinfo.ResponseData;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 短信模板信息service
 * 
 * @author 梁赞文
 */
@Service
public class MsgSmsTempServiceImpl implements MsgSmsTempService {

  @Autowired
  private MsgSmsTempPOMapper msgSmsTempPOMapper;
  
  @Autowired
  private MsgMenuPlaceHolderRelPOMapper msgMenuPlaceHolderRelPOMapper;
//  
//  @Autowired
//  private MsgSmsTempPOMapper msgSmsTempPOMapper;
  
  
  

  /**
   * 短信类型查找
   * 
    * @author 梁赞文
   */
	@Override
	public ResponseData<Object> getTemplateByType(Long sysBrandId,String businessType ,String templateType) {
	    ResponseData<Object> responseData = new ResponseData<>();
	    
	    responseData.setCode(SysRespConstants.FAILED.getStatus());
	    
	    
	    MsgSmsTempPOExample example = new MsgSmsTempPOExample();
	    List<MsgSmsTempPO> messageTempPOList=new ArrayList<MsgSmsTempPO>();
	    if(templateType==null||StringUtils.isBlank(templateType)) {
		    example.createCriteria().andSysBrandIdEqualTo(sysBrandId).andBusinessTypeEqualTo(businessType).andValidEqualTo(SystemConstants.TABLE_VALID_EFFECTIVE);
		     messageTempPOList = msgSmsTempPOMapper.selectByExample(example);
			    	 responseData.setData(messageTempPOList);
			      responseData.setCode(SysRespConstants.SUCCESS.getStatus());
			  
		    
	    }else {
		    example.createCriteria().andSysBrandIdEqualTo(sysBrandId).andValidEqualTo(SystemConstants.TABLE_VALID_EFFECTIVE).andTemplateTypeEqualTo(templateType);
		     messageTempPOList = msgSmsTempPOMapper.selectByExample(example);
			    
			    MsgSmsTempPO messageTempPO = new MsgSmsTempPO() ;
			    if(CollectionUtils.isNotEmpty(messageTempPOList)){
			      messageTempPO = messageTempPOList.get(0);
			      responseData.setCode(SysRespConstants.SUCCESS.getStatus());
			      responseData.setData(messageTempPO);
			    }else {
			    	responseData.setData(messageTempPOList);
			    }
			   
	    }

	      return responseData;
	  }
	
	
	
	@Override
	public ResponseData<List<MsgSmsTempPO>> getQyTemplateByType(Long sysBrandId,String businessType ,String templateType) {
	    ResponseData<List<MsgSmsTempPO>> responseData = new ResponseData<>();
	    
	    responseData.setCode(SysRespConstants.FAILED.getStatus());
	    
	    MsgSmsTempPOExample example = new MsgSmsTempPOExample();
	    List<MsgSmsTempPO> messageTempPOList=new ArrayList<MsgSmsTempPO>();

		     example.createCriteria().andSysBrandIdEqualTo(sysBrandId).andValidEqualTo(SystemConstants.TABLE_VALID_EFFECTIVE).andBusinessTypeEqualTo(businessType);
		     messageTempPOList = msgSmsTempPOMapper.selectByExample(example);
			    
			    /*MsgSmsTempPO messageTempPO = new MsgSmsTempPO() ;
			    if(CollectionUtils.isNotEmpty(messageTempPOList)){
			      messageTempPO = messageTempPOList.get(0);
			      responseData.setCode(SysRespConstants.SUCCESS.getStatus());
			      responseData.setData(messageTempPO.getContent());
			    }else {
			    	responseData.setData("找不到到模板");
			    }*/

			responseData.setData(messageTempPOList);
	      return responseData;
	  }
	
	  /**
	   * 短信类型查找
	   * 
	    * @author 梁赞文
	   */
		@Override
		public ResponseData<Object> findBytemplateType(String templateType) {
		    ResponseData<Object> responseData = new ResponseData<>();
		    
		    responseData.setCode(SysRespConstants.FAILED.getStatus());
		    if(StringUtils.isBlank(templateType)){
		      responseData.setCode(SysRespConstants.SYSTEM_DATA_NOT_EMPTY.getStatus());
		      responseData.setMessage(SysRespConstants.SYSTEM_DATA_NOT_EMPTY.getMsg());
		      return responseData;
		    }
		    List<MsgMenuPlaceHolderRelPO> messageTempPOList = msgMenuPlaceHolderRelPOMapper.findBytemplateType(templateType);
		    
		    
		    List<String>  namelist =new ArrayList<>();
		    if(CollectionUtils.isNotEmpty(messageTempPOList)){
		    	for(MsgMenuPlaceHolderRelPO msgMenuPlaceHolderRelPO : messageTempPOList) {
		    		namelist.add(msgMenuPlaceHolderRelPO.getMenuName());
		    	}
		      responseData.setCode(SysRespConstants.SUCCESS.getStatus());
		      responseData.setData(namelist);
		      return responseData;
		    }
		    responseData.setData(null);
		      return responseData;
		  }



	/**
	 * 更新
	 */
	@Override
	public ResponseData<Object> updateMsgSmsTempById(MsgSmsTempPO po) {
	    ResponseData<Object> responseData = new ResponseData<>();
	    
	    responseData.setCode(SysRespConstants.FAILED.getStatus());
//	    `sys_brand_id`  template_type和模板唯一 
		 if(po.getBusinessType()==null||StringUtils.isBlank(po.getBusinessType().toString())) {
	  	      responseData.setCode(SysRespConstants.SYSTEM_DATA_NOT_REPEAT.getStatus());
		      responseData.setMessage("业务类型不能为空！");
	    		 return responseData;
	    }
   
	   if(po.getTemplateType()==null||StringUtils.isBlank(po.getTemplateType().toString())) {
	 	      responseData.setCode(SysRespConstants.SYSTEM_DATA_NOT_REPEAT.getStatus());
		      responseData.setMessage("短信模板类型不能为空！");
	   		 return responseData;
	    }
	   
	   if(po.getStatus()==null||StringUtils.isBlank(po.getStatus().toString())) {
	 	      responseData.setCode(SysRespConstants.SYSTEM_DATA_NOT_REPEAT.getStatus());
		      responseData.setMessage("短信开启状态不能为空");
	   		 return responseData;
	   }
	   
	   if(po.getContent()==null||StringUtils.isBlank(po.getContent().toString())) {
	 	      responseData.setCode(SysRespConstants.SYSTEM_DATA_NOT_REPEAT.getStatus());
		      responseData.setMessage("短信模板内容不能为空！");
	   		 return responseData;
	   }
	   
	   if(po.getSendWxmember()==null||StringUtils.isBlank(po.getSendWxmember().toString())) {
	 	      responseData.setCode(SysRespConstants.SYSTEM_DATA_NOT_REPEAT.getStatus());
		      responseData.setMessage("0.全部发送 1.向微信会员发送短信2.向非微信会员发送短信,内容不能为空！");
	   		 return responseData;
	   }
	   
	   if(po.getMsgSmsTempId()==null||StringUtils.isBlank(po.getMsgSmsTempId().toString())) {
	 	      responseData.setCode(SysRespConstants.SYSTEM_DATA_NOT_REPEAT.getStatus());
		      responseData.setMessage("msgSmsTempId主键ID不能是空！");
	   		 return responseData;
	   }
     
	
   
	    MsgSmsTempPOExample example = new MsgSmsTempPOExample();
	    example.createCriteria().andSysBrandIdEqualTo(po.getSysBrandId()).andValidEqualTo(SystemConstants.TABLE_VALID_EFFECTIVE).andTemplateTypeEqualTo(po.getTemplateType());
	    List<MsgSmsTempPO> messageTempPOList = msgSmsTempPOMapper.selectByExample(example);
	    if(CollectionUtils.isNotEmpty(messageTempPOList)){
	    	if(!(messageTempPOList.get(0).getMsgSmsTempId().equals(po.getMsgSmsTempId()))) {
	  	      responseData.setCode(SysRespConstants.SYSTEM_DATA_NOT_REPEAT.getStatus());
		      responseData.setMessage("该品牌的短信模板类型已经存在！不允许重复");
	    		 return responseData;
	    	}
	    	
	    }
	    
	    po.setModifiedDate(new Date());
	    int count = msgSmsTempPOMapper.updateByPrimaryKeySelective(po);
	    if(count==0) {
		    responseData.setCode(SysRespConstants.FAILED.getStatus());
		    responseData.setMessage(SysRespConstants.FAILED.getMsg());
	    }else {
		    responseData.setCode(SysRespConstants.SUCCESS.getStatus());
		    responseData.setMessage(SysRespConstants.SUCCESS.getMsg());
	    	
	    }
	    responseData.setData(po);
	    return responseData;
	  }
	
	
	/**
	 * 新建
	 */
	@Override
	public ResponseData<Object> insert(MsgSmsTempPO po) {
	    ResponseData<Object> responseData = new ResponseData<>();

	    responseData.setCode(SysRespConstants.FAILED.getStatus());
	        
		 if(po.getBusinessType()==null||StringUtils.isBlank(po.getBusinessType().toString())) {
		  	      responseData.setCode(SysRespConstants.SYSTEM_DATA_NOT_REPEAT.getStatus());
			      responseData.setMessage("业务类型不能为空！");
		    		 return responseData;
		 }
	    
	    if(po.getTemplateType()==null||StringUtils.isBlank(po.getTemplateType().toString())) {
	  	      responseData.setCode(SysRespConstants.SYSTEM_DATA_NOT_REPEAT.getStatus());
		      responseData.setMessage("短信模板类型不能为空！");
	    		 return responseData;
	     }
	    
	    if(po.getStatus()==null||StringUtils.isBlank(po.getStatus().toString())) {
	  	      responseData.setCode(SysRespConstants.SYSTEM_DATA_NOT_REPEAT.getStatus());
		      responseData.setMessage("短信开启状态不能为空");
	    		 return responseData;
	    }
	    
	    if(po.getContent()==null||StringUtils.isBlank(po.getContent().toString())) {
	  	      responseData.setCode(SysRespConstants.SYSTEM_DATA_NOT_REPEAT.getStatus());
		      responseData.setMessage("短信模板内容不能为空！");
	    		 return responseData;
	    }
	    
	    if(po.getSendWxmember()==null||StringUtils.isBlank(po.getSendWxmember().toString())) {
	  	      responseData.setCode(SysRespConstants.SYSTEM_DATA_NOT_REPEAT.getStatus());
		      responseData.setMessage("0.全部发送 1.向微信会员发送短信2.向非微信会员发送短信,内容不能为空！");
	    		 return responseData;
	    }
	      
	    

	    
//	    `sys_brand_id`  template_type和模板唯一 
	    MsgSmsTempPOExample example = new MsgSmsTempPOExample();
	    example.createCriteria().andSysBrandIdEqualTo(po.getSysBrandId()).andValidEqualTo(SystemConstants.TABLE_VALID_EFFECTIVE).andTemplateTypeEqualTo(po.getTemplateType());
	    List<MsgSmsTempPO> messageTempPOList = msgSmsTempPOMapper.selectByExample(example);
	    if(CollectionUtils.isNotEmpty(messageTempPOList)){
		     responseData.setMessage("该品牌的短信模板类型已经存在！不允许重复");
	    	 return responseData;
	    	
	    }
	    
	    po.setCreateDate(new Date());
	    int count = msgSmsTempPOMapper.insert(po);
	    if(count==0) {
		    
		    responseData.setMessage(SysRespConstants.FAILED.getMsg());
	    }else {
		    responseData.setCode(SysRespConstants.SUCCESS.getStatus());
		    responseData.setMessage(SysRespConstants.SUCCESS.getMsg());
	    }
	    responseData.setData(po);
	    return responseData;
	  }
	
	
	}
