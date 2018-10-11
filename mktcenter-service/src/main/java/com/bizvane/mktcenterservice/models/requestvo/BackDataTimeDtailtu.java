package com.bizvane.mktcenterservice.models.requestvo;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

public class BackDataTimeDtailtu {
	private String vipData;
	private String inactivityVipData;
	private String activityVipData;
	private String oldVipData;
	private String newVipData;



	private String  inactivityVipDataAccountedfor;
	private String 	activityVipDataAccountedfor;
	private String 	oldVipDataAccountedfor;
	private String 	newVipDataAccountedfor;
	
	private List<JSONObject>  josonData;
	

	public List<JSONObject> getJosonData() {
		return josonData;
	}
	public void setJosonData(List<JSONObject> josonData) {
		this.josonData = josonData;
	}
	public String getVipData() {
		return vipData;
	}
	public void setVipData(String vipData) {
		this.vipData = vipData;
	}
	public String getInactivityVipData() {
		return inactivityVipData;
	}
	public void setInactivityVipData(String inactivityVipData) {
		this.inactivityVipData = inactivityVipData;
	}
	public String getActivityVipData() {
		return activityVipData;
	}
	public void setActivityVipData(String activityVipData) {
		this.activityVipData = activityVipData;
	}
	public String getOldVipData() {
		return oldVipData;
	}
	public void setOldVipData(String oldVipData) {
		this.oldVipData = oldVipData;
	}
	public String getNewVipData() {
		return newVipData;
	}
	public void setNewVipData(String newVipData) {
		this.newVipData = newVipData;
	}
	public String getInactivityVipDataAccountedfor() {
		return inactivityVipDataAccountedfor;
	}
	public void setInactivityVipDataAccountedfor(String inactivityVipDataAccountedfor) {
		this.inactivityVipDataAccountedfor = inactivityVipDataAccountedfor;
	}
	public String getActivityVipDataAccountedfor() {
		return activityVipDataAccountedfor;
	}
	public void setActivityVipDataAccountedfor(String activityVipDataAccountedfor) {
		this.activityVipDataAccountedfor = activityVipDataAccountedfor;
	}
	public String getOldVipDataAccountedfor() {
		return oldVipDataAccountedfor;
	}
	public void setOldVipDataAccountedfor(String oldVipDataAccountedfor) {
		this.oldVipDataAccountedfor = oldVipDataAccountedfor;
	}
	public String getNewVipDataAccountedfor() {
		return newVipDataAccountedfor;
	}
	public void setNewVipDataAccountedfor(String newVipDataAccountedfor) {
		this.newVipDataAccountedfor = newVipDataAccountedfor;
	}

	
	
	

	


}
