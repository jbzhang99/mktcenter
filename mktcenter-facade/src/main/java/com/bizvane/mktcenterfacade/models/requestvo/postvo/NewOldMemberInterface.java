package com.bizvane.mktcenterfacade.models.requestvo.postvo;

import com.bizvane.mktcenterfacade.models.requestvo.ReBase;

public class NewOldMemberInterface  extends ReBase  {
	
	private String	dimension	;//	维度	String	1	Y
	private String	organization	;//	组织	String	1	Y
	private String[]	organizationAngle	;//	选择组织维度	String[]	1024	Y
	private String	startDate	;//	起始时间	String	20	Y
	private String	endDate	;//	截止时间	String	20	Y
	private String	startRecord	;//	起始条目（分页）	String	8	Y
	private String	queryNum	;//	查询数量（分页）	String	8	Y
	private String	newVipCycle	;//	新会员周期	String	3	Y
	private String	vipType	;//	会员类型	String	1	Y
	private String	fuzzyQueryContent	;//	模糊查询内容	String	12	N
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
	public String getStartRecord() {
		return startRecord;
	}
	public void setStartRecord(String startRecord) {
		this.startRecord = startRecord;
	}
	public String getQueryNum() {
		return queryNum;
	}
	public void setQueryNum(String queryNum) {
		this.queryNum = queryNum;
	}
	public String getNewVipCycle() {
		return newVipCycle;
	}
	public void setNewVipCycle(String newVipCycle) {
		this.newVipCycle = newVipCycle;
	}
	public String getVipType() {
		return vipType;
	}
	public void setVipType(String vipType) {
		this.vipType = vipType;
	}
	public String getFuzzyQueryContent() {
		return fuzzyQueryContent;
	}
	public void setFuzzyQueryContent(String fuzzyQueryContent) {
		this.fuzzyQueryContent = fuzzyQueryContent;
	}

  
}
