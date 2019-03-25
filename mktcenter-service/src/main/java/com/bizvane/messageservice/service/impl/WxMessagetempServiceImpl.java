package com.bizvane.messageservice.service.impl;

import com.bizvane.messageservice.common.constants.SysRespConstants;
import com.bizvane.messageservice.common.constants.SystemConstants;
import com.bizvane.messageservice.mappers.MsgWxTempPOMapper;
import com.bizvane.messageservice.service.WxMessagetempService;
import com.bizvane.messagefacade.models.po.MsgWxTempPO;
import com.bizvane.messagefacade.models.po.MsgWxTempPOExample;
import com.bizvane.messagefacade.models.vo.Result;
import com.bizvane.utils.responseinfo.ResponseData;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 获取微信模板service
 * 
 * @author 董争光 2018年5月28日下午2:45:55
 */
@Service
public class WxMessagetempServiceImpl implements WxMessagetempService {

  @Autowired
  private MsgWxTempPOMapper msgWxTempPOMapper;
  
  

  /**
   * 微信类型查找
   * 
    * @author 梁赞文
   */
	@Override
	public ResponseData<Object> getTemplateByType(Long sysBrandId, String businessType,String templateType) {
	    ResponseData<Object> responseData = new ResponseData<>();
	    
//	    responseData.setCode(SysRespConstants.FAILED.getStatus());
//	    if(StringUtils.isBlank(templateType)){
//	      responseData.setCode(SysRespConstants.SYSTEM_DATA_NOT_EMPTY.getStatus());
//	      responseData.setMessage(SysRespConstants.SYSTEM_DATA_NOT_EMPTY.getMsg());
//	      return responseData;
//	    }
	    MsgWxTempPOExample example = new MsgWxTempPOExample();
	    List<MsgWxTempPO> messageTempPOList=new ArrayList<MsgWxTempPO>();
	    if(templateType==null||StringUtils.isBlank(templateType)) {
		    example.createCriteria().andSysBrandIdEqualTo(sysBrandId).andBusinessTypeEqualTo(businessType).andValidEqualTo(SystemConstants.TABLE_VALID_EFFECTIVE);
		     messageTempPOList = msgWxTempPOMapper.selectByExample(example);
			      responseData.setData(messageTempPOList);
			      responseData.setCode(SysRespConstants.SUCCESS.getStatus());
			   
			  
	    }else {
		    example.createCriteria().andSysBrandIdEqualTo(sysBrandId).andValidEqualTo(SystemConstants.TABLE_VALID_EFFECTIVE).andTemplateTypeEqualTo(templateType);
		     messageTempPOList = msgWxTempPOMapper.selectByExample(example);
			    MsgWxTempPO messageTempPO = new MsgWxTempPO();
			    if(CollectionUtils.isNotEmpty(messageTempPOList)){
			      messageTempPO = messageTempPOList.get(0);
			      responseData.setCode(SysRespConstants.SUCCESS.getStatus());
			    }
			   responseData.setData(messageTempPO);
	    }
	    

	      return responseData;
	  }


