package com.bizvane.mktcenterfacade.models.requestvo.postvo;

import com.bizvane.mktcenterfacade.models.requestvo.ReBase;

public class VipIncomeAnalysis extends ReBase  {
	
	
	  private String  	indicators	;//	指标	String	1	Y
	  private String  	organization	;//	组织	String	1	Y
	  private String 	organizationContent	;//	组织内容	String[]	1024	N
	  private String  	startDate	;//	起始时间	String	20	Y
	  private String  	endDate	;//	截止时间	String	20	Y
	  private String  	particleSize	;//	报表粒度	String	1	Y
	  
	  
	public String getIndicators() {
		return indicators;
	}
	public void setIndicators(String indicators) {
		this.indicators = indicators;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}


	public String getOrganizationContent() {
		return organizationContent;
	}
	public void setOrganizationContent(String organizationContent) {
		this.organizationContent = organizationContent;
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
	public String getParticleSize() {
		return particleSize;
	}
	public void setParticleSize(String particleSize) {
		this.particleSize = particleSize;
	}

	  
	  
	  
}
