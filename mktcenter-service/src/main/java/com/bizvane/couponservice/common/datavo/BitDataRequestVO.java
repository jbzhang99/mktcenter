package com.bizvane.couponservice.common.datavo;

import com.bizvane.couponfacade.models.po.CouponDefinitionPO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class BitDataRequestVO  implements Serializable {
	private static final long serialVersionUID = 1L;
	
    
	@io.swagger.annotations.ApiModelProperty(value = "couponManualId", name = "couponManualId", required = false, example = "")
	private Long couponManualId;
	@io.swagger.annotations.ApiModelProperty(value = "任务名称", name = "taskName", required = false, example = "")
	private String taskName;
	@io.swagger.annotations.ApiModelProperty(value = "创建时间", name = "createDate", required = false, example = "")
	private Date createDate;
	@io.swagger.annotations.ApiModelProperty(value = "参与门店：120", name = "storesSum", required = false, example = "")
	private String storesSum;
	@io.swagger.annotations.ApiModelProperty(value = "发送的优惠券List", name = "couponDefinitionPOList", required = false, example = "") 	
	private List<CouponDefinitionPO> couponDefinitionPOList;
	
	@io.swagger.annotations.ApiModelProperty(value = "券类型下拉", name = "bitDataXiaLaiVOList", required = false, example = "") 	
	private List<BitDataXiaLaiVO> bitDataXiaLaiVOList;

	
	
	public List<BitDataXiaLaiVO> getBitDataXiaLaiVOList() {
		return bitDataXiaLaiVOList;
	}


	public void setBitDataXiaLaiVOList(List<BitDataXiaLaiVO> bitDataXiaLaiVOList) {
		this.bitDataXiaLaiVOList = bitDataXiaLaiVOList;
	}


	public List<CouponDefinitionPO> getCouponDefinitionPOList() {
		return couponDefinitionPOList;
	}


	public void setCouponDefinitionPOList(List<CouponDefinitionPO> couponDefinitionPOList) {
		this.couponDefinitionPOList = couponDefinitionPOList;
	}


	public String getTaskName() {
		return taskName;
	}


	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}


	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public String getStoresSum() {
		return storesSum;
	}


	public void setStoresSum(String storesSum) {
		this.storesSum = storesSum;
	}


	public Long getCouponManualId() {
		return couponManualId;
	}


	public void setCouponManualId(Long couponManualId) {
		this.couponManualId = couponManualId;
	}
    
	

	
	
}