	/**
	 * 更新
	 */
	@Override
	public ResponseData<Object> updateMsgSmsTempById(MsgWxTempPO po) {
	    ResponseData<Object> responseData = new ResponseData<>();
	    
	    responseData.setCode(SysRespConstants.FAILED.getStatus());
		 if(po.getBusinessType()==null||StringUtils.isBlank(po.getBusinessType().toString())) {
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
		      responseData.setMessage("短信开启状态不能为空");
	    		 return responseData;
	    }
	   
//	   if(po.getContent()==null||StringUtils.isBlank(po.getContent().toString())) {
//	 	      responseData.setCode(SysRespConstants.SYSTEM_DATA_NOT_REPEAT.getStatus());
//		      responseData.setMessage("微信模板内容不能为空！");
//	   		 return responseData;
//	   }
//	   
//	
//	   
//	   if(po.getWxMessageTempId()==null||StringUtils.isBlank(po.getWxMessageTempId().toString())) {
//	 	      responseData.setCode(SysRespConstants.SYSTEM_DATA_NOT_REPEAT.getStatus());
//		      responseData.setMessage("WxMessageTempId主键ID不能是空！");
//	   		 return responseData;
//	   }
     

   
	    MsgWxTempPOExample example = new MsgWxTempPOExample();
	    example.createCriteria().andSysBrandIdEqualTo(po.getSysBrandId()).andValidEqualTo(SystemConstants.TABLE_VALID_EFFECTIVE).andTemplateTypeEqualTo(po.getTemplateType());
	    List<MsgWxTempPO> messageTempPOList = msgWxTempPOMapper.selectByExample(example);
	    if(CollectionUtils.isNotEmpty(messageTempPOList)){
	    	po.setWxMessageTempId(messageTempPOList.get(0).getWxMessageTempId());
		    po.setModifiedDate(new Date());
		    int count = msgWxTempPOMapper.updateByPrimaryKeySelective(po);
	    	
	    }else {
	    	
		    po.setCreateDate(new Date());
		    po.setValid(true);
		    int count = msgWxTempPOMapper.insert(po);
	    }
	    

	     responseData.setCode(SysRespConstants.SUCCESS.getStatus());
	    responseData.setMessage(SysRespConstants.SUCCESS.getMsg());
	    
	    responseData.setData(po);
	    return responseData;
	  }
	
	
	/**
	 * 新建
	 */
	@Override
	public ResponseData<Object> insert(MsgWxTempPO po) {
	    ResponseData<Object> responseData = new ResponseData<>();

	    responseData.setCode(SysRespConstants.FAILED.getStatus());
	        
		 if(po.getBusinessType()==null||StringUtils.isBlank(po.getBusinessType().toString())) {
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
		      responseData.setMessage("短信开启状态不能为空");
	    		 return responseData;
	    }
	    
	    if(po.getUrl()==null||StringUtils.isBlank(po.getUrl().toString())) {
	  	      responseData.setCode(SysRespConstants.SYSTEM_DATA_NOT_REPEAT.getStatus());
		      responseData.setMessage("微信模板内容不能为空！");
	    		 return responseData;
	    }
	      

	    
//	    `sys_brand_id`  template_type和模板唯一 
	    MsgWxTempPOExample example = new MsgWxTempPOExample();
	    example.createCriteria().andSysBrandIdEqualTo(po.getSysBrandId()).andValidEqualTo(SystemConstants.TABLE_VALID_EFFECTIVE).andTemplateTypeEqualTo(po.getTemplateType());
	    List<MsgWxTempPO> messageTempPOList = msgWxTempPOMapper.selectByExample(example);
	    if(CollectionUtils.isNotEmpty(messageTempPOList)){
	    	responseData.setCode(SysRespConstants.SYSTEM_DATA_NOT_REPEAT.getStatus());
		     responseData.setMessage("该品牌的微信模板类型已经存在！不允许重复");
	    	 return responseData;
	    	
	    }
	    
	    po.setCreateDate(new Date());
	    po.setValid(true);
	    int count = msgWxTempPOMapper.insert(po);
	    if(count==0) {
		    
		    responseData.setMessage(SysRespConstants.FAILED.getMsg());
	    }else {
		    responseData.setCode(SysRespConstants.SUCCESS.getStatus());
		    responseData.setMessage(SysRespConstants.SUCCESS.getMsg());
	    }
	    responseData.setData(po);
	    return responseData;
	  }
	
	
	

  /**
   * 通过模板类型和品牌
   * 
   * @param type
   * @param wxPublicId
   * @return
   */
  @Override
  public MsgWxTempPO findMessagetempPOByType(String type, Long wxPublicId) {

	MsgWxTempPOExample example = new MsgWxTempPOExample();
    example.createCriteria().andTemplateTypeEqualTo(type).andWxPublicIdEqualTo(wxPublicId);

    List<MsgWxTempPO> list = this.msgWxTempPOMapper.selectByExample(example);

    MsgWxTempPO wxMessagetempPOWithBLOBs = null;
    if (CollectionUtils.isNotEmpty(list)) {
      wxMessagetempPOWithBLOBs = list.get(0);
    }

    return wxMessagetempPOWithBLOBs;
  }

