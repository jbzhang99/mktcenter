package com.bizvane.couponservice.common.datavo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by yunjie.tian on 2018/7/20.
 */
public class BitDataVO  implements Serializable {
	private static final long serialVersionUID = 1L;
	
    
	@io.swagger.annotations.ApiModelProperty(value = "couponManualId", name = "couponManualId", required = false, example = "")
	private Long couponManualId;
	
	@io.swagger.annotations.ApiModelProperty(value = "", name = "批次号", required = false, example = "")
	private String batchNo;
	@io.swagger.annotations.ApiModelProperty(value = "", name = "起始时间", required = false, example = "")
	private String startDate;
	@io.swagger.annotations.ApiModelProperty(value = "", name = "截止时间", required = false, example = "")
	private String endDate;
	@io.swagger.annotations.ApiModelProperty(value = "", name = "报表粒度", required = false, example = "")
	private String particleSize;

	@io.swagger.annotations.ApiModelProperty(value = "", name = "线下店铺id", required = false, example = "")
	private String storeIds[];
	
	@io.swagger.annotations.ApiModelProperty(value = "", name = "线下店铺id ,默认1,2,3", required = false, example = "")
	private String storeIdstr;
	
	@io.swagger.annotations.ApiModelProperty(value = "", name = "起始条目（分页）", required = false, example = "")
	private String startRecord;
	@io.swagger.annotations.ApiModelProperty(value = "", name = "查询数量（分页）", required = false, example = "")
	private String queryNum;
	
	@io.swagger.annotations.ApiModelProperty(value = "", name = "群主id", required = false, example = "")
	private Map<String,List> storeIdsInArea ;
	
	@io.swagger.annotations.ApiModelProperty(value = "", name = "ture是导出", required = false, example = "")
	private String export;
	

	public String getStoreIdstr() {
		return storeIdstr;
	}


	public void setStoreIdstr(String storeIdstr) {
		this.storeIdstr = storeIdstr;
	}


	public String getExport() {
		return export;
	}


	public void setExport(String export) {
		this.export = export;
	}



	public Map<String, List> getStoreIdsInArea() {
		return storeIdsInArea;
	}


	public void setStoreIdsInArea(Map<String, List> storeIdsInArea) {
		this.storeIdsInArea = storeIdsInArea;
	}


	public String[] getStoreIds() {
		return storeIds;
	}


	public void setStoreIds(String[] storeIds) {
		this.storeIds = storeIds;
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


	public String getBatchNo() {
		return batchNo;
	}


	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}


	public Long getCouponManualId() {
		return couponManualId;
	}


	public void setCouponManualId(Long couponManualId) {
		this.couponManualId = couponManualId;
	}
    
	

	
	
}
