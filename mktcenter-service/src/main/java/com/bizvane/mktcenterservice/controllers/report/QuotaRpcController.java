package com.bizvane.mktcenterservice.controllers.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.bizvane.mktcenterfacade.models.requestvo.EmpDailyback;
import com.bizvane.mktcenterfacade.models.requestvo.postvo.EmpDaily;
import com.bizvane.mktcenterservice.common.report.BaseUrl;
import com.bizvane.utils.responseinfo.ResponseData;

import lombok.extern.slf4j.Slf4j;

/**
 * @author liangzanwen
 * @date on 2018/09/18
 * @description 报表分析
 * @Copyright (c) 2018 每日 日报
 */
@Slf4j
@RestController
@RequestMapping("quotaRpc")
public class QuotaRpcController {
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private BaseUrl BaseUrl; 
	

	
    @RequestMapping("empDaily")
    public ResponseData<EmpDailyback> empDaily(@RequestBody EmpDaily sendVO){
    	 JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(sendVO));
    	 ResponseData<EmpDailyback> ResponseData =new ResponseData<EmpDailyback>();
    	 EmpDailyback empDailyback =new EmpDailyback();
    	 
      	 ResponseEntity<String> response =null;
   		try {
   			log.info("报表查询ReportIncomeController："+BaseUrl.getLoadUrl("empDaily")+jsonObject.toString());
			   //获取用户key
	   		   jsonObject.put("businessNum", BaseUrl.getBusinessNum());
	   		   jsonObject.put("apiKey", BaseUrl.getApiKey());
   		    response = this.restTemplate.postForEntity(BaseUrl.getLoadUrl("empDaily"), jsonObject,String.class, new Object[0]);
		} catch (Exception e) {
			  ResponseData.setCode(500);
		  	  ResponseData.setMessage("大数据连接异常"+e.getMessage()+BaseUrl.getLoadUrl("empDaily")+jsonObject.toString());
		  	
		  	ResponseData.setData(empDailyback);
		  	 return ResponseData;
		}
   		
	     JSONObject jobObject = JSONObject.parseObject(response.getBody());
	     if(jobObject.get("successFlag").equals("1")) {
	     JSONObject job =jobObject.getJSONObject("data");
	    	 for(Object k : job.keySet()){
	    		  empDailyback.setTime(k.toString());
	    		  JSONObject json = JSONObject.parseObject(job.get(k).toString()); 
	    		  for(Object kk : json.keySet()){

	    			  if(kk.toString().equals("storeAchievements")) {
	    				  empDailyback.setStoreAchievements(json.get(kk).toString());
	    			  }else  if(kk.toString().equals("storePercentage")) {
	    				  empDailyback.setStorePercentage(json.get(kk).toString()); 
	    			  }else  if(kk.toString().equals("empRank")) {
	    				  empDailyback.setEmpRank(json.get(kk).toString());
	    			  }else  if(kk.toString().equals("empPercentage")) {
	    				  empDailyback.setEmpPercentage(json.get(kk).toString());
	    			  }else  if(kk.toString().equals("empAchievements")) {
	    				  empDailyback.setEmpAchievements(json.get(kk).toString());
	    			  }

	    		  }
	    	 }
	     }else {
			  ResponseData.setCode(500);
		  	  ResponseData.setMessage(jobObject.getJSONObject("message").toString()+BaseUrl.getLoadUrl("empDaily")+jsonObject.toString());
		  	  ResponseData.setData(empDailyback);
	     }
	     ResponseData.setCode(0);
	     ResponseData.setMessage(BaseUrl.getLoadUrl("empDaily")+jsonObject.toString());
	     ResponseData.setData(empDailyback);
 	 return ResponseData;
   }
	
    


   
}