  /**
   * 获取可发送模板消息的模板 类型和品牌找
   * 
   * @param wxPublicId
   * @return
   */
  @Override
  public Result<MsgWxTempPO> findCanSendMessagetempPOByType(String type, Long wxPublicId) {
    Result<MsgWxTempPO> result = new Result<>();

    MsgWxTempPO wxMessagetempPOWithBLOBs = this.findMessagetempPOByType(type, wxPublicId);
    if (wxMessagetempPOWithBLOBs == null) {
      result.setStatus(SysRespConstants.WX_MESSAGETEMP_NOT_EXISTS.getStatus());
      result.setMsg(SysRespConstants.WX_MESSAGETEMP_NOT_EXISTS.getMsg());
      return result;
    }
//没有用默认
//    if (StringUtils.isBlank(wxMessagetempPOWithBLOBs.getMessage())) {
//      result.setStatus(SysRespConstants.WX_MESSAGETEMP_NOT_EXISTS.getStatus());
//      result.setMsg(SysRespConstants.WX_MESSAGETEMP_NOT_EXISTS.getMsg());
//      return result;
//    }
    
    if (!SystemConstants.WECHAT_TEMPLATE_SEND_STATE_YES.equals(wxMessagetempPOWithBLOBs.getStatus())) {
      result.setStatus(SysRespConstants.WX_MESSAGETEMP_STATE_NOT_SEND.getStatus());
      result.setMsg(SysRespConstants.WX_MESSAGETEMP_STATE_NOT_SEND.getMsg());
      return result;
    }

    result.setData(wxMessagetempPOWithBLOBs);
    return result;

  }

  /**
   * 根据wx_public_id和valid查询集合
   * @return
   */
    @Override
    public List<MsgWxTempPO> findByPublicIdAndValid(Long wxPublicId,Boolean valid) {

      MsgWxTempPOExample example = new MsgWxTempPOExample();
      example.createCriteria().andWxPublicIdEqualTo(wxPublicId).andValidEqualTo(valid);

      List<MsgWxTempPO> wxMessageTempPOList = msgWxTempPOMapper.selectByExample(example);
        return wxMessageTempPOList;
    }

  /**
   * 通过主键字符串查找
   * @param temp_id_str
   * @return
   */
    @Override
    public List<MsgWxTempPO> findByIdStr(String temp_id_str) {
      List<MsgWxTempPO> wxMessageTempPOList = msgWxTempPOMapper.findByIdStr(temp_id_str);
        return wxMessageTempPOList;
    }

  /**
   * 更新信息
   * @param wxMessageTempPO
   * @param example
   */
    @Override
    public void updateWxMessageTemp(MsgWxTempPO wxMessageTempPO, MsgWxTempPOExample example) {
    	msgWxTempPOMapper.updateByExampleSelective(wxMessageTempPO,example);
    }

  /**
   * 根据id查询
   * @param wxMessageTempId
   * @return
   */
    @Override
    public MsgWxTempPO findById(long wxMessageTempId) {
    	MsgWxTempPO po = msgWxTempPOMapper.selectByPrimaryKey(wxMessageTempId);
      return po;
    }

  /**
   * 根据条件查询
   * @param example
   * @return
   */
  @Override
  public List<MsgWxTempPO> findByExample(MsgWxTempPOExample example) {
    List<MsgWxTempPO> list = msgWxTempPOMapper.selectByExample(example);
    return list;
  }

    /**
   * 根据模板id和公众号id查询模板数量
   * @param template_id
   * @param public_id
   * @return
   */
    @Override
    public long findCountByTemplateIdAndPublicId(String template_id, long public_id) {
    	MsgWxTempPOExample example = new MsgWxTempPOExample();
      example.createCriteria().andWxTemplateIdEqualTo(template_id).andWxPublicIdEqualTo(public_id);
      long count = msgWxTempPOMapper.countByExample(example);
        return count;
    }

  /**
   * 保存message_temp对象
   * @param po
   * @return
   */
  @Override
  public long saveMessageTemp(MsgWxTempPO po) {
    long id = msgWxTempPOMapper.insertSelective(po);
    return id;
  }

  /**
   * 根据id删除
   * @param wxMessageTempId
   */
    @Override
    public int deleteById(long wxMessageTempId) {
      int val = msgWxTempPOMapper.deleteByPrimaryKey(wxMessageTempId);
        return val;
    }

  /**
   * 根据条件删除
   * @param example
   * @return
   */
  @Override
  public int deleteByExample(MsgWxTempPOExample example) {
    int val = msgWxTempPOMapper.deleteByExample(example);
    return val;
  }

  /**
   * 根据short_code和public_id查询数量
   * @param short_code
   * @param public_id
   * @return
   */
  @Override
  public long findCountByShortCodeAndPublicId(String short_code, long public_id) {
	  MsgWxTempPOExample example = new MsgWxTempPOExample();
    example.createCriteria().andShortCodeEqualTo(short_code).andWxPublicIdEqualTo(public_id);
    long count = msgWxTempPOMapper.countByExample(example);
    return count;
  }

