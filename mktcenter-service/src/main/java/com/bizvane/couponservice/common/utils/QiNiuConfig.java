package com.bizvane.couponservice.common.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * 
 * @author 董争光 2018年7月30日下午3:40:54
 */
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

  public void setAccessKey(String accessKey) {
    this.accessKey = accessKey;
  }

  public String getSecretKey() {
    return this.secretKey;
  }

  public void setSecretKey(String secretKey) {
    this.secretKey = secretKey;
  }

  public String getBucketNm() {
    return this.bucketNm;
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



}
