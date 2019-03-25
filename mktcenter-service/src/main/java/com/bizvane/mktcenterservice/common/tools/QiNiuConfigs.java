package com.bizvane.mktcenterservice.common.tools;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Gavin on 2018/9/22.
 */
@Component
public class QiNiuConfigs {


    @Value("${qiniu.domain}")
    private String doMain;

    @Value("${qiniu.bucketNm}")
    private String bucket;

    public String getDoMain() {
        return doMain;
    }

    public void setDoMain(String doMain) {
        this.doMain = doMain;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }
}
