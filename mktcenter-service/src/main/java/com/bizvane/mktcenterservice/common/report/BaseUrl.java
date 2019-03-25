package com.bizvane.mktcenterservice.common.report;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;


@Component
public class BaseUrl {

	@Value("${bitdata.url}")
	public  String url ;
	
	@Value("${bitdata.businessNum}")
	public  String businessNum ;
	
	@Value("${bitdata.apiKey}")
	public  String apiKey ;
	
	
//	public static String staticurl ="http://47.98.194.197:8765/api/open-data-analysis/";
//	public static String staticurl ="http://bizvane.f3322.net:58765/api/open-data-analysis/";
	public  String getLoadUrl(String method) {
		return url+method;
	}


	public String getBusinessNum() {
		return businessNum;
	}


	public void setBusinessNum(String businessNum) {
		this.businessNum = businessNum;
	}


	public String getApiKey() {
		return apiKey;
	}


	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	
	
 
}
