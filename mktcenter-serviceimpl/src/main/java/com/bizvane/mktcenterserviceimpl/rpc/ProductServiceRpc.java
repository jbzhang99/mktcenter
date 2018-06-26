package com.bizvane.centercontrolserviceimpl.rpc;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author chen.li
 * @date on 2018/6/26 10:28
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@FeignClient(name = "centerstage-serviceimpl")
public interface ProductServiceRpc {

    @RequestMapping("getdatetime")
    public String getdatetime();
}
