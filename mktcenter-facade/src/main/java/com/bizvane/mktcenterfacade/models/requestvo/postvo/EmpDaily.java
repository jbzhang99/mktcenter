package com.bizvane.mktcenterfacade.models.requestvo.postvo;

import com.bizvane.mktcenterfacade.models.requestvo.ReBase;

public class EmpDaily  extends ReBase  {
	
	
	
	   private String 	corpId;	//查询企业编号	String
	   private String 	startDate;	//起始时间	String
	   private String 	endDate;//	截止时间	String
	   private String 	storeId;	//店铺Id	String
	   private String 	empId;	//导购Id	String
	   
	   
	public String getCorpId() {
		return corpId;
	}
	public void setCorpId(String corpId) {
		this.corpId = corpId;
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
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}

	
	
	
}
