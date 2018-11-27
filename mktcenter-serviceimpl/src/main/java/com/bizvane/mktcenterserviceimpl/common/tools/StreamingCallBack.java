package com.bizvane.mktcenterserviceimpl.common.tools;

import org.apache.poi.ss.usermodel.Row;

public interface StreamingCallBack<T> {
	void onCompletion(T t, Row row);
}
