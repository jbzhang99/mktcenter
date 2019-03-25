package com.bizvane.messageservice.common.sms.response;

import java.util.List;

/**
 * 
 * @author tianyh 
 * @Description:状态报告响应实体类
 */
public class SmsReportResponse {
	/**
	 * 请求状态
	 */
	private String ret;
	/**
	 * 请求错误描述
	 */
	private String error;
	/**
	 * 上行明细结果
	 */
	private List<SmsResult> result;
	
 
	
	public String getRet() {
		return ret;
	}
	
	public void setRet(String ret) {
		this.ret = ret;
	}
	
	public String getError() {
		return error;
	}
	
	public void setError(String error) {
		this.error = error;
	}
	
	public List<SmsResult> getResult() {
		return result;
	}
	
	public void setResult(List<SmsResult> result) {
		this.result = result;
	}

	
}
