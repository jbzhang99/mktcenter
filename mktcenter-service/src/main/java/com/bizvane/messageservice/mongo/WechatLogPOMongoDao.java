package com.bizvane.messageservice.mongo;

import com.bizvane.messageservice.common.utils.PageForm;
import com.bizvane.messagefacade.models.po.MsgWxLogPO;
import com.bizvane.messagefacade.models.vo.WechatMessageLogVO;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class WechatLogPOMongoDao extends BaseMongoDao<MsgWxLogPO> {
	
	  @Autowired
      private MsgWxLogMongoRepository userInfoMongoRepository;

  public String saveRocketLogPO(MsgWxLogPO msgSmsTempPO) {

	  MsgWxLogPO item = super.insert(msgSmsTempPO);
      return item.get_id();
  }
  
  public void updateRocketLogPO(MsgWxLogPO msgSmsTempPO) {
	  
	  Query query = Query.query(Criteria.where("_id").is(msgSmsTempPO.get_id()));
	  super.update(query, msgSmsTempPO);
	  
  }
  public static boolean isNumeric(String str){
	     for (int i = str.length();--i>=0;){ 
			if (!Character.isDigit(str.charAt(i))){
             return false;
		        }
		   }
	      return true;
   }

  public  PageInfo<MsgWxLogPO> getRocketLogPOList( WechatMessageLogVO wechatMessageLogVO) {
    Criteria criteria = new Criteria();
    Criteria criteriaoMemberPhone= new Criteria();
    Criteria criteriaTemplateType= new Criteria();
    Criteria criteriasendTimeStart= new Criteria();
    Criteria criteriasendTimeEnd= new Criteria();
    Criteria criteriaSearchValue= new Criteria();
    Criteria criteriaSearchStatistics= new Criteria();
    Criteria criteriaOpenId= new Criteria();
    
    Criteria criteriabaseSysBrandId= new Criteria();
    
    if(null!=wechatMessageLogVO.getSysBrandId()) {
    	criteriabaseSysBrandId= Criteria.where("sysBrandId").is(wechatMessageLogVO.getSysBrandId());
    }else {
    	
    	PageInfo<MsgWxLogPO> saveMsgWxLogPOList=new  PageInfo<MsgWxLogPO>();
    	 return saveMsgWxLogPOList;   
    }
    
    if(!StringUtils.isBlank(wechatMessageLogVO.getMemberPhone())) {
    	criteriaoMemberPhone=Criteria.where("memberPhone").is(wechatMessageLogVO.getMemberPhone());
    }
    if(!StringUtils.isBlank(wechatMessageLogVO.getTemplateType())) {
    	criteriaTemplateType=Criteria.where("templateType").is(wechatMessageLogVO.getTemplateType());
    }


	  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	  try {

		if(!StringUtils.isBlank(wechatMessageLogVO.getSendTimeStart())) {

			Date timeStart = format.parse(wechatMessageLogVO.getSendTimeStart());
			criteriasendTimeStart= Criteria.where("createDate").gte(timeStart);


		}

		if(!StringUtils.isBlank(wechatMessageLogVO.getSendTimeEnd())) {
			Date timeEnd = format.parse(wechatMessageLogVO.getSendTimeEnd());
			criteriasendTimeEnd = Criteria.where("createDate").lte(timeEnd);
		}

	  }catch (Exception e){}

    if(!StringUtils.isBlank(wechatMessageLogVO.getOpenId())) {
    	criteriaOpenId= Criteria.where("openId").gte(wechatMessageLogVO.getOpenId());
    }
    if(!StringUtils.isBlank(wechatMessageLogVO.getSendState())) {
    	criteriaSearchStatistics= Criteria.where("sendState").gte(wechatMessageLogVO.getSendState());
    }
    
    
    if(!StringUtils.isBlank(wechatMessageLogVO.getSearchValue())) {
    	
    	MsgWxLogPO msgSmsLog = new MsgWxLogPO();
		msgSmsLog.setSysBrandId(wechatMessageLogVO.getSysBrandId());
		
		String type="memberPhone";
		if(isNumeric(wechatMessageLogVO.getSearchValue()))
		 {
			msgSmsLog.setMemberPhone(wechatMessageLogVO.getSearchValue());
		}else {
			msgSmsLog.setTemplateTypeName(wechatMessageLogVO.getSearchValue());
			type="templateTypeName";
		}
		
		ExampleMatcher matcher=null;
	    if(null!=wechatMessageLogVO.getSendState()) {
	    	msgSmsLog.setSendState(wechatMessageLogVO.getSendState());
	    	
			 matcher = ExampleMatcher.matching() 
					.withMatcher(type, GenericPropertyMatchers.exact())
					.withMatcher("sendState", GenericPropertyMatchers.exact())
					.withMatcher("sysBrandId", GenericPropertyMatchers.exact()); // 姓名采用“开始匹配”的方式查询
	    }else {
			 matcher = ExampleMatcher.matching() 
					.withMatcher(type, GenericPropertyMatchers.exact())
					.withMatcher("sysBrandId", GenericPropertyMatchers.exact()); // 姓名采用“开始匹配”的方式查询
	    	
	    }

		// 创建实例
		Example<MsgWxLogPO> ex = Example.of(msgSmsLog, matcher);
		
		
//		分页
	    Pageable pageable=PageRequest.of(wechatMessageLogVO.getPageNumber()-1, wechatMessageLogVO.getPageSize(), new Sort(Sort.Direction.DESC, "createDate"));
	    Page<MsgWxLogPO> MsgWxLogPOlist= userInfoMongoRepository.findAll(ex,pageable);
     	PageInfo<MsgWxLogPO> saveMsgWxLogPOList=new  PageInfo<MsgWxLogPO>();
     	
     	saveMsgWxLogPOList.setPageNum(wechatMessageLogVO.getPageNumber());
     	saveMsgWxLogPOList.setPageSize(wechatMessageLogVO.getPageSize());
     	saveMsgWxLogPOList.setTotal(MsgWxLogPOlist.getTotalElements());
     	saveMsgWxLogPOList.setList(MsgWxLogPOlist.getContent());
	      return saveMsgWxLogPOList; 

    }
    	 criteria.andOperator(criteriaSearchValue,criteriabaseSysBrandId,criteriaoMemberPhone,criteriaTemplateType,
				 criteriaOpenId,criteriaSearchStatistics,criteriasendTimeStart,criteriasendTimeEnd);


    Query findquery = new Query();
    findquery.addCriteria(criteria).with(new Sort(Sort.Direction.DESC, "createDate"));
//    findquery.skip(pageForm.getPageSize()*pageForm.getPageNum() - pageForm.getPageSize());// 从那条记录开始
//    findquery.limit(pageForm.getPageSize());// 取多少条记录
    
    PageForm pageForm =new PageForm();
    pageForm.setPageNum(wechatMessageLogVO.getPageNumber());
    pageForm.setPageSize(wechatMessageLogVO.getPageSize());
    
    PageInfo<MsgWxLogPO> MsgWxLogPOl=super.findPage(pageForm, findquery);
    
     return MsgWxLogPOl;
     
  }
}



