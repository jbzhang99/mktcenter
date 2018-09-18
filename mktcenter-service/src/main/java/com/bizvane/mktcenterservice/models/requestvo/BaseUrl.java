package com.bizvane.mktcenterservice.models.requestvo;

public class BaseUrl {

	
//	@Value("${xxl.job.admin.addresses}")
//	private String jobAdminUrl=;
	
    public static final String url ="http://192.168.1.63:8765/api/open-data-analysis/";
    public static final String businessNum ="testbz";
    public static final String apiKey ="4199454b3cac0c02b48fd5a9c67c00c0";
	
	public static String getLoadUrl(String method) {
		return url+method;
	}
	
	public static String getBusinessNum() {
		return businessNum;
	}
	
	public static String getApiKey() {
		return apiKey;
	}
	
}
