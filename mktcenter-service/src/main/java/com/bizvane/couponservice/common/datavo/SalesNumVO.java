package com.bizvane.couponservice.common.datavo;

import java.io.Serializable;

/**
 * Created by yunjie.tian on 2018/7/20.
 */
public class SalesNumVO  implements Serializable {
	private static final long serialVersionUID = 1L;
	
    
	
	@io.swagger.annotations.ApiModelProperty(value = "", name = "批次号", required = false, example = "")
	private String batchNo;
	@io.swagger.annotations.ApiModelProperty(value = "", name = "起始时间", required = false, example = "")
	private String startDate;
	@io.swagger.annotations.ApiModelProperty(value = "", name = "截止时间", required = false, example = "")
	private String endDate;
	
	private String brandId;
	private String yesteryearStartDate;
	private String yesteryearEndDate;
	private String lastStartDate;
	private String lastEndDate;
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
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
	public String getBrandId() {
		return brandId;
	}
	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}
	public String getYesteryearStartDate() {
		return yesteryearStartDate;
	}
	public void setYesteryearStartDate(String yesteryearStartDate) {
		this.yesteryearStartDate = yesteryearStartDate;
	}
	public String getYesteryearEndDate() {
		return yesteryearEndDate;
	}
	public void setYesteryearEndDate(String yesteryearEndDate) {
		this.yesteryearEndDate = yesteryearEndDate;
	}
	public String getLastStartDate() {
		return lastStartDate;
	}
	public void setLastStartDate(String lastStartDate) {
		this.lastStartDate = lastStartDate;
	}
	public String getLastEndDate() {
		return lastEndDate;
	}
	public void setLastEndDate(String lastEndDate) {
		this.lastEndDate = lastEndDate;
	}
	
	
	
}
