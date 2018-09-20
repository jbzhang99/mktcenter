package com.bizvane.mktcenterservice.models.requestvo.postvo;

import com.bizvane.mktcenterservice.models.requestvo.ReBase;

public class IncomeTotalListGroup  extends ReBase  {
	private String	organization	;//	组织	String	1	Y
	private String	organizationContent	;//	组织内容	String[]	1024	N
	private String	startDate	;//	起始时间	String	20	Y
	private String	endDate	;//	截止时间	String	20	Y
	private String	particleSize	;//	报表粒度	String	1	Y
	
	private int	startRecord	;//	起始条目（分页）	String	8	Y
	private int	queryNum	;//	查询数量（分页）	String	8	Y
	
	private String activeCycle ;//活跃会员周期	String
	private String newVipCycle ;//	String
	
	

	public String getActiveCycle() {
		return activeCycle;
	}
	public void setActiveCycle(String activeCycle) {
		this.activeCycle = activeCycle;
	}
	public String getNewVipCycle() {
		return newVipCycle;
	}
	public void setNewVipCycle(String newVipCycle) {
		this.newVipCycle = newVipCycle;
	}
	public int getStartRecord() {
		return startRecord;
	}
	public void setStartRecord(int startRecord) {
		this.startRecord = startRecord;
	}
	public int getQueryNum() {
		return queryNum;
	}
	public void setQueryNum(int queryNum) {
		this.queryNum = queryNum;
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
