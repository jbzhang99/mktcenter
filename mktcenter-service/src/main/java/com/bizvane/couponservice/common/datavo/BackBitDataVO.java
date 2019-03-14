package com.bizvane.couponservice.common.datavo;

import java.io.Serializable;

/**
 * Created by yunjie.tian on 2018/7/20.
 */
public class BackBitDataVO  implements Serializable {
	private static final long serialVersionUID = 1L;
	
    
	private Object list;
	
	private String total;

	public Object getList() {
		return list;
	}

	public void setList(Object list) {
		this.list = list;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	
}
