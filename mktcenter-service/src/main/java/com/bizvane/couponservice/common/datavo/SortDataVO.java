package com.bizvane.couponservice.common.datavo;

import java.io.Serializable;
import java.math.BigDecimal;


public class SortDataVO  implements Serializable {
	private static final long serialVersionUID = 1L;
	
    

	
	private String nameKey;
	private BigDecimal bigDecimalVal;
	private Integer integerVal;
	
	
	public String getNameKey() {
		return nameKey;
	}
	public void setNameKey(String nameKey) {
		this.nameKey = nameKey;
	}
	public BigDecimal getBigDecimalVal() {
		return bigDecimalVal;
	}
	public void setBigDecimalVal(BigDecimal bigDecimalVal) {
		this.bigDecimalVal = bigDecimalVal;
	}
	public Integer getIntegerVal() {
		return integerVal;
	}
	public void setIntegerVal(Integer integerVal) {
		this.integerVal = integerVal;
	}
	
}