  /**
   * 根据short_code和public_id查询id
   * @param short_code
   * @param public_id
   * @return
   */
  @Override
  public Long findIdByShortCodeAndPublicId(String short_code, long public_id) {
	  MsgWxTempPOExample example = new MsgWxTempPOExample();
    example.createCriteria().andShortCodeEqualTo(short_code).andWxPublicIdEqualTo(public_id);
    List<MsgWxTempPO> po = msgWxTempPOMapper.selectByExample(example);
    if(null == po && po.size()==0){
      return null;
    }else{
      return po.get(0).getWxMessageTempId();
    }
  }


  /**
   * 根据id更新
   */
  @Override
  public ResponseData<Object> updateWxMessageIsSend(Long wxMessageTempId,Boolean issendmessage) {
    ResponseData<Object> responseData = new ResponseData<>();

    MsgWxTempPO tempPO = new MsgWxTempPO();
    tempPO.setWxMessageTempId(wxMessageTempId);
    tempPO.setIssendmessage(issendmessage);
    int count = msgWxTempPOMapper.updateByPrimaryKeySelective(tempPO);
    responseData.setData(count);
    return responseData;
  }


  /**
   * 根据id更新
   */
  @Override
  public ResponseData<Object> updateWxMessageTempById(MsgWxTempPO msgWxTempPO) {
    ResponseData<Object> responseData = new ResponseData<>();

    int count = msgWxTempPOMapper.updateByPrimaryKeySelective(msgWxTempPO);
    responseData.setData(count);
    return responseData;
  }

  /**
   * 根据publicId和shortCode查找集合
   * @param public_id
   * @param opentm207128229
   * @return
   */
    @Override
    public List<MsgWxTempPO> findByPublicIdAndShortCode(Long public_id, String opentm207128229) {
    	MsgWxTempPOExample example = new MsgWxTempPOExample();
        example.createCriteria().andWxPublicIdEqualTo(public_id).andShortCodeEqualTo("opentm207128229");
        List<MsgWxTempPO> poList = msgWxTempPOMapper.selectByExample(example);
        return poList;
    }

  /**
   * 根据类型type和publicId查询数据
   * @param templateMessageType
   * @param wxPublicId
   * @return
   */
    @Override
    public List<MsgWxTempPO> findByTypeAndPublicId(String templateMessageType, long wxPublicId) {
    	MsgWxTempPOExample example = new MsgWxTempPOExample();
      example.createCriteria().andBusinessTypeEqualTo(templateMessageType).andWxPublicIdEqualTo(wxPublicId);
      List<MsgWxTempPO> list = msgWxTempPOMapper.selectByExample(example);
        return list;
    }

  /**
   * 查询不同的模板
   * @param public_id
   * @return
   */
  @Override
  public List<MsgWxTempPO> findBypublicDiff(long public_id) {
    List<MsgWxTempPO> poList = msgWxTempPOMapper.findBypublicDiff(public_id);
    return poList;
  }

  /**
   * 根据模板类型查询微信模板消息
   * @param businessType
   * @return
   */
    @Override
    public ResponseData<Object> getTemplateByType(String businessType) {
      ResponseData<Object> responseData = new ResponseData<>();
      if(StringUtils.isBlank(businessType)){
        responseData.setCode(SysRespConstants.SYSTEM_DATA_NOT_EMPTY.getStatus());
        responseData.setMessage(SysRespConstants.SYSTEM_DATA_NOT_EMPTY.getMsg());
        return responseData;
      }
      MsgWxTempPOExample example = new MsgWxTempPOExample();
      example.createCriteria().andBusinessTypeEqualTo(businessType).andValidEqualTo(SystemConstants.TABLE_VALID_EFFECTIVE);
      List<MsgWxTempPO> messageTempPOList = msgWxTempPOMapper.selectByExample(example);
      MsgWxTempPO messageTempPO = null;
      if(CollectionUtils.isNotEmpty(messageTempPOList)){
        messageTempPO = messageTempPOList.get(0);
      }
      responseData.setData(messageTempPO);
        return responseData;
    }


/* (non-Javadoc)
 * @see WxMessagetempService#updateMsgSmsTempById(com.bizvane.messagefacade.models.po.MsgSmsTempPO)
 */


}
