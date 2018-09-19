package com.bizvane.mktcenterservice.models.requestvo;

public class ReBase {
    
    private   String  businessNum;	//调用商家编号	String	12	Y
    private  String  apiKey;	//APIkey	String	64	Y
    private String  corpId;	//查询企业编号	String	12	Y
    
    public ReBase() {  
    	this.businessNum=BaseUrl.businessNum;
    	this.apiKey=BaseUrl.apiKey;
    	
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
	public String getCorpId() {
		return corpId;
	}
	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}


    
    
    
}
