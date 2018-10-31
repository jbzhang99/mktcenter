package com.bizvane.mktcenterserviceimpl.common.config;


import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author xiao.shu
 * @date on 2018/8/2 15:53
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@Component
public class QRCodeConfig {

    @Value("${activity.qrcodeurl}")
    private String qrcodeurl;

    public String getQrcodeurl() {
        return qrcodeurl;
    }

    public void setQrcodeurl(String qrcodeurl) {
        this.qrcodeurl = qrcodeurl;
    }
}
