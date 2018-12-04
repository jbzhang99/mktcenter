package com.bizvane.mktcenterservice.models.requestvo;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

public class EmpDailyback {
	
	private String	time;//时间
	private String	storeAchievements;//	店铺业绩	String   如：12.53
	private String	storePercentage;//	店铺业绩上涨比例	String   如：15%
	private String	empRank;//	导购排名	String   如：12
	private String	empPercentage;//	导购业绩上涨比例	String   如：-10%
	private String	empAchievements;//	导购业绩	String   如：12.53
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getStoreAchievements() {
		return storeAchievements;
	}
	public void setStoreAchievements(String storeAchievements) {
		this.storeAchievements = storeAchievements;
	}
	public String getStorePercentage() {
		return storePercentage;
	}
	public void setStorePercentage(String storePercentage) {
		this.storePercentage = storePercentage;
	}
	public String getEmpRank() {
		return empRank;
	}
	public void setEmpRank(String empRank) {
		this.empRank = empRank;
	}
	public String getEmpPercentage() {
		return empPercentage;
	}
	public void setEmpPercentage(String empPercentage) {
		this.empPercentage = empPercentage;
	}
	public String getEmpAchievements() {
		return empAchievements;
	}
	public void setEmpAchievements(String empAchievements) {
		this.empAchievements = empAchievements;
	}
	

	
}
