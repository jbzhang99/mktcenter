package com.bizvane.mktcenterservice.models.requestvo;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

public class BackDataTimeDtail {
	private String 	total;
	private String vipData;
	private String touristsData;
	private String 	onlineData;
	private String 	offlineData;
	
	private String vipDataAccountedfor;
	private String touristsDataAccountedfor;
	private String 	onlineDataAccountedfor;
	private String 	offlineDataAccountedfor;
	
	private List<JSONObject>  josonData;
	

	public List<JSONObject> getJosonData() {
		return josonData;
	}
	public void setJosonData(List<JSONObject> josonData) {
		this.josonData = josonData;
	}
	
	
	public String getVipDataAccountedfor() {
		return vipDataAccountedfor;
	}
	public void setVipDataAccountedfor(String vipDataAccountedfor) {
		this.vipDataAccountedfor = vipDataAccountedfor;
	}
	public String getTouristsDataAccountedfor() {
		return touristsDataAccountedfor;
	}
	public void setTouristsDataAccountedfor(String touristsDataAccountedfor) {
		this.touristsDataAccountedfor = touristsDataAccountedfor;
	}
	public String getOnlineDataAccountedfor() {
		return onlineDataAccountedfor;
	}
	public void setOnlineDataAccountedfor(String onlineDataAccountedfor) {
		this.onlineDataAccountedfor = onlineDataAccountedfor;
	}
	public String getOfflineDataAccountedfor() {
		return offlineDataAccountedfor;
	}
	public void setOfflineDataAccountedfor(String offlineDataAccountedfor) {
		this.offlineDataAccountedfor = offlineDataAccountedfor;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getVipData() {
		return vipData;
	}
	public void setVipData(String vipData) {
		this.vipData = vipData;
	}
	public String getTouristsData() {
		return touristsData;
	}
	public void setTouristsData(String touristsData) {
		this.touristsData = touristsData;
	}
	public String getOnlineData() {
		return onlineData;
	}
	public void setOnlineData(String onlineData) {
		this.onlineData = onlineData;
	}
	public String getOfflineData() {
		return offlineData;
	}
	public void setOfflineData(String offlineData) {
		this.offlineData = offlineData;
	}

	


}
