package com.bizvane.messageservice.mongo;

import com.bizvane.messageservice.common.utils.PageForm;
import com.bizvane.messagefacade.models.po.MsgSmsLogPO;
import com.bizvane.messagefacade.models.vo.GenrealGetMessageVO;
import com.bizvane.messagefacade.models.vo.SmsMessageLogVo;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MsgSmsLogPOMongoDao extends BaseMongoDao<MsgSmsLogPO> {
	
	  @Autowired
      private MsgSmsLogMongoRepository userInfoMongoRepository;
	  


   public static boolean isNumeric(String str){
	     for (int i = str.length();--i>=0;){ 
			if (!Character.isDigit(str.charAt(i))){
                return false;
		        }
		   }
	      return true;
      }

  public String saveRocketLogPO(MsgSmsLogPO msgSmsTempPO) {

	  MsgSmsLogPO item = super.insert(msgSmsTempPO);
     return item.get_id();
  }
  
  
  public void saveMsgSmsLogPOList( List<MsgSmsLogPO> msgSmsTempPO) {
       //批量插入
	   super.batchSave(msgSmsTempPO);;
  }
  
  public void updateRocketLogPO(MsgSmsLogPO msgSmsTempPO) {

	  Query query = Query.query(Criteria.where("_id").is(msgSmsTempPO.get_id()));
	  super.update(query, msgSmsTempPO);
  }
  
  public void MsgSmsLogPOBymemberPhone(MsgSmsLogPO msgSmsTempPO) {
	  
	  Criteria criteria= new Criteria();
	  criteria.andOperator(
				  Criteria.where("bussinessId").is(msgSmsTempPO.getBussinessId()),
				  Criteria.where("memberPhone").is(msgSmsTempPO.getMemberPhone())
					);

      Query findquery = new Query();
      findquery.addCriteria(criteria);
	
	  super.update(findquery, msgSmsTempPO);
  }



  public  PageInfo<MsgSmsLogPO>  getRocketLogPOList( SmsMessageLogVo msgSmsLogPO, PageForm pageForm) {
    Criteria criteria = new Criteria();
    Criteria criteriaoMemberPhone= new Criteria();
    Criteria criteriaTemplateType= new Criteria();
    Criteria criteriasendTimeStart= new Criteria();
    Criteria criteriasendTimeEnd= new Criteria();
    Criteria criteriabaseSearchValue= new Criteria();
    Criteria criteriabaseSendState= new Criteria();
    Criteria criteriabaseSysBrandId= new Criteria();
    
    if(null!=msgSmsLogPO.getSysBrandId()) {
    	criteriabaseSysBrandId= Criteria.where("sysBrandId").is(msgSmsLogPO.getSysBrandId());
    }else {
    	PageInfo<MsgSmsLogPO> saveMsgSmsLogPOList=new  PageInfo<MsgSmsLogPO>();
    	 return saveMsgSmsLogPOList;   
    }
    if(!StringUtils.isBlank(msgSmsLogPO.getMemberPhone())) {
    	criteriaoMemberPhone=Criteria.where("memberPhone").is(msgSmsLogPO.getMemberPhone());
    }
    if(!StringUtils.isBlank(msgSmsLogPO.getTemplateType())) {
    	criteriaTemplateType=Criteria.where("templateType").is(msgSmsLogPO.getTemplateType());
    }
//    
    if(null!=msgSmsLogPO.getSendTimeStart()) {
    	criteriasendTimeStart= Criteria.where("createDate").gte(msgSmsLogPO.getSendTimeStart());
    }
//    
    if(null!=msgSmsLogPO.getSendTimeEnd()) {
    	criteriasendTimeEnd= Criteria.where("createDate").lte(msgSmsLogPO.getSendTimeEnd());
    }
    
    if(null!=msgSmsLogPO.getSendState()) {
    	criteriabaseSendState= Criteria.where("sendState").is(msgSmsLogPO.getSendState());
    }
    

    //根据基本条件查询
    if(!StringUtils.isBlank(msgSmsLogPO.getBaseSearchValue())) {
    	
		MsgSmsLogPO msgSmsLog = new MsgSmsLogPO();
		
		msgSmsLog.setSysBrandId(msgSmsLogPO.getSysBrandId());
		
		ExampleMatcher matcher=null;
		String type="memberPhone";
		if(isNumeric(msgSmsLogPO.getBaseSearchValue()))
		 {
			msgSmsLog.setMemberPhone(msgSmsLogPO.getBaseSearchValue());
		}else {
			msgSmsLog.setTemplateTypeName(msgSmsLogPO.getBaseSearchValue());
			type="templateTypeName";
		}
		
		
		
	    if(null!=msgSmsLogPO.getSendState()) {
	    	msgSmsLog.setSendState(msgSmsLogPO.getSendState());
	    	
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
		Example<MsgSmsLogPO> ex = Example.of(msgSmsLog, matcher);
		
	    Pageable pageable=PageRequest.of(pageForm.getPageNum()-1, pageForm.getPageSize(), new Sort(Sort.Direction.DESC, "createDate"));
	    Page<MsgSmsLogPO> msgWxLogPOlist= userInfoMongoRepository.findAll(ex,pageable);
     	PageInfo<MsgSmsLogPO> saveMsgWxLogPOList=new  PageInfo<MsgSmsLogPO>();
     	
     	saveMsgWxLogPOList.setPageNum(pageForm.getPageNum());
     	saveMsgWxLogPOList.setPageSize(pageForm.getPageSize());
     	saveMsgWxLogPOList.setTotal(msgWxLogPOlist.getTotalElements());
     	saveMsgWxLogPOList.setList(msgWxLogPOlist.getContent());
	      return saveMsgWxLogPOList; 
		// 查询
//		List<MsgSmsLogPO> msgSmsLogPO11 = userInfoMongoRepository.findAll(ex);
		
		
//		分页

	      
	      
		
//		MsgSmsLogPO msgSmsLog2 = new MsgSmsLogPO();
//		msgSmsLog2.setTemplateTypeName(msgSmsLogPO.getBaseSearchValue());
//		msgSmsLog2.setSysBrandId(msgSmsLogPO.getSysBrandId());
//		
//		ExampleMatcher matche2=null;
//	    if(null!=msgSmsLogPO.getSendState()) {
//	    	msgSmsLog2.setSendState(msgSmsLogPO.getSendState());
//	    	
//	    	matche2 = ExampleMatcher.matching() 
//					.withMatcher("templateTypeName", GenericPropertyMatchers.regex())
//					.withMatcher("sendState", GenericPropertyMatchers.exact())
//					.withMatcher("sysBrandId", GenericPropertyMatchers.exact()); // 姓名采用“开始匹配”的方式查询
//	    }else {
//	    	matche2 = ExampleMatcher.matching() 
//					.withMatcher("templateTypeName", GenericPropertyMatchers.regex())
//					.withMatcher("sysBrandId", GenericPropertyMatchers.exact()); // 姓名采用“开始匹配”的方式查询
//	    	
//	    }
//
//		// 创建实例
//		Example<MsgSmsLogPO> ex2 = Example.of(msgSmsLog2, matche2);
//		// 查询
//		List<MsgSmsLogPO> MsgWxLogPO22 = userInfoMongoRepository.findAll(ex2);
//		msgSmsLogPO11.addAll(MsgWxLogPO22);
//		
//		// 按照时间降序：
//		Collections.sort(msgSmsLogPO11, new Comparator<MsgSmsLogPO>() {
//			@Override
//			public int compare(MsgSmsLogPO m1, MsgSmsLogPO m2) {
//				if (m1.getCreateDate().getTime() > m2.getCreateDate().getTime()) {
//					return -1;
//				}
//				if (m1.getCreateDate() == m2.getCreateDate()) {
//					return 0;
//				}
//				return 1;
//			}
//		});
//		
//		
//		List<MsgSmsLogPO> msgSmsLogPOnew =new ArrayList<MsgSmsLogPO>();
//     	PageInfo<MsgSmsLogPO> saveMsgSmsLogPOList=new  PageInfo<MsgSmsLogPO>();
//     	
//     	int a=pageForm.getPageNum()*10-10;
//     	for(int i=0;i<10;i++){
//     		if(a == msgSmsLogPO11.size()) {
//     			break; 
//     		}
//     		MsgSmsLogPO msgSmsog =msgSmsLogPO11.get(a++);
//     		
//     		msgSmsLogPOnew.add(msgSmsog);
//     		
//     	}
//     	
//     	saveMsgSmsLogPOList.setTotal(msgSmsLogPO11.size());
//     	saveMsgSmsLogPOList.setList(msgSmsLogPOnew);

		//saveMsgSmsLogPOList.getList().sort(Comparator.comparing(MsgSmsLogPO::getCreateDate));




//	      return saveMsgSmsLogPOList;   
		
//    	query.addCriteria(Criteria.where(condition.getKey()).regex(".*?\\" +condition.getValue().toString()+ ".*"));
//    	criteriabaseSearchValue.orOperator(
//	    Criteria.where("memberPhone").is(msgSmsLogPO.getBaseSearchValue()),
//	    Criteria.where("templateTypeName").is(msgSmsLogPO.getBaseSearchValue())
//		);
    } 
    
    	 criteria.andOperator(criteriabaseSearchValue,criteriaoMemberPhone,criteriaTemplateType,criteriasendTimeStart,criteriabaseSendState,criteriasendTimeEnd,criteriabaseSysBrandId);

    


         Query findquery = new Query();
         findquery.addCriteria(criteria).with(new Sort(Sort.Direction.DESC, "createDate"));
    	 PageInfo<MsgSmsLogPO> MsgSmsLogPOl=super.findPage(pageForm, findquery);
    	  return MsgSmsLogPOl;   
     
    

//     query.addCriteria(Criteria.where("memberPhone").regex("4$"));
     
//     Query query = Query.query(Criteria.where("memberPhone").regex("1"));  
//     List<MsgSmsLogPO> msgSmsLogPO1 = mongoTemplate.find(query,MsgSmsLogPO.class,"msgSmsLogPO1");
 
     
  }
  
  public  PageInfo<MsgSmsLogPO>  getReturnMessage( GenrealGetMessageVO msgSmsLogPO, Integer sendState,PageForm pageForm) {
	    Criteria criteria = new Criteria();
	    Criteria criteriaoTaskId= new Criteria();
	    Criteria criteriaTemplateType= new Criteria();
	    Criteria criteriasendTimeStart= new Criteria();
	    Criteria criteriasendTimeEnd= new Criteria();
	    Criteria criteriabaseSendState= new Criteria();
	    Criteria criteriabaseSysBrandId= new Criteria();
	    
	    if(null!=msgSmsLogPO.getSysBrandId()) {
	    	criteriabaseSysBrandId= Criteria.where("sysBrandId").is(msgSmsLogPO.getSysBrandId());
	    }else {
	    	 return null;   
	    }
	    
	    if(msgSmsLogPO.getTaskId()!=null) {
	    	criteriaoTaskId=Criteria.where("bussinessId").is(msgSmsLogPO.getTaskId().toString());
	    }

	    if(!StringUtils.isBlank(msgSmsLogPO.getTemplateType())) {
	    	criteriaTemplateType=Criteria.where("templateType").is(msgSmsLogPO.getTemplateType());
	    }
	//    
	    if(null!=msgSmsLogPO.getSendTimeStart()) {
	    	criteriasendTimeStart= Criteria.where("createDate").gte(msgSmsLogPO.getSendTimeStart());
	    }
	//    
	    if(null!=msgSmsLogPO.getSendTimeEnd()) {
	    	criteriasendTimeEnd= Criteria.where("createDate").lte(msgSmsLogPO.getSendTimeEnd());
	    }
	    
	    if(null!=sendState) {
	    	criteriabaseSendState= Criteria.where("sendState").is(sendState);
	    }
	    
	    

	    	 criteria.andOperator(criteriaoTaskId,criteriaTemplateType,criteriasendTimeStart,criteriabaseSendState,criteriasendTimeEnd,criteriabaseSysBrandId);
	    	
//	    	 criteria.andOperator(criteriabaseSysBrandId,criteriaoTaskId);


	         Query findquery = new Query();
	         findquery.addCriteria(criteria);
	    	 PageInfo<MsgSmsLogPO> MsgSmsLogPOl=super.findPage(pageForm, findquery);
	    	  return MsgSmsLogPOl;   
	     
	 
	     
	  }
}


