package com.bizvane.mktcenterserviceimpl.common.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class QiNiuConfig {
	@Value("${qiniu.accessKey}")
	private String accessKey;

	@Value("${qiniu.secretKey}")
	private String secretKey;

	@Value("${qiniu.bucketNm}")
	private String bucketNm;

	@Value("${qiniu.domain}")
	private String domain;

	public String getAccessKey() {
		return this.accessKey;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public String getBucketNm() {
		return bucketNm;
	}

	public void setBucketNm(String bucketNm) {
		this.bucketNm = bucketNm;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

}
