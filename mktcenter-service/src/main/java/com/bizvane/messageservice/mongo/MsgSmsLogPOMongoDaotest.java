package com.bizvane.messageservice.mongo;

import com.bizvane.messageservice.common.utils.PageForm;
import com.bizvane.messagefacade.models.po.MsgSmsLogPO;
import com.bizvane.messagefacade.models.vo.SmsMessageLogVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MsgSmsLogPOMongoDaotest  {
	
	
	  @Autowired
      private MsgSmsLogMongoRepository userInfoMongoRepository;
//  


  public List<MsgSmsLogPO> getRocketLogPOList( SmsMessageLogVo msgSmsLogPO, PageForm pageForm) {
		MsgSmsLogPO msgSmsLog = new MsgSmsLogPO();
		msgSmsLog.setBussinessId("71231");
		boolean ii = userInfoMongoRepository.singleSave(msgSmsLog);
		msgSmsLog.setBussinessId("72");
		// 创建匹配器，即如何使用查询条件
		ExampleMatcher matcher = ExampleMatcher.matching() // 构建对象
				.withMatcher("bussinessId", GenericPropertyMatchers.startsWith()); // 姓名采用“开始匹配”的方式查询
//	            .withIgnorePaths("focus");  //忽略属性：是否关注。因为是基本类型，需要忽略掉

		// 创建实例
		Example<MsgSmsLogPO> ex = Example.of(msgSmsLog, matcher);
		

		// 查询
		List<MsgSmsLogPO> msgSmsLogPO11 = userInfoMongoRepository.findAll(ex);

		return null;
	
 
     
  }
  
//  public List<MsgSmsLogPO> getRocketLogPOList( SmsMessageLogVo msgSmsLogPO, PageForm pageForm) {
//	  SysSmsConfigVO msgSmsLog =new SysSmsConfigVO();
////	  msgSmsLog.setBrandName("71231");
////	  boolean ii= mongoTemplateService.singleSave(msgSmsLog);
//	  msgSmsLog.setBrandName("1");
//	    //创建匹配器，即如何使用查询条件
//	    ExampleMatcher matcher = ExampleMatcher.matching() //构建对象
//	            .withMatcher("brandName", GenericPropertyMatchers.startsWith());  //姓名采用“开始匹配”的方式查询
////	            .withIgnorePaths("focus");  //忽略属性：是否关注。因为是基本类型，需要忽略掉
//	    
//	    //创建实例
//	    Example<SysSmsConfigVO> ex = Example.of(msgSmsLog, matcher); 
//	    
//	    
//	    //查询
//	     List<SysSmsConfigVO> msgSmsLogPO11 = mongoTemplateService.findAll(ex);
//	     
//		return null;
//	
// 
//     
//  }



}



