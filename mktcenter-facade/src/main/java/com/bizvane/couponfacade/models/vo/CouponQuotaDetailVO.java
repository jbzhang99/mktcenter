package com.bizvane.couponfacade.models.vo;

import com.bizvane.couponfacade.models.po.CouponQuotaDetailPO;

/**
 * Created by yunjie.tian on 2018/7/20.
 */
public class CouponQuotaDetailVO extends CouponQuotaDetailPO{
	private static final long serialVersionUID = 1L;
	

    
    @io.swagger.annotations.ApiModelProperty(value = "高级查询", name = "baseSearchValue", required = false,example = "")
    private String baseSearchValue;
    
    @io.swagger.annotations.ApiModelProperty(value = "当前页数", name = "pageNumber")
    private Integer pageNumber = 1;

    @io.swagger.annotations.ApiModelProperty(value = "显示条数", name = "pageSize")
    private Integer pageSize = 20;
    
	@io.swagger.annotations.ApiModelProperty(value = "品牌id", name = "sysBrandId", required = false, example = "")
	private Long sysBrandId;
    
	

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

	public Long getSysBrandId() {
		return sysBrandId;
	}

	public void setSysBrandId(Long sysBrandId) {
		this.sysBrandId = sysBrandId;
	}

	public String getBaseSearchValue() {
		return baseSearchValue;
	}

	public void setBaseSearchValue(String baseSearchValue) {
		this.baseSearchValue = baseSearchValue;
	}


	
	
	
}
