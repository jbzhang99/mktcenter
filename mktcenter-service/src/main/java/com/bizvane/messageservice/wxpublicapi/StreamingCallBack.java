package com.bizvane.messageservice.wxpublicapi;

import org.apache.poi.ss.usermodel.Row;

public interface StreamingCallBack<T> {
	void onCompletion(T t, Row row);
}
