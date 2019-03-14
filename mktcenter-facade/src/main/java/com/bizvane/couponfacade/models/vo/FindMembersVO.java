package com.bizvane.couponfacade.models.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by yunjie.tian on 2018/7/20.
 */
public class FindMembersVO  implements Serializable {
	private static final long serialVersionUID = 1L;
	

	
	@io.swagger.annotations.ApiModelProperty(value = "", name = "批次号", required = false, example = "")
	private String batchNo;

	@io.swagger.annotations.ApiModelProperty(value = "", name = "线下店铺id", required = false, example = "")
	private String storeId;
	@io.swagger.annotations.ApiModelProperty(value = "", name = "ture是导出", required = false, example = "")
	private String export;

	
    @io.swagger.annotations.ApiModelProperty(value = "当前页数", name = "pageNumber")
    private Integer pageNumber = 1;

    @io.swagger.annotations.ApiModelProperty(value = "显示条数", name = "pageSize")
    private Integer pageSize = 20;
    
    
	@io.swagger.annotations.ApiModelProperty(value = "", name = "time", required = false, example = "")
	private Date time;
	
	@io.swagger.annotations.ApiModelProperty(value = "", name = "会员姓名", required = false, example = "")
	private String membersName;
	
	@io.swagger.annotations.ApiModelProperty(value = "", name = "昵称", required = false, example = "")
	private String nickname;

	@io.swagger.annotations.ApiModelProperty(value = "", name = "电话", required = false, example = "")
	private String cardNo;
	
	@io.swagger.annotations.ApiModelProperty(value = "", name = "会员姓名/昵称", required = false, example = "")
	private String phone;

	
	
	public String getExport() {
		return export;
	}

	public void setExport(String export) {
		this.export = export;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getMembersName() {
		return membersName;
	}

	public void setMembersName(String membersName) {
		this.membersName = membersName;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String card) {
		this.cardNo = card;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	

}
