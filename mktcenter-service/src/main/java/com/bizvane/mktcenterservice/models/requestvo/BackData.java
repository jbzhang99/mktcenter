package com.bizvane.mktcenterservice.models.requestvo;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

public class BackData {
	private List<BackDataBiaotou>  header ;
	private JSONObject JosonData;
	

	public List<BackDataBiaotou> getHeader() {
		return header;
	}

	public void setHeader(List<BackDataBiaotou> header) {
		this.header = header;
	}

	public JSONObject getJosonData() {
		return JosonData;
	}

	public void setJosonData(JSONObject json) {
		JosonData = json;// TODO Auto-generated method stub
		
	}


	


}
