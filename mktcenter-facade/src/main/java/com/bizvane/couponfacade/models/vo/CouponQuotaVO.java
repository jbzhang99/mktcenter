package com.bizvane.couponfacade.models.vo;

import com.bizvane.centerstageservice.models.po.SysStaffPo;
import com.bizvane.couponfacade.models.po.CouponQuotaPO;

import java.util.List;


public class CouponQuotaVO extends CouponQuotaPO{
	private static final long serialVersionUID = 1L;
	
	private List<SysStaffPo> staffCodeList; //分配员工Code
	
	private List<String> staffNameList; //分配员工Name
	
	@io.swagger.annotations.ApiModelProperty(value = "开始时间-开始", name = "startDateEnd", required = false, example = "")
	private String startDateStart;
	@io.swagger.annotations.ApiModelProperty(value = "开始时间-截止", name = "startDateEnd", required = false, example = "")
	private String startDateEnd;

	@io.swagger.annotations.ApiModelProperty(value = "截止时间-开始", name = "endDateStart", required = false, example = "")
	private String endDateStart;
	@io.swagger.annotations.ApiModelProperty(value = "截止时间-截止", name = "endDateStart", required = false, example = "")
	private String endDateEnd;

    @io.swagger.annotations.ApiModelProperty(value = "创建时间-开始", name = "createDtStart", required = false,example = "")
    private String createDateStart;
    @io.swagger.annotations.ApiModelProperty(value = "创建时间-截止", name = "createDtEnd", required = false,example = "")
    private String createDateEnd;


    @io.swagger.annotations.ApiModelProperty(value = "当前页数", name = "pageNumber")
    private Integer pageNumber = 1;

    @io.swagger.annotations.ApiModelProperty(value = "显示条数", name = "pageSize")
    private Integer pageSize = 10;
    
    @io.swagger.annotations.ApiModelProperty(value = "高级查询", name = "baseSearchValue", required = false,example = "")
    private String baseSearchValue;
    

	public List<String> getStaffNameList() {
		return staffNameList;
	}

	public void setStaffNameList(List<String> staffNameList) {
		this.staffNameList = staffNameList;
	}



	public List<SysStaffPo> getStaffCodeList() {
		return staffCodeList;
	}

	public void setStaffCodeList(List<SysStaffPo> staffCodeList) {
		this.staffCodeList = staffCodeList;
	}

	public String getStartDateStart() {
		return startDateStart;
	}

	public void setStartDateStart(String startDateStart) {
		this.startDateStart = startDateStart;
	}

	public String getStartDateEnd() {
		return startDateEnd;
	}

	public void setStartDateEnd(String startDateEnd) {
		this.startDateEnd = startDateEnd;
	}

	public String getEndDateStart() {
		return endDateStart;
	}

	public void setEndDateStart(String endDateStart) {
		this.endDateStart = endDateStart;
	}

	public String getEndDateEnd() {
		return endDateEnd;
	}

	public void setEndDateEnd(String endDateEnd) {
		this.endDateEnd = endDateEnd;
	}

	public String getCreateDateStart() {
		return createDateStart;
	}

	public void setCreateDateStart(String createDateStart) {
		this.createDateStart = createDateStart;
	}

	public String getCreateDateEnd() {
		return createDateEnd;
	}

	public void setCreateDateEnd(String createDateEnd) {
		this.createDateEnd = createDateEnd;
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

	public String getBaseSearchValue() {
		return baseSearchValue;
	}

	public void setBaseSearchValue(String baseSearchValue) {
		this.baseSearchValue = baseSearchValue;
	}


	
	
	
}
