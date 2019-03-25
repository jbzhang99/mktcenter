package com.bizvane.couponservice.common.datavo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by yunjie.tian on 2018/7/20.
 */
public class BitDataXiaLaiVO  implements Serializable {
	private static final long serialVersionUID = 1L;
	
    
	@io.swagger.annotations.ApiModelProperty(value = "code", name = "code", required = false, example = "")
	private String code;
	
	@io.swagger.annotations.ApiModelProperty(value = "name", name = "name", required = false, example = "")
	private String name;
	
	private Date validDateStart;
	
	private Date validDateEnd;
	


	public Date getValidDateStart() {
		return validDateStart;
	}

	public void setValidDateStart(Date validDateStart) {
		this.validDateStart = validDateStart;
	}

	public Date getValidDateEnd() {
		return validDateEnd;
	}

	public void setValidDateEnd(Date validDateEnd) {
		this.validDateEnd = validDateEnd;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	 

	
	
}
