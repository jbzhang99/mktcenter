package com.bizvane.mktcenterservice.models.requestvo;

public class ReBase {
    
    private   String  businessNum;	//调用商家编号	String	12	Y
    private  String  apiKey;	//APIkey	String	64	Y
    private String  corpId;	//查询企业编号	String	12	Y
    
    private String postTem ;//导出：export,请求数据：getdata
    
    
    private String organizationContentStr;
    
    
	private String	dimension	;//	维度	String	1	Y
	private String	organization	;//	组织	String	1	Y
	private String[]	organizationAngle	;//	选择组织维度	String[]	1024	Y
	private String	startDate	;//	起始时间	String	20	Y
	private String	endDate	;//	截止时间	String	20	Y
    
    
    
    public String getDimension() {
		return dimension;
	}


	public void setDimension(String dimension) {
		this.dimension = dimension;
	}


	public String getOrganization() {
		return organization;
	}


	public void setOrganization(String organization) {
		this.organization = organization;
	}


	public String[] getOrganizationAngle() {
		return organizationAngle;
	}


	public void setOrganizationAngle(String[] organizationAngle) {
		this.organizationAngle = organizationAngle;
	}


	public String getStartDate() {
		return startDate;
	}


	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}


	public String getEndDate() {
		return endDate;
	}


	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}





	public String getOrganizationContentStr() {
		return organizationContentStr;
	}


	public void setOrganizationContentStr(String organizationContentStr) {
		this.organizationContentStr = organizationContentStr;
	}


	public String getPostTem() {
		return postTem;
	}


	public void setPostTem(String postTem) {
		this.postTem = postTem;
	}


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
