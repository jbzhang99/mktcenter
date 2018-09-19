package com.bizvane.mktcenterservice.models.requestvo;

import com.alibaba.fastjson.JSONObject;

import springfox.documentation.spring.web.json.Json;

public class BackData2 {
	private String time;
	private JSONObject JosonData;
	 
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public JSONObject getJosonData() {
		return JosonData;
	}

	public void setJosonData(JSONObject json) {
		JosonData = json;// TODO Auto-generated method stub
		
	}


	


}
