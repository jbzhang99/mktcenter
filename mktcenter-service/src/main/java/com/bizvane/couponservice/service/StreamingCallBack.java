package com.bizvane.couponservice.service;

import org.apache.poi.ss.usermodel.Row;

public interface StreamingCallBack<T> {
	void onCompletion(T t, Row row);
}
