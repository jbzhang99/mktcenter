package com.bizvane.mktcenterserviceimpl.common.report;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;


@Component
public class BaseUrl {

	@Value("${bitdata.url}")
	public  String url ;
	
	public static String staticurl ="http://47.98.194.197:8765/api/open-data-analysis/";
	public  String getLoadUrl(String method) {
		return url+method;
	}
	
 
}
