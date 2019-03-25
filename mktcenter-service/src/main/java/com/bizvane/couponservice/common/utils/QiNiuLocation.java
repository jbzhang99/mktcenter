package com.bizvane.couponservice.common.utils;

/**
 * Created by Gavin on 2018/7/28.
 */
public enum QiNiuLocation {
    BIZVANE01("bizvane01","pccumfar2.bkt.clouddn.com"),
    CENTERSTAGE("bizvane01","pccumfar2.bkt.clouddn.com");

    private String bucket;
    private String domain;

    QiNiuLocation(String bucket, String domain){
        this.bucket = bucket;
        this.domain = domain;
    }

    public String getBucket() {
        return bucket;
    }

    public String getDomain() {
        return domain;
    }
}
