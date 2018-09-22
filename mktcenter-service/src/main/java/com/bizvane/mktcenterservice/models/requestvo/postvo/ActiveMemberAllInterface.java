package com.bizvane.mktcenterservice.models.requestvo.postvo;

import com.bizvane.mktcenterservice.models.requestvo.ReBase;

public class ActiveMemberAllInterface  extends ReBase  {
	

	private String	activeCycle	;//	活跃会员周期	String	3	Y
	private String	fuzzyQueryContent	;//	模糊查询内容	String	12	N
	private String	startRecord	;//	起始条目（分页）	String	8	Y
	private String	queryNum	;//	查询数量（分页）	String	8	Y
	
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
	public String getActiveCycle() {
		return activeCycle;
	}
	public void setActiveCycle(String activeCycle) {
		this.activeCycle = activeCycle;
	}
	public String getFuzzyQueryContent() {
		return fuzzyQueryContent;
	}
	public void setFuzzyQueryContent(String fuzzyQueryContent) {
		this.fuzzyQueryContent = fuzzyQueryContent;
	}



}
